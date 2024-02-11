<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.caltech.clinic.pogo.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Consultation</title>

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

    <i><center><h2 class="dynamic-heading">Add Consultation</h2></center></i>
    <form method="post" action="addOneConsultation" class="mt-3">

        <!-- Consultation Form Fields -->
        <div class="form-group">
            <label for="petId">Pet:</label>
            <select class="form-control" id="petId" name="petId" required>
                <option value="" disabled selected>Select Pet</option>
                <% 
                    List<Pet> petsList = (List<Pet>) request.getAttribute("petsList");
                    if (petsList != null) {
                        for (Pet pet : petsList) {
                %>
                            <option value="<%= pet.getId() %>"><%= pet.getName() %> - <%= pet.getSpecies() %></option>
                <%
                        }
                    }
                %>
            </select>
        </div>

        <div class="form-group">
            <label for="diagnosis">Diagnosis:</label>
            <input type="text" class="form-control" id="diagnosis" name="diagnosis" required>
        </div>

        <div class="form-group">
            <label for="consultationDate">Consultation Date:</label>
            <input type="date" class="form-control" id="consultationDate" name="consultationDate" required>
        </div>

        <div class="form-group">
            <label for="fee">Consultation Fee:</label>
            <input type="number" class="form-control" id="fee" name="fee" required>
        </div>

        <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Add Consultation</button>
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
