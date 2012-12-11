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
    
	    <title>案件审核</title>
	    
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
				<td class="formtitle"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">立案结论信息</td>
			</tr>
			<tr>
				<td class="left">立案结论：</td>
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
					<td width="10%" align='left'><input type="button" class="cssbutton" value="匹配所有理算责任" onClick=""></td>
					<td width="10%" align='left'><input type="button" class="cssbutton" value="医疗单证录入" onClick="self.location.href='${ctx}/claim/claimoperate/audit/MedicalAffixEdit.jsp'"></td>
					<td width="80%"><input type="button" class="claimButton" value="理  算">
				</td>
			</tr>
		</table>
		<table id="PolicyInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="11"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">保单计算信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="10%">出险人编码</td>
					<td width="10%">出险人姓名</td>
					<td width="15%">合同号</td>
					<td width="15%">保单号</td>
					<td width="10%">给付责任名称</td>
					<td width="6%">生效日期</td>
					<td width="6%">交至日期</td>
					<td width="6%">险种代码</td>
					<td width="15%">险种名称</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="checkbox" name="CheckBox" value="" /></td>
					<td>1</td>
					<td>2012050600</td>
					<td>罗布</td>
					<td>46413841242101</td>
					<td>46413841242101</td>
					<td>医疗</td>
					<td>2012-03-01</td>
					<td>2013-02-28</td>
					<td>2710</td>
					<td>个人意外伤害保险</td>
				</tr>		
			</tbody>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">赔案计算信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">赔付金额</td>
					<td width="15%">预付金额</td>
					<td width="15%">结算金额</td>
					<td width="15%">最终赔付金额</td>
					<td width="15%">拒赔金额</td>
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
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">理赔类型计算信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="10%">理赔类型代码</td>
					<td width="15%">理赔类型名称</td>
					<td width="10%">账单金额</td>
					<td width="10%">核算赔付金额</td>
					<td width="10%">社保给付</td>
					<td width="10%">第三方给付</td>
					<td width="10%">核赔赔付金额</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>102</td>
					<td>伤残</td>
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
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">保单计算信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">合同号</td>
					<td width="15%">保单号</td>
					<td width="6%">理赔类型</td>
					<td width="10%">生效日期</td>
					<td width="10%">交至日期</td>
					<td width="6%">险种代码</td>
					<td width="10%">险种名称</td>
					<td width="10%">理算金额</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>110210000008568</td>
					<td>S110210000008568</td>
					<td>伤残</td>
					<td>2012-03-01</td>
					<td>2013-02-28</td>
					<td>2710</td>
					<td>个人意外伤害保险</td>
					<td>800</td>
				</tr>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>G110210000008568</td>
					<td>G110210000008568</td>
					<td>伤残</td>
					<td>2012-03-01</td>
					<td>2013-02-28</td>
					<td>2700</td>
					<td>团体意外伤害保险</td>
					<td>1200</td>
				</tr>				
			</tbody>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">保项计算信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">保单号</td>
					<td width="10%">保险责任</td>
					<td width="10%">责任起期</td>
					<td width="10%">责任止期</td>
					<td width="10%">保额</td>
					<td width="10%">理算金额</td>
					<td width="10%">预付金额</td>
					<td width="10%">调整金额</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value=""  onClick="showPage()"/></td>
					<td>1</td>
					<td>S110210000008568</td>
					<td>个人意外伤残给付</td>
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
					<td>团体意外伤残给付</td>
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
					<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">保项赔付结论</td>
				</tr>
				<tr>
					<td  class="left">赔付结论：</td>
					<td  class="right">
						<input class="codecode" id="resultCode" name="lcReport.resultCode" class="common" type="text" value="" style="width:20%"><input name="result" class="common" type="text" onchange="clickable()" style="width:68%" value="">
					</td>
					<td  class="common"> </td>
					<td  class="common"> </td>
				</tr>
				<tr>
					<td  class="left">调整金额：</td>
					<td  class="right"><input name="AdjusMount" class="common" type="text" onchange="clickable()"></td>
					<td  class="left">调整原因：</td>
					<td  class="right">
						<input class="codecode" id="adjusCode" name="lcReport.adjusCode" class="common" type="text" value="" style="width:20%"><input name="adjusReson" class="common" type="text" onchange="clickable()" style="width:68%" value="">
					</td>
				</tr>
				<tr>
					<td >调整备注</td>
				</tr>
				<tr>
					<td colspan="4"><textarea name="remarkInfo" cols="" rows="4" style="width:100%"></textarea></td>
				</tr>
			</table>
			<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td>
						<input type="button" class="cssbutton" name="SaveEdit" value="保存修改" onclick="" />
					</td>
				</tr>
			</table>
		</div>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">自动理算金额：</td>
				<td class="right"><input name="autoClaimMount" class="common" type="text" onchange="clickable()"></td>
				<td class="left">案件标识：</td>
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
					<input type="button" class="cssbutton" name="FindReport" value="查看呈报" onclick="self.location.href='${ctx}/claim/claimoperate/register/ReportInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="StartSurvey" value="发起调查" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyApply.jsp'" />
					<input type="button" class="cssbutton" name="AccessSurvey" value="查看调查" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="CancelSurvey" value="取消调查" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyCancel.jsp'" />
					<input type="button" class="cssbutton" name="AffixSupple" value="补充单证" onclick="self.location.href='${ctx}/claim/claimoperate/register/ClaimAffixImptNew.jsp'" />
					<input type="button" class="cssbutton" name="AffixReturn" value="单证回销" onclick="self.location.href='${ctx}/claim/claimoperate/register/ClaimAffixImpt.jsp'" />
					<input type="button" class="cssbutton" name="PrintCertify" value="打印单证通知书清单" onclick="" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="AffixAdjust" value="医疗单证调整" onClick="self.location.href='${ctx}/claim/claimoperate/audit/MedicalAffixEdit.jsp'"" />
					<input type="button" class="cssbutton" name="MatchClaim" value="匹配并理算" onclick="" />
					<input type="button" class="cssbutton" name="StartSecAudit" value="发起二核" onclick="self.location.href='${ctx}/claim/claimoperate/audit/SecdAuditStart.jsp'" />
					<input type="button" class="cssbutton" name="SecAuditResult" value="二核结论查看" onclick="self.location.href='${ctx}/claim/claimoperate/audit/DealSecdAudit.jsp'" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="ApproveMng" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">审核管理</td>
			</tr>
			<tr>
				<td colspan="6">审核意见(包括字符最多700汉字)</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="auditOpinion" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
			<tr>
				<td class="left">审核人：</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">审核日期：</td>
				<td  class="right"><input name="AuditDate" class="common" type="text" onchange="clickable()"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="ApproveResult" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">审核结论：</td>
				<td class="right">
					<input class="codecode" id="auditCode" name="lcReport.auditCode" class="common" type="text" value="" style="width:20%"><input name="auditResult" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td  class="left">特殊备注：</td>
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
					<input type="button" class="cssbutton" name="AffixAdjust" value="结论保存" onclick="" />
					<input type="button" class="cssbutton" name="BnfDisb" value="受益人分配" onclick="self.location.href='${ctx}/claim/claimoperate/audit/BnfDistbInfo.jsp'" />
					<input type="button" class="cssbutton" name="FindAudit" value="审核结论查询" onclick="self.location.href='${ctx}/claim/claimoperate/audit/CaseClaimInfo.jsp'" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="SureAudit" value="审核确认" onclick="" />
					<input type="button" class="cssbutton" name="returnButton" value="返  回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>