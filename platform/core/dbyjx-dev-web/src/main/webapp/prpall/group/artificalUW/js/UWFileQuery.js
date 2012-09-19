//自动核保功能
function autoUWInfo() {
	var autoUWInfoUrl = ctx + "/prpall/autoUWInfoQuery.do";
	var grpContNo = $("#grpContNo").val();
	window.location.href = autoUWInfoUrl + "?lcGrpCont.grpContNo=" + grpContNo;
}

//问题件录入
function issueInput(){
	var issueInputUrl = contextRootPath + "/prpall/group/artificalUW/ProblemFileInput.jsp";
	var grpContNo = $("#grpContNo").val();
	var operatePos = $("#inputLocation").val();
	window.location.href = issueInputUrl + "?grpContNo=" + grpContNo + "&operatePos=" + operatePos;
}


//团体问题件查询
function findGrpIssueFile(){
	var findGrpIssueFileUrl = ctx + "/prpall/findGrpIssue.do";
	var grpContNo = $("#grpContNo").val();
	var operatePos = $("#inputLocation").val();
	window.location.href = findGrpIssueFileUrl + "?lcIssue.id.grpContNo=" + grpContNo + "&lcIssue.operatePos=" + operatePos;
}

//个人核保信息处理
function PersonProposalInfoProcess(){
	var personProposalInfoProcessUrl = contextRootPath + "/prpall/group/artificalUW/InsuredSelect.jsp";
	var grpContNo = $("#grpContNo").val();
	window.location.href = personProposalInfoProcessUrl + "?grpContNo=" + grpContNo;
}

//团体契调结论查询
function findGrpSearchInfoQuery(){
	var findGrpSearchInfoUrl = contextRootPath + "/prpall/findGrpSearchInfoQuery.do?lcGrpCont.grpContNo=" + $("#grpContNo").val();
	window.location.href = findGrpSearchInfoUrl;
}