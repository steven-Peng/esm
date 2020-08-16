$(function () {
    var search = window.location.href;
    var number = search.split("?")[1];
	//initialPage();
	 let dom =  document.getElementById('myChart');
          $("#myChart").css({'width': '1000px','height':'400px'});
     let resizeMainContainer = function () {
           dom.style.width = window.innerWidth+'px';
           dom.style.height = window.innerHeight*0.8+'px';
      };
      resizeMainContainer();
	getChart(number,myChart);
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-56});
	});
}
function getChart(number,myChart){
  $('#myChart').width($('#myChart').width());
  $('#myChart').height($('#myChart').height());
  var myChart = echarts.init(document.getElementById('myChart'),'light');
  $.AjaxForm({
      url: '../../rest/testData?_' + $.now(),
      param: {'deviceNumber':number},
      success: function(data) {
      var rows = data.rows;
      let legend = new Array();
      let xData = new Array();
      let series = new Array;
      for(let i=0;i<rows.length;i++){
         legend[i] = rows[i].sensorNum;
         xData = rows[i].collectTime;
         let obj ={
           name:rows[i].sensorNum,
           type:'line',
           data:rows[i].data
         };
         series.push(obj);
      }
       var option = {
               title: {
                   text: '传感器历史数据'
               },
               tooltip: {},
               legend: {
                   data:legend
               },
               xAxis: {
                   data: xData
               },
               yAxis: {},
               series:series
           };
            myChart.setOption(option);
      }
  })

}