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
    
    <title>��ȫ����</title>
    
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
				<td class="right"><input name="EndorAcceptNo" class="common" type="text"></td>
				<td class="left">�������ͣ�</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%"></td>
				<td class="left">���屣���ţ�</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">�������ڣ�</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">��Ч����</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="common"></td>
				<td class="common"></td>		
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ����������</td>
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
					<td width="13%">����</td>				
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>aaa</td>
					<td>aaa</td>
					<td>aaa</td>
					<td>aaa</td>
					<td>aaa</td>
					<td>aaa</td>
					<td>aaa</td>
				</tr>
			</tbody>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="ɾ��������" onclick="">
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="¼�����" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="��  ��" onclick="javascript:history.go(-1);">
					<input type = "button" class="cssbutton" name="EndorAccept" value="�����嵥����" onclick="location.href='./EndorInsuredListImport.jsp'">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ���˷Ѻϼ�</td>
			</tr>
			<tr>
				<td class="left">���˷ѽ��ϼƣ�</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>				
			</tr>			
		</table>
	</div>
	</form>
  </body>
</html>
