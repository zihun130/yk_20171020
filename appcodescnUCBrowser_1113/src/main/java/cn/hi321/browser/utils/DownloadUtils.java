/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
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