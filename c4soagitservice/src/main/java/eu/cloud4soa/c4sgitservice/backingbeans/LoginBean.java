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


package eu.cloud4soa.c4sgitservice.backingbeans;

/**
 *
 * @author Panagiotis Gouvas
 */

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;

import eu.cloud4soa.c4sgitservice.dao.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
//TODO add a maven profile that includes the JSF libaries in Tomcat
//@Scope(value = "request")
//@ManagedBean
//@RequestScoped
public class LoginBean {
    
    protected final Log log = LogFactory.getLog(getClass());
    
    @Autowired
    private UserRepository userdao;
    
    private String username;
    private String password;


    public String validateUser() {
        log.info("validateUser() invoked with username:"+getUsername()+" and password:"+getPassword());
        if (userdao==null){
            System.out.println("userdao is NULL");
        } else {
            System.out.println("count: "+userdao.count());
        }        
        return "ok";
    }//EoM validateUser

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
   

}//EoClass
