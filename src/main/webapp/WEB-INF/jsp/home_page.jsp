<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--библиотека Jsp для исп. циклов-->

<c:if test="${userId != null}">
    <c:redirect url="/user/${userId}"/>
</c:if>

<html>
<head>
    <title>Title</title>
</head>
<body>
<!--c:-это обращение к библиотеке, затем пишем цикл:
items- это коллекция в которой лежит список,
 var-это один элемент списка к которому мы будем обращаться, user-переменная-->
<c:forEach items="${usersList}" var="user">
    <a href="/user/${user.id}"> <!--/ссылка, к-ая перекидывает на user.добавляем атрибут, его название-->
            ${user.username} <br>  <!--//условие цикла(добавляем атрибут, его название,
            и перенос на след строку)-->
    </a>
</c:forEach>

</body>
<a href="/users">
    Список пользователей
</a>
<c:if test="${role == 'ADMIN'}">
    <a href="/admin">
        Админ панель
    </a>
</c:if>
<a href="#">
    Выход
</a>

<br> ${username} <br>


<c:if test="${thisIsMainUser == true}">
    This is main user page
</c:if>

<c:if test="${thisIsMainUser == false}">
    This is not main user page
</c:if>

</body>
</html>