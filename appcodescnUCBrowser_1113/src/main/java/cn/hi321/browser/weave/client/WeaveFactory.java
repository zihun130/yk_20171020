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

/**
 * @author Patrick Woodworth
 */
public class WeaveFactory {

  private WeaveTransport m_transport;
  private final boolean m_acceptInvalidCerts;
  private final boolean m_useConnectionPool;

  public WeaveFactory(boolean acceptInvalidCerts) {
    m_acceptInvalidCerts = acceptInvalidCerts;
    m_useConnectionPool = WeaveConstants.CONNECTION_POOL_ENABLED_DEFAULT;
  }

  public UserWeave createUserWeave(URI server, String username, String password) {
    return new UserWeave(getWeaveTransport(), server, username, password);
  }

  public boolean isInvalidCertsAccepted() {
    return m_acceptInvalidCerts;
  }

  public boolean isConnectionPoolEnabled() {
    return m_useConnectionPool;
  }

  protected WeaveTransport createWeaveTransport() {
    return new WeaveTransport(isConnectionPoolEnabled(), isInvalidCertsAccepted());
  }

  protected synchronized WeaveTransport getWeaveTransport() {
    if (m_transport == null) {
      m_transport = createWeaveTransport();
    }
    return m_transport;
  }
}