//投保单申请按钮
function displyNewProsalPreInfoCheck(){
	
	var flag=0;
	var firstTrialDate=$("#repApplyDate").val();
	var manageCom=$("#comCode").val();
	var grpName=$("#grpName").val();
	var grpNameTem=$("#grpNameTem").val();
	
	if(manageCom== "" || firstTrialDate== "" ){
		flag=1;
		alert("管理机构或初审日期不能为空");
	}else{
	
	
	if(grpName!=""){
		if(grpNameTem==""){
			flag=1;
			$("#grpNameTem").val(grpName);
			$("#grpName").val("");
			$("#grpName").focus();
			alert("请再次输入投保单位名称");
		}else{
			var grpName=$("#grpName").val();
			var grpNameTem=$("#grpNameTem").val();
			if(grpName!=grpNameTem){
				flag=1;
				$("#grpName").val("");
				$("#grpNameTem").val("");
				$("#grpName").focus();
				alert("两次输入的投保单位名称不一致，请重新输入");}
		}
		
	}else{
		flag=1;
		alert("请输入投保单位名称");
	}
	
	}
	if(flag==0){
		var url = ctx + "/prpall/apply.do";;
		$("#fm").attr("action",url);
		$("#fm").submit();
	}
	
	
	
}

			
			
//呈报件查看按钮
function findReportInfo(){
	
	var url =contextRootPath + "/prpall/findReportInfo.do";
	var params ={
			"lcGrpCont.grpName":$("#GrpName").val(),
			"lcGrpCont.appntNo":$("#CustomerNo").val()
	};
	
	
	function CallBack(obj){
		
		if(obj=="sucess"){
			window.open(contextRootPath+"/prpall/group/proposalPre/ReportQueryResult.jsp");
		}else if(obj=="fail"){
			alert("没有查到相关呈报件信息");
		}
	}
	jQuery.post(url,params,CallBack);
}

//ReportQueryResult.jsp中的返回按钮
function reportReturn(){
	var repNo;
	if(null==$('input:radio[name="radioRepNo"]:checked').val() ||undefined==$('input:radio[name="radioRepNo"]:checked').val()){  
		alert("请选择一条呈报件记录！"); 
		return false; 
	}
	repNo=$('input:radio[name="radioRepNo"]:checked').val(); 
		var doc=window.opener.document;
		doc.fm.ReportNo.value=repNo;
		window.close();
	
}

//投保单查询按钮
function findProsalPreInfo(){
	var url = ctx + "/prpall/findProsalPreInfo.do";
	$("#fm").attr("action",url);
	$("#fm").submit();	
	
}

//ProposalPreApply.jsp中的开始录入按钮
function findProsalPreDetail(){
	if(null==$('input:radio[name="lcGrpCont.grpContNo"]:checked').val() ||undefined==$('input:radio[name="lcGrpCont.grpContNo"]:checked').val()){  
		alert("请选择一条投保单记录！"); 
		return false; 
	}
	var grpContNo=$('input:radio[name="lcGrpCont.grpContNo"]:checked').val(); 
	var url = ctx + "/prpall/findProsalPreInfoByGrpContNo.do?lcGrpCont.grpContNo="+grpContNo;
	$("#emptyfm").attr("action",url);
	$("#emptyfm").attr("target","fraInterface");
	$("#emptyfm").submit();	
	
}

//ProposalPreInput.jsp中的记事本查看按钮
function findNoteInfo(){
	var url =contextRootPath + "/prpall/findNoteInfo.do";
	var params ={
			"lcNotepad.id.bussinessNo":$("#grpContNo").val(),
			"lcNotepad.inputLocation" :$("#inputLocation").val()
	};
	function CallBack(obj){
		if(obj=="success"){
			window.open(contextRootPath+"/prpall/group/proposalPre/NotepadInputAndQuery.jsp");
	    }
	}
	jQuery.post(url,params,CallBack);
}

//NotepadInputAndQuery.jsp中的新增按钮
function savaNoteInfo(){
	var url = contextRootPath + "/prpall/savaNoteInfo.do";
	var params ={
			"lcNotepad.id. bussinessNo":$("#grpContNo").val(),
			"lcNotepad.inputLocation":$("#flag").val(),
			"lcNotepad.content" :$("#content").val()
	};
	
	function CallBack(obj){
		var date = new Date();
		 date.setTime(obj.data[0].modifyDate.time);
		 var dateStr = date.getUTCFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getUTCDate()+1);
		 var oldInfo=$("#noteInfo").html();
		 var newInfo="<tr class='content' name='aa'>"+
		 "<td><input id='radioRepNo' name='radioRepNo' type='radio' value="+obj.data[0].id.businessNo+"/></td>"+
		 "<td>"+obj.data[0].id.serialNo+"</td>"+
		 "<td>"+obj.data[0].content+"</td>"+
		 "<td>"+obj.data[0].inputLocation+"</td>"+
		 "<td>"+obj.data[0].operator+"</td>"+
		 "<td>"+dateStr+"</td>"+
		 "<td>"+obj.data[0].modifyTime+"</td>"+
        "</tr>";
		 oldInfo=oldInfo+newInfo;
		 $("#noteInfo").html(oldInfo);

		
	}
	jQuery.post(url,params,CallBack,"JSON");
}

