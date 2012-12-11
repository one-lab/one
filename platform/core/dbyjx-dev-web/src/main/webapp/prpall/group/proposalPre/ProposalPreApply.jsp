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
    
    <title>投保单初审任务申请</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- <link href="common/css/Standard.css" rel="stylesheet" type="text/css" /> -->
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript">ctx = "${ctx}";</script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/proposalPre/ProposalPreApply.js"></script>	
	<!--<script src="common/js/SimpleCalendar.js"></script> -->
    
  </head>
  <body>
    <form id="fm" name="fm"  method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="proposalAppInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     请输入投保单号（首次申请录入投保单号即可）</td>
			</tr>
			<tr> 
				<td class="left">管理机构：</td>
				<td class="right">
				<input type="hidden" id ="upperComCode" value='<s:property value="#session.prpDcompany.comCode"/>'/>  
				<input id="comCode" name="lcGrpCont.manageCom" class="codecode" type="text" ondblclick="queryCode('comCode','comName','PrpDcompany','comCode:comCode|upperComCode:upperComCode')" style="width:20%" value='<s:if test="#request.lcGrpCont==null" ><s:property value="#session.prpDcompany.comCode"/></s:if><s:else><s:property value="#request.lcGrpCont.manageCom"/></s:else>'><input id='comName' name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value='<s:property value="#session.prpDcompany.comCName"/>'  ><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">投保单号：</td>
				<td class="right"><input id="GrpContNo" name="lcGrpCont.grpContNo" class="common" type="text" value='<s:if test="#request.lcGrpCont==null" ><s:property value=""/></s:if><s:else><s:property value="#request.lcGrpCont.grpContNo"/></s:else>' ></td>
			</tr>
			<tr>
				<td class="left">初审日期：</td>
				<td class="right">
					<input id="repApplyDate" name="lcGrpCont.firstTrialDate" class="common" value='<s:if test="#request.lcGrpCont==null" ><s:property value="#request.currentTime"/></s:if><s:else><s:property value="#request.lcGrpCont.firstTrialDate"/></s:else>' type="text"  style="width: 73%">
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onClick="WdatePicker({el:'repApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>			
				<td class="left">投保单位全称：</td>
				<td class="right"><input id="grpName" name="lcGrpCont.grpName" class="common" type="text" value='<s:if test="#request.lcGrpCont==null" ><s:property value=""/></s:if><s:else><s:property value="#request.lcGrpCont.grpName"/></s:else>'></td>
			</tr>
			<tr> 
				<td class="left">主揽业务员姓名：</td>
				<td class="right"><input id="MainAgentName" name="lcGrpCont.handlerName" class="common" value='<s:if test="#request.lcGrpCont==null" ><s:property value=""/></s:if><s:else><s:property value="#request.lcGrpCont.handlerName"/></s:else>' type="text"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>			
		</table>
		<%--隐藏域客户号 --%>
          <input type="hidden" id="customerNo" value="">
        <%--隐藏域投保单位全称 --%> 
          <input type="hidden" id="grpNameTem" value="">
        <%--mark标志，如果mark为0说明按的是申请按钮 --%>
        <input type="hidden" id="mark" name="mark" value="">
          
		<table id="QueryApplyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="findProsalPreInfo()">
					<input type = "button" class="cssbutton" name="ApplyButton" value="申  请" onclick="displyNewProsalPreInfoCheck()">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     工作列表</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="11%">投保单号</td>
					<td width="11%">管理机构</td>
					<td width="15%">初审时间</td>
					<td width="11%">投保单位全称</td>
					<td width="11%">主揽业务员</td>
				</tr>
			</thead>
			<tbody id="content">
			<s:iterator value="ProposalPrePage.result" var="temp" status="index">
			  <tr class="content">
				<td width="4%"><input type='radio' name='lcGrpCont.grpContNo' value='<s:property value="#temp.grpContNo" />' /></td>
				<td width="5%"><s:property value="#index.count"/></td>
				<td width="15%"><s:property value="#temp.grpContNo" /></td>
				<td width="15%"><s:property value="#temp.manageCom" /></td>
				<td width="16%"><s:date name="#temp.firstTrialDate" format="yyyy-MM-dd"/></td>
				<td width="20%"><s:property value="#temp.grpName" /></td>
				<td width="20%"><s:property value="#temp.handlerName" /></td>
			  </tr>	
			  </s:iterator>		
		    </tbody>
		    </table>
			<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
				<tr>
				    <td width="5%"><input type = "button" class="cssbutton" value="开始录入" onclick="findProsalPreDetail()"></td>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick="location.href='ReportAuditDeal.jsp'"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
				</tr>
			</table>	
			
	</div>
	</form>
	
	 <form id="emptyfm" name="emptyfm" method="post">
	 </form>
  </body>
</html>
