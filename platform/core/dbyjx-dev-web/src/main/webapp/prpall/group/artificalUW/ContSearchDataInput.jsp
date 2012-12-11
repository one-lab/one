<%@page import="com.opensymphony.xwork2.ActionContext"%>
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
    
    <title>契调资料录入</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="common/js/SimpleCalendar.js"></script>
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript">
	     ctx = "${ctx}";
    </script>
	<script type="text/javascript" src="${ctx }/prpall/group/artificalUW/js/ContSearchDataInput.js"></script>
  </head>
  <body>
    <form id="fmSearchDateInput" name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     契调基本信息	</td>
			</tr>
			<tr> 
				<td class="left">投保单号：</td>
				<td class="right"><input name="lcCont.contNo" class="common" type="text" value="${lcCont.contNo }" readonly></td>
				<td class="left">核保人：</td>
				<td class="right"><input name="lcCont.uwOperator" class="common" type="text" value="${lcCont.uwOperator }" readonly></td>
				<td class="left">契调原因：</td>
				<td class="right"><input id="reason" name="lcSingleSearchInfo.reason" class="codecode" type="text" style="width:20%" ondblclick="queryCode('reason','reasonName','PDLDcode1','codeType:PrpallSearchReason')"/><input id="reasonName" name="reasonName" class="common" type="text" style="width:68%"/></td>
			</tr>
			<tr> 
				<td class="left">客户号码：</td>
				<td class="right"><input name="ldPerson.customerNo" class="common" type="text" value="${ldPerson.customerNo }" readonly ></td>
				<td class="left">客户姓名：</td>
				<td class="right"><input name="ldPerson.name" class="common" type="text" value="${ldPerson.name }" readonly></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>			
		</table>
	</div>
	<div style = "width:80%">
		<table id="SearchItemTable" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     契调项目录入</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="30%">契调项目编号</td>
					<td width="30%">契调项目名称</td>
					<td width="30%">备注</td>
					<td width="5%"></td>
				</tr>
			</thead>
			<tbody id="searchItemBoby">
			
			</tbody>
			<tr>
				<td><input type="button" value="+" onclick="addItemInfo()" /></td>
			</tr>
			<tr>
				<td colspan="6">其他契调信息</td>
			</tr>
			<tr>
				<td colspan="4"><textarea id="othermessage" name="lcSingleSearchInfo.otherMessage" cols="100%" rows="5"></textarea></td>
			</tr>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input id="saveSearchInfoSubmit" type = "button" class="cssbutton" name="saveSearchInfoSubmit" value="确  认" onclick="saveSingleSearchInfo()">
					<input type = "button" class="cssbutton" name="ReturnBack" value="返  回" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
