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


package c4soa.adapter;

import eu.cloud4soa.adapter.rest.response.*;
import javax.ws.rs.*;

/**
 *
 * @author pgouvas
 */
/**
 *
 * @author pgouvas
 */


//deprecated
//methods moved to class Adapter
@Path("/c4sDB")
public class Database {

    @GET
    @Path("/ems/database")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void getDBList(){

    }   
    
    @GET
    @Path("/ems/database/{dbid}")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void getDatabaseDetails(@PathParam("dbid") String dbid){

    }       
    
    @POST
    @Path("/ems/database/{db}")
    @Produces({"application/json","application/xml","text/plain"}) 
    public CreateDatabaseResponse createDatabase(@PathParam("db") c4soa.resource.Database db){
        return new CreateDatabaseResponse();
    }

    @PUT
    @Path("/ems/database/{db}")
    @Produces({"application/json","application/xml","text/plain"}) 
    public UpdateDatabaseResponse updateDatabase(@PathParam("app") c4soa.resource.Database db){
        return new UpdateDatabaseResponse();
    }    
    
    @DELETE
    @Path("/ems/database/{dbid}")
    @Produces({"application/json","application/xml","text/plain"}) 
    public DeleteDatabaseResponse deleteDatabase(@PathParam("dbid") String dbid ){
          return new DeleteDatabaseResponse();
    }       
    
}
