/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package c4soa.resource;

/**
 *
 * @author pgouvas
 */
public class Application {
    
    private String version;
    private String publickey;
    private String secretkey;
    private String appname;
    private String appnversion;  
    private String environment;    
    private String bucket;
    
    public Application (){

    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    

    
}
