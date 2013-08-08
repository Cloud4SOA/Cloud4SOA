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

import eu.cloud4soa.xtext.dsl.Architecture;
import eu.cloud4soa.xtext.dsl.Cache;
import eu.cloud4soa.xtext.dsl.Component;
import eu.cloud4soa.xtext.dsl.ComputationalComponent;
import eu.cloud4soa.xtext.dsl.Cores;
import eu.cloud4soa.xtext.dsl.DslPackage;
import eu.cloud4soa.xtext.dsl.Memory;
import eu.cloud4soa.xtext.dsl.Speed;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computational Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.ComputationalComponentImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.ComputationalComponentImpl#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.ComputationalComponentImpl#getCores <em>Cores</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.ComputationalComponentImpl#getSpeed <em>Speed</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.ComputationalComponentImpl#getMemory <em>Memory</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.ComputationalComponentImpl#getCache <em>Cache</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComputationalComponentImpl extends MinimalEObjectImpl.Container implements ComputationalComponent
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
   * The cached value of the '{@link #getArchitecture() <em>Architecture</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArchitecture()
   * @generated
   * @ordered
   */
  protected Architecture architecture;

  /**
   * The cached value of the '{@link #getCores() <em>Cores</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCores()
   * @generated
   * @ordered
   */
  protected Cores cores;

  /**
   * The cached value of the '{@link #getSpeed() <em>Speed</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpeed()
   * @generated
   * @ordered
   */
  protected Speed speed;

  /**
   * The cached value of the '{@link #getMemory() <em>Memory</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMemory()
   * @generated
   * @ordered
   */
  protected Memory memory;

  /**
   * The cached value of the '{@link #getCache() <em>Cache</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCache()
   * @generated
   * @ordered
   */
  protected Cache cache;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComputationalComponentImpl()
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
    return DslPackage.Literals.COMPUTATIONAL_COMPONENT;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.COMPUTATIONAL_COMPONENT__COMPONENT, oldComponent, newComponent);
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
        msgs = ((InternalEObject)component).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMPUTATIONAL_COMPONENT__COMPONENT, null, msgs);
      if (newComponent != null)
        msgs = ((InternalEObject)newComponent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMPUTATIONAL_COMPONENT__COMPONENT, null, msgs);
      msgs = basicSetComponent(newComponent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.COMPUTATIONAL_COMPONENT__COMPONENT, newComponent, newComponent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Architecture getArchitecture()
  {
    return architecture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArchitecture(Architecture newArchitecture, NotificationChain msgs)
  {
    Architecture oldArchitecture = architecture;
    architecture = newArchitecture;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.COMPUTATIONAL_COMPONENT__ARCHITECTURE, oldArchitecture, newArchitecture);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArchitecture(Architecture newArchitecture)
  {
    if (newArchitecture != architecture)
    {
      NotificationChain msgs = null;
      if (architecture != null)
        msgs = ((InternalEObject)architecture).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMPUTATIONAL_COMPONENT__ARCHITECTURE, null, msgs);
      if (newArchitecture != null)
        msgs = ((InternalEObject)newArchitecture).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMPUTATIONAL_COMPONENT__ARCHITECTURE, null, msgs);
      msgs = basicSetArchitecture(newArchitecture, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.COMPUTATIONAL_COMPONENT__ARCHITECTURE, newArchitecture, newArchitecture));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cores getCores()
  {
    return cores;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCores(Cores newCores, NotificationChain msgs)
  {
    Cores oldCores = cores;
    cores = newCores;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.COMPUTATIONAL_COMPONENT__CORES, oldCores, newCores);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCores(Cores newCores)
  {
    if (newCores != cores)
    {
      NotificationChain msgs = null;
      if (cores != null)
        msgs = ((InternalEObject)cores).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMPUTATIONAL_COMPONENT__CORES, null, msgs);
      if (newCores != null)
        msgs = ((InternalEObject)newCores).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMPUTATIONAL_COMPONENT__CORES, null, msgs);
      msgs = basicSetCores(newCores, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.COMPUTATIONAL_COMPONENT__CORES, newCores, newCores));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Speed getSpeed()
  {
    return speed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSpeed(Speed newSpeed, NotificationChain msgs)
  {
    Speed oldSpeed = speed;
    speed = newSpeed;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.COMPUTATIONAL_COMPONENT__SPEED, oldSpeed, newSpeed);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpeed(Speed newSpeed)
  {
    if (newSpeed != speed)
    {
      NotificationChain msgs = null;
      if (speed != null)
        msgs = ((InternalEObject)speed).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMPUTATIONAL_COMPONENT__SPEED, null, msgs);
      if (newSpeed != null)
        msgs = ((InternalEObject)newSpeed).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMPUTATIONAL_COMPONENT__SPEED, null, msgs);
      msgs = basicSetSpeed(newSpeed, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.COMPUTATIONAL_COMPONENT__SPEED, newSpeed, newSpeed));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Memory getMemory()
  {
    return memory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMemory(Memory newMemory, NotificationChain msgs)
  {
    Memory oldMemory = memory;
    memory = newMemory;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.COMPUTATIONAL_COMPONENT__MEMORY, oldMemory, newMemory);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMemory(Memory newMemory)
  {
    if (newMemory != memory)
    {
      NotificationChain msgs = null;
      if (memory != null)
        msgs = ((InternalEObject)memory).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMPUTATIONAL_COMPONENT__MEMORY, null, msgs);
      if (newMemory != null)
        msgs = ((InternalEObject)newMemory).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMPUTATIONAL_COMPONENT__MEMORY, null, msgs);
      msgs = basicSetMemory(newMemory, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.COMPUTATIONAL_COMPONENT__MEMORY, newMemory, newMemory));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cache getCache()
  {
    return cache;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCache(Cache newCache, NotificationChain msgs)
  {
    Cache oldCache = cache;
    cache = newCache;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.COMPUTATIONAL_COMPONENT__CACHE, oldCache, newCache);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCache(Cache newCache)
  {
    if (newCache != cache)
    {
      NotificationChain msgs = null;
      if (cache != null)
        msgs = ((InternalEObject)cache).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMPUTATIONAL_COMPONENT__CACHE, null, msgs);
      if (newCache != null)
        msgs = ((InternalEObject)newCache).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.COMPUTATIONAL_COMPONENT__CACHE, null, msgs);
      msgs = basicSetCache(newCache, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.COMPUTATIONAL_COMPONENT__CACHE, newCache, newCache));
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
      case DslPackage.COMPUTATIONAL_COMPONENT__COMPONENT:
        return basicSetComponent(null, msgs);
      case DslPackage.COMPUTATIONAL_COMPONENT__ARCHITECTURE:
        return basicSetArchitecture(null, msgs);
      case DslPackage.COMPUTATIONAL_COMPONENT__CORES:
        return basicSetCores(null, msgs);
      case DslPackage.COMPUTATIONAL_COMPONENT__SPEED:
        return basicSetSpeed(null, msgs);
      case DslPackage.COMPUTATIONAL_COMPONENT__MEMORY:
        return basicSetMemory(null, msgs);
      case DslPackage.COMPUTATIONAL_COMPONENT__CACHE:
        return basicSetCache(null, msgs);
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
      case DslPackage.COMPUTATIONAL_COMPONENT__COMPONENT:
        return getComponent();
      case DslPackage.COMPUTATIONAL_COMPONENT__ARCHITECTURE:
        return getArchitecture();
      case DslPackage.COMPUTATIONAL_COMPONENT__CORES:
        return getCores();
      case DslPackage.COMPUTATIONAL_COMPONENT__SPEED:
        return getSpeed();
      case DslPackage.COMPUTATIONAL_COMPONENT__MEMORY:
        return getMemory();
      case DslPackage.COMPUTATIONAL_COMPONENT__CACHE:
        return getCache();
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
      case DslPackage.COMPUTATIONAL_COMPONENT__COMPONENT:
        setComponent((Component)newValue);
        return;
      case DslPackage.COMPUTATIONAL_COMPONENT__ARCHITECTURE:
        setArchitecture((Architecture)newValue);
        return;
      case DslPackage.COMPUTATIONAL_COMPONENT__CORES:
        setCores((Cores)newValue);
        return;
      case DslPackage.COMPUTATIONAL_COMPONENT__SPEED:
        setSpeed((Speed)newValue);
        return;
      case DslPackage.COMPUTATIONAL_COMPONENT__MEMORY:
        setMemory((Memory)newValue);
        return;
      case DslPackage.COMPUTATIONAL_COMPONENT__CACHE:
        setCache((Cache)newValue);
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
      case DslPackage.COMPUTATIONAL_COMPONENT__COMPONENT:
        setComponent((Component)null);
        return;
      case DslPackage.COMPUTATIONAL_COMPONENT__ARCHITECTURE:
        setArchitecture((Architecture)null);
        return;
      case DslPackage.COMPUTATIONAL_COMPONENT__CORES:
        setCores((Cores)null);
        return;
      case DslPackage.COMPUTATIONAL_COMPONENT__SPEED:
        setSpeed((Speed)null);
        return;
      case DslPackage.COMPUTATIONAL_COMPONENT__MEMORY:
        setMemory((Memory)null);
        return;
      case DslPackage.COMPUTATIONAL_COMPONENT__CACHE:
        setCache((Cache)null);
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
      case DslPackage.COMPUTATIONAL_COMPONENT__COMPONENT:
        return component != null;
      case DslPackage.COMPUTATIONAL_COMPONENT__ARCHITECTURE:
        return architecture != null;
      case DslPackage.COMPUTATIONAL_COMPONENT__CORES:
        return cores != null;
      case DslPackage.COMPUTATIONAL_COMPONENT__SPEED:
        return speed != null;
      case DslPackage.COMPUTATIONAL_COMPONENT__MEMORY:
        return memory != null;
      case DslPackage.COMPUTATIONAL_COMPONENT__CACHE:
        return cache != null;
    }
    return super.eIsSet(featureID);
  }

} //ComputationalComponentImpl
