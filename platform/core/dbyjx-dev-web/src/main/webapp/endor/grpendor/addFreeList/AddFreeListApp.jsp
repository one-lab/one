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
    
    <title>����������������</title>
    
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     �������ѯ����</td>
			</tr>
			<tr> 
				<td class="left">Ͷ�����ţ�</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">���屣���ţ�</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">���˱����ţ�</td>
				<td  class="right"><input name="RepApplyNo" class="common" type="text"></td>
			</tr>
			<tr> 
				<td  class="left">��֤�ţ�</td>
				<td  class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
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
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">���</td>
					<td width="15%">Ͷ������</td>
					<td width="15%">���屣����</td>
					<td width="14%">���˱�����</td>
					<td width="8%">����������</td>
					<td width="8%">�ܱ���</td>	
					<td width="8%">�ܱ���</td>	
					<td width="8%">��Ч����</td>
					<td width="8%">�㼶</td>	
					<td width="8%">�б�����</td>												
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>SE86012012005</td>
					<td>P5646860101</td>
					<td>43123132155767</td>
					<td>11</td>
					<td>100000</td>
					<td>5000</td>
					<td>2012-05-18</td>
					<td>Ա��</td>
					<td>20</td>					
				</tr>					
			</tbody>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="������" onclick="location.href='./AddFreeListInput.jsp'">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
