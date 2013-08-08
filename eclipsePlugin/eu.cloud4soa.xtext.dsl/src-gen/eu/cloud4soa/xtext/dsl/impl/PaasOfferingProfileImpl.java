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

import eu.cloud4soa.xtext.dsl.Channels;
import eu.cloud4soa.xtext.dsl.DslPackage;
import eu.cloud4soa.xtext.dsl.PaasOfferingInfos;
import eu.cloud4soa.xtext.dsl.PaasOfferingProfile;
import eu.cloud4soa.xtext.dsl.TechnologyInfo;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Paas Offering Profile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.PaasOfferingProfileImpl#getPaasOfferingInfos <em>Paas Offering Infos</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.PaasOfferingProfileImpl#getChannels <em>Channels</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.PaasOfferingProfileImpl#getTechnology <em>Technology</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PaasOfferingProfileImpl extends MinimalEObjectImpl.Container implements PaasOfferingProfile
{
  /**
   * The cached value of the '{@link #getPaasOfferingInfos() <em>Paas Offering Infos</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPaasOfferingInfos()
   * @generated
   * @ordered
   */
  protected PaasOfferingInfos paasOfferingInfos;

  /**
   * The cached value of the '{@link #getChannels() <em>Channels</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChannels()
   * @generated
   * @ordered
   */
  protected Channels channels;

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
  protected PaasOfferingProfileImpl()
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
    return DslPackage.Literals.PAAS_OFFERING_PROFILE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PaasOfferingInfos getPaasOfferingInfos()
  {
    return paasOfferingInfos;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPaasOfferingInfos(PaasOfferingInfos newPaasOfferingInfos, NotificationChain msgs)
  {
    PaasOfferingInfos oldPaasOfferingInfos = paasOfferingInfos;
    paasOfferingInfos = newPaasOfferingInfos;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.PAAS_OFFERING_PROFILE__PAAS_OFFERING_INFOS, oldPaasOfferingInfos, newPaasOfferingInfos);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPaasOfferingInfos(PaasOfferingInfos newPaasOfferingInfos)
  {
    if (newPaasOfferingInfos != paasOfferingInfos)
    {
      NotificationChain msgs = null;
      if (paasOfferingInfos != null)
        msgs = ((InternalEObject)paasOfferingInfos).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.PAAS_OFFERING_PROFILE__PAAS_OFFERING_INFOS, null, msgs);
      if (newPaasOfferingInfos != null)
        msgs = ((InternalEObject)newPaasOfferingInfos).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.PAAS_OFFERING_PROFILE__PAAS_OFFERING_INFOS, null, msgs);
      msgs = basicSetPaasOfferingInfos(newPaasOfferingInfos, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.PAAS_OFFERING_PROFILE__PAAS_OFFERING_INFOS, newPaasOfferingInfos, newPaasOfferingInfos));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Channels getChannels()
  {
    return channels;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChannels(Channels newChannels, NotificationChain msgs)
  {
    Channels oldChannels = channels;
    channels = newChannels;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.PAAS_OFFERING_PROFILE__CHANNELS, oldChannels, newChannels);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChannels(Channels newChannels)
  {
    if (newChannels != channels)
    {
      NotificationChain msgs = null;
      if (channels != null)
        msgs = ((InternalEObject)channels).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.PAAS_OFFERING_PROFILE__CHANNELS, null, msgs);
      if (newChannels != null)
        msgs = ((InternalEObject)newChannels).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.PAAS_OFFERING_PROFILE__CHANNELS, null, msgs);
      msgs = basicSetChannels(newChannels, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.PAAS_OFFERING_PROFILE__CHANNELS, newChannels, newChannels));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.PAAS_OFFERING_PROFILE__TECHNOLOGY, oldTechnology, newTechnology);
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
        msgs = ((InternalEObject)technology).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.PAAS_OFFERING_PROFILE__TECHNOLOGY, null, msgs);
      if (newTechnology != null)
        msgs = ((InternalEObject)newTechnology).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.PAAS_OFFERING_PROFILE__TECHNOLOGY, null, msgs);
      msgs = basicSetTechnology(newTechnology, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.PAAS_OFFERING_PROFILE__TECHNOLOGY, newTechnology, newTechnology));
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
      case DslPackage.PAAS_OFFERING_PROFILE__PAAS_OFFERING_INFOS:
        return basicSetPaasOfferingInfos(null, msgs);
      case DslPackage.PAAS_OFFERING_PROFILE__CHANNELS:
        return basicSetChannels(null, msgs);
      case DslPackage.PAAS_OFFERING_PROFILE__TECHNOLOGY:
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
      case DslPackage.PAAS_OFFERING_PROFILE__PAAS_OFFERING_INFOS:
        return getPaasOfferingInfos();
      case DslPackage.PAAS_OFFERING_PROFILE__CHANNELS:
        return getChannels();
      case DslPackage.PAAS_OFFERING_PROFILE__TECHNOLOGY:
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
      case DslPackage.PAAS_OFFERING_PROFILE__PAAS_OFFERING_INFOS:
        setPaasOfferingInfos((PaasOfferingInfos)newValue);
        return;
      case DslPackage.PAAS_OFFERING_PROFILE__CHANNELS:
        setChannels((Channels)newValue);
        return;
      case DslPackage.PAAS_OFFERING_PROFILE__TECHNOLOGY:
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
      case DslPackage.PAAS_OFFERING_PROFILE__PAAS_OFFERING_INFOS:
        setPaasOfferingInfos((PaasOfferingInfos)null);
        return;
      case DslPackage.PAAS_OFFERING_PROFILE__CHANNELS:
        setChannels((Channels)null);
        return;
      case DslPackage.PAAS_OFFERING_PROFILE__TECHNOLOGY:
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
      case DslPackage.PAAS_OFFERING_PROFILE__PAAS_OFFERING_INFOS:
        return paasOfferingInfos != null;
      case DslPackage.PAAS_OFFERING_PROFILE__CHANNELS:
        return channels != null;
      case DslPackage.PAAS_OFFERING_PROFILE__TECHNOLOGY:
        return technology != null;
    }
    return super.eIsSet(featureID);
  }

} //PaasOfferingProfileImpl
