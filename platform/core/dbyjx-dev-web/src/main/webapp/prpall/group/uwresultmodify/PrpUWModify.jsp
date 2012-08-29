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
		<title>核保订正</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>
		<script type="text/javascript">ctx = "${ctx}"</script>
		<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
		<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
		<script type="text/javascript" src="${ctx}/prpall/group/uwresultmodify/js/PrpUWModify.js"></script>
		<script type="text/javascript">
			$(function(){
				isEmpty();
			});
		</script>
	</head>
	
	<body>
		<form id="fmUWResultModify" name="fmUWResultModify" method="post">
        <br>
        	<input id="flag" type="hidden" value="${flag }"/>
			<table  class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">查询条件</td>
				</tr>
				<tr>
					<td class="left">集体投保单号：</td>
					<td class="right"><input id="grpContNo" name="lcGrpCont.grpContNo" class="common" type="text" value='<s:property value="lcGrpCont.grpContNo"/>'></td>
					<td class="left">管理机构：</td>
					<td class="right"><input type="hidden" id="upperComCode" value='<s:property value="#session.prpDcompany.comCode"/>'/>
					<input id="comCode" name="lcGrpCont.manageCom" class="codecode" type="text" ondblclick="queryCode('comCode','comName','PrpDcompany','comCode:comCode|upperComCode:upperComCode')" style="width:20%" value='<s:if test="lcGrpCont.comCode==null" ><s:property value="#session.prpDcompany.comCode"/></s:if><s:else><s:property value="lcGrpCont.comCode"/></s:else>'><input id='comName' name="comName" class="common" type="text"  style="width:68%" value='<s:property value="#session.prpDcompany.comCName"/>' ><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
					<td class="left">投保单位客户号：</td>
					<td class="right"><input id="appntNo" name="lcGrpCont.appntNo" class="common" type="text" value='<s:property value="lcGrpCont.appntNo"/>'></td>
				</tr>
				<tr>
					<td class="left">投保单位名称：</td>
					<td class="right"><input id="grpName" name="lcGrpCont.grpName" class="common" type="text" value='<s:property value="lcGrpCont.grpName"/>'></td>
					<td class="left">代理人编码：</td>
					<td class="right">
					<input id="agentCode" name="lcGrpCont.agentCode" class="codecode" type="text" ondblclick="queryCode('comCode','comName','PrpDcompany','comCode:comCode')" style="width:20%" value='<s:property value="lcGrpCont.agentCode"/>'><input id='comName' name="comName" class="common" type="text"  style="width:68%" value='<s:property value=""/>' ><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
					<td class="common"></td>
					<td class="common"></td>
				</tr>				
			</table>
		
			<table>
				<tr>
					<td colspan="6">
						<input type="button" class="cssbutton" name="queryButton" value="查  询" onClick="findUWResultModify()"/>
					</td>
				</tr>
			</table>
		<div style="width:100%">
			<table id="ReportCompanyInfo" class="common" cellpadding="3" cellspacing="0">
				<thead>
					<tr>
						<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">集体信息</td>
					</tr>
					<tr class="tableHead">
						<td width="3%">&nbsp;</td>
						<td width="7%">序号</td>
						<td width="20%">集体投保单号</td>
						<td width="30%">投保单位名称</td>
						<td width="20%">管理机构</td>
						<td width="20%">代理人编码</td>
					</tr>
				</thead>
				<tbody id="uwResultModifyBoby">
						<s:iterator value="#request.lcGrpContList" var="temp" status="tempStatus">
							<tr class="content">
								<td ><input name="radioGrpContNo" type="radio" value='<s:property value="#temp.grpContNo"/>' /></td>
								<td ><s:property value="#tempStatus.count"/></td>
								<td ><s:property value="#temp.grpContNo"/></td>
								<td ><s:property value="#temp.grpName"/></td>
								<td ><s:property value="#temp.comCode"/></td>
								<td ><s:property value="#temp.agentCode"/></td>
							</tr>
						</s:iterator>
					
					
				</tbody>
			</table>
			</div>
			<!--
			<div id="pageDiv" align="right">
				<jsp:include page="/common/pub/page.jsp"></jsp:include>
			</div>	
			-->
			<table>
				<tr>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
				</tr>
			</table>
			   
			<input type="button" class="cssbutton" name="InsertButton" value="核保订正" onClick="uwResultModify()">
		</form>
	</body>
</html>