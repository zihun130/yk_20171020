/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
 */
package cn.hi321.browser.weave.client;

import java.security.Key;

/**
* @author Patrick Woodworth
*/
class BulkKeyCouplet {
  public final Key cipherKey;
  public final Key hmacKey;

  public BulkKeyCouplet(Key cipherKey, Key hmacKey) {
    this.cipherKey = cipherKey;
    this.hmacKey = hmacKey;
  }
}