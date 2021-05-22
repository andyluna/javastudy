<%--
  Created by IntelliJ IDEA.
  User: xiangdan
  Date: 2021/5/22
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    //http://localhost:8080/EL_JSTL_study/
%>


<html>
<head>
    <title>Title</title>
</head>
<body>
http://localhost:8080/EL_JSTL_study/exer/UploadServlet
    <form action="../UploadServlet" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="username"/><br>
        头像:<input type="file" name="photo"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>


1.绝对路径
    1.1
        http://ip:port/
        //

        http://localhost:8080/EL_JSTL_study/UploadServlet
        http://127.0.0.1:8080/EL_JSTL_study/UploadServlet
        http://123.125.45.32:8080/EL_JSTL_study/UploadServlet
        http://www.liyi.com:8080/EL_JSTL_study/UploadServlet   www.liyi.com 123.125.45.32
        http://www.liyi.com:80/EL_JSTL_study/UploadServlet     www.liyi.com 123.125.45.32:8080
        http://www.liyi.com/EL_JSTL_study/UploadServlet
        <%=basePath%>/UploadServlet

    1.2
        /
        例如：  /EL_JSTL_study/UploadServlet
              <%=path%>/UploadServlet
2.相对路径
    ../UploadServlet
