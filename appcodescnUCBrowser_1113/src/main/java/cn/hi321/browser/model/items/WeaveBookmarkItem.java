/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
 */
package cn.hi321.browser.model.items;

public class WeaveBookmarkItem {
	
	private String mTitle;
	private String mUrl;
	private boolean mIsFolder;
	private String mWeaveId;

	public WeaveBookmarkItem(String title, String url, String weaveId, boolean isFolder) {
		mTitle = title;
		mUrl = url;
		mWeaveId = weaveId;
		mIsFolder = isFolder;
	}
	
	public String getTitle() {
		return mTitle;
	}
	
	public String getUrl() {
		return mUrl;
	}
	
	public String getWeaveId() {
		return mWeaveId;
	}
	
	public boolean isFolder() {
		return mIsFolder;
	}

}