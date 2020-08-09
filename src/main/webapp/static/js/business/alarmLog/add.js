/**
 * 新增-预警日志表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		alarmLog: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../business/alarmLog/save?_' + $.now(),
		    	param: vm.alarmLog,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
