<%--
  Created by IntelliJ IDEA.
  User: xiangdan
  Date: 2021/6/11
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println("a.jsp页面执行了！");
    Object user=session.getAttribute("user");

    if (user==null){
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        return;
    }
%>


我是a.jsp页面
</body>
</html>
