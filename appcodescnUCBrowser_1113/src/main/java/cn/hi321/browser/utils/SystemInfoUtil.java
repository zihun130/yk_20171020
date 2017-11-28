/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.utils;

import java.lang.reflect.Field;

import android.content.Context;

/**
 * This class provides methods to get info relate to android system,
 *  such as the height of status bar;
 * 
 * @author Wang Chenxi
 *
 */
public class SystemInfoUtil {
	private final static String TAG = "SystemInfoUtil";

	private static int statusBarHeight = -1;
	
	public static int getStatusBarHeight(Context context) {
		if (statusBarHeight < 0) {
			measureStatusBarHeight(context);
		}
		return statusBarHeight;
	}
	
	private synchronized static void measureStatusBarHeight(Context context) {
		try {
			Class<?> c = Class.forName("com.android.internal.R$dimen");
			Object obj = c.newInstance();  
			Field field = c.getField("status_bar_height");  
			int x = Integer.parseInt(field.get(obj).toString());  
			statusBarHeight = context.getResources().getDimensionPixelSize(x);  
			
			LogUtil.v(TAG, "get mStatusBarHeight: "+ statusBarHeight);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}