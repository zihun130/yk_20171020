/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
 */
package cn.hi321.browser.service;

import android.content.Context;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import cn.hi321.browser.utils.StreamTools;
import cn.hi321.browser2.R;

public class Service {

	/**
	 * 采用http的get方式提交数据到服务器
	 * 
	 * @param name
	 * @return
	 */
	public static String loginByHttpGet(Context context, String name) {
		String result = null;
		try {
			String basepath = context.getResources().getString(
					R.string.serverurl);

			String newname = URLEncoder.encode(name);
			String path = basepath + newname ;
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5000);

			if (conn.getResponseCode() == 200) {
				InputStream is = conn.getInputStream();
				byte[] data = StreamTools.getBytes(is);// 服务器端返回的数据是gbk的数�?				result = new String(data,"GBK");
			} else {
				result = "服务器内部错�?";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "连接服务器异�?";
		}

		return result;
	}

	

	/**
	 * 采用httpclient的方�?提交数据到服务器
	 * 
	 * @param context
	 * @return
	 */
	public static String loginByHttpClientGet(Context context, String name) {
		String result = null;
		// 1.打开�?��浏览�?
		HttpClient client = new DefaultHttpClient();
		// 2.输入�?��地址.
		String basepath = context.getResources().getString(R.string.serverurl);

		String newname = URLEncoder.encode(name);
		String path = basepath + newname ;
		HttpGet httpGet = new HttpGet(path);

			try {
			HttpResponse response = client.execute(httpGet);
			int code = response.getStatusLine().getStatusCode();
			if (code == 200) {
				InputStream is = response.getEntity().getContent();
				result = new String(StreamTools.getBytes(is),"GBK");
			} else {
				result = "服务器状态错�?";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "获取数据失败";
		}
		return result;
	}

	
}