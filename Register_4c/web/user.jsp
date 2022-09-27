<%-- 
    Document   : user
    Created on : 26 Sep, 2022, 5:44:27 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="sql"  uri="http://java.sun.com/jsp/jstl/sql"  %>

<sql:setDataSource var="dbsource" 
                   driver="org.apache.derby.jdbc.ClientDriver" 
                   url="jdbc:derby://localhost/demo"
                   user="root"
                   password="root"
/>

<sql:update dataSource="${dbsource}">
    INSERT INTO USERS VALUES ('2',?,?)
    <sql:param value="${param.name}" />
     <sql:param value="${param.roll}" />
</sql:update>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
    </head>
    <h1>User Added Successfully</h1>
</html>
