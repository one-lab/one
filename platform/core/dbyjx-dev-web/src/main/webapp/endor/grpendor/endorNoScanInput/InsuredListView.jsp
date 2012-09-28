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
    
    <title>人名清单查询</title>
    
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
	<div style = "width:100%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">险种编码：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%">
				</td>
				<td class="left">个人保单号：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				<td class="left">个人客户姓名：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
		</table>
		<hr>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="">
				</td>
			</tr>
		</table>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     个人保单信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="10%">个人保单号</td>
					<td width="8%">个人客户号</td>
					<td width="6%">被保人姓名</td>
					<td width="6%">险种</td>
					<td width="6%">交费频率</td>
					<td width="6%">投保年龄</td>
					<td width="6%">保费</td>
					<td width="6%">保额</td>
					<td width="6%">保单状态</td>
					<td width="6%">被保险人人数</td>
					<td width="6%">保障层级</td>
					<td width="8%">生效日期</td>
					<td width="6%">对应被保人</td>
					<td width="6%">与住被保人关系</td>										
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>1300566868120</td>
					<td>00005684</td>
					<td>光明</td>
					<td>4025</td>
					<td>0</td>
					<td>31</td>
					<td>200</td>
					<td>150000</td>
					<td>承保</td>
					<td>1</td>
					<td>经理</td>
					<td>2012-06-25</td>
					<td>本人</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick="location.href='ReportAuditDeal.jsp'"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>		
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="个人特约查询" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="帐户查询" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="管理费查询" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="返  回" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
