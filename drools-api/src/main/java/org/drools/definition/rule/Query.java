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

package org.drools.definition.rule;

import java.util.Collection;
import java.util.Map;

import org.drools.definition.KnowledgeDefinition;

/**
 * Public Query interface for runtime query inspection.
 */
public interface Query
    extends
    KnowledgeDefinition {

    /**
     * Returns the package name (namespace) this query is tied to.
     *  
     * @return the package name.
     */
    String getPackageName();
    
    /**
     * Returns this query's name.
     * 
     * @return the query name
     */
    String getName();

    /**
     * Returns an immutable Map<String key, Object value> of all meta data attributes associated with 
     * this query object.
     * 
     * @return an immutable Map<String key, Object value> of meta data attributes.
     */
    Map<String, Object> getMetaData();

    /**
     * This method is deprecated. Please use {@link Query#getMetaAttributes()} instead.
     * 
     * @return a collection with all the meta attribute keys associated with this Query.
     * @deprecated
     */
    @Deprecated
    Collection<String> listMetaAttributes();
    
    /**
     * Returns an immutable Map<String key, String value> of all meta attributes associated with this query object.
     * 
     * @return an immutable Map<String key, String value> of meta attributes.
     * @deprecated
     */
    @Deprecated
    Map<String, Object> getMetaAttributes();

    /**
     * Returns the value of the meta attribute identified by the "key"
     * 
     * @param key the meta attribute key
     * 
     * @return the meta attribute value or null if there is no value for that key.
     * @deprecated
     */
    @Deprecated
    String getMetaAttribute(final String key);
}
