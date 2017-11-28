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
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/**
 * @author Patrick Woodworth
 */
public class WeaveUtil {

  private static final String JSON_STREAM_TYPE = "application/json";
  private static final String ENTITY_CHARSET_NAME = "UTF-8";

  private WeaveUtil() {
    // no instantiation
  }

  @SuppressWarnings({})
  public static void checkNull(URI uri) {
    if (uri == null) {
      Dbg.w(new IllegalArgumentException("checkNull(URI) had null arg"));
    } else if (uri.getHost() == null || uri.getHost().length() < 1) {
      Dbg.w(new IllegalArgumentException("checkNull(URI) had empty host"));
    }
  }

  @SuppressWarnings({})
  public static void checkNull(String str) {
    if (str == null || str.trim().length() < 1) {
      Dbg.w(new IllegalArgumentException("checkNull(String) had empty arg"));
    }
  }

  public static String toModifiedTimeString(Date modified) {
    long time = modified.getTime();
    double timed = time / 1000.0;
    String retval = String.format(Locale.ENGLISH, "%.2f", timed);      
//    Dbg.debug("TIME: " + retval);
    return retval;
  }

  public static Date toModifiedTimeDate(String modified) {
    @SuppressWarnings("unused")
	long now = System.currentTimeMillis();
    try {
      double modDouble = Double.parseDouble(modified) * 1000;
      long mod = Math.round(modDouble);
//      Dbg.printf("mod: %d ; cur : %d ; delta : %d\n", mod, now, now - mod);
      return new Date(mod);
    } catch (Exception e) {
      return new Date(); // todo buggy ?
    }
  }

  public static Date toModifiedTimeDate(double modDouble) {
    try {
      long mod = Math.round(modDouble * 1000);
      return new Date(mod);
    } catch (Exception e) {
      return null;
    }
  }

  public static UriBuilder buildUpon(URI serverUri) {
    return new UriBuilder(serverUri);
  }

  public static void dump(JSONObject jsonObject) {
    try {
      String out = jsonObject.toString(2);
      System.out.println(out);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  public static String encodeUriSegment(String segment) {
    try {
      return URLEncoder.encode(segment, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException(e);
    }
  }

  public static String toString(URI uri) {
    checkNull(uri);
    String retval = uri == null ? null : uri.toString();
    checkNull(retval);
    return retval;
  }

  public static byte[] toAsciiBytes(String data) {
    try {
      return data == null ? null : data.getBytes("US-ASCII");
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException(e);
    }
  }

  public static String toAsciiString(byte[] data) {
    try {
      return data == null ? null : new String(data, "US-ASCII");
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException(e);
    }
  }

  public static byte[] toUtf8Bytes(String data) {
    try {
      return data == null ? null : data.getBytes("UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException(e);
    }
  }

  public static String toUtf8String(byte[] data) {
    try {
      return data == null ? null : new String(data, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException(e);
    }
  }

  public static void zeroize(char[] secret) {
    if (secret != null)
      Arrays.fill(secret, '\0');
  }

  @SuppressWarnings("unused")
  private static HttpEntity toHttpEntity(JSONArray jsonArray) throws JSONException {
    try {
      StringEntity entity = new StringEntity(jsonArray.toString(0), ENTITY_CHARSET_NAME);
      entity.setContentType(JSON_STREAM_TYPE + HTTP.CHARSET_PARAM + ENTITY_CHARSET_NAME);
      return entity;
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException(e);
    }
  }

  @SuppressWarnings("unused")
  private static HttpEntity toHttpEntity(WeaveBasicObject wbo) throws JSONException {
    try {
      StringEntity entity = new StringEntity(wbo.toJSONObjectString(), ENTITY_CHARSET_NAME);
      entity.setContentType(JSON_STREAM_TYPE + HTTP.CHARSET_PARAM + ENTITY_CHARSET_NAME);
      return entity;
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException(e);
    }
  }

  public static class UriBuilder {

    private String m_val;

    public UriBuilder(URI uri) {
      m_val = uri.toASCIIString();
    }

    public void appendEncodedPath(String s) {
      if (m_val.charAt(m_val.length() - 1) != '/')
        m_val += "/";
      m_val += s;
    }

    public URI build() {
      try {
        return URI.create(m_val);
      } catch (IllegalArgumentException e) {
        Dbg.w("BAD URI: %s", m_val);
        throw e;
      }
    }
  }
}