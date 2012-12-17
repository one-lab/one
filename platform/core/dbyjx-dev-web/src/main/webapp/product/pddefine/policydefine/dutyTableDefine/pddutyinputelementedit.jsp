<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>责任录入要素定义</title>
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
	<div style = "width:80%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td align="right" colspan="4">
					<input type = "button" class="cssbutton" name="SaveButton" value="保  存" onclick="">
					<input type = "button" class="cssbutton" name="EditButton" value="修  改" onclick="">
					<input type = "button" class="cssbutton" name="DeleteButton" value="删  除" onclick="">
				</td>
			</tr>
			<tr>
				<td class="left">产品险种编码：</td>
				<td class="right"><input name="" class="common" type="text"/></td>
			</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种责任录入要素定义</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="4%">序号</td>
					<td width="16%">属性名称</td>
					<td width="16%">属性代码</td>
					<td width="16%">属性数据类型</td>
					<td width="16%">属性值</td>
					<td width="16%">官方字段描述</td>
					<td width="16%">业务人员备注</td>
				</tr>
			</thead>
			<tbody align="center">
				<tr class="content">
					<td>1</td>
					<td>险种代码</td>
					<td>RiskCode</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>2</td>
					<td>缴费责任编码</td>
					<td>PayPlanCode</td>
					<td>CHAR(10)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>3</td>
					<td>计算要素</td>
					<td>CalFactor</td>
					<td>VARCHAR(20)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>4</td>
					<td>要素名称</td>
					<td>FactorName</td>
					<td>VARCHAR(200)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>5</td>
					<td>计划要素类型</td>
					<td>CalFactorType</td>
					<td>VARCHAR2(20)</td>
					<td>&nbsp;</td>
					<td>1直接值2算法计算结果值</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>6</td>
					<td>计算SQL</td>
					<td>CalSql</td>
					<td>VARCHAR2(600)</td>
					<td>&nbsp;</td>
					<td>SQL模板</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>7</td>
					<td>可选属性</td>
					<td>ChooseFlag</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>0-保险计划，1-险种信息，2-二者都有</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>8</td>
					<td>要素描述</td>
					<td>FactorNoti</td>
					<td>VARCHAR(1000)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>9</td>
					<td>要素顺序</td>
					<td>FactorOrder</td>
					<td>INT</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>10</td>
					<td>缴费编码</td>
					<td>PayPlanCode</td>
					<td>VARCHAR(8)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>11</td>
					<td>给付代码</td>
					<td>GetDutyCode</td>
					<td>VARCHAR(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>12</td>
					<td>保险账户号码</td>
					<td>InsuAccNo</td>
					<td>CHAR(20)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已保存险种责任录入要素</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="9%">险种编码</td>
					<td width="9%">缴费责任编码</td>
					<td width="9%">计算要素</td>
					<td width="9%">要素名称</td>
					<td width="9%">计算要素类型</td>
					<td width="9%">计算SQL</td>
					<td width="9%">可选属性</td>
					<td width="9%">缴费编码</td>
					<td width="9%">给付编码</td>
					<td width="9%">保险账户号码</td>
				</tr>
			</thead>
			<tbody align="center">
				<tr class="content">
					<td><input name="" value="" type="radio"/></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		</div>
	</form>
  </body>
</html>
