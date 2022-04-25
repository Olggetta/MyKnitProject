<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--библиотека Jsp для исп. циклов-->

<c:if test="${userId == null}"> <!--//не cмогут зайти не зарегистрированные пользователи-->
    <c:redirect url="/registration/${userId}"/>
</c:if>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Заказать изделие</title>
</head>
<body>
<c:set var="order" value="${order}"/>
${order.get().customername}<br>
${order.get().customerphone}<br>
${order.get().customeraddress}<br>
${order.get().message}<br>

</body>
</html>