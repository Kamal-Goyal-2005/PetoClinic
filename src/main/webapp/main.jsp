<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PetoClinic</title>

    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <style>

        .container {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            margin-top: 50px;
            border-radius: 10px;
        }

        .pet-image {
            max-width: 200px;
            max-height: 200px;
            margin-bottom: 10px;
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
        
         body {
            background-image: url('https://img.freepik.com/free-vector/animal-background-with-cute-pets-illustration_53876-99291.jpg?size=626&ext=jpg&ga=GA1.1.1508639031.1707039131&semt=ais');
            background-size: cover; /* Ensures the image covers the entire background */
            background-repeat: no-repeat; /* Prevents the image from repeating */
            background-position: center; /* Centers the image */
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <i><center><h2 class="dynamic-heading">PetoClinic</h2></center></i>

    <div class="row">
        <div class="col-md-4">
            <div class="card">
                <div class="card-header">
                    <h5 class="dynamic-heading">Owners</h5>
                </div>
                <div class="card-body">
                    <a href="listOwners" class="btn btn-primary mb-2">List Owners</a>
                    <br/>
                    <a href="owners/addOwner.jsp" class="btn btn-primary">Add Owner</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-header">
                    <h5 class="dynamic-heading">Pets</h5>
                </div>
                <div class="card-body">
                    <a href="listPets" class="btn btn-primary mb-2">List Pets</a>
                    <br/>
                    <a href="addPet" class="btn btn-primary mb-2">Add Pet</a>

                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-header">
                    <h5 class="dynamic-heading">Consultations</h5>
                </div>
                <div class="card-body">
                    <a href="listConsultation" class="btn btn-primary mb-2">List Consultations</a>
                    <br/>
                    <a href="addConsultation" class="btn btn-primary">Add Consultation</a>
                </div>
            </div>
        </div>
    </div>

    
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
