
var chart;
$(document).ready(function() {
    $("body").layout({
        top:{topHeight:100}
    });
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
                text: '访问次数'
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
                    + this.y +'次';
            }
        },
        legend: {
                    enabled :false

        },
        series: [{
            name: '访问次数',
            data: [4,7,9,0,7,1,9]
        }]
    });

    $("#list_table").Grid({
        url : "urlInfo.json",
        dataType: "json",
        height: 'auto',
        colums:[
            {id:'1',text:'方法名称',name:"methodName",width:'400',index:'1',align:'center',color:''},
            {id:'2',text:'最大响应时间',name:"maxTime",width:'',index:'1',align:'center',color:''},
            {id:'3',text:'最小响应时间',name:"minTime",width:'',index:'1',align:'center',color:''},
            {id:'4',text:'平均响应时间',name:"avgTime",width:'',index:'1',align:'center',color:''},
            {id:'5',text:'状态',name:"status",width:'30',index:'1',align:'center',color:''}
        ],
        rowNum:10,
        rowList:[10,20,30],
        pager : true,
        number:false,
        multiselect:false
    });

    $("#event_log_grid").Grid({
        url : "eventLog.json",
        dataType: "json",
        height: 'auto',
        colums:[
            {id:'1',text:'IP',name:"methodName",width:'400',index:'1',align:'',color:''},
            {id:'2',text:'访问者',name:"maxTime",width:'',index:'1',align:'',color:''},
            {id:'3',text:'时间',name:"minTime",width:'',index:'1',align:'',color:''},
            {id:'4',text:'状态',name:"avgTime",width:'',index:'1',align:'',color:''},
            {id:'5',text:'操作',name:"status",width:'',index:'1',align:'',color:''}
        ],
        rowNum:10,
        rowList:[10,20,30],
        pager : true,
        number:false,
        multiselect:false
    });

    $("#tabs").tabs({closeTab:false});
});

function createSevenURLTime() {
    var temWin = $("body").window({
        "id":"testOne11",
        "title":"URL访问次数",
        "url":"sevenDayURLTime.html",
        "hasIFrame":true,
        "width":850,
        "height":440,
        "diyButton":[{
            "id": "btOne",
            "btClass": "buttons",
            "value": "关闭",
            "onclickEvent" : "selectLear",
            "btFun": function() {
                temWin.closeWin();
            }
        }
        ]
    });
}
function createThirtyURLTime() {
    var temWin = $("body").window({
        "id":"testOne10",
        "title":"URL访问次数",
        "url":"thirtyDayURLTime.html",
        "hasIFrame":true,
        "width":850,
        "height":440,
        "diyButton":[{
            "id": "btOne",
            "btClass": "buttons",
            "value": "关闭",
            "onclickEvent" : "selectLear",
            "btFun": function() {
                temWin.closeWin();
            }
        }
        ]
    });
}
function createSevenDayResponseTime() {
    var temWin = $("body").window({
        "id":"testOne9",
        "title":"响应时间",
        "url":"sevenDayResponseTime.html",
        "hasIFrame":true,
        "width":850,
        "height":440,
        "diyButton":[{
            "id": "btOne",
            "btClass": "buttons",
            "value": "关闭",
            "onclickEvent" : "selectLear",
            "btFun": function() {
                temWin.closeWin();
            }
        }
        ]
    });
}
function createThirtyDayResponseTime() {
    var temWin = $("body").window({
        "id":"testOne8",
        "title":"响应时间",
        "url":"thirtyDayResponseTime.html",
        "hasIFrame":true,
        "width":850,
        "height":440,
        "diyButton":[{
            "id": "btOne",
            "btClass": "buttons",
            "value": "关闭",
            "onclickEvent" : "selectLear",
            "btFun": function() {
                temWin.closeWin();
            }
        }
        ]
    });
}