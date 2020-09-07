package com.casestudy.demo.library.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getFormattedDate(Date date, String format) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MON-YYYY");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}
}
