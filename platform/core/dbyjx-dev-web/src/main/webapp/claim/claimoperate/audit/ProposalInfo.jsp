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
    
	    <title>保单查询</title>
	    
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
		<table id="ContractInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">合同信息部分</td>
			</tr>
			<tr>
				<td  class="left">保单号：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">投保单号码：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">服务机构：</td>
				<td  class="right">
					<input class="codecode" id="serviceComCode" name="lcReport.serviceComCode" class="common" type="text" value="" style="width:20%" ><input name="serviceCom" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td class="left">销售渠道：</td>
				<td class="right">
					<input class="codecode" id="saleChnlCode" name="lcReport.saleChnlCode" class="common" type="text" value="" style="width:20%"><input name="saleChnl" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">银保通号码：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">客户签收日期：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">业务员编码：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">业务员组别：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">代理机构：</td>
				<td  class="right">
					<input class="codecode" id="agentCode" name="lcReport.agentCode" class="common" type="text" value="" style="width:20%" ><input name="agentCom" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td  class="left">保单服务状态：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">签单机构：</td>
				<td  class="right">
					<input class="codecode" id="signbillCode" name="lcReport.signbillCode" class="common" type="text" value="" style="width:20%" ><input name="signbillCom" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">签单日期：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">销售机构：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">保单打印日期：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">回单日期：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
			</tr>
		</table>
		<table id="AppntInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">投保人信息部分</td>
			</tr>
			<tr>
				<td  class="left">姓名：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">性别：</td>
				<td class="right">
					<input class="codecode" id="sexCode" name="lcReport.sexCode" class="common" type="text" value="01" style="width:20%" ><input name="sex" class="common" type="text" onchange="clickable()" style="width:68%" value="男">
				</td>
				<td  class="left">出生日期：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">客户号：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">证件类型：</td>
				<td class="right">
					<input class="codecode" id="IDCode" name="lcReport.IDCode" class="common" type="text" value="01" style="width:20%" ><input name="IDType" class="common" type="text" onchange="clickable()" style="width:68%" value="身份证">
				</td>
				<td  class="left">证件号码：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">职业等级：</td>
				<td class="right">
					<input class="codecode" id="occupCode" name="lcReport.occupCode" class="common" type="text" value="01" style="width:20%" ><input name="occupLevel" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">国籍：</td>
				<td class="right">
					<input class="codecode" id="nationCode" name="lcReport.nationCode" class="common" type="text" value="01" style="width:20%" ><input name="nation" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">客户级别：</td>
				<td class="right">
					<input class="codecode" id="customerCode" name="lcReport.customerCode" class="common" type="text" value="01" style="width:20%" ><input name="customerGrade" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
		</table>
		<table id="AppntInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">被保人信息部分</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">序号</td>
					<td width="10%">被保人姓名</td>
					<td width="15%">客户号</td>
					<td width="10%">性别</td>
					<td width="10%">证件类型</td>
					<td width="20%">证件号码</td>
					<td width="10%">国籍</td>
					<td width="10%">职业等级</td>
					<td width="11%">出生日期</td>
				</tr>
		    </thead>
		    <tbody>
				<tr class="content">
					<td>1</td>
					<td>王五</td>
					<td>1641344124</td>
					<td>男</td>
					<td>护照</td>
					<td>8621462100</td>
					<td></td>
					<td>一级</td>
					<td>1986-12-20</td>
				</tr>
			</tbody>
		</table>
		<table id="AppntInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="18"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">保单险种信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="3%">序号</td>
					<td width="6%">被保人姓名</td>
					<td width="6%">险种编码</td>
					<td width="8%">险种名称</td>
					<td width="6%">出单机构</td>
					<td width="5%">保单状态</td>
					<td width="8%">保额</td>
					<td width="6%">生效日期</td>
					<td width="6%">保险止期</td>
					<td width="6%">缴费止期</td>
					<td width="5%">交费形式</td>
					<td width="6%">交费对应日</td>
					<td width="5%">交费年期</td>
					<td width="6%">保费总额</td>
					<td width="6%">基本保费</td>
					<td width="5%">健康加费</td>
					<td width="5%">职业加费</td>
				</tr>
		    </thead>
		    <tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>王五</td>
					<td>0717</td>
					<td>建筑工程团体</td>
					<td>86</td>
					<td>承保</td>
					<td>0</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>1</td>
					<td>300</td>
					<td>300</td>
					<td>0</td>
					<td>0</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="18"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">新契约类</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="Button" value="保单明细查询" onClick="" />
					<input type="button" class="cssbutton" name="Button" value="影像资料查询" onclick="" />
					<input type="button" class="cssbutton" name="Button" value="操作履历查询" onclick="" />
					<input type="button" class="cssbutton" name="Button" value="保单状态查询" onclick="" />
					<input type="button" class="cssbutton" name="Button" value="暂交费查询" onclick="" />
					<input type="button" class="cssbutton" name="Button" value="被保人查询" onclick="" />
					
				</td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="18"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">保全类</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="Button" value="代收代付查询" onclick="" />
					<input type="button" class="cssbutton" name="Button" value="保全批改查询" onclick="" />
					<input type="button" class="cssbutton" name="Button" value="补发打印查询" onclick="" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="Button" value="险种信息查询" onClick="" />
					<input type="button" class="cssbutton" name="Button" value="垫交/借款查询" onclick="" />
				</td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="18"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">客户保单</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="Button" value="投保人已承保保单查询" onClick="" />
					<input type="button" class="cssbutton" name="Button" value="投保人未承保保单查询" onclick="" />
					<input type="button" class="cssbutton" name="Button" value="被保人已承保保单查询" onclick="" />
					<input type="button" class="cssbutton" name="Button" value="被保人未承保保单查询" onclick="" />
				</td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="returnButton" value="返  回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>

</body>
</html>