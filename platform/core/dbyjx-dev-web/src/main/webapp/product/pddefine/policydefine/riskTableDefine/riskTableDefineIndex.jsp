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
    
    <title>险种层级定义</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<link href="${ctx}/common/css/TagPage.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/product/pddefine/policydefine/js/policydefine.js">
	</script>
  </head>
  <body>
    <div id="con">
	   <%-- 1险种层级定义  --%>
		    <ul id="tags">
				<li class="selectTag"><a href="javascript:void(0)" onclick="selectLevelTag(2,'tagContent20',this);findRiskRoleByRisk();">险种各角色定义</a></li>
				<li ><a href="javascript:void(0)" onclick="selectLevelTag(2,'tagContent21',this);">险种条款打印定义</a></li>
				<li ><a href="javascript:void(0)" onclick="selectLevelTag(2,'tagContent22',this);">险种缴费定义</a></li>
				<li ><a href="javascript:void(0)" onclick="selectLevelTag(2,'tagContent23',this);">险种缴费间隔定义</a></li>
				<li ><a href="javascript:void(0)" onclick="selectLevelTag(2,'tagContent24',this);queryApplingCF();">险种投保规则定义</a></li>
				<li ><a href="javascript:void(0)" onclick="selectLevelTag(2,'tagContent25',this);queryApplingUW();">险种核保规则定义</a></li>
				<li ><a href="javascript:void(0)" onclick="selectLevelTag(2,'tagContent26',this);queryApplingIssue();">问题件录入</a></li>
				<li ><a href="javascript:void(0)" onclick="selectLevelTag(2,'tagContent27',this);">记事本信息</a></li>
				<li ><a href="javascript:void(0)" onclick="selectLevelTag(2,'tagContent28',this);">险种销售控制定义</a></li>
				<li ><a href="javascript:void(0)" onclick="selectLevelTag(2,'tagContent29',this);">主附险组合定义</a></li>
			</ul>
		 <div id="tagContent" style="width:100%">
		 <%-- 险种各角色定义 --%>
			<div id="tagContent20" class="tagContent selectTag" style="width:100%;height:480px;background-color:#ffffff;overflow:auto;">
	   		 	<jsp:include page="/product/pddefine/policydefine/riskTableDefine/pdriskroleedit.jsp"></jsp:include>
		   </div>
	   	<%-- 险种条款打印定义--%>
		   <div id="tagContent21" class="tagContent" style="width:100%;height:480px;background-color:#ffffff;overflow:auto;">
	   		 	<jsp:include page="/product/pddefine/policydefine/riskTableDefine/pdrisktermprintedit.jsp"></jsp:include>
		   </div>
	   <%-- 险种缴费定义 --%>
		   <div id="tagContent22" class="tagContent" style="width:100%;height:480px;background-color:#ffffff;overflow:auto;">
	   		 	<jsp:include page="/product/pddefine/policydefine/riskTableDefine/pdriskpayattributeedit.jsp"></jsp:include>
		   </div>
	   <%-- 险种缴费间隔定义 --%>
		   <div id="tagContent23" class="tagContent" style="width:100%;height:480px;background-color:#ffffff;overflow:auto;">
	   		 	<jsp:include page="/product/pddefine/policydefine/riskTableDefine/pdriskpayintvedit.jsp"></jsp:include>
		   </div>
		   <%-- 险种投保规则定义--%>
			<div id="tagContent24" class="tagContent" style="width:100%;height:480px;background-color:#ffffff;overflow:auto;">
	   		 	<jsp:include page="/product/pddefine/policydefine/riskTableDefine/pdriskinsuruleedit.jsp"></jsp:include>
		   </div>
	   	<%-- 险种核保规则定义--%>
		   <div id="tagContent25" class="tagContent" style="width:100%;height:480px;background-color:#ffffff;overflow:auto;">
	   		 	<jsp:include page="/product/pddefine/policydefine/riskTableDefine/pdriskunderwriteedit.jsp"></jsp:include>
		   </div>
	   <%-- 问题件录入 --%>                 
		   <div id="tagContent26" class="tagContent" style="width:100%;height:480px;background-color:#ffffff;overflow:auto;">
	   		 	<jsp:include page="/product/pddefine/policydefine/riskTableDefine/pdissueedit.jsp"></jsp:include>
		   </div>
	   <%-- 记事本信息 --%>
		   <div id="tagContent27" class="tagContent" style="width:100%;height:480px;background-color:#ffffff;overflow:auto;">
	   		 	<jsp:include page="/product/pddefine/baseinfodefine/pdlmrisknotepadedit.jsp"></jsp:include>
		   </div>
		   <%-- 险种销售控制定义 --%>
		   <div id="tagContent28" class="tagContent" style="width:100%;height:480px;background-color:#ffffff;overflow:auto;">
	   		 	<jsp:include page="/product/pddefine/policydefine/riskTableDefine/pdrisksallctrledit.jsp"></jsp:include>
		   </div>
	   <%-- 主附险组合定义 --%>
		   <div id="tagContent29" class="tagContent" style="width:100%;height:480px;background-color:#ffffff;overflow:auto;">
	   		 	<jsp:include page="/product/pddefine/policydefine/riskTableDefine/pdriskcombination1edit.jsp"></jsp:include>
		   </div>
		 </div>
	  </div>
  </body>
</html>
