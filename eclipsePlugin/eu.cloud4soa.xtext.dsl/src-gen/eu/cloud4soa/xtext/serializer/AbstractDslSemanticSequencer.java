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
import com.google.inject.Provider;
import eu.cloud4soa.xtext.dsl.AccountInfo;
import eu.cloud4soa.xtext.dsl.ApplicationCode;
import eu.cloud4soa.xtext.dsl.ApplicationInfos;
import eu.cloud4soa.xtext.dsl.ApplicationProfile;
import eu.cloud4soa.xtext.dsl.Architecture;
import eu.cloud4soa.xtext.dsl.Bandwidth;
import eu.cloud4soa.xtext.dsl.Birthday;
import eu.cloud4soa.xtext.dsl.Box;
import eu.cloud4soa.xtext.dsl.BoxComponent;
import eu.cloud4soa.xtext.dsl.Cache;
import eu.cloud4soa.xtext.dsl.Capacity;
import eu.cloud4soa.xtext.dsl.Channel;
import eu.cloud4soa.xtext.dsl.Channels;
import eu.cloud4soa.xtext.dsl.Command;
import eu.cloud4soa.xtext.dsl.CommunicationalComponent;
import eu.cloud4soa.xtext.dsl.Component;
import eu.cloud4soa.xtext.dsl.ComputationalComponent;
import eu.cloud4soa.xtext.dsl.Compute;
import eu.cloud4soa.xtext.dsl.Cores;
import eu.cloud4soa.xtext.dsl.Description;
import eu.cloud4soa.xtext.dsl.Digest;
import eu.cloud4soa.xtext.dsl.DslPackage;
import eu.cloud4soa.xtext.dsl.File;
import eu.cloud4soa.xtext.dsl.FileDimension;
import eu.cloud4soa.xtext.dsl.Hardware;
import eu.cloud4soa.xtext.dsl.HttpRequests;
import eu.cloud4soa.xtext.dsl.InformationReturned;
import eu.cloud4soa.xtext.dsl.Latency;
import eu.cloud4soa.xtext.dsl.License;
import eu.cloud4soa.xtext.dsl.Memory;
import eu.cloud4soa.xtext.dsl.NetworkResource;
import eu.cloud4soa.xtext.dsl.Operation;
import eu.cloud4soa.xtext.dsl.PaasOfferingInfos;
import eu.cloud4soa.xtext.dsl.PaasOfferingProfile;
import eu.cloud4soa.xtext.dsl.PersonalInfos;
import eu.cloud4soa.xtext.dsl.ProgrammingLanguage;
import eu.cloud4soa.xtext.dsl.Scope;
import eu.cloud4soa.xtext.dsl.Software;
import eu.cloud4soa.xtext.dsl.SoftwareCategory;
import eu.cloud4soa.xtext.dsl.SoftwareComponent;
import eu.cloud4soa.xtext.dsl.Speed;
import eu.cloud4soa.xtext.dsl.StorageComponent;
import eu.cloud4soa.xtext.dsl.StorageResource;
import eu.cloud4soa.xtext.dsl.TechnologyInfo;
import eu.cloud4soa.xtext.dsl.UserProfile;
import eu.cloud4soa.xtext.dsl.Version;
import eu.cloud4soa.xtext.services.DslGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("restriction")
public class AbstractDslSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected DslGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == DslPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case DslPackage.ACCOUNT_INFO:
				if(context == grammarAccess.getAccountInfoRule()) {
					sequence_AccountInfo(context, (AccountInfo) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.APPLICATION_CODE:
				if(context == grammarAccess.getApplicationCodeRule()) {
					sequence_ApplicationCode(context, (ApplicationCode) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.APPLICATION_INFOS:
				if(context == grammarAccess.getApplicationInfosRule()) {
					sequence_ApplicationInfos(context, (ApplicationInfos) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.APPLICATION_PROFILE:
				if(context == grammarAccess.getApplicationProfileRule()) {
					sequence_ApplicationProfile(context, (ApplicationProfile) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.ARCHITECTURE:
				if(context == grammarAccess.getArchitectureRule()) {
					sequence_Architecture(context, (Architecture) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.BANDWIDTH:
				if(context == grammarAccess.getBandwidthRule()) {
					sequence_Bandwidth(context, (Bandwidth) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.BIRTHDAY:
				if(context == grammarAccess.getBirthdayRule()) {
					sequence_Birthday(context, (Birthday) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.BOX:
				if(context == grammarAccess.getBoxRule()) {
					sequence_Box(context, (Box) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.BOX_COMPONENT:
				if(context == grammarAccess.getBoxComponentRule()) {
					sequence_BoxComponent(context, (BoxComponent) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.CACHE:
				if(context == grammarAccess.getCacheRule()) {
					sequence_Cache(context, (Cache) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.CAPACITY:
				if(context == grammarAccess.getCapacityRule()) {
					sequence_Capacity(context, (Capacity) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.CHANNEL:
				if(context == grammarAccess.getChannelRule()) {
					sequence_Channel(context, (Channel) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.CHANNELS:
				if(context == grammarAccess.getChannelsRule()) {
					sequence_Channels(context, (Channels) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.COMMAND:
				if(context == grammarAccess.getCommandRule()) {
					sequence_Command(context, (Command) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.COMMUNICATIONAL_COMPONENT:
				if(context == grammarAccess.getCommunicationalComponentRule()) {
					sequence_CommunicationalComponent(context, (CommunicationalComponent) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.COMPONENT:
				if(context == grammarAccess.getComponentRule()) {
					sequence_Component(context, (Component) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.COMPUTATIONAL_COMPONENT:
				if(context == grammarAccess.getComputationalComponentRule()) {
					sequence_ComputationalComponent(context, (ComputationalComponent) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.COMPUTE:
				if(context == grammarAccess.getComputeRule()) {
					sequence_Compute(context, (Compute) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.CORES:
				if(context == grammarAccess.getCoresRule()) {
					sequence_Cores(context, (Cores) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.DESCRIPTION:
				if(context == grammarAccess.getDescriptionRule()) {
					sequence_Description(context, (Description) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.DIGEST:
				if(context == grammarAccess.getDigestRule()) {
					sequence_Digest(context, (Digest) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.FILE:
				if(context == grammarAccess.getFileRule()) {
					sequence_File(context, (File) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.FILE_DIMENSION:
				if(context == grammarAccess.getFileDimensionRule()) {
					sequence_FileDimension(context, (FileDimension) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.HARDWARE:
				if(context == grammarAccess.getHardwareRule()) {
					sequence_Hardware(context, (Hardware) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.HTTP_REQUESTS:
				if(context == grammarAccess.getHttpRequestsRule()) {
					sequence_HttpRequests(context, (HttpRequests) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.INFORMATION_RETURNED:
				if(context == grammarAccess.getInformationReturnedRule()) {
					sequence_InformationReturned(context, (InformationReturned) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.LATENCY:
				if(context == grammarAccess.getLatencyRule()) {
					sequence_Latency(context, (Latency) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.LICENSE:
				if(context == grammarAccess.getLicenseRule()) {
					sequence_License(context, (License) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.MEMORY:
				if(context == grammarAccess.getMemoryRule()) {
					sequence_Memory(context, (Memory) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.NETWORK_RESOURCE:
				if(context == grammarAccess.getNetworkResourceRule()) {
					sequence_NetworkResource(context, (NetworkResource) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.OPERATION:
				if(context == grammarAccess.getOperationRule()) {
					sequence_Operation(context, (Operation) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.PAAS_OFFERING_INFOS:
				if(context == grammarAccess.getPaasOfferingInfosRule()) {
					sequence_PaasOfferingInfos(context, (PaasOfferingInfos) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.PAAS_OFFERING_PROFILE:
				if(context == grammarAccess.getPaasOfferingProfileRule()) {
					sequence_PaasOfferingProfile(context, (PaasOfferingProfile) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.PERSONAL_INFOS:
				if(context == grammarAccess.getPersonalInfosRule()) {
					sequence_PersonalInfos(context, (PersonalInfos) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.PROGRAMMING_LANGUAGE:
				if(context == grammarAccess.getProgrammingLanguageRule()) {
					sequence_ProgrammingLanguage(context, (ProgrammingLanguage) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.PROVIDER:
				if(context == grammarAccess.getProviderRule()) {
					sequence_Provider(context, (eu.cloud4soa.xtext.dsl.Provider) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.SCOPE:
				if(context == grammarAccess.getScopeRule()) {
					sequence_Scope(context, (Scope) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.SOFTWARE:
				if(context == grammarAccess.getSoftwareRule()) {
					sequence_Software(context, (Software) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.SOFTWARE_CATEGORY:
				if(context == grammarAccess.getSoftwareCategoryRule()) {
					sequence_SoftwareCategory(context, (SoftwareCategory) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.SOFTWARE_COMPONENT:
				if(context == grammarAccess.getSoftwareComponentRule()) {
					sequence_SoftwareComponent(context, (SoftwareComponent) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.SPEED:
				if(context == grammarAccess.getSpeedRule()) {
					sequence_Speed(context, (Speed) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.STORAGE_COMPONENT:
				if(context == grammarAccess.getStorageComponentRule()) {
					sequence_StorageComponent(context, (StorageComponent) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.STORAGE_RESOURCE:
				if(context == grammarAccess.getStorageResourceRule()) {
					sequence_StorageResource(context, (StorageResource) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.TECHNOLOGY_INFO:
				if(context == grammarAccess.getTechnologyInfoRule()) {
					sequence_TechnologyInfo(context, (TechnologyInfo) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.USER_PROFILE:
				if(context == grammarAccess.getUserProfileRule()) {
					sequence_UserProfile(context, (UserProfile) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.VERSION:
				if(context == grammarAccess.getVersionRule()) {
					sequence_Version(context, (Version) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (username=STRING password=STRING)
	 */
	protected void sequence_AccountInfo(EObject context, AccountInfo semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.ACCOUNT_INFO__USERNAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.ACCOUNT_INFO__USERNAME));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.ACCOUNT_INFO__PASSWORD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.ACCOUNT_INFO__PASSWORD));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAccountInfoAccess().getUsernameSTRINGTerminalRuleCall_2_0(), semanticObject.getUsername());
		feeder.accept(grammarAccess.getAccountInfoAccess().getPasswordSTRINGTerminalRuleCall_5_0(), semanticObject.getPassword());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     applicationCode=STRING
	 */
	protected void sequence_ApplicationCode(EObject context, ApplicationCode semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.APPLICATION_CODE__APPLICATION_CODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.APPLICATION_CODE__APPLICATION_CODE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getApplicationCodeAccess().getApplicationCodeSTRINGTerminalRuleCall_2_0(), semanticObject.getApplicationCode());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (application=STRING version=Version code=ApplicationCode?)
	 */
	protected void sequence_ApplicationInfos(EObject context, ApplicationInfos semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (infos=ApplicationInfos file=File technology=TechnologyInfo)
	 */
	protected void sequence_ApplicationProfile(EObject context, ApplicationProfile semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.APPLICATION_PROFILE__INFOS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.APPLICATION_PROFILE__INFOS));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.APPLICATION_PROFILE__FILE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.APPLICATION_PROFILE__FILE));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.APPLICATION_PROFILE__TECHNOLOGY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.APPLICATION_PROFILE__TECHNOLOGY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getApplicationProfileAccess().getInfosApplicationInfosParserRuleCall_0_0(), semanticObject.getInfos());
		feeder.accept(grammarAccess.getApplicationProfileAccess().getFileFileParserRuleCall_1_0(), semanticObject.getFile());
		feeder.accept(grammarAccess.getApplicationProfileAccess().getTechnologyTechnologyInfoParserRuleCall_2_0(), semanticObject.getTechnology());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (architecture='x86' | architecture='x64')
	 */
	protected void sequence_Architecture(EObject context, Architecture semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     bandwidth=NATURAL_NUMBER
	 */
	protected void sequence_Bandwidth(EObject context, Bandwidth semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.BANDWIDTH__BANDWIDTH) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.BANDWIDTH__BANDWIDTH));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBandwidthAccess().getBandwidthNATURAL_NUMBERTerminalRuleCall_2_0(), semanticObject.getBandwidth());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     date=DATE_US
	 */
	protected void sequence_Birthday(EObject context, Birthday semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.BIRTHDAY__DATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.BIRTHDAY__DATE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBirthdayAccess().getDateDATE_USTerminalRuleCall_2_0(), semanticObject.getDate());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (component=Component httpRequest=HttpRequests)
	 */
	protected void sequence_BoxComponent(EObject context, BoxComponent semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.BOX_COMPONENT__COMPONENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.BOX_COMPONENT__COMPONENT));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.BOX_COMPONENT__HTTP_REQUEST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.BOX_COMPONENT__HTTP_REQUEST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBoxComponentAccess().getComponentComponentParserRuleCall_0_0(), semanticObject.getComponent());
		feeder.accept(grammarAccess.getBoxComponentAccess().getHttpRequestHttpRequestsParserRuleCall_1_0(), semanticObject.getHttpRequest());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     box=BoxComponent
	 */
	protected void sequence_Box(EObject context, Box semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.BOX__BOX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.BOX__BOX));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBoxAccess().getBoxBoxComponentParserRuleCall_1_0(), semanticObject.getBox());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     cache=NATURAL_NUMBER
	 */
	protected void sequence_Cache(EObject context, Cache semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.CACHE__CACHE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.CACHE__CACHE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCacheAccess().getCacheNATURAL_NUMBERTerminalRuleCall_2_0(), semanticObject.getCache());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     capacity=NATURAL_NUMBER
	 */
	protected void sequence_Capacity(EObject context, Capacity semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.CAPACITY__CAPACITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.CAPACITY__CAPACITY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCapacityAccess().getCapacityNATURAL_NUMBERTerminalRuleCall_2_0(), semanticObject.getCapacity());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     operation+=Operation*
	 */
	protected void sequence_Channel(EObject context, Channel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     channel+=Channel*
	 */
	protected void sequence_Channels(EObject context, Channels semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     command=STRING
	 */
	protected void sequence_Command(EObject context, Command semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.COMMAND__COMMAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.COMMAND__COMMAND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCommandAccess().getCommandSTRINGTerminalRuleCall_2_0(), semanticObject.getCommand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (component=Component bandwidth=Bandwidth latency=Latency?)
	 */
	protected void sequence_CommunicationalComponent(EObject context, CommunicationalComponent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (component=STRING description=Description)
	 */
	protected void sequence_Component(EObject context, Component semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.COMPONENT__COMPONENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.COMPONENT__COMPONENT));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.COMPONENT__DESCRIPTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.COMPONENT__DESCRIPTION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getComponentAccess().getComponentSTRINGTerminalRuleCall_2_0(), semanticObject.getComponent());
		feeder.accept(grammarAccess.getComponentAccess().getDescriptionDescriptionParserRuleCall_3_0(), semanticObject.getDescription());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         component=Component 
	 *         architecture=Architecture 
	 *         cores=Cores 
	 *         speed=Speed 
	 *         memory=Memory 
	 *         cache=Cache
	 *     )
	 */
	protected void sequence_ComputationalComponent(EObject context, ComputationalComponent semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.COMPUTATIONAL_COMPONENT__COMPONENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.COMPUTATIONAL_COMPONENT__COMPONENT));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.COMPUTATIONAL_COMPONENT__ARCHITECTURE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.COMPUTATIONAL_COMPONENT__ARCHITECTURE));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.COMPUTATIONAL_COMPONENT__CORES) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.COMPUTATIONAL_COMPONENT__CORES));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.COMPUTATIONAL_COMPONENT__SPEED) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.COMPUTATIONAL_COMPONENT__SPEED));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.COMPUTATIONAL_COMPONENT__MEMORY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.COMPUTATIONAL_COMPONENT__MEMORY));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.COMPUTATIONAL_COMPONENT__CACHE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.COMPUTATIONAL_COMPONENT__CACHE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getComputationalComponentAccess().getComponentComponentParserRuleCall_0_0(), semanticObject.getComponent());
		feeder.accept(grammarAccess.getComputationalComponentAccess().getArchitectureArchitectureParserRuleCall_1_0(), semanticObject.getArchitecture());
		feeder.accept(grammarAccess.getComputationalComponentAccess().getCoresCoresParserRuleCall_2_0(), semanticObject.getCores());
		feeder.accept(grammarAccess.getComputationalComponentAccess().getSpeedSpeedParserRuleCall_3_0(), semanticObject.getSpeed());
		feeder.accept(grammarAccess.getComputationalComponentAccess().getMemoryMemoryParserRuleCall_4_0(), semanticObject.getMemory());
		feeder.accept(grammarAccess.getComputationalComponentAccess().getCacheCacheParserRuleCall_5_0(), semanticObject.getCache());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     compute=ComputationalComponent
	 */
	protected void sequence_Compute(EObject context, Compute semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.COMPUTE__COMPUTE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.COMPUTE__COMPUTE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getComputeAccess().getComputeComputationalComponentParserRuleCall_1_0(), semanticObject.getCompute());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     cores=NATURAL_NUMBER
	 */
	protected void sequence_Cores(EObject context, Cores semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.CORES__CORES) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.CORES__CORES));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCoresAccess().getCoresNATURAL_NUMBERTerminalRuleCall_2_0(), semanticObject.getCores());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     description=STRING
	 */
	protected void sequence_Description(EObject context, Description semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.DESCRIPTION__DESCRIPTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.DESCRIPTION__DESCRIPTION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDescriptionAccess().getDescriptionSTRINGTerminalRuleCall_2_0(), semanticObject.getDescription());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     digest=STRING
	 */
	protected void sequence_Digest(EObject context, Digest semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.DIGEST__DIGEST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.DIGEST__DIGEST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDigestAccess().getDigestSTRINGTerminalRuleCall_2_0(), semanticObject.getDigest());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (size=NATURAL_NUMBER digest=Digest?)
	 */
	protected void sequence_FileDimension(EObject context, FileDimension semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (fileName=STRING dimension=FileDimension?)
	 */
	protected void sequence_File(EObject context, File semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((box=Box | compute=Compute)? networkResource+=NetworkResource* storageResource+=StorageResource*)
	 */
	protected void sequence_Hardware(EObject context, Hardware semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     http_requests=NATURAL_NUMBER
	 */
	protected void sequence_HttpRequests(EObject context, HttpRequests semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.HTTP_REQUESTS__HTTP_REQUESTS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.HTTP_REQUESTS__HTTP_REQUESTS));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getHttpRequestsAccess().getHttp_requestsNATURAL_NUMBERTerminalRuleCall_2_0(), semanticObject.getHttp_requests());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     informationReturned=STRING
	 */
	protected void sequence_InformationReturned(EObject context, InformationReturned semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.INFORMATION_RETURNED__INFORMATION_RETURNED) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.INFORMATION_RETURNED__INFORMATION_RETURNED));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInformationReturnedAccess().getInformationReturnedSTRINGTerminalRuleCall_2_0(), semanticObject.getInformationReturned());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     latency=NATURAL_NUMBER
	 */
	protected void sequence_Latency(EObject context, Latency semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.LATENCY__LATENCY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.LATENCY__LATENCY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLatencyAccess().getLatencyNATURAL_NUMBERTerminalRuleCall_2_0(), semanticObject.getLatency());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (license='GPL' | license='LGPL' | license='BSD' | license='MIT')
	 */
	protected void sequence_License(EObject context, License semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     memory=NATURAL_NUMBER
	 */
	protected void sequence_Memory(EObject context, Memory semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.MEMORY__MEMORY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.MEMORY__MEMORY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMemoryAccess().getMemoryNATURAL_NUMBERTerminalRuleCall_2_0(), semanticObject.getMemory());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     networkResource=CommunicationalComponent
	 */
	protected void sequence_NetworkResource(EObject context, NetworkResource semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.NETWORK_RESOURCE__NETWORK_RESOURCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.NETWORK_RESOURCE__NETWORK_RESOURCE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNetworkResourceAccess().getNetworkResourceCommunicationalComponentParserRuleCall_1_0(), semanticObject.getNetworkResource());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (operation=STRING description=Description command=Command informationReturned=InformationReturned)
	 */
	protected void sequence_Operation(EObject context, Operation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.OPERATION__OPERATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.OPERATION__OPERATION));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.OPERATION__DESCRIPTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.OPERATION__DESCRIPTION));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.OPERATION__COMMAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.OPERATION__COMMAND));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.OPERATION__INFORMATION_RETURNED) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.OPERATION__INFORMATION_RETURNED));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOperationAccess().getOperationSTRINGTerminalRuleCall_2_0(), semanticObject.getOperation());
		feeder.accept(grammarAccess.getOperationAccess().getDescriptionDescriptionParserRuleCall_3_0(), semanticObject.getDescription());
		feeder.accept(grammarAccess.getOperationAccess().getCommandCommandParserRuleCall_4_0(), semanticObject.getCommand());
		feeder.accept(grammarAccess.getOperationAccess().getInformationReturnedInformationReturnedParserRuleCall_5_0(), semanticObject.getInformationReturned());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     paasOffering=STRING
	 */
	protected void sequence_PaasOfferingInfos(EObject context, PaasOfferingInfos semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.PAAS_OFFERING_INFOS__PAAS_OFFERING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.PAAS_OFFERING_INFOS__PAAS_OFFERING));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPaasOfferingInfosAccess().getPaasOfferingSTRINGTerminalRuleCall_2_0(), semanticObject.getPaasOffering());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (paasOfferingInfos=PaasOfferingInfos channels=Channels technology=TechnologyInfo)
	 */
	protected void sequence_PaasOfferingProfile(EObject context, PaasOfferingProfile semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.PAAS_OFFERING_PROFILE__PAAS_OFFERING_INFOS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.PAAS_OFFERING_PROFILE__PAAS_OFFERING_INFOS));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.PAAS_OFFERING_PROFILE__CHANNELS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.PAAS_OFFERING_PROFILE__CHANNELS));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.PAAS_OFFERING_PROFILE__TECHNOLOGY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.PAAS_OFFERING_PROFILE__TECHNOLOGY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPaasOfferingProfileAccess().getPaasOfferingInfosPaasOfferingInfosParserRuleCall_0_0(), semanticObject.getPaasOfferingInfos());
		feeder.accept(grammarAccess.getPaasOfferingProfileAccess().getChannelsChannelsParserRuleCall_1_0(), semanticObject.getChannels());
		feeder.accept(grammarAccess.getPaasOfferingProfileAccess().getTechnologyTechnologyInfoParserRuleCall_2_0(), semanticObject.getTechnology());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (firstName=STRING surnName=STRING email=STRING birthDay=Birthday?)
	 */
	protected void sequence_PersonalInfos(EObject context, PersonalInfos semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (programmingLanguage=STRING version=Version)
	 */
	protected void sequence_ProgrammingLanguage(EObject context, ProgrammingLanguage semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.PROGRAMMING_LANGUAGE__PROGRAMMING_LANGUAGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.PROGRAMMING_LANGUAGE__PROGRAMMING_LANGUAGE));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.PROGRAMMING_LANGUAGE__VERSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.PROGRAMMING_LANGUAGE__VERSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getProgrammingLanguageAccess().getProgrammingLanguageSTRINGTerminalRuleCall_2_0(), semanticObject.getProgrammingLanguage());
		feeder.accept(grammarAccess.getProgrammingLanguageAccess().getVersionVersionParserRuleCall_3_0(), semanticObject.getVersion());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (provider=STRING homepage=STRING)
	 */
	protected void sequence_Provider(EObject context, eu.cloud4soa.xtext.dsl.Provider semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.PROVIDER__PROVIDER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.PROVIDER__PROVIDER));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.PROVIDER__HOMEPAGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.PROVIDER__HOMEPAGE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getProviderAccess().getProviderSTRINGTerminalRuleCall_0_0(), semanticObject.getProvider());
		feeder.accept(grammarAccess.getProviderAccess().getHomepageSTRINGTerminalRuleCall_3_0(), semanticObject.getHomepage());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (userProfile=UserProfile | applicationProfile=ApplicationProfile | paasOfferingProfile=PaasOfferingProfile)
	 */
	protected void sequence_Scope(EObject context, Scope semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (category=STRING description=Description)
	 */
	protected void sequence_SoftwareCategory(EObject context, SoftwareCategory semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.SOFTWARE_CATEGORY__CATEGORY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.SOFTWARE_CATEGORY__CATEGORY));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.SOFTWARE_CATEGORY__DESCRIPTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.SOFTWARE_CATEGORY__DESCRIPTION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSoftwareCategoryAccess().getCategorySTRINGTerminalRuleCall_2_0(), semanticObject.getCategory());
		feeder.accept(grammarAccess.getSoftwareCategoryAccess().getDescriptionDescriptionParserRuleCall_3_0(), semanticObject.getDescription());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (component=Component version=Version license=License?)
	 */
	protected void sequence_SoftwareComponent(EObject context, SoftwareComponent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (category+=SoftwareCategory component+=SoftwareComponent+)+
	 */
	protected void sequence_Software(EObject context, Software semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     speed=NATURAL_NUMBER
	 */
	protected void sequence_Speed(EObject context, Speed semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.SPEED__SPEED) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.SPEED__SPEED));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSpeedAccess().getSpeedNATURAL_NUMBERTerminalRuleCall_2_0(), semanticObject.getSpeed());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (component=Component capacity=Capacity bandwidth=Bandwidth?)
	 */
	protected void sequence_StorageComponent(EObject context, StorageComponent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     storageComponent=StorageComponent
	 */
	protected void sequence_StorageResource(EObject context, StorageResource semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.STORAGE_RESOURCE__STORAGE_COMPONENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.STORAGE_RESOURCE__STORAGE_COMPONENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStorageResourceAccess().getStorageComponentStorageComponentParserRuleCall_1_0(), semanticObject.getStorageComponent());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (programmingLanguage=ProgrammingLanguage software=Software hardware=Hardware)
	 */
	protected void sequence_TechnologyInfo(EObject context, TechnologyInfo semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.TECHNOLOGY_INFO__PROGRAMMING_LANGUAGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.TECHNOLOGY_INFO__PROGRAMMING_LANGUAGE));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.TECHNOLOGY_INFO__SOFTWARE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.TECHNOLOGY_INFO__SOFTWARE));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.TECHNOLOGY_INFO__HARDWARE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.TECHNOLOGY_INFO__HARDWARE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTechnologyInfoAccess().getProgrammingLanguageProgrammingLanguageParserRuleCall_0_0(), semanticObject.getProgrammingLanguage());
		feeder.accept(grammarAccess.getTechnologyInfoAccess().getSoftwareSoftwareParserRuleCall_1_0(), semanticObject.getSoftware());
		feeder.accept(grammarAccess.getTechnologyInfoAccess().getHardwareHardwareParserRuleCall_2_0(), semanticObject.getHardware());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (provider=Provider? accountInfo=AccountInfo personalInfo=PersonalInfos)
	 */
	protected void sequence_UserProfile(EObject context, UserProfile semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=NATURAL_NUMBER
	 */
	protected void sequence_Version(EObject context, Version semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.VERSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.VERSION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVersionAccess().getValueNATURAL_NUMBERTerminalRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
}
