/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
 */
package cn.hi321.browser.weave.client;

/**
 * @author Patrick Woodworth
 */
enum WeaveHeader {

  X_WEAVE_BACKOFF("X-Weave-Backoff"),
  X_WEAVE_ALERT("X-Weave-Alert"),
  X_WEAVE_TIMESTAMP("X-Weave-Timestamp"),
  X_WEAVE_RECORDS("X-Weave-Records"),
  X_WEAVE_IF_UNMODIFIED_SINCE("X-If-Unmodified-Since"),
  ;

  private final String m_name;

  WeaveHeader(String name) {
    m_name = name;
  }

  public String getName() {
    return m_name;
  }
}