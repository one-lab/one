<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
    	<base href="<%=basePath%>"/>
    
	    <title>����ҽԺ����</title>
	    
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
		<meta http-equiv="expires" content="0"/>    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
		<meta http-equiv="description" content="This is my page"/>
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css"/>
		<script src="${ctx}/common/calender/WdatePicker.js"></script>

	</head>
<body>
	<form name="fm" method="post" onKeyPress="KeyDown()">
	<div style="width:100%">
		<table id="HospitalInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>ҽԺ����</td>
			</tr>
			<tr>
				<td class="left">ҽԺ���ƣ�</td>
				<td class="right"><input name="HosName" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">ҽԺ�ȼ���</td>
				<td class="right"><input name="HosClass" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<table id="HosInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr class="tableHead">
					<td width="4%">���</td>
					<td width="50%">������Ŀ����</td>
					<td width="20%">����</td>
					<td width="20%">��������</td>
				</tr>
			</thead>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">�����ϼƣ�</td>
				<td class="right"><input name="TotalFraction" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="AddButton" value="��  ��" onClick=""/>
					<input type="button" class="cssbutton" name="ModifyButton" value="��  ��" onClick=""/>
					<input type="button" class="cssbutton" name="returnButton" value="��  ��" onclick="javascript:history.back();" />
					<input type="button" class="cssbutton" name="HosAssessTab" value="ҽԺ������׼��" onClick=""/>
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>