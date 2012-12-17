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
    
    <title>保单打印任务选取</title>
    
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">请输入查询条件</td>
			</tr>
			<tr>
				<td class="left">团体投保单号：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>			
				<td class="left">团体保单号：</td>
				<td class="right"><input name="ManageCom" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">管理机构：</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','comCode:21102');"><input id="comName" name="comName" class="common" type="text"   style="width:68%" value="都邦北京分公司"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>			
				<td class="left">业务员编码：</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','comCode:21102');"><input id="comName" name="comName" class="common" type="text"   style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>			
			<tr>
				<td class="left">生效日期：</td>
				<td class="right">
					<input name="ValidDate" id="ValidDate" class="common" type="text" style="width: 73%" value='2012-05-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'ValidDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="common"></td>
				<td class="common"></td>						
			</tr>
		</table>
		<br>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="ApplyButton" value="查询保单" onclick="">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     投保单信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="13%">团体投保单号</td>
					<td width="13%">团体保单号</td>
					<td width="13%">管理机构</td>
					<td width="13%">业务员编码</td>
					<td width="13%">团体保费</td>
					<td width="14%">团体单位名称</td>
					<td width="13%">生效日期</td>					
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>&nbsp;</td>
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
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0" style="width:40%">
			<tr>
				<td width="30%" class="left">单证流水号：</td>
				<td width="70%" class="right"><input type="text" class="common" name="textss"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type = "button" class="cssbutton" name="ApplyButton" value="打印保单正文" onclick="">
					<input type = "button" class="cssbutton" name="ApplyButton" value="打印保单附件" onclick="">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
