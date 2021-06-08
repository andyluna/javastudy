<%--
  Created by IntelliJ IDEA.
  User: xiangdan
  Date: 2021/6/2
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String myPath   = request.getContextPath() + "/";
%>

<div>

    <%--
      <a href="<%=myPath%>pages/order/order.jsp">我的订单</a>
      <a href="<%=myPath%>index.jsp">注销</a>&nbsp;&nbsp;
      <a href="<%=myPath%>index.jsp">返回</a>
      --%>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>




    <a href="<%=basePath%>pages/order/order.jsp">我的订单</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="<%=basePath%>index.jsp">返回</a>
</div>
