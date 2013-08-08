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


package eu.cloud4soa.c4sgitservice.datamodel;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: pgouvas
 * Date: 8/2/12
 * Time: 12:30 PM
 */

@Entity(name="C4sUser")
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long userId;

    @Column(name = "USERNAME")
    private String username;
    
    @Column(name = "PASSWORD")
    private String password;

    //If the comment below is activated then a JOIN USER_PUBKEY is created
    //@OneToMany(fetch = FetchType.LAZY)
    //private Set<PubKey> pubkeys;

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Set<PubKey> getPubkeys() {
//        return pubkeys;
//    }
//
//    public void setPubkeys(Set<PubKey> pubkeys) {
//        this.pubkeys = pubkeys;
//    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}  //EoClass