//ProposalPreInput.jsp中的保存按钮
function saveProposalInfo(){
	
	
	var flag=0;
	var mark=$("#mark").val();
	var grpContNo=$("#grpContNo").val();
	var manageCom=$("#comCode").val();
	var firstTrialDate=$("#FirstApplyDate").val();
	var appntNo=$("#CustomerNo").val();
	var grpName=$("#GrpName").val();
	var handlerName=$("#MainAgentCode").val();
	var grpSellType=$("#codeType").val();
	var Prem=$("#prem").val();
	var reportNo=$("#reportNo").val();
	var previewPrintFlag=$("#IsPrintFlagType").val();	
	var agreementFlagType=$("#AgreementFlagType").val();	
	var string="";
	
	if(firstTrialDate==""){
		string+="|初审日期";
	}
	if(grpName==""){
		string+="|投保单位名称";
	}
	if(handlerName==""){
		string+="|主揽业务员";
	}
	if(grpSellType==""){
		string+="|销售方式";
	}
	
	if(Prem==""){
		string+="|保费合计";
	}
	if(previewPrintFlag==""){
		string+="|预打保单标记";
	}
	
	if(agreementFlagType==""){
		string+="|协议录入标志";
	}
	
	if(string!=""){
		flag=1;
		
		alert("输入有误，可能是如下错误中的一个："+string+"不能为空！");
		
	}
	
	if(flag==0){
	var actionUrl =contextRootPath + "/prpall/saveProposalInfo.do?mark="+mark;
	var actionParams ={
			"lcGrpCont.grpContNo":grpContNo,
			"lcGrpCont.manageCom":manageCom,
			"lcGrpCont.firstTrialDate":firstTrialDate,
			"lcGrpCont.appntNo":appntNo,
			"lcGrpCont.grpName":grpName,
			"lcGrpCont.handlerName":handlerName,
			"lcGrpCont.grpSellType":grpSellType,
			"lcGrpCont.Prem":Prem,
			"lcGrpCont.reportNo":reportNo,
			"lcGrpCont.previewPrintFlag":previewPrintFlag,
			"lcGrpServInfo.id.grpContNo":grpContNo,
			"lcGrpServInfo.id.servKind":"3",//3表示团单初审服务
			"lcGrpServInfo.id.servDetail":agreementFlagType
	};
	function CallBack(obj){
		if(obj=="save"){
			alert("保存成功");
			$("#save").attr('disabled',true);

		}else{
			$("#grpContNo").val(obj);//自动生成的投保单号需要回写在页面上
			alert("保存成功");
			$("#save").attr('disabled',true);
		}
	}
	jQuery.post(actionUrl,actionParams,CallBack);
	}
}
//ProposalPreInput.jsp加载时保存按钮是否可用
function saveButtonIsAble(){
	//如果有投保单号,说明这条数据在数据库中已经保存过了，那么保存按钮不可用，用户只能按修改按钮
	var grpContNo=$("#grpContNo").val();
	
	if(grpContNo!=""){
		$("#save").attr("disabled",true);
	}
	
//如果没有投报单号，记事本查看按钮不可用
	if(grpContNo==""){
		$("#showNotepad").attr("disabled",true);
	}

}


//ProposalPreInput.jsp中的修改按钮
function editProposalInfo(){
	
	var actionUrl =contextRootPath + "/prpall/editProposalInfo.do";
	var actionParams ={
			"lcGrpCont.grpContNo":$("#grpContNo").val(),
			"lcGrpCont.manageCom":$("#comCode").val(),
			"lcGrpCont.firstTrialDate":$("#FirstApplyDate").val(),
			"lcGrpCont.appntNo":$("#CustomerNo").val(),
			"lcGrpCont.grpName":$("#GrpName").val(),
			"lcGrpCont.handlerName":$("#MainAgentCode").val(),
			"lcGrpCont.grpSellType":$("#codeType").val(),
			"lcGrpCont.Prem":$("#prem").val(),
			"lcGrpCont.reportNo":$("#reportNo").val(),
			"lcGrpCont.previewPrintFlag":$("#IsPrintFlagType").val(),
			"lcGrpServInfo.id.grpContNo":$("#grpContNo").val(),
			"lcGrpServInfo.id.servKind":"3",//3表示团单初审服务
			"lcGrpServInfo.id.servDetail":$("#AgreementFlagType").val()
	};
	function CallBack(obj){
		if(obj=="success"){
			alert("修改成功");
		} 
		
	}
	jQuery.post(actionUrl,actionParams,CallBack);
	
}
//初审确认按钮
function proposalPreConfirm(){
	var actionUrl =contextRootPath + "/prpall/proposalPreConfirm.do";
	var actionParams ={
			"lcGrpCont.grpContNo":$("#grpContNo").val()
	}
	function CallBack(obj){
		if(obj=="success"){
			var url = ctx + "/prpall/findProsalPreInfo.do";
			$("#fmTem").attr("action",url);
			$("#fmTem").submit();
		}
	}
	
	jQuery.post(actionUrl,actionParams,CallBack);
}



			
			
		
	







	
	
	
	

	
	








		
	
			
			
	
	



