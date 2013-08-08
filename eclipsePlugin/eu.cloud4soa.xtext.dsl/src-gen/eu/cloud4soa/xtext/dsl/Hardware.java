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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hardware</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.Hardware#getBox <em>Box</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.Hardware#getCompute <em>Compute</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.Hardware#getNetworkResource <em>Network Resource</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.Hardware#getStorageResource <em>Storage Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.cloud4soa.xtext.dsl.DslPackage#getHardware()
 * @model
 * @generated
 */
public interface Hardware extends EObject
{
  /**
   * Returns the value of the '<em><b>Box</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Box</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Box</em>' containment reference.
   * @see #setBox(Box)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getHardware_Box()
   * @model containment="true"
   * @generated
   */
  Box getBox();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.Hardware#getBox <em>Box</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Box</em>' containment reference.
   * @see #getBox()
   * @generated
   */
  void setBox(Box value);

  /**
   * Returns the value of the '<em><b>Compute</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Compute</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Compute</em>' containment reference.
   * @see #setCompute(Compute)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getHardware_Compute()
   * @model containment="true"
   * @generated
   */
  Compute getCompute();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.Hardware#getCompute <em>Compute</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Compute</em>' containment reference.
   * @see #getCompute()
   * @generated
   */
  void setCompute(Compute value);

  /**
   * Returns the value of the '<em><b>Network Resource</b></em>' containment reference list.
   * The list contents are of type {@link eu.cloud4soa.xtext.dsl.NetworkResource}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Network Resource</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Network Resource</em>' containment reference list.
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getHardware_NetworkResource()
   * @model containment="true"
   * @generated
   */
  EList<NetworkResource> getNetworkResource();

  /**
   * Returns the value of the '<em><b>Storage Resource</b></em>' containment reference list.
   * The list contents are of type {@link eu.cloud4soa.xtext.dsl.StorageResource}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Storage Resource</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Storage Resource</em>' containment reference list.
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getHardware_StorageResource()
   * @model containment="true"
   * @generated
   */
  EList<StorageResource> getStorageResource();

} // Hardware
