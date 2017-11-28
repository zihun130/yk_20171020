/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.utils;

import java.util.Iterator;

import android.content.Context;
import android.preference.PreferenceManager;
import cn.hi321.browser.config.Constants;
import cn.hi321.browser.controllers.Controller;

/**
 * Url management utils.
 */
public class UrlUtils {

	/**
	 * Check if a string is an url.
	 * For now, just consider that if a string contains a dot, it is an url.
	 * @param url The url to check.
	 * @return True if the string is an url.
	 */
	public static boolean isUrl(String url) {
		return url.equals(Constants.URL_ABOUT_BLANK) ||
			url.equals(Constants.URL_ABOUT_START) ||
			url.contains(".");
	}
	
	/**
	 * Get the current search url.
	 * @param context The current context.
	 * @param searchTerms The terms to search for.
	 * @return The search url.
	 */
	public static String getSearchUrl(Context context, String searchTerms) {
		String currentSearchUrl = PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.PREFERENCES_GENERAL_SEARCH_URL, Constants.URL_SEARCH_GOOGLE);
		return String.format(currentSearchUrl, searchTerms);
	}
	
	/**
	 * Check en url. Add http:// before if missing.
	 * @param url The url to check.
	 * @return The modified url if necessary.
	 */
	public static String checkUrl(String url) {
		if ((url != null) &&
    			(url.length() > 0)) {
    	
    		if ((!url.startsWith("http://")) &&
    				(!url.startsWith("https://")) &&
    				(!url.startsWith("file://")) &&
    				(!url.startsWith(Constants.URL_ABOUT_BLANK)) &&
    				(!url.startsWith(Constants.URL_ABOUT_START))) {
    			
    			url = "http://" + url;
    			
    		}
		}
		
		return url;
	}
	
	/**
	 * Check if there is an item in the mobile view url list that match a given url.
	 * @param context The current context.
	 * @param url The url to check.
	 * @return True if an item in the list match the given url.
	 */
	public static boolean checkInMobileViewUrlList(Context context, String url) {
		
		if (url != null) {
			boolean inList = false;
			Iterator<String> iter = Controller.getInstance().getMobileViewUrlList(context).iterator();			
			while ((iter.hasNext()) &&
					(!inList)) {
				if (url.contains(iter.next())) {
					inList = true;
				}
			}
			return inList;
		} else {
			return false;
		} 
	}
	
	public static boolean checkIsVideoNetwork(String url) {
		boolean isVideoNetwork = false;
		if ((url != null) &&
    			(url.length() > 0)) {
    	
    		if ((url.contains("youku.com")) ||
    				(url.contains("funshion.com")) ||
    				(url.contains("tudou.com")) ||
    				(url.contains("iqiyi.com")) ||
    				(url.contains("v.qq.com"))  ||
    				(url.contains("tv.sohu.com"))||
    				(url.contains("letv.com"))||
    				(url.contains("pps.com"))||
    				(url.contains("pptv.com"))||
    				(url.contains("56.com"))||
    				(url.contains("m1905.cn"))||
    				(url.contains("video.sina.cn"))  
    				
    				) {
    			isVideoNetwork = true;
    			
    		}else{
    			isVideoNetwork = false;
    		}
		}
		
		return isVideoNetwork;
	}
	
}