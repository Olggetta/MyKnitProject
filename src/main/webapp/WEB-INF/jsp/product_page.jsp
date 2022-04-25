<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--библиотека Jsp для исп. циклов-->

<c:if test="${userId == null}"> <!--//не cмогут зайти не зарегистрированные пользователи-->
    <c:redirect url="/registration/${userId}"/>
</c:if>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Вязанные изделия</title>
</head>
<body>
${error}<br>
<form method="post" action="/product">
    <a href="/create-product">
        Создать изделие
    </a>


    <a href="/user/${userId}">
        Профиль
    </a>

    <a href="/logout">
        Выход
    </a>
</form>
</body>
</html>