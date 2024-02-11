<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import="com.caltech.clinic.pogo.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Owners</title>

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

    <i><center><h2 class="dynamic-heading">List Owners</h2></center></i>
    
    <%-- Check if ownersList is not null and not empty --%>
    <% 
        List<Owner> ownersList = (List<Owner>) request.getAttribute("ownersList");
        if (ownersList != null && !ownersList.isEmpty()) {
    %>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Pets</th>
                </tr>
            </thead>
            <tbody>
                <%-- Iterate over the ownersList and display owner information --%>
                <% 
                    for (Owner owner : ownersList) {
                %>
                        <tr>
                            <td><%= owner.getId() %></td>
                            <td><%= owner.getName() %></td>
                            <td><%= owner.getContact_no() %></td>
                            <td>
                                <%-- Check if owner has pets --%>
                                <% 
                                    List<Pet> pets = owner.getPets();
                                    if (pets != null && !pets.isEmpty()) {
                                %>
                                        <%-- Iterate over the owner's pets and display pet information --%>
                                        <ul>
                                            <% 
                                                for (Pet pet : pets) {
                                            %>
                                                    <li><%= pet.getName() %> (<%= pet.getSpecies() %>)</li>
                                            <%
                                                }
                                            %>
                                        </ul>
                                <%
                                    }
                                %>
                            </td>
                        </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    <% 
        } else {
    %>
        <p>No owners available.</p>
    <% 
        }
    %>
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
