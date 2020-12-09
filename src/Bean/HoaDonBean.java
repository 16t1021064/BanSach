package Bean;

import java.util.Date;

public class HoaDonBean {
	private int mahoadon;
	private int makh;
	private Date ngaymua;
	private boolean damua;
	public int getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(int mahoadon) {
		this.mahoadon = mahoadon;
	}
	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public HoaDonBean(int mahoadon, int makh, Date ngaymua, boolean damua) {
		super();
		this.mahoadon = mahoadon;
		this.makh = makh;
		this.ngaymua = ngaymua;
		this.damua = damua;
	}
	public HoaDonBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
