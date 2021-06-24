<%-- 
    Document   : viewCart
    Created on : Apr 19, 2021, 9:26:22 AM
    Author     : Admin
--%>

<%@page import="vinhnd.dtos.TeaDTO"%>
<%@page import="vinhnd.dtos.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
        <h1>Your order:</h1>
        <%
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null) {
                %>
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Total</th>
                            <th>Option</th>
                            <th>Edit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int count = 1;
                            double total = 0;
                            for (TeaDTO tea : cart.getCart().values()) {
                                total += tea.getQuantity() * tea.getPrice();
                        %>
                    <form action="MainController">
                        <tr>
                            <td><%= count++ %></td>
                            <td><%= tea.getId() %>
                                <input type="hidden" name="id" 
                                       value="<%= tea.getId() %>" />
                            </td>
                            <td><%= tea.getName() %></td>
                            <td>
                                <input type="number" name="quantity" 
                                       value="<%= tea.getQuantity()%>" required=""/>
                            </td>
                            <td><%= tea.getPrice() %></td>
                            <td><%= tea.getQuantity() * tea.getPrice() %></td>
                            <td>
                                <input type="submit" value="Remove" name="action" />
                            </td>
                            <td>
                                <input type="submit" value="Edit" name="action" />
                            </td>
                        </tr>
                    </form>
                        <%
                            }
                        %>
                    </tbody>
                </table>
                    <h2>Total: <%= total %></h2>
                    <a href="shopping.jsp">Add more tea</a>
        <%
            }
        %>
    </body>
</html>
