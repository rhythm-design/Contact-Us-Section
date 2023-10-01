<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/login-page.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="all-functions">
        <a href="${pageContext.request.contextPath}"> <button class="btn1">Home</button> </a>
    </div>
    <div class="container">
        <h1>Login</h1>
            <c:if test="${not empty errorMessage}">
                <p style="color: red;">${errorMessage}</p>
            </c:if>
            <form action="login" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required class="field"><br>
    
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required class="field"><br>
                <input type="hidden" name="login-action" value="login">
                <div class="btn-div">
                    <input type="submit" value="Login" class="btn">
                </div>
            </form>
    </div>	
</div>
</body>
</html>

