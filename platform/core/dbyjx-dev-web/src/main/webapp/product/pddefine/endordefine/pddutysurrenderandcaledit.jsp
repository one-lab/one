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
    
    <title>责任退保及算法定义</title>
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
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">险种编码</td>
				<td class="right"><input name="" class="common" type="text"/></td>
				<td class="left">产品险种名称</td>
				<td class="right"><input name="" class="common" type="text"/></td>		
			</tr>
			<tr>
				<td class="left">保全项目编码</td>
				<td class="right"><input name="" class="common" type="text"/></td>
				<td class="left">保全项目名称</td>
				<td class="right"><input name="" class="common" type="text"/></td>		
			</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">产品责任信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="23%">险种代码</td>
					<td width="23%">责任代码</td>
					<td width="23%">责任名称</td>
					<td width="23%">责任缴费代码</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>2</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">退保责任描述</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">序号</td>
					<td width="16%">属性名称</td>
					<td width="16%">属性代码</td>
					<td width="16%">属性数据类型</td>
					<td width="16%">属性值</td>
					<td width="16%">官方字段描述</td>
					<td width="16%">业务人员备注</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>险种编码</td>
					<td>RiskCode</td>
					<td>VARCHAR2(8)</td>
					<td>自动带出</td>
					<td>只读</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>2</td>
					<td>责任编码</td>
					<td>DutyCode</td>
					<td>CHAR(10)</td>
					<td>自动带出</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>3</td>
					<td>交费计划编码</td>
					<td>PayPlanCode</td>
					<td>CHAR(8)</td>
					<td>自动带出</td>
					<td>默认填写000000*</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>4</td>
					<td>算法分支序号</td>
					<td>SurrCalType</td>
					<td>VARCHAR2(2)</td>
					<td>&nbsp;</td>
					<td>*</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>5</td>
					<td>期缴时间间隔</td>
					<td>CycPayIntvType</td>
					<td>VARCHAR2(2)</td>
					<td>&nbsp;</td>
					<td>0--趸交 12--年交 *</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>6</td>
					<td>期交算法编码</td>
					<td>CycPayCalCode</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>7</td>
					<td>生存退保生存金计算类型</td>
					<td>LiveGetType</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>0--按年初计算生存金</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>8</td>
					<td>死亡退保金计算类型</td>
					<td>DeadGetType</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>0--按年初计算死亡退保金</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>9</td>
					<td>计算方式参考</td>
					<td>CalCodeType</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>1--比例计算法</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>10</td>
					<td>退保年度计算类型</td>
					<td>ZTYearType</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>0--舍弃法（向下撇）</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>11</td>
					<td>趸交算法编码（备用）</td>
					<td>OnePayCalCode</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>12</td>
					<td>趸缴时间间隔(备用)</td>
					<td>OnePayIntvType</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--年 M--月 D--日</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>13</td>
					<td>备用</td>
					<td>OutGetType</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>14</td>
					<td>现金价值计算公式(备用)</td>
					<td>CashValueCode</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>15</td>
					<td>是否按账户退保</td>
					<td>PayByAcc</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>1--是 0--否</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>16</td>
					<td>是按保费还是保额计算</td>
					<td>PayCalType</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>1--保额 0--保费</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已保存字段参数</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="13%">险种编码</td>
					<td width="13%">责任编码</td>
					<td width="13%">交费计划编码</td>
					<td width="13%">期交算法编码</td>
					<td width="13%">趸交算法编码</td>
					<td width="13%">是否按账户退保</td>
					<td width="13%">是按保费还是保额计算</td>
				</tr>
			</thead>
			<tbody>
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
				</tr>
			</tbody>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="defineButton" value="新增" onclick="">
					<input type = "button" class="cssbutton" name="defineButton" value="修改" onclick="">
					<input type = "button" class="cssbutton" name="defineButton" value="算法定义" onclick="location.href='pdcaledit.jsp'">
				</td>
			</tr>
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="defineButton" value="返回" onclick="javascript:history.back()">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
