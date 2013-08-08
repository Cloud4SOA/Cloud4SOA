/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openshift;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.openshift.client.*;
//import com.openshift.client.IUser;
import com.openshift.internal.client.Cartridge;
import com.openshift.internal.client.UserResource;
import java.io.IOException;
//import org.jboss.tools.openshift.express.client.*;
//import org.jboss.tools.openshift.express.client.User;
import eu.cloud4soa.adapter.rest.response.model.Database;
import eu.cloud4soa.adapter.rest.response.model.Application;
import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import org.apache.cxf.helpers.FileUtils;

/**
 *
 * @author jled
 */
public class Openshift_Aux {

    String id = "";
    String username = "";
    String password = "";
    String passPhrase = "";

    public Openshift_Aux() {
    }

    public Openshift_Aux(String openshift_id, String openshift_username, String openshift_password) {
        id = openshift_id;
        username = openshift_username;
        password = openshift_password;
    }

    public Openshift_Aux(String openshift_username, String openshift_password) {
        username = openshift_username;
        password = openshift_password;
    }
    
    

    

    
    public static void main(String[] args) throws Exception {
        Openshift_Aux aux = new Openshift_Aux();
        aux.getApplicationUrl("c4sapp2");
    }
    ///////////uncomment for 2.3.0

    public void test(String applicationName) throws Exception {


        try {

            Cartridge crt = new Cartridge(username);

            final IOpenShiftConnection connection =
                    new OpenShiftConnectionFactory().getConnection(id, username, password);
            IUser user = connection.getUser();
            System.out.println("11");
            //  ISSHPublicKey sshKey = SSHKeyPair.create(passPhrase, privateKeyPath, publicKeyPath);
            System.out.println("22");
            IDomain domain = user.getDefaultDomain();
            System.out.println("33");
            IApplication application = domain.createApplication(applicationName, ICartridge.JBOSSAS_7);
            //IApplication application = user.createApplication(applicationName, ICartridge.JBOSSAS_7);
            System.out.println("44--Application Created");
            application.start();
            System.out.println("55--Application started");


            // IApplication application = user.getApplicationByName(applicationName);
            //ICartridge cartridge = application.getCartridge();
            // cartridge.getName();

            System.out.println(application.getApplicationUrl());
            System.out.println(application.getName());
            System.out.println("gituri" + application.getGitUrl());
            System.out.println("66--Application geturl");

        } catch (OpenShiftException ex) {
            Logger.getLogger(Openshift_Aux.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Application createApplication(String applicationName) throws OpenShiftException {
        Boolean created = false;
        Application app = new Application();

        final IOpenShiftConnection connection =
                new OpenShiftConnectionFactory().getConnection(id, username, password);
        IUser user = connection.getUser();
        IDomain domain = user.getDefaultDomain();

        IApplication application = domain.createApplication(applicationName, ICartridge.JBOSSAS_7);
        System.out.println("OpenShift API createApplication called");
        app.setApplicationName(application.getName());
        app.setUrl(application.getApplicationUrl());
        app.setRepository(application.getGitUrl());
        app.setCreated(application.getCreationTime().toString());
        

        return app;

    }//eom createApplication

    public Application createApplicationPython(String applicationName) throws OpenShiftException {
        Boolean created = false;
        Application app = new Application();

        final IOpenShiftConnection connection =
                new OpenShiftConnectionFactory().getConnection(id, username, password);
        IUser user = connection.getUser();
        IDomain domain = user.getDefaultDomain();

        IApplication application = domain.createApplication(applicationName, ICartridge.PYTHON_26);
        System.out.println("OpenShift API createApplication called");
        app.setApplicationName(application.getName());
        app.setUrl(application.getApplicationUrl());
        app.setRepository(application.getGitUrl());
        app.setCreated(application.getCreationTime().toString());
        

        return app;

    }//eom createApplicationPython

    
    public Application createApplicationPHP(String applicationName) throws OpenShiftException {
        Boolean created = false;
        Application app = new Application();

        final IOpenShiftConnection connection =
                new OpenShiftConnectionFactory().getConnection(id, username, password);
        IUser user = connection.getUser();
        IDomain domain = user.getDefaultDomain();

        IApplication application = domain.createApplication(applicationName, ICartridge.PHP_53);
        System.out.println("OpenShift API createApplicationPHP called");
        app.setApplicationName(application.getName());
        app.setUrl(application.getApplicationUrl());
        app.setRepository(application.getGitUrl());
        app.setCreated(application.getCreationTime().toString());
        

        return app;

    }//eom createApplicationPHP

    public String getApplicationUrl(String applicationName) throws OpenShiftException {
        String ret = "";

        final IOpenShiftConnection connection =
                new OpenShiftConnectionFactory().getConnection(id, username, password);
        IUser user = connection.getUser();
        IDomain domain = user.getDefaultDomain();
        IApplication application = domain.getApplicationByName(applicationName);
        System.out.println("OpenShift API getApplicationByName called-url");
        ret = application.getApplicationUrl();



        return ret;

    }//eom getApplicationUrl

    public String getApplicationName(String applicationName) throws OpenShiftException {
        String ret = "";

        final IOpenShiftConnection connection =
                new OpenShiftConnectionFactory().getConnection(id, username, password);
        IUser user = connection.getUser();
        IDomain domain = user.getDefaultDomain();;
        IApplication application = domain.getApplicationByName(applicationName);
        System.out.println("OpenShift API getApplicationByName called-name");
        ret = application.getName();


        return ret;

    }//eom getApplicationName

    //mallon prepei na parw to git kai na kanw push
    public String deploy(String applicationName) throws OpenShiftException {
        String ret = "";

        final IOpenShiftConnection connection =
                new OpenShiftConnectionFactory().getConnection(id, username, password);
        IUser user = connection.getUser();
        IDomain domain = user.getDefaultDomain();;
        IApplication application = domain.getApplicationByName(applicationName);
        System.out.println("OpenShift API getApplicationByName called-git");
        System.out.println(application.getGitUrl());
        ret = application.getGitUrl();
        //TODO///
        ///git push



        return ret;

    }//eom getApplicationName

    public String startApplication(String applicationName) throws OpenShiftException {
        String ret = "";

        final IOpenShiftConnection connection =
                new OpenShiftConnectionFactory().getConnection(id, username, password);
        IUser user = connection.getUser();
        IDomain domain = user.getDefaultDomain();;
        IApplication application = domain.getApplicationByName(applicationName);
        System.out.println("OpenShift API getApplicationByName called-start");
        application.start();
        System.out.println("OpenShift API start called " + applicationName);



        return ret;

    }//eom startApplication

    public String stopApplication(String applicationName) throws OpenShiftException {
        String ret = "";

        final IOpenShiftConnection connection =
                new OpenShiftConnectionFactory().getConnection(id, username, password);
        IUser user = connection.getUser();
        IDomain domain = user.getDefaultDomain();;
        IApplication application = domain.getApplicationByName(applicationName);
        System.out.println("OpenShift API getApplicationByName called-stop");
        application.stop();
        System.out.println("OpenShift API stop called " + applicationName);



        return ret;

    }//eom stopApplication

    public String deleteApplication(String applicationName) throws OpenShiftException {
        String ret = "";

        final IOpenShiftConnection connection =
                new OpenShiftConnectionFactory().getConnection(id, username, password);
        IUser user = connection.getUser();
        IDomain domain = user.getDefaultDomain();;
        IApplication application = domain.getApplicationByName(applicationName);
        System.out.println("OpenShift API getApplicationByName called-delete");
        application.destroy();
        System.out.println("OpenShift API destroy called " + applicationName);



        return ret;

    }//eom deleteApplication

    public IUser createUser(String username, String password) throws OpenShiftException {
        IUser user = null;

        final IOpenShiftConnection connection =
                new OpenShiftConnectionFactory().getConnection(id, username, password);
        user = connection.getUser();
        System.out.println("username:" + user.getAuthIV());


        return user;
    }

    public String createDomain(String domainName, String passPhrase, String privateKeyPath, String publicKeyPath) throws OpenShiftException {
        String ret = "";

        final IOpenShiftConnection connection =
                new OpenShiftConnectionFactory().getConnection(id, username, password);
        IUser user = connection.getUser();
        //ISSHPublicKey sshKey = SSHKeyPair.create(passPhrase, privateKeyPath, publicKeyPath);

        IDomain domain = user.createDomain(domainName);;
        System.out.println("OpenShift API createDomain called");

        return ret;

    }//eom createapplication

    public String createDatabase(String applicationName) throws OpenShiftException {
        Database db = new Database();
        final IOpenShiftConnection connection =
                new OpenShiftConnectionFactory().getConnection(id, username, password);
        IUser user = connection.getUser();
        IDomain domain = user.getDefaultDomain();
        IApplication application = domain.getApplicationByName(applicationName);
        System.out.println("1");
        // operation

        IEmbeddedCartridge embeddedCartridge = application.addEmbeddableCartridge(IEmbeddableCartridge.MYSQL_51);
        String dburl = embeddedCartridge.getUrl();
       // System.out.println(dburl);
        String log = embeddedCartridge.getCreationLog();
        System.out.println("log:" + log);
        System.out.println("tostring:"+embeddedCartridge.toString());
        System.out.println("2");


        return log;
    }

    public Database getMysqlDatabaseCredentials(String applicationName) throws OpenShiftException {
        Database db = new Database();
        
        
        final IOpenShiftConnection connection =
                new OpenShiftConnectionFactory().getConnection(id, username, password);
        IUser user = connection.getUser();
        IDomain domain = user.getDefaultDomain();
        IApplication application = domain.getApplicationByName(applicationName);
        System.out.println("1");
        // operation
        if (application.hasEmbeddedCartridge(IEmbeddableCartridge.MYSQL_51)) {
            IEmbeddedCartridge embeddedCartridge = application.getEmbeddedCartridge(IEmbeddableCartridge.MYSQL_51);
            String url=embeddedCartridge.getUrl();
            System.out.println("url:"+url);
            System.out.println("log:"+embeddedCartridge.getCreationLog());
            System.out.println("tostring"+embeddedCartridge.toString());
            try{
            //url:mysql://127.3.153.1:3306/    
            String splitedStr1[] = url.split("mysql://");
            String splitedStr2[] = splitedStr1[1].split(":");
            String dbHost=splitedStr2[0].trim();
             String dbPort=splitedStr2[1].replace("/", "").trim();
            System.out.println("dbHost:"+dbHost);
                        
            db.setHost(dbHost);
            db.setPort(dbPort);
            db.setDatabaseName(applicationName);
            
            }catch(Exception ex){
            throw new OpenShiftException("Information could not been retrieved due to log formating.:"+url+".Exception :"+ex.getMessage());
            }
            

        }
    return db;
    }

    public Database extractInfoFromLog(String log) throws OpenShiftException {
        Database db = new Database();
        
        try{
        
        String splitedStr1[] = log.split("Root User:");
        String splitedStr2[] = splitedStr1[1].split("\\n");
        String dbUsername=splitedStr2[0].trim();
            System.out.println("dbUsername:"+dbUsername);
        
        String splitedStr3[] = log.split("Root Password:");
        String splitedStr4[] = splitedStr3[1].split("\\n");
        String dbPassword=splitedStr4[0].trim();
            System.out.println("dbPassword:"+dbPassword);
            
        String splitedStr5[] = log.split("credentials above.");
        String splitedStr6[] = splitedStr5[1].split("mysql://");
        String splitedStr7[] = splitedStr6[1].split(":");
        String dbHost=splitedStr7[0].trim();
        String dbPort=splitedStr7[1].replace("/", "").trim();
            System.out.println("dbHost:"+dbHost+"");
                
        String splitedStr8[] = log.split("Database Name:");
        String splitedStr9[] = splitedStr8[1].split("\\n");
        String dbName=splitedStr9[0].trim();
            System.out.println("dbName:"+dbName);
        db.setUserName(dbUsername);
        db.setPassword(dbPassword);
        db.setHost(dbHost);
        db.setPort(dbPort);
        db.setDatabaseName(dbName);
        
        }catch(Exception ex){
            //if Exception occured while trying to read info from the log, send the log unedited
            throw new OpenShiftException("DB created, but info could not been retrieved due to log formating. Here is the unedited log:"+log+". Exception :"+ex.getMessage());
        }

        return db;
    }
    
    
        ///SSH KEY from File
    public Boolean createSSHKey( String passPhrase, String privateKeyPath, String publicKeyPath, String keyName) throws OpenShiftException {
        Boolean ret = false;
        try{
        final IOpenShiftConnection connection =
                new OpenShiftConnectionFactory().getConnection(id, username, password);
        IUser user = connection.getUser();
        System.out.println("user:"+user.toString());
        ISSHPublicKey sshKey = SSHKeyPair.create(passPhrase, privateKeyPath, publicKeyPath);
        System.out.println("key created");
        user.putSSHKey(keyName, sshKey);
        System.out.println("key added");
        ret=true;
        }catch(Exception ex){
            //if Exception occured while trying to read info from the log, send the log unedited
            ret=false;
            throw new OpenShiftException("Error while deleting key. "+". Exception :"+ex.getMessage());
        }

        return ret;

    }
        ///Delete SSH KEY
    public Boolean deleteSSHKey( String keyName) throws OpenShiftException {
        Boolean ret = false;
        try{
        final IOpenShiftConnection connection =
                new OpenShiftConnectionFactory().getConnection(id, username, password);
        IUser user = connection.getUser();
        user.deleteKey(keyName);
        ret= true;
        }catch(Exception ex){
            //if Exception occured while trying to read info from the log, send the log unedited
            ret=false;
            throw new OpenShiftException("Error while deleting key. "+". Exception :"+ex.getMessage());
        }

        
        return ret;

    }
    
    
    
        ///SSH KEY pair from String
	public static SSHKeyPair create(String privateKey,String publicKey) throws IOException, OpenShiftException {
		File privateKeyFile = File.createTempFile(createRandomString(), null);
		writeTo(privateKey, privateKeyFile);

		File publicKeyFile = File.createTempFile(createRandomString(), null);
		writeTo(publicKey, publicKeyFile);
		
		return SSHKeyPair.load(privateKeyFile.getAbsolutePath(), publicKeyFile.getAbsolutePath());
	}    
	private static String createRandomString() {
		return String.valueOf(System.currentTimeMillis());
	}
        
        public static void writeTo(String data, File file) throws IOException {
		StringReader reader = null;
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			reader = new StringReader(data);
			for (int character = -1; (character = reader.read()) != -1;) {
				writer.write(character);
			}
		} finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
			if (reader != null) {
				reader.close();
			}
		}
	}
        
        
	        
}
