/*
 * Copyright [2013] [Cloud4SOA, www.cloud4soa.eu]
 *
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package eu.cloud4soa.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDslLexer extends Lexer {
    public static final int RULE_ID=7;
    public static final int T__66=66;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__65=65;
    public static final int T__27=27;
    public static final int T__62=62;
    public static final int T__26=26;
    public static final int T__63=63;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int RULE_NATURAL_NUMBER=6;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=8;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_DATE_US=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=4;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=11;

    // delegates
    // delegators

    public InternalDslLexer() {;} 
    public InternalDslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalDslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:11:7: ( 'profile' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:11:9: 'profile'
            {
            match("profile"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:12:7: ( '{' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:12:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:13:7: ( '}' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:13:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:14:7: ( 'developer' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:14:9: 'developer'
            {
            match("developer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:15:7: ( 'provider' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:15:9: 'provider'
            {
            match("provider"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:16:7: ( ':' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:16:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:17:7: ( 'firstname' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:17:9: 'firstname'
            {
            match("firstname"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:18:7: ( 'surname' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:18:9: 'surname'
            {
            match("surname"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:19:7: ( 'email' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:19:9: 'email'
            {
            match("email"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:20:7: ( 'birthday' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:20:9: 'birthday'
            {
            match("birthday"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:21:7: ( 'username' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:21:9: 'username'
            {
            match("username"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:22:7: ( 'password' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:22:9: 'password'
            {
            match("password"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:23:7: ( 'url' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:23:9: 'url'
            {
            match("url"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:24:7: ( 'application' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:24:9: 'application'
            {
            match("application"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:25:7: ( 'application_code' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:25:9: 'application_code'
            {
            match("application_code"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:26:7: ( 'paas_offering' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:26:9: 'paas_offering'
            {
            match("paas_offering"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:27:7: ( 'file_name' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:27:9: 'file_name'
            {
            match("file_name"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:28:7: ( 'size' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:28:9: 'size'
            {
            match("size"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:29:7: ( 'digest' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:29:9: 'digest'
            {
            match("digest"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:30:7: ( 'programming_language' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:30:9: 'programming_language'
            {
            match("programming_language"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:31:7: ( 'software' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:31:9: 'software'
            {
            match("software"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:32:7: ( 'category' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:32:9: 'category'
            {
            match("category"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:33:7: ( 'component' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:33:9: 'component'
            {
            match("component"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:34:7: ( 'description' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:34:9: 'description'
            {
            match("description"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:35:7: ( 'license' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:35:9: 'license'
            {
            match("license"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:36:7: ( 'GPL' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:36:9: 'GPL'
            {
            match("GPL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:37:7: ( 'LGPL' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:37:9: 'LGPL'
            {
            match("LGPL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:38:7: ( 'BSD' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:38:9: 'BSD'
            {
            match("BSD"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:39:7: ( 'MIT' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:39:9: 'MIT'
            {
            match("MIT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:40:7: ( 'hardware' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:40:9: 'hardware'
            {
            match("hardware"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:41:7: ( 'box' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:41:9: 'box'
            {
            match("box"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:42:7: ( 'http_requests' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:42:9: 'http_requests'
            {
            match("http_requests"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:43:7: ( 'compute' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:43:9: 'compute'
            {
            match("compute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:44:7: ( 'architecture' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:44:9: 'architecture'
            {
            match("architecture"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:45:7: ( 'x86' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:45:9: 'x86'
            {
            match("x86"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:46:7: ( 'x64' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:46:9: 'x64'
            {
            match("x64"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:47:7: ( 'cores' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:47:9: 'cores'
            {
            match("cores"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:48:7: ( 'speed' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:48:9: 'speed'
            {
            match("speed"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:49:7: ( 'memory' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:49:9: 'memory'
            {
            match("memory"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:50:7: ( 'cache' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:50:9: 'cache'
            {
            match("cache"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:51:7: ( 'network_resource' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:51:9: 'network_resource'
            {
            match("network_resource"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:52:7: ( 'bandwidth' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:52:9: 'bandwidth'
            {
            match("bandwidth"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:53:7: ( 'latency' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:53:9: 'latency'
            {
            match("latency"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:54:7: ( 'storage_resource' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:54:9: 'storage_resource'
            {
            match("storage_resource"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:55:7: ( 'capacity' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:55:9: 'capacity'
            {
            match("capacity"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:56:7: ( 'channels' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:56:9: 'channels'
            {
            match("channels"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:57:7: ( 'api' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:57:9: 'api'
            {
            match("api"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:58:7: ( 'cli' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:58:9: 'cli'
            {
            match("cli"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:59:7: ( 'web_interface' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:59:9: 'web_interface'
            {
            match("web_interface"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:60:7: ( 'operation' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:60:9: 'operation'
            {
            match("operation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:61:7: ( 'command' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:61:9: 'command'
            {
            match("command"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:62:7: ( 'information_returned' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:62:9: 'information_returned'
            {
            match("information_returned"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:63:7: ( 'version' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:63:9: 'version'
            {
            match("version"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:64:7: ( '.' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:64:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "RULE_NATURAL_NUMBER"
    public final void mRULE_NATURAL_NUMBER() throws RecognitionException {
        try {
            int _type = RULE_NATURAL_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3020:21: ( ( '0' .. '9' | '1' .. '9' ( '0' .. '9' )+ ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3020:23: ( '0' .. '9' | '1' .. '9' ( '0' .. '9' )+ )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3020:23: ( '0' .. '9' | '1' .. '9' ( '0' .. '9' )+ )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>='1' && LA2_0<='9')) ) {
                int LA2_1 = input.LA(2);

                if ( ((LA2_1>='0' && LA2_1<='9')) ) {
                    alt2=2;
                }
                else {
                    alt2=1;}
            }
            else if ( (LA2_0=='0') ) {
                alt2=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3020:24: '0' .. '9'
                    {
                    matchRange('0','9'); 

                    }
                    break;
                case 2 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3020:33: '1' .. '9' ( '0' .. '9' )+
                    {
                    matchRange('1','9'); 
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3020:42: ( '0' .. '9' )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3020:43: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


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
    // $ANTLR end "RULE_NATURAL_NUMBER"

    // $ANTLR start "RULE_DATE_US"
    public final void mRULE_DATE_US() throws RecognitionException {
        try {
            int _type = RULE_DATE_US;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3022:14: ( '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '-' '0' .. '9' '0' .. '9' '-' '0' .. '9' '0' .. '9' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3022:16: '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '-' '0' .. '9' '0' .. '9' '-' '0' .. '9' '0' .. '9'
            {
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            match('-'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            match('-'); 
            matchRange('0','9'); 
            matchRange('0','9'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DATE_US"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3024:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3024:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3024:11: ( '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='^') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3024:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3024:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3026:10: ( ( '0' .. '9' )+ )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3026:12: ( '0' .. '9' )+
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3026:12: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3026:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3028:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3028:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3028:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\'') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3028:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3028:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3028:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3028:66: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3028:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3028:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3028:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3028:137: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('\''); 

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
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3030:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3030:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3030:24: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3030:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3032:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3032:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3032:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3032:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3032:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3032:41: ( '\\r' )? '\\n'
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3032:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3032:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

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
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3034:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3034:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3034:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3036:16: ( . )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3036:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | RULE_NATURAL_NUMBER | RULE_DATE_US | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=63;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:238: T__51
                {
                mT__51(); 

                }
                break;
            case 40 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:244: T__52
                {
                mT__52(); 

                }
                break;
            case 41 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:250: T__53
                {
                mT__53(); 

                }
                break;
            case 42 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:256: T__54
                {
                mT__54(); 

                }
                break;
            case 43 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:262: T__55
                {
                mT__55(); 

                }
                break;
            case 44 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:268: T__56
                {
                mT__56(); 

                }
                break;
            case 45 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:274: T__57
                {
                mT__57(); 

                }
                break;
            case 46 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:280: T__58
                {
                mT__58(); 

                }
                break;
            case 47 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:286: T__59
                {
                mT__59(); 

                }
                break;
            case 48 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:292: T__60
                {
                mT__60(); 

                }
                break;
            case 49 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:298: T__61
                {
                mT__61(); 

                }
                break;
            case 50 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:304: T__62
                {
                mT__62(); 

                }
                break;
            case 51 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:310: T__63
                {
                mT__63(); 

                }
                break;
            case 52 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:316: T__64
                {
                mT__64(); 

                }
                break;
            case 53 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:322: T__65
                {
                mT__65(); 

                }
                break;
            case 54 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:328: T__66
                {
                mT__66(); 

                }
                break;
            case 55 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:334: RULE_NATURAL_NUMBER
                {
                mRULE_NATURAL_NUMBER(); 

                }
                break;
            case 56 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:354: RULE_DATE_US
                {
                mRULE_DATE_US(); 

                }
                break;
            case 57 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:367: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 58 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:375: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 59 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:384: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 60 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:396: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 61 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:412: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 62 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:428: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 63 :
                // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1:436: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\1\46\2\uffff\1\46\1\uffff\24\46\1\uffff\2\120\1\43\1\uffff"+
        "\3\43\2\uffff\2\46\3\uffff\2\46\1\uffff\42\46\1\uffff\1\120\1\uffff"+
        "\1\u0085\4\uffff\17\46\1\u0097\2\46\1\u009a\1\46\1\u009c\7\46\1"+
        "\u00a5\2\46\1\u00a8\1\46\1\u00aa\1\u00ab\2\46\1\u00ae\1\u00af\6"+
        "\46\1\120\1\u0085\1\uffff\13\46\1\u00c3\5\46\1\uffff\2\46\1\uffff"+
        "\1\46\1\uffff\10\46\1\uffff\2\46\1\uffff\1\u00d7\2\uffff\2\46\2"+
        "\uffff\6\46\1\120\1\u0085\13\46\1\uffff\1\46\1\u00ee\1\46\1\u00f0"+
        "\6\46\1\u00f7\4\46\1\u00fc\3\46\1\uffff\10\46\1\uffff\1\120\7\46"+
        "\1\u010f\4\46\1\uffff\1\46\1\uffff\6\46\1\uffff\4\46\1\uffff\5\46"+
        "\1\u0124\5\46\1\u012a\6\46\1\uffff\2\46\1\u0133\12\46\1\u013e\1"+
        "\u013f\1\46\1\u0141\1\u0142\2\46\1\uffff\4\46\1\u0149\1\uffff\1"+
        "\u014a\1\46\1\u014c\5\46\1\uffff\1\u0152\1\46\1\u0154\1\46\1\u0156"+
        "\2\46\1\u0159\1\u015a\1\46\2\uffff\1\u015c\2\uffff\1\u015d\5\46"+
        "\2\uffff\1\46\1\uffff\1\46\1\u0165\1\46\1\u0167\1\u0168\1\uffff"+
        "\1\46\1\uffff\1\u016a\1\uffff\2\46\2\uffff\1\u016d\2\uffff\3\46"+
        "\1\u0171\3\46\1\uffff\1\46\2\uffff\1\46\1\uffff\2\46\1\uffff\3\46"+
        "\1\uffff\3\46\1\u017f\1\46\1\u0182\7\46\1\uffff\2\46\1\uffff\1\u018c"+
        "\5\46\1\u0192\2\46\1\uffff\1\u0195\1\46\1\u0197\2\46\1\uffff\2\46"+
        "\1\uffff\1\46\1\uffff\7\46\1\u01a4\1\u01a5\1\u01a6\2\46\3\uffff"+
        "\5\46\1\u01ae\1\u01af\2\uffff";
    static final String DFA14_eofS =
        "\u01b0\uffff";
    static final String DFA14_minS =
        "\1\0\1\141\2\uffff\1\145\1\uffff\2\151\1\155\1\141\1\162\1\160\2"+
        "\141\1\120\1\107\1\123\1\111\1\141\1\66\3\145\1\160\1\156\1\145"+
        "\1\uffff\2\60\1\101\1\uffff\2\0\1\52\2\uffff\1\157\1\141\3\uffff"+
        "\1\163\1\147\1\uffff\1\154\1\162\1\172\1\146\1\145\1\157\1\141\1"+
        "\162\1\170\1\156\1\145\1\154\1\151\2\143\1\155\1\141\1\151\1\143"+
        "\1\164\1\114\1\120\1\104\1\124\1\162\1\164\1\66\1\64\1\155\1\164"+
        "\1\142\1\145\1\146\1\162\1\uffff\1\60\1\uffff\1\60\4\uffff\1\146"+
        "\2\163\1\145\1\143\1\145\1\163\1\145\1\156\1\145\1\164\1\145\1\162"+
        "\1\151\1\164\1\60\1\144\1\162\1\60\1\154\1\60\1\150\1\145\1\150"+
        "\1\141\1\155\1\145\1\156\1\60\2\145\1\60\1\114\2\60\1\144\1\160"+
        "\2\60\1\157\1\167\1\137\1\162\1\157\1\163\2\60\1\uffff\2\151\1\162"+
        "\1\167\1\137\1\154\1\162\1\163\1\164\1\137\1\141\1\60\1\167\1\144"+
        "\1\141\1\154\1\150\1\uffff\1\167\1\156\1\uffff\1\151\1\uffff\1\151"+
        "\1\147\1\145\1\143\1\157\1\141\1\163\1\156\1\uffff\2\156\1\uffff"+
        "\1\60\2\uffff\1\167\1\137\2\uffff\1\162\1\157\1\151\1\141\1\162"+
        "\1\151\2\55\1\154\1\144\1\141\3\157\1\151\1\164\2\156\1\155\1\uffff"+
        "\1\141\1\60\1\147\1\60\1\144\1\151\1\141\1\143\1\164\1\157\1\60"+
        "\1\151\1\156\1\164\1\156\1\60\1\145\1\163\1\143\1\uffff\1\141\1"+
        "\162\1\171\1\162\1\156\1\164\1\155\1\157\1\uffff\1\60\2\145\1\155"+
        "\1\162\1\146\2\160\1\60\2\141\1\145\1\162\1\uffff\1\145\1\uffff"+
        "\1\141\1\144\1\155\1\141\1\145\1\162\1\uffff\1\164\2\145\1\144\1"+
        "\uffff\1\154\1\145\1\171\1\162\1\145\1\60\1\153\1\164\1\151\1\141"+
        "\1\156\1\60\1\162\1\155\1\144\1\146\1\145\1\164\1\uffff\2\155\1"+
        "\60\1\145\1\137\1\171\1\164\1\145\1\164\1\143\2\171\1\156\2\60\1"+
        "\163\2\60\1\145\1\161\1\uffff\1\137\1\145\1\157\1\164\1\60\1\uffff"+
        "\1\60\1\151\1\60\1\145\1\162\1\151\2\145\1\uffff\1\60\1\162\1\60"+
        "\1\150\1\60\1\151\1\164\2\60\1\164\2\uffff\1\60\2\uffff\1\60\1\165"+
        "\2\162\1\156\1\151\2\uffff\1\156\1\uffff\1\162\1\60\1\157\2\60\1"+
        "\uffff\1\145\1\uffff\1\60\1\uffff\1\157\1\165\2\uffff\1\60\2\uffff"+
        "\2\145\1\146\1\60\1\157\1\147\1\151\1\uffff\1\156\2\uffff\1\163"+
        "\1\uffff\1\156\1\162\1\uffff\2\163\1\141\1\uffff\1\156\1\137\1\156"+
        "\1\60\1\157\1\60\1\145\1\164\1\157\1\143\1\137\1\154\1\147\1\uffff"+
        "\1\165\1\143\1\uffff\1\60\1\163\1\165\1\145\1\162\1\141\1\60\1\162"+
        "\1\157\1\uffff\1\60\1\162\1\60\1\145\1\156\1\uffff\1\143\1\144\1"+
        "\uffff\1\143\1\uffff\1\164\1\147\3\145\2\165\3\60\1\162\1\141\3"+
        "\uffff\1\156\1\147\2\145\1\144\2\60\2\uffff";
    static final String DFA14_maxS =
        "\1\uffff\1\162\2\uffff\1\151\1\uffff\1\151\1\165\1\155\1\157\1\163"+
        "\1\162\1\157\1\151\1\120\1\107\1\123\1\111\1\164\1\70\3\145\1\160"+
        "\1\156\1\145\1\uffff\2\71\1\172\1\uffff\2\uffff\1\57\2\uffff\1\157"+
        "\1\163\3\uffff\1\166\1\147\1\uffff\2\162\1\172\1\146\1\145\1\157"+
        "\1\141\1\162\1\170\1\156\1\145\1\154\1\160\1\143\1\164\1\162\1\141"+
        "\1\151\1\143\1\164\1\114\1\120\1\104\1\124\1\162\1\164\1\66\1\64"+
        "\1\155\1\164\1\142\1\145\1\146\1\162\1\uffff\1\71\1\uffff\1\71\4"+
        "\uffff\1\166\2\163\1\145\1\143\1\145\1\163\1\145\1\156\1\145\1\164"+
        "\1\145\1\162\1\151\1\164\1\172\1\144\1\162\1\172\1\154\1\172\1\150"+
        "\1\145\1\150\1\141\1\160\1\145\1\156\1\172\2\145\1\172\1\114\2\172"+
        "\1\144\1\160\2\172\1\157\1\167\1\137\1\162\1\157\1\163\2\71\1\uffff"+
        "\2\151\1\162\1\167\1\137\1\154\1\162\1\163\1\164\1\137\1\141\1\172"+
        "\1\167\1\144\1\141\1\154\1\150\1\uffff\1\167\1\156\1\uffff\1\151"+
        "\1\uffff\1\151\1\147\1\145\1\143\1\165\1\141\1\163\1\156\1\uffff"+
        "\2\156\1\uffff\1\172\2\uffff\1\167\1\137\2\uffff\1\162\1\157\1\151"+
        "\1\141\1\162\1\151\1\71\1\55\1\154\1\144\1\141\3\157\1\151\1\164"+
        "\2\156\1\155\1\uffff\1\141\1\172\1\147\1\172\1\144\1\151\1\141\1"+
        "\143\1\164\1\157\1\172\1\151\1\156\1\164\1\156\1\172\1\145\1\163"+
        "\1\143\1\uffff\1\141\1\162\1\171\1\162\1\156\1\164\1\155\1\157\1"+
        "\uffff\1\71\2\145\1\155\1\162\1\146\2\160\1\172\2\141\1\145\1\162"+
        "\1\uffff\1\145\1\uffff\1\141\1\144\1\155\1\141\1\145\1\162\1\uffff"+
        "\1\164\2\145\1\144\1\uffff\1\154\1\145\1\171\1\162\1\145\1\172\1"+
        "\153\1\164\1\151\1\141\1\156\1\172\1\162\1\155\1\144\1\146\1\145"+
        "\1\164\1\uffff\2\155\1\172\1\145\1\137\1\171\1\164\1\145\1\164\1"+
        "\143\2\171\1\156\2\172\1\163\2\172\1\145\1\161\1\uffff\1\137\1\145"+
        "\1\157\1\164\1\172\1\uffff\1\172\1\151\1\172\1\145\1\162\1\151\2"+
        "\145\1\uffff\1\172\1\162\1\172\1\150\1\172\1\151\1\164\2\172\1\164"+
        "\2\uffff\1\172\2\uffff\1\172\1\165\2\162\1\156\1\151\2\uffff\1\156"+
        "\1\uffff\1\162\1\172\1\157\2\172\1\uffff\1\145\1\uffff\1\172\1\uffff"+
        "\1\157\1\165\2\uffff\1\172\2\uffff\2\145\1\146\1\172\1\157\1\147"+
        "\1\151\1\uffff\1\156\2\uffff\1\163\1\uffff\1\156\1\162\1\uffff\2"+
        "\163\1\141\1\uffff\1\156\1\137\1\156\1\172\1\157\1\172\1\145\1\164"+
        "\1\157\1\143\1\137\1\154\1\147\1\uffff\1\165\1\143\1\uffff\1\172"+
        "\1\163\1\165\1\145\1\162\1\141\1\172\1\162\1\157\1\uffff\1\172\1"+
        "\162\1\172\1\145\1\156\1\uffff\1\143\1\144\1\uffff\1\143\1\uffff"+
        "\1\164\1\147\3\145\2\165\3\172\1\162\1\141\3\uffff\1\156\1\147\2"+
        "\145\1\144\2\172\2\uffff";
    static final String DFA14_acceptS =
        "\2\uffff\1\2\1\3\1\uffff\1\6\24\uffff\1\66\3\uffff\1\71\3\uffff"+
        "\1\76\1\77\2\uffff\1\71\1\2\1\3\2\uffff\1\6\42\uffff\1\66\1\uffff"+
        "\1\67\1\uffff\1\73\1\74\1\75\1\76\57\uffff\1\72\21\uffff\1\37\2"+
        "\uffff\1\15\1\uffff\1\57\10\uffff\1\60\2\uffff\1\32\1\uffff\1\34"+
        "\1\35\2\uffff\1\43\1\44\23\uffff\1\22\23\uffff\1\33\10\uffff\1\70"+
        "\15\uffff\1\46\1\uffff\1\11\6\uffff\1\50\4\uffff\1\45\22\uffff\1"+
        "\23\24\uffff\1\47\5\uffff\1\1\10\uffff\1\10\12\uffff\1\41\1\63\1"+
        "\uffff\1\31\1\53\6\uffff\1\65\1\5\1\uffff\1\14\5\uffff\1\25\1\uffff"+
        "\1\12\1\uffff\1\13\2\uffff\1\26\1\55\1\uffff\1\56\1\36\7\uffff\1"+
        "\4\1\uffff\1\7\1\21\1\uffff\1\52\2\uffff\1\27\3\uffff\1\62\15\uffff"+
        "\1\30\2\uffff\1\16\11\uffff\1\42\5\uffff\1\20\2\uffff\1\40\1\uffff"+
        "\1\61\14\uffff\1\54\1\17\1\51\7\uffff\1\24\1\64";
    static final String DFA14_specialS =
        "\1\0\36\uffff\1\1\1\2\u018f\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\43\2\42\2\43\1\42\22\43\1\42\1\43\1\37\4\43\1\40\6\43\1"+
            "\32\1\41\1\34\11\33\1\5\6\43\1\36\1\20\4\36\1\16\4\36\1\17\1"+
            "\21\15\36\3\43\1\35\1\36\1\43\1\13\1\11\1\14\1\4\1\10\1\6\1"+
            "\36\1\22\1\30\2\36\1\15\1\24\1\25\1\27\1\1\2\36\1\7\1\36\1\12"+
            "\1\31\1\26\1\23\2\36\1\2\1\43\1\3\uff82\43",
            "\1\45\20\uffff\1\44",
            "",
            "",
            "\1\51\3\uffff\1\52",
            "",
            "\1\54",
            "\1\56\5\uffff\1\57\1\60\3\uffff\1\61\1\55",
            "\1\62",
            "\1\65\7\uffff\1\63\5\uffff\1\64",
            "\1\67\1\66",
            "\1\70\1\uffff\1\71",
            "\1\72\6\uffff\1\74\3\uffff\1\75\2\uffff\1\73",
            "\1\77\7\uffff\1\76",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104\22\uffff\1\105",
            "\1\107\1\uffff\1\106",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "",
            "\12\117",
            "\12\121",
            "\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\0\122",
            "\0\122",
            "\1\123\4\uffff\1\124",
            "",
            "",
            "\1\126",
            "\1\130\21\uffff\1\127",
            "",
            "",
            "",
            "\1\132\2\uffff\1\131",
            "\1\133",
            "",
            "\1\135\5\uffff\1\134",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\152\6\uffff\1\151",
            "\1\153",
            "\1\155\14\uffff\1\156\3\uffff\1\154",
            "\1\157\4\uffff\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "",
            "\12\u0083",
            "",
            "\12\u0084",
            "",
            "",
            "",
            "",
            "\1\u0086\1\u0088\16\uffff\1\u0087",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0098",
            "\1\u0099",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u009b",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a2\2\uffff\1\u00a1",
            "\1\u00a3",
            "\1\u00a4",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00a6",
            "\1\u00a7",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00a9",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00ac",
            "\1\u00ad",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\12\u00b6",
            "\12\u00b7",
            "",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "",
            "\1\u00c9",
            "\1\u00ca",
            "",
            "\1\u00cb",
            "",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0\5\uffff\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "",
            "\1\u00d5",
            "\1\u00d6",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "\1\u00d8",
            "\1\u00d9",
            "",
            "",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0\2\uffff\12\u00e1",
            "\1\u00e0",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "",
            "\1\u00ed",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00ef",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "",
            "\12\u00e1",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "",
            "\1\u0114",
            "",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "",
            "\1\u0131",
            "\1\u0132",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0140",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0143",
            "\1\u0144",
            "",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u014b",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u014d",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0153",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0155",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0157",
            "\1\u0158",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u015b",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u015e",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "",
            "",
            "\1\u0163",
            "",
            "\1\u0164",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0166",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\1\u0169",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\1\u016b",
            "\1\u016c",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "\1\u016e",
            "\1\u016f",
            "\1\u0170",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0172",
            "\1\u0173",
            "\1\u0174",
            "",
            "\1\u0175",
            "",
            "",
            "\1\u0176",
            "",
            "\1\u0177",
            "\1\u0178",
            "",
            "\1\u0179",
            "\1\u017a",
            "\1\u017b",
            "",
            "\1\u017c",
            "\1\u017d",
            "\1\u017e",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0180",
            "\12\46\7\uffff\32\46\4\uffff\1\u0181\1\uffff\32\46",
            "\1\u0183",
            "\1\u0184",
            "\1\u0185",
            "\1\u0186",
            "\1\u0187",
            "\1\u0188",
            "\1\u0189",
            "",
            "\1\u018a",
            "\1\u018b",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u018d",
            "\1\u018e",
            "\1\u018f",
            "\1\u0190",
            "\1\u0191",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0193",
            "\1\u0194",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0196",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0198",
            "\1\u0199",
            "",
            "\1\u019a",
            "\1\u019b",
            "",
            "\1\u019c",
            "",
            "\1\u019d",
            "\1\u019e",
            "\1\u019f",
            "\1\u01a0",
            "\1\u01a1",
            "\1\u01a2",
            "\1\u01a3",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u01a7",
            "\1\u01a8",
            "",
            "",
            "",
            "\1\u01a9",
            "\1\u01aa",
            "\1\u01ab",
            "\1\u01ac",
            "\1\u01ad",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | RULE_NATURAL_NUMBER | RULE_DATE_US | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0=='p') ) {s = 1;}

                        else if ( (LA14_0=='{') ) {s = 2;}

                        else if ( (LA14_0=='}') ) {s = 3;}

                        else if ( (LA14_0=='d') ) {s = 4;}

                        else if ( (LA14_0==':') ) {s = 5;}

                        else if ( (LA14_0=='f') ) {s = 6;}

                        else if ( (LA14_0=='s') ) {s = 7;}

                        else if ( (LA14_0=='e') ) {s = 8;}

                        else if ( (LA14_0=='b') ) {s = 9;}

                        else if ( (LA14_0=='u') ) {s = 10;}

                        else if ( (LA14_0=='a') ) {s = 11;}

                        else if ( (LA14_0=='c') ) {s = 12;}

                        else if ( (LA14_0=='l') ) {s = 13;}

                        else if ( (LA14_0=='G') ) {s = 14;}

                        else if ( (LA14_0=='L') ) {s = 15;}

                        else if ( (LA14_0=='B') ) {s = 16;}

                        else if ( (LA14_0=='M') ) {s = 17;}

                        else if ( (LA14_0=='h') ) {s = 18;}

                        else if ( (LA14_0=='x') ) {s = 19;}

                        else if ( (LA14_0=='m') ) {s = 20;}

                        else if ( (LA14_0=='n') ) {s = 21;}

                        else if ( (LA14_0=='w') ) {s = 22;}

                        else if ( (LA14_0=='o') ) {s = 23;}

                        else if ( (LA14_0=='i') ) {s = 24;}

                        else if ( (LA14_0=='v') ) {s = 25;}

                        else if ( (LA14_0=='.') ) {s = 26;}

                        else if ( ((LA14_0>='1' && LA14_0<='9')) ) {s = 27;}

                        else if ( (LA14_0=='0') ) {s = 28;}

                        else if ( (LA14_0=='^') ) {s = 29;}

                        else if ( (LA14_0=='A'||(LA14_0>='C' && LA14_0<='F')||(LA14_0>='H' && LA14_0<='K')||(LA14_0>='N' && LA14_0<='Z')||LA14_0=='_'||LA14_0=='g'||(LA14_0>='j' && LA14_0<='k')||(LA14_0>='q' && LA14_0<='r')||LA14_0=='t'||(LA14_0>='y' && LA14_0<='z')) ) {s = 30;}

                        else if ( (LA14_0=='\"') ) {s = 31;}

                        else if ( (LA14_0=='\'') ) {s = 32;}

                        else if ( (LA14_0=='/') ) {s = 33;}

                        else if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {s = 34;}

                        else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='!'||(LA14_0>='#' && LA14_0<='&')||(LA14_0>='(' && LA14_0<='-')||(LA14_0>=';' && LA14_0<='@')||(LA14_0>='[' && LA14_0<=']')||LA14_0=='`'||LA14_0=='|'||(LA14_0>='~' && LA14_0<='\uFFFF')) ) {s = 35;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_31 = input.LA(1);

                        s = -1;
                        if ( ((LA14_31>='\u0000' && LA14_31<='\uFFFF')) ) {s = 82;}

                        else s = 35;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_32 = input.LA(1);

                        s = -1;
                        if ( ((LA14_32>='\u0000' && LA14_32<='\uFFFF')) ) {s = 82;}

                        else s = 35;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}