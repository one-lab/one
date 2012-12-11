
//问题件查看内容和回复
//function viewContentAndReply(){
//	if(null==$('input:radio[name="lcIssueRadio"]:checked').val()
//			   ||undefined==$('input:radio[name="lcIssueRadio"]:checked').val()){
//			   alert("请选择一条记录进行查看！");
//			   return false;
//			}
//	var  serialNo=$('input:radio[name="lcIssueRadio"]:checked').val();
//	var grpContNo=$("#grpContNo").val();
//	var url=contextRootPath+"/prpall/viewContentAndReply.do?lcIssue.id.serialNo="+serialNo+"&&lcIssue.id.grpContNo="+grpContNo;
//	$("#issueForm").attr("action",url);
//	$("#issueForm").attr("target","fraInterface");
//	$("#issueForm").submit();
//}


//问题件查看内容和回复
function viewContentAndReply(){
	var url=contextRootPath+"/prpall/viewContentAndReply.do?";
	if(null==$('input:radio[name="lcIssueRadio"]:checked').val()
			   ||undefined==$('input:radio[name="lcIssueRadio"]:checked').val()){
			   alert("请选择一条记录进行查看！");
			   return false;
			}
	var params = {
			"lcIssue.id.serialNo":$('input:radio[name="lcIssueRadio"]:checked').val(),
			"lcIssue.id.grpContNo":$("#grpContNo").val()
	};
	
	function viewContentAndReplyCallBack(obj){
		$("#issueContent").val(obj.data[0].issueCont);
		$("#issueApply").val(obj.data[0].replyResult);
	}
	jQuery.post(url,params,viewContentAndReplyCallBack,'json');
}
