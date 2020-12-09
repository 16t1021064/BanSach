package Common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Chuyển đổi kiểu dữ liệu ngoại giữa các loại với nhau
 * - String
 * - java.sql.Date
 * - java.util.Date
 * @author VO HUY
 *
 */
public class DateConversion {
	
	private String dateFormat = "";
	
	public DateConversion() {
		
	}
	
	public DateConversion(String format) {
		this.dateFormat = format;
	}
	
	public Date toUtilDate(String stringDate) {
		DateFormat format = new SimpleDateFormat(this.dateFormat);
		try {
			return format.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String toStringDate(Date ngayJav) {
		
		DateFormat format = new SimpleDateFormat(this.dateFormat);
		
		return format.format(ngayJav);
		
		
	}
	
	
	public Date toUtilDate(java.sql.Date ngaySql) {
		
		return new Date( ngaySql.getTime()  );
		
	}

	public java.sql.Date toSqlDate(Date utilDate){
		return new java.sql.Date(utilDate.getTime());
	}
}
