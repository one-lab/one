//险种用序号
var riskNum=1;

function checkRealRisk() {
	if ($("#riskName").val().indexOf('附加') >= 0) {
		$("#mainRiskNameTD").css("display", "");
		$("#mainRiskValueTD").css("display", "");
	} else {
		$("#mainRiskNameTD").css("display", "none");
		$("#mainRiskValueTD").css("display", "none");
	}
}

function opentEnsure() {
	var repNo=$("#repNo").val();
	var grpContNo=$("#grpContNoHidden").val();
//	if(null==repNo||""==repNo){
//		alert("请先保存呈报信息！");
//		return false;
//	}
	window.location = contextRootPath+"/prpall/initializeEnsurePlan.do?lcGrpContReport.id.repNo=S200020120058&lcGrpContReport.id.grpContNo=T20002012000019";//+grpContNo;//+repNo;
}

function callback() {
	if ($("#riskName").val().indexOf('附加') >= 0) {
		$("#riskCode").val();
	}
	checkRealRisk();
}
// 保存呈报基本信息，呈报团体客户信息，呈报团单投保人信息，集体保单部分信息，呈报告知信息
function saveBaseInfo(){
	$.ajax({
		type : "POST",
		url : contextRootPath + "/prpall/saveBaseInfo.do",
		data : $("#reportForm").serialize(),
		dataType :"json",
		success : function(obj){
			if(null!=obj){
				//向隐藏域中写入信息
			$("#repNo").val(obj.lcReport[0].repNo);
			$("#serialNoHidden").val(obj.lcReport[0].serialNo);
			$("#repNoHidden").val(obj.lcReport[0].repNo);
			$("#repApplyDateHidden").val(new Date(obj.lcReport[0].repApplyDate.time).format("yyyy-MM-dd"));
			$("#repOperatorHidden").val(obj.lcReport[0].repOperator);
			$("#manageComHidden").val(obj.lcReport[0].manageCom);
			$("#grpContNoHidden").val(obj.lcGrpContReport[0].id.grpContNo);
			$("#prtNoHidden").val(obj.lcGrpContReport[0].prtNo);
			$("#customerNoHidden").val(obj.ldGrp[0].customerNo);
			$("#customerNo").val(obj.ldGrp[0].customerNo);
			$("#saleChnlHidden").val(obj.lcGrpContReport[0].saleChnl);
			$("#agentTypeHidden").val(obj.lcGrpContReport[0].agentType);
			$("#agentGroupHidden").val(obj.lcGrpContReport[0].agentGroup);
			$("#agentCode1Hidden").val(obj.lcGrpContReport[0].agentCode1);
			$("#agentComHidden").val(obj.lcGrpContReport[0].agentCom);
			$("#agentCodeHidden").val(obj.lcGrpContReport[0].agentCode);
			$("#addressNoHidden").val(obj.lcGrpContReport[0].addressNo);
			$("#GrpNameHidden").val(obj.lcGrpContReport[0].GrpName);
			$("#riskCodeHidden").val(obj.lcGrpContReport[0].riskCode);
			$("#payModeHidden").val(obj.lcGrpContReport[0].payMode);
			$("#mainRiskCodeHidden").val(obj.lcGrpContReport[0].mainRiskCode);
			$("#proposalGrpContNoHidden").val(obj.lcGrpContReport[0].proposalGrpContNo);
			//告知单信息
			$("#PremInfoBody").html("");
			var content="";
			for(var i=0;i<obj.lcRepInfoReportList.length;i++){
				if(obj.lcRepInfoReportList[i].message==null){
					obj.lcRepInfoReportList[i].message="";
				}
				var content="<tr class='content' id='prem"+(i)+"'>";
				content+="<td>"+(i+1)+"<input type='hidden' id='serial"+(i)+"' name='lcRepInfoReportList["+(i)+"].id.subSerialNo' value='"+obj.lcRepInfoReportList[i].id.subSerialNo+"' /></td>"
				+"<td><input type='text' id='ver"+(i)+"' name='lcRepInfoReportList["+(i)+"].id.impartVer' value='"+obj.lcRepInfoReportList[i].id.impartVer+"' maxlength='5' size='5'/><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"
				+"<td><input type='text' id='code"+(i)+"' name='lcRepInfoReportList["+(i)+"].id.impartCode' value='"+obj.lcRepInfoReportList[i].id.impartCode+"' maxlength='4' size='4'/><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"
				+"<td><input type='text' id='detail"+(i)+"' name='lcRepInfoReportList["+(i)+"].impartDetailContent' value='"+obj.lcRepInfoReportList[i].impartDetailContent+"'   size='50' /><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"
				+"<td><input type='text' id='mes"+(i)+"' name='lcRepInfoReportList["+(i)+"].message' value='"+obj.lcRepInfoReportList[i].message+"' size='50'/></td>"
				+"<td><input type='button' value='-' onclick=removePremInfo('prem"+(i)+"') /></td>";
				content+="</tr>";
			}
			
			$("#PremInfoBody").html(content);
			$("#competitionStatus").val(obj.lcRepInfoReportDetail[0].competitionStatus);
			$("#insurStatus").val(obj.lcRepInfoReportDetail[0].insurStatus);
			$("#clmHistory").val(obj.lcRepInfoReportDetail[0].clmHistory);
			$("#conStatusAndServ").val(obj.lcRepInfoReportDetail[0].conStatusAndServ);
			//保存按钮不可用，不能二次保存
			$("#baseSaveButton").attr("disabled",true);
			$("#addRepInfoButton").attr("disabled",true);
			$("premInfoDele").attr("disabled",true);
			alert("保存成功！");
		}
		}
	});

}
//更新呈报基本信息，呈报团体客户信息，呈报团单投保人信息，集体保单部分信息，呈报告知信息
function updateBaseInfo(){
	$.ajax({
		type : "POST",
		url : contextRootPath + "/prpall/updateBaseInfo.do",
		data : $("#reportForm").serialize(),
		dataType :"json",
		success : function(obj){
			if(null!=obj){
				if(obj.msg=="success"){}
			alert("修改成功！");
			}
		}
		
	});
}
// 增加险种
function addRisk(){
	var url = contextRootPath + "/prpall/addRisk.do";
	var params = {
		"lcGrpPolReport.id.repNo":$("#repNoHidden").val(),	
		"lcGrpPolReport.repApplyDate":$("#repApplyDateHidden").val(),
		"lcGrpPolReport.repOperator":$("#repOperatorHidden").val(),
		"lcGrpPolReport.grpContNo":$("#grpContNoHidden").val(),
		"lcGrpPolReport.prtNo":$("#prtNoHidden").val(),
		"lcGrpPolReport.customerNo":$("#customerNoHidden").val(),
		"lcGrpPolReport.saleChnl":$("#saleChnlHidden").val(),
		"lcGrpPolReport.manageCom":$("#manageComHidden").val(),
		"lcGrpPolReport.agentType":$("#agentTypeHidden").val(),
		"lcGrpPolReport.agentGroup":$("#agentGroupHidden").val(),
		"lcGrpPolReport.agentCode1":$("#agentCode1Hidden").val(),
		"lcGrpPolReport.agentCom":$("#agentComHidden").val(),
		"lcGrpPolReport.agentCode":$("#agentCodeHidden").val(),
		"lcGrpPolReport.addressNo":$("#addressNoHidden").val(),
		"lcGrpPolReport.GrpName":$("#GrpNameHidden").val(),
		"lcGrpPolReport.manageCom":$("#manageComHidden").val(),
		"lcGrpPolReport.riskCode":$("#riskCode").val(),
		"lcGrpPolReport.mainRiskCode":$("#mainRiskCode").val()
	};
	function riskCallback(obj){
		var riskHTML = $("#riskContent").html();
		riskHTML += "<tr class='content' id='"+obj.lcGrpPolReport[0].id.grpPolNo+"'><td><input type='radio' name='riskRadio' value='"+obj.lcGrpPolReport[0].id.grpPolNo+"'/></td><td>"+riskNum+"</td><td>"+obj.lcGrpPolReport[0].riskCode+
			"</td><td>"+$("#riskName").val()+
			"</td><td>0</td><td>0</td><td>"+obj.lcGrpPolReport[0].payMode+
			"</td></tr>";
		$("#riskContent").html(riskHTML);
		riskNum++;
	};
	jQuery.post(url,params,riskCallback,"json");	
}
//删除险种
function deleteRisk(){
	var deleUrl=ctx+"/prpall/deleRisk.do";
	var grpPolNo="";
	if(null==$('input:radio[name="riskRadio"]:checked').val()
			   ||undefined==$('input:radio[name="riskRadio"]:checked').val()){
			   alert("请选择一条呈报申请记录进行删除！");
			   return false;
			}
	grpPolNo= $('input:radio[name="riskRadio"]:checked').val();
	var param={
			"lcGrpPolReport.id.repNo":$("#repNoHidden").val(),
			"lcGrpPolReport.id.grpPolNo":grpPolNo
	};
	function deleteRiskCallBack(obj){
		$("#"+obj.lcGrpPolReport[0].id.grpPolNo).remove();
		alert("删除成功！");
	}
	if(window.confirm("确定要删除吗？")){
		jQuery.post(deleUrl,param,deleteRiskCallBack,"json");
	}
	
}
// 增加集体被保人模糊信息的“+”按钮
function addGrpInsurInfor() {
	var $table_tr=$("#GrpInsurInforBody tr");
	var len=$table_tr.length;
	var content = "<tr class='content' id='grp"+(len)+"'>"+ 
	"<td><input type='checkbox' checked='checked' id='GrpInsurInforId' name='serialNo' value='0'/></td>"+
	"<td>"+ (len+1)	+ "</td>"+ 
	"<td><input class='codecode' id='GrpInsurInforType"+ (len)+ "' name='type' class='common' type='text' value='' style='width:68%' ondblclick=queryCode('GrpInsurInforType"+ (len)+ "','GrpInsurInforTypeName"+ (len)+ "','PDLDcode1','codeType:GrpInsurInforType') /><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"+
	"<td><input id='GrpInsurInforTypeName"+ (len)	+ "' name='typeName' class='common' type='text'   style='width:68%' value=''/></td>"+
	"<td><input id='typevalue"+(len)+"' name='typevalue' class='common' type='text'   style='width:68%' value=''/><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"+ 
	"<td><input id='peoples"+(len)+"' name='peoples' class='common' type='text'   style='width:68%' value=''/><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"+
	"<td><input id='rate"+(len)+"' name='rate' class='common' type='text'   style='width:68%' value=''/><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"	+
	"<td width='3%'><input type='button' value='-' onclick=removeGrpInsurInfor('grp"+ (len) + "') /></td>"
	+ "</tr>";
	$("#GrpInsurInforBody").append(content);
	
}
// 移除信息的“-”按钮
function removeGrpInsurInfor(t) {
	var $table_tr=$("#GrpInsurInforBody tr");
	var len=$table_tr.length;
	var index=parseInt(t.substring(3));
	if(index>len){
		return;
	}else{
		for(var temp=index;temp<=len;temp++)
		   {
			if(temp==len){
				$("#grp"+temp).remove();
			}else{
				$("#GrpInsurInforType"+temp).val($("#GrpInsurInforType"+(temp+1)).val());
				$("#GrpInsurInforTypeName"+temp).val($("#GrpInsurInforTypeName"+(temp+1)).val());
				$("#typevalue"+temp).val($("#typevalue"+(temp+1)).val());
				$("#peoples"+temp).val($("#peoples"+(temp+1)).val());
				$("#rate"+temp).val($("#rate"+(temp+1)).val());
			}
		   } 
		
	}
}
// 处理保存按钮请求
function saveGrpInsurInfor() {
	var repNo=$("#repNo").val();
	if(null==repNo||""==repNo){
		alert("请先保存呈报信息！");
	}else{
	var url = contextRootPath + "/prpall/saveGrpInsurInfor.do";
		var maxage=$("#insurMaxAge").val();
	var minage=$("#insurMinAge").val();
	var average=$("#insurAverAge").val();
	var contPlanCode=$("#riskCode").val();
	var contplanname=$("#riskName").val();
	var serialNo = document.getElementsByName("serialNo");
	var checked=new Array(serialNo.length);
	for(var i=0,k=0;i<serialNo.length;i++){
		if(serialNo[i].checked){
			checked[k]=i;
			k++;
		}
	}
	var typeStr =document.getElementsByName("type");
	var typeNameStr = document.getElementsByName("typeName");
	var typeValueStr = document.getElementsByName("typevalue");
	var typePeopleStr =document.getElementsByName("peoples");
	var typeRateStr = document.getElementsByName("rate");
	var list="var params={";
		for(var i = 0; i < checked.length; i++){
			list+="'lcGrpInsuredInfoReportList["+i+"].id.serialNo':'"+serialNo[checked[i]].value+
			"','lcGrpInsuredInfoReportList["+i+"].id.repNo':'"+repNo+
			"','lcGrpInsuredInfoReportList["+i+"].type':'"+typeStr[checked[i]].value+
			"','lcGrpInsuredInfoReportList["+i+"].typeName':'"+typeNameStr[checked[i]].value+
			"','lcGrpInsuredInfoReportList["+i+"].typeValue':'"+typeValueStr[checked[i]].value+
			"','lcGrpInsuredInfoReportList["+i+"].peoples':'"+typePeopleStr[checked[i]].value+
			"','lcGrpInsuredInfoReportList["+i+"].rate':'"+typeRateStr[checked[i]].value+
			"','lcGrpInsuredInfoReportList["+i+"].maxAge':'"+maxage+
			"','lcGrpInsuredInfoReportList["+i+"].minAge':'"+minage+
			"','lcGrpInsuredInfoReportList["+i+"].averAge':'"+average+
			"','lcGrpInsuredInfoReportList["+i+"].contPlanCode':'"+contPlanCode+
			"','lcGrpInsuredInfoReportList["+i+"].contPlanName':'"+contplanname+
			"',";
		}
	
	list=list.substring(0, list.length-1);
	list+="}";
	eval(list);
	function grpInsurInforCallback(obj){
		if(null!=obj){
		$("#GrpInsurInforBody").html("");
		var content="";			
		var xuhao=1;
		for(var j=0;j<obj.data.length;j++){
			 content += "<tr class='content' id='"+xuhao+"'>"
			+ "<td><input type='checkbox' checked='checked' id='GrpInsurInforId' name='serialNo' value='"+obj.data[j]["id.serialNo"]+"'/></td>"+
			"<td>"+ xuhao+ "</td>"+ 
			"<td><input class='codecode' id='GrpInsurInforType"	+ xuhao	+ "' name='type' class='common' type='text' value='"+obj.data[j]["type"]+"' style='width:68%' ondblclick=queryCode('GrpInsurInforType"+ xuhao+ "','GrpInsurInforTypeName"+ xuhao+ "','PDLDcode1','codeType:GrpInsurInforType') /><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"+ 
			"<td><input id='GrpInsurInforTypeName"+ xuhao+ "' name='typeName' class='common' type='text'   style='width:68%' value='"+obj.data[j]["typeName"]+"'/></td>"+ 
			"<td><input id='' name='typevalue' class='common' type='text'   style='width:68%' value='"+obj.data[j]["typeValue"]+"'/><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"+
			"<td><input id='' name='peoples' class='common' type='text'   style='width:68%' value='"+obj.data[j]["peoples"]+"'/><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"+
			"<td><input id='' name='rate' class='common' type='text'   style='width:68%' value='"+obj.data[j]["rate"]+"'/><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"+
			"<td width='3%'><input type='button' value='-' onclick='removeGrpInsurInfor("+ xuhao + ")'/></td>" +
			"</tr>";
			xuhao++;
		}
		$("#GrpInsurInforBody").html(content);
		$("#insurMaxAge").val(obj.data[0]["maxAge"]);
		$("#insurMinAge").val(obj.data[0]["minAge"]);
		$("#insurAverAge").val(obj.data[0]["averAge"]);
		num=xuhao;
		}
	}
	jQuery.post(url,params,grpInsurInforCallback,'json');
	}
}

