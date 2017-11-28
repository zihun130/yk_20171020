/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.utils;

import android.os.Environment;

/**
 * 
 * @author yanggf
 * 
 */

public class ConstantUtil {
	public final static String SDCARD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
	public final static String EXTERNAL_SDCARD_PATH = SDCARD_PATH+ "/external_sd";	
	public final static String TIME_STARTAPP = "startapptime";
	
	public final static String FROM_BAIDU = "frombaidu";
	
	public final static long SEVENDAYS = 1000*60*60*24;
	
	public final static long START_TIME_DEFAULT = -1;
	
	public static final int SUCCEED_DEFAULT = 1;
	
	public static final String PUSHSTARTAPP = "3";
	
	public static final String BAIDU_START_APP = "5";
	
	public static final String PUSHWINDOWSTARTAPP = "7";
	
	public static final String HOMESTARTAPP = "6";
	
	public static final String FROM_THIRD_PUSH_NOTIFICATION_START = "9";
	
	public static final String FROM_THIRD_PUSH_POP_WINDOW_STATR = "10";
	
}