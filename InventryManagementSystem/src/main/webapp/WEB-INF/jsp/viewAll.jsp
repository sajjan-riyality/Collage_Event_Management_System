<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Registrations</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<%@ include file="modules/header.jsp" %>
<%-- <jsp:include page="modules/header.jsp"></jsp:include> 
 --%><div class="container mt-4">
    <h2 class="mb-3">Event Registrations</h2>
    <table class="table table-bordered table-hover">
        <thead class="table-dark">
            <tr>
                <th>Registration ID</th>
                <th>Student Name</th>
                <th>Email</th>
                <th>Event Name</th>
                <th>Registered At</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="reg" items="${registrations}">
                <tr>
                    <td>${reg.id}</td>
                    <td>${reg.studentName}</td>
                    <td>${reg.email}</td>
                    <td>${reg.eventName}</td>
                    <td>${reg.registeredAt}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
