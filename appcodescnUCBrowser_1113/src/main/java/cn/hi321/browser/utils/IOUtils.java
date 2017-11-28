/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.graphics.Bitmap;
import android.os.Environment;

/**
 * Utilities for I/O reading and writing.
 */
public class IOUtils {
	
	private static final String APPLICATION_FOLDER = "321Browser";
	private static final String DOWNLOAD_FOLDER = "downloads";
	private static final String BOOKMARKS_EXPORT_FOLDER = "bookmarks-exports";
	
	/**
	 * Get the application folder on the SD Card. Create it if not present.
	 * @return The application folder.
	 */
	public static File getApplicationFolder() {
		File root = Environment.getExternalStorageDirectory();
		if (root.canWrite()) {
			
			File folder = new File(root, APPLICATION_FOLDER);
			
			if (!folder.exists()) {
				folder.mkdir();
			}
			
			return folder;
			
		} else {
			return null;
		}
	}
	
	/**
	 * Get the application download folder on the SD Card. Create it if not present.
	 * @return The application download folder.
	 */
	public static File getDownloadFolder() {
		File root = getApplicationFolder();
		
		if (root != null) {
			
			File folder = new File(root, DOWNLOAD_FOLDER);
			
			if (!folder.exists()) {
				folder.mkdir();
			}
			
			return folder;
			
		} else {
			return null;
		}
	}
	
	public static final String SAVE_FILE_PATH_DIRECTORY = Environment
	.getExternalStorageDirectory().getAbsolutePath() + "/" + "321Browser/";
	public static void SaveImage(Bitmap tempBitmap){
		 File file = new File(SAVE_FILE_PATH_DIRECTORY);
			file.mkdirs();// 鍒涘缓鏂囦欢
			String imageSavePath = SAVE_FILE_PATH_DIRECTORY
					+ System.currentTimeMillis() + ".jpg";
			try {
				FileOutputStream fileOutStream = new FileOutputStream(
						imageSavePath);
				tempBitmap.compress(Bitmap.CompressFormat.JPEG, 65,
						fileOutStream);// 鎶婃暟鎹啓鍏ユ枃
				fileOutStream.flush();
				fileOutStream.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	/**
	 * Get the application folder for bookmarks export. Create it if not present.
	 * @return The application folder for bookmarks export.
	 */
	public static File getBookmarksExportFolder() {
		File root = getApplicationFolder();
		
		if (root != null) {
			
			File folder = new File(root, BOOKMARKS_EXPORT_FOLDER);
			
			if (!folder.exists()) {
				folder.mkdir();
			}
			
			return folder;
			
		} else {
			return null;
		}
	}
	
	/**
	 * Get the list of xml files in the bookmark export folder.
	 * @return The list of xml files in the bookmark export folder.
	 */
	public static List<String> getExportedBookmarksFileList() {
		List<String> result = new ArrayList<String>();
		
		File folder = getBookmarksExportFolder();		
		
		if (folder != null) {
			
			FileFilter filter = new FileFilter() {
				
				@Override
				public boolean accept(File pathname) {
					if ((pathname.isFile()) &&
							(pathname.getPath().endsWith(".xml"))) {
						return true;
					}
					return false;
				}
			};
			
			File[] files = folder.listFiles(filter);
			
			for (File file : files) {
				result.add(file.getName());
			}			
		}
		
		Collections.sort(result, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {				
				return arg1.compareTo(arg0);
			}    		
    	});
		
		return result;
	}

}