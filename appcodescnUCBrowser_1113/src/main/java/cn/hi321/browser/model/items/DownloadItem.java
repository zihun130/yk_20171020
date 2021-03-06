/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.model.items;

import java.util.Random;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import cn.hi321.browser.events.EventConstants;
import cn.hi321.browser.events.EventController;
import cn.hi321.browser.ui.runnables.DownloadRunnable;

/**
 * Represent a download item.
 */
public class DownloadItem {
	
	private Context mContext;
	
	private String mUrl;
	private String mFileName;
	
	private int mProgress;
	
	private String mErrorMessage;
	
	private DownloadRunnable mRunnable;
	
	private boolean mIsFinished;
	private boolean mIsAborted;
	
	private NotificationManager mNotificationManager;
	private Notification mNotification;
	private int mNotificationId;
	
	/**
	 * Constructor.
	 * @param context The current context.
	 * @param url The download url.
	 */
	public DownloadItem(Context context, String url) {
		
		mContext = context;
		
		mUrl = url;
		//modify by yanggf
		try{
			mFileName = mUrl.substring(mUrl.lastIndexOf("/") + 1);
			mFileName = mFileName.substring(0, mFileName.indexOf("?"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		mProgress = 0;
	
		mRunnable = null;
		mErrorMessage = null;
		
		mIsFinished = false;
		mIsAborted = false;
		
		Random r = new Random();
		mNotificationId = r.nextInt();
		mNotification = null;
		mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
	}
	
	/**
	 * Gets the download url.
	 * @return The download url.
	 */
	public String getUrl() {
		return mUrl;
	}
	
	/**
	 * Gets the filename on disk.
	 * @return The filename on disk.
	 */
	public String getFileName() {
		return mFileName;
	}
	
	/**
	 * Gets the download progress.
	 * @return The download progress.
	 */
	public int getProgress() {
		return mProgress;
	}
	
	/**
	 * Set the current error message for this download.
	 * @param errorMessage The error message.
	 */
	public void setErrorMessage(String errorMessage) {
		mErrorMessage = errorMessage;
	}
	
	/**
	 * Gets the error message for this download.
	 * @return The error message.
	 */
	public String getErrorMessage() {
		return mErrorMessage;
	}
	
	/**
	 * Trigger a start download event.
	 */
	public void onStart() {
//		createNotification();
		
		EventController.getInstance().fireDownloadEvent(EventConstants.EVT_DOWNLOAD_ON_START, this);
	}
	
	/**
	 * Set this item is download finished state. Trigger a finished download event.
	 */
	public void onFinished() {
		mProgress = 100;
		mRunnable = null;
		
		mIsFinished = true;
		
//		updateNotificationOnEnd();
		
		EventController.getInstance().fireDownloadEvent(EventConstants.EVT_DOWNLOAD_ON_FINISHED, this);
	}
	
	/**
	 * Set the current progress. Trigger a progress download event.
	 * @param progress The current progress.
	 */
	public void onProgress(int progress) {
		mProgress = progress;
		
		EventController.getInstance().fireDownloadEvent(EventConstants.EVT_DOWNLOAD_ON_PROGRESS, this);
	}
	
	/**
	 * Start the current download.
	 */
	public void startDownload() {
		if (mRunnable != null) {
			mRunnable.abort();
		}
		mRunnable = new DownloadRunnable(this);
		new Thread(mRunnable).start();
	}
	
	/**
	 * Abort the current download.
	 */
	public void abortDownload() {
		if (mRunnable != null) {
			mRunnable.abort();
		}
		mIsAborted = true;
	}
	
	/**
	 * Check if the download is finished.
	 * @return True if the download is finished.
	 */
	public boolean isFinished() {
		return mIsFinished;
	}
	
	/**
	 * Check if the download is aborted.
	 * @return True if the download is aborted.
	 */
	public boolean isAborted() {
		return mIsAborted;
	}
	
	/**
	 * Create the download notification.
	 */
//	private void createNotification() {
//		mNotification = new Notification(R.drawable.download_anim, mContext.getString(R.string.DownloadNotification_DownloadStart), System.currentTimeMillis());		
//
//		Intent notificationIntent = new Intent(mContext.getApplicationContext(), DownloadsListActivity.class);
//		PendingIntent contentIntent = PendingIntent.getActivity(mContext.getApplicationContext(), 0, notificationIntent, 0);
//
//		mNotification.setLatestEventInfo(mContext.getApplicationContext(), mContext.getString(R.string.DownloadNotification_DownloadInProgress), mFileName, contentIntent);
//
//		mNotificationManager.notify(mNotificationId, mNotification);
//	}
	
	/**
	 * Update the download notification at the end of download.
	 */
//	private void updateNotificationOnEnd() {
//		if (mNotification != null) {
//			mNotificationManager.cancel(mNotificationId);			
//		}
//		
//		String message;
//		if (mIsAborted) {
//			message = mContext.getString(R.string.DownloadNotification_DownloadCanceled);
//		} else {
//			message = mContext.getString(R.string.DownloadNotification_DownloadComplete);
//		}
//
//		mNotification = new Notification(R.drawable.stat_sys_download, mContext.getString(R.string.DownloadNotification_DownloadComplete), System.currentTimeMillis());
//		mNotification.flags |= Notification.FLAG_AUTO_CANCEL;
//
//		Intent notificationIntent = new Intent(mContext.getApplicationContext(), DownloadsListActivity.class);
//		PendingIntent contentIntent = PendingIntent.getActivity(mContext.getApplicationContext(), 0, notificationIntent, 0);
//
//		mNotification.setLatestEventInfo(mContext.getApplicationContext(), mFileName, message, contentIntent);
//
//		mNotificationManager.notify(mNotificationId, mNotification);		
//	}

}