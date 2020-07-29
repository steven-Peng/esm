/**
 * 编辑-设备传感器上传的数据js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		busiDeviceSensorData: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../business/device-sensor-data/info?_' + $.now(),
		    	param: vm.busiDeviceSensorData.id,
		    	success: function(data) {
		    		vm.busiDeviceSensorData = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../business/device-sensor-data/update?_' + $.now(),
		    	param: vm.busiDeviceSensorData,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})