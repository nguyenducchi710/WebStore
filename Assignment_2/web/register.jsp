<%-- 
    Document   : register
    Created on : Aug 22, 2023, 10:42:57 PM
    Author     : nguye
--%>

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
        <form action="MainController" method="post">
            <label for="registername">Full Name</label>
            <input type="text" id="registername" name="registername" placeholder="Enter your FullName" required=""/>

            <label for="registeraddress">Address</label>
            <input type="text" id="registeraddress" name="registeraddress" placeholder="Enter your address" required=""/>

            <label for="registerphone">Phone Number</label>
            <input type="text" id="registerphone" name="registerphone" placeholder="Enter your PhoneNumber" required=""/>

            <label for="registeremail">Email</label>
            <input type="text" id="registeremail" name="registeremail" placeholder="Enter your email" required=""/>

            <label for="registerusername">Username</label>
            <input type="text" id="registerusername" name="registerusername" placeholder="Enter your username" required=""/>

            <label for="registerpassword">Password</label>
            <input type="password" id="registerpassword" name="registerpassword" placeholder="Enter your password" required=""/>

            <input type="submit" value="Register" name="action">
        </form>

    </body>
</html>
