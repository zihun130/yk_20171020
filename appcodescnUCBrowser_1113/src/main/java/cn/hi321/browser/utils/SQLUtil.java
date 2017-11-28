/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SQLUtil {
	public static final String DB_NAME = "321Browser.db";// Database name
	public static final int DB_VERSION = 4;// Database version
	public static SQLiteDatabase mInstance = null;
	/**
	 * 鎻掑叆鐢靛奖鏁版嵁鐨凷QL
	 */
	public final static String MOVIEINSERSQL = "insert into moviefilterhistory ("
			+ "hashid,_inserttime,"
			+ "filter_cate_key,filter_cate_title,filter_region_key,filter_region_title,"
			+ "filter_rdate_key,filter_rdate_title,filter_karma_key,filter_karma_title,"
			+ "filter_clarity_key,filter_clarity_title,filter_udate_key,filter_udate_title,"
			+ "filter_hotrank_key,filter_hotrank_title )values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * 鎻掑叆鐢佃鍓ф暟鎹殑SQL
	 */
	public final static String TVINSERTSQL = "insert into tvfilterhistory ("
			+ "hashid,_inserttime,"
			+ "filter_cate_key ,filter_cate_title ,filter_region_key ,filter_region_title ,"
			+ "filter_rdate_key ,filter_rdate_title ,filter_karma_key ,filter_karma_title, "
			+ "filter_udate_key ,filter_udate_title ,"
			+ "filter_hotrank_key ,filter_hotrank_title )values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * 鎻掑叆鍗￠?鐨凷QL
	 */
	public final static String CARTOONINSERTSQL = "insert into cartoonfilterhistory ("
			+ "hashid,_inserttime,"
			+ "filter_cate_key ,filter_cate_title ,filter_region_key ,filter_region_title ,"
			+ "filter_rdate_key ,filter_rdate_title ,filter_karma_key ,filter_karma_title, "
			+ "filter_udate_key ,filter_udate_title ,"
			+ "filter_hotrank_key ,filter_hotrank_title ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * 鎻掑叆缁艰壓鏁版嵁鐨凷QL
	 */
	public final static String VARIETYINSERSQL = "insert into varietyfilterhistory ("
			+ "hashid,_inserttime,"
			+ "filter_cate_key ,filter_cate_title ,filter_region_key ,filter_region_title ,"
			+ "filter_rdate_key ,filter_rdate_title ,filter_karma_key ,filter_karma_title, "
			+ "filter_udate_key ,filter_udate_title ,"
			+ "filter_hotrank_key ,filter_hotrank_title ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static String ENTERTAINMENTINSERSQL = "insert into entertainmentfilterhistory(" +
			"hashid,_inserttime,filter_cate_key ,filter_cate_title,filter_date_key ,filter_date_title)values(?,?,?,?,?,?)";
	public static String SPORTSQL = "insert into sportfilterfilterhistory(" +
			"hashid,_inserttime,filter_cate_key ,filter_cate_title,filter_date_key ,filter_date_title)values(?,?,?,?,?,?)";

	public synchronized static SQLiteDatabase get321BrowserDb(Context context) {
		try {
			if (null == mInstance && null != context) {
				mInstance = context.openOrCreateDatabase(SQLUtil.DB_NAME,
						Context.MODE_PRIVATE, null);
			}
			return mInstance;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}