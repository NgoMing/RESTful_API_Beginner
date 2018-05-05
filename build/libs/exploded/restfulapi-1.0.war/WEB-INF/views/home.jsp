<%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 5/4/2018
  Time: 2:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Online Shopping</title>
        <link rel="stylesheet"
              type="text/css"
              href="<c:url value="/resources/style.css" />" >
    </head>
    <body>
        <h1>Online Shopping for everyone</h1>
        <a href="<c:url value="/customer/register" />">Register</a>
    </body>
</html>
