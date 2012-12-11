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
    
    <title>个人核保信息处理</title>
    
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
	<script src="${ctx}/prpall/group/artificalUW/js/InsuredSelect.js"></script>
	
  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
		<div id="messageInfo" style = "width:100%">
			<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     请输入查询条件</td>
				</tr>
				<tr> 
					
					<td class="left">被保人姓名：<input id="grpContNo" name="grpContNo" class="common" type="hidden" value='${param.grpContNo }'></td>
					<td class="right"><input id="name" name="name" class="common" type="text"></td>
					<td class="left">证件类型：</td>
					<td class="right"><input id="idType" name="idType" class="codecode" type="text" value="0" ondblclick="queryCode('idType','idTypeName','PDLDcode1','codeType:IDType')" style="width:20%"><input id="idTypeName" name="idTypeName" class="common" type="text" value="身份证" style="width:68%"></td>
					<td class="left">证件号码：</td>
					<td class="right"><input id="idNo" name="idNo" class="common" type="text"></td>
				</tr>
				<tr> 
					<!-- 
					<td class="left">特约标记：</td>
					<td class="right"><input name="ManageCom" class="common" type="text"></td>
					 -->
					<td class="left">管理机构：</td>
					<td class="right">
						<input type="hidden" id="upperComCode" value='2110000000' />
						<input class="codecode" id="manageCom" name="manageCom" class="codecode" type="text" onchange="clickable()" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','comCode:manageCom|upperComCode:upperComCode');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
					<td class="left">保险计划：</td>
					<td class="right"><input id="contPlanCode" name="contPlanCode" class="common" type="text"></td>
				</tr>
				<!-- 
				<tr> 
					<td class="left">加费标记：</td>
					<td class="right"><input name="ManageCom" class="common" type="text"></td>
					<td class="left">个人告知：</td>
					<td class="right"><input name="GrpContNo" class="common" type="text"></td>
					<td class="left">有否影像：</td>
					<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				</tr>
				 -->
			</table>
			<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td>
						<input type = "button" class="cssbutton" name="ApplyButton" value="查  询" onclick="findArtificalUWContInfo()">
					</td>
				</tr>
			</table>
			<br>
		</div>
		<br>
		<div id="riskInfo" style="width:70%">
			<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
				<thead>
					<tr>
						<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     保单查询结果</td>
					</tr>
					<tr class="tableHead">
						<td width="3%">&nbsp;</td>
						<td width="5%">序号</td>
						<td width="17%">个人投保单号</td>
						<td width="15%">核保结论</td>
						<td width="15%">被保人</td>
						<td width="15%">管理机构</td>
						<td width="15%">保险计划</td>
						<td width="15%">个人加费</td>
					</tr>
				</thead>
				<tbody id="content">
				<!-- 
					<tr class="content">
						<td><input name="CheckRadio" type="radio" value="" /></td>
						<td>1</td>
						<td><a href="javascript:void(0)" onclick="location.href='./IndUWInfoDeal.jsp'">202123832198778321</a></td>
						<td>核保通过</td>
						<td>麦肯基</td>
						<td>860301</td>
						<td>01</td>
						<td>50</td>
					</tr>
					 -->
				</tbody>
				<table id="PageI1nfo1" class="common" cellpadding="3" cellspacing="0">
					<tr>
						<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick="location.href='ReportAuditDeal.jsp'"></td>
						<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
						<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
						<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
					</tr>
				</table>
				<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td>
						<input type = "button" class="cssbutton" name="ArtificalUWStart" value="开始核保" onclick="artificalUWStart()">
					</td>
				</tr>
			</table>
			</table>
			<br>
		</div>
		<hr>
		<div id="messageInfo" style = "width:100%">
			<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td>
						<input type = "button" class="cssbutton" name="ApplyButton" value="返  回 " onclick="javascript:history.go(-1);">
					</td>
				</tr>
			</table>
		</div>
	</form>
  </body>
</html>
