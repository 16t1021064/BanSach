
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"">
</head>
<body>
	<%
		if (session.getAttribute("un") == null || session.getAttribute("un") == "") {
	%>
	<table align="center" width="400">
		<tr>
			<td>
				<form method="post" action="DangNhapController">
					<label> User Name: </label> <input type="text" name="txtun"
						placeholder="Nhập username" class="form-control"><br>
					<label> Password: </label> <input type="password" name="txtpass"
						placeholder="Nhập mật khẩu" class="form-control"> <br>
					<input type="submit" name="tx" value="Dang nhap"
						class="btn-primary">
				</form> <%
 	if (session.getAttribute("un") == "")
 	out.print("Đăng nhập sai");
 } else
 out.print("hi!: " + session.getAttribute("un").toString());
 %> 
			</td>
		</tr>
	</table>

</body>
</html>