//发起呈报申请
function submitApply(){
	$.ajax({
		type : "post",
		url : contextRootPath + "/claim/submitApply.do",
		data : $("#submitApplyFm").serialize(),
		dataType :"json",
		success : function(obj){
			alert("数据提交成功");
		}
	});
}