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
    
    <title>�ʱ���ϸ��ѯ</title>
    
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
		*ҳ���ʼ��
		*ҳ���ʼ����͸���ReportQuerySelect.jspҳ�洫�����Ĳ������ʱ������repNo����ѯ�ʱ�������Ϣ
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�ʱ�������Ϣ</td>
			</tr>
			<tr class="tableHead">
				<td width="3%">&nbsp;</td>
				<td width="5%">���</td>
				<td width="20%">�ʱ���</td>
				<td width="18%">�ʱ�����</td>
				<td width="18%">�ʱ������</td>
				<td width="18%">���ʱ��</td>
				<td width="18%">��˽���</td>
			</tr>
			</thead>
			<tbody id="content">
		    </tbody>
		</table>			
		<table id="auditIdeas" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" >��������500�����ڣ��س���ռһ���ֽڣ�</td>
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
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">���屣��������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="10%">���</td>
					<td width="15%">���ֱ���</td>
					<td width="15%">��������</td>
					<td width="15%">����</td>
					<td width="15%">����</td>
					<td width="15%">������</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>0601</td>
					<td>���������˺�ҽ�Ʊ���(0601)</td>
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">������Ϣ</td>
			</tr>
			<tr>
				<td width="17%"  class="left">���ֱ��룺</td>
				<td width="33%"  class="right"><input name="RegistNo2" class="common" type="text" onchange="clickable()" /></td>
				<td width="18%"  class="left">�����ʣ�0-1����</td>
				<td width="32%"  class="right"><input name="RegistNo2" class="common" type="text" onchange="clickable()" /></td>
			</tr>
			<tr>
				<td colspan="6">
					<input type="button" class="cssbutton" name = "AddRisk" value="�������" onclick="">
					<input type="button" class="cssbutton" name = "DelRisk" value="ɾ������" onclick="">
				</td>
			</tr>
		</table>
		<hr>
		<table>
			<tr>
				<td >
					<input type="button" class="cssbutton" name = "AddPlan" value="���ϼƻ�����" onclick="location.href='../reportInput/EnsurePlan.jsp'">
					<input type="button" class="cssbutton" name = "ModifyPlan" value="���ϼƻ�ά��" onclick="location.href='../reportInput/EnsurePlan.jsp'">
					<input type="button" class="cssbutton" name = "InsuredImport" value="�������嵥����" onclick="location.href='../reportInput/InsuredListImport.jsp'">
				</td>
			</tr>
		</table>
		<hr>
	</div>
	<div style = "width:100%">
		<table id="GrpInsurInfor" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">   ���屣����������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="7%">���</td>
					<td width="20%">���</td>
					<td width="20%">�������</td>
					<td width="20%">��ֵ</td>
					<td width="15%">Ͷ������</td>
					<td width="15%">����ռ��</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="checkbox" name="checkbox" value="checkbox"></td>
					<td>1</td>
					<td>2</td>
					<td>�Ա�</td>
					<td>��</td>
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
				<td class="left" >������������䣺</td>
				<td class="right"><input name="insurMaxAge" class="common" type="text"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">��������С���䣺</td>
				<td class="right"><input name="insurMinAge" class="common" type="text"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">������ƽ�����䣺</td>
				<td class="right"><input name="insurAverAge" class="common" type="text"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
		</table>
		<br><hr>
	</div>
	<div style="width:100%">
		<table id="GrpInsurDetailInfor" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td colspan="6" class="formtitle"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">   ���屣����������ϸ��Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">���</td>
					<td width="9%">���ϼƻ�</td>
					<td width="9%">������Ϣ</td>
					<td width="9%">������Ϣ</td>
					<td width="9%">�Ա�</td>
					<td width="9%">ְҵ���</td>
					<td width="9%">��С����</td>
					<td width="9%">�������</td>
					<td width="9%">���ѣ�ÿ�ˣ�</td>
					<td width="9%">��׼���ѣ�ÿ�ˣ�</td>
					<td width="9%">�����ۿ�</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>A</td>
					<td>0518</td>
					<td>211301</td>
					<td>��</td>
					<td>��</td>
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
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="��  ҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="β  ҳ"></td>
			</tr>
		</table>
		<hr>
	</div>
	<div style="width:100%">
		<table id="MoneyInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">�������ѣ�</td>
				<td class="right"><input name="Prem" class="common" type="text" onchange="clickable()" /><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">���������ۿۣ�</td>
				<td class="right"><input name="Discount" class="common" type="text" /><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">���������ʣ�</td>
				<td class="right"><input name="Rate" class="common" type="text"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td colspan="6">
					<input type="button" class="cssbutton" name = "saveButton" value="��  ��" onclick="" />
					<input type="button" class="cssbutton" name = "updateButton" value="��  ��" onclick="" />
				</td>
			</tr>
		</table>
		<hr>
	</div>
	<div style="width:100%">
		<table id="UplodeInfor" class="common" cellpadding="3" cellspacing="0">
			<thead>
			<tr>
				<td colspan="7"><input type="button" class="cssbutton" name = "UpLoad" value="�ϴ�����" onclick="" /></td>
			</tr>
			<tr>
				<td colspan="7">������Ϣ�鿴</td>
			</tr>
			<tr class="tableHead">
				<td width="3%">&nbsp;</td>
				<td width="5%">���</td>
				<td width="18%">�ʱ������</td>
				<td width="18%">�������κ�</td>
				<td width="18%">������</td>
				<td width="18%">��������</td>
				<td width="20%">��  ��</td>
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
				<td><input type="button" class="cssbutton" name = "UpLoad" value="��  ��" onclick="" /></td>
			</tr>
			</tbody>
		</table>
		<table>
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="��  ҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="β  ҳ"></td>
			</tr>
		</table>
		<hr>
		<table id="ButtonInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6"><input type="button" class="cssbutton" name = "ReturnBack" value="��  ��" onclick="javascript:history.go(-1);" /></td>
			</tr>
		</table>
	</div>
    <input type="hidden" id="repNoTem" value=<%=request.getParameter("repNo")%>>
	</form>
  </body>
</html>
