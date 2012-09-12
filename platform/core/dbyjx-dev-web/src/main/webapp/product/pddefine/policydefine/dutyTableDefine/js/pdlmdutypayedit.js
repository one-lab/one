function sonCallbackFather(){
		createAlgo();
	}
	//增加操作元素
	function createAlgo(){
		//保存计算公式的文字形式
		var factorElement = $("#calName").val();
		var factorText = $("#algoId").text();
		factorText += factorElement;
		$("#algoId").text(factorText);
		
		//保存计算公式的真实面孔
		var calElement = $("#calSql").val();
		var calAll = $("#pdlmCalMode_calSQL").val();
		calAll += calElement;
		$("#pdlmCalMode_calSQL").val(calAll);
	}
	
	//增加操作符
	function addOperator(operator){
		//保存计算公式的文字形式
		var factorElement = $(operator).val();
		var factorText = $("#algoId").text();
		factorText += factorElement;
		$("#algoId").text(factorText);
		
		//保存计算公式的真实面孔
		var calElement = $(operator).val();
		var calAll = $("#pdlmCalMode_calSQL").val();
		calAll += calElement;
		$("#pdlmCalMode_calSQL").val(calAll);
	}
	//保存算法
	function saveCalMode(){
		alert($("#operCalMode").length);
		var params = {
			"pdlmCalMode.calCode":$("#pdlmCalMode_calCode").val(),
			"pdlmCalMode.riskCode":$("#pdlmCalMode_riskCode").val(),
			"pdlmCalMode.type":$("#pdlmCalMode_type").val(),
			"pdlmCalMode.remark":$("#algoId").val(),
			"pdlmCalMode.calSQL":$("#pdlmCalMode_calSQL").val()
		};
		$.ajax({
			type : "post",
			url : ctx + "/product/saveCalMode",
			data : params,
			success : function(data){
				var calModeString = $("#calModeContent").html();
				for(var i = 0 ; i < data.length ; i++){
					calModeString += '<tr class="content" align="center">'+
						'<td width="5%"> <input name="calCodeRadio" value='+data[i].calCode+' type="radio"/> </td>'+
						'<td width="5%">'+(i+1)+'</td>'+
						'<td width="18%">'+data[i].calCode+'</td>'+
						'<td width="18%">'+data[i].riskCode+'</td>'+
						'<td width="18%">'+data[i].type+'</td>'+
						'<td width="18%">'+data[i].remark+'</td>'+
						'</tr>';
						
				}
				$("#calModeContent").html(calModeString);
			}
		});
	}
	
	//修改算法
	function updateCalMode(){
		var params = {
			"pdlmCalMode.calCode":$("#pdlmCalMode_calCode").val(),
			"pdlmCalMode.riskCode":$("#pdlmCalMode_riskCode").val(),
			"pdlmCalMode.type":$("#pdlmCalMode_type").val(),
			"pdlmCalMode.remark":$("#algoId").val(),
			"pdlmCalMode.calSQL":$("#pdlmCalMode_calSQL").val()
		};
		$.ajax({
			type : "post",
			url : ctx + "/product/updateCalMode",
			data : params,
			success : function(data){
				var calModeString = $("#calModeContent").html();
				for(var i = 0 ; i < data.length ; i++){
					calModeString += '<tr class="content" align="center">'+
						'<td width="5%"> <input name="calCodeRadio" value='+data[i].calCode+' type="radio"/> </td>'+
						'<td width="5%">'+(i+1)+'</td>'+
						'<td width="18%">'+data[i].calCode+'</td>'+
						'<td width="18%">'+data[i].riskCode+'</td>'+
						'<td width="18%">'+data[i].type+'</td>'+
						'<td width="18%">'+data[i].remark+'</td>'+
						'</tr>';
						
				}
				$("#calModeContent").html(calModeString);
			}
		});
	}
	//删除算法
	function deleteCalMode(){
		var bool = confirm("您确定要删除这条记录？");
		if(bool){			
			$.ajax({
				type : "post",
				url : contextRootPath + "/product/deleteCalMode",
				data : {"calCode":$("#calCode").val()},
				success : function(obj){
					alert(obj);
				}
			});
		}
	}
	
	//清空算法
	function clearCalMode(){
		$("#algoId").text("");
		$("#pdlmCalMode_calSQL").val("");
	}