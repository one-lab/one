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
		<table id="FeeInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="2"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">��������</td>
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
		<table id="ServiceAffixInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">���ﵥ֤¼����Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="17%">ҽԺ����</td>
					<td width="10%">ҽԺ�ȼ�</td>
					<td width="10%">��ʼ����</td>
					<td width="10%">��������</td>
					<td width="10%">����</td>
					<td width="10%">��������</td>
					<td width="17%">���ý��</td>
					<td width="10%">�����־</td>
				</tr>
		    </thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "HidButton" value="��  ��" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<table id="ServiceAffixInfo" class="common" cellpadding="3" cellspacing="1">
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
			</tr>
			<tr>
				<td class="left">������</td>
				<td class="right"><input name="BillNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">���������¹ʷ���������</td>
				<td  class="right"><input name="AccidDays" class="common" type="text" onchange="clickable()"></td>
				<td class="left">�����������������</td>
				<td class="right"><input name="AppntDays" class="common" type="text" onchange="clickable()"></td>
			</tr>
		</table>
		<hr />
		<table id="HosAffixInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">סԺ��֤¼����Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="17%">ҽԺ����</td>
					<td width="10%">ҽԺ�ȼ�</td>
					<td width="10%">��ʼ����</td>
					<td width="10%">��������</td>
					<td width="10%">����</td>
					<td width="10%">��������</td>
					<td width="17%">���ý��</td>
					<td width="10%">�����־</td>
				</tr>
		    </thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "HidButton" value="��  ��" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<table id="HosAffixInfo" class="common" cellpadding="3" cellspacing="1">
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
				<td class="left">��ʼ���ڣ�</td>
				<td class="right">
					<input name="StartDate2" id="StartDate2" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'StartDate2',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">�������ڣ�</td>
				<td class="right">
					<input name="EndDate2" id="EndDate2" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'EndDate2',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">ʵ��סԺ������</td>
				<td class="right"><input name="BillNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">���������¹ʷ���������</td>
				<td  class="right"><input name="AccidDays" class="common" type="text" onchange="clickable()"></td>
				<td class="left">�����������������</td>
				<td class="right"><input name="AppntDays" class="common" type="text" onchange="clickable()"></td>
			</tr>
		</table>
		<hr />
		<table id="DisableInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�˲�¼����Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="15%">�м�����</td>
					<td width="17%">�˲м�������</td>
					<td width="15%">�˲д���</td>
					<td width="10%">�м���������</td>
					<td width="10%">�����������</td>
					<td width="12%">������������</td>
					<td width="15%">����ʱ��</td>
				</tr>
		    </thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "HidButton" value="��  ��" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<table id="DisableInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">�м����ͣ�</td>
				<td class="right">
					<input class="codecode" id="injuryTypeCode" name="lcReport.injuryTypeCode" class="common" type="text" value="" style="width:20%"><input name="injuryType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">�˲м���</td>
				<td  class="right">
					<input class="codecode" id="injuryGradeCode" name="lcReport.injuryGradeCode" class="common" type="text" value="" style="width:20%"><input name="injuryGrade" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
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
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'AppraDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
		</table>
		<hr />
		<table id="SpeciInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�ض����������ּ������ض�������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="15%">����</td>
					<td width="15%">����</td>
					<td width="17%">����</td>
					<td width="15%">���</td>
					<td width="17%">ҽ�ƻ�������</td>
					<td width="15%">ȷ������</td>
				</tr>
		    </thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "HidButton" value="��  ��" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<table id="SpeciInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">���ͣ�</td>
				<td class="right">
					<input class="codecode" id="typeCode" name="lcReport.typeCode" class="common" type="text" value="" style="width:20%"><input name="type" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">���룺</td>
				<td  class="right">
					<input class="codecode" id="Code" name="lcReport.Code" class="common" type="text" value="" style="width:20%"><input name="Code" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">��</td>
				<td  class="right"><input name="Mount" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">ҽ�ƻ������ƣ�</td>
				<td class="right"><input name="HosName" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">ȷ�����ڣ�</td>
				<td class="right">
					<input name="DiagnDate" id="DiagnDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'DiagnDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="SpeciFeeList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">���ַ���</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="10%">��������</td>
					<td width="10%">���ַ��ô���</td>
					<td width="17%">���ַ�������</td>
					<td width="10%">���ַ��ý��</td>
					<td width="17%">�����������</td>
					<td width="15%">��ʼ����</td>
					<td width="15%">��������</td>
				</tr>
		    </thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "HidButton" value="��  ��" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<table id="SpeciFeeInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">�������ͣ�</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">���ַ��ô��룺</td>
				<td  class="right">
					<input class="codecode" id="speciFeeCode" name="lcReport.speciFeeCode" class="common" type="text" value="" style="width:20%"><input name="speciFee" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">���ַ��ý�</td>
				<td  class="right"><input name="SubsidyGrade" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">����������ƣ�</td>
				<td  class="right"><input name="MedicalName" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">��ʼ���ڣ�</td>
				<td class="right">
					<input name="StartDate3" id="StartDate3" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'StartDate3',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">�������ڣ�</td>
				<td class="right">
					<input name="EndDate3" id="EndDate3" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'EndDate3',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
		</table>
		<hr />
		<table id="ThirdFeeList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�籣����������</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="18%">��������</td>
					<td width="18%">���ô���</td>
					<td width="20%">��������</td>
					<td width="18%">���ý��</td>
					<td width="20%">�����������</td>
				</tr>
		    </thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "HidButton" value="��  ��" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<table id="ThirdFeeInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">�������ͣ�</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">���ô��룺</td>
				<td  class="right">
					<input class="codecode" id="FeeCode" name="lcReport.FeeCode" class="common" type="text" value="" style="width:20%"><input name="Fee" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
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