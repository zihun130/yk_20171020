/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.utils;
import java.text.DecimalFormat;

public class DownloadUtils {
	private final static long DOWNLOAD_SMALL_MEDIA_BOUNDARY = 10485760L;
	private final static long DOWNLOAD_MEDIUM_MEDIA_BOUNDARY = 104857600L;
	private final static String INIT_DWONLOAD_SIZE = "0";
	private static DecimalFormat mSmallSizeFormat = null;
	private static DecimalFormat mMediumSizeFormat = null;
	
	private static void initSizeFormat(){
		if(null == mSmallSizeFormat){
			mSmallSizeFormat = new DecimalFormat("0.##");
		}
		if(null == mMediumSizeFormat){
			mMediumSizeFormat = new DecimalFormat("0.#");
		}
	}
	public static String getDownloadedSize(long size){
		initSizeFormat();
		String downloadedSize = "";
		float sizeFloat = ((float)size) / 1024 / 1024;
		if(Math.abs(sizeFloat-0) < 0.01){
			downloadedSize = INIT_DWONLOAD_SIZE;
		}else{
			downloadedSize = String.valueOf(mSmallSizeFormat.format(sizeFloat));
		}	
		return downloadedSize;
	}
	
	public static String getTotalSize(long size){
		initSizeFormat();
		String downloadedSize = "";
		float sizeFloat = ((float)size) / 1024 / 1024;
		if(Math.abs(sizeFloat-0) < 0.01){
			downloadedSize = INIT_DWONLOAD_SIZE;
		}else if(size < DOWNLOAD_SMALL_MEDIA_BOUNDARY){
			downloadedSize = String.valueOf(mSmallSizeFormat.format(sizeFloat));
		}else if(size < DOWNLOAD_MEDIUM_MEDIA_BOUNDARY){
			downloadedSize = String.valueOf(mMediumSizeFormat.format(sizeFloat));
		}else{
			downloadedSize = String.valueOf(size/1024/1024);
		}
		return downloadedSize;
	}
}