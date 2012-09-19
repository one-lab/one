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
    
    <title>保全项目明细</title>
    
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
				<td class="left">保全申请号：</td>
				<td class="right"><input name="EndorAcceptNo" class="common" type="text" readonly></td>
				<td class="left">批改类型：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>
				<td class="left">保单号：</td>
				<td class="right"><input name="EndorApplyNo" class="common" type="text" readonly></td>
			</tr>
			<tr> 
				<td class="left">申请日期：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">生效日期：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">    被保人信息</td>
			</tr>
			<tr>
				<td class="left">VIP客户：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>			
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">客户内部号码：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>		
				<td class="left">与第一被保险人关系：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>
				<td class="left">与投保人关系：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>
			</tr>
			<tr>
				<td class="left">姓名：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">性别：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>
				<td class="left">婚姻状况：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>
			</tr>
			<tr>
				<td class="left">出生日期：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">被保人年龄：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">职业代码：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>
			</tr>
			<tr>
				<td class="left">证件类型：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>		
				<td class="left">证件号码：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">国籍：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
			</tr>
			<tr>
				<td class="left">驾照类型：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>			
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td colspan="6">    联系地址：</td>
			</tr>
			<tr>
				<td class="left">省：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>		
				<td class="left">市：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>
				<td class="left">区/县：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%" readonly><input name="comName" class="common" type="text" style="width:68%" readonly></td>
			</tr>
			<tr>
				<td class="left">街道：</td>
				<td class="right" colspan="3"><input name="AdressNo" class="common" type="text" ></td>
				<td class="left">邮政编码：</td>
				<td class="right"><input name="ZipCode" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">移动电话：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">办公电话：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">传真电话：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
			</tr>
			<tr>
				<td class="left">住宅电话：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">工作单位：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">电子邮箱：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
			</tr>
			<tr>
				<td class="left">工作证号：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">社会保障号：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">入司时间：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
			</tr>
			<tr>
				<td class="left">月薪：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">服务机构：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>																			
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">    被保险人更改后的信息</td>
			</tr>
			<tr>
				<td class="left">国籍：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>		
				<td class="left">婚姻状况：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
				<td class="left">驾照类型：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
			</tr>
			<tr>
				<td colspan="6">    联系地址：</td>
			</tr>
			<tr>
				<td class="left">省：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>		
				<td class="left">市：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
				<td class="left">区/县：</td>
				<td class="right"><input name="ApplyType" class="codecode" type="text" style="width:20%"><input name="comName" class="common" type="text" style="width:68%"></td>
			</tr>
			<tr>
				<td class="left">街道：</td>
				<td class="right" colspan="3"><input name="AdressNo" class="common" type="text" ></td>
				<td class="left">邮政编码：</td>
				<td class="right"><input name="ZipCode" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">移动电话：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				<td class="left">办公电话：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				<td class="left">传真电话：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">住宅电话：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				<td class="left">工作单位：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				<td class="left">电子邮箱：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
			</tr>						
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="保  存" onclick="">
					<input type = "button" class="cssbutton" name="Confirm" value="返  回" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>							
	</div>
	</form>
  </body>
</html>
