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
 * A representation of the model object '<em><b>Paas Offering Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.PaasOfferingProfile#getPaasOfferingInfos <em>Paas Offering Infos</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.PaasOfferingProfile#getChannels <em>Channels</em>}</li>
 *   <li>{@link eu.cloud4soa.xtext.dsl.PaasOfferingProfile#getTechnology <em>Technology</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.cloud4soa.xtext.dsl.DslPackage#getPaasOfferingProfile()
 * @model
 * @generated
 */
public interface PaasOfferingProfile extends EObject
{
  /**
   * Returns the value of the '<em><b>Paas Offering Infos</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Paas Offering Infos</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Paas Offering Infos</em>' containment reference.
   * @see #setPaasOfferingInfos(PaasOfferingInfos)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getPaasOfferingProfile_PaasOfferingInfos()
   * @model containment="true"
   * @generated
   */
  PaasOfferingInfos getPaasOfferingInfos();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.PaasOfferingProfile#getPaasOfferingInfos <em>Paas Offering Infos</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Paas Offering Infos</em>' containment reference.
   * @see #getPaasOfferingInfos()
   * @generated
   */
  void setPaasOfferingInfos(PaasOfferingInfos value);

  /**
   * Returns the value of the '<em><b>Channels</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Channels</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Channels</em>' containment reference.
   * @see #setChannels(Channels)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getPaasOfferingProfile_Channels()
   * @model containment="true"
   * @generated
   */
  Channels getChannels();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.PaasOfferingProfile#getChannels <em>Channels</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Channels</em>' containment reference.
   * @see #getChannels()
   * @generated
   */
  void setChannels(Channels value);

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
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getPaasOfferingProfile_Technology()
   * @model containment="true"
   * @generated
   */
  TechnologyInfo getTechnology();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.PaasOfferingProfile#getTechnology <em>Technology</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Technology</em>' containment reference.
   * @see #getTechnology()
   * @generated
   */
  void setTechnology(TechnologyInfo value);

} // PaasOfferingProfile
