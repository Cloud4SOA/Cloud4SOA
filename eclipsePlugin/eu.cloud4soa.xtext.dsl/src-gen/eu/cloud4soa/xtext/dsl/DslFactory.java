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


/**
 * <copyright>
 * </copyright>
 *
 */
package eu.cloud4soa.xtext.dsl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eu.cloud4soa.xtext.dsl.DslPackage
 * @generated
 */
public interface DslFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DslFactory eINSTANCE = eu.cloud4soa.xtext.dsl.impl.DslFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Scope</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scope</em>'.
   * @generated
   */
  Scope createScope();

  /**
   * Returns a new object of class '<em>User Profile</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>User Profile</em>'.
   * @generated
   */
  UserProfile createUserProfile();

  /**
   * Returns a new object of class '<em>Personal Infos</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Personal Infos</em>'.
   * @generated
   */
  PersonalInfos createPersonalInfos();

  /**
   * Returns a new object of class '<em>Birthday</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Birthday</em>'.
   * @generated
   */
  Birthday createBirthday();

  /**
   * Returns a new object of class '<em>Account Info</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Account Info</em>'.
   * @generated
   */
  AccountInfo createAccountInfo();

  /**
   * Returns a new object of class '<em>Provider</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Provider</em>'.
   * @generated
   */
  Provider createProvider();

  /**
   * Returns a new object of class '<em>Application Profile</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Application Profile</em>'.
   * @generated
   */
  ApplicationProfile createApplicationProfile();

  /**
   * Returns a new object of class '<em>Application Infos</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Application Infos</em>'.
   * @generated
   */
  ApplicationInfos createApplicationInfos();

  /**
   * Returns a new object of class '<em>Application Code</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Application Code</em>'.
   * @generated
   */
  ApplicationCode createApplicationCode();

  /**
   * Returns a new object of class '<em>Paas Offering Profile</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Paas Offering Profile</em>'.
   * @generated
   */
  PaasOfferingProfile createPaasOfferingProfile();

  /**
   * Returns a new object of class '<em>Paas Offering Infos</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Paas Offering Infos</em>'.
   * @generated
   */
  PaasOfferingInfos createPaasOfferingInfos();

  /**
   * Returns a new object of class '<em>File</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>File</em>'.
   * @generated
   */
  File createFile();

  /**
   * Returns a new object of class '<em>File Dimension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>File Dimension</em>'.
   * @generated
   */
  FileDimension createFileDimension();

  /**
   * Returns a new object of class '<em>Digest</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Digest</em>'.
   * @generated
   */
  Digest createDigest();

  /**
   * Returns a new object of class '<em>Technology Info</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Technology Info</em>'.
   * @generated
   */
  TechnologyInfo createTechnologyInfo();

  /**
   * Returns a new object of class '<em>Programming Language</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Programming Language</em>'.
   * @generated
   */
  ProgrammingLanguage createProgrammingLanguage();

  /**
   * Returns a new object of class '<em>Software</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Software</em>'.
   * @generated
   */
  Software createSoftware();

  /**
   * Returns a new object of class '<em>Software Category</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Software Category</em>'.
   * @generated
   */
  SoftwareCategory createSoftwareCategory();

  /**
   * Returns a new object of class '<em>Software Component</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Software Component</em>'.
   * @generated
   */
  SoftwareComponent createSoftwareComponent();

  /**
   * Returns a new object of class '<em>Component</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component</em>'.
   * @generated
   */
  Component createComponent();

  /**
   * Returns a new object of class '<em>Description</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Description</em>'.
   * @generated
   */
  Description createDescription();

  /**
   * Returns a new object of class '<em>License</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>License</em>'.
   * @generated
   */
  License createLicense();

  /**
   * Returns a new object of class '<em>Hardware</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Hardware</em>'.
   * @generated
   */
  Hardware createHardware();

  /**
   * Returns a new object of class '<em>Box</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Box</em>'.
   * @generated
   */
  Box createBox();

  /**
   * Returns a new object of class '<em>Box Component</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Box Component</em>'.
   * @generated
   */
  BoxComponent createBoxComponent();

  /**
   * Returns a new object of class '<em>Http Requests</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Requests</em>'.
   * @generated
   */
  HttpRequests createHttpRequests();

  /**
   * Returns a new object of class '<em>Compute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Compute</em>'.
   * @generated
   */
  Compute createCompute();

  /**
   * Returns a new object of class '<em>Computational Component</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Computational Component</em>'.
   * @generated
   */
  ComputationalComponent createComputationalComponent();

  /**
   * Returns a new object of class '<em>Architecture</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Architecture</em>'.
   * @generated
   */
  Architecture createArchitecture();

  /**
   * Returns a new object of class '<em>Cores</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cores</em>'.
   * @generated
   */
  Cores createCores();

  /**
   * Returns a new object of class '<em>Speed</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Speed</em>'.
   * @generated
   */
  Speed createSpeed();

  /**
   * Returns a new object of class '<em>Memory</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Memory</em>'.
   * @generated
   */
  Memory createMemory();

  /**
   * Returns a new object of class '<em>Cache</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cache</em>'.
   * @generated
   */
  Cache createCache();

  /**
   * Returns a new object of class '<em>Network Resource</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Network Resource</em>'.
   * @generated
   */
  NetworkResource createNetworkResource();

  /**
   * Returns a new object of class '<em>Communicational Component</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Communicational Component</em>'.
   * @generated
   */
  CommunicationalComponent createCommunicationalComponent();

  /**
   * Returns a new object of class '<em>Bandwidth</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bandwidth</em>'.
   * @generated
   */
  Bandwidth createBandwidth();

  /**
   * Returns a new object of class '<em>Latency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Latency</em>'.
   * @generated
   */
  Latency createLatency();

  /**
   * Returns a new object of class '<em>Storage Resource</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Storage Resource</em>'.
   * @generated
   */
  StorageResource createStorageResource();

  /**
   * Returns a new object of class '<em>Storage Component</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Storage Component</em>'.
   * @generated
   */
  StorageComponent createStorageComponent();

  /**
   * Returns a new object of class '<em>Capacity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Capacity</em>'.
   * @generated
   */
  Capacity createCapacity();

  /**
   * Returns a new object of class '<em>Channels</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Channels</em>'.
   * @generated
   */
  Channels createChannels();

  /**
   * Returns a new object of class '<em>Channel</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Channel</em>'.
   * @generated
   */
  Channel createChannel();

  /**
   * Returns a new object of class '<em>Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operation</em>'.
   * @generated
   */
  Operation createOperation();

  /**
   * Returns a new object of class '<em>Command</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Command</em>'.
   * @generated
   */
  Command createCommand();

  /**
   * Returns a new object of class '<em>Information Returned</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Information Returned</em>'.
   * @generated
   */
  InformationReturned createInformationReturned();

  /**
   * Returns a new object of class '<em>Version</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Version</em>'.
   * @generated
   */
  Version createVersion();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  DslPackage getDslPackage();

} //DslFactory
