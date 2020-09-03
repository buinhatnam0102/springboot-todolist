function redirectEdit(id) {
		window.location.href = "/edit?id=" + id;
	}
	function redirectDetail(id) {
		window.location.href = "/detail?id=" + id;
	}
	function redirectUpdate(id) {
		window.location.href = "/complete?id=" + id;
	}
	function redirectUncomplete(id) {
		window.location.href = "/uncomplete?id=" + id;
	}
	$(document).ready(function() {
		$("#submit").click(function(event) {
			if (!confirm('タスク削除をします。本当	によろしいですか？')) {
				event.preventDefault();
			}

		});
	});
	$(document).ready(function() {
		$("#submit1").click(function(event) {
			if (!confirm('タスク削除をします。本当	によろしいですか？')) {
				event.preventDefault();
			}

		});
	});