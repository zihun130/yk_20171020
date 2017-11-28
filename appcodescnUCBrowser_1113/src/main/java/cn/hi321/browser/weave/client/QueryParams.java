/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
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