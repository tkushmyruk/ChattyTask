<!DOCTYPE html>
<html>
<head>Login Page</head>
<body>
<form action="/login" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="sign in"/></div>
</form>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button class="btn btn-primary" type="submit">Sign out</button>
</form>
<div>
    <a href="/registration">Registration</a>
</div>
<div>
    <a href="/">Main page</a>
</div>
</body>
</html>