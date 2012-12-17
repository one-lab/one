<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>险种承保定义</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript">	ctx = "${ctx}";	</script>
  </head>
  <body>
    <input type="hidden" id="flag" value="${flag}"/>
    <form id="riskAppForm" name="fm" method="post" >
	<div id="content" style = "width:60%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">险种代码：</td>
				<td class="right"><input id="riskAppRiskCode" name="riskCode" class="common" type="text" value="${riskCode}"/></td>
				<td class="left">申请日期：</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="middle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>				
			</tr>
		</table>
		</div>
		<div style = "width:98%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="3"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种承保属性定义</td>
					<td align="right" colspan="3">
						<input type = "button" class="cssbutton" name="SaveButton" value="保  存" onclick="">
						<input type = "button" class="cssbutton" name="EditButton" value="修  改" onclick="">
						<input type = "button" class="cssbutton" name="DeleteButton" value="删  除" onclick="">
					</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="19%">属性名称</td>
					<td width="19%">属性数据类型</td>
					<td width="19%">属性值</td>
					<td width="19%">官方字段描述</td>
					<td width="19%">业务人员备注</td>
				</tr>
			</thead>
			<tbody id="riskAppFieldContent">
				<c:forEach items="${allTableFields.pdlmRiskApp }" var="temp">
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
	</div>
	</form>
  </body>
</html>
