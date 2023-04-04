<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<meta charset="utf-8">
<title>Giỏ hàng</title>
</head>
<body>
	<h2 style="text-align: center;">Giỏ Hàng</h2>
	<div class="row">
		<div class="col-sm-12 col-md-10 col-md-offset-1">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Sản phẩm</th>
						<th>Số lượng</th>
						<th class="text-center">Giá tiền</th>
						<th class="text-center">Tổng cộng</th>
						<th> </th>
						<th> </th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="item" items="${Cart }">
						<tr>
							<td class="col-md-6">
								<div class="media">
									<a class="thumbnail pull-left" href=""> <img
										class="media-object"
										src="<c:url value="/assets/hinhsanpham/${item.value.sanpham.hinhSP}"/>"
										style="width: 72px; height: 72px;">
									</a>
									<div class="media-body">
										<h4 class="media-heading">
											<a href="#"></a>
										</h4>
										<span class="text-warning"><strong>${item.value.sanpham.tenSP}</strong></span>
									</div>
								</div>
							</td>
							<td class="col-md-1" style="text-align: center"><input type="number" min="0" max="1000" id="quanty-cart-${item.key}" placeholder="1" size="16" type="text"
								value="${item.value.soluong}"></td>
							<td class="col-md-1 text-center"><strong>$<fmt:formatNumber type="number"
										maxFractionDigits="3" value="${item.value.sanpham.giaSP}" /></strong></td>
							<td class="col-md-1 text-center"><strong>$<fmt:formatNumber type="number"
										maxFractionDigits="3" value="${item.value.tongGia}" /></strong></td>
							<td class="col-md-1"><a
								href="<c:url value="/DeleteCart/${item.key}"/>"><button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span> Xóa
									</button></a></td>
							<td class="col-md-1"><a><button data-id="${item.key}" type="button" class="btn btn-success edit-cart"><span class="glyphicon glyphicon-play"></span> Sửa
									</button></a></td>
						</tr>
					</c:forEach>
					<tr>
						<td><h3>Tổng sản phẩm</h3> </td>
						<td><h3><strong>${TotalSoLuong}</strong></h3></td>
						<td> </td>
						<td><h3>Tổng giá</h3></td>
						<td class="text-right"><h3>
								<strong>$<fmt:formatNumber type="number"
										maxFractionDigits="3" value="${TotalTongGia}" /></strong>
							</h3></td>
						<td> </td>
					</tr>
					<tr>
						<td> </td>
						<td> </td>
						<td> </td>
						<td>
							<a href="<c:url value="/trangchu"/>" class="btn btn-default glyphicon glyphicon-shopping-cart" role="button">Tiếp tục mua</a>
						</td>
						<td>
							<a href="<c:url value="/Thanhtoan"/>" class="btn btn-success glyphicon glyphicon-play" role="button">Thanh toán</a>
							<a href="<c:url value="/Thanhtoanpaypal"/>" class="btn btn-success glyphicon glyphicon-play" role="button">Thanh toán sử dụng Paypal</a>
						</td>
						<td> </td>
					</tr>


				</tbody>
			</table>
		</div>
	</div>

	<content tag="script"> <script>
		$(".edit-cart").on("click", function() {
			var id = $(this).data("id");
			var quanty = $("#quanty-cart-"+id).val();
			window.location = "EditCart/"+id+"/"+quanty;
		});
	</script> </content>

</body>


