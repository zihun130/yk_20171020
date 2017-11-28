/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
 */
package cn.hi321.browser.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import cn.hi321.browser2.R;

import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.ReportPolicy;
import com.zdp.aseo.content.AseoZdpAseo;

/**
 * 启动页面
 * 
 * @author yanggf
 * 
 */
public class SplashActivity extends Activity {

	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		MobclickAgent.onError(this);// 友盟错误报告

		// 使用在线配置功能
		MobclickAgent.updateOnlineConfig(this);
		// 每次启动发�?
		MobclickAgent
				.setDefaultReportPolicy(this, ReportPolicy.BATCH_AT_LAUNCH);
		// 友盟�?��更新

		setContentView(R.layout.start_activity);
		AseoZdpAseo.init(this, AseoZdpAseo.SCREEN_TYPE);
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				enterHome();
			}
		}, 1000 * 3);
	}

	protected void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
	}

	private void enterHome() {
		Intent intent = new Intent(this, HomeActivity.class);
		startActivity(intent);
		this.finish();
	};


}