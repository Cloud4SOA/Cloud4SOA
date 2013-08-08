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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.cloud4soa.xtext.dsl.DslFactory
 * @model kind="package"
 * @generated
 */
public interface DslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "dsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.cloud4soa.eu/xtext/Dsl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "dsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DslPackage eINSTANCE = eu.cloud4soa.xtext.dsl.impl.DslPackageImpl.init();

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.ScopeImpl <em>Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.ScopeImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getScope()
   * @generated
   */
  int SCOPE = 0;

  /**
   * The feature id for the '<em><b>User Profile</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE__USER_PROFILE = 0;

  /**
   * The feature id for the '<em><b>Application Profile</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE__APPLICATION_PROFILE = 1;

  /**
   * The feature id for the '<em><b>Paas Offering Profile</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE__PAAS_OFFERING_PROFILE = 2;

  /**
   * The number of structural features of the '<em>Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.UserProfileImpl <em>User Profile</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.UserProfileImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getUserProfile()
   * @generated
   */
  int USER_PROFILE = 1;

  /**
   * The feature id for the '<em><b>Provider</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_PROFILE__PROVIDER = 0;

  /**
   * The feature id for the '<em><b>Account Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_PROFILE__ACCOUNT_INFO = 1;

  /**
   * The feature id for the '<em><b>Personal Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_PROFILE__PERSONAL_INFO = 2;

  /**
   * The number of structural features of the '<em>User Profile</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_PROFILE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.PersonalInfosImpl <em>Personal Infos</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.PersonalInfosImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getPersonalInfos()
   * @generated
   */
  int PERSONAL_INFOS = 2;

  /**
   * The feature id for the '<em><b>First Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERSONAL_INFOS__FIRST_NAME = 0;

  /**
   * The feature id for the '<em><b>Surn Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERSONAL_INFOS__SURN_NAME = 1;

  /**
   * The feature id for the '<em><b>Email</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERSONAL_INFOS__EMAIL = 2;

  /**
   * The feature id for the '<em><b>Birth Day</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERSONAL_INFOS__BIRTH_DAY = 3;

  /**
   * The number of structural features of the '<em>Personal Infos</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERSONAL_INFOS_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.BirthdayImpl <em>Birthday</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.BirthdayImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getBirthday()
   * @generated
   */
  int BIRTHDAY = 3;

  /**
   * The feature id for the '<em><b>Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIRTHDAY__DATE = 0;

  /**
   * The number of structural features of the '<em>Birthday</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIRTHDAY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.AccountInfoImpl <em>Account Info</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.AccountInfoImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getAccountInfo()
   * @generated
   */
  int ACCOUNT_INFO = 4;

  /**
   * The feature id for the '<em><b>Username</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACCOUNT_INFO__USERNAME = 0;

  /**
   * The feature id for the '<em><b>Password</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACCOUNT_INFO__PASSWORD = 1;

  /**
   * The number of structural features of the '<em>Account Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACCOUNT_INFO_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.ProviderImpl <em>Provider</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.ProviderImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getProvider()
   * @generated
   */
  int PROVIDER = 5;

  /**
   * The feature id for the '<em><b>Provider</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVIDER__PROVIDER = 0;

  /**
   * The feature id for the '<em><b>Homepage</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVIDER__HOMEPAGE = 1;

  /**
   * The number of structural features of the '<em>Provider</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVIDER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.ApplicationProfileImpl <em>Application Profile</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.ApplicationProfileImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getApplicationProfile()
   * @generated
   */
  int APPLICATION_PROFILE = 6;

  /**
   * The feature id for the '<em><b>Infos</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_PROFILE__INFOS = 0;

  /**
   * The feature id for the '<em><b>File</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_PROFILE__FILE = 1;

  /**
   * The feature id for the '<em><b>Technology</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_PROFILE__TECHNOLOGY = 2;

  /**
   * The number of structural features of the '<em>Application Profile</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_PROFILE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.ApplicationInfosImpl <em>Application Infos</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.ApplicationInfosImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getApplicationInfos()
   * @generated
   */
  int APPLICATION_INFOS = 7;

  /**
   * The feature id for the '<em><b>Application</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_INFOS__APPLICATION = 0;

  /**
   * The feature id for the '<em><b>Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_INFOS__VERSION = 1;

  /**
   * The feature id for the '<em><b>Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_INFOS__CODE = 2;

  /**
   * The number of structural features of the '<em>Application Infos</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_INFOS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.ApplicationCodeImpl <em>Application Code</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.ApplicationCodeImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getApplicationCode()
   * @generated
   */
  int APPLICATION_CODE = 8;

  /**
   * The feature id for the '<em><b>Application Code</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_CODE__APPLICATION_CODE = 0;

  /**
   * The number of structural features of the '<em>Application Code</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_CODE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.PaasOfferingProfileImpl <em>Paas Offering Profile</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.PaasOfferingProfileImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getPaasOfferingProfile()
   * @generated
   */
  int PAAS_OFFERING_PROFILE = 9;

  /**
   * The feature id for the '<em><b>Paas Offering Infos</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAAS_OFFERING_PROFILE__PAAS_OFFERING_INFOS = 0;

  /**
   * The feature id for the '<em><b>Channels</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAAS_OFFERING_PROFILE__CHANNELS = 1;

  /**
   * The feature id for the '<em><b>Technology</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAAS_OFFERING_PROFILE__TECHNOLOGY = 2;

  /**
   * The number of structural features of the '<em>Paas Offering Profile</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAAS_OFFERING_PROFILE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.PaasOfferingInfosImpl <em>Paas Offering Infos</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.PaasOfferingInfosImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getPaasOfferingInfos()
   * @generated
   */
  int PAAS_OFFERING_INFOS = 10;

  /**
   * The feature id for the '<em><b>Paas Offering</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAAS_OFFERING_INFOS__PAAS_OFFERING = 0;

  /**
   * The number of structural features of the '<em>Paas Offering Infos</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAAS_OFFERING_INFOS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.FileImpl <em>File</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.FileImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getFile()
   * @generated
   */
  int FILE = 11;

  /**
   * The feature id for the '<em><b>File Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE__FILE_NAME = 0;

  /**
   * The feature id for the '<em><b>Dimension</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE__DIMENSION = 1;

  /**
   * The number of structural features of the '<em>File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.FileDimensionImpl <em>File Dimension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.FileDimensionImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getFileDimension()
   * @generated
   */
  int FILE_DIMENSION = 12;

  /**
   * The feature id for the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE_DIMENSION__SIZE = 0;

  /**
   * The feature id for the '<em><b>Digest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE_DIMENSION__DIGEST = 1;

  /**
   * The number of structural features of the '<em>File Dimension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE_DIMENSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.DigestImpl <em>Digest</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.DigestImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getDigest()
   * @generated
   */
  int DIGEST = 13;

  /**
   * The feature id for the '<em><b>Digest</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIGEST__DIGEST = 0;

  /**
   * The number of structural features of the '<em>Digest</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIGEST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.TechnologyInfoImpl <em>Technology Info</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.TechnologyInfoImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getTechnologyInfo()
   * @generated
   */
  int TECHNOLOGY_INFO = 14;

  /**
   * The feature id for the '<em><b>Programming Language</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TECHNOLOGY_INFO__PROGRAMMING_LANGUAGE = 0;

  /**
   * The feature id for the '<em><b>Software</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TECHNOLOGY_INFO__SOFTWARE = 1;

  /**
   * The feature id for the '<em><b>Hardware</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TECHNOLOGY_INFO__HARDWARE = 2;

  /**
   * The number of structural features of the '<em>Technology Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TECHNOLOGY_INFO_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.ProgrammingLanguageImpl <em>Programming Language</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.ProgrammingLanguageImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getProgrammingLanguage()
   * @generated
   */
  int PROGRAMMING_LANGUAGE = 15;

  /**
   * The feature id for the '<em><b>Programming Language</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAMMING_LANGUAGE__PROGRAMMING_LANGUAGE = 0;

  /**
   * The feature id for the '<em><b>Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAMMING_LANGUAGE__VERSION = 1;

  /**
   * The number of structural features of the '<em>Programming Language</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAMMING_LANGUAGE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.SoftwareImpl <em>Software</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.SoftwareImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getSoftware()
   * @generated
   */
  int SOFTWARE = 16;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE__CATEGORY = 0;

  /**
   * The feature id for the '<em><b>Component</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE__COMPONENT = 1;

  /**
   * The number of structural features of the '<em>Software</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.SoftwareCategoryImpl <em>Software Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.SoftwareCategoryImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getSoftwareCategory()
   * @generated
   */
  int SOFTWARE_CATEGORY = 17;

  /**
   * The feature id for the '<em><b>Category</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_CATEGORY__CATEGORY = 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_CATEGORY__DESCRIPTION = 1;

  /**
   * The number of structural features of the '<em>Software Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_CATEGORY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.SoftwareComponentImpl <em>Software Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.SoftwareComponentImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getSoftwareComponent()
   * @generated
   */
  int SOFTWARE_COMPONENT = 18;

  /**
   * The feature id for the '<em><b>Component</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_COMPONENT__COMPONENT = 0;

  /**
   * The feature id for the '<em><b>Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_COMPONENT__VERSION = 1;

  /**
   * The feature id for the '<em><b>License</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_COMPONENT__LICENSE = 2;

  /**
   * The number of structural features of the '<em>Software Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_COMPONENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.ComponentImpl <em>Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.ComponentImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getComponent()
   * @generated
   */
  int COMPONENT = 19;

  /**
   * The feature id for the '<em><b>Component</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT__COMPONENT = 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT__DESCRIPTION = 1;

  /**
   * The number of structural features of the '<em>Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.DescriptionImpl <em>Description</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.DescriptionImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getDescription()
   * @generated
   */
  int DESCRIPTION = 20;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION__DESCRIPTION = 0;

  /**
   * The number of structural features of the '<em>Description</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.LicenseImpl <em>License</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.LicenseImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getLicense()
   * @generated
   */
  int LICENSE = 21;

  /**
   * The feature id for the '<em><b>License</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LICENSE__LICENSE = 0;

  /**
   * The number of structural features of the '<em>License</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LICENSE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.HardwareImpl <em>Hardware</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.HardwareImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getHardware()
   * @generated
   */
  int HARDWARE = 22;

  /**
   * The feature id for the '<em><b>Box</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HARDWARE__BOX = 0;

  /**
   * The feature id for the '<em><b>Compute</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HARDWARE__COMPUTE = 1;

  /**
   * The feature id for the '<em><b>Network Resource</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HARDWARE__NETWORK_RESOURCE = 2;

  /**
   * The feature id for the '<em><b>Storage Resource</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HARDWARE__STORAGE_RESOURCE = 3;

  /**
   * The number of structural features of the '<em>Hardware</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HARDWARE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.BoxImpl <em>Box</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.BoxImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getBox()
   * @generated
   */
  int BOX = 23;

  /**
   * The feature id for the '<em><b>Box</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOX__BOX = 0;

  /**
   * The number of structural features of the '<em>Box</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOX_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.BoxComponentImpl <em>Box Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.BoxComponentImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getBoxComponent()
   * @generated
   */
  int BOX_COMPONENT = 24;

  /**
   * The feature id for the '<em><b>Component</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOX_COMPONENT__COMPONENT = 0;

  /**
   * The feature id for the '<em><b>Http Request</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOX_COMPONENT__HTTP_REQUEST = 1;

  /**
   * The number of structural features of the '<em>Box Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOX_COMPONENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.HttpRequestsImpl <em>Http Requests</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.HttpRequestsImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getHttpRequests()
   * @generated
   */
  int HTTP_REQUESTS = 25;

  /**
   * The feature id for the '<em><b>Http requests</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HTTP_REQUESTS__HTTP_REQUESTS = 0;

  /**
   * The number of structural features of the '<em>Http Requests</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HTTP_REQUESTS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.ComputeImpl <em>Compute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.ComputeImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getCompute()
   * @generated
   */
  int COMPUTE = 26;

  /**
   * The feature id for the '<em><b>Compute</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTE__COMPUTE = 0;

  /**
   * The number of structural features of the '<em>Compute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.ComputationalComponentImpl <em>Computational Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.ComputationalComponentImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getComputationalComponent()
   * @generated
   */
  int COMPUTATIONAL_COMPONENT = 27;

  /**
   * The feature id for the '<em><b>Component</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTATIONAL_COMPONENT__COMPONENT = 0;

  /**
   * The feature id for the '<em><b>Architecture</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTATIONAL_COMPONENT__ARCHITECTURE = 1;

  /**
   * The feature id for the '<em><b>Cores</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTATIONAL_COMPONENT__CORES = 2;

  /**
   * The feature id for the '<em><b>Speed</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTATIONAL_COMPONENT__SPEED = 3;

  /**
   * The feature id for the '<em><b>Memory</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTATIONAL_COMPONENT__MEMORY = 4;

  /**
   * The feature id for the '<em><b>Cache</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTATIONAL_COMPONENT__CACHE = 5;

  /**
   * The number of structural features of the '<em>Computational Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTATIONAL_COMPONENT_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.ArchitectureImpl <em>Architecture</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.ArchitectureImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getArchitecture()
   * @generated
   */
  int ARCHITECTURE = 28;

  /**
   * The feature id for the '<em><b>Architecture</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARCHITECTURE__ARCHITECTURE = 0;

  /**
   * The number of structural features of the '<em>Architecture</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARCHITECTURE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.CoresImpl <em>Cores</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.CoresImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getCores()
   * @generated
   */
  int CORES = 29;

  /**
   * The feature id for the '<em><b>Cores</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORES__CORES = 0;

  /**
   * The number of structural features of the '<em>Cores</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORES_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.SpeedImpl <em>Speed</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.SpeedImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getSpeed()
   * @generated
   */
  int SPEED = 30;

  /**
   * The feature id for the '<em><b>Speed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPEED__SPEED = 0;

  /**
   * The number of structural features of the '<em>Speed</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPEED_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.MemoryImpl <em>Memory</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.MemoryImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getMemory()
   * @generated
   */
  int MEMORY = 31;

  /**
   * The feature id for the '<em><b>Memory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMORY__MEMORY = 0;

  /**
   * The number of structural features of the '<em>Memory</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMORY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.CacheImpl <em>Cache</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.CacheImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getCache()
   * @generated
   */
  int CACHE = 32;

  /**
   * The feature id for the '<em><b>Cache</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CACHE__CACHE = 0;

  /**
   * The number of structural features of the '<em>Cache</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CACHE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.NetworkResourceImpl <em>Network Resource</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.NetworkResourceImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getNetworkResource()
   * @generated
   */
  int NETWORK_RESOURCE = 33;

  /**
   * The feature id for the '<em><b>Network Resource</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NETWORK_RESOURCE__NETWORK_RESOURCE = 0;

  /**
   * The number of structural features of the '<em>Network Resource</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NETWORK_RESOURCE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.CommunicationalComponentImpl <em>Communicational Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.CommunicationalComponentImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getCommunicationalComponent()
   * @generated
   */
  int COMMUNICATIONAL_COMPONENT = 34;

  /**
   * The feature id for the '<em><b>Component</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATIONAL_COMPONENT__COMPONENT = 0;

  /**
   * The feature id for the '<em><b>Bandwidth</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATIONAL_COMPONENT__BANDWIDTH = 1;

  /**
   * The feature id for the '<em><b>Latency</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATIONAL_COMPONENT__LATENCY = 2;

  /**
   * The number of structural features of the '<em>Communicational Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATIONAL_COMPONENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.BandwidthImpl <em>Bandwidth</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.BandwidthImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getBandwidth()
   * @generated
   */
  int BANDWIDTH = 35;

  /**
   * The feature id for the '<em><b>Bandwidth</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BANDWIDTH__BANDWIDTH = 0;

  /**
   * The number of structural features of the '<em>Bandwidth</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BANDWIDTH_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.LatencyImpl <em>Latency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.LatencyImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getLatency()
   * @generated
   */
  int LATENCY = 36;

  /**
   * The feature id for the '<em><b>Latency</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATENCY__LATENCY = 0;

  /**
   * The number of structural features of the '<em>Latency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATENCY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.StorageResourceImpl <em>Storage Resource</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.StorageResourceImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getStorageResource()
   * @generated
   */
  int STORAGE_RESOURCE = 37;

  /**
   * The feature id for the '<em><b>Storage Component</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE_RESOURCE__STORAGE_COMPONENT = 0;

  /**
   * The number of structural features of the '<em>Storage Resource</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE_RESOURCE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.StorageComponentImpl <em>Storage Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.StorageComponentImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getStorageComponent()
   * @generated
   */
  int STORAGE_COMPONENT = 38;

  /**
   * The feature id for the '<em><b>Component</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE_COMPONENT__COMPONENT = 0;

  /**
   * The feature id for the '<em><b>Capacity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE_COMPONENT__CAPACITY = 1;

  /**
   * The feature id for the '<em><b>Bandwidth</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE_COMPONENT__BANDWIDTH = 2;

  /**
   * The number of structural features of the '<em>Storage Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE_COMPONENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.CapacityImpl <em>Capacity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.CapacityImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getCapacity()
   * @generated
   */
  int CAPACITY = 39;

  /**
   * The feature id for the '<em><b>Capacity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPACITY__CAPACITY = 0;

  /**
   * The number of structural features of the '<em>Capacity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPACITY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.ChannelsImpl <em>Channels</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.ChannelsImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getChannels()
   * @generated
   */
  int CHANNELS = 40;

  /**
   * The feature id for the '<em><b>Channel</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANNELS__CHANNEL = 0;

  /**
   * The number of structural features of the '<em>Channels</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANNELS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.ChannelImpl <em>Channel</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.ChannelImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getChannel()
   * @generated
   */
  int CHANNEL = 41;

  /**
   * The feature id for the '<em><b>Operation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANNEL__OPERATION = 0;

  /**
   * The number of structural features of the '<em>Channel</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANNEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.OperationImpl <em>Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.OperationImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getOperation()
   * @generated
   */
  int OPERATION = 42;

  /**
   * The feature id for the '<em><b>Operation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__OPERATION = 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__DESCRIPTION = 1;

  /**
   * The feature id for the '<em><b>Command</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__COMMAND = 2;

  /**
   * The feature id for the '<em><b>Information Returned</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__INFORMATION_RETURNED = 3;

  /**
   * The number of structural features of the '<em>Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.CommandImpl <em>Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.CommandImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getCommand()
   * @generated
   */
  int COMMAND = 43;

  /**
   * The feature id for the '<em><b>Command</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND__COMMAND = 0;

  /**
   * The number of structural features of the '<em>Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.InformationReturnedImpl <em>Information Returned</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.InformationReturnedImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getInformationReturned()
   * @generated
   */
  int INFORMATION_RETURNED = 44;

  /**
   * The feature id for the '<em><b>Information Returned</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_RETURNED__INFORMATION_RETURNED = 0;

  /**
   * The number of structural features of the '<em>Information Returned</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_RETURNED_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.cloud4soa.xtext.dsl.impl.VersionImpl <em>Version</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.cloud4soa.xtext.dsl.impl.VersionImpl
   * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getVersion()
   * @generated
   */
  int VERSION = 45;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERSION__VALUE = 0;

  /**
   * The number of structural features of the '<em>Version</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERSION_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Scope <em>Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scope</em>'.
   * @see eu.cloud4soa.xtext.dsl.Scope
   * @generated
   */
  EClass getScope();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.Scope#getUserProfile <em>User Profile</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>User Profile</em>'.
   * @see eu.cloud4soa.xtext.dsl.Scope#getUserProfile()
   * @see #getScope()
   * @generated
   */
  EReference getScope_UserProfile();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.Scope#getApplicationProfile <em>Application Profile</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Application Profile</em>'.
   * @see eu.cloud4soa.xtext.dsl.Scope#getApplicationProfile()
   * @see #getScope()
   * @generated
   */
  EReference getScope_ApplicationProfile();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.Scope#getPaasOfferingProfile <em>Paas Offering Profile</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Paas Offering Profile</em>'.
   * @see eu.cloud4soa.xtext.dsl.Scope#getPaasOfferingProfile()
   * @see #getScope()
   * @generated
   */
  EReference getScope_PaasOfferingProfile();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.UserProfile <em>User Profile</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>User Profile</em>'.
   * @see eu.cloud4soa.xtext.dsl.UserProfile
   * @generated
   */
  EClass getUserProfile();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.UserProfile#getProvider <em>Provider</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Provider</em>'.
   * @see eu.cloud4soa.xtext.dsl.UserProfile#getProvider()
   * @see #getUserProfile()
   * @generated
   */
  EReference getUserProfile_Provider();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.UserProfile#getAccountInfo <em>Account Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Account Info</em>'.
   * @see eu.cloud4soa.xtext.dsl.UserProfile#getAccountInfo()
   * @see #getUserProfile()
   * @generated
   */
  EReference getUserProfile_AccountInfo();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.UserProfile#getPersonalInfo <em>Personal Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Personal Info</em>'.
   * @see eu.cloud4soa.xtext.dsl.UserProfile#getPersonalInfo()
   * @see #getUserProfile()
   * @generated
   */
  EReference getUserProfile_PersonalInfo();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.PersonalInfos <em>Personal Infos</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Personal Infos</em>'.
   * @see eu.cloud4soa.xtext.dsl.PersonalInfos
   * @generated
   */
  EClass getPersonalInfos();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.PersonalInfos#getFirstName <em>First Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>First Name</em>'.
   * @see eu.cloud4soa.xtext.dsl.PersonalInfos#getFirstName()
   * @see #getPersonalInfos()
   * @generated
   */
  EAttribute getPersonalInfos_FirstName();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.PersonalInfos#getSurnName <em>Surn Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Surn Name</em>'.
   * @see eu.cloud4soa.xtext.dsl.PersonalInfos#getSurnName()
   * @see #getPersonalInfos()
   * @generated
   */
  EAttribute getPersonalInfos_SurnName();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.PersonalInfos#getEmail <em>Email</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Email</em>'.
   * @see eu.cloud4soa.xtext.dsl.PersonalInfos#getEmail()
   * @see #getPersonalInfos()
   * @generated
   */
  EAttribute getPersonalInfos_Email();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.PersonalInfos#getBirthDay <em>Birth Day</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Birth Day</em>'.
   * @see eu.cloud4soa.xtext.dsl.PersonalInfos#getBirthDay()
   * @see #getPersonalInfos()
   * @generated
   */
  EReference getPersonalInfos_BirthDay();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Birthday <em>Birthday</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Birthday</em>'.
   * @see eu.cloud4soa.xtext.dsl.Birthday
   * @generated
   */
  EClass getBirthday();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Birthday#getDate <em>Date</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Date</em>'.
   * @see eu.cloud4soa.xtext.dsl.Birthday#getDate()
   * @see #getBirthday()
   * @generated
   */
  EAttribute getBirthday_Date();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.AccountInfo <em>Account Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Account Info</em>'.
   * @see eu.cloud4soa.xtext.dsl.AccountInfo
   * @generated
   */
  EClass getAccountInfo();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.AccountInfo#getUsername <em>Username</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Username</em>'.
   * @see eu.cloud4soa.xtext.dsl.AccountInfo#getUsername()
   * @see #getAccountInfo()
   * @generated
   */
  EAttribute getAccountInfo_Username();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.AccountInfo#getPassword <em>Password</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Password</em>'.
   * @see eu.cloud4soa.xtext.dsl.AccountInfo#getPassword()
   * @see #getAccountInfo()
   * @generated
   */
  EAttribute getAccountInfo_Password();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Provider <em>Provider</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Provider</em>'.
   * @see eu.cloud4soa.xtext.dsl.Provider
   * @generated
   */
  EClass getProvider();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Provider#getProvider <em>Provider</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Provider</em>'.
   * @see eu.cloud4soa.xtext.dsl.Provider#getProvider()
   * @see #getProvider()
   * @generated
   */
  EAttribute getProvider_Provider();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Provider#getHomepage <em>Homepage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Homepage</em>'.
   * @see eu.cloud4soa.xtext.dsl.Provider#getHomepage()
   * @see #getProvider()
   * @generated
   */
  EAttribute getProvider_Homepage();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.ApplicationProfile <em>Application Profile</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Application Profile</em>'.
   * @see eu.cloud4soa.xtext.dsl.ApplicationProfile
   * @generated
   */
  EClass getApplicationProfile();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.ApplicationProfile#getInfos <em>Infos</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Infos</em>'.
   * @see eu.cloud4soa.xtext.dsl.ApplicationProfile#getInfos()
   * @see #getApplicationProfile()
   * @generated
   */
  EReference getApplicationProfile_Infos();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.ApplicationProfile#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>File</em>'.
   * @see eu.cloud4soa.xtext.dsl.ApplicationProfile#getFile()
   * @see #getApplicationProfile()
   * @generated
   */
  EReference getApplicationProfile_File();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.ApplicationProfile#getTechnology <em>Technology</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Technology</em>'.
   * @see eu.cloud4soa.xtext.dsl.ApplicationProfile#getTechnology()
   * @see #getApplicationProfile()
   * @generated
   */
  EReference getApplicationProfile_Technology();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.ApplicationInfos <em>Application Infos</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Application Infos</em>'.
   * @see eu.cloud4soa.xtext.dsl.ApplicationInfos
   * @generated
   */
  EClass getApplicationInfos();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.ApplicationInfos#getApplication <em>Application</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Application</em>'.
   * @see eu.cloud4soa.xtext.dsl.ApplicationInfos#getApplication()
   * @see #getApplicationInfos()
   * @generated
   */
  EAttribute getApplicationInfos_Application();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.ApplicationInfos#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Version</em>'.
   * @see eu.cloud4soa.xtext.dsl.ApplicationInfos#getVersion()
   * @see #getApplicationInfos()
   * @generated
   */
  EReference getApplicationInfos_Version();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.ApplicationInfos#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Code</em>'.
   * @see eu.cloud4soa.xtext.dsl.ApplicationInfos#getCode()
   * @see #getApplicationInfos()
   * @generated
   */
  EReference getApplicationInfos_Code();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.ApplicationCode <em>Application Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Application Code</em>'.
   * @see eu.cloud4soa.xtext.dsl.ApplicationCode
   * @generated
   */
  EClass getApplicationCode();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.ApplicationCode#getApplicationCode <em>Application Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Application Code</em>'.
   * @see eu.cloud4soa.xtext.dsl.ApplicationCode#getApplicationCode()
   * @see #getApplicationCode()
   * @generated
   */
  EAttribute getApplicationCode_ApplicationCode();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.PaasOfferingProfile <em>Paas Offering Profile</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Paas Offering Profile</em>'.
   * @see eu.cloud4soa.xtext.dsl.PaasOfferingProfile
   * @generated
   */
  EClass getPaasOfferingProfile();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.PaasOfferingProfile#getPaasOfferingInfos <em>Paas Offering Infos</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Paas Offering Infos</em>'.
   * @see eu.cloud4soa.xtext.dsl.PaasOfferingProfile#getPaasOfferingInfos()
   * @see #getPaasOfferingProfile()
   * @generated
   */
  EReference getPaasOfferingProfile_PaasOfferingInfos();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.PaasOfferingProfile#getChannels <em>Channels</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Channels</em>'.
   * @see eu.cloud4soa.xtext.dsl.PaasOfferingProfile#getChannels()
   * @see #getPaasOfferingProfile()
   * @generated
   */
  EReference getPaasOfferingProfile_Channels();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.PaasOfferingProfile#getTechnology <em>Technology</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Technology</em>'.
   * @see eu.cloud4soa.xtext.dsl.PaasOfferingProfile#getTechnology()
   * @see #getPaasOfferingProfile()
   * @generated
   */
  EReference getPaasOfferingProfile_Technology();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.PaasOfferingInfos <em>Paas Offering Infos</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Paas Offering Infos</em>'.
   * @see eu.cloud4soa.xtext.dsl.PaasOfferingInfos
   * @generated
   */
  EClass getPaasOfferingInfos();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.PaasOfferingInfos#getPaasOffering <em>Paas Offering</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Paas Offering</em>'.
   * @see eu.cloud4soa.xtext.dsl.PaasOfferingInfos#getPaasOffering()
   * @see #getPaasOfferingInfos()
   * @generated
   */
  EAttribute getPaasOfferingInfos_PaasOffering();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.File <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>File</em>'.
   * @see eu.cloud4soa.xtext.dsl.File
   * @generated
   */
  EClass getFile();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.File#getFileName <em>File Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File Name</em>'.
   * @see eu.cloud4soa.xtext.dsl.File#getFileName()
   * @see #getFile()
   * @generated
   */
  EAttribute getFile_FileName();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.File#getDimension <em>Dimension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dimension</em>'.
   * @see eu.cloud4soa.xtext.dsl.File#getDimension()
   * @see #getFile()
   * @generated
   */
  EReference getFile_Dimension();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.FileDimension <em>File Dimension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>File Dimension</em>'.
   * @see eu.cloud4soa.xtext.dsl.FileDimension
   * @generated
   */
  EClass getFileDimension();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.FileDimension#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Size</em>'.
   * @see eu.cloud4soa.xtext.dsl.FileDimension#getSize()
   * @see #getFileDimension()
   * @generated
   */
  EAttribute getFileDimension_Size();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.FileDimension#getDigest <em>Digest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Digest</em>'.
   * @see eu.cloud4soa.xtext.dsl.FileDimension#getDigest()
   * @see #getFileDimension()
   * @generated
   */
  EReference getFileDimension_Digest();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Digest <em>Digest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Digest</em>'.
   * @see eu.cloud4soa.xtext.dsl.Digest
   * @generated
   */
  EClass getDigest();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Digest#getDigest <em>Digest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Digest</em>'.
   * @see eu.cloud4soa.xtext.dsl.Digest#getDigest()
   * @see #getDigest()
   * @generated
   */
  EAttribute getDigest_Digest();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.TechnologyInfo <em>Technology Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Technology Info</em>'.
   * @see eu.cloud4soa.xtext.dsl.TechnologyInfo
   * @generated
   */
  EClass getTechnologyInfo();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.TechnologyInfo#getProgrammingLanguage <em>Programming Language</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Programming Language</em>'.
   * @see eu.cloud4soa.xtext.dsl.TechnologyInfo#getProgrammingLanguage()
   * @see #getTechnologyInfo()
   * @generated
   */
  EReference getTechnologyInfo_ProgrammingLanguage();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.TechnologyInfo#getSoftware <em>Software</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Software</em>'.
   * @see eu.cloud4soa.xtext.dsl.TechnologyInfo#getSoftware()
   * @see #getTechnologyInfo()
   * @generated
   */
  EReference getTechnologyInfo_Software();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.TechnologyInfo#getHardware <em>Hardware</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Hardware</em>'.
   * @see eu.cloud4soa.xtext.dsl.TechnologyInfo#getHardware()
   * @see #getTechnologyInfo()
   * @generated
   */
  EReference getTechnologyInfo_Hardware();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.ProgrammingLanguage <em>Programming Language</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Programming Language</em>'.
   * @see eu.cloud4soa.xtext.dsl.ProgrammingLanguage
   * @generated
   */
  EClass getProgrammingLanguage();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.ProgrammingLanguage#getProgrammingLanguage <em>Programming Language</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Programming Language</em>'.
   * @see eu.cloud4soa.xtext.dsl.ProgrammingLanguage#getProgrammingLanguage()
   * @see #getProgrammingLanguage()
   * @generated
   */
  EAttribute getProgrammingLanguage_ProgrammingLanguage();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.ProgrammingLanguage#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Version</em>'.
   * @see eu.cloud4soa.xtext.dsl.ProgrammingLanguage#getVersion()
   * @see #getProgrammingLanguage()
   * @generated
   */
  EReference getProgrammingLanguage_Version();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Software <em>Software</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Software</em>'.
   * @see eu.cloud4soa.xtext.dsl.Software
   * @generated
   */
  EClass getSoftware();

  /**
   * Returns the meta object for the containment reference list '{@link eu.cloud4soa.xtext.dsl.Software#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Category</em>'.
   * @see eu.cloud4soa.xtext.dsl.Software#getCategory()
   * @see #getSoftware()
   * @generated
   */
  EReference getSoftware_Category();

  /**
   * Returns the meta object for the containment reference list '{@link eu.cloud4soa.xtext.dsl.Software#getComponent <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Component</em>'.
   * @see eu.cloud4soa.xtext.dsl.Software#getComponent()
   * @see #getSoftware()
   * @generated
   */
  EReference getSoftware_Component();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.SoftwareCategory <em>Software Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Software Category</em>'.
   * @see eu.cloud4soa.xtext.dsl.SoftwareCategory
   * @generated
   */
  EClass getSoftwareCategory();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.SoftwareCategory#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Category</em>'.
   * @see eu.cloud4soa.xtext.dsl.SoftwareCategory#getCategory()
   * @see #getSoftwareCategory()
   * @generated
   */
  EAttribute getSoftwareCategory_Category();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.SoftwareCategory#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see eu.cloud4soa.xtext.dsl.SoftwareCategory#getDescription()
   * @see #getSoftwareCategory()
   * @generated
   */
  EReference getSoftwareCategory_Description();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.SoftwareComponent <em>Software Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Software Component</em>'.
   * @see eu.cloud4soa.xtext.dsl.SoftwareComponent
   * @generated
   */
  EClass getSoftwareComponent();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.SoftwareComponent#getComponent <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Component</em>'.
   * @see eu.cloud4soa.xtext.dsl.SoftwareComponent#getComponent()
   * @see #getSoftwareComponent()
   * @generated
   */
  EReference getSoftwareComponent_Component();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.SoftwareComponent#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Version</em>'.
   * @see eu.cloud4soa.xtext.dsl.SoftwareComponent#getVersion()
   * @see #getSoftwareComponent()
   * @generated
   */
  EReference getSoftwareComponent_Version();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.SoftwareComponent#getLicense <em>License</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>License</em>'.
   * @see eu.cloud4soa.xtext.dsl.SoftwareComponent#getLicense()
   * @see #getSoftwareComponent()
   * @generated
   */
  EReference getSoftwareComponent_License();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Component <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component</em>'.
   * @see eu.cloud4soa.xtext.dsl.Component
   * @generated
   */
  EClass getComponent();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Component#getComponent <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Component</em>'.
   * @see eu.cloud4soa.xtext.dsl.Component#getComponent()
   * @see #getComponent()
   * @generated
   */
  EAttribute getComponent_Component();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.Component#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see eu.cloud4soa.xtext.dsl.Component#getDescription()
   * @see #getComponent()
   * @generated
   */
  EReference getComponent_Description();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Description <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Description</em>'.
   * @see eu.cloud4soa.xtext.dsl.Description
   * @generated
   */
  EClass getDescription();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Description#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see eu.cloud4soa.xtext.dsl.Description#getDescription()
   * @see #getDescription()
   * @generated
   */
  EAttribute getDescription_Description();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.License <em>License</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>License</em>'.
   * @see eu.cloud4soa.xtext.dsl.License
   * @generated
   */
  EClass getLicense();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.License#getLicense <em>License</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>License</em>'.
   * @see eu.cloud4soa.xtext.dsl.License#getLicense()
   * @see #getLicense()
   * @generated
   */
  EAttribute getLicense_License();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Hardware <em>Hardware</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Hardware</em>'.
   * @see eu.cloud4soa.xtext.dsl.Hardware
   * @generated
   */
  EClass getHardware();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.Hardware#getBox <em>Box</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Box</em>'.
   * @see eu.cloud4soa.xtext.dsl.Hardware#getBox()
   * @see #getHardware()
   * @generated
   */
  EReference getHardware_Box();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.Hardware#getCompute <em>Compute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Compute</em>'.
   * @see eu.cloud4soa.xtext.dsl.Hardware#getCompute()
   * @see #getHardware()
   * @generated
   */
  EReference getHardware_Compute();

  /**
   * Returns the meta object for the containment reference list '{@link eu.cloud4soa.xtext.dsl.Hardware#getNetworkResource <em>Network Resource</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Network Resource</em>'.
   * @see eu.cloud4soa.xtext.dsl.Hardware#getNetworkResource()
   * @see #getHardware()
   * @generated
   */
  EReference getHardware_NetworkResource();

  /**
   * Returns the meta object for the containment reference list '{@link eu.cloud4soa.xtext.dsl.Hardware#getStorageResource <em>Storage Resource</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Storage Resource</em>'.
   * @see eu.cloud4soa.xtext.dsl.Hardware#getStorageResource()
   * @see #getHardware()
   * @generated
   */
  EReference getHardware_StorageResource();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Box <em>Box</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Box</em>'.
   * @see eu.cloud4soa.xtext.dsl.Box
   * @generated
   */
  EClass getBox();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.Box#getBox <em>Box</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Box</em>'.
   * @see eu.cloud4soa.xtext.dsl.Box#getBox()
   * @see #getBox()
   * @generated
   */
  EReference getBox_Box();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.BoxComponent <em>Box Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Box Component</em>'.
   * @see eu.cloud4soa.xtext.dsl.BoxComponent
   * @generated
   */
  EClass getBoxComponent();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.BoxComponent#getComponent <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Component</em>'.
   * @see eu.cloud4soa.xtext.dsl.BoxComponent#getComponent()
   * @see #getBoxComponent()
   * @generated
   */
  EReference getBoxComponent_Component();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.BoxComponent#getHttpRequest <em>Http Request</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Http Request</em>'.
   * @see eu.cloud4soa.xtext.dsl.BoxComponent#getHttpRequest()
   * @see #getBoxComponent()
   * @generated
   */
  EReference getBoxComponent_HttpRequest();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.HttpRequests <em>Http Requests</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Http Requests</em>'.
   * @see eu.cloud4soa.xtext.dsl.HttpRequests
   * @generated
   */
  EClass getHttpRequests();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.HttpRequests#getHttp_requests <em>Http requests</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Http requests</em>'.
   * @see eu.cloud4soa.xtext.dsl.HttpRequests#getHttp_requests()
   * @see #getHttpRequests()
   * @generated
   */
  EAttribute getHttpRequests_Http_requests();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Compute <em>Compute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Compute</em>'.
   * @see eu.cloud4soa.xtext.dsl.Compute
   * @generated
   */
  EClass getCompute();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.Compute#getCompute <em>Compute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Compute</em>'.
   * @see eu.cloud4soa.xtext.dsl.Compute#getCompute()
   * @see #getCompute()
   * @generated
   */
  EReference getCompute_Compute();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.ComputationalComponent <em>Computational Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Computational Component</em>'.
   * @see eu.cloud4soa.xtext.dsl.ComputationalComponent
   * @generated
   */
  EClass getComputationalComponent();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getComponent <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Component</em>'.
   * @see eu.cloud4soa.xtext.dsl.ComputationalComponent#getComponent()
   * @see #getComputationalComponent()
   * @generated
   */
  EReference getComputationalComponent_Component();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getArchitecture <em>Architecture</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Architecture</em>'.
   * @see eu.cloud4soa.xtext.dsl.ComputationalComponent#getArchitecture()
   * @see #getComputationalComponent()
   * @generated
   */
  EReference getComputationalComponent_Architecture();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getCores <em>Cores</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cores</em>'.
   * @see eu.cloud4soa.xtext.dsl.ComputationalComponent#getCores()
   * @see #getComputationalComponent()
   * @generated
   */
  EReference getComputationalComponent_Cores();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getSpeed <em>Speed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Speed</em>'.
   * @see eu.cloud4soa.xtext.dsl.ComputationalComponent#getSpeed()
   * @see #getComputationalComponent()
   * @generated
   */
  EReference getComputationalComponent_Speed();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getMemory <em>Memory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Memory</em>'.
   * @see eu.cloud4soa.xtext.dsl.ComputationalComponent#getMemory()
   * @see #getComputationalComponent()
   * @generated
   */
  EReference getComputationalComponent_Memory();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getCache <em>Cache</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cache</em>'.
   * @see eu.cloud4soa.xtext.dsl.ComputationalComponent#getCache()
   * @see #getComputationalComponent()
   * @generated
   */
  EReference getComputationalComponent_Cache();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Architecture <em>Architecture</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Architecture</em>'.
   * @see eu.cloud4soa.xtext.dsl.Architecture
   * @generated
   */
  EClass getArchitecture();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Architecture#getArchitecture <em>Architecture</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Architecture</em>'.
   * @see eu.cloud4soa.xtext.dsl.Architecture#getArchitecture()
   * @see #getArchitecture()
   * @generated
   */
  EAttribute getArchitecture_Architecture();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Cores <em>Cores</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cores</em>'.
   * @see eu.cloud4soa.xtext.dsl.Cores
   * @generated
   */
  EClass getCores();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Cores#getCores <em>Cores</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cores</em>'.
   * @see eu.cloud4soa.xtext.dsl.Cores#getCores()
   * @see #getCores()
   * @generated
   */
  EAttribute getCores_Cores();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Speed <em>Speed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Speed</em>'.
   * @see eu.cloud4soa.xtext.dsl.Speed
   * @generated
   */
  EClass getSpeed();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Speed#getSpeed <em>Speed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Speed</em>'.
   * @see eu.cloud4soa.xtext.dsl.Speed#getSpeed()
   * @see #getSpeed()
   * @generated
   */
  EAttribute getSpeed_Speed();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Memory <em>Memory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Memory</em>'.
   * @see eu.cloud4soa.xtext.dsl.Memory
   * @generated
   */
  EClass getMemory();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Memory#getMemory <em>Memory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Memory</em>'.
   * @see eu.cloud4soa.xtext.dsl.Memory#getMemory()
   * @see #getMemory()
   * @generated
   */
  EAttribute getMemory_Memory();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Cache <em>Cache</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cache</em>'.
   * @see eu.cloud4soa.xtext.dsl.Cache
   * @generated
   */
  EClass getCache();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Cache#getCache <em>Cache</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cache</em>'.
   * @see eu.cloud4soa.xtext.dsl.Cache#getCache()
   * @see #getCache()
   * @generated
   */
  EAttribute getCache_Cache();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.NetworkResource <em>Network Resource</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Network Resource</em>'.
   * @see eu.cloud4soa.xtext.dsl.NetworkResource
   * @generated
   */
  EClass getNetworkResource();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.NetworkResource#getNetworkResource <em>Network Resource</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Network Resource</em>'.
   * @see eu.cloud4soa.xtext.dsl.NetworkResource#getNetworkResource()
   * @see #getNetworkResource()
   * @generated
   */
  EReference getNetworkResource_NetworkResource();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.CommunicationalComponent <em>Communicational Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Communicational Component</em>'.
   * @see eu.cloud4soa.xtext.dsl.CommunicationalComponent
   * @generated
   */
  EClass getCommunicationalComponent();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.CommunicationalComponent#getComponent <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Component</em>'.
   * @see eu.cloud4soa.xtext.dsl.CommunicationalComponent#getComponent()
   * @see #getCommunicationalComponent()
   * @generated
   */
  EReference getCommunicationalComponent_Component();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.CommunicationalComponent#getBandwidth <em>Bandwidth</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Bandwidth</em>'.
   * @see eu.cloud4soa.xtext.dsl.CommunicationalComponent#getBandwidth()
   * @see #getCommunicationalComponent()
   * @generated
   */
  EReference getCommunicationalComponent_Bandwidth();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.CommunicationalComponent#getLatency <em>Latency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Latency</em>'.
   * @see eu.cloud4soa.xtext.dsl.CommunicationalComponent#getLatency()
   * @see #getCommunicationalComponent()
   * @generated
   */
  EReference getCommunicationalComponent_Latency();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Bandwidth <em>Bandwidth</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bandwidth</em>'.
   * @see eu.cloud4soa.xtext.dsl.Bandwidth
   * @generated
   */
  EClass getBandwidth();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Bandwidth#getBandwidth <em>Bandwidth</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bandwidth</em>'.
   * @see eu.cloud4soa.xtext.dsl.Bandwidth#getBandwidth()
   * @see #getBandwidth()
   * @generated
   */
  EAttribute getBandwidth_Bandwidth();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Latency <em>Latency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Latency</em>'.
   * @see eu.cloud4soa.xtext.dsl.Latency
   * @generated
   */
  EClass getLatency();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Latency#getLatency <em>Latency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Latency</em>'.
   * @see eu.cloud4soa.xtext.dsl.Latency#getLatency()
   * @see #getLatency()
   * @generated
   */
  EAttribute getLatency_Latency();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.StorageResource <em>Storage Resource</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Storage Resource</em>'.
   * @see eu.cloud4soa.xtext.dsl.StorageResource
   * @generated
   */
  EClass getStorageResource();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.StorageResource#getStorageComponent <em>Storage Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Storage Component</em>'.
   * @see eu.cloud4soa.xtext.dsl.StorageResource#getStorageComponent()
   * @see #getStorageResource()
   * @generated
   */
  EReference getStorageResource_StorageComponent();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.StorageComponent <em>Storage Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Storage Component</em>'.
   * @see eu.cloud4soa.xtext.dsl.StorageComponent
   * @generated
   */
  EClass getStorageComponent();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.StorageComponent#getComponent <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Component</em>'.
   * @see eu.cloud4soa.xtext.dsl.StorageComponent#getComponent()
   * @see #getStorageComponent()
   * @generated
   */
  EReference getStorageComponent_Component();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.StorageComponent#getCapacity <em>Capacity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Capacity</em>'.
   * @see eu.cloud4soa.xtext.dsl.StorageComponent#getCapacity()
   * @see #getStorageComponent()
   * @generated
   */
  EReference getStorageComponent_Capacity();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.StorageComponent#getBandwidth <em>Bandwidth</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Bandwidth</em>'.
   * @see eu.cloud4soa.xtext.dsl.StorageComponent#getBandwidth()
   * @see #getStorageComponent()
   * @generated
   */
  EReference getStorageComponent_Bandwidth();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Capacity <em>Capacity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Capacity</em>'.
   * @see eu.cloud4soa.xtext.dsl.Capacity
   * @generated
   */
  EClass getCapacity();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Capacity#getCapacity <em>Capacity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Capacity</em>'.
   * @see eu.cloud4soa.xtext.dsl.Capacity#getCapacity()
   * @see #getCapacity()
   * @generated
   */
  EAttribute getCapacity_Capacity();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Channels <em>Channels</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Channels</em>'.
   * @see eu.cloud4soa.xtext.dsl.Channels
   * @generated
   */
  EClass getChannels();

  /**
   * Returns the meta object for the containment reference list '{@link eu.cloud4soa.xtext.dsl.Channels#getChannel <em>Channel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Channel</em>'.
   * @see eu.cloud4soa.xtext.dsl.Channels#getChannel()
   * @see #getChannels()
   * @generated
   */
  EReference getChannels_Channel();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Channel <em>Channel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Channel</em>'.
   * @see eu.cloud4soa.xtext.dsl.Channel
   * @generated
   */
  EClass getChannel();

  /**
   * Returns the meta object for the containment reference list '{@link eu.cloud4soa.xtext.dsl.Channel#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operation</em>'.
   * @see eu.cloud4soa.xtext.dsl.Channel#getOperation()
   * @see #getChannel()
   * @generated
   */
  EReference getChannel_Operation();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation</em>'.
   * @see eu.cloud4soa.xtext.dsl.Operation
   * @generated
   */
  EClass getOperation();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Operation#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operation</em>'.
   * @see eu.cloud4soa.xtext.dsl.Operation#getOperation()
   * @see #getOperation()
   * @generated
   */
  EAttribute getOperation_Operation();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.Operation#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see eu.cloud4soa.xtext.dsl.Operation#getDescription()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_Description();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.Operation#getCommand <em>Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Command</em>'.
   * @see eu.cloud4soa.xtext.dsl.Operation#getCommand()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_Command();

  /**
   * Returns the meta object for the containment reference '{@link eu.cloud4soa.xtext.dsl.Operation#getInformationReturned <em>Information Returned</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Information Returned</em>'.
   * @see eu.cloud4soa.xtext.dsl.Operation#getInformationReturned()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_InformationReturned();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Command <em>Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Command</em>'.
   * @see eu.cloud4soa.xtext.dsl.Command
   * @generated
   */
  EClass getCommand();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Command#getCommand <em>Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Command</em>'.
   * @see eu.cloud4soa.xtext.dsl.Command#getCommand()
   * @see #getCommand()
   * @generated
   */
  EAttribute getCommand_Command();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.InformationReturned <em>Information Returned</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Information Returned</em>'.
   * @see eu.cloud4soa.xtext.dsl.InformationReturned
   * @generated
   */
  EClass getInformationReturned();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.InformationReturned#getInformationReturned <em>Information Returned</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Information Returned</em>'.
   * @see eu.cloud4soa.xtext.dsl.InformationReturned#getInformationReturned()
   * @see #getInformationReturned()
   * @generated
   */
  EAttribute getInformationReturned_InformationReturned();

  /**
   * Returns the meta object for class '{@link eu.cloud4soa.xtext.dsl.Version <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Version</em>'.
   * @see eu.cloud4soa.xtext.dsl.Version
   * @generated
   */
  EClass getVersion();

  /**
   * Returns the meta object for the attribute '{@link eu.cloud4soa.xtext.dsl.Version#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see eu.cloud4soa.xtext.dsl.Version#getValue()
   * @see #getVersion()
   * @generated
   */
  EAttribute getVersion_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DslFactory getDslFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.ScopeImpl <em>Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.ScopeImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getScope()
     * @generated
     */
    EClass SCOPE = eINSTANCE.getScope();

    /**
     * The meta object literal for the '<em><b>User Profile</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCOPE__USER_PROFILE = eINSTANCE.getScope_UserProfile();

    /**
     * The meta object literal for the '<em><b>Application Profile</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCOPE__APPLICATION_PROFILE = eINSTANCE.getScope_ApplicationProfile();

    /**
     * The meta object literal for the '<em><b>Paas Offering Profile</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCOPE__PAAS_OFFERING_PROFILE = eINSTANCE.getScope_PaasOfferingProfile();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.UserProfileImpl <em>User Profile</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.UserProfileImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getUserProfile()
     * @generated
     */
    EClass USER_PROFILE = eINSTANCE.getUserProfile();

    /**
     * The meta object literal for the '<em><b>Provider</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference USER_PROFILE__PROVIDER = eINSTANCE.getUserProfile_Provider();

    /**
     * The meta object literal for the '<em><b>Account Info</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference USER_PROFILE__ACCOUNT_INFO = eINSTANCE.getUserProfile_AccountInfo();

    /**
     * The meta object literal for the '<em><b>Personal Info</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference USER_PROFILE__PERSONAL_INFO = eINSTANCE.getUserProfile_PersonalInfo();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.PersonalInfosImpl <em>Personal Infos</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.PersonalInfosImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getPersonalInfos()
     * @generated
     */
    EClass PERSONAL_INFOS = eINSTANCE.getPersonalInfos();

    /**
     * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PERSONAL_INFOS__FIRST_NAME = eINSTANCE.getPersonalInfos_FirstName();

    /**
     * The meta object literal for the '<em><b>Surn Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PERSONAL_INFOS__SURN_NAME = eINSTANCE.getPersonalInfos_SurnName();

    /**
     * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PERSONAL_INFOS__EMAIL = eINSTANCE.getPersonalInfos_Email();

    /**
     * The meta object literal for the '<em><b>Birth Day</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PERSONAL_INFOS__BIRTH_DAY = eINSTANCE.getPersonalInfos_BirthDay();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.BirthdayImpl <em>Birthday</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.BirthdayImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getBirthday()
     * @generated
     */
    EClass BIRTHDAY = eINSTANCE.getBirthday();

    /**
     * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BIRTHDAY__DATE = eINSTANCE.getBirthday_Date();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.AccountInfoImpl <em>Account Info</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.AccountInfoImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getAccountInfo()
     * @generated
     */
    EClass ACCOUNT_INFO = eINSTANCE.getAccountInfo();

    /**
     * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACCOUNT_INFO__USERNAME = eINSTANCE.getAccountInfo_Username();

    /**
     * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACCOUNT_INFO__PASSWORD = eINSTANCE.getAccountInfo_Password();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.ProviderImpl <em>Provider</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.ProviderImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getProvider()
     * @generated
     */
    EClass PROVIDER = eINSTANCE.getProvider();

    /**
     * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROVIDER__PROVIDER = eINSTANCE.getProvider_Provider();

    /**
     * The meta object literal for the '<em><b>Homepage</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROVIDER__HOMEPAGE = eINSTANCE.getProvider_Homepage();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.ApplicationProfileImpl <em>Application Profile</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.ApplicationProfileImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getApplicationProfile()
     * @generated
     */
    EClass APPLICATION_PROFILE = eINSTANCE.getApplicationProfile();

    /**
     * The meta object literal for the '<em><b>Infos</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APPLICATION_PROFILE__INFOS = eINSTANCE.getApplicationProfile_Infos();

    /**
     * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APPLICATION_PROFILE__FILE = eINSTANCE.getApplicationProfile_File();

    /**
     * The meta object literal for the '<em><b>Technology</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APPLICATION_PROFILE__TECHNOLOGY = eINSTANCE.getApplicationProfile_Technology();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.ApplicationInfosImpl <em>Application Infos</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.ApplicationInfosImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getApplicationInfos()
     * @generated
     */
    EClass APPLICATION_INFOS = eINSTANCE.getApplicationInfos();

    /**
     * The meta object literal for the '<em><b>Application</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute APPLICATION_INFOS__APPLICATION = eINSTANCE.getApplicationInfos_Application();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APPLICATION_INFOS__VERSION = eINSTANCE.getApplicationInfos_Version();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APPLICATION_INFOS__CODE = eINSTANCE.getApplicationInfos_Code();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.ApplicationCodeImpl <em>Application Code</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.ApplicationCodeImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getApplicationCode()
     * @generated
     */
    EClass APPLICATION_CODE = eINSTANCE.getApplicationCode();

    /**
     * The meta object literal for the '<em><b>Application Code</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute APPLICATION_CODE__APPLICATION_CODE = eINSTANCE.getApplicationCode_ApplicationCode();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.PaasOfferingProfileImpl <em>Paas Offering Profile</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.PaasOfferingProfileImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getPaasOfferingProfile()
     * @generated
     */
    EClass PAAS_OFFERING_PROFILE = eINSTANCE.getPaasOfferingProfile();

    /**
     * The meta object literal for the '<em><b>Paas Offering Infos</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PAAS_OFFERING_PROFILE__PAAS_OFFERING_INFOS = eINSTANCE.getPaasOfferingProfile_PaasOfferingInfos();

    /**
     * The meta object literal for the '<em><b>Channels</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PAAS_OFFERING_PROFILE__CHANNELS = eINSTANCE.getPaasOfferingProfile_Channels();

    /**
     * The meta object literal for the '<em><b>Technology</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PAAS_OFFERING_PROFILE__TECHNOLOGY = eINSTANCE.getPaasOfferingProfile_Technology();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.PaasOfferingInfosImpl <em>Paas Offering Infos</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.PaasOfferingInfosImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getPaasOfferingInfos()
     * @generated
     */
    EClass PAAS_OFFERING_INFOS = eINSTANCE.getPaasOfferingInfos();

    /**
     * The meta object literal for the '<em><b>Paas Offering</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PAAS_OFFERING_INFOS__PAAS_OFFERING = eINSTANCE.getPaasOfferingInfos_PaasOffering();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.FileImpl <em>File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.FileImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getFile()
     * @generated
     */
    EClass FILE = eINSTANCE.getFile();

    /**
     * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FILE__FILE_NAME = eINSTANCE.getFile_FileName();

    /**
     * The meta object literal for the '<em><b>Dimension</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FILE__DIMENSION = eINSTANCE.getFile_Dimension();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.FileDimensionImpl <em>File Dimension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.FileDimensionImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getFileDimension()
     * @generated
     */
    EClass FILE_DIMENSION = eINSTANCE.getFileDimension();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FILE_DIMENSION__SIZE = eINSTANCE.getFileDimension_Size();

    /**
     * The meta object literal for the '<em><b>Digest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FILE_DIMENSION__DIGEST = eINSTANCE.getFileDimension_Digest();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.DigestImpl <em>Digest</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.DigestImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getDigest()
     * @generated
     */
    EClass DIGEST = eINSTANCE.getDigest();

    /**
     * The meta object literal for the '<em><b>Digest</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DIGEST__DIGEST = eINSTANCE.getDigest_Digest();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.TechnologyInfoImpl <em>Technology Info</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.TechnologyInfoImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getTechnologyInfo()
     * @generated
     */
    EClass TECHNOLOGY_INFO = eINSTANCE.getTechnologyInfo();

    /**
     * The meta object literal for the '<em><b>Programming Language</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TECHNOLOGY_INFO__PROGRAMMING_LANGUAGE = eINSTANCE.getTechnologyInfo_ProgrammingLanguage();

    /**
     * The meta object literal for the '<em><b>Software</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TECHNOLOGY_INFO__SOFTWARE = eINSTANCE.getTechnologyInfo_Software();

    /**
     * The meta object literal for the '<em><b>Hardware</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TECHNOLOGY_INFO__HARDWARE = eINSTANCE.getTechnologyInfo_Hardware();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.ProgrammingLanguageImpl <em>Programming Language</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.ProgrammingLanguageImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getProgrammingLanguage()
     * @generated
     */
    EClass PROGRAMMING_LANGUAGE = eINSTANCE.getProgrammingLanguage();

    /**
     * The meta object literal for the '<em><b>Programming Language</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROGRAMMING_LANGUAGE__PROGRAMMING_LANGUAGE = eINSTANCE.getProgrammingLanguage_ProgrammingLanguage();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROGRAMMING_LANGUAGE__VERSION = eINSTANCE.getProgrammingLanguage_Version();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.SoftwareImpl <em>Software</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.SoftwareImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getSoftware()
     * @generated
     */
    EClass SOFTWARE = eINSTANCE.getSoftware();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOFTWARE__CATEGORY = eINSTANCE.getSoftware_Category();

    /**
     * The meta object literal for the '<em><b>Component</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOFTWARE__COMPONENT = eINSTANCE.getSoftware_Component();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.SoftwareCategoryImpl <em>Software Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.SoftwareCategoryImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getSoftwareCategory()
     * @generated
     */
    EClass SOFTWARE_CATEGORY = eINSTANCE.getSoftwareCategory();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOFTWARE_CATEGORY__CATEGORY = eINSTANCE.getSoftwareCategory_Category();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOFTWARE_CATEGORY__DESCRIPTION = eINSTANCE.getSoftwareCategory_Description();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.SoftwareComponentImpl <em>Software Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.SoftwareComponentImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getSoftwareComponent()
     * @generated
     */
    EClass SOFTWARE_COMPONENT = eINSTANCE.getSoftwareComponent();

    /**
     * The meta object literal for the '<em><b>Component</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOFTWARE_COMPONENT__COMPONENT = eINSTANCE.getSoftwareComponent_Component();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOFTWARE_COMPONENT__VERSION = eINSTANCE.getSoftwareComponent_Version();

    /**
     * The meta object literal for the '<em><b>License</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOFTWARE_COMPONENT__LICENSE = eINSTANCE.getSoftwareComponent_License();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.ComponentImpl <em>Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.ComponentImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getComponent()
     * @generated
     */
    EClass COMPONENT = eINSTANCE.getComponent();

    /**
     * The meta object literal for the '<em><b>Component</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPONENT__COMPONENT = eINSTANCE.getComponent_Component();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT__DESCRIPTION = eINSTANCE.getComponent_Description();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.DescriptionImpl <em>Description</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.DescriptionImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getDescription()
     * @generated
     */
    EClass DESCRIPTION = eINSTANCE.getDescription();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DESCRIPTION__DESCRIPTION = eINSTANCE.getDescription_Description();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.LicenseImpl <em>License</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.LicenseImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getLicense()
     * @generated
     */
    EClass LICENSE = eINSTANCE.getLicense();

    /**
     * The meta object literal for the '<em><b>License</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LICENSE__LICENSE = eINSTANCE.getLicense_License();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.HardwareImpl <em>Hardware</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.HardwareImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getHardware()
     * @generated
     */
    EClass HARDWARE = eINSTANCE.getHardware();

    /**
     * The meta object literal for the '<em><b>Box</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HARDWARE__BOX = eINSTANCE.getHardware_Box();

    /**
     * The meta object literal for the '<em><b>Compute</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HARDWARE__COMPUTE = eINSTANCE.getHardware_Compute();

    /**
     * The meta object literal for the '<em><b>Network Resource</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HARDWARE__NETWORK_RESOURCE = eINSTANCE.getHardware_NetworkResource();

    /**
     * The meta object literal for the '<em><b>Storage Resource</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HARDWARE__STORAGE_RESOURCE = eINSTANCE.getHardware_StorageResource();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.BoxImpl <em>Box</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.BoxImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getBox()
     * @generated
     */
    EClass BOX = eINSTANCE.getBox();

    /**
     * The meta object literal for the '<em><b>Box</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOX__BOX = eINSTANCE.getBox_Box();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.BoxComponentImpl <em>Box Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.BoxComponentImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getBoxComponent()
     * @generated
     */
    EClass BOX_COMPONENT = eINSTANCE.getBoxComponent();

    /**
     * The meta object literal for the '<em><b>Component</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOX_COMPONENT__COMPONENT = eINSTANCE.getBoxComponent_Component();

    /**
     * The meta object literal for the '<em><b>Http Request</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOX_COMPONENT__HTTP_REQUEST = eINSTANCE.getBoxComponent_HttpRequest();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.HttpRequestsImpl <em>Http Requests</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.HttpRequestsImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getHttpRequests()
     * @generated
     */
    EClass HTTP_REQUESTS = eINSTANCE.getHttpRequests();

    /**
     * The meta object literal for the '<em><b>Http requests</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HTTP_REQUESTS__HTTP_REQUESTS = eINSTANCE.getHttpRequests_Http_requests();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.ComputeImpl <em>Compute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.ComputeImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getCompute()
     * @generated
     */
    EClass COMPUTE = eINSTANCE.getCompute();

    /**
     * The meta object literal for the '<em><b>Compute</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPUTE__COMPUTE = eINSTANCE.getCompute_Compute();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.ComputationalComponentImpl <em>Computational Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.ComputationalComponentImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getComputationalComponent()
     * @generated
     */
    EClass COMPUTATIONAL_COMPONENT = eINSTANCE.getComputationalComponent();

    /**
     * The meta object literal for the '<em><b>Component</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPUTATIONAL_COMPONENT__COMPONENT = eINSTANCE.getComputationalComponent_Component();

    /**
     * The meta object literal for the '<em><b>Architecture</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPUTATIONAL_COMPONENT__ARCHITECTURE = eINSTANCE.getComputationalComponent_Architecture();

    /**
     * The meta object literal for the '<em><b>Cores</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPUTATIONAL_COMPONENT__CORES = eINSTANCE.getComputationalComponent_Cores();

    /**
     * The meta object literal for the '<em><b>Speed</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPUTATIONAL_COMPONENT__SPEED = eINSTANCE.getComputationalComponent_Speed();

    /**
     * The meta object literal for the '<em><b>Memory</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPUTATIONAL_COMPONENT__MEMORY = eINSTANCE.getComputationalComponent_Memory();

    /**
     * The meta object literal for the '<em><b>Cache</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPUTATIONAL_COMPONENT__CACHE = eINSTANCE.getComputationalComponent_Cache();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.ArchitectureImpl <em>Architecture</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.ArchitectureImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getArchitecture()
     * @generated
     */
    EClass ARCHITECTURE = eINSTANCE.getArchitecture();

    /**
     * The meta object literal for the '<em><b>Architecture</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARCHITECTURE__ARCHITECTURE = eINSTANCE.getArchitecture_Architecture();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.CoresImpl <em>Cores</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.CoresImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getCores()
     * @generated
     */
    EClass CORES = eINSTANCE.getCores();

    /**
     * The meta object literal for the '<em><b>Cores</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CORES__CORES = eINSTANCE.getCores_Cores();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.SpeedImpl <em>Speed</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.SpeedImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getSpeed()
     * @generated
     */
    EClass SPEED = eINSTANCE.getSpeed();

    /**
     * The meta object literal for the '<em><b>Speed</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SPEED__SPEED = eINSTANCE.getSpeed_Speed();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.MemoryImpl <em>Memory</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.MemoryImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getMemory()
     * @generated
     */
    EClass MEMORY = eINSTANCE.getMemory();

    /**
     * The meta object literal for the '<em><b>Memory</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MEMORY__MEMORY = eINSTANCE.getMemory_Memory();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.CacheImpl <em>Cache</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.CacheImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getCache()
     * @generated
     */
    EClass CACHE = eINSTANCE.getCache();

    /**
     * The meta object literal for the '<em><b>Cache</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CACHE__CACHE = eINSTANCE.getCache_Cache();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.NetworkResourceImpl <em>Network Resource</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.NetworkResourceImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getNetworkResource()
     * @generated
     */
    EClass NETWORK_RESOURCE = eINSTANCE.getNetworkResource();

    /**
     * The meta object literal for the '<em><b>Network Resource</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NETWORK_RESOURCE__NETWORK_RESOURCE = eINSTANCE.getNetworkResource_NetworkResource();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.CommunicationalComponentImpl <em>Communicational Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.CommunicationalComponentImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getCommunicationalComponent()
     * @generated
     */
    EClass COMMUNICATIONAL_COMPONENT = eINSTANCE.getCommunicationalComponent();

    /**
     * The meta object literal for the '<em><b>Component</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMUNICATIONAL_COMPONENT__COMPONENT = eINSTANCE.getCommunicationalComponent_Component();

    /**
     * The meta object literal for the '<em><b>Bandwidth</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMUNICATIONAL_COMPONENT__BANDWIDTH = eINSTANCE.getCommunicationalComponent_Bandwidth();

    /**
     * The meta object literal for the '<em><b>Latency</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMUNICATIONAL_COMPONENT__LATENCY = eINSTANCE.getCommunicationalComponent_Latency();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.BandwidthImpl <em>Bandwidth</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.BandwidthImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getBandwidth()
     * @generated
     */
    EClass BANDWIDTH = eINSTANCE.getBandwidth();

    /**
     * The meta object literal for the '<em><b>Bandwidth</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BANDWIDTH__BANDWIDTH = eINSTANCE.getBandwidth_Bandwidth();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.LatencyImpl <em>Latency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.LatencyImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getLatency()
     * @generated
     */
    EClass LATENCY = eINSTANCE.getLatency();

    /**
     * The meta object literal for the '<em><b>Latency</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LATENCY__LATENCY = eINSTANCE.getLatency_Latency();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.StorageResourceImpl <em>Storage Resource</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.StorageResourceImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getStorageResource()
     * @generated
     */
    EClass STORAGE_RESOURCE = eINSTANCE.getStorageResource();

    /**
     * The meta object literal for the '<em><b>Storage Component</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STORAGE_RESOURCE__STORAGE_COMPONENT = eINSTANCE.getStorageResource_StorageComponent();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.StorageComponentImpl <em>Storage Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.StorageComponentImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getStorageComponent()
     * @generated
     */
    EClass STORAGE_COMPONENT = eINSTANCE.getStorageComponent();

    /**
     * The meta object literal for the '<em><b>Component</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STORAGE_COMPONENT__COMPONENT = eINSTANCE.getStorageComponent_Component();

    /**
     * The meta object literal for the '<em><b>Capacity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STORAGE_COMPONENT__CAPACITY = eINSTANCE.getStorageComponent_Capacity();

    /**
     * The meta object literal for the '<em><b>Bandwidth</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STORAGE_COMPONENT__BANDWIDTH = eINSTANCE.getStorageComponent_Bandwidth();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.CapacityImpl <em>Capacity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.CapacityImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getCapacity()
     * @generated
     */
    EClass CAPACITY = eINSTANCE.getCapacity();

    /**
     * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CAPACITY__CAPACITY = eINSTANCE.getCapacity_Capacity();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.ChannelsImpl <em>Channels</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.ChannelsImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getChannels()
     * @generated
     */
    EClass CHANNELS = eINSTANCE.getChannels();

    /**
     * The meta object literal for the '<em><b>Channel</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHANNELS__CHANNEL = eINSTANCE.getChannels_Channel();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.ChannelImpl <em>Channel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.ChannelImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getChannel()
     * @generated
     */
    EClass CHANNEL = eINSTANCE.getChannel();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHANNEL__OPERATION = eINSTANCE.getChannel_Operation();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.OperationImpl <em>Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.OperationImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getOperation()
     * @generated
     */
    EClass OPERATION = eINSTANCE.getOperation();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION__OPERATION = eINSTANCE.getOperation_Operation();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__DESCRIPTION = eINSTANCE.getOperation_Description();

    /**
     * The meta object literal for the '<em><b>Command</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__COMMAND = eINSTANCE.getOperation_Command();

    /**
     * The meta object literal for the '<em><b>Information Returned</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__INFORMATION_RETURNED = eINSTANCE.getOperation_InformationReturned();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.CommandImpl <em>Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.CommandImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getCommand()
     * @generated
     */
    EClass COMMAND = eINSTANCE.getCommand();

    /**
     * The meta object literal for the '<em><b>Command</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMAND__COMMAND = eINSTANCE.getCommand_Command();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.InformationReturnedImpl <em>Information Returned</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.InformationReturnedImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getInformationReturned()
     * @generated
     */
    EClass INFORMATION_RETURNED = eINSTANCE.getInformationReturned();

    /**
     * The meta object literal for the '<em><b>Information Returned</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INFORMATION_RETURNED__INFORMATION_RETURNED = eINSTANCE.getInformationReturned_InformationReturned();

    /**
     * The meta object literal for the '{@link eu.cloud4soa.xtext.dsl.impl.VersionImpl <em>Version</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.cloud4soa.xtext.dsl.impl.VersionImpl
     * @see eu.cloud4soa.xtext.dsl.impl.DslPackageImpl#getVersion()
     * @generated
     */
    EClass VERSION = eINSTANCE.getVersion();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERSION__VALUE = eINSTANCE.getVersion_Value();

  }

} //DslPackage
