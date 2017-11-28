/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
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