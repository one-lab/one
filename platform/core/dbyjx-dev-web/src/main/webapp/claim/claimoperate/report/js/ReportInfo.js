//检查报案人与出险人关系 如果为GX01-本人，则将报案人姓名由系统自动带出【出险人查询】中的出险人姓名
function sonCallbackFather(){
	if("GX01" == $("#relation").val()){
		$("#rptorName").val($("#customerName").val());
	}else{
		$("#rptorName").val("");
	}
}
//出险人查询
function findAppnt(){
	var url= contextRootPath + "/claim/claimoperate/report/appntFrame.jsp";
	var w=(screen.availWidth-1000)/2; 
    var h=(screen.availHeight-500)/2;
    window.showModalDialog(url,window,"dialogHide:yes;help:no;status:no;scroll:yes;dialogWidth:1000px;dialogHeight:500px,dialogLeft:"+w+",dialogTop:"+h);
}