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
		<table id="GroupConInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">团体合同信息</td>
			</tr>
			<tr>
				<td class="left">团体合同号码：</td>
				<td class="right"><input name="GroupContNo" class="common" type="text" onchange="clickable()"></td>
				<td class="left">投保单号：</td>
				<td class="right"><input name="AppNo" class="common" type="text" onchange="clickable()"></td>
				<td class="left">管理机构：</td>
				<td class="right">
					<input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="都邦北京分公司">
				</td>
			</tr>
			<tr>
				<td class="left">销售渠道：</td>
				<td class="right">
					<input class="codecode" id="saleChnlCode" name="lcReport.saleChnlCode" class="common" type="text" value="" style="width:20%"><input name="saleChnl" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">呈报申请号：</td>
				<td class="right"><input name="ReportAppNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">服务协议书号：</td>
				<td  class="right"><input name="ServProtNo" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">投保申请日期：</td>
				<td class="right"><input name="AppAppDate" class="common" type="text" onchange="clickable()"></td>
				<td class="left">保单生效日期：</td>
				<td class="right"><input name="PolValiDate" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">签单日期：</td>
				<td  class="right"><input name="SignDate" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">续保原保单号：</td>
				<td class="right"><input name="RnewNo" class="common" type="text" onchange="clickable()"></td>
				<td class="left">支持保全定期结算：</td>
				<td class="right">
					<input class="codecode" id="edorRegBalaCode" name="lcReport.edorRegBalaCode" class="common" type="text" value="" style="width:20%"><input name="edorRegBala" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">定期结算时间：</td>
				<td  class="right"><input name="RegBalaDate" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">保单打印方式：</td>
				<td class="right">
					<input class="codecode" id="polPrintCode" name="lcReport.polPrintCode" class="common" type="text" value="" style="width:20%"><input name="polPrintType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">VIP标记：</td>
				<td class="right">
					<input class="codecode" id="VIPCode" name="lcReport.VIPCode" class="common" type="text" value="2000000122" style="width:20%"><input name="VIPFlag" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">是否统括保单：</td>
				<td  class="right">
					<input class="codecode" id="YNUniAppCode" name="lcReport.YNUniAppCode" class="common" type="text" value="01" style="width:20%"><input name="YNUniApp" class="common" type="text" onchange="clickable()" style="width:68%" value="是">
				</td>
			</tr>
			<tr>
				<td class="left">主揽业务员：</td>
				<td class="right"><input name="MainBusiMan" class="common" type="text" onchange="clickable()"></td>
				<td class="left">主揽业务员姓名：</td>
				<td class="right"><input name="MainBusiManName" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">所属机构：</td>
				<td  class="right">
					<input class="codecode" id="belongComCode" name="lcReport.belongComCode" class="common" type="text" value="2000000122" style="width:20%"><input name="belongCom" class="common" type="text" onchange="clickable()" style="width:68%" value="都邦北京分公司">
				</td>
			</tr>
		</table>
		<table id="AppUnitInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">投保单位资料</td>
			</tr>
			<tr>
				<td  class="left">VIP客户：</td>
				<td  class="right">
					<input class="codecode" id="VIPCustCode" name="lcReport.VIPCustCode" class="common" type="text" value="" style="width:20%"><input name="VIPCust" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td  class="left">投保单位客户号码：</td>
				<td  class="right"><input name="AppComNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">投保单位全称：</td>
				<td  class="right"><input name="AppComName" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">组织机构代码：</td>
				<td  class="right"><input name="OrgCode" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">单位性质：</td>
				<td  class="right">
					<input class="codecode" id="comNatureCode" name="lcReport.comNatureCode" class="common" type="text" value="01" style="width:20%"><input name="comNature" class="common" type="text" onchange="clickable()" style="width:68%" value="国有企业">
				</td>
				<td  class="left">行业类别：</td>
				<td  class="right">
					<input class="codecode" id="indsCatgCode" name="lcReport.indsCatgCode" class="common" type="text" value="" style="width:20%"><input name="indsCatg" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">单位总人数：</td>
				<td  class="right"><input name="ComTotalNum" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">税务登记证号：</td>
				<td  class="right"><input name="TaxNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">资产总额(万元)：</td>
				<td  class="right"><input name="TotalAsset" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">交费期间：</td>
				<td  class="right">
					<input class="codecode" id="payIntvCode" name="lcReport.payIntvCode" class="common" type="text" value="" style="width:20%"><input name="payIntv" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td  class="left">联系地址：</td>
				<td  class="right"><input name="ContAddr" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">邮政编码：</td>
				<td  class="right"><input name="PostalCode" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td  class="left">联系部门：</td>
				<td  class="right"><input name="ContDepart" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">联系人：</td>
				<td  class="right"><input name="ContPeo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">联系人职位：</td>
				<td  class="right"><input name="ContPeoPos" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">区号：</td>
				<td  class="right"><input name="AreaCode" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">固定电话：</td>
				<td  class="right"><input name="FixedTel" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">分机号：</td>
				<td  class="right"><input name="ExtenNum" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">移动电话：</td>
				<td  class="right"><input name="MobieTel" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">E-MAIL：</td>
				<td  class="right"><input name="E-MAIL" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">传真：</td>
				<td  class="right"><input name="Fax" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">主被保险人数：</td>
				<td  class="right"><input name="MainAppntMount" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">连带被保险人数：</td>
				<td  class="right"><input name="JoinAppntMount" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">投保率：</td>
				<td  class="right"><input name="AppRate" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">已参加过社保统筹：</td>
				<td  class="right">
					<input class="codecode" id="partedSociPlanCode" name="lcReport.partedSociPlanCode" class="common" type="text" value="01" style="width:20%"><input name="partedSociPlan" class="common" type="text" onchange="clickable()" style="width:68%" value="是">
				</td>
				<td  class="left">社保登记证号：</td>
				<td  class="right"><input name="SSNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">缴费方式：</td>
				<td  class="right">
					<input class="codecode" id="payCode" name="lcReport.payCode" class="common" type="text" value="" style="width:20%"><input name="payType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td  class="left">开户银行：</td>
				<td  class="right">
					<input class="codecode" id="openBankCode" name="lcReport.openBankCode" class="common" type="text" value="" style="width:20%"><input name="openBank" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">帐号：</td>
				<td  class="right"><input name="AccNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
	</div>
	<div style="width:100%">
		<table id="GroupAppInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">集体保单信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">险种编码</td>
					<td width="20%">险种名称</td>
					<td width="15%">出单机构</td>
					<td width="11%">保费金额</td>
					<td width="11%">缴费期限</td>
					<td width="11%">保险期限</td>
					<td width="11%">保单状态</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>0601</td>
					<td>附加意外伤害医疗保险(0601)</td>
					<td>北京支公司</td>
					<td>5000</td>
					<td>1年</td>
					<td>1年</td>
					<td>正常签单</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="30%" align='right'><input type="button" class="cssbutton" name="PayQuery" value="缴费查询" onclick=""></td>
				<td width="5%"><input type="button" class="cssbutton" name="EdorQuery" value="保全查询" onclick=""></td>
				<td width="5%"><input type="button" class="cssbutton" name="AppInfoQuery" value="保单明细查询" onclick=""></td>
				<td width="5%"><input type="button" class="cssbutton" name="ScanQuery" value="扫描件查询" onclick=""></td>
				<td width="5%"><input type="button" class="cssbutton" name="PeopOfUnitQuery" value="集体下个人保单查询" onclick=""></td>
				<td width="5%"><input type="button" class="cssbutton" name="OperHistQuery" value="操作履历查询" onclick=""></td>
				<td width="30%"><input type="button" class="cssbutton" name="returnButton" value="返  回" onclick="javascript:history.back();"/></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
