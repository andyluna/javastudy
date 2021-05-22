<%@ page import="java.lang.String" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liyi.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiangdan
  Date: 2021/5/22
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 500px;
            border: 1px solid red;
            border-collapse: collapse;
        }
        th,td{
            border: 1px solid red;
        }
    </style>
</head>
<body>
    <c:forEach begin="1" end="10" var="i">
        ${i} <br>
    </c:forEach>
    <hr>
    <%--遍历object数组--%>
    <%
        String[] arr = new String[]{"4454545","45544545"};
        request.setAttribute("arr",arr);
    %>
    <c:forEach items="${requestScope.arr}" var="item">
        ${item}<br>
    </c:forEach>
    <hr>

    <%--遍历map集合--%>
    <%
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
//        for (Map.Entry<String,Object> entry:map.entrySet()){
//
//        }
        request.setAttribute("map",map);
    %>
    <c:forEach items="${requestScope.map}" var="entry">
        ${entry.key}=${entry.value}<br>
    </c:forEach>
    <hr>

    <%--遍历List集合--%>
    <%
          List<Student> studentList=new ArrayList<Student>();
          for (int i=1;i<=10;i++){
              studentList.add(new Student(i,"username"+i,"pass"+i,18+i,"phone"+i));
          }
          request.setAttribute("stus",studentList);
    %>
    <table >
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>年龄</th>
            <th>电话</th>
            <th>操作</th>
        </tr>

            <c:forEach begin="2" end="8" items="${requestScope.stus}" var="stu">
                <tr>
                    <td>${stu.id}</td>
                    <td>${stu.username}</td>
                    <td>${stu.password}</td>
                    <td>${stu.age}</td>
                    <td>${stu.phone}</td>
                    <td>删除/修改}</td>
                </tr>
            </c:forEach>
    </table>


</body>
</html>
