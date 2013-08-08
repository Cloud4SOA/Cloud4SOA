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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see eu.cloud4soa.xtext.dsl.DslPackage
 * @generated
 */
public class DslSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static DslPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = DslPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case DslPackage.SCOPE:
      {
        Scope scope = (Scope)theEObject;
        T result = caseScope(scope);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.USER_PROFILE:
      {
        UserProfile userProfile = (UserProfile)theEObject;
        T result = caseUserProfile(userProfile);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.PERSONAL_INFOS:
      {
        PersonalInfos personalInfos = (PersonalInfos)theEObject;
        T result = casePersonalInfos(personalInfos);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.BIRTHDAY:
      {
        Birthday birthday = (Birthday)theEObject;
        T result = caseBirthday(birthday);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.ACCOUNT_INFO:
      {
        AccountInfo accountInfo = (AccountInfo)theEObject;
        T result = caseAccountInfo(accountInfo);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.PROVIDER:
      {
        Provider provider = (Provider)theEObject;
        T result = caseProvider(provider);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.APPLICATION_PROFILE:
      {
        ApplicationProfile applicationProfile = (ApplicationProfile)theEObject;
        T result = caseApplicationProfile(applicationProfile);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.APPLICATION_INFOS:
      {
        ApplicationInfos applicationInfos = (ApplicationInfos)theEObject;
        T result = caseApplicationInfos(applicationInfos);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.APPLICATION_CODE:
      {
        ApplicationCode applicationCode = (ApplicationCode)theEObject;
        T result = caseApplicationCode(applicationCode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.PAAS_OFFERING_PROFILE:
      {
        PaasOfferingProfile paasOfferingProfile = (PaasOfferingProfile)theEObject;
        T result = casePaasOfferingProfile(paasOfferingProfile);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.PAAS_OFFERING_INFOS:
      {
        PaasOfferingInfos paasOfferingInfos = (PaasOfferingInfos)theEObject;
        T result = casePaasOfferingInfos(paasOfferingInfos);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.FILE:
      {
        File file = (File)theEObject;
        T result = caseFile(file);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.FILE_DIMENSION:
      {
        FileDimension fileDimension = (FileDimension)theEObject;
        T result = caseFileDimension(fileDimension);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.DIGEST:
      {
        Digest digest = (Digest)theEObject;
        T result = caseDigest(digest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.TECHNOLOGY_INFO:
      {
        TechnologyInfo technologyInfo = (TechnologyInfo)theEObject;
        T result = caseTechnologyInfo(technologyInfo);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.PROGRAMMING_LANGUAGE:
      {
        ProgrammingLanguage programmingLanguage = (ProgrammingLanguage)theEObject;
        T result = caseProgrammingLanguage(programmingLanguage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.SOFTWARE:
      {
        Software software = (Software)theEObject;
        T result = caseSoftware(software);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.SOFTWARE_CATEGORY:
      {
        SoftwareCategory softwareCategory = (SoftwareCategory)theEObject;
        T result = caseSoftwareCategory(softwareCategory);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.SOFTWARE_COMPONENT:
      {
        SoftwareComponent softwareComponent = (SoftwareComponent)theEObject;
        T result = caseSoftwareComponent(softwareComponent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.COMPONENT:
      {
        Component component = (Component)theEObject;
        T result = caseComponent(component);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.DESCRIPTION:
      {
        Description description = (Description)theEObject;
        T result = caseDescription(description);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.LICENSE:
      {
        License license = (License)theEObject;
        T result = caseLicense(license);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.HARDWARE:
      {
        Hardware hardware = (Hardware)theEObject;
        T result = caseHardware(hardware);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.BOX:
      {
        Box box = (Box)theEObject;
        T result = caseBox(box);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.BOX_COMPONENT:
      {
        BoxComponent boxComponent = (BoxComponent)theEObject;
        T result = caseBoxComponent(boxComponent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.HTTP_REQUESTS:
      {
        HttpRequests httpRequests = (HttpRequests)theEObject;
        T result = caseHttpRequests(httpRequests);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.COMPUTE:
      {
        Compute compute = (Compute)theEObject;
        T result = caseCompute(compute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.COMPUTATIONAL_COMPONENT:
      {
        ComputationalComponent computationalComponent = (ComputationalComponent)theEObject;
        T result = caseComputationalComponent(computationalComponent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.ARCHITECTURE:
      {
        Architecture architecture = (Architecture)theEObject;
        T result = caseArchitecture(architecture);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.CORES:
      {
        Cores cores = (Cores)theEObject;
        T result = caseCores(cores);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.SPEED:
      {
        Speed speed = (Speed)theEObject;
        T result = caseSpeed(speed);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.MEMORY:
      {
        Memory memory = (Memory)theEObject;
        T result = caseMemory(memory);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.CACHE:
      {
        Cache cache = (Cache)theEObject;
        T result = caseCache(cache);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.NETWORK_RESOURCE:
      {
        NetworkResource networkResource = (NetworkResource)theEObject;
        T result = caseNetworkResource(networkResource);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.COMMUNICATIONAL_COMPONENT:
      {
        CommunicationalComponent communicationalComponent = (CommunicationalComponent)theEObject;
        T result = caseCommunicationalComponent(communicationalComponent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.BANDWIDTH:
      {
        Bandwidth bandwidth = (Bandwidth)theEObject;
        T result = caseBandwidth(bandwidth);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.LATENCY:
      {
        Latency latency = (Latency)theEObject;
        T result = caseLatency(latency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.STORAGE_RESOURCE:
      {
        StorageResource storageResource = (StorageResource)theEObject;
        T result = caseStorageResource(storageResource);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.STORAGE_COMPONENT:
      {
        StorageComponent storageComponent = (StorageComponent)theEObject;
        T result = caseStorageComponent(storageComponent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.CAPACITY:
      {
        Capacity capacity = (Capacity)theEObject;
        T result = caseCapacity(capacity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.CHANNELS:
      {
        Channels channels = (Channels)theEObject;
        T result = caseChannels(channels);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.CHANNEL:
      {
        Channel channel = (Channel)theEObject;
        T result = caseChannel(channel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.OPERATION:
      {
        Operation operation = (Operation)theEObject;
        T result = caseOperation(operation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.COMMAND:
      {
        Command command = (Command)theEObject;
        T result = caseCommand(command);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.INFORMATION_RETURNED:
      {
        InformationReturned informationReturned = (InformationReturned)theEObject;
        T result = caseInformationReturned(informationReturned);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.VERSION:
      {
        Version version = (Version)theEObject;
        T result = caseVersion(version);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scope</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scope</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScope(Scope object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>User Profile</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>User Profile</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUserProfile(UserProfile object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Personal Infos</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Personal Infos</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePersonalInfos(PersonalInfos object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Birthday</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Birthday</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBirthday(Birthday object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Account Info</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Account Info</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAccountInfo(AccountInfo object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Provider</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Provider</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProvider(Provider object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Application Profile</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Application Profile</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseApplicationProfile(ApplicationProfile object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Application Infos</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Application Infos</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseApplicationInfos(ApplicationInfos object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Application Code</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Application Code</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseApplicationCode(ApplicationCode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Paas Offering Profile</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Paas Offering Profile</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePaasOfferingProfile(PaasOfferingProfile object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Paas Offering Infos</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Paas Offering Infos</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePaasOfferingInfos(PaasOfferingInfos object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>File</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>File</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFile(File object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>File Dimension</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>File Dimension</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFileDimension(FileDimension object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Digest</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Digest</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDigest(Digest object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Technology Info</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Technology Info</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTechnologyInfo(TechnologyInfo object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Programming Language</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Programming Language</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProgrammingLanguage(ProgrammingLanguage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Software</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Software</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSoftware(Software object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Software Category</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Software Category</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSoftwareCategory(SoftwareCategory object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Software Component</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Software Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSoftwareComponent(SoftwareComponent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponent(Component object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Description</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Description</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDescription(Description object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>License</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>License</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLicense(License object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Hardware</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Hardware</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHardware(Hardware object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Box</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Box</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBox(Box object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Box Component</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Box Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBoxComponent(BoxComponent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Http Requests</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Http Requests</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHttpRequests(HttpRequests object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Compute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Compute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCompute(Compute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Computational Component</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Computational Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComputationalComponent(ComputationalComponent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Architecture</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Architecture</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArchitecture(Architecture object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cores</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cores</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCores(Cores object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Speed</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Speed</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSpeed(Speed object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Memory</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Memory</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMemory(Memory object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cache</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cache</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCache(Cache object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Network Resource</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Network Resource</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNetworkResource(NetworkResource object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Communicational Component</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Communicational Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommunicationalComponent(CommunicationalComponent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bandwidth</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bandwidth</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBandwidth(Bandwidth object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Latency</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Latency</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLatency(Latency object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Storage Resource</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Storage Resource</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStorageResource(StorageResource object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Storage Component</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Storage Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStorageComponent(StorageComponent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Capacity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Capacity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCapacity(Capacity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Channels</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Channels</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseChannels(Channels object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Channel</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Channel</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseChannel(Channel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperation(Operation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommand(Command object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Information Returned</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Information Returned</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInformationReturned(InformationReturned object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Version</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Version</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVersion(Version object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //DslSwitch
