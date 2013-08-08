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
 * A representation of the model object '<em><b>Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.Provider#getProvider <em>Provider</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.Provider#getHomepage <em>Homepage</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.cloud4soa.xtext.dsl.DslPackage#getProvider()
 * @model
 * @generated
 */
public interface Provider extends EObject
{
  /**
   * Returns the value of the '<em><b>Provider</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Provider</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Provider</em>' attribute.
   * @see #setProvider(String)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getProvider_Provider()
   * @model
   * @generated
   */
  String getProvider();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.Provider#getProvider <em>Provider</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Provider</em>' attribute.
   * @see #getProvider()
   * @generated
   */
  void setProvider(String value);

  /**
   * Returns the value of the '<em><b>Homepage</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Homepage</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Homepage</em>' attribute.
   * @see #setHomepage(String)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getProvider_Homepage()
   * @model
   * @generated
   */
  String getHomepage();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.Provider#getHomepage <em>Homepage</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Homepage</em>' attribute.
   * @see #getHomepage()
   * @generated
   */
  void setHomepage(String value);

} // Provider
