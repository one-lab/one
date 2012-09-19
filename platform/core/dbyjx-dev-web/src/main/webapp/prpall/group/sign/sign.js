//查询待签单的投报单
function findProposalSignInfo(){
	var url = contextRootPath + "/prpall/findProposalSignInfo.do";
    $("#fm").attr("action",url);
	$("#fm").submit();
}
//签单功能
function saveSignInfo(){
	if(null==$('input:radio[name="lcGrpCont.proposalGrpContNo"]:checked').val() ||undefined==$('input:radio[name="lcGrpCont.proposalGrpContNo"]:checked').val()){  
		alert("请选择一条投保单记录！"); 
		return false; 
	}
	//var proposalGrpContNo=$('input:radio[name="lcGrpCont.proposalGrpContNo"]:checked').val(); 
	
    var url = ctx + "/prpall/saveSignInfo.do";
	$("#fm").attr("action",url);
    $("#fm").submit();	
}