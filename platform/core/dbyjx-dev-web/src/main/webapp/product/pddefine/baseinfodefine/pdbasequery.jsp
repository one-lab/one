<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html >
<head>
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/common/css/TagPage.css" rel="stylesheet" type="text/css" />
</head>
<body scroll="no">
<div id="con">
	<ul id="tags">
		<li class="selectTag"><a href="javascript:void(0)" onclick="selectTag('tagContent0',this)">定义中的产品</a></li>
		<li ><a href="javascript:void(0)" onclick="selectTag('tagContent1',this)">已上线产品查询</a></li>
	</ul>
	<div id="tagContent" style="width:100%;">
	   <div id="tagContent0" class="tagContent selectTag" style="width:100%;height:470px;background-color:#ffffff;overflow:auto;">
	         <%-- 将查询定义中的产品页面加载进来 --%>
	         <jsp:include page="/product/pddefine/baseinfodefine/pdQueryDefine.jsp" flush="true" />
	   </div>
	   <div id="tagContent1" class="tagContent" style="width:100%;height:480px;background-color:#ffffff;overflow:auto;">
	   		 已上线产品查询---待完成....
	   </div>	   
	</div>
 
</div>
</body>
</html>
