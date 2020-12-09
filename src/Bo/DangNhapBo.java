package Bo;

import Dao.DangNhapDao;

public class DangNhapBo {
	DangNhapDao dn = new DangNhapDao();
	public boolean ktDangNhap (String un, String pass) throws Exception{
		return dn.ktDangNhap(un, pass);
	}
}
