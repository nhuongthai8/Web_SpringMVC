<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<h1 style="text-align:center;">Đăng Ký Tài Khoản</h1>
	<br />
	<div class="col-lg-12">
		<div class="row">
			<form:form action="Dangky" modelAttribute="dangkyuser" method="POST">  
				<div class="col-sm-12">
					<div class="form-group">
						<label>Họ và tên</label>
						<form:input type="text" path="HoTen" class="form-control" placeholder="Nhập họ và tên.." autocomplete="off"/>   
					</div>
					<div class="form-group">
						<label>Địa chỉ</label>
						<form:input type="text" path="DiaChi" class="form-control" placeholder="Nhập địa chỉ.." autocomplete="off"/>
					</div>
					<div class="form-group">
						<label>Số điện thoại</label>
						<form:input type="number" path="SDT" class="form-control" placeholder="Nhập số điện thoại.." autocomplete="off"/>
					</div>
					<div class="form-group">
						<label>Email</label>
						<form:input type="text" path="Email" class="form-control" placeholder="Nhập Email.." autocomplete="off"/>
					</div>
					<div class="form-group">
						<label>Tài khoản</label>
						<form:input type="text" path="Username" class="form-control" placeholder="Nhập tài khoản.." autocomplete="off"/>
					</div>
					<div class="form-group">
						<label>Mật khẩu</label>
						<form:input type="password" path="Password" class="form-control" placeholder="Nhập mật khẩu.." autocomplete="off"/>
					</div>
					<button type="submit" class="btn btn-lg btn-info">Đăng ký</button>
				</div>
			</form:form>
		</div>
	</div>
</body>

</html>