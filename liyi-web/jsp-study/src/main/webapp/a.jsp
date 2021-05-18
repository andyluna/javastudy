<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: xiangdan
  Date: 2021/5/18
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%!
    private Integer id;
    private String name;
    private static Map<String,Object>map;
%>
<%!
    static {
        map=new HashMap<String,Object>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
    }
%>

<%!
    public int abc(){
        return 12;
    }
%>

<%!
    public static class A{
        private Integer id=12;
        private String abc="abc";
    }
%>


    <%=12%>
    <%="我是字符串"%>
    <%=map%>
    <%=request.getParameter("username")%>

    <%
    int i=1;
    if (i==1){
        %>
    <h1>Yes</h1>
    <%
    }else {
        %>
    <h1>No</h1>
    <%
    }
    %>
<%
    for (int b=0;b<10;b++){
        System.out.println(b);
    }
%>

</body>
</html>
