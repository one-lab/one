<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>呈报明细查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
    <script src="${ctx}/prpall/group/report/reportQuery/ReportQuerySelect.js"></script>
	<script type="text/javascript">
		/*
		*页面初始化
		*页面初始化完就根据ReportQuerySelect.jsp页面传过来的参数“呈报申请号repNo”查询呈报返回信息
		*/
		var ctx= "${ctx}";
		
		var num=1;
		$(function(){
			var findUrl=ctx+"/prpall/findReportReturningInfo.do";
			var repNo=document.getElementById("repNoTem").value;
			var param={
					"lcReportAudit.id.repNo":repNo,	
					"lcReportAudit.id.serialNO":6
				};
			function findReportReturningInfoCallBack(obj){
				$("#content").html("");
				var contentString="";
				var xuhao = 1 ;
				for(var i = 0 ; i < obj.data.length; i++){
					contentString += "<tr class='content' name='aa'>";
					var date = new Date();
					date.setTime(obj.data[i].modifyDate.time);
					var dateStr = date.getUTCFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getUTCDate()+1);
					contentString += "<td ><input name='radioRepNo' type='radio' value="+obj.data[i].repNo+" />"+
					"<td>"+xuhao+"</td>"+
					"<td>"+obj.data[i].id.repNo+"</td>"+
					"<td>"+obj.data[i].id.serialNO+"</td>"+
					"<td>"+obj.data[i].repauditoperator+"</td>"+
					"<td>"+dateStr+"</td>"+
					"<td>"+obj.data[i].result+"</td>";
					$("#repauditidea").val(obj.data[i].repauditidea);
					xuhao++;
					contentString +="</tr>";
				}
				$("#content").html(contentString);
				
			}
			jQuery.post(findUrl, param, findReportReturningInfoCallBack, 'json');
			
		});
	</script>

  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="ReportBackInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">呈报返回信息</td>
			</tr>
			<tr class="tableHead">
				<td width="3%">&nbsp;</td>
				<td width="5%">序号</td>
				<td width="20%">呈报号</td>
				<td width="18%">呈报批次</td>
				<td width="18%">呈报审核人</td>
				<td width="18%">审核时间</td>
				<td width="18%">审核结论</td>
			</tr>
			</thead>
			<tbody id="content">
		    </tbody>
		</table>			
		<table id="auditIdeas" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" >审核意见（500字以内，回车符占一个字节）</td>
			</tr>
			<tr>
				<td colspan="6"><textarea id="repauditidea" name="repauditidea" cols="100%" rows="5"></textarea></td>
			</tr>
		</table>
		<table id=companyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../reportInput/CompanyInfo.jsp" /> </td>
			</tr>
		</table>
	</div>
	<div style="width:100%">
		<table id="GrpPolInfor" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">集体保单险种信息</td>
				</tr>
				<tr class="tableHead">
					<td width="10%">序号</td>
					<td width="15%">险种编码</td>
					<td width="15%">险种名称</td>
					<td width="15%">保费</td>
					<td width="15%">保额</td>
					<td width="15%">费用率</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>0601</td>
					<td>附加意外伤害医疗保险(0601)</td>
					<td>88</td>
					<td>5000</td>
					<td>0.15</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div style="width:100%">
		<table id="RiskInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种信息</td>
			</tr>
			<tr>
				<td width="17%"  class="left">险种编码：</td>
				<td width="33%"  class="right"><input name="RegistNo2" class="common" type="text" onchange="clickable()" /></td>
				<td width="18%"  class="left">费用率（0-1）：</td>
				<td width="32%"  class="right"><input name="RegistNo2" class="common" type="text" onchange="clickable()" /></td>
			</tr>
			<tr>
				<td colspan="6">
					<input type="button" class="cssbutton" name = "AddRisk" value="添加险种" onclick="">
					<input type="button" class="cssbutton" name = "DelRisk" value="删除险种" onclick="">
				</td>
			</tr>
		</table>
		<hr>
		<table>
			<tr>
				<td >
					<input type="button" class="cssbutton" name = "AddPlan" value="保障计划定制" onclick="location.href='../reportInput/EnsurePlan.jsp'">
					<input type="button" class="cssbutton" name = "ModifyPlan" value="保障计划维护" onclick="location.href='../reportInput/EnsurePlan.jsp'">
					<input type="button" class="cssbutton" name = "InsuredImport" value="被保人清单导入" onclick="location.href='../reportInput/InsuredListImport.jsp'">
				</td>
			</tr>
		</table>
		<hr>
	</div>
	<div style = "width:100%">
		<table id="GrpInsurInfor" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">   集体保单被保人信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="7%">序号</td>
					<td width="20%">类别</td>
					<td width="20%">类别名称</td>
					<td width="20%">数值</td>
					<td width="15%">投保人数</td>
					<td width="15%">人数占比</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="checkbox" name="checkbox" value="checkbox"></td>
					<td>1</td>
					<td>2</td>
					<td>性别</td>
					<td>男</td>
					<td>10</td>
					<td>100%</td>
				</tr>
			</tbody>
		</table>
		<br>
	</div>
	<div style="width:100%">
		<table id="GrpInsurInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left" >被保人最大年龄：</td>
				<td class="right"><input name="insurMaxAge" class="common" type="text"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">被保人最小年龄：</td>
				<td class="right"><input name="insurMinAge" class="common" type="text"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">被保人平均年龄：</td>
				<td class="right"><input name="insurAverAge" class="common" type="text"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
		</table>
		<br><hr>
	</div>
	<div style="width:100%">
		<table id="GrpInsurDetailInfor" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td colspan="6" class="formtitle"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">   集体保单被保人详细信息</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="9%">保障计划</td>
					<td width="9%">险种信息</td>
					<td width="9%">责任信息</td>
					<td width="9%">性别</td>
					<td width="9%">职业类别</td>
					<td width="9%">最小年龄</td>
					<td width="9%">最大年龄</td>
					<td width="9%">保费（每人）</td>
					<td width="9%">标准保费（每人）</td>
					<td width="9%">费率折扣</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>A</td>
					<td>0518</td>
					<td>211301</td>
					<td>男</td>
					<td>四</td>
					<td>26</td>
					<td>26</td>
					<td>60</td>
					<td>80</td>
					<td>0.125</td>
				</tr>
			</tbody>
		</table>
		<table>
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>
		<hr>
	</div>
	<div style="width:100%">
		<table id="MoneyInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">整单保费：</td>
				<td class="right"><input name="Prem" class="common" type="text" onchange="clickable()" /><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">整单保费折扣：</td>
				<td class="right"><input name="Discount" class="common" type="text" /><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">整单费用率：</td>
				<td class="right"><input name="Rate" class="common" type="text"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td colspan="6">
					<input type="button" class="cssbutton" name = "saveButton" value="保  存" onclick="" />
					<input type="button" class="cssbutton" name = "updateButton" value="修  改" onclick="" />
				</td>
			</tr>
		</table>
		<hr>
	</div>
	<div style="width:100%">
		<table id="UplodeInfor" class="common" cellpadding="3" cellspacing="0">
			<thead>
			<tr>
				<td colspan="7"><input type="button" class="cssbutton" name = "UpLoad" value="上传附件" onclick="" /></td>
			</tr>
			<tr>
				<td colspan="7">上载信息查看</td>
			</tr>
			<tr class="tableHead">
				<td width="3%">&nbsp;</td>
				<td width="5%">序号</td>
				<td width="18%">呈报申请号</td>
				<td width="18%">上载批次号</td>
				<td width="18%">经办人</td>
				<td width="18%">上载日期</td>
				<td width="20%">下  载</td>
			</tr>
			<thead>
			<tbody>
			<tr class="content">
				<td>1</td>
				<td>1</td>
				<td>S11111111111</td>
				<td>S11111111111_1</td>
				<td>Andy</td>
				<td>2012-05-15</td>
				<td><input type="button" class="cssbutton" name = "UpLoad" value="下  载" onclick="" /></td>
			</tr>
			</tbody>
		</table>
		<table>
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>
		<hr>
		<table id="ButtonInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6"><input type="button" class="cssbutton" name = "ReturnBack" value="返  回" onclick="javascript:history.go(-1);" /></td>
			</tr>
		</table>
	</div>
    <input type="hidden" id="repNoTem" value=<%=request.getParameter("repNo")%>>
	</form>
  </body>
</html>
