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
    
    <title>预估金额试算信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx }/claim/claimoperate/report/js/PayInfo.js"></script>
	
  </head>
  
  <body>
  <div style="width:1000ps">
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="4">
					<input type="button" class="cssbutton" name="startSurvey" value="发起调查" onClick="findLLInqApplyByRptNoInsuredNo();" />
					<input type="button" class="cssbutton" name="accessSurvey" value="查看调查" onclick="findLLInqApplyByRptNoInsuredNoTwo();" />
					<input type="button" class="cssbutton" name="CancelSurvey" value="取消调查" onclick="findLLInqApplyByRptNoInsuredNoThree();" />
				</td>
			</tr>
		</table>
		<table id="PayInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td><input type="button" class="cssbutton" name="moneyCalculation" value="预估金额试算" onclick="" /></td>
				</tr>
				<tr>
					<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">预估金额试算结果</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">序号</td>
					<td width="32%">出险人姓名</td>
					<td width="32%">赔付类型</td>
					<td width="32%">预估赔付金额</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>马布</td>
					<td>附加意外伤害医疗保险(0601)</td>
					<td>5000</td>
				</tr>
			  </tbody>
		</table>
		<hr />
		<table id="RiskInfor" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "ReportStart" value="发起呈报" onclick="reportApply();">
				</td>
			</tr>
		</table>
	</div>
	<hr />
	<div style="width:1000ps">
		<table id="RiskInfor" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "sureButton" value="报案确认" onclick="">
					<input type="button" class="cssbutton" name = "returnButton" value="返  回" onclick="javascript:history.back();">
				</td>
			</tr>
		</table>
	</div>
	</body>
</html>