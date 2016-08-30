var SongLib = function() {
	return {
		add : function() {
			$("#songId").val("");
			$("#name").val("");
			$("#description").val("");
			$("#formModal .modal-title").text("添加");
			$("#formModal").modal();
		},
		edit : function(id, name, description) {
			$("#songId").val(id);
			$("#name").val(name);
			$("#description").val(description);
			$("#formModal .modal-title").text("编辑");
			$("#formModal").modal();
		},
		remove : function(id) {
			var yes = window.confirm("确定要删除么？");
			if (!yes) {
				return;
			}
			var url = "/admin/meta/song/lib/delete?songId=" + id;
			$.get(url, {}, function(data) {
				if (data.code != 200) {
					alert(data.msg);
					return;
				}
				SongLib.refresh();
			}, "json")
		},
		save : function() {
			var id = $("#songId").val();
			if (!id) {
				SongLib.insert();
			} else {
				SongLib.update();
			}

		},
		refresh : function() {
			$("#basic_data_m3").click();
			$(".modal-backdrop").remove();
		},

		insert : function() {
			var _name = $.trim($("#name").val());
			var _iconUrl = $("#iconUrl").val();
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

			if (!_opernScreenshotUrl) {
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
			}

			// alert("1");
			/*
			 * $("#songForm").attr("action", "/admin/meta/song/lib/add");
			 * $("#songForm").submit(function( event ) { alert( "Handler for
			 * .submit() called." ); event.preventDefault(); });
			 * $("#songForm").submit();
			 */
			// SongLib.refresh();
			var formData = new FormData($("#songForm")[0]);

			$.ajax({
				url : '/admin/meta/song/lib/add',
				type : 'POST',
				data : formData,
				async : false,
				cache : false,
				contentType : false,
				processData : false,
				success : function(returndata) {
					SongLib.refresh();
				},
				error : function(returndata) {
					console.log("error");
				}
			});

		},
		update : function() {
			var _name = $.trim($("#name").val());
			if (!_name) {
				alert("名称不能为空")
				return;
			}
			
			var id = $("#songId").val();
			var formData = new FormData($("#songForm")[0]);
			formData.append("songId", id);
			$.ajax({
				url : '/admin/meta/song/lib/update',
				type : 'POST',
				data : formData,
				async : false,
				cache : false,
				contentType : false,
				processData : false,
				success : function(returndata) {
					SongLib.refresh();
				},
				error : function(returndata) {
					console.log("error");
				}
			});

		}
	};
}();