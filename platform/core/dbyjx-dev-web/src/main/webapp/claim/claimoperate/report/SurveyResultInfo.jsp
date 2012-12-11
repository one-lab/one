<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>调查结论信息</title>
    
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
  	<div>
		<table id="SurveyResultInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">调查结论详细信息</td>
			</tr>
			<tr>
				<td  class="left">报/赔案号：</td>
				<td  class="right"><input id="inqConClusionClmNo" name="llInqConclusion.clmNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">调查序号：</td>
				<td  class="right"><input id="inqConClusionConNo" name="llInqConclusion.conNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">调查机构：</td>
				<td  class="right"><input id="inqConClusionInqDept" name="llInqConclusion.inqDept" class="common" type="text" onchange="clickable()"></td>
			</tr>
		</table>
		<table id="SurveyResult" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td>调查结论</td>
			</tr>
			<tr>
				<td colspan="4" ><textarea id="inqConclusionConclusion" name="llInqConclusion.inqConclusion" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
			<tr>
				<td>备注</td>
			</tr>
			<tr>
				<td colspan="4" ><textarea id="inqConclusionremark" name="llInqConclusion.remark" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
