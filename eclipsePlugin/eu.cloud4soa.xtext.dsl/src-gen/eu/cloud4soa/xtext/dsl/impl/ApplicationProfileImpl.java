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

import eu.cloud4soa.xtext.dsl.ApplicationInfos;
import eu.cloud4soa.xtext.dsl.ApplicationProfile;
import eu.cloud4soa.xtext.dsl.DslPackage;
import eu.cloud4soa.xtext.dsl.File;
import eu.cloud4soa.xtext.dsl.TechnologyInfo;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Profile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.ApplicationProfileImpl#getInfos <em>Infos</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.ApplicationProfileImpl#getFile <em>File</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.ApplicationProfileImpl#getTechnology <em>Technology</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplicationProfileImpl extends MinimalEObjectImpl.Container implements ApplicationProfile
{
  /**
   * The cached value of the '{@link #getInfos() <em>Infos</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInfos()
   * @generated
   * @ordered
   */
  protected ApplicationInfos infos;

  /**
   * The cached value of the '{@link #getFile() <em>File</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFile()
   * @generated
   * @ordered
   */
  protected File file;

  /**
   * The cached value of the '{@link #getTechnology() <em>Technology</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTechnology()
   * @generated
   * @ordered
   */
  protected TechnologyInfo technology;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ApplicationProfileImpl()
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
    return DslPackage.Literals.APPLICATION_PROFILE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ApplicationInfos getInfos()
  {
    return infos;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInfos(ApplicationInfos newInfos, NotificationChain msgs)
  {
    ApplicationInfos oldInfos = infos;
    infos = newInfos;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.APPLICATION_PROFILE__INFOS, oldInfos, newInfos);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInfos(ApplicationInfos newInfos)
  {
    if (newInfos != infos)
    {
      NotificationChain msgs = null;
      if (infos != null)
        msgs = ((InternalEObject)infos).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.APPLICATION_PROFILE__INFOS, null, msgs);
      if (newInfos != null)
        msgs = ((InternalEObject)newInfos).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.APPLICATION_PROFILE__INFOS, null, msgs);
      msgs = basicSetInfos(newInfos, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.APPLICATION_PROFILE__INFOS, newInfos, newInfos));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public File getFile()
  {
    return file;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFile(File newFile, NotificationChain msgs)
  {
    File oldFile = file;
    file = newFile;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.APPLICATION_PROFILE__FILE, oldFile, newFile);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFile(File newFile)
  {
    if (newFile != file)
    {
      NotificationChain msgs = null;
      if (file != null)
        msgs = ((InternalEObject)file).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.APPLICATION_PROFILE__FILE, null, msgs);
      if (newFile != null)
        msgs = ((InternalEObject)newFile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.APPLICATION_PROFILE__FILE, null, msgs);
      msgs = basicSetFile(newFile, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.APPLICATION_PROFILE__FILE, newFile, newFile));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TechnologyInfo getTechnology()
  {
    return technology;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTechnology(TechnologyInfo newTechnology, NotificationChain msgs)
  {
    TechnologyInfo oldTechnology = technology;
    technology = newTechnology;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.APPLICATION_PROFILE__TECHNOLOGY, oldTechnology, newTechnology);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTechnology(TechnologyInfo newTechnology)
  {
    if (newTechnology != technology)
    {
      NotificationChain msgs = null;
      if (technology != null)
        msgs = ((InternalEObject)technology).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.APPLICATION_PROFILE__TECHNOLOGY, null, msgs);
      if (newTechnology != null)
        msgs = ((InternalEObject)newTechnology).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.APPLICATION_PROFILE__TECHNOLOGY, null, msgs);
      msgs = basicSetTechnology(newTechnology, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.APPLICATION_PROFILE__TECHNOLOGY, newTechnology, newTechnology));
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
      case DslPackage.APPLICATION_PROFILE__INFOS:
        return basicSetInfos(null, msgs);
      case DslPackage.APPLICATION_PROFILE__FILE:
        return basicSetFile(null, msgs);
      case DslPackage.APPLICATION_PROFILE__TECHNOLOGY:
        return basicSetTechnology(null, msgs);
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
      case DslPackage.APPLICATION_PROFILE__INFOS:
        return getInfos();
      case DslPackage.APPLICATION_PROFILE__FILE:
        return getFile();
      case DslPackage.APPLICATION_PROFILE__TECHNOLOGY:
        return getTechnology();
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
      case DslPackage.APPLICATION_PROFILE__INFOS:
        setInfos((ApplicationInfos)newValue);
        return;
      case DslPackage.APPLICATION_PROFILE__FILE:
        setFile((File)newValue);
        return;
      case DslPackage.APPLICATION_PROFILE__TECHNOLOGY:
        setTechnology((TechnologyInfo)newValue);
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
      case DslPackage.APPLICATION_PROFILE__INFOS:
        setInfos((ApplicationInfos)null);
        return;
      case DslPackage.APPLICATION_PROFILE__FILE:
        setFile((File)null);
        return;
      case DslPackage.APPLICATION_PROFILE__TECHNOLOGY:
        setTechnology((TechnologyInfo)null);
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
      case DslPackage.APPLICATION_PROFILE__INFOS:
        return infos != null;
      case DslPackage.APPLICATION_PROFILE__FILE:
        return file != null;
      case DslPackage.APPLICATION_PROFILE__TECHNOLOGY:
        return technology != null;
    }
    return super.eIsSet(featureID);
  }

} //ApplicationProfileImpl
