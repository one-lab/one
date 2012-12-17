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
    
    <title>保全撤销录入</title>
    
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     保全申请信息</td>
			</tr>
			<tr> 
				<td class="left">保全受理号：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">申请号码：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">号码类型：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>				
			</tr>
			<tr> 
				<td class="left">申请人：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">申请方式：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">管理机构：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>				
			</tr>			
			<tr> 
				<td class="left">补/退费金额：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">补/退费利息：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     投保单项目信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="15%">申请批单号</td>
					<td width="11%">批改类型</td>
					<td width="11%">团体保单号</td>
					<td width="11%">生效日期</td>
					<td width="11%">补退费金额合计</td>	
					<td width="11%">补退费利息</td>	
					<td width="11%">批改状态</td>
					<td width="11%">核保状态</td>							
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>SE8601221012005</td>
					<td>IC-被保人重要资料变更 </td>
					<td>5674732432432</td>
					<td>2012-05-18</td>
					<td>-59</td>
					<td>0</td>
					<td>申请确认</td>
					<td>自核未通过</td>
				</tr>					
				</tr>
			</tbody>
		</table>
		<table id="endorItemInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     保全申请撤销</td>
			</tr>
			<tr> 
				<td class="left">撤销原因：</td>
				<td class="right">
					<input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" >
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td colspan="6" >详细情况</td>
			</tr>
			<tr>
				<td colspan="4" ><textarea id="specNoName"  name="lcGrpContReport.specNoName" cols="" rows="4"></textarea></td>
			</tr>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="保全撤销" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="返  回" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>					
	</div>
	</form>
  </body>
</html>
