<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@include file="/common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��ӱ�������</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">	ctx = "${ctx}";</script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/noImageInput/NoListAdd.js">	</script>
  </head>
  <body>
    <form id="bnfForm">
	<div style = "width:100%">
	<input type="hidden" value="S211020120002" name="lcInsured.grpContNo">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">�����������ϣ��ͻ���<input name="vipFlag" class="common" type="text" style="width:20%"><input type="button" class="cssbutton" value="��  ѯ" onclick="">�����״�Ͷ����λ������д�ͻ��ţ�</td>
			</tr>
			<tr> 
				<td class="left">�������ͱ�ǣ�</td>
				<td class="right"><input class="codecode" id="remark" name="lcInsured.remark" class="common" type="text" value="1" style="width:20%" ondblclick="queryCode('remark','remarkName','PDLDcode1','codeType:InsuredRemark');"><input id="remarkName" name="remarkName" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="images/bgMarkMustInput.jpg" ></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr> 
				<td class="left">������������</td>
				<td class="right"><input name="lcInsured.insuredPeoples" class="common" type="text" value="2"><img src="images/bgMarkMustInput.jpg" ></td>
				<td class="left">ְҵ���룺</td>
				<td class="right"><input class="codecode" id="occupationCode" name="lcInsured.occupationCode" class="common" type="text" value="2" style="width:20%" ondblclick="queryCode('occupationCode','occupationCodeName','PDLDcode1','codeType:OccupationCode')"><input id="occupationCodeName" name="occupationCodeName" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="images/bgMarkMustInput.jpg" ></td>
				<td class="left">ְҵ���</td>
				<td class="right"><input class="codecode" id="occupationType" name="lcInsured.occupationType" class="common" type="text" value="1" style="width:20%" ondblclick="queryCode('occupationType','occupationTypeName','PDLDcode1','codeType:OccupationType')"><input id="occupationTypeName" name="" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="images/bgMarkMustInput.jpg" ></td>
			</tr>
		</table>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     �������˸�֪��Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">���</td>
					<td width="10%">��֪���</td>
					<td width="10%">��֪����</td>
					<td width="35%">��֪����</td>
					<td width="35%">��д����</td>
					<td width="5%">&nbsp;&nbsp;</td>
				</tr>
			</thead>
			<tbody id="PublicInfoBody">
			<!-- 
			<tr>
				<td><input type='text' size='5'  name='lcRepInfoList[0].id.impartVer' value="�ڶ���"/><img src='images/bgMarkMustInput.jpg' ></td>
				<td><input type='text' size='4'  name='lcRepInfoList[0].id.impartCode' value="abc"/><img src='images/bgMarkMustInput.jpg' ></td>
				<td><input type='text' name='lcRepInfoList[0].impartDetailContent' size='60' value="��Ʒ������"/><img src='images/bgMarkMustInput.jpg' ></td>
				<td><input type='text' name='lcRepInfoList[0].message' size='60' value="��·��Ϣ"/></td>
				<td>&nbsp;</td>
			</tr>
			 -->
			</tbody>
		</table>
		<input type="button" value="+" onclick="addPublicInfo()"/>
		<br>
		<table id="scanApplycInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     ��������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">���</td>
					<td width="12%">���������</td>
					<td width="12%">����������</td>
					<td width="8%">�Ա�</td>
					<td width="12%">֤������</td>
					<td width="12%">֤������</td>
					<td width="12%">�������뱻�����˹�ϵ</td>
					<td width="12%">����˳��</td>
					<td width="10%">�������</td>
					<td width="3%">&nbsp;&nbsp;</td>
				</tr>
			</thead>
			<tbody id="scanApplycInfoBody">
			<!--  
			<tr>
				<td width="5%">0</td>
					<td width="12%"><input type='text' name='lcBnfList[0].id.bnfType' size='15' value="1" /><img src='images/bgMarkMustInput.jpg' ></td>
					<td width="12%"><input type='text' name='lcBnfList[0].name' size='15' value="long"/><img src='images/bgMarkMustInput.jpg' ></td>
					<td width="8%"><input type='text' name='lcBnfList[0].sex' size='6' value="1"/><img src='images/bgMarkMustInput.jpg' ></td>
					<td width="12%"><input type='text' name='lcBnfList[0].idType' size='15' value="1"/><img src='images/bgMarkMustInput.jpg' ></td>
					<td width="12%"><input type='text' name='lcBnfList[0].idNo' size='15' value="123546548798"/><img src='images/bgMarkMustInput.jpg' ></td>
					<td width="12%"><input type='text' name='lcBnfList[0].relationToInsured' size='15' value="2"/></td>
					<td width="12%"><input type='text' name='lcBnfList[0].id.bnfGrade' size='15' value="1"/><img src='images/bgMarkMustInput.jpg' ></td>
					<td width="10%"><input type='text' name='lcBnfList[0].bnfLot' size='12' value="0.2"/><img src='images/bgMarkMustInput.jpg' ></td>
					<td width="3%">&nbsp;&nbsp;</td>
			</tr>
			-->
			</tbody>
		</table>
		<input type="button" value="+" onclick="addApplycInfo()"/>
		<br>
		<table id="PageInfo2" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td colspan="6" align="right"><input type = "button" class="cssbutton" value="��ӱ�������" onclick="saveInfo()"></td>
				</tr>
		</table>
		<hr>
		<table id="scanApplycInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     ��������������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">���</td>
					<td width="23%">���յ����ֺ���</td>
					<td width="23%">���ֱ���</td>
					<td width="23%">���ѣ�Ԫ��</td>
					<td width="23%">���Ԫ��</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>13213233131</td>
					<td>GDS</td>
					<td>50</td>
					<td>5000</td>
				</tr>
			</tbody>
		</table>
		<br>
		<table id="scanApplycInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     ���������嵥�б�</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">���</td>
					<td width="10%">�������˿ͻ���</td>
					<td width="10%">����</td>
					<td width="10%">�Ա�</td>
					<td width="10%">��������</td>
					<td width="10%">֤������</td>
					<td width="15%">֤������</td>
					<td width="10%">���ѣ�Ԫ��</td>
					<td width="10%">�㼶����</td>
					<td width="10%">����������</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>2000212121</td>
					<td>ս��</td>
					<td>��</td>
					<td>1988-11-25</td>
					<td>1</td>
					<td>2222221255211121222</td>
					<td>60</td>
					<td>a�ƻ�</td>
					<td>8</td>
				</tr>
			</tbody>
		</table>
		<br>
		<hr>
		<table id="PageInfo2" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" align="left"><input type = "button" class="cssbutton" value="��  ��" onclick="javascript:history.go(-1);"></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
