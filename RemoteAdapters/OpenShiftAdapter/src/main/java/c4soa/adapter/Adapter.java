package c4soa.adapter;

import com.openshift.client.OpenShiftException;
import openshift.Openshift_Aux;
import openshift.OpenshiftCredentials;
import eu.cloud4soa.adapter.rest.common.HttpStatus;
import eu.cloud4soa.adapter.rest.response.*;
import eu.cloud4soa.adapter.rest.request.*;
import eu.cloud4soa.adapter.rest.response.model.Application;
import eu.cloud4soa.adapter.rest.response.model.Database;
import eu.cloud4soa.adapter.rest.response.model.Module;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import openshift.Cloud4SoaException;
import org.apache.cxf.jaxrs.ext.MessageContext;

/**
 *
 * @author pgouvas
 */
/**
 *
 * @author pgouvas
 */
@Path("/c4s")
public class Adapter {

    @Context
    private MessageContext context;

    private static String username = "";
    private static String password = "";
    private static String id = "";//it must be empty      

    
    
        private void headerProcessing() throws Exception{
        HttpHeaders headers = context.getHttpHeaders();
        List<String> api_key_list = headers.getRequestHeader("apiKey");
        boolean header_tricks=true;
        if(header_tricks==true){
        System.out.println("listappheader_api:" + api_key_list);
        String api_as_string = api_key_list.get(0);
        System.out.println("api_as_string:" + api_as_string);
        String splitedStr[] = api_as_string.split("_");
        username = splitedStr[0];
        password = splitedStr[1];

        System.out.println("username---" + username);
        System.out.println("password---" + password);
        }else{
        String api_as_string = api_key_list.get(0);
        List<String> secret_key_list = headers.getRequestHeader("secretKey");
        System.out.println("listappheader_api:" + secret_key_list);
        String secret_as_string = secret_key_list.get(0);
        System.out.println("secret_as_string:" + secret_as_string);
        username = api_as_string;            
        password = secret_as_string;            
        }
        
        }
    
    
    @GET
    @Path("/ems/application")
    @Produces({"application/json", "application/xml", "text/plain"})
    public ListApplicationResponse listApplications() {

        return new ListApplicationResponse();
    }

