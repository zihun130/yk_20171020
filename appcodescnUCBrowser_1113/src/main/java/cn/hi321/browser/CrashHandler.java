package cn.hi321.browser;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;

import java.lang.Thread.UncaughtExceptionHandler;

import cn.hi321.browser.utils.LogUtil;

public class CrashHandler implements UncaughtExceptionHandler {
    public static final String TAG = "CrashHandler";
    private static CrashHandler INSTANCE = new CrashHandler();
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        return INSTANCE;
    }

    public void init(Context ctx) {
        mContext = ctx;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
    	LogUtil.e(TAG, "uncaughtException");
        System.out.println("uncaughtException");
        
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                new AlertDialog.Builder(mContext).setTitle("提示").setCancelable(false)
                        .setMessage("程序崩溃了，回到浏览器主页�?").setNeutralButton("确定", new OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                               
                            	Intent intent = new Intent(mContext,CrashHandlerActivity.class);
                            	mContext.startActivity(intent);
                            	System.exit(0);
                            }
                        }).setNegativeButton("�?��浏览�?", new OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								System.exit(0);
							}
						})
                        .create().show();
                Looper.loop();
            }
        }.start();
    }

    /**
     * 自定义错误处�?收集错误信息 发�?错误报告等操作均在此完成. �?��者可以根据自己的情况来自定义异常处理逻辑
     * 
     * @param ex
     * @return true:如果处理了该异常信息;否则返回false
     */
    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return true;
        }
        return true;
    }
}