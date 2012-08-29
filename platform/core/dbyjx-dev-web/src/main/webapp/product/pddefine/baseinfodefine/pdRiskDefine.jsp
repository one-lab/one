<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html locale="true" xmlns:mpc>
  <head>

    
    <title>产品基础信息定义</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/common/css/TagPage.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx}/common/js/TagPage.js"></script>
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript">
	function findRiskAppField(){
		$("#riskAppForm").attr("action",ctx + "/product/findRiskAppField.do");
		//TODO 不知道将targer的目标指向哪里？
		$("#riskAppForm").attr("target","");
		$("#riskAppForm").submit();
		
		//$("#contentFrame").attr("src","url");
		//alert(sonDocument);
		//var sonDocument = $("#contentFrame").contentWindow;
		//sonDocument.getElementById("riskAppForm").action=ctx + "/product/findRiskAppField.do";
		//sonDocument.getElementById("riskAppForm").submit();
	}
	//function change(pagePath){
	//	$("#contentFrame").attr("src",pagePath);
	//}
	</script>
  </head>
  <body scroll="no">
  <div id="con">
	<ul id="tags">
		<li class="selectTag"><a href="javascript:void(0)" onclick="selectTag('tagContent0',this)">险种定义</a></li>
		<li ><a href="javascript:void(0)" onclick="selectTag('tagContent1',this);">险种承保定义</a></li>
		<li ><a href="javascript:void(0)" onclick="selectTag('tagContent2',this);">险种责任定义</a></li>
		<li ><a href="javascript:void(0)" onclick="selectTag('tagContent3',this);">险种缴费定义</a></li>
		<li ><a href="javascript:void(0)" onclick="selectTag('tagContent4',this);">险种给付定义</a></li>
		<li ><a href="javascript:void(0)" onclick="selectTag('tagContent5',this)">记事本</a></li>
		<li ><a href="javascript:void(0)" onclick="selectTag('tagContent6',this)">问题件查询</a></li>
	</ul>
	
	<div id="tagContent" style="width:100%">
	   <!-- 0险种定义 -->
	   <div id="tagContent0" class="tagContent selectTag" style="width:100%;height:470px;background-color:#ffffff;overflow:auto;">
	         <%-- 将查询定义中的产品页面加载进来 --%>
	         <jsp:include page="/product/pddefine/baseinfodefine/pdlmriskedit.jsp" flush="true" />        
	   </div>
	   
	    <!-- 1险种承保定义 -->
	   <div id="tagContent1" class="tagContent" style="width:100%;height:470px;background-color:#ffffff;overflow:auto;">
   		 	<jsp:include page="/product/pddefine/baseinfodefine/pdlmriskappedit.jsp" flush="true" /> 
	   </div>	
	   <!-- 2险种责任定义 -->
	    <div id="tagContent2" class="tagContent" style="width:100%;height:470px;background-color:#ffffff;overflow:auto;">
	         <jsp:include page="/product/pddefine/baseinfodefine/pdLMRiskDutyEdit.jsp" flush="true" />
	   </div> 
	    <!-- 3险种缴费定义 -->
	   <div id="tagContent3" class="tagContent" style="width:100%;height:470px;background-color:#ffffff;overflow:auto;">
	   		 <jsp:include page="/product/pddefine/baseinfodefine/pdLMRiskDutyPayEdit.jsp" flush="true" /> 
	   </div> 
	     
	    <!-- 4险种给付定义 -->
	   <div id="tagContent4" class="tagContent" style="width:100%;height:470px;background-color:#ffffff;overflow:auto;">
	   		 <jsp:include page="/product/pddefine/baseinfodefine/pdLMRiskDutyGetEdit.jsp" flush="true" /> 
	   </div>  
	   
	    <!-- 5记事本 -->
	   <div id="tagContent5" class="tagContent" style="width:100%;height:470px;background-color:#ffffff;overflow:auto;">
	   		 <jsp:include page="/product/pddefine/baseinfodefine/pdlmrisknotepadedit.jsp" flush="true" />
	   </div>   
	   
	    <!-- 6问题件查询 -->
	   <div id="tagContent6" class="tagContent" style="width:100%;height:470px;background-color:#ffffff;overflow:auto;">
	   		 <jsp:include page="/product/pddefine/baseinfodefine/pdissueview.jsp" flush="true" />
	   </div>  
	   
	 </div>
    </div>
  </body>
</html>
