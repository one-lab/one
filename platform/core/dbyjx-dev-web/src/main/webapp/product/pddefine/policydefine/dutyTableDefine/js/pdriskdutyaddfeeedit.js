//加载完页面就执行操作。去取表的结构，展示在页面
$(document).ready(function(){
	findRiskDutyAddFeeField();
});

function findRiskDutyAddFeeField(){
	$.ajax({
	   type: "POST",
	   url: ctx + "/product/findRiskDutyAddFeeField",
	   data : {},
	   dataType : "json",
	   success: function(data){
		   var fieldsString = $("#RiskDutyAddFeeFields").html();
		   for(var i = 0 ; i < data.length ; i++){
			   fieldsString += ' <tr class="content">'+
			   	'<td>'+ data[i].displayOrder +'</td>'+
			   	'<td>'+ data[i].fieldName +'</td>'+
			   	'<td>'+ data[i]["id.fieldCode"] +'</td>'+
			   	'<td>'+ data[i].fieldType +'</td>'+
			   	'<td> <input type="text" name="pdlmDutyPayAddFee.'+data[i]["id.fieldCode"]+'" class="common" /></td>'+
			   	'<td>'+ data[i].officialDesc +'</td>'+
			   	'<td>'+ data[i].busiDesc +'</td>'+
			   	'</tr>';
		   }
	   		$("#RiskDutyAddFeeFields").html(fieldsString);
	   }
	});
}

//增加一条加费记录
function saveDutyPayAddFee(){
	//"id.riskCode","id.dutyCode","id.addFeeType","id.addFeeObject",
	//"addFeeCalCode","addPointLimit"
	$.ajax({
	   type: "POST",
	   url: ctx + "/product/saveDutyPayAddFee",
	   data : $("#frmDutyPayAddFee").serialize(),
	   dataType : "json",
	   success: function(data){
		   var fieldsString = $("#RiskDutyAddFeeFields").html();
		   //TODO 朱超 主键解析暂时没有完成
		   for(var i = 0 ; i < data.length ; i++){
			   fieldsString += ' <tr class="content">'+
			    '<td width="5%"> <input type="radio" name="dutyPayAddFeeId" value=""/> </td>'+
			    '<td width="5%">'+(i+1)+'</td>'+
			   	'<td>'+ data[i]["id.riskCode"] +'</td>'+
			   	'<td>'+ data[i]["id.dutyCode"] +'</td>'+
			   	'<td>'+ data[i]["id.addFeeType"] +'</td>'+
			   	'<td>'+ data[i]["id.addFeeObject"] +'</td>'+
			   	'<td>'+data[i].addFeeCalCode+'</td>'+
			   	'<td>'+ data[i].addPointLimit +'</td>'+
			   	'</tr>';
		   }
	   		$("#RiskDutyAddFeeFields").html(fieldsString);
	   }
	});
}

//删除一条加费记录
function deleteDutyPayAddFee(){
	//获取单选按钮的value值
	var id = $('input:radio[name="dutyPayAddFeeId"]:checked').val();
	
	if(id == null){
		alert("请选择一条记录！");
	}else{
		var boolean = confirm("您确定删除这条记录吗？");
		if(boolean){
			$.ajax({
			   type: "POST",
			   url: ctx + "/product/deleteDutyPayAddFee",
			   data : {"id":id},
			   success: function(obj){
				   alert(obj);
			   }
			});
		}
	}
}

//更新一条加费记录
function updateDutyPayAddFee(){
	$.ajax({
	   type: "POST",
	   url: ctx + "/product/updateDutyPayAddFee",
	   data : $("#frmDutyPayAddFee").serialize(),
	   dataType : "json",
	   success: function(data){
		   var fieldsString = $("#RiskDutyAddFeeFields").html();
		   //TODO 朱超 主键解析暂时没有完成
		   for(var i = 0 ; i < data.length ; i++){
			   fieldsString += ' <tr class="content">'+
			    '<td width="5%"> <input type="radio" name="dutyPayAddFeeId" value=""/> </td>'+
			    '<td width="5%">'+(i+1)+'</td>'+
			   	'<td>'+ data[i]["id.riskCode"] +'</td>'+
			   	'<td>'+ data[i]["id.dutyCode"] +'</td>'+
			   	'<td>'+ data[i]["id.addFeeType"] +'</td>'+
			   	'<td>'+ data[i]["id.addFeeObject"] +'</td>'+
			   	'<td>'+data[i].addFeeCalCode+'</td>'+
			   	'<td>'+ data[i].addPointLimit +'</td>'+
			   	'</tr>';
		   }
	   		$("#RiskDutyAddFeeFields").html(fieldsString);
	   }
	});
}
