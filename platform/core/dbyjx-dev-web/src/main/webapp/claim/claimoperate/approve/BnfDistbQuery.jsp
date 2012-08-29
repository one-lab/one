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
    
	    <title>受益人分配查询</title>
	    
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
	<div style="width:100%">
		<table id="ClaimAppntInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">赔案保单信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="25%">赔案号</td>
					<td width="24%">保单号</td>
					<td width="20%">赔付金额</td>
					<td width="25%">分配情况</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio" value="" /></td>
					<td>1</td>
					<td>64131641212</td>
					<td>463164013</td>
					<td>2000</td>
					<td>已分配</td>
				</tr>
			</tbody>
		</table>
		<table id="ClaimResult" class="common" cellpadding="1" cellspacing="1" >
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">赔案保单详细信息</td>
			</tr>
			<tr>
				<td  class="left">赔案号：</td>
				<td  class="right"><input name="ClaimResult" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">保单号：</td>
				<td  class="right"><input name="ClaimResult" class="common" type="text" onchange="clickable()"/></td>
				<td  class="left">赔付金额：</td>
				<td  class="right"><input name="ClaimResult" class="common" type="text" onchange="clickable()" /></td>
			</tr>
		</table>
		<hr />
		<table id="ClaimBnfInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">理赔受益人信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">受益人序号</td>
					<td width="17%">受益人姓名</td>
					<td width="17%">领款人姓名</td>
					<td width="15%">受益金额</td>
					<td width="15%">受益比例</td>
					<td width="15%">支付方式</td>
				</tr>
			</thead>
		</table>
		<table id="ClaimResult" class="common" cellpadding="1" cellspacing="1" >
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">理赔受益人详细信息</td>
			</tr>
			<tr>
				<td  class="left">受益人与被保人关系：</td>
				<td  class="right">
					<input class="codecode" id="relatshipCode" name="lcReport.relatshipCode" class="common" type="text" value="" style="width:20%" ><input name="relatship" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">受益人姓名：</td>
				<td  class="right"><input name="bnfName" class="common" type="text" onchange="clickable()"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">受益人性别：</td>
				<td class="right">
					<input class="codecode" id="bnfCode" name="lcReport.bnfCode" class="common" type="text" value="01" style="width:20%" ><input name="bnfSex" class="common" type="text" onchange="clickable()" style="width:68%" value="男">
				</td>
			</tr>
			<tr>
				<td  class="left">受益人出生日期：</td>
				<td class="right">
					<input name="BnfBirthDate" id="BnfBirthDate" class="common" type="text" onchange="clickable()"  />
				</td>
				<td  class="left">受益人证件类型：</td>
				<td class="right">
					<input class="codecode" id="bnfIDCode" name="lcReport.bnfIDCode" class="common" type="text" value="01" style="width:20%" ><input name="bnfIDType" class="common" type="text" onchange="clickable()" style="width:68%" value="身份证">
				</td>
				<td  class="left">受益人证件号码：</td>
				<td  class="right"><input name="bnfIDNo" class="common" type="text" onchange="clickable()" /></td>
			</tr>
		</table>
		<table id="ClaimRecipInfo" class="common" cellpadding="1" cellspacing="1" >
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">理赔领款人详细信息</td>
			</tr>
			<tr>
				<td  class="left">领款人与受益人关系：</td>
				<td  class="right">
					<input class="codecode" id="reciRelatshipCode" name="lcReport.reciRelatshipCode" class="common" type="text" value="" style="width:20%" ><input name="reciRelatship" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">领款人姓名：</td>
				<td  class="right"><input name="reciName" class="common" type="text" onchange="clickable()"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">领款人性别：</td>
				<td class="right">
					<input class="codecode" id="reciCode" name="lcReport.reciCode" class="common" type="text" value="01" style="width:20%" ><input name="reciSex" class="common" type="text" onchange="clickable()" style="width:68%" value="男">
				</td>
			</tr>
			<tr>
				<td  class="left">领款人出生日期：</td>
				<td class="right">
					<input name="RecipBirthDate" id="RecipBirthDate" class="common" type="text" onchange="clickable()"  />
				</td>
				<td  class="left">领款人证件类型：</td>
				<td class="right">
					<input class="codecode" id="reciIDCode" name="lcReport.reciIDCode" class="common" type="text" value="01" style="width:20%" ><input name="reciIDType" class="common" type="text" onchange="clickable()" style="width:68%" value="身份证">
				</td>
				<td  class="left">领款人证件号码：</td>
				<td  class="right"><input name="reciIDNo" class="common" type="text" onchange="clickable()" /></td>
			</tr>
		</table>
		<table id="DistribInfo" class="common" cellpadding="1" cellspacing="1" >
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">分配详细信息</td>
			</tr>
			<tr>
				<td  class="left">剩余比例：</td>
				<td  class="right"><input name="ClaimResult" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">受益比例：</td>
				<td  class="right"><input name="ClaimResult" class="common" type="text" onchange="clickable()"/></td>
				<td  class="left">受益金额：</td>
				<td  class="right"><input name="ClaimResult" class="common" type="text" onchange="clickable()" /></td>
			</tr>
			<tr>
				<td  class="left">支付方式：</td>
				<td  class="right">
					<input class="codecode" id="payTypeCode" name="lcReport.payTypeCode" class="common" type="text" value="" style="width:20%"><input name="payType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">银行编码：</td>
				<td  class="right">
					<input class="codecode" id="BankCode" name="lcReport.BankCode" class="common" type="text" value="" style="width:20%"><input name="BankCode" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">银行账号：</td>
				<td  class="right"><input name="ClaimResult" class="common" type="text" onchange="clickable()" /></td>
			</tr>
			<tr>
				<td  class="left">银行账户名：</td>
				<td  class="right"><input name="ClaimResult" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<br />
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "returnButton" value="返  回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>

</body>
</html>