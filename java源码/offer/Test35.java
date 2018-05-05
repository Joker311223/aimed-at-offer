package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * ��ָoffer-��35����һ��ֻ����һ�ε��ַ�
 * 
 * ��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��
 */

public class Test35 {
	public int FirstNotRepeatingChar(String str) {
		if (str == null || str.length() == 0) {
			return -1;
		} else {
			Map<Character, Integer> charMap = new HashMap<Character, Integer>();
			char[] charArray = str.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				if (!charMap.containsKey(charArray[i])) {
					charMap.put(charArray[i], 1);
				} else {
					charMap.put(charArray[i], charMap.get(charArray[i]) + 1);
				}
			}
			for (int i = 0; i < charArray.length; i++) {
				if (charMap.get(charArray[i]) == 1) {
					return i;
				}
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		String str = "abaccdeff";
		System.out.println(new Test35().FirstNotRepeatingChar(str));
	}
}
