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
        }
        .btn {
            border-radius:15px;

        }
        .container a{
            text-decoration: none;
        }

    </style>
</head>
<body>
<div class="container">
    <h2>Welcome, <c:out value="${user.name}"/></h2>
    <h4>Tv Shows</h4>
    <table class="table">
        <thead>
        <tr>
            <th>Show</th>
            <th>Network</th>
            <th>Avg Rating</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${shows}" var="show">
            <tr>
                <td><a href="/shows/${show.id}">${show.title}</a></td>
                <td>${show.network}</td>
                <td>${show.ratingList.size()}</td>
<%--                <td>--%>
<%--                    <c:choose>--%>
<%--                        <c:when test="${idea.userLikes.contains(user)}">--%>
<%--                            <a href="/unlike/${idea.id}">Unlike</a>--%>
<%--                        </c:when>--%>
<%--                        <c:otherwise>--%>
<%--                            <a href="/like/${idea.id}">Like</a>--%>
<%--                        </c:otherwise>--%>
<%--                    </c:choose>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button class="btn btn-info"><a href="/shows/new">Add a show</a></button>
</div>
</body>
</html>
