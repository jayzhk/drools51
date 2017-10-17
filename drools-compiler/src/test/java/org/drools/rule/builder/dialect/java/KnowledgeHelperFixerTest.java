package org.drools.rule.builder.dialect.java;

/*
 * Copyright 2005 JBoss Inc
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

import junit.framework.TestCase;

public class KnowledgeHelperFixerTest extends TestCase {

    private static final KnowledgeHelperFixer fixer = new KnowledgeHelperFixer();

    public void testAdd__Handle__Simple() {
        String result = KnowledgeHelperFixerTest.fixer.fix( "update(myObject );" );
        assertEqualsIgnoreWhitespace( "com.agfa.hap.drools.update(myObject );",
                                      result );

        result = KnowledgeHelperFixerTest.fixer.fix( "update ( myObject );" );
        assertEqualsIgnoreWhitespace( "com.agfa.hap.drools.update( myObject );",
                                      result );
    }

    public void testAdd__Handle__withNewLines() {
        final String result = KnowledgeHelperFixerTest.fixer.fix( "\n\t\n\tupdate( myObject );" );
        assertEqualsIgnoreWhitespace( "\n\t\n\tcom.agfa.hap.drools.update( myObject );",
                                      result );
    }

    public void testAdd__Handle__rComplex() {
        String result = KnowledgeHelperFixerTest.fixer.fix( "something update( myObject); other" );
        assertEqualsIgnoreWhitespace( "something com.agfa.hap.drools.update( myObject); other",
                                      result );

        result = KnowledgeHelperFixerTest.fixer.fix( "something update ( myObject );" );
        assertEqualsIgnoreWhitespace( "something com.agfa.hap.drools.update( myObject );",
                                      result );

        result = KnowledgeHelperFixerTest.fixer.fix( " update( myObject ); x" );
        assertEqualsIgnoreWhitespace( " com.agfa.hap.drools.update( myObject ); x",
                                      result );

        //should not touch, as it is not a stand alone word
        result = KnowledgeHelperFixerTest.fixer.fix( "xxupdate(myObject ) x" );
        assertEqualsIgnoreWhitespace( "xxupdate(myObject ) x",
                                      result );
    }

    public void testMultipleMatches() {
        String result = KnowledgeHelperFixerTest.fixer.fix( "update(myObject); update(myObject );" );
        assertEqualsIgnoreWhitespace( "com.agfa.hap.drools.update(myObject); com.agfa.hap.drools.update(myObject );",
                                      result );

        result = KnowledgeHelperFixerTest.fixer.fix( "xxx update(myObject ); update( myObject ); update( yourObject ); yyy" );
        assertEqualsIgnoreWhitespace( "xxx com.agfa.hap.drools.update(myObject ); com.agfa.hap.drools.update( myObject ); com.agfa.hap.drools.update( yourObject ); yyy",
                                      result );

    }

    public void testAssert1() {
        final String raw = "insert( foo );";
        final String result = "com.agfa.hap.drools.insert( foo );";
        assertEqualsIgnoreWhitespace( result,
                                      KnowledgeHelperFixerTest.fixer.fix( raw ) );
    }

    public void testAssert2() {
        final String raw = "some code; insert( new String(\"foo\") );\n More();";
        final String result = "some code; com.agfa.hap.drools.insert( new String(\"foo\") );\n More();";
        assertEqualsIgnoreWhitespace( result,
                                      KnowledgeHelperFixerTest.fixer.fix( raw ) );
    }

    public void testAssertLogical() {
        final String raw = "some code; insertLogical(new String(\"foo\"));\n More();";
        final String result = "some code; com.agfa.hap.drools.insertLogical(new String(\"foo\"));\n More();";
        assertEqualsIgnoreWhitespace( result,
                                      KnowledgeHelperFixerTest.fixer.fix( raw ) );
    }

    public void testModifyRetractModifyInsert() {
        final String raw = "some code; insert( bar ); modifyRetract( foo );\n More(); retract( bar ); modifyInsert( foo );";
        final String result = "some code; com.agfa.hap.drools.insert( bar ); com.agfa.hap.drools.modifyRetract( foo );\n More(); com.agfa.hap.drools.retract( bar ); com.agfa.hap.drools.modifyInsert( foo );";
        assertEqualsIgnoreWhitespace( result,
                                      KnowledgeHelperFixerTest.fixer.fix( raw ) );
    }

    public void testAllActionsMushedTogether() {
        String result = KnowledgeHelperFixerTest.fixer.fix( "insert(myObject ); update(ourObject);\t retract(herObject);" );
        assertEqualsIgnoreWhitespace( "com.agfa.hap.drools.insert(myObject ); com.agfa.hap.drools.update(ourObject);\t com.agfa.hap.drools.retract(herObject);",
                                      result );

        result = KnowledgeHelperFixerTest.fixer.fix( "insert( myObject ); update(ourObject);\t retract(herObject  );\ninsert(  myObject ); update(ourObject);\t retract(  herObject  );" );
        assertEqualsIgnoreWhitespace( "com.agfa.hap.drools.insert( myObject ); com.agfa.hap.drools.update(ourObject);\t com.agfa.hap.drools.retract(herObject  );\ncom.agfa.hap.drools.insert(  myObject ); com.agfa.hap.drools.update(ourObject);\t com.agfa.hap.drools.retract(  herObject  );",
                                      result );
    }

    public void testLeaveLargeAlone() {
        final String original = "yeah yeah yeah minsert( xxx ) this is a long() thing Person (name=='com.agfa.hap.drools') modify a thing";
        final String result = KnowledgeHelperFixerTest.fixer.fix( original );
        assertEqualsIgnoreWhitespace( original,
                                      result );
    }

    public void testWithNull() {
        final String original = null;
        final String result = KnowledgeHelperFixerTest.fixer.fix( original );
        assertEqualsIgnoreWhitespace( original,
                                      result );
    }

    public void testLeaveAssertAlone() {
        final String original = "com.agfa.hap.drools.insert(foo)";
        assertEqualsIgnoreWhitespace( original,
                                      KnowledgeHelperFixerTest.fixer.fix( original ) );
    }

    public void testLeaveAssertLogicalAlone() {
        final String original = "com.agfa.hap.drools.insertLogical(foo)";
        assertEqualsIgnoreWhitespace( original,
                                      KnowledgeHelperFixerTest.fixer.fix( original ) );
    }

    public void testWackyAssert() {
        final String raw = "System.out.println($person1.getName() + \" and \" + $person2.getName() +\" are sisters\");\n" + "insert($person1.getName(\"foo\") + \" and \" + $person2.getName() +\" are sisters\"); yeah();";
        final String expected = "System.out.println($person1.getName() + \" and \" + $person2.getName() +\" are sisters\");\n" + "com.agfa.hap.drools.insert($person1.getName(\"foo\") + \" and \" + $person2.getName() +\" are sisters\"); yeah();";

        assertEqualsIgnoreWhitespace( expected,
                                      KnowledgeHelperFixerTest.fixer.fix( raw ) );
    }

    public void testMoreAssertCraziness() {
        final String raw = "foobar(); (insert(new String(\"blah\").get()); bangBangYudoHono();)";
        assertEqualsIgnoreWhitespace( "foobar(); (com.agfa.hap.drools.insert(new String(\"blah\").get()); bangBangYudoHono();)",
                                      KnowledgeHelperFixerTest.fixer.fix( raw ) );
    }

    // this one is an MVEL bug: http://jira.jboss.com/jira/browse/JBRULES-1191
    public void testRetract() {
        final String raw = "System.out.println(\"some text\");retract(object);";
        assertEqualsIgnoreWhitespace( "System.out.println(\"some text\");com.agfa.hap.drools.retract(object);",
                                      KnowledgeHelperFixerTest.fixer.fix( raw ) );
    }
    
    private void assertEqualsIgnoreWhitespace(final String expected,
                                              final String actual) {
        if ( expected == null || actual == null ) {
            assertEquals(expected, actual);
            return;
        }
        final String cleanExpected = expected.replaceAll( "\\s+",
                                                          "" );
        final String cleanActual = actual.replaceAll( "\\s+",
                                                      "" );

        assertEquals( cleanExpected,
                      cleanActual );
    }
}