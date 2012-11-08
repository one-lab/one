<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Sign On</title>
</head>

<body>
	<!-- 显示流程对应的图片 -->
	<img src="../process-images/ComboProcess-image.png"
		style="position: absolute; left: 0px; top: 0px;">
		<!--将活动的节点高亮显示 -->
	<s:div
		style="position: absolute; border: 2px solid red; left: %{#request.x}px; top: %{#request.y}px; width: %{#request.width}px; height: %{#request.height}px;"></s:div>
</body>
</html>