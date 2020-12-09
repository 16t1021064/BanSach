package Bo;

import java.util.Date;

import Bean.GioHangBean;
import Bean.HoaDonBean;
import Dao.ChiTietHoaDonDao;
import Dao.HoaDonDao;
import Dao.KhachHangDao;

public class HoaDonBo {

	public void luuHoaDon(GioHangBo gh, String username) throws Exception {
		
		if(gh == null) {
			System.out.println("gio hang null");
		}
		
		if(gh.ds.size() <= 0) {
			return;
		}
		
		// DAO Khach Hang de lay id dau username
		
		KhachHangDao khDao = new KhachHangDao();
		
		int makh = khDao.timIdKHBoiUsername(username);
		
		if(makh > 0 ) {
			
			Date ngayMua = new Date();
			
			boolean damua = true;
			
			HoaDonBean hd = (new HoaDonDao()).luuHoaDon(makh, ngayMua, damua);	
			
			if(hd != null) {
				for(GioHangBean item : gh.ds) {
				
					
					// HoadDonChiTietBO luu   => HoadDonChiTietDAO luu
					
					ChiTietHoaDonDao cthddao = new ChiTietHoaDonDao();
					
					cthddao.themCTHD(item.getMasach(), (int) item.getSoluong(), hd.getMahoadon());
					
				}
			}
			
			
			
			
		}
		
	}
	
}
