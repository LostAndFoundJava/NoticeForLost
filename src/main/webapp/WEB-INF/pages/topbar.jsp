<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/menu.css">
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<%-- <script src="<%=request.getContextPath() %>/js/jquery.js"></script> --%>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="nav-container container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<a class="navbar-brand" id="bg-white" href="<c:url value="/"/>">OSF</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active" id="bg-gray"><a
					href="<c:url value="/explore" />">探索</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<form class="ui icon input search" id="search-form"
						action="<c:url value="/search/feed" />" method="get">
						<input type="text" placeholder="搜索..." name="term"> <i
							class="circular search link icon" id="search-btn"></i>
					</form>
				</li>
				<c:if test="${not empty sessionScope.user_email}">
					<li>
						<%-- <a href='<c:url value="/user/${sessionScope.user.id }"></c:url>'>${sessionScope.user.user_name }</a> --%>
						<div class="ui simple dropdown item">
							${sessionScope.user.user_name } <i class="dropdown icon"></i>
							<div class="ui vertical menu">
								<a class="item" href="<c:url value="/notifications/comment" />">
									评论
									<div class="ui red label">${notifications.comment }</div>
								</a> <a class="item" href="<c:url value="/notifications/like" />">
									喜欢
									<div class="ui red label">${notifications.like }</div>
								</a> <a class="item" href="<c:url value="/notifications/follow" />">
									关注
									<div class="ui red label">${notifications.follow }</div>
								</a> <a class="item" href="<c:url value="/notifications/system" />">
									系统消息
									<div class="ui red label">${notifications.system }</div>
								</a> <a href='<c:url value="/account/setting/info" />' class="item">设置</a>
								<a href='<c:url value="/account/logout" />' class="item">退出</a>
							</div>
						</div>
					</li>


				</c:if>
				<c:if test="${empty sessionScope.user_email}">
					<li><a href='<c:url value="/account/register"></c:url>'>注册</a></li>
					<li></li>
					<%-- <li><a href='<c:url value="/account/login"></c:url>'>登录</a></li> --%>
					<li>
						<button type="button" class="btn btn-default" class="active"
							id="bg-gray" data-toggle="modal" data-target="#myModal">已有账号？登录</button>
					</li>

				</c:if>
			</ul>


		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->



</nav>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">登录</h4>
			</div>
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<div class="col-sm-12">
						<input type="email" class="form-control" id="email"
							placeholder="Email">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<input type="password" class="form-control" id="password"
							placeholder="Password">
					</div>
				</div>
				<!-- 				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label> <input type="checkbox"> 请记住我
							</label>
						</div>
					</div>
				</div> -->
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-12">
						<button class="btn btn-default" id="loginbtn">登录</button>
					</div>
				</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$("#bg-white").click(function() {
			$("#bg-white").addClass("navbar-brand active");
			$("#bg-gray").removeClass("active");
		});
		$("#bg-gray").click(function() {
			$("#bg-gray").addClass("active");
			$("#bg-white").removeClass("active");
		});
	})
</script>
