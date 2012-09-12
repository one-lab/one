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
    
    <title>险种给付责任</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript">
	function deleteRiskDutyGet(){
		var getDutyCode = $('input:radio[name="selectGetDutyCode"]:checked').val();
		var mark = confirm("您确定删除"+getDutyCode+"记录吗？");
		if(mark == true){
			$.ajax({
				url : contextRootPath + "/product/deleteRiskDutyGet",
				data : {"getDutyCode":getDutyCode},
				dataType : "String",
				success : function(obj){
					alert(obj);
				}
			});
		}
	}
	function saveRiskDutyGet(){
		$("#riskDutyGetForm").attr("action",contextRootPath + "/product/saveRiskDutyGet");
		$("#riskDutyGetForm").submit();
	}
	</script>
  </head>
  <body>
    <input type="hidden" id="dutyGetFlag" value="${dutyGetFlag}"/>
	<div style = "width:98%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="5"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种给付责任</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="30%">险种代码</td>
					<td width="30%">给付责任代码</td>
					<td width="30%">给付责任名称</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="selectGetDutyCode" type="radio" value="a" /></td>
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<c:if test="${pdLmDutyGet}!=null">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="5"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种缴费责任</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="23%">险种代码</td>
					<td width="23%">责任代码</td>
					<td width="23%">给付责任代码</td>
					<td width="23%">给付责任名称</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>1</td>
					<td><c:out value="${riskCode}"></c:out> </td>
					<td><c:out value="${riskCode}"></c:out> </td>
					<td><c:out value="${riskCode}"></c:out></td>
					<td><c:out value="${riskCode}"></c:out></td>
				</tr>
			</tbody>
		</table>
		</c:if>
	<form name="fm" method="post" id="riskDutyGetForm" >
		<table id="" class="common" cellpadding="0" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="3"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">给付责任属性定义</td>
					<td align="right" colspan="3">
						<input type = "button" class="cssbutton" name="Button" value="查询给付库" onclick="">
						<input type = "button" class="cssbutton" name="Button" value="新  增" onclick="saveRiskDutyGet();">
						<input type = "button" class="cssbutton" name="Button" value="修  改" onclick="">
						<input type = "button" class="cssbutton" name="Button" value="删  除" onclick=" deleteRiskDutyGet();">
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
				<c:forEach items="${allTableFields.pdlmDutyGet }" var="temp">
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
	</form>
	</div>
	
  </body>
</html>
