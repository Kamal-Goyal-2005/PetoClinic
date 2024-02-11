<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #F3F3F3;
        }

        .login-container {
            margin: auto;
            max-width: 400px;
            background-color: #FFFFFF;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 5px #888888;
        }

        .login-header {
            text-align: center;
        }

        .login-form {
            margin-top: 20px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #CCCCCC;
            border-radius: 3px;
        }

        .btn-login {
            width: 100%;
            padding: 10px;
            background-color: #ADD8E6; /* Light Blue */
            color: #FFFFFF;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        .btn-register {
            width: 100%;
            padding: 10px;
            background-color: #ADD8E6; /* Light Blue */
            color: #000000;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        
                       /* Define a class for dynamic heading */
        .dynamic-heading {
            display: inline-block;
            animation: changeColor 3s infinite alternate; /* Change color every 3 seconds */
        }

        /* Define CSS animation for color change */
        @keyframes changeColor {
            0% { color: red; }
            25% { color: blue; }
            50% { color: green; }
            75% { color: orange; }
            100% { color: purple; }
        }
    </style>
</head>
<body>
<%
    String logoutParam = request.getParameter("logout");
    if (logoutParam != null && logoutParam.equals("true")) {
    	out.println("<center><p><h3>You have been logged out successfully.</h3></p></center>");
    }
%>

    <div class="container login-container">
        <div class="login-header">
            <i><center><h2 class="dynamic-heading">Sign-In</h2></center></i>
        </div>
        <div class="login-form">
            <form action="UserController">
                <div class="form-group">
                    <input type="text" name="username" placeholder="Username" required>
                </div>
                <div class="form-group">
                    <input type="password" name="password" placeholder="Password" required>
                </div>

                <div class="form-group">
                    <input type="submit" class="btn-login" value="Login">
                </div>
            </form>
            <form method="post" action="register.jsp">
                <div class="form-group">
                    <input type="submit" class="btn-register" value="Register">
                </div>
            </form>
        </div>
    </div>
<script>
    // You can add more dynamic changes using JavaScript if needed
    // For example, changing the heading text dynamically
    setInterval(function () {
        var heading = document.querySelector('.dynamic-heading');
    }, 5000); // Change text every 5 seconds
</script>
</body>
</html>
