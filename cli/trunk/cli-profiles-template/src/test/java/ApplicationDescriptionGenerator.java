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




import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;

/**
 *
 * @author vins
 */
public class ApplicationDescriptionGenerator {
    
//    private static ApplicationDescriptionGenerator instance = null;
    
    private String templateName = "application.vm";
//    
//    public static ApplicationDescriptionGenerator getInstance(){
//        if(instance == null)
//           instance=new ApplicationDescriptionGenerator(); 
//        return instance;
//    }
    
    private String readFile(String fileName) throws FileNotFoundException{
        URL fileURL = this.getClass().getClassLoader().getResource(fileName);
        if (fileURL == null)
            throw new FileNotFoundException(fileName);
        System.out.println(""+fileURL.getFile());
        return fileURL.getFile();
    }
    
    @Test
    public void init(){
        VelocityEngine ve = new VelocityEngine(); 
        ve.setProperty(Velocity.RESOURCE_LOADER, "class");
        ve.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader"); 
        Properties p = new Properties();
        p.setProperty("file.resource.loader.path", "/src/test/resources");
        ve.init( p );
        VelocityContext context = new VelocityContext();
        //crea la reference all'array di dati list
        String applicationUriId = "1234567890";
        context.put("applicationUriId", applicationUriId);
        Template template =  null;
        String fileName;
//        try {
//            fileName = readFile(templateName);
//            fileName="/src/main/resources/"+templateName;
            template = ve.getTemplate(templateName);

            BufferedWriter writer = writer = new BufferedWriter(
            new OutputStreamWriter(System.out));
            //Merge i dati referenziati con il template
            if ( template != null)
                template.merge(context, writer);
            try {
                //flush e cleanup
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(ApplicationDescriptionGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ApplicationDescriptionGenerator.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
}

