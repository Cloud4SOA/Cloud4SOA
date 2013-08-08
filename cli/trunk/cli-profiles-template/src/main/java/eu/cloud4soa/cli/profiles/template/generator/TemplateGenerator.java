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


package eu.cloud4soa.cli.profiles.template.generator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vins
 */
public class TemplateGenerator {
    
    final Logger logger = LoggerFactory.getLogger(TemplateGenerator.class);
    
    private static TemplateGenerator instance = null;
    
    private String templateName = "application.vm";
    private VelocityEngine ve = null;
    VelocityContext context = null;
    private List<String> allowedValues = new ArrayList<String>();

    public TemplateGenerator(String templateName, List<String> allowedValues) {
        this.templateName = templateName;
        this.allowedValues = allowedValues;
        context = new VelocityContext();
        initVelocityEngine();
    }

    private void initVelocityEngine() {
        ve = new VelocityEngine(); 
        ve.setProperty(Velocity.RESOURCE_LOADER, "class");
        ve.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader"); 
        Properties p = new Properties();
        p.setProperty("file.resource.loader.path", "classpath:*/src/main/resources");
        ve.init( p );
    }
    
    public void setValue(String variableName, String variableValue) throws IllegalArgumentException{
        if(!allowedValues.contains(variableName)){
            throw new IllegalArgumentException("The variable "+variableName+" is not allowed");
        }
        if(context.containsKey(variableName)){
            throw new IllegalArgumentException("The variable "+variableName+" is already set");
        }
        context.put(variableName, variableValue);
    }
    
    public void setValues(Map<String, String> map) throws IllegalArgumentException{
        for (Map.Entry<String, String> entry : map.entrySet()){
            setValue(entry.getKey(), entry.getKey());
        }
    }
    
    public void evaluateTemplate(OutputStream outputStream) throws AssertionError{
        for (String allowedValue : allowedValues) {
            if(!context.containsKey(allowedValue))
                throw new AssertionError("The template context is not fulfilled");
        }
        
        Template template =  null;
        
        try{
            //get template
            template = ve.getTemplate(templateName);
        }
        catch( ResourceNotFoundException rnfe ){
            logger.error("Cannot find template " + templateName );
        }
        catch( ParseErrorException pee ){
            logger.error("Syntax error in template " + templateName + ":" + pee );
        }

        BufferedWriter writer = writer = new BufferedWriter(
            new OutputStreamWriter(outputStream));
        //Merge of referenced data with template
        if ( template != null)
            template.merge(context, writer);
        try {
            //flush amd cleanup
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            logger.error("Failed to flush and cleanup", ex);
        }    
    }
}

