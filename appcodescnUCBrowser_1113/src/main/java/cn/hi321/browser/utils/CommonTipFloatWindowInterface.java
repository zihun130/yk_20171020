/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.utils;

public interface CommonTipFloatWindowInterface {
	/**
	 * push寮圭獥鐨勬捣鎶ュ浘鐗?	 */
    public static final int GET_POSTER_IMAGE = 0;
    
    /**
     * 鐢ㄦ埛鐐瑰嚮浜哹ack閿?     */
    public static final int  USER_PRESSED_BACK = 1;
    
    /**
     * 瑙ｅ睆涓ゅ垎閽熷悗鍥炲鐢ㄦ埛鎵嬫満涓洪攣灞忕姸鎬?     */
    public static final int ROLL_BACK_TO_LOCKSCREEN = USER_PRESSED_BACK + 1;
    
    /**
     * 瑙ｅ睆瓒呮椂鏃堕棿 2鍒嗛挓
     */
    public static final int UNLOCK_TIME_OUT =  120000;
    
    /**
     * 鐢ㄦ埛鐐瑰嚮浜唄ome閿?     */
    public static final int  USER_PRESSED_HOME = 2;
    
    public static final int STATR_CREATE_SHORTCUT = 3;
    
    public static final String CURRENT_OBJECT = "current_object";
    
    public static final String POP_SWITCH = "popswitch";
	
    public static final  String ON_OFF = "OnOff";
    
    public static final String SCREEN_LOCK = "screen_lock";
    
    public static final String USER_CLOSE_WINDOW = "useclose";
    
    public static final String IS_FROM_THIRD_PUSH = "isfromthirdpush";
    
    public static final String LONG_MEDIA = "long";
	
    public static final String SHORT_MEDIA = "short";
	
    public static final String LIVE_MEDIA = "live";
	
    public static final String LOCAL_NOTIFICATION = "local_notification";
    
}