//根据条件查询问题件
function queryIsSueByCon(){
	var url =contextRootPath + "/product/queryIsSueByCon";
	var params ={
		"pdIsSue.riskCode":$("#pdIsSue_riskCode").val(),
		"pdIsSue.backPost":$("#backPost").val(),
		"pdIsSue.issueCont":$("#issueCont").val(),
		"pdIsSue.issueState":$("#issueState").val()
	};
	//将查询出的问题件显示在页面
	function CallBackNotepad(obj){
		var issueContentString;
		var json = obj.data;
		for(var i=0;i<json.length;i++){
			//TODO 朱超:需要进行判断根据后面的汉字内容
			issueContentString +="<tr>"+
				  "<td><input name='' type='radio' value='' /></td><td>1</td>"+
				  "<td>"+(json[i].backPost=="01"?"承包处理":(json[i].backPost=="02"?"保全处理":(json[i].backPost=="03"?"理赔处理":"")))+"</td>"+
				  "<td>"+(json[i].replyMan==null?"":json[i].replyMan)+"</td>"+
				  "<td>"+json[i].issueCont+"</td>"+
				  "<td>"+(json[i].issueState=="1"?"处理完毕":(json[i].issueState=="2"?"处理中":(json[i].issueState=="3"?"未处理":"")))+"</td></tr>";
		}
		$("#issueContent").html(issueContentString);
	}
	jQuery.post(url,params,CallBackNotepad, "json");
}