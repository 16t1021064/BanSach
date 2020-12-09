<%@page import="Bo.LoaiBo"%>
<%@page import="Bean.LoaiBean"%>
<%@page import="Bean.SachBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bo.SachBo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Nhà sách Minh Khai</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"">

<link rel="stylesheet" href="/BanSach/style.css">
</head>
<body>

	<div class="container">

		<%@include file="TieuDe.jsp"%>
		<div class="row mt-4">
			<div class="col-3">

				<div class="row">
					<div class="col"></div>
					<div class="col-auto">
						<%@include file="TimKiem.jsp"%>
					</div>
				</div>

				<ul class="list-group">
					<%
						ArrayList<LoaiBean> dsloai = (ArrayList<LoaiBean>) request.getAttribute("lstloai");
					%>
					<%
						for (LoaiBean l : dsloai) {
					%>
					<li class="list-group-item"><a
						href="SachController?ml=<%=l.getMaloai()%>"> <%=l.getTenloai()%></a></li>
					<%
						}
					%>
				</ul>
			</div>
			<div class="col-9">



				<%
					ArrayList<SachBean> ds;
				if (request.getAttribute("lstsach") != null) {
					ds = (ArrayList<SachBean>) request.getAttribute("lstsach");
				} else if (request.getAttribute("lstma") != null) {
					ds = (ArrayList<SachBean>) request.getAttribute("lstma");
				} else
					ds = (ArrayList<SachBean>) request.getAttribute("lsttk");
				%>

				<div class="row">


					<%
						int n = ds.size();
					for (int i = 0; i < n; i++) {
					%>

					<div class="col-lg-4 col-md-6 mb-5">

						<img src="<%=ds.get(i).getAnh()%>"><br>
						<%=ds.get(i).getTensach()%><br>
						<%=ds.get(i).getTacgia()%><br>
						<%=ds.get(i).getGia()%><br> <a
							href="DatMuaController?ms=<%=ds.get(i).getMasach()%>&ts=<%=ds.get(i).getTensach()%>&gia=<%=ds.get(i).getGia()%>"><img
							alt="" src="buynow.jpg"></a>

					</div>

					<%
						}
					%>


				</div>


			</div>
		</div>


		<hr>

	</div>



	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		
		
		

</body>
</html>