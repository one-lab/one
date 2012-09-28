//查询将要进行核保订正的投保单记录
function findUWResultModify(){
	findUrl = contextRootPath + "/prpall/findUWResultModify.do";
	$("#fmUWResultModify").attr("action",findUrl).submit();
}

//进行核保订正
function uwResultModify(){
	uwModifyUrl = contextRootPath + "/prpall/uwResultModify.do";
	//判断是否选中一条呈报申请记录
	if(null==$('input:radio[name="radioGrpContNo"]:checked').val()
	   ||undefined==$('input:radio[name="radioGrpContNo"]:checked').val()){
	   alert("请选择一条核保订正记录进行订正！");
	   return false;
	}
	var uwModifyParams = {
			"lcGrpCont.grpContNo":$('input:radio[name="radioGrpContNo"]:checked').val()
	};
	function uwResultModifyCallBack(obj){
		if(obj.msg == "success"){
			alert("投保单核保订正成功！");
			window.location.href = contextRootPath + "/prpall/group/artificalUW/ArtificalUWApply.jsp";
		}else{
			alert("投保单核保订正出现错误！");
		}
		
	}
	jQuery.post(uwModifyUrl,uwModifyParams,uwResultModifyCallBack,'json');
}

//判断是否查询到数据
function isEmpty(){
	var flag = $("#flag").val();
	if(undefined != $("#flag").val()){
		if(flag == "true"){
			alert("没有任何记录可以显示！");
		}
	}
}



