<!DOCTYPE>
<html>
<body>
<h2 align="center">Registration Page</h2>
<form  method="post">
    <div>
        <label>User Name : </label>
        <div>
            <input type="text" name="username" class="form-control" placeholder="User name"/>
        </div>
    </div>
    <div>
        <label>Password : </label>
        <div>
            <input type="password" name="password" class="form-control" placeholder="Password"/>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Submit</button>
</form>
<div>
    <a href="/login">Back</a>
</div>
</body>
</html>