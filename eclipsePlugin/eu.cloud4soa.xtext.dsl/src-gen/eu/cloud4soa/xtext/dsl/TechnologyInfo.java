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
 * A representation of the model object '<em><b>Technology Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.TechnologyInfo#getProgrammingLanguage <em>Programming Language</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.TechnologyInfo#getSoftware <em>Software</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.TechnologyInfo#getHardware <em>Hardware</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.cloud4soa.xtext.dsl.DslPackage#getTechnologyInfo()
 * @model
 * @generated
 */
public interface TechnologyInfo extends EObject
{
  /**
   * Returns the value of the '<em><b>Programming Language</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Programming Language</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Programming Language</em>' containment reference.
   * @see #setProgrammingLanguage(ProgrammingLanguage)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getTechnologyInfo_ProgrammingLanguage()
   * @model containment="true"
   * @generated
   */
  ProgrammingLanguage getProgrammingLanguage();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.TechnologyInfo#getProgrammingLanguage <em>Programming Language</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Programming Language</em>' containment reference.
   * @see #getProgrammingLanguage()
   * @generated
   */
  void setProgrammingLanguage(ProgrammingLanguage value);

  /**
   * Returns the value of the '<em><b>Software</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Software</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Software</em>' containment reference.
   * @see #setSoftware(Software)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getTechnologyInfo_Software()
   * @model containment="true"
   * @generated
   */
  Software getSoftware();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.TechnologyInfo#getSoftware <em>Software</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Software</em>' containment reference.
   * @see #getSoftware()
   * @generated
   */
  void setSoftware(Software value);

  /**
   * Returns the value of the '<em><b>Hardware</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hardware</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hardware</em>' containment reference.
   * @see #setHardware(Hardware)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getTechnologyInfo_Hardware()
   * @model containment="true"
   * @generated
   */
  Hardware getHardware();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.TechnologyInfo#getHardware <em>Hardware</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Hardware</em>' containment reference.
   * @see #getHardware()
   * @generated
   */
  void setHardware(Hardware value);

} // TechnologyInfo
