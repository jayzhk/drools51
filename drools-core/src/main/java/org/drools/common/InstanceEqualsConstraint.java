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

package org.drools.common;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.drools.reteoo.LeftTuple;
import org.drools.rule.ContextEntry;
import org.drools.rule.Declaration;
import org.drools.rule.Pattern;
import org.drools.spi.BetaNodeFieldConstraint;

/**
 * InstanceEqualsConstraint
 *
 * Created: 21/06/2006
 * @author <a href="mailto:tirelli@post.com">Edson Tirelli</a>
 *
 * @version $Id$
 */

public class InstanceEqualsConstraint
    implements
    BetaNodeFieldConstraint {

    private static final long   serialVersionUID = 510l;

    private Declaration[] declarations     = new Declaration[0];

    private Pattern             otherPattern;

    public InstanceEqualsConstraint() {
    }

    public InstanceEqualsConstraint(final Pattern otherPattern) {
        this.otherPattern = otherPattern;
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        declarations    = (Declaration[])in.readObject();
        otherPattern    = (Pattern)in.readObject();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(declarations);
        out.writeObject(otherPattern);
    }

    public Declaration[] getRequiredDeclarations() {
        return this.declarations;
    }

    public void replaceDeclaration(Declaration oldDecl,
                                   Declaration newDecl) {
    }

    public Pattern getOtherPattern() {
        return this.otherPattern;
    }
    
    public boolean isTemporal() {
        return false;
    }

    public ContextEntry createContextEntry() {
        return new InstanceEqualsConstraintContextEntry( this.otherPattern );
    }

    public boolean isAllowedCachedLeft(final ContextEntry context,
                                       final InternalFactHandle handle) {
        return ((InstanceEqualsConstraintContextEntry) context).left == handle.getObject();
    }

    public boolean isAllowedCachedRight(final LeftTuple tuple,
                                        final ContextEntry context) {
        return tuple.get( this.otherPattern.getOffset() ).getObject() == ((InstanceEqualsConstraintContextEntry) context).right;
    }

    public String toString() {
        return "[InstanceEqualsConstraint otherPattern=" + this.otherPattern + " ]";
    }

    public int hashCode() {
        return this.otherPattern.hashCode();
    }

    public Object clone() {
        // don't clone pattern
        return new InstanceEqualsConstraint( this.otherPattern );
    }

    public boolean equals(final Object object) {
        if ( this == object ) {
            return true;
        }

        if ( object == null || !(object instanceof InstanceEqualsConstraint) ) {
            return false;
        }

        final InstanceEqualsConstraint other = (InstanceEqualsConstraint) object;
        return this.otherPattern.equals( other.otherPattern );
    }

    public static class InstanceEqualsConstraintContextEntry
        implements
        ContextEntry {

        private static final long serialVersionUID = 510l;

        public Object             left;
        public Object             right;

        private Pattern           pattern;
        private ContextEntry      entry;

        public InstanceEqualsConstraintContextEntry() {
        }
        
        public InstanceEqualsConstraintContextEntry(final Pattern pattern) {
            this.pattern = pattern;
        }

        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            left    = in.readObject();
            right   = in.readObject();
            pattern = (Pattern)in.readObject();
            entry   = (ContextEntry)in.readObject();
        }

        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(left);
            out.writeObject(right);
            out.writeObject(pattern);
            out.writeObject(entry);
        }

        public ContextEntry getNext() {
            return this.entry;
        }

        public void setNext(final ContextEntry entry) {
            this.entry = entry;
        }

        public void updateFromTuple(final InternalWorkingMemory workingMemory,
                                    final LeftTuple tuple) {
            this.left = tuple.get( this.pattern.getOffset() ).getObject();
        }

        public void updateFromFactHandle(final InternalWorkingMemory workingMemory,
                                         final InternalFactHandle handle) {
            this.right = handle.getObject();
        }

        public void resetTuple() {
            this.left = null;
        }

        public void resetFactHandle() {
            this.right = null;
        }
    }

    public ConstraintType getType() {
        return ConstraintType.BETA;
    }
}
