<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>出险人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx }/claim/claimoperate/report/js/AppntInfo.js"></script>
	
  </head>
  
  <body>
  <div id="appntInfo" style="width: 100%">
<!--  	<input type="hidden" id="customerNo" name="llSubReport.id.customerNo" value='<s:property value="#request.llSubReportList[0].id.customerNo" />' >-->
  	<input type="hidden" id="customerNo" name="llSubReport.id.customerNo" value="2012000004" >
  	<input type="hidden" id="custBirthday" name="llSubReport.custBirthday" value='<s:property value="#request.llSubReportList[0].custBirthday" />' >
  	<input type="hidden" id="idType" name="llSubReport.idType" value='<s:property value="#request.llSubReportList[0].idType" />' >
  	<input type="hidden" id="idNo" name="llSubReport.idNo" value='<s:property value="#request.llSubReportList[0].idNo" />' >
	<table id="ReportInfoList" class="common" cellpadding="3" cellspacing="0">
		<tr>
			<td><jsp:include page="/claim/commonpage/AppntInfoList.jsp" /></td>
		</tr>
	</table>
	<table id="AppntInfo" class="common" cellpadding="3" cellspacing="1">
		<tr>
			<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">出险人信息</td>
		</tr>
		<tr>
			<td class="left">出险人姓名：</td>
			<td class="right"><input id="customerName" name="llSubReport.customerName" class="common" type="text" value='<s:property value="#request.llSubReportList[0].customerName" />' /></td>
			<td class="left">出险人年龄：</td>
			<td class="right"><input id="customerAge" name="llSubReport.customerAge" class="common" type="text" value='<s:property value="#request.llSubReportList[0].customerAge" />' /></td>
			<td class="left">出险人性别：</td>
			<td  class="right">
				<input class="codecode" id="sex" name="llSubReport.customerSex" type="text" style="width:20%" value='<s:property value="#request.llSubReportList[0].customerSex" />' ondblclick="queryCode('sex','sexValue','PDLDcode1','codeType:Sex')" /><input id="sexValue" name="llSubReport.sexValue" class="common" type="text" style="width:68%" value='<s:property value="#request.llSubReportList[0].sexValue" />' />
			</td>
		</tr>
		<tr>
			<td class="left">联系电话：</td>
			<td class="right">
				<input id="contactNo" name="llSubReport.contactNo" class="common" type="text" value='<s:property value="#request.llSubReportList[0].contactNo" />' /><img src="${ctx}/images/bgMarkMustInput.jpg" >
			</td>
			<td class="left">事故日期：</td>
			<td class="right">
				<input id="accDate" name="llAccident.accDate" class="common" type="text" style="width: 73%" value="<s:date name="#request.llAccidentList[0].accDate" format="yyyy-MM-dd"/>" /><img style='cursor: hand' 
					align="middle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'accDate',accDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
			</td>
			<td class="left">出险细节：</td>
			<td  class="right">
				<input class="codecode" id="AccidentDetail" name="llSubReport.accidentDetail" type="text" style="width:20%" value='<s:property value="#request.llSubReportList[0].accidentDetail" />' ondblclick="queryCode('AccidentDetail','AccidentDetailValue','PDLDcode1','codeType:AccidentDetail')" /><input id="AccidentDetailValue" name="llSubReport.accidentDetailValue" class="common" type="text" style="width:68%" value='<s:property value="#request.llSubReportList[0].accidentDetailValue" />' />
			</td>
		</tr>
		<tr>
			<td class="left">出险原因：</td>
			<td  class="right">
				<input class="codecode" id="AccCause" name="llSubReport.accCause" type="text" style="width:20%" value='<s:property value="#request.llSubReportList[0].accCause" />' ondblclick="queryCode('AccCause','AccCauseValue','PDLDcode1','codeType:AccCause')" /><input id="AccCauseValue" name="llSubReport.accCauseValue" class="common" type="text" style="width:68%" value='<s:property value="#request.llSubReportList[0].accCauseValue" />' />
			</td>
			<td class="left">出险地点：</td>
			<td class="right"><input id="accidentSite" name="llReport.accidentSite" class="common" type="text" value='<s:property value="#request.llReport.accidentSite" />' /></td>
			<td class="left">出险日期：</td>
			<td class="right">
				<input id="accidentDate" name="llReport.accidentDate" class="common" type="text" style="width: 73%" value="<s:date name="#request.llReport.accidentDate" format="yyyy-MM-dd"/>" /><img style='cursor: hand' 
					align="middle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'accidentDate',accidentDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
			</td>
		</tr>
		<tr>
			<td class="left">治疗医院：</td>
			<td  class="right">
				<input class="codecode" id="hospitalCode" name="llSubReport.hospitalCode" type="text" style="width:20%" value='<s:property value="#request.llSubReportList[0].hospitalCode" />' ondblclick="queryCode('hospitalCode','hospitalName','findHospital','hospitalCode:hospitalCode')" /><input id="hospitalName" name="llSubReport.hospitalName" class="common" type="text" style="width:68%" value='<s:property value="#request.llSubReportList[0].hospitalName" />' />
			</td>
			<td class="left">治疗情况：</td>
			<td  class="right">
				<input class="codecode" id="CureDesc" name="llSubReport.cureDesc" type="text" style="width:20%" value='<s:property value="#request.llSubReportList[0].cureDesc" />' ondblclick="queryCode('CureDesc','CureDescValue','PDLDcode1','codeType:CureDesc')" /><input id="CureDescValue" name="llSubReport.cureDescValue" class="common" type="text" style="width:68%" value='<s:property value="#request.llSubReportList[0].cureDescValue" />' />
			</td>
			<td class="left">出险结果1：</td>
			<td  class="right">
				<input class="codecode" id="AccResult1" name="llSubReport.accResult1" type="text" style="width:20%" value='<s:property value="#request.llSubReportList[0].accResult1" />' ondblclick="queryCode('AccResult1','AccResult1Value','PDLDcode1','codeType:AccResult1')" /><input id="AccResult1Value" name="llSubReport.accResult1Value" class="common" type="text" style="width:68%" value='<s:property value="#request.llSubReportList[0].accResult1Value" />' />
			</td>
		</tr>
		<tr>
			<td class="left">出险结果2：</td>
			<td  class="right">
				<input class="codecode" id="AccResult2" name="llSubReport.accResult2" type="text" style="width:20%" value='<s:property value="#request.llSubReportList[0].accResult2" />' ondblclick="queryCode('AccResult2','AccResult2Value','PDLDcode1','codeType:AccResult2')" /><input id="AccResult2Value" name="llSubReport.accResult2Value" class="common" type="text" style="width:68%" value='<s:property value="#request.llSubReportList[0].accResult2Value" />' />
			</td>
			<td class="left">住院科室：</td>
			<td class="right"><input id="sectionOffice" name="llSubReport.sectionOffice" class="common" type="text" value='<s:property value="#request.llSubReportList[0].sectionOffice" />'></td>
			<td class="left">死亡日期：</td>
			<td class="right">
				<input id="dieDate" name="llSubReport.dieDate" class="common" type="text" style="width: 73%" value="<s:date name="#request.llSubReportList[0].dieDate" format="yyyy-MM-dd"/>" /><img style='cursor: hand' 
					align="middle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'dieDate',dieDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
			</td>
		</tr>
	</table>
	<table id="claimType" class="common" cellpadding="3" cellspacing="0">
		<tr>
			<td><jsp:include page="/claim/commonpage/ClaimType.jsp" /></td>
		</tr>
	</table>
	<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
		<tr>
			<td colspan="4">
				<input type="button" class="cssbutton" name="saveButton" value="保  存" onclick="saveClaimReportInfo()" />
				<input type="button" class="cssbutton" name="modifyButton" value="修  改" onclick="udpateClaimReportInfo();" />
			</td>
		</tr>
	</table>
  </div>
  </body>
</html>