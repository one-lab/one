$(function (){
	var ctree = new dhtmlXTreeObject("taskTree", "100%", "100%", 0);
	ctree.setImagePath(contextRootPath+"/images/dxTree/");
	//tree.setSkin('dhx_skyblue');
	ctree.setChildCalcMode("Child");
	//tree.af(true);
	ctree.setOnClickHandler(findTaskfInfo);
	ctree.loadXML(contextRootPath+"/rms/task/taskTree.do",function(){
			$("#taskTreeLoadImg").css("display","none");
	});
	var tree;
});

function findTaskfInfo(taskId){
	$("#selectParent").css("display","none");
	$("#edditTask").html("");
	$.ajax({
		type: "POST",
		cache:false,
		async:true,
		data:{"task.taskID":taskId},
		url: contextRootPath+ "/rms/task/findTaskInfo.do?" + Math.random(),
		success : function(data){
			$("#taskInfo").html(data);
		}
	});
};


function selectParent(){
	$("#selectParent").html("");
	$("#selectParent").css("display","block");
	var ctree = new dhtmlXTreeObject("selectParent", "100%", "100%", 0);
	ctree.setImagePath(contextRootPath+"/images/dxTree/");
	//tree.setSkin('dhx_skyblue');
	ctree.setChildCalcMode("Child");
	//tree.af(true);
	ctree.setOnClickHandler(getParent);
	ctree.loadXML(contextRootPath+"/rms/task/taskTree.do",function(){
			$("#selectParentLoadImg").css("display","none");
	});
	tree=ctree;
}

function getParent(taskId){
	var taskname=tree.getItemText(taskId);
	$("#parentId").val(""+taskId+"");
	$("#prtId").val(""+taskId+"");
	$("#parentName").val(""+taskname+"");
	$("#prtName").val(""+taskname+"");
	$("#selectParent").css("display","none");
}

function prepAdd(){
	$("#selectParent").css("display","none");
	$("#edditTask").html("");
	$.ajax({
		type: "POST",
		cache:false,
		async:true,
		url: contextRootPath+ "/rms/task/prepareAddTask.do?" + Math.random(),
		success : function(data){
			$("#taskInfo").html(data);
		}
	});
}


function saveTask(){
	$("#addtaskfm").attr("action", contextRootPath + "/rms/task/saveTask.do").submit();
}


function prepUpdata(taskId){
	$.ajax({
		type: "POST",
		cache:false,
		async:true,
		data:{"task.taskID":taskId},
		url: contextRootPath+ "/rms/task/prepareUpdata.do?" + Math.random(),
		success : function(data){
			$("#edditTask").html(data);
		}
	});
}

function updataTask(){
	$("#updataTaskfm").attr("action", contextRootPath + "/rms/task/updataTask.do").submit();
}