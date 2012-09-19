<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>问题件修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/Standard.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<TABLE id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
		<TR>
			<TD colspan="6"><table width="800" border="1">
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
						<td>2334234</td>
						<td>阿卡的身份卡上</td>
						<td>&nbsp;</td>
						<td>22</td>
						<td>32423</td>
						<td>2342342</td>
						<td>0.2</td>
					</tr>
				</table></TD>
		</TR>
		<tr>
			<td>险种信息</td>
		</tr>
		<tr>
			<td class="left">险种编码：</td>
			<td class="right"><input name="RegistNo2" class="common" type="text" onchange="clickable()" /></td>
		</tr>
		<tr>
			<td colspan="6">险种费率信息(0至1之间的小数）</td>
		</tr>
		<tr>
			<td colspan="6"><table width="1200" border="1">
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
						<td>&nbsp;</td>
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
			<td colspan="6"><input type="button" class="button" name = "queryButton2" value="添加险种" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="删除险种" onclick="" />
			</td>
		</tr>
		<tr>
			<td colspan="6"><hr /></td>
		</tr>
		<tr>
			<td colspan="6"><input type="button" class="button" name = "queryButton2" value="险种信息" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="层级定制" onclick="" />
			<input type="button" class="button" name = "queryButton2" value="保障计划定制" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="被保险人信息" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="业务信息报告书" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="分期付款设置" onclick="" />
			</td>
		</tr>
		<tr>
			<td colspan="6"><hr /></td>
		</tr>
		<tr>
			<td colspan="6">
				<input type="button" class="button" name = "queryButton2" value="记事本查看（共0条）" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="团体问题件修改确认" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="团体问题件回复" onclick="parent.document.getElementById('fraInterface').src ='group/problemFileModi/ProblemFileReply.jsp'" />
				<input type="button" class="button" name = "queryButton2" value="影像件查看" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="返回" onclick="" />
			</td>
		</tr>
	</TABLE>
</form>
  </body>
</html>
