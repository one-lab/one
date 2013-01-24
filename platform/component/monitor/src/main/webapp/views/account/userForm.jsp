<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="msg" uri="http://mvc.one.sinosoft.com/validation/msg" %>
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

    <script language="javascript">
        function isValid(form) {
            if (form.password.value != form.passwordConfirm.value) {
                alert("两次输入的密码不同！");
                return false;
            }
            return true;
        }
    </script>


</head>

<body>
<div class="container">
    <%@ include file="/WEB-INF/layouts/header.jsp" %>
    <div id="content" class="span12">
        <form:form id="inputForm" modelAttribute="user"
                   action="${ctx}/account/user/save/${account.id}" method="post" enctype="multipart/form-data"
                   class="form-horizontal" onsubmit="return isValid(this);">
            <fieldset>
                <legend>
                    <small>新增用户</small>
                </legend>
                <div id="messageBox" class="alert alert-error" style="display:none">输入有误，请先更正。</div>
                <div class="control-group">
                    <label for="loginName" class="control-label">用户名:</label>

                    <div class="controls">
                        <input type="text" id="loginName" name="loginName" size="50" value="${account.loginName}"
                               class="required"/>
                        <msg:errorMsg property="loginName"/></div>
                </div>
                <div class="control-group">
                    <label for="password" class="control-label">密码:</label>

                    <div class="controls">
                        <input type="password" id="password" name="password" size="50" value="${account.password}"
                               class="required" minlength="4"/>
                        <msg:errorMsg property="password" type="message"/></div>
                </div>
                <div class="control-group">
                    <label for="passwordConfirm" class="control-label">确认密码:</label>

                    <div class="controls">
                        <input type="password" id="passwordConfirm" name="passwordConfirm" size="50"
                               value="${account.password}" equalTo="#password" class="required"/>
                    </div>
                </div>
                <div class="control-group">
                    <label for="name" class="control-label">姓名:</label>

                    <div class="controls">
                        <input type="text" id="name" name="name" size="50" value="${account.name}" class="required"/>
                        <msg:errorMsg property="name"/></div>
                </div>
                <div class="control-group">
                    <label for="phone" class="control-label">手机号:</label>

                    <div class="controls">
                        <input type="text" id="phone" name="phone" size="11" value="${account.phone}" class="phone"/>
                        <msg:errorMsg property="phone"/></div>
                </div>
                <div class="control-group">
                    <label for="email" class="control-label">邮箱:</label>

                    <div class="controls">
                        <input type="text" id="email" name="email" size="100" value="${account.email}" class="email"/>
                        <msg:errorMsg property="email"/></div>
                </div>
                <div class="control-group">
                    <label for="status" id="status" class="control-label">状态:</label>

                    <div class="controls">
                        <input type="radio" name="status"
                               value="1" ${account.status eq "1" || null == account.status ? "checked='checked'" : ''}/>正常&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="status"
                               value="0" ${account.status eq "0" ? "checked='checked'" : ''}/>锁定
                    </div>
                </div>
                <div class="form-actions">
                    <input id="submit" class="btn btn-primary" type="submit" value="保存"/>&nbsp;
                    <input id="cancel" class="btn" type="button" value="返回" onclick="history.back()"/>
                </div>
            </fieldset>
        </form:form>

    </div>
    <%@ include file="/WEB-INF/layouts/footer.jsp" %>
</div>
</body>
</html>
