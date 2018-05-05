package offer;

/**
 * ��ָoffer-��42����ת����˳��VS����ת�ַ���
 * 
 * ��һ������һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣Ϊ������������ź���ͨ��ĸһ�������������� �ַ���"I am a
 * student.",�����"student. a am I"
 * 
 * ������ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β�����붨��һ������ʵ���ַ�������ת������ ���ܡ���������
 * �ַ���"abcdefg"������2���ú�������������ת2λ�õ��Ľ��"cdefgab"
 */

public class Test42 {
	// ��һ
	public String ReverseSentence(String str) {
		if (str == null) {
			return null;
		} else if (str.trim().equals("")) {
			return str;
		} else {
			char[] charArray = str.toCharArray();
			// ��ת�����ַ���
			charArray = reverse(charArray, 0, charArray.length - 1);
			int beginIndex = 0;
			int endIndex = 0;
			while (endIndex < charArray.length) {
				if (charArray[beginIndex] == ' ') {
					beginIndex++;
					endIndex++;
				} else if (charArray[endIndex] == ' ' || endIndex == charArray.length - 1) {
					if (endIndex == charArray.length - 1) {
						charArray = reverse(charArray, beginIndex, endIndex);
					} else {
						charArray = reverse(charArray, beginIndex, --endIndex);
					}
					beginIndex = ++endIndex;
				} else {
					endIndex++;
				}
			}
			return String.valueOf(charArray);
		}
	}

	public char[] reverse(char[] charArray, int i, int j) {
		if (charArray.length == 0) {
			return null;
		}
		while (i < j) {
			char temp = charArray[i];
			charArray[i++] = charArray[j];
			charArray[j--] = temp;
		}
		return charArray;
	}

	// ���
	public String LeftRotateString(String str, int n) {
		if (str == null) {
			return null;
		} else if (n > 0 && n < str.length() && str.length() > 0) {
			char[] charArray = str.toCharArray();
			charArray = reverse(charArray, 0, n - 1);
			charArray = reverse(charArray, n, str.length() - 1);
			charArray = reverse(charArray, 0, str.length() - 1);
			return String.valueOf(charArray);
		} else {
			return str;
		}
	}

	public static void main(String[] args) {
		Test42 test42 = new Test42();
		String str1 = "I am a student.";
		String str2 = "abcdefg";
		System.out.println(test42.ReverseSentence(str1));
		System.out.println(test42.LeftRotateString(str2, 2));
	}
}
