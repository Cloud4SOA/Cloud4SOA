/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package c4soa.adapter;

import c4soa.resource.Application;
import eu.cloud4soa.adapter.rest.response.CreateApplicationResponse;
import eu.cloud4soa.adapter.rest.response.DeleteApplicationResponse;
import eu.cloud4soa.adapter.rest.response.UpdateApplicationResponse;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author pgouvas
 */
@Path("/adapter")
public class GenericAdapter {

    @POST
    @Path("/createApplication/{app}")
    @Produces({"application/json","application/xml","text/plain"}) 
    public CreateApplicationResponse createApplication(@PathParam("app") Application app){
        return new CreateApplicationResponse();
    }

    @DELETE
    @Path("/deleteApplication/{appid}")
    @Produces({"application/json","application/xml","text/plain"}) 
    public DeleteApplicationResponse deleteApplication(@PathParam("appid") String appid ){
          return new DeleteApplicationResponse();
    }    

    @POST
    @Path("/updateApplication/{appid}")
    @Produces({"application/json","application/xml","text/plain"}) 
    public UpdateApplicationResponse updateApplication(@PathParam("appid") String appid ){
        return new UpdateApplicationResponse();
    }    

    @GET
    @Path("/checkAppAvailability")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void checkAppAvailability(){

    }     
    
    @GET
    @Path("/listApplications")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void listApplications(){

    }     
    
    @GET
    @Path("/getAppVersions")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void getAppVersions(){

    }      
    
    @GET
    @Path("/getAppEnvironments")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void getAppEnvironments(){

    }          
    
    @GET
    @Path("/getRunningAppVersion")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void getRunningAppVersion(){

    }              
    
    @POST
    @Path("/createAppVersion")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void createAppVersion(){

    }   
    

    @DELETE
    @Path("/deleteAppVersion")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void deleteAppVersion(){

    }     

    @GET
    @Path("/getAppStatus")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void getAppStatus(){

    }     
    
    @GET
    @Path("/getAppStatistics")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void getAppStatistics(){

    }       

    @GET
    @Path("/getRunningStatus")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void getRunningStatus(){

    }    
    
    @GET
    @Path("/exportAppVersion")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void exportAppVersion(){

    }     
    
    @POST
    @Path("/deploy")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void deploy(){

    }   
    
    @POST
    @Path("/undeploy")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void undeploy(){

    }       
    
    @POST
    @Path("/start")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void start(){

    }       
    
    @POST
    @Path("/stop")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void stop(){

    } 
    
    @POST
    @Path("/createDB")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void createDB(){

    }     
    
    @GET
    @Path("/getDBList")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void getDBList(){

    }       
    
    @DELETE
    @Path("/deleteDB")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void deleteDB(){

    }     
    
    @GET
    @Path("/downloadDB")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void downloadDB(){

    }      
    
    @POST
    @Path("/restoreDB")
    @Produces({"application/json","application/xml","text/plain"}) 
    public void restoreDB(){

    }        
    
/*    
    @GET
    @Path("/order/{orderid}/{search:.*}")
    @Produces({"application/json","application/xml","text/plain"}) 
    public Application findItem(@PathParam("id") Long customerId, 
                         @PathParam("orderid") Long orderId,
                         @PathParam("search") String searchString,
                         @PathParam("search") List<PathSegment> searchList) {
        System.out.println("orderid: "+orderId);
        System.out.println("search: "+searchString);        
        //Application app = new Application( "app1", "type1") ;
        return app;
    }        
*/    
    
}//EoC