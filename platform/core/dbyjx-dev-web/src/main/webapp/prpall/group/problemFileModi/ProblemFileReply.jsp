<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>������ظ�</title>
    
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
						��ͬͶ��������
					</td>
					<td class="right">
						17234751273647
					</td>
					<td class="left">
						Ͷ����ȫ��
					</td>
					<td class="right">
						���Ϸ�ʦ��˹�ٷ�
					</td>
				</tr>
				<tr>
					<td>
						������б�
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
									���
								</th>
								<th scope="col">
									Ͷ������
								</th>
								<th scope="col">
									�������
								</th>
								<th scope="col">
									��������
								</th>
								<th scope="col">
									�ظ�����
								</th>
								<th scope="col">
									¼����
								</th>
								<th scope="col">
									¼��ʱ��
								</th>
								<th scope="col">
									����λ��
								</th>
								<th scope="col">
									���ض���
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
						<input type="button" class="button" name="queryButton" value="��ҳ"
							onClick="">
						<input type="button" class="button" name="queryButton" value="��һҳ"
							onClick="">
						<input type="button" class="button" name="queryButton" value="��һҳ"
							onClick="">
						<input type="button" class="button" name="queryButton" value="βҳ"
							onClick="">
					</td>
				</tr>
				<tr>
					<td>
						���������
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="" cols="50" rows="5"></textarea>
					</td>
				</tr>

				<tr>
					<td>
						������ظ�
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
							value="�ظ�����" onClick="">
						<input type="button" class="button" name="queryButton" value="����"
							onClick="">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
