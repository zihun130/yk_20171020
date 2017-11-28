/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.weave.client;

import org.apache.http.client.HttpResponseException;

/**
 * @author Patrick Woodworth
 */
@SuppressWarnings("serial")
public class WeaveException extends Exception {

  private final WeaveException.ExceptionType m_type;

  public WeaveException() {
    this(WeaveException.ExceptionType.GENERAL);
  }

  public WeaveException(WeaveException.ExceptionType type) {
    m_type = type;
  }

  public WeaveException(String message) {
    this(WeaveException.ExceptionType.GENERAL, message);
  }

  public WeaveException(WeaveException.ExceptionType type, String message) {
    super(message);
    m_type = type;
  }

  public WeaveException(Throwable cause) {
    this(WeaveException.ExceptionType.GENERAL, cause);
  }

  public WeaveException(WeaveException.ExceptionType type, Throwable cause) {
    super(cause);
    m_type = type;
  }

  public WeaveException(String message, Throwable cause) {
    this(WeaveException.ExceptionType.GENERAL, message, cause);
  }

  public WeaveException(WeaveException.ExceptionType type, String message, Throwable cause) {
    super(message, cause);
    m_type = type;
  }

  public WeaveException.ExceptionType getType() {
    return m_type;
  }

  public static boolean isAuthFailure(HttpResponseException e) {
    int statusCode = e.getStatusCode();
    if (WeaveConstants.UNAUTHORIZED_HTTP_STATUS_CODE == statusCode)
      return true;
    return false;
  }

  public enum ExceptionType {
    GENERAL,
    BACKOFF,
    ;
  }
}