Cloud4SOA Frontend project
==========================

Checkout project from http://pandora.atosorigin.es/svn/cloud4soa/frontend/trunk 
as Java Project. Current configuration for a single Eclipse project including all modules

Compile the project at root level with:

    mvn install

Current modules:
- frontend-commons: include common client and server helper classes and services
it should include any code reuse by dashboard and widgets
- frontend-dashboard: generates the Cloud4SOA frontend dashboard, that is, the
Cloud4SOA user interface 
- frontend-widget-user-management: generates user management widget and related views
- frontend-widget-search: generates search for PaaS offerings widget and related views

Dependencies:
frontend-widget-user-management -> frontend-commons
frontend-widget-search -> frontend-commons
frontend-dashboard  -> frontend-commons
					-> frontend-widget-user-management
					-> frontend-widget-search

Compile, debug and run individual widgets and the dashboard
Place your command line in a concrete widget or dashboard root directory.
Ensure frontend-commons is up to date and installed with mvn install
Compile:

    mvn clean gwt:compile
Execute:

    mvn -P dev gwt:run

The 'dev' profile must be activated in order to include the MySQL JDBC Connector in the classpath.

When producing the war file for deploying in a servlet container you won't include the MySQL JDBC Connector in the classpath.
Instead, you will manually add the MySQL JDBC Connector in the servlet container.

Debugging from Eclipse:
In Project Explorer select the widget module, righ-click, select RunAs/Maven build ...
In goals type gwt:debug, give a name, apply changes and run
Eclipse runs a debugging session. To connect to it, create a debug configuration for same
module, as Remote Java Application debug project, and select port 8008 (as configured in pom.xml) to connect to.
Accept changes and debug. Set code breakpoints and from emerging GWT Development Mode window launch the application in default browser.

Standalone and Full mode
------------------------

Cloud4SOA can be started in two modes: standalone and full.
The 'standalone' mode allows users to use only the matchmaking functionality hiding deployment, monitoring, migration
and SLA enforcement.
Furthermore, the 'standalone' mode provide a slightly modified welcome page that avoid referring to the functions not
provided in this mode.

The mode can be decided at startup by mean of a system property (environment variable) 'c4s.mode'. When set to 'standalone'
this property makes the Cloud4SOA application to work in standalone mode. When unset, set to 'full' (or any other value)
Cloud4SOA works full featured.

When using mvn gwt:run, the property can be set with:

    mvn -Dc4s.mode=standalone gwt:run

When deploying the war file in tomcat, the property can be set using the CATALINA_OPTS variable:

    $export CATALINA_OPTS=-Dc4s.mode=standalone
    $catalina.sh start

In Debian style linux distribution, the variable can be set in /etc/default/tomcat7 file

    JAVA_OPTS="-Djava.awt.headless=true -XX:MaxPermSize=200m -mx512m -XX:+UseConcMarkSweepGC -Dc4s.mode=standalone"


Tips/Notes
----------
Let's use this section to communicate lessons learnt and notes WRT the maven lifecycle for GWT-based projects



