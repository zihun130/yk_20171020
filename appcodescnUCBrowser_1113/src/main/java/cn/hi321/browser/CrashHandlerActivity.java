/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
 */
package cn.hi321.browser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.hi321.browser.ui.activities.HomeActivity;
import cn.hi321.browser.utils.LogUtil;

/**
 * 
 * @author yanggf
 * 
 */
public class CrashHandlerActivity extends Activity {
	public static final String TAG = "CrashHandler";

	protected void onCreate(Bundle state) {
		super.onCreate(state);
		LogUtil.e("CrashHandle onCreate");
		startActivity(new Intent(CrashHandlerActivity.this, HomeActivity.class));
		finish();
	}

}