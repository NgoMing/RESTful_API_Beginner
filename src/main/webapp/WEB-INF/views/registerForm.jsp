<%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 5/4/2018
  Time: 2:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Online Shopping for everyone</title>
    </head>
    <body>
        <h1>Register</h1>

        <sf:form method="POST" commandName="customer" >
            First Name: <sf:input path="firstName" /><br/>
            Last Name: <sf:input path="lastName" /><br/>
            Username: <sf:input path="username" /><br/>
            Password: <sf:password path="password" /><br/>
            <input type="submit" value="Register" />
        </sf:form>
    </body>
</html>
