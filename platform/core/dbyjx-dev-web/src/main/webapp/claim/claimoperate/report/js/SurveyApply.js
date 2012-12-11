//发起调查申请
function saveLLInqApply(){
	var a = $("#inqItem").val().length;
	var b = $("#inqDesc").val().length;
	if(a>500){
		alert("调查内容不能超过500汉字!");
		return ;
	}
	if(b>500){
		alert("备注信息不能超过1000汉字!");
		return ;
	}
	$.ajax({
		type : "post",
		url : contextRootPath + "/claim/saveLLInqApply.do",
		data : $("#inqApplyFm").serialize(),
		dataType :"json",
		success : function(obj){
			alert("数据提交成功");
			$("#llInqApplyContent").html("");
			var llInqApplyContentStr;
			var xuhao = 1;
			for(var i=0;i<obj.inqApplyList.length;i++){
				//TODO hesiqi:双击域内容确定后修改
				llInqApplyContentStr += "<tr>"+
						"<td><input type='radio' name='redio' value=''/></td>"+
						"<td>"+(xuhao++)+"</td>"+
						"<td>"+obj.inqApplyList[i].id.clmNo+"</td>"+
						"<td>"+obj.inqApplyList[i].id.inqNo+"</td>"+
						"<td>"+(obj.inqApplyList[i].customerNo==null?"":obj.inqApplyList[i].customerNo)+"</td>"+
						"<td>"+(obj.inqApplyList[i].customerName==null?"":obj.inqApplyList[i].customerName)+"</td>"+
						"<td>"+(obj.inqApplyList[i].initDeptValue==null?"":obj.inqApplyList[i].initDeptValue)+"</td>"+
						"<td>"+(obj.inqApplyList[i].inqRCodeValue==null?"":obj.inqApplyList[i].inqRCodeValue)+"</td>"+
						"<td>"+(obj.inqApplyList[i].inqDeptName==null?"":obj.inqApplyList[i].inqDeptName)+"</td>"+
						"<td>"+(obj.inqApplyList[i].inqStateValue==null?"":obj.inqApplyList[i].inqStateValue)+"</td>"+
						"</tr>";
			}
			$("#llInqApplyContent").html(llInqApplyContentStr);
		}
	});
}