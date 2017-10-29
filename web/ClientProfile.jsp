<%-- 
    Document   : ClientProfile
    Created on : Oct 28, 2017, 7:15:15 PM
    Author     : Scarlet
--%>
<!-- <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
-->
<%@ page language="java" import="java.util.*" %>
<html>
<body>
    Session attributes:
    <%
      for (Enumeration e = session.getAttributeNames(); e.hasMoreElements(); ) {     
        String attribName = (String) e.nextElement();
        Object attribValue = session.getAttribute(attribName);
    %>
    <BR><%= attribName %> - <%= attribValue %>

    <%
    }
    %>
    
    <form action="LogoutServlet">
        <input type="submit" value="Salir" style="color: teal; background-color: #FFFFFF;"/>
    </form>
</body>
</html>
