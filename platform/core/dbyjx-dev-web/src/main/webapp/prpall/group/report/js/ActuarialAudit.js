//根据 呈报号查询呈报审核意见 路径的变量
//var findReportIdea=ctx + "/prpall/findReportIdea.do?lcReport.repNo=";
//查询呈报审核信息
function findActuarialReport111(){
	var findUrl=ctx + "/prpall/findActuarialReport.do";
	var findParams ={
		"lcReport.repNo":$("#repNo").val(),
		"lcReport.repOperator":$("#repOperator").val(),
		"lcReport.manageCom":$("#comCode").val(),
		"lcReport.repApplyDate":$("#repApplyDate").val(),
		"lcReport.name":$("#name1").val()
	};
	//返回查询结果信息
	function findActuarialCallBack(obj){
		$("#content").html("");
		var contentString="";
		var xuhao = 1 ;
		for(var i = 0 ; i < obj.data.length; i++){
			contentString += "<tr class='content' name='aa'>";
			var date = new Date();
			date.setTime(obj.data[i].repApplyDate.time);
			var dateStr = date.getUTCFullYear()+"-"+(date.getUTCMonth()+1)+"-"+(date.getUTCDate()+1);
			contentString += "<td ><input name='radioRepNo' type='radio' value="+obj.data[i].repNo+" />"+
			"<td>"+xuhao+"</td>"+
			"<td><a href='"+findReportIdea+obj.data[i].repNo +"'>"+obj.data[i].repNo+"</a></td>"+
			"<td>"+obj.data[i].repOperator+"</td>"+
			"<td>"+obj.data[i].manageCom+"</td>"+
			"<td>"+dateStr+"</td>"+
			"<td>"+obj.data[i].grpName+"</td>";
			xuhao++;
			contentString +="</tr>";
		}
		$("#content").html(contentString);
	}
	jQuery.post(findUrl,findParams,findActuarialCallBack,'json');
}
//初始化呈报日期＝系统当前日期
$(function(){
	var date=new Date();
	$("#repApplyDate").val(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate());
});

/**********************************************************/
/******************** 以上方法弃用 *************************/
/**********************************************************/
// 查询待精算审核任务
function findActuarialReport(){
	var url= contextRootPath + "/prpall/findActuarialReport.do";
	$("#fmActuarialAuditFind").attr("action",url);
	$("#fmActuarialAuditFind").attr("target","fraInterface");
	$("#fmActuarialAuditFind").submit();	
}




