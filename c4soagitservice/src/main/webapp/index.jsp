<%@ page language="java" pageEncoding="UTF-8"%>
<%
    java.util.jar.Manifest manifest = new java.util.jar.Manifest();
    manifest.read(pageContext.getServletContext().getResourceAsStream("/META-INF/MANIFEST.MF"));
    java.util.jar.Attributes attributes = manifest.getMainAttributes();

%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>C4SOA Git Proxy Server</title>
</head>
<body>
<h1>Access the services</h1>

<a href="./services/GitServices">Interacting Web Services</a>

<br>
<h1>Status Check</h1>
<h2>Version: <%=attributes.getValue("Implementation-Version")%>-<%=attributes.getValue("Implementation-Environment")%></h2>
<h2>SCM Revision: <%=attributes.getValue("Implementation-Build")%></h2>
</body>
</html>