<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
</a><br><br>

<c:set var="topic" value="${topic}"/>
${topic.get().author}<br>
${topic.get().topicName}<br>
${topic.get().message}<br>

<c:if test="${comment.pathToCommentImage != null}">
    <img src="../${topic.get().pathToTopicImage}"><br>
</c:if>
${topic.get().createDate}<br>

<c:if test="${userId == topic.get().authorId || role == 'ADMIN'}">
    <form method="post" action="/delete-topic">
        <button type="submit" name="deleteTopicButton" value="${topic.get().id}">Удалить</button>
    </form>
</c:if>

<form method="post" action="/add-comment/${topic.get().id}" enctype="multipart/form-data">
    <!--enctype="multipart/form-data" - добавляем фото-->
    <input type="text" name="comment" placeholder="Input comment here..." autofocus><br>
    <input type="file" name="commentImage"><br>
    <button type="submit">Отправить</button>
</form>
<br><br>

<c:forEach items="${comments}" var="comment"> <!--выводим все комментарии и выводим единичный из списка-->
    <a href="/user/${comment.authorId}">
            ${comment.authorUsername}
    </a><br>
    ${comment.comment}<br>

    <c:if test="${comment.pathToCommentImage != null}">
        <img src="../${comment.pathToCommentImage}"/><br>
    </c:if>
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