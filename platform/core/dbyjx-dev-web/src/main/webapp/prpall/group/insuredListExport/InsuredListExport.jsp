<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>被保人清单导出</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="common/css/Standard.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<table id="ContractInfo" class="common" cellpadding="3" cellspacing="0">
		<tr>
			<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     请输入保单号码</td>
		</tr>
		<tr>
			<td  class="left">保单号码</td>
			<td  class="right"><input name="RegistNo" class="common" type="text""><img src="images/bgMarkMustInput.jpg" ></td>
			<td  class="right"><input type="button" class="cssbutton" name = "queryButton" value="确  定" onClick="" ></td>
			<td  class="common"></td>
			<td  class="common"></td>
			<td  class="common"></td>
		</tr>
		<tr>
			<td  class="left">有效被保人人数</td>
			<td  class="right"><input name="RegistNo" class="common" type="text""></td>
			<td  class="right"><input type="button" class="cssbutton" name = "queryButton" value="导出清单" onClick="" ></td>
			<td  class="common"></td>
			<td  class="common"></td>
			<td  class="common"></td>
		</tr>
		<tr>
			<td  class="left">有效受益人人数</td>
			<td  class="right"><input name="RegistNo" class="common" type="text""></td>
			<td  class="right"><input type="button" class="cssbutton" name = "queryButton" value="导出清单" onClick="" ></td>
			<td  class="common"></td>
			<td  class="common"></td>
			<td  class="common"></td>
		</tr>
	</table>
	<table id="UseInfo" class="common" cellpadding="3" cellspacing="0">
		<tr>
			<td class="formtitle"><img src="images/bgformtitle.gif" style="cursor:hand;">     使用方法</td>
		</tr>
		<tr>
			<td colspan="2"><ul>
					<li>1、录入“保单号码”，点击“确定”按钮。</li>
					<li>2、“有效被保人人数”会显示出当前保单的有效被保人人数，人数大于0时可以点击“导出清单”，生产Excel清单</li>
					<li>3、“有效受益人人数”会显示出当前保单的受益人人数，人数大于0时可以点击“导出清单”，生产Excel清单</li>
					<li>4、将导出清单信息逐一粘贴到“被保人导入模版”中，请注意导入Sheet的选择。</li>
				</ul></td>
		</tr>
	</table>
</form>
  </body>
</html>
