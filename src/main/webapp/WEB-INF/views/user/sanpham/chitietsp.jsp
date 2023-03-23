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
	<h1 style="text-align: center;">Chi Tiết Sản Phẩm</h1>
	<br />
	<form method="get" action="<c:url value="/AddCart/${allsanpham.id}"/>">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">
						<div class="preview-pic tab-content">
							<div class="tab-pane active" id="pic-1">
								<img
									src="<c:url value="/assets/hinhsanpham/${allsanpham.hinhSP}"/>"
									width="100%" />
							</div>
						</div>
					</div>
					<div class="details col-md-6">
						<h3 class="product-title"
							style="color: red; text-transform: uppercase;">
							<b>${allsanpham.tenSP}</b>
						</h3>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>
							<span class="review-no">41 reviews</span>
						</div>
						<br />
						<p class="product-description">${allsanpham.noiDung}</p>
						<br />
						<h4 class="price">
							Giá sản phẩm: <span style="color: red;">$ <b><fmt:formatNumber
										type="number" maxFractionDigits="3"
										value="${allsanpham.giaSP}" /></b></span>
						</h4>
						<p class="vote">
							<strong>91%</strong> of buyers enjoyed this product! <strong>(87
								votes)</strong>
						</p>
						<h4 class="sizes">Nhà phân phối: ${allsanpham.id_npp}</h4>
						<h4 class="sizes">Loại sản phẩm: ${allsanpham.id_lsp}</h4>
						<div class="action">
							<button class="add-to-cart btn btn-default" type="submit">Thêm
								vào giỏ</button>
							<button class="like btn btn-default" type="button">
								<span class="fa fa-heart"></span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>

	<div class="row">
		<div class="col-12">
			<h2 style="text-align: center;">Sản Phẩm Liên Quan</h2>
		</div>
	</div>
	<div class="row">
		<c:forEach var="item" items="${allsanphamrelated}">
			<div class="col-md-4 text-center col-sm-6 col-xs-6">
				<div class="thumbnail product-box">
					<img src="<c:url value="/assets/hinhsanpham/${item.hinhSP}"/>"
						alt="" />
					<div class="caption">
						<h3>
							<a href="#">${item.tenSP}</a>
						</h3>
						<p>
							Price : <strong>$ <fmt:formatNumber type="number"
									maxFractionDigits="3" value="${item.giaSP}" /></strong>
						</p>
						<p>
							<a href="#">Ptional dismiss button </a>
						</p>
						<p>${item.noiDung}</p>
						<p>
							<a href="#" class="btn btn-success" role="button">Thêm vào
								giỏ</a> <a href="${item.id}" class="btn btn-primary" role="button">Chi
								tiết</a>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>