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
    
	    <title>�������</title>
	    
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
					<td width="2%"><input type="radio" name="Redio" value="" /></td>
					<td width="4%">���</td>
					<td width="25%">�ⰸ��</td>
					<td width="25%">��ͬ����</td>
					<td width="22%">�����������</td>
					<td width="22%">����������</td>
				</tr>
			</thead>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�ύ����ԭ��</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="AccidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="ContractInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="5"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�Ѿ����κ˱���ɵĺ�ͬ�б�</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="32%">�ⰸ��</td>
					<td width="32%">��ͬ����</td>
					<td width="30%">�����������</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>414512140011</td>
					<td>421354111154</td>
					<td>2010-12-01</td>
				</tr>
				<tr class="content">
					<td><input type="radio" name="Redio2" value="" /></td>
					<td>1</td>
					<td>414512140011</td>
					<td>421354111154</td>
					<td>2010-12-01</td>
				</tr>
			</tbody>
		</table>
		<table id="TypePlan" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">���ּƻ�</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">���</td>
					<td width="10%">���ִ���</td>
					<td width="15%">��������</td>
					<td width="10%">����(Ԫ)</td>
					<td width="10%">����/����</td>
					<td width="6%">��������</td>
					<td width="10%">��׼����(Ԫ)</td>
					<td width="10%">ԭ����(Ԫ)</td>
					<td width="10%">�ӷѽ��</td>
					<td width="15%">ԭ�˱�����</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>0612</td>
					<td>����Ӹ��������˺�ҽ�Ʊ���</td>
					<td>2000</td>
					<td>10</td>
					<td>1</td>
					<td>1000</td>
					<td>1000</td>
					<td>0</td>
					<td>��׼��</td>
				</tr>
				<tr class="content">
					<td>2</td>
					<td>0612</td>
					<td>����Ӹ��������˺�ҽ�Ʊ���</td>
					<td>2000</td>
					<td>10</td>
					<td>1</td>
					<td>1000</td>
					<td>1000</td>
					<td>0</td>
					<td>��׼��</td>
				</tr>
			</tbody>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�˱����</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="AccidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="Button" value="��  ��" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>