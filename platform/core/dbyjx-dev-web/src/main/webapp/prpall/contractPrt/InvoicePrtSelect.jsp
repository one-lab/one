<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发票打印</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript">ctx = "${ctx}";</script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     请输入查询条件</td>
			</tr>
			<tr> 
				<td class="left">团体保单号：</td>
				<td class="right"><input name="ManageCom" class="common" type="text"></td>
				<td class="left">收据号：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				<td class="left">收费类型：</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','comCode:21102');"><input id="comName" name="comName" class="common" type="text"   style="width:68%" value="都邦北京分公司"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>			
			</tr>
			<tr>
				<td class="left">收费日期起期：</td>
				<td class="right">
					<input id="repApplyDate" name="lcReport.repApplyDate" class="common" type="text"  style="width: 73%" value='2012-04-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onClick="WdatePicker({el:'repApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="left">收费日期止期：</td>
				<td class="right">
					<input id="repApplyDate" name="lcReport.repApplyDate" class="common" type="text"  style="width: 73%" value='2012-04-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onClick="WdatePicker({el:'repApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="common"></td>
				<td class="common"></td>						
			</tr>
		</table>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     发票信息</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="15%">保单号</td>
					<td width="20%">团体单位名称</td>
					<td width="15%">收费类型</td>
					<td width="15%">收费金额</td>
					<td width="15%">收据号</td>
					<td width="15%">收费日期</td>					
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>					
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
				<td class="left">发票号码：</td>
				<td class="right"><input type="text" class="common" name="textss"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td><input type = "button" class="cssbutton" name="ApplyButton" value="打  印" onclick=""></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
