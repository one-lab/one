
//人工核审中查询团体投保单
	function findProposalGrpContInfo(){
		var findUrl=ctx + "/prpall/findProposalGrpContInfo.do";
		var findParams ={
			"lcGrpCont.grpContNo":$("#grpContNo").val(),
			"lcGrpCont.grpName":$("#grpName").val(),
			"lcGrpCont.manageCom":$("#manageCom").val()
		};
	//人工核保中查询团体保单信息回调函数
		function findProposalGrpContInfoCallBack(obj){
			$("#content").html("");
			var contentString="";
			var index = 1;
			var firstDateStr = "";
			for(var i = 0 ; i < obj.data.length; i++){
				contentString += "<tr class='content' id='tr_" + index + "'>";
				if(null != obj.data[i].uwDate){
					var date = new Date();
					date.setTime(obj.data[i].uwDate.time);
					var dateStr = date.getUTCFullYear()+"-"+(date.getUTCMonth()+1)+"-"+(date.getUTCDate()+1);
				}else{
					dateStr = "";
				}
				if(null != obj.data[i].uwDate){
					var firstDate = new Date();
					firstDate.setTime(obj.data[i].firstTrialDate.time);
					firstDateStr = firstDate.getUTCFullYear()+"-"+(firstDate.getUTCMonth()+1)+"-"+(firstDate.getUTCDate()+1);
				}else{
					firstDateStr = "";
				}
				contentString += "<td ><input name='radioGrpContNo' type='radio' value="+obj.data[i].grpContNo+" />"+
				"<td>"+index+"</td>"+
				"<td>"+obj.data[i].grpContNo+"</td>"+
				"<td>"+obj.data[i].grpName+"</td>"+
				"<td>"+(null == obj.data[i].uwOperator ? "" : obj.data[i].uwOperator)+"</td>"+
				"<td>"+obj.data[i].manageCom+"</td>"+
				"<td>"+dateStr+"</td>"+
				"<td>"+firstDateStr+"</td>"+
				"<td>"+(null == obj.data[i].uwFlag ? "" : obj.data[i].uwFlag)+"</td>";
				index++;
				contentString +="</tr>";
			}
			$("#content").html(contentString);
		}
		jQuery.post(findUrl,findParams,findProposalGrpContInfoCallBack,'json');
	}
	
	
	
//人工核审中申请团体投保单

	function applyProposal(){
		var findUrl=ctx + "/prpall/applyProposal.do";
		var grpContNoTemp = "";
		//查找哪个radio被选中
		if(null==$('input:radio[name="radioGrpContNo"]:checked').val()
				   ||undefined==$('input:radio[name="radioGrpContNo"]:checked').val()){
				   alert("请选择一条投保单申请记录进行核保！");
				   return false;
				}
		grpContNoTemp= $('input:radio[name="radioGrpContNo"]:checked').val();
		window.location.href = findUrl + "?lcGrpCont.grpContNo=" + grpContNoTemp;
	}
	
	
	
	
//开始人工核保
	function artificalUWStart(){
		var findUrl=ctx + "/prpall/findArtificalUWDeal.do";
		var grpContNoTemp = "";
		//查找哪个radio被选中
		if(null==$('input:radio[name="radioWaitUW"]:checked').val()
				   ||undefined==$('input:radio[name="radioWaitUW"]:checked').val()){
				   alert("请选择一条记录在进行核保！");
				   return false;
				}
		grpContNoTemp= $('input:radio[name="radioWaitUW"]:checked').val();
		window.location.href = findUrl + "?lcGrpCont.grpContNo=" + grpContNoTemp;
	}
	
	
//核保件查看
	function UWFileCheck(){
		var findUrl=ctx + "/prpall/findArtificalUWFile.do";
		var grpContNoTemp = "";
		//查找哪个radio被选中
		if(null==$('input:radio[name="radioGrpContNo"]:checked').val()
				   ||undefined==$('input:radio[name="radioGrpContNo"]:checked').val()){
				   alert("请选择一条记录查看的核保件！");
				   return false;
				}
		grpContNoTemp= $('input:radio[name="radioGrpContNo"]:checked').val();
		window.location.href = findUrl + "?lcGrpCont.grpContNo=" + grpContNoTemp;
	}
	
	
//初始化个人工作池
	function initPersonWorkPool(){
		var findUrl = contextRootPath + "/prpall/initArtificalUWApply.do";
		//初始化个人工作池回调函数
		function initPersonWorkPoolCallBack(obj){
			$("#privateContent").html("");
			var parivateContent = "";
			var dateStr = "";
			var firstDateStr = "";
			for(var i = 0;i < obj.data.length;i++){
				if(null != obj.data[i].uwDate && undefined != obj.data[i].uwDate){
					var date = new Date();
					date.setTime(obj.data[i].uwDate.time);
					dateStr = date.getUTCFullYear()+"-"+(date.getUTCMonth()+1)+"-"+(date.getUTCDate()+1);
				}else{
					dateStr = "";
				}
				if(null != obj.data[i].firstTrialDate && undefined != obj.data[i].firstTrialDate){
					var firstDate = new Date();
					firstDate.setTime(obj.data[i].firstTrialDate.time);
					firstDateStr = firstDate.getUTCFullYear()+"-"+(firstDate.getUTCMonth()+1)+"-"+(firstDate.getUTCDate()+1);
				}else{
					firstDateStr = "";
				}
				parivateContent+="<tr class='content'>"
					+ "<td><input name='radioWaitUW' type='radio' value='" + obj.data[i].grpContNo + "'/></td>"
					+ "<td>"+ (i+1)	+ "</td>"
					+ "<td>"+ obj.data[i].grpContNo +"</td>"
					+ "<td>"+ obj.data[i].grpName+ "</td>"
					+ "<td>"+obj.data[i].manageCom+"</td>"
					+ "<td>"+ dateStr + "</td>"
					+ "<td>"+ firstDateStr + "</td>"
					+ "</tr>";
			}
			$("#privateContent").html(parivateContent);
		}
		jQuery.post(findUrl,null,initPersonWorkPoolCallBack,"json");
	}
	
	
	