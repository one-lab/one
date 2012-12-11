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
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    
	<div style = "width:70%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="3"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已发送问题件</td>
				</tr>
				<tr class="tableHead">
				    <td width="5">&nbsp;</td>
				 	<td width="10%">序号</td>
					<td width="30%">返回岗位</td>
					<td width="30%">问题件内容</td>
					<td width="30%">问题件状态</td>
				</tr>
			</thead>
			<tbody align="center" id="HASIssuedetail">
			</tbody>
		</table>
	    <table  class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td align="right" colspan="4">
					<input type = "button" class="cssbutton" name="InsertButton" value="新 增" onclick="insertIssue();">
					<input type = "button" class="cssbutton" name="EditButton" value="修  改" onclick="updateIssue();">
					<input type = "button" class="cssbutton" name="DeleteButton" value="删  除" onclick="deleteIssue();">
					<input type = "button" class="cssbutton" id="save" name="SaveButton" value="保 存" onclick="saveIssue();" >
				</td>
			</tr>
		</table>
	   <form name="fm" method="post" id="frmIssueInput">
		<table id="IssueDetail" class="common" cellpadding="3" cellspacing="0" style="display: none" >
			<tr>
				<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">问题件录入</td>
				<input type="hidden" id="id.pdIsSue.issuetype" name="pdIsSue.issuetype" value="1"/>
				<input type="hidden" id="riskCode" name="pdIsSue.id.riskCode" value="GCMR"/>
				<input type="hidden" id="serialNo" name="pdIsSue.id.serialNo"/>
				<input type="hidden" id="id.pdIsSue.operpost" name="pdIsSue.operpost" value="02"/>
				<input type="hidden" id="id.pdIsSue.issuestate" name="pdIsSue.issuestate" value="1"/>
			</tr>
			<tr>
				<td class="left">返回岗位：</td>
				<td class="right">
				  <input id="codeType" name="pdIsSue.backpost" class="codecode" type="text" ondblclick="queryCode('codeType','codeName','PDLDcode1','codeType:IssueGrade')"  style="width:20%">
				  <input id="codeName" name="" class="common" type="text"  onchange="clickable()" style="width:68%">
				</td>
			</tr>
			<tr>
					<td width="100%" class="left">问题件内容</td>
			</tr>
			<tr>
					<td class="formtitle" colspan="4"><textarea id="issuecont" name="pdIsSue.issuecont"  rows="4" ></textarea></td>
			</tr>
			<tr>	
				<td >
					<input type="button" class="cssbutton"
					name="pdIsSue.issuefilepath" value="上传附件"
					onclick="window.open('${ctx}/product/pddefine/policydefine/IssueFileInput.jsp', 'newwindow', 'width=400, height=150, top=150, left=250, toolbar=no, menubar=no, scrollbars=no,resizable=no,location=no, status=yes')" />
				</td>            
			</tr>
		</table>
	 </form>
	</div>

  </body>
</html>
