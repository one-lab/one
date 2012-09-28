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
    
    <title>报案信息录入</title>
    
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
		<table id="claimCalculaInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">赔案计算信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="19%">赔付金额</td>
					<td width="19%">预付金额</td>
					<td width="19%">结算金额</td>
					<td width="19%">最终赔付金额</td>
					<td width="18%">拒赔金额</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>5000</td>
					<td>2000</td>
					<td>2000</td>
					<td>4500</td>
					<td>500</td>
				</tr>
			</tbody>
		</table>
		<table id="claimTypeCalculaInfo" class="common" cellpadding="3" cellspacing="1">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">理赔类型计算信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">理赔类型代码</td>
					<td width="15%">理赔类型名称</td>
					<td width="15%">账单金额</td>
					<td width="15%">核算赔付金额</td>
					<td width="11%">社保给付</td>
					<td width="11%">第三方给付</td>
					<td width="12%">核赔赔付金额</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>s456</td>
					<td>伤残</td>
					<td>2000</td>
					<td>4500</td>
					<td>5000</td>
					<td>1500</td>
					<td>1500</td>
				</tr>
			</tbody>
		</table>
		<table id="policyCalculaInfo" class="common" cellpadding="3" cellspacing="1">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">保单计算信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">合同号</td>
					<td width="15%">保单号</td>
					<td width="10%">理赔类型</td>
					<td width="10%">生效日期</td>
					<td width="10%">交至日期</td>
					<td width="10%">险种代码</td>
					<td width="14%">险种名称</td>
					<td width="10%">理算金额</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio2" value="" /></td>
					<td>1</td>
					<td>s564244212</td>
					<td>s1565211</td>
					<td>理赔</td>
					<td>2012-03-01</td>
					<td>2013-02-28</td>
					<td>15</td>
					<td>意外伤害险</td>
					<td>1000</td>
				</tr>
			</tbody>
		</table>
		<table id="guarantItemCalculaInfo" class="common" cellpadding="3" cellspacing="1">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">保项计算信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">保单号</td>
					<td width="15%">保险责任</td>
					<td width="12%">责任起期</td>
					<td width="12%">责任止期</td>
					<td width="10%">保额</td>
					<td width="10%">理算金额</td>
					<td width="10%">预付金额</td>
					<td width="10%">调整金额</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio3" value="" /></td>
					<td>1</td>
					<td>s46415</td>
					<td>双方</td>
					<td>2012-03-01</td>
					<td>2013-02-28</td>
					<td>500</td>
					<td>800</td>
					<td>300</td>
					<td>500</td>
				</tr>
			</tbody>
		</table>
	</div>
	</form>
</body>
</html>







