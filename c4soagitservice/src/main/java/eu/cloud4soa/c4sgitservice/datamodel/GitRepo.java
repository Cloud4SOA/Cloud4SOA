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

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: pgouvas
 * Date: 8/3/12
 * Time: 7:45 AM
 */
@Entity(name = "GITREPO")
public class GitRepo {

    @Id
    @GeneratedValue
    @Column(name = "GITREPOID")
    private Long  gitrepoid;

    @Column(name = "GITURL")
    private String  giturl;

    @Column(name = "GITREPO")
    private String  gitrepo;

    @ManyToOne
    @JoinColumn(name = "USERID")
    private User user;


    @ManyToOne
    @JoinColumn(name = "PAASID")
    private Paas paas;


    public Paas getPaas() {
        return paas;
    }

    public void setPaas(Paas paas) {
        this.paas = paas;
    }

    public Long getGitrepoid() {
        return gitrepoid;
    }

    public void setGitrepoid(Long gitrepoid) {
        this.gitrepoid = gitrepoid;
    }

    public String getGiturl() {
        return giturl;
    }

    public void setGiturl(String giturl) {
        this.giturl = giturl;
    }

    public String getGitrepo() {
        return gitrepo;
    }

    public void setGitrepo(String gitrepo) {
        this.gitrepo = gitrepo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
