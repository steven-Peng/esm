/**
 * 编辑-预警表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		sensorAlarm: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../business/sensorAlarm/info?_' + $.now(),
		    	param: vm.sensorAlarm.id,
		    	success: function(data) {
		    		vm.sensorAlarm = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../business/sensorAlarm/update?_' + $.now(),
		    	param: vm.sensorAlarm,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})