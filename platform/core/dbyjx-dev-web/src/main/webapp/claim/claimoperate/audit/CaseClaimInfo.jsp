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
    
	    <title>��������������ѯ</title>
	    
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
		<table id="CaseInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">��������������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="20%">�ⰸ��</td>
					<td width="17%">�������</td>
					<td width="17%">����Ա</td>
					<td width="25%">�������</td>
					<td width="15%">��������</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio" value="" /></td>
					<td>1</td>
					<td>64131641212</td>
					<td>1</td>
					<td>100</td>
					<td>862100</td>
					<td>2010-10-20</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="5%" align='right'><input type = "button" class="cssbutton" value="��  ҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="85%"><input type = "button" class="cssbutton" value="β  ҳ"></td>
			</tr>
		</table>
	</div>
	<div style="width:100%" id="AuditResult">
		<table id="ApproveMng" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">��˹���</td>
			</tr>
			<tr>
				<td  class="left">��˽��ۣ�</td>
				<td  class="right"><input name="FeeType" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">���ⱸע��</td>
				<td  class="right"><input name="FeeCode" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td  class="left">����ˣ�</td>
				<td  class="right"><input name="ServiceName" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">������ڣ� </td>
				<td  class="right"><input name="ServiceName" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td>������</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="AccidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<hr />
		<table id="AuditContent" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">��������</td>
			</tr>
			<tr>
				<td  class="left">�������ۣ�</td>
				<td  class="right"><input name="FeeType" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�����ˣ�</td>
				<td  class="right"><input name="FeeCode" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�������ڣ�</td>
				<td  class="right"><input name="FeeCode" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">��ͨ��ԭ��</td>
				<td  class="right"><input name="ServiceName" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">��ͨ�����ݣ� </td>
				<td  class="right"><input name="ServiceName" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td>�������</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="AccidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "returnButton" value="��  ��" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>