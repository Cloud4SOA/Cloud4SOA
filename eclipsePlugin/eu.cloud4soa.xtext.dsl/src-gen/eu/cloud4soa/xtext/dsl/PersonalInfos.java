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
 * A representation of the model object '<em><b>Personal Infos</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.PersonalInfos#getFirstName <em>First Name</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.PersonalInfos#getSurnName <em>Surn Name</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.PersonalInfos#getEmail <em>Email</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.PersonalInfos#getBirthDay <em>Birth Day</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.cloud4soa.xtext.dsl.DslPackage#getPersonalInfos()
 * @model
 * @generated
 */
public interface PersonalInfos extends EObject
{
  /**
   * Returns the value of the '<em><b>First Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First Name</em>' attribute.
   * @see #setFirstName(String)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getPersonalInfos_FirstName()
   * @model
   * @generated
   */
  String getFirstName();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.PersonalInfos#getFirstName <em>First Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First Name</em>' attribute.
   * @see #getFirstName()
   * @generated
   */
  void setFirstName(String value);

  /**
   * Returns the value of the '<em><b>Surn Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Surn Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Surn Name</em>' attribute.
   * @see #setSurnName(String)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getPersonalInfos_SurnName()
   * @model
   * @generated
   */
  String getSurnName();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.PersonalInfos#getSurnName <em>Surn Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Surn Name</em>' attribute.
   * @see #getSurnName()
   * @generated
   */
  void setSurnName(String value);

  /**
   * Returns the value of the '<em><b>Email</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Email</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Email</em>' attribute.
   * @see #setEmail(String)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getPersonalInfos_Email()
   * @model
   * @generated
   */
  String getEmail();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.PersonalInfos#getEmail <em>Email</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Email</em>' attribute.
   * @see #getEmail()
   * @generated
   */
  void setEmail(String value);

  /**
   * Returns the value of the '<em><b>Birth Day</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Birth Day</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Birth Day</em>' containment reference.
   * @see #setBirthDay(Birthday)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getPersonalInfos_BirthDay()
   * @model containment="true"
   * @generated
   */
  Birthday getBirthDay();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.PersonalInfos#getBirthDay <em>Birth Day</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Birth Day</em>' containment reference.
   * @see #getBirthDay()
   * @generated
   */
  void setBirthDay(Birthday value);

} // PersonalInfos
