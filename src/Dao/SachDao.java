package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DungChung.CDungChung;
import Bean.SachBean;

public class SachDao {
	Connection cn;
	   public void KetNoi() throws Exception{
		   Class.forName(
				   "com.microsoft.sqlserver.jdbc.SQLServerDriver");
				   cn=DriverManager.getConnection(CDungChung.url,
				   CDungChung.un,CDungChung.pass);
		}
	   public ArrayList<SachBean> getsach() throws Exception{
		   KetNoi();
		   String sql="select * from sach";
		   PreparedStatement cmd = cn.prepareStatement(sql);
		   ResultSet r= cmd.executeQuery();
		   ArrayList<SachBean> ds = new ArrayList<SachBean>();
		   while(r.next()) {
			   String masach = r.getString("masach");
			   String tensach = r.getString("tensach");
			   String tacgia = r.getString("tacgia");
			   long gia = r.getLong("gia");
			   String anh= r.getString("anh");
			   String loai = r.getString("maloai");
			   SachBean s= new SachBean(masach, tensach, tacgia, gia, anh, loai);
			   ds.add(s);
		   }
		   r.close();
		   return ds;
	   }
	   public ArrayList<SachBean> timSachTheoLoai(String loai) throws Exception{
		   KetNoi();
		   String sql= "select * from sach where maloai='"+loai+"'";
		   PreparedStatement cmd = cn.prepareStatement(sql);
		   ResultSet r= cmd.executeQuery();
		   ArrayList<SachBean> ds = new ArrayList<SachBean>();
		   while (r.next()) {
			   String masach = r.getString("masach");
			   String tensach = r.getString("tensach");
			   String tacgia = r.getString("tacgia");
			   long gia = r.getLong("gia");
			   String anh=r.getString("anh");
			   SachBean s = new SachBean(masach, tensach, tacgia, gia, anh, loai);
			   ds.add(s);
		   }
		r.close();
		return ds;
}
public ArrayList<SachBean> timSachTheoTen(String tensach) throws Exception{
	   KetNoi();
	   String sql= "select * from sach where tensach like N'%"+tensach+"%'";
	   System.out.println(sql);
	   PreparedStatement cmd = cn.prepareStatement(sql);
	   ResultSet r= cmd.executeQuery();
	   ArrayList<SachBean> ds = new ArrayList<SachBean>();
	   while (r.next()) {
		   String masach = r.getString("masach");
		   tensach = r.getString("tensach");
		   String tacgia = r.getString("tacgia");
		   long gia = r.getLong("gia");
		   String anh=r.getString("anh");
		   String loai =r.getString("maloai");
		   SachBean s = new SachBean(masach, tensach, tacgia, gia, anh, loai);
		   ds.add(s);
	   }
	r.close();
	return ds;
}
}
