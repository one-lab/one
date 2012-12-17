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
    
    <title>问题件录入</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="common/js/SimpleCalendar.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript">
	     ctx = "${ctx}";
    </script>
    <script type="text/javascript" src="${ctx }/prpall/group/artificalUW/js/ProblemFileInput.js"></script>
  </head>
  <body>
    <form name="fm" method="post">
	<div style = "width:100%">
		<table id="auditIdeas" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td  class="left">发送对象：</td>
				<td  class="right"><input id="backObjType" name="backObjType" class="codecode" type="text" ondblclick="queryCode('backObjType','backObjTypeName','PDLDcode1','codeType:BackObjType')" style="width:20%"><input id="backObjTypeName" name="backObjTypeName" class="common" type="text" style="width:68%"></td>
				<td  class="common"><input id="grpContNo" name="grpContNo" type="hidden" value="${param.grpContNo }"/></td>
				<td  class="common"></td>
				<td  class="common"></td>
				<td  class="common"></td>
			</tr>
			<tr>
				<td  class="left">问题件选择：</td>
				<td  class="right"><input id="issueType" name="issueType" class="codecode" type="text" ondblclick="queryCode('issueType','issueTypeName','PDLDcode1','codeType:IssueReason')" style="width:20%"><input id="issueTypeName" name="issueTypeName" class="common" type="text" style="width:68%"></td>
				<td  class="common"><input id="operatePos" name="operatePos" type="hidden" value="${param.operatePos }"/><!-- 问题件录入位置：“05”表示人工核保时产生 --></td>
				<td  class="common"></td>
				<td  class="common"></td>
				<td  class="common"></td>
			</tr>			
			<tr>
				<td colspan="6" >问题件内容（500字以内，回车符占一个字节）</td>
			</tr>
			<tr>
				<td colspan="6"><textarea id="issueCont" name="issueCont" cols="100%" rows="5"></textarea></td>
			</tr>
		</table>
		<br>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" id="saveIssueButton" name="saveIssueButton" value="保  存" onclick="saveIssueFile()">
					<input type = "button" class="cssbutton" name="QueryButton" value="返  回" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
