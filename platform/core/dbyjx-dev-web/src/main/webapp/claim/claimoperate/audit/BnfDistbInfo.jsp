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
    
	    <title>�����Ϣ��ѯ</title>
	    
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
	<div style="width:100%">
		<table id="ClaimAppnt" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�ⰸ������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="22%">�ⰸ��</td>
					<td width="22%">������</td>
					<td width="20%">�⸶���</td>
					<td width="30%">�������</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>64131641212</td>
					<td>463164013</td>
					<td>2000</td>
					<td>�ѷ���</td>
				</tr>
			</tbody>
		</table>
		<table id="ClaimAppntInfo" class="common" cellpadding="1" cellspacing="1" >
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�ⰸ������ϸ��Ϣ</td>
			</tr>
			<tr>
				<td  class="left">�ⰸ�ţ�</td>
				<td  class="right"><input name="ClaimNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�����ţ�</td>
				<td  class="right"><input name="appNo" class="common" type="text" onchange="clickable()"/></td>
				<td  class="left">�⸶��</td>
				<td  class="right"><input name="payMount" class="common" type="text" onchange="clickable()" /></td>
			</tr>
		</table>
		<hr />
		<table id="ClaimBnfList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="12"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">������������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="10%">���������</td>
					<td width="10%">����������</td>
					<td width="10%">���������</td>
					<td width="8%">������</td>
					<td width="6%">�������</td>
					<td width="5%">֧����ʽ</td>
					<td width="15%">�����˻���</td>
					<td width="10%">ʵ����ȡ������</td>
					<td width="12%">ʵ����ȡ����ϵ��ʽ</td>
					<td width="6%">�����˼���</td>
				</tr>
			</thead>
		</table>
		<table id="ClaimResult" class="common" cellpadding="1" cellspacing="1" >
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�ⰸ������ϸ��Ϣ</td>
			</tr>
			<tr>
				<td  class="left">�������뱻���˹�ϵ��</td>
				<td  class="right">
					<input class="codecode" id="relatshipCode" name="lcReport.relatshipCode" class="common" type="text" value="" style="width:20%" ><input name="relatship" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">������������</td>
				<td  class="right"><input name="bnfName" class="common" type="text" onchange="clickable()"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">�������Ա�</td>
				<td class="right">
					<input class="codecode" id="bnfCode" name="lcReport.bnfCode" class="common" type="text" value="01" style="width:20%" ><input name="bnfSex" class="common" type="text" onchange="clickable()" style="width:68%" value="��"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td  class="left">�����˳������ڣ�</td>
				<td class="right">
					<input name="BnfBirthDate" id="BnfBirthDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'BnfBirthDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td  class="left">������֤�����ͣ�</td>
				<td class="right">
					<input class="codecode" id="bnfIDCode" name="lcReport.bnfIDCode" class="common" type="text" value="01" style="width:20%" ><input name="bnfIDType" class="common" type="text" onchange="clickable()" style="width:68%" value="���֤"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">������֤�����룺</td>
				<td  class="right"><input name="bnfIDNo" class="common" type="text" onchange="clickable()" /><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
		</table>
		<table id="ClaimResult" class="common" cellpadding="1" cellspacing="1" >
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�����������ϸ��Ϣ</td>
			</tr>
			<tr>
				<td  class="left">������������˹�ϵ��</td>
				<td  class="right">
					<input class="codecode" id="relatshipCode" name="lcReport.relatshipCode" class="common" type="text" value="" style="width:20%" ><input name="relatship" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">�����������</td>
				<td  class="right"><input name="recivName" class="common" type="text" onchange="clickable()"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">������Ա�</td>
				<td class="right">
					<input class="codecode" id="recivCode" name="lcReport.recivCode" class="common" type="text" value="01" style="width:20%" ><input name="recivSex" class="common" type="text" onchange="clickable()" style="width:68%" value="��"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td  class="left">����˳������ڣ�</td>
				<td class="right">
					<input name="recivBirthDate" id="recivBirthDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'recivBirthDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td  class="left">�����֤�����ͣ�</td>
				<td class="right">
					<input class="codecode" id="recivIDCode" name="lcReport.recivIDCode" class="common" type="text" value="01" style="width:20%" ><input name="recivIDType" class="common" type="text" onchange="clickable()" style="width:68%" value="���֤"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">�����֤�����룺</td>
				<td  class="right"><input name="recivNo" class="common" type="text" onchange="clickable()" /><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
		</table>
		<table id="ClaimResult" class="common" cellpadding="1" cellspacing="1" >
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">����ʵ���������ϸ��Ϣ</td>
			</tr>
			<tr>
				<td  class="left">ʵ��������������˹�ϵ��</td>
				<td  class="right">
					<input class="codecode" id="relatshipCode" name="lcReport.relatshipCode" class="common" type="text" value="" style="width:20%" ><input name="relatship" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">ʵ�������������</td>
				<td  class="right"><input name="payeeName" class="common" type="text" onchange="clickable()"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">ʵ��������Ա�</td>
				<td class="right">
					<input class="codecode" id="payeeCode" name="lcReport.payeeCode" class="common" type="text" value="01" style="width:20%" ><input name="payeeSex" class="common" type="text" onchange="clickable()" style="width:68%" value="��"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td  class="left">ʵ������˳������ڣ�</td>
				<td class="right">
					<input name="PayeeBirthDate2" id="PayeeBirthDate2" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'PayeeBirthDate2',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td  class="left">ʵ�������֤�����ͣ�</td>
				<td class="right">
					<input class="codecode" id="payeeIDCode" name="lcReport.payeeIDCode" class="common" type="text" value="01" style="width:20%" ><input name="payeeIDType" class="common" type="text" onchange="clickable()" style="width:68%" value="���֤"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">ʵ�������֤�����룺</td>
				<td  class="right"><input name="payeeIDNo" class="common" type="text" onchange="clickable()" /><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td  class="left">ʵ���������ϵ��ʽ��</td>
				<td  class="right"><input name="payeeTel" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<table id="ClaimResult" class="common" cellpadding="1" cellspacing="1" >
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">������ϸ��Ϣ</td>
			</tr>
			<tr>
				<td  class="left">ʣ�������</td>
				<td  class="right"><input name="ClaimResult" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">���������</td>
				<td  class="right"><input name="ClaimResult" class="common" type="text" onchange="clickable()"/></td>
				<td  class="left">�����</td>
				<td  class="right"><input name="ClaimResult" class="common" type="text" onchange="clickable()" /></td>
			</tr>
			<tr>
				<td  class="left">֧����ʽ��</td>
				<td  class="right">
					<input class="codecode" id="payTypeCode" name="lcReport.payTypeCode" class="common" type="text" value="" style="width:20%"><input name="payType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="��  ��" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="��  ��" onClick="" />
					<input type="button" class="cssbutton" name = "DelButton" value="ɾ  ��" onClick="" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "returnButton" value="��  ��" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>

</body>
</html>