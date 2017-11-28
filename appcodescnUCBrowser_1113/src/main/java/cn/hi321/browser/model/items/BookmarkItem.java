/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
 */
package cn.hi321.browser.model.items;

/**
 * Represent a bookmark.
 */
public class BookmarkItem {
	
	private String mTitle;
	private String mUrl;
	
	/**
	 * Constructor.
	 * @param title The bookmark title.
	 * @param url The bookmark url.
	 */
	public BookmarkItem(String title, String url) {
		mTitle = title;
		mUrl = url;
	}
	
	/**
	 * Get the bookmark title.
	 * @return The bookmark title.
	 */
	public String getTitle() {
		return mTitle;
	}
	
	/**
	 * Get the bookmark url.
	 * @return The bookmark url.
	 */
	public String getUrl() {
		return mUrl;
	}

}