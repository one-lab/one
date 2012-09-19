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
    <title>告知单信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript">ctx = "${ctx}";</script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/report/js/ReportAdd.js"></script>
  </head>
<table id="PremInfo" class="common" cellpadding="3" cellspacing="0">
	<thead>
		<tr>
			<td colspan="1" align='right'>保单付费方式 ：</td>
			<td colspan="5" align='left'><input id="premClearingForm"
				name="lcGrpContReport.premClearingForm" type="checkbox" value="1"
				checked="checked" />投保单位全额负担</td>
		</tr>
		<tr>
			<td class="left">单位负担（%）：</td>
			<td class="right"><input id="unitsBurden"
				name="lcGrpContReport.unitsBurden" class="common" type="text"
				value="10"><img src="${ctx}/images/bgMarkMustInput.jpg"></td>
		</tr>
		<tr>
			<td class="left">特定约定编码</td>
			<td class="right"><input id="specNo"
				name="lcGrpContReport.specNo" class="common" type="text"
				value="10001"><img src="${ctx}/images/bgMarkMustInput.jpg"></td>
		</tr>
		<tr>
			<td colspan="6">特定约定内容</td>
		</tr>
		<tr>
			<td colspan="6"><textarea id="specNoName"
				name="lcGrpContReport.specNoName" cols="" rows="4">约定内容</textarea></td>
		</tr>
		<tr>
			<td class="formtitle" colspan="6"><img
				src="${ctx}/images/bgformtitle.gif" style="cursor: hand;">
			投保单告知书</td>
		</tr>
		<tr class="tableHead">
			<td width="5%">序号</td>
			<td width="10%">告知版别</td>
			<td width="10%">告知内容编号</td>
			<td width="30%">告知内容</td>
			<td width="40%">录入信息</td>
			<td width="5%">&nbsp;</td>
		</tr>
	</thead>
	<tbody id="PremInfoBody">
	<!--<tr class="content">
			<td width="5%">0<input type="hidden" name="lcRepInfoList[0].id.subSerialNo"/></td>
			<td width="10%"><input type='text'
				name='lcRepInfoList[0].id.impartVer' maxlength='5' size='5'
				value="001" /><img src='${ctx}/images/bgMarkMustInput.jpg'></td>
			<td width="10%"><input type='text'
				name='lcRepInfoList[0].id.impartCode' maxlength='4' size='4'
				value="1001" /><img src='${ctx}/images/bgMarkMustInput.jpg'></td>
			<td width="30%"><input type='text'
				name='lcRepInfoList[0].impartDetailContent' size='50' value="告知书" /><img
				src='${ctx}/images/bgMarkMustInput.jpg'></td>
			<td width="40%"><input type='text'
				name='lcRepInfoList[0].message' size='50' value="录入信息" /></td>
			<td width="5%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>  -->
		
	</tbody>
	<tr>
		<td><input type="button" value="+" onclick="addPremInfo()" id="addRepInfoButton"/></td>
	</tr>

	<tr>
		<td colspan="6">同业竞争状况</td>
	</tr>
	<tr>
		<td colspan="6"><textarea id="competitionStatus"
			name="lcRepInfoReportDetail.competitionStatus" cols="100%" rows="5">竞争状况</textarea></td>
	</tr>
	<tr>
		<td colspan="6">被保险人情况</td>
	</tr>
	<tr>
		<td colspan="6"><textarea id="insurStatus"
			name="lcRepInfoReportDetail.insurStatus" cols="100%" rows="5">被保险人情况</textarea></td>
	</tr>
	<tr>
		<td colspan="6">既往理赔史</td>
	</tr>
	<tr>
		<td colspan="6"><textarea id="clmHistory"
			name="lcRepInfoReportDetail.clmHistory" cols="100%" rows="5">既往理赔史</textarea></td>
	</tr>
	<tr>
		<td colspan="6">保单相关情况及服务要求</td>
	</tr>
	<tr>
		<td colspan="6"><textarea id="conStatusAndServ"
			name="lcRepInfoReportDetail.conStatusAndServ" cols="100%" rows="5">保单相关情况及服务要求</textarea></td>
	</tr>
	<tr>
		<td colspan="6">
		<input type="button" class="cssButton" id="baseSaveButton"	name="SubmitButton" value="保  存" onClick="saveBaseInfo()"> 
		<input type="button" class="cssButton" name="UpdateButton" value="修  改" onClick="updateBaseInfo()"></td>
	</tr>
</table>
</html>