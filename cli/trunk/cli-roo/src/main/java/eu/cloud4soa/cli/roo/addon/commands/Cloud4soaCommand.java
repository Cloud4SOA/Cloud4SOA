/*
 *  Copyright 2013 Cloud4SOA, www.cloud4soa.eu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cloud4soa.cli.roo.addon.commands;

/**
 *
 * @author frarav
 */
public abstract class Cloud4soaCommand {
    
    protected String failureMessage = "";
    protected String successMessage = "";
    protected String gerund;
    protected boolean displaySuccessMessage = true;
    
    

    
    
    protected Cloud4soaCommand(final String failureMessage, final String successMessage, final String gerund) {
            this.failureMessage = failureMessage;
            this.successMessage = successMessage;
            this.gerund = gerund;
    }

    
    
    protected Cloud4soaCommand(final String failureMessage, final String successMessage) {
            this(failureMessage, successMessage, "Performing operation");
    }

    
    
    protected Cloud4soaCommand(final String failureMessage) {
            this(failureMessage, null);
    }

    
   
    public abstract void execute() throws Exception;

    
    
    public String getFailureMessage() {
            return failureMessage;
    }

    
    
    public String getSuccessMessage() {
            return successMessage;
    }

    
    
    public String getGerund() {
            return gerund;
    }

    
    
    public boolean isDisplaySuccessMessage() {
            return displaySuccessMessage;
    }


}