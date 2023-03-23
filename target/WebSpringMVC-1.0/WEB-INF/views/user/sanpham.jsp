<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Tất cả sản phẩm</title>
</head>
<body>
	<div class="row">
		<c:forEach var="item" items="${allsanpham}">
			<div class="col-md-4 text-center col-sm-6 col-xs-6">
				<div class="thumbnail product-box">
					<img src="<c:url value="/assets/hinhsanpham/${item.hinhSP}"/>" alt="" />
					<div class="caption">
						<h3>
							<a href="#">${item.tenSP}</a>
						</h3>
						<p>
							Price : <strong>$ <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${item.giaSP}" /></strong>
						</p>
						<p>
							<a href="#">Ptional dismiss button </a>
						</p>
						<p>${item.noiDung}</p>
						<p>
							<a href="<c:url value="/AddCart/${item.id}"/>" class="btn btn-success" role="button">Thêm vào giỏ</a>
							<a href="chitietsp/${item.id}" class="btn btn-primary" role="button">Chi tiết</a>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>