/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
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