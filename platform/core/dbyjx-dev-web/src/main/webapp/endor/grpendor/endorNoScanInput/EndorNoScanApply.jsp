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
    
    <title>��ȫ��ɨ������</title>
    
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     �������ѯ����</td>
			</tr>
			<tr> 
				<td class="left">��ȫ����ţ�</td>
				<td class="right"><input name="EndorAcceptNo" class="common" type="text"></td>
				<td class="left">���屣���ţ�</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				<td class="left">Ͷ����λ���ƣ�</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">���뷽ʽ��</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%">
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>		
			</tr>
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="QueryButton" value="��  ѯ" onclick="">
					<input type = "button" class="cssbutton" name="ApplyButton" value="��  ��" onclick="location.href='./EndorNoScanInput.jsp'">
				</td>
			</tr>
		</table>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     �ҵ�����</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">���</td>
					<td width="15%">��ȫ�����</td>
					<td width="15%">���屣����</td>
					<td width="17%">Ͷ����λ</td>
					<td width="15%">��ȫ��Ŀ</td>
					<td width="15%">¼����Ա</td>
					<td width="15%">��ȫ¼������</td>					
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td><a href="javascript:void(0)" onclick="location.href='./EndorNoScanInput.jsp'">SE86012012005</a></td>
					<td>G860234342205</td>
					<td>����չ�˾�����ֹ�˾</td>
					<td>��ȫ����</td>
					<td>���</td>
					<td>2012-05-18</td>
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
					<input type = "button" class="cssbutton" name="EndorAccept" value="��ȫ����" onclick="location.href='./EndorNoScanInput.jsp'">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
