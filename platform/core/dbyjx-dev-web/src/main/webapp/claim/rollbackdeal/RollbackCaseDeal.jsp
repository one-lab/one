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
    
	    <title>���˰�������</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>

	</head>
<body>
	<form name="fm" method="post" onKeyPress="KeyDown()">
	<div style="width:100%">
		<table id="RollbackCaseInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">������Ϣ</td>
			</tr>
			<tr>
				<td class="left">�ⰸ�ţ�</td>
				<td class="right"><input name="ClaimNum" class="common" type="text" onChange="clickable()"></td>
				<td class="left">ԭ��˽��ۣ�</td>
				<td class="right"><input name="OldAuditResult" class="common" type="text" onChange="clickable()"></td>
				<td class="left">ԭ�⸶�ܽ�</td>
				<td class="right"><input name=" OldTotalMount" class="common" type="text" onChange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">���˺���˽��ۣ�</td>
				<td  class="right">
					<input class="codecode" id="auditResultCode" name="lcReport.auditResultCode" class="common" type="text" value="" style="width:20%"><input name="auditResult" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">����ԭ��</td>
				<td  class="right">
					<input class="codecode" id="rollReasonCode" name="lcReport.rollReasonCode" class="common" type="text" value="" style="width:20%"><input name="rollReason" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">�����������ڣ�</td>
				<td  class="right"><input name="ApplyDate" class="common" type="text" onChange="clickable()"></td>
			</tr>
		</table>
		<table id="RollbackInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td >����ԭ����ϸ˵��(�����������900����)</td>
			</tr>
			<tr>
				<td><textarea name="RollbackReason" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
			<tr>
				<td >��ע(�����������900����)</td>
			</tr>
			<tr>
				<td><textarea name="remarks" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "ClaimInfo" value="�ⰸ��ϸ��ѯ" onClick="self.location.href='${ctx}/claim/rollbackdeal/RollbackClaimInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name = "saveButton" value="��  ��" onClick="" />
					<input type="button" class="cssbutton" name = "TempPayVerify" value="�ݽ��Ѻ���" onClick="" />
					<input type="button" class="cssbutton" name = "Rollback" value="����ȷ��" onClick="" />
					<input type="button" class="cssbutton" name = "returnButton" value="��  ��" onClick="javascript:history.back();" />
				</td>
			</tr>
		</table>
		<table id="RollbackAccountInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>��������Ӧ����Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%"></td>
					<td width="4%">���</td>
					<td width="15%">֪ͨ�����</td>
					<td width="15%">Ͷ���˿ͻ�����</td>
					<td width="10%">��Ӧ�ս��</td>
					<td width="20%">�ɷ�����</td>
					<td width="15%">����ת�˳ɹ���־</td>
				</tr>
			</thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "PrintButton" value="��ӡ��������շ�֪ͨ��" onClick="" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>