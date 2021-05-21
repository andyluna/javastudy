<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: xiangdan
  Date: 2021/5/21
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("a.a.a","112222221");
        map.put("b+b+b","2222阿斯顿撒旦222");
        map.put("ccc","333");
        request.setAttribute("map",map);
    %>
        ${map['a.a.a']} <br/>
        ${map['b+b+b']}

</body>
</html>
