/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.weave.client;

import java.util.Date;

/**
 * @author Patrick Woodworth
 */
public class QueryParams {

  private Date m_older;

  private Date m_newer;

  private boolean m_full = true;

  private String m_sort = "newest";

  public QueryParams() {
  }

  public Date getOlder() {
    return m_older;
  }

  public QueryParams setOlder(Date older) {
    m_older = older;
    return this;
  }

  public Date getNewer() {
    return m_newer;
  }

  public QueryParams setNewer(Date newer) {
    m_newer = newer;
    return this;
  }

  public boolean isFull() {
    return m_full;
  }

  public QueryParams setFull(boolean full) {
    m_full = full;
    return this;
  }

  public String getSort() {
    return m_sort;
  }

  public QueryParams setSort(String sort) {
    m_sort = sort;
    return this;
  }

  public String toQueryString() {
    StringBuffer retval = new StringBuffer();
    retval.append("?full=").append(m_full ? "1" : "0");
    if (m_sort != null)
      retval.append("&sort=").append(m_sort);
    if (m_older != null)
      retval.append("&older=").append(WeaveUtil.toModifiedTimeString(m_older));
    if (m_newer != null)
      retval.append("&newer=").append(WeaveUtil.toModifiedTimeString(m_newer));
    return retval.toString();
  }

  @Override
  public String toString() {
    return toQueryString();
  }
}