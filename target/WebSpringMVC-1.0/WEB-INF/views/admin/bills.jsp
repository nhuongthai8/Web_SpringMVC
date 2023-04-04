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
								<th>Quantity</th>
								<th>Total</th>
								<th>Note</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="bills" items="${list}">
							<tr>
								<td>${bills.id}</td>
								<td>${bills.hoTen}</td>
								<td>${bills.diaChi}</td>
								<td>${bills.SDT}</td>
								<td>${bills.email}</td>
								<td>${bills.username}</td>
								<td>${bills.quanty}</td>
								<td>${bills.total}</td>
								<td>${bills.note}</td>
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