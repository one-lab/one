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
    
    <title>责任给付定义</title>
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
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">责任给付属性定义</td>
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
					<td>VARCHAR2(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>2</td>
					<td>给付名称</td>
					<td>VARCHAR2(30)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>3</td>
					<td>给付类型</td>
					<td>VARCHAR2(6)</td>
					<td>&nbsp;</td>
					<td>0--生存领取</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>4</td>
					<td>给付间隔</td>
					<td>SMALLINT</td>
					<td>&nbsp;</td>
					<td>如果有固定期间，请填写，以月为单位</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>5</td>
					<td>默认值</td>
					<td>decimal(16,2)</td>
					<td>&nbsp;</td>
					<td>默认的领取金额</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>6</td>
					<td>算法</td>
					<td>varchar2(6)</td>
					<td>&nbsp;</td>
					<td>保费算保额</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>7</td>
					<td>反算算法</td>
					<td>varchar2(6)</td>
					<td>&nbsp;</td>
					<td>保额算保额</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>8</td>
					<td>其他算法</td>
					<td>varchar2(6)</td>
					<td>&nbsp;</td>
					<td>其他算保额</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>9</td>
					<td>起领期间</td>
					<td>SMALLINT</td>
					<td>&nbsp;</td>
					<td>和起领期间单位搭配</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>10</td>
					<td>起领期间单位</td>
					<td>varchar2(1)</td>
					<td>&nbsp;</td>
					<td>Y--年 M--月 D--日 A--年龄</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>11</td>
					<td>起领日期计算参照</td>
					<td>varchar2(1)</td>
					<td>&nbsp;</td>
					<td>S--起保日期对应日 B--出生日期对应日</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>12</td>
					<td>起领日期计算方式</td>
					<td>varchar2(1)</td>
					<td>&nbsp;</td>
					<td>0--以计算为准</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>13</td>
					<td>起领期间上限</td>
					<td>SMALLINT</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>14</td>
					<td>止领期间</td>
					<td>SMALLINT</td>
					<td>&nbsp;</td>
					<td>和止领期间单位搭配</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>15</td>
					<td>止领期间单位</td>
					<td>varchar2(1)</td>
					<td>&nbsp;</td>
					<td>Y--年 M--月 D--日 A--年龄</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>16</td>
					<td>止领日期计算参照</td>
					<td>varchar2(1)</td>
					<td>&nbsp;</td>
					<td>S--起保日期对应日 B--出生日期对应日</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>17</td>
					<td>止领日期计算方式</td>
					<td>varchar2(1)</td>
					<td>&nbsp;</td>
					<td>0--以计算为准1--取计算后当月一号</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>18</td>
					<td>递增标记</td>
					<td>varchar2(1)</td>
					<td>&nbsp;</td>
					<td>Y--是 N--否</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>19</td>
					<td>性别关联标记</td>
					<td>varchar2(1)</td>
					<td>&nbsp;</td>
					<td>N--无关 F--男 M--女性</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>20</td>
					<td>算入保额标记</td>
					<td>varchar2(1)</td>
					<td>&nbsp;</td>
					<td>N--不加 Y--加</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>21</td>
					<td>受益人标记</td>
					<td>varchar2(1)</td>
					<td>&nbsp;</td>
					<td>I--受益人是被保险人 A--是投保人 N--无限制</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>22</td>
					<td>催付标记</td>
					<td>varchar2(1)</td>
					<td>&nbsp;</td>
					<td>Y--发催付 N--不发催付</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>23</td>
					<td>被保人死亡后有效标记</td>
					<td>varchar2(1)</td>
					<td>&nbsp;</td>
					<td>Y--有效 N--无效</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>25</td>
					<td>默认申请标志</td>
					<td>varchar2(1)</td>
					<td>&nbsp;</td>
					<td>就可以领</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>28</td>
					<td>给付金是否允许零值</td>
					<td>varchar2(1)</td>
					<td>&nbsp;</td>
					<td>Y--允许 N--不允许</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="2">
					<input type = "button" class="cssbutton" name="Button" value="进入算法定义" onclick="location.href='pdcaledit.jsp'">
					<input type = "button" class="cssbutton" name="Button" value="责任给付生存定义" onclick="location.href='pddutypaysurvivaledit.jsp'">
					<input type = "button" class="cssbutton" name="Button" value="责任给付赔付定义" onclick="location.href='pddutypayclaimedit.jsp'">
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type = "button" class="cssbutton" name="Button" value="赔付控制定义" onclick="location.href='pdclaimctrledit.jsp'">
					<input type = "button" class="cssbutton" name="Button" value="赔付费用定义" onclick="location.href='pdclaimcostedit.jsp'">
					<input type = "button" class="cssbutton" name="Button" value="赔付期间定义" onclick="location.href='pdclaimperiodedit.jsp'">
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
