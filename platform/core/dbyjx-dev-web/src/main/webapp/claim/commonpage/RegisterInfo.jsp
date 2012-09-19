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
    	
	    <title>出险人基本信息列表</title>
	    
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
	<div id="appntInfo" style="width:100%">
		<table id="RegisterInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">立案信息</td>
			</tr>
			<tr>
				<td  class="left">事件号：</td>
				<td  class="right"><input name="accNO" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">赔案号：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">申请人姓名：</td>
				<td  class="right">
					<input name="RgtantName" class="common" type="text" onchange="clickable()">
				</td>
			</tr>
			<tr>
				<td  class="left">申请人电话：</td>
				<td  class="right">
					<input name="RgtantTel" class="common" type="text" onchange="clickable()">
				</td>
				<td  class="left">申请人地址：</td>
				<td  class="right">
					<input name="RgtantAddress" class="common" type="text" onchange="clickable()">
				</td>
				<td  class="left">申请人与出险人关系：</td>
				<td  class="right">
					<input class="codecode" id="relatshipCode" name="lcReport.relatshipCode" class="common" type="text" value="" style="width:20%" ><input name="relatship" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td  class="left">立案日期：</td>
				<td class="right">
					<input name="RegisterDate" class="common" type="text" onchange="clickable()">
				</td>
				<td  class="left">立案受理人：</td>
				<td  class="right"><input name="RgtAgent" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">管理机构：</td>
				<td  class="right">
					<input class="codecode" id="adminComCode" name="lcReport.adminComCode" class="common" type="text" value="" style="width:20%" ><input name="adminCom" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td  class="left">受托人类型：</td>
				<td  class="right"><input name="AgentType" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">受托人代码：</td>
				<td  class="right"><input name="AgentCode" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">受托人姓名：</td>
				<td  class="right"><input name="AgentName" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">受托人性别：</td>
				<td  class="right"><input name="AgentType" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">受托人电话：</td>
				<td  class="right"><input name="AgentTel" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">受托人地址：</td>
				<td  class="right"><input name="AgentAddress" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">受托人邮编：</td>
				<td  class="right"><input name="AgentZip" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">申请类型：</td>
				<td  class="right">
					<input class="codecode" id="applyCode" name="lcReport.applyCode" class="common" type="text" value="" style="width:20%" ><input name="applyType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="common"></td>
				<td  class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="ReportInfoList" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="AppntInfoList.jsp" /></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">出险人信息</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="PolQuery" value="保单查询" onclick="self.location.href='${ctx}/claim/claimoperate/register/PolicyQuery.jsp'" />
					<input type="button" class="cssbutton" name="ImageQuery" value="影像查询" onclick="" />
					<input type="button" class="cssbutton" name="PastClaimQuery" value="既往赔案查询" onclick="self.location.href='${ctx}/claim/claimoperate/register/PastClaimQuery.jsp'" />
				</td>
			</tr>
		</table>
		<table id="AppntInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">出险人姓名：</td>
				<td class="right"><input name="AppntName" class="common" type="text" onchange="clickable()"></td>
				<td class="left">出险人年龄：</td>
				<td class="right"><input name="AppntAge" class="common" type="text" onchange="clickable()"></td>
				<td class="left">出险人性别</td>
				<td class="right">
					<input class="codecode" id="appntCode" name="lcReport.appntCode" class="common" type="text" value="01" style="width:20%" ><input name="appntSex" class="common" type="text" onchange="clickable()" style="width:68%" value="男">
				</td>
			</tr>
			<tr>
				<td  class="left">事故日期：</td>
				<td class="right">
					<input name="accDate" id="accDate" class="common" type="text" onchange="clickable()" value='' /><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">出险日期：</td>
				<td class="right">
					<input name="AppntDate" id="AppntDate" class="common" type="text" onchange="clickable()" value='' /><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">联系电话：</td>
				<td class="right">
					<input name="Telephone" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">出险原因：</td>
				<td class="right">
					<input class="codecode" id="appntReasonCode" name="lcReport.appntReasonCode" class="common" type="text" value="" style="width:20%" ><input name="appntReason" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">出险地点：</td>
				<td class="right"><input name="AppPlace" class="common" type="text" onchange="clickable()"></td>
				<td class="left">治疗医院：</td>
				<td class="right">
					<input class="codecode" id="treatHospitalCode" name="lcReport.treatHospitalCode" class="common" type="text" value="" style="width:20%" ><input name="treatHospital" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td class="left">意外细节：</td>
				<td class="right">
					<input class="codecode" id="unexpectDetailCode" name="lcReport.unexpectDetailCode" class="common" type="text" value="" style="width:20%" ><input name="unexpectDetail" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">治疗情况：</td>
				<td class="right">
					<input class="codecode" id="treatStateCode" name="lcReport.treatStateCode" class="common" type="text" value="" style="width:20%" ><input name="treatState" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">出险结果1：</td>
				<td class="right">	
					<input class="codecode" id="CaseResult1Code" name="lcReport.CaseResult1Code" class="common" type="text" value="" style="width:20%" ><input name="CaseResult1" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">出险结果2：</td>
				<td class="right">	
					<input class="codecode" id="CaseResult2Code" name="lcReport.CaseResult2Code" class="common" type="text" value="" style="width:20%" ><input name="CaseResult2" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">住院科室：</td>
				<td class="right"><input name="HosDepart" class="common" type="text" onchange="clickable()"></td>
				<td class="left">单证齐全标识：</td>
				<td class="right">
					<input class="codecode" id="affixComplCode" name="lcReport.affixComplCodee" class="common" type="text" value="" style="width:20%" ><input name="affixComplFlag" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td class="left">案件标识：</td>
				<td class="right">
					<input class="codecode" id="caseCode" name="lcReport.caseCode" class="common" type="text" value="" style="width:20%" ><input name="caseFlag" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
		        <td class="left">死亡日期：</td>
				<td class="right"><input name="DeathDate" class="common" type="text" onchange="clickable()"></td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
		</table>
		<table id="claimType" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="ClaimType.jsp" /></td>
			</tr>
		</table>
		<hr />
	</div>
	</form>
</body>
</html>