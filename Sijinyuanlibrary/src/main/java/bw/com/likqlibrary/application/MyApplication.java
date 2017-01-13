package bw.com.likqlibrary.application;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * 自定义application, 进行全局初始化
 * 配置清单文件！！！
 *
 *
 */
public class MyApplication extends Application {

	private static Context context;
	private static Handler handler;
	private static int mainThreadId;

	@Override
	public void onCreate() {
		super.onCreate();

		context = this.getApplicationContext();
		handler = new Handler();
		mainThreadId = android.os.Process.myTid();
	}

	/***
	 * 		//添加日志过滤器
	 */


	public static Context getContext() {
		return context;
	}

	public static Handler getHandler() {
		return handler;
	}

	public static int getMainThreadId() {
		return mainThreadId;
	}
}
