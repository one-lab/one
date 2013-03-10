/**
 * 数据库列表视图-列样式
 */
var thresholdColumnStyle = 
	[  
		{id:'1',text:'名称',name:"appellation",index:'1',align:''},
		{id:'2',text:'可用性',name:"appellation",index:'1',align:''},
		{id:'3',text:'健康状态',name:"appellation",index:'1',align:''},
		{id:'4',text:'操作',name:"appellation",index:'1',align:''}
	];


function getForm() {
	 systemMonitorTable("/monitor/os/systemMonitorTable/24hours");
	$.ajax({
		type : "post",
		url : "/monitor/os/performanceList",
		dataType : "json",
		cache : false,
		success : function(data) {
			for (var formName in data) {
				var series = [];
				for (var name in data[formName]) {
					var categories = [];
					var i = 0, x = [], y = {
						data : []
					};
					while (i < data[formName][name].length) {
						if (i == 0) {
							y.name = name;
						}
						categories.push(data[formName][name][i].x);
						y.data.push(data[formName][name][i].y);
						i += 1;
					}
					series.push(y);
				}
				new Highcharts.Chart({
					chart : {
						renderTo : formName,
						type : 'line',
						marginRight : 50,
						marginBottom : 75,
						height : 200
					},
					title : {
						text : ' ',
					x : -20
					// center
					},
					xAxis : {
						categories : categories
					},
					yAxis : {
						title : {
							text : '%'
						},
						plotLines : false
					},
					plotOptions : {
						series : {
							marker : {
								radius : 0
							}
						}
					},
					credits : {
						text : '',
					href : ''
					},
					tooltip : {
						formatter : function() {
							return this.y + "%";
							}
						},
						legend : {
							enabled : true
						},
						series : series
				});
			}
		}
	});
	healthGrid("/monitor/os/healthList/24hours");

	$("#thresholdList").Grid({
		url :  rootPath + "/os/systemList",  
		dataType: "json",
		colDisplay: false,  
		clickSelect: true,
		draggable:false,
		height: "auto",  
		colums: thresholdColumnStyle,  
		rowNum:9999,
		pager : false,
		number:false,  
		multiselect: true  
	});
}

function healthGrid(url) {
	$("#healthList").empty();
	$("#healthList").Grid({
				url : url,
				dataType : "json",
				colDisplay : false,
				clickSelect : true,
				draggable : false,
				height : 'auto',
				colums : [{	id : '1', text : '名称',
							name : "appellation",
							index : '1',
							align : '',
							width : '100'
						}, {
							id : '2',
							text : '01',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '3',
							text : '02',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '4',
							text : '03',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '5',
							text : '04',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '6',
							text : '05',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '7',
							text : '06',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '8',
							text : '07',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '9',
							text : '08',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '10',
							text : '09',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '11',
							text : '10',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '12',
							text : '11',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '13',
							text : '12',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '14',
							text : '13',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '16',
							text : '15',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '17',
							text : '16',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '19',
							text : '18',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '20',
							text : '19',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '21',
							text : '20',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '22',
							text : '21',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '23',
							text : '22',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '24',
							text : '23',
							name : "appellation",
							index : '1',
							align : ''
						}, {
							id : '25',
							text : '24',
							name : "appellation",
							index : '1',
							align : ''
						}],
				rowNum : 9999,
				pager : false,
				number : false,
				multiselect : false
			});
}
function systemMonitorTable(url) {
	$.ajax({
			type : "post",
			url : url,
			dataType : "html",
			cache : false,
			success : function(data) {
				$("#systemMonitorTable").html(data);
			}
	});
}

function healthChange(ele) {
	if ($(ele).val() == '24hours') {
		healthGrid("/monitor/os/healthList/24hours");
	}
	if ($(ele).val() == '30days') {
		healthGrid("/monitor/os/healthList/30days");
	}
}
//点击可用性下拉
function availableChange(ele) {
	if ($(ele).val() == '24hours') {
		alert(24)
		systemMonitorTable("/monitor/os/systemMonitorTable/24hours");
	}
	if ($(ele).val() == '30days') {
		alert(30)
		availableList("/monitor/os/systemMonitorTable/30days");
	}
}
function navHover() {
	$(this).toggleClass("hover")
}
function navClick() {
	$(this).addClass("seleck").siblings().removeClass("seleck");
	if ($(this).hasClass('has_sub')) {
		var subMav = $(this).children("ul.add_sub_menu");
		var isAdd = false;
		if ($(this).parent().attr("id") == "menu") {
			isAdd = true;
		};
		subMav.slideDown('fast', function() {
			$(document).bind('click', {
						dom : subMav,
						add : isAdd
					}, hideNav);
			return false;
		});
	};
}
function hideNav(e) {
	var subMenu = e.data.dom;
	var isAdd = e.data.add;
	subMenu.slideUp('fast', function() {
		if (isAdd) {
			subMenu.parent().removeClass('seleck');
		};
	});
	$(document).unbind();
}

/**
 * 删除一条记录
 * @param e
 */
function delRow(e){
	var rows = $(e).parent().parent();
	var rowId = rows.attr('id');
	msgConfirm('系统消息','确定要删除该条记录吗？',function(){
		$.ajax({
			url: rootPath+"/os/remove",
			type: "get",
			dataType: "json",
			data: {"monitorIds":rowId.split('_')[1]},
			success: function(msg) {
				if(msg.result) {
					msgSuccess("系统消息", "操作成功，记录已删除！");
					rows.remove();
				}
			}
		});
	});
}

/**
 * 批量删除记录
 */
function batchDel(){
	var $g = $("#thresholdList div.grid_view > table");
	var selecteds = $("td.multiple :checked",$g);
	if(selecteds.length > 0){
		msgConfirm('系统消息','确定要删除该条记录吗？',function(){
			var checks = [];
			var monitorIds = [];
			selecteds.each(function(){
				var rows = $(this).parent().parent();
				var rowId = rows.attr('id');
				monitorIds.push(rowId.split('_')[1]);
				checks.push(rows);
			});
			$.ajax({
				url: rootPath+"/os/remove",
				type: "get",
				dataType: "json",
				data: {"monitorIds":monitorIds.toString()},
				success: function(msg) {
					if(msg.result) {
						$(checks).each(function(i,d){
							$(this).remove();
						});
						msgSuccess("系统消息", "操作成功，记录已删除！");
					}
				}
			});
		});
	}else{
		msgAlert('系统消息','没有选中的记录！<br />请选择要删除的记录后，继续操作。')
	};
}
setInterval(getForm, 1000 * 10 * 60);