/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
 */
package cn.hi321.browser.weave.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.Date;

/**
* @author Patrick Woodworth
*/
public class WeaveResponse {

  private final WeaveTransport.WeaveResponseHeaders m_responseHeaders;
  private final String m_body;
  private URI m_uri;

  public WeaveResponse(HttpResponse response) throws IOException {
    m_responseHeaders = new WeaveTransport.WeaveResponseHeaders(response);
    HttpEntity entity = response.getEntity();
    m_body = entity == null ? null : EntityUtils.toString(entity);
  }

  public WeaveTransport.WeaveResponseHeaders getResponseHeaders() {
    return m_responseHeaders;
  }

  public String getBody() {
    return m_body;
  }

  public Date getServerTimestamp() {
    return m_responseHeaders.getServerTimestamp();
  }

  public long getBackoffSeconds() {
    return m_responseHeaders.getBackoffSeconds();
  }

  public URI getUri() {
    return m_uri;
  }

  public void setUri(URI uri) {
    m_uri = uri;
  }
}