<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${userId != null}">
    <c:redirect url="/user/${userId}"/>
</c:if>
<html>
<head>
    <title>Title</title>
</head>
<body>
${error}<br>
<form method="post" action="/registration">

    <!--ДОБАВЛЯЕМ ФОРМУ ДЛЯ КНОПОК-->

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

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
button - это кнопка на сайте, с названием Логин,
"btn btn-primary" - это класс СС -шрифт-->

<a href="/login">
    <button class="btn btn-primary">Login</button>
</a>
</body>
</html>


<!--Писала до подключения форм кнопок
<form method="post" action="/login">
<input type="text" name="username" placeholder="Username"/><br>
<input type="password" name="password" placeholder="Password"><br>
<button>Login</button> //выводим название кнопки/
<a href="/registration">Registration</a> //ссылка, к-ая перекидывает на registration.
//добавляем атрибут, его название///

</form>

<form method="post" action="/login">
<input type="text" name="username" placeholder="Username"/><br>
<input type="password" name="password" placeholder="Password"><br>
<button>Login</button> //выводим название кнопки//
<a href="/registration">Registration</a> //ссылка, к-ая перекидывает на registration.
//добавляем атрибут, его название-->
