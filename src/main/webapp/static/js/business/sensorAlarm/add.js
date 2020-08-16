/**
 * 新增-预警表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		sensorAlarm: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../business/sensorAlarm/save?_' + $.now(),
		    	param: vm.sensorAlarm,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
