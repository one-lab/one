$(function () {
    var chart,chart2;
    $(document).ready(function() {
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'time_times',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            title: {
                text: 'URL访问次数',
                x: -20 //center
            },
            xAxis: {
                categories: ['00:00', '01:00', '02:00', '03:00', '04:00', '05:00','06:00']
            },
            yAxis: {
                title: {
                    text: '访问次数(次)'
                },
                plotLines:[
                    {
                        value:0,
                        width:1,
                        color:'#808080'
                    }
                ]
            },
            plotOptions:{
                line:{              // 数据点的点击事件
                    events:{
                        click:function (event) {
                            alert('The bar was clicked, and you can add any other functions.');
                        }
                    }
                }
            },
            credits:{
                text:'',
                href:''
            },
            tooltip:{
                formatter:function () {
                    return '<b>' + this.series.name + '</b><br/>' +
                        +this.y + '次';
                }
            },
            legend:{
                enabled:false,

            },
            series:[
                {
                    name:'访问次数',
                    data:[4, 7, 9, 0, 7, 1, 9]
                }
            ]
        });
				
				chart2 = new Highcharts.Chart({
            chart: {
                renderTo: 'time_response_time',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            title: {
                text: 'URL响应时',
                x: -20 //center
            },
            xAxis: {
                categories: ['00:00', '01:00', '02:00', '03:00', '04:00', '05:00','06:00']
            },
            yAxis: {
                title: {
                    text: '响应时间(ms)'
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
                        + this.y +'ms';
                }
            },
            legend: {
								enabled :false,
               
            },
            series: [{
                name: '响应时间',
                data: [4,7,9,0,7,1,9]
            }]
        });
    });

});