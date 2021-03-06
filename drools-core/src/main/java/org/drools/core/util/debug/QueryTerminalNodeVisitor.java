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

package org.drools.core.util.debug;

import java.util.LinkedList;
import java.util.Stack;

import org.drools.common.NetworkNode;
import org.drools.reteoo.QueryTerminalNode;
import org.drools.rule.Rule;

public class QueryTerminalNodeVisitor extends AbstractNetworkNodeVisitor {
    
    public static final QueryTerminalNodeVisitor INSTANCE = new QueryTerminalNodeVisitor();
    
    protected QueryTerminalNodeVisitor() {
    }

    @Override
    protected void doVisit(NetworkNode node,
                           Stack<NetworkNode> nodeStack,
                           StatefulKnowledgeSessionInfo info) {
        QueryTerminalNode rtn = (QueryTerminalNode) node;
        Rule rule = rtn.getRule();
        // first thing, associate all nodes belonging to this rule
        for( NetworkNode snode : nodeStack ) {
            info.assign( snode, rule );
        }

        // Query Terminal Nodes no longer have memory
        // TODO delete this
//        final LinkedList<?> memory = (LinkedList<?>) info.getSession().getNodeMemory( rtn );
//        final DefaultNodeInfo ni = (DefaultNodeInfo) info.getNodeInfo( node );
//        ni.setMemoryEnabled( true );
//        ni.setTupleMemorySize( memory.size() );
    }

}
