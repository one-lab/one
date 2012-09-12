<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>费率表定制</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script src="${ctx}/common/js/QueryCodeAll.js" type="text/javascript"></script>
	<script src="${ctx}/product/pddefine/policydefine/dutyTableDefine/js/pdratetableedit.js" type="text/javascript"></script>
    <script type="text/javascript">var ctx = "${ctx}"</script>
  </head>
    <form name="fm" method="post" >
	<div style = "width:60%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">请选择费率表所用要素</td>
			</tr>
			<tr>
				<td class="left">险种代码</td><%-- ${riskCode} --%>
				<td class="right"><input id="riskCode" class="common" type="text" value="<s:property value='riskCode'/>"></td>
				<td class="left">缴费责任编码</td><%-- ${dutyCode} --%>
				<td class="right">
					<input id="dutyCode" class="codecode" type="text" style="width:20%" 
					 	ondblclick="queryCode('dutyCode','dutyCodeName','findDutyByRisk','riskCode:riskCode')"> 
					<input id="dutyCodeName" class="common" type="text" style="width:80%" > 
				</td>				
			</tr>
		</table>
	</div>
	<div style="width:60%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td colspan="3">费率表可选要素：</td>
				</tr>
				<tr class="tableHead">
					<td width="10%">&nbsp;</td>
					<td width="25%">序号</td>
					<td width="65%">要素名称</td>
					
				</tr>
			</thead>
			<tbody align="center" id="factorContent">
			</tbody>
				<tr>
					<td>
						<input type = "button" class="cssbutton" name="AddButton" value="单要素添加" onclick="addRiskDutyFactor();">
					</td>
					<td>
						<input type = "button" class="cssbutton" name="AddButton" value="组合要素添加" onclick="addRiskDutyFactors();">
					</td>
				</tr>
		</table> 
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr class="tableHead">
					<td width="25%">要素顺序</td>
					<td width="25%">要素名称</td>
					<td  width="25%">是否为组合要素</td>
					<td  width="25%">组合元素</td>
					<td width="25%">&nbsp;</td>
				</tr>
			</thead>
			<tbody id="riskDutyFactorContent" align="center">
				
			</tbody>
		</table>
		<table  class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="" value="创建险种页面" onclick="createFactorHtml();">
					<div id="tempFactorHtml"></div>
				</td>
			</tr>
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="" value="导出费率表模版" onclick="DownloadExcel();">
				</td>
			</tr>
		</table>
		
		<table id="" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td class="formtitle"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">费率表导入</td>
					<td><input type="text" name="" class="common"/>
					</td>
					<td>
						<input type = "button" class="cssbutton" name="" value="浏览" onclick="">
						<input type = "button" class="cssbutton" name="" value="导入" onclick="">
					</td>
				</tr>
		</table>
	</div>	
	</form>
</html>
