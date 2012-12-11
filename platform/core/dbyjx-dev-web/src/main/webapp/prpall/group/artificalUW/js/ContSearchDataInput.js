// 契调项目增加按钮

function addItemInfo(){
	var len=$("#searchItemBoby tr").length;
	var content="<tr class='content' id='prem"+(len + 1)+"'>";
	content+="<td>"+(len + 1)+"<input type='hidden' name='"+len+"'/></td>"
	+"<td><input type='text' class = 'codecode' id='itemNo" + (len + 1) + "' name='lcSingleSearchItemList["+len+"].id.itemNo' size='30'  ondblclick=\"queryCode('itemNo" + (len +1) + "','itemName" + (len + 1) + "','PDLDcode1','codeType:SearchNo')\"/></td>"
	+"<td><input type='text' class = 'context' id='itemName" + (len + 1) + "' name='"+len+"' size='30'/></td>"
	+"<td><input type='text' id='standbyFlag3"+(len + 1)+"' name='lcSingleSearchItemList["+len+"].standbyFlag3' size='40' /></td>"
	+"<td><input type='button' value='-' onclick=removeItemInfo('prem"+(len+1)+"') /></td>";
	content+="</tr>";
	$("#searchItemBoby").append(content);
}
// 契调项目删除按钮
function removeItemInfo(p){
	var len = $("#searchItemBoby tr").length;
	var index = parseInt(p.substring(4));
	if(index > len){
		return;
	}else{
		for(var temp = index;temp <= len;temp++){
			if(temp == len){
				$("#prem"+temp).remove();
			}else{
				$("#itemNo"+temp).val($("#itemNo"+(temp+1)).val());
				$("#itemName"+temp).val($("#itemName"+(temp+1)).val());
				$("#standbyFlag3"+temp).val($("#standbyFlag3"+(temp+1)).val());
			}
		}
	}
}



//保存契调信息
function saveSingleSearchInfo(){
	$.ajax({
		type:"POST",
		url:contextRootPath + "/prpall/saveSingleSearchInfo.do",
		data:$("#fmSearchDateInput").serialize(),
		dataType:"json",
		success:function(obj){
			if(obj.msg=='success'){
				$("#othermessage").attr("readOnly",true);
				$("#saveSearchInfoSubmit").attr("disabled",true);
				alert("契调信息保存成功！");
			}
		}
	});
}

