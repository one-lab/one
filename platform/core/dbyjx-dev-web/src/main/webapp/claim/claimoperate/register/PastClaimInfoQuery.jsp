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
    
    <title>�����ⰸ��ϸ��Ϣ��ѯ</title>
    
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
		<table id="RegisterInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">������Ϣ</td>
			</tr>
			<tr>
				<td  class="left">�¼��ţ�</td>
				<td  class="right"><input name="EventNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�ⰸ�ţ�</td>
				<td  class="right"><input name="ClaimNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">������������</td>
				<td  class="right"><input name="ApplyName" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">�����˵绰��</td>
				<td  class="right"><input name="ApplyTel" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�����˵�ַ��</td>
				<td  class="right"><input name="ApplyAddr" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">������������˹�ϵ��</td>
				<td  class="right">
					<input class="codecode" id="relatshipCode" name="lcReport.relatshipCode" class="common" type="text" value="" style="width:20%" ><input name="relatship" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td  class="left">���յص㣺</td>
				<td  class="right"><input name="AppPlace" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�������ڣ�</td>
				<td  class="right"><input name="RgtDate" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">��Ͻ������</td>
				<td  class="right"><input name="JurisCom" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">���������ˣ�</td>
				<td  class="right"><input name="Rgtant" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">���������ͣ�</td>
				<td  class="right"><input name="AgentMode" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�����˴��룺</td>
				<td  class="right"><input name="AgentCode" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">������������</td>
				<td  class="right"><input name="AgentName" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�������Ա�</td>
				<td  class="right"><input name="AgentSex" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�����˵绰��</td>
				<td  class="right"><input name="AgentTel" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">�����˵�ַ��</td>
				<td  class="right"><input name="AgentAddr" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�������ʱࣺ</td>
				<td  class="right"><input name="AgentZip" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�������ͣ�</td>
				<td  class="right"><input name="ApplyType" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">�������ȡ��ʽ��</td>
				<td  class="right"><input name="ClaimGetType" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="ReportInfoList" class="common" cellpadding="3" cellspacing="0">
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
		<table id="RegisterInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">������������</td>
				<td class="right"><input name="AppntName" class="common" type="text" onchange="clickable()"></td>
				<td class="left">���������䣺</td>
				<td class="right"><input name="AppntAge" class="common" type="text" onchange="clickable()"></td>
				<td class="left">�������Ա�</td>
				<td class="right"><input name="AppntSex" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">��ϵ�绰��</td>
				<td class="right">
					<input name="Telephone" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">�¹����ڣ�</td>
				<td class="right">
					<input name="AccidDate" id="AccidDate" class="common" type="text" onchange="clickable()" value='' /><img src="${ctx}/images/bgMarkMustInput.jpg" >
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
				<td class="left">�������ڣ�</td>
				<td class="right">
					<input name="AppntDate" id="AppntDate" class="common" type="text" onchange="clickable()" value='' /><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">����ϸ�ڣ�</td>
				<td class="right">
					<input class="codecode" id="unexpectDetailCode" name="lcReport.unexpectDetailCode" class="common" type="text" value="" style="width:20%" ><input name="unexpectDetail" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			<tr>
				<td class="left">���������</td>
				<td class="right">
					<input class="codecode" id="treatStateCode" name="lcReport.treatStateCode" class="common" type="text" value="" style="width:20%" ><input name="treatState" class="common" type="text" onchange="clickable()" style="width:68%" value="">
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
				<td class="left">סԺ���ң�</td>
				<td class="right"><input name="HosDepart" class="common" type="text" onchange="clickable()"></td>
		        <td class="left">��֤��ȫ��ʶ��</td>
				<td class="right">
					<input class="codecode" id="affixComplCode" name="lcReport.affixComplCodee" class="common" type="text" value="" style="width:20%" ><input name="affixComplFlag" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td class="left">������ʶ��</td>
				<td class="right"><input name="CaseFlag" class="common" type="text" onchange="clickable()"></td>
				<td class="left">�⸶������</td>
				<td class="right"><input name="ClaimNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<table id="ClaimType" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../../commonpage/ClaimType.jsp" /></td>
			</tr>
			<tr>
				<td >��ע</td>
			</tr>
			<tr>
				<td><textarea name="Remark" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<hr />
		<table id="RegisterResult" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="3"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">����������Ϣ</td>
			</tr>
			<tr>
				<td class="left">��������</td>
				<td class="right">
					<input class="codecode" id="registerCode" name="lcReport.registerCode" class="common" type="text" value="" style="width:20%"><input name="registerResult" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
		</table>
		<hr />
	</div>
	<div style="width:100%">
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../../commonpage/CalculaInfo.jsp" /></td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="AccessReport" value="�鿴�ʱ�" onclick="self.location.href='${ctx}/claim/claimoperate/register/ReportInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="AccessSurvey" value="�鿴����" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="RemarkInfo" value="��ע��Ϣ" onclick="" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="MedCtfInfoQuery" value="ҽ�Ƶ�֤��Ϣ�鿴" onClick="self.location.href='${ctx}/claim/claimoperate/approve/MedicalAffixApply.jsp'" />
					<input type="button" class="cssbutton" name="ApproveQuery" value="���˽��۲鿴" onclick="self.location.href='${ctx}/claim/claimoperate/audit/DealSecdAudit.jsp'" />
					<input type="button" class="cssbutton" name="BnfDtbQuery" value="�����˷�����Ϣ�鿴" onClick="self.location.href='${ctx}/claim/claimoperate/approve/BnfDistbQuery.jsp'" />
					<input type="button" class="cssbutton" name="ApproveQuery" value="����������۲鿴" onclick="" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../../commonpage/ApproveAuditMng.jsp" /></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input  type="button" class="cssbutton" name="returnButton" value="��  ��" onclick="javascript:history.back();" />
 				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
