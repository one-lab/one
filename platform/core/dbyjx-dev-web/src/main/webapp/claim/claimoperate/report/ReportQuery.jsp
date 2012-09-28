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
    <title>报案查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">ctx = "${ctx}";</script>
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/claim/claimoperate/report/js/ReportQuery.js"></script>
	

</head>
<body>
	<form id="frmReportQuery" name="frmReportQuery" method="post">
	<div style="width:100%">
		<table id="reportInfoQuery" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">报案信息查询</td>
			</tr>
			<tr>
				<td class="left">报案号：</td>
				<td class="right"><input id="rptNo" name="llReport.rptNo" class="common" type="text" value='<s:property value="#request.llReport.rptNo" />' /></td>
				<td class="left">报案人姓名：</td>
				<td class="right"><input id="rptorName" name="llReport.rptorName" class="common" type="text" value='<s:property value="#request.llReport.rptorName" />' /></td>
				<td class="left">保单号：</td>
				<td class="right"><input id="polNo" name="llSubReport.polNo" class="common" type="text" value='<s:property value="#request.llSubReport.polNo" />' /></td>
			</tr>
			<tr>
				<td class="left">出险人姓名：</td>
				<td class="right"><input id="customerName" name="llSubReport.customerName" class="common" type="text" value='<s:property value="#request.llSubReport.customerName" />' /></td>
				<td  class="left">出险人证件类型：</td>
				<td  class="right">
					<input class="codecode" id="IDType" name="llSubReport.idType" type="text" style="width:20%" value='<s:property value="#request.llSubReport.idType" />' ondblclick="queryCode('IDType','IDTypeValue','PDLDcode1','codeType:IDType')" /><input id="IDTypeValue" name="llSubReport.idTypeValue" class="common" type="text" style="width:68%" value='<s:property value="#request.llSubReport.idTypeValue" />' />
				</td>
				<td  class="left">出险人证件号码：</td>
				<td  class="right"><input id="IDNo" name="llSubReport.idNo" class="common" type="text" value='<s:property value="#request.llSubReport.idNo" />' /></td>
			</tr>
			<tr>
				<td class="left">报案日期(起始)：</td>
				<td class="right">
					<input id="rptStartDate" name="rptStartDate" class="common" type="text" style="width: 73%" value="<s:date name="#request.rptStartDate" format="yyyy-MM-dd"/>" /><img style='cursor: hand' 
						align="middle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'rptStartDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="left">报案日期(结束)：</td>
				<td class="right">
					<input id="rptEndDate" name="rptEndDate" class="common" type="text" style="width: 73%" value="<s:date name="#request.rptEndDate" format="yyyy-MM-dd"/>" /><img style='cursor: hand' 
						align="middle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'rptEndDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td  class="common"></td>
				<td  class="common"></td>
			</tr>
			<tr>
				<td class="left">出险日期(起始)：</td>
				<td class="right">
					<input id="appntStartDate" name="appntStartDate" class="common" type="text" style="width: 73%" value="<s:date name="#request.appntStartDate" format="yyyy-MM-dd"/>" /><img style='cursor: hand' 
						align="middle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'appntStartDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="left">出险日期(结束)：</td>
				<td class="right">
					<input id="appntEndDate" name="appntEndDate" class="common" type="text" style="width: 73%" value="<s:date name="#request.appntEndDate" format="yyyy-MM-dd"/>" /><img style='cursor: hand' 
						align="middle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'appntEndDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td  class="common"></td>
				<td  class="common"></td>
				<input type="hidden" name="pageNo" id="pageNo" value="${pageNo==null ? 1 : pageNo}" /> 
                <input type="hidden" name="pageSize" value="${pageSize==null ? 20 : pageSize}" >				
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "queryButton" value="查  询" onClick="findClaimReport()" />
					<input type="button" class="cssbutton" name = "addButton" value="新增报案" onClick="self.location.href='${ctx}/claim/claimoperate/report/ReportAdd.jsp?rptNo='" />
				</td>
			</tr>
		</table>
		<br />
		<table id="ReportInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">工作队列</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="20%">报案号</td>
					<td width="14%">报案人姓名</td>
					<td width="14%">报案日期</td>
					<td width="10%">出险人姓名</td>
					<td width="12%">性别</td>
					<td width="12%">出险日期</td>
					<td width="12%">报案状态</td>
				</tr>
			</thead>
			<tbody id="content">
					<s:iterator value="page.result" var="temp" status="index">
					 	<tr class="content" >
						 	<td width="2%"><input name='radioRptNo' type='radio' value="<s:property value='#temp.rptNo'/>"/></td>
							<td width="4%"><s:property value="#index.count"/></td>
							<td width="20%"><s:property value="#temp.rptNo"/></td>
							<td width="14%"><s:property value="#temp.rptorName"/></td>
							<td width="14%"><s:date name="#temp.rptDate" format="yyyy-MM-dd" /></td>
							<td width="10%"><s:property value="#temp.customerName"/></td>
							<td width="12%"><s:property value="#temp.sexValue"/></td>
							<td width="14%"><s:date name="#temp.accidentDate" format="yyyy-MM-dd" /></td>
							<td width="12%"><s:property value="#temp.avaiFlagValue"/></td>
						</tr>
					</s:iterator>
				</tbody>
		</table>
		<div id="pageDiv" align="right">
			<jsp:include page="/common/pub/page.jsp"></jsp:include>
		</div>	
		<table id="addReport" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="modifyButton" value="报案处理" onClick="findReportInfo()" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>