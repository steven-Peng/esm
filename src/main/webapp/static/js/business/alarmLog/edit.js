/**
 * 编辑-预警日志表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		alarmLog: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../business/alarmLog/info?_' + $.now(),
		    	param: vm.alarmLog.id,
		    	success: function(data) {
		    		vm.alarmLog = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../business/alarmLog/update?_' + $.now(),
		    	param: vm.alarmLog,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})