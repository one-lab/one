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
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript">
	     ctx = "${ctx}";
    </script>
    <script type="text/javascript" src="${ctx}/prpall/group/artificalUW/js/IndUWInfoDeal.js"></script>
  </head>
  <body>
    <form name="fm" id="fmSearchInfo" method="post"">
		<div id="messageInfo" style = "width:100%">
			<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">投保单位信息</td>
				</tr>
				<tr> 
					<td class="left">投保单位：</td>
					<td class="right"><input name="name" class="common" type="text" value="${lcGrpAppnt.name }" readonly></td>
					<td class="left">电话：</td>
					<td class="right"><input name="phone" class="common" type="text" value="${lcGrpAppnt.phone }" readonly></td>
					<td class="left">单位地址：</td>
					<td class="right"><input name="postalAddress" class="common" value="${lcGrpAppnt.postalAddress }" type="text" readonly></td>
				</tr>
				<tr> 
					<td class="left">邮政编码：</td>
					<td class="right"><input name="zipCode" class="common" type="text" value="${lcGrpAppnt.zipCode }" readonly></td>
					<td class="left">业务员编码：</td>
					<td class="right"><input name="operator" class="common" type="text" value="${lcCont.operator }" readonly></td>
					<td class="common"></td>
					<td class="common"></td>
				</tr>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">个人合同信息</td>
				</tr>
				<tr> 
					<td class="left">姓名：</td>
					<td class="right"><input name="appntName" class="common" type="text" value="${lcCont.appntName }" readonly></td>
					<td class="left">性别：</td>
					<td class="right"><input name="appntSex" class="common" type="text" value="${lcCont.appntSex }" readonly></td>
					<td class="left">出生日期：</td>
					<td class="right"><input name="insuredBirthday" class="common" type="text" value="${lcCont.insuredBirthday }" readonly></td>
				</tr>
				<tr> 
					<td class="left">证件类型：</td>
					<td class="right">
						<input id="insuredIDType" name="insuredIDType" class="codecode" type="text" value="${lcCont.insuredIDType }" ondblclick="queryCode('insuredIDType','idTypeName','PDLDcode1','codeType:IDType')" style="width:20%"><input id="idTypeName" name="idTypeName" class="common" type="text" style="width:68%"></td>
						<!-- <input name="appntIDType" class="common" type="text" value="${lcCont.appntIDType }" readonly></td>    -->
					<td class="left">证件号：</td>
					<td class="right"><input name="insuredIDNo" class="common" type="text" value="${lcCont.insuredIDNo }" readonly></td>
					<td class="left">职业类别：</td>
					<td class="right"><input name="occupationType" class="common" type="text" value="${lcAppnt.occupationType }" readonly></td>
				</tr>
			</table>
			<hr><br>
		</div>
		<br>
		<div id="riskInfo" style="width:90%">
			<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
				<thead>
					<tr>
						<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种查询结果</td>
					</tr>
					<tr class="tableHead">
						<td width="3%">&nbsp;</td>
						<td width="5%">序号</td>
						<td width="13%">险种编码</td>
						<td width="14%">核保结论</td>
						<td width="13%">投保人</td>
						<td width="13%">被保人</td>
						<td width="13%">份数</td>
						<td width="13%">保费</td>
						<td width="13%">保额</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lcPolList }" var="temp" varStatus="tempStatus">
						<tr class="content">
							<td><input name="CheckRadio" type="radio" value="" /></td>
							<td>${tempStatus.count }</td>
							<td>${temp.riskCode }</td>
							<td>${temp.uwFlag }</td>
							<td>${temp.appntName }</td>
							<td>${temp.insuredName }</td>
							<td>${temp.mult }</td>
							<td>${temp.prem }</td>
							<td>${temp.amnt }</td>
						</tr>
					</c:forEach>
				<!-- 
					<tr class="content">
						<td><input name="CheckRadio" type="radio" value="" /></td>
						<td>1</td>
						<td>211301</td>
						<td>核保通过</td>
						<td>麦肯基</td>
						<td>麦肯基</td>
						<td>1</td>
						<td>50</td>
						<td>20000</td>
					</tr>
					 -->
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
		</div>
		<hr>
		<div id="messageInfo" style = "width:100%">
			<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td>
						<input type = "button" class="cssbutton" name="ApplyButton" value="个人保单明细信息 " onclick="">
						<input type = "button" class="cssbutton" name="ApplyButton" value="被保人保额累计信息" onclick="">
						<input type = "button" class="cssbutton" name="ApplyButton" value="被保人已承保保单查询" onclick="">
					</td>
				</tr>
				<tr>
					<td>
						<input type = "button" class="cssbutton" name="ApplyButton" value="被保人未承保保单查询 " onclick="">
						<input type = "button" class="cssbutton" name="ApplyButton" value="被保人既往保全查询" onclick="">
						<input type = "button" class="cssbutton" name="ApplyButton" value="被保人既往理赔查询" onclick="">
					</td>
				</tr>
				<tr>
					<td>
						<input type = "button" class="cssbutton" name="ApplyButton" value="体检资料查询 " onclick="">
						<input type = "button" class="cssbutton" name="ApplyButton" value="体检资料录入" onclick="location.href='./PhysicalExamInput.jsp'">
						<input type = "button" class="cssbutton" name="ApplyButton" value="契调资料录入" onclick="searchInfoInput()">
					</td>
				</tr>
			</table>
		</div>
		<hr>
		<div id="messageInfo" style = "width:80%">
			<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">个人单核保结论</td>
				</tr>
				<tr> 
					<td width="40%" class="left">个人单核保结论：</td>
					<td width="40%" class="right">
						<input id="artificalPersonResultCode" name="artificalPersonResultCode" class="codecode" type="text" onchange="clickable()" ondblclick="queryCode('artificalPersonResultCode','artificalPersonResultContext','PDLDcode1','codeType:UWFlag')" style="width:20%"><input id="artificalPersonResultContext" name="artificalPersonResultContext" class="common" type="text" onchange="clickable()" style="width:68%">
					</td>
					<td width="10%" class="common"></td>
					<td width="10%" class="common"></td>
				</tr>
			</table>
			<hr>
			<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td>
						<input type = "button" class="cssbutton" name="PrpallInput" value="个单加费承保录入" onclick="">
						<input type = "button" class="cssbutton" name="SpecialInput" value="个单特约承保录入" onclick="">
					</td>
				</tr>
			</table>
			<hr>
			<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td>个人单核保意见（500字以内，回车符占一个字节）<input id="contNo" name="contNo" type="hidden" value="${lcCont.contNo }"/></td>
				</tr>
				<tr>
					<td><textarea id="artificalPersonIdea" name="artificalPersonIdea" cols="100%" rows="5" ></textarea></td>
				</tr>
			</table>
			<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td>
						<input id="artificalPersonSubmit" type = "button" class="cssbutton" name="ConSubmit" value="个单核保确定" onclick="saveArtificalUWPersonResultAndIdea()">
						<input type = "button" class="cssbutton" name="ReturnBack" value="返  回" onclick="javascript:history.go(-1);">
					</td>
				</tr>
			</table>
		</div>
	</form>
  </body>
</html>
