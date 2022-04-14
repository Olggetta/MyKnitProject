<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--библиотека Jsp для исп. циклов-->
<c:if test="${userId == null}"> <!--//== сравнивает, != не равно-->
    <c:redirect url="/home/${userId}"/>
</c:if>

<html>
<head>
    <title>Каталог изделий</title>
</head>
<body>
${error}<br>
<form method="post" action="/catalog">

    <button type="submit">Описание изделия</button>
    <button type="submit">Заказать изделие</button>

    <a href="/news">
        Новости/Акции
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