<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${userId == null}"> <!--не могут зайти не зарегистрированные пользователи-->
    <c:redirect url="/registration/${userId}"/>
</c:if>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!--форма для картинки-->
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
</form>
</body>
</html>