<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/view-single-message.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="display: flex; justify-content: center">
    <a href="requests"><button class="top-btn" id="top-btn">Return back to requests</button></a>
</div>
<div class="contact-form">
    <div class="form-title">
        <h3 class="heading"> Customer Message</h3>
        <p class="heading-line"> Solve issue and archive request</p>
    </div>
    <div class="form-div">
        <form action="requests" method="post">
            <input type="hidden" name="command" value="shouldArchive">
            <input type="hidden" name="contactIdUnique" value="${requestScope.contactid}" />
            <input type="hidden" name="fromTable" value="activecontacts" />
            <input type="hidden" name="toTable" value="archievedcontacts" />

            <p class="form-label">Full Name:  </p>
            <input name="full_name" type="text" class="feedback-input" value="${requestScope.full_name}" readonly/>

            <p class="form-label">Email: </p>
            <input name="email" type="email" class="feedback-input" value="${requestScope.email}" readonly/>

            <p class="form-label">Message: </p>
            <textarea name="message" class="feedback-input" readonly>${requestScope.message}</textarea>

            <div class="submit-area">
                <input type="submit" value="ARCHIVE"/>
            </div>

        </form>
    </div>
</div>
</body>
</html>
