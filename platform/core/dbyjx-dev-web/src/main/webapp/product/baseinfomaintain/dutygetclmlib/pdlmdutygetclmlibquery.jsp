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
    
    <title>责任给付赔付库</title>
    
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">给付赔付库查询条件</td>
			</tr>
			<tr>
				<td class="left">赔付库代码</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">赔付库名称</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>			
				<td class="left">赔付库责任类型</td>
				<td class="right"><input name="comCode" class="codecode" type="text" onchange="clickable()" ></td>
			</tr>
			<tr>
				<td class="left">关联险种</td>
				<td class="right"><input name="comCode" class="codecode" type="text" onchange="clickable()" ></td>
				<td class="left">关联给付赔付</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" >
				</td>
				<td class="left">关联赔付责任类型</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" >
				</td>					
			</tr>
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">给付赔付查询结果</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="30%">给付赔付库代码</td>
					<td width="30%">给付赔付库名称</td>
					<td width="30%">赔付库责任类型</td>
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
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">给付赔付关联结果</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="18%">给付赔付库代码</td>
					<td width="18%">关联险种代码</td>
					<td width="18%">关联险种名称</td>
					<td width="18%">关联给付代码</td>
					<td width="18%">关联赔付责任类型</td>
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
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		</div>
		<div style = "width:100%">
			<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="3"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">给付赔付库属性定义</td>
					<td align="right" colspan="3">
					<input type = "button" class="cssbutton" name="SaveButton" value="保  存" onclick="">
					<input type = "button" class="cssbutton" name="EditButton" value="修  改" onclick="">
					<input type = "button" class="cssbutton" name="DeleteButton" value="删  除" onclick="">
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
					<td>给付赔付库代码</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>只读</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>2</td>
					<td>给付赔付库名称</td>
					<td>VARCHAR2(30)</td>
					<td>&nbsp;</td>
					<td>最长15个汉字或30个英文字母</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>3</td>
					<td>赔付责任类型</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>X01--残疾金</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>4</td>
					<td>默认值</td>
					<td>decimal(16,2)</td>
					<td>&nbsp;</td>
					<td>默认的赔付金额</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>5</td>
					<td>录入标记</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>默认的赔付金额</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>8</td>
					<td>录入标记</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>给付金是否需要</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>9</td>
					<td>统计类别</td>
					<td>CHAR(2)</td>
					<td>&nbsp;</td>
					<td>YL 医疗 SC 伤残</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>10</td>
					<td>起付限</td>
					<td>decimal(16,2)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>11</td>
					<td>给付后动作</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>000--无动作</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>12</td>
					<td>赔付限额</td>
					<td>decimal(16,2)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>13</td>
					<td>赔付比例</td>
					<td>decimal(5,3)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>14</td>
					<td>赔付天数限额</td>
					<td>smallint</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>15</td>
					<td>累计赔付天数限额</td>
					<td>smallint</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>16</td>
					<td>免赔额</td>
					<td>decimal(16,2)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>17</td>
					<td>免赔天数</td>
					<td>smallint</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>18</td>
					<td>观察期</td>
					<td>smallint</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>19</td>
					<td>被保人死亡后有效</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>Y--有效 N--无效</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>20</td>
					<td>领取时是否需要重新计算</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--需要N--不需要</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>21</td>
					<td>给付类型</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>0--被保人</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>22</td>
					<td>伤残级别</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>0或者空--没有伤</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		</div>
	</form>
  </body>
</html>
