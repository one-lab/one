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
    
    <title>投保单复制</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript">ctx="${ctx}"</script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>		

  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     保单复制</td>
			</tr>
			<tr> 
				<td class="left">原保单号：</td>
				<td class="right"><input name="ManageCom" class="common" type="text"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left"><input name="QueryButton" class="cssbutton" type="button" value="查  询"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<br><hr>
		<table id="ContractInfo" class="common" cellpadding="3" cellspacing="0">
			<tr> 
				<td class="left">新投保单号：</td>
				<td class="right"><input name="ManageCom" class="common" type="text"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">新保费总额：</td>
				<td class="right"><input name="ManageCom" class="common" type="text"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">管理机构：</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="都邦北京分公司"></td>
			</tr>
			<tr> 
				<td class="left">主揽业务员编码：</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="李四"></td>
				<td class="left">预打保单标记：</td>
				<td class="right"><input name="ManageCom" class="common" type="text"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left"><input name="QueryButton" class="cssbutton" type="button" value="复  制"></td>
				<td class="common"></td>
			</tr>
		</table>
		<br><hr>
	</div>
	</form>
  </body>
</html>
