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

import org.hibernate.annotations.Table;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: pgouvas
 * Date: 8/2/12
 * Time: 12:30 PM
 */

@Entity(name = "PUBKEY")
public class PubKey {

    @Id
    @GeneratedValue
    @Column(name = "PUBKEYID")
    private Long pubkeyid;

    @Column(name = "PUBKEY",length = 500)
    private String pubkey;

    @ManyToOne
    @JoinColumn(name = "USERID")
    private User user;

    public Long getPubkeyid() {
        return pubkeyid;
    }

    public void setPubkeyid(Long pubkeyid) {
        this.pubkeyid = pubkeyid;
    }

    public String getPubkey() {
        return pubkey;
    }

    public void setPubkey(String pubkey) {
        this.pubkey = pubkey;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PubKey{" +
                "pubkeyid=" + pubkeyid +
                ", pubkey='" + pubkey + '\'' +
                ", user=" + user +
                '}';
    }
}
