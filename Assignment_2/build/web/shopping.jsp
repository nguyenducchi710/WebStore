<%-- 
    Document   : shopping
    Created on : Aug 22, 2023, 8:53:55 PM
    Author     : nguye
--%>

<%@page import="DAO.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

            form {
                text-align: center;
                margin-top: 20px;
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

            form input[type="text"], input[type="submit"] {
                padding: 5px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }

            a {
                text-decoration: none;
                color: #333;
            }

            .product-card {
                border: 1px solid #ddd;
                padding: 10px;
                margin: 10px;
                background-color: #fff;
            }

            .product-grid {
                display: grid;
                grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
                gap: 20px;
                margin: 20px;
            }

            .product-card {
                border: 1px solid #ddd;
                padding: 10px;
                background-color: #fff;
                text-align: center;
            }

            .product-card img {
                max-width: 150px;
                height: auto;
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <h1>Jan's Store</h1>
        <%
            String keyword = request.getParameter("keyword");

        %>
        <form action="MainController" method="post">
            <input type="hidden" value="search" name="action"/>
            <p>Search Product: <input type="text" name="txtsearch" value="<%= (keyword != null) ? keyword : ""%>"/><input type="submit" value="Search"/></p>
        </form>
        <%
            ArrayList<Product> list = (ArrayList) request.getAttribute("list");
            if (list != null && list.size() > 0) {

        %>        
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Gender</th>
                <th>Type</th>
                <th>Price</th>
                <th>Size</th>
            </tr>
            <%                for (Product i : list) {
            %>
            <tr>
                <td><%=i.getProductname()%></td>
                <td><%=i.getDesciption()%></td>
                <td><%=i.getGender()%></td>
                <td><%=i.getType()%></td>
                <td><%=i.getPrice()%></td>
                <td><%=i.getSize()%></td>
                <td>
                    <form action="MainController" method="post">
                        <input type="hidden" value="<%=i.getProductid()%>" name="productid"/>
                        <input type="submit" value="Add to cart" name="action"/>
                    </form>
                </td>    
            </tr>

            <%
                }
            %>
        </table>
        <%
            }
        %>
        <%
            ArrayList<Product> list2 = ProductDAO.getAllProduct();
            if (list2 != null && list2.size() > 0) {
        %>
        <div class="product-grid">
            <%
                for (Product p : list2) {
            %>
            <div class="product-card">
                <img src="img/Logo2.png" alt="Product Image">
                <p><%=p.getProductname()%></p>
                <p><%=p.getSize()%></p>
                <p><%=p.getGender()%></p>
                <p><%=p.getPrice()%></p>
                <form action="MainController" method="post">
                    <input type="hidden" value="<%=p.getProductid()%>" name="productid"/>
                    <input type="submit" value="Add to cart" name="action"/>
                </form>
            </div>
            <%
                }
            %>
        </div>
        <%
            }
        %>
        <%
            String msg = (String) request.getAttribute("msg2");
            if (msg != null && !msg.isEmpty()) {
        %>
            <div class="error-msg"><%= msg %></div>
        <%
            }
        %>
        <h2><a href="MainController?action=viewcart">View cart</a></h2>
        <h2><a href="MainController?action=logout">Logout</a></h2>
    </body>
</html>
