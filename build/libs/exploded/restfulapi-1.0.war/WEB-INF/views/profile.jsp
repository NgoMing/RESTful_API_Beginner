<%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 5/4/2018
  Time: 3:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Online Shopping for everyone</title>
    </head>
    <body>
        <h1>Your Profile</h1>
        <c:out value="${customer.username}" /><br/>
        <c:out value="${customer.firstName}" />
        <c:out value="${customer.lastName}" /><br/>
    </body>
</html>
