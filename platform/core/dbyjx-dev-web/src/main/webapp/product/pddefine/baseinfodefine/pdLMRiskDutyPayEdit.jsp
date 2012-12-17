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
    
    <title>险种缴费责任</title>
    
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
  <input type="hidden" id="dutyPayFlag" value="${dutyPayFlag}"/>
    <form name="fm" method="post" >
	<div style = "width:98%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
		<thead>
			<tr>
			<td class="formtitle" colspan="3"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种缴费责任</td>
				<td align="right" colspan="3">
					
					
				</td>
			</tr>
			<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="23%">险种代码</td>
					<td width="23%">责任代码</td>
					<td width="23%">缴费责任代码</td>
					<td width="23%">缴费责任名称</td>
					
				</tr>
			</thead>
			<tbody>
			<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="3"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">缴费责任属性定义</td>
					<td align="right" colspan="3">
						<input type = "button" class="cssbutton" name="Button" value="查询缴费库" onclick="">
						<input type = "button" class="cssbutton" name="Button" value="新  增" onclick="">
						<input type = "button" class="cssbutton" name="Button" value="修  改" onclick="">
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
			<tbody>
				<c:forEach items="${allTableFields.pdlmDutyPay}" var="temp">
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
