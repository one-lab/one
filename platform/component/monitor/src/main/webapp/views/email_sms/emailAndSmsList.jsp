<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${ctx}/static/portal.css" rel="stylesheet" type="text/css"
          media="all"/>
    <title>预警对象配置</title>
    <%@ include file="/WEB-INF/layouts/base.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            //聚焦第一个输入框
            $("#emailAndSms-tab").addClass("active");
        });
    </script>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/layouts/header.jsp" %>
    <div id="content" class="span12">
        <h2>预警对象信息：</h2>

        <div class="window">
            <div class="title">预警对象管理-邮箱</div>
            <!--这里使用$weather的"weather"即是第一个window的标识-->
            <div class="content">${email}</div>
        </div>

        <div class="window">
            <div class="title">预警对象管理-手机</div>
            <!--$todo实际是一个Window对象，velocity会调用其toString()输出html的-->
            <div class="content">${sms}</div>
        </div>
    </div>
    <%@ include file="/WEB-INF/layouts/footer.jsp" %>
</div>
</body>
</html>

