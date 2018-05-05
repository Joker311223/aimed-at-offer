package offer;

/**
 * ��ָoffer-��55���ַ����е�һ�����ظ����ַ�
 * 
 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ��
 * ���ַ���"g"�����Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
 */

public class Test55 {
	int[] occurrence = new int[256];
	int index = 1;

	// Insert one char from stringstream
	public void Insert(char ch) {
		if (occurrence[ch] == 0) {
			occurrence[ch] = index;
		} else {
			occurrence[ch] = -1;
		}
		index++;
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		int maxIndex = Integer.MAX_VALUE;
		char ch = '#';
		for (int i = 0; i < occurrence.length; i++) {
			if (occurrence[i] > 0 && occurrence[i] < maxIndex) {
				maxIndex = occurrence[i];
				ch = (char) i;
			}
		}
		return ch;
	}

	public static void main(String[] args) {
		Test55 test55 = new Test55();
		test55.Insert('g');
		test55.Insert('o');
		test55.Insert('o');
		test55.Insert('g');
		test55.Insert('l');
		test55.Insert('e');
		System.out.println(test55.FirstAppearingOnce());
	}
}
