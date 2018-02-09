/**   
* @Title: DateUtils.java 
* @Package com.getOpenId.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Rex   
* @date 2017年7月29日 下午12:24:41 
* @version V1.0   
*/
package com.getOpenId.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @ClassName: DateUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Rex
 * @date 2017年7月29日 下午12:24:41
 * 
 */
public class DateUtils {
	/**
	 * 获取当前时间，格式：广朿旿
	 * 
	 * @return String
	 */
	public static String getNowDate() {
		Calendar date = Calendar.getInstance();
		return "" + date.get(Calendar.YEAR) + "-" + (date.get(Calendar.MONTH) + 1) + "-" + date.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * @Description:检查某时间距离现在是否超过了一天24小时
	 * @param datea
	 * @return
	 * @time 2016-12-19 下午5:28:56
	 */
	public static boolean checkdate(String datea) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		boolean status = false;
		java.util.Date date;
		try {
			date = sdf.parse(datea);
			long s1 = date.getTime();// 将时间转为毫秒
			long s2 = System.currentTimeMillis();// 得到当前的毫秒
			int mouth = (int) ((s2 - s1) / 1000 / 60 / 60);
			if (mouth < 24) {
				status = true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	/**
	 * @Description:检查某时间距离现在是否超过了一天2小时
	 * @param datea
	 * @return
	 * @time 2016-12-19 下午5:28:56
	 */
	public static boolean checkdateover2(String datea) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		boolean status = false;
		java.util.Date date;
		try {
			date = sdf.parse(datea);
			long s1 = date.getTime();// 将时间转为毫秒
			long s2 = System.currentTimeMillis();// 得到当前的毫秒
			int mouth = (int) ((s2 - s1) / 1000 / 60 / 60);
			if (mouth < 1) {
				status = true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	/**
	 * @Description:检测时间是否超过12小时
	 * @param datea
	 * @return
	 * @time 2017-1-17 下午3:13:12
	 */
	public static boolean checkdate12(String datea) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		boolean status = false;
		java.util.Date date;
		try {
			date = sdf.parse(datea);
			long s1 = date.getTime();// 将时间转为毫秒
			long s2 = System.currentTimeMillis();// 得到当前的毫秒
			int mouth = (int) ((s2 - s1) / 1000 / 60 / 60);
			System.out.println(mouth);
			System.out.println(mouth % 12);
			System.out.println(mouth / 12);
			if (mouth % 12 == 1 && mouth / 12 == 1) {
				status = true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public static void main(String[] args) {
		System.out.println(checkdateover2(""));
	}

	/**
	 * 获取当前时间，格式：年月日时分秒
	 * 
	 * @return String
	 */
	public static String getnewNowDateString() {
		Calendar date = Calendar.getInstance();
		String i = "";
		String k = "";
		String h = "";
		String fen = "";
		String miao = "";
		if (date.get(Calendar.MONTH) + 1 < 10) {
			i = "0";
		}
		if (date.get(Calendar.DAY_OF_MONTH) < 10) {
			k = "0";
		}
		if (date.get(Calendar.HOUR_OF_DAY) < 10) {
			h = "0";
		}
		if (date.get(Calendar.MINUTE) < 10) {
			fen = "0";
		}
		if (date.get(Calendar.SECOND) < 10) {
			miao = "0";
		}
		return "" + date.get(Calendar.YEAR) + i + (date.get(Calendar.MONTH) + 1) + k + date.get(Calendar.DAY_OF_MONTH) + h + date.get(Calendar.HOUR_OF_DAY) + fen + date.get(Calendar.MINUTE) + miao + date.get(Calendar.SECOND);
	}

	/**
	 * 获取当前时间，格式：年月旿
	 * 
	 * @return String
	 */
	public static String getNowDateString() {
		Calendar date = Calendar.getInstance();
		String i = "";
		String k = "";
		String h = "";
		String fen = "";
		String miao = "";
		if (date.get(Calendar.MONTH) + 1 < 10) {
			i = "0";
		}
		if (date.get(Calendar.DAY_OF_MONTH) < 10) {
			k = "0";
		}
		if (date.get(Calendar.HOUR_OF_DAY) < 10) {
			h = "0";
		}
		if (date.get(Calendar.MINUTE) < 10) {
			fen = "0";
		}
		if (date.get(Calendar.SECOND) < 10) {
			miao = "0";
		}
		return "" + (date.get(Calendar.MONTH) + 1) + k + date.get(Calendar.DAY_OF_MONTH) + h + date.get(Calendar.HOUR_OF_DAY) + fen + date.get(Calendar.MINUTE) + miao + date.get(Calendar.SECOND);
	}

	public static String getNowDateStringten() {
		Calendar date = Calendar.getInstance();
		String i = "";
		String k = "";
		String h = "";
		String fen = "";
		String miao = "";
		if (date.get(Calendar.MILLISECOND) + 1 < 10) {
			i = "0";
		}
		if (date.get(Calendar.DAY_OF_MONTH) < 10) {
			k = "0";
		}
		if (date.get(Calendar.HOUR_OF_DAY) < 10) {
			h = "0";
		}
		if (date.get(Calendar.MINUTE) < 10) {
			fen = "0";
		}
		if (date.get(Calendar.SECOND) < 10) {
			miao = "0";
		}
		return "" + h + date.get(Calendar.HOUR_OF_DAY) + fen + date.get(Calendar.MINUTE) + miao + date.get(Calendar.SECOND) + date.get(Calendar.MILLISECOND);
	}

	/**
	 * 获取当前时间串，年月日时分秒毫秒，数字串
	 * 
	 * @return String
	 */
	public static String getNowTimeString() {
		Calendar date = Calendar.getInstance();
		String k = "";
		if (date.get(Calendar.DAY_OF_MONTH) < 10) {
			k = "0";
		}
		return "" + k + (date.get(Calendar.MONTH) + 1) + date.get(Calendar.DAY_OF_MONTH) + date.get(Calendar.HOUR_OF_DAY) + date.get(Calendar.MINUTE) + date.get(Calendar.SECOND);
	}

	/**
	 * 获取当前时间格式为（年-月-日 时：分：秒）
	 * 
	 * @return
	 */
	public static String getNowTime() {
		Calendar date = Calendar.getInstance();
		String i = "";
		String k = "";
		String h = "";
		String fen = "";
		String miao = "";
		if (date.get(Calendar.MONTH) + 1 < 10) {
			i = "0";
		}
		if (date.get(Calendar.DAY_OF_MONTH) < 10) {
			k = "0";
		}
		if (date.get(Calendar.HOUR_OF_DAY) < 10) {
			h = "0";
		}
		if (date.get(Calendar.MINUTE) < 10) {
			fen = "0";
		}
		if (date.get(Calendar.SECOND) < 10) {
			miao = "0";
		}
		return "" + date.get(Calendar.YEAR) + "-" + i + (date.get(Calendar.MONTH) + 1) + "-" + k + date.get(Calendar.DAY_OF_MONTH) + " " + h + date.get(Calendar.HOUR_OF_DAY) + ":" + fen + date.get(Calendar.MINUTE) + ":" + miao + date.get(Calendar.SECOND);
	}

	public static String toString(Calendar date) {
		return "" + date.get(Calendar.YEAR) + "-" + (date.get(Calendar.MONTH) + 1) + "-" + date.get(Calendar.DAY_OF_MONTH) + " " + date.get(Calendar.HOUR_OF_DAY) + ":" + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);
	}

	public static String getyymmdd() {
		Calendar date = Calendar.getInstance();
		String i = "";
		String k = "";
		String h = "";
		String fen = "";
		String miao = "";
		if (date.get(Calendar.MONTH) + 1 < 10) {
			i = "0";
		}
		if (date.get(Calendar.DAY_OF_MONTH) < 10) {
			k = "0";
		}
		if (date.get(Calendar.HOUR_OF_DAY) < 10) {
			h = "0";
		}
		if (date.get(Calendar.MINUTE) < 10) {
			fen = "0";
		}
		if (date.get(Calendar.SECOND) < 10) {
			miao = "0";
		}
		return "" + (date.get(Calendar.YEAR)) + i + (date.get(Calendar.MONTH) + 1) + k + date.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取时间零点的Calendar 丿ĩ的开姿
	 */
	public static Calendar getZeroTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}
}
