<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>中国人寿集团电子商务后台管理系统-欢迎页面</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/global/css/mis_basic.css">
</head>
<body topmargin="0" leftmargin="0" style="background-color:#86d6cb;">
<div id="main">
	<div style="width: 100%; height: 600px; background-color: #86d6cb; float: left; margin-top: -5px;">
		<div style="height: 600px; width: 1000px; background: url(global/images/welcome.jpg) repeat-y; overflow: hidden">
			<div class="title">
				中国人寿保险(集团)公司电子商务后台管理系统
			</div>
		</div>
	</div>
</div>
<%
Thread currentThread=Thread.currentThread();
String traceId=currentThread.getName()+"#"+currentThread.getId();

%>
<%=traceId %>
</body>
</html>