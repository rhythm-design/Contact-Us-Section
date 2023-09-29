<link type="text/css" rel="stylesheet" href="css/contact-us.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <!-- change names if input fields -->
  <div class="contact-form">
    <div class="form-title">
      <h1> Contact Us</h1>
      <p> Please fill this form in decent manner</p>
    </div>
    <form action="ContactUsControllerServlet" method="post">
      <input type="hidden" name="command" value="add">
      <p class="form-label">Full Name: </p> 
      <input name="full_name" type="text" class="feedback-input" placeholder="Name"/>   
      <p class="form-label">Email: </p>       
      <input name="email" type="email" class="feedback-input" placeholder="Email"/>
      <p class="form-label">Message: </p>      
      <textarea name="message" class="feedback-input" placeholder="Comment"></textarea>
      <input type="submit" value="SUBMIT"/>
    </form>
  </div>
</body>
</html>
