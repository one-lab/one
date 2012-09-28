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
    
    <title>责任给付库</title>
    
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">给付责任库查询条件</td>
			</tr>
			<tr>
				<td class="left">给付库责任代码</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">给付库责任名称</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>			
				<td class="left">给付类型</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
			<tr>
				<td class="left">关联险种</td>
				<td class="right"><input name="comCode" class="codecode" type="text" onchange="clickable()" ></td>
				<td class="left">关联给付责任</td>
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
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">给付责任库查询结果</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="30%">给付库责任代码</td>
					<td width="30%">给付库责任名称</td>
					<td width="30%">责任类型</td>
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
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">给付责任关联结果</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="30%">给付库责任代码</td>
					<td width="30%">关联险种代码</td>
					<td width="30%">关联给付代码</td>
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
		</div>
		<div style = "width:100%">
			<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="3"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">责任给付属性定义</td>
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
					<td>给付库责任代码</td>
					<td>VARCHAR2(6)</td>
					<td>&nbsp;</td>
					<td>只读</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>2</td>
					<td>给付库责任名称</td>
					<td>VARCHAR2(30)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>3</td>
					<td>给付类型</td>
					<td>VARCHAR2(6)</td>
					<td>&nbsp;</td>
					<td>0--生存领取</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>4</td>
					<td>给付间隔</td>
					<td>SMALLINT</td>
					<td>&nbsp;</td>
					<td>如果有固定期间，请填写</td>
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
					<td>19</td>
					<td>递增标记</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--是 N--否</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>20</td>
					<td>性别关联标记</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>N--无关 F--男性 M--女性</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>22</td>
					<td>算入保额标记</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>N--不加 Y--加</td>
					<td>&nbsp;</td>
				</tr>

				<tr class="content">
					<td>27</td>
					<td>受益人标记</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>I--受益人是被保险人A--是投保人</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>28</td>
					<td>催付标记</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--发催付N--不发催付</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>29</td>
					<td>被保人死亡后有效</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--有效N--无效</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>35</td>
					<td>默认申请标志</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>0--不用申请就可以领取</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>37</td>
					<td>给付分类1</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>0--满期金 1--年金</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>38</td>
					<td>给付金是否允许为零</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--允许 N--不允许</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		</div>
	</form>
  </body>
</html>
