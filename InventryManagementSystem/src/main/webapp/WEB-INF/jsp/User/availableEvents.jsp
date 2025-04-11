

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:include page="../modules/userHeader.jsp" />




</head>
<body>

<div class="container py-5">
    <h2 class="text-center event-section-title mb-5 text-primary">📅 Upcoming College Events</h2>

    <div class="row g-4 justify-content-center">
        <c:forEach var="event" items="${events}">
            <div class="col-md-6 col-lg-4 d-flex">
                <div class="card event-card shadow-sm flex-fill">
                    <c:if test="${not empty event.eventImage and not empty event.eventImage.imageUrl}">
                        <img src="${event.eventImage.imageUrl}" class="event-img card-img-top" />
                    </c:if>
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title text-dark">${event.title}</h5>
                        <p class="card-text mb-1"><strong>📍 Location:</strong> ${event.location}</p>
                        <p class="card-text mb-1"><strong>📆 Date:</strong> ${event.date}</p>
                        <p class="card-text text-muted mb-3">${event.description}</p>
                        <a href="/registerEvent?id=${event.id}" class="btn btn-outline-primary btn-sm mt-auto w-100">Register Now</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<jsp:include page="../modules/footer.jsp" /> 

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
 