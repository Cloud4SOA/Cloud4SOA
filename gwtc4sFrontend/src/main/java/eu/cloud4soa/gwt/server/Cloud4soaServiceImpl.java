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


package eu.cloud4soa.gwt.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import eu.cloud4soa.api.frontend.DeploymentWidget;
import eu.cloud4soa.api.soa.ApplicationDeployment;
import eu.cloud4soa.gwt.client.GreetingService;
import eu.cloud4soa.gwt.shared.FieldVerifier;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class Cloud4soaServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	private ApplicationContext context;
	
	public Cloud4soaServiceImpl() {
		super();

		System.out.println(System.getProperty("java.class.path"));
//		String[] serviceResources = {"classpath*:WEB-INF/classes/spring/config/applicationContext.xml"};
		String[] serviceResources = {"classpath:**/*applicationContext.xml"};

		context = new ClassPathXmlApplicationContext(serviceResources);
	}

	
	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

// 	------------------------
		
//		ApplicationDeployment applicationDeployment = (ApplicationDeployment)context.getBean("applicationDeployment");
		DeploymentWidget deploymentWidget = (DeploymentWidget)context.getBean("deploymentWidget");
        //build ApplicationInstance from ApplicationSemanticModel + applicationInstance
        eu.cloud4soa.api.datamodel.frontend.ApplicationArchive frontendApplicationArchive = new eu.cloud4soa.api.datamodel.frontend.ApplicationArchive() {};
        //build ApplicationInstance from ApplicationSemanticModel + applicationInstance
        eu.cloud4soa.api.datamodel.frontend.ApplicationInstance frontendApplicationInstance = new eu.cloud4soa.api.datamodel.frontend.ApplicationInstance() {};
        //build PaaSInstance from PaaSSemanticModel + paaSInstance
        eu.cloud4soa.api.datamodel.frontend.PaaSInstance frontendPaaSInstance = new eu.cloud4soa.api.datamodel.frontend.PaaSInstance() {};

//        applicationDeployment.deployApplication(frontendApplicationArchive, frontendApplicationInstance, frontendPaaSInstance);
        deploymentWidget.deployApplication(frontendApplicationArchive, frontendApplicationInstance, frontendPaaSInstance);
        
//	-------------------------
        
		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Application " + input + " deployed!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
