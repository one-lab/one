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
    
    <title>������������</title>
    
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     �����ͬ��Ϣ</td>
			</tr>
			<tr> 
				<td class="left">Ͷ�����ţ�</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">�ʱ����ţ�</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">����������</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" ></td>
			</tr>
			<tr> 
				<td  class="left">�н������</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:90%" ></td>
				<td class="left">Ͷ���������ڣ�</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='2012-04-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="left">������Ч���ڣ�</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='2012-04-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
			<tr>
				<td class="left">���������</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" ></td>
				<td class="left">�����շ����ڣ�</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='2012-04-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr>
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr> 
				<td class="left">ҵ��Ա���룺</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:90%" ></td>
				<td class="left">ҵ��Ա������</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">����������</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" ></td>
			</tr>
			<tr> 
				<td class="left">�����ֲ���</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">�Ǽ�ҵ��Ա��</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" ></td>
				<td class="left">��ҵ��Ա���빴ѡ��</td>
				<td class="right"><input type="checkbox" name="checkbox" value="checkbox"></td>
			</tr>
		</table>
		<hr>
		<table id="CompanyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">Ͷ����λ���ϣ��ͻ��ţ�</td>
			</tr>
			<tr>
				<td class="left">��λ���ƣ�</td>
				<td class="right"><input name="GrpName" class="common" type="text" ></td>
				<td class="left">�ʲ��ܶ��Ԫ����</td>
				<td class="right"><input name="Money" class="common" type="text" ></td>				
				<td class="left">��λ���ʣ�</td>
				<td class="right"><input name="CompanyNature" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">��ҵ���</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" ></td>
				<td class="left">Ա��������</td>
				<td class="right"><input name="Money" class="common" type="text" ></td>
				<td class="left">��λ���棺</td>
				<td class="right"><input name="RegistNo" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">�籣�Ǽ�֤�ţ�</td>
				<td class="right"><input name="SocialSecurityNo" class="common" type="text" ></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>			
			</tr>
			<tr>
				<td class="left">��λ��ַ���룺</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:90%" ></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>			
			</tr>
			<tr>
				<td class="left">��λ��ַ��</td>
				<td class="right" colspan="3"><input name="AdressNo" class="common" type="text" ></td>
				<td class="left">�������룺</td>
				<td class="right"><input name="ZipCode" class="common" type="text" ></td>
			</tr>			
			<tr>
				<td class="left">������ϵ��һ</td>
			</tr>
			<tr>
				<td class="left">������</td>
				<td class="right"><input name="Telephone1" class="common" type="text" ></td>
				<td class="left">��ϵ�绰��</td>
				<td class="right"><input name="Department" class="common" type="text" ></td>
				<td class="left">E-MAIL��</td>
				<td class="right"><input name="Department" class="common" type="text" ></td>	
			</tr>
			<tr>
				<td class="left">���ţ�</td>
				<td class="right" colspan="3"><input name="AdressNo" class="common" type="text" ></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
			<tr>
				<td class="left">������ϵ�˶�</td>
			</tr>
			<tr>
				<td class="left">������</td>
				<td class="right"><input name="Telephone1" class="common" type="text" ></td>
				<td class="left">��ϵ�绰��</td>
				<td class="right"><input name="Department" class="common" type="text" ></td>
				<td class="left">E-MAIL��</td>
				<td class="right"><input name="Department" class="common" type="text" ></td>	
			</tr>
			<tr>
				<td class="left">���ţ�</td>
				<td class="right" colspan="3"><input name="AdressNo" class="common" type="text" ></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">���ʽ��</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" ></td>
				<td class="left">�������У�</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" ></td>
				<td class="left">�˺� ��</td>
				<td class="right"><input name="MainInsuredCount" class="common" type="text" ></td>
			</tr>
		</table>
	</div>
	<div style="width:80%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" >��ע</td>
			</tr>
			<tr>
				<td colspan="3"><textarea id="clmHistory"  name="lcRepInfo.clmHistory" cols="100%" rows="5"></textarea></td>
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
					<td width="14%">���ֱ���</td>
					<td width="13%">��������</td>
					<td width="13%">�����ڼ�</td>
					<td width="13%">�α�����</td>
					<td width="13%">����/����ϼ�</td>	
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckBox" type="CheckBox" value="" /></td>
					<td>1</td>
					<td>SE86012012005</td>
					<td>P5646860101</td>
					<td>�»����</td>
					<td>11</td>
					<td>860101</td>
				</tr>
				<tr class="content">
					<td><input name="CheckBox" type="CheckBox" value="" /></td>
					<td>2</td>
					<td>SE86012012005</td>
					<td>P5646860101</td>
					<td>�»����</td>
					<td>11</td>
					<td>860101</td>
				</tr>								
			</tbody>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="������" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="���ռƻ��鿴" onclick="location.href='./AddFreeListInput.jsp'">
				</td>
			</tr>
		</table>
	</div>
	<div style="width:100%">
		<hr>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="95%" align="right"><input type = "button" class="cssbutton" name="EndorAccept" value="�����������ѯ" onclick=""></td>
				<td width="5%" align="left"><input type = "button" class="cssbutton" name="EndorAccept" value="��  ��" onclick="javascript:history.go(-1);"></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
