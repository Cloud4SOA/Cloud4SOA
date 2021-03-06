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


/*
* generated by Xtext
*/
package eu.cloud4soa.xtext.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import eu.cloud4soa.xtext.services.DslGrammarAccess;

public class DslParser extends AbstractContentAssistParser {
	
	@Inject
	private DslGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected eu.cloud4soa.xtext.ui.contentassist.antlr.internal.InternalDslParser createParser() {
		eu.cloud4soa.xtext.ui.contentassist.antlr.internal.InternalDslParser result = new eu.cloud4soa.xtext.ui.contentassist.antlr.internal.InternalDslParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getScopeAccess().getAlternatives_2(), "rule__Scope__Alternatives_2");
					put(grammarAccess.getUserProfileAccess().getAlternatives_0(), "rule__UserProfile__Alternatives_0");
					put(grammarAccess.getLicenseAccess().getLicenseAlternatives_2_0(), "rule__License__LicenseAlternatives_2_0");
					put(grammarAccess.getHardwareAccess().getAlternatives_2(), "rule__Hardware__Alternatives_2");
					put(grammarAccess.getArchitectureAccess().getArchitectureAlternatives_2_0(), "rule__Architecture__ArchitectureAlternatives_2_0");
					put(grammarAccess.getChannelAccess().getAlternatives_0(), "rule__Channel__Alternatives_0");
					put(grammarAccess.getScopeAccess().getGroup(), "rule__Scope__Group__0");
					put(grammarAccess.getUserProfileAccess().getGroup(), "rule__UserProfile__Group__0");
					put(grammarAccess.getUserProfileAccess().getGroup_0_1(), "rule__UserProfile__Group_0_1__0");
					put(grammarAccess.getPersonalInfosAccess().getGroup(), "rule__PersonalInfos__Group__0");
					put(grammarAccess.getBirthdayAccess().getGroup(), "rule__Birthday__Group__0");
					put(grammarAccess.getAccountInfoAccess().getGroup(), "rule__AccountInfo__Group__0");
					put(grammarAccess.getProviderAccess().getGroup(), "rule__Provider__Group__0");
					put(grammarAccess.getApplicationProfileAccess().getGroup(), "rule__ApplicationProfile__Group__0");
					put(grammarAccess.getApplicationInfosAccess().getGroup(), "rule__ApplicationInfos__Group__0");
					put(grammarAccess.getApplicationCodeAccess().getGroup(), "rule__ApplicationCode__Group__0");
					put(grammarAccess.getPaasOfferingProfileAccess().getGroup(), "rule__PaasOfferingProfile__Group__0");
					put(grammarAccess.getPaasOfferingInfosAccess().getGroup(), "rule__PaasOfferingInfos__Group__0");
					put(grammarAccess.getFileAccess().getGroup(), "rule__File__Group__0");
					put(grammarAccess.getFileDimensionAccess().getGroup(), "rule__FileDimension__Group__0");
					put(grammarAccess.getDigestAccess().getGroup(), "rule__Digest__Group__0");
					put(grammarAccess.getTechnologyInfoAccess().getGroup(), "rule__TechnologyInfo__Group__0");
					put(grammarAccess.getProgrammingLanguageAccess().getGroup(), "rule__ProgrammingLanguage__Group__0");
					put(grammarAccess.getSoftwareAccess().getGroup(), "rule__Software__Group__0");
					put(grammarAccess.getSoftwareAccess().getGroup_2(), "rule__Software__Group_2__0");
					put(grammarAccess.getSoftwareCategoryAccess().getGroup(), "rule__SoftwareCategory__Group__0");
					put(grammarAccess.getSoftwareComponentAccess().getGroup(), "rule__SoftwareComponent__Group__0");
					put(grammarAccess.getComponentAccess().getGroup(), "rule__Component__Group__0");
					put(grammarAccess.getDescriptionAccess().getGroup(), "rule__Description__Group__0");
					put(grammarAccess.getLicenseAccess().getGroup(), "rule__License__Group__0");
					put(grammarAccess.getHardwareAccess().getGroup(), "rule__Hardware__Group__0");
					put(grammarAccess.getBoxAccess().getGroup(), "rule__Box__Group__0");
					put(grammarAccess.getBoxComponentAccess().getGroup(), "rule__BoxComponent__Group__0");
					put(grammarAccess.getHttpRequestsAccess().getGroup(), "rule__HttpRequests__Group__0");
					put(grammarAccess.getComputeAccess().getGroup(), "rule__Compute__Group__0");
					put(grammarAccess.getComputationalComponentAccess().getGroup(), "rule__ComputationalComponent__Group__0");
					put(grammarAccess.getArchitectureAccess().getGroup(), "rule__Architecture__Group__0");
					put(grammarAccess.getCoresAccess().getGroup(), "rule__Cores__Group__0");
					put(grammarAccess.getSpeedAccess().getGroup(), "rule__Speed__Group__0");
					put(grammarAccess.getMemoryAccess().getGroup(), "rule__Memory__Group__0");
					put(grammarAccess.getCacheAccess().getGroup(), "rule__Cache__Group__0");
					put(grammarAccess.getNetworkResourceAccess().getGroup(), "rule__NetworkResource__Group__0");
					put(grammarAccess.getCommunicationalComponentAccess().getGroup(), "rule__CommunicationalComponent__Group__0");
					put(grammarAccess.getBandwidthAccess().getGroup(), "rule__Bandwidth__Group__0");
					put(grammarAccess.getLatencyAccess().getGroup(), "rule__Latency__Group__0");
					put(grammarAccess.getStorageResourceAccess().getGroup(), "rule__StorageResource__Group__0");
					put(grammarAccess.getStorageComponentAccess().getGroup(), "rule__StorageComponent__Group__0");
					put(grammarAccess.getCapacityAccess().getGroup(), "rule__Capacity__Group__0");
					put(grammarAccess.getChannelsAccess().getGroup(), "rule__Channels__Group__0");
					put(grammarAccess.getChannelAccess().getGroup(), "rule__Channel__Group__0");
					put(grammarAccess.getOperationAccess().getGroup(), "rule__Operation__Group__0");
					put(grammarAccess.getCommandAccess().getGroup(), "rule__Command__Group__0");
					put(grammarAccess.getInformationReturnedAccess().getGroup(), "rule__InformationReturned__Group__0");
					put(grammarAccess.getVersionAccess().getGroup(), "rule__Version__Group__0");
					put(grammarAccess.getVersionAccess().getGroup_3(), "rule__Version__Group_3__0");
					put(grammarAccess.getScopeAccess().getUserProfileAssignment_2_0(), "rule__Scope__UserProfileAssignment_2_0");
					put(grammarAccess.getScopeAccess().getApplicationProfileAssignment_2_1(), "rule__Scope__ApplicationProfileAssignment_2_1");
					put(grammarAccess.getScopeAccess().getPaasOfferingProfileAssignment_2_2(), "rule__Scope__PaasOfferingProfileAssignment_2_2");
					put(grammarAccess.getUserProfileAccess().getProviderAssignment_0_1_2(), "rule__UserProfile__ProviderAssignment_0_1_2");
					put(grammarAccess.getUserProfileAccess().getAccountInfoAssignment_2(), "rule__UserProfile__AccountInfoAssignment_2");
					put(grammarAccess.getUserProfileAccess().getPersonalInfoAssignment_3(), "rule__UserProfile__PersonalInfoAssignment_3");
					put(grammarAccess.getPersonalInfosAccess().getFirstNameAssignment_2(), "rule__PersonalInfos__FirstNameAssignment_2");
					put(grammarAccess.getPersonalInfosAccess().getSurnNameAssignment_5(), "rule__PersonalInfos__SurnNameAssignment_5");
					put(grammarAccess.getPersonalInfosAccess().getEmailAssignment_8(), "rule__PersonalInfos__EmailAssignment_8");
					put(grammarAccess.getPersonalInfosAccess().getBirthDayAssignment_9(), "rule__PersonalInfos__BirthDayAssignment_9");
					put(grammarAccess.getBirthdayAccess().getDateAssignment_2(), "rule__Birthday__DateAssignment_2");
					put(grammarAccess.getAccountInfoAccess().getUsernameAssignment_2(), "rule__AccountInfo__UsernameAssignment_2");
					put(grammarAccess.getAccountInfoAccess().getPasswordAssignment_5(), "rule__AccountInfo__PasswordAssignment_5");
					put(grammarAccess.getProviderAccess().getProviderAssignment_0(), "rule__Provider__ProviderAssignment_0");
					put(grammarAccess.getProviderAccess().getHomepageAssignment_3(), "rule__Provider__HomepageAssignment_3");
					put(grammarAccess.getApplicationProfileAccess().getInfosAssignment_0(), "rule__ApplicationProfile__InfosAssignment_0");
					put(grammarAccess.getApplicationProfileAccess().getFileAssignment_1(), "rule__ApplicationProfile__FileAssignment_1");
					put(grammarAccess.getApplicationProfileAccess().getTechnologyAssignment_2(), "rule__ApplicationProfile__TechnologyAssignment_2");
					put(grammarAccess.getApplicationInfosAccess().getApplicationAssignment_2(), "rule__ApplicationInfos__ApplicationAssignment_2");
					put(grammarAccess.getApplicationInfosAccess().getVersionAssignment_3(), "rule__ApplicationInfos__VersionAssignment_3");
					put(grammarAccess.getApplicationInfosAccess().getCodeAssignment_4(), "rule__ApplicationInfos__CodeAssignment_4");
					put(grammarAccess.getApplicationCodeAccess().getApplicationCodeAssignment_2(), "rule__ApplicationCode__ApplicationCodeAssignment_2");
					put(grammarAccess.getPaasOfferingProfileAccess().getPaasOfferingInfosAssignment_0(), "rule__PaasOfferingProfile__PaasOfferingInfosAssignment_0");
					put(grammarAccess.getPaasOfferingProfileAccess().getChannelsAssignment_1(), "rule__PaasOfferingProfile__ChannelsAssignment_1");
					put(grammarAccess.getPaasOfferingProfileAccess().getTechnologyAssignment_2(), "rule__PaasOfferingProfile__TechnologyAssignment_2");
					put(grammarAccess.getPaasOfferingInfosAccess().getPaasOfferingAssignment_2(), "rule__PaasOfferingInfos__PaasOfferingAssignment_2");
					put(grammarAccess.getFileAccess().getFileNameAssignment_2(), "rule__File__FileNameAssignment_2");
					put(grammarAccess.getFileAccess().getDimensionAssignment_3(), "rule__File__DimensionAssignment_3");
					put(grammarAccess.getFileDimensionAccess().getSizeAssignment_2(), "rule__FileDimension__SizeAssignment_2");
					put(grammarAccess.getFileDimensionAccess().getDigestAssignment_3(), "rule__FileDimension__DigestAssignment_3");
					put(grammarAccess.getDigestAccess().getDigestAssignment_2(), "rule__Digest__DigestAssignment_2");
					put(grammarAccess.getTechnologyInfoAccess().getProgrammingLanguageAssignment_0(), "rule__TechnologyInfo__ProgrammingLanguageAssignment_0");
					put(grammarAccess.getTechnologyInfoAccess().getSoftwareAssignment_1(), "rule__TechnologyInfo__SoftwareAssignment_1");
					put(grammarAccess.getTechnologyInfoAccess().getHardwareAssignment_2(), "rule__TechnologyInfo__HardwareAssignment_2");
					put(grammarAccess.getProgrammingLanguageAccess().getProgrammingLanguageAssignment_2(), "rule__ProgrammingLanguage__ProgrammingLanguageAssignment_2");
					put(grammarAccess.getProgrammingLanguageAccess().getVersionAssignment_3(), "rule__ProgrammingLanguage__VersionAssignment_3");
					put(grammarAccess.getSoftwareAccess().getCategoryAssignment_2_0(), "rule__Software__CategoryAssignment_2_0");
					put(grammarAccess.getSoftwareAccess().getComponentAssignment_2_2(), "rule__Software__ComponentAssignment_2_2");
					put(grammarAccess.getSoftwareCategoryAccess().getCategoryAssignment_2(), "rule__SoftwareCategory__CategoryAssignment_2");
					put(grammarAccess.getSoftwareCategoryAccess().getDescriptionAssignment_3(), "rule__SoftwareCategory__DescriptionAssignment_3");
					put(grammarAccess.getSoftwareComponentAccess().getComponentAssignment_0(), "rule__SoftwareComponent__ComponentAssignment_0");
					put(grammarAccess.getSoftwareComponentAccess().getVersionAssignment_1(), "rule__SoftwareComponent__VersionAssignment_1");
					put(grammarAccess.getSoftwareComponentAccess().getLicenseAssignment_2(), "rule__SoftwareComponent__LicenseAssignment_2");
					put(grammarAccess.getComponentAccess().getComponentAssignment_2(), "rule__Component__ComponentAssignment_2");
					put(grammarAccess.getComponentAccess().getDescriptionAssignment_3(), "rule__Component__DescriptionAssignment_3");
					put(grammarAccess.getDescriptionAccess().getDescriptionAssignment_2(), "rule__Description__DescriptionAssignment_2");
					put(grammarAccess.getLicenseAccess().getLicenseAssignment_2(), "rule__License__LicenseAssignment_2");
					put(grammarAccess.getHardwareAccess().getBoxAssignment_2_0(), "rule__Hardware__BoxAssignment_2_0");
					put(grammarAccess.getHardwareAccess().getComputeAssignment_2_1(), "rule__Hardware__ComputeAssignment_2_1");
					put(grammarAccess.getHardwareAccess().getNetworkResourceAssignment_3(), "rule__Hardware__NetworkResourceAssignment_3");
					put(grammarAccess.getHardwareAccess().getStorageResourceAssignment_4(), "rule__Hardware__StorageResourceAssignment_4");
					put(grammarAccess.getBoxAccess().getBoxAssignment_1(), "rule__Box__BoxAssignment_1");
					put(grammarAccess.getBoxComponentAccess().getComponentAssignment_0(), "rule__BoxComponent__ComponentAssignment_0");
					put(grammarAccess.getBoxComponentAccess().getHttpRequestAssignment_1(), "rule__BoxComponent__HttpRequestAssignment_1");
					put(grammarAccess.getHttpRequestsAccess().getHttp_requestsAssignment_2(), "rule__HttpRequests__Http_requestsAssignment_2");
					put(grammarAccess.getComputeAccess().getComputeAssignment_1(), "rule__Compute__ComputeAssignment_1");
					put(grammarAccess.getComputationalComponentAccess().getComponentAssignment_0(), "rule__ComputationalComponent__ComponentAssignment_0");
					put(grammarAccess.getComputationalComponentAccess().getArchitectureAssignment_1(), "rule__ComputationalComponent__ArchitectureAssignment_1");
					put(grammarAccess.getComputationalComponentAccess().getCoresAssignment_2(), "rule__ComputationalComponent__CoresAssignment_2");
					put(grammarAccess.getComputationalComponentAccess().getSpeedAssignment_3(), "rule__ComputationalComponent__SpeedAssignment_3");
					put(grammarAccess.getComputationalComponentAccess().getMemoryAssignment_4(), "rule__ComputationalComponent__MemoryAssignment_4");
					put(grammarAccess.getComputationalComponentAccess().getCacheAssignment_5(), "rule__ComputationalComponent__CacheAssignment_5");
					put(grammarAccess.getArchitectureAccess().getArchitectureAssignment_2(), "rule__Architecture__ArchitectureAssignment_2");
					put(grammarAccess.getCoresAccess().getCoresAssignment_2(), "rule__Cores__CoresAssignment_2");
					put(grammarAccess.getSpeedAccess().getSpeedAssignment_2(), "rule__Speed__SpeedAssignment_2");
					put(grammarAccess.getMemoryAccess().getMemoryAssignment_2(), "rule__Memory__MemoryAssignment_2");
					put(grammarAccess.getCacheAccess().getCacheAssignment_2(), "rule__Cache__CacheAssignment_2");
					put(grammarAccess.getNetworkResourceAccess().getNetworkResourceAssignment_1(), "rule__NetworkResource__NetworkResourceAssignment_1");
					put(grammarAccess.getCommunicationalComponentAccess().getComponentAssignment_0(), "rule__CommunicationalComponent__ComponentAssignment_0");
					put(grammarAccess.getCommunicationalComponentAccess().getBandwidthAssignment_1(), "rule__CommunicationalComponent__BandwidthAssignment_1");
					put(grammarAccess.getCommunicationalComponentAccess().getLatencyAssignment_2(), "rule__CommunicationalComponent__LatencyAssignment_2");
					put(grammarAccess.getBandwidthAccess().getBandwidthAssignment_2(), "rule__Bandwidth__BandwidthAssignment_2");
					put(grammarAccess.getLatencyAccess().getLatencyAssignment_2(), "rule__Latency__LatencyAssignment_2");
					put(grammarAccess.getStorageResourceAccess().getStorageComponentAssignment_1(), "rule__StorageResource__StorageComponentAssignment_1");
					put(grammarAccess.getStorageComponentAccess().getComponentAssignment_0(), "rule__StorageComponent__ComponentAssignment_0");
					put(grammarAccess.getStorageComponentAccess().getCapacityAssignment_1(), "rule__StorageComponent__CapacityAssignment_1");
					put(grammarAccess.getStorageComponentAccess().getBandwidthAssignment_2(), "rule__StorageComponent__BandwidthAssignment_2");
					put(grammarAccess.getCapacityAccess().getCapacityAssignment_2(), "rule__Capacity__CapacityAssignment_2");
					put(grammarAccess.getChannelsAccess().getChannelAssignment_2(), "rule__Channels__ChannelAssignment_2");
					put(grammarAccess.getChannelAccess().getOperationAssignment_2(), "rule__Channel__OperationAssignment_2");
					put(grammarAccess.getOperationAccess().getOperationAssignment_2(), "rule__Operation__OperationAssignment_2");
					put(grammarAccess.getOperationAccess().getDescriptionAssignment_3(), "rule__Operation__DescriptionAssignment_3");
					put(grammarAccess.getOperationAccess().getCommandAssignment_4(), "rule__Operation__CommandAssignment_4");
					put(grammarAccess.getOperationAccess().getInformationReturnedAssignment_5(), "rule__Operation__InformationReturnedAssignment_5");
					put(grammarAccess.getCommandAccess().getCommandAssignment_2(), "rule__Command__CommandAssignment_2");
					put(grammarAccess.getInformationReturnedAccess().getInformationReturnedAssignment_2(), "rule__InformationReturned__InformationReturnedAssignment_2");
					put(grammarAccess.getVersionAccess().getValueAssignment_2(), "rule__Version__ValueAssignment_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			eu.cloud4soa.xtext.ui.contentassist.antlr.internal.InternalDslParser typedParser = (eu.cloud4soa.xtext.ui.contentassist.antlr.internal.InternalDslParser) parser;
			typedParser.entryRuleScope();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public DslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(DslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
