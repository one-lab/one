<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>集体投保单明细</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/Standard.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
		<tr>
			<td>投保单告知书</td>
		</tr>
		<tr>
			<td colspan="6"><table width="1000" border="1">
					<tr>
						<th scope="col">序号</th>
						<th scope="col">告知版别</th>
						<th scope="col">告知内容编号</th>
						<th scope="col">告知内容</th>
						<th scope="col">录入信息</th>
					</tr>
					<tr>
						<td><label></label></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td>集体保单险种信息</td>
		</tr>
		<tr>
			<td colspan="6"><table width="1000" border="1">
					<tr>
						<th scope="col">&nbsp;</th>
						<th scope="col">序号</th>
						<th scope="col">险种编码</th>
						<th scope="col">险种名称</th>
						<th scope="col">交费期间</th>
						<th scope="col">参保人数</th>
						<th scope="col">保费</th>
						<th scope="col">保额/份数合计</th>
						<th scope="col">费用率</th>
					</tr>
					<tr>
						<td><label>
							<input type="radio" name="radiobutton" value="radiobutton" />
							</label></td>
						<td>1</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td>险种费率信息（0至1之间的小数）</td>
		</tr>
		<tr>
			<td colspan="6"><table width="1000" border="1">
					<tr>
						<th scope="col">序号</th>
						<th scope="col">手续费比例</th>
						<th scope="col">个人绩效比例</th>
						<th scope="col">管理绩效比例</th>
						<th scope="col">个人费用比例</th>
						<th scope="col">团队费用比例</th>
						<th scope="col">机构费用比例</th>
						<th scope="col">前线固定费用分摊比例</th>
					</tr>
					<tr>
						<td >1</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td><hr />
			</td>
		</tr>
		<tr>
			<td colspan="6"><input type="button" class="button" name = "queryButton" value="险种信息" onClick="" >
				<input type="button" class="button" name = "queryButton" value="层级定制" onClick="" >
				<input type="button" class="button" name = "queryButton" value="保障计划定制" onClick="" >
				<input type="button" class="button" name = "queryButton" value="被保险人信息" onClick="" >
				<input type="button" class="button" name = "queryButton" value="呈报件查询" onClick="" >
				<input type="button" class="button" name = "queryButton" value="业务员信息报告书" onClick="" >
				<input type="button" class="button" name = "queryButton" value="分期付款设置" onClick="" >
			</td>
		</tr>
		<tr>
			<td><hr />
			</td>
		</tr>
		<tr>
			<td colspan="6"><input type="button" class="button" name = "queryButton" value="团体问题件查询" onClick="" >
				<input type="button" class="button" name = "queryButton" value="返回" onClick="" >
				<input type="button" class="button" name = "queryButton" value="记事本查看（共0条）" onClick="" >
			</td>
		</tr>
	</table>
</form>
  </body>
</html>
