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


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cloud4soa.cli.profiles.grammar.visitor.core;

import eu.cloud4soa.api.datamodel.core.ApplicationInstance;
import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.datamodel.core.UserInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.BoxInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.ChannelInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.ChannelType;
import eu.cloud4soa.api.datamodel.core.utilBeans.Cloud4SoaAccountInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.ComputeInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.DeveloperInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.HardwareCategoryType;
import eu.cloud4soa.api.datamodel.core.utilBeans.HardwareComponentInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.NetworkResourceInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.PaaSProviderInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.PaaSUserInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.SoftwareCategoryInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.StorageResourceInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.WebInterfaceInstance;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.AccountInfo;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.Api;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.ApplicationCode;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.ApplicationInfos;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.ApplicationProfile;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.Bandwidth;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.Birthday;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.BoxComponent;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.Cli;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.CommunicationalComponent;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.Component;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.ComputationalComponent;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.Description;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.Digest;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.File;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.FileDimension;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.INode;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.Latency;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.License;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.NodeChoice;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.NodeList;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.NodeSequence;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.NodeToken;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.Operation;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.PaasOfferingInfos;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.PaasOfferingProfile;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.PersonalInfos;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.Provider;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.Software;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.SoftwareCategory;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.SoftwareComponent;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.StorageComponent;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.TechnologyInfo;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.UserProfile;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.Version;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.WebInterface;
import eu.cloud4soa.cli.profiles.grammar.visitor.DepthFirstVoidVisitor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

    
    

    
    
/**
 *
 * @author vins
 */
public class CoreDepthFirstVoidVisitor extends DepthFirstVoidVisitor{
    private ApplicationInstance applicationInstance;
    private PaaSInstance paaSInstance;
    private UserInstance userInstance;
    
    private Cloud4SoaAccountInstance cloud4SoaAccountInstance;
    private SoftwareCategoryInstance softwareCategory;
    
    private String version;
    private String componentName;
    private String description;
    private String licenseType;
    private String category;

    //Operation
    private String operationName;
    private String operationDescription;
    private String operationCommand;
    private String operationInformationRet;
    
    private String latency;
    private String bandwidth;
    
    public ApplicationInstance getApplicationInstance() {
        return applicationInstance;
    }

    public PaaSInstance getPaaSInstance() {
        return paaSInstance;
    }

    public UserInstance getUserInstance() {
        return userInstance;
    }

    /*
     * f0 -> ApplicationInfos 
     * f1 -> File 
     * f2 -> TechnologyInfo
     */
    @Override
    public void visit(ApplicationProfile n) {
        applicationInstance = new ApplicationInstance();
        super.visit(n);
    }

    /*
     * f0 -> <APPLICATION> 
     * f1 -> <COLON> 
     * f2 -> <STRING> 
     * f3 -> Version 
     * f4 -> ( ApplicationCode )?
     */
    @Override
    public void visit(ApplicationInfos n) {
        if(applicationInstance != null){
            String acronym = n.f2.tokenImage;
            acronym = trimQuotes(acronym);
            applicationInstance.setAcronym(acronym);
            String version = n.f3.f2.tokenImage;
            applicationInstance.setVersion(version);            
            if(n.f4.present()){
                n.f4.node.accept(this);
                applicationInstance.setApplicationcode(acronym = trimQuotes(n.f4.node.toString()));
            }
        }
    }
        
    /*
     * f0 -> <APPLICATION_CODE> 
     * f1 -> <COLON> 
     * f2 -> <STRING> 
     */
    @Override
    public void visit(ApplicationCode n) {
        applicationInstance.setApplicationcode(trimQuotes(n.f2.tokenImage));
    }

    /*
     * f0 -> <FILE_NAME>
     * f1 -> <COLON> 
     * f2 -> <STRING> 
     * f3 -> ( FileDimension )?
     */
    @Override
    public void visit(File n) {
        String fileName = trimQuotes(n.f2.tokenImage);
        String extension = FilenameUtils.getExtension(fileName);
        String baseName = FilenameUtils.getBaseName(fileName);
        applicationInstance.setArchiveFileName(baseName);
        applicationInstance.setArchiveExtensionName(FilenameUtils.EXTENSION_SEPARATOR_STR+extension);
        if(n.f3.present())
            n.f3.accept(this);
    }

