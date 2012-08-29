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
		<title>呈报查询结果</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript">ctx = "${ctx}";</script>
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>
		<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="${ctx}/prpall/group/proposalPre/ProposalPreApply.js"></script>	
	</head>
	
	<body>
	
		<form name="fm" method="post">
			<table id="ReportQueryResultInfo" class="common" cellpadding="3" cellspacing="0">
				<thead>
				<tr>
			      <td class="formtitle" colspan="6"><img
				  src="${ctx}/images/bgformtitle.gif" style="cursor: hand;">呈报查询结果</td>
		        </tr>
					<tr class="tableHead">
					   <td width="3%">&nbsp;</td>
						<td width="5%">序号</td>
						<td width="5%">呈报序列号</td>
						<td width="10%">呈报申请号</td>
						<td width="20%">单位名称</td>
						<td width="10%">管理机构</td>
						<td width="10%">申请人</td>
						<td width="10%">申请日期</td>
						<td width="10%">呈报结论</td>
						<td width="30%">呈报意见</td>
					</tr>
					</thead>
					<tbody>
						<c:if test="${findResult !=null }">
						   <c:forEach items="${findResult }" var="report" varStatus="s">
						   	<tr class="content">
							 <td><input name="radioRepNo" type="radio" value="${report.repNo}"/></td>
							 <td>${s.count }</td>
							 <td>${report.serialNo}</td>
							 <td>${report.repNo}</td>
							 <td>${report.name}</td>
							 <td>${report.manageCom}</td>
							 <td>${report.repOperator}</td>
							 <td>${report.repApplyDate}</td>
							 <td>${report.result}</td>
							 <td>${report.repAuditIdea}</td>
							</tr>
						   </c:forEach>
						</c:if>  
					</tbody>
				</table>
			<input type = "button" class="cssbutton" value="返  回" onclick="reportReturn()" >
			<table>
				<tr>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
				</tr>
			</table>
			<!-- 隐藏域客户号 -->
			<input type="hidden" id="CustomerNo" name="客户号" >
		</form>
	</body>
</html>