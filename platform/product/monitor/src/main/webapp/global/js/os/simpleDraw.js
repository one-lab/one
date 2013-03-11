function creatSimpleChart(url, renderTo, text) {
	alert(url);
	$.ajax({
				type : "post",
				url : url,
				dataType : "json",
				cache : false,
				success : function(data) {
					var series = [], categories = [], i = 0;
					for (var name in data) {
						var j = 0, x = [], y = {
							data : []
						};
						while (j < data[name].length) {
							if (j == 0) {
									y.name = name;
							}
							if (i == 0) {
								categories.push(data[name][j].x);
							}
							if (data[name][j].y=="-1") {
								y.data.push(null);
							} 
							if(data[name][j].y!="-1"){
								y.data.push(data[name][j].y);
							}
							
							j += 1;
						}
						series.push(y);
						i += 1;
					}
					new Highcharts.Chart({
								chart : {
									renderTo : renderTo,
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
										text : text
									}

								},
								tooltip : {
									enabled : false,
									formatter : function() {
										return '<b>' + this.series.name
												+ '</b><br/>' + this.x + ': '
												+ this.y;
									}
								},
								plotOptions : {
									line : {
										dataLabels : {
											enabled : true
										},
										connectNulls : true,
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
								series : series,
								colors : ['#00b200', '#0000b2', '#b200b2']
							});
				}
			});
}


