package offer;

/**
 * ��ָoffer-��40��������ֻ����һ�ε�����
 * 
 * һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�Ҫ��ʱ�临�Ӷ���O(n),�ռ临�Ӷ���O(1)
 */

public class Test40 {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array.length < 2) {
			return;
		}
		int resultXOR = 0;
		for (int i = 0; i < array.length; i++) {
			resultXOR ^= array[i];
		}
		int index = getFirstBitIndex(resultXOR);
		for (int i = 0; i < array.length; i++) {
			if (isBit1(array[i], index)) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}
	}

	// ���ؽ������֮��������е�һ��Ϊ1��λ��
	public int getFirstBitIndex(int num) {
		int index = 0;
		while ((num & 1) != 1 && index < 32) {
			num = num >> 1;
			index++;
		}
		return index;
	}

	// �ж�ĳ�����Ķ����ƴ�����������ָ��λ�Ƿ���1
	public boolean isBit1(int num, int index) {
		return (num >> index & 1) == 1;
	}

	public static void main(String[] args) {
		Test40 test40 = new Test40();
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		int[] array = { 2, 4, 3, 6, 3, 2, 5, 5 };
		test40.FindNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0] + "--" + num2[0]);
	}
}
