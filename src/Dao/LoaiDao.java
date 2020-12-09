package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DungChung.CDungChung;
import Bean.LoaiBean;

public class LoaiDao {
   Connection cn;
   public void KetNoi() throws Exception{
	   Class.forName(
			   "com.microsoft.sqlserver.jdbc.SQLServerDriver");
			   cn=DriverManager.getConnection(CDungChung.url,
			   CDungChung.un,CDungChung.pass);
	}
   public ArrayList<LoaiBean> getloai() throws Exception{
	   KetNoi();
	   String sql="select * from loai";
	   PreparedStatement cmd = cn.prepareStatement(sql);
	   ResultSet r=cmd.executeQuery();
	   ArrayList<LoaiBean> ds = new ArrayList<LoaiBean>();
	   while (r.next()) {
		   String maloai = r.getString("maloai");
		   String tenloai = r.getString("tenloai");
		   LoaiBean l= new LoaiBean(maloai, tenloai);
		   ds.add(l);
	   }
	   r.close();
	   return ds;
   }
}
