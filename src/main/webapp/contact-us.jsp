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
      <h1 class="heading"> Contact Us</h1>
      <p class="heading-line"> Please fill this form in decent manner</p>
    </div>
    <div class="form-div">
      <form action="ContactUsControllerServlet" method="post">
        <input type="hidden" name="command" value="add">

        <p class="form-label">Full Name: <span class="field-important">*</span> </p> 
        <input name="full_name" type="text" class="feedback-input" placeholder="Full Name" required/>   
        
        <p class="form-label">Email: <span class="field-important">*</span></p>       
        <input name="email" type="email" class="feedback-input" placeholder="Email" required/>
        <p class="email-type-label">example@example.com</p>  
        
        <p class="form-label">Message: <span class="field-important">*</span></p>      
        <textarea name="message" class="feedback-input" placeholder="Message" required></textarea>
        
        <div class="submit-area">
          <input type="submit" value="SUBMIT"/>
        </div>
        
      </form>
    </div>
  </div>
</body>
</html>
