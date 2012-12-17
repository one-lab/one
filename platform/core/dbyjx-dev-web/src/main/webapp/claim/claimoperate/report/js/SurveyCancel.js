//取消调查
function cancelSurvey(){
	if(null==$('input:radio[name="radio"]:checked').val()
			   ||undefined==$('input:radio[name="radio"]:checked').val()){
			   alert("请选择一条呈报申请记录进行删除!");
			   return false;
			}
	var cioStr = $('input:radio[name="radio"]:checked').val();
	var a = $("#inqCancel").val().length;
	if(a > 500){
		alert("取消调查原因不能超过500!");
		return ;
	}
	var url = contextRootPath + "/claim/cancelSurvey.do";
	param = {
			"cioStr" : cioStr,
			"llInqApply.inqCancel" : $("#inqCancel").val()
	};
	function callBack(obj){
		if(obj == "No"){
			alert("非发起调查本人不能取消调查或该调查已回复或已被取消!");
		}else if(obj == "Yes") {
			alert("数据提交成功!");
		}
	}
	jQuery.post(url, param, callBack);
}