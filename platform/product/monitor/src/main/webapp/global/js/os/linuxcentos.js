var osid;
$(function() {
	osid =$("#osid").val();
			refresh();
			setInterval(refresh, 1000 * 10 * 60);
		});

// 基本信息 （完成）
$(function() {
			$.ajax({
						type : "post",
						url : "/monitor/os/osInfo/"+osid,
						dataType : "json",
						cache : false,
						success : function(data) {
							for (var key in data) {
								if (key == 'health') {
									continue;
								}
								$("#" + key).html(data[key]);
							}
						}
					});

		});
function refresh() {
	// 可用性饼图（完成）
	$.ajax({
				type : "post",
				url : "/monitor/os/getUsability/"+osid,
				dataType : "json",
				cache : false,
				success : function(data) {
					var usable = data.usable;
					var unusable = data.unusable;
					var options = {
						chart : {
							renderTo : 'container',
							plotBackgroundColor : null,
							plotBorderWidth : null,
							plotShadow : false
						},
						title : {
							text : ''
						},
						tooltip : {
							formatter : function() {
								return '<b>' + this.point.name + '</b>: '
										+ this.percentage.toFixed(2) + ' %';
							}
						},
						plotOptions : {
							pie : {
								allowPointSelect : true,
								cursor : 'pointer',
								dataLabels : {
									enabled : false
								},
								showInLegend : true
							}
						},
						series : [{
									type : 'pie',
									name : 'Browser share',
									data : [{
												name : '可用',
												y : usable,
												color : "#0f6",
												sliced : false,
												selected : false
											}, {
												name : '不可用',
												y : unusable,
												color : "#f00",
												sliced : false,
												selected : false
											}]
								}]
					};
					// Build the chart
					new Highcharts.Chart(options);
				}
			});
	// cpu,ram,disk使用率表盘（完成）
	$.ajax({
				type : "post",
				url : "/monitor/os/getUtilzation/"+osid,
				dataType : "json",
				cache : false,
				success : function(data) {
					for (var key in data) {
						if (key == "cpuUtilzation") {
							$("#" + key + "1").attr("title",
									"CPU使用率-" + data[key] + " %");
							$("#" + key + "2").html("CPU使用率 - " + data[key]);
						}
						if (key == "ramUtilzation") {
							$("#" + key + "1").attr("title",
									"内存使用率-" + data[key] + " %");
							$("#" + key + "2").html("内存使用率 - " + data[key]);
						}
						if (key == "diskUtilzation") {
							$("#" + key + "1").attr("title",
									"磁盘使用率-" + data[key] + " %");
							$("#" + key + "2").html("磁盘使用率 - " + data[key]);
						}
						var seriesData = [];
						seriesData.push(data[key]);
						var options = {
							chart : {
								renderTo : key,
								type : 'gauge',
								plotBackgroundColor : null,
								plotBackgroundImage : null,
								plotBorderWidth : 0,
								plotShadow : false
							},

							title : {
								text : ''
							},
							credits : {
								text : '',
								href : ''
							},

							pane : {
								startAngle : -150,
								endAngle : 150,
								background : [{
										// backgroundColor:'#ccc' // 默认表盘颜色
										}, {
									backgroundColor : '#222',
									borderWidth : 0,
									outerRadius : '105%',
									innerRadius : '103%'
								}]
							},
							labels : {
								style : {
									color : '#222'
								}
							},

							// the value axis
							yAxis : {
								min : 0,
								max : 100,
								minorTickInterval : 'auto',
								minorTickWidth : 1,
								minorTickLength : 10,
								minorTickPosition : 'inside',
								minorTickColor : '#666',

								tickPixelInterval : 30,
								tickWidth : 2,
								tickPosition : 'inside',
								tickLength : 15,
								tickColor : '#666',
								labels : {
									step : 5, // 步长 *5的数值
									rotation : 'auto'
								},
								title : {
									text : '' // 表盘中央显示数值信息
								},
								plotBands : [{
											from : 0,
											to : 60,
											color : '#55BF3B' // green
										}, {
											from : 60,
											to : 80,
											color : '#DDDF0D' // yellow
										}, {
											from : 80,
											to : 100,
											color : '#DF5353' // red
										}]
							},

							series : [{
										name : '使用率',
										data : seriesData,
										tooltip : {
											valueSuffix : ' %'
										}
									}]

						}
						// Add some life
						new Highcharts.Chart(options);
					}

				}
			});
	// cpu及内存使用率图表（完成）
	$.ajax({
				type : "post",
				url : "/monitor/os/getCpuAndRam/"+osid,
				dataType : "json",
				cache : false,
				success : function(data) {
					var series = [];
					for (var name in data) {
						var categories = [];
						var i = 0, x = [], y = {
							data : []
						};
						while (i < data[name].length) {
							if (i == 0) {
								if (name == "CPU") {
									y.name = 'CPU利用率';
								}
								if (name == "MEM") {
									y.name = '物理内存利用率';

								}
								if (name == "SWAP") {
									y.name = '交换内存利用率';

								}
							}
							categories.push(data[name][i].x);
							if (data[name][i].y==-1) {
								data[name][i].y=null;
							}
							y.data.push(data[name][i].y);
							i += 1;
						}
						series.push(y);
					}

					var options = {
						chart : {
							renderTo : 'CPU_line',
							type : 'line',
							height : 300
						},
						title : {
							text : ''
						},
						subtitle : {
							text : ''
						},
						xAxis : {
							categories : categories
						},
						yAxis : {
							title : {
								text : '值%'
							}

						},
						tooltip : {
							formatter : function() {
								return '<b>' + this.series.name + '</b><br/>'
										+ this.x + ': ' + this.y;
							}
						},
						plotOptions : {
							line : {
								dataLabels : {
									enabled : true
								},
								marker : {
									enabled : false
								}
							}
						},
						credits : {
							text : '',
							href : ''
						},
						series : series
					}
					new Highcharts.Chart(options);
				}
			});
	// 分解cpu利用率图表（完成）
	$.ajax({
				type : "post",
				url : "/monitor/os/getCpuInfo/"+osid,
				dataType : "json",
				cache : false,
				success : function(data) {
					var series = [];
					for (var name in data) {
						var categories = [];
						var i = 0, x = [], y = {
							data : []
						};
						while (i < data[name].length) {
							if (i == 0) {
								if (name == "userTime") {
									y.name = '用户时间(%)';
								}
								if (name == "sysTime") {
									y.name = '系统时间(%) ';

								}
								if (name == "io") {
									y.name = 'I/O等待(%)';
								}
								if (name == "idle") {
									y.name = '空闲时间(%) ';

								}
							}
							categories.push(data[name][i].x);
							if (data[name][i].y==-1) {
								data[name][i].y=null;
							}
							y.data.push(data[name][i].y);
							i += 1;
						}
						series.push(y);
					}

					var options = {
						chart : {
							renderTo : 'CPU_line2',
							type : 'line',
							height : 300
						},
						title : {
							text : ''
						},
						subtitle : {
							text : ''
						},
						xAxis : {
							categories : categories
						},
						yAxis : {
							title : {
								text : '值%'
							}

						},
						tooltip : {
							enabled : false,
							formatter : function() {
								return '<b>' + this.series.name + '</b><br/>'
										+ this.x + ': ' + this.y;
							}
						},
						plotOptions : {
							line : {
								dataLabels : {
									enabled : true
								},
								enableMouseTracking : false,
								marker : {
									enabled : false
								}
							}
						},
						credits : {
							text : '',
							href : ''
						},
						series : series
					}
					new Highcharts.Chart(options);
				}
			});
}
$(function() {
			$("body").layout({
						top : {
							topHeight : 100
						}
					});
			$("#myDesk").height($("#layout_center").height());
			$("#nav").delegate('li', 'mouseover mouseout', navHover);
			$("#nav,#menu").delegate('li', 'click', navClick);
		});
