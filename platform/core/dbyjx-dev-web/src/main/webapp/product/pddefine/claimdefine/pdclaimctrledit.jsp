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
    
    <title>赔付控制</title>
    
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
			</tr>
			<tr>
				<td class="left">给付代码：</td>
				<td class="right"><input name="" class="common" type="text"></td>
				<td class="left">给付名称：</td>
				<td class="right"><input name="" class="common" type="text"></td>
			</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已有赔付控制</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="30%">理赔控制编号</td>
					<td width="30%">理赔控制名称</td>
					<td width="30%">类型</td>
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
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="3" align="right"">
					<input type = "button" class="cssbutton" name="Button" value="保存" onclick="">
					<input type = "button" class="cssbutton" name="Button" value="修改" onclick="">
					<input type = "button" class="cssbutton" name="Button" value="删除" onclick="">
				</td>
			</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">赔付控制定义</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="5%">序号</td>
					<td width="19%">属性名称</td>
					<td width="19%">属性数据类型</td>
					<td width="19%">属性值</td>
					<td width="19%">官方字段描述</td>
					<td width="19%">业务人员备注</td>
				</tr>
			</thead>
			<tbody align="center">
				<tr class="content">
					<td>1</td>
					<td>理赔控制编号</td>
					<td>VARCHAR2(8)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>2</td>
					<td>理赔控制名称</td>
					<td>VARCHAR2(120)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>3</td>
					<td>类型</td>
					<td>VARCHAR2(3)</td>
					<td>&nbsp;</td>
					<td>2.给付比例投保</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>4</td>
					<td>理赔控制描述</td>
					<td>VARCHAR2(500)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>5</td>
					<td>有效期间</td>
					<td>VARCHAR2(3)</td>
					<td>&nbsp;</td>
					<td>2.日历年度</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>6</td>
					<td>自定义期间标记</td>
					<td>VARCHAR2(3)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>7</td>
					<td>个人家庭标记</td>
					<td>VARCHAR2(3)</td>
					<td>&nbsp;</td>
					<td>用保额标记</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>8</td>
					<td>保单有效期/内外</td>
					<td>VARCHAR2(3)</td>
					<td>&nbsp;</td>
					<td>期险间内还是保险</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>9</td>
					<td>赔付期间控制上限</td>
					<td>INTEGER</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>10</td>
					<td>赔付期间上限单位</td>
					<td>VARCHAR2(1)</td>
					<td>&nbsp;</td>
					<td>D--日 A--年龄</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>11</td>
					<td>赔付期间上限控制计算参考</td>
					<td>VARCHAR2(1)</td>
					<td>&nbsp;</td>
					<td>日</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>12</td>
					<td>赔付期间下限控制</td>
					<td>INTEGER</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>13</td>
					<td>赔付期间下限控制单位</td>
					<td>VARCHAR2(1)</td>
					<td>&nbsp;</td>
					<td>D--日 A--年龄</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>14</td>
					<td>赔付期间下限控制计算参考</td>
					<td>VARCHAR2(1)</td>
					<td>&nbsp;</td>
					<td>日</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>15</td>
					<td>理赔控制计算SQL</td>
					<td>VARCHAR2(6)</td>
					<td>&nbsp;</td>
					<td>计算公式</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>16</td>
					<td>理赔控制处理值类型</td>
					<td>VARCHAR2(3)</td>
					<td>&nbsp;</td>
					<td>2.金额</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>17</td>
					<td>理赔控制默认值</td>
					<td>NUMBER(12,2)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>18</td>
					<td>理赔控制计算方式</td>
					<td>VARCHAR2(3)</td>
					<td>&nbsp;</td>
					<td>实例化时取默认值</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>19</td>
					<td>理赔费用控制计算公式</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
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
