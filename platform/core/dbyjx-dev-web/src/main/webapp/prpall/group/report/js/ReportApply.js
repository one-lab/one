//表单提交获取申请中的呈报件
function findApplingReport(){
  var findUrl = ctx + "/prpall/report/findReport";
  $("#fmReportList").attr("action",findUrl).submit();
}

//呈报信息的查询
function findReport() {
	var findUrl = ctx + "/prpall/report/findReport";
	var findParams = {
		"lcReport.repNo" : $("#repNo").val(),
		"lcReport.manageCom" : $("#comCode").val(),
		"lcReport.repApplyDate" : $("#applyDate").val(),
		"ldGrp.grpName" : $("#grpName").val()
	};
	function findCallBack(obj) {
		if (null != obj) {
			$("#content").html("");
			var contentString = "";
			var xuhao = 1;
			var state = "";
			for ( var i = 0; i < obj.data.length; i++) {
				contentString += "<tr class='content' name='aa' id='"+ obj.data[i].repNo + "'>";
				var dateStr = "";
				if (null != obj.data[i].repApplyDate) {
					var date = new Date();
					date.setTime(obj.data[i].repApplyDate.time);
					dateStr = date.getUTCFullYear() + "-"+ (date.getUTCMonth() + 1) + "-"+ (date.getUTCDate() + 1);
				}
				contentString += "<td ><input name='radioRepNo' type='radio' value="+ obj.data[i].repNo	+ " />"+ 
				"<td>"+ xuhao+ "</td>"+
				"<td>"+ obj.data[i].repNo+ "</td>"+ 
				"<td>"+ obj.data[i].manageCom+ "</td>"+ 
				"<td>"+ obj.data[i].repOperator	+ "</td>"+ 
				"<td>"+ dateStr	+ "</td>"+
				"<td>"+ obj.data[i].grpName	+ "</td>"+
				"<td>" + obj.data[i].state + "</td>";
				xuhao++;
				contentString += "</tr>";
			}
			$("#content").html(contentString);
		}
	}
	jQuery.post(findUrl, findParams, findCallBack, 'json');
}

// 呈报申请删除功能实现
// 于文龙
function deleteReport() {
	var deleteUrl = contextRootPath + "/prpall/deleteReport.do";
	var repNo = "";
	if(null==$('input:radio[name="radioRepNo"]:checked').val()
			   ||undefined==$('input:radio[name="radioRepNo"]:checked').val()){
			   alert("请选择一条呈报申请记录进行删除！");
			   return false;
			}
	repNo= $('input:radio[name="radioRepNo"]:checked').val();
	var param = {
		"lcReport.repNo" : repNo
	};
	function deleteReportCallBack(obj) {
		$("#" + obj.lcReport[0].repNo).remove();
		alert("删除成功！");
	}
	if(window.confirm("确定需要删除所选呈报申请记录【呈报申请号："+repNo+"】？")){
		jQuery.post(deleteUrl, param, deleteReportCallBack, "json");
	}
	
}

// 开始录入
// 于文龙
function reportInput() {
	var repNo = "";
	//判断是否选中一条呈报申请记录
	if(null==$('input:radio[name="radioRepNo"]:checked').val()
	   ||undefined==$('input:radio[name="radioRepNo"]:checked').val()){
	   alert("请选择一条呈报申请记录进行录入！");
	   return false;
	}
	repNo = $('input:radio[name="radioRepNo"]:checked').val();
	
	location.href = ctx + "/prpall/report/findReportAllInfo?lcReport.repNo="+ repNo;
}