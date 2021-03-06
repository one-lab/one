<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户管理</title>
    <%@ include file="/WEB-INF/layouts/base.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            //聚焦第一个输入框
            $("#user-tab").addClass("active");
        });

    </script>

</head>

<body>
<div class="container">
    <%@ include file="/WEB-INF/layouts/header.jsp" %>
    <div id="content" class="span12">
        <h4>用户列表</h4>
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
                <th>用户名</th>
                <th>姓名</th>
                <th>状态</th>
                <th>手机号</th>
                <th>邮箱</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${accounts}" var="user">
                <tr>
                    <td>${user.loginName}</td>
                    <td>${user.name}</td>
                    <td>${user.status}</td>
                    <td>${user.phone}</td>
                    <td>${user.email}</td>
                    <td><fmt:formatDate value="${user.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                    <td><a href="update/${user.id}" id="editLink-${user.name}">编辑</a>
                        <a href="delete/${user.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a class="btn" href="create">新增用户</a>
    </div>
    <div id="view" class="span12" style="display: none">
        <form:form id="inputForm" modelAttribute="user" class="form-horizontal">
            <input type="hidden" name="id" value="${user.id}"/>
            <fieldset>
                <legend>
                    <a href="javascript:void(0)" onclick="closeView();" style="float:right;margin-top:14px"><font
                            size="2">关闭&nbsp; </font></a>
                    <small>用户基本信息</small>
                </legend>

                <div class="control-group">
                    <label for="loginName" class="control-label">登录名:</label>

                    <div class="controls">
                        <input type="text" id="loginName" name="loginName" size="50" class="required"/>
                    </div>
                </div>
                <div class="control-group">
                    <label for="name" class="control-label">用户名:</label>

                    <div class="controls">
                        <input type="text" id="name" name="name" size="50" class="required"/>
                    </div>
                </div>
                <div class="control-group">
                    <label for="email" class="control-label">邮箱:</label>

                    <div class="controls">
                        <input type="text" id="email" name="email" size="50" class="email"/>
                    </div>
                </div>
                <div class="control-group">
                    <label for="phone" class="control-label">手机号:</label>

                    <div class="controls">
                        <input type="text" id="phone" name="phone" size="50" class="phone"/>
                    </div>
                </div>
            </fieldset>
        </form:form>
    </div>
    <%@ include file="/WEB-INF/layouts/footer.jsp" %>
</div>
<script type="text/javascript">

    var closeView = function () {
        $("#view").hide();
    }
</script>
</body>
</html>
