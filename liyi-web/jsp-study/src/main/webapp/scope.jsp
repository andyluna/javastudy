<%--
  Created by IntelliJ IDEA.
  User: xiangdan
  Date: 2021/5/19
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>scope1.jsp页面</h1>
    <%
        // 往四个域中都分别保存了数据
        pageContext.setAttribute("key1","pageContext");
        request.setAttribute("key2", "request");
        session.setAttribute("key3", "session");
        application.setAttribute("key4", "application");
    %>
    pageContext域是否有值：<%=pageContext.getAttribute("key1")%> <br>
    pageContext域是否有值：<%=pageContext.getAttribute("key1")%> <br>
    request域是否有值：<%=request.getAttribute("key2")%> <br>
    session域是否有值：<%=session.getAttribute("key3")%> <br>
    application域是否有值：<%=application.getAttribute("key4")%> <br>
    <%
//        request.getRequestDispatcher("/scope2.jsp").forward(request,response);
    %>

    <%
        out.write("out输出1</br>");

        out.flush();

        out.write("out输出2</br>");

        response.getWriter().write("response输出1</br>");
        response.getWriter().write("response输出2</br>");



    %>

    <%--
        <jsp:forward page=""></jsp:forward> 是请求转发标签，它的功能就是请求转发
            page 属性设置请求转发的路径
    --%>
    <jsp:forward page="scope2.jsp"></jsp:forward>
</body>
</html>
