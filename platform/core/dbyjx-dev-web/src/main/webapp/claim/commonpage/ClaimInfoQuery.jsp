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
    
    <title>�᰸��Ϣ��ѯ</title>
    
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
		<table id="RegisterApplyInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">����������Ϣ</td>
			</tr>
			<tr>
				<td  class="left">�ⰸ�ţ�</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�������ڣ�</td>
				<td  class="right">
					<input name="AppntDate" id="AppntDate" class="common" type="text" onchange="clickable()" />
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td  class="left">������������˹�ϵ��</td>
				<td  class="right">
					<input name="Relationship" class="common" type="text" onchange="clickable()">
				</td>
				<td  class="left">������������</td>
				<td  class="right">
					<input name="RgtantName" class="common" type="text" onchange="clickable()">
				</td>
				<td  class="left">�����˵绰��</td>
				<td  class="right">
					<input name="RgtantTel" class="common" type="text" onchange="clickable()">
				</td>
			</tr>
			<tr>
				<td  class="left">�����˵�ַ��</td>
				<td  class="right">
					<input name="RgtantAddress" class="common" type="text" onchange="clickable()">
				</td>
				<td  class="left">�������ڣ�</td>
				<td class="right">
					<input name="RgtDate" id="RgtDate" class="common" type="text" onchange="clickable()" />
				</td>
				<td  class="left">���������ˣ�</td>
				<td  class="right"><input name="RgtAgent" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">���������ͣ�</td>
				<td  class="right"><input name="AgentType" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�����˴��룺</td>
				<td  class="right"><input name="AgentCode" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">������������</td>
				<td  class="right"><input name="AgentName" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">�������Ա�</td>
				<td  class="right"><input name="AgentType" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�����˵绰��</td>
				<td  class="right"><input name="AgentTel" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�����˵�ַ��</td>
				<td  class="right"><input name="AgentAddress" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">�������ʱࣺ</td>
				<td  class="right"><input name="AgentZip" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">���������ţ�</td>
				<td class="right">
					<input name="RgtDate" id="RgtDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="RegisterList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="30%">����������</td>
					<td width="30%">�Ա�</td>
					<td width="30%">��������</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>��</td>
					<td>��</td>
					<td>1986-03-01</td>
				</tr>
			</tbody>
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
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">������������</td>
				<td class="right"><input name="AppntName" class="common" type="text" onchange="clickable()"></td>
				<td class="left">���������䣺</td>
				<td class="right"><input name="AppntAge" class="common" type="text" onchange="clickable()"></td>
				<td class="left">�������Ա�</td>
				<td class="right"><input name="AppntSex" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">����ԭ��</td>
				<td class="right">
					<input name="AppntReason" class="common" type="text" onchange="clickable()">
				</td>
				<td class="left">����ҽԺ��</td>
				<td class="right"><input name="treatHospital" class="common" type="text" onchange="clickable()"></td>
				<td class="left">��ϵ�绰��</td>
				<td class="right">
					<input name="Telephone" class="common" type="text" onchange="clickable()">
				</td>
			</tr>
			<tr>
				<td class="left">����ϸ�ڣ�</td>
				<td class="right"><input name="UnexpectDetail" class="common" type="text" onchange="clickable()"></td>
				<td class="left">���������</td>
				<td class="right"><input name="Treatment" class="common" type="text" onchange="clickable()"></td>
				<td class="left">���ս��1��</td>
				<td class="right">
					<input name="CaseResult1" class="common" type="text" onchange="clickable()">	
				</td>
			</tr>
			<tr>
				<td class="left">���ս��2��</td>
				<td class="right">
					<input name="CaseResult2" class="common" type="text" onchange="clickable()">
				</td>
				<td class="left">סԺ���ң�</td>
				<td class="right"><input name="HosDepart" class="common" type="text" onchange="clickable()"></td>
				<td class="left">��֤��ȫ��ʶ��</td>
				<td class="right">
					<input name="EstimatAmount" class="common" type="text" onchange="clickable()">
				</td>
			</tr>
			<tr>
				<td class="left">���յص㣺</td>
				<td class="right"><input name="CaseAddress" class="common" type="text" onchange="clickable()"></td>
				<td class="common"> </td>
				<td class="common"> </td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
		</table>
		<table id="ClaimType" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="ClaimType.jsp" /></td>
			</tr>
		</table>
		<table id="RegisterResult" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">����������Ϣ</td>
			</tr>
			<tr>
				<td class="left">�������ۣ�</td>
				<td class="right"><input name="AppntName" class="common" type="text" onchange="clickable()"></td>
				<td class="left">������ʶ��</td>
				<td class="right"><input name="AppntAge" class="common" type="text" onchange="clickable()"></td>
				<td class="left">�ⰸ״̬��</td>
				<td class="right"><input name="AppntSex" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">�����ˣ�</td>
				<td class="right"><input name="AppntName" class="common" type="text" onchange="clickable()"></td>
				<td class="left">�������ڣ�</td>
				<td class="right"><input name="AppntAge" class="common" type="text" onchange="clickable()"></td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="ReportInfoList" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="CalculaInfo.jsp" /></td>
			</tr>
		</table>
		<hr />		
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="AccessReport" value="�鿴�ʱ�" onclick="self.location.href='${ctx}/claim/claimoperate/register/ReportInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="AccessSurvey" value="�鿴����" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="SecAuditResult" value="���˽��۲鿴" onclick="self.location.href='${ctx}/claim/claimoperate/audit/DealSecdAudit.jsp'" />
					<input type="button" class="cssbutton" name="MatchClaim" value="��������Ϣ�鿴" onClick="self.location.href='${ctx}/claim/claimoperate/approve/BnfDistbQuery.jsp'"/>
					<input type="button" class="cssbutton" name="AffixAdjust" value="ҽ�Ƶ�֤�鿴" onClick="self.location.href='${ctx}/claim/claimoperate/approve/MedicalAffixApply.jsp'" />
				</td>
			</tr>
		</table>
		<table id="ApproveInfoMng" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">��˹���</td>
			</tr>
			<tr>
				<td class="left">����ˣ�</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">������ڣ�</td>
				<td  class="right"><input name="AuditDate" class="common" type="text" onchange="clickable()"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">��˽��ۣ�</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
				<td class="left">������ʶ��</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">���ⱸע��</td>
				<td  class="right"><input name="AuditDate" class="common" type="text" onchange="clickable()"></td>
			</tr>
		</table>
		<hr />
		<table id="AuditInfoMng" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">��������</td>
			</tr>
			<tr>
				<td colspan="6">�������(�����ַ����700����)</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="AccidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
			<tr>
				<td class="left">�����ˣ�</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�������ڣ�</td>
				<td  class="right"><input name="AuditDate" class="common" type="text" onchange="clickable()"></td>
				<td class="left">��˽��ۣ�</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">������ʶ��</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
