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
    
    <title>������Ϣ¼��</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script language="javascript">
	function showPage(type,spanID)
	{
	  if(type.value!="01"){
	    //��
	  	spanID.style.display="";
	  }
	  else
	  { 
	    //�ر�
	    spanID.style.display="none";
	  }
	}
	</script>

  </head>
  
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div id="registerInfo" style="width:100%">
		<table id="applyInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">����������Ϣ</td>
			</tr>
			<tr>
				<td  class="left">�¼��ţ�</td>
				<td  class="right"><input name="accNO" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�ⰸ�ţ�</td>
				<td  class="right"><input name="clmNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�����˲�ѯ��</td>
				<td  class="right">
					<input type="button" class="cssButton" name="appntQuery" value="�����˲�ѯ" onClick="self.location.href='${ctx}/claim/claimoperate/register/AppntQuery.jsp'" >
				</td>
			</tr>
			<tr>
				<td  class="left">������������˹�ϵ��</td>
				<td  class="right">
					<input class="codecode" id="relatshipCode" name="lcReport.relatshipCode" class="common" type="text" value="" style="width:20%" ><input name="relatship" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">������������</td>
				<td  class="right">
					<input name="RgtantName" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">�����˵绰��</td>
				<td  class="right">
					<input name="RgtantTel" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td  class="left">�����˵�ַ��</td>
				<td  class="right">
					<input name="RgtantAddress" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">������EMail��</td>
				<td  class="right"><input name="RgtantEMail" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td  class="left">���������ͣ�</td>
				<td  class="right">
					<input class="codecode" id="agentCode" name="lcReport.agentCode" class="common" type="text" value="" style="width:20%" ><input name="agentType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">�����˴��룺</td>
				<td  class="right"><input name="agentCode" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">������������</td>
				<td  class="right"><input name="agentName" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">�������Ա�</td>
				<td  class="right">
					<input class="codecode" id="agentCode" name="lcReport.agentCode" class="common" type="text" value="" style="width:20%" ><input name="agentSex" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">�����˵绰��</td>
				<td  class="right"><input name="agentTel" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�����˵�ַ��</td>
				<td  class="right"><input name="agentAddress" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">�������ʱࣺ</td>
				<td  class="right"><input name="agentZip" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�������ڣ�</td>
				<td class="right">
					<input name="RgtDate" id="RgtDate" class="common" type="text" onchange="clickable()" value='' />
				</td>
				<td  class="left">���������ˣ�</td>
				<td  class="right"><input name="RgtAgent" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">��Ͻ������</td>
				<td  class="right">
					<input class="codecode" id="adminComCode" name="lcReport.adminComCode" class="common" type="text" value="" style="width:20%" ><input name="adminCom" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">�������ͣ�</td>
				<td  class="right">
					<input class="codecode" id="applyCode" name="lcReport.applyCode" class="common" type="text" value="" style="width:20%" ><input name="applyType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="AppntList" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�������б�</td>
			</tr>
			<tr>
				<td><jsp:include page="../../commonpage/AppntInfoList.jsp" /></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">��������Ϣ</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="PolQuery" value="������ѯ" onclick="self.location.href='${ctx}/claim/claimoperate/register/PolicyQuery.jsp'" />
					<input type="button" class="cssbutton" name="PastClaimQuery" value="�����ⰸ��ѯ" onclick="self.location.href='${ctx}/claim/claimoperate/register/PastClaimQuery.jsp'" />
					<input type="button" class="cssbutton" name="${ctx}/imageQuery" value="Ӱ���ѯ" onclick="" />
				</td>
			</tr>
		</table>
		<table id="AppntInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">������������</td>
				<td class="right"><input name="appntName" class="common" type="text" onchange="clickable()"></td>
				<td class="left">���������䣺</td>
				<td class="right"><input name="appntAge" class="common" type="text" onchange="clickable()"></td>
				<td class="left">�������Ա�</td>
				<td class="right">
					<input class="codecode" id="appntCode" name="lcReport.appntCode" class="common" type="text" value="01" style="width:20%" ><input name="appntSex" class="common" type="text" onchange="clickable()" style="width:68%" value="��">
				</td>
			</tr>
			<tr>
				<td  class="left">�¹����ڣ�</td>
				<td class="right">
					<input name="accDate" id="accDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'accDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">�������ڣ�</td>
				<td class="right">
					<input name="appntDate" id="appntDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'appntDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">����ԭ��</td>
				<td class="right">
					<input class="codecode" id="appntReasonCode" name="lcReport.appntReasonCode" class="common" type="text" value="" style="width:20%" ><input name="appntReason" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">����ҽԺ��</td>
				<td class="right">
					<input class="codecode" id="treatHospitalCode" name="lcReport.treatHospitalCode" class="common" type="text" value="" style="width:20%" ><input name="treatHospital" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">��ϵ�绰��</td>
				<td class="right">
					<input name="telephone" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">���������</td>
				<td class="right">
					<input class="codecode" id="treatStateCode" name="lcReport.treatStateCode" class="common" type="text" value="" style="width:20%" ><input name="treatState" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td class="left">����ϸ�ڣ�</td>
				<td class="right">
					<input class="codecode" id="unexpectDetailCode" name="lcReport.unexpectDetailCode" class="common" type="text" value="" style="width:20%" ><input name="unexpectDetail" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">���ս��1��</td>
				<td class="right">	
					<input class="codecode" id="CaseResult1Code" name="lcReport.CaseResult1Code" class="common" type="text" value="" style="width:20%" ><input name="CaseResult1" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			
				<td class="left">���ս��2��</td>
				<td class="right">	
					<input class="codecode" id="CaseResult2Code" name="lcReport.CaseResult2Code" class="common" type="text" value="" style="width:20%" ><input name="CaseResult2" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">���յص㣺</td>
				<td class="right"><input name="caseAddress" class="common" type="text" onchange="clickable()"></td>
				<td class="left">סԺ���ң�</td>
				<td class="right"><input name="HosDepart" class="common" type="text" onchange="clickable()"></td>
				<td class="left">Ԥ����</td>
				<td class="right">
					<input name="estimatAmount" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">������ʶ��</td>
				<td class="right">
					<input class="codecode" id="caseCode" name="lcReport.caseCode" class="common" type="text" value="" style="width:20%" ><input name="caseFlag" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">�������ڣ�</td>
				<td class="right">
					<input name="deathDate" id="deathDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'deathDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
		</table>
		<table id="claimType" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../../commonpage/ClaimType.jsp" /></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="saveButton" value="��  ��" onclick="" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="ProCertify" value="���ɵ�֤" onclick="self.location.href='${ctx}/claim/claimoperate/register/ClaimAffixImptNew.jsp'" />
					<input type="button" class="cssbutton" name="CertifyDest" value="��֤����" onclick="self.location.href='${ctx}/claim/claimoperate/register/ClaimAffixImpt.jsp'" />
					<input type="button" class="cssbutton" name="PrintCertify" value="��ӡ��֤֪ͨ���嵥" onclick="" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="StartSurvey" value="�������" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyApply.jsp'" />
					<input type="button" class="cssbutton" name="CancelSurvey" value="ȡ������" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyCancel.jsp'" />
					<input type="button" class="cssbutton" name="AccessSurvey" value="�鿴����" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="AccessReport" value="�鿴�ʱ�" onclick="self.location.href='${ctx}/claim/claimoperate/register/ReportInfoQuery.jsp'" />
				</td>
			</tr>
		</table>
	</div>
	<div id="registerResult" style="width:100%">
		<table id="RegisterResultInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="3"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">����������Ϣ</td>
			</tr>
			<tr>
				<td class="left">�������ۣ�</td>
				<td class="right">
					<input class="codecode" id="registerCode" name="lcReport.registerCode" class="common" type="text" value="01" style="width:20%" ><input name="registerResult" class="common" type="text" onchange="clickable()" style="width:68%" value="����ͨ��"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td>
					<input type="button" class="cssbutton" name = "ResultSave" value="���۱���" onclick="">
				</td>
			</tr>
		</table>
		<hr />
		<table id="refuseRegister" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">��������ԭ��</td>
				<td class="right">
					<input class="codecode" id="refuseRegistCode" name="lcReport.refuseRegistCode" class="common" type="text" value="06" style="width:20%" ><input name="refuseRegist" class="common" type="text" onchange="clickable()" style="width:68%" value="���ⵥ֤����ȫ">
				</td>
				<td>
					<input type="button" class="cssbutton" name = "printRefuRegist" value="��ӡ��������֪ͨ��" onclick="">
				</td>
			</tr>
		</table>
		<hr />
		<table id="delayRegist" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td>�ӳ�����ԭ��(�����������300����)</td>
			</tr>
			<tr>
				<td>
					<textarea name="delayRegist" cols="" rows="4" style="width:100%"></textarea>
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "printDelayRegist" value="��ӡ�ӳ�����֪ͨ��" onclick="">
				</td>
			</tr>
	    </table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="RegisterConf" value="����ȷ��" onclick="" />
					<input type="button" class="cssbutton" name="returnButton" value="��  ��" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
