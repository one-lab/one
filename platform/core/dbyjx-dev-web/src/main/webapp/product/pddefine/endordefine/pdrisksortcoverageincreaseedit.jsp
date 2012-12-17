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
    <title>险种保额递增表</title>
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
				<td class="left">描述表名称</td>
				<td class="right"><input name="" class="common" type="text"/></td>
			</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">产品责任信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="23%">险种编码</td>
					<td width="23%">责任编码</td>
					<td width="23%">责任名称</td>
					<td width="23%">责任缴费代码</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>2</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种保额递增描述</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="19%">属性名称</td>
					<td width="19%">属性数据类型</td>
					<td width="19%">属性值</td>
					<td width="19%">官方字段描述</td>
					<td width="19%">业务人员备注</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>险种编码</td>
					<td>VARCHAR2(8)</td>
					<td>自动带出</td>
					<td>只读</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>2</td>
					<td>责任编码</td>
					<td>VARCHAR2(6)</td>
					<td>自动带出</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>3</td>
					<td>递增范围</td>
					<td>VARCHAR2(1)</td>
					<td>&nbsp;</td>
					<td>2-续保时</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>4</td>
					<td>递增算法</td>
					<td>VARCHAR2(1000)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已保存字段参数</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="13%">险种编码</td>
					<td width="13%">险种版本</td>
					<td width="13%">责任代码</td>
					<td width="13%">保全类型</td>
					<td width="13%">计算类型</td>
					<td width="13%">算法编码</td>
					<td width="13%">说明</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>&nbsp;</td>
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
