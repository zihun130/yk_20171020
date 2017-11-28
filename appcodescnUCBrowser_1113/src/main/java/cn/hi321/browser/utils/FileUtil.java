/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import cn.hi321.browser.download.DownloadHelper;


public class FileUtil {
	public static String TAG  = "FileUtil";
	public final static int POOL_SIZE = 5; 	// 鍗曚釜CPU绾跨▼姹犲ぇ灏?
	public final static int MB = 1024 * 1024; 
	public final static int CACHE_SIZE = 3; // 闄愬埗apk鏂囦欢鍖呯紦瀛樺浘鐗囩洰褰曞ぇ灏忔渶澶т负3M
	public final static int SD_CACHE_SIZE = 10; // 闄愬埗SD鍗℃枃浠跺浘鐗囩紦瀛樼洰褰曞ぇ灏忔渶澶т负10M
	public final static String SDCARD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
	public final static String SAVE_FILE_PATH_DIRECTORY = SDCARD_PATH + "/"+ "321Browser";
	public final static String EXTERNAL_SDCARD_PATH = SDCARD_PATH+ "/external_sd";
	public final static String EXTERNAL_321BROWSER_PATH = EXTERNAL_SDCARD_PATH+ "/321Browser";
	public final static String FEATURED_CACHE_PATH = SAVE_FILE_PATH_DIRECTORY+ CacheUtils.featuredBasePath + CacheUtils.featuredStr;
	public final static String NEW_FEATURED_CACHE_PATH = SAVE_FILE_PATH_DIRECTORY+ CacheUtils.featuredBasePath+ CacheUtils.NEW_FEATURE_BASE_PATH;
	public final static String SPREAD_CACHE_PATH = SAVE_FILE_PATH_DIRECTORY+ CacheUtils.spreadBasePath + CacheUtils.spreadStr;
	public final static String SHORTMEDIA_PATH = SAVE_FILE_PATH_DIRECTORY+ CacheUtils.shortBasePath;
	public final static String LIVEMEDIA_PATH = SAVE_FILE_PATH_DIRECTORY+ CacheUtils.liveBasePath;
	public final static String CACHE_IMG_DIR_PATH = "/imgfiles/";//Cache directory of the picture 
	public final static String FINAL_SAVE_MEDIA_PATH = SAVE_FILE_PATH_DIRECTORY;
	public final static String SAVE_STATE_TO_FILE_PATH = SDCARD_PATH + "/" +"SYSTEM_FUNSHION.ini";
	public final static String CACHE_IMAGES_PATH = "/321Browser" + CACHE_IMG_DIR_PATH;
	
	public final static String PLAT_LOGIN_CACHE_PATH = FileUtil.SAVE_FILE_PATH_DIRECTORY + CacheUtils.plat_login_path + "platlogin";
	public final static String PLAT_BOUND_CACHE_PATH = FileUtil.SAVE_FILE_PATH_DIRECTORY+CacheUtils.plat_login_path+"platbound";
	/** Upgrade request path identification **/
	private static final String LOG_PATH = SAVE_FILE_PATH_DIRECTORY+ "/fslog.txt";
	public static File file = new File(LOG_PATH);
	
	/**
	 * Determine whether there is a memory card, and returns TRUE, otherwise
	 * FALSE
	 * @return
	 */
	public static boolean isSDcardExist() {
		boolean isExist = false;
		try {
			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
				isExist = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isExist;

	}
	
	public synchronized static void writeFile(String content) {
		if (TextUtils.isEmpty(content) || !isSDcardExist()) {
			return;
		}
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			long len = raf.length();
			raf.seek(len);
			raf.writeBytes(content);
			raf.close();
		} catch (Exception e) {
		}
	}
	