    /*
     * f0 -> <SIZE>
     * f1 -> <COLON> 
     * f2 -> <NATURAL_NUMBER>
     * f3 -> ( Digest )?
     */
    @Override
    public void visit(FileDimension n) {
        String size = n.f2.tokenImage;
        applicationInstance.setSizeQuantity(Float.parseFloat(size));
        if(n.f3.present())
            n.f3.accept(this);
    }

    /*
     * f0 -> <DIGEST>
     * f1 -> <COLON> 
     * f2 -> <NATURAL_NUMBER>
     */
    @Override
    public void visit(Digest n) {
       String digest = n.f2.tokenImage;
        applicationInstance.setDigest(digest);
    }

    /*
     * f0 -> ProgrammingLanguage
     * f1 -> SWRequirements
     * f2 -> HWRequirements
     */
    @Override
    public void visit(TechnologyInfo n) {
        String programmingLanguage = n.f0.f2.tokenImage;
        programmingLanguage = trimQuotes(programmingLanguage);
        String programmingLanguageVersion = n.f0.f3.f2.tokenImage;
        if(applicationInstance != null){
            applicationInstance.setProgramminglanguage(programmingLanguage);
            applicationInstance.setProgramminglanguageVersion(programmingLanguageVersion);
        }
        else if(paaSInstance != null){
            paaSInstance.setSupportedProgrammingLanguage(programmingLanguage);
            paaSInstance.setSupportedProgrammingLanguageVersion(programmingLanguageVersion);
        }
        n.f1.accept(this);
        n.f2.accept(this);
    }

    /*
     * f0 -> <SW_REQUIREMENTS> 
     * f1 -> <LBRACE> 
     * f2 -> ( SoftwareCategory <LBRACE> ( SoftwareComponent )+ <RBRACE> )+ 
     * f3 -> <RBRACE>
     */
    @Override
    public void visit(Software n) {
        for (INode node : n.f2.nodes) {
            ArrayList<INode> list = ((NodeSequence)node).nodes;
            //SoftwareCategory
            INode swCategoryNode = list.get(0);
            swCategoryNode.accept(this);
            // ( SoftwareComponent )+
            INode swComponentNode = list.get(2);
            Iterator<INode> swComponentIterator = ((NodeList)swComponentNode).elements();
            while (swComponentIterator.hasNext()) {
                INode iNode = swComponentIterator.next();
                iNode.accept(this);
                if(applicationInstance != null){
                    applicationInstance.createAndAddSoftwareComponent(componentName, description, 
        		version, licenseType, softwareCategory);
                }
                else if(paaSInstance != null){
                    paaSInstance.createAndAddSoftwareComponent(componentName, description, 
        		version, licenseType, softwareCategory);
                }
            }
        }
    }

    /*
     * f0 -> <CATEGORY> 
     * f1 -> <COLON>
     * f2 -> <STRING>
     * f3 -> Description()
     */
    @Override
    public void visit(SoftwareCategory n) {
        category = n.f2.tokenImage;
        category = trimQuotes(category);
        n.f3.accept(this);
        softwareCategory = new SoftwareCategoryInstance(category, description);
    }

    /*
     * f0 -> <COMPONENT> 
     * f1 -> <COLON>
     * f2 -> <STRING>
     * f3 -> Description
     */
    @Override
    public void visit(Component n) {
        componentName = n.f2.tokenImage;
        componentName = trimQuotes(componentName);
        n.f3.accept(this);
    }

    /*
     * f0 -> Component
     * f1 -> Version 
     * f2 -> (License)?
     */
    @Override
    public void visit(SoftwareComponent n) {
        n.f0.accept(this);
        n.f1.accept(this);
        if(n.f2.present())
            n.f2.accept(this);
    }

    
    /*
     * f0 -> <DESCRIPTION> 
     * f1 -> <COLON>
     * f2 -> <STRING>
     */
    @Override
    public void visit(Description n) {
        description = n.f2.tokenImage;
        description = trimQuotes(description);
    }

    /*
     * f0 -> <VERSION> 
     * f1 -> <COLON>
     * f2 -> <FLOATING_POINT>
     */
    @Override
    public void visit(Version n) {
        version = n.f2.tokenImage;
    }
    
