// $ANTLR 3.1.1 src/main/resources/org/drools/lang/dsl/DSLMap.g 2010-05-27 17:19:52

	package org.drools.lang.dsl;
	import java.util.List;
	import java.util.ArrayList;
//	import org.drools.lang.dsl.DSLMappingParseException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class DSLMapLexer extends Lexer {
    public static final int COMMA=27;
    public static final int RIGHT_CURLY=30;
    public static final int IdentifierPart=35;
    public static final int VT_ENTRY_VAL=14;
    public static final int WS=31;
    public static final int MISC=36;
    public static final int VT_META=12;
    public static final int VT_CONSEQUENCE=9;
    public static final int VT_SPACE=20;
    public static final int LINE_COMMENT=22;
    public static final int VT_ANY=11;
    public static final int VT_LITERAL=17;
    public static final int DOT=33;
    public static final int EQUALS=23;
    public static final int VT_DSL_GRAMMAR=4;
    public static final int VT_CONDITION=8;
    public static final int VT_VAR_DEF=15;
    public static final int VT_ENTRY=6;
    public static final int VT_PATTERN=18;
    public static final int LITERAL=26;
    public static final int EscapeSequence=32;
    public static final int VT_COMMENT=5;
    public static final int EOF=-1;
    public static final int EOL=21;
    public static final int LEFT_SQUARE=24;
    public static final int VT_ENTRY_KEY=13;
    public static final int VT_SCOPE=7;
    public static final int COLON=28;
    public static final int VT_KEYWORD=10;
    public static final int VT_QUAL=19;
    public static final int VT_VAR_REF=16;
    public static final int LEFT_CURLY=29;
    public static final int POUND=34;
    public static final int RIGHT_SQUARE=25;

    // delegates
    // delegators

    public DSLMapLexer() {;} 
    public DSLMapLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public DSLMapLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "src/main/resources/org/drools/lang/dsl/DSLMap.g"; }

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:269:9: ( ( ' ' | '\\t' | '\\f' )+ )
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:269:17: ( ' ' | '\\t' | '\\f' )+
            {
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:269:17: ( ' ' | '\\t' | '\\f' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\t'||LA1_0=='\f'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/main/resources/org/drools/lang/dsl/DSLMap.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            if ( state.backtracking==0 ) {
               _channel=HIDDEN;
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "EOL"
    public final void mEOL() throws RecognitionException {
        try {
            int _type = EOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:276:6: ( ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' ) )
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:277:6: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
            {
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:277:6: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='\n') && (synpred1_DSLMap())) {
                    alt2=1;
                }
                else {
                    alt2=2;}
            }
            else if ( (LA2_0=='\n') ) {
                alt2=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // src/main/resources/org/drools/lang/dsl/DSLMap.g:277:14: ( '\\r\\n' )=> '\\r\\n'
                    {
                    match("\r\n"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // src/main/resources/org/drools/lang/dsl/DSLMap.g:278:25: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // src/main/resources/org/drools/lang/dsl/DSLMap.g:279:25: '\\n'
                    {
                    match('\n'); if (state.failed) return ;

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EOL"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:285:5: ( '\\\\' ( 'b' | 'B' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | '.' | 'o' | 'x' | 'a' | 'e' | 'c' | 'd' | 'D' | 's' | 'S' | 'w' | 'W' | 'p' | 'A' | 'G' | 'Z' | 'z' | 'Q' | 'E' | '*' | '[' | ']' | '(' | ')' | '$' | '^' | '{' | '}' | '?' | '+' | '-' | '&' | '|' | '=' | 'u' | '0' | '#' ) )
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:285:9: '\\\\' ( 'b' | 'B' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | '.' | 'o' | 'x' | 'a' | 'e' | 'c' | 'd' | 'D' | 's' | 'S' | 'w' | 'W' | 'p' | 'A' | 'G' | 'Z' | 'z' | 'Q' | 'E' | '*' | '[' | ']' | '(' | ')' | '$' | '^' | '{' | '}' | '?' | '+' | '-' | '&' | '|' | '=' | 'u' | '0' | '#' )
            {
            match('\\'); if (state.failed) return ;
            if ( (input.LA(1)>='\"' && input.LA(1)<='$')||(input.LA(1)>='&' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='.')||input.LA(1)=='0'||input.LA(1)=='='||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='B')||(input.LA(1)>='D' && input.LA(1)<='E')||input.LA(1)=='G'||input.LA(1)=='Q'||input.LA(1)=='S'||input.LA(1)=='W'||(input.LA(1)>='Z' && input.LA(1)<='^')||(input.LA(1)>='a' && input.LA(1)<='f')||(input.LA(1)>='n' && input.LA(1)<='p')||(input.LA(1)>='r' && input.LA(1)<='u')||(input.LA(1)>='w' && input.LA(1)<='x')||(input.LA(1)>='z' && input.LA(1)<='}') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "LEFT_SQUARE"
    public final void mLEFT_SQUARE() throws RecognitionException {
        try {
            int _type = LEFT_SQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:292:9: ( '[' )
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:292:11: '['
            {
            match('['); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFT_SQUARE"

    // $ANTLR start "RIGHT_SQUARE"
    public final void mRIGHT_SQUARE() throws RecognitionException {
        try {
            int _type = RIGHT_SQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:296:9: ( ']' )
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:296:11: ']'
            {
            match(']'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHT_SQUARE"

    // $ANTLR start "LEFT_CURLY"
    public final void mLEFT_CURLY() throws RecognitionException {
        try {
            int _type = LEFT_CURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:300:9: ( '{' )
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:300:11: '{'
            {
            match('{'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFT_CURLY"

    // $ANTLR start "RIGHT_CURLY"
    public final void mRIGHT_CURLY() throws RecognitionException {
        try {
            int _type = RIGHT_CURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:304:9: ( '}' )
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:304:11: '}'
            {
            match('}'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHT_CURLY"

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:307:8: ( '=' )
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:307:10: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUALS"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:310:5: ( '.' )
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:310:7: '.'
            {
            match('.'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "POUND"
    public final void mPOUND() throws RecognitionException {
        try {
            int _type = POUND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:313:9: ( '#' )
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:313:11: '#'
            {
            match('#'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POUND"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:316:7: ( ':' )
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:316:9: ':'
            {
            match(':'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:319:7: ( ',' )
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:319:9: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:327:2: ( POUND ( options {greedy=false; } : . )* EOL )
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:327:4: POUND ( options {greedy=false; } : . )* EOL
            {
            mPOUND(); if (state.failed) return ;
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:327:10: ( options {greedy=false; } : . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\r') ) {
                    alt3=2;
                }
                else if ( (LA3_0=='\n') ) {
                    alt3=2;
                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src/main/resources/org/drools/lang/dsl/DSLMap.g:327:37: .
            	    {
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            mEOL(); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "LITERAL"
    public final void mLITERAL() throws RecognitionException {
        try {
            int _type = LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:335:2: ( ( IdentifierPart | MISC | EscapeSequence | DOT )+ )
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:335:4: ( IdentifierPart | MISC | EscapeSequence | DOT )+
            {
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:335:4: ( IdentifierPart | MISC | EscapeSequence | DOT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=5;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\u0000' && LA4_0<='\b')||(LA4_0>='\u000E' && LA4_0<='\u001B')||LA4_0=='$'||(LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u007F' && LA4_0<='\u009F')||(LA4_0>='\u00A2' && LA4_0<='\u00A5')||LA4_0=='\u00AA'||LA4_0=='\u00AD'||LA4_0=='\u00B5'||LA4_0=='\u00BA'||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u0236')||(LA4_0>='\u0250' && LA4_0<='\u02C1')||(LA4_0>='\u02C6' && LA4_0<='\u02D1')||(LA4_0>='\u02E0' && LA4_0<='\u02E4')||LA4_0=='\u02EE'||(LA4_0>='\u0300' && LA4_0<='\u0357')||(LA4_0>='\u035D' && LA4_0<='\u036F')||LA4_0=='\u037A'||LA4_0=='\u0386'||(LA4_0>='\u0388' && LA4_0<='\u038A')||LA4_0=='\u038C'||(LA4_0>='\u038E' && LA4_0<='\u03A1')||(LA4_0>='\u03A3' && LA4_0<='\u03CE')||(LA4_0>='\u03D0' && LA4_0<='\u03F5')||(LA4_0>='\u03F7' && LA4_0<='\u03FB')||(LA4_0>='\u0400' && LA4_0<='\u0481')||(LA4_0>='\u0483' && LA4_0<='\u0486')||(LA4_0>='\u048A' && LA4_0<='\u04CE')||(LA4_0>='\u04D0' && LA4_0<='\u04F5')||(LA4_0>='\u04F8' && LA4_0<='\u04F9')||(LA4_0>='\u0500' && LA4_0<='\u050F')||(LA4_0>='\u0531' && LA4_0<='\u0556')||LA4_0=='\u0559'||(LA4_0>='\u0561' && LA4_0<='\u0587')||(LA4_0>='\u0591' && LA4_0<='\u05A1')||(LA4_0>='\u05A3' && LA4_0<='\u05B9')||(LA4_0>='\u05BB' && LA4_0<='\u05BD')||LA4_0=='\u05BF'||(LA4_0>='\u05C1' && LA4_0<='\u05C2')||LA4_0=='\u05C4'||(LA4_0>='\u05D0' && LA4_0<='\u05EA')||(LA4_0>='\u05F0' && LA4_0<='\u05F2')||(LA4_0>='\u0600' && LA4_0<='\u0603')||(LA4_0>='\u0610' && LA4_0<='\u0615')||(LA4_0>='\u0621' && LA4_0<='\u063A')||(LA4_0>='\u0640' && LA4_0<='\u0658')||(LA4_0>='\u0660' && LA4_0<='\u0669')||(LA4_0>='\u066E' && LA4_0<='\u06D3')||(LA4_0>='\u06D5' && LA4_0<='\u06DD')||(LA4_0>='\u06DF' && LA4_0<='\u06E8')||(LA4_0>='\u06EA' && LA4_0<='\u06FC')||LA4_0=='\u06FF'||(LA4_0>='\u070F' && LA4_0<='\u074A')||(LA4_0>='\u074D' && LA4_0<='\u074F')||(LA4_0>='\u0780' && LA4_0<='\u07B1')||(LA4_0>='\u0901' && LA4_0<='\u0939')||(LA4_0>='\u093C' && LA4_0<='\u094D')||(LA4_0>='\u0950' && LA4_0<='\u0954')||(LA4_0>='\u0958' && LA4_0<='\u0963')||(LA4_0>='\u0966' && LA4_0<='\u096F')||(LA4_0>='\u0981' && LA4_0<='\u0983')||(LA4_0>='\u0985' && LA4_0<='\u098C')||(LA4_0>='\u098F' && LA4_0<='\u0990')||(LA4_0>='\u0993' && LA4_0<='\u09A8')||(LA4_0>='\u09AA' && LA4_0<='\u09B0')||LA4_0=='\u09B2'||(LA4_0>='\u09B6' && LA4_0<='\u09B9')||(LA4_0>='\u09BC' && LA4_0<='\u09C4')||(LA4_0>='\u09C7' && LA4_0<='\u09C8')||(LA4_0>='\u09CB' && LA4_0<='\u09CD')||LA4_0=='\u09D7'||(LA4_0>='\u09DC' && LA4_0<='\u09DD')||(LA4_0>='\u09DF' && LA4_0<='\u09E3')||(LA4_0>='\u09E6' && LA4_0<='\u09F3')||(LA4_0>='\u0A01' && LA4_0<='\u0A03')||(LA4_0>='\u0A05' && LA4_0<='\u0A0A')||(LA4_0>='\u0A0F' && LA4_0<='\u0A10')||(LA4_0>='\u0A13' && LA4_0<='\u0A28')||(LA4_0>='\u0A2A' && LA4_0<='\u0A30')||(LA4_0>='\u0A32' && LA4_0<='\u0A33')||(LA4_0>='\u0A35' && LA4_0<='\u0A36')||(LA4_0>='\u0A38' && LA4_0<='\u0A39')||LA4_0=='\u0A3C'||(LA4_0>='\u0A3E' && LA4_0<='\u0A42')||(LA4_0>='\u0A47' && LA4_0<='\u0A48')||(LA4_0>='\u0A4B' && LA4_0<='\u0A4D')||(LA4_0>='\u0A59' && LA4_0<='\u0A5C')||LA4_0=='\u0A5E'||(LA4_0>='\u0A66' && LA4_0<='\u0A74')||(LA4_0>='\u0A81' && LA4_0<='\u0A83')||(LA4_0>='\u0A85' && LA4_0<='\u0A8D')||(LA4_0>='\u0A8F' && LA4_0<='\u0A91')||(LA4_0>='\u0A93' && LA4_0<='\u0AA8')||(LA4_0>='\u0AAA' && LA4_0<='\u0AB0')||(LA4_0>='\u0AB2' && LA4_0<='\u0AB3')||(LA4_0>='\u0AB5' && LA4_0<='\u0AB9')||(LA4_0>='\u0ABC' && LA4_0<='\u0AC5')||(LA4_0>='\u0AC7' && LA4_0<='\u0AC9')||(LA4_0>='\u0ACB' && LA4_0<='\u0ACD')||LA4_0=='\u0AD0'||(LA4_0>='\u0AE0' && LA4_0<='\u0AE3')||(LA4_0>='\u0AE6' && LA4_0<='\u0AEF')||LA4_0=='\u0AF1'||(LA4_0>='\u0B01' && LA4_0<='\u0B03')||(LA4_0>='\u0B05' && LA4_0<='\u0B0C')||(LA4_0>='\u0B0F' && LA4_0<='\u0B10')||(LA4_0>='\u0B13' && LA4_0<='\u0B28')||(LA4_0>='\u0B2A' && LA4_0<='\u0B30')||(LA4_0>='\u0B32' && LA4_0<='\u0B33')||(LA4_0>='\u0B35' && LA4_0<='\u0B39')||(LA4_0>='\u0B3C' && LA4_0<='\u0B43')||(LA4_0>='\u0B47' && LA4_0<='\u0B48')||(LA4_0>='\u0B4B' && LA4_0<='\u0B4D')||(LA4_0>='\u0B56' && LA4_0<='\u0B57')||(LA4_0>='\u0B5C' && LA4_0<='\u0B5D')||(LA4_0>='\u0B5F' && LA4_0<='\u0B61')||(LA4_0>='\u0B66' && LA4_0<='\u0B6F')||LA4_0=='\u0B71'||(LA4_0>='\u0B82' && LA4_0<='\u0B83')||(LA4_0>='\u0B85' && LA4_0<='\u0B8A')||(LA4_0>='\u0B8E' && LA4_0<='\u0B90')||(LA4_0>='\u0B92' && LA4_0<='\u0B95')||(LA4_0>='\u0B99' && LA4_0<='\u0B9A')||LA4_0=='\u0B9C'||(LA4_0>='\u0B9E' && LA4_0<='\u0B9F')||(LA4_0>='\u0BA3' && LA4_0<='\u0BA4')||(LA4_0>='\u0BA8' && LA4_0<='\u0BAA')||(LA4_0>='\u0BAE' && LA4_0<='\u0BB5')||(LA4_0>='\u0BB7' && LA4_0<='\u0BB9')||(LA4_0>='\u0BBE' && LA4_0<='\u0BC2')||(LA4_0>='\u0BC6' && LA4_0<='\u0BC8')||(LA4_0>='\u0BCA' && LA4_0<='\u0BCD')||LA4_0=='\u0BD7'||(LA4_0>='\u0BE7' && LA4_0<='\u0BEF')||LA4_0=='\u0BF9'||(LA4_0>='\u0C01' && LA4_0<='\u0C03')||(LA4_0>='\u0C05' && LA4_0<='\u0C0C')||(LA4_0>='\u0C0E' && LA4_0<='\u0C10')||(LA4_0>='\u0C12' && LA4_0<='\u0C28')||(LA4_0>='\u0C2A' && LA4_0<='\u0C33')||(LA4_0>='\u0C35' && LA4_0<='\u0C39')||(LA4_0>='\u0C3E' && LA4_0<='\u0C44')||(LA4_0>='\u0C46' && LA4_0<='\u0C48')||(LA4_0>='\u0C4A' && LA4_0<='\u0C4D')||(LA4_0>='\u0C55' && LA4_0<='\u0C56')||(LA4_0>='\u0C60' && LA4_0<='\u0C61')||(LA4_0>='\u0C66' && LA4_0<='\u0C6F')||(LA4_0>='\u0C82' && LA4_0<='\u0C83')||(LA4_0>='\u0C85' && LA4_0<='\u0C8C')||(LA4_0>='\u0C8E' && LA4_0<='\u0C90')||(LA4_0>='\u0C92' && LA4_0<='\u0CA8')||(LA4_0>='\u0CAA' && LA4_0<='\u0CB3')||(LA4_0>='\u0CB5' && LA4_0<='\u0CB9')||(LA4_0>='\u0CBC' && LA4_0<='\u0CC4')||(LA4_0>='\u0CC6' && LA4_0<='\u0CC8')||(LA4_0>='\u0CCA' && LA4_0<='\u0CCD')||(LA4_0>='\u0CD5' && LA4_0<='\u0CD6')||LA4_0=='\u0CDE'||(LA4_0>='\u0CE0' && LA4_0<='\u0CE1')||(LA4_0>='\u0CE6' && LA4_0<='\u0CEF')||(LA4_0>='\u0D02' && LA4_0<='\u0D03')||(LA4_0>='\u0D05' && LA4_0<='\u0D0C')||(LA4_0>='\u0D0E' && LA4_0<='\u0D10')||(LA4_0>='\u0D12' && LA4_0<='\u0D28')||(LA4_0>='\u0D2A' && LA4_0<='\u0D39')||(LA4_0>='\u0D3E' && LA4_0<='\u0D43')||(LA4_0>='\u0D46' && LA4_0<='\u0D48')||(LA4_0>='\u0D4A' && LA4_0<='\u0D4D')||LA4_0=='\u0D57'||(LA4_0>='\u0D60' && LA4_0<='\u0D61')||(LA4_0>='\u0D66' && LA4_0<='\u0D6F')||(LA4_0>='\u0D82' && LA4_0<='\u0D83')||(LA4_0>='\u0D85' && LA4_0<='\u0D96')||(LA4_0>='\u0D9A' && LA4_0<='\u0DB1')||(LA4_0>='\u0DB3' && LA4_0<='\u0DBB')||LA4_0=='\u0DBD'||(LA4_0>='\u0DC0' && LA4_0<='\u0DC6')||LA4_0=='\u0DCA'||(LA4_0>='\u0DCF' && LA4_0<='\u0DD4')||LA4_0=='\u0DD6'||(LA4_0>='\u0DD8' && LA4_0<='\u0DDF')||(LA4_0>='\u0DF2' && LA4_0<='\u0DF3')||(LA4_0>='\u0E01' && LA4_0<='\u0E3A')||(LA4_0>='\u0E3F' && LA4_0<='\u0E4E')||(LA4_0>='\u0E50' && LA4_0<='\u0E59')||(LA4_0>='\u0E81' && LA4_0<='\u0E82')||LA4_0=='\u0E84'||(LA4_0>='\u0E87' && LA4_0<='\u0E88')||LA4_0=='\u0E8A'||LA4_0=='\u0E8D'||(LA4_0>='\u0E94' && LA4_0<='\u0E97')||(LA4_0>='\u0E99' && LA4_0<='\u0E9F')||(LA4_0>='\u0EA1' && LA4_0<='\u0EA3')||LA4_0=='\u0EA5'||LA4_0=='\u0EA7'||(LA4_0>='\u0EAA' && LA4_0<='\u0EAB')||(LA4_0>='\u0EAD' && LA4_0<='\u0EB9')||(LA4_0>='\u0EBB' && LA4_0<='\u0EBD')||(LA4_0>='\u0EC0' && LA4_0<='\u0EC4')||LA4_0=='\u0EC6'||(LA4_0>='\u0EC8' && LA4_0<='\u0ECD')||(LA4_0>='\u0ED0' && LA4_0<='\u0ED9')||(LA4_0>='\u0EDC' && LA4_0<='\u0EDD')||LA4_0=='\u0F00'||(LA4_0>='\u0F18' && LA4_0<='\u0F19')||(LA4_0>='\u0F20' && LA4_0<='\u0F29')||LA4_0=='\u0F35'||LA4_0=='\u0F37'||LA4_0=='\u0F39'||(LA4_0>='\u0F3E' && LA4_0<='\u0F47')||(LA4_0>='\u0F49' && LA4_0<='\u0F6A')||(LA4_0>='\u0F71' && LA4_0<='\u0F84')||(LA4_0>='\u0F86' && LA4_0<='\u0F8B')||(LA4_0>='\u0F90' && LA4_0<='\u0F97')||(LA4_0>='\u0F99' && LA4_0<='\u0FBC')||LA4_0=='\u0FC6'||(LA4_0>='\u1000' && LA4_0<='\u1021')||(LA4_0>='\u1023' && LA4_0<='\u1027')||(LA4_0>='\u1029' && LA4_0<='\u102A')||(LA4_0>='\u102C' && LA4_0<='\u1032')||(LA4_0>='\u1036' && LA4_0<='\u1039')||(LA4_0>='\u1040' && LA4_0<='\u1049')||(LA4_0>='\u1050' && LA4_0<='\u1059')||(LA4_0>='\u10A0' && LA4_0<='\u10C5')||(LA4_0>='\u10D0' && LA4_0<='\u10F8')||(LA4_0>='\u1100' && LA4_0<='\u1159')||(LA4_0>='\u115F' && LA4_0<='\u11A2')||(LA4_0>='\u11A8' && LA4_0<='\u11F9')||(LA4_0>='\u1200' && LA4_0<='\u1206')||(LA4_0>='\u1208' && LA4_0<='\u1246')||LA4_0=='\u1248'||(LA4_0>='\u124A' && LA4_0<='\u124D')||(LA4_0>='\u1250' && LA4_0<='\u1256')||LA4_0=='\u1258'||(LA4_0>='\u125A' && LA4_0<='\u125D')||(LA4_0>='\u1260' && LA4_0<='\u1286')||LA4_0=='\u1288'||(LA4_0>='\u128A' && LA4_0<='\u128D')||(LA4_0>='\u1290' && LA4_0<='\u12AE')||LA4_0=='\u12B0'||(LA4_0>='\u12B2' && LA4_0<='\u12B5')||(LA4_0>='\u12B8' && LA4_0<='\u12BE')||LA4_0=='\u12C0'||(LA4_0>='\u12C2' && LA4_0<='\u12C5')||(LA4_0>='\u12C8' && LA4_0<='\u12CE')||(LA4_0>='\u12D0' && LA4_0<='\u12D6')||(LA4_0>='\u12D8' && LA4_0<='\u12EE')||(LA4_0>='\u12F0' && LA4_0<='\u130E')||LA4_0=='\u1310'||(LA4_0>='\u1312' && LA4_0<='\u1315')||(LA4_0>='\u1318' && LA4_0<='\u131E')||(LA4_0>='\u1320' && LA4_0<='\u1346')||(LA4_0>='\u1348' && LA4_0<='\u135A')||(LA4_0>='\u1369' && LA4_0<='\u1371')||(LA4_0>='\u13A0' && LA4_0<='\u13F4')||(LA4_0>='\u1401' && LA4_0<='\u166C')||(LA4_0>='\u166F' && LA4_0<='\u1676')||(LA4_0>='\u1681' && LA4_0<='\u169A')||(LA4_0>='\u16A0' && LA4_0<='\u16EA')||(LA4_0>='\u16EE' && LA4_0<='\u16F0')||(LA4_0>='\u1700' && LA4_0<='\u170C')||(LA4_0>='\u170E' && LA4_0<='\u1714')||(LA4_0>='\u1720' && LA4_0<='\u1734')||(LA4_0>='\u1740' && LA4_0<='\u1753')||(LA4_0>='\u1760' && LA4_0<='\u176C')||(LA4_0>='\u176E' && LA4_0<='\u1770')||(LA4_0>='\u1772' && LA4_0<='\u1773')||(LA4_0>='\u1780' && LA4_0<='\u17D3')||LA4_0=='\u17D7'||(LA4_0>='\u17DB' && LA4_0<='\u17DD')||(LA4_0>='\u17E0' && LA4_0<='\u17E9')||(LA4_0>='\u180B' && LA4_0<='\u180D')||(LA4_0>='\u1810' && LA4_0<='\u1819')||(LA4_0>='\u1820' && LA4_0<='\u1877')||(LA4_0>='\u1880' && LA4_0<='\u18A9')||(LA4_0>='\u1900' && LA4_0<='\u191C')||(LA4_0>='\u1920' && LA4_0<='\u192B')||(LA4_0>='\u1930' && LA4_0<='\u193B')||(LA4_0>='\u1946' && LA4_0<='\u196D')||(LA4_0>='\u1970' && LA4_0<='\u1974')||(LA4_0>='\u1D00' && LA4_0<='\u1D6B')||(LA4_0>='\u1E00' && LA4_0<='\u1E9B')||(LA4_0>='\u1EA0' && LA4_0<='\u1EF9')||(LA4_0>='\u1F00' && LA4_0<='\u1F15')||(LA4_0>='\u1F18' && LA4_0<='\u1F1D')||(LA4_0>='\u1F20' && LA4_0<='\u1F45')||(LA4_0>='\u1F48' && LA4_0<='\u1F4D')||(LA4_0>='\u1F50' && LA4_0<='\u1F57')||LA4_0=='\u1F59'||LA4_0=='\u1F5B'||LA4_0=='\u1F5D'||(LA4_0>='\u1F5F' && LA4_0<='\u1F7D')||(LA4_0>='\u1F80' && LA4_0<='\u1FB4')||(LA4_0>='\u1FB6' && LA4_0<='\u1FBC')||LA4_0=='\u1FBE'||(LA4_0>='\u1FC2' && LA4_0<='\u1FC4')||(LA4_0>='\u1FC6' && LA4_0<='\u1FCC')||(LA4_0>='\u1FD0' && LA4_0<='\u1FD3')||(LA4_0>='\u1FD6' && LA4_0<='\u1FDB')||(LA4_0>='\u1FE0' && LA4_0<='\u1FEC')||(LA4_0>='\u1FF2' && LA4_0<='\u1FF4')||(LA4_0>='\u1FF6' && LA4_0<='\u1FFC')||(LA4_0>='\u200C' && LA4_0<='\u200F')||(LA4_0>='\u202A' && LA4_0<='\u202E')||(LA4_0>='\u203F' && LA4_0<='\u2040')||LA4_0=='\u2054'||(LA4_0>='\u2060' && LA4_0<='\u2063')||(LA4_0>='\u206A' && LA4_0<='\u206F')||LA4_0=='\u2071'||LA4_0=='\u207F'||(LA4_0>='\u20A0' && LA4_0<='\u20B1')||(LA4_0>='\u20D0' && LA4_0<='\u20DC')||LA4_0=='\u20E1'||(LA4_0>='\u20E5' && LA4_0<='\u20EA')||LA4_0=='\u2102'||LA4_0=='\u2107'||(LA4_0>='\u210A' && LA4_0<='\u2113')||LA4_0=='\u2115'||(LA4_0>='\u2119' && LA4_0<='\u211D')||LA4_0=='\u2124'||LA4_0=='\u2126'||LA4_0=='\u2128'||(LA4_0>='\u212A' && LA4_0<='\u212D')||(LA4_0>='\u212F' && LA4_0<='\u2131')||(LA4_0>='\u2133' && LA4_0<='\u2139')||(LA4_0>='\u213D' && LA4_0<='\u213F')||(LA4_0>='\u2145' && LA4_0<='\u2149')||(LA4_0>='\u2160' && LA4_0<='\u2183')||(LA4_0>='\u3005' && LA4_0<='\u3007')||(LA4_0>='\u3021' && LA4_0<='\u302F')||(LA4_0>='\u3031' && LA4_0<='\u3035')||(LA4_0>='\u3038' && LA4_0<='\u303C')||(LA4_0>='\u3041' && LA4_0<='\u3096')||(LA4_0>='\u3099' && LA4_0<='\u309A')||(LA4_0>='\u309D' && LA4_0<='\u309F')||(LA4_0>='\u30A1' && LA4_0<='\u30FF')||(LA4_0>='\u3105' && LA4_0<='\u312C')||(LA4_0>='\u3131' && LA4_0<='\u318E')||(LA4_0>='\u31A0' && LA4_0<='\u31B7')||(LA4_0>='\u31F0' && LA4_0<='\u31FF')||(LA4_0>='\u3400' && LA4_0<='\u4DB5')||(LA4_0>='\u4E00' && LA4_0<='\u9FA5')||(LA4_0>='\uA000' && LA4_0<='\uA48C')||(LA4_0>='\uAC00' && LA4_0<='\uD7A3')||(LA4_0>='\uF900' && LA4_0<='\uFA2D')||(LA4_0>='\uFA30' && LA4_0<='\uFA6A')||(LA4_0>='\uFB00' && LA4_0<='\uFB06')||(LA4_0>='\uFB13' && LA4_0<='\uFB17')||(LA4_0>='\uFB1D' && LA4_0<='\uFB28')||(LA4_0>='\uFB2A' && LA4_0<='\uFB36')||(LA4_0>='\uFB38' && LA4_0<='\uFB3C')||LA4_0=='\uFB3E'||(LA4_0>='\uFB40' && LA4_0<='\uFB41')||(LA4_0>='\uFB43' && LA4_0<='\uFB44')||(LA4_0>='\uFB46' && LA4_0<='\uFBB1')||(LA4_0>='\uFBD3' && LA4_0<='\uFD3D')||(LA4_0>='\uFD50' && LA4_0<='\uFD8F')||(LA4_0>='\uFD92' && LA4_0<='\uFDC7')||(LA4_0>='\uFDF0' && LA4_0<='\uFDFC')||(LA4_0>='\uFE00' && LA4_0<='\uFE0F')||(LA4_0>='\uFE20' && LA4_0<='\uFE23')||(LA4_0>='\uFE33' && LA4_0<='\uFE34')||(LA4_0>='\uFE4D' && LA4_0<='\uFE4F')||LA4_0=='\uFE69'||(LA4_0>='\uFE70' && LA4_0<='\uFE74')||(LA4_0>='\uFE76' && LA4_0<='\uFEFC')||LA4_0=='\uFEFF'||LA4_0=='\uFF04'||(LA4_0>='\uFF10' && LA4_0<='\uFF19')||(LA4_0>='\uFF21' && LA4_0<='\uFF3A')||LA4_0=='\uFF3F'||(LA4_0>='\uFF41' && LA4_0<='\uFF5A')||(LA4_0>='\uFF65' && LA4_0<='\uFFBE')||(LA4_0>='\uFFC2' && LA4_0<='\uFFC7')||(LA4_0>='\uFFCA' && LA4_0<='\uFFCF')||(LA4_0>='\uFFD2' && LA4_0<='\uFFD7')||(LA4_0>='\uFFDA' && LA4_0<='\uFFDC')||(LA4_0>='\uFFE0' && LA4_0<='\uFFE1')||(LA4_0>='\uFFE5' && LA4_0<='\uFFE6')||(LA4_0>='\uFFF9' && LA4_0<='\uFFFB')) ) {
                    alt4=1;
                }
                else if ( ((LA4_0>='!' && LA4_0<='\"')||(LA4_0>='%' && LA4_0<='-')||LA4_0=='/'||(LA4_0>=';' && LA4_0<='<')||(LA4_0>='>' && LA4_0<='@')||LA4_0=='^'||LA4_0=='|') ) {
                    alt4=2;
                }
                else if ( (LA4_0=='\\') ) {
                    alt4=3;
                }
                else if ( (LA4_0=='.') ) {
                    alt4=4;
                }


                switch (alt4) {
            	case 1 :
            	    // src/main/resources/org/drools/lang/dsl/DSLMap.g:335:5: IdentifierPart
            	    {
            	    mIdentifierPart(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // src/main/resources/org/drools/lang/dsl/DSLMap.g:335:20: MISC
            	    {
            	    mMISC(); if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // src/main/resources/org/drools/lang/dsl/DSLMap.g:335:25: EscapeSequence
            	    {
            	    mEscapeSequence(); if (state.failed) return ;

            	    }
            	    break;
            	case 4 :
            	    // src/main/resources/org/drools/lang/dsl/DSLMap.g:335:40: DOT
            	    {
            	    mDOT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LITERAL"

    // $ANTLR start "MISC"
    public final void mMISC() throws RecognitionException {
        try {
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:339:7: ( '>' | '<' | '!' | '@' | '%' | '^' | '*' | '-' | '+' | '?' | COMMA | '/' | '\\'' | '\"' | '|' | '&' | '(' | ')' | ';' )
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:
            {
            if ( (input.LA(1)>='!' && input.LA(1)<='\"')||(input.LA(1)>='%' && input.LA(1)<='-')||input.LA(1)=='/'||(input.LA(1)>=';' && input.LA(1)<='<')||(input.LA(1)>='>' && input.LA(1)<='@')||input.LA(1)=='^'||input.LA(1)=='|' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "MISC"

    // $ANTLR start "IdentifierPart"
    public final void mIdentifierPart() throws RecognitionException {
        try {
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:346:5: ( '\\u0000' .. '\\u0008' | '\\u000e' .. '\\u001b' | '\\u0024' | '\\u0030' .. '\\u0039' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u007f' .. '\\u009f' | '\\u00a2' .. '\\u00a5' | '\\u00aa' | '\\u00ad' | '\\u00b5' | '\\u00ba' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u0236' | '\\u0250' .. '\\u02c1' | '\\u02c6' .. '\\u02d1' | '\\u02e0' .. '\\u02e4' | '\\u02ee' | '\\u0300' .. '\\u0357' | '\\u035d' .. '\\u036f' | '\\u037a' | '\\u0386' | '\\u0388' .. '\\u038a' | '\\u038c' | '\\u038e' .. '\\u03a1' | '\\u03a3' .. '\\u03ce' | '\\u03d0' .. '\\u03f5' | '\\u03f7' .. '\\u03fb' | '\\u0400' .. '\\u0481' | '\\u0483' .. '\\u0486' | '\\u048a' .. '\\u04ce' | '\\u04d0' .. '\\u04f5' | '\\u04f8' .. '\\u04f9' | '\\u0500' .. '\\u050f' | '\\u0531' .. '\\u0556' | '\\u0559' | '\\u0561' .. '\\u0587' | '\\u0591' .. '\\u05a1' | '\\u05a3' .. '\\u05b9' | '\\u05bb' .. '\\u05bd' | '\\u05bf' | '\\u05c1' .. '\\u05c2' | '\\u05c4' | '\\u05d0' .. '\\u05ea' | '\\u05f0' .. '\\u05f2' | '\\u0600' .. '\\u0603' | '\\u0610' .. '\\u0615' | '\\u0621' .. '\\u063a' | '\\u0640' .. '\\u0658' | '\\u0660' .. '\\u0669' | '\\u066e' .. '\\u06d3' | '\\u06d5' .. '\\u06dd' | '\\u06df' .. '\\u06e8' | '\\u06ea' .. '\\u06fc' | '\\u06ff' | '\\u070f' .. '\\u074a' | '\\u074d' .. '\\u074f' | '\\u0780' .. '\\u07b1' | '\\u0901' .. '\\u0939' | '\\u093c' .. '\\u094d' | '\\u0950' .. '\\u0954' | '\\u0958' .. '\\u0963' | '\\u0966' .. '\\u096f' | '\\u0981' .. '\\u0983' | '\\u0985' .. '\\u098c' | '\\u098f' .. '\\u0990' | '\\u0993' .. '\\u09a8' | '\\u09aa' .. '\\u09b0' | '\\u09b2' | '\\u09b6' .. '\\u09b9' | '\\u09bc' .. '\\u09c4' | '\\u09c7' .. '\\u09c8' | '\\u09cb' .. '\\u09cd' | '\\u09d7' | '\\u09dc' .. '\\u09dd' | '\\u09df' .. '\\u09e3' | '\\u09e6' .. '\\u09f3' | '\\u0a01' .. '\\u0a03' | '\\u0a05' .. '\\u0a0a' | '\\u0a0f' .. '\\u0a10' | '\\u0a13' .. '\\u0a28' | '\\u0a2a' .. '\\u0a30' | '\\u0a32' .. '\\u0a33' | '\\u0a35' .. '\\u0a36' | '\\u0a38' .. '\\u0a39' | '\\u0a3c' | '\\u0a3e' .. '\\u0a42' | '\\u0a47' .. '\\u0a48' | '\\u0a4b' .. '\\u0a4d' | '\\u0a59' .. '\\u0a5c' | '\\u0a5e' | '\\u0a66' .. '\\u0a74' | '\\u0a81' .. '\\u0a83' | '\\u0a85' .. '\\u0a8d' | '\\u0a8f' .. '\\u0a91' | '\\u0a93' .. '\\u0aa8' | '\\u0aaa' .. '\\u0ab0' | '\\u0ab2' .. '\\u0ab3' | '\\u0ab5' .. '\\u0ab9' | '\\u0abc' .. '\\u0ac5' | '\\u0ac7' .. '\\u0ac9' | '\\u0acb' .. '\\u0acd' | '\\u0ad0' | '\\u0ae0' .. '\\u0ae3' | '\\u0ae6' .. '\\u0aef' | '\\u0af1' | '\\u0b01' .. '\\u0b03' | '\\u0b05' .. '\\u0b0c' | '\\u0b0f' .. '\\u0b10' | '\\u0b13' .. '\\u0b28' | '\\u0b2a' .. '\\u0b30' | '\\u0b32' .. '\\u0b33' | '\\u0b35' .. '\\u0b39' | '\\u0b3c' .. '\\u0b43' | '\\u0b47' .. '\\u0b48' | '\\u0b4b' .. '\\u0b4d' | '\\u0b56' .. '\\u0b57' | '\\u0b5c' .. '\\u0b5d' | '\\u0b5f' .. '\\u0b61' | '\\u0b66' .. '\\u0b6f' | '\\u0b71' | '\\u0b82' .. '\\u0b83' | '\\u0b85' .. '\\u0b8a' | '\\u0b8e' .. '\\u0b90' | '\\u0b92' .. '\\u0b95' | '\\u0b99' .. '\\u0b9a' | '\\u0b9c' | '\\u0b9e' .. '\\u0b9f' | '\\u0ba3' .. '\\u0ba4' | '\\u0ba8' .. '\\u0baa' | '\\u0bae' .. '\\u0bb5' | '\\u0bb7' .. '\\u0bb9' | '\\u0bbe' .. '\\u0bc2' | '\\u0bc6' .. '\\u0bc8' | '\\u0bca' .. '\\u0bcd' | '\\u0bd7' | '\\u0be7' .. '\\u0bef' | '\\u0bf9' | '\\u0c01' .. '\\u0c03' | '\\u0c05' .. '\\u0c0c' | '\\u0c0e' .. '\\u0c10' | '\\u0c12' .. '\\u0c28' | '\\u0c2a' .. '\\u0c33' | '\\u0c35' .. '\\u0c39' | '\\u0c3e' .. '\\u0c44' | '\\u0c46' .. '\\u0c48' | '\\u0c4a' .. '\\u0c4d' | '\\u0c55' .. '\\u0c56' | '\\u0c60' .. '\\u0c61' | '\\u0c66' .. '\\u0c6f' | '\\u0c82' .. '\\u0c83' | '\\u0c85' .. '\\u0c8c' | '\\u0c8e' .. '\\u0c90' | '\\u0c92' .. '\\u0ca8' | '\\u0caa' .. '\\u0cb3' | '\\u0cb5' .. '\\u0cb9' | '\\u0cbc' .. '\\u0cc4' | '\\u0cc6' .. '\\u0cc8' | '\\u0cca' .. '\\u0ccd' | '\\u0cd5' .. '\\u0cd6' | '\\u0cde' | '\\u0ce0' .. '\\u0ce1' | '\\u0ce6' .. '\\u0cef' | '\\u0d02' .. '\\u0d03' | '\\u0d05' .. '\\u0d0c' | '\\u0d0e' .. '\\u0d10' | '\\u0d12' .. '\\u0d28' | '\\u0d2a' .. '\\u0d39' | '\\u0d3e' .. '\\u0d43' | '\\u0d46' .. '\\u0d48' | '\\u0d4a' .. '\\u0d4d' | '\\u0d57' | '\\u0d60' .. '\\u0d61' | '\\u0d66' .. '\\u0d6f' | '\\u0d82' .. '\\u0d83' | '\\u0d85' .. '\\u0d96' | '\\u0d9a' .. '\\u0db1' | '\\u0db3' .. '\\u0dbb' | '\\u0dbd' | '\\u0dc0' .. '\\u0dc6' | '\\u0dca' | '\\u0dcf' .. '\\u0dd4' | '\\u0dd6' | '\\u0dd8' .. '\\u0ddf' | '\\u0df2' .. '\\u0df3' | '\\u0e01' .. '\\u0e3a' | '\\u0e3f' .. '\\u0e4e' | '\\u0e50' .. '\\u0e59' | '\\u0e81' .. '\\u0e82' | '\\u0e84' | '\\u0e87' .. '\\u0e88' | '\\u0e8a' | '\\u0e8d' | '\\u0e94' .. '\\u0e97' | '\\u0e99' .. '\\u0e9f' | '\\u0ea1' .. '\\u0ea3' | '\\u0ea5' | '\\u0ea7' | '\\u0eaa' .. '\\u0eab' | '\\u0ead' .. '\\u0eb9' | '\\u0ebb' .. '\\u0ebd' | '\\u0ec0' .. '\\u0ec4' | '\\u0ec6' | '\\u0ec8' .. '\\u0ecd' | '\\u0ed0' .. '\\u0ed9' | '\\u0edc' .. '\\u0edd' | '\\u0f00' | '\\u0f18' .. '\\u0f19' | '\\u0f20' .. '\\u0f29' | '\\u0f35' | '\\u0f37' | '\\u0f39' | '\\u0f3e' .. '\\u0f47' | '\\u0f49' .. '\\u0f6a' | '\\u0f71' .. '\\u0f84' | '\\u0f86' .. '\\u0f8b' | '\\u0f90' .. '\\u0f97' | '\\u0f99' .. '\\u0fbc' | '\\u0fc6' | '\\u1000' .. '\\u1021' | '\\u1023' .. '\\u1027' | '\\u1029' .. '\\u102a' | '\\u102c' .. '\\u1032' | '\\u1036' .. '\\u1039' | '\\u1040' .. '\\u1049' | '\\u1050' .. '\\u1059' | '\\u10a0' .. '\\u10c5' | '\\u10d0' .. '\\u10f8' | '\\u1100' .. '\\u1159' | '\\u115f' .. '\\u11a2' | '\\u11a8' .. '\\u11f9' | '\\u1200' .. '\\u1206' | '\\u1208' .. '\\u1246' | '\\u1248' | '\\u124a' .. '\\u124d' | '\\u1250' .. '\\u1256' | '\\u1258' | '\\u125a' .. '\\u125d' | '\\u1260' .. '\\u1286' | '\\u1288' | '\\u128a' .. '\\u128d' | '\\u1290' .. '\\u12ae' | '\\u12b0' | '\\u12b2' .. '\\u12b5' | '\\u12b8' .. '\\u12be' | '\\u12c0' | '\\u12c2' .. '\\u12c5' | '\\u12c8' .. '\\u12ce' | '\\u12d0' .. '\\u12d6' | '\\u12d8' .. '\\u12ee' | '\\u12f0' .. '\\u130e' | '\\u1310' | '\\u1312' .. '\\u1315' | '\\u1318' .. '\\u131e' | '\\u1320' .. '\\u1346' | '\\u1348' .. '\\u135a' | '\\u1369' .. '\\u1371' | '\\u13a0' .. '\\u13f4' | '\\u1401' .. '\\u166c' | '\\u166f' .. '\\u1676' | '\\u1681' .. '\\u169a' | '\\u16a0' .. '\\u16ea' | '\\u16ee' .. '\\u16f0' | '\\u1700' .. '\\u170c' | '\\u170e' .. '\\u1714' | '\\u1720' .. '\\u1734' | '\\u1740' .. '\\u1753' | '\\u1760' .. '\\u176c' | '\\u176e' .. '\\u1770' | '\\u1772' .. '\\u1773' | '\\u1780' .. '\\u17d3' | '\\u17d7' | '\\u17db' .. '\\u17dd' | '\\u17e0' .. '\\u17e9' | '\\u180b' .. '\\u180d' | '\\u1810' .. '\\u1819' | '\\u1820' .. '\\u1877' | '\\u1880' .. '\\u18a9' | '\\u1900' .. '\\u191c' | '\\u1920' .. '\\u192b' | '\\u1930' .. '\\u193b' | '\\u1946' .. '\\u196d' | '\\u1970' .. '\\u1974' | '\\u1d00' .. '\\u1d6b' | '\\u1e00' .. '\\u1e9b' | '\\u1ea0' .. '\\u1ef9' | '\\u1f00' .. '\\u1f15' | '\\u1f18' .. '\\u1f1d' | '\\u1f20' .. '\\u1f45' | '\\u1f48' .. '\\u1f4d' | '\\u1f50' .. '\\u1f57' | '\\u1f59' | '\\u1f5b' | '\\u1f5d' | '\\u1f5f' .. '\\u1f7d' | '\\u1f80' .. '\\u1fb4' | '\\u1fb6' .. '\\u1fbc' | '\\u1fbe' | '\\u1fc2' .. '\\u1fc4' | '\\u1fc6' .. '\\u1fcc' | '\\u1fd0' .. '\\u1fd3' | '\\u1fd6' .. '\\u1fdb' | '\\u1fe0' .. '\\u1fec' | '\\u1ff2' .. '\\u1ff4' | '\\u1ff6' .. '\\u1ffc' | '\\u200c' .. '\\u200f' | '\\u202a' .. '\\u202e' | '\\u203f' .. '\\u2040' | '\\u2054' | '\\u2060' .. '\\u2063' | '\\u206a' .. '\\u206f' | '\\u2071' | '\\u207f' | '\\u20a0' .. '\\u20b1' | '\\u20d0' .. '\\u20dc' | '\\u20e1' | '\\u20e5' .. '\\u20ea' | '\\u2102' | '\\u2107' | '\\u210a' .. '\\u2113' | '\\u2115' | '\\u2119' .. '\\u211d' | '\\u2124' | '\\u2126' | '\\u2128' | '\\u212a' .. '\\u212d' | '\\u212f' .. '\\u2131' | '\\u2133' .. '\\u2139' | '\\u213d' .. '\\u213f' | '\\u2145' .. '\\u2149' | '\\u2160' .. '\\u2183' | '\\u3005' .. '\\u3007' | '\\u3021' .. '\\u302f' | '\\u3031' .. '\\u3035' | '\\u3038' .. '\\u303c' | '\\u3041' .. '\\u3096' | '\\u3099' .. '\\u309a' | '\\u309d' .. '\\u309f' | '\\u30a1' .. '\\u30ff' | '\\u3105' .. '\\u312c' | '\\u3131' .. '\\u318e' | '\\u31a0' .. '\\u31b7' | '\\u31f0' .. '\\u31ff' | '\\u3400' .. '\\u4db5' | '\\u4e00' .. '\\u9fa5' | '\\ua000' .. '\\ua48c' | '\\uac00' .. '\\ud7a3' | '\\uf900' .. '\\ufa2d' | '\\ufa30' .. '\\ufa6a' | '\\ufb00' .. '\\ufb06' | '\\ufb13' .. '\\ufb17' | '\\ufb1d' .. '\\ufb28' | '\\ufb2a' .. '\\ufb36' | '\\ufb38' .. '\\ufb3c' | '\\ufb3e' | '\\ufb40' .. '\\ufb41' | '\\ufb43' .. '\\ufb44' | '\\ufb46' .. '\\ufbb1' | '\\ufbd3' .. '\\ufd3d' | '\\ufd50' .. '\\ufd8f' | '\\ufd92' .. '\\ufdc7' | '\\ufdf0' .. '\\ufdfc' | '\\ufe00' .. '\\ufe0f' | '\\ufe20' .. '\\ufe23' | '\\ufe33' .. '\\ufe34' | '\\ufe4d' .. '\\ufe4f' | '\\ufe69' | '\\ufe70' .. '\\ufe74' | '\\ufe76' .. '\\ufefc' | '\\ufeff' | '\\uff04' | '\\uff10' .. '\\uff19' | '\\uff21' .. '\\uff3a' | '\\uff3f' | '\\uff41' .. '\\uff5a' | '\\uff65' .. '\\uffbe' | '\\uffc2' .. '\\uffc7' | '\\uffca' .. '\\uffcf' | '\\uffd2' .. '\\uffd7' | '\\uffda' .. '\\uffdc' | '\\uffe0' .. '\\uffe1' | '\\uffe5' .. '\\uffe6' | '\\ufff9' .. '\\ufffb' )
            // src/main/resources/org/drools/lang/dsl/DSLMap.g:
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001B')||input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u007F' && input.LA(1)<='\u009F')||(input.LA(1)>='\u00A2' && input.LA(1)<='\u00A5')||input.LA(1)=='\u00AA'||input.LA(1)=='\u00AD'||input.LA(1)=='\u00B5'||input.LA(1)=='\u00BA'||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u0236')||(input.LA(1)>='\u0250' && input.LA(1)<='\u02C1')||(input.LA(1)>='\u02C6' && input.LA(1)<='\u02D1')||(input.LA(1)>='\u02E0' && input.LA(1)<='\u02E4')||input.LA(1)=='\u02EE'||(input.LA(1)>='\u0300' && input.LA(1)<='\u0357')||(input.LA(1)>='\u035D' && input.LA(1)<='\u036F')||input.LA(1)=='\u037A'||input.LA(1)=='\u0386'||(input.LA(1)>='\u0388' && input.LA(1)<='\u038A')||input.LA(1)=='\u038C'||(input.LA(1)>='\u038E' && input.LA(1)<='\u03A1')||(input.LA(1)>='\u03A3' && input.LA(1)<='\u03CE')||(input.LA(1)>='\u03D0' && input.LA(1)<='\u03F5')||(input.LA(1)>='\u03F7' && input.LA(1)<='\u03FB')||(input.LA(1)>='\u0400' && input.LA(1)<='\u0481')||(input.LA(1)>='\u0483' && input.LA(1)<='\u0486')||(input.LA(1)>='\u048A' && input.LA(1)<='\u04CE')||(input.LA(1)>='\u04D0' && input.LA(1)<='\u04F5')||(input.LA(1)>='\u04F8' && input.LA(1)<='\u04F9')||(input.LA(1)>='\u0500' && input.LA(1)<='\u050F')||(input.LA(1)>='\u0531' && input.LA(1)<='\u0556')||input.LA(1)=='\u0559'||(input.LA(1)>='\u0561' && input.LA(1)<='\u0587')||(input.LA(1)>='\u0591' && input.LA(1)<='\u05A1')||(input.LA(1)>='\u05A3' && input.LA(1)<='\u05B9')||(input.LA(1)>='\u05BB' && input.LA(1)<='\u05BD')||input.LA(1)=='\u05BF'||(input.LA(1)>='\u05C1' && input.LA(1)<='\u05C2')||input.LA(1)=='\u05C4'||(input.LA(1)>='\u05D0' && input.LA(1)<='\u05EA')||(input.LA(1)>='\u05F0' && input.LA(1)<='\u05F2')||(input.LA(1)>='\u0600' && input.LA(1)<='\u0603')||(input.LA(1)>='\u0610' && input.LA(1)<='\u0615')||(input.LA(1)>='\u0621' && input.LA(1)<='\u063A')||(input.LA(1)>='\u0640' && input.LA(1)<='\u0658')||(input.LA(1)>='\u0660' && input.LA(1)<='\u0669')||(input.LA(1)>='\u066E' && input.LA(1)<='\u06D3')||(input.LA(1)>='\u06D5' && input.LA(1)<='\u06DD')||(input.LA(1)>='\u06DF' && input.LA(1)<='\u06E8')||(input.LA(1)>='\u06EA' && input.LA(1)<='\u06FC')||input.LA(1)=='\u06FF'||(input.LA(1)>='\u070F' && input.LA(1)<='\u074A')||(input.LA(1)>='\u074D' && input.LA(1)<='\u074F')||(input.LA(1)>='\u0780' && input.LA(1)<='\u07B1')||(input.LA(1)>='\u0901' && input.LA(1)<='\u0939')||(input.LA(1)>='\u093C' && input.LA(1)<='\u094D')||(input.LA(1)>='\u0950' && input.LA(1)<='\u0954')||(input.LA(1)>='\u0958' && input.LA(1)<='\u0963')||(input.LA(1)>='\u0966' && input.LA(1)<='\u096F')||(input.LA(1)>='\u0981' && input.LA(1)<='\u0983')||(input.LA(1)>='\u0985' && input.LA(1)<='\u098C')||(input.LA(1)>='\u098F' && input.LA(1)<='\u0990')||(input.LA(1)>='\u0993' && input.LA(1)<='\u09A8')||(input.LA(1)>='\u09AA' && input.LA(1)<='\u09B0')||input.LA(1)=='\u09B2'||(input.LA(1)>='\u09B6' && input.LA(1)<='\u09B9')||(input.LA(1)>='\u09BC' && input.LA(1)<='\u09C4')||(input.LA(1)>='\u09C7' && input.LA(1)<='\u09C8')||(input.LA(1)>='\u09CB' && input.LA(1)<='\u09CD')||input.LA(1)=='\u09D7'||(input.LA(1)>='\u09DC' && input.LA(1)<='\u09DD')||(input.LA(1)>='\u09DF' && input.LA(1)<='\u09E3')||(input.LA(1)>='\u09E6' && input.LA(1)<='\u09F3')||(input.LA(1)>='\u0A01' && input.LA(1)<='\u0A03')||(input.LA(1)>='\u0A05' && input.LA(1)<='\u0A0A')||(input.LA(1)>='\u0A0F' && input.LA(1)<='\u0A10')||(input.LA(1)>='\u0A13' && input.LA(1)<='\u0A28')||(input.LA(1)>='\u0A2A' && input.LA(1)<='\u0A30')||(input.LA(1)>='\u0A32' && input.LA(1)<='\u0A33')||(input.LA(1)>='\u0A35' && input.LA(1)<='\u0A36')||(input.LA(1)>='\u0A38' && input.LA(1)<='\u0A39')||input.LA(1)=='\u0A3C'||(input.LA(1)>='\u0A3E' && input.LA(1)<='\u0A42')||(input.LA(1)>='\u0A47' && input.LA(1)<='\u0A48')||(input.LA(1)>='\u0A4B' && input.LA(1)<='\u0A4D')||(input.LA(1)>='\u0A59' && input.LA(1)<='\u0A5C')||input.LA(1)=='\u0A5E'||(input.LA(1)>='\u0A66' && input.LA(1)<='\u0A74')||(input.LA(1)>='\u0A81' && input.LA(1)<='\u0A83')||(input.LA(1)>='\u0A85' && input.LA(1)<='\u0A8D')||(input.LA(1)>='\u0A8F' && input.LA(1)<='\u0A91')||(input.LA(1)>='\u0A93' && input.LA(1)<='\u0AA8')||(input.LA(1)>='\u0AAA' && input.LA(1)<='\u0AB0')||(input.LA(1)>='\u0AB2' && input.LA(1)<='\u0AB3')||(input.LA(1)>='\u0AB5' && input.LA(1)<='\u0AB9')||(input.LA(1)>='\u0ABC' && input.LA(1)<='\u0AC5')||(input.LA(1)>='\u0AC7' && input.LA(1)<='\u0AC9')||(input.LA(1)>='\u0ACB' && input.LA(1)<='\u0ACD')||input.LA(1)=='\u0AD0'||(input.LA(1)>='\u0AE0' && input.LA(1)<='\u0AE3')||(input.LA(1)>='\u0AE6' && input.LA(1)<='\u0AEF')||input.LA(1)=='\u0AF1'||(input.LA(1)>='\u0B01' && input.LA(1)<='\u0B03')||(input.LA(1)>='\u0B05' && input.LA(1)<='\u0B0C')||(input.LA(1)>='\u0B0F' && input.LA(1)<='\u0B10')||(input.LA(1)>='\u0B13' && input.LA(1)<='\u0B28')||(input.LA(1)>='\u0B2A' && input.LA(1)<='\u0B30')||(input.LA(1)>='\u0B32' && input.LA(1)<='\u0B33')||(input.LA(1)>='\u0B35' && input.LA(1)<='\u0B39')||(input.LA(1)>='\u0B3C' && input.LA(1)<='\u0B43')||(input.LA(1)>='\u0B47' && input.LA(1)<='\u0B48')||(input.LA(1)>='\u0B4B' && input.LA(1)<='\u0B4D')||(input.LA(1)>='\u0B56' && input.LA(1)<='\u0B57')||(input.LA(1)>='\u0B5C' && input.LA(1)<='\u0B5D')||(input.LA(1)>='\u0B5F' && input.LA(1)<='\u0B61')||(input.LA(1)>='\u0B66' && input.LA(1)<='\u0B6F')||input.LA(1)=='\u0B71'||(input.LA(1)>='\u0B82' && input.LA(1)<='\u0B83')||(input.LA(1)>='\u0B85' && input.LA(1)<='\u0B8A')||(input.LA(1)>='\u0B8E' && input.LA(1)<='\u0B90')||(input.LA(1)>='\u0B92' && input.LA(1)<='\u0B95')||(input.LA(1)>='\u0B99' && input.LA(1)<='\u0B9A')||input.LA(1)=='\u0B9C'||(input.LA(1)>='\u0B9E' && input.LA(1)<='\u0B9F')||(input.LA(1)>='\u0BA3' && input.LA(1)<='\u0BA4')||(input.LA(1)>='\u0BA8' && input.LA(1)<='\u0BAA')||(input.LA(1)>='\u0BAE' && input.LA(1)<='\u0BB5')||(input.LA(1)>='\u0BB7' && input.LA(1)<='\u0BB9')||(input.LA(1)>='\u0BBE' && input.LA(1)<='\u0BC2')||(input.LA(1)>='\u0BC6' && input.LA(1)<='\u0BC8')||(input.LA(1)>='\u0BCA' && input.LA(1)<='\u0BCD')||input.LA(1)=='\u0BD7'||(input.LA(1)>='\u0BE7' && input.LA(1)<='\u0BEF')||input.LA(1)=='\u0BF9'||(input.LA(1)>='\u0C01' && input.LA(1)<='\u0C03')||(input.LA(1)>='\u0C05' && input.LA(1)<='\u0C0C')||(input.LA(1)>='\u0C0E' && input.LA(1)<='\u0C10')||(input.LA(1)>='\u0C12' && input.LA(1)<='\u0C28')||(input.LA(1)>='\u0C2A' && input.LA(1)<='\u0C33')||(input.LA(1)>='\u0C35' && input.LA(1)<='\u0C39')||(input.LA(1)>='\u0C3E' && input.LA(1)<='\u0C44')||(input.LA(1)>='\u0C46' && input.LA(1)<='\u0C48')||(input.LA(1)>='\u0C4A' && input.LA(1)<='\u0C4D')||(input.LA(1)>='\u0C55' && input.LA(1)<='\u0C56')||(input.LA(1)>='\u0C60' && input.LA(1)<='\u0C61')||(input.LA(1)>='\u0C66' && input.LA(1)<='\u0C6F')||(input.LA(1)>='\u0C82' && input.LA(1)<='\u0C83')||(input.LA(1)>='\u0C85' && input.LA(1)<='\u0C8C')||(input.LA(1)>='\u0C8E' && input.LA(1)<='\u0C90')||(input.LA(1)>='\u0C92' && input.LA(1)<='\u0CA8')||(input.LA(1)>='\u0CAA' && input.LA(1)<='\u0CB3')||(input.LA(1)>='\u0CB5' && input.LA(1)<='\u0CB9')||(input.LA(1)>='\u0CBC' && input.LA(1)<='\u0CC4')||(input.LA(1)>='\u0CC6' && input.LA(1)<='\u0CC8')||(input.LA(1)>='\u0CCA' && input.LA(1)<='\u0CCD')||(input.LA(1)>='\u0CD5' && input.LA(1)<='\u0CD6')||input.LA(1)=='\u0CDE'||(input.LA(1)>='\u0CE0' && input.LA(1)<='\u0CE1')||(input.LA(1)>='\u0CE6' && input.LA(1)<='\u0CEF')||(input.LA(1)>='\u0D02' && input.LA(1)<='\u0D03')||(input.LA(1)>='\u0D05' && input.LA(1)<='\u0D0C')||(input.LA(1)>='\u0D0E' && input.LA(1)<='\u0D10')||(input.LA(1)>='\u0D12' && input.LA(1)<='\u0D28')||(input.LA(1)>='\u0D2A' && input.LA(1)<='\u0D39')||(input.LA(1)>='\u0D3E' && input.LA(1)<='\u0D43')||(input.LA(1)>='\u0D46' && input.LA(1)<='\u0D48')||(input.LA(1)>='\u0D4A' && input.LA(1)<='\u0D4D')||input.LA(1)=='\u0D57'||(input.LA(1)>='\u0D60' && input.LA(1)<='\u0D61')||(input.LA(1)>='\u0D66' && input.LA(1)<='\u0D6F')||(input.LA(1)>='\u0D82' && input.LA(1)<='\u0D83')||(input.LA(1)>='\u0D85' && input.LA(1)<='\u0D96')||(input.LA(1)>='\u0D9A' && input.LA(1)<='\u0DB1')||(input.LA(1)>='\u0DB3' && input.LA(1)<='\u0DBB')||input.LA(1)=='\u0DBD'||(input.LA(1)>='\u0DC0' && input.LA(1)<='\u0DC6')||input.LA(1)=='\u0DCA'||(input.LA(1)>='\u0DCF' && input.LA(1)<='\u0DD4')||input.LA(1)=='\u0DD6'||(input.LA(1)>='\u0DD8' && input.LA(1)<='\u0DDF')||(input.LA(1)>='\u0DF2' && input.LA(1)<='\u0DF3')||(input.LA(1)>='\u0E01' && input.LA(1)<='\u0E3A')||(input.LA(1)>='\u0E3F' && input.LA(1)<='\u0E4E')||(input.LA(1)>='\u0E50' && input.LA(1)<='\u0E59')||(input.LA(1)>='\u0E81' && input.LA(1)<='\u0E82')||input.LA(1)=='\u0E84'||(input.LA(1)>='\u0E87' && input.LA(1)<='\u0E88')||input.LA(1)=='\u0E8A'||input.LA(1)=='\u0E8D'||(input.LA(1)>='\u0E94' && input.LA(1)<='\u0E97')||(input.LA(1)>='\u0E99' && input.LA(1)<='\u0E9F')||(input.LA(1)>='\u0EA1' && input.LA(1)<='\u0EA3')||input.LA(1)=='\u0EA5'||input.LA(1)=='\u0EA7'||(input.LA(1)>='\u0EAA' && input.LA(1)<='\u0EAB')||(input.LA(1)>='\u0EAD' && input.LA(1)<='\u0EB9')||(input.LA(1)>='\u0EBB' && input.LA(1)<='\u0EBD')||(input.LA(1)>='\u0EC0' && input.LA(1)<='\u0EC4')||input.LA(1)=='\u0EC6'||(input.LA(1)>='\u0EC8' && input.LA(1)<='\u0ECD')||(input.LA(1)>='\u0ED0' && input.LA(1)<='\u0ED9')||(input.LA(1)>='\u0EDC' && input.LA(1)<='\u0EDD')||input.LA(1)=='\u0F00'||(input.LA(1)>='\u0F18' && input.LA(1)<='\u0F19')||(input.LA(1)>='\u0F20' && input.LA(1)<='\u0F29')||input.LA(1)=='\u0F35'||input.LA(1)=='\u0F37'||input.LA(1)=='\u0F39'||(input.LA(1)>='\u0F3E' && input.LA(1)<='\u0F47')||(input.LA(1)>='\u0F49' && input.LA(1)<='\u0F6A')||(input.LA(1)>='\u0F71' && input.LA(1)<='\u0F84')||(input.LA(1)>='\u0F86' && input.LA(1)<='\u0F8B')||(input.LA(1)>='\u0F90' && input.LA(1)<='\u0F97')||(input.LA(1)>='\u0F99' && input.LA(1)<='\u0FBC')||input.LA(1)=='\u0FC6'||(input.LA(1)>='\u1000' && input.LA(1)<='\u1021')||(input.LA(1)>='\u1023' && input.LA(1)<='\u1027')||(input.LA(1)>='\u1029' && input.LA(1)<='\u102A')||(input.LA(1)>='\u102C' && input.LA(1)<='\u1032')||(input.LA(1)>='\u1036' && input.LA(1)<='\u1039')||(input.LA(1)>='\u1040' && input.LA(1)<='\u1049')||(input.LA(1)>='\u1050' && input.LA(1)<='\u1059')||(input.LA(1)>='\u10A0' && input.LA(1)<='\u10C5')||(input.LA(1)>='\u10D0' && input.LA(1)<='\u10F8')||(input.LA(1)>='\u1100' && input.LA(1)<='\u1159')||(input.LA(1)>='\u115F' && input.LA(1)<='\u11A2')||(input.LA(1)>='\u11A8' && input.LA(1)<='\u11F9')||(input.LA(1)>='\u1200' && input.LA(1)<='\u1206')||(input.LA(1)>='\u1208' && input.LA(1)<='\u1246')||input.LA(1)=='\u1248'||(input.LA(1)>='\u124A' && input.LA(1)<='\u124D')||(input.LA(1)>='\u1250' && input.LA(1)<='\u1256')||input.LA(1)=='\u1258'||(input.LA(1)>='\u125A' && input.LA(1)<='\u125D')||(input.LA(1)>='\u1260' && input.LA(1)<='\u1286')||input.LA(1)=='\u1288'||(input.LA(1)>='\u128A' && input.LA(1)<='\u128D')||(input.LA(1)>='\u1290' && input.LA(1)<='\u12AE')||input.LA(1)=='\u12B0'||(input.LA(1)>='\u12B2' && input.LA(1)<='\u12B5')||(input.LA(1)>='\u12B8' && input.LA(1)<='\u12BE')||input.LA(1)=='\u12C0'||(input.LA(1)>='\u12C2' && input.LA(1)<='\u12C5')||(input.LA(1)>='\u12C8' && input.LA(1)<='\u12CE')||(input.LA(1)>='\u12D0' && input.LA(1)<='\u12D6')||(input.LA(1)>='\u12D8' && input.LA(1)<='\u12EE')||(input.LA(1)>='\u12F0' && input.LA(1)<='\u130E')||input.LA(1)=='\u1310'||(input.LA(1)>='\u1312' && input.LA(1)<='\u1315')||(input.LA(1)>='\u1318' && input.LA(1)<='\u131E')||(input.LA(1)>='\u1320' && input.LA(1)<='\u1346')||(input.LA(1)>='\u1348' && input.LA(1)<='\u135A')||(input.LA(1)>='\u1369' && input.LA(1)<='\u1371')||(input.LA(1)>='\u13A0' && input.LA(1)<='\u13F4')||(input.LA(1)>='\u1401' && input.LA(1)<='\u166C')||(input.LA(1)>='\u166F' && input.LA(1)<='\u1676')||(input.LA(1)>='\u1681' && input.LA(1)<='\u169A')||(input.LA(1)>='\u16A0' && input.LA(1)<='\u16EA')||(input.LA(1)>='\u16EE' && input.LA(1)<='\u16F0')||(input.LA(1)>='\u1700' && input.LA(1)<='\u170C')||(input.LA(1)>='\u170E' && input.LA(1)<='\u1714')||(input.LA(1)>='\u1720' && input.LA(1)<='\u1734')||(input.LA(1)>='\u1740' && input.LA(1)<='\u1753')||(input.LA(1)>='\u1760' && input.LA(1)<='\u176C')||(input.LA(1)>='\u176E' && input.LA(1)<='\u1770')||(input.LA(1)>='\u1772' && input.LA(1)<='\u1773')||(input.LA(1)>='\u1780' && input.LA(1)<='\u17D3')||input.LA(1)=='\u17D7'||(input.LA(1)>='\u17DB' && input.LA(1)<='\u17DD')||(input.LA(1)>='\u17E0' && input.LA(1)<='\u17E9')||(input.LA(1)>='\u180B' && input.LA(1)<='\u180D')||(input.LA(1)>='\u1810' && input.LA(1)<='\u1819')||(input.LA(1)>='\u1820' && input.LA(1)<='\u1877')||(input.LA(1)>='\u1880' && input.LA(1)<='\u18A9')||(input.LA(1)>='\u1900' && input.LA(1)<='\u191C')||(input.LA(1)>='\u1920' && input.LA(1)<='\u192B')||(input.LA(1)>='\u1930' && input.LA(1)<='\u193B')||(input.LA(1)>='\u1946' && input.LA(1)<='\u196D')||(input.LA(1)>='\u1970' && input.LA(1)<='\u1974')||(input.LA(1)>='\u1D00' && input.LA(1)<='\u1D6B')||(input.LA(1)>='\u1E00' && input.LA(1)<='\u1E9B')||(input.LA(1)>='\u1EA0' && input.LA(1)<='\u1EF9')||(input.LA(1)>='\u1F00' && input.LA(1)<='\u1F15')||(input.LA(1)>='\u1F18' && input.LA(1)<='\u1F1D')||(input.LA(1)>='\u1F20' && input.LA(1)<='\u1F45')||(input.LA(1)>='\u1F48' && input.LA(1)<='\u1F4D')||(input.LA(1)>='\u1F50' && input.LA(1)<='\u1F57')||input.LA(1)=='\u1F59'||input.LA(1)=='\u1F5B'||input.LA(1)=='\u1F5D'||(input.LA(1)>='\u1F5F' && input.LA(1)<='\u1F7D')||(input.LA(1)>='\u1F80' && input.LA(1)<='\u1FB4')||(input.LA(1)>='\u1FB6' && input.LA(1)<='\u1FBC')||input.LA(1)=='\u1FBE'||(input.LA(1)>='\u1FC2' && input.LA(1)<='\u1FC4')||(input.LA(1)>='\u1FC6' && input.LA(1)<='\u1FCC')||(input.LA(1)>='\u1FD0' && input.LA(1)<='\u1FD3')||(input.LA(1)>='\u1FD6' && input.LA(1)<='\u1FDB')||(input.LA(1)>='\u1FE0' && input.LA(1)<='\u1FEC')||(input.LA(1)>='\u1FF2' && input.LA(1)<='\u1FF4')||(input.LA(1)>='\u1FF6' && input.LA(1)<='\u1FFC')||(input.LA(1)>='\u200C' && input.LA(1)<='\u200F')||(input.LA(1)>='\u202A' && input.LA(1)<='\u202E')||(input.LA(1)>='\u203F' && input.LA(1)<='\u2040')||input.LA(1)=='\u2054'||(input.LA(1)>='\u2060' && input.LA(1)<='\u2063')||(input.LA(1)>='\u206A' && input.LA(1)<='\u206F')||input.LA(1)=='\u2071'||input.LA(1)=='\u207F'||(input.LA(1)>='\u20A0' && input.LA(1)<='\u20B1')||(input.LA(1)>='\u20D0' && input.LA(1)<='\u20DC')||input.LA(1)=='\u20E1'||(input.LA(1)>='\u20E5' && input.LA(1)<='\u20EA')||input.LA(1)=='\u2102'||input.LA(1)=='\u2107'||(input.LA(1)>='\u210A' && input.LA(1)<='\u2113')||input.LA(1)=='\u2115'||(input.LA(1)>='\u2119' && input.LA(1)<='\u211D')||input.LA(1)=='\u2124'||input.LA(1)=='\u2126'||input.LA(1)=='\u2128'||(input.LA(1)>='\u212A' && input.LA(1)<='\u212D')||(input.LA(1)>='\u212F' && input.LA(1)<='\u2131')||(input.LA(1)>='\u2133' && input.LA(1)<='\u2139')||(input.LA(1)>='\u213D' && input.LA(1)<='\u213F')||(input.LA(1)>='\u2145' && input.LA(1)<='\u2149')||(input.LA(1)>='\u2160' && input.LA(1)<='\u2183')||(input.LA(1)>='\u3005' && input.LA(1)<='\u3007')||(input.LA(1)>='\u3021' && input.LA(1)<='\u302F')||(input.LA(1)>='\u3031' && input.LA(1)<='\u3035')||(input.LA(1)>='\u3038' && input.LA(1)<='\u303C')||(input.LA(1)>='\u3041' && input.LA(1)<='\u3096')||(input.LA(1)>='\u3099' && input.LA(1)<='\u309A')||(input.LA(1)>='\u309D' && input.LA(1)<='\u309F')||(input.LA(1)>='\u30A1' && input.LA(1)<='\u30FF')||(input.LA(1)>='\u3105' && input.LA(1)<='\u312C')||(input.LA(1)>='\u3131' && input.LA(1)<='\u318E')||(input.LA(1)>='\u31A0' && input.LA(1)<='\u31B7')||(input.LA(1)>='\u31F0' && input.LA(1)<='\u31FF')||(input.LA(1)>='\u3400' && input.LA(1)<='\u4DB5')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FA5')||(input.LA(1)>='\uA000' && input.LA(1)<='\uA48C')||(input.LA(1)>='\uAC00' && input.LA(1)<='\uD7A3')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFA2D')||(input.LA(1)>='\uFA30' && input.LA(1)<='\uFA6A')||(input.LA(1)>='\uFB00' && input.LA(1)<='\uFB06')||(input.LA(1)>='\uFB13' && input.LA(1)<='\uFB17')||(input.LA(1)>='\uFB1D' && input.LA(1)<='\uFB28')||(input.LA(1)>='\uFB2A' && input.LA(1)<='\uFB36')||(input.LA(1)>='\uFB38' && input.LA(1)<='\uFB3C')||input.LA(1)=='\uFB3E'||(input.LA(1)>='\uFB40' && input.LA(1)<='\uFB41')||(input.LA(1)>='\uFB43' && input.LA(1)<='\uFB44')||(input.LA(1)>='\uFB46' && input.LA(1)<='\uFBB1')||(input.LA(1)>='\uFBD3' && input.LA(1)<='\uFD3D')||(input.LA(1)>='\uFD50' && input.LA(1)<='\uFD8F')||(input.LA(1)>='\uFD92' && input.LA(1)<='\uFDC7')||(input.LA(1)>='\uFDF0' && input.LA(1)<='\uFDFC')||(input.LA(1)>='\uFE00' && input.LA(1)<='\uFE0F')||(input.LA(1)>='\uFE20' && input.LA(1)<='\uFE23')||(input.LA(1)>='\uFE33' && input.LA(1)<='\uFE34')||(input.LA(1)>='\uFE4D' && input.LA(1)<='\uFE4F')||input.LA(1)=='\uFE69'||(input.LA(1)>='\uFE70' && input.LA(1)<='\uFE74')||(input.LA(1)>='\uFE76' && input.LA(1)<='\uFEFC')||input.LA(1)=='\uFEFF'||input.LA(1)=='\uFF04'||(input.LA(1)>='\uFF10' && input.LA(1)<='\uFF19')||(input.LA(1)>='\uFF21' && input.LA(1)<='\uFF3A')||input.LA(1)=='\uFF3F'||(input.LA(1)>='\uFF41' && input.LA(1)<='\uFF5A')||(input.LA(1)>='\uFF65' && input.LA(1)<='\uFFBE')||(input.LA(1)>='\uFFC2' && input.LA(1)<='\uFFC7')||(input.LA(1)>='\uFFCA' && input.LA(1)<='\uFFCF')||(input.LA(1)>='\uFFD2' && input.LA(1)<='\uFFD7')||(input.LA(1)>='\uFFDA' && input.LA(1)<='\uFFDC')||(input.LA(1)>='\uFFE0' && input.LA(1)<='\uFFE1')||(input.LA(1)>='\uFFE5' && input.LA(1)<='\uFFE6')||(input.LA(1)>='\uFFF9' && input.LA(1)<='\uFFFB') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "IdentifierPart"

    public void mTokens() throws RecognitionException {
        // src/main/resources/org/drools/lang/dsl/DSLMap.g:1:8: ( WS | EOL | LEFT_SQUARE | RIGHT_SQUARE | LEFT_CURLY | RIGHT_CURLY | EQUALS | DOT | POUND | COLON | COMMA | LINE_COMMENT | LITERAL )
        int alt5=13;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // src/main/resources/org/drools/lang/dsl/DSLMap.g:1:10: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 2 :
                // src/main/resources/org/drools/lang/dsl/DSLMap.g:1:13: EOL
                {
                mEOL(); if (state.failed) return ;

                }
                break;
            case 3 :
                // src/main/resources/org/drools/lang/dsl/DSLMap.g:1:17: LEFT_SQUARE
                {
                mLEFT_SQUARE(); if (state.failed) return ;

                }
                break;
            case 4 :
                // src/main/resources/org/drools/lang/dsl/DSLMap.g:1:29: RIGHT_SQUARE
                {
                mRIGHT_SQUARE(); if (state.failed) return ;

                }
                break;
            case 5 :
                // src/main/resources/org/drools/lang/dsl/DSLMap.g:1:42: LEFT_CURLY
                {
                mLEFT_CURLY(); if (state.failed) return ;

                }
                break;
            case 6 :
                // src/main/resources/org/drools/lang/dsl/DSLMap.g:1:53: RIGHT_CURLY
                {
                mRIGHT_CURLY(); if (state.failed) return ;

                }
                break;
            case 7 :
                // src/main/resources/org/drools/lang/dsl/DSLMap.g:1:65: EQUALS
                {
                mEQUALS(); if (state.failed) return ;

                }
                break;
            case 8 :
                // src/main/resources/org/drools/lang/dsl/DSLMap.g:1:72: DOT
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 9 :
                // src/main/resources/org/drools/lang/dsl/DSLMap.g:1:76: POUND
                {
                mPOUND(); if (state.failed) return ;

                }
                break;
            case 10 :
                // src/main/resources/org/drools/lang/dsl/DSLMap.g:1:82: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 11 :
                // src/main/resources/org/drools/lang/dsl/DSLMap.g:1:88: COMMA
                {
                mCOMMA(); if (state.failed) return ;

                }
                break;
            case 12 :
                // src/main/resources/org/drools/lang/dsl/DSLMap.g:1:94: LINE_COMMENT
                {
                mLINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 13 :
                // src/main/resources/org/drools/lang/dsl/DSLMap.g:1:107: LITERAL
                {
                mLITERAL(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_DSLMap
    public final void synpred1_DSLMap_fragment() throws RecognitionException {   
        // src/main/resources/org/drools/lang/dsl/DSLMap.g:277:14: ( '\\r\\n' )
        // src/main/resources/org/drools/lang/dsl/DSLMap.g:277:16: '\\r\\n'
        {
        match("\r\n"); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred1_DSLMap

    public final boolean synpred1_DSLMap() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_DSLMap_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\10\uffff\1\15\1\16\1\uffff\1\20\5\uffff";
    static final String DFA5_eofS =
        "\21\uffff";
    static final String DFA5_minS =
        "\1\0\7\uffff\2\0\1\uffff\1\0\5\uffff";
    static final String DFA5_maxS =
        "\1\ufffb\7\uffff\1\ufffb\1\uffff\1\uffff\1\ufffb\5\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff\1\12\1\uffff\1\15"+
        "\1\10\1\11\1\14\1\13";
    static final String DFA5_specialS =
        "\11\uffff\1\0\7\uffff}>";
    static final String[] DFA5_transitionS = {
            "\11\14\1\1\1\2\1\uffff\1\1\1\2\16\14\4\uffff\1\1\2\14\1\11"+
            "\10\14\1\13\1\14\1\10\13\14\1\12\2\14\1\7\35\14\1\3\1\14\1\4"+
            "\2\14\1\uffff\32\14\1\5\1\14\1\6\1\uffff\41\14\2\uffff\4\14"+
            "\4\uffff\1\14\2\uffff\1\14\7\uffff\1\14\4\uffff\1\14\5\uffff"+
            "\27\14\1\uffff\37\14\1\uffff\u013f\14\31\uffff\162\14\4\uffff"+
            "\14\14\16\uffff\5\14\11\uffff\1\14\21\uffff\130\14\5\uffff\23"+
            "\14\12\uffff\1\14\13\uffff\1\14\1\uffff\3\14\1\uffff\1\14\1"+
            "\uffff\24\14\1\uffff\54\14\1\uffff\46\14\1\uffff\5\14\4\uffff"+
            "\u0082\14\1\uffff\4\14\3\uffff\105\14\1\uffff\46\14\2\uffff"+
            "\2\14\6\uffff\20\14\41\uffff\46\14\2\uffff\1\14\7\uffff\47\14"+
            "\11\uffff\21\14\1\uffff\27\14\1\uffff\3\14\1\uffff\1\14\1\uffff"+
            "\2\14\1\uffff\1\14\13\uffff\33\14\5\uffff\3\14\15\uffff\4\14"+
            "\14\uffff\6\14\13\uffff\32\14\5\uffff\31\14\7\uffff\12\14\4"+
            "\uffff\146\14\1\uffff\11\14\1\uffff\12\14\1\uffff\23\14\2\uffff"+
            "\1\14\17\uffff\74\14\2\uffff\3\14\60\uffff\62\14\u014f\uffff"+
            "\71\14\2\uffff\22\14\2\uffff\5\14\3\uffff\14\14\2\uffff\12\14"+
            "\21\uffff\3\14\1\uffff\10\14\2\uffff\2\14\2\uffff\26\14\1\uffff"+
            "\7\14\1\uffff\1\14\3\uffff\4\14\2\uffff\11\14\2\uffff\2\14\2"+
            "\uffff\3\14\11\uffff\1\14\4\uffff\2\14\1\uffff\5\14\2\uffff"+
            "\16\14\15\uffff\3\14\1\uffff\6\14\4\uffff\2\14\2\uffff\26\14"+
            "\1\uffff\7\14\1\uffff\2\14\1\uffff\2\14\1\uffff\2\14\2\uffff"+
            "\1\14\1\uffff\5\14\4\uffff\2\14\2\uffff\3\14\13\uffff\4\14\1"+
            "\uffff\1\14\7\uffff\17\14\14\uffff\3\14\1\uffff\11\14\1\uffff"+
            "\3\14\1\uffff\26\14\1\uffff\7\14\1\uffff\2\14\1\uffff\5\14\2"+
            "\uffff\12\14\1\uffff\3\14\1\uffff\3\14\2\uffff\1\14\17\uffff"+
            "\4\14\2\uffff\12\14\1\uffff\1\14\17\uffff\3\14\1\uffff\10\14"+
            "\2\uffff\2\14\2\uffff\26\14\1\uffff\7\14\1\uffff\2\14\1\uffff"+
            "\5\14\2\uffff\10\14\3\uffff\2\14\2\uffff\3\14\10\uffff\2\14"+
            "\4\uffff\2\14\1\uffff\3\14\4\uffff\12\14\1\uffff\1\14\20\uffff"+
            "\2\14\1\uffff\6\14\3\uffff\3\14\1\uffff\4\14\3\uffff\2\14\1"+
            "\uffff\1\14\1\uffff\2\14\3\uffff\2\14\3\uffff\3\14\3\uffff\10"+
            "\14\1\uffff\3\14\4\uffff\5\14\3\uffff\3\14\1\uffff\4\14\11\uffff"+
            "\1\14\17\uffff\11\14\11\uffff\1\14\7\uffff\3\14\1\uffff\10\14"+
            "\1\uffff\3\14\1\uffff\27\14\1\uffff\12\14\1\uffff\5\14\4\uffff"+
            "\7\14\1\uffff\3\14\1\uffff\4\14\7\uffff\2\14\11\uffff\2\14\4"+
            "\uffff\12\14\22\uffff\2\14\1\uffff\10\14\1\uffff\3\14\1\uffff"+
            "\27\14\1\uffff\12\14\1\uffff\5\14\2\uffff\11\14\1\uffff\3\14"+
            "\1\uffff\4\14\7\uffff\2\14\7\uffff\1\14\1\uffff\2\14\4\uffff"+
            "\12\14\22\uffff\2\14\1\uffff\10\14\1\uffff\3\14\1\uffff\27\14"+
            "\1\uffff\20\14\4\uffff\6\14\2\uffff\3\14\1\uffff\4\14\11\uffff"+
            "\1\14\10\uffff\2\14\4\uffff\12\14\22\uffff\2\14\1\uffff\22\14"+
            "\3\uffff\30\14\1\uffff\11\14\1\uffff\1\14\2\uffff\7\14\3\uffff"+
            "\1\14\4\uffff\6\14\1\uffff\1\14\1\uffff\10\14\22\uffff\2\14"+
            "\15\uffff\72\14\4\uffff\20\14\1\uffff\12\14\47\uffff\2\14\1"+
            "\uffff\1\14\2\uffff\2\14\1\uffff\1\14\2\uffff\1\14\6\uffff\4"+
            "\14\1\uffff\7\14\1\uffff\3\14\1\uffff\1\14\1\uffff\1\14\2\uffff"+
            "\2\14\1\uffff\15\14\1\uffff\3\14\2\uffff\5\14\1\uffff\1\14\1"+
            "\uffff\6\14\2\uffff\12\14\2\uffff\2\14\42\uffff\1\14\27\uffff"+
            "\2\14\6\uffff\12\14\13\uffff\1\14\1\uffff\1\14\1\uffff\1\14"+
            "\4\uffff\12\14\1\uffff\42\14\6\uffff\24\14\1\uffff\6\14\4\uffff"+
            "\10\14\1\uffff\44\14\11\uffff\1\14\71\uffff\42\14\1\uffff\5"+
            "\14\1\uffff\2\14\1\uffff\7\14\3\uffff\4\14\6\uffff\12\14\6\uffff"+
            "\12\14\106\uffff\46\14\12\uffff\51\14\7\uffff\132\14\5\uffff"+
            "\104\14\5\uffff\122\14\6\uffff\7\14\1\uffff\77\14\1\uffff\1"+
            "\14\1\uffff\4\14\2\uffff\7\14\1\uffff\1\14\1\uffff\4\14\2\uffff"+
            "\47\14\1\uffff\1\14\1\uffff\4\14\2\uffff\37\14\1\uffff\1\14"+
            "\1\uffff\4\14\2\uffff\7\14\1\uffff\1\14\1\uffff\4\14\2\uffff"+
            "\7\14\1\uffff\7\14\1\uffff\27\14\1\uffff\37\14\1\uffff\1\14"+
            "\1\uffff\4\14\2\uffff\7\14\1\uffff\47\14\1\uffff\23\14\16\uffff"+
            "\11\14\56\uffff\125\14\14\uffff\u026c\14\2\uffff\10\14\12\uffff"+
            "\32\14\5\uffff\113\14\3\uffff\3\14\17\uffff\15\14\1\uffff\7"+
            "\14\13\uffff\25\14\13\uffff\24\14\14\uffff\15\14\1\uffff\3\14"+
            "\1\uffff\2\14\14\uffff\124\14\3\uffff\1\14\3\uffff\3\14\2\uffff"+
            "\12\14\41\uffff\3\14\2\uffff\12\14\6\uffff\130\14\10\uffff\52"+
            "\14\126\uffff\35\14\3\uffff\14\14\4\uffff\14\14\12\uffff\50"+
            "\14\2\uffff\5\14\u038b\uffff\154\14\u0094\uffff\u009c\14\4\uffff"+
            "\132\14\6\uffff\26\14\2\uffff\6\14\2\uffff\46\14\2\uffff\6\14"+
            "\2\uffff\10\14\1\uffff\1\14\1\uffff\1\14\1\uffff\1\14\1\uffff"+
            "\37\14\2\uffff\65\14\1\uffff\7\14\1\uffff\1\14\3\uffff\3\14"+
            "\1\uffff\7\14\3\uffff\4\14\2\uffff\6\14\4\uffff\15\14\5\uffff"+
            "\3\14\1\uffff\7\14\17\uffff\4\14\32\uffff\5\14\20\uffff\2\14"+
            "\23\uffff\1\14\13\uffff\4\14\6\uffff\6\14\1\uffff\1\14\15\uffff"+
            "\1\14\40\uffff\22\14\36\uffff\15\14\4\uffff\1\14\3\uffff\6\14"+
            "\27\uffff\1\14\4\uffff\1\14\2\uffff\12\14\1\uffff\1\14\3\uffff"+
            "\5\14\6\uffff\1\14\1\uffff\1\14\1\uffff\1\14\1\uffff\4\14\1"+
            "\uffff\3\14\1\uffff\7\14\3\uffff\3\14\5\uffff\5\14\26\uffff"+
            "\44\14\u0e81\uffff\3\14\31\uffff\17\14\1\uffff\5\14\2\uffff"+
            "\5\14\4\uffff\126\14\2\uffff\2\14\2\uffff\3\14\1\uffff\137\14"+
            "\5\uffff\50\14\4\uffff\136\14\21\uffff\30\14\70\uffff\20\14"+
            "\u0200\uffff\u19b6\14\112\uffff\u51a6\14\132\uffff\u048d\14"+
            "\u0773\uffff\u2ba4\14\u215c\uffff\u012e\14\2\uffff\73\14\u0095"+
            "\uffff\7\14\14\uffff\5\14\5\uffff\14\14\1\uffff\15\14\1\uffff"+
            "\5\14\1\uffff\1\14\1\uffff\2\14\1\uffff\2\14\1\uffff\154\14"+
            "\41\uffff\u016b\14\22\uffff\100\14\2\uffff\66\14\50\uffff\15"+
            "\14\3\uffff\20\14\20\uffff\4\14\17\uffff\2\14\30\uffff\3\14"+
            "\31\uffff\1\14\6\uffff\5\14\1\uffff\u0087\14\2\uffff\1\14\4"+
            "\uffff\1\14\13\uffff\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff"+
            "\32\14\12\uffff\132\14\3\uffff\6\14\2\uffff\6\14\2\uffff\6\14"+
            "\2\uffff\3\14\3\uffff\2\14\3\uffff\2\14\22\uffff\3\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\11\14\5\uffff\16\14\5\uffff\2\14\1\uffff\26\14\1\uffff\2"+
            "\14\1\uffff\35\14\1\uffff\1\14\1\uffff\2\14\1\uffff\32\14\1"+
            "\uffff\1\14\2\uffff\41\14\2\uffff\4\14\4\uffff\1\14\2\uffff"+
            "\1\14\7\uffff\1\14\4\uffff\1\14\5\uffff\27\14\1\uffff\37\14"+
            "\1\uffff\u013f\14\31\uffff\162\14\4\uffff\14\14\16\uffff\5\14"+
            "\11\uffff\1\14\21\uffff\130\14\5\uffff\23\14\12\uffff\1\14\13"+
            "\uffff\1\14\1\uffff\3\14\1\uffff\1\14\1\uffff\24\14\1\uffff"+
            "\54\14\1\uffff\46\14\1\uffff\5\14\4\uffff\u0082\14\1\uffff\4"+
            "\14\3\uffff\105\14\1\uffff\46\14\2\uffff\2\14\6\uffff\20\14"+
            "\41\uffff\46\14\2\uffff\1\14\7\uffff\47\14\11\uffff\21\14\1"+
            "\uffff\27\14\1\uffff\3\14\1\uffff\1\14\1\uffff\2\14\1\uffff"+
            "\1\14\13\uffff\33\14\5\uffff\3\14\15\uffff\4\14\14\uffff\6\14"+
            "\13\uffff\32\14\5\uffff\31\14\7\uffff\12\14\4\uffff\146\14\1"+
            "\uffff\11\14\1\uffff\12\14\1\uffff\23\14\2\uffff\1\14\17\uffff"+
            "\74\14\2\uffff\3\14\60\uffff\62\14\u014f\uffff\71\14\2\uffff"+
            "\22\14\2\uffff\5\14\3\uffff\14\14\2\uffff\12\14\21\uffff\3\14"+
            "\1\uffff\10\14\2\uffff\2\14\2\uffff\26\14\1\uffff\7\14\1\uffff"+
            "\1\14\3\uffff\4\14\2\uffff\11\14\2\uffff\2\14\2\uffff\3\14\11"+
            "\uffff\1\14\4\uffff\2\14\1\uffff\5\14\2\uffff\16\14\15\uffff"+
            "\3\14\1\uffff\6\14\4\uffff\2\14\2\uffff\26\14\1\uffff\7\14\1"+
            "\uffff\2\14\1\uffff\2\14\1\uffff\2\14\2\uffff\1\14\1\uffff\5"+
            "\14\4\uffff\2\14\2\uffff\3\14\13\uffff\4\14\1\uffff\1\14\7\uffff"+
            "\17\14\14\uffff\3\14\1\uffff\11\14\1\uffff\3\14\1\uffff\26\14"+
            "\1\uffff\7\14\1\uffff\2\14\1\uffff\5\14\2\uffff\12\14\1\uffff"+
            "\3\14\1\uffff\3\14\2\uffff\1\14\17\uffff\4\14\2\uffff\12\14"+
            "\1\uffff\1\14\17\uffff\3\14\1\uffff\10\14\2\uffff\2\14\2\uffff"+
            "\26\14\1\uffff\7\14\1\uffff\2\14\1\uffff\5\14\2\uffff\10\14"+
            "\3\uffff\2\14\2\uffff\3\14\10\uffff\2\14\4\uffff\2\14\1\uffff"+
            "\3\14\4\uffff\12\14\1\uffff\1\14\20\uffff\2\14\1\uffff\6\14"+
            "\3\uffff\3\14\1\uffff\4\14\3\uffff\2\14\1\uffff\1\14\1\uffff"+
            "\2\14\3\uffff\2\14\3\uffff\3\14\3\uffff\10\14\1\uffff\3\14\4"+
            "\uffff\5\14\3\uffff\3\14\1\uffff\4\14\11\uffff\1\14\17\uffff"+
            "\11\14\11\uffff\1\14\7\uffff\3\14\1\uffff\10\14\1\uffff\3\14"+
            "\1\uffff\27\14\1\uffff\12\14\1\uffff\5\14\4\uffff\7\14\1\uffff"+
            "\3\14\1\uffff\4\14\7\uffff\2\14\11\uffff\2\14\4\uffff\12\14"+
            "\22\uffff\2\14\1\uffff\10\14\1\uffff\3\14\1\uffff\27\14\1\uffff"+
            "\12\14\1\uffff\5\14\2\uffff\11\14\1\uffff\3\14\1\uffff\4\14"+
            "\7\uffff\2\14\7\uffff\1\14\1\uffff\2\14\4\uffff\12\14\22\uffff"+
            "\2\14\1\uffff\10\14\1\uffff\3\14\1\uffff\27\14\1\uffff\20\14"+
            "\4\uffff\6\14\2\uffff\3\14\1\uffff\4\14\11\uffff\1\14\10\uffff"+
            "\2\14\4\uffff\12\14\22\uffff\2\14\1\uffff\22\14\3\uffff\30\14"+
            "\1\uffff\11\14\1\uffff\1\14\2\uffff\7\14\3\uffff\1\14\4\uffff"+
            "\6\14\1\uffff\1\14\1\uffff\10\14\22\uffff\2\14\15\uffff\72\14"+
            "\4\uffff\20\14\1\uffff\12\14\47\uffff\2\14\1\uffff\1\14\2\uffff"+
            "\2\14\1\uffff\1\14\2\uffff\1\14\6\uffff\4\14\1\uffff\7\14\1"+
            "\uffff\3\14\1\uffff\1\14\1\uffff\1\14\2\uffff\2\14\1\uffff\15"+
            "\14\1\uffff\3\14\2\uffff\5\14\1\uffff\1\14\1\uffff\6\14\2\uffff"+
            "\12\14\2\uffff\2\14\42\uffff\1\14\27\uffff\2\14\6\uffff\12\14"+
            "\13\uffff\1\14\1\uffff\1\14\1\uffff\1\14\4\uffff\12\14\1\uffff"+
            "\42\14\6\uffff\24\14\1\uffff\6\14\4\uffff\10\14\1\uffff\44\14"+
            "\11\uffff\1\14\71\uffff\42\14\1\uffff\5\14\1\uffff\2\14\1\uffff"+
            "\7\14\3\uffff\4\14\6\uffff\12\14\6\uffff\12\14\106\uffff\46"+
            "\14\12\uffff\51\14\7\uffff\132\14\5\uffff\104\14\5\uffff\122"+
            "\14\6\uffff\7\14\1\uffff\77\14\1\uffff\1\14\1\uffff\4\14\2\uffff"+
            "\7\14\1\uffff\1\14\1\uffff\4\14\2\uffff\47\14\1\uffff\1\14\1"+
            "\uffff\4\14\2\uffff\37\14\1\uffff\1\14\1\uffff\4\14\2\uffff"+
            "\7\14\1\uffff\1\14\1\uffff\4\14\2\uffff\7\14\1\uffff\7\14\1"+
            "\uffff\27\14\1\uffff\37\14\1\uffff\1\14\1\uffff\4\14\2\uffff"+
            "\7\14\1\uffff\47\14\1\uffff\23\14\16\uffff\11\14\56\uffff\125"+
            "\14\14\uffff\u026c\14\2\uffff\10\14\12\uffff\32\14\5\uffff\113"+
            "\14\3\uffff\3\14\17\uffff\15\14\1\uffff\7\14\13\uffff\25\14"+
            "\13\uffff\24\14\14\uffff\15\14\1\uffff\3\14\1\uffff\2\14\14"+
            "\uffff\124\14\3\uffff\1\14\3\uffff\3\14\2\uffff\12\14\41\uffff"+
            "\3\14\2\uffff\12\14\6\uffff\130\14\10\uffff\52\14\126\uffff"+
            "\35\14\3\uffff\14\14\4\uffff\14\14\12\uffff\50\14\2\uffff\5"+
            "\14\u038b\uffff\154\14\u0094\uffff\u009c\14\4\uffff\132\14\6"+
            "\uffff\26\14\2\uffff\6\14\2\uffff\46\14\2\uffff\6\14\2\uffff"+
            "\10\14\1\uffff\1\14\1\uffff\1\14\1\uffff\1\14\1\uffff\37\14"+
            "\2\uffff\65\14\1\uffff\7\14\1\uffff\1\14\3\uffff\3\14\1\uffff"+
            "\7\14\3\uffff\4\14\2\uffff\6\14\4\uffff\15\14\5\uffff\3\14\1"+
            "\uffff\7\14\17\uffff\4\14\32\uffff\5\14\20\uffff\2\14\23\uffff"+
            "\1\14\13\uffff\4\14\6\uffff\6\14\1\uffff\1\14\15\uffff\1\14"+
            "\40\uffff\22\14\36\uffff\15\14\4\uffff\1\14\3\uffff\6\14\27"+
            "\uffff\1\14\4\uffff\1\14\2\uffff\12\14\1\uffff\1\14\3\uffff"+
            "\5\14\6\uffff\1\14\1\uffff\1\14\1\uffff\1\14\1\uffff\4\14\1"+
            "\uffff\3\14\1\uffff\7\14\3\uffff\3\14\5\uffff\5\14\26\uffff"+
            "\44\14\u0e81\uffff\3\14\31\uffff\17\14\1\uffff\5\14\2\uffff"+
            "\5\14\4\uffff\126\14\2\uffff\2\14\2\uffff\3\14\1\uffff\137\14"+
            "\5\uffff\50\14\4\uffff\136\14\21\uffff\30\14\70\uffff\20\14"+
            "\u0200\uffff\u19b6\14\112\uffff\u51a6\14\132\uffff\u048d\14"+
            "\u0773\uffff\u2ba4\14\u215c\uffff\u012e\14\2\uffff\73\14\u0095"+
            "\uffff\7\14\14\uffff\5\14\5\uffff\14\14\1\uffff\15\14\1\uffff"+
            "\5\14\1\uffff\1\14\1\uffff\2\14\1\uffff\2\14\1\uffff\154\14"+
            "\41\uffff\u016b\14\22\uffff\100\14\2\uffff\66\14\50\uffff\15"+
            "\14\3\uffff\20\14\20\uffff\4\14\17\uffff\2\14\30\uffff\3\14"+
            "\31\uffff\1\14\6\uffff\5\14\1\uffff\u0087\14\2\uffff\1\14\4"+
            "\uffff\1\14\13\uffff\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff"+
            "\32\14\12\uffff\132\14\3\uffff\6\14\2\uffff\6\14\2\uffff\6\14"+
            "\2\uffff\3\14\3\uffff\2\14\3\uffff\2\14\22\uffff\3\14",
            "\0\17",
            "",
            "\11\14\5\uffff\16\14\5\uffff\2\14\1\uffff\26\14\1\uffff\2"+
            "\14\1\uffff\35\14\1\uffff\1\14\1\uffff\2\14\1\uffff\32\14\1"+
            "\uffff\1\14\2\uffff\41\14\2\uffff\4\14\4\uffff\1\14\2\uffff"+
            "\1\14\7\uffff\1\14\4\uffff\1\14\5\uffff\27\14\1\uffff\37\14"+
            "\1\uffff\u013f\14\31\uffff\162\14\4\uffff\14\14\16\uffff\5\14"+
            "\11\uffff\1\14\21\uffff\130\14\5\uffff\23\14\12\uffff\1\14\13"+
            "\uffff\1\14\1\uffff\3\14\1\uffff\1\14\1\uffff\24\14\1\uffff"+
            "\54\14\1\uffff\46\14\1\uffff\5\14\4\uffff\u0082\14\1\uffff\4"+
            "\14\3\uffff\105\14\1\uffff\46\14\2\uffff\2\14\6\uffff\20\14"+
            "\41\uffff\46\14\2\uffff\1\14\7\uffff\47\14\11\uffff\21\14\1"+
            "\uffff\27\14\1\uffff\3\14\1\uffff\1\14\1\uffff\2\14\1\uffff"+
            "\1\14\13\uffff\33\14\5\uffff\3\14\15\uffff\4\14\14\uffff\6\14"+
            "\13\uffff\32\14\5\uffff\31\14\7\uffff\12\14\4\uffff\146\14\1"+
            "\uffff\11\14\1\uffff\12\14\1\uffff\23\14\2\uffff\1\14\17\uffff"+
            "\74\14\2\uffff\3\14\60\uffff\62\14\u014f\uffff\71\14\2\uffff"+
            "\22\14\2\uffff\5\14\3\uffff\14\14\2\uffff\12\14\21\uffff\3\14"+
            "\1\uffff\10\14\2\uffff\2\14\2\uffff\26\14\1\uffff\7\14\1\uffff"+
            "\1\14\3\uffff\4\14\2\uffff\11\14\2\uffff\2\14\2\uffff\3\14\11"+
            "\uffff\1\14\4\uffff\2\14\1\uffff\5\14\2\uffff\16\14\15\uffff"+
            "\3\14\1\uffff\6\14\4\uffff\2\14\2\uffff\26\14\1\uffff\7\14\1"+
            "\uffff\2\14\1\uffff\2\14\1\uffff\2\14\2\uffff\1\14\1\uffff\5"+
            "\14\4\uffff\2\14\2\uffff\3\14\13\uffff\4\14\1\uffff\1\14\7\uffff"+
            "\17\14\14\uffff\3\14\1\uffff\11\14\1\uffff\3\14\1\uffff\26\14"+
            "\1\uffff\7\14\1\uffff\2\14\1\uffff\5\14\2\uffff\12\14\1\uffff"+
            "\3\14\1\uffff\3\14\2\uffff\1\14\17\uffff\4\14\2\uffff\12\14"+
            "\1\uffff\1\14\17\uffff\3\14\1\uffff\10\14\2\uffff\2\14\2\uffff"+
            "\26\14\1\uffff\7\14\1\uffff\2\14\1\uffff\5\14\2\uffff\10\14"+
            "\3\uffff\2\14\2\uffff\3\14\10\uffff\2\14\4\uffff\2\14\1\uffff"+
            "\3\14\4\uffff\12\14\1\uffff\1\14\20\uffff\2\14\1\uffff\6\14"+
            "\3\uffff\3\14\1\uffff\4\14\3\uffff\2\14\1\uffff\1\14\1\uffff"+
            "\2\14\3\uffff\2\14\3\uffff\3\14\3\uffff\10\14\1\uffff\3\14\4"+
            "\uffff\5\14\3\uffff\3\14\1\uffff\4\14\11\uffff\1\14\17\uffff"+
            "\11\14\11\uffff\1\14\7\uffff\3\14\1\uffff\10\14\1\uffff\3\14"+
            "\1\uffff\27\14\1\uffff\12\14\1\uffff\5\14\4\uffff\7\14\1\uffff"+
            "\3\14\1\uffff\4\14\7\uffff\2\14\11\uffff\2\14\4\uffff\12\14"+
            "\22\uffff\2\14\1\uffff\10\14\1\uffff\3\14\1\uffff\27\14\1\uffff"+
            "\12\14\1\uffff\5\14\2\uffff\11\14\1\uffff\3\14\1\uffff\4\14"+
            "\7\uffff\2\14\7\uffff\1\14\1\uffff\2\14\4\uffff\12\14\22\uffff"+
            "\2\14\1\uffff\10\14\1\uffff\3\14\1\uffff\27\14\1\uffff\20\14"+
            "\4\uffff\6\14\2\uffff\3\14\1\uffff\4\14\11\uffff\1\14\10\uffff"+
            "\2\14\4\uffff\12\14\22\uffff\2\14\1\uffff\22\14\3\uffff\30\14"+
            "\1\uffff\11\14\1\uffff\1\14\2\uffff\7\14\3\uffff\1\14\4\uffff"+
            "\6\14\1\uffff\1\14\1\uffff\10\14\22\uffff\2\14\15\uffff\72\14"+
            "\4\uffff\20\14\1\uffff\12\14\47\uffff\2\14\1\uffff\1\14\2\uffff"+
            "\2\14\1\uffff\1\14\2\uffff\1\14\6\uffff\4\14\1\uffff\7\14\1"+
            "\uffff\3\14\1\uffff\1\14\1\uffff\1\14\2\uffff\2\14\1\uffff\15"+
            "\14\1\uffff\3\14\2\uffff\5\14\1\uffff\1\14\1\uffff\6\14\2\uffff"+
            "\12\14\2\uffff\2\14\42\uffff\1\14\27\uffff\2\14\6\uffff\12\14"+
            "\13\uffff\1\14\1\uffff\1\14\1\uffff\1\14\4\uffff\12\14\1\uffff"+
            "\42\14\6\uffff\24\14\1\uffff\6\14\4\uffff\10\14\1\uffff\44\14"+
            "\11\uffff\1\14\71\uffff\42\14\1\uffff\5\14\1\uffff\2\14\1\uffff"+
            "\7\14\3\uffff\4\14\6\uffff\12\14\6\uffff\12\14\106\uffff\46"+
            "\14\12\uffff\51\14\7\uffff\132\14\5\uffff\104\14\5\uffff\122"+
            "\14\6\uffff\7\14\1\uffff\77\14\1\uffff\1\14\1\uffff\4\14\2\uffff"+
            "\7\14\1\uffff\1\14\1\uffff\4\14\2\uffff\47\14\1\uffff\1\14\1"+
            "\uffff\4\14\2\uffff\37\14\1\uffff\1\14\1\uffff\4\14\2\uffff"+
            "\7\14\1\uffff\1\14\1\uffff\4\14\2\uffff\7\14\1\uffff\7\14\1"+
            "\uffff\27\14\1\uffff\37\14\1\uffff\1\14\1\uffff\4\14\2\uffff"+
            "\7\14\1\uffff\47\14\1\uffff\23\14\16\uffff\11\14\56\uffff\125"+
            "\14\14\uffff\u026c\14\2\uffff\10\14\12\uffff\32\14\5\uffff\113"+
            "\14\3\uffff\3\14\17\uffff\15\14\1\uffff\7\14\13\uffff\25\14"+
            "\13\uffff\24\14\14\uffff\15\14\1\uffff\3\14\1\uffff\2\14\14"+
            "\uffff\124\14\3\uffff\1\14\3\uffff\3\14\2\uffff\12\14\41\uffff"+
            "\3\14\2\uffff\12\14\6\uffff\130\14\10\uffff\52\14\126\uffff"+
            "\35\14\3\uffff\14\14\4\uffff\14\14\12\uffff\50\14\2\uffff\5"+
            "\14\u038b\uffff\154\14\u0094\uffff\u009c\14\4\uffff\132\14\6"+
            "\uffff\26\14\2\uffff\6\14\2\uffff\46\14\2\uffff\6\14\2\uffff"+
            "\10\14\1\uffff\1\14\1\uffff\1\14\1\uffff\1\14\1\uffff\37\14"+
            "\2\uffff\65\14\1\uffff\7\14\1\uffff\1\14\3\uffff\3\14\1\uffff"+
            "\7\14\3\uffff\4\14\2\uffff\6\14\4\uffff\15\14\5\uffff\3\14\1"+
            "\uffff\7\14\17\uffff\4\14\32\uffff\5\14\20\uffff\2\14\23\uffff"+
            "\1\14\13\uffff\4\14\6\uffff\6\14\1\uffff\1\14\15\uffff\1\14"+
            "\40\uffff\22\14\36\uffff\15\14\4\uffff\1\14\3\uffff\6\14\27"+
            "\uffff\1\14\4\uffff\1\14\2\uffff\12\14\1\uffff\1\14\3\uffff"+
            "\5\14\6\uffff\1\14\1\uffff\1\14\1\uffff\1\14\1\uffff\4\14\1"+
            "\uffff\3\14\1\uffff\7\14\3\uffff\3\14\5\uffff\5\14\26\uffff"+
            "\44\14\u0e81\uffff\3\14\31\uffff\17\14\1\uffff\5\14\2\uffff"+
            "\5\14\4\uffff\126\14\2\uffff\2\14\2\uffff\3\14\1\uffff\137\14"+
            "\5\uffff\50\14\4\uffff\136\14\21\uffff\30\14\70\uffff\20\14"+
            "\u0200\uffff\u19b6\14\112\uffff\u51a6\14\132\uffff\u048d\14"+
            "\u0773\uffff\u2ba4\14\u215c\uffff\u012e\14\2\uffff\73\14\u0095"+
            "\uffff\7\14\14\uffff\5\14\5\uffff\14\14\1\uffff\15\14\1\uffff"+
            "\5\14\1\uffff\1\14\1\uffff\2\14\1\uffff\2\14\1\uffff\154\14"+
            "\41\uffff\u016b\14\22\uffff\100\14\2\uffff\66\14\50\uffff\15"+
            "\14\3\uffff\20\14\20\uffff\4\14\17\uffff\2\14\30\uffff\3\14"+
            "\31\uffff\1\14\6\uffff\5\14\1\uffff\u0087\14\2\uffff\1\14\4"+
            "\uffff\1\14\13\uffff\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff"+
            "\32\14\12\uffff\132\14\3\uffff\6\14\2\uffff\6\14\2\uffff\6\14"+
            "\2\uffff\3\14\3\uffff\2\14\3\uffff\2\14\22\uffff\3\14",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( WS | EOL | LEFT_SQUARE | RIGHT_SQUARE | LEFT_CURLY | RIGHT_CURLY | EQUALS | DOT | POUND | COLON | COMMA | LINE_COMMENT | LITERAL );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_9 = input.LA(1);

                        s = -1;
                        if ( ((LA5_9>='\u0000' && LA5_9<='\uFFFF')) ) {s = 15;}

                        else s = 14;

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}