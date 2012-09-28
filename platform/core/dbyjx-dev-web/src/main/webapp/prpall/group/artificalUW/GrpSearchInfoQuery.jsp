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
    
    <title>团体契调结论查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
    <script src="${ctx}/prpall/group/artificalUW/js/ArtificalUWApply.js"></script>
    <script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript">ctx = "${ctx}";</script>
	<script type="text/javascript" src="${ctx }/prpall/group/artificalUW/js/GrpSearchInfoQuery.js"></script>
  </head>
  <body>
    <form id="issueForm" name="fm" method="post">
	<div style = "width:100%">
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0" style="width:90%">
			<thead>
				<tr>
					<td class="formtitle" colspan="6">团体契调结论查询</td>
				</tr>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     已契调个人保单</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="20%">个人合同号</td>
					<td width="30%">打印流水号</td>
					<td width="20%">代理人编码</td>
					<td width="25%">录入时间</td>
				</tr>
			</thead>
			<tbody id="content">
				<input type="hidden" id="grpContNo" name="lcCont.grpCont" value="${lcGrpCont.grpContNo }"/>
				<s:if test="not empty(lcContList)">
					<s:iterator value="lcContPage.result" var="lcCont" status="s">
						<tr class="content">
							<td>
								<input type="radio" id="lcContRadio" name="lcContRadio" value='<s:property value="#lcCont.contNo"/>'  onclick="findSingleSearchItemList()" />
							</td>
							<td><s:property value="#s.count"/></td>
							<td><s:property value="#lcCont.contNo"/></td>
							<td><s:property value="#lcCont.prtNo"/></td>
							<td><s:property value="#lcCont.agentCode"/></td>
							<td><s:property value="#lcCont.inputDate"/>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#lcCont.inputTime"/></td>
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
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick=""></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0" style="width:90%">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     契调项目</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="20%">契调项目编号</td>
					<td width="20%">契调项目名称</td>
					<td width="55%">备注</td>
				</tr>
			</thead>
			<tbody id="searchItemContent">
				
			</tbody>
		</table>
	</div>
	<input type="button" value="返回" onclick="javascript:history.go(-1);"/>
	</form>
  </body>
</html>
