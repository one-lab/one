
	
	//页面加载完后查询所有要素，展示在页面
		
	$(document).ready(function (){
		findAllFactor();
	});

	function findAllFactor(){
		$.ajax({
		   type: "POST",
		   url: ctx + "/product/findScheRateCalFactor",
		   dataType : "json",
		   success: function(data){
		   		var factorString = $("#factorContent").html();
		   		for(var i = 0 ; i < data.length ; i++){
		   			factorString += '<tr class="content">'+
		   				'<td><input name="factor" type="checkbox" value="'+data[i].factorCode+'" /></td>'+
		   				'<td>'+(i+1)+'</td>'+
		   				'<td>'+data[i].factorName+'</td>';
		   		}
		   		$("#factorContent").html(factorString);
		   		
		   		var riskCode = $("#riskCode").val();
				var dutyCode = $("#dutyCode").val();
				var url = ctx + "/product/findFactorByRiskAndDuty";
				var params = {
					"riskCode":riskCode,
					"dutyCode":dutyCode
				};
				jQuery.post(url,params,checkFactorCallBack,"json");
				function checkFactorCallBack(data){
					$("input:checkbox").each(function(){
						for(var i = 0 ; i < data.length ; i++){
							if($(this).val() == data[i]["id.calFactor"]){
								$(this).attr("disabled","disabled");
								//$(this).css("display","display");
							}
						}
					});
					//获得当前险种的已定义好的要素
					showFactor(data);
				}
		   }
		}); 
	}
	function showFactor(data){
		var factorContent = $("#riskDutyFactorContent").html();
		for(var i = 0 ; i < data.length ; i++){
			factorContent += '<tr class="content">'+
			'<td width="25%">'+ (i+1) +'</td>'+  //obj.data[i].factorOrder
			'<td width="25%">'+ data[i].factorName +'</td>'+
			'<td  width="25%">'+ (data[i].comFactorName.indexOf("(")>=0?"是":"否") +'</td>'+
			'<td  width="25%">'+ data[i].comFactorName +'</td>'+'<td width="25%">&nbsp;</td>'+
			'</tr>';
		}
		$("#riskDutyFactorContent").html(factorContent);
	}
	//获得当前险种的已定义好的要素
//	function findFactorByRiskDuty(){
//		var riskCode = $("#riskCode").val();
//		var dutyCode = $("#dutyCode").val();
//		var url = ctx + "/product/findFactorByRiskAndDuty";
//		var params = {
//			"riskCode":riskCode,
//			"dutyCode":dutyCode
//		};
		
