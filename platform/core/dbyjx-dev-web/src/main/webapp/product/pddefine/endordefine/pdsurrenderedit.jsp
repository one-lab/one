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
    
    <title>退保/协议退保</title>
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
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">描述表内容</td>
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
					<td>CHAR(6)</td>
					<td>自动带出</td>
					<td>只读</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>2</td>
					<td>险种版本</td>
					<td>RiskVersion</td>
					<td>CHAR(8)</td>
					<td>&nbsp;</td>
					<td>一般为2002</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>3</td>
					<td>期交是否允许通融退保</td>
					<td>CycFlag</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>1--是0--否</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>4</td>
					<td>期交退保控制范围类型</td>
					<td>CycType</td>
					<td>CHAR(5)</td>
					<td>&nbsp;</td>
					<td>M--月</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>5</td>
					<td>期交退保控制范围，起点</td>
					<td>CycStart</td>
					<td>INTEGER</td>
					<td>&nbsp;</td>
					<td>期交退保控制范围类型搭配</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>6</td>
					<td>期交退保控制范围，终点</td>
					<td>CycFlag</td>
					<td>INTEGER</td>
					<td>&nbsp;</td>
					<td>期交退保控制范围类型搭配</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>7</td>
					<td>趸交是否允许通融退保</td>
					<td>OnePayFlag</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>1--是0--否</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>8</td>
					<td>趸交退保控制范围类型</td>
					<td>OnePayType</td>
					<td>CHAR(5)</td>
					<td>&nbsp;</td>
					<td>Y--年 M--月 D--日</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>9</td>
					<td>趸交退保控制范围起点</td>
					<td>OnePayStart</td>
					<td>INTEGER</td>
					<td>&nbsp;</td>
					<td>和趸交退保控制范围类型搭配</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>10</td>
					<td>趸交退保控制范围终点</td>
					<td>OnePayEnd</td>
					<td>INTEGER</td>
					<td>&nbsp;</td>
					<td>和趸交退保控制范围类型搭配</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>11</td>
					<td>补/退费财务类型</td>
					<td>FeeFinaType</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>该字段根据不同的退费类型</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>12</td>
					<td>加费是否退费标记</td>
					<td>AddFeeBackFlag</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
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
					<td width="5%">序号</td>
					<td width="15%">险种编码</td>
					<td width="15%">险种版本</td>
					<td width="15%">期交是否允许通融退保</td>
					<td width="15%">期交退保控制范围类型</td>
					<td width="15%">趸交是否允许通融退保</td>
					<td width="15%">趸交退保控制范围类型</td>
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
				</tr>
			</tbody>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="defineButton" value="新增" onclick="">
					<input type = "button" class="cssbutton" name="defineButton" value="修改" onclick="">
					<input type = "button" class="cssbutton" name="defineButton" value="责任退保及算法定义" onclick="location.href='pddutysurrenderandcaledit.jsp'">
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
