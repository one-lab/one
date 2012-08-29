//增加一个新的险种，并且检查该险种是否已存在
function addRiskCode(){
	if(null==$("#riskCode").val()||$("#riskCode").val()==""){
		alert("请输入待申请的产品险种代码！");
		return false;
	}
	//url,params,callback
	var url = contextRootPath + "/product/checkRiskExist.do";
	var params ={
		"pdLMRisk.riskCode":$("#riskCode").val(),
		"pdLMRisk.makeDate":$("#makeDate").val()
	};
	jQuery.post(url,params,callbackRiskExist);
}

//检查是否已存在该险种 存在--Y 不存在--N
function callbackRiskExist(obj){
	if(obj == "Y"){
		alert("申请的险种编码【"+$("#riskCode").val()+"】已存在!");
		return false;
	}
}


//查询定义中的产品
function queryApplingRisk(){
	var url=contextRootPath + "/product/queryApplingRisk.do";
	$("#frmInput").attr("action",url);
	$("#frmInput").attr("target","fraInterface");
	$("#frmInput").submit();	
}


//查询已有核保规则
function queryApplingUW(){
	
	$.ajax({
		type : "POST",
		url : contextRootPath + "/product/queryApplingUW.do",
		data : "",
		dataType :"json",
		success : function(obj){
			   var showContentString = "";
			   $("#HASUWdetail").html("");
			   for(var i = 0 ; i < obj.data.length ; i++){
				   showContentString += "<tr class='content'>"
				   +"<td><input type='radio' name='selectApplingRadio' value='"+obj.data[i].uwCode+"'/></td>"
				   +"<td>"+(i+1)+"</td>"
				   +"<td>"+obj.data[i].uwCode+"</td>"
				   +"<td>"+obj.data[i]["PDLMRisk.riskCode"]+"</td>"
				   +"<td>"+obj.data[i].uwOrder+"</td>"
				   +"<td>"+obj.data[i].remark+"</td>"
				   +"</tr>";
			   }
		   		$("#HASUWdetail").html(showContentString);
			
		}
	});
}
 

//新增核保规则
function insertUW(){
	$("#UWDetail").show();

	$.ajax({
		   type: "POST",
		   url: contextRootPath + "/product/pdriskUnderwrite.do",
		   data : {"uwCode":""},
		   dataType : "json",
		   success: function(obj){
			   var showContentString = "";
			   for(var i = 0 ; i < obj.data.length ; i++){
				   showContentString += "<tr class='content'>"
				   +"<td>"+obj.data[i].displayOrder+"</td>"
				   +"<td>"+obj.data[i].fieldName+"</td>"
				   +"<td>"+obj.data[i].fieldType+"</td>"
				   +"<td><input name='"+obj.data[i].fieldValueName+"' class='common' type='text' value='"+obj.data[i].fieldValue+"' /></td>";
				   if(null==obj.data[i].officialDesc){
					   showContentString  +="<td>"+""+"</td>";
				   }else{
					   showContentString  +="<td>"+obj.data[i].officialDesc+"</td>"; 
				   }
				   if(null==obj.data[i].busiDesc){
					   showContentString  +="<td>"+""+"</td>";
				   }else{
					   showContentString  +="<td>"+obj.data[i].busiDesc+"</td>"; 
				   }
				   showContentString  +="</tr>";
			   }
		   		$("#UWContent").html(showContentString);
		   }
		});
	
	
}

