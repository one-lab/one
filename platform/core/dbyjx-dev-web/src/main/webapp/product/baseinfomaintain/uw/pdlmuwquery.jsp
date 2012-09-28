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
    
    <title>公共核保规则定义</title>
    
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
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
				<thead>
					<tr>
						<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已保存的险种算法</td>
					</tr>
					<tr class="tableHead">
						<td width="5%">&nbsp;</td>
						<td width="5%">序号</td>
						<td width="18%">算法编码</td>
						<td width="18%">险种编码</td>
						<td width="18%">算法类型</td>
						<td width="18%">算法内容</td>
						<td width="18%">算法描述</td>
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
			<tr>
				<td align="right" colspan="4">
					<input type = "button" class="cssbutton" name="SaveButton" value="保  存" onclick="">
					<input type = "button" class="cssbutton" name="EditButton" value="修  改" onclick="">
					<input type = "button" class="cssbutton" name="DeleteButton" value="删  除" onclick="">
				</td>
			</tr>
			<tr>
				<td class="left">算法编码</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">险种代码</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>			
			</tr>
			<tr>
				<td class="left">算法类型</td>
				<td class="right"><input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:65%"></td>
				<td class="left">算法描述</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="3"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">算法内容</td>
					<td colspan="3">
					<input type = "button"  class="cssbutton" name="QueryButton" value="查询算法模板" onclick="">
				</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="formtitle" ><textarea name="" cols="" rows="4" ></textarea></td>
				</tr>
			</tbody>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">算法可用基本要素</td>
					<td colspan="4" align="right">
					<input type = "button"  class="cssbutton" name="QueryButton" value="查询" onclick="">
				</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="15%">要素性质</td>
					<td width="15%">要素名称</td>
					<td width="15%">要素代码</td>
					<td width="15%">测试值</td>
					<td width="15%">要素值数据类型</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>险种要素</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>2</td>
					<td>投保人要素</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type = "button"  class="cssbutton" name="QueryButton" value="删除要素" onclick=""></td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type = "button"  class="cssbutton" name="QueryButton" value="测试" onclick=""></td>
			</tr>
		</table>
		</div>
	</form>
  </body>
</html>
