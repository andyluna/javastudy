<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>后台管理首页</title>
    <script src="${path}/pages/manager/js/jquery-2.1.1.min.js"></script>

</head>
<body>
    <input type="hidden" id="mypath" value="${path}">

    <h1>欢迎您:<span style="color: red"> ${SESSION_USER_KEY.username}</span> 这是后台管理首页</h1>
    <ol>
        <li><a href="${path}/manager/userServlet" target="_blank">用户管理</a></li>
        <li><a href="${path}/manager/deptServlet" target="_blank">部门管理</a></li>
        <li><a href="${path}/manager/menuServlet" target="_blank">菜单管理</a></li>
        <li><a href="${path}/manager/roleServlet"    target="_blank">角色管理</a></li>

    </ol>

    <a href="javascript:void(0)" id="logout">退出登录</a>

<script type="text/javascript">

    $(function (){
        var mypath = $("#mypath").val();
        $('#logout').click(function (){
            var r = confirm("真的要退出吗");
            var url = mypath+"/manager/logout";
            if(r){
                $.post(url,null,function (data) {
                    if(data.code==0){
                        alert('退出成功');
                        window.location.href=mypath+"/manager/index";
                    }else{
                        alert('退出失败');
                    }
                },'json')
            }
        });
    });

</script>
</body>
</html>
