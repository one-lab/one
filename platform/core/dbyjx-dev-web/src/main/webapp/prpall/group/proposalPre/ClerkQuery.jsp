<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>业务员查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="common/js/SimpleCalendar.js"></script>

  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="ReportComAppInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     业务员查询条件</td>
			</tr>
			<tr> 
				<td class="left">业务员编码：</td>
				<td class="right"><input name="AgentCode" class="common" type="text"></td>
				<td class="left">销售机构：</td>
				<td class="right"><input name="SaleManagecom" class="common" type="text"></td>
				<td class="left">管理机构：</td>
				<td class="right"><input name="Managecom" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">姓名：</td>
				<td class="right"><input name="name" class="common" type="text"></td>
				<td class="left">性别：</td>
				<td class="right"><input name="Sex" class="common" type="text"></td>
				<td class="left">身份证号：</td>
				<td class="right"><input name="IDNo" class="common" type="text"></td>				
			</tr>
		</table>
		<table id="QueryApplyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="">
					<input type = "button" class="cssbutton" name="ReturnBack" value="返  回" onclick="javascript:history.go(-1);">						
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     业务员结果</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="11%">业务员编码</td>
					<td width="11%">销售机构</td>
					<td width="15%">管理机构</td>
					<td width="11%">姓名</td>
					<td width="11%">身份证号</td>
					<td width="11%">状态</td>
					<td width="11%">电话</td>
					<td width="11%">手机</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>S86012012005</td>
					<td>860101</td>
					<td>北京都邦保险公司</td>
					<td>于开启</td>
					<td>李四</td>
					<td>审核通过</td>
					<td>未开启</td>
					<td>2012-01-01</td>
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
	</div>
	</form>
  </body>
</html>
