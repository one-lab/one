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
    
    <title>险种核保规则定义</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
    <script type="text/javascript" src="${ctx}/product/pddefine/policydefine/js/policydefine.js"></script>
  </head>
  <body>
  <form name="fm" method="post"  id="frmInput" >
	<div style = "width:80%">
	<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
			<tr>
				<td class="left">险种编码：</td>
				<td class="right"><input  class="common" type="text" value="GCMR"/></td>
			</tr>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已有核保规则</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="5">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="16%">核保编码</td>
					<td width="16%">险种代码</td>
					<td width="16%">核保顺序</td>
					<td width="16%">校验提示信息</td>
				</tr>
			</thead>
			<tbody align="center" id="HASUWdetail">
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td align="right" colspan="4">
					<input type = "button" class="cssbutton" name="InsertButton" value="新 增" onclick="insertUW();">
					<input type = "button" class="cssbutton" name="EditButton" value="修  改" onclick="updateUW();">
					<input type = "button" class="cssbutton" name="DeleteButton" value="删  除" onclick="deleteUW();">
					<input type = "button" class="cssbutton" id="save" name="SaveButton" value="保 存" onclick="saveUW();" >
				</td>
			</tr>
		</table>
		  
		<table id="UWDetail" class="common" cellpadding="3" cellspacing="0" style="display: none">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">核保规则定义</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="5%">序号</td>
					<td width="15%">属性名称</td>
					<td width="19%">属性数据类型</td>
					<td width="19%">属性值</td>
					<td width="23%">官方字段描述</td>
					<td width="19%">业务人员备注</td>
				</tr>
			</thead>
			
			<tbody align="center" id="UWContent">
				
			</tbody>
		
			 <tr>
				<td>
					<input type = "button" class="cssbutton" name="" value="进入算法定义" onclick="location.href='pddefine/policydefine/dutyTableDefine/pdrisksortcaledit.jsp'">
				</td>
			</tr>
		</table>
			
		</div>
	</form>
  </body>
</html>