//根据客户号查询投保单位资料的查询按钮
function selectInfoByCustomerNo(){
	var actionUrl = contextRootPath + "/prpall/findInfoByCustomerNo.do";
	//团体客户表
	var actionParams = {
		"ldGrp.customerNo":$("#customerNo").val()
	};
	function actionCallBack(obj){
		if(null!=obj){
			var dateStr="";
			if(null!=obj.data[0].foundDate){
			var date = new Date();
			date.setTime(obj.data[0].foundDate.time);
			dateStr = date.getUTCFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getUTCDate()+1);
			}
		$("#customerNo").val(obj.data[0].customerNo);
		$("#vipValue").val(obj.data[0].vipValue);
		$("#grpName").val(obj.data[0].grpName);
		$("#businessType").val(obj.data[0].businessType);
		$("#organizationNo").val(obj.data[0].organizationNo);
		$("#asset").val(obj.data[0].asset);
		$("#taxRegistNo").val(obj.data[0].taxRegistNo);
		$("#yearGrossIncome").val(obj.data[0].yearGrossIncome);
		$("#grpNature").val(obj.data[0].grpNature);
		$("#foundDate").val(dateStr);
		$("#mainBussiness").val(obj.data[0].mainBussiness);
		$("#operateArea").val(obj.data[0].operateArea);
		$("#peoples").val(obj.data[0].peoples);
		}
	}
	jQuery.post(actionUrl,actionParams,actionCallBack, "json");
	
}

