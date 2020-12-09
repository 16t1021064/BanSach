package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DungChung.CDungChung;

public class DangNhapDao {
	Connection cn;
	public void KetNoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		cn= DriverManager.getConnection(CDungChung.url, CDungChung.un, CDungChung.pass);
	}
	public boolean ktDangNhap(String un, String pass) throws Exception{
		KetNoi();
		String sql = "select * from KhachHang where tendn='"+un+"'and pass= '"+pass+"'";
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r= cmd.executeQuery();
		boolean kq= r.next();
		r.close();
		return kq;
	}
}