//修改核保规则查询
function  updateUW(){
    //判断产品是否存并是否已选择定义中的产品
	if(null==$('input:radio[name="selectApplingRadio"]:checked').val()
	  ||undefined==$('input:radio[name="selectApplingRadio"]:checked').val()){
		alert("请先选择一个需要定义的产品！");
		return false;
	}
	
	$("#UWDetail").show();

	$.ajax({
		   type: "POST",
		   url: contextRootPath + "/product/pdriskUnderwrite.do",
		   data : {"uwCode":""+$('input:radio[name="selectApplingRadio"]:checked').val()},
		   dataType : "json",
		   success: function(obj){
			   var showContentString = "";
			   $("#UWContent").html("");
			   for(var i = 0 ; i < obj.data.length ; i++){
				   showContentString += "<tr class='content'>"
				   +"<td>"+obj.data[i].displayOrder+"</td>"
				   +"<td>"+obj.data[i].fieldName+"</td>"
				   +"<td>"+obj.data[i].fieldType+"</td>"
				   +"<td><input name='"+obj.data[i].fieldValueName+"' class='common' type='text' value='"+obj.data[i].fieldValue+"' /></td>";
				   if(null==obj.data[i].officialDesc){
					   showContentString  +="<td>"+""+"</td>";
				   }else{
					   showContentString  +="<td>"+obj.data[i].officialDesc+"</td>"; 
				   }
				   if(null==obj.data[i].busiDesc){
					   showContentString  +="<td>"+""+"</td>";
				   }else{
					   showContentString  +="<td>"+obj.data[i].busiDesc+"</td>"; 
				   }
				   showContentString  +="</tr>";
			   }
		   		$("#UWContent").html(showContentString);
		   }
		});
	
}

//保存核保规则
function saveUW(){
	
	$.ajax({
		type : "POST",
		url : contextRootPath + "/product/saveLMUW.do",
		data : $("#frmInput").serialize(),
		dataType :"json",
		success : function(obj){
			if(null!=obj.msg){
			  alert("保存成功！");
			  $("#save").attr('disabled',true);
			  queryApplingUW();
		    }
		}
	});

}

//删除核保规则
function deleteUW(){
	
    //判断产品是否存并是否已选择定义中的产品
	if(null==$('input:radio[name="selectApplingRadio"]:checked').val()
	  ||undefined==$('input:radio[name="selectApplingRadio"]:checked').val()){
		alert("请先选择一个需要定义的产品！");
		return false;
	}
	
	$.ajax({
		type : "POST",
		url : contextRootPath + "/product/deleteLMUW.do",
		data : {"uwCode":""+$('input:radio[name="selectApplingRadio"]:checked').val()},
		dataType :"json",
		success : function(obj){
			if(null!=obj.msg){
			  alert(obj.msg);
			  queryApplingUW();
		    }
		}
	});

}





//查询已有投保规则
function queryApplingCF(){
	
	$.ajax({
		type : "POST",
		url : contextRootPath + "/product/queryApplingCF.do",
		data : {"riskCode":"GCMR"},
		dataType :"json",
		success : function(obj){
			   var showContentString = "";
			   $("#HASCFdetail").html("");
			   for(var i = 0 ; i < obj.data.length ; i++){
				   showContentString += "<tr class='content'>"
				   +"<td><input type='radio' name='selectApplingRadio' value='"+obj.data[i]["PDLMRisk.riskCode"]+","+obj.data[i]["id.fieldName"]+","+obj.data[i]["id.serialNO"]+"'/></td>"
				   +"<td>"+(i+1)+"</td>"
				   +"<td>"+obj.data[i]["PDLMRisk.riskCode"]+"</td>"
				   +"<td>"+obj.data[i]["id.fieldName"]+"</td>"
				   +"<td>"+obj.data[i]["id.serialNO"]+"</td>"
				   +"<td>"+obj.data[i].msg+"</td>"
				   +"</tr>";
			   }
		   		$("#HASCFdetail").html(showContentString);
			
		}
	});
}


//新增投保规则
function insertCF(){
	$("#CFDetail").show();

	$.ajax({
		   type: "POST",
		   url: contextRootPath + "/product/insertCF.do",
		   data : {},
		   dataType : "json",
		   success: function(obj){
			   var showContentString = "";
			   for(var i = 0 ; i < obj.data.length ; i++){
				   showContentString += "<tr class='content'>"
				   +"<td>"+obj.data[i].displayOrder+"</td>"
				   +"<td>"+obj.data[i].fieldName+"</td>"
				   +"<td>"+obj.data[i].fieldType+"</td>"
				   +"<td><input name='"+obj.data[i].fieldValueName+"' class='common' type='text' value='"+obj.data[i].fieldValue+"' /></td>";
				   if(null==obj.data[i].officialDesc){
					   showContentString  +="<td>"+""+"</td>";
				   }else{
					   showContentString  +="<td>"+obj.data[i].officialDesc+"</td>"; 
				   }
				   if(null==obj.data[i].busiDesc){
					   showContentString  +="<td>"+""+"</td>";
				   }else{
					   showContentString  +="<td>"+obj.data[i].busiDesc+"</td>"; 
				   }
				   showContentString  +="</tr>";
			   }
		   		$("#CFContent").html(showContentString);
		   }
		});
}



