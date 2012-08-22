<%--
  Created by IntelliJ IDEA.
  User: carvin
  Date: 12-8-7
  Time: 下午7:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>下载测试</title>
    <%@ include file="/WEB-INF/layouts/base.jsp"%>
    <script type="text/javascript">
        $(document).ready(function() {
            //聚焦第一个输入框
            $("#file-tab").addClass("active");
        });

    </script>
</head>
<body>
    <div class="container">
    <%@ include file="/WEB-INF/layouts/header.jsp"%>
        <div id="content" class="span12">
            <a href="${ctx}/file/download/word">下载Word文档</a><br/>
            <a href="${ctx}/file/download/excel">下载Excel文档</a><br/>
            <a href="${ctx}/file/download/txt">下载Txt文档</a><br/>
        </div>
    </div>
    </div>
    <%@ include file="/WEB-INF/layouts/footer.jsp"%>
    </div>
</body>
</html>