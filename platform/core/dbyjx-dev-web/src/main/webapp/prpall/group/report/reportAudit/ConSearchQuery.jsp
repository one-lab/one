<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看契调信息</title>
    
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
	<div style = "width:100%">
		<table>
			<tr>
				<td colspan="6" >影像件图片信息</td>
			</tr>
		</table>
		<br><br><br><br><br><br><br><hr>	
		<table id="prpallSearchInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     契调信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="32%">通知书流水号</td>
					<td width="30%">下发人</td>
					<td width="30%">下发日期</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>PR42145123515</td>
					<td>李四</td>
					<td>2012-06-01</td>
				</tr>
			</tbody>
		</table>
		
		<table id="ReportCompanyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" >其他契调项目</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="OtherPrpallSearch" cols="100%" rows="5" witdh=100%></textarea></td>
			</tr>
			<tr>
				<td colspan="6" >契调结论</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="PrpallSearchResult" cols="100%" rows="5" witdh=100%></textarea></td>
			</tr>			
		</table>
		<br />
		<table id="UplodeInfor" class="common" cellpadding="3" cellspacing="0">
			<thead>
			<tr>
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     上载信息查看</td>
			</tr>
			<tr class="tableHead">
				<td width="3%">&nbsp;</td>
				<td width="5%">序号</td>
				<td width="18%">呈报申请号</td>
				<td width="18%">上载批次号</td>
				<td width="18%">经办人</td>
				<td width="18%">上载日期</td>
				<td width="20%">下载</td>
			</tr>
			<thead>
			<tbody>
			<tr class="content">
				<td>1</td>
				<td>1</td>
				<td>S11111111111</td>
				<td>S11111111111_1</td>
				<td>Andy</td>
				<td>2012-05-15</td>
				<td>S11111111111_1.excel</td>
			</tr>
			</tbody>
			<table>
				<tr>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
				</tr>
			</table>
		</table>
		<hr>
		<table  id="ButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button"  name="returnButton" class="cssbutton" value="返  回" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>		
	</div>
	</form>
  </body>
</html>
