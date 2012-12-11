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
    
    <title>调查信息查看</title>
    
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
	<script type="text/javascript" src="${ctx}/claim/claimoperate/report/js/SurveyInfoQuery.js"></script>

  </head>
  
  <body>
  <form name="fm" method="post">
	<div style="width:100%">
		<table id="SurveyResultList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">调查信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="25%">报/赔序号</td>
					<td width="25%">调查序号</td>
					<td width="22%">出险人姓名</td>
					<td width="22%">完成标志</td>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="llInqApplyPage.result" var="llInqApply" status="index">
					<tr class="content">
						<td><input type="radio" name="surveyRedio" onclick="findLLInq(this.value);" value='<s:property value="#llInqApply.id.clmNo"/>,<s:property value="#llInqApply.id.inqNo"/>' /></td>
						<td><s:property value="#index.count"/> </td>
						<td><s:property value="#llInqApply.id.clmNo"/> </td>
						<td><s:property value="#llInqApply.id.inqNo"/> </td>
						<td><s:property value="#llInqApply.customerName"/> </td>
						<td>
							<s:if test="#llInqApply.inqStateValue!=null"><s:property value="#llInqApply.inqStateValue"/> </s:if>
							<s:else>&nbsp;</s:else>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td align="center">
						<input type="button" class="cssbutton" name = "querycssbutton" value="首  页" onClick="" >
						<input type="button" class="cssbutton" name = "querybutton" value="上一页" onClick="" >
						<input type="button" class="cssbutton" name = "querybutton" value="下一页" onClick="" >
						<input type="button" class="cssbutton" name = "querybutton" value="尾  页" onClick="" >
					</td>
				</tr>
		</table>
	</div>
  </form>
  <div id="con">
	<ul id="tags">
		<li class="selectTag"><a href="javascript:void(0)" onclick="selectTag('tagContent0',this)">调查结论信息</a></li>
		<li ><a href="javascript:void(0)" onclick="selectTag('tagContent1',this);">调查申请信息</a></li>
		<li ><a href="javascript:void(0)" onclick="selectTag('tagContent2',this);">调查过程及费用信息</a></li>
	</ul>
	
	<div id="tagContent" style="width:100%">
	   <!-- 0调查结论 -->
	   <div id="tagContent0" class="tagContent selectTag" style="width:100%;height:480px;background-color:#ffffff;overflow:auto;">
	         <%-- 将调查结论页面加载进来 --%>
	         <jsp:include page="/claim/claimoperate/report/SurveyResultInfo.jsp" flush="true" />        
	   </div>
	   
	    <!-- 1调查申请信息 -->
	   <div id="tagContent1" class="tagContent" style="width:100%;height:480px;background-color:#ffffff;overflow:auto;">
   		 	<jsp:include page="/claim/claimoperate/report/SurveyApplyInfo.jsp" flush="true" /> 
	   </div>	
	   <!-- 2调查过程信息 -->
	    <div id="tagContent2" class="tagContent" style="width:100%;height:480px;background-color:#ffffff;overflow:auto;">
	         <jsp:include page="/claim/claimoperate/report/SurveyProcessInfo.jsp" flush="true" />
	   </div> 
	 </div>
  </div>
  </body>
</html>
