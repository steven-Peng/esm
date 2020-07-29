/**
 * 设备传感器上传的数据js
 */

$(function () {
    var search = window.location.href;
    var number = search.split("?")[1];
	initialPage();
	getGrid(number);
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-56});
	});
}

function getGrid(number) {
	$('#dataGrid').bootstrapTableEx({

		url: '../../business/device-sensor-data/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
		    if(number != null && number != ''){
		        params.search = number;
		    }
		    if(vm.keyword != null && vm.keyword != ''){
		        params.search = vm.keyword;
		    }
			return params;
		},
		columns: [
			{checkbox: true},
            {field : "deviceNumber", title : "设备编号", width : "200px"},
            {field : "sensorData", title : "设备传感器上传的数据", width : "600px"},
            {field : "gmtCreate", title : "入库时间", width : "200px"},
            {field : "gmtUpload", title : "上传时间", width : "200px"},
            //{field : "isDelete", title : "是否删除 0:否，1:是", width : "100px"},
            {title : "操作", formatter : function(value, row, index) {
                    var _html = '';
//                    if (hasPermission('business:device-sensor-data:edit')) {
//                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.id+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
//                    }
                    if (hasPermission('business:device-sensor-data:remove')) {
                        _html += '<a href="javascript:;" onclick="vm.remove(false,\''+row.id+'\')" title="删除"><i class="fa fa-trash-o"></i></a>';
                    }
                    return _html;
                }
            }
		]
	})
}

var vm = new Vue({
	el:'#dpLTE',
	data: {
		keyword: null
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增设备传感器上传的数据',
				url: 'ss/data/add.html?_' + $.now(),
				width: '420px',
				height: '350px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function(id) {
            dialogOpen({
                title: '编辑设备传感器上传的数据',
                url: 'ss/data/edit.html?_' + $.now(),
                width: '420px',
                height: '350px',
                success: function(iframeId){
                    top.frames[iframeId].vm.busiDeviceSensorData.id = id;
                    top.frames[iframeId].vm.setForm();
                },
                yes: function(iframeId){
                    top.frames[iframeId].vm.acceptClick();
                }
            });
        },
        remove: function(batch, id) {
            var ids = [];
            if (batch) {
                var ck = $('#dataGrid').bootstrapTable('getSelections');
                if (!checkedArray(ck)) {
                    return false;
                }
                $.each(ck, function(idx, item){
                    ids[idx] = item.id;
                });
            } else {
                ids.push(id);
            }
            $.RemoveForm({
                url: '../../business/device-sensor-data/remove?_' + $.now(),
                param: ids,
                success: function(data) {
                    vm.load();
                }
            });
        }
	}
})