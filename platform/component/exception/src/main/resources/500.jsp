<%@page import="com.sinosoft.one.exception.Exceptions"%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true"%>

<%
	if (exception != null) {
		Exceptions.handleThrowable((Throwable) exception);
	} else if (request.getAttribute("javax.servlet.error.exception") != null) {
        Exceptions.handleThrowable((Throwable) request
                    .getAttribute("javax.servlet.error.exception"));
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>500 - 系统内部错误</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
</head>

<body class="bg_default">
<div class="kong404"></div>
<div class="container_404">
   <div class="up">
      <div class="content">
          <div class="font_hei wenzi">
             <ul>
                 <li class="font_14 font_bold ">当前页面不存在</li>
                 <li class="pd_t5">
                     <span class="color_666">请您检查网络链接是否正常，点击</span>
                     <a href="${ctx}">刷新</a><span class="color_666">当前页面</span>
                 </li>
             </ul>
          </div>
          <div class="tupian"></div>
      </div>
   </div>
   <div class="line"></div>
</div>
<div class="search_404">
      <div class="tupian"></div>
   </div>
</body>
</html>