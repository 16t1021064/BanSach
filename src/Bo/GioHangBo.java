package Bo;

import java.util.ArrayList;

import Bean.GioHangBean;

public class GioHangBo {
	
	public ArrayList<GioHangBean> ds = new ArrayList<GioHangBean>();
	public void Them(String masach, String tensach, long gia, long soluong, String maloai) {
		int n = ds.size();
		for ( int i= 0; i <n; i++) {
			if(ds.get(i).getMasach().equals(masach)) {
				long slt = ds.get(i).getSoluong()+ 1;
				ds.get(i).setSoluong(slt);
				long g= ds.get(i).getGia();
				long tt = slt*g;
				ds.get(i).setThanhtien(tt);
				return;
				}
		}
		GioHangBean gh= new GioHangBean(masach, tensach, gia, soluong, maloai);
		ds.add(gh);	
	}
	public void capNhat(String masach, long sl) {
		for(GioHangBean g: ds) {
			if(g.getMasach().equals(masach)) {
				g.setSoluong(g.getSoluong() + sl);
				g.setThanhtien(g.getSoluong() *g.getGia());
			}
		}
	}
	public void xoa(String masach) {
		for(GioHangBean g:ds) {
			if(g.getMasach().equals(masach)) {
				ds.remove(g);
				break;
			}
		}
	}
	public long tongtien() {
		long s=0;
		for(GioHangBean g: ds) {
			s+=g.getThanhtien();
		}
		return s;
	}
}

