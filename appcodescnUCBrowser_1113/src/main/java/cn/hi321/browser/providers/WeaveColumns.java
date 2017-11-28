/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.providers;

import android.net.Uri;
import android.provider.BaseColumns;

public class WeaveColumns implements BaseColumns {
	
	private WeaveColumns() { }
	
	public static final Uri CONTENT_URI = Uri.parse("content://" + WeaveContentProvider.AUTHORITY + "/" + WeaveContentProvider.WEAVE_BOOKMARKS_TABLE);
	
	public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.zirco.weave";
	public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.zirco.weave";
	
	public static final String WEAVE_BOOKMARKS_ID = "_id";
	public static final String WEAVE_BOOKMARKS_WEAVE_ID = "weave_id";
	public static final String WEAVE_BOOKMARKS_WEAVE_PARENT_ID = "weave_parent_id";
	public static final String WEAVE_BOOKMARKS_TITLE = "title";
	public static final String WEAVE_BOOKMARKS_URL = "url";
	public static final String WEAVE_BOOKMARKS_FOLDER = "folder";
	
	public static final String[] WEAVE_BOOKMARKS_PROJECTION = { WEAVE_BOOKMARKS_ID,
		WEAVE_BOOKMARKS_WEAVE_ID,
		WEAVE_BOOKMARKS_WEAVE_PARENT_ID,
		WEAVE_BOOKMARKS_TITLE,
		WEAVE_BOOKMARKS_URL,
		WEAVE_BOOKMARKS_FOLDER };	
}