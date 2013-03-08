var dayColumnStyle = 
	[  
		{id:'0',text:'名称',name:"appellation",index:'1',align:'',width:'100'},
		{id:'1',text:'01',name:"hour1",index:'1',align:''},
		{id:'2',text:'02',name:"hour2",index:'1',align:''},
		{id:'3',text:'03',name:"hour3",index:'1',align:''},
		{id:'4',text:'04',name:"hour4",index:'1',align:''},
		{id:'5',text:'05',name:"hour5",index:'1',align:''},
		{id:'6',text:'06',name:"hour6",index:'1',align:''},
		{id:'7',text:'07',name:"hour7",index:'1',align:''},
		{id:'8',text:'08',name:"hour8",index:'1',align:''},
		{id:'9',text:'09',name:"hour9",index:'1',align:''},
		{id:'10',text:'10',name:"hour10",index:'1',align:''},
		{id:'11',text:'11',name:"hour11",index:'1',align:''},
		{id:'12',text:'11',name:"hour11",index:'1',align:''},
		{id:'13',text:'12',name:"hour12",index:'1',align:''},
		{id:'14',text:'14',name:"hour14",index:'1',align:''},
		{id:'15',text:'15',name:"hour15",index:'1',align:''},
		{id:'16',text:'16',name:"hour16",index:'1',align:''},
		{id:'17',text:'17',name:"hour17",index:'1',align:''},
		{id:'18',text:'18',name:"hour18",index:'1',align:''},
		{id:'19',text:'19',name:"hour19",index:'1',align:''},
		{id:'20',text:'20',name:"hour20",index:'1',align:''},
		{id:'21',text:'21',name:"hour21",index:'1',align:''},
		{id:'22',text:'22',name:"hour22",index:'1',align:''},
		{id:'23',text:'23',name:"hour23",index:'1',align:''},
		{id:'24',text:'24',name:"hour24",index:'1',align:''}
	];


function buildHighchart(_highChart) {
	new Highcharts.Chart({
	    chart: {
	        renderTo: _highChart.renderId,
	        type: 'line',
	        marginRight: 50,
	        marginBottom: 75,
			height:200
	    },
	    title: {
	        text: ' ',
	        x: -20 //center
	    },
	    xAxis: {
	        categories: _highChart.categories
	    },
	    yAxis: {
	        title: {
	            text: '%'
	        },
	        plotLines: false
			},
			plotOptions:{
				series: {
	                marker: {
	                    radius: 0
	                }
	            }
			},
	  credits: { 
	    text: '',
	    href: ''
	  },
	    tooltip: false,
	    legend: {
			enabled :true,
	    },
	    series: _highChart.series
	});
}