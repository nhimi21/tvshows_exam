<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Shows</title>
    <style>

    </style>
</head>
<body>
<div class="container">
    <h4>Create a new show:</h4>
    <form:form method="POST" action="/shows/new" modelAttribute="show">
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
        <form:input path="creator" type="hidden" value="${userId}"/>
        <a href="/shows">Back</a>
    </form:form>
</div>
</body>
</html>
