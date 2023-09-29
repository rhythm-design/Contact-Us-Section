<%--
  Created by IntelliJ IDEA.
  User: rhythm
  Date: 28/09/23
  Time: 10:14 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contacts Data</title>
</head>
<body>
    <h2>All Active contacts here</h2>
    <c:forEach var="contact" items="${ACTIVE_CONTACT_LIST}">
        ${contact} <br />
    </c:forEach>

    <h2>All Archieved contacts here</h2>
    <c:forEach var="contact" items="${ARCHIEVED_CONTACT_LIST}">
        ${contact} <br />
    </c:forEach>
</body>
</html>
