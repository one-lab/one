<%@ page contentType="text/html;charset=utf-8" isErrorPage="true"%>
<%@ page
	import="org.slf4j.Logger,org.slf4j.LoggerFactory,java.util.concurrent.BlockingQueue,java.util.Date"%>

<%
	if (exception != null) {
		exception.printStackTrace();
	} else {
		System.out.println("----1----");
	}
	System.out.println("------------------");
	System.out.println("-----jsp---catch-----end-----");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>500 - 系统内部错误ss</title>
</head>

<body>
<div>
<h1>系统发生内部错误.</h1>
</div>
<div><a href="">返回首页</a></div>
</body>
</html>
