/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
 */
package cn.hi321.browser.weave.client;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;

/**
* @author Patrick Woodworth
*/
public class WeaveAccountInfo {

  private final URI m_server;
  private final String m_username;
  private final String m_password;
  private final char[] m_secret;

  private WeaveAccountInfo(URI server, String username, String password, char[] secret) {
    if (server == null)
      throw new NullPointerException("server was null");
    if (username == null)
      throw new NullPointerException("username was null");
    if (password == null)
      throw new NullPointerException("password was null");
    if (secret == null)
      throw new NullPointerException("secret was null");
    m_server = server;
    m_username = username;
    m_password = password;
    m_secret = secret;
  }

  public URI getServer() {
    return m_server;
  }

  public String getServerAsString() {
    return WeaveUtil.toString(getServer());
  }

  public String getUsername() {
    return m_username;
  }

  public String getPassword() {
    return m_password;
  }

  public String getSecretAsString() {
    return m_secret == null ? null : new String(m_secret);
  }

  public char[] getSecret() {
    return m_secret;
  }

  public String toAuthToken() {
    try {
      JSONObject retval = new JSONObject();
      retval.put("server", getServerAsString());
      retval.put("username", getUsername());
      retval.put("password", getPassword());
      retval.put("secret", getSecretAsString());
      return retval.toString();
    } catch (JSONException e) {
      throw new IllegalStateException(e);
    }
  }

  @Override
  public String toString() {
    try {
      return toAuthToken();
    } catch (Exception ignored) { }
    return super.toString();
  }

  public static WeaveAccountInfo createWeaveAccountInfo(String authtoken) {
    try {
      JSONObject retval = new JSONObject(authtoken);
      URI server = URI.create(retval.getString("server"));
      String username = retval.getString("username");
      String password = retval.getString("password");
      char[] secret = retval.getString("secret").toCharArray();
      return createWeaveAccountInfo(server, username, password, secret);
    } catch (JSONException e) {
      throw new IllegalStateException(e);
    }
  }

  public static WeaveAccountInfo createWeaveAccountInfo(String serverUri, String username, String password, char[] encsecret) throws URISyntaxException {
    return createWeaveAccountInfo(new URI(serverUri), username, password, encsecret);
  }

  public static WeaveAccountInfo createWeaveAccountInfo(URI serverUri, String username, String password, char[] encsecret) {
    return new WeaveAccountInfo(serverUri, username, password, encsecret);
  }
}