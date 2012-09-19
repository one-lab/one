<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.*"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>精算审核申请</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>
		<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
		<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
		<script type="text/javascript">
		//根路径
		var ctx = "${ctx}";
		//查询呈报审核信息
		function findActuarialReport(){
			var findUrl=contextRootPath + "/prpall/findActuarialReport.do";
			$("#fmActuarialAudit").attr("action",findUrl).submit();
		}
		
		function findAuditIdea(){
			//判断是否选中一条呈报申请记录
			if(null==$('input:radio[name="radioRepNo"]:checked').val()
			   ||undefined==$('input:radio[name="radioRepNo"]:checked').val()){
			   alert("请选择一条核保订正记录进行订正！");
			   return false;
			}
			var findAuditIdeaUrl = contextRootPath + "/prpall/findReportIdea.do?lcActuarialAudit.id.repNo=" + $('input:radio[name="radioRepNo"]:checked').val();
			$("#fmActuarialAudit").attr("action",findAuditIdeaUrl).submit();
		}
		
		</script>
	</head>
	
	<body>
		<form id="fmActuarialAudit" name="fm" method="post" >
			<table  class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">呈报申请信息</td>
				</tr>
				<tr>
					<td class="left">呈报号：</td>
					<td class="right"><input id="repNo" name="lcReport.repNo" class="common" type="text" value="${lcReport.repNo }"></td>
					<td class="left">呈报人：</td>
					<td class="right"><input id="repOperator" name="lcReport.repOperator" class="common" type="text" value="${lcReport.repOperator }"></td>
					<td class="left">单位名称：</td>
					<td class="right"><input id="name1" name="lcReport.name" class="common" type="text" value="${lcReport.name }"></td>					
				</tr>				
				<tr> 
					<td class="left">呈报机构：</td>
					<td class="right">
					<input type="hidden" id="upperComCode" value='2110200000' />
					<input id="comCode" name="lcReport.manageCom" class="codecode" type="text" 
					ondblclick="queryCode('comCode','comName','PrpDcompany','comCode:comCode|upperComCode:upperComCode')" style="width:20%" 
					value='<s:if test="#request.manageCom==null" ><s:property value="#session.prpDcompany.comCode"/></s:if><s:else><s:property value="#request.manageCom"/></s:else>'/><input id='comName' name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value='<s:property value="#session.prpDcompany.comCName"/>' ><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
					<td class="left">呈报日期：</td>
					<td class="right">
						<input name="lcReport.repApplyDate" id="repApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='<s:if test="#request.repApplyDate==null" ><%= new SimpleDateFormat("yyyy-MM-dd").format(new Date())%></s:if><s:else><s:date name="#request.repApplyDate" format="yyyy-MM-dd"/></s:else>'>
						<img style='cursor: hand' align="middle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'repApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td colspan="6">
						<input type="button" class="cssbutton" name="queryButton" value="查  询" onClick="findActuarialReport();">
					</td>
				</tr>
			</table>
			<table id="ReportCompanyInfo" class="common" cellpadding="3" cellspacing="0">
				<thead>
					<tr>
						<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">呈报审核信息</td>
					</tr>
					<tr class="tableHead">
						<td width="3%">&nbsp;</td>
						<td width="7%">序号</td>
						<td width="15%">呈报号</td>
						<td width="15%">呈报人</td>
						<td width="15%">呈报机构</td>
						<td width="15%">呈报日期</td>
						<td width="30%">单位名称</td>
					</tr>
				</thead>
				<tbody id="content">
					<s:iterator value="page.result" var="temp" status="tempStatus">
							<tr class="content">
								<td ><input name="radioRepNo" type="radio" value='<s:property value="#temp.repNo"/>' /></td>
								<td ><s:property value="#tempStatus.count"/></td>
								<td ><s:property value="#temp.repNo"/></td>
								<td ><s:property value="#temp.repOperator"/></td>
								<td ><s:property value="#temp.manageCom"/></td>
								<td ><s:property value="#temp.repApplyDate"/></td>
								<td ><s:property value="#temp.name"/></td>
							</tr>
					</s:iterator>
				</tbody>
			</table>
			<div id="pageDiv" align="right">
				<jsp:include page="/common/pub/page.jsp"></jsp:include>
			</div>	
			<!-- 
			<table>
				<tr>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
				</tr>
			</table>
			 -->
			<table>
				<tr>
					<td colspan="6">
						<input type="button" class="cssbutton" name="queryButton" value="进入精算审核" onClick="findAuditIdea()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
