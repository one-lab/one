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
    
	    <title>ҽ�Ƶ�֤¼��</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>
		<script type="text/javascript">
		function showAllPage()
		{
			tt = document.getElementById("AffixInfo");
			tt.style.display="block";
		}
		function hidAllPage()
		{
			alter("test")
			tt = document.getElementById("AffixInfo");
			tt.style.display="none";
		}
		function showPage()
		{
			tt = document.getElementByName("AddButton");
			tt.style.display="block";
		}
		function hidPage()
		{
			tt = document.getElementById("HidButton");
			tt.style.display="none";
		}
		</script>

	</head>
<body>
	<form name="fm" method="post" onkeypress="KeyDown()">
	<div style="width:100%">
		<table id="QueryCondition" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�������ѯ����</td>
			</tr>
			<tr>
				<td  class="left">�������ͣ�</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
	</div>
	<div style="width:100%" id="AffixInfo" style="display:none">
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">���ﵥ֤¼����Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="15%">ҽԺ����</td>
					<td width="9%">ҽԺ�ȼ�</td>
					<td width="10%">��ʼ����</td>
					<td width="10%">��������</td>
					<td width="10%">����</td>
					<td width="10%">��������</td>
					<td width="15%">���ý��</td>
					<td width="15%">�Ը����</td>
				</tr>
		    </thead>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">�����ܼƣ�</td>
				<td class="right"><input name="FeeTotal" class="common" type="text" onchange="clickable()"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="FeeBillInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">�˵��ţ�</td>
				<td class="right"><input name="BillNum" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">ҽԺ���ƣ�</td>
				<td class="right">
					<input class="codecode" id="hosCode" name="lcReport.hosCode" class="common" type="text" value="" style="width:20%"><input name="hosName" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">�������ͣ�</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">���ý�</td>
				<td class="right"><input name="FeeMount" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�Ը���</td>
				<td  class="right"><input name="MountSelf" class="common" type="text" onchange="clickable()"></td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
			<tr>
				<td class="left">��ʼ���ڣ�</td>
				<td class="right">
					<input name="StartDate1" id="StartDate1" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'StartDate1',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">�������ڣ�</td>
				<td class="right">
					<input name="EndDate1" id="EndDate1" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'EndDate1',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="��  ��" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "DelButton" value="ɾ  ��" onClick="" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="��  ��" onClick="" />
					<input type="button" class="cssbutton" name = "HidButton" value="��  ��" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">סԺ��֤¼����Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="15%">ҽԺ����</td>
					<td width="10%">ҽԺ�ȼ�</td>
					<td width="10%">��ʼ����</td>
					<td width="10%">��������</td>
					<td width="10%">����</td>
					<td width="9%">��������</td>
					<td width="15%">���ý��</td>
					<td width="15%">�Ը����</td>
				</tr>
		    </thead>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">�����ܼƣ�</td>
				<td class="right"><input name="FeeTotal" class="common" type="text" onchange="clickable()"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="FeeBillInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">�˵��ţ�</td>
				<td class="right"><input name="BillNum" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">ҽԺ���ƣ�</td>
				<td class="right">
					<input class="codecode" id="hosCode" name="lcReport.hosCode" class="common" type="text" value="" style="width:20%"><input name="hosName" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">�������ͣ�</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">���ý�</td>
				<td class="right"><input name="FeeMount" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�Ը���</td>
				<td  class="right"><input name="MountSelf" class="common" type="text" onchange="clickable()"></td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
			<tr>
				<td class="left">��ʼ���ڣ�</td>
				<td class="right">
					<input name="StartDate1" id="StartDate1" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'StartDate1',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">�������ڣ�</td>
				<td class="right">
					<input name="EndDate1" id="EndDate1" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'EndDate1',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="��  ��" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "DelButton" value="ɾ  ��" onClick="" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="��  ��" onClick="" />
					<input type="button" class="cssbutton" name = "HidButton" value="��  ��" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�˲�¼����Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="15%">�м�����</td>
					<td width="15%">�˲м�������</td>
					<td width="14%">�˲д���</td>
					<td width="10%">�м���������</td>
					<td width="10%">�����������</td>
					<td width="15%">������������</td>
					<td width="15%">����ʱ��</td>
				</tr>
		    </thead>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">�м����ͣ�</td>
				<td class="right">
					<input class="codecode" id="injuryCode" name="lcReport.injuryCode" class="common" type="text" value="" style="width:20%"><input name="injuryType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">�˲м���</td>
				<td  class="right">
					<input class="codecode" id="injuryCode" name="lcReport.injuryCode" class="common" type="text" value="" style="width:20%"><input name="injuryGrade" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">�˲д��룺</td>
				<td class="right">
					<input class="codecode" id="injuryCode" name="lcReport.injuryCode" class="common" type="text" value="" style="width:20%"><input name="injuryCode" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">�м�����������</td>
				<td class="right"><input name="InjuryGetRate" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">����������</td>
				<td  class="right"><input name="AppraCom" class="common" type="text" onchange="clickable()"></td>
				<td class="left">�������ڣ�</td>
				<td class="right">
					<input name="AppraDate" id="AppraDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'AppraDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="��  ��" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "DelButton" value="ɾ  ��" onClick="" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="��  ��" onClick="" />
					<input type="button" class="cssbutton" name = "HidButton" value="��  ��" onclick="hidPage()" />
					<input type="button" class="cssbutton" name = "InjuryCodeQuery" value="�˲д����ѯ" onclick="" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">סԺ����¼����Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="20%">ҽԺ����</td>
					<td width="17%">ҽԺ�ȼ�</td>
					<td width="20%">סԺ����</td>
					<td width="20%">��Ժ����</td>
					<td width="17%">סԺ����</td>
				</tr>
		    </thead>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">ҽԺ���ƣ�</td>
				<td class="right">
					<input class="codecode" id="hosCode" name="lcReport.hosCode" class="common" type="text" value="" style="width:20%"><input name="hosName" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">סԺ���ͣ�</td>
				<td  class="right">
					<input class="codecode" id="inHosCode" name="lcReport.inHosCode" class="common" type="text" value="" style="width:20%"><input name="inHosType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
			<tr>
				<td class="left">סԺ���ڣ�</td>
				<td class="right">
					<input name="InHosDate" id="InHosDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'InHosDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">��Ժ���ڣ�</td>
				<td class="right">
					<input name="OutHosDate" id="OutHosDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'OutHosDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">סԺ������</td>
				<td class="right"><input name="InHosDay" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="��  ��" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "DelButton" value="ɾ  ��" onClick="" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="��  ��" onClick="" />
					<input type="button" class="cssbutton" name = "HidButton" value="��  ��" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">��������¼����Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="10%">��������</td>
					<td width="15%">��������</td>
					<td width="15%">��������</td>
					<td width="10%">�����ȼ�</td>
					<td width="14%">�������</td>
					<td width="15%">ҽ�ƻ�������</td>
					<td width="15%">��������</td>
				</tr>
		    </thead>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">�������ͣ�</td>
				<td  class="right">
					<input class="codecode" id="OpsTypeCode" name="lcReport.OpsTypeCode" class="common" type="text" value="" style="width:20%"><input name="OpsType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">�������룺</td>
				<td  class="right">
					<input class="codecode" id="OpsCode" name="lcReport.OpsCode" class="common" type="text" value="" style="width:20%"><input name="OpsCode" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">�����ȼ���</td>
				<td  class="right"><input name="SubsidyGrade" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">ҽ�ƻ������ƣ�</td>
				<td  class="right"><input name="MedicalName" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">�������ڣ�</td>
				<td class="right">
					<input name="OpsDate" id="OpsDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'OpsDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="��  ��" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "DelButton" value="ɾ  ��" onClick="" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="��  ��" onClick="" />
					<input type="button" class="cssbutton" name = "HidButton" value="��  ��" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�籣�������</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="20%">��������</td>
					<td width="17%">���ô���</td>
					<td width="20%">��������</td>
					<td width="17%">���ý��</td>
					<td width="20%">�����������</td>
				</tr>
		    </thead>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">�������ͣ�</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">���ñ��룺</td>
				<td  class="right">
					<input class="codecode" id="feeCode" name="lcReport.feeCode" class="common" type="text" value="" style="width:20%"><input name="feeCode" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">���ý�</td>
				<td  class="right"><input name="FeeMount" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">����������ƣ�</td>
				<td  class="right"><input name="ServiceName" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td >��ע</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="AccidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="��  ��" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "DelButton" value="ɾ  ��" onClick="" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="��  ��" onClick="" />
					<input type="button" class="cssbutton" name = "HidButton" value="��  ��" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">������������</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="17%">��������</td>
					<td width="17%">��������</td>
					<td width="20%">��������</td>
					<td width="20%">ҽ�ƻ�������</td>
					<td width="20%">��������</td>
				</tr>
		    </thead>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">�������ͣ�</td>
				<td  class="right">
					<input class="codecode" id="OpsTypeCode" name="lcReport.OpsTypeCode" class="common" type="text" value="" style="width:20%"><input name="OpsType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">�������룺</td>
				<td  class="right">
					<input class="codecode" id="OpsCode" name="lcReport.OpsCode" class="common" type="text" value="" style="width:20%"><input name="OpsCode" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td  class="left">����������ƣ�</td>
				<td  class="right"><input name="ServiceName" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">�������ڣ�</td>
				<td class="right">
					<input name="OpsDate2" id="OpsDate2" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'OpsDate2',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="��  ��" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "DelButton" value="ɾ  ��" onClick="" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="��  ��" onClick="" />
					<input type="button" class="cssbutton" name = "HidButton" value="��  ��" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">��������</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="20%">��������</td>
					<td width="17%">���ô���</td>
					<td width="20%">��������</td>
					<td width="17%">���ý��</td>
					<td width="20%">�����������</td>
				</tr>
		    </thead>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">�������ͣ�</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">���ñ��룺</td>
				<td  class="right">
					<input class="codecode" id="feeCode" name="lcReport.feeCode" class="common" type="text" value="" style="width:20%"><input name="feeCode" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">���ý�</td>
				<td  class="right"><input name="FeeMount" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">����������ƣ�</td>
				<td  class="right"><input name="ServiceName" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td >��ע</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="AccidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="��  ��" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "DelButton" value="ɾ  ��" onClick="" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="��  ��" onClick="" />
					<input type="button" class="cssbutton" name = "HidButton" value="��  ��" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<hr />
	</div>
	<div style="width:100%">
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AppButton" value="�鿴ȫ��" onClick="showAllPage()" />
					<input type="button" class="cssbutton" name = "AppButton" value="����ȫ��" onClick="HidAllPage()" />
					<input type="button" class="cssbutton" name = "AppButton" value="��  ��" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>