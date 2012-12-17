//人工核审中查询个人投保单

	function findArtificalUWContInfo(){
		var findUrl= ctx + "/prpall/findArtificalUWContInfo.do";
		var findParams ={
			"lcInsured.grpContNo":$("#grpContNo").val(),
			"lcInsured.name":$("#name").val(),
			"lcInsured.manageCom":$("#manageCom").val(),
			"lcInsured.idType":$("#idType").val(),
			"lcInsured.idNo":$("#idNo").val(),
			"lcInsured.contPlanCode":$("#contPlanCode").val()
		};
	//人工核保中查询个人保单信息回调函数
		function findProposalGrpContInfoCallBack(obj){
			$("#content").html("");
			var contentString="";
			var xuhao = 1 ;
			for(var i = 0 ; i < obj.data.length; i++){
				contentString += "<tr class='content' name='aa'>";
				contentString += "<td ><input id='radioContNo' name='radioContNo' type='radio' value="+obj.data[i].contNo+" />"+
				"<td>"+xuhao+"</td>"+
				"<td>"+obj.data[i].contNo+"</td>"+
				"<td>"+obj.data[i].uwFlag+"</td>"+
				"<td>"+obj.data[i].name+"</td>"+
				"<td>"+obj.data[i].manageCom+"</td>"+
				"<td>"+obj.data[i].contPlanCode+"</td>"+
				"<td>50</td>";
				xuhao++;
				contentString +="</tr>";
			}
			$("#content").html(contentString);
			
		}
		jQuery.post(findUrl,findParams,findProposalGrpContInfoCallBack,'json');
	}
	
	
	//开始人工核保个人信息
	function artificalUWStart(){
		var findUrl=ctx + "/prpall/findArtificalUWPersonDeal.do";
		var contNoTemp = "";
		//查找哪个radio被选中
		if(null==$('input:radio[name="radioContNo"]:checked').val()
				   ||undefined==$('input:radio[name="radioContNo"]:checked').val()){
				   alert("请选择一条记录查看的核保件！");
				   return false;
				}
		contNoTemp= $('input:radio[name="radioContNo"]:checked').val();
		window.location.href = findUrl + "?lcCont.contNo=" + contNoTemp;
	}