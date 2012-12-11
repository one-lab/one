	
//根据条件查询客户信息
	function findCustomerInfoByCondition(){
		var findUrl=ctx + "/prpall/findCustomerInfoByCondition.do";
		
		$("#customerForm").attr("action",findUrl).submit();
		
		
		
		
		/*var findParams = {
				//集体保单信息类
			"ldGrp.customerNo":$("#customerNo").val(),
			"ldGrp.grpName":$("#grpName").val(),
			"ldGrp.grpNature":$("#grpNature").val()
		}
		//返回查询结果信息
		function findCustomerInfoCallBack(obj){
			$("#content").html("");
			var contentString="";
			var xuhao = 1 ;
			for(var i = 0 ; i < obj.data.length; i++){
				contentString += "<tr class='content' name='aa'>";
				contentString += "<td ><input name='radioClertNo' type='radio' value="+obj.data[i].customerNo+" />"+
				"<td>"+xuhao+"</td>"+
				"<td>"+obj.data[i].customerNo+"</td>"+
				"<td>"+obj.data[i].grpName+"</td>"+
				"<td>"+obj.data[i].grpNature+"</td>";
				xuhao++;
				contentString +="</tr>";
			}
			$("#content").html(contentString);
		}
		jQuery.post(findUrl,findParams,findCustomerInfoCallBack,'json');*/
	}

//开始选择
	function chooseClertStart(){
		//根据 投保单号 查询保单详细信息 路径的变量
		var ChooseClertUrl=ctx + "/prpall/findClertInfoByCustomerNo.do?customerNo1=";
		var customerNoTemp = "";
		if(null==$('input:radio[name="comstomerNoRadio"]:checked').val()
			   ||undefined==$('input:radio[name="comstomerNoRadio"]:checked').val()){
			   alert("请选择一条客户信息开始录入！");
			   return false;
			}
		customerNoTemp= $('input:radio[name="comstomerNoRadio"]:checked').val();
			$("#customerForm").attr("action",ChooseClertUrl+customerNoTemp).submit();
		//保单号
		grpContNoHidden=$("#grpContNoHidden").val();
	}
	