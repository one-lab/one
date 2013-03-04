$(function(){
  //右上饼状图
		var chart,chart2,chart3,chart4,chart5,chart6,chart7,chart8;
    $(document).ready(function() {
       chart = new Highcharts.Chart({
            chart: {
                renderTo: 'day_available',
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: ''
            },
						credits: { 
							text: '',
							href: ''
						},
            tooltip: {
                formatter: function() {
                    return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
                }
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: false
                    },
                    showInLegend: true
                }
            },
            series: [{
                type: 'pie',
                name: 'Browser share',
                data: [
                    {
                        name: '预警',
                        y: 1,
                        sliced: false,
                        selected: false
                    },
                    ['正常',99]
                ]
            }],
						colors: ['#Ff4f4f', '#5cff5c'] 
        });
  
//第二排左边 曲线图

   
        chart2 = new Highcharts.Chart({
            chart: {
                renderTo: 'last_onehour',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            title: {
                text: '时间',
                x: -20 //center
            },
            xAxis: {
                categories: ['00:00', '01:00', '02:00', '03:00', '04:00', '05:00','06:00']
            },
            yAxis: {
                title: {
                    text: '连接时间(ms)'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
						plotOptions:{
							line:{              // 数据点的点击事件
								events:{
										click: function(event){
												alert('The bar was clicked, and you can add any other functions.');
										}
								},
									  marker:{  
											enabled:false
										}
							}
						},
          credits: { 
            text: '',
            href: ''
          },
            tooltip: {
                formatter: function() {
                        return '<b>'+ this.series.name +'</b><br/>'+
                        + this.y +'次';
                }
            },
            legend: {
								enabled :false,
               
            },
            series: [{
                name: '访问次数',
                data: [4,7,9,0,7,1,9]
            }]
        });
   
  //第二排右边 曲线图

   
        chart3 = new Highcharts.Chart({
            chart: {
                renderTo: 'user_last_onehour',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            title: {
                text: '时间',
                x: -20 //center
            },
            xAxis: {
                categories: ['00:00', '01:00', '02:00', '03:00', '04:00', '05:00','06:00']
            },
            yAxis: {
                title: {
                    text: '连接时间(ms)'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
						plotOptions:{
							line:{              // 数据点的点击事件
								events:{
										click: function(event){
												alert('The bar was clicked, and you can add any other functions.');
										}
								},
									  marker:{  
											enabled:false
										}
							}
						},
          credits: { 
            text: '',
            href: ''
          },
            tooltip: {
                formatter: function() {
                        return '<b>'+ this.series.name +'</b><br/>'+
                        + this.y +'次';
                }
            },
            legend: {
								enabled :false,
               
            },
            series: [{
                name: '访问次数',
                data: [4,7,9,0,7,1,9]
            }]
        });
		
		//右下饼状图
		 chart4 = new Highcharts.Chart({
            chart: {
                renderTo: 'share_sga',
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: ''
            },
						credits: { 
							text: '',
							href: ''
						},
            tooltip: {
                formatter: function() {
                    return '<b>'+ this.point.name +'</b>: '+ this.y +'MB';
                }
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
												formatter: function() {
                            return this.y +' MB';
                        }
                    },
                    showInLegend: true
                }
            },
            series: [{
                type: 'pie',
                name: 'Browser share',
                data: [
                    {
                        name: '缓存存储器大小',
                        y: 392,
                        sliced: false,
                        selected: false
                    },
                    ['共享池大小',113],
										['重做日志缓冲器大小',199],
										['库存存储器大小',199],
										['数据字典存储器大小',299],
										['sql区域大小',399],
										['固定区域大小',499],
										['重做日志缓冲器大小',699]
                ]
            }],
						colors: ['#5cdfff', '#ff9900','#8b008b','#2f4f4f','#ff5555','#5555ff','#55ff55'] 
        });
//cpu使用率
		 chart5 = new Highcharts.Chart({
	
	    chart: {
	        renderTo: 'use_cpu',
	        type: 'gauge',
	        plotBackgroundColor: null,
	        plotBackgroundImage: null,
	        plotBorderWidth: 0,
	        plotShadow: false,
					height:250,
					events:{
						click:function(e){
								createHistoryCPU(this);
							}
						}
	    },
	    
	    title: {
	        text: 'CPU使用率检测'
	    },
		credits: { 
			text: '',
			href: ''
		},
	    pane: {
	        startAngle: -150,
	        endAngle: 150,
	        background: [{
	           //backgroundColor:'#ccc' // 默认表盘颜色
	        }, {
	            backgroundColor: '#222',
	            borderWidth: 0,
	            outerRadius: '105%',
	            innerRadius: '103%'
	        }]
	    },
			labels:{
					style:{
							color:'#222'
						}
				},
	       
	    // the value axis
	    yAxis: {
	        min: 0,
	        max: 100,
	        minorTickInterval: 'auto',
	        minorTickWidth: 1,
	        minorTickLength: 10,
	        minorTickPosition: 'inside',
	        minorTickColor: '#666',
	
	        tickPixelInterval: 30,
	        tickWidth: 2,
	        tickPosition: 'inside',
	        tickLength: 15,
	        tickColor: '#666',
	        labels: {
	            step: 5, //步长 *5的数值
	            rotation: 'auto',
	        },
	        title: {
	            text: '百分比' //表盘中央显示数值信息
	        },
	        plotBands: [{
	            from: 0,
	            to: 60,
	            color: '#55BF3B' // green
	        }, {
	            from: 60,
	            to: 80,
	            color: '#DDDF0D' // yellow
	        }, {
	            from: 80,
	            to: 100,
	            color: '#DF5353' // red
	        }]        
	    }, 
	    series: [{
	        name: '使用率',
	        data: [0],
	        tooltip: {
	            valueSuffix: ' %'
	        }
	    }]
		});
//内存使用率
 chart6 = new Highcharts.Chart({
	
	    chart: {
	        renderTo: 'use_memory',
	        type: 'gauge',
	        plotBackgroundColor: null,
	        plotBackgroundImage: null,
	        plotBorderWidth: 0,
	        plotShadow: false,
					height:250,
					events:{
						click:function(e){
								createHistoryMemory(this);
							}
						}
	    },
	    
	    title: {
	        text: '内存使用率检测'
	    },
		credits: { 
			text: '',
			href: ''
		},
	    
	    pane: {
	        startAngle: -150,
	        endAngle: 150,
	        background: [{
	           //backgroundColor:'#ccc' // 默认表盘颜色
	        }, {
	            backgroundColor: '#222',
	            borderWidth: 0,
	            outerRadius: '105%',
	            innerRadius: '103%'
	        }]
	    },
			labels:{
					style:{
							color:'#222'
						}
				},
	       
	    // the value axis
	    yAxis: {
	        min: 0,
	        max: 100,
	        minorTickInterval: 'auto',
	        minorTickWidth: 1,
	        minorTickLength: 10,
	        minorTickPosition: 'inside',
	        minorTickColor: '#666',
	
	        tickPixelInterval: 30,
	        tickWidth: 2,
	        tickPosition: 'inside',
	        tickLength: 15,
	        tickColor: '#666',
	        labels: {
	            step: 5, //步长 *5的数值
	            rotation: 'auto',
	        },
	        title: {
	            text: '百分比' //表盘中央显示数值信息
	        },
	        plotBands: [{
	            from: 0,
	            to: 60,
	            color: '#55BF3B' // green
	        }, {
	            from: 60,
	            to: 80,
	            color: '#DDDF0D' // yellow
	        }, {
	            from: 80,
	            to: 100,
	            color: '#DF5353' // red
	        }]        
	    },
	
	    series: [{
	        name: '使用率',
	        data: [0],
	        tooltip: {
	            valueSuffix: ' %'
	        }
	    }]
		});
//硬盘使用率		
		 chart7 = new Highcharts.Chart({
	
	    chart: {
	        renderTo: 'use_disk',
	        type: 'gauge',
	        plotBackgroundColor: null,
	        plotBackgroundImage: null,
	        plotBorderWidth: 0,
	        plotShadow: false,
					height:250,
					events:{
						click:function(e){
								createHistoryDisk(this);
							}
						}
	    },
	    
	    title: {
	        text: '硬盘使用率检测'
	    },
		credits: { 
			text: '',
			href: ''
		},
	    
	    pane: {
	        startAngle: -150,
	        endAngle: 150,
	        background: [{
	           //backgroundColor:'#ccc' // 默认表盘颜色
	        }, {
	            backgroundColor: '#222',
	            borderWidth: 0,
	            outerRadius: '105%',
	            innerRadius: '103%'
	        }]
	    },
			labels:{
					style:{
							color:'#222'
						}
				},
	       
	    // the value axis
	    yAxis: {
	        min: 0,
	        max: 100,
	        minorTickInterval: 'auto',
	        minorTickWidth: 1,
	        minorTickLength: 10,
	        minorTickPosition: 'inside',
	        minorTickColor: '#666',
	
	        tickPixelInterval: 30,
	        tickWidth: 2,
	        tickPosition: 'inside',
	        tickLength: 15,
	        tickColor: '#666',
	        labels: {
	            step: 5, //步长 *5的数值
	            rotation: 'auto',
	        },
	        title: {
	            text: '百分比' //表盘中央显示数值信息
	        },
	        plotBands: [{
	            from: 0,
	            to: 60,
	            color: '#55BF3B' // green
	        }, {
	            from: 60,
	            to: 80,
	            color: '#DDDF0D' // yellow
	        }, {
	            from: 80,
	            to: 100,
	            color: '#DF5353' // red
	        }]        
	    },
	
	    series: [{
	        name: '使用率',
	        data: [0],
	        tooltip: {
	            valueSuffix: ' %'
	        }
	    }]
		});
//sag 曲线图
			 chart8 = new Highcharts.Chart({
            chart: {
                renderTo: 'sga_target',
                type: 'line',
								height:300
            },
            title: {
                text: ''
            },
            subtitle: {
                text: ''
            },
            xAxis: {
                categories: ['08:20', '08:21', '08:22', '08:23', '08:24', '08:25', '08:26']
            },
            yAxis: {
                title: {
                    text: '值%'
                }
								
									
            },
            tooltip: {
                enabled: false,
                formatter: function() {
                    return '<b>'+ this.series.name +'</b><br/>'+
                        this.x +': '+ this.y ;
                }
            },
            plotOptions: {
                line: {
                    dataLabels: {
                        enabled: true
                    },
                    enableMouseTracking: false,
									  marker:{  
											enabled:false
										}
                }
            },
						credits: { 
							text: '',
							href: ''
						},
            series: [{
                name: '缓冲区击中率',
                data: [98, 42, 57, 85, 79, 12, 17]
            },
						{
                name: '数据字典击中率',
                data: [57, 85, 19, 42, 57, 85, 19]
            },
						{
                name: '缓存击中率',
                data: [19, 42, 57, 85, 57, 85, 29]
            }],
						colors: ['#00b200', '#0000b2', '#b200b2'] 
        });
	});
});