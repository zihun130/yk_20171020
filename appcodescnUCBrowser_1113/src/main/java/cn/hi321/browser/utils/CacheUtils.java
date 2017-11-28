/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
 */
package cn.hi321.browser.utils;


public class CacheUtils {
	
	
	/**电影、电视剧、动漫�?综艺*/
	public static String[] longMediaType= {"movie","tv","cartoon","variety"};
	

	public static String[] longMediaOrder = new String[]{"pl","mo","ka","re"};

	public static String[] shortMediaType = {"entertainments","sport"};
	

	public static String[] shortMediaOrder = new String[]{"pl","mo","ka"};
	
	/**直播�?��直播节目、电视台*/
	public static String[] liveMediaOrder = {"live_program","tv_program"};
	

	public static String liveBasePath = "/cache/livePage/";
	

	public static String longBasePath = "/cache/longMediaPage/";
	
	/**首页推广数据缓存路径*/
	public static String spreadBasePath = "/cache/spread/";
	
	/**精�?缓存数据存储路径*/
	public static String featuredBasePath = "/cache/featured/";
	
	/**新版精�?缓存数据存储路径*/
	public static String NEW_FEATURE_BASE_PATH = "phonemedia";
	
	public static String spreadStr = "spread_mid";
		
	/**精�?*/
	public static String featuredStr = "featured_mid";
	

	public static String shortBasePath = "/cache/shortMediaPage/";
	
	public static String cachePath = "/cache/";
	
	/**
	 * 存储筛�?条件的路�?	 */
	public static String indexBasePath = "/cache/mediaIndexPage/";
	
	/**
	 * 存储push消息的路�?	 */
	public static String pushInfoPath = "/cache/pushdata/";
	
	public static long time_out = 60*60*1000; //过期时间�?小时
	
	public static String plat_login_path = "/cache/plat_login/";

}