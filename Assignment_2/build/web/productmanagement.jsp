<%-- 
    Document   : productmanagement
    Created on : Aug 23, 2023, 4:21:29 PM
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
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }
            h1 {
                background-color: #333;
                color: #fff;
                padding: 10px;
                text-align: center;
            }
            h2 {
                background-color: #333;
                color: #fff;
                padding: 10px;
                text-align: center;
            }
            form {
                margin-bottom: 20px;
                text-align: center;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }
            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }
            th {
                background-color: #f2f2f2;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            tr:hover {
                background-color: #ddd;
            }
            input[type="text"], input[type="submit"] {
                padding: 5px;
            }
            input[type="submit"] {
                background-color: #333;
                color: #fff;
                border: none;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <h1>Product Management</h1>
        <%
            String keyword = request.getParameter("keyword");

        %>
        <form action="MainController" method="post">
            <input type="hidden" value="searchproduct" name="action"/>
            <p>Search Product: <input type="text" name="txtsearch" value="<%= (keyword != null) ? keyword : ""%>"/> <input type="submit" value="Search"/></p>
        </form>
        <%
            ArrayList<Product> list = (ArrayList) request.getAttribute("list");
            if (list != null && list.size() > 0) {

        %>
        <h2>Search List</h2>
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Gender</th>
                <th>Type</th>
                <th>Price</th>
                <th>Size</th>
                <th>Action</th>
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
                        <input type="submit" value="Edit Product" name="action"/>
                    </form>
                    <form action="MainController" method="post">
                        <input type="hidden" value="<%=i.getProductid()%>" name="productid"/>
                        <input type="submit" value="Delete Product" name="action"/>
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
        <h2>Product List</h2>
        <%
            ArrayList<Product> list2 = ProductDAO.getAllProduct();
            if (list2 != null && list2.size() > 0) {

        %>  
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Gender</th>
                <th>Type</th>
                <th>Price</th>
                <th>Size</th>
                <th>Action</th>
            </tr>
            <%                for (Product i : list2) {
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
                        <input type="submit" value="Edit Product" name="action"/>
                    </form>
                    <form action="MainController" method="post">
                        <input type="hidden" value="<%=i.getProductid()%>" name="productid"/>
                        <input type="submit" value="Delete Product" name="action"/>
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
            String msg = (String) request.getAttribute("msg4");
            if (msg != null && !msg.isEmpty()) {
        %>
            <div class="error-msg"><%= msg %></div>
        <%
            }
        %>
    </body>
</html>
