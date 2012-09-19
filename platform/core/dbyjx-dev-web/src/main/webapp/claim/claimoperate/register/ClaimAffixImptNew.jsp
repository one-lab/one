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
    
	    <title>理赔案件附件录入(单证补充)</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>
		<script type="text/javascript">
		function showPage()
		{
			tt = document.getElementById("AddAffix");
			tt.style.display="block";
		}
		</script>

	</head>
<body>
	<form name="fm" method="post" onkeypress="KeyDown()">
	<div style="width:100%">
		<table id="ApplyAffixList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">申请单证清单</td>
				</tr>
				<tr class="tableHead">
					<td width="2%"><input type="checkbox" name="CheckBox" value="" disabled/></td>
					<td width="4%">序号</td>
					<td width="20%">单证代码</td>
					<td width="20%">单证名称</td>
					<td width="17%">是否必须</td>
					<td width="17%">单证件数</td>
					<td width="20%">提交形式</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="checkbox" name="CheckBox" value="" /></td>
					<td>1</td>
					<td>CLM001</td>
					<td>保险合同正本</td>
					<td>0</td>
					<td>1</td>
					<td>0</td>
				</tr>
				<tr class="content">
					<td><input type="checkbox" name="CheckBox" value="" /></td>
					<td>1</td>
					<td>CLM002</td>
					<td>索赔申请书</td>
					<td>0</td>
					<td>1</td>
					<td>0</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="CertifyAdd" value="增加单证" onClick="showPage()" />
					<input type="button" class="cssbutton" name="CertifySave" value="保存单证" onClick="" />
					<input type="button" class="cssbutton" name="returnButton" value="返回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
		<hr />
	</div>
	<div style="width:100%" id="AddAffix" style="display:none">
		<table id="RegisterInfor" class="common" cellpadding="1" cellspacing="1" >
			<tr>
				<td class="formtitle" ><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">增加单证信息</td>
			</tr>
			<tr>
				<td class="left" width="8%">单证名称：</td>
				<td class="right" width="20%" align="left">
					<input class="codecode" id="affixNameCode" name="lcReport.affixNameCode" class="common" type="text" value="CML003" style="width:20%"><input name="affixName" class="common" type="text" onchange="clickable()" style="width:68%" value="赔款给付方式协议书">
				</td>
				<td width="72%" class="common"></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "Conf" value="确  认" onclick="">
					<input type="button" class="cssbutton" name = "Cancel" value="取  消" onclick="">
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>