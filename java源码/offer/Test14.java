package offer;

/**
 * ��ָoffer-��14����������˳��ʹ����λ��ż��ǰ��
 * 
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������
 * ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 */

public class Test14 {

	// �÷���ʵ�ֵ��ǵ��������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣��������λ��
	public void array(int[] array) {
		int firstIndex = 0;
		int lastIndex = array.length - 1;
		while (firstIndex < lastIndex) {
			while (firstIndex < lastIndex && isEven(array[firstIndex])) {
				firstIndex++;
			}
			while (firstIndex < lastIndex && !isEven(array[lastIndex])) {
				lastIndex--;
			}
			if (firstIndex < lastIndex) {
				int temp = array[firstIndex];
				array[firstIndex] = array[lastIndex];
				array[lastIndex] = temp;
			}
		}
	}

	// �÷���ʵ�ֵ��ǵ��������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż
	// ��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò���
	public void newArray(int[] array) {
		int j;
		int i = 1;
		while (i < array.length && !isEven(array[i])) {
			i++;
		}
		while (i < array.length) {
			j = i - 1;
			int temp = array[i];
			while (j >= 0 && !isEven(array[j])) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
			i++;
			while (i < array.length && !isEven(array[i])) {
				i++;
			}
		}
	}

	public boolean isEven(int num) { // �ж��Ƿ����������Ƿ���true
		return (num & 0x1) == 1;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		// new Test10().array(array);
		new Test14().newArray(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
	}

}