// 告知单增加按钮
function addPremInfo(){
	var $table_tr=$("#PremInfoBody tr");
	var len=$table_tr.length;
	var content="<tr class='content' id='prem"+(len)+"'>";
	content+="<td>"+(len+1)+"<input type='hidden' id='serial"+(len)+"' name='lcRepInfoReportList["+(len)+"].id.subSerialNo'/></td>"
	+"<td><input type='text' id='ver"+(len)+"' name='lcRepInfoReportList["+(len)+"].id.impartVer' maxlength='5' size='5'/><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"
	+"<td><input type='text' id='code"+(len)+"' name='lcRepInfoReportList["+(len)+"].id.impartCode' maxlength='4' size='4'/><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"
	+"<td><input type='text' id='detail"+(len)+"' name='lcRepInfoReportList["+(len)+"].impartDetailContent'   size='50' /><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"
	+"<td><input type='text' id='mes"+(len)+"' name='lcRepInfoReportList["+(len)+"].message' size='50'/></td>"
	+"<td><input type='button' name='premInfoDele' value='-' onclick=removePremInfo('prem"+(len)+"') /></td>";
	content+="</tr>";
	$("#PremInfoBody").append(content);
}
// 告知单删除按钮
function removePremInfo(p){
	var $table_tr=$("#PremInfoBody tr");
	var len=$table_tr.length;
	var index=parseInt(p.substring(4));
	if(index>len){
		return;
	}else{
		for(var temp=index;temp<=len;temp++)
		   {
			if(temp==len){
				$("#prem"+temp).remove();
			}else{
				$("#serial"+temp).val($("#serial"+(temp+1)).val());
				$("#ver"+temp).val($("#ver"+(temp+1)).val());
				$("#code"+temp).val($("#code"+(temp+1)).val());
				$("#detail"+temp).val($("#detail"+(temp+1)).val());
				$("#mes"+temp).val($("#mes"+(temp+1)).val());
			}
		   }	
	}
}
//上传附件按钮

function uploadFile(){
	var repNo=$("#repNo").val();
	window.open('${ctx}/prpall/group/report/reportInput/ReportFileInput.jsp?repNo='+repNo+'', 'newwindow', 'width=400, height=150, top=150, left=250, toolbar=no, menubar=no, scrollbars=no,resizable=no,location=no, status=yes');
}