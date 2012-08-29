/**
 * 呈报审核查询
 */
	function findReportAudit() {
		var findUrl = contextRootPath+ "/prpall/findReportAudit.do";
		var findParams = {
			"lcReport.repNo" : $("#repNo").val(),
			"lcReport.repOperator" : $("#repOperator").val(),
			"lcReport.name" : $("#name").val(),
			"lcReport.manageCom" : $("#manageCom").val(),
			"lcReport.repApplyDate" : $("#reportDate").val()
		};
		function findCallBack(obj) {
			$("#PublicContent").html("");
			var publicContent = "";
			if(null!=obj){
				//共享工作池信息
				if(null!=obj.reportAuditVoList && undefined!=obj.reportAuditVoList){
					for(var i=0;i<obj.reportAuditVoList.length;i++){
						//判断时间
						var dateString="";
						if(null!=obj.reportAuditVoList[i].repApplyDate){
						var date = new Date();
						date.setTime(obj.reportAuditVoList[i].repApplyDate.time);
						dateString = date.getUTCFullYear() + "-"+ (date.getMonth() + 1) + "-" + (date.getDate());
						}
						//审核人判断
						var repAuditOperator = "";
						if (null != obj.reportAuditVoList[i].repAuditOperator) {
							repAuditOperator = obj.reportAuditVoList[i].repAuditOperator;
						}
						
						publicContent += "<tr class='content' id='"+obj.reportAuditVoList[i].repNo+"'>"+
						 "<td><input name='radioRepNo' type='radio' value='"+obj.reportAuditVoList[i].repNo+"'/></td>"+
						 "<td>"	+ (i+1)+ "</td>"+
						 "<td>"	+ obj.reportAuditVoList[i].repNo+ "</td>"+
						 "<td>"	+ obj.reportAuditVoList[i].repOperator+ "</td>"+
						 "<td>"	+ obj.reportAuditVoList[i].manageCom+ "</td>"+
						 "<td>"	+ dateString+ "</td>"+
						 "<td>"	+ obj.reportAuditVoList[i].name+ "</td>"+
						 "<td>"	+ repAuditOperator+ "</td>"+
						 "<td>"	+ obj.reportAuditVoList[i].state + "</td>" +
						 "</tr>";
					}
					$("#PublicContent").html(publicContent);
				}
			}
		}
		jQuery.post(findUrl, findParams, findCallBack,"json");
	}
	/**
	 * 申请按钮
	 */
	function applyReportAduit() {
		
		var repNo="";
		 if(null==$('input:radio[name="radioRepNo"]:checked').val()
				   ||undefined==$('input:radio[name="radioRepNo"]:checked').val()){
				   alert("请选择一条呈报记录进行申请！");
				   return false;
				}
		repNo= $('input:radio[name="radioRepNo"]:checked').val();
		window.location= contextRootPath + "/prpall/applyReportAudit.do?lcReport.repNo="+repNo;
	}
	
	/**
	 * 开始审核
	 */
	function applyReportView(){
		var repNo="";
		  if(null==$('input:radio[name="applyRadio"]:checked').val()
				   ||undefined==$('input:radio[name="applyRadio"]:checked').val()){
				   alert("请选择一条呈报申请记录进行审核！");
				   return false;
				}
		repNo= $('input:radio[name="applyRadio"]:checked').val();
		
		window.location= contextRootPath + "/prpall/applyReportAudit.do?lcReport.repNo="+repNo;
	}
	
	
	//审核确认
	function reportAuditCommit(){
		var commitUrl=contextRootPath+"/prpall/reportAuditCommit.do";
		var repNoValue=$("#repNo").val();
		var result=$("#result").val();
		var idea=$("#idea").val();
		var serialNo=$("#auditSerialNo").val();
		if(null==serialNo){
			alert("请先呈报！");
			return false;
		}
		var commitParam={
				"lcReportAudit.id.repNo":repNoValue,
				"lcReportAudit.id.serialNO":serialNo,
				"lcReportAudit.result":result,
				"lcReportAudit.repauditidea":idea
		};
		function commitCallBack(obj){
			$("#reportInfoBody").html("");
			var content="";
			var xuhao=1;
			for(var i=0;i<obj.data.length;i++){
				var operater="";
				var result="";
				var idea="";
				var dateString="";
				if(null!=obj.data[i].repauditoperator){
					operater=obj.data[i].repauditoperator;
				}
				if(null!=obj.data[i].result){
					result=obj.data[i].result;
				}
				if(null!=obj.data[i].repauditidea){
					idea=obj.data[i].repauditidea;
				}
				if(null!=obj.data[i].modifyDate){
				var date=new Date();
				date.setTime(obj.data[i].modifyDate.time);
				dateString = date.getUTCFullYear() + "-"
						+ (date.getMonth() + 1) + "-" + (date.getDate());
				}
				content+="<tr class='content'>";
				content+="<td>"+xuhao+"</td>"+
				"<td>"+operater+"</td>"+
				"<td>"+result+"</td>"+
				"<td>"+idea+"</td>"+
				"<td>"+dateString+"</td>";
				xuhao++;
				$("#reportInfoBody").html(content);
				$("#result").val("");
				$("#idea").val("");
			}
		}
		jQuery.post(commitUrl, commitParam, commitCallBack, 'json');
	}
	
	//呈报审核初始化
	function initialReportAudit(){
		var initialUrl=contextRootPath+"/prpall/initialReportAudit.do";
		
		function initialCallBack(obj){			
			var selfContent=$("#PrivateContent").html();
		//个人工作池信息
		if(null!=obj.reportList && undefined != obj.reportList){
			
			for(var n=0;n<obj.reportList.length;n++){
				selfContent+="<tr class='content'>"
					+ "<td><input name='applyRadio' type='radio' value='"+obj.reportList[n].repNo+"'/></td>"
					+ "<td>"+ (n+1)	+ "</td>"
					+ "<td>"+ obj.reportList[n].repNo+"</td>"
					+ "<td>"+ obj.reportList[n].repOperator+ "</td>"
					+ "<td>"+ obj.reportList[n].manageCom+ "</td>"
					+ "<td>"+ new Date(obj.reportList[n].repApplyDate.time).format("yyyy-MM-dd");+ "</td>"
					+ "<td>"+ obj.reportList[n].name +"</td>"
					+ "</tr>";
			}
			$("#PrivateContent").html(selfContent);
		}
		}
		jQuery.post(initialUrl,null,initialCallBack,"json");
	}
	
	//发起契调
	function openPrpallSearch(){
		var repNo=$("#repNo").val();
		if(null==repNo){
			alert("呈报信息未载入");
			return false;
		}
		window.location=contextRootPath+"/prpall/openPrpallSearch.do?lcReport.repNo="+repNo;
	}
	//查看契调
	function findPrpallMessage(){
		var repNo=$("#repNo").val();
		if(null==repNo){
			alert("呈报信息未载入");
			return false;
		}
		window.location=contextRootPath+"/prpall/findPrpallMessage.do?lcReport.repNo="+repNo;
	}
	

	/*
	*契调确认
	*/
	function reportConCommit(){
		$.ajax({
			type : "POST",
			url : contextRootPath + "/prpall/reportConCommit.do",
			data : $("#propallSearchForm").serialize(),
			dataType :"json",
			success : function(obj){
				if(obj.msg=="success"){
					alert("契调信息保存成功！");
				}else{
					alert("契调信息保存失败！");
				}
			}
		});
	}
	//契调项目添加按钮“+”
	function addItem(){
		var $table_tr=$("#PrpallSearchInfoBody tr");
		var len=$table_tr.length;
		var content="<tr class='content' id='tr"+len+"'>"+
		"<td width='10%'>"+(len+1)+"</td>"+
		"<td width='10%' class='right'><input class='codecode' id='itemCode"+len+"' name='propallSearchItemList["+len+"].id.itemNo' class='common' type='text' value='' style='width:68%' ondblclick=queryCode('itemCode"+len+"','itemName"+len+"','PDLDcode1','codeType:SearchNo') /><img src='${ctx}/images/bgMarkMustInput.jpg'></td>"+
		"<td width='20%'><input id='itemName"+len+"' name='' class='common' type='text' style='width: 68%' value=''></td>"+
		"<td><input type='button' onclick=removeItem('tr"+len+"') value='-'/></td>"+
		"<td width='37%'>&nbsp;</td>"+"</tr>";
			$("#PrpallSearchInfoBody").append(content);
	}
	function removeItem(p){
		var $table_tr=$("#PrpallSearchInfoBody tr");
		var len=$table_tr.length;
		var index=parseInt(p.substring(2));
		if(index>len){
			return;
		}else{
			for(var temp=index;temp<=len;temp++)
			   {
				if(temp==(len-1)){
					$("#prem"+temp).remove();
				}else{
					$("#itemCode"+temp).val($("#itemCode"+(temp+1)).val());
					$("#itemName"+temp).val($("#itemName"+(temp+1)).val());
				}
			   }	
		}
	}