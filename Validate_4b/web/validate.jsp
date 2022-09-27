<%-- 
    Document   : validate
    Created on : 26 Sep, 2022, 5:00:17 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validate</title>
    </head>
    <body>
        <jsp:useBean id="user" scope="request" class="beans.User">
            <jsp:setProperty name="user" property="*" />
        </jsp:useBean>
        
        <% if(user.validate()) {%>
            <jsp:forward page="success.jsp" />
        <% } else { %>
            <jsp:include page="error.jsp" />
        <% } %>
    </body>
</html>
