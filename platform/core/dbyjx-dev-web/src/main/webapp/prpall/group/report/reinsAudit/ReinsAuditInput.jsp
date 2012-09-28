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
    
    <title>再保审核处理</title>
    
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
	     ctx = "${ctx}";
    </script>
	<script src="${ctx}/prpall/group/report/reinsAudit/ReinsAuditInput.js"></script>
  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div id="prpallInfo" style = "width:100%">
		<table id="prpallInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../reportInput/ReportAdd.jsp" /> </td>
			</tr>
		</table>
	</div>
	<div id="reportAuditInfo" style = "width:100%">
		<table id="ReportCompanyInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">呈保审核信息</td>
				</tr>
				<tr class="tableHead">
					<td width="7%">序号</td>
					<td width="23%">审核人</td>
					<td width="47%">审核意见</td>
					<td width="23%">审核时间</td>
				</tr>
			</thead>
			<tbody id="contentReinsAuditList">
				<s:iterator value="#request.lcReinsAudits" var="temp" status="tempStatus">
					<tr class="content">
						<td><s:property value="#tempStatus.count"/></td>
						<td><s:property value="#temp.repAuditOperator"/></td>
						<td><s:property value="#temp.repAuditIdea"/></td>
						<td><s:property value="#temp.modifyDate"/></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<table id="auditIdeas" class="common" cellpadding="3" cellspacing="0">
			
			<tr>
				<td colspan="6" >审核意见（500字以内，回车符占一个字节）<input id="reinsAuditrepNo" name="lcReinsAudit.repNo" type="hidden" value="<c:out value="${repNo }"></c:out>"></input></td>
			</tr>
			<tr>
				<td colspan="6"><textarea id="repAuditIdea" name="lcReinsAudit.repAuditIdea" cols="100%" rows="5" witdh=100%></textarea></td>
			</tr>
		</table>
		 
		<table id="ResultInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="75%" align='left'><input id="saveAuditIdea" type="button" class="cssbutton" name="Confirm" value="确  认" onclick="saveAuditResultAndIdea()"/></td>
			</tr>
		</table>
		
		<hr>
		<table id="searchInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" align="left">
					<input type="button" class="cssbutton" name = "OpenPrpallSearch" value="确  认" onclick="">
					<input type="button"  name="returnButton" class="cssbutton" value="返  回" onclick="javascript:history.go(-1);"></td>
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
