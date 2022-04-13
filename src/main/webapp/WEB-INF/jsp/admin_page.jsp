<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--библиотека Jsp для исп. циклов-->

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
    <a href="/delete/${user.id}"> <!--добавляем кнопки (удалить/заблокировать)-->
        Delete
    </a> <br>

    <!--делаем проверку. Если User-Aсtive,то появляется кнопка Block-->
    <c:if test="${user.status == 'ACTIVE'}">
        <a href="/block/${user.id}">
            Block
        </a> <br>
    </c:if>

    <!--делаем проверку. Если User-ACtive,то появляется кнопка Block-->
    <c:if test="${user.status == 'BLOCKED'}">
        <a href="/unblock/${user.id}">
            Unblock
        </a> <br>
    </c:if>

</c:forEach>

</body>
</html>