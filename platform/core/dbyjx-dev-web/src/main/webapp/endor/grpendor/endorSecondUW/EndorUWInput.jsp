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
    
    <title>��ȫ�˹��˱�</title>
    
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ��ȫ������Ϣ</td>
			</tr>
			<tr> 
				<td class="left">��ȫ����ţ�</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">������룺</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">�������ͣ�</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			</tr>
			 <tr>
			 	<td class="left">Ԥ�򱣵���</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">���뷽ʽ��</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">���������</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			 </tr>
			 <tr>
			 	<td class="left">���˷ѽ�</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">���˷���Ϣ��</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="common"></td>
				<td class="common"></td>
			 </tr>			 
		</table>
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ���屣����Ϣ</td>
			</tr>
			<tr> 
				<td class="left">���屣���ţ�</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">����ͻ��ţ�</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">Ͷ����λ��</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>				
			</tr>
			 <tr>
			 	<td class="left">Ͷ��������</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">���������</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">����������</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			 </tr>
			 <tr>
			 	<td class="left">�����˱��룺</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">������������</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">���������</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			 </tr>
			 <tr>
			 	<td class="left">VIP��ǣ�</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>				
			 </tr>			 		 
		</table>		
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ���屣��������Ϣ</td>
			</tr>
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="������ϸ��Ϣ " onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="Ͷ����Ӱ���ѯ" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="Ͷ����λ�ѳб�����" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="Ͷ����λδ�б�����" onclick="">
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="Ͷ����λ������ȫ" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="Ͷ����λ��������" onclick="">
				</td>
			</tr>			
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ���屣��������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">���</td>
					<td width="12%">������</td>
					<td width="10%">��������</td>
					<td width="10%">���ֱ���</td>
					<td width="10%">��������</td>
					<td width="10%">���Ѽ��</td>
					<td width="10%">Ͷ������</td>
					<td width="10%">��������</td>
					<td width="10%">��Ч����</td>	
					<td width="10%">�˱�����</td>				
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>SE86012012005</td>
					<td>IC</td>
					<td>0601</td>
					<td>����סԺ�������彡������</td>
					<td>����</td>
					<td>10</td>
					<td>2012-05-18</td>
					<td>2012-05-18</td>
					<td>10</td>
				</tr>
			</tbody>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ��ȫ�˱����� </td>
			</tr>
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="��ȫӰ���ѯ " onclick="location.href='./EndorScanView.jsp'">
					<input type = "button" class="cssbutton" name="EndorAccept" value="�����Զ��˱���Ϣ" onclick="location.href='./GrpAutoUW.jsp'">
					<input type = "button" class="cssbutton" name="EndorAccept" value="��ȫ��ϸ��ѯ" onclick="location.href='./EndorDetailView.jsp'">
					<input type = "button" class="cssbutton" name="EndorAccept" value="���˺˱���Ϣ" onclick="location.href='./SigleContDetailAutoUW.jsp'">
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="��ȫ�����켣" onclick="location.href='./EndorOperateTraceView.jsp'">
					<input type = "button" class="cssbutton" name="EndorAccept" value="���ַ���Ҫ�ز�ѯ" onclick="location.href='../../../prpall/group/artificalUW/KindRiskInfo.jsp'">
				</td>
			</tr>			
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     �������ֺ˱����� </td>
			</tr>
			<tr>
				<td class="left">�˱����ۣ�</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td colspan="6">�˱���� </td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="UWIdea" cols="100%" rows="5"></textarea></td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="ȷ  �� " onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="��  ��" onclick="">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ��ȫ����˱����� </td>
			</tr>
			<tr>
				<td class="left">�˱����ۣ�</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td colspan="6">�˱���� </td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="UWIdea" cols="100%" rows="5"></textarea></td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="ȷ  �� " onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="��  ��" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="��  ��" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>			
	</div>
	</form>
  </body>
</html>
