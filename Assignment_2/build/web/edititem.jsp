<%@page import="Model.Product"%>
<%@page import="DAO.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Product</title>
    <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                margin: 0;
                padding: 0;
            }

            form {
                max-width: 400px;
                margin: 0 auto;
                padding: 20px;
                background-color: #fff;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                display: grid;
                grid-gap: 10px;
            }

            input[type="text"], input[type="password"] {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }


            input[type="submit"] {
                display: block;
                width: 100%;
                padding: 10px;
                background-color: #333;
                color: #fff;
                border: none;
                border-radius: 3px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #555;
            }

            input[type="submit"]:focus {
                outline: none;
            }

        </style>
</head>
<body>
    <h1>Edit Product</h1>
    <%
        int productid = Integer.parseInt(request.getParameter("productid"));
        Product p = ProductDAO.getProductByID(productid);
        if (p != null) {
    %>
    <form action="MainController" method="post">
        <label for="productname">Product Name:</label>
        <input type="text" value="<%= p.getProductname() %>" name="productname" id="productname"/><br>

        <label for="description">Description:</label>
        <input type="text" value="<%= p.getDesciption()%>" name="description" id="description"/><br>

        <label for="price">Price:</label>
        <input type="number" value="<%= p.getPrice() %>" name="price" id="price"/><br>

        <label for="gender">Gender:</label>
        <input type="text" value="<%= p.getGender() %>" name="gender" id="gender"/><br>

        <label for="type">Type:</label>
        <input type="text" value="<%= p.getType() %>" name="type" id="type"/><br>

        <label for="size">Size:</label>
        <input type="text" value="<%= p.getSize() %>" name="size" id="size"/><br>

        <input type="hidden" name="productid" value="<%= p.getProductid() %>"/>

        <input type="submit" value="Update" name="action"/>
    </form>
    <%
        }
    %>
</body>
</html>
