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
    
	    <title>呈报信息查看</title>
	    
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
		<table id="ReportInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">该赔案下的呈报信息列表</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">报案号</td>
					<td width="15%">呈报序号</td>
					<td width="14%">呈报次数</td>
					<td width="15%">出险人姓名</td>
					<td width="10%">提起阶段</td>
					<td width="15%">呈报日期</td>
					<td width="10%">呈报状态</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>S86012012018</td>
					<td>L5214</td>
					<td>1</td>
					<td>马布</td>
					<td>01</td>
					<td>2012-05-01</td>
					<td>完成</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="5%"><input type = "button" class="cssbutton" value="首  页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="85%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>
		<br />
		<table id="ReportInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">选中呈报的具体信息</td>
			</tr>
			<tr>
				<td  class="left">赔案号：</td>
				<td  class="right"><input name="ClaimNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">案件对应的报案号：</td>
				<td  class="right"><input name="ReportNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">呈报序号：</td>
				<td  class="right"><input name="ReportNum" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">呈报次数：</td>
				<td  class="right"><input name="ReportTimes" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">出险人姓名：</td>
				<td  class="right"><input name="AppntName" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">提起阶段：</td>
				<td  class="right"><input name="LiftStage" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">呈报人：</td>
				<td  class="right"><input name="Reporter" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">呈报机构：</td>
				<td  class="right"><input name="ReportCom" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">呈报日期：</td>
				<td  class="right"><input name="ReportDate" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">承接人员用户名：</td>
				<td  class="right"><input name="AgentName" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">呈报状态：</td>
				<td  class="right"><input name="ReportState" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<table id="ReportContent" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td colspan="4">呈报描述</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="accidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
			<tr>
				<td colspan="4">呈报处理意见</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="accidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="returnButton" value="返  回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>