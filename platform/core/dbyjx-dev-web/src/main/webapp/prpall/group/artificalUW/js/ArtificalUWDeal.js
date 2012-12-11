//保存人工核保中对集体投保单的审核意见和核保结论
	function saveArtificalUWResultAndIdea(){
		var saveArtificalUWResultAndIdeaUrl = ctx + "/prpall/saveArtificalUWResultAndIdea.do";
		var saveUWResultAndIdeaParams = {
				"lcGrpCont.grpContNo":$("#grpContNo").val(),
				"lcGrpCont.remark":$("#artificalIdea").val(),
				"lcGrpCont.uwFlag":$("#artificalResultCode").val()
		};
		function saveArtificalUWResultAndIdeaCallBack(obj){
			if(obj.msg == "success"){
				alert("人工核保完成！");
				window.location.href = contextRootPath + "/prpall/group/artificalUW/ArtificalUWApply.jsp";
			}else{
				alert("人工核保失败！");
			}
			
		}
		jQuery.post(saveArtificalUWResultAndIdeaUrl,saveUWResultAndIdeaParams,saveArtificalUWResultAndIdeaCallBack,'json');
	}
	
//
$(function(){
	$("#UWFileQueryButton").css("display","none");
	}
);
