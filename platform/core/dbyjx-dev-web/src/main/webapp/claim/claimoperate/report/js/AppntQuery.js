//查询出险信息
function queryLCInsuredByCondition(){
			var url =contextRootPath + "/claim/findLCInsuredByCondition.do";
			$("#appntQueryFm").attr("action", url);
			$("#appntQueryFm").submit();
}
//按合同号和客户号查一条并将出险人信息显示在页面
function findLCInsuredByContNoInsuredNo(){
	if(null==$('input:radio[name="radio"]:checked').val()
			   ||undefined==$('input:radio[name="radio"]:checked').val()){
			   alert("请选择一条数据并返回！");
			   return false;
			}
	val = $('input:radio[name="radio"]:checked').val();
	var url = contextRootPath + "/claim/findLCInsuredByContNoInsuredNo.do";
	var param = {
		"ciStr" : val
	};
	function callBack(obj){
		if(obj != null){
			var parentWindow = window.parent.dialogArguments;
			if(null != obj.lcInsuredList[0].birthday){
				var a = parseInt(new Date(obj.lcInsuredList[0].birthday.time).format('yyyy'));
				var b = parseInt(new Date().format('yyyy'));
				parentWindow.document.getElementById("customerAge").value = (b-a);
				parentWindow.document.getElementById("custBirthday").value = new Date(obj.lcInsuredList[0].birthday.time).format('yyyy-MM-dd');
			}
			parentWindow.document.getElementById("customerName").value = obj.lcInsuredList[0].name;
			parentWindow.document.getElementById("sex").value = obj.lcInsuredList[0].sex;
			parentWindow.document.getElementById("customerNo").value = obj.lcInsuredList[0].id.insuredNo;
			parentWindow.document.getElementById("idType").value = obj.lcInsuredList[0].idType;
			parentWindow.document.getElementById("idNo").value = obj.lcInsuredList[0].idNo;
			window.parent.close();
		}
	}
	jQuery.post(url,param,callBack,"json");
}