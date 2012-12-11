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
    
    <title>责任给付赔付</title>
    
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
				<td class="left">险种编码：</td>
				<td class="right"><input name="" class="common" type="text"></td>
				<td class="left">给付代码：</td>
				<td class="right"><input name="" class="common" type="text"></td>			
			</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已有责任给付赔付项</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="23%">给付代码</td>
					<td width="23%">理赔控制编号</td>
					<td width="23%">给付名称</td>
					<td width="23%">给付责任类型</td>
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
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="4" align="right"">
					<input type = "button" class="cssbutton" name="Button" value="查询给付赔付库" onclick="">
					<input type = "button" class="cssbutton" name="Button" value="保存" onclick="">
					<input type = "button" class="cssbutton" name="Button" value="修改" onclick="">
					<input type = "button" class="cssbutton" name="Button" value="删除" onclick="">
				</td>
			</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">责任给付赔付属性定义</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="15%">属性名称</td>
					<td width="15%">属性代码</td>
					<td width="15%">属性数据类型</td>
					<td width="15%">属性值</td>
					<td width="15%">官方字段描述</td>
					<td width="15%">业务人员备注</td>
				</tr>
			</thead>
			<tbody align="center">
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>给付代码</td>
					<td>GETDUTYCODE</td>
					<td>NOT NULL CHAR(6)</td>
					<td>&nbsp;</td>
					<td>只读</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>2</td>
					<td>给付名称</td>
					<td>GetDutyName</td>
					<td>VARCHAR2(30)</td>
					<td>&nbsp;</td>
					<td>最长15个汉字或30个英文字母</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>3</td>
					<td>给付责任类型</td>
					<td>GetDutyKind</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>X01--残疾金</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>4</td>
					<td>默认值</td>
					<td>Default</td>
					<td>decimal(16,2)</td>
					<td>&nbsp;</td>
					<td>默认的赔付金额</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>5</td>
					<td>算法</td>
					<td>CalCode</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>保费算保额（一般只用这个）</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>6</td>
					<td>反算算法</td>
					<td>CnterCalCode</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>保额算保额（没有用）</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>7</td>
					<td>其他算法</td>
					<td>OthCalCode</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>其他算保额</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>8</td>
					<td>录入标记</td>
					<td>InpFlag</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>给付金是否需要输入</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>9</td>
					<td>统计类别</td>
					<td>StatType</td>
					<td>CHAR(2)</td>
					<td>&nbsp;</td>
					<td>YL--医疗 SC 伤残</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>10</td>
					<td>起付限</td>
					<td>MinGet</td>
					<td>decimal(16,2)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>11</td>
					<td>给付后动作</td>
					<td>AfterGet</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>000--无动作</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>12</td>
					<td>赔付限额</td>
					<td>MaxGet</td>
					<td>decimal(16,2)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>13</td>
					<td>赔付比例</td>
					<td>ClaimRate</td>
					<td>decimal(5,3)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>14</td>
					<td>赔付天数限额</td>
					<td>ClmDayLmt</td>
					<td>smallint</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>15</td>
					<td>累计赔付天数限额</td>
					<td>SumClmDayLmt</td>
					<td>smallint</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>16</td>
					<td>免赔额</td>
					<td>Deductible</td>
					<td>decimal(16,2)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>17</td>
					<td>免赔天数</td>
					<td>DeDuctDay</td>
					<td>smallint</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>18</td>
					<td>观察期</td>
					<td>ObsPeriod</td>
					<td>smallint</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>19</td>
					<td>被保人死亡后有效</td>
					<td>DeadValiFlag</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--有效 N--无效</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>20</td>
					<td>领取时是否需要重新计算</td>
					<td>NeedReCompute</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--需要 N--不需要</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>21</td>
					<td>给付类型</td>
					<td>CasePolType</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>0--被保人</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>22</td>
					<td>伤残级别</td>
					<td>DeformityGrade</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>0或者空--没有伤残比例</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="2">
					<input type = "button" class="cssbutton" name="Button" value="进入算法定义" onclick="location.href='pdcaledit.jsp'">
					<input type = "button" class="cssbutton" name="Button" value="关联账单定义" onclick="location.href='pdrelaaccedit.jsp'">
				</td>
			</tr>
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Button" value="返回" onclick="javascript:history.back()">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