    /*
     * f0 -> <LICENSE> 
     * f1 -> <COLON>
     * f2 -> <LICENSE_TYPE>
     */
    @Override
    public void visit(License n) {
        licenseType = n.f2.tokenImage;
    }  

    /*
     * f0 -> Component 
     * f1 -> HttpRequests
     */
    @Override
    public void visit(BoxComponent n) {
        n.f0.accept(this);
        String httpRequests = n.f1.f2.tokenImage;
        HardwareComponentInstance computationalComponent = null;
        if(paaSInstance != null){
            computationalComponent = paaSInstance.createAndAddHardwareComponent(HardwareCategoryType.Box);
        }
        else if(applicationInstance != null){
            computationalComponent = applicationInstance.createAndAddHardwareComponent(HardwareCategoryType.Box);
        }
        
//        computationalComponent.setTitle(componentName);
//        computationalComponent.setDescription(description);
        
        BoxInstance boxInstance = (BoxInstance)computationalComponent.getRelatedhwcategoryInstance();
        boxInstance.setTitle(componentName);
        boxInstance.setDescription(description);
        boxInstance.setMinHTTPRequests(Float.parseFloat(httpRequests));
    }

    /*
     * f0 -> Component 
     * f1 -> Architecture
     * f2 -> Cores
     * f3 -> Speed 
     * f4 -> Memory 
     * f5 -> Cache
     */    
    @Override
    public void visit(ComputationalComponent n) {
        n.f0.accept(this);
        String architecture = n.f1.f2.tokenImage;
        String coresN = n.f2.f2.tokenImage;
        String speed = n.f3.f2.tokenImage;
        String memory = n.f4.f2.tokenImage;
        String cache = n.f5.f2.tokenImage;
        HardwareComponentInstance computationalComponent = null;
        if(paaSInstance != null){
            computationalComponent = paaSInstance.createAndAddHardwareComponent(HardwareCategoryType.Compute);
        }
        else if(applicationInstance != null){
            computationalComponent = applicationInstance.createAndAddHardwareComponent(HardwareCategoryType.Compute);
        }
        
//        computationalComponent.setTitle(componentName);
//        computationalComponent.setDescription(description);
        
        ComputeInstance computeInstance = (ComputeInstance)computationalComponent.getRelatedhwcategoryInstance();
        computeInstance.setTitle(componentName);
        computeInstance.setDescription(description);
        computeInstance.setArchitecture(architecture);
        computeInstance.setMinHasCores(Float.parseFloat(coresN));
        computeInstance.setMinSpeedValue(Float.parseFloat(speed));
        computeInstance.setMinMemoryValue(Float.parseFloat(memory));
        computeInstance.setMinCacheValue(Float.parseFloat(cache));
    }

    /*
     * f0 -> Component 
     * f1 -> Bandwidth 
     * f2 -> ( Latency )?
     */
    @Override
    public void visit(CommunicationalComponent n) {
        n.f0.accept(this);
        String bandwidth = n.f1.f2.tokenImage;
        
        HardwareComponentInstance communicationalComponent = null;
        
        if(applicationInstance != null){
            communicationalComponent = applicationInstance.createAndAddHardwareComponent(HardwareCategoryType.NetworkResource);
        }
        else if(paaSInstance != null){
            communicationalComponent = paaSInstance.createAndAddHardwareComponent(HardwareCategoryType.NetworkResource);
        }
        
//        communicationalComponent.setTitle(componentName);
//        communicationalComponent.setDescription(description);
        
        NetworkResourceInstance networkResourceInstance = (NetworkResourceInstance)communicationalComponent.getRelatedhwcategoryInstance();
        networkResourceInstance.setTitle(componentName);
        networkResourceInstance.setDescription(description);
        networkResourceInstance.setMinBandwidthValue(Float.parseFloat(bandwidth));
        if(n.f2.present()){
            n.f2.accept(this); //Latency (optional)
            networkResourceInstance.setMaxLatencyValue(Float.parseFloat(latency));
        }
    }

    /*
     * f0 -> <LATENCY>
     * f1 -> <COLON> 
     * f2 -> <NATURAL_NUMBER> 
     */
    @Override
    public void visit(Latency n) {
        latency = n.f2.tokenImage;
    }

