<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�ʱ������ظ�</title>
    
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
		Ӱ��ͼƬ��Ϣ
		<hr>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     ������Ŀ</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">���</td>
					<td width="31%">������Ŀ���</td>
					<td width="31%">������Ŀ����</td>
					<td width="33%">��ע</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>˫��������ѡ��</td>
					<td>Ͷ������</td>
					<td>12</td>
				</tr>
			</tbody>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">��������</td>
				<td class="right"><input type="text" class="common" name="text"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td colspan="6" >����������Ŀ</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5" witdh=100%></textarea></td>
			</tr>
			<tr>
				<td colspan="6" >��������</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5" witdh=100%></textarea></td>
			</tr>			
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="ApplyButton" value="���ظ���" onclick="">
				</td>
			</tr>		
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="ApplyButton" value="�����������" onclick="">
					<input type = "button" class="cssbutton" name="ApplyButton" value="��  ��" onclick="javascript:history.go(-1)">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
