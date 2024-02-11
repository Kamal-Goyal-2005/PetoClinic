<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.caltech.clinic.pogo.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Pet</title>

    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <style>
        .container {
            margin-top: 50px;
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

<div class="container">
    <i><center><h2 class="dynamic-heading">Add Pet</h2></center></i>
    <form method="post" action="addOnePet" class="mt-3">

        <!-- Pet Form Fields -->
        <div class="form-group">
            <label for="name">Pet Name:</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>

        <div class="form-group">
            <label for="species">Species:</label>
            <input type="text" class="form-control" id="species" name="species" required>
        </div>

        <div class="form-group">
            <label for="ownerId">Owner:</label>
            <select class="form-control" id="ownerid" name="ownerid" required>
                <option value="" disabled selected>Select Owner</option>
                <% 
                    List<Owner> ownersList = (List<Owner>) request.getAttribute("ownersList");
                    if (ownersList != null) {
                        for (Owner owner : ownersList) {
                %>
                            <option value="<%= owner.getId() %>"><%= owner.getName() %></option>
                <%
                        }
                    } else {
                %>
                        <!-- Handle the case when ownersList is null -->
                        <option value="-1">Owners List Not Available</option>
                <%
                    }
                %>
            </select>
        </div>

        <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Add Pet</button>
    </form>
</div>

<!-- Bootstrap JS (Optional, only if you need Bootstrap JavaScript features) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    // You can add more dynamic changes using JavaScript if needed
    // For example, changing the heading text dynamically
    setInterval(function () {
        var heading = document.querySelector('.dynamic-heading');
    }, 5000); // Change text every 5 seconds
</script>
</body>
</html>
