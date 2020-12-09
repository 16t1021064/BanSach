package Bo;

import java.util.ArrayList;

import Bean.SachBean;
import Dao.SachDao;

public class SachBo {
   SachDao s =new SachDao();
   public ArrayList<SachBean> getsach() throws Exception{
	   return s.getsach();
   }
   public ArrayList<SachBean> timSachTheoTen(String ten) throws Exception{
	   return s.timSachTheoTen(ten);
   }
   public ArrayList<SachBean> timSachTheoLoai(String loai) throws Exception{
	   return s.timSachTheoLoai(loai);
   }
}
