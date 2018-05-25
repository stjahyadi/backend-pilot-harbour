package id.co.asyst.backend.common;

import java.sql.Date;
import java.util.Calendar;

public class DateUtil {
	/**
	 * To get current date with java sql format
	 * 
	 * @return
	 */
	public static Date getCurentDate() {
		Calendar calendar = Calendar.getInstance();
		Date tanggal = new Date(calendar.getTime().getTime());
		return tanggal;
	}
}