//		jQuery.post(url,params,showFactorCallBack,"json");
//	}
	
	//单要素添加
	function addRiskDutyFactor(){
		if($('input[name="factor"]:checked').size()>1){
			alert("单要素添加，请选择一个要素！");
		}else{			
			//输出选中的值  
			var str="";  
			var paramString = "params = {";
			$('input[name="factor"]:checked').each(function(){
				paramString +="'pdLMRiskDutyFactor.id.calFactor' : '"+$(this).val()+"'";
				paramString +=" , 'pdLMRiskDutyFactor.id.riskCode' : '"+$("#riskCode").val()+"'";
				paramString +=" , 'pdLMRiskDutyFactor.id.dutyCode' : '"+$("#dutyCode").val()+"'";
				$(this).removeAttr("checked");
				$(this).attr("disabled","disabled");
			});
			paramString +=" } ";
			eval(paramString);
			function showFactor(obj){
				alert(obj);
				var resuleString = '';
				
				for(var i = 0 ; i < obj.data.length ; i++){
					resuleString += '<tr class="content"><td>'+obj.data[i].factorOrder+'</td>'+
						'<td>'+obj.data[i].factorName+'</td><td>否</td><td></td><td>&nbsp;-&nbsp;</td></tr>';
				}
				var html = $("#riskDutyFactorContent").html();
				html += resuleString;
				$("#riskDutyFactorContent").html(html);
			}
			jQuery.post(ctx + "/product/addRiskDutyFactor",params,showFactor,'json');
		}
	}
	//组合要素添加
	function addRiskDutyFactors(){
		if($('input[name="factor"]:checked').size()<=1){
			alert("组合要素添加，请选择多个要素！");
		}else{
			//输出选中的值  
			var str="";  
			var paramString = "params = {";
			var count = 0;
			$('input[name="factor"]:checked').each(function(){
				paramString +="'pdLmRiskDutyFactorList["+count+"].id.calFactor' : '"+$(this).val()+"'";
				paramString +=" , 'pdLmRiskDutyFactorList["+count+"].id.riskCode' : '"+$("#riskCode").val()+"'";
				paramString +=" , 'pdLmRiskDutyFactorList["+count+"].id.dutyCode' : '"+$("#dutyCode").val()+"'";
				paramString +=" , ";
				count++;
				$(this).removeAttr("checked");
				$(this).attr("disabled","disabled");
			});
			paramString = paramString.substring(0,(paramString.length-2));
			paramString +=" } ";
			eval(paramString);
			function showFactor(data){
				var resuleString = '';
				var factors = "";
				for(var i = 0 ; i < data.length ; i++){
					factors += "（"+data[i].factorName+"）";
					
				}
				for(var i = 0 ; i < data.length ; i++){
					resuleString += '<tr class="content"><td>'+data[i].factorOrder+'</td><td>'+data[i].factorName+'</td>'+
					'<td>是</td><td> '+factors+' </td><td>&nbsp;-&nbsp;</td></tr>';
				}
				var html = $("#riskDutyFactorContent").html();
				html += resuleString;
				$("#riskDutyFactorContent").html(html);
			}
			jQuery.post(ctx + "/product/addRiskDutyFactor",params,showFactor,'json');
		}
	}
	
	
	//创建要素页面
	function createFactorHtml(){
		//获得当前责任下的要素
		var riskCode = $("#riskCode").val();
		var dutyCode = $("#dutyCode").val();
		var url = ctx + "/product/findFactorByRiskAndDuty";
		var params = {
			"riskCode":riskCode,
			"dutyCode":dutyCode
		};
		function createHTML(data){
			var strHtmlTitle = "<tr class='tableHead'>";
			var strHtmlContent = "<tr class='content' >";
			for(var i = 0 ; i < data.length ; i++){
				//0:直接值   1:双击文本   2:特殊值
				if("0"==data[i].dhtmlType){
					//TODO 朱超，单位是否要带上
					strHtmlTitle += "<td>"+data[i].factorName+"()</td>";
					strHtmlContent += "<td>"+
						"<input type='hidden' name='PDLMRiskDutyFactorValueVos["+i+"].calFactor' value="+data[i]["id.calFactor"]+" />"+
						" <input type='text' class='common' name='PDLMRiskDutyFactorValueVos["+i+"].calFactorValue' /></td>";
				}
				if("1"==data[i].dhtmlType){
					strHtmlTitle += "<td>"+data[i].factorName+"()</td>";
					//<input id="sex" class="codecode" type="text" sex','sexname','pdldcode1','codetype:sex')'="" ondblclick="queryCode(" name="sex" style="width: 20%;">
					strHtmlContent += "<td>"+
						"<input type='hidden' name='PDLMRiskDutyFactorValueVos["+i+"].calFactor' value="+data[i]["id.calFactor"]+" />"+
						" <input type='text' style='width:20%' class='codecode' id='"+data[i]["id.calFactor"]+"' name='PDLMRiskDutyFactorValueVos["+i+"].calFactorValue'"+
						" ondblclick=queryCode('"+data[i]["id.calFactor"]+"','"+data[i]["id.calFactor"]+"Name','PDLDcode1','codeType:"+data[i]["id.calFactor"]+"') />"+
						"<input type='text' class='common' style='width:60%' id='"+data[i]["id.calFactor"]+"Name' /> </td>";
				}
				if("2"==data[i].dhtmlType){
					strHtmlTitle += "<td>"+data[i].factorName+"()</td>";
					strHtmlContent += "<td>"+
					"<input type='hidden' name='PDLMRiskDutyFactorValueVos["+i+"].calFactor' value="+data[i]["id.calFactor"]+" />"+
						" <input type='text' style='width:20%' class='codecode' id='"+data[i]["id.calFactor"]+"' name='"+data[i]["id.calFactor"]+"'" +
						" ondblclick=queryCode('"+data[i]["id.calFactor"]+"','"+data[i]["id.calFactor"]+"Name','PDLDcode1','codeType:"+data[i]["id.calFactor"]+"') />"+
						"<input type='text' class='common' style='width:50%' id='"+data[i]["id.calFactor"]+"Name' />"+
						"<input type='text' class='common' style='width:30%' name='PDLMRiskDutyFactorValueVos["+i+"].calFactorValue' /> </td>";
				}
			}
			
			strHtmlTitle +="</tr>";
			strHtmlContent +="</tr>";
			var strHTML = strHtmlTitle + strHtmlContent;
			$("#tempFactorHtml").html(strHTML);
			alert(strHTML);
			
			//更新pd_lmriskduty表中的字段DHTML
			var updateDhtmlUrl = ctx + "/product/updateDhtml";
			var params = {
				"pdlmRiskDuty.id.riskCode" : $("#riskCode").val(),
				"pdlmRiskDuty.id.dutyCode" : $("#dutyCode").val(),
				"pdlmRiskDuty.dhtml" : strHTML
			};
			function showMsg(obj){
				alert(obj);
			}
			jQuery.post(updateDhtmlUrl,params,showMsg);
			
		}
		jQuery.post(url,params,createHTML,'json');
		
	}
	
	
	
	//下载费率表模版
	function DownloadExcel(){
		alert("待完成，哈哈...");
	}
	function sonCallbackFather(){
		alert(111);
		findAllFactor();
	}
	