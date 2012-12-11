<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>责任缴费算法定义</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script src="${ctx}/product/pddefine/policydefine/dutyTableDefine/js/pdlmdutypayedit.js"></script>
    <script type="text/javascript">var ctx = "${ctx}"</script>
  </head>
  <body>
	<div style = "width:80%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">产品险种编码：</td>
				<td class="right"><input id="dutyPayRiskCode" name="" class="common" type="text" value="GCAA"/></td>
				<td class="left">缴费责任代码：</td>
				<td class="right"><input id="dutyPayDutyCode" name="" class="common" type="text" value="G22000"/></td>				
			</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已保存的险种算法</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="18%">算法编码</td>
					<td width="18%">险种编码</td>
					<td width="18%">算法类型</td>
					<td width="18%">算法内容</td>
				</tr>
			</thead>
			
			<tbody align="center" id="calModeContent">
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td align="right">
					<input type = "button" class="cssbutton" name="Button" value="保存" onclick="saveCalMode();">
					<input type = "button" class="cssbutton" name="Button" value="修改" onclick="updateCalMode();">
					<input type = "button" class="cssbutton" name="Button" value="删除" onclick="deleteCalMode();">
				</td>
			</tr>
		</table>
		<form id="operCalMode" name="operCalMode" action="aaa">
			<table id="" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td class="left">算法编码：</td>
					<td class="right"><input id="pdlmCalMode_calCode" name="pdlmCalMode.calCode" class="common" type="text"/></td>
					<td class="left">险种代码：</td>
					<td class="right">
						<input id="pdlmCalMode_riskCode" name="pdlmCalMode.riskCode" class="common" type="text"/>
					</td>				
				</tr>
				<tr>
					<td class="left">算法类型：</td>
					<td class="right"><input id="pdlmCalMode_type" name="pdlmCalMode.type" class="codecode" type="text"  ></td>
					<%-- 
					<td class="left">算法描述：</td>
					<td class="right">
						<input name="pdlmCalMode.remark" class="common" type="text"/>
					</td>
					--%>				
				</tr>
				<tr>
					<td class="left">算法内容：</td>
					<td class="right"><input type = "button" class="cssbutton" name="Button" value="查询算法模板" onclick=""></td>
					<td class="left"><input type = "button" class="cssbutton" name="Button" value="添加要素"
					 	onclick="queryCode('calSql','calName','pdlmRiskDutyFactor','riskCode:dutyPayRiskCode|dutyCode:dutyPayDutyCode')"></td>
					<td>
					<td ><input type = "button" class="cssbutton" name="Button" value="+" onclick="addOperator(this)"></td>
					<td ><input type = "button" class="cssbutton" name="Button" value="-" onclick="addOperator(this)"></td>
					<td ><input type = "button" class="cssbutton" name="Button" value="*" onclick="addOperator(this)"></td>
					<td ><input type = "button" class="cssbutton" name="Button" value="/" onclick="addOperator(this)"></td>
					<td>
					<td class="right"><input type = "button" class="cssbutton" name="Button" value="清空算法" onclick="clearCalMode();"></td>
					<td>
					<input name="calSql" type="hidden" id="calSql"/>
					<input name="calName" type="hidden" id="calName"/>
					</td>
				</tr>
				<tr>
					<td class="formtitle" colspan="4">
						<textarea id="algoId" name="pdlmCalMode.remark" cols="" rows="4" readonly="readonly" ></textarea>
						<input id="pdlmCalMode_calSQL" type="hidden" name="pdlmCalMode.calSQL" id="calSQL"/>
					</td>
					
				</tr>
			</table>
		</form>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">算法可用基本要素</td>
					<td class="right"><input type = "button" class="cssbutton" name="Button" value="查询" onclick=""></td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="18%">要素性质</td>
					<td width="18%">要素名称</td>
					<td width="18%">要素代码</td>
					<td width="18%">测试值</td>
					<td width="18%">要素值数据类型</td>
				</tr>
			</thead>
			<tbody align="center" id="factorList">
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type = "button" class="cssbutton" name="Button" value="测试" onclick=""></td>
			</tr>
		</table>
	</div>
  </body>
</html>
