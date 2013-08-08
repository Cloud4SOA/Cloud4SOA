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
 * A representation of the model object '<em><b>Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.Scope#getUserProfile <em>User Profile</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.Scope#getApplicationProfile <em>Application Profile</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.Scope#getPaasOfferingProfile <em>Paas Offering Profile</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.cloud4soa.xtext.dsl.DslPackage#getScope()
 * @model
 * @generated
 */
public interface Scope extends EObject
{
  /**
   * Returns the value of the '<em><b>User Profile</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>User Profile</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>User Profile</em>' containment reference.
   * @see #setUserProfile(UserProfile)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getScope_UserProfile()
   * @model containment="true"
   * @generated
   */
  UserProfile getUserProfile();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.Scope#getUserProfile <em>User Profile</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Profile</em>' containment reference.
   * @see #getUserProfile()
   * @generated
   */
  void setUserProfile(UserProfile value);

  /**
   * Returns the value of the '<em><b>Application Profile</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Application Profile</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Application Profile</em>' containment reference.
   * @see #setApplicationProfile(ApplicationProfile)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getScope_ApplicationProfile()
   * @model containment="true"
   * @generated
   */
  ApplicationProfile getApplicationProfile();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.Scope#getApplicationProfile <em>Application Profile</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Application Profile</em>' containment reference.
   * @see #getApplicationProfile()
   * @generated
   */
  void setApplicationProfile(ApplicationProfile value);

  /**
   * Returns the value of the '<em><b>Paas Offering Profile</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Paas Offering Profile</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Paas Offering Profile</em>' containment reference.
   * @see #setPaasOfferingProfile(PaasOfferingProfile)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getScope_PaasOfferingProfile()
   * @model containment="true"
   * @generated
   */
  PaasOfferingProfile getPaasOfferingProfile();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.Scope#getPaasOfferingProfile <em>Paas Offering Profile</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Paas Offering Profile</em>' containment reference.
   * @see #getPaasOfferingProfile()
   * @generated
   */
  void setPaasOfferingProfile(PaasOfferingProfile value);

} // Scope
