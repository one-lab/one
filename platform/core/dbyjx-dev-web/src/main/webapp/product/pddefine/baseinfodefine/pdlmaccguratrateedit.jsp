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
    
    <title>保证利率录入</title>
    
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
		<thead>
			<tr>
			<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">账户利率</td>
			</tr>
			<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="18%">险种代码</td>
					<td width="18%">险种账户代码</td>
					<td width="18%">利率起始日期</td>
					<td width="18%">利率类型</td>
					<td width="18%">保证利率</td>
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
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">利率属性定义</td>
				</tr>
				<tr>
					<td align="right" colspan="6">
						<input type = "button" class="cssbutton" name="Button" value="新增" onclick="">
						<input type = "button" class="cssbutton" name="Button" value="修改" onclick="">
						<input type = "button" class="cssbutton" name="Button" value="删除" onclick="">
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
					<td>险种编码</td>
					<td>VARCHAR2(8)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>2</td>
					<td>保险账户号码</td>
					<td>CHAR(20)</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td>3</td>
					<td>起始日期</td>
					<td>DATE</td>
					<td> &nbsp;</td>
					<td> &nbsp;</td>
					<td> &nbsp;</td>
				</tr>
				<tr class="content">
					<td>4</td>
					<td>结束日期</td>
					<td>DATE</td>
					<td> &nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp; </td>
				</tr>
				<tr class="content">
					<td>5</td>
					<td>利率类型</td>
					<td>CHAR(1)</td>
					<td> &nbsp;</td>
					<td>Y-年利率M-月利率D-日利率</td>
					<td> &nbsp;</td>
				</tr>
				<tr class="content">
					<td>6</td>
					<td>保证利率</td>
					<td>FlOAT</td>
					<td>&nbsp; </td>
					<td>&nbsp;</td>
					<td> &nbsp;</td>
				</tr>
			</tbody>
		</table>
	</div>
	</form>
  </body>
</html>
