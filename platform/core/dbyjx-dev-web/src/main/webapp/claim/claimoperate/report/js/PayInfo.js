//根据报案号和客户号查询以发起的调查（发起调查）
function findLLInqApplyByRptNoInsuredNo(){
	var url = contextRootPath + '/claim/findLLInqApplyByRptNoInsuredNo.do';
	$("#claimReportInfo").attr("action" , url);
	$("#claimReportInfo").submit();
}
//根据报案号和客户号查询以发起的调查（查看调查）
function findLLInqApplyByRptNoInsuredNoTwo(){
	var url = contextRootPath + '/claim/findLLInqApplyByRptNoInsuredNoTwo.do';
	$("#claimReportInfo").attr("action" , url);
	$("#claimReportInfo").submit();
}
//根据报案号和客户号查询以发起的调查（取消调查）
function findLLInqApplyByRptNoInsuredNoThree(){
	var url = contextRootPath + '/claim/findLLInqApplyByRptNoInsuredNoThree.do';
	$("#claimReportInfo").attr("action" , url);
	$("#claimReportInfo").submit();
}
//跳转至呈报申请页面，将出险人信息显示在页面
function reportApply(){
	var url = contextRootPath + '/claim/claimoperate/report/ReportApply.jsp';
	$("#claimReportInfo").attr("action", url);
	$("#claimReportInfo").submit();
}