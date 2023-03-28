<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><strong>DIGI</strong> Shop</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${empty Logininfo}">
					<li><a href="<c:url value="/Dangnhap"/>">Đăng Nhập</a></li>
					<li><a href="<c:url value="/Dangky"/>">Đăng Ký</a></li>
				</c:if>
				<c:if test="${not empty Logininfo}">
					<li><a href="<c:url value="#"/>">Xin chào ${Logininfo.hoTen}</a></li>
					<li><a href="<c:url value="/Dangxuat"/>">Đăng Xuất</a></li>
				</c:if>
					<li><a href="<c:url value="/Giohang"/>">Giỏ Hàng</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>