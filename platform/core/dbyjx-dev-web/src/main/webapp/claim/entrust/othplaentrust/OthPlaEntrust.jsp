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
    
	    <title>���ί����Ϣ��ѯ</title>
	    
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
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�ⰸ��ѯ</td>
			</tr>
			<tr>
				<td class="left">�ⰸ�׶Σ�</td>
				<td class="right"><input class="codecode" id="claimPhase" name="lcReport.claimPhase" class="common" type="text" value="" style="width:20%"><input name="claimPhase" class="common" type="text" onchange="clickable()" style="width:68%" value=""></td>
				<td class="left">�ⰸ�ţ�</td>
				<td class="right"><input name="claimNo" class="common" type="text" onchange="clickable()"></td>
				<td class="common"> </td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">���������</td>
				<td class="right"><input class="codecode" id="mngCom" name="lcReport.mngCom" class="common" type="text" value="" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value=""></td>
				<td class="left">ί�б�־��</td>
				<td class="right"><input class="codecode" id="entrustFlag" name="lcReport.entrustFlag" class="common" type="text" value="" style="width:20%"><input name="entrustFlag" class="common" type="text" onchange="clickable()" style="width:68%" value=""></td>
				<td class="common"> </td>
				<td class="common"></td>
			</tr>
		</table>
		<table  id="RiskInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AppntSelect" value="��  ѯ" onClick="" />
					<input type="button" class="cssbutton" name = "AppntSelect" value="�ⰸ��ϸ��ѯ" onclick="self.location.href='${ctx}/claim/claimoperate/register/PastClaimInfoQuery.jsp'" />
				</td>
			</tr>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�ⰸ�б�</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="15%">������</td>
					<td width="10%">ί�и�λ</td>
					<td width="10%">ί������</td>
					<td width="10%">ί�в���Ա</td>
					<td width="15%">ί�л���</td>
					<td width="10%">��ί�и�λ</td>
					<td width="15%">��ί�л���</td>
					<td width="9%">ί�б�־</td>
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
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">��ע��Ϣ¼��</td>
			</tr>
		</table>
		<table  id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td>��ע��Ϣ</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="AccidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">ѡ�������ͣ�</td>
				<td  class="right">
					<input class="codecode" id="dealCode" name="lcReport.dealCode" class="common" type="text" value="01" style="width:20%"><input name="dealType" class="common" type="text" onchange="clickable()" style="width:68%" value="����ί��"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="sureButton" value="����ȷ��" onClick="" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>