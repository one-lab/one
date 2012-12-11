<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>客户查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/noImageInput/js/ClientQuery.js"></script>
	<script type="text/javascript">
	var ctx='${ctx}';
	</script>
  </head>
  <body>
    <form id="customerForm" name="fm" method="post">
	<div style = "width:100%">
			<input id="grpContNoHidden" type="hidden" name="grpContNoHidden" value="${grpContNoHidden}"></input>
		<table id="ReportComAppInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">  请输入查询条件</td>
			</tr>
			<tr> 
				<td class="left">客户号：</td>
				<td class="right"><input id="customerNo" name="ldGrp.customerNo" class="common" type="text"></td>
				<td class="left">单位名称：</td>
				<td class="right"><input id="grpName" name="ldGrp.grpName" class="common" type="text"></td>
				<td class="left">单位性质：</td>
				<td class="right"><input class="codecode" id="grpNature" name="ldGrp.grpNature" class="common" type="text" style="width:20%" ondblclick="queryCode('grpNature','grpNatureName','PDLDcode1','codeType:GrpNature')"><input name="grpNatureName" class="common" type="text"   style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
		</table>
		<table id="QueryApplyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" id="QueryButton" name="QueryButton" value="查  询" onclick="findCustomerInfoByCondition();">
					<input type = "button" class="cssbutton" id="ReturnBack" name="ReturnBack" value="返  回" onclick="javascript:history.go(-1);">						
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
					<td width="22%">客户号</td>
					<td width="35%">单位名称</td>
					<td width="35%">单位性质</td>
				</tr>
			</thead>
			<tbody id="content">
				<s:iterator value="page.result" var="temp" status="index">
					  <tr class="content">
						<td width="5%"><input type='radio' name='comstomerNoRadio' value='<s:property value="#temp.customerNo" />' /></td>
						<td width="5%"><s:property value="#index.count"/></td>
						<td width="20%"><s:property value="#temp.customerNo" /></td>
						<td width="25%"><s:property value="#temp.grpName" /></td>
						<td width="25%"><s:property value="#temp.grpNature" /></td>
					  </tr>	
			  	</s:iterator>	
			</tbody>
		</table>
		<div id="pageDiv" align="right">
					<input type="hidden" name="pageNo" id="pageNo" value="${pageNo==null ? 1 : pageNo}" /> 
                    <input type="hidden" name="pageSize" value="${pageSize==null ? 20 : pageSize}" >
			<jsp:include page="/common/pub/page.jsp"></jsp:include>
		</div>		
		<table id="ChooseClertStart" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Start" value="开始录入" onclick="chooseClertStart()">
				</td>
			</tr>
		</table>		
	</div>
	</form>
  </body>
</html>
