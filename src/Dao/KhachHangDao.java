package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import Common.DateConversion;
import DungChung.CDungChung;

public class KhachHangDao {
	
	Connection cn;
	public void KetNoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		cn= DriverManager.getConnection(CDungChung.url, CDungChung.un, CDungChung.pass);
	}

	public int timIdKHBoiUsername(String username) throws Exception {
		KetNoi();
		String sql = "select makh from KhachHang where tendn=?";
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setString(1, username);
		ResultSet r= cmd.executeQuery();
		if(r.next()) {
			return r.getInt("makh");
		}else {
			return -1;
		}
	}
	
//	public static void main(String[] args) {
//		
//		Date hientai = new Date();
//		
//		System.out.println(   (new DateConversion("yyyy-MM-dd")).toStringDate(hientai)    );
//		
//		System.out.println(   (new DateConversion("yyyy/MM/dd")).toStringDate(hientai)    );
//		
//		
//		
//		
//	}
	
}
