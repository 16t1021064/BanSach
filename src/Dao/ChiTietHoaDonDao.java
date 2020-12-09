package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DungChung.CDungChung;

public class ChiTietHoaDonDao {
	Connection cn;
	public void KetNoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		cn= DriverManager.getConnection(CDungChung.url, CDungChung.un, CDungChung.pass);
	}

	public void themCTHD(String masach, int soluong, int mahoadon) throws Exception{
		KetNoi();
		String sql = "INSERT INTO ChiTietHoaDon (MaSach, SoLuongMua, MaHoaDon)  VALUES ('"+masach+"', "+soluong+", "+mahoadon+");";
		PreparedStatement cmd = cn.prepareStatement(sql);
		int r= cmd.executeUpdate();
	}

}
