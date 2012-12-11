<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>精算审核处理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
		<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
		<script type="text/javascript">
		//根路径
		var ctx = "${ctx}";
		//保存精审意见
		function saveActuarialAuditIdea(){
			var findUrl=ctx + "/prpall/saveActuarialAuditIdea.do";
			var findParams ={
				"lcActuarialAudit.id.repNo":$("#repNoTemp").val(),
				"lcActuarialAudit.repAuditIdea":$("#repAuditIdea").val()
			};
			//返回查询结果信息
			function findActuarialCallBack(obj){
				
				$("#ActuarialAuditInfo").html("");
				var contentString="";
				var xuhao = 1 ;
				for(var i = 0 ; i < obj.data.length; i++){
					contentString += "<tr class='content' name='aa'>";
					var date = new Date();
					date.setTime(obj.data[i].modifyDate.time);
					var dateStr = date.getUTCFullYear()+"-"+(date.getUTCMonth()+1)+"-"+(date.getUTCDate()+1)+" "+obj.data[i].modifyTime;
					contentString += 
					"<td>"+xuhao+"</td>"+
					"<td>"+obj.data[i].repAuditOperator+"</td>"+
					"<td>"+obj.data[i].repAuditIdea+"</td>"+
					"<td>"+dateStr+"</td>";
					xuhao++;
					contentString +="</tr>";
				}
				$("#ActuarialAuditInfo").html(contentString);
				alert("精算审核成功！");
				$("#repAuditIdea").attr("readOnly",true);
				$("#saveAuditIdea").attr("disabled",true);
				
			}
			jQuery.post(findUrl,findParams,findActuarialCallBack,'json');
		}
	
		</script>
  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div id="prpallInfo" style = "width:100%">
		<table id="prpallInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../reportInput/ReportAdd.jsp" /> </td>
			</tr>
		</table>
	</div>
	<div id="reportAuditInfo" style = "width:100%">
		<table id="ReportCompanyInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">呈保审核信息</td>
				</tr>
				<tr class="tableHead">
					<td width="7%">序号</td>
					<td width="23%">审核人</td>
					<td width="24%">审核意见</td>
					<td width="23%">审核时间</td>
				</tr>
			</thead>
			<tbody id="ActuarialAuditInfo">
				<s:iterator value="#request.lcActurialList" var="temp" status="tempStatus">
					<tr class="content">
						<td><s:property value="#tempStatus.count"/></td>
						<td><s:property value="#temp.repAuditOperator"/></td>
						<td><s:property value="#temp.repAuditIdea"/></td>
						<td><s:property value="#temp.modifyDate"/></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<table id="auditIdeas" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<input id="repNoTemp" type="hidden" name="lcActuarialAudit.id.repNo" value="${repNo}"/>
				<td colspan="6" >审核意见（500字以内，回车符占一个字节）</td>
			</tr>
			<tr>
				<td colspan="6"><textarea id="repAuditIdea" name="lcActuarialAudit.repAuditIdea" cols="100%" rows="5" witdh=100%></textarea></td>
			</tr>
		</table>
		<table id="ResultInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="75%" align='left'><input id="saveAuditIdea" type="button" class="cssbutton" name="Confirm" value="确  认" onclick="saveActuarialAuditIdea()"/></td>
			</tr>
		</table>
		<hr>
		<table id="searchInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" align="left">
					<input type="button" class="cssbutton" name = "OpenPrpallSearch" value="确  认" onclick="">
					<input type="button"  name="returnButton" class="cssbutton" value="返  回" onclick="javascript:history.go(-1);"></td>
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
