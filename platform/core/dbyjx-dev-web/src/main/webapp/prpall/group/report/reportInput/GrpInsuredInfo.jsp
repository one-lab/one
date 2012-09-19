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
    
    <title>集体保单被保人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript">ctx = "${ctx}";</script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/report/js/ReportAdd.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#GrpInsurDetailInfoDiv").toggle();
	});
	</script>
  </head>
  
<div style="width: 100%">
<table id="GrpInsurInfor" class="common" cellpadding="3" cellspacing="0">
	<thead>
		<tr>
			<td class="formtitle" colspan="6"><img
				src="${ctx}/images/bgformtitle.gif" style="cursor: hand;">
			集体保单被保人信息</td>
		</tr>
		<tr class="tableHead">
			<td width="3%">&nbsp;</td>
			<td width="4%">序号</td>
			<td width="20%">类别</td>
			<td width="20%">类别名称</td>
			<td width="20%">数值</td>
			<td width="15%">投保人数</td>
			<td width="15%">人数占比</td>
			<td width="3%">&nbsp;&nbsp;</td>
		</tr>
	</thead>
	<tbody id="GrpInsurInforBody">
	</tbody>
</table>
<div><input type="button" value="+" onclick="addGrpInsurInfor()" /></div>
<br>
</div>
<div style="width: 100%">
<table id="GrpInsurInfor" class="common" cellpadding="3" cellspacing="0">
	<tr>
		<td class="left">被保人最大年龄：</td>
		<td class="right"><input name="insurMaxAge" class="common"
			id="insurMaxAge" type="text" /><img
			src="${ctx}/images/bgMarkMustInput.jpg"></td>
		<td class="left">被保人最小年龄：</td>
		<td class="right"><input name="insurMinAge" class="common"
			id="insurMinAge" type="text" /><img
			src="${ctx}/images/bgMarkMustInput.jpg"></td>
		<td class="left">被保人平均年龄：</td>
		<td class="right"><input name="insurAverAge" class="common"
			id="insurAverAge" type="text" /><img
			src="${ctx}/images/bgMarkMustInput.jpg"></td>
	</tr>
</table>
<br>
<hr>
</div>
<div style="width: 100%" id="GrpInsurDetailInfoDiv">
<table id="GrpInsurDetailInfor" class="common" cellpadding="3"
	cellspacing="0">
	<thead>
		<tr>
			<td colspan="6" class="formtitle"><img
				src="${ctx}/images/bgformtitle.gif" style="cursor: hand;">
			集体保单被保人详细信息</td>
		</tr>
		<tr class="tableHead">
			<td width="5%">序号</td>
			<td width="9%">保障计划编码</td>
			<td width="9%">险种信息</td>
			<td width="9%">责任信息</td>
			<td width="9%">性别</td>
			<td width="9%">职业类别</td>
			<td width="9%">最小年龄</td>
			<td width="9%">最大年龄</td>
			<td width="9%">保费（每人）</td>
			<td width="9%">标准保费（每人）</td>
			<td width="9%">费率折扣</td>
		</tr>
	</thead>
	<tbody>
	</tbody>
	<div>
	<table>
		<tr>
			<td width="45%" align='right'><input type="button"
				class="cssbutton" value="首  页"></td>
			<td width="5%"><input type="button" class="cssbutton"
				value="上一页"></td>
			<td width="5%"><input type="button" class="cssbutton"
				value="下一页"></td>
			<td width="45%"><input type="button" class="cssbutton"
				value="尾  页"></td>
		</tr>
	</table>
	</div>
</table>
</div>
<div style="width: 100%">
<table id="MoneyInfor" class="common" cellpadding="3" cellspacing="0">
	<tr>
		<td class="left">整单保费：</td>
		<td class="right"><input name="Prem" class="common" type="text" /><img
			src="${ctx}/images/bgMarkMustInput.jpg"></td>
		<td class="left">整单保费折扣：</td>
		<td class="right"><input name="Discount" class="common"
			type="text" /><img src="${ctx}/images/bgMarkMustInput.jpg"></td>
		<td class="left">整单费用率：</td>
		<td class="right"><input name="PremRate" class="common" type="text" /><img
			src="${ctx}/images/bgMarkMustInput.jpg"></td>
	</tr>
	<tr>
		<td colspan="6"><input type="button" class="cssbutton"
			name="saveButton" value="保  存" onclick="saveGrpInsurInfor()" /> <input
			type="button" class="cssbutton" name="updateButton" value="修  改"
			onclick="saveGrpInsurInfor()" /></td>
	</tr>
</table>
<hr>
</div>
</html>