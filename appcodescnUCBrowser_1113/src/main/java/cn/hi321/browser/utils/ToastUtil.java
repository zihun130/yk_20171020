/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
	private static Toast mToast = null;
	
	
	public static void showLongToast(Context context,int id){
		if(null != context){
			if(null == mToast){
				mToast = Toast.makeText(context, id, Toast.LENGTH_LONG);
			}else{
				mToast.setText(id);
			}	
			mToast.show();
		}
	}
	
	public static void showLongToast(Context context,String content){
		if(null != context){
			if(null == mToast){
				mToast = Toast.makeText(context,content,Toast.LENGTH_LONG);
			}else{
				mToast.setText(content);
			}	
			mToast.show();
		}
	}
	
	public static void showShortToast(Context context,int id){
		if(null != context){
			if(null == mToast){
				mToast = Toast.makeText(context, id, Toast.LENGTH_SHORT);
			}else{
				mToast.setText(id);
			}	
			mToast.show();
		}
	}
	
	public static void showShortToast(Context context,String content){
		if(null != context){
			if(null == mToast){
				mToast = Toast.makeText(context,content,Toast.LENGTH_SHORT);
			}else{
				mToast.setText(content);
			}	
			mToast.show();
		}
	}
	
	public static void toastPrompt(Context context,int id,int time){
		if(null != context){
			if(null == mToast){
				mToast = Toast.makeText(context, id, time);
			}else{
				mToast.setText(id);
			}	
			mToast.show();
		}
	}
	
	/*public static void toastPrompt(Context context,String str,int time){
		if(null != context){
			if(null == mToast){
				mToast = Toast.makeText(context,str,time);
			}else{
				mToast.setText(str);
			}	
			mToast.show();
		}
	}*/
	
	public static void cancelToast(){
		if(null != mToast){
			mToast.cancel();
		}
	}
}