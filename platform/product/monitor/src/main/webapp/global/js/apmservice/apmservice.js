$(function () {

    var chart;
    var chart2;
    $(document).ready(function () {
        chart = new Highcharts.Chart({
            chart:{
                renderTo:'pie_availability',
                plotBackgroundColor:null,
                plotBorderWidth:null,
                plotShadow:false
            },
            title:{
                text:''
            },
            credits:{
                text:'',
                href:''
            },
            tooltip:{
                formatter:function () {
                    return '<b>' + this.point.name + '</b>: ' + this.percentage + ' %';
                }
            },
            plotOptions:{
                pie:{
                    allowPointSelect:true,
                    cursor:'pointer',
                    dataLabels:{
                        enabled:false
                    },
                    showInLegend:true
                }
            },
            series:[
                {
                    type:'pie',
                    name:'Browser share',
                    data:[
                        {
                            name:'预警',
                            y:65,
                            sliced:false,
                            selected:false
                        },
                        ['正常', 35]
                    ]
                }
            ],
            colors:['#Ff4f4f', '#5cff5c']
        });


        chart2 = new Highcharts.Chart({
            chart:{
                renderTo:'pie_health',
                plotBackgroundColor:null,
                plotBorderWidth:null,
                plotShadow:false
            },
            title:{
                text:''
            },
            credits:{
                text:'',
                href:''
            },
            tooltip:{
                formatter:function () {
                    return '<b>' + this.point.name + '</b>: ' + this.percentage + ' %';
                }
            },
            plotOptions:{
                pie:{
                    allowPointSelect:true,
                    cursor:'pointer',
                    dataLabels:{
                        enabled:false
                    },
                    showInLegend:true
                }
            },
            series:[
                {
                    type:'pie',
                    name:'Browser share',
                    data:[
                        {
                            name:'预警',
                            y:45,
                            sliced:false,
                            selected:false
                        },
                        ['正常', 55]
                    ]
                }
            ],
            colors:['#Ff4f4f', '#5cff5c']
        });
    });
})	