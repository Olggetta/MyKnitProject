<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--библиотека Jsp для исп. циклов-->

<c:if test="${userId == null}"> <!--//не cмогут зайти не зарегистрированные пользователи-->
    <c:redirect url="/registration/${userId}"/>
</c:if>


<head>
    <meta charset="UTF-8">
    <title>Создать изделие</title>
</head>
<body>
${error}<br>
<form action="/admin-action" method="post">
    <button type="submit" name="create_product ${user.id}">Создать изделие</button>


    <a href="/user/${userId}">

        Профиль
    </a>

    <a href="/logout">
        Выход
    </a>

</form>
</body>
</html>