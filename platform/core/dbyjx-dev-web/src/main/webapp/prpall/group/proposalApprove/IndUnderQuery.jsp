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
    
    <title>个人已承包保单查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/proposalApprove/js/IndUnderQuery.js"></script>

  </head>
  <body>
    <form name="fm" >
	<div style = "width:100%">
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     原客户信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="20%">客户号</td>
					<td width="15%">姓名</td>
					<td width="10%">性别</td>
					<td width="15%">出生日期</td>
					<td width="10%">证件类型</td>
					<td width="22%">证件号码</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="not empty(ldPersonList)">
					<s:iterator value="ldPersonList" var="ldPerson" status="s">
						<tr class="content">
							<td><input name="ldPersonRadio" type="radio" value='<s:property value="#ldPerson.customerNo"/>' /></td>
							<td><s:property value="#s.count"/></td>
							<td><s:property value="#ldPerson.customerNo"/></td>
							<td><s:property value="#ldPerson.name"/> </td>
							<td><s:property value="#ldPerson.sex"/></td>
							<td><s:property value="#ldPerson.birthday"/></td>
							<td><s:property value="#ldPerson.idType"/></td>
							<td><s:property value="#ldPerson.idNo"/></td>					
						</tr>
						</s:iterator>
				</s:if>
				<s:else>
				<tr class="content">
							<td colspan="8">暂无信息</td>			
						</tr>
				</s:else>			
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
		<table id="scanApplycInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     重复客户信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="15%">个人保单号</td>
					<td width="15%">客户号</td>
					<td width="15%">姓名</td>
					<td width="5%">性别</td>
					<td width="10%">出生日期</td>
					<td width="10%">证件类型</td>
					<td width="15%">证件号码</td>
					<td width="7%">保额</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="not empty(repeatCustomerInfoList)">
					<s:iterator value="repeatCustomerInfoList" var="repeatCustomerInfo" status="s">
						<tr class="content">
							<td><input name="lcContRadio" type="radio" value='<s:property value="#repeatCustomerInfo.contNo"/>'  onclick="radioButton()"/></td>
							<td><s:property value="#s.count"/></td>
							<td><s:property value="#repeatCustomerInfo[0]"/></td>
							<td><s:property value="#repeatCustomerInfo[1]"/></td>
							<td><s:property value="#repeatCustomerInfo[2]"/></td>
							<td><s:property value="#repeatCustomerInfo[3]"/></td>
							<td><s:property value="#repeatCustomerInfo[4]"/></td>
							<td><s:property value="#repeatCustomerInfo[5]"/></td>							
							<td><s:property value="#repeatCustomerInfo[6]"/></td>
							<td><s:property value="#repeatCustomerInfo[7]"/></td>
						</tr>
					</s:iterator>
				</s:if>
				<s:else>
						<tr class="content">
							<td colspan="9">暂无信息</td>
						</tr>
				</s:else>
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
		<br>
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     合并客户信息</td>
			</tr>
			<tr> 
				<td class="left">原客户号码：</td>
				<td class="right"><input id="oldNo" class="common" type="text"></td>
				<td class="left">合并后客户号码：</td>
				<td class="right"><input id="newNo" class="common" type="text"></td>
			</tr>
		</table>	
		<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" value="合  并" onclick="merge()">
					<input type = "button" class="cssbutton" value="返  回" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>		
	</div>
	</form>
  </body>
</html>