    /*
     * f0 -> Component 
     * f1 -> Capacity 
     * f2 -> ( Bandwidth )?
     */    
    @Override
    public void visit(StorageComponent n) {
        n.f0.accept(this);
        String capacity = n.f1.f2.tokenImage;
        
        HardwareComponentInstance storageComponent = null;
        
        if(applicationInstance != null){
            storageComponent = applicationInstance.createAndAddHardwareComponent(HardwareCategoryType.StorageResource);
        }
        else if(paaSInstance != null){
            storageComponent = paaSInstance.createAndAddHardwareComponent(HardwareCategoryType.StorageResource);
        }
        
//        storageComponent.setTitle(componentName);
//        storageComponent.setDescription(description);
        
        StorageResourceInstance storageResourceInstance = (StorageResourceInstance)storageComponent.getRelatedhwcategoryInstance();
        storageResourceInstance.setTitle(componentName);
        storageResourceInstance.setDescription(description);
        storageResourceInstance.setMinCapacityValue(Float.parseFloat(capacity));
        if(n.f2.present()){
            n.f2.accept(this); //<LATENCY> (optional)
            storageResourceInstance.setMinBandwidthValue(Float.parseFloat(bandwidth));
        }
    }

    /*
     * f0 -> <BANDWIDTH> 
     * f1 -> <COLON> 
     * f2 -> <NATURAL_NUMBER>
     */ 
    @Override
    public void visit(Bandwidth n) {
        bandwidth = n.f2.tokenImage;
    }

    /*
     * f0 -> PaasOfferingInfos
     * f1 -> Channels
     * f2 -> TechnologyInfo
     */ 
    @Override
    public void visit(PaasOfferingProfile n) {
        paaSInstance = new PaaSInstance();
        super.visit(n);
    }

    /*
     * f0 -> <PAAS_OFFERING> 
     * f1 -> <COLON> 
     * f2 -> <STRING>
     */
    @Override
    public void visit(PaasOfferingInfos n) {
        String paaSOfferingName = n.f2.tokenImage;
        paaSOfferingName = trimQuotes(paaSOfferingName);
        paaSInstance.setTitle(paaSOfferingName);
    }
    
    /*
     * f0 -> <API>
     * f1 -> <LBRACE>
     * f2 -> ( Operation )*
     * f3 -> <RBRACE>
     */
    @Override
    public void visit(Api n) {
        ChannelInstance channelInstance = null;
        channelInstance = paaSInstance.createAndAddChannel(ChannelType.API);

        for (INode node : n.f2.nodes) {
            node.accept(this);
            channelInstance.createAndAddOperation(operationName, description, operationCommand, operationInformationRet);
        }
    }
    
        /*
     * f0 -> <CLI>
     * f1 -> <LBRACE>
     * f2 -> ( Operation )*
     * f3 -> <RBRACE>
     */
    @Override
    public void visit(Cli n) {
        ChannelInstance channelInstance = null;
        channelInstance = paaSInstance.createAndAddChannel(ChannelType.CLI);

        for (INode node : n.f2.nodes) {
            node.accept(this);
            channelInstance.createAndAddOperation(operationName, description, operationCommand, operationInformationRet);
        }
    }
    
        /*
     * f0 -> <WebInterface>
     * f1 -> <LBRACE>
     * f2 -> ( Operation )*
     * f3 -> <RBRACE>
     */
    @Override
    public void visit(WebInterface n) {
        ChannelInstance channelInstance = null;
        channelInstance = (WebInterfaceInstance) paaSInstance.createAndAddChannel(ChannelType.WebInterface);

        for (INode node : n.f2.nodes) {
            node.accept(this);
            channelInstance.createAndAddOperation(operationName, description, operationCommand, operationInformationRet);
        }
    }

    /*
     * f0 -> <NAME> 
     * f1 -> <COLON> 
     * f2 -> <STRING> 
     * f3 -> Description 
     * f4 -> Command 
     * f5 -> InformationReturned
     */
    @Override
    public void visit(Operation n) {
        operationName = n.f2.tokenImage;
        operationName = trimQuotes(operationName);
        n.f3.accept(this);
        description= n.f3.f2.tokenImage;
        description = trimQuotes(description);
        operationCommand = n.f4.f2.tokenImage;
        operationCommand = trimQuotes(operationCommand);
        operationInformationRet = n.f5.f2.tokenImage;
        operationInformationRet = trimQuotes(operationInformationRet);
    }

