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
    
    <title>特殊赔付定义</title>
    
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
	<div style = "width:31%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">险种编码：</td>
				<td class="right"><input name="" class="common" type="text"></td>
			</tr>
		</table>
	</div>
	<div style = "width:100%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="2" align="right"">
					<input type = "button" class="cssbutton" name="Button" value="保存" onclick="">
					<input type = "button" class="cssbutton" name="Button" value="修改" onclick="">
				</td>
			</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">扩充计算公式定义</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="19%">属性名称</td>
					<td width="19%">属性数据类型</td>
					<td width="19%">属性值</td>
					<td width="19%">官方字段描述</td>
					<td width="19%">业务人员备注</td>
				</tr>
			</thead>
			<tbody align="center">
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>给付代码</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>必填</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>2</td>
					<td>给付名称</td>
					<td>VARCHAR2(120)</td>
					<td>&nbsp;</td>
					<td>必填</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>3</td>
					<td>给付责任类型</td>
					<td>CAHR(6)</td>
					<td>&nbsp;</td>
					<td>X01--残疾金</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>4</td>
					<td>算法1</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>限分配的公式</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>5</td>
					<td>算法2</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>投保后未成年出险理赔</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>6</td>
					<td>算法3</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>保额的不用于理赔权限</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>7</td>
					<td>算法4</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>8</td>
					<td>算法5</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>9</td>
					<td>算法6</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>10</td>
					<td>算法7</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>11</td>
					<td>算法8</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>12</td>
					<td>算法9</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>13</td>
					<td>算法10</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Button" value="进入算法定义" onclick="location.href='pdcaledit.jsp'">
				</td>
			</tr>
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Button" value="返回" onclick="javascript:history.back()">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
