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
