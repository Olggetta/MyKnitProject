<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--библиотека Jsp для исп. циклов-->

<c:if test="${userId == null}"> <!--//не могут зайти не зарегистрированные пользователи-->
    <c:redirect url="/registration/${userId}"/>
</c:if>

<html>
<head>
    <link href="../css/style.css"  rel="stylesheet"/> <!--добавляем фото-->
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
<!--за ссылки отвечает ТЕГ <a,
выводим список пользователей из Userов-->
<a href="/catalog">
    Каталог изделий
</a>


<a href="/users">

    Список пользователей
    <a href="/news">
        Новости
    </a>

    <a href="/topics">
        Обсуждения
    </a>


</a>
<c:if test="${role == 'ADMIN'}"> <!--если роль верна  с Админом, то переход на Админ панель
                                  //== сравнивает, != не равно-->
    <a href="/admin">

        Админ панель
    </a>
</c:if>
<a href="/settings">
    Настройки
</a>
<a href="/user/${userId}">
    Профиль
</a>

<a href="/logout">

    Выход
</a>
<br> ${username} <br>


<!--добавляем фото-->
<div class="user-photo">
    <img src="../${image}" alt="user-photo"/><br>
</div>


<c:if test="${thisIsMainUser == true}">
    This is main user page <!--это главная страница пользователя-->
</c:if>

<c:if test="${thisIsMainUser == false}">
    This is not main user page <!--это не главная страница пользователя-->
</c:if>

</body>
</html>