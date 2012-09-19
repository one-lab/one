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
    
    <title>险种账户定义</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
		<thead>
			<tr>
			<td class="formtitle" colspan="3"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种已有账户</td>
			</tr>
			<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="30%">险种代码</td>
					<td width="30%">险种账户代码</td>
					<td width="30%">险种账户名称</td>
				</tr>
			</thead>
			<tbody>
			<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
			<tr>
					<td align="left" colspan="5">
						<input type = "button" class="cssbutton" name="Button" value="保证利率录入" onclick="location.href='pdlmaccguratrateedit.jsp'">
					</td>
			</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">账户属性定义</td>
				</tr>
				<tr>
					<td align="right" colspan="6">
						<input type = "button" class="cssbutton" name="Button" value="新增" onclick="">
						<input type = "button" class="cssbutton" name="Button" value="修改" onclick="">
						<input type = "button" class="cssbutton" name="Button" value="删除" onclick="">
					</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="19%">属性名称</td>
					<td width="19%">属性数据类型</td>
					<td width="19%">属性值</td>
					<td width="19%">官方字段描述</td>
					<td width="19%">业务人员备注</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>账户类型</td>
					<td>CHAR(3)</td>
					<td>&nbsp;</td>
					<td>001--集体公共账户002--个人账户</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>2</td>
					<td>账户分类</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>1--现金账户2--股份账户</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>3</td>
					<td>保险账户名称</td>
					<td>VARCHAR2(30)</td>
					<td> &nbsp;</td>
					<td> &nbsp;</td>
					<td> &nbsp;</td>
				</tr>
				<tr class="content">
					<td>4</td>
					<td>账户产生位置</td>
					<td>CHAR(1)</td>
					<td> &nbsp;</td>
					<td>1--投保单录入时产生</td>
					<td>&nbsp; </td>
				</tr>
				<tr class="content">
					<td>5</td>
					<td>账号产生规则</td>
					<td>CHAR(1)</td>
					<td> &nbsp;</td>
					<td>1--同个人保单号</td>
					<td> &nbsp;</td>
				</tr>
				<tr class="content">
					<td>6</td>
					<td>账户固定利率</td>
					<td>Number(16,6)</td>
					<td>&nbsp; </td>
					<td>&nbsp;</td>
					<td> &nbsp;</td>
				</tr>
				<tr class="content">
					<td>7</td>
					<td>账户对应利率表</td>
					<td>CHAR(20)</td>
					<td>&nbsp; </td>
					<td>账户利率表为利率+账户号</td>
					<td> &nbsp;</td>
				</tr>
				<tr class="content">
					<td>9</td>
					<td>账户结算方式</td>
					<td>CHAR(3)</td>
					<td> &nbsp;</td>
					<td>0--不计利息1--按固定利率</td>
					<td>&nbsp; </td>
				</tr>
				<tr class="content">
					<td>9</td>
					<td>投资类型</td>
					<td>CHAR(3)</td>
					<td> &nbsp;</td>
					<td>货币基金</td>
					<td> &nbsp;</td>
				</tr>
				<tr class="content">
					<td>10</td>
					<td>基金公司代码</td>
					<td>CHAR(20)</td>
					<td>&nbsp; </td>
					<td>&nbsp;</td>
					<td>&nbsp; </td>
				</tr>
				<tr class="content">
					<td>11</td>
					<td>账户所有者</td>
					<td>CHAR(1)</td>
					<td>&nbsp; </td>
					<td>0--雇主1--雇员</td>
					<td> &nbsp;</td>
				</tr>
				<tr class="content">
					<td>12</td>
					<td>是否参与分红</td>
					<td>VARCHAR2(1)</td>
					<td> &nbsp;</td>
					<td>0--不参与分红1--参与分红</td>
					<td> &nbsp;</td>
				</tr>
				<tr class="content">
					<td>13</td>
					<td>分红计入账户的方式</td>
					<td>VARCHAR2(1)</td>
					<td> &nbsp;</td>
					<td>0--直接计入本账户</td>
					<td> &nbsp;</td>
				</tr>
				<tr class="content">
					<td>14</td>
					<td>分红计入账户代码</td>
					<td>VARCHAR2(20)</td>
					<td> &nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp; </td>
				</tr>
				<tr class="content">
					<td>15</td>
					<td>分红时是否进行账户结算</td>
					<td>VARCHAR2(1)</td>
					<td> &nbsp;</td>
					<td>0--不进行结算1--结算账户</td>
					<td> &nbsp;</td>
				</tr>
				<tr class="content">
					<td>16</td>
					<td>分红方式</td>
					<td>VARCHAR2(1)</td>
					<td> &nbsp;</td>
					<td>1--美式会计年度</td>
					<td> &nbsp;</td>
				</tr>
				<tr class="content">
					<td>17</td>
					<td>投资收益类型</td>
					<td>VARCHAR2(1)</td>
					<td>&nbsp; </td>
					<td>1--金额类型2--份额类型</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>18</td>
					<td>计价周期</td>
					<td>VARCHAR2(30)</td>
					<td> &nbsp;</td>
					<td>可以改成按天标注的方式</td>
					<td> &nbsp;</td>
				</tr>
				<tr class="content">
					<td>19</td>
					<td>计价价格获取规则</td>
					<td>VARCHAR2(2)</td>
					<td>&nbsp; </td>
					<td>&nbsp; </td>
					<td>&nbsp; </td>
				</tr>
				<tr class="content">
					<td>20</td>
					<td>小数位数</td>
					<td>VARCHAR2(1)</td>
					<td>&nbsp; </td>
					<td>&nbsp; </td>
					<td>&nbsp; </td>
				</tr>
				<tr class="content">
					<td>21</td>
					<td>四舍五入标记</td>
					<td>VARCHAR2(1)</td>
					<td>&nbsp; </td>
					<td>1--直接截取2--四舍五入</td>
					<td>&nbsp; </td>
				</tr>
				<tr class="content">
					<td>22</td>
					<td>是否参与分红</td>
					<td>VARCHAR2(1)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp; </td>
				</tr>
			</tbody>
		</table>
	</div>
	</form>
  </body>
</html>
