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
    
    <title>��ȫ����¼��</title>
    
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
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">������룺</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">�������ͣ�</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>				
			</tr>
			<tr> 
				<td class="left">�����ˣ�</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">���뷽ʽ��</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">���������</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>				
			</tr>			
			<tr> 
				<td class="left">��/�˷ѽ�</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">��/�˷���Ϣ��</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     Ͷ������Ŀ��Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">���</td>
					<td width="15%">����������</td>
					<td width="11%">��������</td>
					<td width="11%">���屣����</td>
					<td width="11%">��Ч����</td>
					<td width="11%">���˷ѽ��ϼ�</td>	
					<td width="11%">���˷���Ϣ</td>	
					<td width="11%">����״̬</td>
					<td width="11%">�˱�״̬</td>							
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>SE8601221012005</td>
					<td>IC-��������Ҫ���ϱ�� </td>
					<td>5674732432432</td>
					<td>2012-05-18</td>
					<td>-59</td>
					<td>0</td>
					<td>����ȷ��</td>
					<td>�Ժ�δͨ��</td>
				</tr>					
				</tr>
			</tbody>
		</table>
		<table id="endorItemInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ��ȫ���볷��</td>
			</tr>
			<tr> 
				<td class="left">����ԭ��</td>
				<td class="right">
					<input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" >
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td colspan="6" >��ϸ���</td>
			</tr>
			<tr>
				<td colspan="4" ><textarea id="specNoName"  name="lcGrpContReport.specNoName" cols="" rows="4"></textarea></td>
			</tr>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="��ȫ����" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="��  ��" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>					
	</div>
	</form>
  </body>
</html>