//修改投保规则查询
function  updateCF(){
  //判断产品是否存并是否已选择定义中的产品
	if(null==$('input:radio[name="selectApplingRadio"]:checked').val()
	  ||undefined==$('input:radio[name="selectApplingRadio"]:checked').val()){
		alert("请先选择一个需要定义的产品！");
		return false;
	}
	
	$("#CFDetail").show();

	$.ajax({
		   type: "POST",
		   url: contextRootPath + "/product/insertCF.do",
		   data : {"id":$('input:radio[name="selectApplingRadio"]:checked').val()},
		   dataType : "json",
		   success: function(obj){
			   var showContentString = "";
			   $("#CFContent").html("");
			   for(var i = 0 ; i < obj.data.length ; i++){
				   showContentString += "<tr class='content'>"
				   +"<td>"+obj.data[i].displayOrder+"</td>"
				   +"<td>"+obj.data[i].fieldName+"</td>"
				   +"<td>"+obj.data[i].fieldType+"</td>"
				   +"<td><input name='"+obj.data[i].fieldValueName+"' class='common' type='text' value='"+obj.data[i].fieldValue+"' /></td>";
				   if(null==obj.data[i].officialDesc){
					   showContentString  +="<td>"+""+"</td>";
				   }else{
					   showContentString  +="<td>"+obj.data[i].officialDesc+"</td>"; 
				   }
				   if(null==obj.data[i].busiDesc){
					   showContentString  +="<td>"+""+"</td>";
				   }else{
					   showContentString  +="<td>"+obj.data[i].busiDesc+"</td>"; 
				   }
				   showContentString  +="</tr>";
			   }
		   		$("#CFContent").html(showContentString);
		   }
		});
	
}



//删除投保规则
function deleteCF(){
	
    //判断产品是否存并是否已选择定义中的产品
	if(null==$('input:radio[name="selectApplingRadio"]:checked').val()
	  ||undefined==$('input:radio[name="selectApplingRadio"]:checked').val()){
		alert("请先选择一个需要定义的产品！");
		return false;
	}
	
	$.ajax({
		type : "POST",
		url : contextRootPath + "/product/deleteCF.do",
		 data : {"id":$('input:radio[name="selectApplingRadio"]:checked').val()},
		dataType :"json",
		success : function(obj){
			if(null!=obj.msg){
			  alert(obj.msg);
			  queryApplingCF();
		    }
		}
	});

}







//保存投保规则
function saveCF(){
	
	$.ajax({
		type : "POST",
		url : contextRootPath + "/product/saveCF.do",
		data : $("#frmInput").serialize(),
		dataType :"json",
		success : function(obj){
			if(null!=obj.msg){
			  alert("保存成功！");
			  $("#save").attr('disabled',true);
			  queryApplingCF();
		    }
		}
	});

}




//查询已发送的问题件规则
function queryApplingIssue(){
	
	$.ajax({
		type : "POST",
		url : contextRootPath + "/product/queryApplingIssue.do",
		data : {"riskCode":"","issueState":"1"},
		dataType :"json",
		success : function(obj){
			   var showContentString = "";
			   $("#HASIssuedetail").html("");
			   for(var i = 0 ; i < obj.data.length ; i++){
				   showContentString += "<tr class='content'>"
				   +"<td><input type='radio' name='selectApplingRadio' value='"+obj.data[i]["id.riskCode"]+","+obj.data[i]["id.serialNo"]+"'/></td>"
				   +"<td>"+(i+1)+"</td>"
				   +"<td>"+obj.data[i].backpost+"</td>"
				   +"<td>"+obj.data[i].issuecont+"</td>"
				   +"<td>"+obj.data[i].issuestate+"</td>"
				   +"</tr>";
			   }
		   		$("#HASIssuedetail").html(showContentString);
			
		}
	});
}





//新增问题件
function insertIssue(){
	$("#IssueDetail").show();
	$("#serialNo").val(""); 
}




