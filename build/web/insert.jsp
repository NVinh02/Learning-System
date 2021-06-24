<%-- 
    Document   : insert
    Created on : Apr 16, 2021, 7:20:29 AM
    Author     : Admin
--%>

<%@page import="vinhnd.dtos.UserErrorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registion Page</title>
    </head>
    <body>
        <h1>Input user's information</h1>
        <%--
            UserErrorDTO error = (UserErrorDTO) request.getAttribute("ERROR_USER");
            if (error == null) {
                error = new UserErrorDTO("", "", "", "", "");
            }
        --%>
        <form action="MainController" method="POST">
            User ID <input type="text" name="userID" value="" /><br>
            <%--
                if (!error.getUserIDError().isEmpty()) {
                    %>
                    <%= error.getUserIDError() %><br>
            <%
                }
            --%>
            ${requestScope.ERROR_USER.userIDError}
            Full Name <input type="text" name="fullname" 
                             value="" /><br>
            <%--
                if (!error.getFullnameError().equals("")) {
                    %>
                    <%= error.getFullnameError() %><br>
            <%
                }
            --%>
            ${requestScope.ERROR_USER.fullnameError}
            Role ID <input type="text" name="roleID" value="" /><br>
            <%--
                if (!error.getRoleIDError().equals("")) {
                    %>
                    <%= error.getRoleIDError() %><br>
            <%
                }
            --%>
            ${requestScope.ERROR_USER.roleIDError}
            Password <input type="password" name="password" value="" /><br>
            <%--
                if (!error.getPasswordError().equals("")) {
                    %>
                    <%= error.getPasswordError() %><br>
            <%
                }
            --%>
            ${requestScope.ERROR_USER.passwordError}
            Confirm <input type="password" name="confirm" value="" /><br>
            <%--
                if (!error.getConfirmError().equals("")) {
                    %>
                    <%= error.getConfirmError() %><br>
            <%
                }
            --%>
            ${requestScope.ERROR_USER.confirmError}
            <input type="submit" value="Insert" name="action" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
