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

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import eu.cloud4soa.xtext.services.DslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_DATE_US", "RULE_NATURAL_NUMBER", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'profile'", "'{'", "'}'", "'developer'", "'provider'", "':'", "'firstname'", "'surname'", "'email'", "'birthday'", "'username'", "'password'", "'url'", "'application'", "'application_code'", "'paas_offering'", "'file_name'", "'size'", "'digest'", "'programming_language'", "'software'", "'category'", "'component'", "'description'", "'license'", "'GPL'", "'LGPL'", "'BSD'", "'MIT'", "'hardware'", "'box'", "'http_requests'", "'compute'", "'architecture'", "'x86'", "'x64'", "'cores'", "'speed'", "'memory'", "'cache'", "'network_resource'", "'bandwidth'", "'latency'", "'storage_resource'", "'capacity'", "'channels'", "'api'", "'cli'", "'web_interface'", "'operation'", "'command'", "'information_returned'", "'version'", "'.'"
    };
    public static final int RULE_ID=7;
    public static final int T__66=66;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
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
    public static final int RULE_STRING=4;
    public static final int T__32=32;
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


        public InternalDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDslParser.tokenNames; }
    public String getGrammarFileName() { return "../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g"; }



     	private DslGrammarAccess grammarAccess;
     	
        public InternalDslParser(TokenStream input, DslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Scope";	
       	}
       	
       	@Override
       	protected DslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleScope"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:67:1: entryRuleScope returns [EObject current=null] : iv_ruleScope= ruleScope EOF ;
    public final EObject entryRuleScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScope = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:68:2: (iv_ruleScope= ruleScope EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:69:2: iv_ruleScope= ruleScope EOF
            {
             newCompositeNode(grammarAccess.getScopeRule()); 
            pushFollow(FOLLOW_ruleScope_in_entryRuleScope75);
            iv_ruleScope=ruleScope();

            state._fsp--;

             current =iv_ruleScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScope85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScope"


    // $ANTLR start "ruleScope"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:76:1: ruleScope returns [EObject current=null] : (otherlv_0= 'profile' otherlv_1= '{' ( ( (lv_userProfile_2_0= ruleUserProfile ) ) | ( (lv_applicationProfile_3_0= ruleApplicationProfile ) ) | ( (lv_paasOfferingProfile_4_0= rulePaasOfferingProfile ) ) ) otherlv_5= '}' ) ;
    public final EObject ruleScope() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_userProfile_2_0 = null;

        EObject lv_applicationProfile_3_0 = null;

        EObject lv_paasOfferingProfile_4_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:79:28: ( (otherlv_0= 'profile' otherlv_1= '{' ( ( (lv_userProfile_2_0= ruleUserProfile ) ) | ( (lv_applicationProfile_3_0= ruleApplicationProfile ) ) | ( (lv_paasOfferingProfile_4_0= rulePaasOfferingProfile ) ) ) otherlv_5= '}' ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:80:1: (otherlv_0= 'profile' otherlv_1= '{' ( ( (lv_userProfile_2_0= ruleUserProfile ) ) | ( (lv_applicationProfile_3_0= ruleApplicationProfile ) ) | ( (lv_paasOfferingProfile_4_0= rulePaasOfferingProfile ) ) ) otherlv_5= '}' )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:80:1: (otherlv_0= 'profile' otherlv_1= '{' ( ( (lv_userProfile_2_0= ruleUserProfile ) ) | ( (lv_applicationProfile_3_0= ruleApplicationProfile ) ) | ( (lv_paasOfferingProfile_4_0= rulePaasOfferingProfile ) ) ) otherlv_5= '}' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:80:3: otherlv_0= 'profile' otherlv_1= '{' ( ( (lv_userProfile_2_0= ruleUserProfile ) ) | ( (lv_applicationProfile_3_0= ruleApplicationProfile ) ) | ( (lv_paasOfferingProfile_4_0= rulePaasOfferingProfile ) ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleScope122); 

                	newLeafNode(otherlv_0, grammarAccess.getScopeAccess().getProfileKeyword_0());
                
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleScope134); 

                	newLeafNode(otherlv_1, grammarAccess.getScopeAccess().getLeftCurlyBracketKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:88:1: ( ( (lv_userProfile_2_0= ruleUserProfile ) ) | ( (lv_applicationProfile_3_0= ruleApplicationProfile ) ) | ( (lv_paasOfferingProfile_4_0= rulePaasOfferingProfile ) ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 16:
            case 17:
                {
                alt1=1;
                }
                break;
            case 26:
                {
                alt1=2;
                }
                break;
            case 28:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:88:2: ( (lv_userProfile_2_0= ruleUserProfile ) )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:88:2: ( (lv_userProfile_2_0= ruleUserProfile ) )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:89:1: (lv_userProfile_2_0= ruleUserProfile )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:89:1: (lv_userProfile_2_0= ruleUserProfile )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:90:3: lv_userProfile_2_0= ruleUserProfile
                    {
                     
                    	        newCompositeNode(grammarAccess.getScopeAccess().getUserProfileUserProfileParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUserProfile_in_ruleScope156);
                    lv_userProfile_2_0=ruleUserProfile();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScopeRule());
                    	        }
                           		set(
                           			current, 
                           			"userProfile",
                            		lv_userProfile_2_0, 
                            		"UserProfile");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:107:6: ( (lv_applicationProfile_3_0= ruleApplicationProfile ) )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:107:6: ( (lv_applicationProfile_3_0= ruleApplicationProfile ) )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:108:1: (lv_applicationProfile_3_0= ruleApplicationProfile )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:108:1: (lv_applicationProfile_3_0= ruleApplicationProfile )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:109:3: lv_applicationProfile_3_0= ruleApplicationProfile
                    {
                     
                    	        newCompositeNode(grammarAccess.getScopeAccess().getApplicationProfileApplicationProfileParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleApplicationProfile_in_ruleScope183);
                    lv_applicationProfile_3_0=ruleApplicationProfile();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScopeRule());
                    	        }
                           		set(
                           			current, 
                           			"applicationProfile",
                            		lv_applicationProfile_3_0, 
                            		"ApplicationProfile");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:126:6: ( (lv_paasOfferingProfile_4_0= rulePaasOfferingProfile ) )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:126:6: ( (lv_paasOfferingProfile_4_0= rulePaasOfferingProfile ) )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:127:1: (lv_paasOfferingProfile_4_0= rulePaasOfferingProfile )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:127:1: (lv_paasOfferingProfile_4_0= rulePaasOfferingProfile )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:128:3: lv_paasOfferingProfile_4_0= rulePaasOfferingProfile
                    {
                     
                    	        newCompositeNode(grammarAccess.getScopeAccess().getPaasOfferingProfilePaasOfferingProfileParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FOLLOW_rulePaasOfferingProfile_in_ruleScope210);
                    lv_paasOfferingProfile_4_0=rulePaasOfferingProfile();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScopeRule());
                    	        }
                           		set(
                           			current, 
                           			"paasOfferingProfile",
                            		lv_paasOfferingProfile_4_0, 
                            		"PaasOfferingProfile");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleScope223); 

                	newLeafNode(otherlv_5, grammarAccess.getScopeAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScope"


    // $ANTLR start "entryRuleUserProfile"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:156:1: entryRuleUserProfile returns [EObject current=null] : iv_ruleUserProfile= ruleUserProfile EOF ;
    public final EObject entryRuleUserProfile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUserProfile = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:157:2: (iv_ruleUserProfile= ruleUserProfile EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:158:2: iv_ruleUserProfile= ruleUserProfile EOF
            {
             newCompositeNode(grammarAccess.getUserProfileRule()); 
            pushFollow(FOLLOW_ruleUserProfile_in_entryRuleUserProfile259);
            iv_ruleUserProfile=ruleUserProfile();

            state._fsp--;

             current =iv_ruleUserProfile; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUserProfile269); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUserProfile"


    // $ANTLR start "ruleUserProfile"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:165:1: ruleUserProfile returns [EObject current=null] : ( (otherlv_0= 'developer' | (otherlv_1= 'provider' otherlv_2= ':' ( (lv_provider_3_0= ruleProvider ) ) ) ) otherlv_4= '{' ( (lv_accountInfo_5_0= ruleAccountInfo ) ) ( (lv_personalInfo_6_0= rulePersonalInfos ) ) otherlv_7= '}' ) ;
    public final EObject ruleUserProfile() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_provider_3_0 = null;

        EObject lv_accountInfo_5_0 = null;

        EObject lv_personalInfo_6_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:168:28: ( ( (otherlv_0= 'developer' | (otherlv_1= 'provider' otherlv_2= ':' ( (lv_provider_3_0= ruleProvider ) ) ) ) otherlv_4= '{' ( (lv_accountInfo_5_0= ruleAccountInfo ) ) ( (lv_personalInfo_6_0= rulePersonalInfos ) ) otherlv_7= '}' ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:169:1: ( (otherlv_0= 'developer' | (otherlv_1= 'provider' otherlv_2= ':' ( (lv_provider_3_0= ruleProvider ) ) ) ) otherlv_4= '{' ( (lv_accountInfo_5_0= ruleAccountInfo ) ) ( (lv_personalInfo_6_0= rulePersonalInfos ) ) otherlv_7= '}' )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:169:1: ( (otherlv_0= 'developer' | (otherlv_1= 'provider' otherlv_2= ':' ( (lv_provider_3_0= ruleProvider ) ) ) ) otherlv_4= '{' ( (lv_accountInfo_5_0= ruleAccountInfo ) ) ( (lv_personalInfo_6_0= rulePersonalInfos ) ) otherlv_7= '}' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:169:2: (otherlv_0= 'developer' | (otherlv_1= 'provider' otherlv_2= ':' ( (lv_provider_3_0= ruleProvider ) ) ) ) otherlv_4= '{' ( (lv_accountInfo_5_0= ruleAccountInfo ) ) ( (lv_personalInfo_6_0= rulePersonalInfos ) ) otherlv_7= '}'
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:169:2: (otherlv_0= 'developer' | (otherlv_1= 'provider' otherlv_2= ':' ( (lv_provider_3_0= ruleProvider ) ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) ) {
                alt2=1;
            }
            else if ( (LA2_0==17) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:169:4: otherlv_0= 'developer'
                    {
                    otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleUserProfile307); 

                        	newLeafNode(otherlv_0, grammarAccess.getUserProfileAccess().getDeveloperKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:174:6: (otherlv_1= 'provider' otherlv_2= ':' ( (lv_provider_3_0= ruleProvider ) ) )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:174:6: (otherlv_1= 'provider' otherlv_2= ':' ( (lv_provider_3_0= ruleProvider ) ) )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:174:8: otherlv_1= 'provider' otherlv_2= ':' ( (lv_provider_3_0= ruleProvider ) )
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleUserProfile326); 

                        	newLeafNode(otherlv_1, grammarAccess.getUserProfileAccess().getProviderKeyword_0_1_0());
                        
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleUserProfile338); 

                        	newLeafNode(otherlv_2, grammarAccess.getUserProfileAccess().getColonKeyword_0_1_1());
                        
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:182:1: ( (lv_provider_3_0= ruleProvider ) )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:183:1: (lv_provider_3_0= ruleProvider )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:183:1: (lv_provider_3_0= ruleProvider )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:184:3: lv_provider_3_0= ruleProvider
                    {
                     
                    	        newCompositeNode(grammarAccess.getUserProfileAccess().getProviderProviderParserRuleCall_0_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleProvider_in_ruleUserProfile359);
                    lv_provider_3_0=ruleProvider();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUserProfileRule());
                    	        }
                           		set(
                           			current, 
                           			"provider",
                            		lv_provider_3_0, 
                            		"Provider");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleUserProfile373); 

                	newLeafNode(otherlv_4, grammarAccess.getUserProfileAccess().getLeftCurlyBracketKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:204:1: ( (lv_accountInfo_5_0= ruleAccountInfo ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:205:1: (lv_accountInfo_5_0= ruleAccountInfo )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:205:1: (lv_accountInfo_5_0= ruleAccountInfo )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:206:3: lv_accountInfo_5_0= ruleAccountInfo
            {
             
            	        newCompositeNode(grammarAccess.getUserProfileAccess().getAccountInfoAccountInfoParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAccountInfo_in_ruleUserProfile394);
            lv_accountInfo_5_0=ruleAccountInfo();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getUserProfileRule());
            	        }
                   		set(
                   			current, 
                   			"accountInfo",
                    		lv_accountInfo_5_0, 
                    		"AccountInfo");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:222:2: ( (lv_personalInfo_6_0= rulePersonalInfos ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:223:1: (lv_personalInfo_6_0= rulePersonalInfos )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:223:1: (lv_personalInfo_6_0= rulePersonalInfos )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:224:3: lv_personalInfo_6_0= rulePersonalInfos
            {
             
            	        newCompositeNode(grammarAccess.getUserProfileAccess().getPersonalInfoPersonalInfosParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_rulePersonalInfos_in_ruleUserProfile415);
            lv_personalInfo_6_0=rulePersonalInfos();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getUserProfileRule());
            	        }
                   		set(
                   			current, 
                   			"personalInfo",
                    		lv_personalInfo_6_0, 
                    		"PersonalInfos");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleUserProfile427); 

                	newLeafNode(otherlv_7, grammarAccess.getUserProfileAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUserProfile"


    // $ANTLR start "entryRulePersonalInfos"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:252:1: entryRulePersonalInfos returns [EObject current=null] : iv_rulePersonalInfos= rulePersonalInfos EOF ;
    public final EObject entryRulePersonalInfos() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePersonalInfos = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:253:2: (iv_rulePersonalInfos= rulePersonalInfos EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:254:2: iv_rulePersonalInfos= rulePersonalInfos EOF
            {
             newCompositeNode(grammarAccess.getPersonalInfosRule()); 
            pushFollow(FOLLOW_rulePersonalInfos_in_entryRulePersonalInfos463);
            iv_rulePersonalInfos=rulePersonalInfos();

            state._fsp--;

             current =iv_rulePersonalInfos; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePersonalInfos473); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePersonalInfos"


    // $ANTLR start "rulePersonalInfos"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:261:1: rulePersonalInfos returns [EObject current=null] : (otherlv_0= 'firstname' otherlv_1= ':' ( (lv_firstName_2_0= RULE_STRING ) ) otherlv_3= 'surname' otherlv_4= ':' ( (lv_surnName_5_0= RULE_STRING ) ) otherlv_6= 'email' otherlv_7= ':' ( (lv_email_8_0= RULE_STRING ) ) ( (lv_birthDay_9_0= ruleBirthday ) )? ) ;
    public final EObject rulePersonalInfos() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_firstName_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_surnName_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_email_8_0=null;
        EObject lv_birthDay_9_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:264:28: ( (otherlv_0= 'firstname' otherlv_1= ':' ( (lv_firstName_2_0= RULE_STRING ) ) otherlv_3= 'surname' otherlv_4= ':' ( (lv_surnName_5_0= RULE_STRING ) ) otherlv_6= 'email' otherlv_7= ':' ( (lv_email_8_0= RULE_STRING ) ) ( (lv_birthDay_9_0= ruleBirthday ) )? ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:265:1: (otherlv_0= 'firstname' otherlv_1= ':' ( (lv_firstName_2_0= RULE_STRING ) ) otherlv_3= 'surname' otherlv_4= ':' ( (lv_surnName_5_0= RULE_STRING ) ) otherlv_6= 'email' otherlv_7= ':' ( (lv_email_8_0= RULE_STRING ) ) ( (lv_birthDay_9_0= ruleBirthday ) )? )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:265:1: (otherlv_0= 'firstname' otherlv_1= ':' ( (lv_firstName_2_0= RULE_STRING ) ) otherlv_3= 'surname' otherlv_4= ':' ( (lv_surnName_5_0= RULE_STRING ) ) otherlv_6= 'email' otherlv_7= ':' ( (lv_email_8_0= RULE_STRING ) ) ( (lv_birthDay_9_0= ruleBirthday ) )? )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:265:3: otherlv_0= 'firstname' otherlv_1= ':' ( (lv_firstName_2_0= RULE_STRING ) ) otherlv_3= 'surname' otherlv_4= ':' ( (lv_surnName_5_0= RULE_STRING ) ) otherlv_6= 'email' otherlv_7= ':' ( (lv_email_8_0= RULE_STRING ) ) ( (lv_birthDay_9_0= ruleBirthday ) )?
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_rulePersonalInfos510); 

                	newLeafNode(otherlv_0, grammarAccess.getPersonalInfosAccess().getFirstnameKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_rulePersonalInfos522); 

                	newLeafNode(otherlv_1, grammarAccess.getPersonalInfosAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:273:1: ( (lv_firstName_2_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:274:1: (lv_firstName_2_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:274:1: (lv_firstName_2_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:275:3: lv_firstName_2_0= RULE_STRING
            {
            lv_firstName_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePersonalInfos539); 

            			newLeafNode(lv_firstName_2_0, grammarAccess.getPersonalInfosAccess().getFirstNameSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPersonalInfosRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"firstName",
                    		lv_firstName_2_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_20_in_rulePersonalInfos556); 

                	newLeafNode(otherlv_3, grammarAccess.getPersonalInfosAccess().getSurnameKeyword_3());
                
            otherlv_4=(Token)match(input,18,FOLLOW_18_in_rulePersonalInfos568); 

                	newLeafNode(otherlv_4, grammarAccess.getPersonalInfosAccess().getColonKeyword_4());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:299:1: ( (lv_surnName_5_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:300:1: (lv_surnName_5_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:300:1: (lv_surnName_5_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:301:3: lv_surnName_5_0= RULE_STRING
            {
            lv_surnName_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePersonalInfos585); 

            			newLeafNode(lv_surnName_5_0, grammarAccess.getPersonalInfosAccess().getSurnNameSTRINGTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPersonalInfosRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"surnName",
                    		lv_surnName_5_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_6=(Token)match(input,21,FOLLOW_21_in_rulePersonalInfos602); 

                	newLeafNode(otherlv_6, grammarAccess.getPersonalInfosAccess().getEmailKeyword_6());
                
            otherlv_7=(Token)match(input,18,FOLLOW_18_in_rulePersonalInfos614); 

                	newLeafNode(otherlv_7, grammarAccess.getPersonalInfosAccess().getColonKeyword_7());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:325:1: ( (lv_email_8_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:326:1: (lv_email_8_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:326:1: (lv_email_8_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:327:3: lv_email_8_0= RULE_STRING
            {
            lv_email_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePersonalInfos631); 

            			newLeafNode(lv_email_8_0, grammarAccess.getPersonalInfosAccess().getEmailSTRINGTerminalRuleCall_8_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPersonalInfosRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"email",
                    		lv_email_8_0, 
                    		"STRING");
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:343:2: ( (lv_birthDay_9_0= ruleBirthday ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==22) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:344:1: (lv_birthDay_9_0= ruleBirthday )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:344:1: (lv_birthDay_9_0= ruleBirthday )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:345:3: lv_birthDay_9_0= ruleBirthday
                    {
                     
                    	        newCompositeNode(grammarAccess.getPersonalInfosAccess().getBirthDayBirthdayParserRuleCall_9_0()); 
                    	    
                    pushFollow(FOLLOW_ruleBirthday_in_rulePersonalInfos657);
                    lv_birthDay_9_0=ruleBirthday();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPersonalInfosRule());
                    	        }
                           		set(
                           			current, 
                           			"birthDay",
                            		lv_birthDay_9_0, 
                            		"Birthday");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePersonalInfos"


    // $ANTLR start "entryRuleBirthday"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:369:1: entryRuleBirthday returns [EObject current=null] : iv_ruleBirthday= ruleBirthday EOF ;
    public final EObject entryRuleBirthday() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBirthday = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:370:2: (iv_ruleBirthday= ruleBirthday EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:371:2: iv_ruleBirthday= ruleBirthday EOF
            {
             newCompositeNode(grammarAccess.getBirthdayRule()); 
            pushFollow(FOLLOW_ruleBirthday_in_entryRuleBirthday694);
            iv_ruleBirthday=ruleBirthday();

            state._fsp--;

             current =iv_ruleBirthday; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBirthday704); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBirthday"


    // $ANTLR start "ruleBirthday"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:378:1: ruleBirthday returns [EObject current=null] : (otherlv_0= 'birthday' otherlv_1= ':' ( (lv_date_2_0= RULE_DATE_US ) ) ) ;
    public final EObject ruleBirthday() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_date_2_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:381:28: ( (otherlv_0= 'birthday' otherlv_1= ':' ( (lv_date_2_0= RULE_DATE_US ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:382:1: (otherlv_0= 'birthday' otherlv_1= ':' ( (lv_date_2_0= RULE_DATE_US ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:382:1: (otherlv_0= 'birthday' otherlv_1= ':' ( (lv_date_2_0= RULE_DATE_US ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:382:3: otherlv_0= 'birthday' otherlv_1= ':' ( (lv_date_2_0= RULE_DATE_US ) )
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleBirthday741); 

                	newLeafNode(otherlv_0, grammarAccess.getBirthdayAccess().getBirthdayKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleBirthday753); 

                	newLeafNode(otherlv_1, grammarAccess.getBirthdayAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:390:1: ( (lv_date_2_0= RULE_DATE_US ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:391:1: (lv_date_2_0= RULE_DATE_US )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:391:1: (lv_date_2_0= RULE_DATE_US )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:392:3: lv_date_2_0= RULE_DATE_US
            {
            lv_date_2_0=(Token)match(input,RULE_DATE_US,FOLLOW_RULE_DATE_US_in_ruleBirthday770); 

            			newLeafNode(lv_date_2_0, grammarAccess.getBirthdayAccess().getDateDATE_USTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBirthdayRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"date",
                    		lv_date_2_0, 
                    		"DATE_US");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBirthday"


    // $ANTLR start "entryRuleAccountInfo"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:416:1: entryRuleAccountInfo returns [EObject current=null] : iv_ruleAccountInfo= ruleAccountInfo EOF ;
    public final EObject entryRuleAccountInfo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccountInfo = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:417:2: (iv_ruleAccountInfo= ruleAccountInfo EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:418:2: iv_ruleAccountInfo= ruleAccountInfo EOF
            {
             newCompositeNode(grammarAccess.getAccountInfoRule()); 
            pushFollow(FOLLOW_ruleAccountInfo_in_entryRuleAccountInfo811);
            iv_ruleAccountInfo=ruleAccountInfo();

            state._fsp--;

             current =iv_ruleAccountInfo; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAccountInfo821); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAccountInfo"


    // $ANTLR start "ruleAccountInfo"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:425:1: ruleAccountInfo returns [EObject current=null] : (otherlv_0= 'username' otherlv_1= ':' ( (lv_username_2_0= RULE_STRING ) ) otherlv_3= 'password' otherlv_4= ':' ( (lv_password_5_0= RULE_STRING ) ) ) ;
    public final EObject ruleAccountInfo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_username_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_password_5_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:428:28: ( (otherlv_0= 'username' otherlv_1= ':' ( (lv_username_2_0= RULE_STRING ) ) otherlv_3= 'password' otherlv_4= ':' ( (lv_password_5_0= RULE_STRING ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:429:1: (otherlv_0= 'username' otherlv_1= ':' ( (lv_username_2_0= RULE_STRING ) ) otherlv_3= 'password' otherlv_4= ':' ( (lv_password_5_0= RULE_STRING ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:429:1: (otherlv_0= 'username' otherlv_1= ':' ( (lv_username_2_0= RULE_STRING ) ) otherlv_3= 'password' otherlv_4= ':' ( (lv_password_5_0= RULE_STRING ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:429:3: otherlv_0= 'username' otherlv_1= ':' ( (lv_username_2_0= RULE_STRING ) ) otherlv_3= 'password' otherlv_4= ':' ( (lv_password_5_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleAccountInfo858); 

                	newLeafNode(otherlv_0, grammarAccess.getAccountInfoAccess().getUsernameKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleAccountInfo870); 

                	newLeafNode(otherlv_1, grammarAccess.getAccountInfoAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:437:1: ( (lv_username_2_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:438:1: (lv_username_2_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:438:1: (lv_username_2_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:439:3: lv_username_2_0= RULE_STRING
            {
            lv_username_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAccountInfo887); 

            			newLeafNode(lv_username_2_0, grammarAccess.getAccountInfoAccess().getUsernameSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAccountInfoRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"username",
                    		lv_username_2_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleAccountInfo904); 

                	newLeafNode(otherlv_3, grammarAccess.getAccountInfoAccess().getPasswordKeyword_3());
                
            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleAccountInfo916); 

                	newLeafNode(otherlv_4, grammarAccess.getAccountInfoAccess().getColonKeyword_4());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:463:1: ( (lv_password_5_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:464:1: (lv_password_5_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:464:1: (lv_password_5_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:465:3: lv_password_5_0= RULE_STRING
            {
            lv_password_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAccountInfo933); 

            			newLeafNode(lv_password_5_0, grammarAccess.getAccountInfoAccess().getPasswordSTRINGTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAccountInfoRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"password",
                    		lv_password_5_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAccountInfo"


    // $ANTLR start "entryRuleProvider"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:489:1: entryRuleProvider returns [EObject current=null] : iv_ruleProvider= ruleProvider EOF ;
    public final EObject entryRuleProvider() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProvider = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:490:2: (iv_ruleProvider= ruleProvider EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:491:2: iv_ruleProvider= ruleProvider EOF
            {
             newCompositeNode(grammarAccess.getProviderRule()); 
            pushFollow(FOLLOW_ruleProvider_in_entryRuleProvider974);
            iv_ruleProvider=ruleProvider();

            state._fsp--;

             current =iv_ruleProvider; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProvider984); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProvider"


    // $ANTLR start "ruleProvider"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:498:1: ruleProvider returns [EObject current=null] : ( ( (lv_provider_0_0= RULE_STRING ) ) otherlv_1= 'url' otherlv_2= ':' ( (lv_homepage_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleProvider() throws RecognitionException {
        EObject current = null;

        Token lv_provider_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_homepage_3_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:501:28: ( ( ( (lv_provider_0_0= RULE_STRING ) ) otherlv_1= 'url' otherlv_2= ':' ( (lv_homepage_3_0= RULE_STRING ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:502:1: ( ( (lv_provider_0_0= RULE_STRING ) ) otherlv_1= 'url' otherlv_2= ':' ( (lv_homepage_3_0= RULE_STRING ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:502:1: ( ( (lv_provider_0_0= RULE_STRING ) ) otherlv_1= 'url' otherlv_2= ':' ( (lv_homepage_3_0= RULE_STRING ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:502:2: ( (lv_provider_0_0= RULE_STRING ) ) otherlv_1= 'url' otherlv_2= ':' ( (lv_homepage_3_0= RULE_STRING ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:502:2: ( (lv_provider_0_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:503:1: (lv_provider_0_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:503:1: (lv_provider_0_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:504:3: lv_provider_0_0= RULE_STRING
            {
            lv_provider_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleProvider1026); 

            			newLeafNode(lv_provider_0_0, grammarAccess.getProviderAccess().getProviderSTRINGTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getProviderRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"provider",
                    		lv_provider_0_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleProvider1043); 

                	newLeafNode(otherlv_1, grammarAccess.getProviderAccess().getUrlKeyword_1());
                
            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleProvider1055); 

                	newLeafNode(otherlv_2, grammarAccess.getProviderAccess().getColonKeyword_2());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:528:1: ( (lv_homepage_3_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:529:1: (lv_homepage_3_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:529:1: (lv_homepage_3_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:530:3: lv_homepage_3_0= RULE_STRING
            {
            lv_homepage_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleProvider1072); 

            			newLeafNode(lv_homepage_3_0, grammarAccess.getProviderAccess().getHomepageSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getProviderRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"homepage",
                    		lv_homepage_3_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProvider"


    // $ANTLR start "entryRuleApplicationProfile"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:554:1: entryRuleApplicationProfile returns [EObject current=null] : iv_ruleApplicationProfile= ruleApplicationProfile EOF ;
    public final EObject entryRuleApplicationProfile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApplicationProfile = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:555:2: (iv_ruleApplicationProfile= ruleApplicationProfile EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:556:2: iv_ruleApplicationProfile= ruleApplicationProfile EOF
            {
             newCompositeNode(grammarAccess.getApplicationProfileRule()); 
            pushFollow(FOLLOW_ruleApplicationProfile_in_entryRuleApplicationProfile1113);
            iv_ruleApplicationProfile=ruleApplicationProfile();

            state._fsp--;

             current =iv_ruleApplicationProfile; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleApplicationProfile1123); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleApplicationProfile"


    // $ANTLR start "ruleApplicationProfile"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:563:1: ruleApplicationProfile returns [EObject current=null] : ( ( (lv_infos_0_0= ruleApplicationInfos ) ) ( (lv_file_1_0= ruleFile ) ) ( (lv_technology_2_0= ruleTechnologyInfo ) ) ) ;
    public final EObject ruleApplicationProfile() throws RecognitionException {
        EObject current = null;

        EObject lv_infos_0_0 = null;

        EObject lv_file_1_0 = null;

        EObject lv_technology_2_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:566:28: ( ( ( (lv_infos_0_0= ruleApplicationInfos ) ) ( (lv_file_1_0= ruleFile ) ) ( (lv_technology_2_0= ruleTechnologyInfo ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:567:1: ( ( (lv_infos_0_0= ruleApplicationInfos ) ) ( (lv_file_1_0= ruleFile ) ) ( (lv_technology_2_0= ruleTechnologyInfo ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:567:1: ( ( (lv_infos_0_0= ruleApplicationInfos ) ) ( (lv_file_1_0= ruleFile ) ) ( (lv_technology_2_0= ruleTechnologyInfo ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:567:2: ( (lv_infos_0_0= ruleApplicationInfos ) ) ( (lv_file_1_0= ruleFile ) ) ( (lv_technology_2_0= ruleTechnologyInfo ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:567:2: ( (lv_infos_0_0= ruleApplicationInfos ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:568:1: (lv_infos_0_0= ruleApplicationInfos )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:568:1: (lv_infos_0_0= ruleApplicationInfos )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:569:3: lv_infos_0_0= ruleApplicationInfos
            {
             
            	        newCompositeNode(grammarAccess.getApplicationProfileAccess().getInfosApplicationInfosParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleApplicationInfos_in_ruleApplicationProfile1169);
            lv_infos_0_0=ruleApplicationInfos();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getApplicationProfileRule());
            	        }
                   		set(
                   			current, 
                   			"infos",
                    		lv_infos_0_0, 
                    		"ApplicationInfos");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:585:2: ( (lv_file_1_0= ruleFile ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:586:1: (lv_file_1_0= ruleFile )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:586:1: (lv_file_1_0= ruleFile )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:587:3: lv_file_1_0= ruleFile
            {
             
            	        newCompositeNode(grammarAccess.getApplicationProfileAccess().getFileFileParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFile_in_ruleApplicationProfile1190);
            lv_file_1_0=ruleFile();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getApplicationProfileRule());
            	        }
                   		set(
                   			current, 
                   			"file",
                    		lv_file_1_0, 
                    		"File");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:603:2: ( (lv_technology_2_0= ruleTechnologyInfo ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:604:1: (lv_technology_2_0= ruleTechnologyInfo )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:604:1: (lv_technology_2_0= ruleTechnologyInfo )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:605:3: lv_technology_2_0= ruleTechnologyInfo
            {
             
            	        newCompositeNode(grammarAccess.getApplicationProfileAccess().getTechnologyTechnologyInfoParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleTechnologyInfo_in_ruleApplicationProfile1211);
            lv_technology_2_0=ruleTechnologyInfo();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getApplicationProfileRule());
            	        }
                   		set(
                   			current, 
                   			"technology",
                    		lv_technology_2_0, 
                    		"TechnologyInfo");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleApplicationProfile"


    // $ANTLR start "entryRuleApplicationInfos"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:629:1: entryRuleApplicationInfos returns [EObject current=null] : iv_ruleApplicationInfos= ruleApplicationInfos EOF ;
    public final EObject entryRuleApplicationInfos() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApplicationInfos = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:630:2: (iv_ruleApplicationInfos= ruleApplicationInfos EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:631:2: iv_ruleApplicationInfos= ruleApplicationInfos EOF
            {
             newCompositeNode(grammarAccess.getApplicationInfosRule()); 
            pushFollow(FOLLOW_ruleApplicationInfos_in_entryRuleApplicationInfos1247);
            iv_ruleApplicationInfos=ruleApplicationInfos();

            state._fsp--;

             current =iv_ruleApplicationInfos; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleApplicationInfos1257); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleApplicationInfos"


    // $ANTLR start "ruleApplicationInfos"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:638:1: ruleApplicationInfos returns [EObject current=null] : (otherlv_0= 'application' otherlv_1= ':' ( (lv_application_2_0= RULE_STRING ) ) ( (lv_version_3_0= ruleVersion ) ) ( (lv_code_4_0= ruleApplicationCode ) )? ) ;
    public final EObject ruleApplicationInfos() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_application_2_0=null;
        EObject lv_version_3_0 = null;

        EObject lv_code_4_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:641:28: ( (otherlv_0= 'application' otherlv_1= ':' ( (lv_application_2_0= RULE_STRING ) ) ( (lv_version_3_0= ruleVersion ) ) ( (lv_code_4_0= ruleApplicationCode ) )? ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:642:1: (otherlv_0= 'application' otherlv_1= ':' ( (lv_application_2_0= RULE_STRING ) ) ( (lv_version_3_0= ruleVersion ) ) ( (lv_code_4_0= ruleApplicationCode ) )? )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:642:1: (otherlv_0= 'application' otherlv_1= ':' ( (lv_application_2_0= RULE_STRING ) ) ( (lv_version_3_0= ruleVersion ) ) ( (lv_code_4_0= ruleApplicationCode ) )? )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:642:3: otherlv_0= 'application' otherlv_1= ':' ( (lv_application_2_0= RULE_STRING ) ) ( (lv_version_3_0= ruleVersion ) ) ( (lv_code_4_0= ruleApplicationCode ) )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleApplicationInfos1294); 

                	newLeafNode(otherlv_0, grammarAccess.getApplicationInfosAccess().getApplicationKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleApplicationInfos1306); 

                	newLeafNode(otherlv_1, grammarAccess.getApplicationInfosAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:650:1: ( (lv_application_2_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:651:1: (lv_application_2_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:651:1: (lv_application_2_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:652:3: lv_application_2_0= RULE_STRING
            {
            lv_application_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleApplicationInfos1323); 

            			newLeafNode(lv_application_2_0, grammarAccess.getApplicationInfosAccess().getApplicationSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getApplicationInfosRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"application",
                    		lv_application_2_0, 
                    		"STRING");
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:668:2: ( (lv_version_3_0= ruleVersion ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:669:1: (lv_version_3_0= ruleVersion )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:669:1: (lv_version_3_0= ruleVersion )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:670:3: lv_version_3_0= ruleVersion
            {
             
            	        newCompositeNode(grammarAccess.getApplicationInfosAccess().getVersionVersionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleVersion_in_ruleApplicationInfos1349);
            lv_version_3_0=ruleVersion();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getApplicationInfosRule());
            	        }
                   		set(
                   			current, 
                   			"version",
                    		lv_version_3_0, 
                    		"Version");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:686:2: ( (lv_code_4_0= ruleApplicationCode ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==27) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:687:1: (lv_code_4_0= ruleApplicationCode )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:687:1: (lv_code_4_0= ruleApplicationCode )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:688:3: lv_code_4_0= ruleApplicationCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getApplicationInfosAccess().getCodeApplicationCodeParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleApplicationCode_in_ruleApplicationInfos1370);
                    lv_code_4_0=ruleApplicationCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getApplicationInfosRule());
                    	        }
                           		set(
                           			current, 
                           			"code",
                            		lv_code_4_0, 
                            		"ApplicationCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleApplicationInfos"


    // $ANTLR start "entryRuleApplicationCode"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:712:1: entryRuleApplicationCode returns [EObject current=null] : iv_ruleApplicationCode= ruleApplicationCode EOF ;
    public final EObject entryRuleApplicationCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApplicationCode = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:713:2: (iv_ruleApplicationCode= ruleApplicationCode EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:714:2: iv_ruleApplicationCode= ruleApplicationCode EOF
            {
             newCompositeNode(grammarAccess.getApplicationCodeRule()); 
            pushFollow(FOLLOW_ruleApplicationCode_in_entryRuleApplicationCode1407);
            iv_ruleApplicationCode=ruleApplicationCode();

            state._fsp--;

             current =iv_ruleApplicationCode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleApplicationCode1417); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleApplicationCode"


    // $ANTLR start "ruleApplicationCode"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:721:1: ruleApplicationCode returns [EObject current=null] : (otherlv_0= 'application_code' otherlv_1= ':' ( (lv_applicationCode_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleApplicationCode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_applicationCode_2_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:724:28: ( (otherlv_0= 'application_code' otherlv_1= ':' ( (lv_applicationCode_2_0= RULE_STRING ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:725:1: (otherlv_0= 'application_code' otherlv_1= ':' ( (lv_applicationCode_2_0= RULE_STRING ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:725:1: (otherlv_0= 'application_code' otherlv_1= ':' ( (lv_applicationCode_2_0= RULE_STRING ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:725:3: otherlv_0= 'application_code' otherlv_1= ':' ( (lv_applicationCode_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleApplicationCode1454); 

                	newLeafNode(otherlv_0, grammarAccess.getApplicationCodeAccess().getApplication_codeKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleApplicationCode1466); 

                	newLeafNode(otherlv_1, grammarAccess.getApplicationCodeAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:733:1: ( (lv_applicationCode_2_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:734:1: (lv_applicationCode_2_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:734:1: (lv_applicationCode_2_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:735:3: lv_applicationCode_2_0= RULE_STRING
            {
            lv_applicationCode_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleApplicationCode1483); 

            			newLeafNode(lv_applicationCode_2_0, grammarAccess.getApplicationCodeAccess().getApplicationCodeSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getApplicationCodeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"applicationCode",
                    		lv_applicationCode_2_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleApplicationCode"


    // $ANTLR start "entryRulePaasOfferingProfile"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:759:1: entryRulePaasOfferingProfile returns [EObject current=null] : iv_rulePaasOfferingProfile= rulePaasOfferingProfile EOF ;
    public final EObject entryRulePaasOfferingProfile() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePaasOfferingProfile = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:760:2: (iv_rulePaasOfferingProfile= rulePaasOfferingProfile EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:761:2: iv_rulePaasOfferingProfile= rulePaasOfferingProfile EOF
            {
             newCompositeNode(grammarAccess.getPaasOfferingProfileRule()); 
            pushFollow(FOLLOW_rulePaasOfferingProfile_in_entryRulePaasOfferingProfile1524);
            iv_rulePaasOfferingProfile=rulePaasOfferingProfile();

            state._fsp--;

             current =iv_rulePaasOfferingProfile; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePaasOfferingProfile1534); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePaasOfferingProfile"


    // $ANTLR start "rulePaasOfferingProfile"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:768:1: rulePaasOfferingProfile returns [EObject current=null] : ( ( (lv_paasOfferingInfos_0_0= rulePaasOfferingInfos ) ) ( (lv_channels_1_0= ruleChannels ) ) ( (lv_technology_2_0= ruleTechnologyInfo ) ) ) ;
    public final EObject rulePaasOfferingProfile() throws RecognitionException {
        EObject current = null;

        EObject lv_paasOfferingInfos_0_0 = null;

        EObject lv_channels_1_0 = null;

        EObject lv_technology_2_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:771:28: ( ( ( (lv_paasOfferingInfos_0_0= rulePaasOfferingInfos ) ) ( (lv_channels_1_0= ruleChannels ) ) ( (lv_technology_2_0= ruleTechnologyInfo ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:772:1: ( ( (lv_paasOfferingInfos_0_0= rulePaasOfferingInfos ) ) ( (lv_channels_1_0= ruleChannels ) ) ( (lv_technology_2_0= ruleTechnologyInfo ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:772:1: ( ( (lv_paasOfferingInfos_0_0= rulePaasOfferingInfos ) ) ( (lv_channels_1_0= ruleChannels ) ) ( (lv_technology_2_0= ruleTechnologyInfo ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:772:2: ( (lv_paasOfferingInfos_0_0= rulePaasOfferingInfos ) ) ( (lv_channels_1_0= ruleChannels ) ) ( (lv_technology_2_0= ruleTechnologyInfo ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:772:2: ( (lv_paasOfferingInfos_0_0= rulePaasOfferingInfos ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:773:1: (lv_paasOfferingInfos_0_0= rulePaasOfferingInfos )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:773:1: (lv_paasOfferingInfos_0_0= rulePaasOfferingInfos )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:774:3: lv_paasOfferingInfos_0_0= rulePaasOfferingInfos
            {
             
            	        newCompositeNode(grammarAccess.getPaasOfferingProfileAccess().getPaasOfferingInfosPaasOfferingInfosParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulePaasOfferingInfos_in_rulePaasOfferingProfile1580);
            lv_paasOfferingInfos_0_0=rulePaasOfferingInfos();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPaasOfferingProfileRule());
            	        }
                   		set(
                   			current, 
                   			"paasOfferingInfos",
                    		lv_paasOfferingInfos_0_0, 
                    		"PaasOfferingInfos");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:790:2: ( (lv_channels_1_0= ruleChannels ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:791:1: (lv_channels_1_0= ruleChannels )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:791:1: (lv_channels_1_0= ruleChannels )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:792:3: lv_channels_1_0= ruleChannels
            {
             
            	        newCompositeNode(grammarAccess.getPaasOfferingProfileAccess().getChannelsChannelsParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleChannels_in_rulePaasOfferingProfile1601);
            lv_channels_1_0=ruleChannels();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPaasOfferingProfileRule());
            	        }
                   		set(
                   			current, 
                   			"channels",
                    		lv_channels_1_0, 
                    		"Channels");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:808:2: ( (lv_technology_2_0= ruleTechnologyInfo ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:809:1: (lv_technology_2_0= ruleTechnologyInfo )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:809:1: (lv_technology_2_0= ruleTechnologyInfo )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:810:3: lv_technology_2_0= ruleTechnologyInfo
            {
             
            	        newCompositeNode(grammarAccess.getPaasOfferingProfileAccess().getTechnologyTechnologyInfoParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleTechnologyInfo_in_rulePaasOfferingProfile1622);
            lv_technology_2_0=ruleTechnologyInfo();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPaasOfferingProfileRule());
            	        }
                   		set(
                   			current, 
                   			"technology",
                    		lv_technology_2_0, 
                    		"TechnologyInfo");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePaasOfferingProfile"


    // $ANTLR start "entryRulePaasOfferingInfos"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:834:1: entryRulePaasOfferingInfos returns [EObject current=null] : iv_rulePaasOfferingInfos= rulePaasOfferingInfos EOF ;
    public final EObject entryRulePaasOfferingInfos() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePaasOfferingInfos = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:835:2: (iv_rulePaasOfferingInfos= rulePaasOfferingInfos EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:836:2: iv_rulePaasOfferingInfos= rulePaasOfferingInfos EOF
            {
             newCompositeNode(grammarAccess.getPaasOfferingInfosRule()); 
            pushFollow(FOLLOW_rulePaasOfferingInfos_in_entryRulePaasOfferingInfos1658);
            iv_rulePaasOfferingInfos=rulePaasOfferingInfos();

            state._fsp--;

             current =iv_rulePaasOfferingInfos; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePaasOfferingInfos1668); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePaasOfferingInfos"


    // $ANTLR start "rulePaasOfferingInfos"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:843:1: rulePaasOfferingInfos returns [EObject current=null] : (otherlv_0= 'paas_offering' otherlv_1= ':' ( (lv_paasOffering_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePaasOfferingInfos() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_paasOffering_2_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:846:28: ( (otherlv_0= 'paas_offering' otherlv_1= ':' ( (lv_paasOffering_2_0= RULE_STRING ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:847:1: (otherlv_0= 'paas_offering' otherlv_1= ':' ( (lv_paasOffering_2_0= RULE_STRING ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:847:1: (otherlv_0= 'paas_offering' otherlv_1= ':' ( (lv_paasOffering_2_0= RULE_STRING ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:847:3: otherlv_0= 'paas_offering' otherlv_1= ':' ( (lv_paasOffering_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_rulePaasOfferingInfos1705); 

                	newLeafNode(otherlv_0, grammarAccess.getPaasOfferingInfosAccess().getPaas_offeringKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_rulePaasOfferingInfos1717); 

                	newLeafNode(otherlv_1, grammarAccess.getPaasOfferingInfosAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:855:1: ( (lv_paasOffering_2_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:856:1: (lv_paasOffering_2_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:856:1: (lv_paasOffering_2_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:857:3: lv_paasOffering_2_0= RULE_STRING
            {
            lv_paasOffering_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePaasOfferingInfos1734); 

            			newLeafNode(lv_paasOffering_2_0, grammarAccess.getPaasOfferingInfosAccess().getPaasOfferingSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPaasOfferingInfosRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"paasOffering",
                    		lv_paasOffering_2_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePaasOfferingInfos"


    // $ANTLR start "entryRuleFile"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:881:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:882:2: (iv_ruleFile= ruleFile EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:883:2: iv_ruleFile= ruleFile EOF
            {
             newCompositeNode(grammarAccess.getFileRule()); 
            pushFollow(FOLLOW_ruleFile_in_entryRuleFile1775);
            iv_ruleFile=ruleFile();

            state._fsp--;

             current =iv_ruleFile; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFile1785); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFile"


    // $ANTLR start "ruleFile"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:890:1: ruleFile returns [EObject current=null] : (otherlv_0= 'file_name' otherlv_1= ':' ( (lv_fileName_2_0= RULE_STRING ) ) ( (lv_dimension_3_0= ruleFileDimension ) )? ) ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fileName_2_0=null;
        EObject lv_dimension_3_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:893:28: ( (otherlv_0= 'file_name' otherlv_1= ':' ( (lv_fileName_2_0= RULE_STRING ) ) ( (lv_dimension_3_0= ruleFileDimension ) )? ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:894:1: (otherlv_0= 'file_name' otherlv_1= ':' ( (lv_fileName_2_0= RULE_STRING ) ) ( (lv_dimension_3_0= ruleFileDimension ) )? )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:894:1: (otherlv_0= 'file_name' otherlv_1= ':' ( (lv_fileName_2_0= RULE_STRING ) ) ( (lv_dimension_3_0= ruleFileDimension ) )? )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:894:3: otherlv_0= 'file_name' otherlv_1= ':' ( (lv_fileName_2_0= RULE_STRING ) ) ( (lv_dimension_3_0= ruleFileDimension ) )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleFile1822); 

                	newLeafNode(otherlv_0, grammarAccess.getFileAccess().getFile_nameKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleFile1834); 

                	newLeafNode(otherlv_1, grammarAccess.getFileAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:902:1: ( (lv_fileName_2_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:903:1: (lv_fileName_2_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:903:1: (lv_fileName_2_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:904:3: lv_fileName_2_0= RULE_STRING
            {
            lv_fileName_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFile1851); 

            			newLeafNode(lv_fileName_2_0, grammarAccess.getFileAccess().getFileNameSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFileRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"fileName",
                    		lv_fileName_2_0, 
                    		"STRING");
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:920:2: ( (lv_dimension_3_0= ruleFileDimension ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==30) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:921:1: (lv_dimension_3_0= ruleFileDimension )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:921:1: (lv_dimension_3_0= ruleFileDimension )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:922:3: lv_dimension_3_0= ruleFileDimension
                    {
                     
                    	        newCompositeNode(grammarAccess.getFileAccess().getDimensionFileDimensionParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFileDimension_in_ruleFile1877);
                    lv_dimension_3_0=ruleFileDimension();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFileRule());
                    	        }
                           		set(
                           			current, 
                           			"dimension",
                            		lv_dimension_3_0, 
                            		"FileDimension");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFile"


    // $ANTLR start "entryRuleFileDimension"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:946:1: entryRuleFileDimension returns [EObject current=null] : iv_ruleFileDimension= ruleFileDimension EOF ;
    public final EObject entryRuleFileDimension() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFileDimension = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:947:2: (iv_ruleFileDimension= ruleFileDimension EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:948:2: iv_ruleFileDimension= ruleFileDimension EOF
            {
             newCompositeNode(grammarAccess.getFileDimensionRule()); 
            pushFollow(FOLLOW_ruleFileDimension_in_entryRuleFileDimension1914);
            iv_ruleFileDimension=ruleFileDimension();

            state._fsp--;

             current =iv_ruleFileDimension; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFileDimension1924); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFileDimension"


    // $ANTLR start "ruleFileDimension"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:955:1: ruleFileDimension returns [EObject current=null] : (otherlv_0= 'size' otherlv_1= ':' ( (lv_size_2_0= RULE_NATURAL_NUMBER ) ) ( (lv_digest_3_0= ruleDigest ) )? ) ;
    public final EObject ruleFileDimension() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_size_2_0=null;
        EObject lv_digest_3_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:958:28: ( (otherlv_0= 'size' otherlv_1= ':' ( (lv_size_2_0= RULE_NATURAL_NUMBER ) ) ( (lv_digest_3_0= ruleDigest ) )? ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:959:1: (otherlv_0= 'size' otherlv_1= ':' ( (lv_size_2_0= RULE_NATURAL_NUMBER ) ) ( (lv_digest_3_0= ruleDigest ) )? )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:959:1: (otherlv_0= 'size' otherlv_1= ':' ( (lv_size_2_0= RULE_NATURAL_NUMBER ) ) ( (lv_digest_3_0= ruleDigest ) )? )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:959:3: otherlv_0= 'size' otherlv_1= ':' ( (lv_size_2_0= RULE_NATURAL_NUMBER ) ) ( (lv_digest_3_0= ruleDigest ) )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleFileDimension1961); 

                	newLeafNode(otherlv_0, grammarAccess.getFileDimensionAccess().getSizeKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleFileDimension1973); 

                	newLeafNode(otherlv_1, grammarAccess.getFileDimensionAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:967:1: ( (lv_size_2_0= RULE_NATURAL_NUMBER ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:968:1: (lv_size_2_0= RULE_NATURAL_NUMBER )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:968:1: (lv_size_2_0= RULE_NATURAL_NUMBER )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:969:3: lv_size_2_0= RULE_NATURAL_NUMBER
            {
            lv_size_2_0=(Token)match(input,RULE_NATURAL_NUMBER,FOLLOW_RULE_NATURAL_NUMBER_in_ruleFileDimension1990); 

            			newLeafNode(lv_size_2_0, grammarAccess.getFileDimensionAccess().getSizeNATURAL_NUMBERTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFileDimensionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"size",
                    		lv_size_2_0, 
                    		"NATURAL_NUMBER");
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:985:2: ( (lv_digest_3_0= ruleDigest ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==31) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:986:1: (lv_digest_3_0= ruleDigest )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:986:1: (lv_digest_3_0= ruleDigest )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:987:3: lv_digest_3_0= ruleDigest
                    {
                     
                    	        newCompositeNode(grammarAccess.getFileDimensionAccess().getDigestDigestParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDigest_in_ruleFileDimension2016);
                    lv_digest_3_0=ruleDigest();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFileDimensionRule());
                    	        }
                           		set(
                           			current, 
                           			"digest",
                            		lv_digest_3_0, 
                            		"Digest");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFileDimension"


    // $ANTLR start "entryRuleDigest"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1011:1: entryRuleDigest returns [EObject current=null] : iv_ruleDigest= ruleDigest EOF ;
    public final EObject entryRuleDigest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDigest = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1012:2: (iv_ruleDigest= ruleDigest EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1013:2: iv_ruleDigest= ruleDigest EOF
            {
             newCompositeNode(grammarAccess.getDigestRule()); 
            pushFollow(FOLLOW_ruleDigest_in_entryRuleDigest2053);
            iv_ruleDigest=ruleDigest();

            state._fsp--;

             current =iv_ruleDigest; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDigest2063); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDigest"


    // $ANTLR start "ruleDigest"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1020:1: ruleDigest returns [EObject current=null] : (otherlv_0= 'digest' otherlv_1= ':' ( (lv_digest_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleDigest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_digest_2_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1023:28: ( (otherlv_0= 'digest' otherlv_1= ':' ( (lv_digest_2_0= RULE_STRING ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1024:1: (otherlv_0= 'digest' otherlv_1= ':' ( (lv_digest_2_0= RULE_STRING ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1024:1: (otherlv_0= 'digest' otherlv_1= ':' ( (lv_digest_2_0= RULE_STRING ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1024:3: otherlv_0= 'digest' otherlv_1= ':' ( (lv_digest_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleDigest2100); 

                	newLeafNode(otherlv_0, grammarAccess.getDigestAccess().getDigestKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleDigest2112); 

                	newLeafNode(otherlv_1, grammarAccess.getDigestAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1032:1: ( (lv_digest_2_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1033:1: (lv_digest_2_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1033:1: (lv_digest_2_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1034:3: lv_digest_2_0= RULE_STRING
            {
            lv_digest_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDigest2129); 

            			newLeafNode(lv_digest_2_0, grammarAccess.getDigestAccess().getDigestSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDigestRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"digest",
                    		lv_digest_2_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDigest"


    // $ANTLR start "entryRuleTechnologyInfo"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1058:1: entryRuleTechnologyInfo returns [EObject current=null] : iv_ruleTechnologyInfo= ruleTechnologyInfo EOF ;
    public final EObject entryRuleTechnologyInfo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyInfo = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1059:2: (iv_ruleTechnologyInfo= ruleTechnologyInfo EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1060:2: iv_ruleTechnologyInfo= ruleTechnologyInfo EOF
            {
             newCompositeNode(grammarAccess.getTechnologyInfoRule()); 
            pushFollow(FOLLOW_ruleTechnologyInfo_in_entryRuleTechnologyInfo2170);
            iv_ruleTechnologyInfo=ruleTechnologyInfo();

            state._fsp--;

             current =iv_ruleTechnologyInfo; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTechnologyInfo2180); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTechnologyInfo"


    // $ANTLR start "ruleTechnologyInfo"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1067:1: ruleTechnologyInfo returns [EObject current=null] : ( ( (lv_programmingLanguage_0_0= ruleProgrammingLanguage ) ) ( (lv_software_1_0= ruleSoftware ) ) ( (lv_hardware_2_0= ruleHardware ) ) ) ;
    public final EObject ruleTechnologyInfo() throws RecognitionException {
        EObject current = null;

        EObject lv_programmingLanguage_0_0 = null;

        EObject lv_software_1_0 = null;

        EObject lv_hardware_2_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1070:28: ( ( ( (lv_programmingLanguage_0_0= ruleProgrammingLanguage ) ) ( (lv_software_1_0= ruleSoftware ) ) ( (lv_hardware_2_0= ruleHardware ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1071:1: ( ( (lv_programmingLanguage_0_0= ruleProgrammingLanguage ) ) ( (lv_software_1_0= ruleSoftware ) ) ( (lv_hardware_2_0= ruleHardware ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1071:1: ( ( (lv_programmingLanguage_0_0= ruleProgrammingLanguage ) ) ( (lv_software_1_0= ruleSoftware ) ) ( (lv_hardware_2_0= ruleHardware ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1071:2: ( (lv_programmingLanguage_0_0= ruleProgrammingLanguage ) ) ( (lv_software_1_0= ruleSoftware ) ) ( (lv_hardware_2_0= ruleHardware ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1071:2: ( (lv_programmingLanguage_0_0= ruleProgrammingLanguage ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1072:1: (lv_programmingLanguage_0_0= ruleProgrammingLanguage )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1072:1: (lv_programmingLanguage_0_0= ruleProgrammingLanguage )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1073:3: lv_programmingLanguage_0_0= ruleProgrammingLanguage
            {
             
            	        newCompositeNode(grammarAccess.getTechnologyInfoAccess().getProgrammingLanguageProgrammingLanguageParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleProgrammingLanguage_in_ruleTechnologyInfo2226);
            lv_programmingLanguage_0_0=ruleProgrammingLanguage();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTechnologyInfoRule());
            	        }
                   		set(
                   			current, 
                   			"programmingLanguage",
                    		lv_programmingLanguage_0_0, 
                    		"ProgrammingLanguage");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1089:2: ( (lv_software_1_0= ruleSoftware ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1090:1: (lv_software_1_0= ruleSoftware )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1090:1: (lv_software_1_0= ruleSoftware )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1091:3: lv_software_1_0= ruleSoftware
            {
             
            	        newCompositeNode(grammarAccess.getTechnologyInfoAccess().getSoftwareSoftwareParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSoftware_in_ruleTechnologyInfo2247);
            lv_software_1_0=ruleSoftware();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTechnologyInfoRule());
            	        }
                   		set(
                   			current, 
                   			"software",
                    		lv_software_1_0, 
                    		"Software");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1107:2: ( (lv_hardware_2_0= ruleHardware ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1108:1: (lv_hardware_2_0= ruleHardware )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1108:1: (lv_hardware_2_0= ruleHardware )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1109:3: lv_hardware_2_0= ruleHardware
            {
             
            	        newCompositeNode(grammarAccess.getTechnologyInfoAccess().getHardwareHardwareParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleHardware_in_ruleTechnologyInfo2268);
            lv_hardware_2_0=ruleHardware();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTechnologyInfoRule());
            	        }
                   		set(
                   			current, 
                   			"hardware",
                    		lv_hardware_2_0, 
                    		"Hardware");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTechnologyInfo"


    // $ANTLR start "entryRuleProgrammingLanguage"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1133:1: entryRuleProgrammingLanguage returns [EObject current=null] : iv_ruleProgrammingLanguage= ruleProgrammingLanguage EOF ;
    public final EObject entryRuleProgrammingLanguage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgrammingLanguage = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1134:2: (iv_ruleProgrammingLanguage= ruleProgrammingLanguage EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1135:2: iv_ruleProgrammingLanguage= ruleProgrammingLanguage EOF
            {
             newCompositeNode(grammarAccess.getProgrammingLanguageRule()); 
            pushFollow(FOLLOW_ruleProgrammingLanguage_in_entryRuleProgrammingLanguage2304);
            iv_ruleProgrammingLanguage=ruleProgrammingLanguage();

            state._fsp--;

             current =iv_ruleProgrammingLanguage; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProgrammingLanguage2314); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgrammingLanguage"


    // $ANTLR start "ruleProgrammingLanguage"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1142:1: ruleProgrammingLanguage returns [EObject current=null] : (otherlv_0= 'programming_language' otherlv_1= ':' ( (lv_programmingLanguage_2_0= RULE_STRING ) ) ( (lv_version_3_0= ruleVersion ) ) ) ;
    public final EObject ruleProgrammingLanguage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_programmingLanguage_2_0=null;
        EObject lv_version_3_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1145:28: ( (otherlv_0= 'programming_language' otherlv_1= ':' ( (lv_programmingLanguage_2_0= RULE_STRING ) ) ( (lv_version_3_0= ruleVersion ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1146:1: (otherlv_0= 'programming_language' otherlv_1= ':' ( (lv_programmingLanguage_2_0= RULE_STRING ) ) ( (lv_version_3_0= ruleVersion ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1146:1: (otherlv_0= 'programming_language' otherlv_1= ':' ( (lv_programmingLanguage_2_0= RULE_STRING ) ) ( (lv_version_3_0= ruleVersion ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1146:3: otherlv_0= 'programming_language' otherlv_1= ':' ( (lv_programmingLanguage_2_0= RULE_STRING ) ) ( (lv_version_3_0= ruleVersion ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleProgrammingLanguage2351); 

                	newLeafNode(otherlv_0, grammarAccess.getProgrammingLanguageAccess().getProgramming_languageKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleProgrammingLanguage2363); 

                	newLeafNode(otherlv_1, grammarAccess.getProgrammingLanguageAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1154:1: ( (lv_programmingLanguage_2_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1155:1: (lv_programmingLanguage_2_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1155:1: (lv_programmingLanguage_2_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1156:3: lv_programmingLanguage_2_0= RULE_STRING
            {
            lv_programmingLanguage_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleProgrammingLanguage2380); 

            			newLeafNode(lv_programmingLanguage_2_0, grammarAccess.getProgrammingLanguageAccess().getProgrammingLanguageSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getProgrammingLanguageRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"programmingLanguage",
                    		lv_programmingLanguage_2_0, 
                    		"STRING");
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1172:2: ( (lv_version_3_0= ruleVersion ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1173:1: (lv_version_3_0= ruleVersion )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1173:1: (lv_version_3_0= ruleVersion )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1174:3: lv_version_3_0= ruleVersion
            {
             
            	        newCompositeNode(grammarAccess.getProgrammingLanguageAccess().getVersionVersionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleVersion_in_ruleProgrammingLanguage2406);
            lv_version_3_0=ruleVersion();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getProgrammingLanguageRule());
            	        }
                   		set(
                   			current, 
                   			"version",
                    		lv_version_3_0, 
                    		"Version");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgrammingLanguage"


    // $ANTLR start "entryRuleSoftware"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1198:1: entryRuleSoftware returns [EObject current=null] : iv_ruleSoftware= ruleSoftware EOF ;
    public final EObject entryRuleSoftware() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSoftware = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1199:2: (iv_ruleSoftware= ruleSoftware EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1200:2: iv_ruleSoftware= ruleSoftware EOF
            {
             newCompositeNode(grammarAccess.getSoftwareRule()); 
            pushFollow(FOLLOW_ruleSoftware_in_entryRuleSoftware2442);
            iv_ruleSoftware=ruleSoftware();

            state._fsp--;

             current =iv_ruleSoftware; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSoftware2452); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSoftware"


    // $ANTLR start "ruleSoftware"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1207:1: ruleSoftware returns [EObject current=null] : (otherlv_0= 'software' otherlv_1= '{' ( ( (lv_category_2_0= ruleSoftwareCategory ) ) otherlv_3= '{' ( (lv_component_4_0= ruleSoftwareComponent ) )+ otherlv_5= '}' )+ otherlv_6= '}' ) ;
    public final EObject ruleSoftware() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_category_2_0 = null;

        EObject lv_component_4_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1210:28: ( (otherlv_0= 'software' otherlv_1= '{' ( ( (lv_category_2_0= ruleSoftwareCategory ) ) otherlv_3= '{' ( (lv_component_4_0= ruleSoftwareComponent ) )+ otherlv_5= '}' )+ otherlv_6= '}' ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1211:1: (otherlv_0= 'software' otherlv_1= '{' ( ( (lv_category_2_0= ruleSoftwareCategory ) ) otherlv_3= '{' ( (lv_component_4_0= ruleSoftwareComponent ) )+ otherlv_5= '}' )+ otherlv_6= '}' )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1211:1: (otherlv_0= 'software' otherlv_1= '{' ( ( (lv_category_2_0= ruleSoftwareCategory ) ) otherlv_3= '{' ( (lv_component_4_0= ruleSoftwareComponent ) )+ otherlv_5= '}' )+ otherlv_6= '}' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1211:3: otherlv_0= 'software' otherlv_1= '{' ( ( (lv_category_2_0= ruleSoftwareCategory ) ) otherlv_3= '{' ( (lv_component_4_0= ruleSoftwareComponent ) )+ otherlv_5= '}' )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleSoftware2489); 

                	newLeafNode(otherlv_0, grammarAccess.getSoftwareAccess().getSoftwareKeyword_0());
                
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleSoftware2501); 

                	newLeafNode(otherlv_1, grammarAccess.getSoftwareAccess().getLeftCurlyBracketKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1219:1: ( ( (lv_category_2_0= ruleSoftwareCategory ) ) otherlv_3= '{' ( (lv_component_4_0= ruleSoftwareComponent ) )+ otherlv_5= '}' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==34) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1219:2: ( (lv_category_2_0= ruleSoftwareCategory ) ) otherlv_3= '{' ( (lv_component_4_0= ruleSoftwareComponent ) )+ otherlv_5= '}'
            	    {
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1219:2: ( (lv_category_2_0= ruleSoftwareCategory ) )
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1220:1: (lv_category_2_0= ruleSoftwareCategory )
            	    {
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1220:1: (lv_category_2_0= ruleSoftwareCategory )
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1221:3: lv_category_2_0= ruleSoftwareCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSoftwareAccess().getCategorySoftwareCategoryParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSoftwareCategory_in_ruleSoftware2523);
            	    lv_category_2_0=ruleSoftwareCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSoftwareRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_2_0, 
            	            		"SoftwareCategory");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleSoftware2535); 

            	        	newLeafNode(otherlv_3, grammarAccess.getSoftwareAccess().getLeftCurlyBracketKeyword_2_1());
            	        
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1241:1: ( (lv_component_4_0= ruleSoftwareComponent ) )+
            	    int cnt7=0;
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==35) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1242:1: (lv_component_4_0= ruleSoftwareComponent )
            	    	    {
            	    	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1242:1: (lv_component_4_0= ruleSoftwareComponent )
            	    	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1243:3: lv_component_4_0= ruleSoftwareComponent
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getSoftwareAccess().getComponentSoftwareComponentParserRuleCall_2_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleSoftwareComponent_in_ruleSoftware2556);
            	    	    lv_component_4_0=ruleSoftwareComponent();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getSoftwareRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"component",
            	    	            		lv_component_4_0, 
            	    	            		"SoftwareComponent");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt7 >= 1 ) break loop7;
            	                EarlyExitException eee =
            	                    new EarlyExitException(7, input);
            	                throw eee;
            	        }
            	        cnt7++;
            	    } while (true);

            	    otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleSoftware2569); 

            	        	newLeafNode(otherlv_5, grammarAccess.getSoftwareAccess().getRightCurlyBracketKeyword_2_3());
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleSoftware2583); 

                	newLeafNode(otherlv_6, grammarAccess.getSoftwareAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSoftware"


    // $ANTLR start "entryRuleSoftwareCategory"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1275:1: entryRuleSoftwareCategory returns [EObject current=null] : iv_ruleSoftwareCategory= ruleSoftwareCategory EOF ;
    public final EObject entryRuleSoftwareCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSoftwareCategory = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1276:2: (iv_ruleSoftwareCategory= ruleSoftwareCategory EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1277:2: iv_ruleSoftwareCategory= ruleSoftwareCategory EOF
            {
             newCompositeNode(grammarAccess.getSoftwareCategoryRule()); 
            pushFollow(FOLLOW_ruleSoftwareCategory_in_entryRuleSoftwareCategory2619);
            iv_ruleSoftwareCategory=ruleSoftwareCategory();

            state._fsp--;

             current =iv_ruleSoftwareCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSoftwareCategory2629); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSoftwareCategory"


    // $ANTLR start "ruleSoftwareCategory"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1284:1: ruleSoftwareCategory returns [EObject current=null] : (otherlv_0= 'category' otherlv_1= ':' ( (lv_category_2_0= RULE_STRING ) ) ( (lv_description_3_0= ruleDescription ) ) ) ;
    public final EObject ruleSoftwareCategory() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_category_2_0=null;
        EObject lv_description_3_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1287:28: ( (otherlv_0= 'category' otherlv_1= ':' ( (lv_category_2_0= RULE_STRING ) ) ( (lv_description_3_0= ruleDescription ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1288:1: (otherlv_0= 'category' otherlv_1= ':' ( (lv_category_2_0= RULE_STRING ) ) ( (lv_description_3_0= ruleDescription ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1288:1: (otherlv_0= 'category' otherlv_1= ':' ( (lv_category_2_0= RULE_STRING ) ) ( (lv_description_3_0= ruleDescription ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1288:3: otherlv_0= 'category' otherlv_1= ':' ( (lv_category_2_0= RULE_STRING ) ) ( (lv_description_3_0= ruleDescription ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleSoftwareCategory2666); 

                	newLeafNode(otherlv_0, grammarAccess.getSoftwareCategoryAccess().getCategoryKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleSoftwareCategory2678); 

                	newLeafNode(otherlv_1, grammarAccess.getSoftwareCategoryAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1296:1: ( (lv_category_2_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1297:1: (lv_category_2_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1297:1: (lv_category_2_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1298:3: lv_category_2_0= RULE_STRING
            {
            lv_category_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSoftwareCategory2695); 

            			newLeafNode(lv_category_2_0, grammarAccess.getSoftwareCategoryAccess().getCategorySTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSoftwareCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"category",
                    		lv_category_2_0, 
                    		"STRING");
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1314:2: ( (lv_description_3_0= ruleDescription ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1315:1: (lv_description_3_0= ruleDescription )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1315:1: (lv_description_3_0= ruleDescription )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1316:3: lv_description_3_0= ruleDescription
            {
             
            	        newCompositeNode(grammarAccess.getSoftwareCategoryAccess().getDescriptionDescriptionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleDescription_in_ruleSoftwareCategory2721);
            lv_description_3_0=ruleDescription();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSoftwareCategoryRule());
            	        }
                   		set(
                   			current, 
                   			"description",
                    		lv_description_3_0, 
                    		"Description");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSoftwareCategory"


    // $ANTLR start "entryRuleSoftwareComponent"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1340:1: entryRuleSoftwareComponent returns [EObject current=null] : iv_ruleSoftwareComponent= ruleSoftwareComponent EOF ;
    public final EObject entryRuleSoftwareComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSoftwareComponent = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1341:2: (iv_ruleSoftwareComponent= ruleSoftwareComponent EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1342:2: iv_ruleSoftwareComponent= ruleSoftwareComponent EOF
            {
             newCompositeNode(grammarAccess.getSoftwareComponentRule()); 
            pushFollow(FOLLOW_ruleSoftwareComponent_in_entryRuleSoftwareComponent2757);
            iv_ruleSoftwareComponent=ruleSoftwareComponent();

            state._fsp--;

             current =iv_ruleSoftwareComponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSoftwareComponent2767); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSoftwareComponent"


    // $ANTLR start "ruleSoftwareComponent"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1349:1: ruleSoftwareComponent returns [EObject current=null] : ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_version_1_0= ruleVersion ) ) ( (lv_license_2_0= ruleLicense ) )? ) ;
    public final EObject ruleSoftwareComponent() throws RecognitionException {
        EObject current = null;

        EObject lv_component_0_0 = null;

        EObject lv_version_1_0 = null;

        EObject lv_license_2_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1352:28: ( ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_version_1_0= ruleVersion ) ) ( (lv_license_2_0= ruleLicense ) )? ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1353:1: ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_version_1_0= ruleVersion ) ) ( (lv_license_2_0= ruleLicense ) )? )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1353:1: ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_version_1_0= ruleVersion ) ) ( (lv_license_2_0= ruleLicense ) )? )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1353:2: ( (lv_component_0_0= ruleComponent ) ) ( (lv_version_1_0= ruleVersion ) ) ( (lv_license_2_0= ruleLicense ) )?
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1353:2: ( (lv_component_0_0= ruleComponent ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1354:1: (lv_component_0_0= ruleComponent )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1354:1: (lv_component_0_0= ruleComponent )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1355:3: lv_component_0_0= ruleComponent
            {
             
            	        newCompositeNode(grammarAccess.getSoftwareComponentAccess().getComponentComponentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleComponent_in_ruleSoftwareComponent2813);
            lv_component_0_0=ruleComponent();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSoftwareComponentRule());
            	        }
                   		set(
                   			current, 
                   			"component",
                    		lv_component_0_0, 
                    		"Component");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1371:2: ( (lv_version_1_0= ruleVersion ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1372:1: (lv_version_1_0= ruleVersion )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1372:1: (lv_version_1_0= ruleVersion )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1373:3: lv_version_1_0= ruleVersion
            {
             
            	        newCompositeNode(grammarAccess.getSoftwareComponentAccess().getVersionVersionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVersion_in_ruleSoftwareComponent2834);
            lv_version_1_0=ruleVersion();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSoftwareComponentRule());
            	        }
                   		set(
                   			current, 
                   			"version",
                    		lv_version_1_0, 
                    		"Version");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1389:2: ( (lv_license_2_0= ruleLicense ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==37) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1390:1: (lv_license_2_0= ruleLicense )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1390:1: (lv_license_2_0= ruleLicense )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1391:3: lv_license_2_0= ruleLicense
                    {
                     
                    	        newCompositeNode(grammarAccess.getSoftwareComponentAccess().getLicenseLicenseParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLicense_in_ruleSoftwareComponent2855);
                    lv_license_2_0=ruleLicense();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSoftwareComponentRule());
                    	        }
                           		set(
                           			current, 
                           			"license",
                            		lv_license_2_0, 
                            		"License");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSoftwareComponent"


    // $ANTLR start "entryRuleComponent"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1415:1: entryRuleComponent returns [EObject current=null] : iv_ruleComponent= ruleComponent EOF ;
    public final EObject entryRuleComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponent = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1416:2: (iv_ruleComponent= ruleComponent EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1417:2: iv_ruleComponent= ruleComponent EOF
            {
             newCompositeNode(grammarAccess.getComponentRule()); 
            pushFollow(FOLLOW_ruleComponent_in_entryRuleComponent2892);
            iv_ruleComponent=ruleComponent();

            state._fsp--;

             current =iv_ruleComponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponent2902); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponent"


    // $ANTLR start "ruleComponent"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1424:1: ruleComponent returns [EObject current=null] : (otherlv_0= 'component' otherlv_1= ':' ( (lv_component_2_0= RULE_STRING ) ) ( (lv_description_3_0= ruleDescription ) ) ) ;
    public final EObject ruleComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_component_2_0=null;
        EObject lv_description_3_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1427:28: ( (otherlv_0= 'component' otherlv_1= ':' ( (lv_component_2_0= RULE_STRING ) ) ( (lv_description_3_0= ruleDescription ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1428:1: (otherlv_0= 'component' otherlv_1= ':' ( (lv_component_2_0= RULE_STRING ) ) ( (lv_description_3_0= ruleDescription ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1428:1: (otherlv_0= 'component' otherlv_1= ':' ( (lv_component_2_0= RULE_STRING ) ) ( (lv_description_3_0= ruleDescription ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1428:3: otherlv_0= 'component' otherlv_1= ':' ( (lv_component_2_0= RULE_STRING ) ) ( (lv_description_3_0= ruleDescription ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleComponent2939); 

                	newLeafNode(otherlv_0, grammarAccess.getComponentAccess().getComponentKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleComponent2951); 

                	newLeafNode(otherlv_1, grammarAccess.getComponentAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1436:1: ( (lv_component_2_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1437:1: (lv_component_2_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1437:1: (lv_component_2_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1438:3: lv_component_2_0= RULE_STRING
            {
            lv_component_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleComponent2968); 

            			newLeafNode(lv_component_2_0, grammarAccess.getComponentAccess().getComponentSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"component",
                    		lv_component_2_0, 
                    		"STRING");
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1454:2: ( (lv_description_3_0= ruleDescription ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1455:1: (lv_description_3_0= ruleDescription )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1455:1: (lv_description_3_0= ruleDescription )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1456:3: lv_description_3_0= ruleDescription
            {
             
            	        newCompositeNode(grammarAccess.getComponentAccess().getDescriptionDescriptionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleDescription_in_ruleComponent2994);
            lv_description_3_0=ruleDescription();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getComponentRule());
            	        }
                   		set(
                   			current, 
                   			"description",
                    		lv_description_3_0, 
                    		"Description");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponent"


    // $ANTLR start "entryRuleDescription"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1480:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1481:2: (iv_ruleDescription= ruleDescription EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1482:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription3030);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription3040); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescription"


    // $ANTLR start "ruleDescription"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1489:1: ruleDescription returns [EObject current=null] : (otherlv_0= 'description' otherlv_1= ':' ( (lv_description_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_description_2_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1492:28: ( (otherlv_0= 'description' otherlv_1= ':' ( (lv_description_2_0= RULE_STRING ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1493:1: (otherlv_0= 'description' otherlv_1= ':' ( (lv_description_2_0= RULE_STRING ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1493:1: (otherlv_0= 'description' otherlv_1= ':' ( (lv_description_2_0= RULE_STRING ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1493:3: otherlv_0= 'description' otherlv_1= ':' ( (lv_description_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleDescription3077); 

                	newLeafNode(otherlv_0, grammarAccess.getDescriptionAccess().getDescriptionKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleDescription3089); 

                	newLeafNode(otherlv_1, grammarAccess.getDescriptionAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1501:1: ( (lv_description_2_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1502:1: (lv_description_2_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1502:1: (lv_description_2_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1503:3: lv_description_2_0= RULE_STRING
            {
            lv_description_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescription3106); 

            			newLeafNode(lv_description_2_0, grammarAccess.getDescriptionAccess().getDescriptionSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDescriptionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"description",
                    		lv_description_2_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDescription"


    // $ANTLR start "entryRuleLicense"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1527:1: entryRuleLicense returns [EObject current=null] : iv_ruleLicense= ruleLicense EOF ;
    public final EObject entryRuleLicense() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLicense = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1528:2: (iv_ruleLicense= ruleLicense EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1529:2: iv_ruleLicense= ruleLicense EOF
            {
             newCompositeNode(grammarAccess.getLicenseRule()); 
            pushFollow(FOLLOW_ruleLicense_in_entryRuleLicense3147);
            iv_ruleLicense=ruleLicense();

            state._fsp--;

             current =iv_ruleLicense; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLicense3157); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLicense"


    // $ANTLR start "ruleLicense"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1536:1: ruleLicense returns [EObject current=null] : (otherlv_0= 'license' otherlv_1= ':' ( ( (lv_license_2_1= 'GPL' | lv_license_2_2= 'LGPL' | lv_license_2_3= 'BSD' | lv_license_2_4= 'MIT' ) ) ) ) ;
    public final EObject ruleLicense() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_license_2_1=null;
        Token lv_license_2_2=null;
        Token lv_license_2_3=null;
        Token lv_license_2_4=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1539:28: ( (otherlv_0= 'license' otherlv_1= ':' ( ( (lv_license_2_1= 'GPL' | lv_license_2_2= 'LGPL' | lv_license_2_3= 'BSD' | lv_license_2_4= 'MIT' ) ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1540:1: (otherlv_0= 'license' otherlv_1= ':' ( ( (lv_license_2_1= 'GPL' | lv_license_2_2= 'LGPL' | lv_license_2_3= 'BSD' | lv_license_2_4= 'MIT' ) ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1540:1: (otherlv_0= 'license' otherlv_1= ':' ( ( (lv_license_2_1= 'GPL' | lv_license_2_2= 'LGPL' | lv_license_2_3= 'BSD' | lv_license_2_4= 'MIT' ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1540:3: otherlv_0= 'license' otherlv_1= ':' ( ( (lv_license_2_1= 'GPL' | lv_license_2_2= 'LGPL' | lv_license_2_3= 'BSD' | lv_license_2_4= 'MIT' ) ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleLicense3194); 

                	newLeafNode(otherlv_0, grammarAccess.getLicenseAccess().getLicenseKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleLicense3206); 

                	newLeafNode(otherlv_1, grammarAccess.getLicenseAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1548:1: ( ( (lv_license_2_1= 'GPL' | lv_license_2_2= 'LGPL' | lv_license_2_3= 'BSD' | lv_license_2_4= 'MIT' ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1549:1: ( (lv_license_2_1= 'GPL' | lv_license_2_2= 'LGPL' | lv_license_2_3= 'BSD' | lv_license_2_4= 'MIT' ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1549:1: ( (lv_license_2_1= 'GPL' | lv_license_2_2= 'LGPL' | lv_license_2_3= 'BSD' | lv_license_2_4= 'MIT' ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1550:1: (lv_license_2_1= 'GPL' | lv_license_2_2= 'LGPL' | lv_license_2_3= 'BSD' | lv_license_2_4= 'MIT' )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1550:1: (lv_license_2_1= 'GPL' | lv_license_2_2= 'LGPL' | lv_license_2_3= 'BSD' | lv_license_2_4= 'MIT' )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt10=1;
                }
                break;
            case 39:
                {
                alt10=2;
                }
                break;
            case 40:
                {
                alt10=3;
                }
                break;
            case 41:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1551:3: lv_license_2_1= 'GPL'
                    {
                    lv_license_2_1=(Token)match(input,38,FOLLOW_38_in_ruleLicense3226); 

                            newLeafNode(lv_license_2_1, grammarAccess.getLicenseAccess().getLicenseGPLKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLicenseRule());
                    	        }
                           		setWithLastConsumed(current, "license", lv_license_2_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1563:8: lv_license_2_2= 'LGPL'
                    {
                    lv_license_2_2=(Token)match(input,39,FOLLOW_39_in_ruleLicense3255); 

                            newLeafNode(lv_license_2_2, grammarAccess.getLicenseAccess().getLicenseLGPLKeyword_2_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLicenseRule());
                    	        }
                           		setWithLastConsumed(current, "license", lv_license_2_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1575:8: lv_license_2_3= 'BSD'
                    {
                    lv_license_2_3=(Token)match(input,40,FOLLOW_40_in_ruleLicense3284); 

                            newLeafNode(lv_license_2_3, grammarAccess.getLicenseAccess().getLicenseBSDKeyword_2_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLicenseRule());
                    	        }
                           		setWithLastConsumed(current, "license", lv_license_2_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1587:8: lv_license_2_4= 'MIT'
                    {
                    lv_license_2_4=(Token)match(input,41,FOLLOW_41_in_ruleLicense3313); 

                            newLeafNode(lv_license_2_4, grammarAccess.getLicenseAccess().getLicenseMITKeyword_2_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLicenseRule());
                    	        }
                           		setWithLastConsumed(current, "license", lv_license_2_4, null);
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLicense"


    // $ANTLR start "entryRuleHardware"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1610:1: entryRuleHardware returns [EObject current=null] : iv_ruleHardware= ruleHardware EOF ;
    public final EObject entryRuleHardware() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHardware = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1611:2: (iv_ruleHardware= ruleHardware EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1612:2: iv_ruleHardware= ruleHardware EOF
            {
             newCompositeNode(grammarAccess.getHardwareRule()); 
            pushFollow(FOLLOW_ruleHardware_in_entryRuleHardware3365);
            iv_ruleHardware=ruleHardware();

            state._fsp--;

             current =iv_ruleHardware; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHardware3375); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHardware"


    // $ANTLR start "ruleHardware"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1619:1: ruleHardware returns [EObject current=null] : (otherlv_0= 'hardware' otherlv_1= '{' ( ( (lv_box_2_0= ruleBox ) ) | ( (lv_compute_3_0= ruleCompute ) ) )? ( (lv_networkResource_4_0= ruleNetworkResource ) )* ( (lv_storageResource_5_0= ruleStorageResource ) )* otherlv_6= '}' ) ;
    public final EObject ruleHardware() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_6=null;
        EObject lv_box_2_0 = null;

        EObject lv_compute_3_0 = null;

        EObject lv_networkResource_4_0 = null;

        EObject lv_storageResource_5_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1622:28: ( (otherlv_0= 'hardware' otherlv_1= '{' ( ( (lv_box_2_0= ruleBox ) ) | ( (lv_compute_3_0= ruleCompute ) ) )? ( (lv_networkResource_4_0= ruleNetworkResource ) )* ( (lv_storageResource_5_0= ruleStorageResource ) )* otherlv_6= '}' ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1623:1: (otherlv_0= 'hardware' otherlv_1= '{' ( ( (lv_box_2_0= ruleBox ) ) | ( (lv_compute_3_0= ruleCompute ) ) )? ( (lv_networkResource_4_0= ruleNetworkResource ) )* ( (lv_storageResource_5_0= ruleStorageResource ) )* otherlv_6= '}' )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1623:1: (otherlv_0= 'hardware' otherlv_1= '{' ( ( (lv_box_2_0= ruleBox ) ) | ( (lv_compute_3_0= ruleCompute ) ) )? ( (lv_networkResource_4_0= ruleNetworkResource ) )* ( (lv_storageResource_5_0= ruleStorageResource ) )* otherlv_6= '}' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1623:3: otherlv_0= 'hardware' otherlv_1= '{' ( ( (lv_box_2_0= ruleBox ) ) | ( (lv_compute_3_0= ruleCompute ) ) )? ( (lv_networkResource_4_0= ruleNetworkResource ) )* ( (lv_storageResource_5_0= ruleStorageResource ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_42_in_ruleHardware3412); 

                	newLeafNode(otherlv_0, grammarAccess.getHardwareAccess().getHardwareKeyword_0());
                
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleHardware3424); 

                	newLeafNode(otherlv_1, grammarAccess.getHardwareAccess().getLeftCurlyBracketKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1631:1: ( ( (lv_box_2_0= ruleBox ) ) | ( (lv_compute_3_0= ruleCompute ) ) )?
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==43) ) {
                alt11=1;
            }
            else if ( (LA11_0==45) ) {
                alt11=2;
            }
            switch (alt11) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1631:2: ( (lv_box_2_0= ruleBox ) )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1631:2: ( (lv_box_2_0= ruleBox ) )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1632:1: (lv_box_2_0= ruleBox )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1632:1: (lv_box_2_0= ruleBox )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1633:3: lv_box_2_0= ruleBox
                    {
                     
                    	        newCompositeNode(grammarAccess.getHardwareAccess().getBoxBoxParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleBox_in_ruleHardware3446);
                    lv_box_2_0=ruleBox();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getHardwareRule());
                    	        }
                           		set(
                           			current, 
                           			"box",
                            		lv_box_2_0, 
                            		"Box");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1650:6: ( (lv_compute_3_0= ruleCompute ) )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1650:6: ( (lv_compute_3_0= ruleCompute ) )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1651:1: (lv_compute_3_0= ruleCompute )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1651:1: (lv_compute_3_0= ruleCompute )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1652:3: lv_compute_3_0= ruleCompute
                    {
                     
                    	        newCompositeNode(grammarAccess.getHardwareAccess().getComputeComputeParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCompute_in_ruleHardware3473);
                    lv_compute_3_0=ruleCompute();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getHardwareRule());
                    	        }
                           		set(
                           			current, 
                           			"compute",
                            		lv_compute_3_0, 
                            		"Compute");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1668:4: ( (lv_networkResource_4_0= ruleNetworkResource ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==53) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1669:1: (lv_networkResource_4_0= ruleNetworkResource )
            	    {
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1669:1: (lv_networkResource_4_0= ruleNetworkResource )
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1670:3: lv_networkResource_4_0= ruleNetworkResource
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHardwareAccess().getNetworkResourceNetworkResourceParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNetworkResource_in_ruleHardware3496);
            	    lv_networkResource_4_0=ruleNetworkResource();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHardwareRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"networkResource",
            	            		lv_networkResource_4_0, 
            	            		"NetworkResource");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1686:3: ( (lv_storageResource_5_0= ruleStorageResource ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==56) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1687:1: (lv_storageResource_5_0= ruleStorageResource )
            	    {
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1687:1: (lv_storageResource_5_0= ruleStorageResource )
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1688:3: lv_storageResource_5_0= ruleStorageResource
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHardwareAccess().getStorageResourceStorageResourceParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStorageResource_in_ruleHardware3518);
            	    lv_storageResource_5_0=ruleStorageResource();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHardwareRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"storageResource",
            	            		lv_storageResource_5_0, 
            	            		"StorageResource");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleHardware3531); 

                	newLeafNode(otherlv_6, grammarAccess.getHardwareAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHardware"


    // $ANTLR start "entryRuleBox"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1716:1: entryRuleBox returns [EObject current=null] : iv_ruleBox= ruleBox EOF ;
    public final EObject entryRuleBox() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBox = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1717:2: (iv_ruleBox= ruleBox EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1718:2: iv_ruleBox= ruleBox EOF
            {
             newCompositeNode(grammarAccess.getBoxRule()); 
            pushFollow(FOLLOW_ruleBox_in_entryRuleBox3567);
            iv_ruleBox=ruleBox();

            state._fsp--;

             current =iv_ruleBox; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBox3577); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBox"


    // $ANTLR start "ruleBox"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1725:1: ruleBox returns [EObject current=null] : (otherlv_0= 'box' ( (lv_box_1_0= ruleBoxComponent ) ) ) ;
    public final EObject ruleBox() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_box_1_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1728:28: ( (otherlv_0= 'box' ( (lv_box_1_0= ruleBoxComponent ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1729:1: (otherlv_0= 'box' ( (lv_box_1_0= ruleBoxComponent ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1729:1: (otherlv_0= 'box' ( (lv_box_1_0= ruleBoxComponent ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1729:3: otherlv_0= 'box' ( (lv_box_1_0= ruleBoxComponent ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleBox3614); 

                	newLeafNode(otherlv_0, grammarAccess.getBoxAccess().getBoxKeyword_0());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1733:1: ( (lv_box_1_0= ruleBoxComponent ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1734:1: (lv_box_1_0= ruleBoxComponent )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1734:1: (lv_box_1_0= ruleBoxComponent )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1735:3: lv_box_1_0= ruleBoxComponent
            {
             
            	        newCompositeNode(grammarAccess.getBoxAccess().getBoxBoxComponentParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleBoxComponent_in_ruleBox3635);
            lv_box_1_0=ruleBoxComponent();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBoxRule());
            	        }
                   		set(
                   			current, 
                   			"box",
                    		lv_box_1_0, 
                    		"BoxComponent");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBox"


    // $ANTLR start "entryRuleBoxComponent"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1759:1: entryRuleBoxComponent returns [EObject current=null] : iv_ruleBoxComponent= ruleBoxComponent EOF ;
    public final EObject entryRuleBoxComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoxComponent = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1760:2: (iv_ruleBoxComponent= ruleBoxComponent EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1761:2: iv_ruleBoxComponent= ruleBoxComponent EOF
            {
             newCompositeNode(grammarAccess.getBoxComponentRule()); 
            pushFollow(FOLLOW_ruleBoxComponent_in_entryRuleBoxComponent3671);
            iv_ruleBoxComponent=ruleBoxComponent();

            state._fsp--;

             current =iv_ruleBoxComponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoxComponent3681); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoxComponent"


    // $ANTLR start "ruleBoxComponent"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1768:1: ruleBoxComponent returns [EObject current=null] : ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_httpRequest_1_0= ruleHttpRequests ) ) ) ;
    public final EObject ruleBoxComponent() throws RecognitionException {
        EObject current = null;

        EObject lv_component_0_0 = null;

        EObject lv_httpRequest_1_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1771:28: ( ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_httpRequest_1_0= ruleHttpRequests ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1772:1: ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_httpRequest_1_0= ruleHttpRequests ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1772:1: ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_httpRequest_1_0= ruleHttpRequests ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1772:2: ( (lv_component_0_0= ruleComponent ) ) ( (lv_httpRequest_1_0= ruleHttpRequests ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1772:2: ( (lv_component_0_0= ruleComponent ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1773:1: (lv_component_0_0= ruleComponent )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1773:1: (lv_component_0_0= ruleComponent )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1774:3: lv_component_0_0= ruleComponent
            {
             
            	        newCompositeNode(grammarAccess.getBoxComponentAccess().getComponentComponentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleComponent_in_ruleBoxComponent3727);
            lv_component_0_0=ruleComponent();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBoxComponentRule());
            	        }
                   		set(
                   			current, 
                   			"component",
                    		lv_component_0_0, 
                    		"Component");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1790:2: ( (lv_httpRequest_1_0= ruleHttpRequests ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1791:1: (lv_httpRequest_1_0= ruleHttpRequests )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1791:1: (lv_httpRequest_1_0= ruleHttpRequests )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1792:3: lv_httpRequest_1_0= ruleHttpRequests
            {
             
            	        newCompositeNode(grammarAccess.getBoxComponentAccess().getHttpRequestHttpRequestsParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleHttpRequests_in_ruleBoxComponent3748);
            lv_httpRequest_1_0=ruleHttpRequests();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBoxComponentRule());
            	        }
                   		set(
                   			current, 
                   			"httpRequest",
                    		lv_httpRequest_1_0, 
                    		"HttpRequests");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoxComponent"


    // $ANTLR start "entryRuleHttpRequests"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1816:1: entryRuleHttpRequests returns [EObject current=null] : iv_ruleHttpRequests= ruleHttpRequests EOF ;
    public final EObject entryRuleHttpRequests() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpRequests = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1817:2: (iv_ruleHttpRequests= ruleHttpRequests EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1818:2: iv_ruleHttpRequests= ruleHttpRequests EOF
            {
             newCompositeNode(grammarAccess.getHttpRequestsRule()); 
            pushFollow(FOLLOW_ruleHttpRequests_in_entryRuleHttpRequests3784);
            iv_ruleHttpRequests=ruleHttpRequests();

            state._fsp--;

             current =iv_ruleHttpRequests; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHttpRequests3794); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHttpRequests"


    // $ANTLR start "ruleHttpRequests"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1825:1: ruleHttpRequests returns [EObject current=null] : (otherlv_0= 'http_requests' otherlv_1= ':' ( (lv_http_requests_2_0= RULE_NATURAL_NUMBER ) ) ) ;
    public final EObject ruleHttpRequests() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_http_requests_2_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1828:28: ( (otherlv_0= 'http_requests' otherlv_1= ':' ( (lv_http_requests_2_0= RULE_NATURAL_NUMBER ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1829:1: (otherlv_0= 'http_requests' otherlv_1= ':' ( (lv_http_requests_2_0= RULE_NATURAL_NUMBER ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1829:1: (otherlv_0= 'http_requests' otherlv_1= ':' ( (lv_http_requests_2_0= RULE_NATURAL_NUMBER ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1829:3: otherlv_0= 'http_requests' otherlv_1= ':' ( (lv_http_requests_2_0= RULE_NATURAL_NUMBER ) )
            {
            otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleHttpRequests3831); 

                	newLeafNode(otherlv_0, grammarAccess.getHttpRequestsAccess().getHttp_requestsKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleHttpRequests3843); 

                	newLeafNode(otherlv_1, grammarAccess.getHttpRequestsAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1837:1: ( (lv_http_requests_2_0= RULE_NATURAL_NUMBER ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1838:1: (lv_http_requests_2_0= RULE_NATURAL_NUMBER )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1838:1: (lv_http_requests_2_0= RULE_NATURAL_NUMBER )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1839:3: lv_http_requests_2_0= RULE_NATURAL_NUMBER
            {
            lv_http_requests_2_0=(Token)match(input,RULE_NATURAL_NUMBER,FOLLOW_RULE_NATURAL_NUMBER_in_ruleHttpRequests3860); 

            			newLeafNode(lv_http_requests_2_0, grammarAccess.getHttpRequestsAccess().getHttp_requestsNATURAL_NUMBERTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getHttpRequestsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"http_requests",
                    		lv_http_requests_2_0, 
                    		"NATURAL_NUMBER");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHttpRequests"


    // $ANTLR start "entryRuleCompute"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1863:1: entryRuleCompute returns [EObject current=null] : iv_ruleCompute= ruleCompute EOF ;
    public final EObject entryRuleCompute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompute = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1864:2: (iv_ruleCompute= ruleCompute EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1865:2: iv_ruleCompute= ruleCompute EOF
            {
             newCompositeNode(grammarAccess.getComputeRule()); 
            pushFollow(FOLLOW_ruleCompute_in_entryRuleCompute3901);
            iv_ruleCompute=ruleCompute();

            state._fsp--;

             current =iv_ruleCompute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompute3911); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompute"


    // $ANTLR start "ruleCompute"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1872:1: ruleCompute returns [EObject current=null] : (otherlv_0= 'compute' ( (lv_compute_1_0= ruleComputationalComponent ) ) ) ;
    public final EObject ruleCompute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_compute_1_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1875:28: ( (otherlv_0= 'compute' ( (lv_compute_1_0= ruleComputationalComponent ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1876:1: (otherlv_0= 'compute' ( (lv_compute_1_0= ruleComputationalComponent ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1876:1: (otherlv_0= 'compute' ( (lv_compute_1_0= ruleComputationalComponent ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1876:3: otherlv_0= 'compute' ( (lv_compute_1_0= ruleComputationalComponent ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleCompute3948); 

                	newLeafNode(otherlv_0, grammarAccess.getComputeAccess().getComputeKeyword_0());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1880:1: ( (lv_compute_1_0= ruleComputationalComponent ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1881:1: (lv_compute_1_0= ruleComputationalComponent )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1881:1: (lv_compute_1_0= ruleComputationalComponent )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1882:3: lv_compute_1_0= ruleComputationalComponent
            {
             
            	        newCompositeNode(grammarAccess.getComputeAccess().getComputeComputationalComponentParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleComputationalComponent_in_ruleCompute3969);
            lv_compute_1_0=ruleComputationalComponent();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getComputeRule());
            	        }
                   		set(
                   			current, 
                   			"compute",
                    		lv_compute_1_0, 
                    		"ComputationalComponent");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompute"


    // $ANTLR start "entryRuleComputationalComponent"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1906:1: entryRuleComputationalComponent returns [EObject current=null] : iv_ruleComputationalComponent= ruleComputationalComponent EOF ;
    public final EObject entryRuleComputationalComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputationalComponent = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1907:2: (iv_ruleComputationalComponent= ruleComputationalComponent EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1908:2: iv_ruleComputationalComponent= ruleComputationalComponent EOF
            {
             newCompositeNode(grammarAccess.getComputationalComponentRule()); 
            pushFollow(FOLLOW_ruleComputationalComponent_in_entryRuleComputationalComponent4005);
            iv_ruleComputationalComponent=ruleComputationalComponent();

            state._fsp--;

             current =iv_ruleComputationalComponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComputationalComponent4015); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComputationalComponent"


    // $ANTLR start "ruleComputationalComponent"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1915:1: ruleComputationalComponent returns [EObject current=null] : ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_architecture_1_0= ruleArchitecture ) ) ( (lv_cores_2_0= ruleCores ) ) ( (lv_speed_3_0= ruleSpeed ) ) ( (lv_memory_4_0= ruleMemory ) ) ( (lv_cache_5_0= ruleCache ) ) ) ;
    public final EObject ruleComputationalComponent() throws RecognitionException {
        EObject current = null;

        EObject lv_component_0_0 = null;

        EObject lv_architecture_1_0 = null;

        EObject lv_cores_2_0 = null;

        EObject lv_speed_3_0 = null;

        EObject lv_memory_4_0 = null;

        EObject lv_cache_5_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1918:28: ( ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_architecture_1_0= ruleArchitecture ) ) ( (lv_cores_2_0= ruleCores ) ) ( (lv_speed_3_0= ruleSpeed ) ) ( (lv_memory_4_0= ruleMemory ) ) ( (lv_cache_5_0= ruleCache ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1919:1: ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_architecture_1_0= ruleArchitecture ) ) ( (lv_cores_2_0= ruleCores ) ) ( (lv_speed_3_0= ruleSpeed ) ) ( (lv_memory_4_0= ruleMemory ) ) ( (lv_cache_5_0= ruleCache ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1919:1: ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_architecture_1_0= ruleArchitecture ) ) ( (lv_cores_2_0= ruleCores ) ) ( (lv_speed_3_0= ruleSpeed ) ) ( (lv_memory_4_0= ruleMemory ) ) ( (lv_cache_5_0= ruleCache ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1919:2: ( (lv_component_0_0= ruleComponent ) ) ( (lv_architecture_1_0= ruleArchitecture ) ) ( (lv_cores_2_0= ruleCores ) ) ( (lv_speed_3_0= ruleSpeed ) ) ( (lv_memory_4_0= ruleMemory ) ) ( (lv_cache_5_0= ruleCache ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1919:2: ( (lv_component_0_0= ruleComponent ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1920:1: (lv_component_0_0= ruleComponent )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1920:1: (lv_component_0_0= ruleComponent )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1921:3: lv_component_0_0= ruleComponent
            {
             
            	        newCompositeNode(grammarAccess.getComputationalComponentAccess().getComponentComponentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleComponent_in_ruleComputationalComponent4061);
            lv_component_0_0=ruleComponent();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getComputationalComponentRule());
            	        }
                   		set(
                   			current, 
                   			"component",
                    		lv_component_0_0, 
                    		"Component");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1937:2: ( (lv_architecture_1_0= ruleArchitecture ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1938:1: (lv_architecture_1_0= ruleArchitecture )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1938:1: (lv_architecture_1_0= ruleArchitecture )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1939:3: lv_architecture_1_0= ruleArchitecture
            {
             
            	        newCompositeNode(grammarAccess.getComputationalComponentAccess().getArchitectureArchitectureParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleArchitecture_in_ruleComputationalComponent4082);
            lv_architecture_1_0=ruleArchitecture();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getComputationalComponentRule());
            	        }
                   		set(
                   			current, 
                   			"architecture",
                    		lv_architecture_1_0, 
                    		"Architecture");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1955:2: ( (lv_cores_2_0= ruleCores ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1956:1: (lv_cores_2_0= ruleCores )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1956:1: (lv_cores_2_0= ruleCores )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1957:3: lv_cores_2_0= ruleCores
            {
             
            	        newCompositeNode(grammarAccess.getComputationalComponentAccess().getCoresCoresParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleCores_in_ruleComputationalComponent4103);
            lv_cores_2_0=ruleCores();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getComputationalComponentRule());
            	        }
                   		set(
                   			current, 
                   			"cores",
                    		lv_cores_2_0, 
                    		"Cores");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1973:2: ( (lv_speed_3_0= ruleSpeed ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1974:1: (lv_speed_3_0= ruleSpeed )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1974:1: (lv_speed_3_0= ruleSpeed )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1975:3: lv_speed_3_0= ruleSpeed
            {
             
            	        newCompositeNode(grammarAccess.getComputationalComponentAccess().getSpeedSpeedParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleSpeed_in_ruleComputationalComponent4124);
            lv_speed_3_0=ruleSpeed();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getComputationalComponentRule());
            	        }
                   		set(
                   			current, 
                   			"speed",
                    		lv_speed_3_0, 
                    		"Speed");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1991:2: ( (lv_memory_4_0= ruleMemory ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1992:1: (lv_memory_4_0= ruleMemory )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1992:1: (lv_memory_4_0= ruleMemory )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:1993:3: lv_memory_4_0= ruleMemory
            {
             
            	        newCompositeNode(grammarAccess.getComputationalComponentAccess().getMemoryMemoryParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleMemory_in_ruleComputationalComponent4145);
            lv_memory_4_0=ruleMemory();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getComputationalComponentRule());
            	        }
                   		set(
                   			current, 
                   			"memory",
                    		lv_memory_4_0, 
                    		"Memory");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2009:2: ( (lv_cache_5_0= ruleCache ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2010:1: (lv_cache_5_0= ruleCache )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2010:1: (lv_cache_5_0= ruleCache )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2011:3: lv_cache_5_0= ruleCache
            {
             
            	        newCompositeNode(grammarAccess.getComputationalComponentAccess().getCacheCacheParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleCache_in_ruleComputationalComponent4166);
            lv_cache_5_0=ruleCache();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getComputationalComponentRule());
            	        }
                   		set(
                   			current, 
                   			"cache",
                    		lv_cache_5_0, 
                    		"Cache");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComputationalComponent"


    // $ANTLR start "entryRuleArchitecture"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2035:1: entryRuleArchitecture returns [EObject current=null] : iv_ruleArchitecture= ruleArchitecture EOF ;
    public final EObject entryRuleArchitecture() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArchitecture = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2036:2: (iv_ruleArchitecture= ruleArchitecture EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2037:2: iv_ruleArchitecture= ruleArchitecture EOF
            {
             newCompositeNode(grammarAccess.getArchitectureRule()); 
            pushFollow(FOLLOW_ruleArchitecture_in_entryRuleArchitecture4202);
            iv_ruleArchitecture=ruleArchitecture();

            state._fsp--;

             current =iv_ruleArchitecture; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArchitecture4212); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArchitecture"


    // $ANTLR start "ruleArchitecture"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2044:1: ruleArchitecture returns [EObject current=null] : (otherlv_0= 'architecture' otherlv_1= ':' ( ( (lv_architecture_2_1= 'x86' | lv_architecture_2_2= 'x64' ) ) ) ) ;
    public final EObject ruleArchitecture() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_architecture_2_1=null;
        Token lv_architecture_2_2=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2047:28: ( (otherlv_0= 'architecture' otherlv_1= ':' ( ( (lv_architecture_2_1= 'x86' | lv_architecture_2_2= 'x64' ) ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2048:1: (otherlv_0= 'architecture' otherlv_1= ':' ( ( (lv_architecture_2_1= 'x86' | lv_architecture_2_2= 'x64' ) ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2048:1: (otherlv_0= 'architecture' otherlv_1= ':' ( ( (lv_architecture_2_1= 'x86' | lv_architecture_2_2= 'x64' ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2048:3: otherlv_0= 'architecture' otherlv_1= ':' ( ( (lv_architecture_2_1= 'x86' | lv_architecture_2_2= 'x64' ) ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_46_in_ruleArchitecture4249); 

                	newLeafNode(otherlv_0, grammarAccess.getArchitectureAccess().getArchitectureKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleArchitecture4261); 

                	newLeafNode(otherlv_1, grammarAccess.getArchitectureAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2056:1: ( ( (lv_architecture_2_1= 'x86' | lv_architecture_2_2= 'x64' ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2057:1: ( (lv_architecture_2_1= 'x86' | lv_architecture_2_2= 'x64' ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2057:1: ( (lv_architecture_2_1= 'x86' | lv_architecture_2_2= 'x64' ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2058:1: (lv_architecture_2_1= 'x86' | lv_architecture_2_2= 'x64' )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2058:1: (lv_architecture_2_1= 'x86' | lv_architecture_2_2= 'x64' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==47) ) {
                alt14=1;
            }
            else if ( (LA14_0==48) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2059:3: lv_architecture_2_1= 'x86'
                    {
                    lv_architecture_2_1=(Token)match(input,47,FOLLOW_47_in_ruleArchitecture4281); 

                            newLeafNode(lv_architecture_2_1, grammarAccess.getArchitectureAccess().getArchitectureX86Keyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getArchitectureRule());
                    	        }
                           		setWithLastConsumed(current, "architecture", lv_architecture_2_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2071:8: lv_architecture_2_2= 'x64'
                    {
                    lv_architecture_2_2=(Token)match(input,48,FOLLOW_48_in_ruleArchitecture4310); 

                            newLeafNode(lv_architecture_2_2, grammarAccess.getArchitectureAccess().getArchitectureX64Keyword_2_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getArchitectureRule());
                    	        }
                           		setWithLastConsumed(current, "architecture", lv_architecture_2_2, null);
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArchitecture"


    // $ANTLR start "entryRuleCores"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2094:1: entryRuleCores returns [EObject current=null] : iv_ruleCores= ruleCores EOF ;
    public final EObject entryRuleCores() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCores = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2095:2: (iv_ruleCores= ruleCores EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2096:2: iv_ruleCores= ruleCores EOF
            {
             newCompositeNode(grammarAccess.getCoresRule()); 
            pushFollow(FOLLOW_ruleCores_in_entryRuleCores4362);
            iv_ruleCores=ruleCores();

            state._fsp--;

             current =iv_ruleCores; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCores4372); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCores"


    // $ANTLR start "ruleCores"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2103:1: ruleCores returns [EObject current=null] : (otherlv_0= 'cores' otherlv_1= ':' ( (lv_cores_2_0= RULE_NATURAL_NUMBER ) ) ) ;
    public final EObject ruleCores() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_cores_2_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2106:28: ( (otherlv_0= 'cores' otherlv_1= ':' ( (lv_cores_2_0= RULE_NATURAL_NUMBER ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2107:1: (otherlv_0= 'cores' otherlv_1= ':' ( (lv_cores_2_0= RULE_NATURAL_NUMBER ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2107:1: (otherlv_0= 'cores' otherlv_1= ':' ( (lv_cores_2_0= RULE_NATURAL_NUMBER ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2107:3: otherlv_0= 'cores' otherlv_1= ':' ( (lv_cores_2_0= RULE_NATURAL_NUMBER ) )
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleCores4409); 

                	newLeafNode(otherlv_0, grammarAccess.getCoresAccess().getCoresKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleCores4421); 

                	newLeafNode(otherlv_1, grammarAccess.getCoresAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2115:1: ( (lv_cores_2_0= RULE_NATURAL_NUMBER ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2116:1: (lv_cores_2_0= RULE_NATURAL_NUMBER )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2116:1: (lv_cores_2_0= RULE_NATURAL_NUMBER )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2117:3: lv_cores_2_0= RULE_NATURAL_NUMBER
            {
            lv_cores_2_0=(Token)match(input,RULE_NATURAL_NUMBER,FOLLOW_RULE_NATURAL_NUMBER_in_ruleCores4438); 

            			newLeafNode(lv_cores_2_0, grammarAccess.getCoresAccess().getCoresNATURAL_NUMBERTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCoresRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"cores",
                    		lv_cores_2_0, 
                    		"NATURAL_NUMBER");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCores"


    // $ANTLR start "entryRuleSpeed"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2141:1: entryRuleSpeed returns [EObject current=null] : iv_ruleSpeed= ruleSpeed EOF ;
    public final EObject entryRuleSpeed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpeed = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2142:2: (iv_ruleSpeed= ruleSpeed EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2143:2: iv_ruleSpeed= ruleSpeed EOF
            {
             newCompositeNode(grammarAccess.getSpeedRule()); 
            pushFollow(FOLLOW_ruleSpeed_in_entryRuleSpeed4479);
            iv_ruleSpeed=ruleSpeed();

            state._fsp--;

             current =iv_ruleSpeed; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpeed4489); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpeed"


    // $ANTLR start "ruleSpeed"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2150:1: ruleSpeed returns [EObject current=null] : (otherlv_0= 'speed' otherlv_1= ':' ( (lv_speed_2_0= RULE_NATURAL_NUMBER ) ) ) ;
    public final EObject ruleSpeed() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_speed_2_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2153:28: ( (otherlv_0= 'speed' otherlv_1= ':' ( (lv_speed_2_0= RULE_NATURAL_NUMBER ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2154:1: (otherlv_0= 'speed' otherlv_1= ':' ( (lv_speed_2_0= RULE_NATURAL_NUMBER ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2154:1: (otherlv_0= 'speed' otherlv_1= ':' ( (lv_speed_2_0= RULE_NATURAL_NUMBER ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2154:3: otherlv_0= 'speed' otherlv_1= ':' ( (lv_speed_2_0= RULE_NATURAL_NUMBER ) )
            {
            otherlv_0=(Token)match(input,50,FOLLOW_50_in_ruleSpeed4526); 

                	newLeafNode(otherlv_0, grammarAccess.getSpeedAccess().getSpeedKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleSpeed4538); 

                	newLeafNode(otherlv_1, grammarAccess.getSpeedAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2162:1: ( (lv_speed_2_0= RULE_NATURAL_NUMBER ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2163:1: (lv_speed_2_0= RULE_NATURAL_NUMBER )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2163:1: (lv_speed_2_0= RULE_NATURAL_NUMBER )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2164:3: lv_speed_2_0= RULE_NATURAL_NUMBER
            {
            lv_speed_2_0=(Token)match(input,RULE_NATURAL_NUMBER,FOLLOW_RULE_NATURAL_NUMBER_in_ruleSpeed4555); 

            			newLeafNode(lv_speed_2_0, grammarAccess.getSpeedAccess().getSpeedNATURAL_NUMBERTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSpeedRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"speed",
                    		lv_speed_2_0, 
                    		"NATURAL_NUMBER");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpeed"


    // $ANTLR start "entryRuleMemory"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2188:1: entryRuleMemory returns [EObject current=null] : iv_ruleMemory= ruleMemory EOF ;
    public final EObject entryRuleMemory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMemory = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2189:2: (iv_ruleMemory= ruleMemory EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2190:2: iv_ruleMemory= ruleMemory EOF
            {
             newCompositeNode(grammarAccess.getMemoryRule()); 
            pushFollow(FOLLOW_ruleMemory_in_entryRuleMemory4596);
            iv_ruleMemory=ruleMemory();

            state._fsp--;

             current =iv_ruleMemory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMemory4606); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMemory"


    // $ANTLR start "ruleMemory"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2197:1: ruleMemory returns [EObject current=null] : (otherlv_0= 'memory' otherlv_1= ':' ( (lv_memory_2_0= RULE_NATURAL_NUMBER ) ) ) ;
    public final EObject ruleMemory() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_memory_2_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2200:28: ( (otherlv_0= 'memory' otherlv_1= ':' ( (lv_memory_2_0= RULE_NATURAL_NUMBER ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2201:1: (otherlv_0= 'memory' otherlv_1= ':' ( (lv_memory_2_0= RULE_NATURAL_NUMBER ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2201:1: (otherlv_0= 'memory' otherlv_1= ':' ( (lv_memory_2_0= RULE_NATURAL_NUMBER ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2201:3: otherlv_0= 'memory' otherlv_1= ':' ( (lv_memory_2_0= RULE_NATURAL_NUMBER ) )
            {
            otherlv_0=(Token)match(input,51,FOLLOW_51_in_ruleMemory4643); 

                	newLeafNode(otherlv_0, grammarAccess.getMemoryAccess().getMemoryKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleMemory4655); 

                	newLeafNode(otherlv_1, grammarAccess.getMemoryAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2209:1: ( (lv_memory_2_0= RULE_NATURAL_NUMBER ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2210:1: (lv_memory_2_0= RULE_NATURAL_NUMBER )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2210:1: (lv_memory_2_0= RULE_NATURAL_NUMBER )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2211:3: lv_memory_2_0= RULE_NATURAL_NUMBER
            {
            lv_memory_2_0=(Token)match(input,RULE_NATURAL_NUMBER,FOLLOW_RULE_NATURAL_NUMBER_in_ruleMemory4672); 

            			newLeafNode(lv_memory_2_0, grammarAccess.getMemoryAccess().getMemoryNATURAL_NUMBERTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMemoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"memory",
                    		lv_memory_2_0, 
                    		"NATURAL_NUMBER");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMemory"


    // $ANTLR start "entryRuleCache"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2235:1: entryRuleCache returns [EObject current=null] : iv_ruleCache= ruleCache EOF ;
    public final EObject entryRuleCache() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCache = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2236:2: (iv_ruleCache= ruleCache EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2237:2: iv_ruleCache= ruleCache EOF
            {
             newCompositeNode(grammarAccess.getCacheRule()); 
            pushFollow(FOLLOW_ruleCache_in_entryRuleCache4713);
            iv_ruleCache=ruleCache();

            state._fsp--;

             current =iv_ruleCache; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCache4723); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCache"


    // $ANTLR start "ruleCache"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2244:1: ruleCache returns [EObject current=null] : (otherlv_0= 'cache' otherlv_1= ':' ( (lv_cache_2_0= RULE_NATURAL_NUMBER ) ) ) ;
    public final EObject ruleCache() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_cache_2_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2247:28: ( (otherlv_0= 'cache' otherlv_1= ':' ( (lv_cache_2_0= RULE_NATURAL_NUMBER ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2248:1: (otherlv_0= 'cache' otherlv_1= ':' ( (lv_cache_2_0= RULE_NATURAL_NUMBER ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2248:1: (otherlv_0= 'cache' otherlv_1= ':' ( (lv_cache_2_0= RULE_NATURAL_NUMBER ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2248:3: otherlv_0= 'cache' otherlv_1= ':' ( (lv_cache_2_0= RULE_NATURAL_NUMBER ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleCache4760); 

                	newLeafNode(otherlv_0, grammarAccess.getCacheAccess().getCacheKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleCache4772); 

                	newLeafNode(otherlv_1, grammarAccess.getCacheAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2256:1: ( (lv_cache_2_0= RULE_NATURAL_NUMBER ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2257:1: (lv_cache_2_0= RULE_NATURAL_NUMBER )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2257:1: (lv_cache_2_0= RULE_NATURAL_NUMBER )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2258:3: lv_cache_2_0= RULE_NATURAL_NUMBER
            {
            lv_cache_2_0=(Token)match(input,RULE_NATURAL_NUMBER,FOLLOW_RULE_NATURAL_NUMBER_in_ruleCache4789); 

            			newLeafNode(lv_cache_2_0, grammarAccess.getCacheAccess().getCacheNATURAL_NUMBERTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCacheRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"cache",
                    		lv_cache_2_0, 
                    		"NATURAL_NUMBER");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCache"


    // $ANTLR start "entryRuleNetworkResource"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2282:1: entryRuleNetworkResource returns [EObject current=null] : iv_ruleNetworkResource= ruleNetworkResource EOF ;
    public final EObject entryRuleNetworkResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNetworkResource = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2283:2: (iv_ruleNetworkResource= ruleNetworkResource EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2284:2: iv_ruleNetworkResource= ruleNetworkResource EOF
            {
             newCompositeNode(grammarAccess.getNetworkResourceRule()); 
            pushFollow(FOLLOW_ruleNetworkResource_in_entryRuleNetworkResource4830);
            iv_ruleNetworkResource=ruleNetworkResource();

            state._fsp--;

             current =iv_ruleNetworkResource; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNetworkResource4840); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNetworkResource"


    // $ANTLR start "ruleNetworkResource"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2291:1: ruleNetworkResource returns [EObject current=null] : (otherlv_0= 'network_resource' ( (lv_networkResource_1_0= ruleCommunicationalComponent ) ) ) ;
    public final EObject ruleNetworkResource() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_networkResource_1_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2294:28: ( (otherlv_0= 'network_resource' ( (lv_networkResource_1_0= ruleCommunicationalComponent ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2295:1: (otherlv_0= 'network_resource' ( (lv_networkResource_1_0= ruleCommunicationalComponent ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2295:1: (otherlv_0= 'network_resource' ( (lv_networkResource_1_0= ruleCommunicationalComponent ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2295:3: otherlv_0= 'network_resource' ( (lv_networkResource_1_0= ruleCommunicationalComponent ) )
            {
            otherlv_0=(Token)match(input,53,FOLLOW_53_in_ruleNetworkResource4877); 

                	newLeafNode(otherlv_0, grammarAccess.getNetworkResourceAccess().getNetwork_resourceKeyword_0());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2299:1: ( (lv_networkResource_1_0= ruleCommunicationalComponent ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2300:1: (lv_networkResource_1_0= ruleCommunicationalComponent )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2300:1: (lv_networkResource_1_0= ruleCommunicationalComponent )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2301:3: lv_networkResource_1_0= ruleCommunicationalComponent
            {
             
            	        newCompositeNode(grammarAccess.getNetworkResourceAccess().getNetworkResourceCommunicationalComponentParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleCommunicationalComponent_in_ruleNetworkResource4898);
            lv_networkResource_1_0=ruleCommunicationalComponent();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNetworkResourceRule());
            	        }
                   		set(
                   			current, 
                   			"networkResource",
                    		lv_networkResource_1_0, 
                    		"CommunicationalComponent");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNetworkResource"


    // $ANTLR start "entryRuleCommunicationalComponent"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2325:1: entryRuleCommunicationalComponent returns [EObject current=null] : iv_ruleCommunicationalComponent= ruleCommunicationalComponent EOF ;
    public final EObject entryRuleCommunicationalComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommunicationalComponent = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2326:2: (iv_ruleCommunicationalComponent= ruleCommunicationalComponent EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2327:2: iv_ruleCommunicationalComponent= ruleCommunicationalComponent EOF
            {
             newCompositeNode(grammarAccess.getCommunicationalComponentRule()); 
            pushFollow(FOLLOW_ruleCommunicationalComponent_in_entryRuleCommunicationalComponent4934);
            iv_ruleCommunicationalComponent=ruleCommunicationalComponent();

            state._fsp--;

             current =iv_ruleCommunicationalComponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommunicationalComponent4944); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommunicationalComponent"


    // $ANTLR start "ruleCommunicationalComponent"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2334:1: ruleCommunicationalComponent returns [EObject current=null] : ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_bandwidth_1_0= ruleBandwidth ) ) ( (lv_latency_2_0= ruleLatency ) )? ) ;
    public final EObject ruleCommunicationalComponent() throws RecognitionException {
        EObject current = null;

        EObject lv_component_0_0 = null;

        EObject lv_bandwidth_1_0 = null;

        EObject lv_latency_2_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2337:28: ( ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_bandwidth_1_0= ruleBandwidth ) ) ( (lv_latency_2_0= ruleLatency ) )? ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2338:1: ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_bandwidth_1_0= ruleBandwidth ) ) ( (lv_latency_2_0= ruleLatency ) )? )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2338:1: ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_bandwidth_1_0= ruleBandwidth ) ) ( (lv_latency_2_0= ruleLatency ) )? )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2338:2: ( (lv_component_0_0= ruleComponent ) ) ( (lv_bandwidth_1_0= ruleBandwidth ) ) ( (lv_latency_2_0= ruleLatency ) )?
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2338:2: ( (lv_component_0_0= ruleComponent ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2339:1: (lv_component_0_0= ruleComponent )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2339:1: (lv_component_0_0= ruleComponent )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2340:3: lv_component_0_0= ruleComponent
            {
             
            	        newCompositeNode(grammarAccess.getCommunicationalComponentAccess().getComponentComponentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleComponent_in_ruleCommunicationalComponent4990);
            lv_component_0_0=ruleComponent();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCommunicationalComponentRule());
            	        }
                   		set(
                   			current, 
                   			"component",
                    		lv_component_0_0, 
                    		"Component");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2356:2: ( (lv_bandwidth_1_0= ruleBandwidth ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2357:1: (lv_bandwidth_1_0= ruleBandwidth )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2357:1: (lv_bandwidth_1_0= ruleBandwidth )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2358:3: lv_bandwidth_1_0= ruleBandwidth
            {
             
            	        newCompositeNode(grammarAccess.getCommunicationalComponentAccess().getBandwidthBandwidthParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleBandwidth_in_ruleCommunicationalComponent5011);
            lv_bandwidth_1_0=ruleBandwidth();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCommunicationalComponentRule());
            	        }
                   		set(
                   			current, 
                   			"bandwidth",
                    		lv_bandwidth_1_0, 
                    		"Bandwidth");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2374:2: ( (lv_latency_2_0= ruleLatency ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==55) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2375:1: (lv_latency_2_0= ruleLatency )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2375:1: (lv_latency_2_0= ruleLatency )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2376:3: lv_latency_2_0= ruleLatency
                    {
                     
                    	        newCompositeNode(grammarAccess.getCommunicationalComponentAccess().getLatencyLatencyParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLatency_in_ruleCommunicationalComponent5032);
                    lv_latency_2_0=ruleLatency();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCommunicationalComponentRule());
                    	        }
                           		set(
                           			current, 
                           			"latency",
                            		lv_latency_2_0, 
                            		"Latency");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommunicationalComponent"


    // $ANTLR start "entryRuleBandwidth"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2400:1: entryRuleBandwidth returns [EObject current=null] : iv_ruleBandwidth= ruleBandwidth EOF ;
    public final EObject entryRuleBandwidth() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBandwidth = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2401:2: (iv_ruleBandwidth= ruleBandwidth EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2402:2: iv_ruleBandwidth= ruleBandwidth EOF
            {
             newCompositeNode(grammarAccess.getBandwidthRule()); 
            pushFollow(FOLLOW_ruleBandwidth_in_entryRuleBandwidth5069);
            iv_ruleBandwidth=ruleBandwidth();

            state._fsp--;

             current =iv_ruleBandwidth; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBandwidth5079); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBandwidth"


    // $ANTLR start "ruleBandwidth"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2409:1: ruleBandwidth returns [EObject current=null] : (otherlv_0= 'bandwidth' otherlv_1= ':' ( (lv_bandwidth_2_0= RULE_NATURAL_NUMBER ) ) ) ;
    public final EObject ruleBandwidth() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_bandwidth_2_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2412:28: ( (otherlv_0= 'bandwidth' otherlv_1= ':' ( (lv_bandwidth_2_0= RULE_NATURAL_NUMBER ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2413:1: (otherlv_0= 'bandwidth' otherlv_1= ':' ( (lv_bandwidth_2_0= RULE_NATURAL_NUMBER ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2413:1: (otherlv_0= 'bandwidth' otherlv_1= ':' ( (lv_bandwidth_2_0= RULE_NATURAL_NUMBER ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2413:3: otherlv_0= 'bandwidth' otherlv_1= ':' ( (lv_bandwidth_2_0= RULE_NATURAL_NUMBER ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_54_in_ruleBandwidth5116); 

                	newLeafNode(otherlv_0, grammarAccess.getBandwidthAccess().getBandwidthKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleBandwidth5128); 

                	newLeafNode(otherlv_1, grammarAccess.getBandwidthAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2421:1: ( (lv_bandwidth_2_0= RULE_NATURAL_NUMBER ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2422:1: (lv_bandwidth_2_0= RULE_NATURAL_NUMBER )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2422:1: (lv_bandwidth_2_0= RULE_NATURAL_NUMBER )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2423:3: lv_bandwidth_2_0= RULE_NATURAL_NUMBER
            {
            lv_bandwidth_2_0=(Token)match(input,RULE_NATURAL_NUMBER,FOLLOW_RULE_NATURAL_NUMBER_in_ruleBandwidth5145); 

            			newLeafNode(lv_bandwidth_2_0, grammarAccess.getBandwidthAccess().getBandwidthNATURAL_NUMBERTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBandwidthRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"bandwidth",
                    		lv_bandwidth_2_0, 
                    		"NATURAL_NUMBER");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBandwidth"


    // $ANTLR start "entryRuleLatency"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2447:1: entryRuleLatency returns [EObject current=null] : iv_ruleLatency= ruleLatency EOF ;
    public final EObject entryRuleLatency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLatency = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2448:2: (iv_ruleLatency= ruleLatency EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2449:2: iv_ruleLatency= ruleLatency EOF
            {
             newCompositeNode(grammarAccess.getLatencyRule()); 
            pushFollow(FOLLOW_ruleLatency_in_entryRuleLatency5186);
            iv_ruleLatency=ruleLatency();

            state._fsp--;

             current =iv_ruleLatency; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLatency5196); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLatency"


    // $ANTLR start "ruleLatency"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2456:1: ruleLatency returns [EObject current=null] : (otherlv_0= 'latency' otherlv_1= ':' ( (lv_latency_2_0= RULE_NATURAL_NUMBER ) ) ) ;
    public final EObject ruleLatency() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_latency_2_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2459:28: ( (otherlv_0= 'latency' otherlv_1= ':' ( (lv_latency_2_0= RULE_NATURAL_NUMBER ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2460:1: (otherlv_0= 'latency' otherlv_1= ':' ( (lv_latency_2_0= RULE_NATURAL_NUMBER ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2460:1: (otherlv_0= 'latency' otherlv_1= ':' ( (lv_latency_2_0= RULE_NATURAL_NUMBER ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2460:3: otherlv_0= 'latency' otherlv_1= ':' ( (lv_latency_2_0= RULE_NATURAL_NUMBER ) )
            {
            otherlv_0=(Token)match(input,55,FOLLOW_55_in_ruleLatency5233); 

                	newLeafNode(otherlv_0, grammarAccess.getLatencyAccess().getLatencyKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleLatency5245); 

                	newLeafNode(otherlv_1, grammarAccess.getLatencyAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2468:1: ( (lv_latency_2_0= RULE_NATURAL_NUMBER ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2469:1: (lv_latency_2_0= RULE_NATURAL_NUMBER )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2469:1: (lv_latency_2_0= RULE_NATURAL_NUMBER )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2470:3: lv_latency_2_0= RULE_NATURAL_NUMBER
            {
            lv_latency_2_0=(Token)match(input,RULE_NATURAL_NUMBER,FOLLOW_RULE_NATURAL_NUMBER_in_ruleLatency5262); 

            			newLeafNode(lv_latency_2_0, grammarAccess.getLatencyAccess().getLatencyNATURAL_NUMBERTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLatencyRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"latency",
                    		lv_latency_2_0, 
                    		"NATURAL_NUMBER");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLatency"


    // $ANTLR start "entryRuleStorageResource"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2494:1: entryRuleStorageResource returns [EObject current=null] : iv_ruleStorageResource= ruleStorageResource EOF ;
    public final EObject entryRuleStorageResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStorageResource = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2495:2: (iv_ruleStorageResource= ruleStorageResource EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2496:2: iv_ruleStorageResource= ruleStorageResource EOF
            {
             newCompositeNode(grammarAccess.getStorageResourceRule()); 
            pushFollow(FOLLOW_ruleStorageResource_in_entryRuleStorageResource5303);
            iv_ruleStorageResource=ruleStorageResource();

            state._fsp--;

             current =iv_ruleStorageResource; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStorageResource5313); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStorageResource"


    // $ANTLR start "ruleStorageResource"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2503:1: ruleStorageResource returns [EObject current=null] : (otherlv_0= 'storage_resource' ( (lv_storageComponent_1_0= ruleStorageComponent ) ) ) ;
    public final EObject ruleStorageResource() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_storageComponent_1_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2506:28: ( (otherlv_0= 'storage_resource' ( (lv_storageComponent_1_0= ruleStorageComponent ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2507:1: (otherlv_0= 'storage_resource' ( (lv_storageComponent_1_0= ruleStorageComponent ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2507:1: (otherlv_0= 'storage_resource' ( (lv_storageComponent_1_0= ruleStorageComponent ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2507:3: otherlv_0= 'storage_resource' ( (lv_storageComponent_1_0= ruleStorageComponent ) )
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleStorageResource5350); 

                	newLeafNode(otherlv_0, grammarAccess.getStorageResourceAccess().getStorage_resourceKeyword_0());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2511:1: ( (lv_storageComponent_1_0= ruleStorageComponent ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2512:1: (lv_storageComponent_1_0= ruleStorageComponent )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2512:1: (lv_storageComponent_1_0= ruleStorageComponent )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2513:3: lv_storageComponent_1_0= ruleStorageComponent
            {
             
            	        newCompositeNode(grammarAccess.getStorageResourceAccess().getStorageComponentStorageComponentParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleStorageComponent_in_ruleStorageResource5371);
            lv_storageComponent_1_0=ruleStorageComponent();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStorageResourceRule());
            	        }
                   		set(
                   			current, 
                   			"storageComponent",
                    		lv_storageComponent_1_0, 
                    		"StorageComponent");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStorageResource"


    // $ANTLR start "entryRuleStorageComponent"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2537:1: entryRuleStorageComponent returns [EObject current=null] : iv_ruleStorageComponent= ruleStorageComponent EOF ;
    public final EObject entryRuleStorageComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStorageComponent = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2538:2: (iv_ruleStorageComponent= ruleStorageComponent EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2539:2: iv_ruleStorageComponent= ruleStorageComponent EOF
            {
             newCompositeNode(grammarAccess.getStorageComponentRule()); 
            pushFollow(FOLLOW_ruleStorageComponent_in_entryRuleStorageComponent5407);
            iv_ruleStorageComponent=ruleStorageComponent();

            state._fsp--;

             current =iv_ruleStorageComponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStorageComponent5417); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStorageComponent"


    // $ANTLR start "ruleStorageComponent"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2546:1: ruleStorageComponent returns [EObject current=null] : ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_capacity_1_0= ruleCapacity ) ) ( (lv_bandwidth_2_0= ruleBandwidth ) )? ) ;
    public final EObject ruleStorageComponent() throws RecognitionException {
        EObject current = null;

        EObject lv_component_0_0 = null;

        EObject lv_capacity_1_0 = null;

        EObject lv_bandwidth_2_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2549:28: ( ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_capacity_1_0= ruleCapacity ) ) ( (lv_bandwidth_2_0= ruleBandwidth ) )? ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2550:1: ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_capacity_1_0= ruleCapacity ) ) ( (lv_bandwidth_2_0= ruleBandwidth ) )? )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2550:1: ( ( (lv_component_0_0= ruleComponent ) ) ( (lv_capacity_1_0= ruleCapacity ) ) ( (lv_bandwidth_2_0= ruleBandwidth ) )? )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2550:2: ( (lv_component_0_0= ruleComponent ) ) ( (lv_capacity_1_0= ruleCapacity ) ) ( (lv_bandwidth_2_0= ruleBandwidth ) )?
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2550:2: ( (lv_component_0_0= ruleComponent ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2551:1: (lv_component_0_0= ruleComponent )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2551:1: (lv_component_0_0= ruleComponent )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2552:3: lv_component_0_0= ruleComponent
            {
             
            	        newCompositeNode(grammarAccess.getStorageComponentAccess().getComponentComponentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleComponent_in_ruleStorageComponent5463);
            lv_component_0_0=ruleComponent();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStorageComponentRule());
            	        }
                   		set(
                   			current, 
                   			"component",
                    		lv_component_0_0, 
                    		"Component");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2568:2: ( (lv_capacity_1_0= ruleCapacity ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2569:1: (lv_capacity_1_0= ruleCapacity )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2569:1: (lv_capacity_1_0= ruleCapacity )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2570:3: lv_capacity_1_0= ruleCapacity
            {
             
            	        newCompositeNode(grammarAccess.getStorageComponentAccess().getCapacityCapacityParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleCapacity_in_ruleStorageComponent5484);
            lv_capacity_1_0=ruleCapacity();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStorageComponentRule());
            	        }
                   		set(
                   			current, 
                   			"capacity",
                    		lv_capacity_1_0, 
                    		"Capacity");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2586:2: ( (lv_bandwidth_2_0= ruleBandwidth ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==54) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2587:1: (lv_bandwidth_2_0= ruleBandwidth )
                    {
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2587:1: (lv_bandwidth_2_0= ruleBandwidth )
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2588:3: lv_bandwidth_2_0= ruleBandwidth
                    {
                     
                    	        newCompositeNode(grammarAccess.getStorageComponentAccess().getBandwidthBandwidthParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleBandwidth_in_ruleStorageComponent5505);
                    lv_bandwidth_2_0=ruleBandwidth();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStorageComponentRule());
                    	        }
                           		set(
                           			current, 
                           			"bandwidth",
                            		lv_bandwidth_2_0, 
                            		"Bandwidth");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStorageComponent"


    // $ANTLR start "entryRuleCapacity"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2612:1: entryRuleCapacity returns [EObject current=null] : iv_ruleCapacity= ruleCapacity EOF ;
    public final EObject entryRuleCapacity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCapacity = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2613:2: (iv_ruleCapacity= ruleCapacity EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2614:2: iv_ruleCapacity= ruleCapacity EOF
            {
             newCompositeNode(grammarAccess.getCapacityRule()); 
            pushFollow(FOLLOW_ruleCapacity_in_entryRuleCapacity5542);
            iv_ruleCapacity=ruleCapacity();

            state._fsp--;

             current =iv_ruleCapacity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCapacity5552); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCapacity"


    // $ANTLR start "ruleCapacity"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2621:1: ruleCapacity returns [EObject current=null] : (otherlv_0= 'capacity' otherlv_1= ':' ( (lv_capacity_2_0= RULE_NATURAL_NUMBER ) ) ) ;
    public final EObject ruleCapacity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_capacity_2_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2624:28: ( (otherlv_0= 'capacity' otherlv_1= ':' ( (lv_capacity_2_0= RULE_NATURAL_NUMBER ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2625:1: (otherlv_0= 'capacity' otherlv_1= ':' ( (lv_capacity_2_0= RULE_NATURAL_NUMBER ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2625:1: (otherlv_0= 'capacity' otherlv_1= ':' ( (lv_capacity_2_0= RULE_NATURAL_NUMBER ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2625:3: otherlv_0= 'capacity' otherlv_1= ':' ( (lv_capacity_2_0= RULE_NATURAL_NUMBER ) )
            {
            otherlv_0=(Token)match(input,57,FOLLOW_57_in_ruleCapacity5589); 

                	newLeafNode(otherlv_0, grammarAccess.getCapacityAccess().getCapacityKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleCapacity5601); 

                	newLeafNode(otherlv_1, grammarAccess.getCapacityAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2633:1: ( (lv_capacity_2_0= RULE_NATURAL_NUMBER ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2634:1: (lv_capacity_2_0= RULE_NATURAL_NUMBER )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2634:1: (lv_capacity_2_0= RULE_NATURAL_NUMBER )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2635:3: lv_capacity_2_0= RULE_NATURAL_NUMBER
            {
            lv_capacity_2_0=(Token)match(input,RULE_NATURAL_NUMBER,FOLLOW_RULE_NATURAL_NUMBER_in_ruleCapacity5618); 

            			newLeafNode(lv_capacity_2_0, grammarAccess.getCapacityAccess().getCapacityNATURAL_NUMBERTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCapacityRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"capacity",
                    		lv_capacity_2_0, 
                    		"NATURAL_NUMBER");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCapacity"


    // $ANTLR start "entryRuleChannels"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2659:1: entryRuleChannels returns [EObject current=null] : iv_ruleChannels= ruleChannels EOF ;
    public final EObject entryRuleChannels() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChannels = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2660:2: (iv_ruleChannels= ruleChannels EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2661:2: iv_ruleChannels= ruleChannels EOF
            {
             newCompositeNode(grammarAccess.getChannelsRule()); 
            pushFollow(FOLLOW_ruleChannels_in_entryRuleChannels5659);
            iv_ruleChannels=ruleChannels();

            state._fsp--;

             current =iv_ruleChannels; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChannels5669); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChannels"


    // $ANTLR start "ruleChannels"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2668:1: ruleChannels returns [EObject current=null] : (otherlv_0= 'channels' otherlv_1= '{' ( (lv_channel_2_0= ruleChannel ) )* otherlv_3= '}' ) ;
    public final EObject ruleChannels() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_channel_2_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2671:28: ( (otherlv_0= 'channels' otherlv_1= '{' ( (lv_channel_2_0= ruleChannel ) )* otherlv_3= '}' ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2672:1: (otherlv_0= 'channels' otherlv_1= '{' ( (lv_channel_2_0= ruleChannel ) )* otherlv_3= '}' )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2672:1: (otherlv_0= 'channels' otherlv_1= '{' ( (lv_channel_2_0= ruleChannel ) )* otherlv_3= '}' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2672:3: otherlv_0= 'channels' otherlv_1= '{' ( (lv_channel_2_0= ruleChannel ) )* otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_58_in_ruleChannels5706); 

                	newLeafNode(otherlv_0, grammarAccess.getChannelsAccess().getChannelsKeyword_0());
                
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleChannels5718); 

                	newLeafNode(otherlv_1, grammarAccess.getChannelsAccess().getLeftCurlyBracketKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2680:1: ( (lv_channel_2_0= ruleChannel ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=59 && LA17_0<=61)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2681:1: (lv_channel_2_0= ruleChannel )
            	    {
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2681:1: (lv_channel_2_0= ruleChannel )
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2682:3: lv_channel_2_0= ruleChannel
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getChannelsAccess().getChannelChannelParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleChannel_in_ruleChannels5739);
            	    lv_channel_2_0=ruleChannel();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getChannelsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"channel",
            	            		lv_channel_2_0, 
            	            		"Channel");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleChannels5752); 

                	newLeafNode(otherlv_3, grammarAccess.getChannelsAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChannels"


    // $ANTLR start "entryRuleChannel"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2710:1: entryRuleChannel returns [EObject current=null] : iv_ruleChannel= ruleChannel EOF ;
    public final EObject entryRuleChannel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChannel = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2711:2: (iv_ruleChannel= ruleChannel EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2712:2: iv_ruleChannel= ruleChannel EOF
            {
             newCompositeNode(grammarAccess.getChannelRule()); 
            pushFollow(FOLLOW_ruleChannel_in_entryRuleChannel5788);
            iv_ruleChannel=ruleChannel();

            state._fsp--;

             current =iv_ruleChannel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChannel5798); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChannel"


    // $ANTLR start "ruleChannel"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2719:1: ruleChannel returns [EObject current=null] : ( (otherlv_0= 'api' | otherlv_1= 'cli' | otherlv_2= 'web_interface' ) otherlv_3= '{' ( (lv_operation_4_0= ruleOperation ) )* otherlv_5= '}' ) ;
    public final EObject ruleChannel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_operation_4_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2722:28: ( ( (otherlv_0= 'api' | otherlv_1= 'cli' | otherlv_2= 'web_interface' ) otherlv_3= '{' ( (lv_operation_4_0= ruleOperation ) )* otherlv_5= '}' ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2723:1: ( (otherlv_0= 'api' | otherlv_1= 'cli' | otherlv_2= 'web_interface' ) otherlv_3= '{' ( (lv_operation_4_0= ruleOperation ) )* otherlv_5= '}' )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2723:1: ( (otherlv_0= 'api' | otherlv_1= 'cli' | otherlv_2= 'web_interface' ) otherlv_3= '{' ( (lv_operation_4_0= ruleOperation ) )* otherlv_5= '}' )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2723:2: (otherlv_0= 'api' | otherlv_1= 'cli' | otherlv_2= 'web_interface' ) otherlv_3= '{' ( (lv_operation_4_0= ruleOperation ) )* otherlv_5= '}'
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2723:2: (otherlv_0= 'api' | otherlv_1= 'cli' | otherlv_2= 'web_interface' )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt18=1;
                }
                break;
            case 60:
                {
                alt18=2;
                }
                break;
            case 61:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2723:4: otherlv_0= 'api'
                    {
                    otherlv_0=(Token)match(input,59,FOLLOW_59_in_ruleChannel5836); 

                        	newLeafNode(otherlv_0, grammarAccess.getChannelAccess().getApiKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2728:7: otherlv_1= 'cli'
                    {
                    otherlv_1=(Token)match(input,60,FOLLOW_60_in_ruleChannel5854); 

                        	newLeafNode(otherlv_1, grammarAccess.getChannelAccess().getCliKeyword_0_1());
                        

                    }
                    break;
                case 3 :
                    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2733:7: otherlv_2= 'web_interface'
                    {
                    otherlv_2=(Token)match(input,61,FOLLOW_61_in_ruleChannel5872); 

                        	newLeafNode(otherlv_2, grammarAccess.getChannelAccess().getWeb_interfaceKeyword_0_2());
                        

                    }
                    break;

            }

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleChannel5885); 

                	newLeafNode(otherlv_3, grammarAccess.getChannelAccess().getLeftCurlyBracketKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2741:1: ( (lv_operation_4_0= ruleOperation ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==62) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2742:1: (lv_operation_4_0= ruleOperation )
            	    {
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2742:1: (lv_operation_4_0= ruleOperation )
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2743:3: lv_operation_4_0= ruleOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getChannelAccess().getOperationOperationParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOperation_in_ruleChannel5906);
            	    lv_operation_4_0=ruleOperation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getChannelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"operation",
            	            		lv_operation_4_0, 
            	            		"Operation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleChannel5919); 

                	newLeafNode(otherlv_5, grammarAccess.getChannelAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChannel"


    // $ANTLR start "entryRuleOperation"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2771:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2772:2: (iv_ruleOperation= ruleOperation EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2773:2: iv_ruleOperation= ruleOperation EOF
            {
             newCompositeNode(grammarAccess.getOperationRule()); 
            pushFollow(FOLLOW_ruleOperation_in_entryRuleOperation5955);
            iv_ruleOperation=ruleOperation();

            state._fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperation5965); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2780:1: ruleOperation returns [EObject current=null] : (otherlv_0= 'operation' otherlv_1= ':' ( (lv_operation_2_0= RULE_STRING ) ) ( (lv_description_3_0= ruleDescription ) ) ( (lv_command_4_0= ruleCommand ) ) ( (lv_informationReturned_5_0= ruleInformationReturned ) ) ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_operation_2_0=null;
        EObject lv_description_3_0 = null;

        EObject lv_command_4_0 = null;

        EObject lv_informationReturned_5_0 = null;


         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2783:28: ( (otherlv_0= 'operation' otherlv_1= ':' ( (lv_operation_2_0= RULE_STRING ) ) ( (lv_description_3_0= ruleDescription ) ) ( (lv_command_4_0= ruleCommand ) ) ( (lv_informationReturned_5_0= ruleInformationReturned ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2784:1: (otherlv_0= 'operation' otherlv_1= ':' ( (lv_operation_2_0= RULE_STRING ) ) ( (lv_description_3_0= ruleDescription ) ) ( (lv_command_4_0= ruleCommand ) ) ( (lv_informationReturned_5_0= ruleInformationReturned ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2784:1: (otherlv_0= 'operation' otherlv_1= ':' ( (lv_operation_2_0= RULE_STRING ) ) ( (lv_description_3_0= ruleDescription ) ) ( (lv_command_4_0= ruleCommand ) ) ( (lv_informationReturned_5_0= ruleInformationReturned ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2784:3: otherlv_0= 'operation' otherlv_1= ':' ( (lv_operation_2_0= RULE_STRING ) ) ( (lv_description_3_0= ruleDescription ) ) ( (lv_command_4_0= ruleCommand ) ) ( (lv_informationReturned_5_0= ruleInformationReturned ) )
            {
            otherlv_0=(Token)match(input,62,FOLLOW_62_in_ruleOperation6002); 

                	newLeafNode(otherlv_0, grammarAccess.getOperationAccess().getOperationKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleOperation6014); 

                	newLeafNode(otherlv_1, grammarAccess.getOperationAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2792:1: ( (lv_operation_2_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2793:1: (lv_operation_2_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2793:1: (lv_operation_2_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2794:3: lv_operation_2_0= RULE_STRING
            {
            lv_operation_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleOperation6031); 

            			newLeafNode(lv_operation_2_0, grammarAccess.getOperationAccess().getOperationSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOperationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"operation",
                    		lv_operation_2_0, 
                    		"STRING");
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2810:2: ( (lv_description_3_0= ruleDescription ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2811:1: (lv_description_3_0= ruleDescription )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2811:1: (lv_description_3_0= ruleDescription )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2812:3: lv_description_3_0= ruleDescription
            {
             
            	        newCompositeNode(grammarAccess.getOperationAccess().getDescriptionDescriptionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleDescription_in_ruleOperation6057);
            lv_description_3_0=ruleDescription();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOperationRule());
            	        }
                   		set(
                   			current, 
                   			"description",
                    		lv_description_3_0, 
                    		"Description");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2828:2: ( (lv_command_4_0= ruleCommand ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2829:1: (lv_command_4_0= ruleCommand )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2829:1: (lv_command_4_0= ruleCommand )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2830:3: lv_command_4_0= ruleCommand
            {
             
            	        newCompositeNode(grammarAccess.getOperationAccess().getCommandCommandParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleCommand_in_ruleOperation6078);
            lv_command_4_0=ruleCommand();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOperationRule());
            	        }
                   		set(
                   			current, 
                   			"command",
                    		lv_command_4_0, 
                    		"Command");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2846:2: ( (lv_informationReturned_5_0= ruleInformationReturned ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2847:1: (lv_informationReturned_5_0= ruleInformationReturned )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2847:1: (lv_informationReturned_5_0= ruleInformationReturned )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2848:3: lv_informationReturned_5_0= ruleInformationReturned
            {
             
            	        newCompositeNode(grammarAccess.getOperationAccess().getInformationReturnedInformationReturnedParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleInformationReturned_in_ruleOperation6099);
            lv_informationReturned_5_0=ruleInformationReturned();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOperationRule());
            	        }
                   		set(
                   			current, 
                   			"informationReturned",
                    		lv_informationReturned_5_0, 
                    		"InformationReturned");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperation"


    // $ANTLR start "entryRuleCommand"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2872:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2873:2: (iv_ruleCommand= ruleCommand EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2874:2: iv_ruleCommand= ruleCommand EOF
            {
             newCompositeNode(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand6135);
            iv_ruleCommand=ruleCommand();

            state._fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand6145); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2881:1: ruleCommand returns [EObject current=null] : (otherlv_0= 'command' otherlv_1= ':' ( (lv_command_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_command_2_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2884:28: ( (otherlv_0= 'command' otherlv_1= ':' ( (lv_command_2_0= RULE_STRING ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2885:1: (otherlv_0= 'command' otherlv_1= ':' ( (lv_command_2_0= RULE_STRING ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2885:1: (otherlv_0= 'command' otherlv_1= ':' ( (lv_command_2_0= RULE_STRING ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2885:3: otherlv_0= 'command' otherlv_1= ':' ( (lv_command_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,63,FOLLOW_63_in_ruleCommand6182); 

                	newLeafNode(otherlv_0, grammarAccess.getCommandAccess().getCommandKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleCommand6194); 

                	newLeafNode(otherlv_1, grammarAccess.getCommandAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2893:1: ( (lv_command_2_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2894:1: (lv_command_2_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2894:1: (lv_command_2_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2895:3: lv_command_2_0= RULE_STRING
            {
            lv_command_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCommand6211); 

            			newLeafNode(lv_command_2_0, grammarAccess.getCommandAccess().getCommandSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCommandRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"command",
                    		lv_command_2_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleInformationReturned"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2919:1: entryRuleInformationReturned returns [EObject current=null] : iv_ruleInformationReturned= ruleInformationReturned EOF ;
    public final EObject entryRuleInformationReturned() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInformationReturned = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2920:2: (iv_ruleInformationReturned= ruleInformationReturned EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2921:2: iv_ruleInformationReturned= ruleInformationReturned EOF
            {
             newCompositeNode(grammarAccess.getInformationReturnedRule()); 
            pushFollow(FOLLOW_ruleInformationReturned_in_entryRuleInformationReturned6252);
            iv_ruleInformationReturned=ruleInformationReturned();

            state._fsp--;

             current =iv_ruleInformationReturned; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInformationReturned6262); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInformationReturned"


    // $ANTLR start "ruleInformationReturned"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2928:1: ruleInformationReturned returns [EObject current=null] : (otherlv_0= 'information_returned' otherlv_1= ':' ( (lv_informationReturned_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleInformationReturned() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_informationReturned_2_0=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2931:28: ( (otherlv_0= 'information_returned' otherlv_1= ':' ( (lv_informationReturned_2_0= RULE_STRING ) ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2932:1: (otherlv_0= 'information_returned' otherlv_1= ':' ( (lv_informationReturned_2_0= RULE_STRING ) ) )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2932:1: (otherlv_0= 'information_returned' otherlv_1= ':' ( (lv_informationReturned_2_0= RULE_STRING ) ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2932:3: otherlv_0= 'information_returned' otherlv_1= ':' ( (lv_informationReturned_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,64,FOLLOW_64_in_ruleInformationReturned6299); 

                	newLeafNode(otherlv_0, grammarAccess.getInformationReturnedAccess().getInformation_returnedKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleInformationReturned6311); 

                	newLeafNode(otherlv_1, grammarAccess.getInformationReturnedAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2940:1: ( (lv_informationReturned_2_0= RULE_STRING ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2941:1: (lv_informationReturned_2_0= RULE_STRING )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2941:1: (lv_informationReturned_2_0= RULE_STRING )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2942:3: lv_informationReturned_2_0= RULE_STRING
            {
            lv_informationReturned_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleInformationReturned6328); 

            			newLeafNode(lv_informationReturned_2_0, grammarAccess.getInformationReturnedAccess().getInformationReturnedSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInformationReturnedRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"informationReturned",
                    		lv_informationReturned_2_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInformationReturned"


    // $ANTLR start "entryRuleVersion"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2966:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2967:2: (iv_ruleVersion= ruleVersion EOF )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2968:2: iv_ruleVersion= ruleVersion EOF
            {
             newCompositeNode(grammarAccess.getVersionRule()); 
            pushFollow(FOLLOW_ruleVersion_in_entryRuleVersion6369);
            iv_ruleVersion=ruleVersion();

            state._fsp--;

             current =iv_ruleVersion; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersion6379); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVersion"


    // $ANTLR start "ruleVersion"
    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2975:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' otherlv_1= ':' ( (lv_value_2_0= RULE_NATURAL_NUMBER ) ) (otherlv_3= '.' this_NATURAL_NUMBER_4= RULE_NATURAL_NUMBER )+ ) ;
    public final EObject ruleVersion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;
        Token this_NATURAL_NUMBER_4=null;

         enterRule(); 
            
        try {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2978:28: ( (otherlv_0= 'version' otherlv_1= ':' ( (lv_value_2_0= RULE_NATURAL_NUMBER ) ) (otherlv_3= '.' this_NATURAL_NUMBER_4= RULE_NATURAL_NUMBER )+ ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2979:1: (otherlv_0= 'version' otherlv_1= ':' ( (lv_value_2_0= RULE_NATURAL_NUMBER ) ) (otherlv_3= '.' this_NATURAL_NUMBER_4= RULE_NATURAL_NUMBER )+ )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2979:1: (otherlv_0= 'version' otherlv_1= ':' ( (lv_value_2_0= RULE_NATURAL_NUMBER ) ) (otherlv_3= '.' this_NATURAL_NUMBER_4= RULE_NATURAL_NUMBER )+ )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2979:3: otherlv_0= 'version' otherlv_1= ':' ( (lv_value_2_0= RULE_NATURAL_NUMBER ) ) (otherlv_3= '.' this_NATURAL_NUMBER_4= RULE_NATURAL_NUMBER )+
            {
            otherlv_0=(Token)match(input,65,FOLLOW_65_in_ruleVersion6416); 

                	newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleVersion6428); 

                	newLeafNode(otherlv_1, grammarAccess.getVersionAccess().getColonKeyword_1());
                
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2987:1: ( (lv_value_2_0= RULE_NATURAL_NUMBER ) )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2988:1: (lv_value_2_0= RULE_NATURAL_NUMBER )
            {
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2988:1: (lv_value_2_0= RULE_NATURAL_NUMBER )
            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:2989:3: lv_value_2_0= RULE_NATURAL_NUMBER
            {
            lv_value_2_0=(Token)match(input,RULE_NATURAL_NUMBER,FOLLOW_RULE_NATURAL_NUMBER_in_ruleVersion6445); 

            			newLeafNode(lv_value_2_0, grammarAccess.getVersionAccess().getValueNATURAL_NUMBERTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVersionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"NATURAL_NUMBER");
            	    

            }


            }

            // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3005:2: (otherlv_3= '.' this_NATURAL_NUMBER_4= RULE_NATURAL_NUMBER )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==66) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../eu.cloud4soa.xtext.dsl/src-gen/eu/cloud4soa/xtext/parser/antlr/internal/InternalDsl.g:3005:4: otherlv_3= '.' this_NATURAL_NUMBER_4= RULE_NATURAL_NUMBER
            	    {
            	    otherlv_3=(Token)match(input,66,FOLLOW_66_in_ruleVersion6463); 

            	        	newLeafNode(otherlv_3, grammarAccess.getVersionAccess().getFullStopKeyword_3_0());
            	        
            	    this_NATURAL_NUMBER_4=(Token)match(input,RULE_NATURAL_NUMBER,FOLLOW_RULE_NATURAL_NUMBER_in_ruleVersion6474); 
            	     
            	        newLeafNode(this_NATURAL_NUMBER_4, grammarAccess.getVersionAccess().getNATURAL_NUMBERTerminalRuleCall_3_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVersion"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleScope_in_entryRuleScope75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScope85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleScope122 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleScope134 = new BitSet(new long[]{0x0000000014030000L});
    public static final BitSet FOLLOW_ruleUserProfile_in_ruleScope156 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ruleApplicationProfile_in_ruleScope183 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rulePaasOfferingProfile_in_ruleScope210 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleScope223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUserProfile_in_entryRuleUserProfile259 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUserProfile269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleUserProfile307 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_17_in_ruleUserProfile326 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleUserProfile338 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleProvider_in_ruleUserProfile359 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleUserProfile373 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_ruleAccountInfo_in_ruleUserProfile394 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rulePersonalInfos_in_ruleUserProfile415 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleUserProfile427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePersonalInfos_in_entryRulePersonalInfos463 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePersonalInfos473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rulePersonalInfos510 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePersonalInfos522 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePersonalInfos539 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_rulePersonalInfos556 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePersonalInfos568 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePersonalInfos585 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rulePersonalInfos602 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePersonalInfos614 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePersonalInfos631 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleBirthday_in_rulePersonalInfos657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBirthday_in_entryRuleBirthday694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBirthday704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleBirthday741 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleBirthday753 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_DATE_US_in_ruleBirthday770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAccountInfo_in_entryRuleAccountInfo811 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAccountInfo821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleAccountInfo858 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAccountInfo870 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAccountInfo887 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleAccountInfo904 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAccountInfo916 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAccountInfo933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProvider_in_entryRuleProvider974 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProvider984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleProvider1026 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleProvider1043 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleProvider1055 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleProvider1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleApplicationProfile_in_entryRuleApplicationProfile1113 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleApplicationProfile1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleApplicationInfos_in_ruleApplicationProfile1169 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ruleFile_in_ruleApplicationProfile1190 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ruleTechnologyInfo_in_ruleApplicationProfile1211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleApplicationInfos_in_entryRuleApplicationInfos1247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleApplicationInfos1257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleApplicationInfos1294 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleApplicationInfos1306 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleApplicationInfos1323 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleApplicationInfos1349 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleApplicationCode_in_ruleApplicationInfos1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleApplicationCode_in_entryRuleApplicationCode1407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleApplicationCode1417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleApplicationCode1454 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleApplicationCode1466 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleApplicationCode1483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePaasOfferingProfile_in_entryRulePaasOfferingProfile1524 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePaasOfferingProfile1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePaasOfferingInfos_in_rulePaasOfferingProfile1580 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ruleChannels_in_rulePaasOfferingProfile1601 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ruleTechnologyInfo_in_rulePaasOfferingProfile1622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePaasOfferingInfos_in_entryRulePaasOfferingInfos1658 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePaasOfferingInfos1668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rulePaasOfferingInfos1705 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePaasOfferingInfos1717 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePaasOfferingInfos1734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile1775 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile1785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleFile1822 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFile1834 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFile1851 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleFileDimension_in_ruleFile1877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFileDimension_in_entryRuleFileDimension1914 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFileDimension1924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleFileDimension1961 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFileDimension1973 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_NATURAL_NUMBER_in_ruleFileDimension1990 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_ruleDigest_in_ruleFileDimension2016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDigest_in_entryRuleDigest2053 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDigest2063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleDigest2100 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleDigest2112 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDigest2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTechnologyInfo_in_entryRuleTechnologyInfo2170 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTechnologyInfo2180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProgrammingLanguage_in_ruleTechnologyInfo2226 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_ruleSoftware_in_ruleTechnologyInfo2247 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleHardware_in_ruleTechnologyInfo2268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProgrammingLanguage_in_entryRuleProgrammingLanguage2304 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProgrammingLanguage2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleProgrammingLanguage2351 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleProgrammingLanguage2363 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleProgrammingLanguage2380 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleProgrammingLanguage2406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSoftware_in_entryRuleSoftware2442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSoftware2452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleSoftware2489 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSoftware2501 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_ruleSoftwareCategory_in_ruleSoftware2523 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSoftware2535 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ruleSoftwareComponent_in_ruleSoftware2556 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_15_in_ruleSoftware2569 = new BitSet(new long[]{0x0000000400008000L});
    public static final BitSet FOLLOW_15_in_ruleSoftware2583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSoftwareCategory_in_entryRuleSoftwareCategory2619 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSoftwareCategory2629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleSoftwareCategory2666 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSoftwareCategory2678 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSoftwareCategory2695 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleSoftwareCategory2721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSoftwareComponent_in_entryRuleSoftwareComponent2757 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSoftwareComponent2767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponent_in_ruleSoftwareComponent2813 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleSoftwareComponent2834 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ruleLicense_in_ruleSoftwareComponent2855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponent_in_entryRuleComponent2892 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponent2902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleComponent2939 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleComponent2951 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleComponent2968 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleComponent2994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription3030 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription3040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleDescription3077 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleDescription3089 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescription3106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLicense_in_entryRuleLicense3147 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLicense3157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleLicense3194 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleLicense3206 = new BitSet(new long[]{0x000003C000000000L});
    public static final BitSet FOLLOW_38_in_ruleLicense3226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleLicense3255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleLicense3284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleLicense3313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHardware_in_entryRuleHardware3365 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHardware3375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleHardware3412 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleHardware3424 = new BitSet(new long[]{0x0120280000008000L});
    public static final BitSet FOLLOW_ruleBox_in_ruleHardware3446 = new BitSet(new long[]{0x0120000000008000L});
    public static final BitSet FOLLOW_ruleCompute_in_ruleHardware3473 = new BitSet(new long[]{0x0120000000008000L});
    public static final BitSet FOLLOW_ruleNetworkResource_in_ruleHardware3496 = new BitSet(new long[]{0x0120000000008000L});
    public static final BitSet FOLLOW_ruleStorageResource_in_ruleHardware3518 = new BitSet(new long[]{0x0100000000008000L});
    public static final BitSet FOLLOW_15_in_ruleHardware3531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBox_in_entryRuleBox3567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBox3577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleBox3614 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ruleBoxComponent_in_ruleBox3635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoxComponent_in_entryRuleBoxComponent3671 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoxComponent3681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponent_in_ruleBoxComponent3727 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleHttpRequests_in_ruleBoxComponent3748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHttpRequests_in_entryRuleHttpRequests3784 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHttpRequests3794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleHttpRequests3831 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleHttpRequests3843 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_NATURAL_NUMBER_in_ruleHttpRequests3860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompute_in_entryRuleCompute3901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompute3911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleCompute3948 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ruleComputationalComponent_in_ruleCompute3969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComputationalComponent_in_entryRuleComputationalComponent4005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComputationalComponent4015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponent_in_ruleComputationalComponent4061 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ruleArchitecture_in_ruleComputationalComponent4082 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleCores_in_ruleComputationalComponent4103 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ruleSpeed_in_ruleComputationalComponent4124 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_ruleMemory_in_ruleComputationalComponent4145 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleCache_in_ruleComputationalComponent4166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArchitecture_in_entryRuleArchitecture4202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArchitecture4212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleArchitecture4249 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleArchitecture4261 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_47_in_ruleArchitecture4281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleArchitecture4310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCores_in_entryRuleCores4362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCores4372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleCores4409 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleCores4421 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_NATURAL_NUMBER_in_ruleCores4438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpeed_in_entryRuleSpeed4479 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpeed4489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleSpeed4526 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSpeed4538 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_NATURAL_NUMBER_in_ruleSpeed4555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMemory_in_entryRuleMemory4596 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMemory4606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleMemory4643 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleMemory4655 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_NATURAL_NUMBER_in_ruleMemory4672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCache_in_entryRuleCache4713 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCache4723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleCache4760 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleCache4772 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_NATURAL_NUMBER_in_ruleCache4789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNetworkResource_in_entryRuleNetworkResource4830 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNetworkResource4840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleNetworkResource4877 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ruleCommunicationalComponent_in_ruleNetworkResource4898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommunicationalComponent_in_entryRuleCommunicationalComponent4934 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommunicationalComponent4944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponent_in_ruleCommunicationalComponent4990 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleBandwidth_in_ruleCommunicationalComponent5011 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_ruleLatency_in_ruleCommunicationalComponent5032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBandwidth_in_entryRuleBandwidth5069 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBandwidth5079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleBandwidth5116 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleBandwidth5128 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_NATURAL_NUMBER_in_ruleBandwidth5145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLatency_in_entryRuleLatency5186 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLatency5196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleLatency5233 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleLatency5245 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_NATURAL_NUMBER_in_ruleLatency5262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStorageResource_in_entryRuleStorageResource5303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStorageResource5313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleStorageResource5350 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ruleStorageComponent_in_ruleStorageResource5371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStorageComponent_in_entryRuleStorageComponent5407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStorageComponent5417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponent_in_ruleStorageComponent5463 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ruleCapacity_in_ruleStorageComponent5484 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_ruleBandwidth_in_ruleStorageComponent5505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCapacity_in_entryRuleCapacity5542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCapacity5552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleCapacity5589 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleCapacity5601 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_NATURAL_NUMBER_in_ruleCapacity5618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChannels_in_entryRuleChannels5659 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChannels5669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleChannels5706 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleChannels5718 = new BitSet(new long[]{0x3800000000008000L});
    public static final BitSet FOLLOW_ruleChannel_in_ruleChannels5739 = new BitSet(new long[]{0x3800000000008000L});
    public static final BitSet FOLLOW_15_in_ruleChannels5752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChannel_in_entryRuleChannel5788 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChannel5798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleChannel5836 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_60_in_ruleChannel5854 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_61_in_ruleChannel5872 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleChannel5885 = new BitSet(new long[]{0x4000000000008000L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleChannel5906 = new BitSet(new long[]{0x4000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleChannel5919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation5955 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperation5965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleOperation6002 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleOperation6014 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleOperation6031 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleOperation6057 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleOperation6078 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleInformationReturned_in_ruleOperation6099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand6135 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand6145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleCommand6182 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleCommand6194 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCommand6211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInformationReturned_in_entryRuleInformationReturned6252 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInformationReturned6262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleInformationReturned6299 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleInformationReturned6311 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleInformationReturned6328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_entryRuleVersion6369 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersion6379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleVersion6416 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleVersion6428 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_NATURAL_NUMBER_in_ruleVersion6445 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ruleVersion6463 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_NATURAL_NUMBER_in_ruleVersion6474 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});

}