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
 * A representation of the model object '<em><b>Application Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.ApplicationProfile#getInfos <em>Infos</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.ApplicationProfile#getFile <em>File</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.ApplicationProfile#getTechnology <em>Technology</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.cloud4soa.xtext.dsl.DslPackage#getApplicationProfile()
 * @model
 * @generated
 */
public interface ApplicationProfile extends EObject
{
  /**
   * Returns the value of the '<em><b>Infos</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Infos</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Infos</em>' containment reference.
   * @see #setInfos(ApplicationInfos)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getApplicationProfile_Infos()
   * @model containment="true"
   * @generated
   */
  ApplicationInfos getInfos();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.ApplicationProfile#getInfos <em>Infos</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Infos</em>' containment reference.
   * @see #getInfos()
   * @generated
   */
  void setInfos(ApplicationInfos value);

  /**
   * Returns the value of the '<em><b>File</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>File</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>File</em>' containment reference.
   * @see #setFile(File)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getApplicationProfile_File()
   * @model containment="true"
   * @generated
   */
  File getFile();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.ApplicationProfile#getFile <em>File</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File</em>' containment reference.
   * @see #getFile()
   * @generated
   */
  void setFile(File value);

  /**
   * Returns the value of the '<em><b>Technology</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Technology</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Technology</em>' containment reference.
   * @see #setTechnology(TechnologyInfo)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getApplicationProfile_Technology()
   * @model containment="true"
   * @generated
   */
  TechnologyInfo getTechnology();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.ApplicationProfile#getTechnology <em>Technology</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Technology</em>' containment reference.
   * @see #getTechnology()
   * @generated
   */
  void setTechnology(TechnologyInfo value);

} // ApplicationProfile
