/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.utils;

import java.text.SimpleDateFormat;

/**
 * 鏍煎紡鍖栧伐鍏? * 
 * @author yanggf
 * 
 */
public class FormatUtil {
	private static final String TAG = "FormatUtil";

	public static final class TimeFormat {
		public static final long SECOND = 1000;
		public static final long MINUTE = 60 * 1000;
		public static final long HOUR = 60 * MINUTE;
		public static final long DAY = 24 * HOUR;

		public static String absolute(Long time) {
			SimpleDateFormat df = new SimpleDateFormat("MM-dd");
			return df.format(time);
		}

	}
}