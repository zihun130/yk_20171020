/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.model.items;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Represent an history element.
 */
public class HistoryItem {
	
	private long mId;
	private String mTitle;
	private String mUrl;
	private boolean mIsBookmark;
	private Bitmap mFavicon;

	/**
	 * Constructor.
	 * @param id The element id.
	 * @param title The title.
	 * @param url The url.
	 * @param isBookmark True if this item is also a bookmark.
	 * @param faviconData The favicon.
	 */
	public HistoryItem(long id, String title, String url, boolean isBookmark, byte[] faviconData) {
		mId = id;
		mTitle = title;
		mUrl = url;
		mIsBookmark = isBookmark;
		if (faviconData != null) {
			mFavicon = BitmapFactory.decodeByteArray(faviconData, 0, faviconData.length);
		} else {
			mFavicon = null;
		}
	}

	/**
	 * Get the id.
	 * @return The id.
	 */
	public long getId() {
		return mId;
	}

	/**
	 * Get the title.
	 * @return The title.
	 */
	public String getTitle() {
		return mTitle;
	}

	/**
	 * Get the url.
	 * @return The url.
	 */
	public String getUrl() {
		return mUrl;
	}
	
	public boolean isBookmark() {
		return mIsBookmark;
	}
	
	/**
	 * Get the favicon.
	 * @return The favicon.
	 */
	public Bitmap getFavicon() {
		return mFavicon;
	}
	
}