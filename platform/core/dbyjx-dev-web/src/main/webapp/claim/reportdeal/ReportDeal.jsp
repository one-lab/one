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
    
	    <title>�ʱ�����</title>
	    
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
		<table id="ReportInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">ѡ�гʱ�����Ϣ</td>
			</tr>
			<tr>
				<td class="left">�����ţ�</td>
				<td class="right"><input name="reportNo" class="common" type="text" onChange="clickable()"></td>
				<td class="left">�ʱ���ţ�</td>
				<td class="right"><input name="ReportNum" class="common" type="text" onChange="clickable()"></td>
				<td class="left">�ʱ�״̬��</td>
				<td class="right"><input name="ReportState" class="common" type="text" onChange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">�ʱ��ˣ�</td>
				<td  class="right"><input name="Reporter" class="common" type="text" onChange="clickable()"></td>
				<td  class="left">�ʱ�������</td>
				<td  class="right">
					<input class="codecode" id="reportComCode" name="lcReport.reportComCode" class="common" type="text" value="" style="width:20%" ><input name="reportCom" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">�ʱ����ڣ�</td>
				<td  class="right"><input name="ReportDate" class="common" type="text" onChange="clickable()"></td>
			</tr>
		</table>
		<table id="ReportDesc" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td >�ʱ�����</td>
			</tr>
			<tr>
				<td><textarea name="ReportDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
			<tr>
				<td colspan="4">�ʱ��������(�����������1000����)</td>
			</tr>
			<tr>
				<td><textarea name="ReportDeal" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "ClaimInfo" value="������Ϣ�鿴" onClick="self.location.href='${ctx}/claim/claimoperate/report/ReportAdd.jsp'" />
					<input type="button" class="cssbutton" name = "saveButton" value="��  ��" onClick="" />
					<input type="button" class="cssbutton" name = "returnButton" value="��  ��" onClick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>