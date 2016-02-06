
<%@page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/bootstrap.css" rel="stylesheet">
    </head>
<body>
 <div class="container">
    <%--header--%>
    <div class="row">
        <div class="col-sm-12">
            <h3 class="text-center">Login please</h3>
        </div>
    </div>
    	<%--main--%>
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
        <h3>Login</h3>
        <hr/>
        <form name="loginForm" method="POST" action="controller">
            <input type="hidden" name="command" value="login"/>
                Login:<br/>
                <input type="text" name="login" value=""><br/>
                Password:<br/>
                <input type="password" name="password" value="">
                <br/>
                <input type="submit" value="Enter">
        </form><hr/>
        <form name="toRegistrationForm" method="POST" action="controller">
            <input type="hidden" name="command" value="toRegistration"/>
                Registration:<br/>
                <input type="submit" value="Enter">
        </form><hr/>
        </div>
        <div class="col-sm-2"></div>
    </div>
        <%--footer--%>
    <div class="row"></div>
   </div>     
 </body>
</html>