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
    
    <title>责任给付生存</title>
    
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
				<td class="left">产品险种代码：</td>
				<td class="right"><input name="" class="common" type="text"></td>
				<td class="left">给付代码：</td>
				<td class="right"><input name="" class="common" type="text"></td>			
			</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已有责任给付生存项</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="30%">给付代码</td>
					<td width="30%">给付名称</td>
					<td width="30%">给付责任类型</td>
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
				<td colspan="4" align="right"">
					<input type = "button" class="cssbutton" name="Button" value="查询给付生存库" onclick="">
					<input type = "button" class="cssbutton" name="Button" value="保存" onclick="">
					<input type = "button" class="cssbutton" name="Button" value="修改" onclick="">
					<input type = "button" class="cssbutton" name="Button" value="删除" onclick="">
				</td>
			</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">责任给付生存属性定义</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="18%">属性名称</td>
					<td width="18%">属性数据类型</td>
					<td width="18%">属性值</td>
					<td width="18%">官方字段描述</td>
					<td width="18%">业务人员备注</td>
				</tr>
			</thead>
			<tbody align="center">
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>给付代码</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>只读</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>2</td>
					<td>给付名称</td>
					<td>VARCHAR2(30)</td>
					<td>&nbsp;</td>
					<td>最长15个汉字或30个英文字母</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>3</td>
					<td>给付责任类型</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>如果是年金从1开始递增</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>4</td>
					<td>给付间隔</td>
					<td>NUMBER(38)</td>
					<td>&nbsp;</td>
					<td>如果有固定期间，请填写，以月为单位</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>5</td>
					<td>默认值</td>
					<td>NUMBER(16,2)</td>
					<td>&nbsp;</td>
					<td>默认的领取金额</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>6</td>
					<td>算法</td>
					<td>char(6)</td>
					<td>&nbsp;</td>
					<td>保费算保额</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>7</td>
					<td>反算算法</td>
					<td>char(6)</td>
					<td>&nbsp;</td>
					<td>保额算保额</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>8</td>
					<td>其他算法</td>
					<td>char(6)</td>
					<td>&nbsp;</td>
					<td>其他算保额</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>9</td>
					<td>起领期间</td>
					<td>NUMBER(38)</td>
					<td>&nbsp;</td>
					<td>和起领期间单位搭配</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>10</td>
					<td>起领期间单位</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>Y--年 M--月</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>11</td>
					<td>起领日期计算参照</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>S--起保日期对应日 </td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>12</td>
					<td>起领日期计算方式</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>0--以计算为准</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>13</td>
					<td>起领期间上限</td>
					<td>NUMBER(38)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>14</td>
					<td>止领期间</td>
					<td>NUMBER(38)</td>
					<td>&nbsp;</td>
					<td>和止领期间单位搭配</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>15</td>
					<td>止领期间单位</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>Y--年 M--月</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>16</td>
					<td>指令日期计算参照</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>S--起保日期对应日</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>17</td>
					<td>指令日期计算方式</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>0--以计算为准</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>18</td>
					<td>递增标记</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>Y--是 N--否</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>19</td>
					<td>递增间隔</td>
					<td>NUMBER(38)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>20</td>
					<td>递增开始期间</td>
					<td>NUMBER(38)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>21</td>
					<td>递增开始期间单位</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>Y--年 M--月</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>22</td>
					<td>递增终止期间</td>
					<td>NUMBER(38)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>23</td>
					<td>递增终止期间单位</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>Y--年 M--月</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>24</td>
					<td>递增类型</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>V--按金额算数递增</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>25</td>
					<td>递增值</td>
					<td>NUMBER(16,2)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>26</td>
					<td>给付最大次数</td>
					<td>NUMBER(38)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>27</td>
					<td>给付后动作</td>
					<td>char(3)</td>
					<td>&nbsp;</td>
					<td>001--保额递减（暂不用）</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>28</td>
					<td>领取动作类型</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>0--可领可不领 1--必须领</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>29</td>
					<td>催付标记</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>Y--发催付 N--不发催付</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>30</td>
					<td>给付最大次数类型</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>1--无条件给付最大年龄数</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>31</td>
					<td>新计算</td>
					<td>char(1)</td>
					<td>&nbsp;</td>
					<td>1--领取时需要重新计算</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Button" value="进入算法定义" onclick="location.href='pdcaledit.jsp'">
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
