<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>����������ѯ</title>
    
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
		<hr>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     ����������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">���</td>
					<td width="25%">Ͷ������</td>
					<td width="20%">����Ա</td>
					<td width="20%">������ʼ����</td>
					<td width="20%">������������</td>
					<td width="20%">������״̬</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>G86012012005</td>
					<td>��ϯ�˱�ʦ</td>
					<td>2012-05-18</td>
					<td>2012-05-18</td>
					<td>�ŵ��Զ��˱�</td>
				</tr>
			</tbody>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>G86012012005</td>
					<td>��ϯ�˱�ʦ</td>
					<td>2012-04-21</td>
					<td>2012-04-21</td>
					<td>�ŵ��Զ��˱�</td>
				</tr>
			</tbody>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>G86012012005</td>
					<td>��ϯ�˱�ʦ</td>
					<td>2012-04-15</td>
					<td>2012-04-15</td>
					<td>�ŵ��Զ��˱�</td>
				</tr>
			</tbody>						
		</table>
		<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="��  ҳ" onclick=""></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="β  ҳ"></td>
			</tr>
		</table>		
		<hr>
		<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type="button" class="cssbutton" name="ReturnBack" value="��  ��" onclick="javascript:history.go(-1);"></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
