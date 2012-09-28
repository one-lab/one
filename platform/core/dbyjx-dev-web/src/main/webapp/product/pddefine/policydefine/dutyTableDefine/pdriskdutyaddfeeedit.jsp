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
    
    <title>险种责任加费定义</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
  </head>
  <body>
    
	<div style = "width:80%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td align="right" colspan="4">
					<input type = "button" class="cssbutton" name="SaveButton" value="保  存" onclick="">
					<input type = "button" class="cssbutton" name="EditButton" value="修  改" onclick="">
					<input type = "button" class="cssbutton" name="DeleteButton" value="删  除" onclick="">
				</td>
			</tr>
			<tr>
				<td class="left">产品险种编码：</td>
				<td class="right"><input name="" class="common" type="text"/></td>
			</tr>
		</table>
		<form name="fm" method="post" id="frmDutyPayAddFee" >
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种责任加费定义</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="4%">序号</td>
					<td width="16%">属性名称</td>
					<td width="16%">属性代码</td>
					<td width="16%">属性数据类型</td>
					<td width="16%">属性值</td>
					<td width="16%">官方字段描述</td>
					<td width="16%">业务人员备注</td>
				</tr>
			</thead>
			<tbody align="center" id="RiskDutyAddFeeFields">
				<tr class="content">
					<td>1</td>
					<td>险种代码</td>
					<td>RiskCode</td>
					<td>VARCHAR2(8)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>2</td>
					<td>责任编码</td>
					<td>DutyCode</td>
					<td>VARCHAR2(10)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>3</td>
					<td>加费类型</td>
					<td>AddFeeType</td>
					<td>VARCHAR2(2)</td>
					<td>&nbsp;</td>
					<td>00 默认，01首期健康</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>4</td>
					<td>加费对象</td>
					<td>AddFeeObject</td>
					<td>VARCHAR2(2)</td>
					<td>&nbsp;</td>
					<td>00默认，01投保人</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>5</td>
					<td>加费算法</td>
					<td>AddFeeCalCode</td>
					<td>VARCHAR2(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>6</td>
					<td>加费评点最大值</td>
					<td>AddPointLimit</td>
					<td>NUMBER(12,2)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		</form>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已保存险种加费类型</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="15%">险种编码</td>
					<td width="15%">责任编码</td>
					<td width="15%">加费类型</td>
					<td width="15%">加费对象</td>
					<td width="15%">加费算法</td>
					<td width="15%">加费评点最大值</td>
				</tr>
			</thead>
			<tbody align="center">
				<tr class="content">
					<td><input name="" value="" type="radio"/></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="" value="加费算法定义" onclick="location.href='pdrisksortcaledit.jsp'">
				</td>
			</tr>
		</table>
		</div>
	
  </body>
</html>
