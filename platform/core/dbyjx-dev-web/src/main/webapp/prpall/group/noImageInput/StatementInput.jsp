<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ҵ����Ϣ����¼��</title>
    
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
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     Ͷ����λ���</td>
			</tr>
			<tr>
				<td class="left" align="left">���������嵥���Ƿ�����д���ÿһ�������˵ľ��������</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">Ͷ����λ��Ա���������</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
		</table>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     Ͷ����ҵ��Ϣ</td>
			</tr>
			<tr>
				<td class="left">Ͷ�����ʣ�</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">ҵ��Ͷ�����ʣ�</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">������Դ��</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">ͳ��������</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">ҵ����Դ��</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">��ϵ��������</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">��ϵ�ֻ���</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">�Ƿ���Э�飺</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td colspan="6" >ҵ������˵��</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5"></textarea></td>
			</tr>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td  >
					<input type = "button" class="cssbutton" name="ApplyButton" value="����/�޸�" onclick="">
					<input type = "button" class="cssbutton" name="ApplyButton" value="��  ��" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
