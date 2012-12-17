<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>特约录入</title>
    
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
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     个人险种信息</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="13%">批单号</td>
					<td width="12%">保单号</td>
					<td width="12%">险种号</td>
					<td width="12%">险种编码</td>
					<td width="12%">险种版本</td>
					<td width="12%">投保人</td>
					<td width="12%">被保人</td>
					<td width="12%">批改类型</td>				
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>嗷嗷嗷</td>
					<td>安安安</td>
					<td>安安安</td>
					<td>安安安</td>
					<td>安安安</td>
					<td>安安安</td>
					<td>安安安</td>
					<td>安安安</td>					
				</tr>
			</tbody>
		</table>
	</div>
	<div style = "width:70%">
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     保单原有特约</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="85%">特约内容</td>
					<td width="10%">状态</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     保全新增特约</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="82%">特约内容</td>
					<td width="10%">状态</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="checkradio" value="" ></td>
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     特约信息模板</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="92%">特约内容</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="checkradio" value="" ></td>
					<td>1</td>
					<td>主险合同的第一被保险人为本合同附加险的被保险人</td>
				</tr>
				<tr class="content">
					<td><input type="radio" name="checkradio" value="" ></td>
					<td>2</td>
					<td>本公司不承担保险条款中豁免保险费的保险责任</td>
				</tr>				
			</tbody>
		</table>
		<table id="auditIdeas" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" >特约原因</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="" cols="100%" rows="5"></textarea></td>
			</tr>
		</table>
		<table id="auditIdeas" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" >特别约定</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="" cols="100%" rows="5"></textarea></td>
			</tr>
		</table>					
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Confirm" value="添  加" onclick="">
					<input type = "button" class="cssbutton" name="Confirm" value="修  改" onclick="">
					<input type = "button" class="cssbutton" name="Confirm" value="删  除" onclick="">
					<input type = "button" class="cssbutton" name="Confirm" value="返  回" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
