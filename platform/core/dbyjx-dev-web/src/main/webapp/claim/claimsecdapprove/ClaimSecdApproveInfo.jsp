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
    
	    <title>������κ˱�</title>
	    
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
	<div style="width:100%">
		<table id="ContractList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">������˵�δ�˱���ɵĺ�ͬ�б�</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="25%">�ⰸ��</td>
					<td width="20%">�˱���</td>
					<td width="25%">�����������</td>
					<td width="20%">����������</td>
				</tr>
		    </thead>
		</table>
		<hr />
		<table id="RiskInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AppntInfo" value="������ϸ��Ϣ��ѯ" onClick="self.location.href='${ctx}/claim/claimsecdapprove/AppInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name = "AuditResult" value="�˱����۲�ѯ" onClick="" />
					<input type="button" class="cssbutton" name = "scanQuery" value="Ӱ�����ϲ�ѯ" onClick="" />
					<input type="button" class="cssbutton" name = "PhyExamQuery" value="������ϲ�ѯ" onClick="self.location.href='${ctx}/claim/claimsecdapprove/PhyExamInfoQuery.jsp'" />
				</td>
			</tr>
		</table>
		<table id="InsurancePlan" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">���ּƻ�</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">���</td>
					<td width="10%">���ִ���</td>
					<td width="10%">��������</td>
					<td width="10%">����(Ԫ)</td>
					<td width="6%">����/����</td>
					<td width="6%">�ɷ�����</td>
					<td width="10%">��׼����(Ԫ)</td>
					<td width="10%">ԭ����(Ԫ)</td>
					<td width="10%">�ӷѽ��</td>
					<td width="10%">ԭ�˱�����</td>
				</tr>
		    </thead>
		</table>
		<table id="AuditOpinion" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td >�˱����(�����������120����)</td>
			</tr>
			<tr>
				<td><textarea name="AuditOpinion" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="AuditSucs" value="�˱����" onclick="" />
					<input type="button" class="cssbutton" name="returnButton" value="��  ��" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>