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
    
    <title>报案信息录入</title>
    
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
	<div style="width:100%">
		<table id="RegisterInfor" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">审核管理</td>
			</tr>
			<tr>
				<td>分公司审核意见</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="BranchOpinion" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="RegisterInfor" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">审核人：</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
				<td class="left">审核日期：</td>
				<td class="right"><input name="ExamDate" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td class="left">审核结论：</td>
				<td class="right">
					<input class="codecode" id="auditCode" name="lcReport.auditCode" class="common" type="text" value="" style="width:20%"><input name="auditResult" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">案件标识：</td>
				<td class="right">
					<input class="codecode" id="caseCode" name="lcReport.caseCode" class="common" type="text" value="" style="width:20%" ><input name="caseFlag" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td class="left">特殊备注：</td>
				<td class="right"><input name="SpecialRemark" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<table id="RegisterInfor" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td>总公司审核意见</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="HeadquartOpinion" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="RegisterInfor" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">审核人：</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
				<td class="left">审核日期：</td>
				<td class="right"><input name="ExamDate" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td class="left">审核结论：</td>
				<td class="right">
					<input class="codecode" id="auditCode" name="lcReport.auditCode" class="common" type="text" value="" style="width:20%"><input name="auditResult" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">审核处理流向：</td>
				<td class="right">
					<input class="codecode" id="auditDealCode" name="lcReport.auditDealCode" class="common" type="text" value="" style="width:20%"><input name="auditDeal" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">案件标识：</td>
				<td class="right">
					<input class="codecode" id="caseCode" name="lcReport.caseCode" class="common" type="text" value="" style="width:20%" ><input name="caseFlag" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">特殊备注：</td>
				<td class="right"><input name="SpecialRemark" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="RegisterInfor" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">审批管理</td>
			</tr>
			<tr>
				<td>审批意见(包括符号最多700汉字)</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="BranchOpinion" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="RegisterInfor" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">审批人：</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
				<td class="left">审批日期：</td>
				<td class="right"><input name="ExamDate" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td class="left">审批结论：</td>
					<td class="right">
						<input class="codecode" id="approveCode" name="lcReport.approveCode" class="common" type="text" value="" style="width:20%" ><input name="approveResult" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
					</td>
				<td class="left">案件标识：</td>
				<td class="right">
					<input class="codecode" id="caseCode" name="lcReport.caseCode" class="common" type="text" value="" style="width:20%" ><input name="caseFlag" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>