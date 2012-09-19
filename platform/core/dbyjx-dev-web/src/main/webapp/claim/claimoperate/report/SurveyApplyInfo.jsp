<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>调查申请信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>

  </head>
  <body>
    <form name="fm" method="post">
	<div style="width:100%">
    <table id="SurveyApply" class="common" cellpadding="3" cellspacing="1">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">调查申请信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="20%">报/赔序号</td>
					<td width="20%">调查序号</td>
					<td width="17%">出险人姓名</td>
					<td width="17%">提起阶段</td>
					<td width="20%">调查原因</td>
				</tr>
			</thead>
			<tbody id="inqApplyContent">
			</tbody>
        </table>			
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "PrtSurReport" value="打印调查报告" onClick="" >
					<input type="button" class="cssbutton" name = "DownloadAffix" value="下载附件" onClick="" >
				</td>
			</tr>
		</table>
		<table id="SurveyApplyInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">调查申请详细信息</td>
			</tr>
			<tr>
				<td  class="left">报/赔案号：</td>
				<td  class="right"><input id="inqApplyClmNo" name="inqApply.clmNo" class="common" type="text"></td>
				<td  class="left">调查序号：</td>
				<td  class="right"><input id="inqApplyInqNo" name="inqApply.inqNo" class="common" type="text"></td>
				<td  class="left">完成标志：</td>
				<td  class="right"><input id="inqApplyInqStateValue" name="inqApply.inqStateValue" class="common" type="text"></td>
			</tr>
			<tr>
				<td  class="left">出险人姓名：</td>
				<td  class="right"><input id="inqApplyCustomerName" name="inqApply.customerName" class="common" type="text"></td>
				<td  class="left">调查申请人：</td>
				<td  class="right"><input id="inqApplyApplyPer" name="inqApply.applyPer" class="common" type="text"></td>
				<td  class="left">申请日期：</td>
				<td class="right">
					<input id="inqApplyApplyDate" name="inqApply.applyDate" class="common" type="text" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'applyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
			<tr>
				<td  class="left">提起阶段：</td>
				<td  class="right">
					<input class="codecode" id="inqApplyInitPhase" name="inqApply.initPhase" class="common" type="text" style="width:20%" ><input id="inqApplyInitPhaseValue" name="inqApply.initPhaseValue" class="common" type="text" style="width:68%">
				</td>
				<td  class="left">调查机构：</td>
				<td  class="right">
					<input class="codecode" id="inqApplyInqDept" name="inqApply.inqDept" class="common" type="text" style="width:20%"><input id="inqApplyInqDeptValue" name="inqApply.inqDeptValue" class="common" type="text" style="width:68%">
				</td>
				<td  class="left">发起机构：</td>
				<td  class="right">
					<input class="codecode" id="inqApplyInitDept" name="inqApply.initDept" class="common" type="text" style="width:20%"><input id="inqApplyInitDeptValue" name="inqApply.initDeptValue" class="common" type="text" style="width:68%">
				</td>
			</tr>
			<tr>
				<td  class="left">调查原因：</td>
				<td  class="right">
					<input class="codecode" id="inqApplyInqRCode" name="inqApply.inqRCode" class="common" type="text" style="width:20%"><input id="inqApplyInqRCodeValue" name="inqApply.inqRCodeValue" class="common" type="text" style="width:68%">
				</td>
				<td  class="left">本地标志：</td>
				<td  class="right"><input id="inqApplyLocFlagValue" name="inqApply.locFlagValue" class="common" type="text"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<table id="SurveyContent" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td>调查内容</td>
			</tr>
			<tr>
				<td colspan="4" ><textarea id="inqApplyInqItem" name="inqApply.inqItem" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
			<tr>
				<td>备注信息</td>
			</tr>
			<tr>
				<td colspan="4" ><textarea id="inqApplyInqDesc" name="inqApply.inqDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
	</div>
	</form>
</html>
