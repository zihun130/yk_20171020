/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.ui.activities;

import com.zdp.aseo.content.AseoZdpAseo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import cn.hi321.browser.config.Constants;
import cn.hi321.browser.providers.BookmarksProviderWrapper;
import cn.hi321.browser2.R;

public class EditBookmarkActivity extends Activity {

	private EditText mTitleEditText;
	private EditText mUrlEditText;
	private ImageView mImageView;

	private Button mOkButton;
	private Button mCancelButton;

	private long mRowId = -1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_bookmark_activity);

		mImageView = (ImageView) findViewById(R.id.back_gohome);
		mTitleEditText = (EditText) findViewById(R.id.EditBookmarkActivity_TitleValue);
		mUrlEditText = (EditText) findViewById(R.id.EditBookmarkActivity_UrlValue);
		AseoZdpAseo.initType(this, AseoZdpAseo.INSERT_TYPE);

		mOkButton = (Button) findViewById(R.id.EditBookmarkActivity_BtnOk);
		mCancelButton = (Button) findViewById(R.id.EditBookmarkActivity_BtnCancel);

		mOkButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				setAsBookmark();
				setResult(RESULT_OK);
				finish();
			}
		});
		mImageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		mCancelButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				setResult(RESULT_CANCELED);
				finish();
			}
		});

		Bundle extras = getIntent().getExtras();
		if (extras != null) {

			String title = extras.getString(Constants.EXTRA_ID_BOOKMARK_TITLE);
			if ((title != null) && (title.length() > 0)) {
				mTitleEditText.setText(title);
			}

			String url = extras.getString(Constants.EXTRA_ID_BOOKMARK_URL);
			if ((url != null) && (url.length() > 0)) {
				mUrlEditText.setText(url);
			} else {
				mUrlEditText.setHint("http://");
			}

			mRowId = extras.getLong(Constants.EXTRA_ID_BOOKMARK_ID);

		}

		if (mRowId == -1) {
			setTitle(R.string.EditBookmarkActivity_TitleAdd);
		}
	}

	private void setAsBookmark() {
		BookmarksProviderWrapper.setAsBookmark(getContentResolver(), mRowId,
				mTitleEditText.getText().toString(), mUrlEditText.getText()
						.toString(), true);

	}

}