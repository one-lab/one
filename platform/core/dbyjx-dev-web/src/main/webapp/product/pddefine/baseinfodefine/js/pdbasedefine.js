//增加一个新的险种，并且检查该险种是否已存在
function addRiskCode(){
	if(null==$("#riskCode").val()||$("#riskCode").val()==""){
		alert("请输入待申请的产品险种代码！");
		return false;
	}
	//url,params,callback
	var url = ctx + "/product/checkRiskExist";
	var params ={
		"pdLMRisk.riskCode":$("#riskCode").val(),
		"pdLMRisk.makeDate":$("#makeDate").val()
	};
	jQuery.post(url,params,callbackRiskExist);
}

//检查是否已存在该险种 存在--Y 不存在--N
function callbackRiskExist(obj){
	if(obj == "Y"){
		alert("申请的险种编码【"+$("#riskCode").val()+"】已存在!");
		return false;
	}
}

//查询定义中的产品信息
function queryApplingRisk(){
	var url=ctx + "/product/queryApplingRisk";
	$("#frmInput").attr("action",url);
	$("#frmInput").attr("target","fraInterface");
	$("#frmInput").submit();	
}
 
//处理定义中的险种信息
function queryModifyApplingRisk(){
    //判断产品是否存并是否已选择定义中的产品
	if(null==$('input:radio[name="selectApplingRadio"]:checked').val()
	  ||undefined==$('input:radio[name="selectApplingRadio"]:checked').val()){
		alert("请先选择一个需要定义的产品！");
		return false;
	}
	var riskCode = $('input:radio[name="selectApplingRadio"]:checked').val();

	//进入定义中产品的修改页面
	//var fm  = document.getElementById('queryApplingRiskForm');
	var url=ctx + "/product/queryModifyApplingRisk";
	$("#riskCode").val(riskCode);
	$("#frmInput").attr("action",url);
	$("#frmInput").attr("target","fraInterface");
	$("#frmInput").submit();
}



