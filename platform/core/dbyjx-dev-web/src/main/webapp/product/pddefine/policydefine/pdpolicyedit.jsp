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
    
    <title>产品契约信息定义</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/common/css/TagPage.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/TagPage.js"></script>
    <script type="text/javascript" src="${ctx}/product/pddefine/policydefine/js/policydefine.js"></script>
    <script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
    <script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
  </head>
 <body  style="overflow:hidden" scroll="no">
    <div id="con">
	    <ul id="tags">
		    <li class="selectTag"><a href="javascript:void(0)" onclick="selectTag('tagContent0',this)">责任层级定义</a><br></li>
			<li ><a href="javascript:void(0)" onclick="selectTag('tagContent1',this);">险种层级定义</a><br></li>
			<li ><a href="javascript:void(0)" onclick="selectTag('tagContent2',this);">险种信息查询</a><br></li>
		</ul>
	   <div id="tagContent" style="width:100%;height:470px;background-color:#ffffff;overflow:auto;" >
	    <!-- 0责任层级定义 --> 
	      <div id="tagContent0" class="tagContent selectTag" >
		   <jsp:include page="/product/pddefine/policydefine/dutyTableDefine/dutyTableDefineIndex.jsp"/> 
	      </div>

	    <!-- 1险种层级定义 -->
	      <div id="tagContent1" class="tagContent" >
		   <jsp:include page="/product/pddefine/policydefine/riskTableDefine/riskTableDefineIndex.jsp"/> 
	     </div>	
	     
	    <!-- 2险种信息查询 -->
	   <div id="tagContent2" class="tagContent">
	    <table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Button" value="险种基础信息查看" onclick="location.href='../baseinfodefine/pdlmriskedit.jsp'">
					<input type = "button" class="cssbutton" name="Button" value="问题件查询" onclick="location.href='../baseinfodefine/pdissueview.jsp'">
				</td>
			</tr>
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Button" value="契约信息录入完毕" onclick="">
					<input type = "button" class="cssbutton" name="Button" value="返回" onclick="javascript:history.back()">
				</td>
			</tr>
		</table>
	   </div> 
	  </div>
 </div>
  </body>
</html>
