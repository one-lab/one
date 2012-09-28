//查询投保单信息
	function findGrpContInfo(){
		var findUrl=ctx + "/prpall/findLcGrpContInfo.do";
		$("#writeGrpInfo").attr("action",findUrl).submit();
	}
	
//开始录入
	function WriteStart(){
		//根据 投保单号 查询保单详细信息 路径的变量
		var findGrpContDetailInfo=ctx + "/prpall/findGrpContDetailInfo.do?grpContNo1=";
		var grpContNoTemp = "";
		if(null==$('input:radio[name="radioGrpNo"]:checked').val()
			   ||undefined==$('input:radio[name="radioGrpNo"]:checked').val()){
			   alert("请选择一条投保单信息开始录入！");
			   return false;
			}
		grpContNoTemp= $('input:radio[name="radioGrpNo"]:checked').val();
		$("#writeGrpInfo").attr("action",findGrpContDetailInfo+grpContNoTemp).submit();
	}
	
//初始初审日期＝系统当前日期
/*	$(function(){
		var date=new Date();
		$("#firstTrialDate").val(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate());
	});*/