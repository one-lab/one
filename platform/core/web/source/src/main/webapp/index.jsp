<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reply Test</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	var contextPath = "<%=request.getContextPath()%>";
	function testReplyStr() {
		$.ajax({
			url : contextPath + "/hello/",
			type : "GET",
			success : function(data) {
				alert(data);
			}
		});
	}
	function testReplyJson() {
		$.ajax({
			url : contextPath + "/hello/",
			type : "POST",
			success : function(data) {
				var str = [];
				for(var key in data) {
					str.push(key + ":" + data[key]);
				}
				alert(str.join(","));
			}
		});
	}
	
	function testReplyJsonExclude() {
		$.ajax({
			url : contextPath + "/hello/exclude",
			type : "GET",
			success : function(data) {
				var str = [];
				for(var key in data) {
					str.push(key + ":" + data[key]);
				}
				alert(str.join(","));
			}
		});
	}
	
	function testReplyJsonInclude() {
		$.ajax({
			url : contextPath + "/hello/include",
			type : "GET",
			success : function(data) {
				var str = [];
				for(var key in data) {
					str.push(key + ":" + data[key]);
				}
				alert(str.join(","));
			}
		});
	}
	
	function testReplyJsonList() {
		$.ajax({
			url : contextPath + "/hello/list",
			type : "GET",
			success : function(datas) {
				var str = [];
				for(var i=0; i<datas.length; i++) {
					var data = datas[i];
					for(var key in data) {
						str.push(key + ":" + data[key]);
					}
				}
				alert(str.join("###"));
			}
		});
	}
	
	function testReplyJsonMap() {
		$.ajax({
			url : contextPath + "/hello/map",
			type : "GET",
			success : function(datas) {
				var str = [];
				for(var key in datas) {
					var s = key + "-";
					var data = datas[key];
					for(var subKey in data) {
						s += subKey + ":" + data[subKey] + ",";
					}
					
					str.push(s);
				}
				alert(str.join("####"));
			}
		});
	}
	
	function testReplyXmlInclude() {
		$.ajax({
			url : contextPath + "/hello/xml/include",
			type : "GET",
			success : function(data) {
				alert(data);
			}
		});
	}
	
	function testReplyXmlExclude() {
		$.ajax({
			url : contextPath + "/hello/xml/exclude",
			type : "GET",
			success : function(data) {
				alert(data);
			}
		});
	}
	
	function testReplyXmlList() {
		$.ajax({
			url : contextPath + "/hello/xml/list",
			type : "GET",
			success : function(data) {
				alert(data);
			}
		});
	}
	
	function testReplyXmlMap() {
		$.ajax({
			url : contextPath + "/hello/xml/map",
			type : "GET",
			success : function(data) {
				alert(data);
			}
		});
	}
</script>
</head>
<body>
	<input type="button" value="testReplyStr" onclick="testReplyStr()"/>
	<input type="button" value="testReplyJson" onclick="testReplyJson()"/>
	<input type="button" value="testReplyJsonExclude" onclick="testReplyJsonExclude()"/>
	<input type="button" value="testReplyJsonInclude" onclick="testReplyJsonInclude()"/>
	<input type="button" value="testReplyJsonList" onclick="testReplyJsonList()"/>
	<input type="button" value="testReplyJsonMap" onclick="testReplyJsonMap()"/>
	<input type="button" value="testReplyXml" onclick="testReplyXml()"/>
	<input type="button" value="testReplyXmlExclude" onclick="testReplyXmlExclude()"/>
	<input type="button" value="testReplyXmlInclude" onclick="testReplyXmlInclude()"/>
	<input type="button" value="testReplyXmlList" onclick="testReplyXmlList()"/>
	<input type="button" value="testReplyXmlMap" onclick="testReplyXmlMap()"/>
</body>
</html>