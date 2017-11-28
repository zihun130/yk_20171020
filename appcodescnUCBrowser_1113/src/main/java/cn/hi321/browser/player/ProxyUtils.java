/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.player;


import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * @author yangguangfu
 *
 */
public class ProxyUtils {
	/**
	 * 鑾峰彇閲嶅畾鍚戝悗鐨刄RL锛屽嵆鐪熸鏈夋晥鐨勯摼鎺?	 * @param urlString
	 * @return
	 */
    public static String getRedirectUrl(String urlString){
    	URL url;
		try {
			url = new URL(urlString);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setInstanceFollowRedirects(false);
			if(urlConnection.getResponseCode()==HttpURLConnection.HTTP_MOVED_PERM)
				return urlConnection.getHeaderField("Location");
			
			if(urlConnection.getResponseCode()==HttpURLConnection.HTTP_MOVED_TEMP)
				return urlConnection.getHeaderField("Location");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return urlString;
		}
    	
    	return urlString;
    }
    
}