    /*
     * f0 -> ( ( <DEVELOPER> | <PROVIDER> <COLON> Provider ) ) 
     * f1 -> <LBRACE>
     * f2 -> AccountInfo 
     * f3 -> PersonalInfos
     * f4 -> <RBRACE>
     */
    @Override
    public void visit(UserProfile n) {
        NodeChoice n0Ch = n.f0;
        userInstance = null;
        switch (n0Ch.which) 
        {
            case 0:
                userInstance = new DeveloperInstance(); // DEVELOPER
                break;
            case 1:
                userInstance = new PaaSUserInstance(); // PROVIDER
                n.f0.choice.accept(this);
                break;
        }
        n.f2.accept(this);
        n.f3.accept(this);
    }

    /*
     * f0 -> <STRING> 
     * f1 -> <URL>
     * f2 -> <COLON>
     * f3 -> <HOMEPAGE>
     */
    @Override
    public void visit(Provider n) {
        String providerName = n.f0.tokenImage;
        providerName = trimQuotes(providerName);
        String providerHomePage = n.f3.tokenImage;
        providerHomePage = trimQuotes(providerHomePage);
        
        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance(providerName, providerHomePage);

        ((PaaSUserInstance)userInstance).setPaaSProviderInstance(paaSProviderInstance);
    }

    /*
     * f0 -> <USERNAME> 
     * f1 -> <COLON> 
     * f2 -> <STRING> 
     * f3 -> <PASSWORD>
     * f4 -> <COLON> 
     * f5 -> <STRING> 
     */
    @Override
    public void visit(AccountInfo n) {
        String accountName = n.f2.tokenImage;
        accountName = trimQuotes(accountName);
        cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
        cloud4SoaAccountInstance.setAccountname(accountName);
        userInstance.setHoldsaccount(cloud4SoaAccountInstance);
    }


    /*
     * f0 -> <FIRSTNAME> 
     * f1 -> <COLON> 
     * f2 -> <STRING> 
     * f3 -> <SURNAME> 
     * f4 -> <COLON> 
     * f5 -> <STRING> 
     * f6 -> <EMAIL> 
     * f7 -> <COLON> 
     * f8 -> <EMAIL_VALUE> 
     * f9 -> ( Birthday )?
     */
    @Override
    public void visit(PersonalInfos n) {
        String firstName = n.f2.tokenImage;
        firstName = trimQuotes(firstName);
        String surname = n.f5.tokenImage;
        surname = trimQuotes(surname);
        String email = n.f8.tokenImage;
        email = trimQuotes(email);
        userInstance.setFirstName(firstName);
        userInstance.setSurname(surname);
        userInstance.setPersonalmailbox(email);
        if(n.f9.present())
            n.f9.accept(this);
    }

    /*
     * f0 -> <BIRTHDAY> 
     * f1 -> <COLON> 
     * f2 -> <DATE_US>
     */
    @Override
    public void visit(Birthday n) {
        String dateUS = n.f2.tokenImage;
        StringTokenizer stk = new StringTokenizer(dateUS, "-", false);
        Integer year = Integer.parseInt(stk.nextToken());
        Integer month = Integer.parseInt(stk.nextToken());
        Integer day = Integer.parseInt(stk.nextToken());
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, month, day);
        String date = year + "/" + month + "/" + day;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date utilDate = null;
        try {
            utilDate = formatter.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(CoreDepthFirstVoidVisitor.class.getName()).log(Level.SEVERE, null, ex);
        }
        userInstance.setBirthday(utilDate);
    }
   
    
    
    
      /**
   * Trims the quotes.
   * <p>
   * For example,
   * <ul>
   * <li>("a.b") => a.b
   * <li>("a.b) => "a.b
   * <li>(a.b") => a.b"
   * </ul>
   * 
   * @param value
   *            the string may have quotes
   * @return the string without quotes
   */

  private String trimQuotes( String value )
  {
    if ( value == null )
      return value;

    value = value.trim( );
    if ( value.startsWith( "\"" ) && value.endsWith( "\"" ) )
      return value.substring( 1, value.length( ) - 1 );
    
    return value;
  }
    

}
