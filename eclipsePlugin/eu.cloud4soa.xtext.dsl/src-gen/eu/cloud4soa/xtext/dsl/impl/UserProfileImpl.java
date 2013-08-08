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

import eu.cloud4soa.xtext.dsl.AccountInfo;
import eu.cloud4soa.xtext.dsl.DslPackage;
import eu.cloud4soa.xtext.dsl.PersonalInfos;
import eu.cloud4soa.xtext.dsl.Provider;
import eu.cloud4soa.xtext.dsl.UserProfile;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Profile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.UserProfileImpl#getProvider <em>Provider</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.UserProfileImpl#getAccountInfo <em>Account Info</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.UserProfileImpl#getPersonalInfo <em>Personal Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserProfileImpl extends MinimalEObjectImpl.Container implements UserProfile
{
  /**
   * The cached value of the '{@link #getProvider() <em>Provider</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProvider()
   * @generated
   * @ordered
   */
  protected Provider provider;

  /**
   * The cached value of the '{@link #getAccountInfo() <em>Account Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccountInfo()
   * @generated
   * @ordered
   */
  protected AccountInfo accountInfo;

  /**
   * The cached value of the '{@link #getPersonalInfo() <em>Personal Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPersonalInfo()
   * @generated
   * @ordered
   */
  protected PersonalInfos personalInfo;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UserProfileImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DslPackage.Literals.USER_PROFILE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Provider getProvider()
  {
    return provider;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProvider(Provider newProvider, NotificationChain msgs)
  {
    Provider oldProvider = provider;
    provider = newProvider;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.USER_PROFILE__PROVIDER, oldProvider, newProvider);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProvider(Provider newProvider)
  {
    if (newProvider != provider)
    {
      NotificationChain msgs = null;
      if (provider != null)
        msgs = ((InternalEObject)provider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.USER_PROFILE__PROVIDER, null, msgs);
      if (newProvider != null)
        msgs = ((InternalEObject)newProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.USER_PROFILE__PROVIDER, null, msgs);
      msgs = basicSetProvider(newProvider, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.USER_PROFILE__PROVIDER, newProvider, newProvider));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AccountInfo getAccountInfo()
  {
    return accountInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAccountInfo(AccountInfo newAccountInfo, NotificationChain msgs)
  {
    AccountInfo oldAccountInfo = accountInfo;
    accountInfo = newAccountInfo;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.USER_PROFILE__ACCOUNT_INFO, oldAccountInfo, newAccountInfo);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAccountInfo(AccountInfo newAccountInfo)
  {
    if (newAccountInfo != accountInfo)
    {
      NotificationChain msgs = null;
      if (accountInfo != null)
        msgs = ((InternalEObject)accountInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.USER_PROFILE__ACCOUNT_INFO, null, msgs);
      if (newAccountInfo != null)
        msgs = ((InternalEObject)newAccountInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.USER_PROFILE__ACCOUNT_INFO, null, msgs);
      msgs = basicSetAccountInfo(newAccountInfo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.USER_PROFILE__ACCOUNT_INFO, newAccountInfo, newAccountInfo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PersonalInfos getPersonalInfo()
  {
    return personalInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPersonalInfo(PersonalInfos newPersonalInfo, NotificationChain msgs)
  {
    PersonalInfos oldPersonalInfo = personalInfo;
    personalInfo = newPersonalInfo;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.USER_PROFILE__PERSONAL_INFO, oldPersonalInfo, newPersonalInfo);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPersonalInfo(PersonalInfos newPersonalInfo)
  {
    if (newPersonalInfo != personalInfo)
    {
      NotificationChain msgs = null;
      if (personalInfo != null)
        msgs = ((InternalEObject)personalInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.USER_PROFILE__PERSONAL_INFO, null, msgs);
      if (newPersonalInfo != null)
        msgs = ((InternalEObject)newPersonalInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.USER_PROFILE__PERSONAL_INFO, null, msgs);
      msgs = basicSetPersonalInfo(newPersonalInfo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.USER_PROFILE__PERSONAL_INFO, newPersonalInfo, newPersonalInfo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case DslPackage.USER_PROFILE__PROVIDER:
        return basicSetProvider(null, msgs);
      case DslPackage.USER_PROFILE__ACCOUNT_INFO:
        return basicSetAccountInfo(null, msgs);
      case DslPackage.USER_PROFILE__PERSONAL_INFO:
        return basicSetPersonalInfo(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case DslPackage.USER_PROFILE__PROVIDER:
        return getProvider();
      case DslPackage.USER_PROFILE__ACCOUNT_INFO:
        return getAccountInfo();
      case DslPackage.USER_PROFILE__PERSONAL_INFO:
        return getPersonalInfo();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DslPackage.USER_PROFILE__PROVIDER:
        setProvider((Provider)newValue);
        return;
      case DslPackage.USER_PROFILE__ACCOUNT_INFO:
        setAccountInfo((AccountInfo)newValue);
        return;
      case DslPackage.USER_PROFILE__PERSONAL_INFO:
        setPersonalInfo((PersonalInfos)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case DslPackage.USER_PROFILE__PROVIDER:
        setProvider((Provider)null);
        return;
      case DslPackage.USER_PROFILE__ACCOUNT_INFO:
        setAccountInfo((AccountInfo)null);
        return;
      case DslPackage.USER_PROFILE__PERSONAL_INFO:
        setPersonalInfo((PersonalInfos)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case DslPackage.USER_PROFILE__PROVIDER:
        return provider != null;
      case DslPackage.USER_PROFILE__ACCOUNT_INFO:
        return accountInfo != null;
      case DslPackage.USER_PROFILE__PERSONAL_INFO:
        return personalInfo != null;
    }
    return super.eIsSet(featureID);
  }

} //UserProfileImpl
