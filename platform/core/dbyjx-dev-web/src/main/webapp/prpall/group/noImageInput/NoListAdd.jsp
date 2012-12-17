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
    
    <title>添加被保险人</title>
    
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
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">被保险人资料（客户号<input name="vipFlag" class="common" type="text" style="width:20%"><input type="button" class="cssbutton" value="查  询" onclick="">）（首次投保单位无需填写客户号）</td>
			</tr>
			<tr> 
				<td class="left">保单类型标记：</td>
				<td class="right"><input class="codecode" id="remark" name="lcInsured.remark" class="common" type="text" value="1" style="width:20%" ondblclick="queryCode('remark','remarkName','PDLDcode1','codeType:InsuredRemark');"><input id="remarkName" name="remarkName" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="images/bgMarkMustInput.jpg" ></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr> 
				<td class="left">被保险人数：</td>
				<td class="right"><input name="lcInsured.insuredPeoples" class="common" type="text" value="2"><img src="images/bgMarkMustInput.jpg" ></td>
				<td class="left">职业代码：</td>
				<td class="right"><input class="codecode" id="occupationCode" name="lcInsured.occupationCode" class="common" type="text" value="2" style="width:20%" ondblclick="queryCode('occupationCode','occupationCodeName','PDLDcode1','codeType:OccupationCode')"><input id="occupationCodeName" name="occupationCodeName" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="images/bgMarkMustInput.jpg" ></td>
				<td class="left">职业类别：</td>
				<td class="right"><input class="codecode" id="occupationType" name="lcInsured.occupationType" class="common" type="text" value="1" style="width:20%" ondblclick="queryCode('occupationType','occupationTypeName','PDLDcode1','codeType:OccupationType')"><input id="occupationTypeName" name="" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="images/bgMarkMustInput.jpg" ></td>
			</tr>
		</table>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     被保险人告知信息</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="10%">告知版别</td>
					<td width="10%">告知编码</td>
					<td width="35%">告知内容</td>
					<td width="35%">填写内容</td>
					<td width="5%">&nbsp;&nbsp;</td>
				</tr>
			</thead>
			<tbody id="PublicInfoBody">
			<!-- 
			<tr>
				<td><input type='text' size='5'  name='lcRepInfoList[0].id.impartVer' value="第二版"/><img src='images/bgMarkMustInput.jpg' ></td>
				<td><input type='text' size='4'  name='lcRepInfoList[0].id.impartCode' value="abc"/><img src='images/bgMarkMustInput.jpg' ></td>
				<td><input type='text' name='lcRepInfoList[0].impartDetailContent' size='60' value="高品质内容"/><img src='images/bgMarkMustInput.jpg' ></td>
				<td><input type='text' name='lcRepInfoList[0].message' size='60' value="入路信息"/></td>
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
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     受益人信息</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="12%">受益人类别</td>
					<td width="12%">受益人姓名</td>
					<td width="8%">性别</td>
					<td width="12%">证件类型</td>
					<td width="12%">证件号码</td>
					<td width="12%">受益人与被保险人关系</td>
					<td width="12%">收益顺序</td>
					<td width="10%">收益比例</td>
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
					<td colspan="6" align="right"><input type = "button" class="cssbutton" value="添加被保险人" onclick="saveInfo()"></td>
				</tr>
		</table>
		<hr>
		<table id="scanApplycInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     被保险人险种信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="23%">保险单险种号码</td>
					<td width="23%">险种编码</td>
					<td width="23%">保费（元）</td>
					<td width="23%">保额（元）</td>
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
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     被保险人清单列表</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="10%">被保险人客户号</td>
					<td width="10%">姓名</td>
					<td width="10%">性别</td>
					<td width="10%">出生日期</td>
					<td width="10%">证件类型</td>
					<td width="15%">证件号码</td>
					<td width="10%">保费（元）</td>
					<td width="10%">层级编码</td>
					<td width="10%">被保险人数</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>2000212121</td>
					<td>战三</td>
					<td>男</td>
					<td>1988-11-25</td>
					<td>1</td>
					<td>2222221255211121222</td>
					<td>60</td>
					<td>a计划</td>
					<td>8</td>
				</tr>
			</tbody>
		</table>
		<br>
		<hr>
		<table id="PageInfo2" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" align="left"><input type = "button" class="cssbutton" value="返  回" onclick="javascript:history.go(-1);"></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
