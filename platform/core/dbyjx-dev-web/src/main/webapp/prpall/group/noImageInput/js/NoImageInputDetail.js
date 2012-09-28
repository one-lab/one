//保存集体保单信息，呈报团体客户信息，呈报团单投保人信息，投保告知单信息
function saveGrpBaseInfo(){
	$.ajax({
		type : "POST",
		url : contextRootPath + "/prpall/saveGrpBaseInfo.do",
		data : $("#lcGrpGroupForm").serialize(),
		dataType :"json",
		success : function(obj){
			if($("#saveGrpBaseInfoId").val()=="保存"){
				alert("保存成功！");
			}
			if($("#saveGrpBaseInfoId").val()=="修改"){
				alert("修改成功！");
			}
			$("#saveGrpBaseInfoId").attr("disabled",true);
		}
	});
}
//告知单增加按钮
function addPremInfo(){
	var $table_tr=$("#PremInfoBody tr");
	var len=$table_tr.length;
	var content="<tr class='content' id='prem"+(len+1)+"'>";
	content+="<td>"+(len+1)+"</td>"
	+"<td><input id='ver"+(len+1)+"' type='text' name='lcGrpContGroupVo.lcRepInfoList["+(len)+"].id.impartVer' maxlength='5' size='5'/><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"
	+"<td><input id='code"+(len+1)+"' type='text' name='lcGrpContGroupVo.lcRepInfoList["+(len)+"].id.impartCode' maxlength='4' size='4'/><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"
	+"<td><input id='detail"+(len+1)+"' type='text' name='lcGrpContGroupVo.lcRepInfoList["+(len)+"].impartDetailContent'   size='50' /><img src='"+ctx+"/images/bgMarkMustInput.jpg'></td>"
	+"<td><input id='mes"+(len+1)+"' type='text' name='lcGrpContGroupVo.lcRepInfoList["+(len)+"].message' size='50'/></td>"
	+"<td><input type='button' value='-' onclick=removePremInfo('prem"+(len+1)+"') /></td>";
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
$(function(){
	//获得客户号
	var customerNoTemp=$("#customerNoHidden").val();
	if(customerNoTemp!=""&&customerNoTemp!=null){
		//有客户号，设置查询按钮不为用
		$("#selectInfoByCustomerNo").attr("disabled",true);
		//如果有客户号：保存按钮变为修改按钮
		$("#saveGrpBaseInfoId").attr("value","修改");
	}else{
		$("#selectInfoByCustomerNo").attr("disabled",false);
		$("#saveGrpBaseInfoId").attr("value","保存");
	}
	//跳到ClientQuery.jsp页面
	$("#selectInfoByCustomerNo").bind("click",function(){
		lcGrpContGroupVo=$("#lcGrpContGroupVo").val();
		$("#lcGrpGroupForm").attr("action",ctx +"/prpall/findClertPage.do");
		$("#lcGrpGroupForm").submit();
		});
}); 
//判断是否是附加险，是：判断该附加险的主险是否增加；是：同时显示相适主险编码。否：给出提示。
//              否：直接增加。
function findSubRiskIsOr(){
	
	$.ajax({
		type : "POST",
		url : ctx + "/prpall/findSubRiskIsOr.do",
		data :{"lcGrpPol.riskCode":$("#riskCode").val(),"lcGrpCont.grpContNo":$("#grpContNo").val()},
		dataType :"json",
		success : function(returnStrFlag){
			if(returnStrFlag.msg=="YY"){//是附加险
				//显示对应主险
				$("#mainRiskNameTD").css("display", "");
				$("#mainRiskValueTD").css("display", "");
			}
			if(returnStrFlag.msg=="YN"){//是附加险,但没有先添加该附加险的主险
				alert("该险种主险信息未录入，故不能进行该险种信息录入！");
			}
			if(returnStrFlag.msg=="N"){//是主险
				$("#mainRiskNameTD").css("display", "none");
				$("#mainRiskValueTD").css("display", "none");
			}
		}
	});
}
//保存集体险种信息
function saveGrpRiskInfo(){
	//检查险种名称是否选择
	if(null==$("#riskCode").val()||$("#riskCode").val()==""){
		alert("请选择[险种编码]！");
		$("#riskCode").focus();
		return false;
	}
	
	
	//检查是否录入险种费用率
	if(null==$("#floatRate").val()||$("#floatRate").val()==""){
		alert("请录入[险种费用率]！");
		$("#floatRate").focus();
		return false;
	}
	var flag=false;//不重复标记
	//检查险种名称是否存在
	$(".checkRiskCode").each(function(){
			if($(this).val()==$("#riskCode").val()){
				alert("险种编码["+$("#riskCode").val()+"]已经存在！");
				$("#riskCode").focus();
				flag=true;
			}
	});
	if(flag){
		return false;
	}else{
	//TODO xu_xinling 这里的return false;必须要加上，不知道为什么，否则会一直往下执行。上一个的return好像没有执行。？？
	saveGrpRiskInfo1();	
	}
}

function saveGrpRiskInfo1(){	
	//保存险种信息
	$.ajax({
		type : "POST",
		url : ctx + "/prpall/saveGrpRiskInfo.do",
		data : $("#lcGrpGroupForm").serialize(),
		dataType :"json",
		success : function(obj){
			alert("保存成功！");
			$("#lcGrpProInfo").html("");
			var contentString="";
			var xuhao = 1 ;
			for(var i = 0 ; i < obj.data.length; i++){
				contentString += "<tr class='content' name='aa'>";
				contentString +=  "<td ><input name='riskRadio' type='radio' value="+obj.data[i].grpPolNo+" /></td>"+
				"<td>"+xuhao+"</td>"+
				//saveFlag:判断险种信息是否已经保存过。1保存过。
				"<td><input type='hidden' name='saveFlag' value='1'/> <input style='border:none' readonly='readonly' class='checkRiskCode' value="+obj.data[i].riskCode+" /></td>"+
				"<td>"+obj.data[i].riskName+"</td>"+
				"<td>"+obj.data[i].prem+"</td>"+
				"<td>"+obj.data[i].amnt+"</td>"+
				"<td>"+obj.data[i].floatRate+"</td>";
				xuhao++;
				contentString +="</tr>";
			}
			$("#lcGrpProInfo").html(contentString);
			//保存后将文本框置空
			$("#riskCode").attr("value","");
			$("#riskName").attr("value","");
			$("#floatRate").attr("value","");
			$("#mainRiskNameTD").attr("value","");
			$("#mainRiskValueTD").attr("value","");
			
		}
	});
}
	//录入完毕，修改状态
	function writeFinishByState(){
		var saveUrl=ctx +"/prpall/writeFinishByState.do";
		var findParams ={
			"lcGrpCont.grpContNo":$("#grpContNo").val()
		};
		
		//返回查询结果信息
		function findGrpContInfoCallBack(){
			alert("无影像录入完毕！");
			$("#writeFinish").attr("disabled",true);
		}
		jQuery.post(saveUrl,findParams,findGrpContInfoCallBack,'json');
	}
//删除险种
	function deleGrpRiskInfo(){
		var deleUrl=ctx+"/prpall/deleGrpRiskInfo.do";
		var grpPolNo="";
		if(null==$('input:radio[name="riskRadio"]:checked').val()
				   ||undefined==$('input:radio[name="riskRadio"]:checked').val()){
				   alert("请选择一条集体保单险种记录进行删除！");
				   return false;
				}
		grpPolNo= $('input:radio[name="riskRadio"]:checked').val();
		var param={
				"lcGrpCont.grpContNo":$("#grpContNo").val(),
				"lcGrpPol.grpPolNo":grpPolNo
		};
		function deleteRiskCallBack(obj){
			alert("删除成功！");
			$("#lcGrpProInfo").html("");
			var contentString="";
			var xuhao = 1 ;
			for(var i = 0 ; i < obj.data.length; i++){
				contentString += "<tr class='content' name='aa'>";
				contentString +=  "<td ><input name='riskRadio' type='radio' value="+obj.data[i].grpPolNo+" />"+
				"<td>"+xuhao+"</td>"+
				"<td>"+obj.data[i].riskCode+"</td>"+
				"<td>"+obj.data[i].riskName+"</td>"+
				"<td>"+obj.data[i].prem+"</td>"+
				"<td>"+obj.data[i].amnt+"</td>"+
				"<td>"+obj.data[i].floatRate+"</td>";
				xuhao++;
				contentString +="</tr>";
			}
			$("#lcGrpProInfo").html(contentString);
		}
		if(window.confirm("确定要删除吗？")){
			jQuery.post(deleUrl,param,deleteRiskCallBack,"json");
		}
		
	}



