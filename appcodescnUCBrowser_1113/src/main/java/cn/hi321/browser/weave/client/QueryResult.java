/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.weave.client;

import java.net.URI;
import java.util.Date;

/**
 * @author Patrick Woodworth
 */
public class QueryResult<T> {

  private final URI m_uri;

  private Date m_serverTimestamp;

  private T m_value;

  QueryResult(WeaveResponse response) {
    this(response, null);
  }

  QueryResult(WeaveResponse response, T value) {
    m_uri = response.getUri();
    m_serverTimestamp = response.getServerTimestamp();
    m_value = value;
  }

  public URI getUri() {
    return m_uri;
  }

  public Date getServerTimestamp() {
    return m_serverTimestamp;
  }

  public T getValue() {
    return m_value;
  }

  void setValue(T value) {
    m_value = value;
  }

  public long getServerTimestampInSeconds() {
    if (m_serverTimestamp != null)
      return m_serverTimestamp.getTime();
    return 0;
  }
}