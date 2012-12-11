<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>SQL资源文件查询方式演示</title>
    <%@ include file="/WEB-INF/layouts/base.jsp"%>
    <script type="text/javascript">
        $(document).ready(function() {
            //聚焦第一个输入框
            $("#sqlresource-tab").addClass("active");
        });

    </script>


</head>

<body>
<div class="container">
    <%@ include file="/WEB-INF/layouts/header.jsp"%>
    <div id="content" class="span12">
        <h4>资源文件查询方式演示</h4>
        <c:if test="${not empty message}">
            <div id="message" class="alert alert-success">
                <button data-dismiss="alert" class="close">×</button>
                <d:flash key="message"></d:flash>
            </div>
        </c:if>
        <table id="contentTable"
               class="table table-striped table-bordered table-condensed">
            <thead>
            <tr>
                <th>登录名</th>
                <th>用户名</th>
                <th>邮箱</th>
                <th>创建时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.loginName}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td><fmt:formatDate value="${user.createTime }" pattern="yyyy-MM-dd HH:mm:ss" />
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a class="btn" href="create">创建用户</a>
    </div>
    <%@ include file="/WEB-INF/layouts/footer.jsp"%>
</div>

</body>
</html>
