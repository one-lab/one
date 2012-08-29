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
    
    <title>自动核保信息查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="common/js/SimpleCalendar.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript">
	     ctx = "${ctx}";
    </script>

  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">

	<div style = "width:100%">
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     团单自动核保信息</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="19%">投保单号</td>
					<td width="19%">险种编码</td>
					<td width="19%">核保顺序号</td>
					<td width="19%">核保意见</td>
					<td width="19%">核保日期</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${grpInfoList }" var="temp" varStatus="tempStatus">
					<tr class="content">
						<td>${tempStatus.count }</td>
						<td>${temp.grpContNo }</td>
						<td>${temp.riskCode }</td>
						<td>${temp.uwSN }</td>
						<td>${temp.remark }</td>
						<td>${temp.uwDate }</td>
					</tr>
				</c:forEach>
				<%-- <tr class="content">
					
				</tr>--%>
				
				 
			</tbody>
			<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick="location.href='ReportAuditDeal.jsp'"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
				</tr>
			</table>
		</table>
		<br>
		
		<table id="scanApplycInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     个单自动核保信息</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="13%">投保单号</td>
					<td width="13%">被保险人序号</td>
					<td width="13%">被保险人姓名</td>
					<td width="13%">险种编码</td>
					<td width="13%">核保顺序号</td>
					<td width="17%">核保意见</td>
					<td width="13%">核保日期</td>
				</tr>
			</thead>
			<tbody> 
			<c:forEach items="${personInfoList }" var="temp" varStatus="tempStatus">
				<tr class="content">
					<td>${tempStatus.count }</td>
					<td>${temp.contNo }</td>
					<td>${temp.insuredNo }</td>
					<td>${temp.insuredName }</td>
					<td>${temp.riskCode }</td>
					<td>${temp.uwSN }</td>
					<td>${temp.remark }</td>
					<td>${temp.uwDate }</td>
				</tr>
			</c:forEach>
			<!-- 
				<tr class="content">
					<td>1</td>
					<td>G86012012005</td>
					<td>2112</td>
					<td>萧蔷</td>
					<td>211301</td>
					<td>4645343</td>
					<td>核保通过</td>
					<td>012-05-18</td>
				</tr>
				 -->
			</tbody>
			<table id="PageInfo2" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick="location.href='ReportAuditDeal.jsp'"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
				</tr>
			</table>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type = "button" class="cssbutton" name="ApplyButton" value="返  回" onclick="javascript:history.go(-1);"></td>
			</tr>
		</table>	
	</div>

	</form>
  </body>
</html>
