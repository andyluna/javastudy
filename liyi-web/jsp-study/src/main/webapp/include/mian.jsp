<%--
  Created by IntelliJ IDEA.
  User: xiangdan
  Date: 2021/5/18
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
头部信息<br>
主体信息<br>
<%--<%@include file="/include/footer.jsp"%>--%>

<jsp:include page="/include/footer.jsp">
    <jsp:param name="username" value="bbj"/>
    <jsp:param name="password" value="123"/>

</jsp:include>
</body>
</html>
