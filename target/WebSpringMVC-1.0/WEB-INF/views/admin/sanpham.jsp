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
		<h1 class="h3 mb-2 text-gray-800">Sản Phẩm</h1>
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
			<a href="#" class="btn btn-primary btn-icon-split"> <span class="icon text-white-50"> <i class="fas fa-flag"></i> </span> <span class="text">Thêm sản phẩm</span> </a>
			</div>
			<div class="card-body">
				
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Id</th>
								<th>Id_LSP</th>
								<th>id_NPP</th>
								<th>Tên</th>
								<th>Hình</th>
								<th>Giá</th>
								<th>Nội Dung</th>
								<th>Highlight</th>
								<th>Detail</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="sp" items="${list}">
							<tr>
								<td>${sp.id}</td>
								<td>${sp.id_lsp}</td>
								<td>${sp.id_npp}</td>
								<td>${sp.tenSP}</td>
								<td>${sp.hinhSP}</td>
								<td>${sp.giaSP}</td>
								<td>${sp.noiDung}</td>
								<td>${sp.highlight}</td>
								<td><a href="" class="btn btn-info btn-circle btn-sm"><i class="fas fa-info-circle"></i></a></td>
								<td><a href="" class="btn btn-warning btn-circle btn-sm"><i class="fas fa-exclamation-triangle"></i></a></td>  
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