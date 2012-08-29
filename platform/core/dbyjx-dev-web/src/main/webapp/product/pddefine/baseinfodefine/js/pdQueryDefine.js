/**
 * 通过form查询的险种
 */
function findRisk(){		
	$.ajax({
		url: $("#frmInput").attr("action"), 
		data : $("#frmInput").serialize(),
		type : $("#frmInput").attr("method"),
		dataType : "json",
		success: function(obj){
			showResult(obj);
      }});
}
function showResult(obj){
	var resultString = "";
	for(var i = 0 ; i < obj.data.length ; i++){
		resultString += "<tr class='content'>"+
			"<td><input type='radio' name='selectApplingRadio' value="+obj.data[i].riskCode+" /></td>"+
			"<td>"+(i+1)+"</td>"+
			"<td>"+obj.data[i].riskCode+"</td>"+
			"<td>"+obj.data[i].riskShortName+"</td>"+
			"<td>"+obj.data[i].makeDate+"</td>"+
			"<td>"+obj.data[i].operator+"</td>"+
			"</tr>";
	}
	$("#totalCount").val(obj.totalRecords);
	$("#totalPage").val(Math.ceil(obj.totalRecords/$("#pageSize").val()));
	$("#pageNo").val();
	$("#pageSize").val();
	$("#ApplingRiskDetail").html(resultString);
}

//增加一个新的险种，并且检查该险种是否已存在
function addRiskCode(){
	if(null==$("#riskCode").val()||$("#riskCode").val()==""){
		alert("请输入待申请的产品险种代码！");
		return false;
	}
	if(null==$("#makeDate").val()||$("#makeDate").val()==""){
		alert("请输入待申请产品的时间！");
		return false;
	}
	//url,params,callback
	var url = contextRootPath + "/product/checkRiskExist.do";
	var params ={
		"pdLMRisk.riskCode":$("#riskCode").val(),
		"pdLMRisk.makeDate":$("#makeDate").val()
	};
//检查是否已存在该险种 存在--Y 不存在--N
	function callbackRiskExist(obj){
		if(obj == "Y"){
			alert("申请的险种编码已存在!");
			return false;
		}
		if(obj == "N"){
			var registerUrl = contextRootPath + "/product/queryModifyApplingRisk.do";
			$("#frmInput").attr("action",registerUrl);
			$("#frmInput").attr("target","fraInterface");
			$("#frmInput").submit();
		}
	}
	jQuery.post(url,params,callbackRiskExist);
}

//处理定义中的险种信息
function modifyApplinyRisk(){
    //判断产品是否存并是否已选择定义中的产品
	if(null==$('input:radio[name="selectApplingRadio"]:checked').val()
	  ||undefined==$('input:radio[name="selectApplingRadio"]:checked').val()){
		alert("请先选择定义中的产品！");
		return false;
	}
	var riskCode = $('input:radio[name="selectApplingRadio"]:checked').val();

	//进入定义中产品的修改页面
	//var fm  = document.getElementById('queryApplingRiskForm');
	var url=contextRootPath + "/product/queryModifyApplingRisk.do?pdLMRisk.riskCode="+riskCode;
	$("#fm").attr("action",url);
	$("#fm").attr("method","get");
	$("#fm").attr("target","fraInterface");
	$("#fm").submit();
}