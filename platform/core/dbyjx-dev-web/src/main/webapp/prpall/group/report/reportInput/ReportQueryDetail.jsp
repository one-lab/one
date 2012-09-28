<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>呈报查询子页面</title>
    
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
		<table id="RepReturnInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     呈报返回信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="11%">呈报号</td>
					<td width="11%">呈报批次</td>
					<td width="15%">呈报审核人</td>
					<td width="11%">审核时间</td>
					<td width="11%">审核结论</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>S86012012005</td>
					<td>S86012012005_11</td>
					<td>张三</td>
					<td>2012-05-28</td>
					<td>审核通过</td>
				</tr>
			</tbody>
			<tr>
				<td>审核意见</td>
			</tr>
			<tr>
				<td><textarea name="idea" cols="100%" rows="5" witdh=100%></textarea></td>
			</tr>
		</table>	
		<table id="prpallInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../reportInput/ProPalPublicMessage.jsp" /> </td>
			</tr>
		</table>
		<hr>
		<table  id="ReturnInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="10%"><input type="button"  name="returnButton" class="cssbutton" value="返  回" onclick="javascript:history.go(-1);"></td></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
