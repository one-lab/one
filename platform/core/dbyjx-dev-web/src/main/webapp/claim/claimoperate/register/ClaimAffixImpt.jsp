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
    
	    <title>理赔案件附件录入</title>
	    
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
		<table id="RollAffixList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已经回销单证清单</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">序号</td>
					<td width="10%">单证代码</td>
					<td width="10%">单证名称</td>
					<td width="10%">是否必须</td>
					<td width="8%">单证件数</td>
					<td width="8%">缺少件数</td>
					<td width="10%">提交形式</td>
					<td width="10%">是否退还原件</td>
					<td width="15%">单证检查结论</td>
					<td width="15%">不齐全原因</td>
				</tr>
			</thead>
		</table>
		<hr />
		<table id="affixList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="11"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">待回销的单证清单</td>
				</tr>
				<tr class="tableHead">
					<td width="2%"><input type="checkbox" name="CheckBox" value="" disabled/></td>
					<td width="4%">序号</td>
					<td width="10%">单证代码</td>
					<td width="10%">单证名称</td>
					<td width="10%">是否必须</td>
					<td width="10%">单证件数</td>
					<td width="10%">缺少件数</td>
					<td width="10%">提交形式</td>
					<td width="10%">是否退还原件</td>
					<td width="10%">单证检查结论</td>
					<td width="14%">不齐全原因</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="checkbox" name="CheckBox" value="" /></td>
					<td>1</td>
					<td>CLM001</td>
					<td>保险合同正本</td>
					<td>0</td>
					<td>1</td>
					<td>0</td>
					<td>0</td>
					<td>1</td>
					<td>0</td>
					<td>0</td>
				</tr>
				<tr class="content">
					<td><input type="checkbox" name="CheckBox" value="" /></td>
					<td>1</td>
					<td>CLM002</td>
					<td>索赔申请书</td>
					<td>0</td>
					<td>1</td>
					<td>0</td>
					<td>0</td>
					<td>1</td>
					<td>0</td>
					<td>0</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="saveButton" value="保  存" onClick="" />
					<input type="button" class="cssbutton" name="returnButton" value="返  回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
		<hr />
	</div>
	</form>
</body>
</html>