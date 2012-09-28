<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>产品基础信息定义</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
  </head>
  <body>
    <form name="fm" method="post" >
	<div style = "width:60%">
		<table id="" class="common" cellpadding="3" cellspacing="0">

			<tr>
				<td class="left">险种代码：</td>
				<td class="right"><input name="pdLMRisk.riskCode" id="riskCode" class="common" type="text" readonly value='${pdLMRisk.riskCode}'></td>
				<td class="left">申请日期：</td>
				<td class="right">
					<input name="pdLMRisk.makeDate" id="makeDate" class="common" type="text" readonly  style="width: 73%" value='${pdLMRisk.makeDate}' />
					<img style='cursor: hand' align="middle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'makeDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>				
			</tr>
			<tr>
				<td class="left">已上线产品：</td>
				<td class="right"><input name="riskCode" class="codecode" type="text" style="width:20%" ondblclick="queryCode('riskCode','riskCodeName','findRisk','rr_id_relaRiskCode:riskCode')">
				<input style="width:70%" name="riskCodeName" class="common" type="text" ></td>
				<td colspan="2">
					<input type = "button" class="cssbutton" name="CopyButton" value="产品复制" onclick="">	
				</td>				
			</tr>
		</table>
	</div>
	<div style="width:98%">	
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种基础属性定义</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="15%">属性名称</td>
					<td width="19%">属性数据类型</td>
					<td width="19%">属性值</td>
					<td width="23%">官方字段描述</td>
					<td width="19%">业务人员备注</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allTableFields.pdlmRisk }" var="temp">
					<tr class="content">
						<td> ${temp.displayOrder } </td>
						<td> ${temp.fieldName} </td>
						<td> ${temp.fieldType} </td>
						<td> <input class="common" type="text" name='${ temp.fieldValueName}' value='${temp.fieldValue}' /> </td>
						<td> ${temp.officialDesc} </td>
						<td> <input class="common" type="text" name='${temp.busiDesc}' /> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Button" value="产品信息录入完毕" onclick="">
					<input type = "button" class="cssbutton" name="Button" value="返  回" onclick="javascript:history.back()">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
