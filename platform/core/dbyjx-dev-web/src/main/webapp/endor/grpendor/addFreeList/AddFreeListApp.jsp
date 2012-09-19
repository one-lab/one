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
    
    <title>无名单补名单申请</title>
    
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
				<td class="left">投保单号：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">集体保单号：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">个人保单号：</td>
				<td  class="right"><input name="RepApplyNo" class="common" type="text"></td>
			</tr>
			<tr> 
				<td  class="left">单证号：</td>
				<td  class="right"><input name="RepApplyNo" class="common" type="text"></td>
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
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     保单信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="15%">投保单号</td>
					<td width="15%">集体保单号</td>
					<td width="14%">个人保单号</td>
					<td width="8%">无名单人数</td>
					<td width="8%">总保费</td>	
					<td width="8%">总保额</td>	
					<td width="8%">生效日期</td>
					<td width="8%">层级</td>	
					<td width="8%">承保人数</td>												
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>SE86012012005</td>
					<td>P5646860101</td>
					<td>43123132155767</td>
					<td>11</td>
					<td>100000</td>
					<td>5000</td>
					<td>2012-05-18</td>
					<td>员工</td>
					<td>20</td>					
				</tr>					
			</tbody>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="补名单" onclick="location.href='./AddFreeListInput.jsp'">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
