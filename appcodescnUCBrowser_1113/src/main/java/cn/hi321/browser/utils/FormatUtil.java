/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
 */
package cn.hi321.browser.utils;

import java.text.SimpleDateFormat;

/**
 * 格式化工�? * 
 * @author yanggf
 * 
 */
public class FormatUtil {
	private static final String TAG = "FormatUtil";

	public static final class TimeFormat {
		public static final long SECOND = 1000;
		public static final long MINUTE = 60 * 1000;
		public static final long HOUR = 60 * MINUTE;
		public static final long DAY = 24 * HOUR;

		public static String absolute(Long time) {
			SimpleDateFormat df = new SimpleDateFormat("MM-dd");
			return df.format(time);
		}

	}
}