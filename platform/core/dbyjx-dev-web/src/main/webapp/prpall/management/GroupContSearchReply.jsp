<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>呈报契调回复</title>
    
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
		影像图片信息
		<hr>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     契调项目</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="31%">契调项目编号</td>
					<td width="31%">契调项目名称</td>
					<td width="33%">备注</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>双击下拉框选出</td>
					<td>投保事项</td>
					<td>12</td>
				</tr>
			</tbody>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">契调费用</td>
				<td class="right"><input type="text" class="common" name="text"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td colspan="6" >其他契调项目</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5" witdh=100%></textarea></td>
			</tr>
			<tr>
				<td colspan="6" >契调结论</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5" witdh=100%></textarea></td>
			</tr>			
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="ApplyButton" value="上载附件" onclick="">
				</td>
			</tr>		
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="ApplyButton" value="契调结果保存" onclick="">
					<input type = "button" class="cssbutton" name="ApplyButton" value="返  回" onclick="javascript:history.go(-1)">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
