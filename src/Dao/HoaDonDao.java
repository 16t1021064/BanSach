package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.ws.soap.AddressingFeature;

import Bean.HoaDonBean;
import DungChung.CDungChung;

public class HoaDonDao {

	Connection cn;
	public void KetNoi() throws Exception{
		
		
	
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		cn= DriverManager.getConnection(CDungChung.url, CDungChung.un, CDungChung.pass);
		
	}
	
	public HoaDonBean luuHoaDon(int makh, Date ngayMua, boolean damua) throws Exception {
		
		
		this.KetNoi();
		
		String sql = "insert into hoadon(makh, NgayMua, damua) values(?, ?, ?)";
		
		PreparedStatement stmt = this.cn.prepareStatement(sql);
		
		stmt.setInt(1, makh);
		stmt.setTimestamp(2, new Timestamp( ngayMua.getTime() )); // lay thoi gian tai thoi diem A
		stmt.setBoolean(3, damua);
		
		
		int x = stmt.executeUpdate(); // áp dụng khi insert, update, delete (có khả năng thay đổi dữ liệu)
//		stmt.executeQuery() // áp dụng select,.. (không có khả thay đổi dữ liệu)
		
		if(x > 0) {
			// chen thanh cong
			
			String sql2 = "select * from hoadon where makh=? and NgayMua=? and damua=?";
			PreparedStatement stmt2 = this.cn.prepareStatement(sql2);
			stmt2.setInt(1, makh);
			stmt2.setTimestamp(2, new Timestamp( ngayMua.getTime() )); // lay thoi gian tai thoi diem B
			stmt2.setBoolean(3, damua);
			
			ResultSet rs2 = stmt2.executeQuery();
			
			if(rs2.next()) {
				
				return new HoaDonBean(
						rs2.getInt("MaHoaDon"), 
						makh, 
						new Date( rs2.getDate("NgayMua").getTime() ), // sql.DAte => util.Date
						damua
				);
				
			}else {
				return null;
			}
			
		}else {
			return null;
		}
		

		
	}
	
}
