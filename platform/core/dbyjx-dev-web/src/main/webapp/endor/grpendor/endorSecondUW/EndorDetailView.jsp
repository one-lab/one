<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>保全明细查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr> 
				<td class="left">保全受理号：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">批改类型：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">集体保单号：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
			</tr>
			 <tr>
			 	<td class="left">申请日期：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">生效日期：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="common"></td>
				<td class="common"></td>
			 </tr>			 
		</table>
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     团体被保人信息</td>
			</tr>
			<tr> 
				<td class="left">个人保单号：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">证件类型：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%">
				</td>
				<td class="left">证件号码：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>				
			</tr>
			 <tr>
			 	<td class="left">客户姓名：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">客户性别：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%">
				</td>
				<td class="left">出生日期：</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='2012-04-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			 </tr>
		</table>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="查  询 " onclick="">
				</td>
			</tr>
		</table>		
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="14%">保单号</td>
					<td width="13%">姓名</td>
					<td width="13%">性别</td>
					<td width="13%">出生日期</td>
					<td width="13%">证件类型</td>
					<td width="13%">证件号码</td>
					<td width="13%">批改状态</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>32528601203453212005</td>
					<td>战三</td>
					<td>男</td>
					<td>2012-05-18</td>
					<td>身份证</td>
					<td>11111111111111111110</td>
					<td>未添加</td>
				</tr>
			</tbody>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="添加被保人 " onclick="">
				</td>
			</tr>
		</table>
	</div>
	<div style = "width:100%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     个人保全项目信息</td>
			</tr>
			<tr> 
				<td class="left">证件类型：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%">
				</td>
				<td class="left">证件号码：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">个人保单号：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>				
			</tr>
			 <tr>
			 	<td class="left">客户姓名：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">客户性别：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%">
				</td>
				<td class="left">出生日期：</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='2012-04-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			 </tr>
		</table>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="查  询 " onclick="">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="12%">保单号</td>
					<td width="10%">客户号</td>
					<td width="10">姓名</td>
					<td width="10%">性别</td>
					<td width="10%">出生日期</td>
					<td width="10%">证件类型</td>
					<td width="10%">证件号码</td>
					<td width="10%">批改状态</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>32528601203453212005</td>
					<td>000656005</td>
					<td>战三</td>
					<td>男</td>
					<td>2012-05-18</td>
					<td>身份证</td>
					<td>11111111111111111110</td>
					<td>未添加</td>
				</tr>
			</tbody>
		</table>					
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="保全项目明细" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="撤销被保人" onclick="">
				</td>
			</tr>			
		</table>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="录入完毕" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="返  回" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>			
	</div>
	</form>
  </body>
</html>
