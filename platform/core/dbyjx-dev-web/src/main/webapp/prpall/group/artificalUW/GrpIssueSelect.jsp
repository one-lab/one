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
    
    <title>团体问题件查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
    <script src="${ctx}/prpall/group/artificalUW/js/ArtificalUWApply.js"></script>
    <script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript">ctx = "${ctx}";</script>
	<script type="text/javascript" src="${ctx }/prpall/group/artificalUW/js/GrpIssueSelect.js"></script>
  </head>
  <body>
    <form id="issueForm" name="fm" method="post">
	<div style = "width:100%">
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0" style="width:90%">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     问题件列表</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="12%">集体投保保单号</td>
					<td width="10%">问题件类型</td>
					<td width="12%">录入人</td>
					<td width="10%">录入日期</td>
					<td width="12%">操作位置</td>
					<td width="12%">返回对象</td>
					<td width="12%">是否打印</td>
				</tr>
			</thead>
			<tbody id="content">
				<s:if test="not empty(lcIssueList)">
					<s:iterator value="lcIssueList" var="lcIssue" status="s">
						<input type="hidden" id="grpContNo" value='<s:property value="lcIssueList.get(0).id.grpContNo"/>'/>
						<tr class="content">
							<td><input type="radio" name="lcIssueRadio" value='<s:property value="#lcIssue.id.serialNo"/>'  onclick="viewContentAndReply()" /> </td>
							<td><s:property value="#s.count"/></td>
							<td><s:property value="#lcIssue.id.grpContNo"/></td>
							<td><s:property value="#lcIssue.issueType"/></td>
							<td><s:property value="#lcIssue.operator"/></td>
							<td><s:property value="#lcIssue.modifyDate"/></td>
							<td><s:property value="#lcIssue.operatePos"/></td>
							<td><s:property value="#lcIssue.backObj"/></td>
							<td><s:property value="#lcIssue.needPrint"/></td>
						</tr>
					</s:iterator>
				</s:if>
				<s:else>
					<tr class="content">
						<td colspan="9">暂无信息</td>
					</tr>
				</s:else>
			</tbody>
			
		</table>
		<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick=""></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" >问题件内容</td>
			</tr>
			<tr id="noContent">
				<td colspan="4"><textarea id="issueContent"  name="issueContent" cols="100%" rows="5"><s:property value="#request.issueContent.issueCont"/> </textarea></td>
			</tr>
			<tr>
				<td colspan="6" >问题件回复</td>
			</tr>
			<tr id="noApply">
				<td colspan="4"><textarea id="issueApply"  name="issueApply" cols="100%" rows="5"><s:property value="#request.issueContent.replyResult"/></textarea></td>
			</tr>
		</table>
	</div>
	<input type="button" value="返回" onclick="javascript:history.go(-1);"/>
	</form>
  </body>
</html>
