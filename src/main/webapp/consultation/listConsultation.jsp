<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.caltech.clinic.pogo.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Consultations</title>

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
    <i><center><h2 class="dynamic-heading">List Consultations</h2></center></i>

    <% 
        List<Consultation> consultationsList = (List<Consultation>) request.getAttribute("consultationsList");
        if (consultationsList != null && !consultationsList.isEmpty()) {
    %>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Pet</th>
                    <th>Species</th>
                    <th>Diagnosis</th>
                    <th>Date</th>
                    <th>Fee</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    for (Consultation consultation : consultationsList) {
                %>
                        <tr>
                            <td><%= consultation.getId() %></td>
                            <td><%= consultation.getPet().getName() %></td>
                            <td><%= consultation.getPet().getSpecies() %></td>
                            <td><%= consultation.getDiagnosis() %></td>
                            <td><%= consultation.getDate() %></td>
                            <td><%= consultation.getFee() %></td>
                        </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    <% 
        } else {
    %>
        <p>No consultations available.</p>
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
