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
    
    <title>��ȫ��Ŀ��ϸ</title>
    
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
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>
				<td class="left">�����ţ�</td>
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">    ��������Ϣ</td>
			</tr>
			<tr>
				<td class="left">VIP�ͻ���</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>			
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">�ͻ��ڲ����룺</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>		
				<td class="left">���һ�������˹�ϵ��</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>
				<td class="left">��Ͷ���˹�ϵ��</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>
			</tr>
			<tr>
				<td class="left">������</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">�Ա�</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>
				<td class="left">����״����</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>
			</tr>
			<tr>
				<td class="left">�������ڣ�</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">���������䣺</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">ְҵ���룺</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>
			</tr>
			<tr>
				<td class="left">֤�����ͣ�</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>		
				<td class="left">֤�����룺</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">������</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
			</tr>
			<tr>
				<td class="left">�������ͣ�</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>			
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td colspan="6">    ��ϵ��ַ��</td>
			</tr>
			<tr>
				<td class="left">ʡ��</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>		
				<td class="left">�У�</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>
				<td class="left">��/�أ�</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>
			</tr>
			<tr>
				<td class="left">�ֵ���</td>
				<td class="right" colspan="3"><input name="AdressNo" class="common" type="text" ></td>
				<td class="left">�������룺</td>
				<td class="right"><input name="ZipCode" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">�ƶ��绰��</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">�칫�绰��</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">����绰��</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
			</tr>
			<tr>
				<td class="left">סլ�绰��</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">������λ��</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">�������䣺</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
			</tr>
			<tr>
				<td class="left">����֤�ţ�</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">��ᱣ�Ϻţ�</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">��˾ʱ�䣺</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
			</tr>
			<tr>
				<td class="left">��н��</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">���������</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>																			
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">    �������˸��ĺ����Ϣ</td>
			</tr>
			<tr>
				<td class="left">������</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>		
				<td class="left">����״����</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
				<td class="left">�������ͣ�</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
			</tr>
			<tr>
				<td colspan="6">    ��ϵ��ַ��</td>
			</tr>
			<tr>
				<td class="left">ʡ��</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>		
				<td class="left">�У�</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
				<td class="left">��/�أ�</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
			</tr>
			<tr>
				<td class="left">�ֵ���</td>
				<td class="right" colspan="3"><input name="AdressNo" class="common" type="text" ></td>
				<td class="left">�������룺</td>
				<td class="right"><input name="ZipCode" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">�ƶ��绰��</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				<td class="left">�칫�绰��</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				<td class="left">����绰��</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">סլ�绰��</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				<td class="left">������λ��</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				<td class="left">�������䣺</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
			</tr>						
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="��  ��" onclick="">
					<input type = "button" class="cssbutton" name="Confirm" value="��  ��" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>							
	</div>
	</form>
  </body>
</html>
