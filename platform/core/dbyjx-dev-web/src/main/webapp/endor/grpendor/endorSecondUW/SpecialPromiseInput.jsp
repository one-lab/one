<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��Լ¼��</title>
    
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
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     ����������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">���</td>
					<td width="13%">������</td>
					<td width="12%">������</td>
					<td width="12%">���ֺ�</td>
					<td width="12%">���ֱ���</td>
					<td width="12%">���ְ汾</td>
					<td width="12%">Ͷ����</td>
					<td width="12%">������</td>
					<td width="12%">��������</td>				
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>���</td>
					<td>������</td>
					<td>������</td>
					<td>������</td>
					<td>������</td>
					<td>������</td>
					<td>������</td>
					<td>������</td>					
				</tr>
			</tbody>
		</table>
	</div>
	<div style = "width:70%">
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     ����ԭ����Լ</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">���</td>
					<td width="85%">��Լ����</td>
					<td width="10%">״̬</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     ��ȫ������Լ</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">���</td>
					<td width="82%">��Լ����</td>
					<td width="10%">״̬</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="checkradio" value="" ></td>
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     ��Լ��Ϣģ��</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">���</td>
					<td width="92%">��Լ����</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="checkradio" value="" ></td>
					<td>1</td>
					<td>���պ�ͬ�ĵ�һ��������Ϊ����ͬ�����յı�������</td>
				</tr>
				<tr class="content">
					<td><input type="radio" name="checkradio" value="" ></td>
					<td>2</td>
					<td>����˾���е����������л��Ᵽ�շѵı�������</td>
				</tr>				
			</tbody>
		</table>
		<table id="auditIdeas" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" >��Լԭ��</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="" cols="100%" rows="5"></textarea></td>
			</tr>
		</table>
		<table id="auditIdeas" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" >�ر�Լ��</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="" cols="100%" rows="5"></textarea></td>
			</tr>
		</table>					
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Confirm" value="��  ��" onclick="">
					<input type = "button" class="cssbutton" name="Confirm" value="��  ��" onclick="">
					<input type = "button" class="cssbutton" name="Confirm" value="ɾ  ��" onclick="">
					<input type = "button" class="cssbutton" name="Confirm" value="��  ��" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
