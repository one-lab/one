/*Highcharts.setOptions({
	global : {
		useUTC : false
	}
});*/
function creatSimpleChart(url, renderTo, text) {
	$.ajax({
				type : "post",
				url : url,
				dataType : "json",
				cache : false,
				success : function(data) {
					var seriesArr = [];
					for (var name in data) {
						var series={};
						series.name=name;
						series.data=data[name];
						seriesArr.push(series);
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
									type: 'datetime',
					                dateTimeLabelFormats: { // don't display the dummy year
					                    second: '%Y-%m-%d<br/>%H:%M:%S',
					                    minute: '%Y-%m-%d<br/>%H:%M',
					                    hour: '%Y-%m-%d<br/>%H:%M',
					                    day: '%Y<br/>%m-%d',
					                    week: '%Y<br/>%m-%d',
					                    month: '%Y-%m',
					                    year: '%Y'
					           }
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
								
								series : seriesArr,
								colors : ['#00b200', '#0000b2', '#b200b2']
							});
				
				}
			});
}


