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


package eu.cloud4soa.c4sgitservice.dao;

import eu.cloud4soa.c4sgitservice.datamodel.Paas;
import eu.cloud4soa.c4sgitservice.datamodel.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: pgouvas
 * Date: 8/29/12
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PaasRepository extends JpaRepository<Paas,Long> {

}
