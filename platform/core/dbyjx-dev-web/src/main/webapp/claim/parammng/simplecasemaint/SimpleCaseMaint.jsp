<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
    	<base href="<%=basePath%>"/>
    
	    <title>简易案件标准维护</title>
	    
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
		<meta http-equiv="expires" content="0"/>    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
		<meta http-equiv="description" content="This is my page"/>
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css"/>
		<script src="${ctx}/common/calender/WdatePicker.js"></script>

	</head>
<body>
	<form name="fm" method="post" onKeyPress="KeyDown()">
	<div style="width:100%">
		<table id="SimpleCaseQuery" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle"" colspan="6">
					<img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>简易案件标准查询<input type="button" class="cssbutton" name="queryButton" value="查  询" onClick=""/>
				</td>
				
			</tr>
			<tr>
				<td class="left">机构代码：</td>
				<td class="right"><input name="ComCode" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">机构名称：</td>
				<td class="right"><input name="ComName" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>简易案件标准列表</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">机构编码</td>
					<td width="15%">机构名称</td>
					<td width="10%">上级机构</td>
					<td width="10%">最小金额</td>
					<td width="10%">最大金额</td>
					<td width="10%">启用日期</td>
					<td width="10%">结束日期</td>
					<td width="10%">操作员</td>
				</tr>
			</thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="5%" align="right"><input type="button" class="cssbutton" value="首  页"/></td>
				<td width="5%"><input type="button" class="cssbutton" value="上一页"/></td>
				<td width="5%"><input type="button" class="cssbutton" value="下一页"/></td>
				<td width="85%"><input type="button" class="cssbutton" value="尾  页"/></td>
			</tr>
		</table>
		<hr />
		
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>简易案件标准</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="AddButton" value="增  加" onClick=""/>
					<input type="button" class="cssbutton" name="ModifyButton" value="修  改" onClick=""/>
					<input type="button" class="cssbutton" name="DelButton" value="删  除" onClick=""/>
					<input type="button" class="cssbutton" name="ResetButton" value="重  置" onClick=""/>
				</td>
			</tr>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">机构名称：</td>
				<td class="right">
					<input class="codecode" id="comCode" name="lcReport.comCode" class="common" type="text" value="2000000122" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="都邦北京分公司"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">上级机构：</td>
				<td class="right"><input name="SuperCom" class="common" type="text" onChange="clickable()"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">最小金额：</td>
				<td class="right"><input name="MinMount" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">最大金额：</td>
				<td class="right"><input name="MaxMount" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>	
				<td class="left">启用日期：</td>
				<td class="right">
					<input name="EnableDate" id="EnableDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'EnableDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="left">结束日期：</td>
				<td class="right">
					<input name="EndDate" id="EndDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'EndDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="left">操作员：</td>
				<td class="right"><input name="Operator" class="common" type="text" onChange="clickable()"/></td>
			</tr>
			<tr>
				<td class="left">入机日期：</td>
				<td class="right"><input name="InDate" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">入机时间：</td>
				<td class="right"><input name="InTime" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>	
				<td class="left">最后一次修改日期：</td>
				<td class="right"><input name="LastModifyDate" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">最后一次修改时间：</td>
				<td class="right"><input name="LastModifyTime" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
	</div>
	</form>
</body>
</html>