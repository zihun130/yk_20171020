/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
 */
package cn.hi321.browser.utils;

import android.os.Environment;

/**
 * 
 * @author yanggf
 * 
 */

public class ConstantUtil {
	public final static String SDCARD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
	public final static String EXTERNAL_SDCARD_PATH = SDCARD_PATH+ "/external_sd";	
	public final static String TIME_STARTAPP = "startapptime";
	
	public final static String FROM_BAIDU = "frombaidu";
	
	public final static long SEVENDAYS = 1000*60*60*24;
	
	public final static long START_TIME_DEFAULT = -1;
	
	public static final int SUCCEED_DEFAULT = 1;
	
	public static final String PUSHSTARTAPP = "3";
	
	public static final String BAIDU_START_APP = "5";
	
	public static final String PUSHWINDOWSTARTAPP = "7";
	
	public static final String HOMESTARTAPP = "6";
	
	public static final String FROM_THIRD_PUSH_NOTIFICATION_START = "9";
	
	public static final String FROM_THIRD_PUSH_POP_WINDOW_STATR = "10";
	
}