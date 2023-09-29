<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<button><a href="/category/view-add ">add</a></button>
<table>
    <tr>
        <td>id</td>
        <td>code</td>
        <td>name</td>
        <td>actioin</td>
    </tr>
    <tbody>
    <c:forEach items="${list}" var="ca">
        <tr>
            <td>${ca.id}</td>
            <td>${ca.code}</td>
            <td>${ca.name}</td>
            <td>
                <button><a href="">detail</a></button>
                <button><a href="/category/view-update/${ca.id}">update</a></button>
                <button><a href="/category/delete/${ca.id}">delete</a></button>

            </td>

        </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>