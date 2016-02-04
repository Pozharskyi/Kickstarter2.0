
<%@page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <title>Registration</title>
    </head>
    <body>
        <h3>Registration</h3>
        <hr/>
        <form name="RegistrationForm" method="POST" action="controller">
            <input type="hidden" name="command" value="registration"/>
                Login:<br/>
                <input type="text" name="login" value=""><br/>
                Password:<br/>
                <input type="password" name="password" value=""><br/>
                Email:<br/>
                <input type="text" name="email" value=""><br/>
                FirstName:<br/>
                <input type="text" name="firstName" value=""><br/>
                LastName:<br/>
                <input type="text" name="lastName" value=""><br/>
                <br/>
                <input type="submit" value="RegisterMe">
        </form><hr/>
    </body>
</html>