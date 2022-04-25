<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--библиотека Jsp для исп. циклов-->

<c:if test="${role != 'ADMIN'}">
    <c:redirect url="/registration/${userId}"/>
</c:if>


<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/user/${userId}"> <!--кнопка профиля и ссылка на нее-->
    Профиль
</a> <br><br>

<c:forEach items="${userList}" var="user">
    <a href="/user/${user.id}"> <!--добавляем ссылку на каждого Usera -->
            ${user.username}
    </a>
    <form action="/admin-action" method="post">
        <button type="submit" name="delete ${user.id}">Delete</button>


        <c:if test="${user.status == 'ACTIVE'}">
            <button type="submit" name="block ${user.id}">Block</button>
        </c:if>

        <c:if test="${user.status == 'BLOCKED'}">
            <button type="submit" name="unblock ${user.id}">Unblock</button>
            <br>
        </c:if>
    </form>

</c:forEach>

</body>
</html>