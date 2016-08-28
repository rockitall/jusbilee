var SongLib = function() {
	return {
		add : function() {
			$("#songId").val("");
			$("#name").val("");
			$("#description").val("");
			$("#formModal .modal-title").text("添加");
			$("#formModal").modal();
		},
		edit : function(id, name, sortOrder) {
			$("#songStyleId").val(id);
			$("#name").val(name);
			$("#sortOrder").val(sortOrder);
			$("#formModal .modal-title").text("编辑");
			$("#formModal").modal();
		},
		remove : function(id) {
			var yes = window.confirm("确定要删除么？");
			if (!yes) {
				return;
			}
			var url = "/admin/meta/song/style/delete?songStyleId=" + id;
			$.get(url, {}, function(data) {
				if (data.code != 200) {
					alert(data.msg);
					return;
				}
				SongLib.refresh();
			}, "json")
		},
		save : function() {
			var id = $("#songStyleId").val();
			if (!id) {
				SongLib.insert();
			}

		},
		refresh : function() {
			$("#basic_data_m2").click();
			$(".modal-backdrop").remove();
		},

		insert : function() {
			var _name = $.trim($("#name").val());
			var _description = $.trim($("#description").val());
			var _iconUrl = $("#iconUrl");
//			var _iconUrl = $("#songForm").files[0];
			var _opernScreenshotUrl = $("#opernScreenshotUrl").val();
			var _opernUrl = $("#opernUrl").val();
			var _wavPlayUrl = $("#wavPlayUrl").val();
			var _midiPlayUrl = $("#midiPlayUrl").val();

			if (!_name) {
				alert("名称不能为空")
				return;
			}
			if (!_iconUrl) {
				alert("小图标不能为空")
				return;
			}
			alert(_iconUrl);

			/*if (!_opernScreenshotUrl) {
				alert("乐谱截屏不能为空")
				return;
			}

			if (!_opernUrl) {
				alert("乐谱图不能为空")
				return;
			}
			if (!_wavPlayUrl) {
				alert("wav文件不能为空")
				return;
			}

			if (!_midiPlayUrl) {
				alert("midi文件不能为空")
				return;
			}*/
/*
			var url = "/admin/meta/song/lib/add";
			$.get(url, {
				name : _name,
				description : _description,
				iconUrl : _iconUrl,
				opernScreenshotUrl : _opernScreenshotUrl,
				opernUrl : _opernUrl,
				wavPlayUrl : _wavPlayUrl,
				midiPlayUrl : _midiPlayUrl
			}, function(data) {
				$("#formModal").modal("hide");
				if (data.code != 200) {
					alert(data.msg);
					return;
				}
				SongLib.refresh();
			}, "json")*/
			
		var form = new FormData($('#songForm'));
         $.ajax({
             url:"/admin/meta/song/lib/add",
             type:"post",
             data:form,
             processData:false,
             contentType:false,
             success:function(data){
            	 $("#formModal").modal("hide");
 				if (data.code != 200) {
 					alert(data.msg);
 					return;
 				}
 				SongLib.refresh();
             },
             error:function(e){
                 alert("错误！！");
                 window.clearInterval(timer);
             }
         });        
			
		}
	};
}();