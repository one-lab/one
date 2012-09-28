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
    
    <title>被保险人基本信息变更</title>
    
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
				<td class="right"><input name="EndorAcceptNo" class="common" type="text" readonly></td>
				<td class="left">批改类型：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%" readonly></td>
				<td class="left">集体保单号：</td>
				<td class="right"><input name="EndorApplyNo" class="common" type="text" readonly></td>
			</tr>
			<tr> 
				<td class="left">申请日期：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">生效日期：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     团体被保险人信息</td>
			</tr>
			<tr>
				<td class="left">个人保单号：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>			
				<td class="left">证件类型：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
				<td class="left">个人保单号：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>				
			</tr>
			<tr>
				<td class="left">客户姓名：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>			
				<td class="left">客户性别：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
				<td class="left">出生日期：</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" style="width: 73%" value='2012-04-28'>
				</td>
			</tr>			
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="查  询" onclick="">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     我的任务</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="15%">保单号</td>
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
					<td><input name="CheckRadio" type="checkBox" value="" /></td>
					<td>1</td>
					<td>3424386012012005</td>
					<td>李步轩</td>
					<td>男</td>
					<td>身份证</td>
					<td>111111111111111</td>
					<td>2012-05-18</td>
					<td>未添加</td>
				</tr>
			</tbody>
		</table>
		<br>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="添加被保人" onclick="">
				</td>
			</tr>
		</table>
		<br>
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     个人保全项目信息</td>
			</tr>		
			<tr> 
				<td class="left">证件类型：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
				<td class="left">证件号码：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
				<td class="left">个人保单号：</td>
				<td class="right"><input name="EndorApplyNo" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">客户姓名：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>			
				<td class="left">客户性别：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
				<td class="left">出生日期：</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" style="width: 73%" value='2012-04-28'>
				</td>
			</tr>			
		</table>
		<br>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="查  询" onclick="">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="15%">保单号</td>
					<td width="11%">客户号</td>
					<td width="11%">姓名</td>
					<td width="11%">性别</td>
					<td width="11%">出生日期</td>
					<td width="11%">证件类型</td>
					<td width="11%">证件号码</td>
					<td width="11%">批改状态</td>						
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="checkBox" value="" /></td>
					<td>1</td>
					<td>3424386012012005</td>
					<td>0000012005</td>
					<td>李步轩</td>
					<td>男</td>
					<td>身份证</td>
					<td>111111111111111</td>
					<td>2012-05-18</td>
					<td>未添加</td>
				</tr>
			</tbody>
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="保全项目明细" onclick="location.href='./EndorItemDetailInput.jsp'">
					<input type = "button" class="cssbutton" name="Confirm" value="撤销被保人" onclick="">
				</td>
			</tr>
		</table>
		<br>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="录入完毕" onclick="">
					<input type = "button" class="cssbutton" name="Confirm" value="返  回" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>					
	</div>
	</form>
  </body>
</html>
