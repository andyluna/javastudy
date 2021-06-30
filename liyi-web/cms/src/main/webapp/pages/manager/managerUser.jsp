<%--
  Created by IntelliJ IDEA.
  User: xiangdan
  Date: 2021/6/17
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
  <script src="${path}/pages/manager/js/jquery-2.1.1.min.js"></script>
</head>
<body>

<div>
  <input type="hidden" id="mypath" value="${path}">

  <table id="tb" border="1" align="center" width="80%">
    <caption style="font-size: 30px;">用户列表展示</caption>
    <tr>
      <td colspan="11">
        <form method="post" action="${path}/manager/userServlet">
          <input name="action" value="list" type="hidden">
          <input name="curPage" id="curPage"  value="${pageRes.curPage}"  type="hidden">
          <input name="pageSize" id="pageSize" type="hidden">
          用户名:<input name="username" value="${username}">
          姓名:<input name="name" value="${name}">
          性别:
          <select name="sex">
            <option value="2" <c:if test="${sex=='2'}"> selected="selected"</c:if> >全部</option>
            <option value="1" <c:if test="${sex=='1'}"> selected="selected"</c:if> >男</option>
            <option value="0" <c:if test="${sex=='0'}"> selected="selected"</c:if>>女</option>
          </select>

          <input type="submit" value="查询" id="mysubmit">
        </form>

        <a href="${path}/manager/userServlet?action=getUser&curPage=${pageRes.curPage}&pageSize=${pageRes.pageSize}">新增用户</a>
      </td>
    </tr>
    <tr>
      <td>序号</td>
      <td>Id</td>
      <td>用户名</td>
      <td>密码</td>
      <td>手机号</td>
      <td>真实姓名</td>
      <td>住址</td>
      <td>性别</td>
      <td>所属部门</td>
      <td colspan="2">操作</td>
    </tr>

  <c:forEach items="${requestScope.pageRes.data}" var="user" varStatus="mystatus">
    <tr>
      <td>${mystatus.count}</td>
      <td>${user.id}</td>
      <td>${user.username}</td>
      <td>${user.password}</td>
      <td>${user.phone}</td>
      <td>${user.name}</td>
      <td>${user.address}</td>
      <td>
        <c:if test="${user.sex==1}">男</c:if>
        <c:if test="${user.sex==0}">女</c:if>
      </td>
      <td>
         ${user.dept.name}
      </td>
      <td><a href="${path}/manager/userServlet?action=getUser&id=${user.id}&curPage=${pageRes.curPage}&pageSize=${pageRes.pageSize}">修改</a></td>
      <td><a class="deleteClass"  myattrid="${user.id}"   href="javascript:void(0)"  >删除</a></td>
    </tr>
    </c:forEach>

    <tr>
      <td colspan="11" align="center">
        <a href="javascript:void(0)" onclick="fanye(1,${pageRes.pageSize})">首页</a>
        &nbsp;&nbsp;
        <a href="javascript:void(0)" onclick="fanye(${pageRes.curPage-1},${pageRes.pageSize})">上一页</a>
        &nbsp;&nbsp;
        当前第<span style="color: blue" id="mycurPage">${pageRes.curPage}</span> 页
        &nbsp;&nbsp;
        每页显示
        <select id="myselectPage">
          <option value="5"   <c:if test="${pageRes.pageSize==5}"> selected="selected"</c:if>  >5</option>
          <option value="10"  <c:if test="${pageRes.pageSize==10}"> selected="selected"</c:if>  >10</option>
          <option value="20"  <c:if test="${pageRes.pageSize==20}"> selected="selected"</c:if>  >20</option>
          <option value="50"  <c:if test="${pageRes.pageSize==50}"> selected="selected"</c:if>  >50</option>
          <option value="100" <c:if test="${pageRes.pageSize==100}"> selected="selected"</c:if>  >100</option>
          <option value="200" <c:if test="${pageRes.pageSize==200}"> selected="selected"</c:if>  >200</option>
        </select>
        条
        &nbsp;&nbsp;
        <a href="javascript:void(0)" onclick="fanye(${pageRes.curPage+1},${pageRes.pageSize})">下一页</a>
        &nbsp;&nbsp;
        <a href="javascript:void(0)" onclick="fanye(${pageRes.totalPage},${pageRes.pageSize})">末页</a>




        总共有<span style="color: blue">${pageRes.totalPage}</span>页
        &nbsp;&nbsp;&nbsp;&nbsp;
        总共有<span style="color: blue">${pageRes.total}</span>条数据数据
      </td>
    </tr>

  </table>
</div>
<a href="${path}/manager/index" >回到后台管理首页</a>
<script>
  function fanye(curPage,pageSize){
    $('#curPage').val(curPage);
    $('#pageSize').val(pageSize);
    $('#mysubmit').click();
  }

  $(function (){
    var path = $('#mypath').val();
    $('#myselectPage').change(function (){
        fanye($('#curPage').val(),$(this).val())
    })

    $("a.deleteClass").click(function () {
      var curId  = $(this).attr('myattrid');
      var curPage  = $('#mycurPage').text();
      var url = path+'/manager/userServlet';
      $.post(url,{action:'delete',id:curId,curPage:curPage},function (data){
        if(data.code==0){
          $('#mysubmit').click();
        }
      },'json')

    });

  });

</script>


</body>
</html>