// 物理和交换内存利用率列表
$(function() {
			$("#grid_Memory").Grid({
						type : "post",
						url : "/monitor/os/gridMemory/"+osid,
						dataType : "json",
						height : 'auto',
						colums : [{
									id : '1',
									text : 'Memory Usage',
									name : "name",
									index : '1',
									align : '',
									color : ''
								}, {
									id : '2',
									text : '%',
									name : "utilzation",
									index : '1',
									align : '',
									color : ''
								}, {
									id : '6',
									text : '',
									name : "link",
									index : '1',
									align : '',
									color : ''
								}, {
									id : '3',
									text : 'MB',
									name : "used",
									index : '1',
									align : '',
									color : ''
								}, {
									id : '4',
									text : 'Threshold',
									name : "threshold",
									index : '1',
									align : '',
									color : ''
								}],
						rowNum : 10,
						number : false,
						sorts : false,
						colDisplay : false,
						multiselect : false,
						draggable : false
					});
		})
// cpu使用率列表
$(function() {
			$("#grid_cpu").Grid({
				type:"post",
						url : "/monitor/os/gridCpu/"+osid,
						dataType : "json",
						height : 'auto',
						colums : [{
									id : '1',
									text : 'CPU Usage',
									name : "name",
									index : '1',
									align : '',
									color : ''
								}, {
									id : '2',
									text : '%',
									name : "utilzation",
									index : '1',
									align : '',
									color : ''
								}, {
									id : '6',
									text : '',
									name : "link",
									index : '1',
									align : '',
									color : ''
								}, {
									id : '4',
									text : 'Threshold',
									name : "threshold",
									index : '1',
									align : '',
									color : ''
								}],
						rowNum : 10,
						number : false,
						sorts : false,
						colDisplay : false,
						multiselect : false,
						draggable : false
					});
		})
		
