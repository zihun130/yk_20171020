/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.ui.runnables;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import cn.hi321.browser.model.items.DownloadItem;
import cn.hi321.browser.utils.IOUtils;

import android.os.Handler;
import android.os.Message;

/**
 * Background downloader.
 */
public class DownloadRunnable implements Runnable {

	private static final int BUFFER_SIZE = 4096;

	private DownloadItem mParent;

	private boolean mAborted;

	/**
	 * Contructor.
	 * 
	 * @param parent
	 *            The item to download.
	 */
	public DownloadRunnable(DownloadItem parent) {
		mParent = parent;
		mAborted = false;
	}

	private Handler mHandler = new Handler() {

		public void handleMessage(Message msg) {
			mParent.onFinished();
		}
	};

	/**
	 * Compute the file name given the url.
	 * 
	 * @return The file name.
	 */
	private String getFileNameFromUrl() {
		// modfiy by yanggf
		String fileName = null;
		try {
			fileName = mParent.getUrl().substring(
					mParent.getUrl().lastIndexOf("/") + 1);
			fileName = fileName.substring(0, fileName.indexOf("?"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}

	/**
	 * Get a file object representation of the file name, in th right folder of
	 * the SD card.
	 * 
	 * @return A file object.
	 */
	private File getFile() {

		File downloadFolder = IOUtils.getDownloadFolder();

		if (downloadFolder != null) {

			return new File(downloadFolder, getFileNameFromUrl());

		} else {
			mParent.setErrorMessage("Unable to get download folder from SD Card.");
			return null;
		}
	}

	@Override
	public void run() {
		File downloadFile = getFile();

		if (downloadFile != null) {

			if (downloadFile.exists()) {
				downloadFile.delete();
			}

			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;

			try {

				mParent.onStart();

				URL url = new URL(mParent.getUrl());
				URLConnection conn = url.openConnection();

				InputStream is = conn.getInputStream();

				int size = conn.getContentLength();

				double oldCompleted = 0;
				double completed = 0;

				bis = new BufferedInputStream(is);
				bos = new BufferedOutputStream(new FileOutputStream(
						downloadFile));

				boolean downLoading = true;
				byte[] buffer = new byte[BUFFER_SIZE];
				int downloaded = 0;
				int read;

				while ((downLoading) && (!mAborted)) {

					if ((size - downloaded < BUFFER_SIZE)
							&& (size - downloaded > 0)) {
						buffer = new byte[size - downloaded];
					}

					read = bis.read(buffer);

					if (read > 0) {
						bos.write(buffer, 0, read);
						downloaded += read;

						completed = ((downloaded * 100f) / size);

					} else {
						downLoading = false;
					}

					// Notify each 5% or more.
					if (oldCompleted + 5 < completed) {
						mParent.onProgress((int) completed);
						oldCompleted = completed;
					}
				}

			} catch (MalformedURLException mue) {
				mParent.setErrorMessage(mue.getMessage());
			} catch (IOException ioe) {
				mParent.setErrorMessage(ioe.getMessage());
			} finally {

				if (bis != null) {
					try {
						bis.close();
					} catch (IOException ioe) {
						mParent.setErrorMessage(ioe.getMessage());
					}
				}
				if (bos != null) {
					try {
						bos.close();
					} catch (IOException ioe) {
						mParent.setErrorMessage(ioe.getMessage());
					}
				}
			}

			if (mAborted) {
				if (downloadFile.exists()) {
					downloadFile.delete();
				}
			}

		}

		mHandler.sendEmptyMessage(0);
	}

	/**
	 * Abort this download.
	 */
	public void abort() {
		mAborted = true;
	}

}