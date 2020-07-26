/**
 * 编辑-设备表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		busiDevice: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../business/device/info?_' + $.now(),
		    	param: vm.busiDevice.id,
		    	success: function(data) {
		    		vm.busiDevice = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../business/device/update?_' + $.now(),
		    	param: vm.busiDevice,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})