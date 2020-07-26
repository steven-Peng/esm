/**
 * 设备表js
 */

$(function () {
	initialPage();
	getGrid();
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-56});
	});
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../business/device/data/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.search = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
            {field : "number", title : "设备编码", width : "200px", align : "center"},
            {field : "name", title : "设备名称", width : "200px",align : "center"},
            {field : "sensorData", title : "传感器数据", width : "500px",align : "center"},
    		{field : "gmtModified", title : "最新时间", align : "center", width : "200px"},
            {field : "gmtCreate", title : "创建时间", align : "center", width : "200px"},
            //{field : "isDelete", title : "是否删除 0:否，1:是", width : "100px"},
            {
    			field : "enable",
    			title : "是否可用",
    			width : "100px",
    			align : "center",
    			formatter : function(value, row, index) {
    				if (value == 0) {
    					return '<i class="fa fa-toggle-off"></i>';
    				}
    				if (value == 1) {
    					return '<i class="fa fa-toggle-on"></i>';
    				}
    			}
    		},
            {
    			field : "status",
    			title : "在线状态",
    			width : "100px",
    			align : "center",
    			formatter : function(value, row, index) {
    				if (value == 0) {
    					return '<i class="fa fa-toggle-off"></i>';
    				}
    				if (value == 1) {
    					return '<i class="fa fa-toggle-on"></i>';
    				}
    			}
    		},
            {title : "操作", align : "center", formatter : function(value, row, index) {
                    var _html = '';
                    if (hasPermission('business:device:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.id+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
                    }
                    if (hasPermission('business:device:remove')) {
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
				title: '新增设备表',
				url: 'business/device/add.html?_' + $.now(),
				width: '420px',
				height: '350px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function(id) {
            dialogOpen({
                title: '编辑设备表',
                url: 'business/device/edit.html?_' + $.now(),
                width: '420px',
                height: '350px',
                success: function(iframeId){
                    top.frames[iframeId].vm.busiDevice.id = id;
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
                url: '../../business/device/remove?_' + $.now(),
                param: ids,
                success: function(data) {
                    vm.load();
                }
            });
        }
	}
})