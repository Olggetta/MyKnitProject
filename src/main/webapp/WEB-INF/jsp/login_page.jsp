<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--библиотека Jsp для исп. циклов-->

<c:if test="${userId != null}">
    <c:redirect url="/user/${userId}"/>
</c:if>
<html>
<head>
    <title>Login</title>

    <!--1.ДОБАВЛЯЕМ ФОРМУ ДЛЯ КНОПОК-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
${error}<br>
<form method="post" action="/login">

    <!--2.ДОБАВЛЯЕМ ФОРМУ ДЛЯ КНОПОК-->

    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Username</label>
        <input type="text" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input type="password" name="password" class="form-control" id="exampleInputPassword1">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>

</form>
<!--за ссылки отвечает ТЕГ <a,
button - это кнопка на сайте, с названием РЕГИСТРАЦИЯ,
"btn btn-primary" - это класс СС -шрифт-->
<a href="/registration">
    <button class="btn btn-primary">Registration</button>
</a>
</body>
</html>
