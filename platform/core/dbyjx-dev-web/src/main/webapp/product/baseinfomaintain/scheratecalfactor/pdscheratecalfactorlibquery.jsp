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
    
    <title>费率表要素库</title>
    
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
	<div style = "width:70%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td align="right" colspan="4">
					<input type = "button" class="cssbutton" name="SaveButton" value="保  存" onclick="">
					<input type = "button" class="cssbutton" name="EditButton" value="修  改" onclick="">
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="">
					<input type = "button" class="cssbutton" name="DeleteButton" value="删  除" onclick="">
				</td>
			</tr>
			<tr>
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">费率表要素库建设</td>
			</tr>
			<tr>
				<td class="left">要素名称</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">要素代码</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>			
			</tr>
			<tr>
				<td class="left">要素数据类型</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">费率表要素查询结果</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="30%">要素名称</td>
					<td width="30%">要素代码</td>
					<td width="30%">要素数据类型</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>保额</td>
					<td>Amnt</td>
					<td>decimal(16,2)</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>2</td>
					<td>保费</td>
					<td>Prem</td>
					<td>decimal(16,2)</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>3</td>
					<td>档次</td>
					<td>Mult</td>
					<td>smallint</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>4</td>
					<td>年龄</td>
					<td>Age</td>
					<td>smallint</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>5</td>
					<td>性别</td>
					<td>Sex</td>
					<td>char(1)</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>6</td>
					<td>职业类别</td>
					<td>OccupationType</td>
					<td>char(1)</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>7</td>
					<td>缴费频次</td>
					<td>PayIntv</td>
					<td>char(1)</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>8</td>
					<td>份数</td>
					<td>copys</td>
					<td>smallint</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>9</td>
					<td>建工险专用要素</td>
					<td>ArchiSpec</td>
					<td>smallint</td>
				</tr>
			</tbody>
			<table id="PageInfo2" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" ></td>
					<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
				</tr>
			</table>
		</table>
		</div>
	</form>
  </body>
</html>
