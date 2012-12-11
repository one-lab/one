//检查带'*'数据
function checkData(){
	if((null == $("#relation").val()) || ("" == $("#relation").val())){
		alter("请录入报案人与出险人关系");
	}
	if((null == $("#rptorName").val()) || ("" == $("#rptorName").val())){
		alter("请录入报案人姓名");
	}
	if((null == $("#comCode").val()) || ("" == $("#comCode").val())){
		alter("请录入管辖机构");
	}
}

// 保存报案基本信息，客户出险信息,事件信息，理赔类型信息
function saveClaimReportInfo(){
	var a = $("#accDesc").val().length;
	if(a > 500){
		alert("事故描述不能超过500!");
		return ;
	}
	//checkData();
	$.ajax({
		type : "POST",
		url : contextRootPath + "/claim/saveClaimReportInfo.do",
		data : $("#claimReportInfo").serialize(),
		dataType :"json",
		success : function(obj){
			if(null!=obj){
				$("#llSubReportContent").html("");
				var content="";
				for(var i=0;i<obj.llSubReport.length;i++){
					if(obj.llSubReport[i].message==null){
						obj.llSubReport[i].message="";
					}
					var xuhao = 1;
					content += "<tr class='content'>";
					content += "<td><input name='radioRptNo' type='radio' value=" + i + " /></td>"
					 		+ "<td>" + xuhao + "</td>"
					 		+ "<td>" + obj.llSubReport[i].CustomerNo + "</td>"
					 		+ "<td>" + obj.llSubReport[i].CustomerName + "</td>"
					 		+ "<td>" + obj.llSubReport[i].CustomerSex + "</td>"
					 		+ "<td>" + obj.llSubReport[i].CustBirthday + "</td>"
					 		+ "<td>" + obj.llSubReport[i].IDType + "</td>"
					 		+ "<td>" + obj.llSubReport[i].IDNo + "</td>";
					content+="</tr>";
					xuhao++;
				}
			$("#llSubReportContent").html(content);
			alert("保存成功！");
		  }
		}
	});
}
//修改报案基本信息，客户出险信息,事件信息，理赔类型信息
function udpateClaimReportInfo(){
	var a = $("#accDesc").val().length;
	if(a > 500){
		alert("事故描述不能超过500!");
		return ;
	}
	$.ajax({
		type : "post",
		url : contextRootPath + "/claim/udpateClaimReportInfo.do",
		data : $("#claimReportInfo").serialize(),
		dataType :"json",
		success : function(obj){
			alert("数据提交成功!");
		}
	});
}
