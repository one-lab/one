<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>签发保单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript">ctx = "${ctx}";</script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/sign/sign.js"></script>	
  </head>
  <body>
    <form id="fm" name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     请输入查询集体条件</td>
			</tr>
			<tr> 
				<td class="left">集体投保单号码：</td>
				<td class="right"><input name="lcGrpCont.grpContNo" class="common" value='<s:if test="#request.lcGrpCont==null" ><s:property value=""/></s:if><s:else><s:property value="#request.lcGrpCont.grpContNo"/></s:else>' type="text"></td>
				<td class="left">管理机构：</td>
				<td class="right">
				<input type="hidden" id ="upperComCode" value='<s:property value="#session.prpDcompany.comCode"/>'/>  
				<input class="codecode" id="comCode" name="lcGrpCont.manageCom" class="common" type="text" ondblclick="queryCode('comCode','comName','PrpDcompany','comCode:comCode|upperComCode:upperComCode')" value='<s:if test="#request.lcGrpCont==null" ><s:property value=""/></s:if><s:else><s:property value="#request.lcGrpCont.manageCom"/></s:else>' style="width:20%" ><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value='<s:property value="#session.prpDcompany.comCName"/>' ><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td class="left">投保单位名称：</td>
				<td class="right"><input name="lcGrpCont.grpName" class="common" value='<s:if test="#request.lcGrpCont==null" ><s:property value=""/></s:if><s:else><s:property value="#request.lcGrpCont.grpName"/></s:else>' type="text"></td>
				<td class="left">代理人编码：</td>
				<td class="right"><input class="codecode" id="agentcode" name="lcGrpCont.agentCode" class="common" type="text" value='<s:if test="#request.lcGrpCont==null" ><s:property value=""/></s:if><s:else><s:property value="#request.lcGrpCont.agentCode"/></s:else>' style="width:20%" ondblclick="queryCode('agentcode','agentName','PDLDcode1','codeType:MainAgent')" ><input id="agentName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="findProposalSignInfo()">
				</td>
			</tr>
		</table>
		<br>
		<div style="width:75%" id="divInfor">
			<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
				<thead>
					<tr>
						<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     集体信息</td>
					</tr>
					<tr class="tableHead">
						<td width="3%">&nbsp;</td>
						<td width="5%">序号</td>
						<td width="23%">集体投保单号码</td>
						<td width="23%">投保单位名称</td>
						<td width="23%">管理机构</td>
						<td width="23%">代理人编码</td>
					</tr>
				</thead>
				<tbody>
			   <s:iterator value="ProposalSignPage.result" var="temp" status="index">
			   <tr class="content">
				<td width="4%"><input type='radio' name='lcGrpCont.proposalGrpContNo' value='<s:property value="#temp.grpContNo" />' /></td>
				<td width="5%"><s:property value="#index.count"/></td>
				<td width="15%"><s:property value="#temp.grpContNo" /></td>
				<td width="20%"><s:property value="#temp.grpName" /></td>
				<td width="15%"><s:property value="#temp.manageCom" /></td>
				<td width="15%"><s:property value="#temp.agentcode" /></td>
			  </tr>	
			  </s:iterator>		
				</tbody>
			</table>
			<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick="location.href='ReportAuditDeal.jsp'"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
				</tr>
			</table>			
		</div>
		<br>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type = "button" class="cssbutton" name="ApplyButton" value="签发保单" onclick="saveSignInfo()"></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
