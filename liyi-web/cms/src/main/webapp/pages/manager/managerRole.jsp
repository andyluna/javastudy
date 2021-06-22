<%--
  Created by IntelliJ IDEA.
  User: xiangdan
  Date: 2021/6/17
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>角色管理</title>
  <script src="${path}/pages/manager/js/jquery-2.1.1.min.js"></script>
</head>
<body>

<div>
  <input type="hidden" id="mypath" value="${path}">

  <table id="tb" border="1" align="center" width="80%">
    <caption style="font-size: 30px;">角色列表展示</caption>
    <tr>
      <td colspan="9">
        <form method="post" action="${path}/manager/roleServlet">
          <input name="action" value="list" type="hidden">
          <input name="curPage" id="curPage"  value="${pageRes.curPage}"  type="hidden">
          <input name="pageSize" id="pageSize" type="hidden">
          角色编码:<input name="code" value="${code}">
          角色名:<input name="name" value="${name}">
          创建人ID:<input name="createUserId" value="${createUserId}">
          <input type="submit" value="查询" id="mysubmit">
        </form>

        <a href="${path}/manager/roleServlet?action=getRole&curPage=${pageRes.curPage}&pageSize=${pageRes.pageSize}">新增角色</a>
      </td>
    </tr>
    <tr>
      <td>序号</td>
      <td>Id</td>
      <td>角色编码</td>
      <td>角色名称</td>
      <td>创建时间</td>
      <td>创建人Id</td>
      <td>最后修改时间</td>
      <td>最后修改人Id</td>
      <td colspan="2">操作</td>
    </tr>

  <c:forEach items="${requestScope.pageRes.data}" var="data" varStatus="mystatus">
    <tr>
      <td>${mystatus.count}</td>
      <td>${data.id}</td>
      <td>${data.code}</td>
      <td>${data.name}</td>
      <td>
        <fmt:formatDate value="${data.createDate}"  pattern="yyyy年MM月dd日 HH:mm:ss"></fmt:formatDate>
      </td>
      <td>${data.createUserId}</td>
      <td>
        <!--dateStyle 和 timeStyle 分别可以取5个值 default|short|medium|long|full -->
        <fmt:formatDate value="${data.lastUpdateDate}" type="both" dateStyle="FULL" timeStyle="long"></fmt:formatDate>
      </td>
      <td>${data.lastUpdateId}</td>
      <td><a href="${path}/manager/roleServlet?action=getRole&id=${data.id}&curPage=${pageRes.curPage}&pageSize=${pageRes.pageSize}">修改</a></td>
      <td><a class="deleteClass"  myattrid="${data.id}"   href="javascript:void(0)"  >删除</a>
      </td>
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

    //每页展示条数 大小选择
    $('#myselectPage').change(function (){
        fanye($('#curPage').val(),$(this).val())
    })


    //删除
    $("a.deleteClass").click(function () {
      var curId  = $(this).attr('myattrid');
      var curPage  = $('#mycurPage').text();
      var url = path+'/manager/roleServlet';
      $.post(url,{action:'delete',id:curId,curPage:curPage},function (data){
        if(data.code==0){
          $('#mysubmit').click();
        }
      },'json');

    });

  });

</script>


</body>
</html>
