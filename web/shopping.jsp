<%-- 
    Document   : shopping
    Created on : Apr 19, 2021, 7:49:06 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Retake's Milk Tea</title>
    </head>
    <body>
        <h1>Welcome to my Tea!</h1>
        <form action="MainController">
            Choose your favorite tea
            <select name="cmbTea">
                <option value="T01-Macha Tea-50">Macha</option>
                <option value="T02-Fresh Coffee-40">Fresh Coffee</option>
                <option value="T03-Bac Siu-20">Bac Siu</option>
                <option value="T04-Pink Tea-90">Pink Tea</option>
            </select>
            <input type="submit" value="Add" name="action" />
            <input type="submit" value="View" name="action" />
            <%
                String msg = (String) request.getAttribute("MESSAGE");
                if (msg == null) {
                    msg = "";
                }
            %>
            <h2><%= msg %></h2>
        </form>
    </body>
</html>
