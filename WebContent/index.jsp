<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Index</title>
</head>
<body>
	<form method="post">
		<input type="text" name="name" value="value" />
	</form>
	<button onclick="el()">el</button>
	<button onclick="redirect()">redirect</button>
	<button onclick="ajax()">ajax</button>
</body>
<script>
	let form = document.getElementsByTagName("form")[0];

	function el() {
		form.action = "el";
		form.submit();
	}
	function redirect() {
		form.action = "redirect";
		form.submit();
	}
	function ajax() {
		const jobCode = 'ajax';
		const formData = 'name=value';
		sendAjax(jobCode, formData, 'ajaxCallBack');
	}
	function sendAjax(jobCode, formData, funcName) {
	    const ajax = new XMLHttpRequest();
	    ajax.open('POST', jobCode);
	    ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
	    ajax.send(formData);

	    ajax.onreadystatechange = function () {
	        if (ajax.readyState == ajax.DONE && ajax.status == "200") {
	            window[funcName](ajax.responseText);//3111:Xenoblade:44
	        }
	    }
	}
	function ajaxCallBack(ajaxData) {
		console.log('ajaxCallBack');
		document.write('<h1>' + ajaxData + '</h1>');
	}
</script>
</html>