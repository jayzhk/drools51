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

package org.drools.command;

import org.drools.command.Command;
import org.drools.command.Context;
import org.drools.command.impl.GenericCommand;
import org.drools.command.impl.KnowledgeCommandContext;
import org.drools.common.InternalFactHandle;
import org.drools.impl.StatefulKnowledgeSessionImpl;
import org.drools.reteoo.ReteooWorkingMemory;
import org.drools.runtime.ExecutionResults;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.impl.ExecutionResultImpl;
import org.drools.runtime.rule.FactHandle;

public class ExecuteCommand
    implements
    GenericCommand<ExecutionResults> {

    private String   outIdentifier;
    private Command<ExecutionResults>  command;

    public ExecuteCommand(Command  command) {
        this.command = command;
    }
    
    public ExecuteCommand(String identifier, Command  command) {
        this.command = command;
        this.outIdentifier = identifier;
    }    

    public ExecutionResults execute(Context context) {
        StatefulKnowledgeSession ksession = ((KnowledgeCommandContext) context).getStatefulKnowledgesession();
        
        ExecutionResults kresults = ksession.execute( this.command );
        if ( this.outIdentifier != null ) {
            ((ExecutionResultImpl)((KnowledgeCommandContext) context ).getExecutionResults()).getResults().put( this.outIdentifier, kresults );
        }        
        
        return kresults;
    }

    public Command getCommand() {
        return this.command;
    }
       
    public String getOutIdentifier() {
        return this.outIdentifier;
    }

    public void setOutIdentifier(String outIdentifier) {
        this.outIdentifier = outIdentifier;
    }
    
    public String toString() {
        return "session.execute(" + this.command + ");";
    }

}
