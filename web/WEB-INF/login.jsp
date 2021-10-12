<%-- 
    Document   : login
    Created on : 10-Oct-2021, 2:59:59 PM
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        
        
        <form name="loginForm" method="post" action="login">
            <label for="login_username">Username</label><input type="text" id="login_username" name="loginInfo[]" value="${username}">
            <br>
            <label for="login_password">Password</label><input type="text" id="login_password" name="loginInfo[]" value="${password}">
            <br>
            <br>
            <input type="submit" value="Login">
        </form>
            <h2>${message}</h2>
    </body>
</html>
