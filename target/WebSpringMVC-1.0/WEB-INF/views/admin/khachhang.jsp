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
<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">Khách Hàng</h1>
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">DataTables
					Example</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Id</th>
								<th>Họ tên</th>
								<th>Địa chỉ</th>
								<th>SĐT</th>
								<th>Email</th>
								<th>Username</th>
								<th>Password</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="kh" items="${list}">
							<tr>
								<td>${kh.id}</td>
								<td>${kh.hoTen}</td>
								<td>${kh.diaChi}</td>
								<td>${kh.SDT}</td>
								<td>${kh.email}</td>
								<td>${kh.username}</td>
								<td>${kh.password}</td>
								<td><a href="" class="btn btn-warning btn-circle btn-sm"><i class="fas fa-exclamation-triangle"></i></a></td>  
								<td><a href="/deleteemp/${kh.id}" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td>  
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
</body>
</html>