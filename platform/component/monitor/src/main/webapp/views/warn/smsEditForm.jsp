<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="msg" uri="http://mvc.one.sinosoft.com/validation/msg" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>预警对象配置</title>
    <%@ include file="/WEB-INF/layouts/base.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            //聚焦第一个输入框
            $("#emailAndSms-tab").addClass("active");
        });

    </script>

    <script language="javascript">
        function isValid(form) {
            if (form.newPhoneno.value.length == 0) {
                alert("手机号码不能为空！");
                return false;
            }
            else if (form.newPhoneno.value != form.phonenoConfirm.value) {
                alert("两次输入的手机号码不同！");
                return false;
            }
            return true;
        }
    </script>

</head>
<%--action="${ctx}/warn/email/save/${email.id}--%>
<body>
<div class="container">
    <%@ include file="/WEB-INF/layouts/header.jsp" %>
    <div id="content" class="span12">
        <form:form id="inputForm" modelAttribute="user"
                   action="${ctx}/warn/tel/save/${sms.id}" method="post" enctype="multipart/form-data"
                   class="form-horizontal" onsubmit="return isValid(this);">
            <fieldset>
                <legend>
                    <small>编辑手机</small>
                </legend>
                <div id="messageBox" class="alert alert-error" style="display:none">输入有误，请先更正。</div>
                <div class="control-group">
                    <div class="control-group">
                        <label for="oldPhoneno" class="control-label">原手机号:</label>

                        <div class="controls">
                            <input type="oldPhoneno" id="oldPhoneno" name="oldPhoneno" size="100"
                                   value="${sms.phoneno}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label for="newPhoneno" class="control-label">新手机号:</label>

                        <div class="controls">
                            <input type="newPhoneno" id="newPhoneno" name="newPhoneno" size="100"
                                   class="required" minlength="11" maxlength="11"/>
                            <msg:errorMsg property="newPhoneno" type="message"/></div>
                    </div>
                    <div class="control-group">
                        <label for="phonenoConfirm" class="control-label">确认手机号:</label>

                        <div class="controls">
                            <input type="phonenoConfirm" id="phonenoConfirm" name="phonenoConfirm" size="100"
                                   equalTo="#phoneno" class="required" minlength="11" maxlength="11"/>
                        </div>
                    </div>
                    <div class="form-actions">
                        <input id="submit" class="btn btn-primary" type="submit" value="保存"/>&nbsp;
                        <input id="cancel" class="btn" type="button" value="返回" onclick="history.back()"/>
                    </div>
                </div>
            </fieldset>
        </form:form>
    </div>
    <%@ include file="/WEB-INF/layouts/footer.jsp" %>
</div>
</body>
</html>
