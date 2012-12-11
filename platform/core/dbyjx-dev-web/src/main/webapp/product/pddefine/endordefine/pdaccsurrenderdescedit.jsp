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
    
    <title>账户退保描述表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">险种编码</td>
				<td class="right"><input name="" class="common" type="text"/></td>
				<td class="left">产品险种名称</td>
				<td class="right"><input name="" class="common" type="text"/></td>		
			</tr>
			<tr>
				<td class="left">保全项目编码</td>
				<td class="right"><input name="" class="common" type="text"/></td>
				<td class="left">保全项目名称</td>
				<td class="right"><input name="" class="common" type="text"/></td>		
			</tr>
		</table>
		</div>
		<div style = "width:50%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">产品保险账户信息</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="45%">险种代码</td>
					<td width="45%">保险账户号码</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		</div>
		<div style = "width:100%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">账户退保描述</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">序号</td>
					<td width="24%">属性名称</td>
					<td width="24%">属性值</td>
					<td width="24%">官方字段描述</td>
					<td width="24%">业务人员备注</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>险种编码</td>
					<td>自动带出</td>
					<td>只读</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>2</td>
					<td>保险账户号码</td>
					<td>自动带出</td>
					<td>最多20个汉字</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>3</td>
					<td>算法编码</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>4</td>
					<td>算法类型</td>
					<td>&nbsp;</td>
					<td>BF--补费</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		</div>
		<div style = "width:70%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已保存字段参数</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="23%">险种编码</td>
					<td width="23%">保险账户号码</td>
					<td width="23%">算法编码</td>
					<td width="23%">算法类型</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" value="" type="radio"/></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="defineButton" value="新增" onclick="">
					<input type = "button" class="cssbutton" name="defineButton" value="修改" onclick="">
					<input type = "button" class="cssbutton" name="defineButton" value="算法定义" onclick="location.href='pdcaledit.jsp'">
				</td>
			</tr>
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="defineButton" value="返回" onclick="javascript:history.back()">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
