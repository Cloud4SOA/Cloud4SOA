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

import eu.cloud4soa.xtext.dsl.DslPackage;
import eu.cloud4soa.xtext.dsl.Hardware;
import eu.cloud4soa.xtext.dsl.ProgrammingLanguage;
import eu.cloud4soa.xtext.dsl.Software;
import eu.cloud4soa.xtext.dsl.TechnologyInfo;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Technology Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.TechnologyInfoImpl#getProgrammingLanguage <em>Programming Language</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.TechnologyInfoImpl#getSoftware <em>Software</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.TechnologyInfoImpl#getHardware <em>Hardware</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TechnologyInfoImpl extends MinimalEObjectImpl.Container implements TechnologyInfo
{
  /**
   * The cached value of the '{@link #getProgrammingLanguage() <em>Programming Language</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProgrammingLanguage()
   * @generated
   * @ordered
   */
  protected ProgrammingLanguage programmingLanguage;

  /**
   * The cached value of the '{@link #getSoftware() <em>Software</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSoftware()
   * @generated
   * @ordered
   */
  protected Software software;

  /**
   * The cached value of the '{@link #getHardware() <em>Hardware</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHardware()
   * @generated
   * @ordered
   */
  protected Hardware hardware;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TechnologyInfoImpl()
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
    return DslPackage.Literals.TECHNOLOGY_INFO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProgrammingLanguage getProgrammingLanguage()
  {
    return programmingLanguage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProgrammingLanguage(ProgrammingLanguage newProgrammingLanguage, NotificationChain msgs)
  {
    ProgrammingLanguage oldProgrammingLanguage = programmingLanguage;
    programmingLanguage = newProgrammingLanguage;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.TECHNOLOGY_INFO__PROGRAMMING_LANGUAGE, oldProgrammingLanguage, newProgrammingLanguage);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProgrammingLanguage(ProgrammingLanguage newProgrammingLanguage)
  {
    if (newProgrammingLanguage != programmingLanguage)
    {
      NotificationChain msgs = null;
      if (programmingLanguage != null)
        msgs = ((InternalEObject)programmingLanguage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.TECHNOLOGY_INFO__PROGRAMMING_LANGUAGE, null, msgs);
      if (newProgrammingLanguage != null)
        msgs = ((InternalEObject)newProgrammingLanguage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.TECHNOLOGY_INFO__PROGRAMMING_LANGUAGE, null, msgs);
      msgs = basicSetProgrammingLanguage(newProgrammingLanguage, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TECHNOLOGY_INFO__PROGRAMMING_LANGUAGE, newProgrammingLanguage, newProgrammingLanguage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Software getSoftware()
  {
    return software;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSoftware(Software newSoftware, NotificationChain msgs)
  {
    Software oldSoftware = software;
    software = newSoftware;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.TECHNOLOGY_INFO__SOFTWARE, oldSoftware, newSoftware);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSoftware(Software newSoftware)
  {
    if (newSoftware != software)
    {
      NotificationChain msgs = null;
      if (software != null)
        msgs = ((InternalEObject)software).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.TECHNOLOGY_INFO__SOFTWARE, null, msgs);
      if (newSoftware != null)
        msgs = ((InternalEObject)newSoftware).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.TECHNOLOGY_INFO__SOFTWARE, null, msgs);
      msgs = basicSetSoftware(newSoftware, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TECHNOLOGY_INFO__SOFTWARE, newSoftware, newSoftware));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Hardware getHardware()
  {
    return hardware;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetHardware(Hardware newHardware, NotificationChain msgs)
  {
    Hardware oldHardware = hardware;
    hardware = newHardware;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.TECHNOLOGY_INFO__HARDWARE, oldHardware, newHardware);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHardware(Hardware newHardware)
  {
    if (newHardware != hardware)
    {
      NotificationChain msgs = null;
      if (hardware != null)
        msgs = ((InternalEObject)hardware).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.TECHNOLOGY_INFO__HARDWARE, null, msgs);
      if (newHardware != null)
        msgs = ((InternalEObject)newHardware).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.TECHNOLOGY_INFO__HARDWARE, null, msgs);
      msgs = basicSetHardware(newHardware, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TECHNOLOGY_INFO__HARDWARE, newHardware, newHardware));
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
      case DslPackage.TECHNOLOGY_INFO__PROGRAMMING_LANGUAGE:
        return basicSetProgrammingLanguage(null, msgs);
      case DslPackage.TECHNOLOGY_INFO__SOFTWARE:
        return basicSetSoftware(null, msgs);
      case DslPackage.TECHNOLOGY_INFO__HARDWARE:
        return basicSetHardware(null, msgs);
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
      case DslPackage.TECHNOLOGY_INFO__PROGRAMMING_LANGUAGE:
        return getProgrammingLanguage();
      case DslPackage.TECHNOLOGY_INFO__SOFTWARE:
        return getSoftware();
      case DslPackage.TECHNOLOGY_INFO__HARDWARE:
        return getHardware();
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
      case DslPackage.TECHNOLOGY_INFO__PROGRAMMING_LANGUAGE:
        setProgrammingLanguage((ProgrammingLanguage)newValue);
        return;
      case DslPackage.TECHNOLOGY_INFO__SOFTWARE:
        setSoftware((Software)newValue);
        return;
      case DslPackage.TECHNOLOGY_INFO__HARDWARE:
        setHardware((Hardware)newValue);
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
      case DslPackage.TECHNOLOGY_INFO__PROGRAMMING_LANGUAGE:
        setProgrammingLanguage((ProgrammingLanguage)null);
        return;
      case DslPackage.TECHNOLOGY_INFO__SOFTWARE:
        setSoftware((Software)null);
        return;
      case DslPackage.TECHNOLOGY_INFO__HARDWARE:
        setHardware((Hardware)null);
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
      case DslPackage.TECHNOLOGY_INFO__PROGRAMMING_LANGUAGE:
        return programmingLanguage != null;
      case DslPackage.TECHNOLOGY_INFO__SOFTWARE:
        return software != null;
      case DslPackage.TECHNOLOGY_INFO__HARDWARE:
        return hardware != null;
    }
    return super.eIsSet(featureID);
  }

} //TechnologyInfoImpl
