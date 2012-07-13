<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://paoding.net/rose/pipe" prefix="rosepipe"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帐号及权限信息(pipe)</title>
<script src="${ctx}/static/rose-pipe/rose-pipe.js" type="text/javascript"></script>
</head>
<body>
帐号及权限信息：
<br>
<div id="p1">${p1}</div>
<br>
<div id="p2">${p2}</div>
</body>
</html>
<rosepipe:write>${p1}</rosepipe:write>
<rosepipe:write>${p2}</rosepipe:write>
