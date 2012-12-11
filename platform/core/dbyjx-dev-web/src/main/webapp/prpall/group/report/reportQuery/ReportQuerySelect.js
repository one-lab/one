//呈报结果查询
function selectReportResult(){
	var actionUrl = ctx + "/prpall/findReportResult.do";
	var actionParams = {
			"lcReport.repNo":$("#repNo").val(),
			"lcReport.manageCom":$("#comCode").val(),
			"lcReport.repApplyDate":$("#applyDate").val(),
			"lcReport.name":$("#grpName").val()
		};
	
	function CallBack(obj){
		$("#content").html("");
		var contentString="";
		var xuhao = 1 ;
		for(var i = 0 ; i < obj.data.length; i++){
			if(null==obj.data[i].result){
				obj.data[i].result="";
			}
			if(null==obj.data[i].state){
				obj.data[i].state="";
			}
			contentString += "<tr class='content' name='aa'>";
			var date = new Date();
			date.setTime(obj.data[i].repApplyDate.time);
			var dateStr = date.getUTCFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getUTCDate()+1);
			contentString += "<td ><input name='radioRepNo' type='radio' value="+obj.data[i].repNo+" />"+
			"<td>"+xuhao+"</td>"+
			"<td>"+obj.data[i].repNo+"</td>"+
			"<td>"+obj.data[i].manageCom+"</td>"+
			"<td>"+obj.data[i].name+"</td>"+
			"<td>"+obj.data[i].repOperator+"</td>"+
			"<td>"+obj.data[i].repauditoperator+"</td>"+
			"<td>"+obj.data[i].result+"</td>"+
			"<td>"+obj.data[i].state+"</td>"+
			"<td>"+dateStr+"</td>";
			xuhao++;
			contentString +="</tr>";
		}
		$("#content").html(contentString);
	}
	
	jQuery.post(actionUrl,actionParams,CallBack, "json");
}


