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
    
    <title>保全人工核保</title>
    
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     保全受理信息</td>
			</tr>
			<tr> 
				<td class="left">保全受理号：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">申请号码：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">号码类型：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			</tr>
			 <tr>
			 	<td class="left">预打保单：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">申请方式：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">管理机构：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			 </tr>
			 <tr>
			 	<td class="left">补退费金额：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">补退费利息：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="common"></td>
				<td class="common"></td>
			 </tr>			 
		</table>
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     团体保单信息</td>
			</tr>
			<tr> 
				<td class="left">团体保单号：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">团体客户号：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">投保单位：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>				
			</tr>
			 <tr>
			 	<td class="left">投保人数：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">管理机构：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">销售渠道：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			 </tr>
			 <tr>
			 	<td class="left">代理人编码：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">代理人姓名：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">代理人组别：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			 </tr>
			 <tr>
			 	<td class="left">VIP标记：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>				
			 </tr>			 		 
		</table>		
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     团体保单附属信息</td>
			</tr>
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="保单明细信息 " onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="投保单影像查询" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="投保单位已承保保单" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="投保单位未承保保单" onclick="">
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="投保单位既往保全" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="投保单位既往理赔" onclick="">
				</td>
			</tr>			
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     团体保单险种信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="12%">批单号</td>
					<td width="10%">批改类型</td>
					<td width="10%">险种编码</td>
					<td width="10%">险种名称</td>
					<td width="10%">交费间隔</td>
					<td width="10%">投保人数</td>
					<td width="10%">交至日期</td>
					<td width="10%">生效日期</td>	
					<td width="10%">核保结论</td>				
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>SE86012012005</td>
					<td>IC</td>
					<td>0601</td>
					<td>都邦住院安心团体健康保险</td>
					<td>趸交</td>
					<td>10</td>
					<td>2012-05-18</td>
					<td>2012-05-18</td>
					<td>10</td>
				</tr>
			</tbody>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     保全核保操作 </td>
			</tr>
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="保全影像查询 " onclick="location.href='./EndorScanView.jsp'">
					<input type = "button" class="cssbutton" name="EndorAccept" value="团体自动核保信息" onclick="location.href='./GrpAutoUW.jsp'">
					<input type = "button" class="cssbutton" name="EndorAccept" value="保全明细查询" onclick="location.href='./EndorDetailView.jsp'">
					<input type = "button" class="cssbutton" name="EndorAccept" value="个人核保信息" onclick="location.href='./SigleContDetailAutoUW.jsp'">
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="保全操作轨迹" onclick="location.href='./EndorOperateTraceView.jsp'">
					<input type = "button" class="cssbutton" name="EndorAccept" value="险种风险要素查询" onclick="location.href='../../../prpall/group/artificalUW/KindRiskInfo.jsp'">
				</td>
			</tr>			
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     团体险种核保结论 </td>
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
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     保全申请核保结论 </td>
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
