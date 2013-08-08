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

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vins
 */
public class ApplicationDescriptionGenerator {
    
    final Logger logger = LoggerFactory.getLogger(ApplicationDescriptionGenerator.class);
    
//    private static ApplicationDescriptionGenerator instance = null;
    
    private static String templateName = "application.vm";
    private TemplateGenerator templateGenerator = null;

    private List<String> allowedValues = new ArrayList<String>();


    public ApplicationDescriptionGenerator() {
        allowedValues.add("applicationUriId");
        allowedValues.add("latencyUriId");
        allowedValues.add("uptimeUriId");
        allowedValues.add("timeRangeUriId");
        allowedValues.add("timeUnitMaxUriId");
        allowedValues.add("timeUnitMinUriId");
        templateGenerator = new TemplateGenerator(templateName, allowedValues);
    }
    
    public void setValue(String variableName, String variableValue) throws IllegalArgumentException{
        templateGenerator.setValue(variableName, variableValue);
    }
    
    public void setValues(Map<String, String> map) throws IllegalArgumentException{
        templateGenerator.setValues(map);
    }
    
    public void evaluateTemplate(OutputStream outputStream) throws AssertionError{
        templateGenerator.evaluateTemplate(outputStream);
    }
}

