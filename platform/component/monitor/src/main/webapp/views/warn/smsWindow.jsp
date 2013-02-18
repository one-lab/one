<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>预警对象管理-手机</title>
    <%@ include file="/WEB-INF/layouts/base.jsp" %>
</head>

<body>
<%--<div id="content" class="span12">--%>

<table id="contentTable"
       class="table table-striped table-bordered table-condensed">
    <div align="right"><a class="btn" href="${ctx}/warn/tel/createTel">新增预警对象</a></div>
    <thead>
    <tr>
        <th>所属应用</th>
        <th>电话</th>
        <th>姓名</th>
        <th>状态</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${smsList}" var="sms">
        <tr>
            <td>${sms.appId}</td>
            <td>${sms.phoneno}</td>
            <td>${sms.owner}</td>
            <td>${sms.status}</td>
            <td><fmt:formatDate value="${sms.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
            <td><a href="${ctx}/warn/tel/update/${sms.id}" id="editLink-${sms.owner}">编辑</a>
                <a href="${ctx}/warn/tel/delete/${sms.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