//保存问题件
function saveIssue(){
	$.ajax({
		type : "POST",
		url : contextRootPath + "/product/saveIssue.do",
		data : $("#frmIssueInput").serialize(),
		dataType :"json",
		success : function(obj){
			if(null!=obj.msg){
			  alert("保存成功！");
			  queryApplingIssue();
		    }
		}
	});

}


//删除问题件
function deleteIssue(){
	
    //判断产品是否存并是否已选择定义中的产品
	if(null==$('input:radio[name="selectApplingRadio"]:checked').val()
	  ||undefined==$('input:radio[name="selectApplingRadio"]:checked').val()){
		alert("请先选择一个需要定义的产品！");
		return false;
	}
	
	$.ajax({
		type : "POST",
		url : contextRootPath + "/product/deleteIssue.do",
		 data : {"id":$('input:radio[name="selectApplingRadio"]:checked').val()},
		dataType :"json",
		success : function(obj){
			if(null!=obj.msg){
			  alert(obj.msg);
			  queryApplingIssue();
		    }
		}
	});

}





//修改问题件
function  updateIssue(){
//判断产品是否存并是否已选择定义中的产品
	if(null==$('input:radio[name="selectApplingRadio"]:checked').val()
	  ||undefined==$('input:radio[name="selectApplingRadio"]:checked').val()){
		alert("请先选择一个需要定义的产品！");
		return false;
	}
	
	$("#IssueDetail").show();

	$.ajax({
		   type: "POST",
		   url: contextRootPath + "/product/updateIssue.do",
		   data : {"id":$('input:radio[name="selectApplingRadio"]:checked').val()},
		   dataType : "json",
		   success: function(obj){
			   for(var i = 0 ; i < obj.data.length ; i++){
					$("#issuecont").val(obj.data[i].issuecont); 
					$("#riskCode").val(obj.data[i].riskCode); 
					$("#serialNo").val(obj.data[i].serialNo); 
					$("#codeType").val(obj.data[i].backpost); 
					$("#codeName").val(obj.data[i].backpostname); 
					
			   }
		   }
		});
	
}
//查询已存在的对应险种的险种角色信息
function findRiskRoleByRisk(){
	$.ajax({
	   type: "POST",
	   url: contextRootPath + "/product/findRiskRoleByRisk.do",
	   data : {"riskCode":"a"},
	   dataType : "json",
	   success: function(obj){
		   var showContentString = "";
		   for(var i = 0 ; i < obj.data.length ; i++){
			   showContentString += "<tr class='content'><td><input name='riskRoleUnion' value='"+obj.data[i]["id.riskCode"]+","+obj.data[i]["id.riskRole"]+","+obj.data[i]["id.riskRoleSex"]+","+obj.data[i]["id.riskRoleNo"]+"' type='radio' /></td><td>"+i+1+"</td><td>"
			   	+obj.data[i]["id.riskCode"]+"</td><td>"
			   	+obj.data[i].riskVer+"</td><td>"
			   	+obj.data[i]["id.riskRole"]+"</td><td>"
			   	+obj.data[i]["id.riskRoleSex"]+"</td><td>"
			   	+obj.data[i]["id.riskRoleNo"]+"</td><td>"
			   	+obj.data[i].minAppAgeFlag+"</td><td>"
			   	+obj.data[i].minAppAge+"</td><td>"
			   	+obj.data[i].maxAppAgeFlag+"</td><td>"
			   	+obj.data[i].maxAppAge+"</td>";
		   }
	   		$("#roleList").html(showContentString);
	   }
	});
	$("#saveriskRole").attr('disabled',true);
}
//展示险种信息的时候，先查询一次险种角色信息
$(function(){
	findRiskRoleByRisk();
});
//查询需要修改的险种角色信息的
function updateRiskRole() { 
	//判断是否已选择要修改的产品
	if(null==$('input:radio[name="riskRoleUnion"]:checked').val()
	  ||undefined==$('input:radio[name="riskRoleUnion"]:checked').val()){
		alert("请先选择一个需要修改的险种角色！");
		return false;
	}
	$("#riskRole").show();
	var val=$('input:radio[name="riskRoleUnion"]:checked').val();
	$.ajax({
		   type: "POST",
		   url: contextRootPath + "/product/findRiskRole.do",
		   data : {"riskRoleUnion":val},
		   dataType : "json",
		   success: function(obj){
			   var showContentString = "";
			   for(var i = 0 ; i < obj.data.length ; i++){
				   showContentString += "<tr class='content'><td>"
				    +obj.data[i].displayOrder+"</td><td>"
				   	+obj.data[i].fieldName+"</td><td>"
				   	+obj.data[i].fieldCode+"</td><td>"
				   	+obj.data[i].fieldType+"</td><td><input type='text' value='"
				   	+obj.data[i].fieldValue+"' name='pdlmRiskRole."+obj.data[i].fieldCode+"' class='common'/></td><td>";
				   if(null==obj.data[i].officialDesc){
					   showContentString  +="</td><td>";
				   }else{
					   showContentString  +=obj.data[i].officialDesc+"</td><td>"; 
				   }
				   if(null==obj.data[i].busiDesc){
					   showContentString  +="</td>";
				   }else{
					   showContentString  +=obj.data[i].busiDesc+"</td>"; 
				   }
				   showContentString  +="</tr>";
			   }
		   		$("#oneRole").html(showContentString);
		   }
		});
	 $("#operateRole").val("u");
	$("#saveriskRole").attr('disabled',false);
};
//新增险种角色信息时查询需要定义的险种角色的字段的名称属性等信息
function addRiskRole() { 
	$("#riskRole").show();
	$.ajax({
		   type: "POST",
		   url: contextRootPath + "/product/findRiskRole.do",
		   data : {"riskRoleUnion":""},
		   dataType : "json",
		   success: function(obj){
			   var showContentString = "";
			   for(var i = 0 ; i < obj.data.length ; i++){
				   showContentString += "<tr class='content'><td>"
				    +obj.data[i].displayOrder+"</td><td>"
				   	+obj.data[i].fieldName+"</td><td>"
				   	+obj.data[i].fieldCode+"</td><td>"
				   	+obj.data[i].fieldType+"</td><td><input type='text' value='"
				   	+obj.data[i].fieldValue+"' name='pdlmRiskRole."+obj.data[i].fieldCode+"' class='common'/></td><td>";
				   if(null==obj.data[i].officialDesc){
					   showContentString  +="</td><td>";
				   }else{
					   showContentString  +=obj.data[i].officialDesc+"</td><td>"; 
				   }
				   if(null==obj.data[i].busiDesc){
					   showContentString  +="</td>";
				   }else{
					   showContentString  +=obj.data[i].busiDesc+"</td>"; 
				   }
				   showContentString  +="</tr>";
			   }
		   		$("#oneRole").html(showContentString);
		   }
		});
	 $("#operateRole").val("s");
	 $("#saveriskRole").attr('disabled',false);
};
//保存险种角色信息
function saveRiskRole() {
	//判断是新增还是更新数据
	if($("#operateRole").val()=="s"){
		operateRiskRole='saveRiskRole';
	}else{
		operateRiskRole='updateRiskRole';
	}
		
	$.ajax({
		type : "POST",
		url : contextRootPath + "/product/"+operateRiskRole+".do",
		data :$("#riskRoleForm").serialize(),
		dataType :"json",
		success : function(){
			  $("#saveriskRole").attr('disabled',true);
			  findRiskRoleByRisk();
		    }
		}
	);
};
function deleteRiskRole(){
	
    //判断是否存已选择要删除的险种角色
	if(null==$('input:radio[name="riskRoleUnion"]:checked').val()
	  ||undefined==$('input:radio[name="riskRoleUnion"]:checked').val()){
		alert("请先选择一个需要删除的险种角色！");
		return false;
	}
	var val=$('input:radio[name="riskRoleUnion"]:checked').val();
	$.ajax({
		type : "POST",
		url : contextRootPath + "/product/deleteRiskRole.do",
		data : {"riskRoleUnion":val},
		dataType :"json",
		success : function(obj){
			$("#saveriskRole").attr('disabled',false);
			if(null!=obj.msg){
			  $("#oneRole").html("");
			  alert(obj.msg);
			  //查询剩余险种角色记录
			  findRiskRoleByRisk();
			  //删除后清空下面的数据
			  
		    }
			
		}
	});

}

