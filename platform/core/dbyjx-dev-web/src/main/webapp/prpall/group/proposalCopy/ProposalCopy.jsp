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
    
    <title>Ͷ��������</title>
    
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ��������</td>
			</tr>
			<tr> 
				<td class="left">ԭ�����ţ�</td>
				<td class="right"><input name="ManageCom" class="common" type="text"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left"><input name="QueryButton" class="cssbutton" type="button" value="��  ѯ"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<br><hr>
		<table id="ContractInfo" class="common" cellpadding="3" cellspacing="0">
			<tr> 
				<td class="left">��Ͷ�����ţ�</td>
				<td class="right"><input name="ManageCom" class="common" type="text"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">�±����ܶ</td>
				<td class="right"><input name="ManageCom" class="common" type="text"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">���������</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="������ֹ�˾"></td>
			</tr>
			<tr> 
				<td class="left">����ҵ��Ա���룺</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="����"></td>
				<td class="left">Ԥ�򱣵���ǣ�</td>
				<td class="right"><input name="ManageCom" class="common" type="text"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left"><input name="QueryButton" class="cssbutton" type="button" value="��  ��"></td>
				<td class="common"></td>
			</tr>
		</table>
		<br><hr>
	</div>
	</form>
  </body>
</html>
