<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Shows</title>
    <style>
        .btn a{
            text-decoration: none;
            color:black;
            font-weight: bold;
            padding: 10px;
        }
        .btn {
            border-radius:15px;
        }
    </style>
</head>
<body>
<div  class="container">
    <h3><c:out value="${show.title}"/></h3>
    <p>Network: <c:out value="${show.network}"/></p>
    <hr>
    <h2>Users who rated your show:</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${show.ratingList}" var="rating">
            <tr>
                <td>${show.ratingList}</td>
                <td>${show.avg}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    <br>
    <c:choose>
        <c:when test="${show.creator.id == loggedInUser}">
            <button class="btn btn-info"><a href="/shows/${show.id}/edit">Edit</a></button>
        </c:when>
        <c:otherwise>
            <button class="btn btn-info"><a href="/shows">Back</a></button>
        </c:otherwise>
    </c:choose>
    <hr>

<form:form method="POST" action="/shows/${show.id}/rating" modelAttribute="show">
    <p>
        <form:label path="avg">Leave a Rating:</form:label>
        <form:input type="double" path="avg"/>
        <form:errors path="avg" cssStyle="color: red"/>
        <input type="submit" class="btn btn-info" value="Rate!" />
    </p>
    </form:form>
</div>

</body>
</html>
