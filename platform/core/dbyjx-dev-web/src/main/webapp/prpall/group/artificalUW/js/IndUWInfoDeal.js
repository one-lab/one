//保存人工核保中对个人投保单的审核意见和核保结论
	function saveArtificalUWPersonResultAndIdea(){
		var saveArtificalUWPersonResultAndIdeaUrl = ctx + "/prpall/saveArtificalUWPersonResultAndIdea.do";
		var findParams ={
			"lcCont.contNo":$("#contNo").val(),
			"lcCont.uwFlag":$("#artificalPersonResultCode").val(),
			"lcCont.remark":$("#artificalPersonIdea").val()
			
		};
	//保存人工核保中对个人投保单的审核意见和核保结论后的回调函数
		function saveArtificalUWPersonResultAndIdeaCallBack(obj){
			$("#artificalPersonResultCode").attr("readOnly",true);
			$("#artificalPersonResultContext").attr("readOnly",true);
			$("#artificalPersonIdea").attr("readOnly",true);
			$("#artificalPersonSubmit").attr("disabled",true);
			alert("个人投保单确认成功!");
			
		}
		jQuery.post(saveArtificalUWPersonResultAndIdeaUrl,findParams,saveArtificalUWPersonResultAndIdeaCallBack,'json');
	}

	
//契调信息录入
	function searchInfoInput(){
		var contNo = $("#contNo").val();
		var findUrl = contextRootPath + "/prpall/findSingleSearchInfoInput.do?lcCont.contNo=" + contNo;
		$("#fmSearchInfo").attr("action",findUrl).submit();
	}