	/**
	 * Check the SD card if there
	 * @return
	 */
	public static boolean checkSDCard() {
		try {
			final String status = Environment.getExternalStorageState();
			if (status.equals(Environment.MEDIA_MOUNTED)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * check file directory exists.
	 * @return boolean
	 */
	public static boolean checkFileDirectory() {
		try {
			final File dir = new File(FINAL_SAVE_MEDIA_PATH);
			if (!dir.exists()) {
				final boolean isMkdirs = dir.mkdirs();
				return isMkdirs;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static String getAppFilesDirBySDCard(Context context) {
		return SAVE_FILE_PATH_DIRECTORY;
	}
	
	/**
	 * @return files
	 */
	public static String getAppFilesDir(Context context) {

		if (FileUtil.isSDcardExist()) {
			return getAppFilesDirBySDCard(context);
		} else {
			return getAppFilesDirByData(context);
		}
	}
	
	public static void initCacheFileBySDCard(Context context) {
		final String imageDir = getAppFilesDirBySDCard(context) + CACHE_IMG_DIR_PATH;
		final File imageFileDir = new File(imageDir);
		if (!imageFileDir.exists()) {
			imageFileDir.mkdirs();
		}
	}
	
	public static String getAppFilesDirByData(Context context) {
		return context.getFilesDir().getAbsolutePath();
	}
	
	/**
	 * check file directory exists.
	 * 
	 * @return boolean
	 */
	public static boolean checkAppFileDirectory(Context context) {
		try {
			final String imageDir = getAppFilesDirByData(context);
			final File imageFileDir = new File(imageDir);
			if (!imageFileDir.exists()) {
				final boolean isMkdirs = imageFileDir.mkdirs();
				return isMkdirs;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	public static void initCacheFile(Context context) {
		if (FileUtil.isSDcardExist()) {
			initCacheFileBySDCard(context);
		} else {
			initCacheFileByData(context);
		}

	}

	/**
	 * Create /data/data/cn.hi321.browser/files/imgfiles Cache folder
	 */
	public static void initCacheFileByData(Context context) {
		final String imageDir = getAppFilesDirByData(context)+ CACHE_IMG_DIR_PATH;
		final File imageFileDir = new File(imageDir);
		if (!imageFileDir.exists()) {
			imageFileDir.mkdirs();
		}
	}
	
	/**
	 * 鍒ゆ柇鏄惁瀛樺湪缂撳瓨鏂囦欢
	 * 
	 * @return add by jiyx at 2012-8-27 16:00:59
	 */
	public static boolean isExist(String path) {
		File fileName = new File(path);
		return fileName.exists();
	}
	
	/**
	 * 鍒ゆ柇鎸囧畾鍚嶇О鐨勫奖鐗囨槸鍚﹀瓨鍦ㄤ簬sdcard涓?	 * 2013-3-4涓嬪崍2:16:53
	 * @param displayName 
	 * @param fileFormat  闇?鍒ゆ柇鐨勬枃浠舵牸寮?	 * @return
	 */
	public static boolean checkFileExist(String displayName ,String fileFormat) {
		File localfile = new File(DownloadHelper.getDownloadPath(),displayName+fileFormat);
		return localfile.exists();
	}
	
	/**
	 * 灏嗗瓧绗︿覆鍐欏叆鏂囦欢
	 * @param path
	 * @param rptContent
	 */
	public static void writeStateToFile(String path, String rpt) {
		//鍐欏叆鏂囨湰鏂囦欢
		File file = new File(path);		
		BufferedWriter writer = null;
		String str="";
		try{
			if (!file.exists())
				file.createNewFile();
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file)));
			writer.write(rpt);
		}catch (Exception e){
			str=e.getMessage();
		}
		finally{
			try{
				if (writer != null)
					writer.close();
			}catch (IOException e){
				str=str+"淇濆瓨鎶ユ枃鍑洪敊,鏈兘姝ｇ‘鍏抽棴鏂囦欢娴併?";
			}
		}
	}
	
	public static void deleteCache() {
		new Thread() {
			@Override
			public void run() {
				super.run();
				try {
					String pathStr = FileUtil.SAVE_FILE_PATH_DIRECTORY
							+ CacheUtils.shortBasePath;
					LogUtil.e(TAG, "鍒犻櫎鏂囦欢鐨勮矾寰?-------" + pathStr);
					deleteDirectory(pathStr);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	/**
	 * 鍒犻櫎鍗曚釜鏂囦欢
	 * 
	 * @param sPath
	 *            琚垹闄ゆ枃浠剁殑鏂囦欢鍚?	 * @return 鍗曚釜鏂囦欢鍒犻櫎鎴愬姛杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 */
	public static boolean deleteFile(String sPath) {
		boolean flag = false;
		file = new File(sPath);
		// 璺緞涓烘枃浠朵笖涓嶄负绌哄垯杩涜鍒犻櫎
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	/**
	 * 鍒犻櫎鐩綍锛堟枃浠跺す锛変互鍙婄洰褰曚笅鐨勬枃浠?	 * 
	 * @param sPath
	 *            琚垹闄ょ洰褰曠殑鏂囦欢璺緞
	 * @return 鐩綍鍒犻櫎鎴愬姛杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 */
	public static boolean deleteDirectory(String sPath) {   
	boolean flag = false;
  //濡傛灉sPath涓嶄互鏂囦欢鍒嗛殧绗︾粨灏撅紝鑷姩娣诲姞鏂囦欢鍒嗛殧绗?  
	    if (!sPath.endsWith(File.separator)) {   
	        sPath = sPath + File.separator;   
	    }   
	    File dirFile = new File(sPath);   
	    //濡傛灉dir瀵瑰簲鐨勬枃浠朵笉瀛樺湪锛屾垨鑰呬笉鏄竴涓洰褰曪紝鍒欓?鍑?  
	    if (!dirFile.exists() || !dirFile.isDirectory()) {   
	       return false;   
	    }   
	    flag = true;   
   //鍒犻櫎鏂囦欢澶逛笅鐨勬墍鏈夋枃浠?鍖呮嫭瀛愮洰褰?   
	    File[] files = dirFile.listFiles();   
	    for (int i = 0; i < files.length; i++) {   
	        //鍒犻櫎瀛愭枃浠?  
	        if (files[i].isFile()) {   
	            flag = deleteFile(files[i].getAbsolutePath());   
	            if (!flag) break;   
	        } //鍒犻櫎瀛愮洰褰?  
	        else {   
	          flag = deleteDirectory(files[i].getAbsolutePath());   
	           if (!flag) break;   
	       }   
	   }   
	    if (!flag) return false;   
	    //鍒犻櫎褰撳墠鐩綍   
	   return dirFile.delete();
	}
	
}