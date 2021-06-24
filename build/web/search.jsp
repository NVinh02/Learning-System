<%-- 
    Document   : search
    Created on : Apr 13, 2021, 9:21:40 AM
    Author     : PC
--%>

<%@page import="java.util.List"%>
<%@page import="vinhnd.dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <% UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
        if (loginUser == null || !"admin".equals(loginUser.getRoleID())) {
            response.sendRedirect("login.html");
            
            return;
        }
        String search = request.getParameter("SearchValue");
        if (search == null) {
            search = "";
        }
        %>
        <h1>Welcome <%= loginUser.getFullname()%></h1>
        <form action="MainController">
            <input type="submit" value="Logout" name="action" />
        </form>
        <a href="shopping.jsp">Shopping</a>
        <form action="MainController">
            Search <input type="text" name="SearchValue" value="<%= search %>" />
            <input type="submit" value="Search" name="action"/>
        </form>
        
        <% List<UserDTO> list = (List<UserDTO>) request.getAttribute("LIST_USER");
            if (list != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>User ID</th>
                    <th>Full name</th>
                    <th>Role ID</th>
                    <th>Password</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (UserDTO user : list){
                        %>
            <form action="MainController">
                        <tr>
                    <td><%= count++ %></td>
                    <td><input type="text" name="userID" value="<%= user.getUserID()%>" readonly=""/></td>
                       
                    <td><input type="text" name="fullname" value="<%= user.getFullname() %>"/></td>
                    
                    <td><input type="text" name="roleID" value="<%= user.getRoleID() %>"/></td>
                    <td><%= user.getPassword() %></td>
                    <td>
                        <a href="MainController?SearchValue=<%= search %>&action=Delete&userID=<%= user.getUserID() %>">Delete</a>
                    </td>
                    <td>
                        <input type="hidden" name="SearchValue" value="<%= search%>" />
                        <input type="submit" value="Update" name="action" />
                    </td>
                </tr>
            </form>
                <%
                    }
                %>
                
            </tbody>
        </table>

        <%
            }
        %>

    </body>
</html>
