<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.*"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>无影像录入申请</title>
    
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
	<script type="text/javascript" src="${ctx}/prpall/group/noImageInput/js/NoImageInputApply.js"></script>
	<script type="text/javascript">
	//根路径
	var ctx = "${ctx}";
	</script>
  </head>
  <body>
    <form  id="writeGrpInfo" name="fm" method="post" action="<%=basePath%>/prpall/findLcGrpContInfo.do">
	<div style = "width:100%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     请输入查询条件</td>
			</tr>
			<tr> 
				<td class="left">管理机构：</td>
					<td class="right">   
					<input type="hidden" id ="upperComCode" value='<s:property value="#session.prpDcompany.comCode"/>'/>                                        <!-- code_CodeSelect(this,'DamageCode',-1,'Y','N','','',''); field, codeType, codeRelation, isClear, isQueryCode, otherCondition, callBackMethod, getDataMethod -->
					<input id="comCode" name="lcGrpCont.manageCom" class="codecode" type="text" 
					ondblclick="queryCode('comCode','comName','PrpDcompany','comCode:comCode|upperComCode:upperComCode')" style="width:20%"  
					value='<s:if test="#request.manageCom==null" ><s:property value="#session.prpDcompany.comCode"/></s:if><s:else><s:property value="#request.manageCom"/></s:else>'>
					<input id='comName' name="comName" class="common" type="text" style="width:68%" value='<s:property value="#session.prpDcompany.comCName"/>' >
					<img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<!--  <td class="right">
				<input type="hidden" id="upperComCode" value='<s:property value="#session.prpDcompany.comCode"/>' />
					<input id="comCode" name="lcGrpCont.manageCom" class="codecode" type="text" 
					ondblclick="queryCode('comCode','comName','PrpDcompany','comCode:comCode|upperComCode:upperComCode')" style="width:20%" 
					value='<s:property value="#session.prpDcompany.comCode"/>' /><input id='comName' name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value='<s:property value="#session.prpDcompany.comCName"/>' ><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				-->
				<td class="left">初审日期：</td>
				<td class="right">
					<input id="firstTrialDate" name="lcGrpCont.firstTrialDate" class="common" type="text"  style="width: 73%" value='<s:if test="#firstTrialDate==null" ><%= new SimpleDateFormat("yyyy-MM-dd").format(new Date())%></s:if><s:else><s:date name="lcGrpCont.firstTrialDate" format="yyyy-MM-dd"/></s:else>'>
					<img style='cursor: hand' align="middle" src="${ctx}/images/bgcalendar.gif" onClick="WdatePicker({el:'firstTrialDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
			<tr>
			<td class="left">投保单号：</td>
				<td class="right"><input id="grpContNo" name="lcGrpCont.grpContNo" class="common" type="text" value='<s:property value="lcGrpCont.grpContNo"/>'></td>
				<td class="left">投保单位全称：</td>
				<td class="right"><input id="grpName" name="lcGrpCont.grpName" class="common" type="text" value='<s:property value="lcGrpCont.grpName"/>'></td>
			</tr>
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="findGrpContInfo();"></td>
			</tr>
		</table>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">投保单信息</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="20%">投保单号</td>
					<td width="25%">管理机构名称</td>
					<td width="20%">初审日期</td>
					<td width="25%">投保单位全称</td>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="page.result" var="temp" status="index">
					  <tr class="content">
						<td width="5%"><input type='radio' name='radioGrpNo' value='<s:property value="#temp.grpContNo" />' /></td>
						<td width="5%"><s:property value="#index.count"/></td>
						<td width="20%"><s:property value="#temp.grpContNo" /></td>
						<td width="25%"><s:property value="#temp.manageCom" /></td>
						<td width="20%"><s:date  name="#temp.firstTrialDate" format="yyyy-MM-dd"/></td>
						<td width="25%"><s:property value="#temp.grpName" /></td>
					  </tr>	
			  	</s:iterator>		
			</tbody>
		</table>
		<div id="pageDiv" align="right">
					<input type="hidden" name="pageNo" id="pageNo" value="${pageNo==null ? 1 : pageNo}" /> 
                    <input type="hidden" name="pageSize" value="${pageSize==null ? 20 : pageSize}" >
			<jsp:include page="/common/pub/page.jsp"></jsp:include>
		</div>	
		<table id="WriteStart" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Start" value="开始录入" onclick="WriteStart()">
				</td>
			</tr>
		</table>	
	</div>
	</form>
	
  </body>
</html>
