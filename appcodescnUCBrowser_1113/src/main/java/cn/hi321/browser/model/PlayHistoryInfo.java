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
import java.util.ArrayList;

import cn.hi321.browser.utils.StringUtil;

/**
 * @author yanggf
 */
public class PlayHistoryInfo implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private static final String TYPE_TV 		= "tv";
	private static final String TYPE_CARTOON 	= "cartoon";
	private static final String TYPE_VARIETY 	= "variety";
	
	private String mid;
	private String hashid;
	
	private String taskname;
	
	private String fsp;
	
	//add by yangguangfu
	//鐩存帴鎾斁鍦板潃
	private String purl;
	
	//瀹圭伨鎾斁鍦板潃
	private String mpurl;
	
	//涓嬭浇鍦板潃
	private String durl;

	private String mediatype;
	
	private String medianame;
	
	private String playedtimeString;
	
	private String size;
	
	private String percent;
	
	private String mLocalPlayerUrl = null;

	private long playedtime;
	
	private long position;
	
	private int movie_position;
	
	private long movie_playedtime;
	
	private String mSerialId;
	
	private String mVideoId;
	
//	private VideoClarityInfo mDefinitionInfo;
//	
//	public VideoClarityInfo getmDefinitionInfo() {
//		return mDefinitionInfo;
//	}
//
//
//	public void setmDefinitionInfo(VideoClarityInfo mDefinitionInfo) {
//		this.mDefinitionInfo = mDefinitionInfo;
//	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getPercent() {
		return percent;
	}


	public void setPercent(String percent) {
		this.percent = percent;
	}


	public PlayHistoryInfo(){
			
	}
	
	private ArrayList<PlayData> playList;
	
	
	public PlayHistoryInfo(String mid,String mediatype,  String medianame, String hashid,String taskname,
			String fsp, String playedtimeString,
			Long playedtime, Long position,int movie_position,long movie_playedtime,String size,String percent,String purl) {
		
		this.mid = mid;
		this.hashid = hashid;
		this.taskname = taskname;
		this.fsp = fsp;
		this.mediatype= mediatype;
		this.medianame = medianame;
		this.playedtimeString = playedtimeString;
		this.playedtime = playedtime;
		this.position = position;
		this.movie_position=movie_position;
		this.movie_playedtime=movie_playedtime;
		this.size = size;
		this.percent = percent;
		this.purl = purl;
	}
	

	public PlayHistoryInfo(String hashid,String mediatype, String medianame, String mid,String taskname,
			String fsp, String playedtimeString,
			Long playedtime, Long position) {
		
		this.mid = mid;
		this.hashid = hashid;
		this.taskname = taskname;
		this.fsp = fsp;
		this.mediatype= mediatype;
		this.medianame = medianame;
		this.playedtimeString = playedtimeString;
		this.playedtime = playedtime;
		this.position = position;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getHashid() {
		return hashid;
	}


	public void setHashid(String hashid) {
		this.hashid = hashid;
	}


	public String getTaskname() {
		return taskname;
	}


	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}


	public String getFsp() {
		return fsp;
	}


	public void setFsp(String fsp) {
		this.fsp = fsp;
	}


	public String getMediatype() {
		return mediatype;
	}


	public void setMediatype(String mediatype) {
		this.mediatype = mediatype;
	}


	public String getMedianame() {
		return medianame;
	}


	public void setMedianame(String medianame) {
		this.medianame = medianame;
	}


	public String getLanguage() {
		return playedtimeString;
	}


	public void setLanguage(String playedtimeString) {
		this.playedtimeString = playedtimeString;
	}


	public long getPlayedtime() {
		return playedtime;
	}


	public void setPlayedtime(long playedtime) {
		this.playedtime = playedtime;
	}


	public long getPosition() {
		return position;
	}


	public void setPosition(long position) {
		this.position = position;
	}


	public int getMovie_position() {
		return movie_position;
	}


	public void setMovie_position(int movie_position) {
		this.movie_position = movie_position;
	}


	public long getMovie_playedtime() {
		return movie_playedtime;
	}


	public void setMovie_playedtime(long movie_playedtime) {
		this.movie_playedtime = movie_playedtime;
	}


	public ArrayList<PlayData> getPlayList() {
		return playList;
	}


	public void setPlayList(ArrayList<PlayData> playList) {
		this.playList = playList;
	}


	public String getPurl() {
		return purl;
	}


	public void setPurl(String purl) {
		this.purl = purl;
	}


	public String getMpurl() {
		return mpurl;
	}


	public void setMpurl(String mpurl) {
		this.mpurl = mpurl;
	}


	public String getDurl() {
		return durl;
	}


	public void setDurl(String durl) {
		this.durl = durl;
	}


	public String getPlayedtimeString() {
		return playedtimeString;
	}

	public void setVideoId(String videoId){
		this.mVideoId = videoId;
	}
	
	public String getVideoId(){
		return mVideoId;
	}
	
	public void setSerialId(String serialId){
		this.mSerialId = serialId;
	}
	
	public String getSerialId(){
		return mSerialId;
	}

	public void setPlayedtimeString(String playedtimeString) {
		this.playedtimeString = playedtimeString;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "PlayHistoryInfo [mid=" + mid + ", hashid=" + hashid
				+ ", taskname=" + taskname + ", fsp=" + fsp + ", purl=" + purl
				+ ", mpurl=" + mpurl + ", durl=" + durl + ", mediatype="
				+ mediatype + ", medianame=" + medianame
				+ ", playedtimeString=" + playedtimeString + ", playedtime="
				+ playedtime + ", position=" + position + ", movie_position="
				+ movie_position + ", movie_playedtime=" + movie_playedtime
				+ ", playList=" + playList + "]";
	}

	/**
	 * 
	 * @return 缁煎悎绫诲瀷淇℃伅鐨勫畬鏁村獟浣撳悕绉?	 */
	public String getCompleteMediaName() {
		String name = "";
		if (!StringUtil.isEmpty(medianame) && !StringUtil.isEmpty(taskname)) {
			if (!medianame.equals(taskname)) {
				name = medianame + " " + taskname;
			}else {
				name = medianame;
			}
		} else if (!StringUtil.isEmpty(medianame)
				&& StringUtil.isEmpty(taskname)) {
			name = medianame;
		} 
		return name;
	}
	

	public String getmLocalPlayerUrl() {
		return mLocalPlayerUrl;
	}


	public void setmLocalPlayerUrl(String mLocalPlayerUrl) {
		this.mLocalPlayerUrl = mLocalPlayerUrl;
	}
	
	
	
	
}