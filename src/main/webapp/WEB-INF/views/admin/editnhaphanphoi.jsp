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
	<h1 class="h3 mb-2 text-gray-800">Thêm Mới</h1>
	<br/>
	<form:form modelAttribute="npp" method="post" action="editsave" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100" >
		<h4>Tên nhà phân phối</h4>
		<div class="input-group">
			<form:input path="TenNPP" type="text" class="form-control bg-light border-left-secondary small" aria-label="Search" aria-describedby="basic-addon2"/>
		</div>
		<br/>
		<input type="submit" class="btn btn-success btn-icon-split"/> 
	</form:form>
</body>
</html>