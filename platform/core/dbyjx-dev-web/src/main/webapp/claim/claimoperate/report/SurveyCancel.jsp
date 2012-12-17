<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
    	<base href="<%=basePath%>">
    
	    <title>取消调查</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>
		<script type="text/javascript" src="${ctx}/claim/claimoperate/report/js/SurveyCancel.js"></script>

	</head>
<body>
	<form name="fm" method="post">
	<div style="width:100%">
		<table class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">该赔案已经发起的调查信息列表</td>
			</tr>
		</table>
		<table id="SurveyInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="15%">赔案号</td>
					<td width="15%">调查序号</td>
					<td width="15%">调查机构</td>
					<td width="15%">调查员</td>
					<td width="15%">调查原因</td>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="llInqApplyPage.result" var="llInqApply" status="index">
					<tr>
						<td><input type="radio" name="radio" value='<s:property value="#llInqApply.id.clmNo"/>,<s:property value="#llInqApply.id.inqNo"/>,<s:property value="#llInqApply.operator"/>'/></td>
						<td><s:property value="#index.count"/></td>
						<td><s:property value="#llInqApply.id.clmNo"/></td>
						<td><s:property value="#llInqApply.id.inqNo"/></td>
						<td><s:property value="#llInqApply.inqDept"/></td>
						<td><s:property value="#llInqApply.inqPer"/></td>
						<td>
							<s:if test="#llInqApply.inqRCode==01">医疗调查</s:if>
							<s:elseif test="#llInqApply.inqRCode==02">伤残调查</s:elseif>
							<s:elseif test="#llInqApply.inqRCode==03">死亡调查</s:elseif>
							<s:else>&nbsp;</s:else>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>
		<table id="SurveyCancelReson" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td >取消调查原因(包括符号最多500汉字)</td>
			</tr>
			<tr>
				<td colspan="4"><textarea id="inqCancel" name="llInqApply.inqCancel" cols="100%" rows="5" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="SurveyCancel" value="取消调查" onClick="cancelSurvey();" />
					<input type="button" class="cssbutton" name="returnButton" value="返  回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>