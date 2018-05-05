package offer;

/**
 * ��ָoffer-��53��������ʽƥ��
 * 
 * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������� ������0�Σ���
 * �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬�� ����"aa.a"��"ab*a"����ƥ��
 */

public class Test53 {
	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		} else if (str.length == 0 && pattern.length == 0) {
			return true;
		}
		return matchCore(str, pattern, 0, 0);
	}

	public boolean matchCore(char[] str, char[] pattern, int strIndex, int patternIndex) {
		int strLength = str.length;
		int patternLength = pattern.length;
		if (strIndex == strLength && patternIndex == patternLength) {
			return true;
		}
		if (strIndex != strLength && patternIndex == patternLength) {
			return false;
		}
		if (patternIndex + 1 < patternLength && pattern[patternIndex + 1] == '*') {
			if ((strIndex < strLength && str[strIndex] == pattern[patternIndex])
					|| (pattern[patternIndex] == '.' && strIndex < strLength)) {
				return matchCore(str, pattern, strIndex, patternIndex + 2)
						|| matchCore(str, pattern, strIndex + 1, patternIndex);
			} else {
				return matchCore(str, pattern, strIndex, patternIndex + 2);
			}
		} else if (patternIndex < patternLength && strIndex < strLength
				&& (str[strIndex] == pattern[patternIndex] || (pattern[patternIndex] == '.'))) {
			return matchCore(str, pattern, ++strIndex, ++patternIndex);
		}
		return false;
	}

	public static void main(String[] args) {
		char[] str = { 'a', 'a', 'a' };
		char[] pattern = { 'a', '*' };
		System.out.println(new Test53().match(str, pattern));
	}

}
