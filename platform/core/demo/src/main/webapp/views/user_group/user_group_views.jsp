<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帐号及权限信息(portal)</title>
<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#portal-tab").addClass("active");
		}); 
</script>
</head>
<body>
帐号及权限信息：
<br>
<div id="p1">${p1}</div>
<br>
<div id="p2">${p2}</div>
</body>
</html>

