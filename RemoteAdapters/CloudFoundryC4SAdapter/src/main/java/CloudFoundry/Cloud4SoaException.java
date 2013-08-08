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


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cloudfoundry;

/**
 *
 * @author jled
 */
public class Cloud4SoaException extends Exception {

    String msg;

//----------------------------------------------
// Default constructor - initializes instance variable to unknown

  public Cloud4SoaException()
  {
    super();             // call superclass constructor
    msg = "Error caused in Cloud4SOA Adapter";
  }

//-----------------------------------------------
// Constructor that receives some kind of message that is saved in an instance variable.
  public Cloud4SoaException(String err)
  {
    super(err);     // call super class constructor
    msg = err;  // save message
  }


//------------------------------------------------
// public method, callable by exception catcher. It returns the error message.

  public String getError()
  {
    return msg;
  }


}