// 分解CPU利用率下面的列表
$(function() {
			$("body").layout({
						top : {
							topHeight : 100
						},
						bottom : {
							bottomHeight : 30
						}
					});
			$("#grid_cpudo").Grid({
				type:"post",
						url : "/monitor/os/gridCpuResolve/"+osid,
						dataType : "json",
						colDisplay : false,
						clickSelect : true,
						draggable : false,
						height : "auto",
						colums : [{
									id : '1',
									text : '参数名称',
									name : "name",
									index : '1',
									align : ''
								}, {
									id : '2',
									text : '当前值',
									name : "value",
									index : '1',
									align : ''
								}, {
									id : '3',
									text : '状态',
									name : "stuts",
									index : '1',
									align : ''
								}, {
									id : '4',
									text : '',
									name : "link",
									index : '1',
									align : ''
								}],
						rowNum : 9999,
						pager : false,
						number : false,
						sorts : false,
						multiselect : false

					});
			
			$("#cipan_space_detail").Grid({
						url : "linux-cipan.json",
						dataType : "json",
						height : 'auto',
						colums : [{
									id : '1',
									text : '磁盘',
									name : "methodName",
									width : '',
									index : '1',
									align : '',
									color : ''
								}, {
									id : '1',
									text : '',
									name : "methodName",
									width : '300',
									index : '1',
									align : '',
									color : ''
								}, {
									id : '2',
									text : '磁盘总空间',
									name : "maxTime",
									width : '',
									index : '1',
									align : '',
									color : ''
								}, {
									id : '3',
									text : '已用%',
									name : "minTime",
									width : '',
									index : '1',
									align : '',
									color : ''
								}, {
									id : '4',
									text : '已用 (MB) ',
									name : "avgTime",
									width : '',
									index : '1',
									align : '',
									color : ''
								}, {
									id : '5',
									text : '空闲% ',
									name : "status",
									width : '',
									index : '1',
									align : '',
									color : ''
								}, {
									id : '6',
									text : '空间(MB) ',
									name : "status",
									width : '',
									index : '1',
									align : '',
									color : ''
								}, {
									id : '7',
									text : ' ',
									name : "status",
									width : '',
									index : '1',
									align : '',
									color : ''
								}, {
									id : '8',
									text : ' ',
									name : "status",
									width : '',
									index : '1',
									align : '',
									color : ''
								}, {
									id : '9',
									text : '配置告警 ',
									name : "status",
									width : '',
									index : '1',
									align : '',
									color : ''
								}],
						rowNum : 10,
						rowList : [10, 20, 30],
						pager : false,
						number : false,
						multiselect : false
					});
			$("#tabs").tabs({
						closeTab : false
					});
			$("#myDesk").height($("#layout_center").height());
			$("#nav").delegate('li', 'mouseover mouseout', navHover);
			$("#nav,#menu").delegate('li', 'click', navClick);
		});
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
function viewWindow(e,url) {
	alert(url);
	alert(osid);
	var rows = $(e).parent().parent();
	var id = rows.attr('id');
	var name = rows.children("td").eq(1).text();
	var title = "历史记录: " + name;
	var temWin = $("body").window({
				"id" : "window",
				"title" : title,
				"url" : "/monitor/os/"+url+"/"+osid,
				"hasIFrame" : true,
				"width" : 740,
				"height" : 440,
				"diyButton" : [{
							"id" : "btOne",
							"btClass" : "buttons",
							"value" : "关闭",
							"onclickEvent" : "selectLear",
							"btFun" : function() {
								temWin.closeWin();
							}
						}]
			});
}
