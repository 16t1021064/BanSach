package Bean;

public class ChiTietHoaDonBean {
	private int machitiethoadon;
	private String masach;
	private int soluong;
	private int mahoadon;
	public int getMachitiethoadon() {
		return machitiethoadon;
	}
	public void setMachitiethoadon(int machitiethoadon) {
		this.machitiethoadon = machitiethoadon;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(int mahoadon) {
		this.mahoadon = mahoadon;
	}
	public ChiTietHoaDonBean(int machitiethoadon, String masach, int soluong, int mahoadon) {
		super();
		this.machitiethoadon = machitiethoadon;
		this.masach = masach;
		this.soluong = soluong;
		this.mahoadon = mahoadon;
	}
	public ChiTietHoaDonBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
