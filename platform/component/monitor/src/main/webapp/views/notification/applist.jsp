<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://mvc.one.sinosoft.com/tags/pipe" prefix="mvcpipe"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${ctx}/static/portal.css" rel="stylesheet" type="text/css"
	media="all" />
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<script src="${ctx}/static/mvc-pipe/mvc-pipe.js" type="text/javascript"></script>

<script type="text/javascript">
	
function queryByChange() {
	$("#appForm").submit();
	var urlPaht="${ctx}/notification/urlConfigure/test";
	alert($("#appSelected option:selected").attr("id"));
	$.ajax({
		type : "post",
		url : "${ctx}/notification/appConfigure/reflashList?appName="+$("#appSelected option:selected").attr("id"),
		dataType : "json",
		success : function(data) {
			var redirectUrl='${ctx}'+data.message;
			location.href = redirectUrl;
		},
		error : function(data) {
			alert(data+"暂时无法获取应用列别信息.");
		}
	}); 
}
</script>
</head>
<body>
	<div  >
			
				<select id="appSelected" onchange="queryByChange()">
					<option id="">请选择应用</option>
					<c:forEach items="${app}" var="appList">
						<option id="${appList.id}">${appList.name }</option>
					</c:forEach>
				</select>
					当前所选应用:
			</div>	
</body>
</html>
