<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ҵ��Ա��ѯ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="common/js/SimpleCalendar.js"></script>

  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="ReportComAppInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     ҵ��Ա��ѯ����</td>
			</tr>
			<tr> 
				<td class="left">ҵ��Ա���룺</td>
				<td class="right"><input name="AgentCode" class="common" type="text"></td>
				<td class="left">���ۻ�����</td>
				<td class="right"><input name="SaleManagecom" class="common" type="text"></td>
				<td class="left">���������</td>
				<td class="right"><input name="Managecom" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">������</td>
				<td class="right"><input name="name" class="common" type="text"></td>
				<td class="left">�Ա�</td>
				<td class="right"><input name="Sex" class="common" type="text"></td>
				<td class="left">���֤�ţ�</td>
				<td class="right"><input name="IDNo" class="common" type="text"></td>				
			</tr>
		</table>
		<table id="QueryApplyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="QueryButton" value="��  ѯ" onclick="">
					<input type = "button" class="cssbutton" name="ReturnBack" value="��  ��" onclick="javascript:history.go(-1);">						
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     ҵ��Ա���</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">���</td>
					<td width="11%">ҵ��Ա����</td>
					<td width="11%">���ۻ���</td>
					<td width="15%">�������</td>
					<td width="11%">����</td>
					<td width="11%">���֤��</td>
					<td width="11%">״̬</td>
					<td width="11%">�绰</td>
					<td width="11%">�ֻ�</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>S86012012005</td>
					<td>860101</td>
					<td>��������չ�˾</td>
					<td>�ڿ���</td>
					<td>����</td>
					<td>���ͨ��</td>
					<td>δ����</td>
					<td>2012-01-01</td>
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
	</div>
	</form>
  </body>
</html>
