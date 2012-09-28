<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人核保信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     被保人查询</td>
			</tr>
			<tr> 
				<td class="left">分单号：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">被保人号：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">员工序号：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>				
			</tr>
			 <tr>
			 	<td class="left">被保人性别：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">性别：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%">
				</td>
				<td class="left">出生日期：</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='2012-04-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			 </tr>
			 <tr>
				<td class="left">证件类型：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%">
				</td>
			 	<td class="left">证件号码：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="common"></td>
				<td class="common"></td>
			 </tr>			 
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     被保人查询结果</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="15%">分单号</td>
					<td width="11%">被保人号</td>
					<td width="11%">被保人姓名</td>
					<td width="11%">性别</td>					
					<td width="11%">出生日期</td>
					<td width="11%">证件类型</td>					
					<td width="11%">证件号码</td>
					<td width="11%">核保结论</td>					
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     被保人信息</td>
			</tr>
			<tr> 
				<td class="left">被保人客户号：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">被保人姓名：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">被保人性别：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>				
			</tr>
			 <tr>
				<td class="left">出生日期：</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='2012-04-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="left">证件类型：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%">
				</td>
			 	<td class="left">证件号码：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>				
			 </tr>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">    被保险人附属信息查询</td>
			</tr>		
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="个人保单明细信息" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="被保人健康告知" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="被保人体检资料" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="被保人保额累计" onclick="">					
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="被保人已承保保单" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="被保人未承保保单" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="被保人既往保全" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="被保人既往理赔" onclick="">					
				</td>
			</tr>			
		</table>		
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     个人保单险种信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="15%">险种代码</td>
					<td width="15%">险种名称</td>
					<td width="15%">基本保额</td>
					<td width="15%">投保份数</td>
					<td width="15%">标准保费</td>
					<td width="17%">核保结论</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     保全核保操作</td>
			</tr>		
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="体检录入" onclick="location.href='../../../prpall/group/artificalUW/PhysicalExamInput.jsp'">
					<input type = "button" class="cssbutton" name="EndorAccept" value="契调录入" onclick="location.href='../../../prpall/group/artificalUW/ContSearchDataInput.jsp'">
					<input type = "button" class="cssbutton" name="EndorAccept" value="特约录入" onclick="location.href='./SpecialPromiseInput.jsp'">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     个人险种核保结论 </td>
			</tr>
			<tr>
				<td class="left">核保结论：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td colspan="6">核保意见 </td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="UWIdea" cols="100%" rows="5"></textarea></td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="确  定 " onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="重  置" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="返  回" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>							
	</div>
	</form>
  </body>
</html>
