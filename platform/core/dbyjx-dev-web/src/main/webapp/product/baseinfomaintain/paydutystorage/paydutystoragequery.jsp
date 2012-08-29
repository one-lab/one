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
    
    <title>缴费责任库</title>
    
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
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">缴费责任库查询条件</td>
			</tr>
			<tr>
				<td class="left">缴费责任库代码</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">缴费责任库名称</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>			
			</tr>
			<tr>
				<td class="left">关联险种</td>
				<td class="right"><input name="comCode" class="codecode" type="text" onchange="clickable()" ></td>
				<td class="left">关联缴费责任</td>
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
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">缴费责任库查询结果</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="30%">缴费库责任代码</td>
					<td width="30%">缴费库责任名称</td>
					<td width="30%">缴费类型</td>
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
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">缴费责任关联结果</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="30%">缴费库责任代码</td>
					<td width="30%">关联险种代码</td>
					<td width="30%">关联缴费代码</td>
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
					<td class="formtitle" colspan="3"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">责任缴费库属性定义</td>
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
					<td>缴费责任库编码</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>只读</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>2</td>
					<td>缴费责任库名称</td>
					<td>VARCHAR(30)</td>
					<td>&nbsp;</td>
					<td>最长15个汉字或30个英文字母</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>3</td>
					<td>缴费类型</td>
					<td>CHAR(6)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>18</td>
					<td>催缴标记</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--催缴，N--不催缴</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>25</td>
					<td>保费值是否可以为0</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--是 N--否</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>27</td>
					<td>缴费目的分类</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>1--个人交费 2--集体交费</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>28</td>
					<td>保险期间</td>
					<td>SMALLINT</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>29</td>
					<td>保险期间单位</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--年M--月D--日A--年龄</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>30</td>
					<td>意外责任期间</td>
					<td>SMALLINT</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>31</td>
					<td>意外责任期间单位</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>Y--年M--月D--日A--年龄</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>32</td>
					<td>计算方法</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>P--保费算保额G--保额算保费</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>34</td>
					<td>起领期间关系</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>领取、保险年期之间的关系</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>35</td>
					<td>保险期间关系</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>保险年期和领取之间的关系</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>36</td>
					<td>保额标记</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>1.按保额销售2.按份数销售</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>37</td>
					<td>单位保额</td>
					<td>NUMBER(12,2)</td>
					<td>&nbsp;</td>
					<td>险种单位保额用处:在险种描述算法</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>38</td>
					<td>加费类型</td>
					<td>CHAR(2)</td>
					<td>&nbsp;</td>
					<td>00--没有加费10--有投保人健康加费</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>39</td>
					<td>保险终止日期计算方式</td>
					<td>CHAR(1)</td>
					<td>&nbsp;</td>
					<td>0--以计算为准（默认值为0）</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		</div>
	</form>
  </body>
</html>
