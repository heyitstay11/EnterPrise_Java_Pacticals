<%-- 
    Document   : index
    Created on : 26 Sep, 2022, 5:31:34 PM
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

<sql:query var="users" dataSource="${dbsource}">
    SELECT * FROM USERS
</sql:query>
   
    <c:forEach var="user" items="${users.rows}">
        <c:out value="${user.name}" /> <br>
    </c:forEach>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="./user.jsp">
            Name <input name="name" /> <br>
            Roll No <input name="roll" /> <br>
            <button>Submit</button>
        </form>
        
    </body>
</html>
