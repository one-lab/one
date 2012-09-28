<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>团体体检回复</title>
    
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
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr> 
				<td class="left">体检医院：</td>
				<td class="right"><input name="ManageCom" class="common" type="text"></td>
				<td class="left">体检医师：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">体检时间：</td>
				<td class="right">
					<input name="StartDate" id="ScanDate" class="common" type="text" style="width: 73%" value='2012-05-28'>
					<img style='cursor: hand' align="absmiddle" src="images/bgcalendar.gif"  onClick="TogglePopupCalendarWindow(this, '1997', '2014')">
				</td>
				<td class="left">复查时间：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="">
				</td>
			</tr>
		</table>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     体检项目</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="31%">体检项目名称</td>
					<td width="31%">体检项目结论</td>
					<td width="33%">备注</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>身高</td>
					<td>N 双击下拉框</td>
					<td>厘米</td>
				</tr>
			</tbody>
		</table>
		<table id="scanApplycInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     疾病结果</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="31%">疾病症状</td>
					<td width="31%">疾病结论</td>
					<td width="33%">ICD编码 双击下拉框</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" >其他体检信息</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5" witdh=100%></textarea></td>
			</tr>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="ApplyButton" value="体检结果保存" onclick="">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
