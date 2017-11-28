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