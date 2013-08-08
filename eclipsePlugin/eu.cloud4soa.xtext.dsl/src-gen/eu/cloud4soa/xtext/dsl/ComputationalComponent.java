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
 * A representation of the model object '<em><b>Computational Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getComponent <em>Component</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getCores <em>Cores</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getSpeed <em>Speed</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getMemory <em>Memory</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getCache <em>Cache</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.cloud4soa.xtext.dsl.DslPackage#getComputationalComponent()
 * @model
 * @generated
 */
public interface ComputationalComponent extends EObject
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
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getComputationalComponent_Component()
   * @model containment="true"
   * @generated
   */
  Component getComponent();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getComponent <em>Component</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Component</em>' containment reference.
   * @see #getComponent()
   * @generated
   */
  void setComponent(Component value);

  /**
   * Returns the value of the '<em><b>Architecture</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Architecture</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Architecture</em>' containment reference.
   * @see #setArchitecture(Architecture)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getComputationalComponent_Architecture()
   * @model containment="true"
   * @generated
   */
  Architecture getArchitecture();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getArchitecture <em>Architecture</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Architecture</em>' containment reference.
   * @see #getArchitecture()
   * @generated
   */
  void setArchitecture(Architecture value);

  /**
   * Returns the value of the '<em><b>Cores</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cores</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cores</em>' containment reference.
   * @see #setCores(Cores)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getComputationalComponent_Cores()
   * @model containment="true"
   * @generated
   */
  Cores getCores();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getCores <em>Cores</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cores</em>' containment reference.
   * @see #getCores()
   * @generated
   */
  void setCores(Cores value);

  /**
   * Returns the value of the '<em><b>Speed</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Speed</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Speed</em>' containment reference.
   * @see #setSpeed(Speed)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getComputationalComponent_Speed()
   * @model containment="true"
   * @generated
   */
  Speed getSpeed();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getSpeed <em>Speed</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Speed</em>' containment reference.
   * @see #getSpeed()
   * @generated
   */
  void setSpeed(Speed value);

  /**
   * Returns the value of the '<em><b>Memory</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Memory</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Memory</em>' containment reference.
   * @see #setMemory(Memory)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getComputationalComponent_Memory()
   * @model containment="true"
   * @generated
   */
  Memory getMemory();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getMemory <em>Memory</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Memory</em>' containment reference.
   * @see #getMemory()
   * @generated
   */
  void setMemory(Memory value);

  /**
   * Returns the value of the '<em><b>Cache</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cache</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cache</em>' containment reference.
   * @see #setCache(Cache)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getComputationalComponent_Cache()
   * @model containment="true"
   * @generated
   */
  Cache getCache();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.ComputationalComponent#getCache <em>Cache</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cache</em>' containment reference.
   * @see #getCache()
   * @generated
   */
  void setCache(Cache value);

} // ComputationalComponent
