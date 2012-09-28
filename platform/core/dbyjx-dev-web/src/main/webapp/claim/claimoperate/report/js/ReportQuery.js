//报案信息的查询
//张凯
function findClaimReport() {
	var findUrl = contextRootPath + "/claim/findClaimReport.do";
	$("#frmReportQuery").attr("action",findUrl);
	$("#frmReportQuery").attr("target","fraInterface");
	$("#frmReportQuery").submit();
}

//信息录入
//张凯
function findReportInfo(){
	//根据 报案号 查询报案出险详细信息
	var rptNo = "";
	if(null == $('input:radio[name="radioRptNo"]:checked').val()
		   || undefined == $('input:radio[name="radioRptNo"]:checked').val()){
		   alert("请选择一条报案信息进行信息录入！");
		   return false;
		}
	rptNo = $('input:radio[name="radioRptNo"]:checked').val();
	
	location.href = contextRootPath + "/claim/findReportInfo.do?llReport.rptNo="+ rptNo;
}