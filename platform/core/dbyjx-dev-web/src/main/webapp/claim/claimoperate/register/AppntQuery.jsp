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
    	
	    <title>�ͻ���Ϣ��ѯ</title>
	    
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
	<div id="appntInfo" style="width:100%">
		<table id=appntInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				 <td><jsp:include page="../report/AppntQuery.jsp"/></td>
			</tr>
		</table>
	</div>
	<div id="appntReportInfo" style="width:100%">
		
		<table id="appntReportInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�����˱�����Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="20%">������</td>
					<td width="10%">����������</td>
					<td width="12%">��������</td>
					<td width="20%">�����˿ͻ���</td>
					<td width="10%">����������</td>
					<td width="10%">�Ա�</td>
					<td width="12%">��������</td>
				</tr>
			<thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>16564148411</td>
					<td>��</td>
					<td>2012-04-15</td>
					<td>201200001</td>
					<td>��</td>
					<td>��</td>
					<td>2012-03-15</td>
				</tr>
			</tbody>
		</table>
	</div>
	</form>
</body>
</html>