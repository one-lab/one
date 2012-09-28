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
    
    <title>保全项目定义</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
  </head>
  <body>
    <form name="fm" method="post" >
	<div style = "width:60%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">险种代码：</td>
				<td class="right"><input name="GrpName" class="common" type="text"/></td>
				<td class="left">产品险种名称：</td>
				<td class="right"><input name="GrpName" class="common" type="text"/></td>		
			</tr>
		</table>
		<table>
			<tr>
				<td align="right" colspan="4">
					<input type = "button" class="cssbutton" name="" value="险种详细信息查询" onclick="location.href='../baseinfodefine/pdlmriskview.jsp'">
				</td>
			</tr>
		</table>
	</div>
	<div style="width:100%">	
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已填加的保全项</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="15%">险种编码</td>
					<td width="15%">险种名称</td>
					<td width="15%">险种责任</td>
					<td width="15%">保全项目编码</td>
					<td width="15%">保全项目名称</td>
					<td width="15%">定义状态</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>CM</td>
					<td>客户重要资料变更</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>2</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>HI</td>
					<td>补充告知</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>3</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>AE</td>
					<td>投保人变更</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>4</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>BC</td>
					<td>受益人变更</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>5</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>CT</td>
					<td>退保</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo2" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" ></td>
					<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
				</tr>
			</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Button" value="具体保全项目定义" onclick="location.href='${ctx}/product/pddefine/endordefine/pdhesitateperiodsurrenderedit.jsp'">
				</td>
			</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">新增保全项目</td>
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
				<s:if test="#request.fields.size() == 0" >
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
					<td>RiskVer</td>
					<td>CHAR(8)</td>
					<td>&nbsp;</td>
					<td>一般为2002</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>3</td>
					<td>险种名称</td>
					<td>RiskName</td>
					<td>CHAR(40)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>4</td>
					<td>保全项目编码</td>
					<td>EdorCode</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>5</td>
					<td>保全项目名称</td>
					<td>EdorName</td>
					<td>VARCHAR(20)</td>
					<td>&nbsp;</td>
					<td>最多10个汉字或20个英文字母</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>6</td>
					<td>保全申请对象</td>
					<td>AppObj</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>G--团体单 I--个单</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>10</td>
					<td>涉及计算</td>
					<td>CalFlag</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>1--涉及 0--不涉及</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>11</td>
					<td>界面上是否需要显示项目详细信息</td>
					<td>NeedDetail</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--是 N--否</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>13</td>
					<td>集体保全批单中是否需要打印</td>
					<td>GrpNeedList</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--需要打印 N--不需要打印</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>14</td>
					<td>保全权限</td>
					<td>EdorPopedom</td>
					<td>CHAR(2)</td>
					<td>&nbsp;</td>
					<td>C--C级保全操作员 D--D级保全操作员</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>15</td>
					<td>财务处理类型</td>
					<td>FinType</td>
					<td>CHAR(2)</td>
					<td>&nbsp;</td>
					<td>B--退保金JK--借款HK--还款</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>16</td>
					<td>保全项目属性</td>
					<td>EdorProperty</td>
					<td>CHAR(2)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				</s:if>
				<s:else>
					<s:iterator value="#request.fields" var="temp">
						<tr class="content">
							<td> <s:property value="#temp.displayorder"/> </td>
							<td> <s:property value="#temp.fieldName"/> </td>
							<td> <s:property value="#temp.fieldCode"/> </td>
							<td> <s:property value="#temp.fieldType"/> </td>
							<td> <input class="common" type="text" name='<s:property value="#temp.fieldValueName"/>'> </td>
							<td> <s:property value="#temp.officialDesc"/> </td>
							<td> <input class="common" type="text" name='<s:property value="#temp.busiDesc"/>'> </td>
						</tr>
					</s:iterator>
				</s:else>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Button" value="新增" onclick="">
					<input type = "button" class="cssbutton" name="Button" value="修改" onclick="">
					<input type = "button" class="cssbutton" name="Button" value="删除" onclick="">
				</td>
			</tr>
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Button" value="记事本" onclick="location.href='../baseinfodefine/pdlmrisknotepadedit.jsp'">
					<input type = "button" class="cssbutton" name="Button" value="问题件查询" onclick="location.href='../baseinfodefine/pdissueview.jsp'">
					<input type = "button" class="cssbutton" name="Button" value="问题件录入" onclick="location.href='../policydefine/pdissueedit.jsp'">
				</td>
			</tr>
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Button" value="保全信息录入完毕" onclick="">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
