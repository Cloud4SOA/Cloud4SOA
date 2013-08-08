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

import eu.cloud4soa.xtext.dsl.ApplicationProfile;
import eu.cloud4soa.xtext.dsl.DslPackage;
import eu.cloud4soa.xtext.dsl.PaasOfferingProfile;
import eu.cloud4soa.xtext.dsl.Scope;
import eu.cloud4soa.xtext.dsl.UserProfile;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scope</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.ScopeImpl#getUserProfile <em>User Profile</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.ScopeImpl#getApplicationProfile <em>Application Profile</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.ScopeImpl#getPaasOfferingProfile <em>Paas Offering Profile</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScopeImpl extends MinimalEObjectImpl.Container implements Scope
{
  /**
   * The cached value of the '{@link #getUserProfile() <em>User Profile</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserProfile()
   * @generated
   * @ordered
   */
  protected UserProfile userProfile;

  /**
   * The cached value of the '{@link #getApplicationProfile() <em>Application Profile</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getApplicationProfile()
   * @generated
   * @ordered
   */
  protected ApplicationProfile applicationProfile;

  /**
   * The cached value of the '{@link #getPaasOfferingProfile() <em>Paas Offering Profile</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPaasOfferingProfile()
   * @generated
   * @ordered
   */
  protected PaasOfferingProfile paasOfferingProfile;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ScopeImpl()
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
    return DslPackage.Literals.SCOPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UserProfile getUserProfile()
  {
    return userProfile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUserProfile(UserProfile newUserProfile, NotificationChain msgs)
  {
    UserProfile oldUserProfile = userProfile;
    userProfile = newUserProfile;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.SCOPE__USER_PROFILE, oldUserProfile, newUserProfile);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUserProfile(UserProfile newUserProfile)
  {
    if (newUserProfile != userProfile)
    {
      NotificationChain msgs = null;
      if (userProfile != null)
        msgs = ((InternalEObject)userProfile).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.SCOPE__USER_PROFILE, null, msgs);
      if (newUserProfile != null)
        msgs = ((InternalEObject)newUserProfile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.SCOPE__USER_PROFILE, null, msgs);
      msgs = basicSetUserProfile(newUserProfile, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.SCOPE__USER_PROFILE, newUserProfile, newUserProfile));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ApplicationProfile getApplicationProfile()
  {
    return applicationProfile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetApplicationProfile(ApplicationProfile newApplicationProfile, NotificationChain msgs)
  {
    ApplicationProfile oldApplicationProfile = applicationProfile;
    applicationProfile = newApplicationProfile;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.SCOPE__APPLICATION_PROFILE, oldApplicationProfile, newApplicationProfile);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setApplicationProfile(ApplicationProfile newApplicationProfile)
  {
    if (newApplicationProfile != applicationProfile)
    {
      NotificationChain msgs = null;
      if (applicationProfile != null)
        msgs = ((InternalEObject)applicationProfile).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.SCOPE__APPLICATION_PROFILE, null, msgs);
      if (newApplicationProfile != null)
        msgs = ((InternalEObject)newApplicationProfile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.SCOPE__APPLICATION_PROFILE, null, msgs);
      msgs = basicSetApplicationProfile(newApplicationProfile, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.SCOPE__APPLICATION_PROFILE, newApplicationProfile, newApplicationProfile));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PaasOfferingProfile getPaasOfferingProfile()
  {
    return paasOfferingProfile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPaasOfferingProfile(PaasOfferingProfile newPaasOfferingProfile, NotificationChain msgs)
  {
    PaasOfferingProfile oldPaasOfferingProfile = paasOfferingProfile;
    paasOfferingProfile = newPaasOfferingProfile;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.SCOPE__PAAS_OFFERING_PROFILE, oldPaasOfferingProfile, newPaasOfferingProfile);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPaasOfferingProfile(PaasOfferingProfile newPaasOfferingProfile)
  {
    if (newPaasOfferingProfile != paasOfferingProfile)
    {
      NotificationChain msgs = null;
      if (paasOfferingProfile != null)
        msgs = ((InternalEObject)paasOfferingProfile).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.SCOPE__PAAS_OFFERING_PROFILE, null, msgs);
      if (newPaasOfferingProfile != null)
        msgs = ((InternalEObject)newPaasOfferingProfile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.SCOPE__PAAS_OFFERING_PROFILE, null, msgs);
      msgs = basicSetPaasOfferingProfile(newPaasOfferingProfile, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.SCOPE__PAAS_OFFERING_PROFILE, newPaasOfferingProfile, newPaasOfferingProfile));
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
      case DslPackage.SCOPE__USER_PROFILE:
        return basicSetUserProfile(null, msgs);
      case DslPackage.SCOPE__APPLICATION_PROFILE:
        return basicSetApplicationProfile(null, msgs);
      case DslPackage.SCOPE__PAAS_OFFERING_PROFILE:
        return basicSetPaasOfferingProfile(null, msgs);
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
      case DslPackage.SCOPE__USER_PROFILE:
        return getUserProfile();
      case DslPackage.SCOPE__APPLICATION_PROFILE:
        return getApplicationProfile();
      case DslPackage.SCOPE__PAAS_OFFERING_PROFILE:
        return getPaasOfferingProfile();
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
      case DslPackage.SCOPE__USER_PROFILE:
        setUserProfile((UserProfile)newValue);
        return;
      case DslPackage.SCOPE__APPLICATION_PROFILE:
        setApplicationProfile((ApplicationProfile)newValue);
        return;
      case DslPackage.SCOPE__PAAS_OFFERING_PROFILE:
        setPaasOfferingProfile((PaasOfferingProfile)newValue);
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
      case DslPackage.SCOPE__USER_PROFILE:
        setUserProfile((UserProfile)null);
        return;
      case DslPackage.SCOPE__APPLICATION_PROFILE:
        setApplicationProfile((ApplicationProfile)null);
        return;
      case DslPackage.SCOPE__PAAS_OFFERING_PROFILE:
        setPaasOfferingProfile((PaasOfferingProfile)null);
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
      case DslPackage.SCOPE__USER_PROFILE:
        return userProfile != null;
      case DslPackage.SCOPE__APPLICATION_PROFILE:
        return applicationProfile != null;
      case DslPackage.SCOPE__PAAS_OFFERING_PROFILE:
        return paasOfferingProfile != null;
    }
    return super.eIsSet(featureID);
  }

} //ScopeImpl
