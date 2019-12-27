<%-- 
    Document   : Register
    Created on : Dec 25, 2019, 4:05:49 PM
    Author     : Bagus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration and Login Form</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                <div id="pop_up"></div>
                <form class="register-form" name="form1" action="Register" method="post" onsubmit="validatePhone() & validateFirstname() & validateLastname() & validateEmail()">
                    <h1>Registration</h1>
                    <input type="text" name="mobile" placeholder="Mobile number"/>
                    <input type="text" name="firstname" placeholder="First name"/>
                    <input type="text" name="lastname" placeholder="Last name"/>
                    <p class="DOF">Date of Birth</p>
                    <input type="date" name="birthday"/>
                    <input type="radio" name="gender" value="male">
                    <span class="radiotext">Male</span>
                    <input type="radio" name="gender" value="female">
                    <span class="radiotext">Female</span>
                    <input type="text" name="email" placeholder="Email"/>
                    <input type="submit" name="submit" value="Register">
                </form>
            </div>
            <div class="footer">
            <button type="button" onclick="javascript:window.location=login.jsp">Login</button>
            </div>
        </div>
                
        <script src='https://code.jquery.com/jquery-3.4.1.min.js'></script>
        
        <script src="validation.js"></script>
                
    </body>
</html>
