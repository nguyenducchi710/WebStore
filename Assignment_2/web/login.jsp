<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login - Online Store</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .logo {
            margin-bottom: 20px;
        }

        .login-form input[type="text"],
        .login-form input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .login-form input[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            padding: 10px 20px;
            cursor: pointer;
        }

        .register-link {
            margin-top: 10px;
            display: block;
        }

        .error-msg {
            color: red;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <img src="img/Logo.png" alt="Logo" class="logo">
        <form class="login-form" action="MainController" method="post">
            <input type="text" name="username" placeholder="Enter your username" required=""><br>
            <input type="password" name="password" placeholder="Enter your password" required=""><br>
            <input type="submit" value="Login" name="action">
        </form>
        <a href="MainController?action=register" class="register-link">Register here!</a>
        <%
            String msg = (String) request.getAttribute("msg");
            if (msg != null && !msg.isEmpty()) {
        %>
            <div class="error-msg"><%= msg %></div>
        <%
            }
        %>
    </div>
</body>
</html>
