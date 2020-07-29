/**
 * 新增-设备传感器上传的数据js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		busiDeviceSensorData: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../business/device-sensor-data/save?_' + $.now(),
		    	param: vm.busiDeviceSensorData,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
