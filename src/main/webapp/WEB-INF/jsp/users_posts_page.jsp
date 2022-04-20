<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${userId == null}"> <!--//не могут зайти не зарегистрированные пользователи-->
    <c:redirect url="/registration/${userId}"/>
</c:if>


<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/user/${userId}">
    Профиль
</a>

<a href="/logout">
    Выход
</a>
</a> <br><br>

<c:forEach items="${messagesList}" var="message"> <!--messagesList- передает все сообщения,
    var="message"> - отдельное одно сообщение-->
    <a href="/user/${message.ownerId}">
            ${message.ownerNickname}
    </a><br>
    ${message.text} <br>
    ${message.postTime} <br><br>
</c:forEach>

<form method="post" action="/news">
    <input type="text" name="userMessage" autofocus/>
    <button type="submit">Отправить</button>
</form>

</body>
</html>