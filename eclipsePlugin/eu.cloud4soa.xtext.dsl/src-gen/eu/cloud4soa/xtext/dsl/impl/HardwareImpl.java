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

import eu.cloud4soa.xtext.dsl.Box;
import eu.cloud4soa.xtext.dsl.Compute;
import eu.cloud4soa.xtext.dsl.DslPackage;
import eu.cloud4soa.xtext.dsl.Hardware;
import eu.cloud4soa.xtext.dsl.NetworkResource;
import eu.cloud4soa.xtext.dsl.StorageResource;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hardware</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.HardwareImpl#getBox <em>Box</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.HardwareImpl#getCompute <em>Compute</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.HardwareImpl#getNetworkResource <em>Network Resource</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.impl.HardwareImpl#getStorageResource <em>Storage Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HardwareImpl extends MinimalEObjectImpl.Container implements Hardware
{
  /**
   * The cached value of the '{@link #getBox() <em>Box</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBox()
   * @generated
   * @ordered
   */
  protected Box box;

  /**
   * The cached value of the '{@link #getCompute() <em>Compute</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCompute()
   * @generated
   * @ordered
   */
  protected Compute compute;

  /**
   * The cached value of the '{@link #getNetworkResource() <em>Network Resource</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNetworkResource()
   * @generated
   * @ordered
   */
  protected EList<NetworkResource> networkResource;

  /**
   * The cached value of the '{@link #getStorageResource() <em>Storage Resource</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStorageResource()
   * @generated
   * @ordered
   */
  protected EList<StorageResource> storageResource;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HardwareImpl()
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
    return DslPackage.Literals.HARDWARE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Box getBox()
  {
    return box;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBox(Box newBox, NotificationChain msgs)
  {
    Box oldBox = box;
    box = newBox;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.HARDWARE__BOX, oldBox, newBox);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBox(Box newBox)
  {
    if (newBox != box)
    {
      NotificationChain msgs = null;
      if (box != null)
        msgs = ((InternalEObject)box).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.HARDWARE__BOX, null, msgs);
      if (newBox != null)
        msgs = ((InternalEObject)newBox).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.HARDWARE__BOX, null, msgs);
      msgs = basicSetBox(newBox, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.HARDWARE__BOX, newBox, newBox));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Compute getCompute()
  {
    return compute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCompute(Compute newCompute, NotificationChain msgs)
  {
    Compute oldCompute = compute;
    compute = newCompute;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.HARDWARE__COMPUTE, oldCompute, newCompute);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCompute(Compute newCompute)
  {
    if (newCompute != compute)
    {
      NotificationChain msgs = null;
      if (compute != null)
        msgs = ((InternalEObject)compute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.HARDWARE__COMPUTE, null, msgs);
      if (newCompute != null)
        msgs = ((InternalEObject)newCompute).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.HARDWARE__COMPUTE, null, msgs);
      msgs = basicSetCompute(newCompute, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.HARDWARE__COMPUTE, newCompute, newCompute));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NetworkResource> getNetworkResource()
  {
    if (networkResource == null)
    {
      networkResource = new EObjectContainmentEList<NetworkResource>(NetworkResource.class, this, DslPackage.HARDWARE__NETWORK_RESOURCE);
    }
    return networkResource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StorageResource> getStorageResource()
  {
    if (storageResource == null)
    {
      storageResource = new EObjectContainmentEList<StorageResource>(StorageResource.class, this, DslPackage.HARDWARE__STORAGE_RESOURCE);
    }
    return storageResource;
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
      case DslPackage.HARDWARE__BOX:
        return basicSetBox(null, msgs);
      case DslPackage.HARDWARE__COMPUTE:
        return basicSetCompute(null, msgs);
      case DslPackage.HARDWARE__NETWORK_RESOURCE:
        return ((InternalEList<?>)getNetworkResource()).basicRemove(otherEnd, msgs);
      case DslPackage.HARDWARE__STORAGE_RESOURCE:
        return ((InternalEList<?>)getStorageResource()).basicRemove(otherEnd, msgs);
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
      case DslPackage.HARDWARE__BOX:
        return getBox();
      case DslPackage.HARDWARE__COMPUTE:
        return getCompute();
      case DslPackage.HARDWARE__NETWORK_RESOURCE:
        return getNetworkResource();
      case DslPackage.HARDWARE__STORAGE_RESOURCE:
        return getStorageResource();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DslPackage.HARDWARE__BOX:
        setBox((Box)newValue);
        return;
      case DslPackage.HARDWARE__COMPUTE:
        setCompute((Compute)newValue);
        return;
      case DslPackage.HARDWARE__NETWORK_RESOURCE:
        getNetworkResource().clear();
        getNetworkResource().addAll((Collection<? extends NetworkResource>)newValue);
        return;
      case DslPackage.HARDWARE__STORAGE_RESOURCE:
        getStorageResource().clear();
        getStorageResource().addAll((Collection<? extends StorageResource>)newValue);
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
      case DslPackage.HARDWARE__BOX:
        setBox((Box)null);
        return;
      case DslPackage.HARDWARE__COMPUTE:
        setCompute((Compute)null);
        return;
      case DslPackage.HARDWARE__NETWORK_RESOURCE:
        getNetworkResource().clear();
        return;
      case DslPackage.HARDWARE__STORAGE_RESOURCE:
        getStorageResource().clear();
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
      case DslPackage.HARDWARE__BOX:
        return box != null;
      case DslPackage.HARDWARE__COMPUTE:
        return compute != null;
      case DslPackage.HARDWARE__NETWORK_RESOURCE:
        return networkResource != null && !networkResource.isEmpty();
      case DslPackage.HARDWARE__STORAGE_RESOURCE:
        return storageResource != null && !storageResource.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //HardwareImpl
