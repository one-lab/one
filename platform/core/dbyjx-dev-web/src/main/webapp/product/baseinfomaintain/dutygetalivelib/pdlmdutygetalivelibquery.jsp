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
    
    <title>责任生存给付库</title>
    
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
	<div style = "width:70%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">给付生存库查询条件</td>
			</tr>
			<tr>
				<td class="left">生存库代码</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">生存库名称</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>			
				<td class="left">生存库责任类型</td>
				<td class="right"><input name="comCode" class="codecode" type="text" onchange="clickable()" ></td>
			</tr>
			<tr>
				<td class="left">关联险种</td>
				<td class="right"><input name="comCode" class="codecode" type="text" onchange="clickable()" ></td>
				<td class="left">关联给付生存</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" >
				</td>
				<td class="left">关联生存责任类型</td>
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
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">给付生存查询结果</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="30%">给付生存库代码</td>
					<td width="30%">给付生存库名称</td>
					<td width="30%">生存库责任类型</td>
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
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">给付生存关联结果</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="18%">给付生存库代码</td>
					<td width="18%">关联险种代码</td>
					<td width="18%">关联险种名称</td>
					<td width="18%">关联给付代码</td>
					<td width="18%">关联生存责任类型</td>
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
					<td class="formtitle" colspan="3"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">责任给付生存属性定义</td>
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
					<td>生存库代码</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>只读</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>2</td>
					<td>生存库名称</td>
					<td>VARCHAR2(30)</td>
					<td>&nbsp;</td>
					<td>最长15个汉字或30个英文字母</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>3</td>
					<td>给付生存责任类型</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>是年金从1开始递增</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>4</td>
					<td>给付间隔</td>
					<td>NUMBER(38)</td>
					<td>&nbsp;</td>
					<td>如果有固定期间，请填写,以月为单位</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>5</td>
					<td>默认值</td>
					<td>decimal(16,2)</td>
					<td>&nbsp;</td>
					<td>默认的领取金额</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>9</td>
					<td>起领期间</td>
					<td>NUMBER(38)</td>
					<td>&nbsp;</td>
					<td>和起领期间单位搭配</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>10</td>
					<td>起领期间单位</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--年M--月</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>11</td>
					<td>起领日期计算参照</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>S--起保日期对应日B--出生日期对应日</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>12</td>
					<td>起领日期计算方式</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>0--以计算为准</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>13</td>
					<td>起领期间上限</td>
					<td>NUMBER(38)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>14</td>
					<td>止领期间</td>
					<td>NUMBER(38)</td>
					<td>&nbsp;</td>
					<td>和止领期间单位搭配</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>15</td>
					<td>止领期间单位</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--年M--月</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>16</td>
					<td>止领日期计算参照</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>S--起保日期对应日</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>17</td>
					<td>止领日期计算方式</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>0--以计算为准</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>18</td>
					<td>递增标记</td>
					<td>CHAR(1) not null</td>
					<td>&nbsp;</td>
					<td>Y--是 N--否</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>19</td>
					<td>递增间隔</td>
					<td>NUBMER(38)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>20</td>
					<td>递增开始期间</td>
					<td>NUBMER(38)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>21</td>
					<td>递增开始期间单位</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--年M--月</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>25</td>
					<td>递增值</td>
					<td>NUMBER(16,2)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>26</td>
					<td>给付最大次数</td>
					<td>NUMBER(38)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>27</td>
					<td>给付后动作</td>
					<td>CHAR(3)</td>
					<td>&nbsp;</td>
					<td>001--保额递减（暂不用）</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>28</td>
					<td>领取动作类型</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>0--可领可不领 1--必须领</td>
					<td>&nbsp;</td>
				</tr>

				<tr class="content">
					<td>29</td>
					<td>催付标记</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--发催付 N--不发催付</td>
					<td>&nbsp;</td>
				</tr>

				<tr class="content">
					<td>30</td>
					<td>给付最大次数类型</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>1--无条件给付最大年龄数</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>31</td>
					<td>计算</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>1--领取时需要重新计算</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>32</td>
					<td>备用</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>33</td>
					<td>备用</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>34</td>
					<td>备用</td>
					<td>NUMBER(38)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		</div>
	</form>
  </body>
</html>
