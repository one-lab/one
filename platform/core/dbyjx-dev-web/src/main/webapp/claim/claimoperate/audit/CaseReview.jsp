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
    
	    <title>�������</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>
		<script type="text/javascript">
		function showPage()
		{
			tt = document.getElementById("AddAffix");
			tt.style.display="block";
		}
		</script>

	</head>
<body>
  <form name="fm" method="post" onkeypress="KeyDown()">
	<div id="RegisterInfo" style="width:100%">
		<table id="registerInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../../commonpage/RegisterInfo.jsp" /></td>
			</tr>
		</table>
		<table id="RegisterResult" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">����������Ϣ</td>
			</tr>
			<tr>
				<td class="left">�������ۣ�</td>
					<td class="right">
						<input class="codecode" id="registerCode" name="lcReport.registerCode" class="common" type="text" value="" style="width:20%" ><input name="registerResult" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
					</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<td width="10%" align='left'><input type="button" class="cssbutton" value="ƥ��������������" onClick=""></td>
					<td width="10%" align='left'><input type="button" class="cssbutton" value="ҽ�Ƶ�֤¼��" onClick="self.location.href='${ctx}/claim/claimoperate/audit/MedicalAffixEdit.jsp'"></td>
					<td width="80%"><input type="button" class="claimButton" value="��  ��">
				</td>
			</tr>
		</table>
		<table id="PolicyInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="11"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">����������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="10%">�����˱���</td>
					<td width="10%">����������</td>
					<td width="15%">��ͬ��</td>
					<td width="15%">������</td>
					<td width="10%">������������</td>
					<td width="6%">��Ч����</td>
					<td width="6%">��������</td>
					<td width="6%">���ִ���</td>
					<td width="15%">��������</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="checkbox" name="CheckBox" value="" /></td>
					<td>1</td>
					<td>2012050600</td>
					<td>�޲�</td>
					<td>46413841242101</td>
					<td>46413841242101</td>
					<td>ҽ��</td>
					<td>2012-03-01</td>
					<td>2013-02-28</td>
					<td>2710</td>
					<td>���������˺�����</td>
				</tr>		
			</tbody>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�ⰸ������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="15%">�⸶���</td>
					<td width="15%">Ԥ�����</td>
					<td width="15%">������</td>
					<td width="15%">�����⸶���</td>
					<td width="15%">������</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>2000</td>
					<td>0</td>
					<td>2000</td>
					<td>2000</td>
					<td>0</td>
				</tr>
			</tbody>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�������ͼ�����Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="10%">�������ʹ���</td>
					<td width="15%">������������</td>
					<td width="10%">�˵����</td>
					<td width="10%">�����⸶���</td>
					<td width="10%">�籣����</td>
					<td width="10%">����������</td>
					<td width="10%">�����⸶���</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>102</td>
					<td>�˲�</td>
					<td>4000</td>
					<td>2000</td>
					<td>0</td>
					<td>0</td>
					<td>2000</td>
				</tr>
			</tbody>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">����������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="15%">��ͬ��</td>
					<td width="15%">������</td>
					<td width="6%">��������</td>
					<td width="10%">��Ч����</td>
					<td width="10%">��������</td>
					<td width="6%">���ִ���</td>
					<td width="10%">��������</td>
					<td width="10%">������</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>110210000008568</td>
					<td>S110210000008568</td>
					<td>�˲�</td>
					<td>2012-03-01</td>
					<td>2013-02-28</td>
					<td>2710</td>
					<td>���������˺�����</td>
					<td>800</td>
				</tr>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>G110210000008568</td>
					<td>G110210000008568</td>
					<td>�˲�</td>
					<td>2012-03-01</td>
					<td>2013-02-28</td>
					<td>2700</td>
					<td>���������˺�����</td>
					<td>1200</td>
				</tr>				
			</tbody>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">���������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="15%">������</td>
					<td width="10%">��������</td>
					<td width="10%">��������</td>
					<td width="10%">����ֹ��</td>
					<td width="10%">����</td>
					<td width="10%">������</td>
					<td width="10%">Ԥ�����</td>
					<td width="10%">�������</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value=""  onClick="showPage()"/></td>
					<td>1</td>
					<td>S110210000008568</td>
					<td>���������˲и���</td>
					<td>2012-03-01</td>
					<td>2013-02-28</td>
					<td>10000</td>
					<td>800</td>
					<td>0</td>
					<td>0</td>
				</tr>
				<tr class="content">
					<td><input type="radio" name="Redio1" value=""  onClick="showPage()"/></td>
					<td>1</td>
					<td>G110210000008568</td>
					<td>���������˲и���</td>
					<td>2012-03-01</td>
					<td>2013-02-28</td>
					<td>20000</td>
					<td>1200</td>
					<td>0</td>
					<td>0</td>
				</tr>				
			</tbody>
		</table>
		<hr />
		<div style="width:60%" id="ClaimResult" style="display:none">
			<table id="ClaimResult" class="common" cellpadding="1" cellspacing="1" >
				<tr>
					<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�����⸶����</td>
				</tr>
				<tr>
					<td  class="left">�⸶���ۣ�</td>
					<td  class="right">
						<input class="codecode" id="resultCode" name="lcReport.resultCode" class="common" type="text" value="" style="width:20%"><input name="result" class="common" type="text" onchange="clickable()" style="width:68%" value="">
					</td>
					<td  class="common"> </td>
					<td  class="common"> </td>
				</tr>
				<tr>
					<td  class="left">������</td>
					<td  class="right"><input name="AdjusMount" class="common" type="text" onchange="clickable()"></td>
					<td  class="left">����ԭ��</td>
					<td  class="right">
						<input class="codecode" id="adjusCode" name="lcReport.adjusCode" class="common" type="text" value="" style="width:20%"><input name="adjusReson" class="common" type="text" onchange="clickable()" style="width:68%" value="">
					</td>
				</tr>
				<tr>
					<td >������ע</td>
				</tr>
				<tr>
					<td colspan="4"><textarea name="remarkInfo" cols="" rows="4" style="width:100%"></textarea></td>
				</tr>
			</table>
			<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td>
						<input type="button" class="cssbutton" name="SaveEdit" value="�����޸�" onclick="" />
					</td>
				</tr>
			</table>
		</div>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">�Զ������</td>
				<td class="right"><input name="autoClaimMount" class="common" type="text" onchange="clickable()"></td>
				<td class="left">������ʶ��</td>
				<td class="right">
					<input class="codecode" id="caseCode" name="lcReport.caseCode" class="common" type="text" value="" style="width:20%" ><input name="caseFlag" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="FindReport" value="�鿴�ʱ�" onclick="self.location.href='${ctx}/claim/claimoperate/register/ReportInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="StartSurvey" value="�������" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyApply.jsp'" />
					<input type="button" class="cssbutton" name="AccessSurvey" value="�鿴����" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="CancelSurvey" value="ȡ������" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyCancel.jsp'" />
					<input type="button" class="cssbutton" name="AffixSupple" value="���䵥֤" onclick="self.location.href='${ctx}/claim/claimoperate/register/ClaimAffixImptNew.jsp'" />
					<input type="button" class="cssbutton" name="AffixReturn" value="��֤����" onclick="self.location.href='${ctx}/claim/claimoperate/register/ClaimAffixImpt.jsp'" />
					<input type="button" class="cssbutton" name="PrintCertify" value="��ӡ��֤֪ͨ���嵥" onclick="" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="AffixAdjust" value="ҽ�Ƶ�֤����" onClick="self.location.href='${ctx}/claim/claimoperate/audit/MedicalAffixEdit.jsp'"" />
					<input type="button" class="cssbutton" name="MatchClaim" value="ƥ�䲢����" onclick="" />
					<input type="button" class="cssbutton" name="StartSecAudit" value="�������" onclick="self.location.href='${ctx}/claim/claimoperate/audit/SecdAuditStart.jsp'" />
					<input type="button" class="cssbutton" name="SecAuditResult" value="���˽��۲鿴" onclick="self.location.href='${ctx}/claim/claimoperate/audit/DealSecdAudit.jsp'" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="ApproveMng" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">��˹���</td>
			</tr>
			<tr>
				<td colspan="6">������(�����ַ����700����)</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="auditOpinion" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
			<tr>
				<td class="left">����ˣ�</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">������ڣ�</td>
				<td  class="right"><input name="AuditDate" class="common" type="text" onchange="clickable()"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="ApproveResult" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">��˽��ۣ�</td>
				<td class="right">
					<input class="codecode" id="auditCode" name="lcReport.auditCode" class="common" type="text" value="" style="width:20%"><input name="auditResult" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td  class="left">���ⱸע��</td>
				<td  class="right"><input name="AuditDate" class="common" type="text" onchange="clickable()"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="AffixAdjust" value="���۱���" onclick="" />
					<input type="button" class="cssbutton" name="BnfDisb" value="�����˷���" onclick="self.location.href='${ctx}/claim/claimoperate/audit/BnfDistbInfo.jsp'" />
					<input type="button" class="cssbutton" name="FindAudit" value="��˽��۲�ѯ" onclick="self.location.href='${ctx}/claim/claimoperate/audit/CaseClaimInfo.jsp'" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="SureAudit" value="���ȷ��" onclick="" />
					<input type="button" class="cssbutton" name="returnButton" value="��  ��" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>