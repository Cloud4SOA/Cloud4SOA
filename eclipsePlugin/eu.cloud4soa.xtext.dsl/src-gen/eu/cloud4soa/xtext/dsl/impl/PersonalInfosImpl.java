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

import eu.cloud4soa.xtext.dsl.Birthday;
import eu.cloud4soa.xtext.dsl.DslPackage;
import eu.cloud4soa.xtext.dsl.PersonalInfos;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Personal Infos</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.PersonalInfosImpl#getFirstName <em>First Name</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.PersonalInfosImpl#getSurnName <em>Surn Name</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.PersonalInfosImpl#getEmail <em>Email</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.PersonalInfosImpl#getBirthDay <em>Birth Day</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PersonalInfosImpl extends MinimalEObjectImpl.Container implements PersonalInfos
{
  /**
   * The default value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstName()
   * @generated
   * @ordered
   */
  protected static final String FIRST_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstName()
   * @generated
   * @ordered
   */
  protected String firstName = FIRST_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getSurnName() <em>Surn Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSurnName()
   * @generated
   * @ordered
   */
  protected static final String SURN_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSurnName() <em>Surn Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSurnName()
   * @generated
   * @ordered
   */
  protected String surnName = SURN_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmail()
   * @generated
   * @ordered
   */
  protected static final String EMAIL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmail()
   * @generated
   * @ordered
   */
  protected String email = EMAIL_EDEFAULT;

  /**
   * The cached value of the '{@link #getBirthDay() <em>Birth Day</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBirthDay()
   * @generated
   * @ordered
   */
  protected Birthday birthDay;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PersonalInfosImpl()
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
    return DslPackage.Literals.PERSONAL_INFOS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFirstName()
  {
    return firstName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirstName(String newFirstName)
  {
    String oldFirstName = firstName;
    firstName = newFirstName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.PERSONAL_INFOS__FIRST_NAME, oldFirstName, firstName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSurnName()
  {
    return surnName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSurnName(String newSurnName)
  {
    String oldSurnName = surnName;
    surnName = newSurnName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.PERSONAL_INFOS__SURN_NAME, oldSurnName, surnName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEmail()
  {
    return email;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEmail(String newEmail)
  {
    String oldEmail = email;
    email = newEmail;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.PERSONAL_INFOS__EMAIL, oldEmail, email));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Birthday getBirthDay()
  {
    return birthDay;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBirthDay(Birthday newBirthDay, NotificationChain msgs)
  {
    Birthday oldBirthDay = birthDay;
    birthDay = newBirthDay;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.PERSONAL_INFOS__BIRTH_DAY, oldBirthDay, newBirthDay);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBirthDay(Birthday newBirthDay)
  {
    if (newBirthDay != birthDay)
    {
      NotificationChain msgs = null;
      if (birthDay != null)
        msgs = ((InternalEObject)birthDay).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.PERSONAL_INFOS__BIRTH_DAY, null, msgs);
      if (newBirthDay != null)
        msgs = ((InternalEObject)newBirthDay).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.PERSONAL_INFOS__BIRTH_DAY, null, msgs);
      msgs = basicSetBirthDay(newBirthDay, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.PERSONAL_INFOS__BIRTH_DAY, newBirthDay, newBirthDay));
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
      case DslPackage.PERSONAL_INFOS__BIRTH_DAY:
        return basicSetBirthDay(null, msgs);
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
      case DslPackage.PERSONAL_INFOS__FIRST_NAME:
        return getFirstName();
      case DslPackage.PERSONAL_INFOS__SURN_NAME:
        return getSurnName();
      case DslPackage.PERSONAL_INFOS__EMAIL:
        return getEmail();
      case DslPackage.PERSONAL_INFOS__BIRTH_DAY:
        return getBirthDay();
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
      case DslPackage.PERSONAL_INFOS__FIRST_NAME:
        setFirstName((String)newValue);
        return;
      case DslPackage.PERSONAL_INFOS__SURN_NAME:
        setSurnName((String)newValue);
        return;
      case DslPackage.PERSONAL_INFOS__EMAIL:
        setEmail((String)newValue);
        return;
      case DslPackage.PERSONAL_INFOS__BIRTH_DAY:
        setBirthDay((Birthday)newValue);
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
      case DslPackage.PERSONAL_INFOS__FIRST_NAME:
        setFirstName(FIRST_NAME_EDEFAULT);
        return;
      case DslPackage.PERSONAL_INFOS__SURN_NAME:
        setSurnName(SURN_NAME_EDEFAULT);
        return;
      case DslPackage.PERSONAL_INFOS__EMAIL:
        setEmail(EMAIL_EDEFAULT);
        return;
      case DslPackage.PERSONAL_INFOS__BIRTH_DAY:
        setBirthDay((Birthday)null);
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
      case DslPackage.PERSONAL_INFOS__FIRST_NAME:
        return FIRST_NAME_EDEFAULT == null ? firstName != null : !FIRST_NAME_EDEFAULT.equals(firstName);
      case DslPackage.PERSONAL_INFOS__SURN_NAME:
        return SURN_NAME_EDEFAULT == null ? surnName != null : !SURN_NAME_EDEFAULT.equals(surnName);
      case DslPackage.PERSONAL_INFOS__EMAIL:
        return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT.equals(email);
      case DslPackage.PERSONAL_INFOS__BIRTH_DAY:
        return birthDay != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (firstName: ");
    result.append(firstName);
    result.append(", surnName: ");
    result.append(surnName);
    result.append(", email: ");
    result.append(email);
    result.append(')');
    return result.toString();
  }

} //PersonalInfosImpl
