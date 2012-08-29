//查询已发起调查的调查结论
function findLLInq(val){
	var url = contextRootPath + "/claim/findLLInq.do";
	var param = {
		"clmInqStr" : val
	};
	function callBack(obj){
		if(obj != null){
			//调查结论信息
			if(obj.inqConClusionList.length != 0){
				$("#inqConClusionClmNo").val(obj.inqConClusionList[0].id.clmNo);
				$("#inqConClusionConNo").val(obj.inqConClusionList[0].id.conNo);
				$("#inqConClusionInqDept").val(obj.inqConClusionList[0].inqDept);
				$("#inqConclusionConclusion").val(obj.inqConClusionList[0].inqConclusion);
				$("#inqConclusionremark").val(obj.inqConClusionList[0].remark);
			}
			if(obj.inqApplyList.length != 0){
				//调查申请信息
				var inqApplyContentStr = "";
				inqApplyContentStr += "<tr><td><input type='radio' name='Redio1' value='' /></td>"+
							"<td>1</td>"+
							"<td>"+obj.inqApplyList[0].id.clmNo+"</td>"+
							"<td>"+obj.inqApplyList[0].id.inqNo+"</td>"+
							"<td>"+(obj.inqApplyList[0].customerName==null?"":obj.inqApplyList[0].customerName)+"</td>"+
							"<td>"+(obj.inqApplyList[0].initPhaseValue==null?"":obj.inqApplyList[0].initPhaseValue)+"</td>"+
							"<td>"+(obj.inqApplyList[0].inqRCodeValue==null?"":obj.inqApplyList[0].inqRCodeValue)+"</td>"+
							"</tr>";
				$("#inqApplyContent").html(inqApplyContentStr);
				$("#inqApplyClmNo").val(obj.inqApplyList[0].id.clmNo);
				$("#inqApplyInqNo").val(obj.inqApplyList[0].id.inqNo);
				$("#inqApplyInqStateValue").val(obj.inqApplyList[0].inqStateValue);
				$("#inqApplyCustomerName").val(obj.inqApplyList[0].customerName);
				$("#inqApplyApplyPer").val(obj.inqApplyList[0].applyPer);
				$("#inqApplyApplyDate").val(obj.inqApplyList[0].applyDate==null?"":new Date(obj.inqApplyList[0].applyDate.time).format('yyyy-MM-dd'));
				$("#inqApplyInitPhase").val(obj.inqApplyList[0].initPhase);
				$("#inqApplyInqDept").val(obj.inqApplyList[0].inqDept);
				$("#inqApplyInitDept").val(obj.inqApplyList[0].initDept);
				$("#inqApplyInqRCode").val(obj.inqApplyList[0].inqRCode);
				$("#inqApplyLocFlag").val(obj.inqApplyList[0].locFlag);
				$("#inqApplyInqItem").val(obj.inqApplyList[0].inqItem);
				$("#inqApplyInqDesc").val(obj.inqApplyList[0].inqDesc);
				$("#inqApplyInitPhaseValue").val(obj.inqApplyList[0].initPhaseValue);
				$("#inqApplyInqRCodeValue").val(obj.inqApplyList[0].inqRCodeValue);
				$("#inqApplyInqDeptValue").val(obj.inqApplyList[0].inqDeptValue);
				$("#inqApplyInitDeptValue").val(obj.inqApplyList[0].initDeptValue);
				$("#inqApplyLocFlagValue").val(obj.inqApplyList[0].locFlagValue);
			}
			//调查过程信息
			if(obj.llInqCourseList.length != 0){
				var inqCourseContentStr = "";
				inqCourseContentStr += "<tr><td><input type='radio' name='Redio1' value='' /></td>"+
							"<td>1</td>"+
							"<td>"+obj.llInqCourseList[0].id.couNo+"</td>"+
							"<td>"+(obj.llInqCourseList[0].inqDate==null?"":new Date(obj.llInqCourseList[0].inqDate.time).format('yyyy-MM-dd'))+"</td>"+
							"<td>"+(obj.llInqCourseList[0].inqModeValue==null?"":obj.llInqCourseList[0].inqModeValue)+"</td>"+
							"<td>"+(obj.llInqCourseList[0].inqSite==null?"":obj.llInqCourseList[0].inqSite)+"</td>"+
							"<td>"+(obj.llInqCourseList[0].inqByPer==null?"":obj.llInqCourseList[0].inqByPer)+"</td>"+
							//TODO   hesiqi :调查机构双击域未确定
							"<td>"+(null==obj.llInqCourseList[0].inqDept?"":obj.llInqCourseList[0].inqDept)+"</td>"+
							"<td>"+(obj.llInqCourseList[0].inqPer1==null?"":obj.llInqCourseList[0].inqPer1)+"</td>"+
							"<td>"+obj.llInqCourseList[0].operator+"</td>"+
							"</tr>";
				$("#inqCourseContent").html(inqCourseContentStr);
			}
			//调查过程单证信息
			if(obj.llInqCertificateList.length != 0){
				var inqCertificateContentStr = "";
				var xuhao = 1;
				for(var i = 0; i < obj.llInqCertificateList.length; i++){
					inqCertificateContentStr += "<tr>"+
							"<td>"+(xuhao++)+"</td>"+
							"<td>"+obj.llInqCertificateList[0].id.cerNo+"</td>"+
							"<td>"+(null==obj.llInqCertificateList[0].cerType?"":obj.llInqCertificateList[0].cerType)+"</td>"+
							"<td>"+(null==obj.llInqCertificateList[0].cerName?"":obj.llInqCertificateList[0].cerName)+"</td>"+
							"<td>"+(null==obj.llInqCertificateList[0].oriFlagValue?"":obj.llInqCertificateList[0].oriFlagValue)+"</td>"+
							"<td>"+(null==obj.llInqCertificateList[0].cerCount?"":obj.llInqCertificateList[0].cerCount)+"</td>"+
							"<td>"+(null==obj.llInqCertificateList[0].remark?"":obj.llInqCertificateList[0].remark)+"</td>"+
							"</tr>";
				}
				$("#inqCertificateContent").html(inqCertificateContentStr);
			}
			//调查费用信息
			if(obj.llInqFeeList.length != 0){
				var inqFeeContentStr = "";
				var xuhao = 1;
				for(var i = 0; i < obj.llInqFeeList.length; i++){
					inqFeeContentStr += "<tr>"+
							"<td>"+(xuhao++)+"</td>"+
							"<td>"+obj.llInqFeeList[i].id.clmNo+"</td>"+
							"<td>"+obj.llInqFeeList[i].id.inqNo+"</td>"+
							"<td>"+(obj.llInqFeeList[i].id.inqDeptName==null?"":obj.llInqFeeList[i].id.inqDeptName)+"</td>"+
							"<td>"+(obj.llInqFeeList[i].feeTypeValue==null?"":obj.llInqFeeList[i].feeTypeValue)+"</td>"+
							"<td>"+(obj.llInqFeeList[i].feeSum==null?"":obj.llInqFeeList[i].feeSum)+"</td>"+
							"<td>"+(obj.llInqFeeList[i].feeDate==null?"":new Date(obj.llInqFeeList[i].feeDate.time).format('yyyy-MM-dd'))+"</td>"+
							"<td>"+(obj.llInqFeeList[i].payee==null?"":obj.llInqFeeList[i].payee)+"</td>"+
							"<td>"+(obj.llInqFeeList[i].payeeTypeValue==null?"":obj.llInqFeeList[i].payeeTypeValue)+"</td>"+
							"<td>"+(obj.llInqFeeList[i].remark==null?"":obj.llInqFeeList[i].remark)+"</td>"+
							"</tr>";
				}
				$("#inqFeeContent").html(inqFeeContentStr);
			}
		}
	}
	jQuery.post(url,param,callBack,"json");
}