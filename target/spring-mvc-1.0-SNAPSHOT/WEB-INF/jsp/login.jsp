<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <span>${gender}</span>
    <form action="${pageContext.request.contextPath}/api/v1/login" method="post">
        <label for="username">Username</label>
        <input id="username" type="text" name="username"><br>
        <label for="password">Password</label>
        <input id="password" type="text" name="password"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
