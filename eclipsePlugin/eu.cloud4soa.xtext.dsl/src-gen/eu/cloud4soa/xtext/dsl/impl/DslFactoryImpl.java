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
package eu.cloud4soa.xtext.dsl.impl;

import eu.cloud4soa.xtext.dsl.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DslFactoryImpl extends EFactoryImpl implements DslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static DslFactory init()
  {
    try
    {
      DslFactory theDslFactory = (DslFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.cloud4soa.eu/xtext/Dsl"); 
      if (theDslFactory != null)
      {
        return theDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new DslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case DslPackage.SCOPE: return createScope();
      case DslPackage.USER_PROFILE: return createUserProfile();
      case DslPackage.PERSONAL_INFOS: return createPersonalInfos();
      case DslPackage.BIRTHDAY: return createBirthday();
      case DslPackage.ACCOUNT_INFO: return createAccountInfo();
      case DslPackage.PROVIDER: return createProvider();
      case DslPackage.APPLICATION_PROFILE: return createApplicationProfile();
      case DslPackage.APPLICATION_INFOS: return createApplicationInfos();
      case DslPackage.APPLICATION_CODE: return createApplicationCode();
      case DslPackage.PAAS_OFFERING_PROFILE: return createPaasOfferingProfile();
      case DslPackage.PAAS_OFFERING_INFOS: return createPaasOfferingInfos();
      case DslPackage.FILE: return createFile();
      case DslPackage.FILE_DIMENSION: return createFileDimension();
      case DslPackage.DIGEST: return createDigest();
      case DslPackage.TECHNOLOGY_INFO: return createTechnologyInfo();
      case DslPackage.PROGRAMMING_LANGUAGE: return createProgrammingLanguage();
      case DslPackage.SOFTWARE: return createSoftware();
      case DslPackage.SOFTWARE_CATEGORY: return createSoftwareCategory();
      case DslPackage.SOFTWARE_COMPONENT: return createSoftwareComponent();
      case DslPackage.COMPONENT: return createComponent();
      case DslPackage.DESCRIPTION: return createDescription();
      case DslPackage.LICENSE: return createLicense();
      case DslPackage.HARDWARE: return createHardware();
      case DslPackage.BOX: return createBox();
      case DslPackage.BOX_COMPONENT: return createBoxComponent();
      case DslPackage.HTTP_REQUESTS: return createHttpRequests();
      case DslPackage.COMPUTE: return createCompute();
      case DslPackage.COMPUTATIONAL_COMPONENT: return createComputationalComponent();
      case DslPackage.ARCHITECTURE: return createArchitecture();
      case DslPackage.CORES: return createCores();
      case DslPackage.SPEED: return createSpeed();
      case DslPackage.MEMORY: return createMemory();
      case DslPackage.CACHE: return createCache();
      case DslPackage.NETWORK_RESOURCE: return createNetworkResource();
      case DslPackage.COMMUNICATIONAL_COMPONENT: return createCommunicationalComponent();
      case DslPackage.BANDWIDTH: return createBandwidth();
      case DslPackage.LATENCY: return createLatency();
      case DslPackage.STORAGE_RESOURCE: return createStorageResource();
      case DslPackage.STORAGE_COMPONENT: return createStorageComponent();
      case DslPackage.CAPACITY: return createCapacity();
      case DslPackage.CHANNELS: return createChannels();
      case DslPackage.CHANNEL: return createChannel();
      case DslPackage.OPERATION: return createOperation();
      case DslPackage.COMMAND: return createCommand();
      case DslPackage.INFORMATION_RETURNED: return createInformationReturned();
      case DslPackage.VERSION: return createVersion();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scope createScope()
  {
    ScopeImpl scope = new ScopeImpl();
    return scope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UserProfile createUserProfile()
  {
    UserProfileImpl userProfile = new UserProfileImpl();
    return userProfile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PersonalInfos createPersonalInfos()
  {
    PersonalInfosImpl personalInfos = new PersonalInfosImpl();
    return personalInfos;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Birthday createBirthday()
  {
    BirthdayImpl birthday = new BirthdayImpl();
    return birthday;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AccountInfo createAccountInfo()
  {
    AccountInfoImpl accountInfo = new AccountInfoImpl();
    return accountInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Provider createProvider()
  {
    ProviderImpl provider = new ProviderImpl();
    return provider;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ApplicationProfile createApplicationProfile()
  {
    ApplicationProfileImpl applicationProfile = new ApplicationProfileImpl();
    return applicationProfile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ApplicationInfos createApplicationInfos()
  {
    ApplicationInfosImpl applicationInfos = new ApplicationInfosImpl();
    return applicationInfos;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ApplicationCode createApplicationCode()
  {
    ApplicationCodeImpl applicationCode = new ApplicationCodeImpl();
    return applicationCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PaasOfferingProfile createPaasOfferingProfile()
  {
    PaasOfferingProfileImpl paasOfferingProfile = new PaasOfferingProfileImpl();
    return paasOfferingProfile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PaasOfferingInfos createPaasOfferingInfos()
  {
    PaasOfferingInfosImpl paasOfferingInfos = new PaasOfferingInfosImpl();
    return paasOfferingInfos;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public File createFile()
  {
    FileImpl file = new FileImpl();
    return file;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FileDimension createFileDimension()
  {
    FileDimensionImpl fileDimension = new FileDimensionImpl();
    return fileDimension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Digest createDigest()
  {
    DigestImpl digest = new DigestImpl();
    return digest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TechnologyInfo createTechnologyInfo()
  {
    TechnologyInfoImpl technologyInfo = new TechnologyInfoImpl();
    return technologyInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProgrammingLanguage createProgrammingLanguage()
  {
    ProgrammingLanguageImpl programmingLanguage = new ProgrammingLanguageImpl();
    return programmingLanguage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Software createSoftware()
  {
    SoftwareImpl software = new SoftwareImpl();
    return software;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SoftwareCategory createSoftwareCategory()
  {
    SoftwareCategoryImpl softwareCategory = new SoftwareCategoryImpl();
    return softwareCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SoftwareComponent createSoftwareComponent()
  {
    SoftwareComponentImpl softwareComponent = new SoftwareComponentImpl();
    return softwareComponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Component createComponent()
  {
    ComponentImpl component = new ComponentImpl();
    return component;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Description createDescription()
  {
    DescriptionImpl description = new DescriptionImpl();
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public License createLicense()
  {
    LicenseImpl license = new LicenseImpl();
    return license;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Hardware createHardware()
  {
    HardwareImpl hardware = new HardwareImpl();
    return hardware;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Box createBox()
  {
    BoxImpl box = new BoxImpl();
    return box;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoxComponent createBoxComponent()
  {
    BoxComponentImpl boxComponent = new BoxComponentImpl();
    return boxComponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HttpRequests createHttpRequests()
  {
    HttpRequestsImpl httpRequests = new HttpRequestsImpl();
    return httpRequests;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Compute createCompute()
  {
    ComputeImpl compute = new ComputeImpl();
    return compute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComputationalComponent createComputationalComponent()
  {
    ComputationalComponentImpl computationalComponent = new ComputationalComponentImpl();
    return computationalComponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Architecture createArchitecture()
  {
    ArchitectureImpl architecture = new ArchitectureImpl();
    return architecture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cores createCores()
  {
    CoresImpl cores = new CoresImpl();
    return cores;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Speed createSpeed()
  {
    SpeedImpl speed = new SpeedImpl();
    return speed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Memory createMemory()
  {
    MemoryImpl memory = new MemoryImpl();
    return memory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cache createCache()
  {
    CacheImpl cache = new CacheImpl();
    return cache;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NetworkResource createNetworkResource()
  {
    NetworkResourceImpl networkResource = new NetworkResourceImpl();
    return networkResource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommunicationalComponent createCommunicationalComponent()
  {
    CommunicationalComponentImpl communicationalComponent = new CommunicationalComponentImpl();
    return communicationalComponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bandwidth createBandwidth()
  {
    BandwidthImpl bandwidth = new BandwidthImpl();
    return bandwidth;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Latency createLatency()
  {
    LatencyImpl latency = new LatencyImpl();
    return latency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StorageResource createStorageResource()
  {
    StorageResourceImpl storageResource = new StorageResourceImpl();
    return storageResource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StorageComponent createStorageComponent()
  {
    StorageComponentImpl storageComponent = new StorageComponentImpl();
    return storageComponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Capacity createCapacity()
  {
    CapacityImpl capacity = new CapacityImpl();
    return capacity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Channels createChannels()
  {
    ChannelsImpl channels = new ChannelsImpl();
    return channels;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Channel createChannel()
  {
    ChannelImpl channel = new ChannelImpl();
    return channel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operation createOperation()
  {
    OperationImpl operation = new OperationImpl();
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Command createCommand()
  {
    CommandImpl command = new CommandImpl();
    return command;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InformationReturned createInformationReturned()
  {
    InformationReturnedImpl informationReturned = new InformationReturnedImpl();
    return informationReturned;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Version createVersion()
  {
    VersionImpl version = new VersionImpl();
    return version;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslPackage getDslPackage()
  {
    return (DslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static DslPackage getPackage()
  {
    return DslPackage.eINSTANCE;
  }

} //DslFactoryImpl
