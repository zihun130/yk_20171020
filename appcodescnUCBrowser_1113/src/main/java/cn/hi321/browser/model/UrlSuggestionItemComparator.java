/*
 *  http://www.appcodes.cn APP��ƷԴ������վ������
 * 1����վԴ��Ϊ�����Ѽ��������ṩ������漰���ֺ������İ� Ȩ��������֪ͨ���ǡ� 
 * 2�� ��վ�ṩ��Ѵ���ֻ�ɹ��о�ѧϰʹ�ã�����������ҵ��; �ɴ�����һ�к���뱾վ�޹ء�
 * 3�� ��ҵԴ������Դ����Ȩ��Χ�ڽ���ʹ�á�
 * 4������APP��ƷԴ�����������:http://www.appcodes.cn��
 * 5�����������뷢��Ϣ��appcodes@qq.com��
 */
package cn.hi321.browser.model;

import java.util.Comparator;

import cn.hi321.browser.model.items.UrlSuggestionItem;

/**
 * Comparator for UrlSuggestionItem.
 */
public class UrlSuggestionItemComparator implements Comparator<UrlSuggestionItem> {

	@Override
	public int compare(UrlSuggestionItem object1, UrlSuggestionItem object2) {
		Float value1 = new Float(object1.getNote());
		Float value2 = new Float(object2.getNote());
		return value2.compareTo(value1);
	}

}