    @GET
    @Path("/ems/application/{appid}")
    @Produces({"application/json", "application/xml", "text/plain"})
    //public void getApplicationDetails(@PathParam("appid") String appid){
    public ApplicationResponse getApplicationDetails(@PathParam("appid") String appid) {
        ApplicationResponse response=new  ApplicationResponse();
            String msg = "nothing executed";

        try {
            headerProcessing();
                
              Openshift_Aux oshift = new Openshift_Aux(username,password);

              //oshift.createUser(username, password);
              String name =oshift.getApplicationName(appid);
              String url =oshift.getApplicationUrl(appid);
              System.out.println("url::"+url);
            Application appl= new Application();
            appl.setApplicationName(name);
            appl.setRepository(url);
            response.setApplication(appl);
        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatusCode(HttpStatus.Expectation_Failed);
            System.out.println("exception msg:"+ex.getMessage());
            System.out.println("exception stack:"+ex.getStackTrace()[0]);
            javax.ws.rs.core.Response.ResponseBuilder builder = javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while getting application details.Log from OpenShift:" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");
            throw new WebApplicationException(builder.build());

        }           
            return response;
 


    }

    
    
    
    @POST
    @Path("/ems/application/{appid}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public CreateApplicationResponse createApplication(@PathParam("appid") String appid) {
         CreateApplicationResponse createappResponse=new CreateApplicationResponse();
        //Application appl= new Application();

        System.out.println("lolololo");
      
          String git_uri=""; 
          try {
            headerProcessing();              
            Openshift_Aux oshift = new Openshift_Aux(username,password);
            //Application appl = oshift.createApplicationPython(appid);
            Application appl = oshift.createApplicationPython(appid);
              //String name =oshift.getApplicationName(appid);
              //String url =oshift.getApplicationUrl(appid); 
              //appl.setApplicationName(name);
              //appl.setRepository(url);
            createappResponse.setApplication(appl);
            
        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            createappResponse.setStatusCode(HttpStatus.Expectation_Failed);
            System.out.println("exception msg:"+ex.getMessage());
            System.out.println("exception stack:"+ex.getStackTrace()[0]);
            javax.ws.rs.core.Response.ResponseBuilder builder = javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while creating application.Log from OpenShift:" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");
            throw new WebApplicationException(builder.build());

        }

        
        
     return  createappResponse; 
    }


    //changed get to post in order to agree with adapter rest operation response
    @POST
    @Path("/ems/application/{appid}/operation/{op}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public OperationResponse StartStopApplication(@PathParam("appid") String appid, @PathParam("op") String operation) {

        String msg = "";
        OperationResponse response = new OperationResponse();
        Openshift_Aux oshift = new Openshift_Aux(username,password);

        try {        
            headerProcessing();
            //START
            if (operation.equalsIgnoreCase("START")) {
            oshift.startApplication(appid);
            }
            //STOP     
            else if (operation.equalsIgnoreCase("STOP")) {
            oshift.stopApplication(appid);    
            }
            else{
             msg="Operation Not Found";   
            }
            
            response.setMessage(msg);
            response.setStatusCode(HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatusCode(HttpStatus.Expectation_Failed);
            System.out.println("exception msg:"+ex.getMessage());
            System.out.println("exception stack:"+ex.getStackTrace()[0]);
            javax.ws.rs.core.Response.ResponseBuilder builder = javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while modifying status of application.Log from OpenShift:" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");
            throw new WebApplicationException(builder.build());

        }

        System.out.println("returned message:" + msg);




        return response;
    }   
    
    @PUT
    @Path("/ems/application/{app}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public UpdateApplicationResponse updateApplication(@PathParam("app") c4soa.resource.Application app) {
        return new UpdateApplicationResponse();
    }

    @DELETE
    @Path("/ems/application/{appid}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public DeleteApplicationResponse deleteApplication(@PathParam("appid") String appid) {


        String msg = "nothing executed";
        DeleteApplicationResponse del_response=new DeleteApplicationResponse();

       try {
            headerProcessing();
                
            Openshift_Aux oshift = new Openshift_Aux(username,password);
                oshift.deleteApplication(appid);
                        del_response.setStatusCode(HttpStatus.OK);

            } catch (OpenShiftException ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            del_response.setStatusCode(HttpStatus.Expectation_Failed);
            System.out.println("exception msg:"+ex.getMessage());
            System.out.println("exception stack:"+ex.getStackTrace()[0]);
            javax.ws.rs.core.Response.ResponseBuilder builder = javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while deleting application(OpenShiftException).Log from OpenShift:" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");
            throw new WebApplicationException(builder.build());
            
            } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            del_response.setStatusCode(HttpStatus.Expectation_Failed);
            System.out.println("exception msg:"+ex.getMessage());
            System.out.println("exception stack:"+ex.getStackTrace()[0]);
            javax.ws.rs.core.Response.ResponseBuilder builder = javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while deleting application.Log from OpenShift:" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");
            throw new WebApplicationException(builder.build());

        }
        

        del_response.setMessage("application "+appid);
        return del_response;
              
              
    }

    //@Path("/ems/application/{appid}/deployment/{deploymentName}/database/{db}/databaseUser/{dbUser}/databasePassword/{dbPassword}/databaseType/{dbType}")
    @POST
    @Path("/ems/application/{appid}/deployment/{deploymentName}/database/{db}")
    @Produces({"application/json", "application/xml", "text/plain"})
    @Consumes(MediaType.APPLICATION_JSON)
    public CreateDatabaseResponse createDatabase(@PathParam("appid") String appid, @PathParam("deploymentName") String deploymentName, @PathParam("db") String db, CreateDatabaseRequest cdr) {
        CreateDatabaseResponse createDB = new CreateDatabaseResponse();
        try {
        headerProcessing();

        Openshift_Aux oshift = new Openshift_Aux(username,password);
        String stringResponse = oshift.createDatabase(appid);
        Database database = oshift.extractInfoFromLog(stringResponse);
        createDB.setDatabase(database);
        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            javax.ws.rs.core.Response.ResponseBuilder builder = javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while creating database.Log from openshift:" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");
            throw new WebApplicationException(builder.build());
        }

        return createDB;
    }  
    
    @POST
    @Path("/ems/sshkey")
    @Produces({"application/json", "application/xml", "text/plain"})
    public CreateSSHKeyResponse createSSHKeyRequest( CreateSSHKeyRequest keyreq) {
        try{
            headerProcessing();

            Openshift_Aux oshift = new Openshift_Aux(username,password);
            oshift.create(keyreq.getSshKey(),keyreq.getApiKey());
            } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            javax.ws.rs.core.Response.ResponseBuilder builder = javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while creating database.Log from openshift:" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");
            throw new WebApplicationException(builder.build());
        }
        
        return new CreateSSHKeyResponse();
    }    
    
        public static void main(String[] args) {
        
            try{
            //headerProcessing();
            username="g.ledakis@gmail.com";
            password="!depR66!";
            Openshift_Aux oshift = new Openshift_Aux(username,password);
            oshift.create("dsdsdsdsd","ddsdsdsdsadas");
            } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            javax.ws.rs.core.Response.ResponseBuilder builder = javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while creating database.Log from openshift:" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");
            throw new WebApplicationException(builder.build());
        }
        
    }  
}
