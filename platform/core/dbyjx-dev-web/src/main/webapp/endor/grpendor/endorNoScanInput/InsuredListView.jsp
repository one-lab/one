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
    
    <title>�����嵥��ѯ</title>
    
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
	<div style = "width:100%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">���ֱ��룺</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%">
				</td>
				<td class="left">���˱����ţ�</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				<td class="left">���˿ͻ�������</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
		</table>
		<hr>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="QueryButton" value="��  ѯ" onclick="">
				</td>
			</tr>
		</table>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ���˱�����Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">���</td>
					<td width="10%">���˱�����</td>
					<td width="8%">���˿ͻ���</td>
					<td width="6%">����������</td>
					<td width="6%">����</td>
					<td width="6%">����Ƶ��</td>
					<td width="6%">Ͷ������</td>
					<td width="6%">����</td>
					<td width="6%">����</td>
					<td width="6%">����״̬</td>
					<td width="6%">������������</td>
					<td width="6%">���ϲ㼶</td>
					<td width="8%">��Ч����</td>
					<td width="6%">��Ӧ������</td>
					<td width="6%">��ס�����˹�ϵ</td>										
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>1300566868120</td>
					<td>00005684</td>
					<td>����</td>
					<td>4025</td>
					<td>0</td>
					<td>31</td>
					<td>200</td>
					<td>150000</td>
					<td>�б�</td>
					<td>1</td>
					<td>����</td>
					<td>2012-06-25</td>
					<td>����</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="��  ҳ" onclick="location.href='ReportAuditDeal.jsp'"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="β  ҳ"></td>
			</tr>
		</table>		
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="������Լ��ѯ" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="�ʻ���ѯ" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="����Ѳ�ѯ" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="��  ��" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
