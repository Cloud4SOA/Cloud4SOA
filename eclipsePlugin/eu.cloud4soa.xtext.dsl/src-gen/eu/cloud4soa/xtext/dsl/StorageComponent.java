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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Storage Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.StorageComponent#getComponent <em>Component</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.StorageComponent#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.StorageComponent#getBandwidth <em>Bandwidth</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.cloud4soa.xtext.dsl.DslPackage#getStorageComponent()
 * @model
 * @generated
 */
public interface StorageComponent extends EObject
{
  /**
   * Returns the value of the '<em><b>Component</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Component</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component</em>' containment reference.
   * @see #setComponent(Component)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getStorageComponent_Component()
   * @model containment="true"
   * @generated
   */
  Component getComponent();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.StorageComponent#getComponent <em>Component</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Component</em>' containment reference.
   * @see #getComponent()
   * @generated
   */
  void setComponent(Component value);

  /**
   * Returns the value of the '<em><b>Capacity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Capacity</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Capacity</em>' containment reference.
   * @see #setCapacity(Capacity)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getStorageComponent_Capacity()
   * @model containment="true"
   * @generated
   */
  Capacity getCapacity();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.StorageComponent#getCapacity <em>Capacity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Capacity</em>' containment reference.
   * @see #getCapacity()
   * @generated
   */
  void setCapacity(Capacity value);

  /**
   * Returns the value of the '<em><b>Bandwidth</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bandwidth</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bandwidth</em>' containment reference.
   * @see #setBandwidth(Bandwidth)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getStorageComponent_Bandwidth()
   * @model containment="true"
   * @generated
   */
  Bandwidth getBandwidth();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.StorageComponent#getBandwidth <em>Bandwidth</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bandwidth</em>' containment reference.
   * @see #getBandwidth()
   * @generated
   */
  void setBandwidth(Bandwidth value);

} // StorageComponent
