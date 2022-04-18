<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="topic" value="${topic}"/>
${topic.get().author}<br>
${topic.get().topicName}<br>
${topic.get().message}<br>
${topic.get().createDate}<br><br>

<form method="post" action="/add-comment/${topic.get().id}">
    <input type="text" name="comment" placeholder="Input comment here..." autofocus>
    <button type="submit">Отправить</button>
</form>
<br><br>

<c:forEach items="${comments}" var="comment"> <!--выводим все комментарии и выводим единичный из списка-->
    <a href="/user/${comment.authorId}">
            ${comment.authorUsername}
    </a><br>
    ${comment.comment}<br>
    ${comment.createdDate}


    <c:if test="${userId == comment.authorId || role == 'ADMIN'}">
        <!--если юзер равен комментариям автора,то кнопка выводится только возле его комментария.
        Либо если это админ- кнопка будет отобращаться возле любого коммента-->
        <form method="post" action="/topic/${comment.topicId}">
            <button type="submit" name="deleteComment" value="${comment.id}">Удалить</button>
            <!--Создаем кнопку удалить:тип, имя,значение,название.
            С помощью post-мы отправляем кнопку на контролер-->
        </form>
    </c:if>

    <br>
</c:forEach><br>

</body>
</html>