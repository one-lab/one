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
    
    <title>责任层级定义</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<link href="${ctx}/common/css/TagPage.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx}/common/js/TagPage.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/product/pddefine/policydefine/dutyTableDefine/js/dutyTableDefineIndex.js"></script>
    <script type="text/javascript">var ctx = "${ctx}"</script>
  </head>
    <div id="con">
	   <!-- 0责任层级定义 -->
		    <ul id="tags">
				<li class="selectTag"><a href="javascript:void(0)" onclick="selectLevelTag(1,'tagContent10',this);">费率定制</a></li>
				<li ><a href="javascript:void(0)" onclick="selectLevelTag(1,'tagContent11',this);defineDutyPay();">定义责任缴费算法</a></li>
				<li ><a href="javascript:void(0)" onclick="selectLevelTag(1,'tagContent12',this);">险种责任加费定义</a></li>
				<li ><a href="javascript:void(0)" onclick="selectLevelTag(1,'tagContent13',this);">责任录入要素定义(仅团险)</a></li>
			</ul>
		<!-- 费率定制 -->
		 <div id="tagContent" style="width:100%">
			<div id="tagContent10" class="tagContent selectTag" style="width:100%;height:470px;background-color:#ffffff;overflow:auto;">
	   		 	<jsp:include page="/product/pddefine/policydefine/dutyTableDefine/pdratetableedit.jsp"></jsp:include>
		   </div>
	   	<!-- 定义责任缴费算法 -->
		   <div id="tagContent11" class="tagContent" style="width:100%;height:470px;background-color:#ffffff;overflow:auto;">
	   		 	<jsp:include page="/product/pddefine/policydefine/dutyTableDefine/pdlmdutypayedit.jsp"></jsp:include>
		   </div>
	   <!-- 险种责任加费定义 -->
		   <div id="tagContent12" class="tagContent" style="width:100%;height:470px;background-color:#ffffff;overflow:auto;">
	   		 	<jsp:include page="/product/pddefine/policydefine/dutyTableDefine/pdriskdutyaddfeeedit.jsp"></jsp:include>
		   </div>
	   <!-- 责任录入要素定义(仅团险) -->
		   <div id="tagContent13" class="tagContent" style="width:100%;height:470px;background-color:#ffffff;overflow:auto;">
	   		 	<jsp:include page="/product/pddefine/policydefine/dutyTableDefine/pddutyinputelementedit.jsp"></jsp:include>
		   </div>
	   </div>
	</div>
</html>
