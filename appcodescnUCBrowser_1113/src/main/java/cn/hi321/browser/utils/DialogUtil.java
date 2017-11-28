/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
 */
package cn.hi321.browser.utils;

import android.app.Dialog;
import android.content.Context;
import cn.hi321.browser2.R;

/**
 * 
 * @author yanggf
 *
 */

public class DialogUtil {
	public static Dialog waitingDialog ;
	private static Context mContext = null;

	public static void setContext(Context context){
		if (context == null){
			return;
		}
		mContext = context;		
	}
	
	public static void startWaitingDialog() {
		try {
			// synchronized(Utils.synchronizeds) {
			if (waitingDialog == null) {
				waitingDialog = new Dialog(mContext, R.style.waiting);
				// dialog.setCanceledOnTouchOutside(true);
				waitingDialog.setContentView(R.layout.waiting);
				waitingDialog.setCanceledOnTouchOutside(false);
				// dialog.setCancelable(false);
				waitingDialog.show();
			} else if (waitingDialog != null && !waitingDialog.isShowing()) {
				waitingDialog.setContentView(R.layout.waiting);
				waitingDialog.setCanceledOnTouchOutside(false);
				waitingDialog.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeWaitingDialog() {
		try {
			// synchronized(Utils.synchronizeds) {
			if (waitingDialog != null) {
				waitingDialog.dismiss();
				waitingDialog = null;
			}
			// }
		} catch (Exception e) {
			// TODO: handle exception
		}

	}


	
	
}