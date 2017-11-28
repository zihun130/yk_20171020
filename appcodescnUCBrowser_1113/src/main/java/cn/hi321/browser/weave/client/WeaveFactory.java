/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
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