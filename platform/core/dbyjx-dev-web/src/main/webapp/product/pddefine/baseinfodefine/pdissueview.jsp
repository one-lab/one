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
    
    <title>问题件查看</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/product/pddefine/baseinfodefine/js/pdissueview.js"></script>
	
  </head>
  <body>
    <form name="fm" method="post">
	<div style = "width:60%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">问题件查询条件</td>
				</tr>
				<tr>
					<td class="left">产品险种代码：</td>
					<td class="right"><input name="pdIsSue.riskCode" id="pdIsSue_riskCode" class="codecode" type="text" ondblclick="queryCode('pdIsSue_riskCode','pdIsSue_riskCodeName','PDLDcode1','codeType:riskCode')" style="width:20%"><input name="comName" id="pdIsSue_riskCodeName" class="common" type="text" style="width:65%"></td>
					<td class="left">返回岗位：</td>
					<td class="right"><input name="pdIsSue.backPost" id="backPost" class="codecode" type="text" ondblclick="queryCode('backPost','backPostName','PDLDcode1','codeType:backPost')" style="width:20%"><input name="comName" id="backPostName" class="common" type="text" style="width:65%"></td>
				</tr>
				<tr>
					<td class="left">问题件内容：</td>
					<td class="right"><input name="pdIsSue.issueCont" id="issueCont" class="common" type="text"/></td>
					<td class="left">问题件状态：</td>
					<td class="right"><input name="pdIsSue.issueState" id="issueState" class="codecode" type="text" ondblclick="queryCode('issueState','issueStateName','PDLDcode1','codeType:issueState')" style="width:20%"><input name="comName" id="issueStateName" class="common" type="text" style="width:65%"></td>
				</tr>
				<tr>
					<td colspan="4">
						<input type = "button" class="cssbutton" name="Button" value="查  询" onclick="queryIsSueByCon();">
					</td>
				</tr>
		</table>
		</div>
		<div style = "width:98%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">问题件列表</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="20%">返回岗位</td>
					<td width="15%">发起人</td>
					<td width="40%">问题件内容</td>
					<td width="15%">问题件状态</td>
				</tr>
			</thead>
			<tbody id="issueContent">
			</tbody>
		</table>
		<input type = "button" class="cssbutton" name="Button" value="下载附件" onclick="">
	</div>
	</form>
  </body>
</html>
