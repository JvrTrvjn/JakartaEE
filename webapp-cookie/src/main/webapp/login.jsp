<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario login</title>
</head>
<body>
<h1>Login</h1>
<form action="/webapp-cookie/login" method="post">
    <div>
        <label for="username">Username</label>
    </div>
    <div>
        <input type="text" name="username" id="username">
    </div>
    <div>
        <label for="password">Password</label>
    </div>
    <div>
        <input type="password" name="password" id="password">
    </div>
    <div>
        <input type="submit" value="Login">
    </div>
</form>
</body>
</html>