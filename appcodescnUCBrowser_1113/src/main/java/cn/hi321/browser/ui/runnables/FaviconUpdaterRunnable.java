/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
 */
package cn.hi321.browser.ui.runnables;

import cn.hi321.browser.providers.BookmarksProviderWrapper;

import android.app.Activity;
import android.graphics.Bitmap;

/**
 * Runnable to update database favicon.
 */
public class FaviconUpdaterRunnable implements Runnable {
	
	private Activity mActivity;
	private String mUrl;
	private String mOriginalUrl;
	private Bitmap mFavIcon;

	/**
	 * Constructor.
	 * @param activity The parent activity.
	 * @param url The page url.
	 * @param originalUrl The page original url.
	 * @param favicon The favicon.
	 */
	public FaviconUpdaterRunnable(Activity activity, String url, String originalUrl, Bitmap favicon) {
		mActivity = activity;
		mUrl = url;
		mOriginalUrl = originalUrl;
		mFavIcon = favicon;
	}
	
	@Override
	public void run() {
		BookmarksProviderWrapper.updateFavicon(mActivity, mUrl, mOriginalUrl, mFavIcon);
	}

}