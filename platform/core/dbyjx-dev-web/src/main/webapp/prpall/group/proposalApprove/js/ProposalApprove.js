//审核完毕
//于文龙
function finishAudit(){
	var grpContNo=$("#GrpContNo").val();
	var finishUrl=contextRootPath+"/prpall/finishAudit.do";
	var param={
		"lcGrpCont.grpContNo":grpContNo
	};
	function finishCallBack(obj){
		if(obj.message=="success"){
			alert("复核成功");
		}else{
			alert("复核失败");
		}
	}
	jQuery.post(finishUrl,param,finishCallBack,"json");
}

//个人已承保保单查询
function findLcContAndInsured(){
	var grpContNo=$("#GrpContNo").val();
	window.location=contextRootPath+'/prpall/findLcContAndInsured.do?lcGrpCont.grpContNo='+grpContNo;
}

//问题件查询

function findGrpIssue(){
	var findGrpIssueFileUrl = contextRootPath + "/prpall/findGrpIssue.do";
	var grpContNo = $("#GrpContNo").val();
	window.location.href = findGrpIssueFileUrl + "?lcIssue.id.grpContNo=" + grpContNo;
}
//问题件录入
function issueInput(){
	var grpContNo=$("#GrpContNo").val();
	var url=contextRootPath+'/prpall/issueInput.do?lcGrpCont.grpContNo=' + grpContNo;	
	$("#fm").attr("action",findUrl);
	$("#fm").attr("target","fraInterface");
	$("#fm").attr("method","post");
	$("#fm").submit();
}
