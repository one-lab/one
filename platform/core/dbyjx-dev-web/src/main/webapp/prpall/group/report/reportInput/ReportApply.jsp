<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<title>呈报录入任务申请</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript">ctx = "${ctx}";</script>
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>
		<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
		<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
		<script type="text/javascript" src="${ctx}/prpall/group/report/js/ReportApply.js"></script>
	</head>
	
	<body>
		<form name="fm" id="fmReportList" method="post">
			<table id="ReportCompanyInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td><input type="button" class="cssbutton" name="AddButton" value="新增呈报件" onClick="self.location.href='${ctx}/prpall/group/report/reportInput/ReportAdd.jsp?reoNo='"></td>
				</tr>
			</table>
			<div style="width:80%">
			<table  class="common" cellpadding="3" cellspacing="0">
				<tr> 
					<td class="left">管理机构：</td>
					<td class="right">   
					<input type="hidden" id ="upperComCode" value='${prpDcompany.comCode}'/>                                        <!-- code_CodeSelect(this,'DamageCode',-1,'Y','N','','',''); field, codeType, codeRelation, isClear, isQueryCode, otherCondition, callBackMethod, getDataMethod -->
					<input id="comCode" name="lcReport.manageCom" class="codecode" type="text" ondblclick="queryCode('comCode','comName','PrpDcompany','comCode:comCode|upperComCode:upperComCode')" style="width:20%"  value="${conditionCom == null ? prpDcompany.comCode : conditonCom}" />
					<input id='comName' name="comName" class="common" type="text" style="width:68%" value='${prpDcompany.comCName}' >
					<img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
					<td class="left">申请日期：</td>
					<td class="right">
                        <c:set var="repApplyDate" value='<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>'/>
                        <c:if test="${conditonRepApplyDate != null}">
                            <c:set var="repApplyDate" value='<%=new SimpleDateFormat("yyyy-MM-dd").format(request.getAttribute("conditonRepApplyDate"))%>' />
                        </c:if>
						<input id="applyDate" name="lcReport.repApplyDate" class="common" type="text" style="width:73%" value = "${repApplyDate}" />
						<img style='cursor: hand' align="middle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'applyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
					</td>
				</tr>
				<tr>
					<td class="left">呈报申请号：</td>
					<td class="right"><input id="repNo" name="lcReport.repNo" class="common" type="text" value='${conditonRepNo}' ></td>
					<td class="left">单位名称：</td>
					<td class="right"><input id="grpName" name="ldGrp.grpName" class="common" type="text" value='${conditonGrpName}'></td>
					<input type="hidden" name="pageNo" id="pageNo" value="${pageNo==null ? 1 : pageNo}" /> 
                    <input type="hidden" name="pageSize" value="${pageSize==null ? 20 : pageSize}" >
				</tr>
			</table>
            </div>
			<table>
				<tr>
					<td colspan="6">
						<input type="button" class="cssbutton" name="queryButton" value="查  询" onClick="findApplingReport()">

					</td>
				</tr>
			</table>
			<table id="ReportCompanyInfo" class="common" cellpadding="3" cellspacing="0">
				<thead>
					<tr class="tableHead">
						<td width="3%">&nbsp;</td>
						<td width="7%">序号</td>
						<td width="20%">呈报申请号</td>
						<td width="10%">管理机构</td>
						<td width="10%">申请人</td>
						<td width="10%">申请日期</td>
						<td width="30%">单位名称</td>
						<td width="10%">状态</td>
					</tr>
				</thead>
				<tbody id="content">
				    <c:forEach items="${page.result}" var="temp" varStatus="index">
                        <tr class="content" >
                            <td width="3%"><input name='radioRepNo' type='radio' value="${temp.repNo}"/></td>
                            <td width="7%">${index.count}</td>
                            <td width="20%">${temp.repNo}</td>
                            <td width="10%">${temp.manageCom}</td>
                            <td width="10%">${temp.repOperator}</td>
                            <td width="10%">${temp.repApplyDate}</td>
                            <td width="30%">${temp.grpName}</td>
                            <td width="10%">${temp.state}</td>
                        </tr>
				    </c:forEach>
				</tbody>
			</table>
			<div id="pageDiv" align="right">
				<jsp:include page="/common/pub/page.jsp"></jsp:include>
			</div>	
			<input type="button" class="cssbutton" name="InsertButton" value="开始录入" onclick="reportInput()">
			<input type="button" class="cssbutton" name="queryButton" value="删  除" onClick="deleteReport()">
		</form>
	</body>
</html>