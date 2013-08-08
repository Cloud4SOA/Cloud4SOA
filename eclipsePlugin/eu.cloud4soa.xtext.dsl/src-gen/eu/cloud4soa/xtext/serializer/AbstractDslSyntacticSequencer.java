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


package eu.cloud4soa.xtext.serializer;

import com.google.inject.Inject;
import eu.cloud4soa.xtext.services.DslGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("restriction")
public class AbstractDslSyntacticSequencer extends AbstractSyntacticSequencer {

	protected DslGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Channel_ApiKeyword_0_0_or_CliKeyword_0_1_or_Web_interfaceKeyword_0_2;
	protected AbstractElementAlias match_Version___FullStopKeyword_3_0_NATURAL_NUMBERTerminalRuleCall_3_1__p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (DslGrammarAccess) access;
		match_Channel_ApiKeyword_0_0_or_CliKeyword_0_1_or_Web_interfaceKeyword_0_2 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getChannelAccess().getApiKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getChannelAccess().getCliKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getChannelAccess().getWeb_interfaceKeyword_0_2()));
		match_Version___FullStopKeyword_3_0_NATURAL_NUMBERTerminalRuleCall_3_1__p = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVersionAccess().getFullStopKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getVersionAccess().getNATURAL_NUMBERTerminalRuleCall_3_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getNATURAL_NUMBERRule())
			return getNATURAL_NUMBERToken(semanticObject, ruleCall, node);
		return "";
	}
	
	protected String getNATURAL_NUMBERToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Channel_ApiKeyword_0_0_or_CliKeyword_0_1_or_Web_interfaceKeyword_0_2.equals(syntax))
				emit_Channel_ApiKeyword_0_0_or_CliKeyword_0_1_or_Web_interfaceKeyword_0_2(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Version___FullStopKeyword_3_0_NATURAL_NUMBERTerminalRuleCall_3_1__p.equals(syntax))
				emit_Version___FullStopKeyword_3_0_NATURAL_NUMBERTerminalRuleCall_3_1__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'web_interface' | 'cli' | 'api'
	 */
	protected void emit_Channel_ApiKeyword_0_0_or_CliKeyword_0_1_or_Web_interfaceKeyword_0_2(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('.' NATURAL_NUMBER)+
	 */
	protected void emit_Version___FullStopKeyword_3_0_NATURAL_NUMBERTerminalRuleCall_3_1__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
