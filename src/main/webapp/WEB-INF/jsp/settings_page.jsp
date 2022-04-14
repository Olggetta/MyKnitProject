<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--библиотека Jsp для исп. циклов-->

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form method="post" action="/add-photo" enctype="multipart/form-data">
    Выберите фото<br>
    <input type="file" name="image"><br>
    <button type="submit">Сохранить</button>
    <a href="/user/${userId}">
        Профиль
    </a>
    <a href="/logout">
        Выход
    </a>

    <c:if test="${userId == null}">
        <c:redirect url="/register_page/${userId}"/>
    </c:if>
</form>
</body>
</html>