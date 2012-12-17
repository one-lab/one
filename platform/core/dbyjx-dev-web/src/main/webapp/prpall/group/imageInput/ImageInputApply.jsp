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
    
    <title>影像录入申请</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
  </head>
  <body>
    <form name="fm" method="post"  >
	<div style = "width:100%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">请输入查询条件</td>
			</tr>
			<tr> 
				<td class="left">管理机构：</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="都邦北京分公司"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">投保单号：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">投保单位全称：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">扫描日期：</td>
				<td class="right">
					<input name="ScanDate" id="ScanDate" class="common" type="text" style="width: 73%" value='2012-05-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'ScanDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>				
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
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">共享工作池</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="23%">投保单号</td>
					<td width="23%">管理机构名称</td>
					<td width="23%">扫描日期</td>
					<td width="23%">投保单位全称</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>G86012012005</td>
					<td>都邦保险公司北京分公司</td>
					<td>2012-05-18</td>
					<td>北京乐逍遥保健品有限公司</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick=""></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="ApplyButton" value="申  请" onclick="">
				</td>
			</tr>
		</table>
		<table id="scanApplycInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">扫描件信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="20%">投保单号</td>
					<td width="25%">管理机构名称</td>
					<td width="20%">扫描日期</td>
					<td width="25%">投保单位全称</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td><a href="javascript:void(0)" onclick="location.href='./ImageInput.jsp'">G86012012005</a></td>
					<td>都邦保险公司北京分公司</td>
					<td>2012-05-18</td>
					<td>北京乐逍遥保健品有限公司</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo2" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick=""></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>		
	</div>
	</form>
  </body>
</html>
