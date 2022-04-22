<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--библиотека Jsp для исп. циклов-->

<c:if test="${userId == null}"> <!--//не могут зайти не зарегистрированные пользователи-->
<c:redirect url="/registration/${userId}"/>
</c:if>


<html>
<head>
    <title>Каталог изделий</title>
</head>
<body>
${error}<br>
<form method="post" action="/catalog">
    <a href="/product_page">
        Выбрать изделие
    </a>

    <a href="/order">
        Заказать изделие
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