<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Shows</title>
</head>
<body>
<div class="container">
    <h4><c:out value="${show.title}"/></h4>
    <form:form method="POST" action="/shows/${show.id}/edit" modelAttribute="show">
        <input type="hidden" name="_method" value="put">
        <table>
            <tr>
                <td>
                    <form:label path="title">Title:</form:label>
                </td>
                <td>
                    <form:input type="text" path="title"/>
                    <form:errors path="title" cssStyle="color: red"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="network">Network:</form:label>
                </td>
                <td>
                    <form:input type="text" path="network"/>
                    <form:errors path="network" cssStyle="color: red"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" class="btn btn-info" style="width: 100%;margin-top: 20px" value="Create" /></td>
            </tr>
        </table>
    </form:form>
    <a href="/">Go Back</a>
    <form action="/shows/${show.id}/delete" method="post">
        <input type="submit" class="btn btn-danger" value="Delete"/>
        <input type="hidden" name="_method" value="delete">
    </form>
</div>
</body>
</html>
