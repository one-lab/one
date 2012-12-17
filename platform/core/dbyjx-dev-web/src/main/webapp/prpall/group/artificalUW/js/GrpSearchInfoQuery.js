//查询个人契调项目列表
function findSingleSearchItemList(){
	var findSingleSearchItemListUrl = contextRootPath + "/prpall/findGrpSearchItemList.do";
	findParams = {
		"lcCont.grpContNo":$("#grpContNo").val(),
		"lcCont.contNo":$('input:radio[name="lcContRadio"]:checked').val()	
	};
	//查询个人契调项目列表回调函数
	function findSingleSearchItemListCallBack(obj){
		$("#searchItemContent").html("");
		var contentString="";
		var index = 1;
		for(var i = 0 ; i < obj.data.length; i++){
			contentString += "<tr class='content'>";
			contentString += "<td>"+index+"</td>"+
			"<td>"+obj.data[i].itemNo+"</td>"+
			"<td>"+obj.data[i].itemName+"</td>"+
			"<td>"+obj.data[i].standbyFlag3+"</td>";
			index++;
			contentString +="</tr>";
		}
		$("#searchItemContent").html(contentString);
	}
	jQuery.post(findSingleSearchItemListUrl,findParams,findSingleSearchItemListCallBack,'json');
	
}