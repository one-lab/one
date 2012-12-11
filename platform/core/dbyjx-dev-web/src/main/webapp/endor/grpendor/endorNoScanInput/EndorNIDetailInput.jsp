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
    
    <title>保全增人</title>
    
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
				<td class="right"><input name="EndorAcceptNo" class="common" type="text"></td>
				<td class="left">批改类型：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%"></td>
				<td class="left">集体保单号：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">申请日期：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">生效日期</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="common"></td>
				<td class="common"></td>		
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     新增被保人</td>
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
					<td width="13%">险种</td>				
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>aaa</td>
					<td>aaa</td>
					<td>aaa</td>
					<td>aaa</td>
					<td>aaa</td>
					<td>aaa</td>
					<td>aaa</td>
				</tr>
			</tbody>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="删除被保人" onclick="">
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="录入完毕" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="返  回" onclick="javascript:history.go(-1);">
					<input type = "button" class="cssbutton" name="EndorAccept" value="人名清单导入" onclick="location.href='./EndorInsuredListImport.jsp'">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     补退费合计</td>
			</tr>
			<tr>
				<td class="left">补退费金额合计：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>				
			</tr>			
		</table>
	</div>
	</form>
  </body>
</html>
