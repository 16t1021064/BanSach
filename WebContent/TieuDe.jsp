<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body>
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light justify-content-between">
	<a class="navbar-brand" href="SachController"><img width="50px"
		, height="25px" , src="minhkhai-logo.png"></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="SachController">Trang chủ <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="DangNhapController">Đăng Nhập</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Đăng xuất</a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="GioHangController">Giỏ Hàng</a></li>




		</ul>
	</div>


	<%
		String username = (String) session.getAttribute("un");
	if (username != null && !username.equals("")) {
	%><a class="nav-link text-bolder" href="javascript:void(0);">Chào <%=username%></a>
	<%
		}
	%> </nav>
</body>
</html>