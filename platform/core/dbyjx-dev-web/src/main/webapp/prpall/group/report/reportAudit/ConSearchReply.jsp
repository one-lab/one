<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>呈报契调信息回复</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="common/js/SimpleCalendar.js"></script>

  </head>
  
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table>
			<tr>
				<td colspan="6" >影像件图片信息</td>
			</tr>
		</table>
		<br><br><br><br><br><br><br><hr>
		<table id="prpallReplyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" >其他契调项目</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="OtherPrpalSearch" cols="100%" rows="5"></textarea></td>
			</tr>
			<tr>
				<td colspan="6" >契调结论</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="PrpalSearchResult" cols="100%" rows="5" ></textarea></td>
			</tr>			
		</table>
		<table  id="HandleInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6"><input type = "button"  name="UpLoad" class="cssbutton" value="上载附件" onclick=""></td>
			</tr>
			<tr>
				<td colspan="6">
					<input type = "button"  name="SaveResult" class="cssbutton" value="契调结果保存" onclick="">
					<input type = "button"  name="returnButton" class="cssbutton" value="返  回" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
