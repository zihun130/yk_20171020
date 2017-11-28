/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class StreamTools {
	/**
	 * 鎶婁竴涓緭鍏ユ祦閲岄潰鐨勫唴瀹?杞寲瀛樻斁鍦ㄤ竴涓猙yte鏁扮粍閲岄潰
	 * @param is
	 * @return
	 * @throws Exception
	 */
	public static byte[] getBytes(InputStream is) throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len =0;
		while((len = is.read(buffer))!=-1){
			baos.write(buffer, 0, len);
		}
		is.close();
		return baos.toByteArray();
		
	}
}