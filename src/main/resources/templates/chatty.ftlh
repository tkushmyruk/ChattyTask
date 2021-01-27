<!DOCTYPE>
<html>
<body>
<h2 align="center">This is our chatty</h2>
<div>
    <div>
        <a href="/login">Login page</a>
    </div>
    <br/>
    <div>
        <a href="/">Main page</a>
    </div>
    <h4>Online users:</h4>
    <#list onlineUsers as user>
        <div >
            <span>${user}</span>
        </div>
    <#else >
        No online users
    </#list>
</div>
<br/>
<form method="post" action="/chatty">
    <div>
        <input type="text" name="text"  placeholder="write message"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </div>
</form>
<h4>Messages:</h4>
<div>
    <#list messages as message>
        <div >
            <span>${message.authorName} : </span>
            <span>${message.text}</span>
        </div>
    <#else >
        No message
    </#list>
</div>

</body>
</html>