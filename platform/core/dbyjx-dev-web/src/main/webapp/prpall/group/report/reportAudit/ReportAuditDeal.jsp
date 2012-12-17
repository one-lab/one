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
    
    <title>呈报审核处理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="common/js/SimpleCalendar.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/report/js/ReportAudit.js"></script>
  </head>
  <body>
    <form name="fm" method="post" >
	<div id="prpallInfo" style = "width:100%">
		<table id="prpallInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="/prpall/group/report/reportInput/ReportAdd.jsp" /> </td>
			</tr>
		</table>
	</div>
	<div>
		<table id="reportInfoTable" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td colspan="6" class="formtitle"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">   审核信息</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="10%">审核人</td>
					<td width="10%">审核结论</td>
					<td width="30%">审核意见</td>
					<td width="10%">审核时间</td>
				</tr>
			</thead>
			<%-- # 和ActionContent等价 --%>
			<tbody id="reportInfoBody">
				<s:if test="lcReportAuditList!= null">
					<s:iterator value="lcReportAuditList"  var="lcReportAudit" status="s">
						<s:if test="#lcReportAudit.result!=null">
						<tr class="content">
							<td width="5%"> <s:property value="#s.index"/> </td>
							<td width="10%"><s:property value="#lcReportAudit.repauditoperator"/></td>
							<td width="10%"><s:property value="#lcReportAudit.result"/></td>
							<td width="30%"><s:property value="#lcReportAudit.repauditidea"/></td>
							<td width="10%"><s:property value="#lcReportAudit.makeDate"/></td>
						</tr>
						</s:if>
						<s:else>
							<input type="hidden" id="auditSerialNo" value='<s:property value="#lcReportAudit.id.serialNO"/>' />
						</s:else>
					</s:iterator>
				</s:if>
			</tbody>
			</table>
	</div>
	<s:debug></s:debug>
	<div id="reportAuditInfo" style = "width:100%">
		<table id="auditIdeas" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" >审核意见（500字以内，回车符占一个字节）</td>
			</tr>
			<tr>
				<td colspan="6"><textarea id="idea" name="" cols="100%" rows="5"></textarea></td>
			</tr>
		</table>
		<table id="ResultInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="10%" align='left'>核保结论</td>
				<td width="15%" align='left'><input id="result" name="result" class="codecode"	id="comCode" type="text" ondblclick="queryCode('result','resultName','PrpDcompany','comCode:comCode');"
			style="width: 20%" id="comCode"	value=''><input	id="resultName" name="resultName" class="common" type="text"style="width: 68%"><img src="${ctx }/images/bgMarkMustInput.jpg" ></td>
				<td width="75%" align='left'><input type="button" class="cssbutton" name="Confirm" value="确  认" onclick="reportAuditCommit()"/></td>
			</tr>
		</table>
		<hr>
		<table id="searchInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" align="left">
					<input type="button" class="cssbutton" name = "OpenPrpallSearch" value="精算审核" onclick="">
					<input type="button" class="cssbutton" name = "FindPrpallMess" value="再保审核" onclick="">				
					<input type="button" class="cssbutton" name = "OpenPrpallSearch" value="发起契调" onclick="openPrpallSearch()">
					<input type="button" class="cssbutton" name = "FindPrpallMess" value="查看契调信息" onclick="findPrpallMessage()">
					<input type="button"  name="returnButton" class="cssbutton" value="返  回" onclick="javascript:history.go(-1);">
				</td>
				
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
