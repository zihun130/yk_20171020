/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.weave.client;

/**
 * @author Patrick Woodworth
 */
enum WeaveHeader {

  X_WEAVE_BACKOFF("X-Weave-Backoff"),
  X_WEAVE_ALERT("X-Weave-Alert"),
  X_WEAVE_TIMESTAMP("X-Weave-Timestamp"),
  X_WEAVE_RECORDS("X-Weave-Records"),
  X_WEAVE_IF_UNMODIFIED_SINCE("X-If-Unmodified-Since"),
  ;

  private final String m_name;

  WeaveHeader(String name) {
    m_name = name;
  }

  public String getName() {
    return m_name;
  }
}