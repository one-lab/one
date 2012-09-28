//集体投保单信息查询
//于文龙
function findGrpContInfo(){
	var findUrl=contextRootPath+"/prpall/findGrpContInfo.do";
	$("#grpContForm").attr("action",findUrl);
	$("#grpContForm").attr("target","fraInterface");
	$("#grpContForm").submit();
}

//集体投保单申请
//于文龙
function applyLcGrpCont(){
	var applyUrl=contextRootPath+"/prpall/applyLcGrpCont.do";
	var grpContNo="";
	if(null==$('input:radio[name="lcGrpContRadio"]:checked').val()
			   ||undefined==$('input:radio[name="lcGrpContRadio"]:checked').val()){
			   alert("请选择一条记录进行申请！");
			   return false;
			}
	
	grpContNo= $('input:radio[name="lcGrpContRadio"]:checked').val();
	$("#"+grpContNo).remove();
	window.location=contextRootPath+"/prpall/auditLcGrpCont.do?lcGrpCont.grpContNo="+grpContNo;
}
//集体投保单复核
//于文龙
function auditLcGrpCont(){
	var grpContNo="";
	if(null==$('input:radio[name="applyRadio"]:checked').val()
			   ||undefined==$('input:radio[name="applyRadio"]:checked').val()){
			   alert("请选择一条记录进行复核！");
			   return false;
			}
	grpContNo= $('input:radio[name="applyRadio"]:checked').val();
	window.location=contextRootPath+"/prpall/auditLcGrpCont.do?lcGrpCont.grpContNo="+grpContNo;
}

//投保单复核初始化
function initialLcGrpContAudit(){
	var url=contextRootPath+"/prpall/initialLcGrpContAudit.do";
	
	function initialAuditCallBack(obj){
		if(null!=obj){
			$("#scanApplycInfoBody").html();
			var content="";
			for(var i=0;i<obj.data.length;i++){
				var dateStr="";
				if(null!=obj.data[i].inputDate){
					var date = new Date();
					date.setTime(obj.data[i].inputDate.time);
					dateStr = date.getUTCFullYear()+"-"+(date.getUTCMonth()+1)+"-"+(date.getUTCDate()+1);
				}
				content+="<tr class='content' id='apply"+obj.data[i].grpContNo+"'>"+
				"<td><input type='radio' name='applyRadio' value='"+obj.data[i].grpContNo+"'/></td>"+
				"<td>"+(i+1)+"</td>"+
				"<td>"+obj.data[i].grpContNo+"</td>"+
				"<td>"+obj.data[i].manageCom+"</td>"+
				"<td>"+dateStr+"</td>"+
				"<td>"+obj.data[i].grpName+"</td>"+
				"</tr>";
			}
			$("#scanApplycInfoBody").html(content);
		}
	}
	
	jQuery.post(url,null,initialAuditCallBack,"json");
}



