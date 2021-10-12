<%-- 
    Document   : home
    Created on : 11-Oct-2021, 6:48:28 PM
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        
        <h2>Welcome ${s_username}</h2>
        
        <br>
        
        <nav>
            <a href="../MyLogin/login?logout">Logout</a>
        </nav>
    </body>
</html>
