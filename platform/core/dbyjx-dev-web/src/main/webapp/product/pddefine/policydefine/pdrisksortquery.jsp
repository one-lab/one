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
    
    <title>险种查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/common/css/TagPage.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
    <script type="text/javascript">var ctx= "${ctx}";</script>
	<script type="text/javascript">
	function startDefine(){
		var val=$('input:radio[name="selectApplingRadio"]:checked').val();
		$("#frmDefine").attr("action",ctx + "/product/showDefine?riskCode="+val);
		$("#frmDefine").submit();
	}
	</script>
	<script type="text/javascript" src="${ctx}/product/pddefine/policydefine/js/policydefine.js"></script>
  </head>
  <body scroll="no">
  <div id="con">
	<ul id="tags">
		<li class="selectTag"><a href="javascript:void(0)" onclick="selectTag('tagContent0',this)">定义中的产品</a></li>
		<li ><a href="javascript:void(0)" onclick="selectTag('tagContent1',this)">已上线产品查询</a></li>
	</ul>			 

	<div id="tagContent" style="width:100%;height:98%">
	   <div id="tagContent0" class="tagContent selectTag" style="width:100%;height:470px;background-color:#ffffff;overflow:auto;">
	       <%-- 假表单，仅用来提交使用 --%>
	       <form id="frmDefine" action=""></form>
	       <form id="frmInput" name="frmInput" >
	         <%-- 将查询定义中的产品页面加载进来 --%>
	        <table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">请输入产品险种代码</td>
			    <td class="right"><input name="flag" value="3" type="hidden"></td>
			</tr>
			<tr>
				<td class="left">产品险种代码：</td>
				<td class="right"><input name="pdLMRisk.riskCode"  id="riskCode" class="common" type="text"></td>
				<td class="left">申请日期：</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="middle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
			</table>
	        <table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="queryApplingRisk();">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">定义中的产品</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="15%">产品险种代码</td>
					<td width="40%">产品险种名称</td>
					<td width="16%">申请日期</td>
					<td width="20%">申请人</td>
				</tr>
			</thead>
			<tbody id = "ApplingRiskDetail">
			  <%--<s:iterator value="page.result" var="temp" status="index">
			  <tr class="content">
				<td width="4%"><input type='radio' name='selectApplingRadio' value='<s:property value="#temp.riskCode" />' /></td>
				<td width="5%"><s:property value="#index.count"/></td>
				<td width="15%"><s:property value="#temp.riskCode" /></td>
				<td width="40%"><s:property value="#temp.riskShortName" /></td>
				<td width="16%"><s:date name="#temp.makeDate" format="yyyy-MM-dd"/></td>
				<td width="20%"><s:property value="#temp.operator" /></td>
			  </tr>	
			  </s:iterator>		--%>
              <c:forEach var="temp" varStatus="index" items="${page.result}">
                  <tr class="content">
                      <td width="4%"><input type='radio' name='selectApplingRadio' value='${temp.riskCode}' /></td>
                      <td width="5%">${index.count}</td>
                      <td width="15%">${temp.riskCode}</td>
                      <td width="40%">${temp.riskShortName}</td>
                      <td width="16%"><fmt:formatDate value="${temp.makeDate}" pattern="yyyy-MM-dd"/></td>
                      <td width="20%">${temp.operator}</td>
                  </tr>
              </c:forEach>
            </tbody>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="5">
					<input type = "button" class="cssbutton" name="defineButton" value="开始定义" 
					onclick="startDefine()">
				</td>
			</tr>
		</table>
		</form>
	   </div>
	   <div id="tagContent1" class="tagContent" style="width:100%;height:470px;background-color:#ffffff;overflow:auto;">
	   		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已上线产品查询</td>
			</tr>
			<tr>
				<td class="left">产品险种代码：</td>
				<td class="right"><input name="comCode" class="codecode" type="text" onchange="clickable()" ></td>
				<td class="right">
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="">
				</td>	
			</tr>
		</table>
		<table id="scanApplycInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr class="tableHead">
					<td width="4%">&nbsp;</td>
					<td width="24%">产品险种代码</td>
					<td width="24%">产品险种名称</td>
					<td width="24%">申请日期</td>
					<td width="24%">申请人</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>	
		<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="5"><input type = "button" class="cssbutton" value="查看信息" onclick="location.href='pdpolicyedit.jsp'"></td>
			</tr>
		</table>	
	   </div>	   
	</div>
	</div>
  </body>
</html>
