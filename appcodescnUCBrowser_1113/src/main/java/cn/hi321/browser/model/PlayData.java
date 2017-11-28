/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.model;

import java.io.Serializable;

/**
 * {"url":"http:\/\/192.168.133.122:80\/1111111111111111111111111111111111111111\/bianxingjingang3C.mp4",
 * "size":"160829086"}
 * @author yanggf
 */
public class PlayData implements Serializable {

	private static final long serialVersionUID = 1L;

	private String url;
	
	private String size;
	
	private String name;
	
	private String  videotype;
	
	private String mid;

	private boolean isLocalFile = false; //鍒ゆ柇鎾斁瑙嗛鏄惁涓烘湰鍦版枃浠?	
	private double watchablePercent;
	
//	private MircoVideoSpecial mircoVideoSpecial;
	
	public PlayData() {
	}

	public PlayData(String url) {
		this.url = url;
	}

	public String getVideotype() {
		return videotype;
	}

	public void setVideotype(String videotype) {
		this.videotype = videotype;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public boolean isLocalFile() {
		return isLocalFile;
	}

	public void setLocalFile(boolean isLocalFiel) {
		this.isLocalFile = isLocalFiel;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWatchablePercent() {
		return watchablePercent;
	}

	public void setWatchablePercent(double watchablePercent) {
		this.watchablePercent = watchablePercent;
	}

	
	@Override
	public String toString() {
		return "PlayData [url=" + url + ", size=" + size + ", name=" + name
				+ "]";
	}

	

}