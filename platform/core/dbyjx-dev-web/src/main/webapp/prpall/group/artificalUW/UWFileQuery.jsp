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
    
    <title>核保件查看</title>
    
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
    
    <script type="text/javascript" src="${ctx }/prpall/group/artificalUW/js/UWFileQuery.js"></script>

  </head>
  <body>
    <form id="fmUWFile" name="fmUWFile" method="post" onkeypress="KeyDown()">
		<div id="messageInfo" style = "width:100%">
			<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">团体投保单信息</td>
				</tr>
				<tr> 
					<td class="left">投保单号：</td>
					<td class="right"><input id="grpContNo" name="lcGrpCont.grpContNo" class="common" type="text" readOnly value="${artificalUWDealVo.grpContNo }"></td>
					<td class="left">呈报申请号：</td>
					<td class="right"><input name="reportNo" class="common" type="text" readOnly value="${artificalUWDealVo.reportNo }"></td>
					<td class="left">续保原保单号：</td>
					<td class="right"><input name="cregistNo" class="common" type="text" readOnly value="${artificalUWDealVo.cregistNo }"></td>
				</tr>
				<tr> 
					<td class="left">投保日期：</td>
					<td class="right">
						<input name="proposalDate" id="proposalDate" class="common" type="text" readOnly style="width: 73%" value="${artificalUWDealVo.firstTrialDate }">
						<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'proposalDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
					</td>
					<td class="left">保单生效日期：</td>
					<td class="right">
						<input name="validDate" id="validDate" class="common" type="text" readOnly style="width: 73%" value="${artificalUWDealVo.cvaliDate }">
						<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'validDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
					</td>
					<td class="left">管理机构：</td>
					<td class="right">
						<input type="hidden" id="upperComCode" value='2110000000' />
						<input class="codecode" id="manageCom" name="manageCom" class="codecode" type="text" onchange="clickable()" value="${artificalUWDealVo.manageCom }" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','comCode:manageCom|upperComCode:upperComCode');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="${artificalUWDealVo.manageName }"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				</tr>
				<tr> 
					<td class="left">销售渠道：</td>
					<td class="right"><input name="ManageCom" class="common" type="text" readOnly value="${artificalUWDealVo.saleChnl }"></td>
					<td class="left">投保单位客户号码 ：</td>
					<td class="right"><input name="appntNo" class="common" type="text" readOnly value="${artificalUWDealVo.appntNo }"></td>
					<td class="left">投保单位全称：</td>
					<td class="right"><input name="grpName" class="common" type="text" readOnly value="${artificalUWDealVo.grpName }"></td>
				</tr>
				<tr>
					<td class="left">VIP标记：</td>
					<td class="right"><input name="vipValue" class="common" type="text" readOnly value="${artificalUWDealVo.vipValue }"></td>
					<td class="common"></td>
					<td class="common"></td>
					<td class="common"></td>
					<td class="common"></td>
				</tr>
			</table>
			<hr><br>
			<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
				<tr> 
					<td class="left">主揽业务员：</td>
					<td class="right"><input name="sale" class="common" type="text" readOnly value="吴尊"></td>
					<td class="left">主揽业务员姓名：</td>
					<td class="right"><input name="saleName" class="common" type="text" readOnly value="吴尊"></td>
					<td class="left">所属机构：</td>
					<td class="right"><input name="comCode" class="common" type="text" readOnly value="都邦保险"></td>
				</tr>
				<tr> 
					<td class="left">所属分布：</td>
					<td class="right"><input name="ManageCom" class="common" type="text" readOnly value="北京分部"></td>
					<td class="common"></td>
					<td class="common"></td>
					<td class="common"></td>
					<td class="common"></td>
				</tr>
			</table>
		</div>
		<br>
		<div id="riskInfo" style="width:80%">
			<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
				<thead>
					<tr>
						<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     团体投保单险种信息</td>
					</tr>
					<tr class="tableHead">
						<td width="3%">&nbsp;</td>
						<td width="5%">序号</td>
						<td width="10%">险种编码</td>
						<td width="12%">险种名称</td>
						<td width="10%">缴费周期</td>
						<td width="10%">投保人数</td>
						<td width="10%">总保额</td>
						<td width="10%">保险起期</td>
						<td width="10%">保险止期</td>
						<td width="10%">应交保费</td>
						<td width="10%">折扣费率</td>				
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${artificalUWPolVolist }" var="temp" varStatus="tempStatus">
					<tr class="content">
						<td><input name="CheckRadio" type="radio" value="" /></td>
						<td>${tempStatus.count }</td>
						<td>${temp.riskCode }</td>
						<td>${temp.riskName }</td>
						<td>${temp.payIntv }${temp.payYears }</td>
						<td>${temp.peoples }</td>
						<td>${temp.amnt }</td>
						<td>${temp.firstPayDate }</td>
						<td>${temp.payEndDate }</td>
						<td>${temp.prem }</td>
						<td>${temp.discountRate }</td>
					</tr>
				</c:forEach>
				
				</tbody>
			</table>
			<br>
		</div>
		<hr>
		<!-- 隐藏域：隐藏录入位置 -->
		<input type="hidden" id="inputLocation" value="05"><!-- "05"表示在人工核保时进行问题件录入 -->
		<div id="messageInfo" style = "width:100%">
			<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td colspan="6">
						<input type = "button" class="cssbutton" name="ApplyButton" value="团体扫描件查询" onclick="">
						<input type = "button" class="cssbutton" name="ApplyButton" value="团体已承保保单查询" onclick="">
						<input type = "button" class="cssbutton" name="ApplyButton" value="团体未承保保单查询" onclick="">
						<input type = "button" class="cssbutton" name="ApplyButton" value="团体问题件查询" onclick="findGrpIssueFile()">
						<input type = "button" class="cssbutton" name="ApplyButton" value="团体既往理赔查询" onclick="">
						<input type = "button" class="cssbutton" name="ApplyButton" value="团体既往保全查询" onclick="">
						<input type = "button" class="cssbutton" name="ApplyButton" value="团体体检结论查询" onclick="">
					</td>
				</tr>
				<tr>
					<td colspan="6">
						<input type = "button" class="cssbutton" name="ApplyButton" value="团体契调结论查询 " onclick="findGrpSearchInfoQuery()">
						<input type = "button" class="cssbutton" name="ApplyButton" value="呈报件查询" onclick="location.href='../report/reportInput/ReportAdd.jsp'">
					</td>
				</tr>
			</table>
			<br>
			<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td colspan="6">
						<input type = "button" class="cssbutton" name="ApplyButton" value="团体保单明细" onclick="">
						<input type = "button" class="cssbutton" name="ApplyButton" value="自动核保信息" onclick="autoUWInfo()">
						<input type = "button" class="cssbutton" name="ApplyButton" value="整单风险要素" onclick="location.href='./EntireProposalRiskInfo.jsp'">
						<input type = "button" class="cssbutton" name="ApplyButton" value="险种风险要素" onclick="location.href='./KindRiskInfo.jsp'">
					</td>
				</tr>
				<tr>
					<td colspan="6">
						<input type = "button" class="cssbutton" name="ApplyButton" value="问题件录入" onclick="issueInput()">
						<input type = "button" class="cssbutton" name="ApplyButton" value="问题件下发" onclick="">
						<input type = "button" class="cssbutton" name="ApplyButton" value="个人核保信息处理" onclick="PersonProposalInfoProcess()">
						<input type = "button" class="cssbutton" name="ApplyButton" value="体检/契调件下发" onclick="">
					</td>
				</tr>		
			</table>
		</div>
		<input id="UWFileQueryButton" type="button" value="返回" onclick="javascript:history.go(-1);"/>
	</form>
  </body>
</html>
