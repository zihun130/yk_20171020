/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.model.items;

/**
 * Store a suggestion item.
 */
public class UrlSuggestionItem {

	private static final float TITLE_COEFFICIENT = 2;
	private static final float URL_COEFFICIENT = 1;
	
	private static final float BOOKMARK_COEFFICIENT = 3;
	private static final float WEAVE_COEFFICIENT = 1;
	private static final float HISTORY_COEFFICIENT = 1;
	
	private String mPattern;
	private String mTitle;
	private String mUrl;
	private int mType;
	
	private float mNote;
	private boolean mNoteComputed = false;
	
	/**
	 * Constructor.
	 * @param pattern The parent pattern.
	 * @param title The item's title.
	 * @param url The item's url.
	 * @param type The item's type (1 -> history, 2 -> bookmark).
	 */
	public UrlSuggestionItem(String pattern, String title, String url, int type) {
		mPattern = pattern;
		mTitle = title;
		mUrl = url;
		mType = type;
	}
	
	/**
	 * Get the item's title.
	 * @return The title.
	 */
	public String getTitle() {
		return mTitle;
	}
	
	/**
	 * Get the item's url.
	 * @return The url.
	 */
	public String getUrl() {
		return mUrl;
	}
	
	/**
	 * Get the item's type.
	 * @return The type.
	 */
	public int getType() {
		return mType;
	}
	
	/**
	 * Get the note of this item. Compute it if not already done.
	 * @return The note.
	 */
	public float getNote() {
		if (!mNoteComputed) {
			computeNote();
			mNoteComputed = true;
		}
		return mNote;
	}
	
	/**
	 * Compute the note of the current item.
	 * The principle is to count the number of occurence of the pattern in the title and in the url, and to do a weighted sum.
	 * A match in title weight more than a match in url, and a match in bookmark weight more than a match in history.
	 */
	private void computeNote() {
		String pattern = mPattern.toLowerCase();
		
		// Count the number of match in a string, did not find a cleaner way.
		int titleMatchCount;
		String title = mTitle.toLowerCase();
		if (title.equals(pattern)) {
			titleMatchCount = 1;
		} else {
			titleMatchCount = title.split(pattern).length - 1;
		}
		
		String url = mUrl.toLowerCase();
		int urlMatchCount = url.split("\\Q" + pattern + "\\E").length - 1;
		
		mNote = (titleMatchCount * TITLE_COEFFICIENT) + (urlMatchCount * URL_COEFFICIENT);
		
		switch(mType) {
		case 1: mNote = mNote * HISTORY_COEFFICIENT; break;
		case 2: mNote = mNote * BOOKMARK_COEFFICIENT; break;
		case 3: mNote = mNote * WEAVE_COEFFICIENT; break;
		default: break;
		}
		
	}
	
}