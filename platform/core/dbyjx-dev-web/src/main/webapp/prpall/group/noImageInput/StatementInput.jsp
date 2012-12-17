<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>业务信息报告录入</title>
    
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
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     投保单位情况</td>
			</tr>
			<tr>
				<td class="left" align="left">被保险人清单内是否已填写清楚每一被保险人的具体情况：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">投保单位人员流动情况：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
		</table>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     投保作业信息</td>
			</tr>
			<tr>
				<td class="left">投保性质：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">业务投保性质：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">数据来源：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">统括保单：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">业务来源：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">联系人姓名：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">联系手机：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">是否有协议：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td colspan="6" >业务特殊说明</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5"></textarea></td>
			</tr>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td  >
					<input type = "button" class="cssbutton" name="ApplyButton" value="保存/修改" onclick="">
					<input type = "button" class="cssbutton" name="ApplyButton" value="返  回" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
