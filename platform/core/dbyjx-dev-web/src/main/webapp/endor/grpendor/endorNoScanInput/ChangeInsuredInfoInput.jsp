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
    
    <title>�������˻�����Ϣ���</title>
    
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
				<td class="left">��ȫ����ţ�</td>
				<td class="right"><input name="EndorAcceptNo" class="common" type="text" readonly></td>
				<td class="left">�������ͣ�</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%" readonly></td>
				<td class="left">���屣���ţ�</td>
				<td class="right"><input name="EndorApplyNo" class="common" type="text" readonly></td>
			</tr>
			<tr> 
				<td class="left">�������ڣ�</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">��Ч���ڣ�</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ���屻��������Ϣ</td>
			</tr>
			<tr>
				<td class="left">���˱����ţ�</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>			
				<td class="left">֤�����ͣ�</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
				<td class="left">���˱����ţ�</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>				
			</tr>
			<tr>
				<td class="left">�ͻ�������</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>			
				<td class="left">�ͻ��Ա�</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
				<td class="left">�������ڣ�</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" style="width: 73%" value='2012-04-28'>
				</td>
			</tr>			
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="��  ѯ" onclick="">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     �ҵ�����</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">���</td>
					<td width="15%">������</td>
					<td width="13%">����</td>
					<td width="13%">�Ա�</td>
					<td width="13%">��������</td>
					<td width="13%">֤������</td>
					<td width="13%">֤������</td>
					<td width="13%">����״̬</td>						
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="checkBox" value="" /></td>
					<td>1</td>
					<td>3424386012012005</td>
					<td>���</td>
					<td>��</td>
					<td>���֤</td>
					<td>111111111111111</td>
					<td>2012-05-18</td>
					<td>δ���</td>
				</tr>
			</tbody>
		</table>
		<br>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="��ӱ�����" onclick="">
				</td>
			</tr>
		</table>
		<br>
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ���˱�ȫ��Ŀ��Ϣ</td>
			</tr>		
			<tr> 
				<td class="left">֤�����ͣ�</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
				<td class="left">֤�����룺</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
				<td class="left">���˱����ţ�</td>
				<td class="right"><input name="EndorApplyNo" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">�ͻ�������</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>			
				<td class="left">�ͻ��Ա�</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
				<td class="left">�������ڣ�</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" style="width: 73%" value='2012-04-28'>
				</td>
			</tr>			
		</table>
		<br>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="��  ѯ" onclick="">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">���</td>
					<td width="15%">������</td>
					<td width="11%">�ͻ���</td>
					<td width="11%">����</td>
					<td width="11%">�Ա�</td>
					<td width="11%">��������</td>
					<td width="11%">֤������</td>
					<td width="11%">֤������</td>
					<td width="11%">����״̬</td>						
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="checkBox" value="" /></td>
					<td>1</td>
					<td>3424386012012005</td>
					<td>0000012005</td>
					<td>���</td>
					<td>��</td>
					<td>���֤</td>
					<td>111111111111111</td>
					<td>2012-05-18</td>
					<td>δ���</td>
				</tr>
			</tbody>
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="��ȫ��Ŀ��ϸ" onclick="location.href='./EndorItemDetailInput.jsp'">
					<input type = "button" class="cssbutton" name="Confirm" value="����������" onclick="">
				</td>
			</tr>
		</table>
		<br>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="¼�����" onclick="">
					<input type = "button" class="cssbutton" name="Confirm" value="��  ��" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>					
	</div>
	</form>
  </body>
</html>
