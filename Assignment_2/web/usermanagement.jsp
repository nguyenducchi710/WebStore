<%-- 
    Document   : usermanagement
    Created on : Aug 23, 2023, 4:17:39 PM
    Author     : nguye
--%>

<%@page import="DAO.UserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.User"%>
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
        <h1>User Management</h1>
        <%
            String keyword = request.getParameter("keyword");

        %>
        <form action="MainController" method="post">
            <input type="hidden" value="searchuser" name="action"/>
            <p>Search Product: <input type="text" name="txtsearch" value="<%= (keyword != null) ? keyword : ""%>"/> <input type="submit" value="Search"/></p>
        </form>
        <%
            ArrayList<User> list = (ArrayList) request.getAttribute("list");
            if (list != null && list.size() > 0) {

        %>
        <h2>Search List</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Username</th>
                <th>Password</th>
                <th>RoleID</th>
                <th>Action</th>
            </tr>
            <%                for (User i : list) {
            %>
            <tr>
                <td><%=i.getUserid()%></td>
                <td><%=i.getFullname()%></td>
                <td><%=i.getAddress()%></td>
                <td><%=i.getPhone()%></td>
                <td><%=i.getEmail()%></td>
                <td><%=i.getUsername()%></td>
                <td><%=i.getPassword()%></td>
                <td><%=i.getRole()%></td>
                <td>
                    <form action="MainController" method="post">
                        <input type="hidden" value="<%=i.getUserid()%>" name="userid"/>
                        <input type="submit" value="Delete User" name="action"/>
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
            ArrayList<User> list2 = UserDAO.getAllUser();
            if (list2 != null && list2.size() > 0) {

        %>
        <h2>User List</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Username</th>
                <th>Password</th>
                <th>RoleID</th>
                <th>Action</th>
            </tr>
            <%                for (User i : list2) {
            %>
            <tr>
                <td><%=i.getUserid()%></td>
                <td><%=i.getFullname()%></td>
                <td><%=i.getAddress()%></td>
                <td><%=i.getPhone()%></td>
                <td><%=i.getEmail()%></td>
                <td><%=i.getUsername()%></td>
                <td><%=i.getPassword()%></td>
                <td><%=i.getRole()%></td>
                <td>
                    <form action="MainController" method="post">
                        <input type="hidden" value="<%=i.getUserid()%>" name="userid"/>
                        <input type="submit" value="Delete User" name="action"/>
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
            String msg = (String) request.getAttribute("msg3");
            if (msg != null && !msg.isEmpty()) {
        %>
            <div class="error-msg"><%= msg %></div>
        <%
            }
        %>
    </body>
</html>
