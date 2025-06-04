<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/06/2025
  Time: 5:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Selected Condiments</title>
</head>
<body>
    <h1>Your selected: </h1>
    <c:choose>
        <c:when test="${not empty condiments}">
            <c:forEach var="c" items="${condiments}" varStatus="loop">
                <c:out value="${c}"/>
                <c:if test="${!loop.last}">, </c:if>
            </c:forEach>
        </c:when>
        <c:otherwise>
            None
        </c:otherwise>
    </c:choose>
    <br/><br/>
    <a href="/">Back</a>
</body>
</html>
