/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.ui.runnables;


import android.content.Context;
import android.preference.PreferenceManager;
import cn.hi321.browser.config.Constants;
import cn.hi321.browser.providers.BookmarksProviderWrapper;

/**
 * Runnable to update and truncate the history in background.
 */
public class HistoryUpdater implements Runnable {

	private Context mContext;
	private String mTitle;
	private String mUrl;
	private String mOriginalUrl;
	
	/**
	 * Constructor.
	 * @param context The current context.
	 * @param title The title.
	 * @param url The url.
	 */
	public HistoryUpdater(Context context, String title, String url, String originalUrl) {
		mContext = context;
		mTitle = title;
		mUrl = url;
		mOriginalUrl = originalUrl;
		
		if (mUrl.startsWith(Constants.URL_GOOGLE_MOBILE_VIEW_NO_FORMAT)) {
			mUrl = mUrl.substring(Constants.URL_GOOGLE_MOBILE_VIEW_NO_FORMAT.length());
		}
	}
	
	@Override
	public void run() {
		BookmarksProviderWrapper.updateHistory(mContext.getContentResolver(), mTitle, mUrl, mOriginalUrl);
		BookmarksProviderWrapper.truncateHistory(mContext.getContentResolver(),
				PreferenceManager.getDefaultSharedPreferences(mContext).getString(Constants.PREFERENCES_BROWSER_HISTORY_SIZE, "90"));
	}

}