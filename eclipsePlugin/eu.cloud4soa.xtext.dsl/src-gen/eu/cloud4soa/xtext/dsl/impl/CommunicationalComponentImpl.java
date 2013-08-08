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

import eu.cloud4soa.xtext.dsl.Bandwidth;
import eu.cloud4soa.xtext.dsl.CommunicationalComponent;
import eu.cloud4soa.xtext.dsl.Component;
import eu.cloud4soa.xtext.dsl.DslPackage;
import eu.cloud4soa.xtext.dsl.Latency;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Communicational Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.CommunicationalComponentImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.CommunicationalComponentImpl#getBandwidth <em>Bandwidth</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.CommunicationalComponentImpl#getLatency <em>Latency</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommunicationalComponentImpl extends MinimalEObjectImpl.Container implements CommunicationalComponent
{
  /**
   * The cached value of the '{@link #getComponent() <em>Component</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponent()
   * @generated
   * @ordered
   */
  protected Component component;

  /**
   * The cached value of the '{@link #getBandwidth() <em>Bandwidth</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBandwidth()
   * @generated
   * @ordered
   */
  protected Bandwidth bandwidth;

  /**
   * The cached value of the '{@link #getLatency() <em>Latency</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLatency()
   * @generated
   * @ordered
   */
  protected Latency latency;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CommunicationalComponentImpl()
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
    return DslPackage.Literals.COMMUNICATIONAL_COMPONENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Component getComponent()
  {
    return component;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetComponent(Component newComponent, NotificationChain msgs)
  {
    Component oldComponent = component;
    component = newComponent;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.COMMUNICATIONAL_COMPONENT__COMPONENT, oldComponent, newComponent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComponent(Component newComponent)
  {
    if (newComponent != component)
    {
      NotificationChain msgs = null;
      if (component != null)
        msgs = ((InternalEObject)component).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMMUNICATIONAL_COMPONENT__COMPONENT, null, msgs);
      if (newComponent != null)
        msgs = ((InternalEObject)newComponent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMMUNICATIONAL_COMPONENT__COMPONENT, null, msgs);
      msgs = basicSetComponent(newComponent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.COMMUNICATIONAL_COMPONENT__COMPONENT, newComponent, newComponent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bandwidth getBandwidth()
  {
    return bandwidth;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBandwidth(Bandwidth newBandwidth, NotificationChain msgs)
  {
    Bandwidth oldBandwidth = bandwidth;
    bandwidth = newBandwidth;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.COMMUNICATIONAL_COMPONENT__BANDWIDTH, oldBandwidth, newBandwidth);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBandwidth(Bandwidth newBandwidth)
  {
    if (newBandwidth != bandwidth)
    {
      NotificationChain msgs = null;
      if (bandwidth != null)
        msgs = ((InternalEObject)bandwidth).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMMUNICATIONAL_COMPONENT__BANDWIDTH, null, msgs);
      if (newBandwidth != null)
        msgs = ((InternalEObject)newBandwidth).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMMUNICATIONAL_COMPONENT__BANDWIDTH, null, msgs);
      msgs = basicSetBandwidth(newBandwidth, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.COMMUNICATIONAL_COMPONENT__BANDWIDTH, newBandwidth, newBandwidth));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Latency getLatency()
  {
    return latency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLatency(Latency newLatency, NotificationChain msgs)
  {
    Latency oldLatency = latency;
    latency = newLatency;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.COMMUNICATIONAL_COMPONENT__LATENCY, oldLatency, newLatency);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLatency(Latency newLatency)
  {
    if (newLatency != latency)
    {
      NotificationChain msgs = null;
      if (latency != null)
        msgs = ((InternalEObject)latency).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMMUNICATIONAL_COMPONENT__LATENCY, null, msgs);
      if (newLatency != null)
        msgs = ((InternalEObject)newLatency).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMMUNICATIONAL_COMPONENT__LATENCY, null, msgs);
      msgs = basicSetLatency(newLatency, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.COMMUNICATIONAL_COMPONENT__LATENCY, newLatency, newLatency));
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
      case DslPackage.COMMUNICATIONAL_COMPONENT__COMPONENT:
        return basicSetComponent(null, msgs);
      case DslPackage.COMMUNICATIONAL_COMPONENT__BANDWIDTH:
        return basicSetBandwidth(null, msgs);
      case DslPackage.COMMUNICATIONAL_COMPONENT__LATENCY:
        return basicSetLatency(null, msgs);
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
      case DslPackage.COMMUNICATIONAL_COMPONENT__COMPONENT:
        return getComponent();
      case DslPackage.COMMUNICATIONAL_COMPONENT__BANDWIDTH:
        return getBandwidth();
      case DslPackage.COMMUNICATIONAL_COMPONENT__LATENCY:
        return getLatency();
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
      case DslPackage.COMMUNICATIONAL_COMPONENT__COMPONENT:
        setComponent((Component)newValue);
        return;
      case DslPackage.COMMUNICATIONAL_COMPONENT__BANDWIDTH:
        setBandwidth((Bandwidth)newValue);
        return;
      case DslPackage.COMMUNICATIONAL_COMPONENT__LATENCY:
        setLatency((Latency)newValue);
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
      case DslPackage.COMMUNICATIONAL_COMPONENT__COMPONENT:
        setComponent((Component)null);
        return;
      case DslPackage.COMMUNICATIONAL_COMPONENT__BANDWIDTH:
        setBandwidth((Bandwidth)null);
        return;
      case DslPackage.COMMUNICATIONAL_COMPONENT__LATENCY:
        setLatency((Latency)null);
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
      case DslPackage.COMMUNICATIONAL_COMPONENT__COMPONENT:
        return component != null;
      case DslPackage.COMMUNICATIONAL_COMPONENT__BANDWIDTH:
        return bandwidth != null;
      case DslPackage.COMMUNICATIONAL_COMPONENT__LATENCY:
        return latency != null;
    }
    return super.eIsSet(featureID);
  }

} //CommunicationalComponentImpl
