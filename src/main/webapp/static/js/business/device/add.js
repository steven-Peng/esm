/**
 * 新增-设备表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		busiDevice: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../business/device/save?_' + $.now(),
		    	param: vm.busiDevice,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
