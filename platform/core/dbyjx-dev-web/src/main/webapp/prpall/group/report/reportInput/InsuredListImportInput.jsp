<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>清单导入界面</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>
	</head>
	
	<body>
		<form name="fm" enctype="multipart/form-data"  method="post" action = "${ctx}/prpall/importInsured.do">
			<div style="width:100%">
				<table  class="common" cellpadding="3" cellspacing="0">
					<tr>
						<td class="left">文件名：</td>						
							<td><input name="insuredFile" class="cssbutton" type="file" value="浏  览..."></td>
						
					</tr>
					<tr>
					<td>
							<input name="comName" class="cssbutton" type="submit" value="导  入" >
						</td>
					</tr>
					  <tr>
					      <td style="color:red" colspan="6">注意：上载文档中单元格格式中数字分类需要选择“文本”。</td> 
					  </tr>
				</table>
			</div>
		</form>
	</body>
</html>
