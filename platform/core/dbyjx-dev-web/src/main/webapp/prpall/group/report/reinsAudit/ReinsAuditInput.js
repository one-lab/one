
//保存再保审核中审核后的审核意见和核保结论
var ctx = "${ctx}";
function saveAuditResultAndIdea(){
	var findUrl=ctx + "/prpall/saveAuditResultAndIdea.do";
	var findParams ={
		"lcReinsAudit.id.repNo":$("#reinsAuditrepNo").val(),
		"lcReinsAudit.repAuditIdea":$("#repAuditIdea").val()
	};
//查询再保审核信息回调函数
	function saveAuditResultAndIdeaCallBack(obj){
		$("#contentReinsAuditList").html("");
		var contentString="";
		var xuhao = 1 ;
		for(var i = 0 ; i < obj.data.length; i++){
			contentString += "<tr class='content' name='aa'>";
			var date = new Date();
			date.setTime(obj.data[i].modifyDate.time);
			var dateStr = date.getUTCFullYear()+"-"+(date.getUTCMonth()+1)+"-"+(date.getUTCDate()+1) + "    " + obj.data[i].modifyTime;
			contentString += "<td>"+xuhao+"</td>"+
			"<td>"+obj.data[i].repAuditOperator+"</td>"+
			"<td>"+obj.data[i].repAuditIdea+"</td>"+
			"<td>"+dateStr+"</td>";
			xuhao++;
			contentString +="</tr>";
		}
		$("#contentReinsAuditList").html(contentString);
		alert("审核成功！");
		$("#saveAuditIdea").attr("disabled",true);
		$("#repAuditIdea").attr("readOnly",true);
	}
	jQuery.post(findUrl,findParams,saveAuditResultAndIdeaCallBack,'json');
}