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
    
    <title>影像录入</title>
    
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
		影像信息
		<br><br><br><br>
		<hr>
		<table id=PraPallInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">投保单信息</td>
			</tr>
			<tr>
				<td class="left">投保单号码：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				<td class="left">呈报件号：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>				
				<td class="left">投保日期：</td>
				<td class="right">
					<input name="InputDate" id="InputDate" class="common" type="text"  style="width: 73%" value='2012-04-28'><img src="${ctx}/images/bgMarkMustInput.jpg" >
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onClick="WdatePicker({el:'InputDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
			<tr>
				<td class="left">保单生效日期：</td>
				<td class="right">
					<input name="Cvalidate" id="Cvalidate" class="common" type="text"  style="width: 73%" value='2012-04-28'><img src="${ctx}/images/bgMarkMustInput.jpg" >
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onClick="WdatePicker({el:'Cvalidate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="left">续保原保单号：</td>
				<td class="right"><input name="OldGrpContNo" class="common" type="text" ></td>
				<td class="left">管理机构：</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="都邦北京分公司"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td class="left">销售方式：</td>
				<td class="right"><input name="SaleType" class="common" type="text" ><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">协议书号：</td>
				<td class="right"><input name="ContractNo" class="common" type="text" ></td>				
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr><br>
		<table id=PraPallInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">业务员编码：</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:90%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">业务员姓名：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>				
				<td class="left">所属机构：</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="都邦北京分公司"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>				
			</tr>
			<tr>
				<td class="left">所属分部：</td>
				<td class="right"><input name="SaleType" class="common" type="text" ></td>
				<td class="left">多业务员,请勾选：</td>
				<td><input type="checkbox" name="checkbox" value="checkbox" /></td>			
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<table id=ContImpartInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6" ><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">其他业务员信息</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="19%">业务员代码</td>
					<td width="19%">业务员姓名</td>
					<td width="19%">所属机构</td>
					<td width="19%">所属分布</td>
					<td width="19%">佣金比例</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>a</td>
					<td>a</td>
					<td>a</td>
					<td>a</td>
					<td>a</td>
				</tr>
			</tbody>
		</table>
		<hr><br>
		<table id=companyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../report/reportInput/CompanyInfo.jsp" /> </td>
			</tr>
		</table>
		<table id=ContImpartInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6" ><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">投保单告知书</td>
				</tr>
				<tr class="tableHead">
					<td width="10%">序号</td>
					<td width="20%">告知版别</td>
					<td width="20%">告知内容编号</td>
					<td width="25%">告知内容</td>
					<td width="25%">录入信息</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>SA</td>
					<td>3234</td>
					<td>告知内容相信</td>
					<td>录入详细信息内容等</td>
				</tr>
			</tbody>
			<tr>
				<td colspan="6" >同业竞争状况</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5"></textarea></td>
			</tr>
			<tr>
				<td colspan="6" >被保险人情况</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5"></textarea></td>
			</tr>
			<tr>
				<td colspan="6" >既往理赔史</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5"></textarea></td>
			</tr>
			<tr>
				<td colspan="6" >保单相关情况及服务要求</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5"></textarea></td>
			</tr>
			<tr>
				<td colspan="6">
					<input type="button" class="cssButton" name = "SubmitButton" value="保  存" onClick="" >
					<input type="button" class="cssButton" name = "UpdateButton" value="修  改" onClick="" >
				</td>
			</tr>
		</table>
	</div>
	<div style="width:100%">
		<table id="GrpPolInfor" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">   集体保单险种信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="15%">险种编码</td>
					<td width="32%">险种名称</td>
					<td width="15%">保费</td>
					<td width="15%">保额</td>
					<td width="15%">费用率</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" value="" name="Radios"/></td>
					<td>1</td>
					<td>0601</td>
					<td>附加意外伤害医疗保险(0601)</td>
					<td>0</td>
					<td>0</td>
					<td>0.15</td>
				</tr>
			</tbody>
		</table>		
	</div>
	<div style="width:100%">
		<table id="RiskInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种信息</td>
			</tr>
			<tr>
				<td class="left">险种编码：</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="都邦北京分公司"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">主险编码：</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="都邦北京分公司"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>				
				<td class="left">费用率（0-1）：</td>
				<td class="right"><input name="RiskCode" class="common" type="text" onchange="clickable()" /></td>
			</tr>
		</table>
		<table id="RiskRateInfor" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种费率信息（0至1之间的小数）</td>
				</tr>
				<tr class="tableHead">
					<td width="10%">序号</td>
					<td width="12%">手续费比例</td>
					<td width="13%">个人绩效比例</td>
					<td width="13%">管理绩效比例</td>
					<td width="13%">个人费用比例</td>
					<td width="13%">团队费用比例</td>
					<td width="13%">机构费用比例</td>
					<td width="13%">前线固定费用分摊比例</td>					
				</tr>
			</thead>	
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>0.4</td>
					<td>0.4</td>
					<td>1</td>
					<td>0.4</td>
					<td>0.4</td>
					<td>0.4</td>
					<td>0.4</td>
				</tr>
			</tbody>
		</table>
		<table id="ButtonInfor1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="90%" align="right"><input type="button" class="cssbutton" name = "AddRisk" value="添加险种" onclick=""></td>
				<td width="10%" align="left"><input type="button" class="cssbutton" name = "DelRisk" value="删除险种" onclick=""></td>
			</tr>
		</table>
		<hr>
		<div id="divInfo1" style="display:''">
			<table id="ButtonInfor2" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td colspan="6">
						<input type="button" class="cssbutton" name = "AddPlan" value="保障计划定制" onclick="location.href='../report/reportInput/EnsurePlan.jsp'">
						<input type="button" class="cssbutton" name = "InsuredInfo" value="被保险人信息" onclick="location.href='../report/reportInput/InsuredListImport.jsp'">
						<input type="button" class="cssbutton" name = "BussinessNote" value="业务信息报告书" onclick="location.href='../noImageInput/StatementInput.jsp'">
						<input type="button" class="cssbutton" name = "JoinSet" value="联保设置" onclick="">
					</td>
				</tr>
			</table>
		</div>
		<div id="divInfo2" style="display:''">
			<table id="ButtonInfor2" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td colspan="6">
						<input type="button" class="cssbutton" name = "AddPlan" value="险种信息" onclick="">
						<input type="button" class="cssbutton" name = "AddPlan" value="保障计划定制" onclick="location.href='../report/reportInput/EnsurePlan.jsp'">
						<input type="button" class="cssbutton" name = "InsuredInfo" value="被保险人信息" onclick="location.href='../report/reportInput/InsuredListImport.jsp'">
						<input type="button" class="cssbutton" name = "BussinessNote" value="业务信息报告书" onclick="location.href='../noImageInput/StatementInput.jsp'">
						<input type="button" class="cssbutton" name = "JoinSet" value="分期付款设置" onclick="location.href='../noImageInput/InstallmentSetting.jsp'">
					</td>
				</tr>
			</table>
		</div>
		<hr>
		<table id="ButtonInfor3" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="50%" align="right"><input type="button" class="cssbutton" name = "ReturnBack" value="返  回" onclick="javascript:history.go(-1);"></td>
				<td width="10%" align="left"><input type="button" class="cssbutton" name = "AddComplete" value="录入完毕" onclick=""></td>
				<td width="10%" align="left"><input type="button" class="cssbutton" name = "QueryNotepad" value="记事本查看（共0条）" onclick=""></td>
				<td width="10%" align="left"><input type="button" class="cssbutton" name = "QueryIssue" value="团体问题件查询" onclick=""></td>
				<td width="10%" align="left"><input type="button" class="cssbutton" name = "AddIssue" value="团体问题件录入" onclick="location.href='../noImageInput/ProblemFileInput.jsp'"></td>
				<td width="10%" align="left"><input type="button" class="cssbutton" name = "QueryImageScan" value="影像件查询" onclick=""></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
