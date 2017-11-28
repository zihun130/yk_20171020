/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.player;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * 
 * @author yanggf
 *
 */
public class PlayerUtils {
	
	private static final String TIP_3G_KEY = "tip_3g_key";
	private static final String TIP_3G_KEY_CONTENT= "tip_3g_key_content";
	
	public  static void setTip3GNework(Context context,boolean flag) {
		SharedPreferences  preference = context.getSharedPreferences(TIP_3G_KEY,context.MODE_PRIVATE );
		Editor editor = preference.edit();
		editor.putBoolean(TIP_3G_KEY_CONTENT, flag);
		editor.commit();
	}
	
	public static boolean  getTip3GNework(Context context) {
		SharedPreferences  preference = context.getSharedPreferences(TIP_3G_KEY,context.MODE_PRIVATE );
        return preference.getBoolean(TIP_3G_KEY_CONTENT, false);
	}
}