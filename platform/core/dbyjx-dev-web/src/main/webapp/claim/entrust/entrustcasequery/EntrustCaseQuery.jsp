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
    
	    <title>ί�а���������ѯ</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css"/>
		<script src="${ctx}/common/calender/WdatePicker.js"></script>

	</head>
<body>
	<form name="fm" method="post" onkeypress="KeyDown()">
	<div style="width:100%">
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�������ѯ����</td>
			</tr>
			<tr>
				<td class="left">�����ţ�</td>
				<td class="right"><input name="ClaimNum" class="common" type="text" onchange="clickable()"></td>
				<td class="left">ί�б�־��</td>
				<td class="right">
					<input class="codecode" id="entrustCode" name="lcReport.entrustCode" class="common" type="text" value="" style="width:20%"><input name="entrustFlag" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
		</table>
		<table  id="RiskInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AppntQuery" value="��  ѯ" onClick="" />
				</td>
			</tr>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">ί���ⰸ�б�</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="15%">������</td>
					<td width="10%">ί�и�λ</td>
					<td width="12%">ί������</td>
					<td width="10%">ί�в���Ա</td>
					<td width="12%">ί�л���</td>
					<td width="10%">��ί�и�λ</td>
					<td width="15%">��ί�л���</td>
					<td width="10%">ί�б�־</td>
				</tr>
		    </thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="��  ҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="β  ҳ"></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="SureButton" value="�ⰸ��ϸ��ѯ" onclick="self.location.href='${ctx}/claim/entrust/entrustcasequery/CaseInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="returnButton" value="����������ѯ" onclick="self.location.href='${ctx}/claim/entrust/entrustcasequery/OperaHistQuery.jsp'" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>