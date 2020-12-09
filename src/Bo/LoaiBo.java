package Bo;

import java.util.ArrayList;

import Dao.LoaiDao;
import Bean.LoaiBean;

public class LoaiBo {
     ArrayList<LoaiBean> ds;
    LoaiDao ldao= new LoaiDao();
    public ArrayList<LoaiBean> getloai() throws Exception{
    	ds= ldao.getloai();
    	return ds;
    }
}
