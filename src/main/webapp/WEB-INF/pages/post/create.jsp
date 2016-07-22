<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>写日志</title>

<script src="<%=request.getContextPath()%>/js/jquery-3.0.0.min.js"></script>
<script src="<%=request.getContextPath()%>/js/post/post.js"></script>
<script src="<%=request.getContextPath() %>/js/code.js"></script>
<script src="<%=request.getContextPath() %>/js/basic.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/semantic.css">

</head>
<body>
	<!-- <input id="fileupload" type="file" name="files[]" data-url="server/php/" multiple> -->

	<div class="ui input">
		<textarea id="content" name="posts" placeholder="写点什么..."></textarea>
	</div>
	<div class="ui button green" id="send">发表</div>
	<div class="ui button" id="cancel">取消</div>
</body>
</html>