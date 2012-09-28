//保障计划详细信息添加按钮“＋”
function addParams(){
	var $div_div=$("#planDetailDIV div");
	var len=$div_div.length;
	var content="<div id='div"+len+"'>"+
		"<table  class='common' cellpadding='3' cellspacing='0'>" +
			"<thead>" +
			"<tr class='tableHead'>" +
					"<td width='2%'>&nbsp;</td>" +
					"<td width='5%'>序号</td>" +
					"<td width='22%'>险种编码</td>" +
					"<td width='22%'>险种名称</td>" +
					"<td width='22%'>责任编码</td>" +
					"<td width='22%'>责任名称</td>" +
					"</tr>" +
			"</thead>" +
			"<tbody >" +
			"<tr class='content' >"+
			"<td width='2%'><input type='radio' name='dutyRadio' value='"+len+"' /></td>" +
			"<td>"+(len+1)+"</td>" +
			"<td><input id='mainRiskCode"+len+"' type='text' class='codecode' name='lcContPlanRiskReportList["+len+"].id.riskCode'  ondblclick=queryCode('mainRiskCode"+len+"','mainRiskCodeName"+len+"','findRiskByReport','repNo:repNo') /></td>" +
			"<td><input id='mainRiskCodeName"+len+"' type='text' style='width:90%' readonly='readonly'/></td>" +
			"<td><input id='dutyCode"+len+"' type='text' class='codecode'  name='lcDutyReportList["+len+"].id.dutyCode' ondblclick=queryCode('dutyCode"+len+"','dutyCodeName"+len+"','findDutyByRisk','riskCode:mainRiskCode"+len+"');findCalMode("+len+") /></td>" +
			"<td><input id='dutyCodeName"+len+"' type='text' style='width:90%' readonly='readonly'/></td>" +
			"</tr>" +
			"</tbody>" +
			"</table>" +
			"<br>" +
			"<table id='DutyParamInfo"+len+"' >" +
			"</table>"+
			"</div>"+
			"<br/>";
			$("#planDetailDIV").append(content);
		}
function deleParams(){
	var index="";
	if(null==$('input:radio[name="dutyRadio"]:checked').val()
			   ||undefined==$('input:radio[name="dutyRadio"]:checked').val()){
			   alert("请选择一条信息进行删除！");
			   return false;
			}
	index= $('input:radio[name="dutyRadio"]:checked').val();
	var $div_div=$("#planDetailDIV div");
	var len=$div_div.length;
			if(index>len){
				return;
			}else{
				for(var temp=index;temp<len;temp++)
				   {
					if(temp==(len-1)){
						$("#div"+temp).remove();
					}else{
						$("#mainRiskCode"+temp).val($("#mainRiskCode"+(temp+1)).val());
						$("#mainRiskCodeName"+temp).val($("#mainRiskCodeName"+(temp+1)).val());
						$("#dutyCode"+temp).val($("#dutyCode"+(temp+1)).val());
						$("#dutyCodeName"+temp).val($("#dutyCodeName"+(temp+1)).val());
					}
				   }	
			}
			$('input:radio[name="dutyRadio"]:checked').attr("checked", false);
}
		function sonCallbackFather(selfId,relationId){
			//将把所有的责任要素全部列出
			if(selfId.indexOf('dutyCode') >= 0){
				var findDutyParamsUrl = contextRootPath+"/product/findDutyParams.do";
				var findDutyParamsParams = {
					"dutyCode" : $("#"+selfId).val()
				};
				
				function findDutyParamsCallback(obj){
					var countStr = selfId.replace("dutyCode","");
					var riskCodeId = "mainRiskCode"+countStr;
					var dutyParamsContent = $("#dutyParamsContent");
					for(var i = 0 ; i < obj.data.length ; i++){
						var trT = $("<tr></tr>").appendTo(dutyParamsContent);
						var tdText = $("<td><input type='text' class='codecode' readonly='readonly' name='factorName"+i+"' value='"+obj.data[i].factorName+"' /></td>").appendTo(trT);
						var tdText = $("<td><input type='text' class='codecode'  readonly='readonly' value='"+(obj.data[i].factorNoti == null ? "":obj.data[i].factorNoti)+"' /></td>").appendTo(trT);
						var tdText = $("<td><input type='text' class='codecode'  name='lcContPlanDutyParamReportList["+i+"].calFactorValue' /></td>").appendTo(trT);
						var hiddenText = $(" <input type='hidden' name='lcContPlanDutyParamReportList["+i+"].id.dutyCode' value='"+$("#"+selfId).val()+"'/>").appendTo(trT);
						var hiddenText = $(" <input type='hidden' name='lcContPlanDutyParamReportList["+i+"].id.calFactor' value='"+obj.data[i]["id.calFactor"]+"'/>").appendTo(trT);
						var hiddenText = $(" <input type='hidden' name='lcContPlanDutyParamReportList["+i+"].id.riskCode' value='"+$("#"+riskCodeId).val()+"'/>").appendTo(trT);
					}
				}
				jQuery.post(findDutyParamsUrl,findDutyParamsParams,findDutyParamsCallback,'json');
			}
		}
		
		/*
		*呈报保障计划及其相关内容的删除
		*于文龙
		*/
		function deleteConPlan(){
			var repNo=$("#repNo").val();
			var planCode="";
			var flag=0;
			var url=ctx+"/prpall/deleteConPlan.do";
			var checkedValues=document.getElementsByName("checkRadio");
			for(var i=0;i<checkedValues.length;i++){
				if(checkedValues[i].checked){
					planCode=checkedValues[i].value;
					flag++;
				}
			}
			if(flag==0){
				alert("请选择一项！");
				return null;
			}
			var param={
				"lcContPlanReport.id.repNo":repNo,
				"lcContPlanReport.id.contPlanCode":planCode
			};
			function deleteConPlanCallBack(obj){
				$("#"+obj.lcContPlanReport[0].id.contPlanCode).remove();
				alert("删除成功！");
			}
			jQuery.post(url,param,deleteConPlanCallBack,"json");
		}
		//保障计划的更新
		//于文龙
		function updateConPlan(){
			$.ajax({
				type : "POST",
				url : contextRootPath + "/prpall/updateConPlan.do",
				data : $("#planForm").serialize(),
				dataType :"json",
				success : function(obj){
					alert("更新成功！");
				}
			});
		}
		
		//保障计划的保存
		function saveContPlan(){
			$.ajax({
				type : "POST",
				url : contextRootPath + "/prpall/saveContPlan.do",
				data : $("#planForm").serialize(),
				dataType :"json",
				success : function(obj){
					if(obj.msg=="success"){
						alert("信息保存成功！");
					}else{
						alert("信息保存失败！");
					}
					alert("更新成功！");
				}
			});
		}
		
		//查找计算公式
		function findCalMode(t){
			var url=contextRootPath+"/prpall/findCalMode.do";
			var riskCode=$("#mainRiskCode"+t).val();
			var dutyCode=$("#dutyCode"+t).val();
			var param={
					"lcDutyReport.id.polNo":riskCode,
					"lcDutyReport.id.dutyCode":dutyCode
			};
			function calModeCallBack(obj){
				if(obj!=null){
					$("#DutyParamInfo"+t).html(obj.msg);
				}
			}
			jQuery.post(url,param,calModeCallBack,"json");
		}