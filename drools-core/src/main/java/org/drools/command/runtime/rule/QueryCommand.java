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

package org.drools.command.runtime.rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import org.drools.command.Context;
import org.drools.command.impl.GenericCommand;
import org.drools.command.impl.KnowledgeCommandContext;
import org.drools.impl.StatefulKnowledgeSessionImpl;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.QueryResults;

@XmlAccessorType( XmlAccessType.NONE )
public class QueryCommand  implements GenericCommand<QueryResults> {

	private static final long serialVersionUID = 510l;
	
	@XmlAttribute(name = "out-identifier")
    private String outIdentifier;
    @XmlAttribute(required = true)
    private String name;
    
    @XmlElement
    private List<Object> arguments;

    public QueryCommand() {
    }
    
    public QueryCommand(String outIdentifier, String name, Object[] arguments) {
        this.outIdentifier = outIdentifier;
        this.name = name;
        this.arguments = arguments != null ? Arrays.asList( arguments ) : Arrays.asList();
    }
    
    public String getOutIdentifier() {
        return outIdentifier;
    }

    public void setOutIdentifier(String outIdentifier) {
        this.outIdentifier = outIdentifier;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Object> getArguments() {
        if (this.arguments == null) {
            this.arguments = new ArrayList<Object>();
        }
        return this.arguments;
    }
    public void setArguments(List<Object> arguments) {
        this.arguments = arguments;
    }

    public QueryResults execute(Context context) {
        StatefulKnowledgeSession ksession = ((KnowledgeCommandContext) context).getStatefulKnowledgesession();
        
        QueryResults results = null;

        //TODO {bauna} remove this try
        try {
			if ( arguments == null || arguments.size() == 0 ) {
			    results = ksession.getQueryResults( name );
			} else {
			    results = ksession.getQueryResults( name, this.arguments.toArray() );
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
        
        if ( this.outIdentifier != null ) {
            ((StatefulKnowledgeSessionImpl)ksession).session.getExecutionResult().getResults().put( this.outIdentifier, results );
        }

        return results;
    }
}
