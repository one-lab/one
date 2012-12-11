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
    
	    <title>立案信息查询</title>
	    
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
	<div id="registerQuery" style="width:100%">
		<table id="QueryCondition" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">请输入查询条件</td>
			</tr>
			<tr>
				<td class="left">赔案号：</td>
				<td class="right"><input name="claimNum" class="common" type="text" onchange="clickable()"></td>
				<td class="left">出险人姓名：</td>
				<td class="right"><input name="appntName" class="common" type="text" onchange="clickable()"></td>
				<td class="left">出险日期：</td>
				<td class="right">
					<input name="appntDate" id="appntDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'appntDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
			<tr>
				<td class="left">出险人证件类型：</td>
				<td class="right">
					<input class="codecode" id="appntIDCode" name="lcReport.appntIDCode" class="common" type="text" value="01" style="width:20%" ><input name="appntIDType" class="common" type="text" onchange="clickable()" style="width:68%" value="身份证">
				</td>
				<td  class="left">出险人证件号码：</td>
				<td  class="right"><input name="appntIDNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type="button" class="cssbutton" name="queryButton" value="查  询" onClick="" /></td>
			</tr>
		</table>
		<table id="WorkList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">工作队列</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="20%">赔案号</td>
					<td width="17%">出险人姓名</td>
					<td width="17%">性别</td>
					<td width="20%">出生日期</td>
					<td width="20%">立案日期</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td><a href="javascript:void(0)" onclick="self.location.href='${ctx}/claim/claimoperate/register/RegisterAdd.jsp'">S86012012018</a></td>
					<td>马布</td>
					<td>男</td>
					<td>1986-03-01</td>
					<td>2010-10-20</td>
				</tr>
			</tbody>
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
		<table id="RegisterAdd" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddRegister" value="新增立案" onClick="self.location.href='${ctx}/claim/claimoperate/register/RegisterAdd.jsp'" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>