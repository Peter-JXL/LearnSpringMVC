<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>演示参数绑定</title>
    </head>
    <body>
        <h1>演示参数绑定</h1>
        <a href="param/testParam?username=peterjxl&password=123">请求参数绑定</a>

        <hr/>
        <hr/>
        <h1>演示参数绑定：基本类型</h1>
        <form action="param/saveAccount" method="post">
            姓名：<input type="text" name="username" /> <br/>
            密码：<input type="text" name="password" /> <br/>
            金额：<input type="text" name="money" /> <br/>
            <input type="submit" value="提交" />
        </form>

        <hr/>
        <hr/>
        <h1>演示参数绑定：实体类型</h1>
        <form action="param/saveAccount2" method="post">
            姓名：<input type="text" name="username" /> <br/>
            密码：<input type="text" name="password" /> <br/>
            金额：<input type="text" name="money" /> <br/>
            用户姓名：<input type="text" name="user.uname" /> <br/>
            用户年龄：<input type="text" name="user.age" /> <br/>
            <input type="submit" value="提交" />
        </form>

        <hr/>
        <hr/>
        <h1>演示参数绑定：集合类型</h1>
        <form action="param/saveAccount3" method="post">
            姓名：<input type="text" name="username" /> <br/>
            密码：<input type="text" name="password" /> <br/>
            金额：<input type="text" name="money" /> <br/>
            用户姓名：<input type="text" name="user.uname" /> <br/>
            用户年龄：<input type="text" name="user.age" /> <br/>

            list用户姓名：<input type="text" name="list[0].uname" /> <br/>
            list用户年龄：<input type="text" name="list[0].age" /> <br/>

            map用户姓名：<input type="text" name="map['one'].uname" /> <br/>
            map用户年龄：<input type="text" name="map['one'].age" /> <br/>
            <input type="submit" value="提交" />
        </form>
    </body>
</html>
