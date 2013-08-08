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
 * A representation of the model object '<em><b>Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.cloud4soa.xtext.dsl.Box#getBox <em>Box</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.cloud4soa.xtext.dsl.DslPackage#getBox()
 * @model
 * @generated
 */
public interface Box extends EObject
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
   * @see #setBox(BoxComponent)
   * @see eu.cloud4soa.xtext.dsl.DslPackage#getBox_Box()
   * @model containment="true"
   * @generated
   */
  BoxComponent getBox();

  /**
   * Sets the value of the '{@link eu.cloud4soa.xtext.dsl.Box#getBox <em>Box</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Box</em>' containment reference.
   * @see #getBox()
   * @generated
   */
  void setBox(BoxComponent value);

} // Box
