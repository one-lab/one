<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>预警对象管理-邮箱</title>
    <%@ include file="/WEB-INF/layouts/base.jsp" %>
</head>

<body>
<%--<div id="content" class="span12">--%>
<%--<div><a class="btn" href="create">新增预警对象</a></div>--%>

<table id="contentTable"
       class="table table-striped table-bordered table-condensed">
    <div align="right"><a class="btn" href="${ctx}/warn/email/createEmail">新增预警对象</a></div>
    <tr>
        <th>所属应用</th>
        <th>邮箱</th>
        <th>姓名</th>
        <th>状态</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${emails}" var="email">
        <tr>
            <td>${email.appId}</td>
            <td>${email.address}</td>
            <td>${email.owner}</td>
            <td>${email.status}</td>
            <td><fmt:formatDate value="${email.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
            <td><a href="${ctx}/warn/email/update/${email.id}" id="editLink-${email.owner}">编辑</a>
                <a href="${ctx}/warn/email/delete/${email.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
