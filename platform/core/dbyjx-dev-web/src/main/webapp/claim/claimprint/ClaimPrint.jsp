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
    
	    <title>赔案打印</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>
	</head>
<body>
	<form name="fm" method="post" onKeyPress="KeyDown()">
	<div style="width:100%">
		<table id="ClaimInfoQuery" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">请输入查询条件(至少需要一个条件，其中选择赔案状态必须输入受理日期区间)：</td>
			</tr>
			<tr>
				<td class="left">赔案号：</td>
				<td class="right"><input name="ClaimNum" class="common" type="text" onChange="clickable()"></td>
				<td class="left">赔案状态：</td>
				<td class="right">
					<input class="codecode" id="claimStateCode" name="lcReport.claimStateCode" class="common" type="text" value="" style="width:20%" ><input name="claimState" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">合同号：</td>
				<td class="right"><input name="ContNum" class="common" type="text" onChange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">出险人编码：</td>
				<td class="right"><input name="AppntCode" class="common" type="text" onChange="clickable()"></td>
			
				<td class="left">出险人姓名：</td>
				<td class="right"><input name="AppntName" class="common" type="text" onChange="clickable()"></td>
				<td  class="left">事故日期：</td>
				<td class="right">
					<input name="AccidDate" id="AccidDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'AccidDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
			<tr>
				<td  class="left">出险日期：</td>
				<td class="right">
					<input name="AppDate" id="AppDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'AppDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td  class="left">立案日期：</td>
				<td class="right">
					<input name="RegisterDate" id="RegisterDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'RegisterDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td  class="left">结案日期：</td>
				<td class="right">
					<input name="EndDate" id="EndDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'EndDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
			<tr>
				<td class="left">团体赔案号：</td>
				<td class="right"><input name="UnitClaimNum" class="common" type="text" onChange="clickable()"></td>
				<td class="left">团体保单号：</td>
				<td class="right"><input name="UnitAppNum" class="common" type="text" onChange="clickable()"></td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
		</table>
		<table id="ClaimQuery" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "queryButton" value="查  询" onClick="" />
				</td>
			</tr>
		</table>
		<table id="ClaimTab" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">赔案列表</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="6%">序号</td>
					<td width="15%">赔案号</td>
					<td width="15%">状态</td>
					<td width="15%">出险人编码</td>
					<td width="15%">出险人姓名</td>
					<td width="10%">性别</td>
					<td width="15%">出险日期</td>
				</tr>
			</thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>
		<hr />
		<table id="ClaimInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "ClaimQuery" value="赔案查询" onClick="self.location.href='${ctx}/claim/claimoperate/endcase/EndCaseInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name = "printButton" value="赔案打印" onClick="self.location.href='${ctx}/claim/claimprint/ClaimAffixPrint.jsp'" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>