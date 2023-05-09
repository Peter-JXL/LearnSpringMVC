<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <script src="js/jquery.min.js"></script>
        <script>
            $(function () {
                $("#btn").click(function () {
                    $.ajax({
                        url:"user/testAjax",
                        contentType:"application/json;charset=UTF-8", // 发送的数据类型
                        data: '{"username":"zhangsan","password":"123", "age":18}',
                        dataType:"json", // 服务器返回的数据类型
                        type:"post",
                        success:function (data) {
                            alert(data.username + data.age);
                        }
                    })
                })
            })
        </script>
    </head>
    <body>
        <h5>测试String类型</h5>
        <a href="user/testString">testString</a>
        <hr/>
        <hr/>
        <h5>测试void类型</h5>
        <a href="user/testVoid">testVoid</a>

        <hr/>
        <hr/>
        <h5>测试ModelAndView类型</h5>
        <a href="user/testModelAndView">ModelAndView</a>

        <hr/>
        <hr/>
        <h5>测试转发和重定向</h5>
        <a href="user/testForward">testForward</a>
        <a href="user/testRedirect">testRedirect</a>

        <hr/>
        <hr/>
        <h5>发送Ajax</h5>
        <button id="btn">发送Ajax</button>
    </body>
</html>
