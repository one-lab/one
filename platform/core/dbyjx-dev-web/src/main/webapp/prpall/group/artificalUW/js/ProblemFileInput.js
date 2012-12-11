
//问题件保存
function saveIssueFile(){
	var saveIssueFileUrl = ctx + "/prpall/saveIssueFile.do";
	var findParams = {
			"lcGrpCont.grpContNo":$("#grpContNo").val(),
			"lcIssue.operatePos":$("#operatePos").val(),
			"lcIssue.backObjType":$("#backObjType").val(),
			"lcIssue.issueType":$("#issueType").val(),
			"lcIssue.issueCont":$("#issueCont").val()
	};
	
	function saveIssueFileCallBack(Obj){
		$("#backObjType").attr("readOnly",true);
		$("#backObjTypeName").attr("readOnly",true);
		$("#issueType").attr("readOnly",true);
		$("#issueTypeName").attr("readOnly",true);
		$("#issueCont").attr("readOnly",true);
		$("#saveIssueButton").attr("disabled",true);
		alert("问题件录入成功！");
	}
	
	jQuery.post(saveIssueFileUrl,findParams,saveIssueFileCallBack,"json");
}