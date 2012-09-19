<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>整单风险信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="common/js/SimpleCalendar.js"></script>

  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
		<div id="riskInfo" style="width:70%">
			<table id="OccationtypeInfo" class="common" cellpadding="3" cellspacing="0">
				<thead>
					<tr>
						<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     1）保险层级分布</td>
					</tr>
					<tr class="tableHead">
						<td width="5%">序号</td>
						<td width="32%">层级名称</td>
						<td width="32%">层级人数</td>
						<td width="31%">层级险种-保费</td>
					</tr>
				</thead>
				<tbody>
					<tr class="content">
						<td>1</td>
						<td>&nbsp;</td>
						<td>10</td>
						<td>0601 - 2300</td>
					</tr>
				</tbody>
				<tbody>
					<tr class="content">
						<td>2</td>
						<td>&nbsp;</td>
						<td>10</td>
						<td>0619 - 372.8</td>
					</tr>
				</tbody>
			</table>
			<br>
			<table id="PeopleAgeInfo" class="common" cellpadding="3" cellspacing="0">
				<thead>
					<tr>
						<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     2）主被保险人职业类别分布</td>
					</tr>
					<tr class="tableHead">
						<td width="5%">序号</td>
						<td width="10%">职业类别</td>
						<td width="12%">人数</td>
						<td width="10%">占主被保险人数</td>
					</tr>
				</thead>
				<tbody>
					<tr class="content">
						<td>1</td>
						<td>1类职业</td>
						<td>10</td>
						<td>100%</td>
					</tr>
				</tbody>
				<tbody>
					<tr class="content">
						<td>2</td>
						<td>2类职业</td>
						<td>0</td>
						<td>0%</td>
					</tr>
				</tbody>
				<tbody>
					<tr class="content">
						<td>3</td>
						<td>3类职业</td>
						<td>0</td>
						<td>0%</td>
					</tr>
				</tbody>
				<tbody>
					<tr class="content">
						<td>4</td>
						<td>4类职业</td>
						<td>0</td>
						<td>0%</td>
					</tr>
				</tbody>
				<tbody>
					<tr class="content">
						<td>5</td>
						<td>5类职业</td>
						<td>0</td>
						<td>0%</td>
					</tr>
				</tbody>
				<tbody>
					<tr class="content">
						<td>6</td>
						<td>6类职业</td>
						<td>0</td>
						<td>0%</td>
					</tr>
				</tbody>	
				<tbody>
					<tr class="content">
						<td>7</td>
						<td>7类职业</td>
						<td>0</td>
						<td>0%</td>
					</tr>
				</tbody>			
			</table>
			<table id="PeopleSexInfo" class="common" cellpadding="3" cellspacing="0">
				<thead>
					<tr>
						<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     3）险种大类费率折扣分布</td>
					</tr>
					<tr class="tableHead">
						<td width="5%">序号</td>
						<td width="50%">险种大类</td>
						<td width="45%">折扣比例</td>
					</tr>
				</thead>
				<tbody>
					<tr class="content">
						<td>1</td>
						<td>健康险</td>
						<td>1</td>
					</tr>
				</tbody>
			</table>
		</div>
		<hr>
		<div id="messageInfo" style = "width:100%">
			<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td>
						<input type="button" class="cssbutton" name="QueryButton" value="查询年龄，性别，累计风险保费分布 " onclick="">
						<input type="button" class="cssbutton" name="ApplyButton" value="返  回 " onclick="javascript:history.go(-1);">
					</td>
				</tr>
			</table>
		</div>
	</form>
  </body>
</html>
