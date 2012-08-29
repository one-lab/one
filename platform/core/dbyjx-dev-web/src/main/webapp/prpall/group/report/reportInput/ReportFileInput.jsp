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
		<title>附件导入界面</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript">ctx = "${ctx}";</script>
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	</head>
	
	<body>
		<form name="fm" id="fm" method="post" action = "${ctx}/prpall/reportFileUpload.do" enctype="multipart/form-data" >
		<input type="hidden" name="lcReportFile.repno" value="${param.repNo }"/>
			<div style="width:100%">
				<table  class="common" cellpadding="3" cellspacing="0">
					<tr>
						<td class="left">文件名：</td>						
							<td><input name="reportFile" class="cssbutton" type="file" value="浏  览..." id="reportFile"></td>
						
					</tr>
					<tr>
						<td>
							<input name="comName" class="cssbutton" type="submit" value="保   存"/>
						</td>
					</tr>
					  <tr>
					      <td style="color:red" colspan="6">注意：可上载的文件格式为rar格式或者zip格式，且文件名与呈报申请号要一致。</td> 
					  </tr>
				</table>
			</div>
		</form>
	</body>
</html>
