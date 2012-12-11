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
    
    <title>保单明细查询</title>
    
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
		<table id="GrpContInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     团体合同信息</td>
			</tr>
			<tr> 
				<td class="left">团体合同号码：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">投保单号码：</td>
				<td class="right"><input name="PrtNo" class="common" type="text" readonly></td>
				<td class="left">管理机构：</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			</tr>
			<tr> 
				<td class="left">销售渠道：</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" value="1" readonly><input name="comName" class="common" type="text" value="中国" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">呈报件号：</td>
				<td class="right"><input name="ReportNo" class="common" type="text" readonly></td>
				<td class="left">服务协议书号：</td>
				<td class="right"><input name="ServiceNo" class="common" type="text" readonly></td>
			</tr>
			<tr>
				<td class="left">投保申请日期：</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" value='2012-04-28' readonly>
				</td>
				<td class="left">保单生效日期：</td>
				<td class="right">
					<input name="CvaliDate" id="Cvalidate" class="common" type="text" onchange="clickable()" value='2012-04-28' readonly>
				</td>
				<td class="left">签单日期：</td>
				<td class="right">
					<input name="SignDate" id="Cvalidate" class="common" type="text" onchange="clickable()" value='2012-04-28' readonly>
				</td>	
			</tr>
			<tr> 
				<td class="left">续保原保单号：</td>
				<td class="right"><input name="ReportNo" class="common" type="text" readonly></td>
				<td class="left">支持保全定期结算：</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">定期结算时间：</td>
				<td class="right"><input name="SettleDate" class="common" type="text" readonly></td>
			</tr>
			<tr> 
				<td class="left">保单打印方式：</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">VIP标记：</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">是否统括保单：</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			</tr>
			<tr> 
				<td class="left">主揽业务员：</td>
				<td class="right"><input name="ReportNo" class="common" type="text" readonly></td>
				<td class="left">主揽业务员姓名：</td>
				<td class="right"><input name="SettleDate" class="common" type="text" readonly></td>
				<td class="left">所属机构：</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			</tr>			
		</table>
	</div>
	<div style = "width:100%">
		<table id="GrpContInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     投保单位资料</td>
			</tr>
			<tr>
				<td class="left">VIP客户：</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">投保单位客户号码：</td>
				<td class="right"><input name="GrpName" class="common" type="text" ></td>
				<td class="left">投保单位名称：</td>
				<td class="right"><input name="BussType" class="common" type="text" ></td>
				<td class="left">组织机构代码：</td>
				<td class="right"><input name="GroupNo" class="common" type="text" ></td>				
			</tr>
			<tr>
				<td class="left">单位性质：</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">行业类别：</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">单位总人数：</td>
				<td class="right"><input name="RegistNo" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">税务登记证号：</td>
				<td class="right"><input name="InCome" class="common" type="text" ></td>
				<td class="left">资产总额（万元）：</td>
				<td class="right"><input name="InCome" class="common" type="text" ></td>
				<td class="left">缴费期间：</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			</tr>
			<tr>
				<td class="left">联系地址：</td>
				<td class="right" colspan="3"><input name="AdressNo" class="common" type="text" ><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">邮政编码：</td>
				<td class="right"><input name="ZipCode" class="common" type="text" ><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td class="left">联系部门 ：</td>
				<td class="right"><input name="Telephone1" class="common" type="text" ></td>
				<td class="left">联系人：</td>
				<td class="right"><input name="Department" class="common" type="text" ></td>
				<td class="left">联系人职位：</td>
				<td class="right"><input name="Department" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">区号：</td>
				<td class="right"><input name="Name" class="common" type="text" ></td>
				<td class="left">固定电话：</td>
				<td class="right"><input name="Sex" class="common" type="text" ></td>
				<td class="left">分机号：</td>
				<td class="right"><input name="Telephone2" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">移动电话：</td>
				<td class="right"><input name="Telephone3" class="common" type="text" ></td>
				<td class="left">E-MAIL：</td>
				<td class="right"><input name="E-Mail" class="common" type="text" ></td>
				<td class="left">传真：</td>
				<td class="right"><input name="E-Mail" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">主被保险人数：</td>
				<td class="right"><input name="LegalPerson" class="common" type="text" ></td>
				<td class="left">连带被保险人数：</td>
				<td class="right"><input name="IDType" class="common" type="text" ></td>
				<td class="left">投保率：</td>
				<td class="right"><input name="IDNo" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">已参加过社会统筹：</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">社保登记证号：</td>
				<td class="right"><input name="RegistNo" class="common" type="text" ></td>
				<td class="left">缴费方式：</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			</tr>
			<tr>
				<td class="left">开户银行：</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left" colspan="">账号 ：</td>
				<td class="right" colspan="3"><input name="MainInsuredCount" class="common" type="text" ></td>
			</tr>
		</table>
		<table id="ReportCompanyInfo" class="common" cellpadding="3" cellspacing="0">
				<thead>
					<tr>
						<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">  集体保单信息</td>
					</tr>
					<tr class="tableHead">
						<td width="3%">&nbsp;</td>
						<td width="7%">序号</td>
						<td width="10%">险种编码</td>
						<td width="15%">险种名称</td>
						<td width="13%">出单机构</td>
						<td width="13%">保费金额</td>
						<td width="13%">缴费期限</td>
						<td width="13%">保险期限</td>
						<td width="13%">保单状态</td>
					</tr>
				</thead>

				<tbody>
					<tr class="content">
						<td ><input name="checkRadio" type="radio" value="" /></td>
						<td >1</td>
						<td >4500</td>
						<td >都邦团体意外伤害保险</td>
						<td >860301</td>
						<td >1300</td>
						<td >1年</td>
						<td >1年</td>
						<td >正常签单</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td width="30%" align='right'><input type = "button" class="cssbutton" name="Query" value="交费查询" onclick=""></td>
					<td width="6%" align='right'><input type = "button" class="cssbutton" name="Query" value="保全查询" onclick=""></td>
					<td width="8%" align='right'><input type = "button" class="cssbutton" name="Query" value="保单明细查询" onclick=""></td>
					<td width="4%" align='right'><input type = "button" class="cssbutton" name="Query" value="扫描件查询" onclick=""></td>
					<td width="14%" align='right'><input type = "button" class="cssbutton" name="Query" value="集体下个人保单查询" onclick=""></td>
					<td width="8%" align='right'><input type = "button" class="cssbutton" name="Query" value="操作履历查询" onclick=""></td>
					<td width="30%" align='left'><input type = "button" class="cssbutton" name="Query" value="返  回" onclick="javascript:history.go(-1);"></td>
				</tr>
			</table>
	</div>
	</form>
  </body>
</html>
