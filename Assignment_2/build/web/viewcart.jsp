<%-- 
    Document   : viewcart
    Created on : Aug 23, 2023, 10:24:59 AM
    Author     : nguye
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function warning() {
                var ans = window.confirm("Are you sure about that?");
                if(ans) {
                    return true;
                }
                return false;
            }
        </script>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                margin: 0;
                padding: 0;
            }

            h1 {
                text-align: center;
                padding: 20px;
                background-color: #333;
                color: #fff;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            th, td {
                padding: 10px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }

            th {
                background-color: #f2f2f2;
            }

            form input[type="number"], input[type="submit"] {
                padding: 5px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }

            a {
                text-decoration: none;
                color: #333;
            }

            .cart-container {
                max-width: 800px;
                margin: 0 auto;
                padding: 20px;
                background-color: #fff;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            }

            .cart-item {
                display: flex;
                align-items: center;
                border-bottom: 1px solid #ddd;
                padding: 10px 0;
            }

            .cart-item img {
                max-width: 80px;
                height: 80px;
                margin-right: 10px;
            }

        </style>
    </head>
    <body>
        <div class="cart-container">
            <h1>Your cart</h1>
            <%
                HashMap<Product, Integer> cart = (HashMap<Product, Integer>) session.getAttribute("cart");
                if (cart != null && cart.size() > 0) {
            %>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Action</th>        
                </tr>
                <%
                    double sum = 0;
                    for (Product c : cart.keySet()) {
                        int quantity = cart.get(c);
                        double totalPrice = quantity * c.getPrice();
                        sum += totalPrice;
                %>
                <form action="MainController" method="post">
                    <input type="hidden" value="9" name="action"/>
                    <input type="hidden" value="<%= c.getProductid()%>" name="txtid"/>
                    <tr>
                        <td> <%= c.getProductid()%> </td>
                        <td> <%= c.getProductname()%></td>
                        <td> <%= c.getPrice()%></td>
                        <td><input type="number" min="1" value="<%= quantity%>" name="txtquantity"/></td>
                        <td><%= totalPrice%> USD</td>
                        <td>
                            <input type="submit" value="remove" onclick="return warning()" name="btnremove">
                            <input type="submit" value="update">
                        </td>
                    </tr>
                </form>
                <%
                    }
                %>    
            </table>
            <h3>Order Date: <%= (new Date()).toString()%></h3>
            <h3>Shipping Date: coming soon</h3>
            <h3>Sum: <%= sum%> USD</h3>
            <form action="MainController" method="post">
                <input type="submit" value="Pay" name="action"/>
            </form>
            <%
                } else {
                    out.print("<h4> Empty cart </h4>");
                }
            %>
            
            <h2><a href="shopping.jsp">Home</a></h2>
        </div>
    </body>
</html>
