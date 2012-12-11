<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>呈报录入</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">ctx = "${ctx}";</script>
<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/common/calender/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
<script type="text/javascript" src="${ctx}/prpall/group/report/js/ReportAdd.js"></script>
</head>
<body>
<div style="width: 100%">
<s:if test="lcReportFileList.size>0">
<table id="ReportApplyInfo" class="common" cellpadding="3"
	cellspacing="0">
	<thead>
		<tr>
			<td class="formtitle" colspan="6"><img
				src="${ctx}/images/bgformtitle.gif" style="cursor: hand;">呈报返回信息</td>
		</tr>
		<tr class="tableHead">
			<td width="3%">&nbsp;</td>
			<td width="10%">序号</td>
			<td width="17%">呈报申请号</td>
			<td width="17%">上载批次号</td>
			<td width="17%">经办人</td>
			<td width="17%">上载日期</td>
			<td width="17%">下载</td>
		</tr>
	</thead>
	<tbody id="ReportApplyInfoBody">
		<s:iterator value="lcReportFileList" var="temp" status="s">
		<tr class="content">
			<td width="3%">&nbsp;</td>
			<td width="10%"><s:property value="#s.count"/></td>
			<td width="17%"><s:property value="#temp.repno"/></td>
			<td width="17%"><s:property value="#temp.uploadcode"/></td>
			<td width="17%"><s:property value="#temp.fileoperator"/></td>
			<td width="17%"><s:date name="#temp.uploadDate" format="yyyy-MM-dd"/></td>
			<td width="17%"><s:property value="#temp.fileName"/></td>
		</tr>
		</s:iterator>

	</tbody>
</table>
<hr />
</s:if>
<form id="reportForm">
<div>
<input type="hidden" id="grpContNoHidden" name="lcGrpAppReport.id.grpContNo"/>
<input type="hidden" id="serialNoHidden" name="lcReport.serialNo" />
<input type="hidden" id="proposalGrpContNoHidden" name="lcGrpContReport.proposalGrpContNo"/>
<input type="hidden" id="prtNoHidden" />
<input type="hidden" id="customerNoHidden" />
<input type="hidden" id="mainRiskCodeHidden" />
<input type="hidden" id="saleChnlHidden" />
<input type="hidden" id="manageComHidden" /> 
<input type="hidden" id="agentTypeHidden" /> 
<input type="hidden" id="agentGroupHidden" />
<input type="hidden" id="agentCode1Hidden" />
<input type="hidden" id="agentComHidden" /> 
<input type="hidden" id="agentCodeHidden" /> 
<input type="hidden" id="addressNoHidden" /> 
<input type="hidden" id="payModeHidden" /> 
<input type="hidden" id="GrpNameHidden" />
<input type="hidden" id="riskCodeHidden" /> 
<input type="hidden" id="repNoHidden" /> 
<input type="hidden" id="repApplyDateHidden" /> 
<input type="hidden" id="repOperatorHidden" />

<table id=PraPallInfo " class="common" cellpadding="3" cellspacing="0">
	<tr>
		<td class="formtitle" colspan="6"><img
			src="${ctx}/images/bgformtitle.gif" style="cursor: hand;"> 投保信息</td>
	</tr>
	<tr>
		<td class="left">呈报申请号：</td>
		<td class="right"><input id="repNo" name="lcReport.repNo"
			class="common" type="text" value="${lcReport.repNo }"></td>
		<td class="left">呈报日期：</td>
		<td class="right"><input id="repApplyDate"
			name="lcReport.repApplyDate" class="common" type="text" maxlength=""
			style="width: 73%" value="${lcReport.repApplyDate }"> <img
			style='cursor: hand' align="middle"
			src="${ctx}/images/bgcalendar.gif"
			onClick="WdatePicker({el:'repApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
		</td>
		<td class="left">管理机构：</td>
		<td class="right"><input type="hidden" id="upperComCode"
			value='<s:property value="#session.prpDcompany.comCode"/>' /> <input class="codecode" id="manageCom"
			name="lcReport.manageCom" class="common" type="text"
			value='${lcReport.manageCom }' style="width: 20%"
			ondblclick="queryCode('manageCom','comName','PrpDcompany','comCode:manageCom|upperComCode:upperComCode');"><input
			id="comName" name="comName" class="common" type="text"
			style="width: 68%" value=""><img
			src="${ctx}/images/bgMarkMustInput.jpg"></td>
	</tr>
	<tr>
		<td class="left">呈报人：</td>
		<td class="right"><input id="repOperator"
			name="lcReport.repOperator" class="common" type="text"
			value="${lcReport.repOperator }"></td>
		<td class="left">业务员编码：</td>
		<td class="right"><input class="codecode" id="agentCode"
			name="lcReport.agentCode" class="common" type="text"
			value="${lcReport.agentCode }" style="width: 20%"
			ondblclick="queryCode('agentCode','agentName','PrpDuser','codeType:agenCode')" /><input
			id="agentName" name="agentName" class="common" type="text"
			style="width: 68%" value=""><img
			src="${ctx}/images/bgMarkMustInput.jpg"></td>
		<td class="left">服务方式：</td>
		<td class="right"><input class="codecode" id="serviceType"
			name="lcReport.serviceType" class="common" type="text" value="${lcReport.serviceType }"
			style="width: 20%"
			ondblclick="queryCode('serviceType','serviceTypeValue','PDLDcode1','codeType:ServiceType')"><input
			id="serviceTypeValue" name="serviceTypeValue" class="common"
			value="" type="text" style="width: 68%"><img
			src="${ctx}/images/bgMarkMustInput.jpg"></td>
	</tr>
	<tr>
		<td class="left">是否中介业务：</td>
		<td class="right"><input class="codecode" id="bussinessFlag"
			name="lcReport.bussinessFlag" class="common" type="text" value="${lcReport.bussinessFlag }"
			style="width: 20%"
			ondblclick="queryCode('bussinessFlag','businessFlagValue','PDLDcode1','codeType:SocietyStat')" /><input
			id="businessFlagValue" name="businessFlagValue" class="common"
			type="text" style="width: 68%" value=""></td>
		<td class="left"></td>
		<td class="right"></td>
		<td class="left"></td>
		<td class="right"></td>
	</tr>
</table>
<table id="CompanyInfo" class="common" cellpadding="3" cellspacing="0">
	<tr>
		<td><jsp:include page="/prpall/group/report/reportInput/CompanyInfo.jsp" /></td>
	</tr>
</table>
</div>
<br />
<br />
<div style="width: 100%">
<!-- 告知单信息 -->
<jsp:include page="/prpall/group/report/reportInput/InformInfo.jsp" />
</div>
</form>
<hr />
</div>
<!-- 集体险种信息 -->
<jsp:include page="/prpall/group/report/reportInput/GrpRiskInfo.jsp" />
<!-- 集体投保单信息 -->
<jsp:include page="/prpall/group/report/reportInput/GrpInsuredInfo.jsp" />
<!-- 上传附件信息 -->
<jsp:include page="/prpall/group/report/reportInput/UploadFileInfo.jsp" />
</body>
</html>
