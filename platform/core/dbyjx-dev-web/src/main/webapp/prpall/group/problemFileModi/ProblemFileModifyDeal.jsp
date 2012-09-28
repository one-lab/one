<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>问题件修改处理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="common/js/SimpleCalendar.js"></script>	
  </head>
  
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
		<tr>
			<td colspan="6"><p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<hr /></td>
		</tr>
		<tr>
			<td>投保单信息</td>
		</tr>
		<tr>
			<td class="left">投保单号码：</td>
			<td class="right">346781263476823647</td>
			<td  class="left">呈报件号</td>
			<td  class="right">3548263784657</td>
			<td class="left">投保日期</td>
			<td class="right"><INPUT name="Startdate" class="common" type="text" onchange="clickable()" style="width:73%"
    	  value='2012-04-28'>
				<img style='cursor:hand' align="absmiddle" src="common/images/bgcalendar.gif" onClick="TogglePopupCalendarWindow('document.fm.Startdate', '1997', '2014')"></td>
		</tr>
		<tr>
			<td class="left">保单生效日期</td>
			<td class="right"><INPUT name="Startdate" class="common" type="text" onchange="clickable()" style="width:73%"
    	  value='2012-04-28'>
				<img style='cursor:hand' align="absmiddle" src="common/images/bgcalendar.gif" onClick="TogglePopupCalendarWindow('document.fm.Startdate', '1997', '2014')"></td>
			<td  class="left">续保原保单号</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">管理机构</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td class="left">销售方式</td>
			<td class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></td>
			<td class="left">协议书号</td>
			<td class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td colspan="6"><hr /></td>
		</tr>
		<tr>
			<td class="left">业务员编码</td>
			<td class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></td>
			<td class="left">业务员姓名</td>
			<td class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></td>
			<td class="left">所属机构</td>
			<td class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">所属分部</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">多业务员，请勾选</td>
			<td  class="right"><input name="" type="checkbox" value="" /></td>
		</tr>
		<tr>
			<td colspan="6"><hr /></td>
		</tr>
		<tr>
			<td colspan="6"> 投保单位资料（客户号
				<input name="" type="text" />
				<input name="" type="button" value="查询" />
				）（首次投保单位无需填写客户号） </td>
		</tr>
		<tr>
			<td class="left">VIP客户</td>
			<td class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">投保单位全称</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">行业类别</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">组织机构代码</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">资产规模（万元）</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">税务登记证号</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">年总收入（万元）：</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">单位性质</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td class="left">成立日期</td>
			<td class="right"><INPUT name="Startdate" class="common" type="text" onchange="clickable()" style="width:73%"
    	  value='2012-04-28'>
				<img style='cursor:hand' align="absmiddle" src="common/images/bgcalendar.gif" onClick="TogglePopupCalendarWindow('document.fm.Startdate', '1997', '2014')"></td>
		</tr>
		<tr>
			<td  class="left">经营区域</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">主营业务</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">单位总人数</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">是否参加社会统筹</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">社保登记证号</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">联系地址</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">联系邮编</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">联系电话</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">联系部门</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">联系人姓名</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">联系人性别</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">联系人电话</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">手机</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">E-MAIL</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">单位法人</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">法人证件类型</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">法人证件号</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td class="left">法人有效日期：</td>
			<td class="right"><INPUT name="Startdate" class="common" type="text" onchange="clickable()" style="width:73%"
    	  value='2012-04-28'>
				<img style='cursor:hand' align="absmiddle" src="common/images/bgcalendar.gif" onClick=			    "TogglePopupCalendarWindow('document.fm.Startdate', '1997', '2014')"></td>
		</tr>
		<tr>
			<td  class="left">投保单位人数</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">主被保险人数</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">连带被保险人数</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">币种</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">保费结算方式</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">缴费方式</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">开户银行</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">账号</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">投保率</td>
			<td  class="right">1</td>
		</tr>
		<tr>
			<td colspan="6">保单付费方式&nbsp;&nbsp;
				<input name="" type="checkbox" value="" />
				投保单位全额负担</td>
		</tr>
		<tr>
			<td  class="left">单位负担（%）：</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">特定约定编码：</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td >特定约定内容：</td>
		</tr>
		<tr>
			<td colspan="6"><textarea name="" cols="" rows="4"></textarea></td>
		</tr>
		<tr>
			<td>投保单告知书</td>
		</tr>
		<tr>
			<td colspan="6"><table width="1000" border="1">
					<tr>
						<th width="36" scope="col">序号</th>
						<th width="196" scope="col">告知版别</th>
						<th width="258" scope="col">告知内容编号</th>
						<th width="258" scope="col">告知内容</th>
						<th width="218" scope="col">录入信息</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td><input type="button" class="button" name = "queryButton" value="保存/修改" onClick="" >
			</td>
		</tr>
		<tr>
			<td>集体保单险种信息</td>
		</tr>
		<tr>
			<td colspan="6"><table width="1000" border="1">
					<tr>
						<th width="32" scope="col">&nbsp;</th>
						<th width="72" scope="col">序号</th>
						<th width="183" scope="col">险种编码</th>
						<th width="185" scope="col">险种名称</th>
						<th width="142" scope="col">交费期间</th>
						<th width="157" scope="col">参保人数</th>
						<th width="158" scope="col">保费</th>
						<th width="157" scope="col">保额/份数合计</th>
						<th width="158" scope="col">费用率</th>
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
						<td>&nbsp;</td>
					</tr>
				</table></td>
		</tr>
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
				<input type="button" class="button" name = "queryButton2" value="联保设置" onclick="" />
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
				<input type="button" class="button" name = "queryButton2" value="影像件查询" onclick="parent.document.getElementById('fraInterface').src ='group/problemFileModi/ImageFileQuery.jsp'" />
				<input type="button" class="button" name = "queryButton2" value="返回" onclick="" />
			</td>
		</tr>
	</table>
</form>
  </body>
</html>
