<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>体检录入</title>
    
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
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     体检基本信息</td>
			</tr>
			<tr> 
				<td class="left">集体合同号码：</td>
				<td class="right"><input name="ManageCom" class="common" type="text" readonly></td>
				<td class="left">合同号码：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">打印状态：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
			</tr>
			<tr> 
				<td class="left">体检人：</td>
				<td class="right"><input name="ManageCom" class="common" type="text" readonly></td>
				<td class="left">体检原因：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				<td class="left">是否空腹：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
			</tr>			
			<tr>
				<td class="left">体检日期：</td>
				<td class="right">
					<input name="StartDate" id="ScanDate" class="common" type="text" style="width: 73%" value='2012-05-28' readonly>
					<img style='cursor: hand' align="absmiddle" src="images/bgcalendar.gif"  onClick="TogglePopupCalendarWindow(this, '1997', '2014')">
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>				
			</tr>
		</table>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     体检类型选择</td>
			</tr>
			<tr>
				<td colspan="6"><input type="radio" name="sex" value="">临床物理检查、心电图、尿常规</td>
			</tr>
			<tr>
				<td colspan="6"><input type="radio" name="sex" value="">临床物理检查、心电图、尿常规、空腹血糖、血常规、肝功能、乙肝表面抗原、血脂、肾功能</td>
			</tr>
			<tr>
				<td colspan="6"><input type="radio" name="sex" value="">临床物理检查、心电图、尿常规、空腹血糖、血常规、肝功能、乙肝表面抗原、血脂、肾功能、眼底、B超、胸部透视</td>
			</tr>
			<tr>
				<td colspan="6"><input type="radio" name="sex" value="">临床物理检查、心电图、尿常规、空腹血糖、血常规、肝功能、乙肝表面抗原、血脂、肾功能、眼底、B超、胸部透视、妇科检查</td>
			</tr>			
		</table>
		<table id="scanApplycInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     体检项目选择</td>
			</tr>
			<tr>
				<td colspan="6"><input type="checkbox" name="sex" value="">临床物理检查（身高、体重、血压、内科检查、外科检查）</td>
			</tr>
			<tr>
				<td colspan="6"><input type="checkbox" name="sex" value="">心电图</td>
			</tr>
			<tr>
				<td colspan="6"><input type="checkbox" name="sex" value="">尿常规</td>
			</tr>
			<tr>
				<td colspan="6"><input type="checkbox" name="sex" value="">空腹血糖（空腹血糖、糖耐量）</td>
			</tr>
			<tr>
				<td colspan="6"><input type="checkbox" name="sex" value="">血常规</td>
			</tr>
			<tr>
				<td colspan="6"><input type="checkbox" name="sex" value="">肝功能</td>
			</tr>
			<tr>
				<td colspan="6"><input type="checkbox" name="sex" value="">乙肝表面抗原</td>
			</tr>
			<tr>
				<td colspan="6"><input type="checkbox" name="sex" value="">血脂</td>
			</tr>
			<tr>
				<td colspan="6"><input type="checkbox" name="sex" value="">肾功能</td>
			</tr>
			<tr>
				<td colspan="6"><input type="checkbox" name="sex" value="">眼底</td>
			</tr>
			<tr>
				<td colspan="6"><input type="checkbox" name="sex" value="">B超</td>
			</tr>
			<tr>
				<td colspan="6"><input type="checkbox" name="sex" value="">胸部透视</td>
			</tr>
			<tr>
				<td colspan="6"><input type="checkbox" name="sex" value="">衰弱测试</td>
			</tr>															
			<tr>
				<td>其他体检信息</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5" witdh=100%></textarea></td>
			</tr>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Confirm" value="确  认" onclick="">
					<input type = "button" class="cssbutton" name="ReturnBack" value="返  回" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
