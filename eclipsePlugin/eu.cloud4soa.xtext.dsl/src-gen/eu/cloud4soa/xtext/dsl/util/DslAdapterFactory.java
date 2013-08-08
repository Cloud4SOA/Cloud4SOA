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
package eu.cloud4soa.xtext.dsl.util;

import eu.cloud4soa.xtext.dsl.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.cloud4soa.xtext.dsl.DslPackage
 * @generated
 */
public class DslAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static DslPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = DslPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DslSwitch<Adapter> modelSwitch =
    new DslSwitch<Adapter>()
    {
      @Override
      public Adapter caseScope(Scope object)
      {
        return createScopeAdapter();
      }
      @Override
      public Adapter caseUserProfile(UserProfile object)
      {
        return createUserProfileAdapter();
      }
      @Override
      public Adapter casePersonalInfos(PersonalInfos object)
      {
        return createPersonalInfosAdapter();
      }
      @Override
      public Adapter caseBirthday(Birthday object)
      {
        return createBirthdayAdapter();
      }
      @Override
      public Adapter caseAccountInfo(AccountInfo object)
      {
        return createAccountInfoAdapter();
      }
      @Override
      public Adapter caseProvider(Provider object)
      {
        return createProviderAdapter();
      }
      @Override
      public Adapter caseApplicationProfile(ApplicationProfile object)
      {
        return createApplicationProfileAdapter();
      }
      @Override
      public Adapter caseApplicationInfos(ApplicationInfos object)
      {
        return createApplicationInfosAdapter();
      }
      @Override
      public Adapter caseApplicationCode(ApplicationCode object)
      {
        return createApplicationCodeAdapter();
      }
      @Override
      public Adapter casePaasOfferingProfile(PaasOfferingProfile object)
      {
        return createPaasOfferingProfileAdapter();
      }
      @Override
      public Adapter casePaasOfferingInfos(PaasOfferingInfos object)
      {
        return createPaasOfferingInfosAdapter();
      }
      @Override
      public Adapter caseFile(File object)
      {
        return createFileAdapter();
      }
      @Override
      public Adapter caseFileDimension(FileDimension object)
      {
        return createFileDimensionAdapter();
      }
      @Override
      public Adapter caseDigest(Digest object)
      {
        return createDigestAdapter();
      }
      @Override
      public Adapter caseTechnologyInfo(TechnologyInfo object)
      {
        return createTechnologyInfoAdapter();
      }
      @Override
      public Adapter caseProgrammingLanguage(ProgrammingLanguage object)
      {
        return createProgrammingLanguageAdapter();
      }
      @Override
      public Adapter caseSoftware(Software object)
      {
        return createSoftwareAdapter();
      }
      @Override
      public Adapter caseSoftwareCategory(SoftwareCategory object)
      {
        return createSoftwareCategoryAdapter();
      }
      @Override
      public Adapter caseSoftwareComponent(SoftwareComponent object)
      {
        return createSoftwareComponentAdapter();
      }
      @Override
      public Adapter caseComponent(Component object)
      {
        return createComponentAdapter();
      }
      @Override
      public Adapter caseDescription(Description object)
      {
        return createDescriptionAdapter();
      }
      @Override
      public Adapter caseLicense(License object)
      {
        return createLicenseAdapter();
      }
      @Override
      public Adapter caseHardware(Hardware object)
      {
        return createHardwareAdapter();
      }
      @Override
      public Adapter caseBox(Box object)
      {
        return createBoxAdapter();
      }
      @Override
      public Adapter caseBoxComponent(BoxComponent object)
      {
        return createBoxComponentAdapter();
      }
      @Override
      public Adapter caseHttpRequests(HttpRequests object)
      {
        return createHttpRequestsAdapter();
      }
      @Override
      public Adapter caseCompute(Compute object)
      {
        return createComputeAdapter();
      }
      @Override
      public Adapter caseComputationalComponent(ComputationalComponent object)
      {
        return createComputationalComponentAdapter();
      }
      @Override
      public Adapter caseArchitecture(Architecture object)
      {
        return createArchitectureAdapter();
      }
      @Override
      public Adapter caseCores(Cores object)
      {
        return createCoresAdapter();
      }
      @Override
      public Adapter caseSpeed(Speed object)
      {
        return createSpeedAdapter();
      }
      @Override
      public Adapter caseMemory(Memory object)
      {
        return createMemoryAdapter();
      }
      @Override
      public Adapter caseCache(Cache object)
      {
        return createCacheAdapter();
      }
      @Override
      public Adapter caseNetworkResource(NetworkResource object)
      {
        return createNetworkResourceAdapter();
      }
      @Override
      public Adapter caseCommunicationalComponent(CommunicationalComponent object)
      {
        return createCommunicationalComponentAdapter();
      }
      @Override
      public Adapter caseBandwidth(Bandwidth object)
      {
        return createBandwidthAdapter();
      }
      @Override
      public Adapter caseLatency(Latency object)
      {
        return createLatencyAdapter();
      }
      @Override
      public Adapter caseStorageResource(StorageResource object)
      {
        return createStorageResourceAdapter();
      }
      @Override
      public Adapter caseStorageComponent(StorageComponent object)
      {
        return createStorageComponentAdapter();
      }
      @Override
      public Adapter caseCapacity(Capacity object)
      {
        return createCapacityAdapter();
      }
      @Override
      public Adapter caseChannels(Channels object)
      {
        return createChannelsAdapter();
      }
      @Override
      public Adapter caseChannel(Channel object)
      {
        return createChannelAdapter();
      }
      @Override
      public Adapter caseOperation(Operation object)
      {
        return createOperationAdapter();
      }
      @Override
      public Adapter caseCommand(Command object)
      {
        return createCommandAdapter();
      }
      @Override
      public Adapter caseInformationReturned(InformationReturned object)
      {
        return createInformationReturnedAdapter();
      }
      @Override
      public Adapter caseVersion(Version object)
      {
        return createVersionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Scope <em>Scope</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Scope
   * @generated
   */
  public Adapter createScopeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.UserProfile <em>User Profile</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.UserProfile
   * @generated
   */
  public Adapter createUserProfileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.PersonalInfos <em>Personal Infos</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.PersonalInfos
   * @generated
   */
  public Adapter createPersonalInfosAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Birthday <em>Birthday</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Birthday
   * @generated
   */
  public Adapter createBirthdayAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.AccountInfo <em>Account Info</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.AccountInfo
   * @generated
   */
  public Adapter createAccountInfoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Provider <em>Provider</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Provider
   * @generated
   */
  public Adapter createProviderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.ApplicationProfile <em>Application Profile</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.ApplicationProfile
   * @generated
   */
  public Adapter createApplicationProfileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.ApplicationInfos <em>Application Infos</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.ApplicationInfos
   * @generated
   */
  public Adapter createApplicationInfosAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.ApplicationCode <em>Application Code</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.ApplicationCode
   * @generated
   */
  public Adapter createApplicationCodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.PaasOfferingProfile <em>Paas Offering Profile</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.PaasOfferingProfile
   * @generated
   */
  public Adapter createPaasOfferingProfileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.PaasOfferingInfos <em>Paas Offering Infos</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.PaasOfferingInfos
   * @generated
   */
  public Adapter createPaasOfferingInfosAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.File <em>File</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.File
   * @generated
   */
  public Adapter createFileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.FileDimension <em>File Dimension</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.FileDimension
   * @generated
   */
  public Adapter createFileDimensionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Digest <em>Digest</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Digest
   * @generated
   */
  public Adapter createDigestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.TechnologyInfo <em>Technology Info</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.TechnologyInfo
   * @generated
   */
  public Adapter createTechnologyInfoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.ProgrammingLanguage <em>Programming Language</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.ProgrammingLanguage
   * @generated
   */
  public Adapter createProgrammingLanguageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Software <em>Software</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Software
   * @generated
   */
  public Adapter createSoftwareAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.SoftwareCategory <em>Software Category</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.SoftwareCategory
   * @generated
   */
  public Adapter createSoftwareCategoryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.SoftwareComponent <em>Software Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.SoftwareComponent
   * @generated
   */
  public Adapter createSoftwareComponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Component <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Component
   * @generated
   */
  public Adapter createComponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Description <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Description
   * @generated
   */
  public Adapter createDescriptionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.License <em>License</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.License
   * @generated
   */
  public Adapter createLicenseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Hardware <em>Hardware</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Hardware
   * @generated
   */
  public Adapter createHardwareAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Box <em>Box</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Box
   * @generated
   */
  public Adapter createBoxAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.BoxComponent <em>Box Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.BoxComponent
   * @generated
   */
  public Adapter createBoxComponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.HttpRequests <em>Http Requests</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.HttpRequests
   * @generated
   */
  public Adapter createHttpRequestsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Compute <em>Compute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Compute
   * @generated
   */
  public Adapter createComputeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.ComputationalComponent <em>Computational Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.ComputationalComponent
   * @generated
   */
  public Adapter createComputationalComponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Architecture <em>Architecture</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Architecture
   * @generated
   */
  public Adapter createArchitectureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Cores <em>Cores</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Cores
   * @generated
   */
  public Adapter createCoresAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Speed <em>Speed</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Speed
   * @generated
   */
  public Adapter createSpeedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Memory <em>Memory</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Memory
   * @generated
   */
  public Adapter createMemoryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Cache <em>Cache</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Cache
   * @generated
   */
  public Adapter createCacheAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.NetworkResource <em>Network Resource</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.NetworkResource
   * @generated
   */
  public Adapter createNetworkResourceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.CommunicationalComponent <em>Communicational Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.CommunicationalComponent
   * @generated
   */
  public Adapter createCommunicationalComponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Bandwidth <em>Bandwidth</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Bandwidth
   * @generated
   */
  public Adapter createBandwidthAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Latency <em>Latency</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Latency
   * @generated
   */
  public Adapter createLatencyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.StorageResource <em>Storage Resource</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.StorageResource
   * @generated
   */
  public Adapter createStorageResourceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.StorageComponent <em>Storage Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.StorageComponent
   * @generated
   */
  public Adapter createStorageComponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Capacity <em>Capacity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Capacity
   * @generated
   */
  public Adapter createCapacityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Channels <em>Channels</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Channels
   * @generated
   */
  public Adapter createChannelsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Channel <em>Channel</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Channel
   * @generated
   */
  public Adapter createChannelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Operation
   * @generated
   */
  public Adapter createOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Command <em>Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Command
   * @generated
   */
  public Adapter createCommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.InformationReturned <em>Information Returned</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.InformationReturned
   * @generated
   */
  public Adapter createInformationReturnedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.cloud4soa.xtext.dsl.Version <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.cloud4soa.xtext.dsl.Version
   * @generated
   */
  public Adapter createVersionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //DslAdapterFactory
