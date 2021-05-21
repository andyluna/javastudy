<%--
  Created by IntelliJ IDEA.
  User: xiangdan
  Date: 2021/5/21
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("key1","pageContext1");
        pageContext.setAttribute("key2","pageContext2");
        request.setAttribute("key1","request1");
        session.setAttribute("key1","session1");
        application.setAttribute("key1","application1");
    %>
    ${key1}<br/>
    ${pageScope.key1}<br/>
    ${requestScope.key1}<br/>
</body>
</html>
