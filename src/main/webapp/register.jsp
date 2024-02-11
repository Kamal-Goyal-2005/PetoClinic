<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #F3F3F3;
        }

        .register-container {
            margin: auto;
            max-width: 400px;
            background-color: #FFFFFF;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 5px #888888;
        }

        .register-header {
            text-align: center;
        }

        .register-form {
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

        .btn-register {
            width: 100%;
            padding: 10px;
            background-color: #ADD8E6; /* Light Blue */
            color: #FFFFFF;
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
    <form action="RegisterController" method="post">
    <div class="container register-container">
        <div class="register-header">
            <i><center><h2 class="dynamic-heading">Register</h2></center></i>
        </div>
        <div class="register-form">
                <div class="form-group">
                    <input type="text" name="name" placeholder="Name" required>
                </div>
                <div class="form-group">
                    <input type="text" name="phone" placeholder="Phone Number" required>
                </div>
                <div class="form-group">
                    <input type="password" name="password" placeholder="Password" required>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn-register" value="Register">
                </div>
        </div>
    </div>
    </form>
<script>
    // You can add more dynamic changes using JavaScript if needed
    // For example, changing the heading text dynamically
    setInterval(function () {
        var heading = document.querySelector('.dynamic-heading');
    }, 5000); // Change text every 5 seconds
</script>    
</body>
</html>
