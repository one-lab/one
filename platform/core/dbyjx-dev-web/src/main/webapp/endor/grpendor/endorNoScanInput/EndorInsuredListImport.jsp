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
    
    <title>���뱻�����嵥</title>
    
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     �����嵥����</td>
			</tr>
			<tr>
				<td class="left">�ϴ��ļ���</td>
				<td class="right">
					<input name="ApplyType" class="common" type="text"  style="width:68%"><input name="comName" class="cssbutton" type="button" value="�  ��..." style="width:25%">
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
					<input type = "button" class="cssbutton" name="QueryButton" value="��  ��" onclick="">
					<input type = "button" class="cssbutton" name="ApplyButton" value="��  ��" onclick="javascript:history.go(-1)">
				</td>
			</tr>
		</table>
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ������־��ѯ</td>
			</tr>
			<tr> 
				<td class="left">��ȫ����ţ�</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">�������κţ�</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">���屣���ţ�</td>
				<td class="right"><input name="State" class="common" type="text" value="���" readonly></td>
			</tr>
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="QueryButton" value="��  ѯ" onclick="">
				</td>
			</tr>
		</table>				
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     �����嵥�����¼</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">���</td>
					<td width="15%">���屣����</td>
					<td width="15%">��ȫ�����</td>
					<td width="17%">������Ϣ</td>
					<td width="15%">����Ա</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>P860234342205</td>
					<td>SDF3213342205</td>
					<td>����չ�˾�����ֹ�˾</td>
					<td>��ȫ��</td>
				</tr>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>2</td>
					<td>P860234342205</td>
					<td>SDF3213342205</td>
					<td>����չ�˾�����ֹ�˾</td>
					<td>��ȫ��</td>
				</tr>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>3</td>
					<td>P860234342205</td>
					<td>SDF3213342205</td>
					<td>����չ�˾�����ֹ�˾</td>
					<td>��ȫ��</td>
				</tr>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>4</td>
					<td>P860234342205</td>
					<td>SDF3213342205</td>
					<td>����չ�˾�����ֹ�˾</td>
					<td>��ȫ��</td>
				</tr>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>5</td>
					<td>P860234342205</td>
					<td>SDF3213342205</td>
					<td>����չ�˾�����ֹ�˾</td>
					<td>��ȫ��</td>
				</tr>																
			</tbody>
		</table>
		<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="��  ҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="β  ҳ"></td>
			</tr>
		</table>		
	</div>
	</form>
  </body>
</html>
