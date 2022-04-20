<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--библиотека Jsp для исп. циклов-->

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

<form method="post" action="/users">
    <input type="text" name="userSearch"/>
    <button type="submit">Найти</button>
</form>
<br><br>

<!--c:-это обращение к библиотеке, затем пишем цикл:items- это коллекция в которой лежит список,
 // var-это один элемент списка к которому мы будем обращаться, user-переменная-->
 <c:forEach items="${usersList}" var="user">

<!-- если id равно,то выводятся Userа, если нет-то нет-->
<c:if test="${userId != user.id}">
    <a href="/user/${user.id}">
            ${user.username} <br>
    </a>
</c:if>
 </c:forEach>

</body>
</html>