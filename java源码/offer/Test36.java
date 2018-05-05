package offer;

/**
 * ��ָoffer-��36�������е������
 * 
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ������,�����������е�����Ե�����P������P��1000000007ȡģ�Ľ�������
 * �����P%1000000007
 */

public class Test36 {
	public int InversePairs(int[] array) {
		if (array.length == 0) {
			return 0;
		} else {
			int[] copyArray = new int[array.length];
			for (int i = 0; i < array.length; i++) {
				copyArray[i] = array[i];
			}
			return InversePairsCore(0, array.length - 1, array, copyArray) % 1000000007;
		}
	}

	public int InversePairsCore(int start, int end, int[] array, int[] copyArray) {
		if (start == end) {
			copyArray[start] = array[start];
			return 0;
		}
		int length = (end - start) / 2;
		int left = InversePairsCore(start, start + length, copyArray, array);
		int right = InversePairsCore(start + length + 1, end, copyArray, array);
		int i = start + length; // ǰ������һ�����ֵ��±�
		int j = end;// �������һ�����ֵ��±�
		int copyIndex = end;
		int count = 0;
		while (i >= start && j >= start + length + 1) {
			if (array[i] > array[j]) {
				copyArray[copyIndex--] = array[i--];
				count += j - start - length;
			} else {
				copyArray[copyIndex--] = array[j--];
			}
		}
		for (; i >= start;) {
			copyArray[copyIndex--] = array[i--];
		}
		for (; j >= start + length + 1;) {
			copyArray[copyIndex--] = array[j--];
		}
		return left + right + count;
	}

	public static void main(String[] args) {
		int[] array = { 7, 5, 6, 4, 2 };
		System.out.println(new Test36().InversePairs(array));
	}

}
