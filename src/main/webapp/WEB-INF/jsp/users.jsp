<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--библиотека Jsp для исп. циклов-->
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--c:-это обращение к библиотеке, затем пишем цикл:items- это коллекция в которой лежит список,
 // var-это один элемент списка к которому мы будем обращаться, user-переменная-->
 <c:forEach items="${usersList}" var="user">
    ${user.username} <br> <!--условие цикла(добавляем атрибут, его название, и перенос на след строку)-->
</c:forEach>

</body>
</html>