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
		<h1 class="h3 mb-2 text-gray-800">Nhà Phân Phối</h1>
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
			<a href="<c:url value="/quan-tri/nhaphanphoi/addnhaphanphoi"/>" class="btn btn-primary btn-icon-split"> <span class="icon text-white-50"> <i class="fas fa-flag"></i> </span> <span class="text">Thêm nhà phân phối</span> </a>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Id</th>
								<th>Tên nhà phân phối</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="npp" items="${list}">
							<tr>
								<td>${npp.id}</td>
								<td>${npp.tenNPP}</td>
								<td><a href="editnhaphanphoi/${npp.id}" class="btn btn-warning btn-circle btn-sm"><i class="fas fa-exclamation-triangle"></i></a></td>  
								<td><a href="" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td>
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