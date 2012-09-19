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
    
	    <title>发起调查</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">ctx='${ctx}';</script>
		<script src="${ctx}/common/calender/WdatePicker.js"></script>
		<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
		<script src="${ctx}/claim/claimoperate/report/js/SurveyApply.js"></script>
		

	</head>
<body>
	<form id="inqApplyFm" method="post">
	<div style="width:100%">
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">发起调查</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "saveButton" value="保  存" onClick="saveLLInqApply();" />
					<input type="button" class="cssbutton" name = "returnButton" value="返  回" onClick="javascript:history.back();" />
				</td>
			</tr>
		</table>
		<table id="SurveyInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">报案号：</td>
				<td class="right"><input id="clmNo" name="llInqApply.id.clmNo" class="common" type="text" value="${llReport.rptNo }"></td>
				<td class="left">客户号码：</td>
				<td class="right"><input id="customerNo" name="llInqApply.customerNo" class="common" type="text" value="${llSubReport.id.customerNo }"></td>
				<td class="left">出险人姓名：</td>
				<td class="right"><input id="customerName" name="llInqApply.customerName" class="common" type="text" value="${llSubReport.customerName }"></td>
			</tr>
			<tr>
				<td class="left">调查员：</td>
				<td class="right">
					<input class="codecode" id="inqPer" name="llInqApply.inqPer" class="common" type="text" style="width:20%" ><input id="inqPerValue" name="llInqApply.inqPerValue" class="common" type="text" style="width:68%">
				</td>
				<td  class="left">调查原因：</td>
				<td  class="right">
					<input class="codecode" id="inqRCode" name="llInqApply.inqRCode" ondblclick="queryCode('inqRCode','inqRCodeValue','PDLDcode1','codeType:ClaimSearchReason')" type="text" style="width:20%"><input id="inqRCodeValue" name="llInqApply.inqRCodeValue" class="common" type="text" style="width:68%">
				</td>
				<td  class="left">调查机构：</td>
				<td  class="right">
					<input class="codecode" id="inqDept" name="llInqApply.inqDept" class="common" type="text" style="width:20%"><input id="inqDeptValue" name="llInqApply.inqDeptValue" class="common" type="text" style="width:68%">
				</td>
			</tr>
		</table>
		<table id="SurveyContent" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>调查内容(包括符号最多500汉字)</td>
			</tr>
			<tr>
				<td colspan="4" ><textarea id="inqItem" name="llInqApply.inqItem" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
			<tr>
				<td>备注信息(包括符号最多1000汉字)</td>
			</tr>
			<tr>
				<td colspan="4" ><textarea id="inqDesc" name="llInqApply.inqDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
	</div>
	</form>
	<br/>
	<form>
	<div style="width:100%">
		<table id="SurveyInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">该赔案已经发起的调查信息列表</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">报/赔案号</td>
					<td width="15%">调查序号</td>
					<td width="15%">出险人客户号</td>
					<td width="10%">出险人姓名</td>
					<td width="10%">发起机构</td>
					<td width="10%">调查原因</td>
					<td width="10%">调查机构</td>
					<td width="9%">调查状态</td>
				</tr>
			</thead>
			<tbody id="llInqApplyContent">
			<s:iterator value="llInqApplyPage.result" var="llInqApply" status="index">
				<tr class="content">
					<td><input type='radio' name='radio'></td>
					<td><s:property value="#index.count"/></td>
				    <td><s:property value="#llInqApply.id.clmNo" /></td>
					<td><s:property value="#llInqApply.id.inqNo" /></td>
					<td><s:property value="#llInqApply.customerNo" /></td>
					<td><s:property value="#llInqApply.customerName" /></td>
					<td>
						<s:if test="#llInqApply.initDeptValue!=null"><s:property value="#llInqApply.initDeptValue" /></s:if>
						<s:else>&nbsp;</s:else>
					</td>
					<td>
						<s:if test="#llInqApply.inqRCode!=null"><s:property value="#llInqApply.inqRCodeValue" /></s:if>
						<s:else>&nbsp;</s:else>
					</td>
					<td>
						<s:if test="llInqApply.inqDeptValue!=null"><s:property value="#llInqApply.inqDeptValue" /></s:if>
						<s:else>&nbsp;</s:else>
					</td>
					<td>
						<s:if test="#llInqApply.inqStateValue!=null"><s:property value="#llInqApply.inqStateValue" /></s:if>
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
	</div>
	</form>
</body>
</html>