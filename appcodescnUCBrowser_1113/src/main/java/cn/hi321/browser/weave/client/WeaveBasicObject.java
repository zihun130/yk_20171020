/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.weave.client;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Date;

/**
 * @author Patrick Woodworth
 */
public class WeaveBasicObject {

  private URI m_uri = null;
  private final URI m_queryUri;
  private final JSONObject m_nodeObj;

  public WeaveBasicObject(URI queryUri, JSONObject nodeObj) {
    m_queryUri = queryUri;
    m_nodeObj = nodeObj;
  }

  public String getId() throws JSONException {
    return m_nodeObj.getString("id");
  }

  public String getSortIndex() throws JSONException {
    return m_nodeObj.getString("sortindex");
  }

  public String getModified() throws JSONException {
    return m_nodeObj.getString("modified");
  }

  public Date getModifiedDate() throws JSONException {
    return WeaveUtil.toModifiedTimeDate(getModified());
  }
  
  public URI getUri() throws JSONException {
    if (m_uri == null) {
      try {
        String baseUriStr = m_queryUri.toASCIIString();
        String queryPart = m_queryUri.getRawQuery();
        if (queryPart != null)
          baseUriStr = baseUriStr.substring(0, baseUriStr.indexOf(queryPart) - 1);
        if (!baseUriStr.endsWith("/"))
          baseUriStr += "/";
        String nodeUriStr = baseUriStr + new URI(null,null,getId(), null).toASCIIString();
        m_uri = new URI(nodeUriStr);
      } catch (URISyntaxException e) {
        throw new JSONException(e.getMessage());
      }
    }
    return m_uri;
  }

  public JSONObject getPayload() throws JSONException {
    return new JSONObject(m_nodeObj.getString("payload"));
  }

  public JSONObject getEncryptedPayload(UserWeave weave, char[] secret)
      throws JSONException, IOException, GeneralSecurityException, WeaveException {
    WeaveEncryptedObject weo = new WeaveEncryptedObject(getPayload());
    byte[] syncKey = Base32.decodeModified(new String(secret)); // todo don't convert to string
    BulkKeyCouplet bulkKeyPair = weave.getBulkKeyPair(syncKey);
    return weo.decryptObject(bulkKeyPair);
  }

  public JSONObject getEncryptedPayload(Key bulkKey, Key hmacKey)
      throws JSONException, IOException, GeneralSecurityException, WeaveException {
    WeaveEncryptedObject weo = new WeaveEncryptedObject(getPayload());
    return weo.decryptObject(bulkKey, hmacKey);
  }

  public JSONObject toJSONObject() {
    return m_nodeObj;
  }

  public String toJSONObjectString() throws JSONException {
    return toJSONObject().toString(0);
  }

  public static class WeaveEncryptedObject {

    private final JSONObject m_nodeObj;

    public WeaveEncryptedObject(JSONObject nodeObj) {
      m_nodeObj = nodeObj;
    }

    public String getHmac() throws JSONException {
      return m_nodeObj.getString("hmac");
    }

    public String getCiphertext() throws JSONException {
      return m_nodeObj.getString("ciphertext");
    }

    public String getIv() throws JSONException {
      return m_nodeObj.getString("IV");
    }

    public JSONObject decryptObject(BulkKeyCouplet keyPair) throws GeneralSecurityException, JSONException {
      return decryptObject(keyPair.cipherKey, keyPair.hmacKey);
    }

    public JSONObject decryptObject(Key key, Key hmacKey) throws GeneralSecurityException, JSONException {
      byte[] bytes = WeaveCryptoUtil.getInstance().decrypt(key, hmacKey, getCiphertext(), getIv(), getHmac());
      return new JSONObject(WeaveUtil.toUtf8String(bytes));
    }
  }
}