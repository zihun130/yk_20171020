/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
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
 * 鍚姩椤甸潰
 * 
 * @author yanggf
 * 
 */
public class SplashActivity extends Activity {

	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		MobclickAgent.onError(this);// 鍙嬬洘閿欒鎶ュ憡

		// 浣跨敤鍦ㄧ嚎閰嶇疆鍔熻兘
		MobclickAgent.updateOnlineConfig(this);
		// 姣忔鍚姩鍙戦?
		MobclickAgent
				.setDefaultReportPolicy(this, ReportPolicy.BATCH_AT_LAUNCH);
		// 鍙嬬洘妫?煡鏇存柊

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