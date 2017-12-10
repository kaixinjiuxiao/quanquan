package com.wealth.freedom.quanquan.qiandao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
	
	public static final String PATTERN_STANDARD08W = "yyyyMMdd";
	public static final String PATTERN_STANDARD12W = "yyyyMMddHHmm";
	public static final String PATTERN_STANDARD14W = "yyyyMMddHHmmss";
	public static final String PATTERN_STANDARD17W = "yyyyMMddHHmmssSSS";

	public static final String PATTERN_STANDARD10H = "yyyy-MM-dd";
	public static final String PATTERN_STANDARD16H = "yyyy-MM-dd HH:mm";
	public static final String PATTERN_STANDARD19H = "yyyy-MM-dd HH:mm:ss";

	public static final String PATTERN_STANDARD10X = "yyyy/MM/dd";
	public static final String PATTERN_STANDARD16X = "yyyy/MM/dd HH:mm";
	public static final String PATTERN_STANDARD19X = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 秒 换算成时分秒
	 * 
	 * @param second
	 * @return
	 */
	public static String secondToHour(int second) {
		int h = 0;
		int d = 0;
		int s = 0;
		int temp = second % 3600;
		if (second > 3600) {
			h = second / 3600;
			if (temp != 0) {
				if (temp > 60) {
					d = temp / 60;
					if (temp % 60 != 0) {
						s = temp % 60;
					}
				} else {
					s = temp;
				}
			}
		} else {
			d = second / 60;
			if (second % 60 != 0) {
				s = second % 60;
			}
			return d + "分" + s + "秒";
		}
		return h + "时" + d + "分" + s + "秒";

	}

	/**
	 * 计算剩余时间
	 * 
	 * @param timeStr
	 *            "2006-05-26 12:00:00"
	 * @return
	 * @throws ParseException
	 */
	public static long getLeftTime(String timeStr) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long days = 0, hours = 0, minutes = 0, totalSec = 0;
		try {
			Date d1 = df.parse(timeStr);
			Date d2 = new Date();

			totalSec = d1.getTime() - d2.getTime();// 这样得到的差值是微秒级别
			// days = totalSec / (1000 * 60 * 60 * 24);
			// hours = (totalSec - days * (1000 * 60 * 60 * 24))
			// / (1000 * 60 * 60);
			// minutes = (totalSec - days * (1000 * 60 * 60 * 24) - hours
			// * (1000 * 60 * 60))
			// / (1000 * 60);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return totalSec;
	}

	/**
	 * long转日期格式
	 * 
	 * @param dateFormat
	 * @param millSec
	 * @return
	 */
	public static String longToDateStr(String dateFormat, Long millSec) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.CHINESE);
		// sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
		TimeZone timeZoneChina = TimeZone.getTimeZone("Asia/Shanghai");// 获取中国的时区
		sdf.setTimeZone(timeZoneChina);
		Date date = new Date(millSec);
		return sdf.format(date);
	}

	/**
	 * 两个日期之间相差天数
	 * 
	 * @param smalldate
	 * @param bigdate
	 * @return
	 * @throws ParseException
	 */
//	public static int daysBetween(String smalldate, String bigdate)
//			throws ParseException {
//		if (StringUtil.isNullString(smalldate)
//				|| StringUtil.isNullString(bigdate)) {
//			return 0;
//		}
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(sdf.parse(smalldate));
//		long time1 = cal.getTimeInMillis();
//		cal.setTime(sdf.parse(bigdate));
//		long time2 = cal.getTimeInMillis();
//		long between_days = (time2 - time1) / (1000 * 3600 * 24);
//
//		return Integer.parseInt(String.valueOf(between_days));
//	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smalldate
	 *            较小的时间
	 * @param bigdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
//	public static int daysBetween(Date smalldate, Date bigdate)
//			throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String sDate = sdf.format(smalldate);
//		String bDate = sdf.format(bigdate);
//
//		return daysBetween(sDate, bDate);
//	}

//	public static int daysOfTwo(String smalldate, String bigdate)
//			throws ParseException {
//
//		if (StringUtil.isNullString(smalldate)
//				|| StringUtil.isNullString(bigdate)) {
//			return 0;
//		}
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(sdf.parse(smalldate));
//		int day1 = cal.get(Calendar.DAY_OF_YEAR);
//		cal.setTime(sdf.parse(bigdate));
//		int day2 = cal.get(Calendar.DAY_OF_YEAR);
//
//		return day2 - day1;
//
//	}
	
//	public static String getWantDate(String dateStr, String wantFormat) {
//		if (StringUtil.isNotNullString(dateStr.trim())) {
//			String pattern = PATTERN_STANDARD14W;
//			int len = dateStr.length();
//			switch (len) {
//			case 8:
//				pattern = PATTERN_STANDARD08W;
//				break;
//			case 12:
//				pattern = PATTERN_STANDARD12W;
//				break;
//			case 14:
//				pattern = PATTERN_STANDARD14W;
//				break;
//			case 17:
//				pattern = PATTERN_STANDARD17W;
//				break;
//			case 10:
//				pattern = (dateStr.contains("-")) ? PATTERN_STANDARD10H
//						: PATTERN_STANDARD10X;
//				break;
//			case 16:
//				pattern = (dateStr.contains("-")) ? PATTERN_STANDARD16H
//						: PATTERN_STANDARD16X;
//				break;
//			case 19:
//				pattern = (dateStr.contains("-")) ? PATTERN_STANDARD19H
//						: PATTERN_STANDARD19X;
//				break;
//			default:
//				pattern = PATTERN_STANDARD14W;
//				break;
//			}
//			SimpleDateFormat sdf = new SimpleDateFormat(wantFormat);
//			try {
//				SimpleDateFormat sdfStr = new SimpleDateFormat(pattern);
//				Date date = sdfStr.parse(dateStr);
//				dateStr = sdf.format(date);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return dateStr;
//	}

}
