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
    
    <title>保全有问题件修改</title>
    
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     请输入查询条件</td>
			</tr>
			<tr> 
				<td  class="left">保全受理号：</td>
				<td  class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">号码类型：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:65%">
				</td>
				<td  class="left">团体保单号：</td>
				<td  class="right"><input name="RepApplyNo" class="common" type="text"></td>
			</tr>
			<tr> 
				<td  class="left">申请人：</td>
				<td  class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">申请方式：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:65%">
				</td>
				<td class="left">扫录入日期：</td>
					<td class="right">
						<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='2012-04-28'>
						<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
					</td>
			</tr>
			<tr> 
				<td class="left">管理机构：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:65%">
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
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     共享工作池</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="14%">保全受理号</td>
					<td width="13%">团体保单号</td>
					<td width="13%">投保单位</td>
					<td width="13%">申请方式</td>
					<td width="13%">管理机构</td>	
					<td width="13%">录入人员</td>	
					<td width="13%">录入日期</td>								
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>SE86012012005</td>
					<td>P5646860101</td>
					<td>新华书店</td>
					<td>11</td>
					<td>860101</td>
					<td>发的</td>
					<td>2012-05-18</td>
				</tr>					
				</tr>
			</tbody>
			<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick="location.href='ReportAuditDeal.jsp'"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
				</tr>
			</table>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="申  请" onclick="">
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
					<td width="13%">保全受理号</td>
					<td width="13%">团体保单号</td>
					<td width="14%">投保单位</td>
					<td width="13%">申请方式</td>
					<td width="13%">管理机构</td>
					<td width="13%">录入员</td>
					<td width="13%">录入日期</td>					
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>SE86012012005</td>
					<td>P154635464646</td>
					<td>铁路交通航空</td>
					<td>客户亲自办理</td>
					<td>都邦保险公司</td>
					<td>萧萧</td>
					<td>2012-05-18</td>
				</tr>
			</tbody>
			<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick=""></td>
					<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
				</tr>
			</table>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="问题件修改" onclick="location.href='../endorNoScanInput/GrpEndorApplyAccept.jsp'">
					<input type = "button" class="cssbutton" name="EndorAccept" value="记事本查看" onclick="">
				</td>
			</tr>
		</table>				
	</div>
	</form>
  </body>
</html>
