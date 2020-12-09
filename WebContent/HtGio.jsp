<%@page import="Bean.GioHangBean"%>
<%@page import="Bo.GioHangBo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bo.SachBo"%>
<%@page import="Bean.SachBean"%>
<%@page import="Dao.SachDao"%>
<%@page import="Bean.LoaiBean"%>
<%@page import="Bo.LoaiBo"%>
<%@page import="Dao.LoaiDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Nhà Sách Minh Khai</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"">
</style>
</head>
<Body>
	<div class="container">
		<%@include file="TieuDe.jsp"%>
		<div class=row>
			<div class="col-3">
				<ul class="list-group">
					<%
						//lay loai
					LoaiBo lBo = new LoaiBo();
					ArrayList<LoaiBean> dsloai = lBo.getloai();
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
				<h1>Giỏ Hàng</h1>
				<%
					GioHangBo gh = (GioHangBo) session.getAttribute("gh");
				if (gh != null) {
				%>
				<table class="table">
					<tr>
						<th scope="col">Thứ tự</th>
						<th scope="col">Mã sách</th>
						<th scope="col">Tên sách</th>
						<th scope="col">Giá</th>
						<th scope="col">Số lượng</th>
						<th scope="col">Thêm</th>
						<th scope="col">Thành tiền</th>
						<th scope="col"></th>
					</tr>
					<%
						for (GioHangBean g : gh.ds) {
					%>
					<tr>
						<th scope="row">-</th>
						<td><%=g.getMasach()%></td>
						<td><%=g.getTensach()%></td>
						<td><%=g.getGia()%></td>
						<td><%=g.getSoluong()%></td>
						<td>
							<form method="post" action="SuaController?ms=<%=g.getMasach()%>"
								method="post">
								<input type="number" name="txtsl"> <input type="submit"
									name="but2" class="btn btn-primary" value="Cập Nhật">
							</form>
						</td>
						<td>Thành Tiền: <%=g.getThanhtien()%></td>
						<td><div class="btn btn-danger">
								<a href="XoaController?ms=<%=g.getMasach()%>">Xóa</a>
							</div></td>
					</tr>
					<%
						}
					%>
					<td>
						<th scope="row"></th>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>
						<form method="post" action="ThanhToanController" method="post">
							<input type="submit" name="butbuy" class="btn btn-secondary" value="Mua">
						</form>
						</td>
					</td>
					
				</table>
				<%
					}
				%>
				<%
					if (gh != null) {
				%>
				<div align="right">
					Tổng Tiền:
					<%=gh.tongtien()%></div>
				<%
					}
				%>
			</div>
		</div>
	</div>
</Body>
</html>