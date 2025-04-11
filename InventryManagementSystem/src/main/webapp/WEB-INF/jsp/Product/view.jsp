<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered Users</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
</head>
<body>

<jsp:include page="modules/header.jsp"></jsp:include> 

<div class="container mt-4">
    <h4>Registered Users</h4>
    <div class="card">
        <div class="card-body">
            <input type="text" id="searchInput" class="form-control mb-3" placeholder="Search for users...">
            
            <table id="userTable" class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Address</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Zip</th>
                    </tr>
                </thead>
                <tbody>
                
                  
  
  
 
                           <tr>
                        <td>${user.id }</td>
                        <td>${user.firstName }</td>
                        <td>${user.lastName }</td>
                        <td>${user.email }</td>
                        <td>${user.phone }</td>
                        <td>${user.address }</td>
                        <td>${user.city }</td>
                        <td>${user.state }</td>
                        <td>${user.zip }</td>
                    </tr>
                 
                   
                 
                </tbody>
            </table>
        </div>
    </div>
</div>



<!-- Sidebar Start -->
<div class="sidenav-menu">
    <!-- Logo -->
    <a href="home.jsp" class="logo">
        <span class="logo-light">
            <span class="logo-lg"><img src="resources/assets/images/logo.png" alt="logo"></span>
        </span>
        <span class="logo-dark">
            <span class="logo-lg"><img src="resources/assets/images/logo-dark.png" alt="dark logo"></span>
        </span>
    </a>

    <!-- Sidebar Toggle Buttons -->
    <button class="button-sm-hover"><i class="ti ti-circle align-middle"></i></button>
    <button class="button-close-fullsidebar"><i class="ti ti-x align-middle"></i></button>

    <div data-simplebar>
        <ul class="side-nav">

            <li class="side-nav-title">Navigation</li>

            <!-- Dashboard (Common) -->
            <li class="side-nav-item">
                <a href="dashboard" class="side-nav-link">
                    <span class="menu-icon"><i class="ti ti-home"></i></span>
                    <span class="menu-text"> Dashboard </span>
                </a>
            </li>

            <!-- Only for Admin -->
            <c:if test="${sessionScope.loggedInUser.role == 'ADMIN'}">
                <li class="side-nav-title">Admin Panel</li>

                <li class="side-nav-item">
                    <a href="createEventForm" class="side-nav-link">
                        <span class="menu-icon"><i class="ti ti-calendar"></i></span>
                        <span class="menu-text"> Create Event </span>
                    </a>
                </li>

                <li class="side-nav-item">
                    <a href="allEvents" class="side-nav-link">
                        <span class="menu-icon"><i class="ti ti-list"></i></span>
                        <span class="menu-text"> View All Events </span>
                    </a>
                </li>

                <li class="side-nav-item">
                    <a href="viewRegistrations" class="side-nav-link">
                        <span class="menu-icon"><i class="ti ti-users"></i></span>
                        <span class="menu-text"> View Registrations </span>
                    </a>
                </li>

                <li class="side-nav-item">
                    <a href="generateCertificates" class="side-nav-link">
                        <span class="menu-icon"><i class="ti ti-file-text"></i></span>
                        <span class="menu-text"> Generate Certificates </span>
                    </a>
                </li>
            </c:if>

            <!-- Only for Student -->
            <c:if test="${sessionScope.loggedInUser.role == 'STUDENT'}">
                <li class="side-nav-title">Student Panel</li>

                <li class="side-nav-item">
                    <a href="availableEvents" class="side-nav-link">
                        <span class="menu-icon"><i class="ti ti-calendar-event"></i></span>
                        <span class="menu-text"> Available Events </span>
                    </a>
                </li>

                <li class="side-nav-item">
                    <a href="myRegistrations" class="side-nav-link">
                        <span class="menu-icon"><i class="ti ti-checklist"></i></span>
                        <span class="menu-text"> My Registrations </span>
                    </a>
                </li>

                <li class="side-nav-item">
                    <a href="myCertificates" class="side-nav-link">
                        <span class="menu-icon"><i class="ti ti-certificate"></i></span>
                        <span class="menu-text"> My Certificates </span>
                    </a>
                </li>
            </c:if>

            <!-- Logout -->
            <li class="side-nav-item">
                <a href="logout" class="side-nav-link">
                    <span class="menu-icon"><i class="ti ti-logout"></i></span>
                    <span class="menu-text"> Logout </span>
                </a>
            </li>

        </ul>
    </div>
</div>
<!-- Sidebar End -->


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function() {
        var table = $('#userTable').DataTable({
            "paging": true,
            "searching": true,
            "lengthChange": false,
            "pageLength": 5
        });

        $('#searchInput').on('keyup', function () {
            table.search(this.value).draw();
        });
    });
</script>

<jsp:include page="modules/footer.jsp"></jsp:include> 

</body>
</html>
