<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>问题件回复</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/Standard.css" rel="stylesheet" type="text/css" />

  </head>

	<body>
		<form name="fm" method="post" onkeypress="KeyDown()">
			<table id="BeforeOverViewMain" class="common" cellpadding="3"
				cellspacing="1">
				<tr>
					<td class="left">
						合同投保单号码
					</td>
					<td class="right">
						17234751273647
					</td>
					<td class="left">
						投保单全称
					</td>
					<td class="right">
						阿迪法师打发斯蒂芬
					</td>
				</tr>
				<tr>
					<td>
						问题件列表：
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<table width="1200" border="1">
							<tr>
								<th scope="col">
									&nbsp;
								</th>
								<th scope="col">
									序号
								</th>
								<th scope="col">
									投保单号
								</th>
								<th scope="col">
									问题代码
								</th>
								<th scope="col">
									问题内容
								</th>
								<th scope="col">
									回复内容
								</th>
								<th scope="col">
									录入人
								</th>
								<th scope="col">
									录入时间
								</th>
								<th scope="col">
									操作位置
								</th>
								<th scope="col">
									返回对象
								</th>
							</tr>
							<tr>
								<td>
									<label>
										<input type="radio" name="radiobutton" value="radiobutton" />
									</label>
								</td>
								<td>
									&nbsp;
								</td>
								<td>
									&nbsp;
								</td>
								<td>
									&nbsp;
								</td>
								<td>
									&nbsp;
								</td>
								<td>
									&nbsp;
								</td>
								<td>
									&nbsp;
								</td>
								<td>
									&nbsp;
								</td>
								<td>
									&nbsp;
								</td>
								<td>
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td colspan="4">
						<input type="button" class="button" name="queryButton" value="首页"
							onClick="">
						<input type="button" class="button" name="queryButton" value="上一页"
							onClick="">
						<input type="button" class="button" name="queryButton" value="下一页"
							onClick="">
						<input type="button" class="button" name="queryButton" value="尾页"
							onClick="">
					</td>
				</tr>
				<tr>
					<td>
						问题件内容
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="" cols="50" rows="5"></textarea>
					</td>
				</tr>

				<tr>
					<td>
						问题件回复
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="" cols="50" rows="5"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<input type="button" class="button" name="queryButton"
							value="回复问题" onClick="">
						<input type="button" class="button" name="queryButton" value="返回"
							onClick="">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
