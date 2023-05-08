<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>演示SpringMVC的常用注解</title>
    </head>
    <body>


        <h2>测试@RequestParam</h2>
        <a href="anno/testRequestParam?name=张三">测试@RequestParam</a> <br/>

        <hr/>
        <hr/>
        <h2>测试@testRequestBody</h2>
        <form action="anno/testRequestBody" method="post">
            User姓名：<input type="text" name="username" /> <br/>
            User年龄：<input type="text" name="age" /> <br/>
            <input type="submit" value="提交" />
        </form>

        <hr/>
        <hr/>
        <h2>测试@PathVariable</h2>
        <a href="anno/testPathVariable/10">测试@PathVariable</a> <br/>

        <hr/>
        <hr/>
        <h2>测试@RequestHeader</h2>
        <a href="anno/testRequestHeader">测试@RequestHeader</a> <br/>

        <hr/>
        <hr/>
        <h2>测试@CookieValue</h2>
        <a href="anno/testCookieValue">测试@CookieValue</a> <br/>

        <hr/>
        <hr/>
        <h2>测试@ModelAttribute</h2>
        <form action="anno/testModelAttribute" method="post">
            User2姓名：<input type="text" name="uname" /> <br/>
            User2年龄：<input type="text" name="age" /> <br/>
            <input type="submit" value="提交" />
        </form>

        <hr/>
        <hr/>
        <h2>测试@SessionAttribute</h2>
        <a href="anno/testSessionAttribute">测试@SessionAttribute</a> <br/>
        <a href="anno/testGetSessionAttribute">测试获取@SessionAttribute</a> <br/>
        <a href="anno/testDelSessionAttribute">测试删除@SessionAttribute</a> <br/>
    </body>
</html>
