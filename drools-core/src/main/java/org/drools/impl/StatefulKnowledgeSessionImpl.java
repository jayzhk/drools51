/**
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.drools.FactException;
import org.drools.KnowledgeBase;
import org.drools.RuleBase;
import org.drools.WorkingMemory;
import org.drools.command.Command;
import org.drools.command.Context;
import org.drools.command.impl.ContextImpl;
import org.drools.command.impl.GenericCommand;
import org.drools.command.impl.KnowledgeCommandContext;
import org.drools.command.runtime.BatchExecutionCommandImpl;
import org.drools.common.AbstractWorkingMemory;
import org.drools.common.InternalAgenda;
import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.common.InternalWorkingMemoryEntryPoint;
import org.drools.common.ObjectStore;
import org.drools.common.ObjectTypeConfigurationRegistry;
import org.drools.event.ActivationCancelledEvent;
import org.drools.event.ActivationCreatedEvent;
import org.drools.event.AfterActivationFiredEvent;
import org.drools.event.AgendaGroupPoppedEvent;
import org.drools.event.AgendaGroupPushedEvent;
import org.drools.event.BeforeActivationFiredEvent;
import org.drools.event.ObjectInsertedEvent;
import org.drools.event.ObjectRetractedEvent;
import org.drools.event.ObjectUpdatedEvent;
import org.drools.event.RuleFlowCompletedEvent;
import org.drools.event.RuleFlowGroupActivatedEvent;
import org.drools.event.RuleFlowGroupDeactivatedEvent;
import org.drools.event.RuleFlowNodeTriggeredEvent;
import org.drools.event.RuleFlowStartedEvent;
import org.drools.event.process.ProcessEventListener;
import org.drools.event.process.impl.ProcessCompletedEventImpl;
import org.drools.event.process.impl.ProcessNodeLeftEventImpl;
import org.drools.event.process.impl.ProcessNodeTriggeredEventImpl;
import org.drools.event.process.impl.ProcessStartedEventImpl;
import org.drools.event.rule.AgendaEventListener;
import org.drools.event.rule.WorkingMemoryEventListener;
import org.drools.event.rule.impl.ActivationCancelledEventImpl;
import org.drools.event.rule.impl.ActivationCreatedEventImpl;
import org.drools.event.rule.impl.AfterActivationFiredEventImpl;
import org.drools.event.rule.impl.AgendaGroupPoppedEventImpl;
import org.drools.event.rule.impl.AgendaGroupPushedEventImpl;
import org.drools.event.rule.impl.BeforeActivationFiredEventImpl;
import org.drools.event.rule.impl.ObjectInsertedEventImpl;
import org.drools.event.rule.impl.ObjectRetractedEventImpl;
import org.drools.event.rule.impl.ObjectUpdatedEventImpl;
import org.drools.reteoo.ReteooWorkingMemory;
import org.drools.rule.EntryPoint;
import org.drools.rule.Rule;
import org.drools.runtime.Calendars;
import org.drools.runtime.Channel;
import org.drools.runtime.Environment;
import org.drools.runtime.ExecutionResults;
import org.drools.runtime.ExitPoint;
import org.drools.runtime.Globals;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.impl.ExecutionResultImpl;
import org.drools.runtime.process.ProcessInstance;
import org.drools.runtime.process.WorkItemManager;
import org.drools.runtime.rule.Agenda;
import org.drools.runtime.rule.AgendaFilter;
import org.drools.runtime.rule.FactHandle;
import org.drools.runtime.rule.LiveQuery;
import org.drools.runtime.rule.QueryResults;
import org.drools.runtime.rule.ViewChangedEventListener;
import org.drools.runtime.rule.WorkingMemoryEntryPoint;
import org.drools.runtime.rule.impl.AgendaImpl;
import org.drools.runtime.rule.impl.NativeQueryResults;
import org.drools.spi.Activation;
import org.drools.time.SessionClock;

public class StatefulKnowledgeSessionImpl
    implements
    StatefulKnowledgeSession,
    InternalWorkingMemoryEntryPoint {
    public ReteooWorkingMemory session;
    public KnowledgeBaseImpl   kbase;

    public StatefulKnowledgeSessionImpl(ReteooWorkingMemory session) {
        this( session,
              new KnowledgeBaseImpl( session.getRuleBase() ) );
    }

    public StatefulKnowledgeSessionImpl(ReteooWorkingMemory session,
                                        KnowledgeBase kbase) {
        this.session = session;
        this.session.setKnowledgeRuntime( this );
        this.kbase = (KnowledgeBaseImpl) kbase;
    }

    public int getId() {
        return this.session.getId();
    }

    public WorkingMemoryEntryPoint getWorkingMemoryEntryPoint(String name) {
        return session.getWorkingMemoryEntryPoint( name );
    }

    public Collection< ? extends org.drools.runtime.rule.WorkingMemoryEntryPoint> getWorkingMemoryEntryPoints() {
        return session.getWorkingMemoryEntryPoints();
    }

    public void addEventListener(WorkingMemoryEventListener listener) {
        WorkingMemoryEventListenerWrapper wrapper = new WorkingMemoryEventListenerWrapper( listener );
        this.session.addEventListener( wrapper );
    }

    public void removeEventListener(WorkingMemoryEventListener listener) {
        WorkingMemoryEventListenerWrapper wrapper = null;
        if ( listener != null && !(listener instanceof WorkingMemoryEventListenerWrapper) ) {
            wrapper = new WorkingMemoryEventListenerWrapper( listener );
        } else {
            wrapper = (WorkingMemoryEventListenerWrapper) listener;
        }
        this.session.removeEventListener( wrapper );
    }

    public Collection<WorkingMemoryEventListener> getWorkingMemoryEventListeners() {
        List<WorkingMemoryEventListener> listeners = new ArrayList<WorkingMemoryEventListener>();
        for ( WorkingMemoryEventListener listener : ((List<WorkingMemoryEventListener>) this.session.getWorkingMemoryEventListeners()) ) {
            if ( listener instanceof WorkingMemoryEventListenerWrapper ) {
                listeners.add( ((WorkingMemoryEventListenerWrapper) listener).unWrap() );
            } else {
                listeners.add( listener );
            }
        }
        return Collections.unmodifiableCollection( listeners );
    }

    public void addEventListener(AgendaEventListener listener) {
        AgendaEventListenerWrapper wrapper = new AgendaEventListenerWrapper( listener );
        this.session.addEventListener( wrapper );
    }

    public Collection<AgendaEventListener> getAgendaEventListeners() {
        List<AgendaEventListener> listeners = new ArrayList<AgendaEventListener>();
        for ( AgendaEventListener listener : ((List<AgendaEventListener>) this.session.getAgendaEventListeners()) ) {
            if ( listener instanceof AgendaEventListenerWrapper ) {
                listeners.add( ((AgendaEventListenerWrapper) listener).unWrap() );
            } else {
                listeners.add( listener );
            }
        }
        return Collections.unmodifiableCollection( listeners );
    }

    public void removeEventListener(AgendaEventListener listener) {
        AgendaEventListenerWrapper wrapper = null;
        if ( listener != null && !(listener instanceof AgendaEventListenerWrapper) ) {
            wrapper = new AgendaEventListenerWrapper( listener );
        } else {
            wrapper = (AgendaEventListenerWrapper) listener;
        }
        this.session.removeEventListener( wrapper );
    }

    public void addEventListener(ProcessEventListener listener) {
        ProcessEventListenerWrapper wrapper = new ProcessEventListenerWrapper( listener );
        this.session.addEventListener( wrapper );
    }

    public Collection<ProcessEventListener> getProcessEventListeners() {
        List<ProcessEventListener> listeners = new ArrayList<ProcessEventListener>();
        for ( ProcessEventListener listener : ((List<ProcessEventListener>) this.session.getRuleFlowEventListeners()) ) {
            if ( listener instanceof ProcessEventListenerWrapper ) {
                listeners.add( ((ProcessEventListenerWrapper) listener).unWrap() );
            } else {
                listeners.add( listener );
            }
        }
        return Collections.unmodifiableCollection( listeners );
    }

    public void removeEventListener(ProcessEventListener listener) {
        ProcessEventListenerWrapper wrapper = null;
        if ( listener != null && !(listener instanceof ProcessEventListenerWrapper) ) {
            wrapper = new ProcessEventListenerWrapper( listener );
        } else {
            wrapper = (ProcessEventListenerWrapper) listener;
        }
        this.session.removeEventListener( wrapper );
    }

    public KnowledgeBase getKnowledgeBase() {
        if ( this.kbase == null ) {
            this.kbase = new KnowledgeBaseImpl( session.getRuleBase() );
        }
        return this.kbase;
    }

    public int fireAllRules() {
        return this.session.fireAllRules();
    }

    public int fireAllRules(int max) {
        return this.session.fireAllRules( max );
    }

    public int fireAllRules(AgendaFilter agendaFilter) {
        return this.session.fireAllRules( new AgendaFilterWrapper( agendaFilter ) );
    }

    public void fireUntilHalt() {
        this.session.fireUntilHalt();
    }

    public void fireUntilHalt(AgendaFilter agendaFilter) {
        this.session.fireUntilHalt( new AgendaFilterWrapper( agendaFilter ) );
    }

    @SuppressWarnings("unchecked")
    public <T extends SessionClock> T getSessionClock() {
        return (T) this.session.getSessionClock();
    }

    public void halt() {
        this.session.halt();
    }

    public void dispose() {
        this.session.dispose();
    }

    public FactHandle insert(Object object) {
        return this.session.insert( object );
    }

    public void retract(FactHandle factHandle) {
        this.session.retract( factHandle );

    }

    public void update(FactHandle factHandle) {
        this.session.update( factHandle,
                             ((InternalFactHandle) factHandle).getObject() );
    }

    public void update(FactHandle factHandle,
                       Object object) {
        this.session.update( factHandle,
                             object );
    }

    public FactHandle getFactHandle(Object object) {
        return this.session.getFactHandle( object );
    }

    public Object getObject(FactHandle factHandle) {
        return this.session.getObject( factHandle );
    }

    public ProcessInstance getProcessInstance(long id) {
        return this.session.getProcessInstance( id );
    }

    public void abortProcessInstance(long id) {
        org.drools.process.instance.ProcessInstance processInstance = this.session.getProcessInstance( id );
        if ( processInstance == null ) {
            throw new IllegalArgumentException( "Could not find process instance for id " + id );
        }
        processInstance.setState( ProcessInstance.STATE_ABORTED );
    }

    public Collection<ProcessInstance> getProcessInstances() {
        List<ProcessInstance> result = new ArrayList<ProcessInstance>();
        result.addAll( this.session.getProcessInstances() );
        return result;
    }

    public WorkItemManager getWorkItemManager() {
        return this.session.getWorkItemManager();
    }

    public ProcessInstance startProcess(String processId) {
        return this.session.startProcess( processId );
    }

    public ProcessInstance startProcess(String processId,
                                        Map<String, Object> parameters) {
        return this.session.startProcess( processId,
                                          parameters );
    }

    public void signalEvent(String type,
                            Object event) {
        this.session.getSignalManager().signalEvent( type,
                                                     event );
    }

    public void signalEvent(String type,
                            Object event,
                            long processInstanceId) {
        this.session.getProcessInstance( processInstanceId ).signalEvent( type,
                                                                          event );
    }

    public void setGlobal(String identifier,
                          Object object) {
        this.session.setGlobal( identifier,
                                object );
    }

    public Object getGlobal(String identifier) {
        return this.session.getGlobal( identifier );
    }

    public Globals getGlobals() {
        return (Globals) this.session.getGlobalResolver();
    }

    public Calendars getCalendars() {
        return this.session.getCalendars();
    }

    public Environment getEnvironment() {
        return this.session.getEnvironment();
    }

    //    public Future<Object> asyncInsert(Object object) {
    //        return new FutureAdapter( this.session.asyncInsert( object ) );
    //    }
    //
    //    public Future<Object> asyncInsert(Object[] array) {
    //        return new FutureAdapter( this.session.asyncInsert( array ) );
    //    }
    //
    //    public Future<Object> asyncInsert(Iterable< ? > iterable) {
    //        return new FutureAdapter( this.session.asyncInsert( iterable ) );
    //    }
    //
    //    public Future< ? > asyncFireAllRules() {
    //        return new FutureAdapter( this.session.asyncFireAllRules() );
    //    }

    public <T extends org.drools.runtime.rule.FactHandle> Collection<T> getFactHandles() {
        return new ObjectStoreWrapper( session.getObjectStore(),
                                       null,
                                       ObjectStoreWrapper.FACT_HANDLE );
    }

    public <T extends org.drools.runtime.rule.FactHandle> Collection<T> getFactHandles(org.drools.runtime.ObjectFilter filter) {
        return new ObjectStoreWrapper( session.getObjectStore(),
                                       filter,
                                       ObjectStoreWrapper.FACT_HANDLE );
    }

    public Collection<Object> getObjects() {
        return new ObjectStoreWrapper( session.getObjectStore(),
                                       null,
                                       ObjectStoreWrapper.OBJECT );
    }

    public Collection<Object> getObjects(org.drools.runtime.ObjectFilter filter) {
        return new ObjectStoreWrapper( session.getObjectStore(),
                                       filter,
                                       ObjectStoreWrapper.OBJECT );
    }

    public void retract(org.drools.FactHandle factHandle,
                        boolean removeLogical,
                        boolean updateEqualsMap,
                        Rule rule,
                        Activation activation) throws FactException {
        ((AbstractWorkingMemory) this.session).retract( factHandle,
                                                        removeLogical,
                                                        updateEqualsMap,
                                                        rule,
                                                        activation );
    }

    public void update(FactHandle factHandle,
                       Object object,
                       Rule rule,
                       Activation activation) throws FactException {
        ((AbstractWorkingMemory) this.session).update( (org.drools.FactHandle) factHandle,
                                                       object,
                                                       rule,
                                                       activation );
    }

    public EntryPoint getEntryPoint() {
        return session.getEntryPoint();
    }

    public InternalWorkingMemory getInternalWorkingMemory() {
        return session;
    }

    public org.drools.FactHandle getFactHandleByIdentity(Object object) {
        return session.getFactHandleByIdentity( object );
    }

    public static abstract class AbstractImmutableCollection
        implements
        Collection {

        public boolean add(Object o) {
            throw new UnsupportedOperationException( "This is an immmutable Collection" );
        }

        public boolean addAll(Collection c) {
            throw new UnsupportedOperationException( "This is an immmutable Collection" );
        }

        public void clear() {
            throw new UnsupportedOperationException( "This is an immmutable Collection" );
        }

        public boolean remove(Object o) {
            throw new UnsupportedOperationException( "This is an immmutable Collection" );
        }

        public boolean removeAll(Collection c) {
            throw new UnsupportedOperationException( "This is an immmutable Collection" );
        }

        public boolean retainAll(Collection c) {
            throw new UnsupportedOperationException( "This is an immmutable Collection" );
        }
    }

    public static class ObjectStoreWrapper extends AbstractImmutableCollection {
        public ObjectStore                     store;
        public org.drools.runtime.ObjectFilter filter;
        public int                             type;           // 0 == object, 1 == facthandle
        public static final int                OBJECT      = 0;
        public static final int                FACT_HANDLE = 1;

        public ObjectStoreWrapper(ObjectStore store,
                                  org.drools.runtime.ObjectFilter filter,
                                  int type) {
            this.store = store;
            this.filter = filter;
            this.type = type;
        }

        public boolean contains(Object object) {
            if ( object instanceof FactHandle ) {
                return this.store.getObjectForHandle( (InternalFactHandle) object ) != null;
            } else {
                return this.store.getHandleForObject( object ) != null;
            }
        }

        public boolean containsAll(Collection c) {
            for ( Object object : c ) {
                if ( !contains( object ) ) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            if ( this.filter == null ) {
                return this.store.isEmpty();
            }

            return size() == 0;
        }

        public int size() {
            if ( this.filter == null ) {
                return this.store.size();
            }

            int i = 0;
            for ( Iterator it = iterator(); it.hasNext(); ) {
                it.next();
                i++;
            }

            return i;
        }

        public Iterator< ? > iterator() {
            Iterator it = null;
            if ( type == OBJECT ) {
                if ( filter != null ) {
                    it = store.iterateObjects( filter );
                } else {
                    it = store.iterateObjects();
                }
            } else {
                if ( filter != null ) {
                    it = store.iterateFactHandles( filter );
                } else {
                    it = store.iterateFactHandles();
                }
            }
            return it;
        }

        public Object[] toArray() {
            return toArray( new Object[size()] );
        }

        public Object[] toArray(Object[] array) {
            if ( array == null || array.length != size() ) {
                array = new Object[size()];
            }

            int i = 0;
            for ( Iterator it = iterator(); it.hasNext(); ) {
                array[i++] = it.next();
            }

            return array;
        }
    }

    public static class WorkingMemoryEventListenerWrapper
        implements
        org.drools.event.WorkingMemoryEventListener {
        private final WorkingMemoryEventListener listener;

        public WorkingMemoryEventListenerWrapper(WorkingMemoryEventListener listener) {
            this.listener = listener;
        }

        public void objectInserted(ObjectInsertedEvent event) {
            listener.objectInserted( new ObjectInsertedEventImpl( event ) );
        }

        public void objectRetracted(ObjectRetractedEvent event) {
            listener.objectRetracted( new ObjectRetractedEventImpl( event ) );
        }

        public void objectUpdated(ObjectUpdatedEvent event) {
            listener.objectUpdated( new ObjectUpdatedEventImpl( event ) );
        }

        public WorkingMemoryEventListener unWrap() {
            return listener;
        }

        /**
         * Since this is a class adapter for API compatibility, the 
         * equals() and hashCode() methods simply delegate the calls 
         * to the wrapped instance. That is implemented this way
         * in order for them to be able to match corresponding instances
         * in internal hash-based maps and sets.  
         */
        @Override
        public int hashCode() {
            return listener != null ? listener.hashCode() : 0;
        }

        /**
         * Since this is a class adapter for API compatibility, the 
         * equals() and hashCode() methods simply delegate the calls 
         * to the wrapped instance. That is implemented this way
         * in order for them to be able to match corresponding instances
         * in internal hash-based maps and sets.  
         */
        @Override
        public boolean equals(Object obj) {
            if ( listener == null || obj == null ) {
                return obj == listener;
            }
            if ( obj instanceof WorkingMemoryEventListenerWrapper ) {
                return this.listener.equals( ((WorkingMemoryEventListenerWrapper) obj).unWrap() );
            }
            return this.listener.equals( obj );
        }
    }

    public static class AgendaEventListenerWrapper
        implements
        org.drools.event.AgendaEventListener {
        private final AgendaEventListener listener;

        public AgendaEventListenerWrapper(AgendaEventListener listener) {
            this.listener = listener;
        }

        public void activationCancelled(ActivationCancelledEvent event,
                                        WorkingMemory workingMemory) {

            listener.activationCancelled( new ActivationCancelledEventImpl( event.getActivation(),
                                                                            ((InternalWorkingMemory) workingMemory).getKnowledgeRuntime(),
                                                                            event.getCause() ) );

        }

        public void activationCreated(ActivationCreatedEvent event,
                                      WorkingMemory workingMemory) {
            listener.activationCreated( new ActivationCreatedEventImpl( event.getActivation(),
                                                                        ((InternalWorkingMemory) workingMemory).getKnowledgeRuntime() ) );
        }

        public void beforeActivationFired(BeforeActivationFiredEvent event,
                                          WorkingMemory workingMemory) {
            listener.beforeActivationFired( new BeforeActivationFiredEventImpl( event.getActivation(),
                                                                                ((InternalWorkingMemory) workingMemory).getKnowledgeRuntime() ) );
        }

        public void afterActivationFired(AfterActivationFiredEvent event,
                                         WorkingMemory workingMemory) {
            listener.afterActivationFired( new AfterActivationFiredEventImpl( event.getActivation(),
                                                                              ((InternalWorkingMemory) workingMemory).getKnowledgeRuntime() ) );
        }

        public void agendaGroupPopped(AgendaGroupPoppedEvent event,
                                      WorkingMemory workingMemory) {
            listener.agendaGroupPopped( new AgendaGroupPoppedEventImpl( event.getAgendaGroup(),
                                                                        ((InternalWorkingMemory) workingMemory).getKnowledgeRuntime() ) );
        }

        public void agendaGroupPushed(AgendaGroupPushedEvent event,
                                      WorkingMemory workingMemory) {
            listener.agendaGroupPushed( new AgendaGroupPushedEventImpl( event.getAgendaGroup(),
                                                                        ((InternalWorkingMemory) workingMemory).getKnowledgeRuntime() ) );
        }

        public AgendaEventListener unWrap() {
            return listener;
        }

        /**
         * Since this is a class adapter for API compatibility, the 
         * equals() and hashCode() methods simply delegate the calls 
         * to the wrapped instance. That is implemented this way
         * in order for them to be able to match corresponding instances
         * in internal hash-based maps and sets.  
         */
        @Override
        public int hashCode() {
            return listener != null ? listener.hashCode() : 0;
        }

        /**
         * Since this is a class adapter for API compatibility, the 
         * equals() and hashCode() methods simply delegate the calls 
         * to the wrapped instance. That is implemented this way
         * in order for them to be able to match corresponding instances
         * in internal hash-based maps and sets.  
         */
        @Override
        public boolean equals(Object obj) {
            if ( listener == null || obj == null ) {
                return obj == listener;
            }
            if ( obj instanceof AgendaEventListenerWrapper ) {
                return this.listener.equals( ((AgendaEventListenerWrapper) obj).unWrap() );
            }
            return this.listener.equals( obj );
        }
    }

    public static class ProcessEventListenerWrapper
        implements
        org.drools.event.RuleFlowEventListener {
        private final ProcessEventListener listener;

        public ProcessEventListenerWrapper(ProcessEventListener listener) {
            this.listener = listener;
        }

        public void beforeRuleFlowCompleted(RuleFlowCompletedEvent event,
                                            WorkingMemory workingMemory) {
            listener.beforeProcessCompleted( new ProcessCompletedEventImpl( event,
                                                                            workingMemory ) );
        }

        public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event,
                                                 WorkingMemory workingMemory) {
        }

        public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event,
                                                   WorkingMemory workingMemory) {
        }

        public void beforeRuleFlowNodeLeft(RuleFlowNodeTriggeredEvent event,
                                           WorkingMemory workingMemory) {
            listener.beforeNodeLeft( new ProcessNodeLeftEventImpl( event,
                                                                   workingMemory ) );
        }

        public void beforeRuleFlowNodeTriggered(RuleFlowNodeTriggeredEvent event,
                                                WorkingMemory workingMemory) {
            listener.beforeNodeTriggered( new ProcessNodeTriggeredEventImpl( event,
                                                                             workingMemory ) );
        }

        public void beforeRuleFlowStarted(RuleFlowStartedEvent event,
                                          WorkingMemory workingMemory) {
            listener.beforeProcessStarted( new ProcessStartedEventImpl( event,
                                                                        workingMemory ) );
        }

        public void afterRuleFlowCompleted(RuleFlowCompletedEvent event,
                                           WorkingMemory workingMemory) {
            listener.afterProcessCompleted( new ProcessCompletedEventImpl( event,
                                                                           workingMemory ) );
        }

        public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event,
                                                WorkingMemory workingMemory) {
        }

        public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event,
                                                  WorkingMemory workingMemory) {
        }

        public void afterRuleFlowNodeLeft(RuleFlowNodeTriggeredEvent event,
                                          WorkingMemory workingMemory) {
            listener.afterNodeLeft( new ProcessNodeLeftEventImpl( event,
                                                                  workingMemory ) );
        }

        public void afterRuleFlowNodeTriggered(RuleFlowNodeTriggeredEvent event,
                                               WorkingMemory workingMemory) {
            listener.afterNodeTriggered( new ProcessNodeTriggeredEventImpl( event,
                                                                            workingMemory ) );
        }

        public void afterRuleFlowStarted(RuleFlowStartedEvent event,
                                         WorkingMemory workingMemory) {
            listener.afterProcessStarted( new ProcessStartedEventImpl( event,
                                                                       workingMemory ) );
        }

        public ProcessEventListener unWrap() {
            return listener;
        }

        /**
         * Since this is a class adapter for API compatibility, the 
         * equals() and hashCode() methods simply delegate the calls 
         * to the wrapped instance. That is implemented this way
         * in order for them to be able to match corresponding instances
         * in internal hash-based maps and sets.  
         */
        @Override
        public int hashCode() {
            return listener != null ? listener.hashCode() : 0;
        }

        /**
         * Since this is a class adapter for API compatibility, the 
         * equals() and hashCode() methods simply delegate the calls 
         * to the wrapped instance. That is implemented this way
         * in order for them to be able to match corresponding instances
         * in internal hash-based maps and sets.  
         */
        @Override
        public boolean equals(Object obj) {
            if ( listener == null || obj == null ) {
                return obj == listener;
            }
            if ( obj instanceof ProcessEventListenerWrapper ) {
                return this.listener.equals( ((ProcessEventListenerWrapper) obj).unWrap() );
            }
            return this.listener.equals( obj );
        }

    }

    public static class AgendaFilterWrapper
        implements
        org.drools.spi.AgendaFilter {
        private AgendaFilter filter;

        public AgendaFilterWrapper(AgendaFilter filter) {
            this.filter = filter;
        }

        public boolean accept(Activation activation) {
            return filter.accept( activation );
        }
    }

    public Agenda getAgenda() {
        return new AgendaImpl( (InternalAgenda) this.session.getAgenda() );
    }

    /**
     * @deprecated Use {@link #registerChannel(String, Channel)} instead.
     */
    @Deprecated
    public void registerExitPoint(String name,
                                  ExitPoint exitPoint) {
        this.session.registerExitPoint( name,
                                        exitPoint );
    }

    /**
     * @deprecated Use {@link #unregisterChannel(String)} instead.
     */
    @Deprecated
    public void unregisterExitPoint(String name) {
        this.session.unregisterExitPoint( name );
    }

    public void registerChannel(String name,
                                Channel channel) {
        this.session.registerChannel( name,
                                      channel );
    }

    public void unregisterChannel(String name) {
        this.session.unregisterChannel( name );
    }

    public Map<String, Channel> getChannels() {
        return this.session.getChannels();
    }

    public ObjectTypeConfigurationRegistry getObjectTypeConfigurationRegistry() {
        return this.session.getObjectTypeConfigurationRegistry();
    }

    public RuleBase getRuleBase() {
        return this.kbase.ruleBase;
    }

    public QueryResults getQueryResults(String query) {
        return new NativeQueryResults( this.session.getQueryResults( query ) );
    }

    public QueryResults getQueryResults(String query,
                                        Object[] arguments) {
        return new NativeQueryResults( this.session.getQueryResults( query,
                                                                     arguments ) );
    }

    private KnowledgeCommandContext commandContext = new KnowledgeCommandContext( new ContextImpl( "ksession",
                                                                                                   null ),
                                                                                  null,
                                                                                  this.kbase,
                                                                                  this,
                                                                                  null );

    public <T> T execute(Command<T> command) {
        return execute( null,
                        command );
    }

    public <T> T execute(Context context,
                         Command<T> command) {
        if ( !( command instanceof BatchExecutionCommandImpl ) ) {
            return (T) ((GenericCommand) command).execute( new KnowledgeCommandContext( context,
                                                                             null,
                                                                             this.kbase,
                                                                             this,
                                                                             null ) ) ;            
        }
        
        ExecutionResultImpl results = null;
        if ( context != null ) {
            results = (ExecutionResultImpl) ((KnowledgeCommandContext) context).getExecutionResults();
        }

        if ( results == null ) {
            results = new ExecutionResultImpl();
        }

        try {
            session.startBatchExecution( results );
            ((GenericCommand) command).execute( new KnowledgeCommandContext( context,
                                                                             null,
                                                                             this.kbase,
                                                                             this,
                                                                             results ) );
            ExecutionResults result = session.getExecutionResult();
            return (T) result;
        } finally {
            session.endBatchExecution();
        }
    }

    public String getEntryPointId() {
        return this.session.getEntryPointId();
    }

    public long getFactCount() {
        return this.session.getFactCount();
    }

    public LiveQuery openLiveQuery(String query,
                                   Object[] arguments,
                                   ViewChangedEventListener listener) {
        return this.session.openLiveQuery( query,
                                           arguments,
                                           listener );
    }

}
