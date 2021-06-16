<%--
  Created by IntelliJ IDEA.
  User: xiangdan
  Date: 2021/6/6
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--分页条的开始--%>
<div id="page_nav">

    <c:if test="${requestScope.page.pageNo>1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>
    <%--页码输出的开始--%>
    <c:choose>
        <%--情况1：如果总页码小于等于5的时候，页码的范围是：1-总页码--%>
        <c:when test="${requestScope.page.pageTotal<=5}">

            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}"/>

        </c:when>

        <%--情况2：总页码大于5--%>
        <c:when test="${requestScope.page.pageTotal>5}">
            <%--小情况1:当前页码为前面3个：1、2、3的情况，页码范围是1-5--%>
            <c:choose>
                <c:when test="${requestScope.page.pageNo<=3}">

                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>

                </c:when>
                <%--小情况2：当前页码为最后3个 8、9、10，页码范围是:总页码减4-总页码--%>
                <c:when test="${requestScope.page.pageNo>requestScope.page.pageTotal-3}">

                    <c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>

                </c:when>
                <%--小情况3：4、5、6、7，页码范围是：当前页码减2-当前页码加2--%>
                <c:otherwise>

                    <c:set var="begin" value="${requestScope.page.pageNo-2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo+2}"/>


                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <%--判断是否是当前页码，是则不可点击--%>
        <c:if test="${i==requestScope.page.pageNo}">
            【${i}】
        </c:if>
        <c:if test="${i !=requestScope.page.pageNo}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <%--当前页--%>
    <%--			【${requestScope.page.pageNo}】--%>

    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>

    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input type="button" id="searchPageBtn" value="确定">
</div>
<%--分页条的结束--%>
