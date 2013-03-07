$(function(){
	var availabilityChart;
	var healthChart;
    $(document).ready(function() {
        $("body").layout({
            top:{topHeight:100}
        });

        $(".show_all_error").live("click",showAllError);
        $(".hide_some_error").live("click",hideSomeError);

        $("#grid_info_table").Grid({
            url : "service.json",
            dataType: "json",
            height: 'auto',
            colums:[
                {id:'1',text:'url地址',name:"methodName",width:'',index:'1',align:'',color:''},
                {id:'2',text:'最大响应时间',name:"maxTime",width:'',index:'1',align:'',color:''},
                {id:'3',text:'最小响应时间',name:"minTime",width:'',index:'1',align:'',color:''},
                {id:'4',text:'平均响应时间',name:"avgTime",width:'',index:'1',align:'',color:''},
                {id:'5',text:'健康性',name:"status",width:'',index:'1',align:'',color:''}
            ],
            rowNum:10,
            rowList:[10,20,30],
            pager : true,
            number:false,
            multiselect:true,
        });

        availabilityChart = new Highcharts.Chart({
            chart: {
                renderTo: 'pie_availability',
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
                        y: 65,
                        sliced: false,
                        selected: false
                    },
                    ['正常',35]
                ]
            }],
						colors: ['#Ff4f4f', '#5cff5c'] 
        });

        healthChart = new Highcharts.Chart({
            chart: {
                renderTo: 'pie_health',
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
                        y: 45,
                        sliced: false,
                        selected: false
                    },
                    ['正常',55]
                ]
            }],
						colors: ['#Ff4f4f', '#5cff5c'] 
        });
    });
})	