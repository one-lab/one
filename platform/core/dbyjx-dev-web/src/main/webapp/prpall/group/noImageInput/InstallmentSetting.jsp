<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>���ڸ�������</title>
    
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
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     ���ڸ�������</td>
			</tr>
			<tr> 
				<td class="left">�ɷѷ�ʽ��</td>
				<td class="right"><input name="ManageCom" class="common" type="text"></td>
				<td class="left">�ڴΣ�</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"><img src="images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td class="left">���ѣ�</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left"></td>
				<td class="right"></td>				
			</tr>
		</table>
				<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     �����ڽɷ�����</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">���</td>
					<td width="24%">Ӧ�ɷ�����</td>
					<td width="24%">�ɷѽ��</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>2012-12-01</td>
					<td>100</td>
				</tr>
			</tbody>
		</table>
		<br>
		<hr>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="ApplyButton" value="����/�޸�" onclick="">
					<input type = "button" class="cssbutton" name="ApplyButton" value="��  ��" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
		<br><br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     ���ڸ������ò�ѯ</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">���</td>
					<td width="24%">���屣����</td>
					<td width="24%">�ڴ�</td>
					<td width="24%">�ɷ�����</td>
					<td width="23%">���</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>G86012012005</td>
					<td>1</td>
					<td>2012-05-18</td>
					<td>50000</td>
				</tr>
			</tbody>
		</table>
	</div>
	</form>
  </body>
</html>
