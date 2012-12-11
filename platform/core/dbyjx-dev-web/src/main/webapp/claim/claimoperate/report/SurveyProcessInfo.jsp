<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>调查过程信息</title>
    
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
  	<form name="fm" method="post" onkeypress="KeyDown()">
    <div style="width:100%">
		<table id="SurveyProcessInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">调查过程详细列表</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="12%">过程序号</td>
					<td width="12%">调查日期</td>
					<td width="10%">调查方式</td>
					<td width="15%">调查地点</td>
					<td width="10%">被调查人</td>
					<td width="15%">调查机构</td>
					<td width="10%">第一调查人</td>
					<td width="10%">操作人</td>
				</tr>
			</thead>
			<tbody id="inqCourseContent">
			</tbody>
		</table>
		<table id="SurveyAffixList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">调查过程单证信息列表</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">序号</td>
					<td width="15%">单证序号</td>
					<td width="11%">单证类型</td>
					<td width="15%">单证名称</td>					
					<td width="15%">原件标志</td>
					<td width="15%">张数</td>
					<td width="25%">备注信息</td>
				</tr>
			</thead>
			<tbody id="inqCertificateContent">
			</tbody>
		</table>
	</div>
	<div>
		<table id="SurveyFee" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">调查费用信息</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">序号</td>
					<td width="10%">报/赔案号</td>
					<td width="10%">调查序号</td>
					<td width="10%">调查机构</td>
					<td width="8%">费用类型</td>
					<td width="10%">费用金额</td>
					<td width="10%">发生时间</td>
					<td width="10%">领款人</td>
					<td width="8%">领款方式</td>
					<td width="20%">备注</td>
				</tr>
			</thead>
			<tbody id="inqFeeContent">
			</tbody>
		</table>
	</div>
	</form>
  </body>
</html>
