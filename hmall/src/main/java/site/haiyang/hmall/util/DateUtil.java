package site.haiyang.hmall.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * 格式化日期
     */
    public static String format(Date date, String pattern) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    	return dateFormat.format(date);
    }
    /**
     * 格式化日期
     */
    public static Date format(String date, String pattern) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    	Date d = null;
    	try {
			d = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return d;
    }
}
