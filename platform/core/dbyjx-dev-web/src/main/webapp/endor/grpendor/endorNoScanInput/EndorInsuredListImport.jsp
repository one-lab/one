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
    
    <title>导入被保人清单</title>
    
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     人名清单导入</td>
			</tr>
			<tr>
				<td class="left">上传文件：</td>
				<td class="right">
					<input name="ApplyType" class="common" type="text"  style="width:68%"><input name="comName" class="cssbutton" type="button" value="浏  览..." style="width:25%">
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>		
			</tr>
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="QueryButton" value="导  入" onclick="">
					<input type = "button" class="cssbutton" name="ApplyButton" value="返  回" onclick="javascript:history.go(-1)">
				</td>
			</tr>
		</table>
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     导入日志查询</td>
			</tr>
			<tr> 
				<td class="left">保全受理号：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">导入批次号：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">团体保单号：</td>
				<td class="right"><input name="State" class="common" type="text" value="晓岚" readonly></td>
			</tr>
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="">
				</td>
			</tr>
		</table>				
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     人名清单导入记录</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="15%">团体保单号</td>
					<td width="15%">保全受理号</td>
					<td width="17%">导入信息</td>
					<td width="15%">操作员</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>P860234342205</td>
					<td>SDF3213342205</td>
					<td>都邦保险公司北京分公司</td>
					<td>保全人</td>
				</tr>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>2</td>
					<td>P860234342205</td>
					<td>SDF3213342205</td>
					<td>都邦保险公司北京分公司</td>
					<td>保全人</td>
				</tr>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>3</td>
					<td>P860234342205</td>
					<td>SDF3213342205</td>
					<td>都邦保险公司北京分公司</td>
					<td>保全人</td>
				</tr>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>4</td>
					<td>P860234342205</td>
					<td>SDF3213342205</td>
					<td>都邦保险公司北京分公司</td>
					<td>保全人</td>
				</tr>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>5</td>
					<td>P860234342205</td>
					<td>SDF3213342205</td>
					<td>都邦保险公司北京分公司</td>
					<td>保全人</td>
				</tr>																
			</tbody>
		</table>
		<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>		
	</div>
	</form>
  </body>
</html>
