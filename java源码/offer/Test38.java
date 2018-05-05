package offer;

/**
 * ��ָoffer-��38�����������������г��ֵĴ���
 * 
 * ͳ��һ�����������������г��ֵĴ�����
 */

public class Test38 {
	public int GetNumberOfK(int[] array, int k) {
		if (array.length == 0) {
			return 0;
		} else {
			int arrayLength = array.length;
			int firstKIndex = getFirstK(array, k, 0, arrayLength - 1);
			int lastKIndex = getLastK(array, k, 0, arrayLength - 1);
			if (firstKIndex >= 0 && lastKIndex >= 0) {
				return lastKIndex - firstKIndex + 1;
			} else {
				return 0;
			}
		}
	}

	// ��ȡ��һ��k��λ��
	public int getFirstK(int[] array, int k, int start, int end) {
		if (end < start) {
			return -1;
		} else {
			int middleIndex = (start + end) / 2;
			if (array[middleIndex] == k) {
				if ((middleIndex > 0 && array[middleIndex - 1] != k) || middleIndex == 0) {
					return middleIndex;
				} else {
					end = middleIndex - 1;
				}
			} else if (array[middleIndex] < k) {
				start = middleIndex + 1;
			} else {
				end = middleIndex - 1;
			}
			return getFirstK(array, k, start, end);
		}
	}

	// ��ȡ���һ��k��λ��
	public int getLastK(int[] array, int k, int start, int end) {
		if (end < start) {
			return -1;
		} else {
			int middleIndex = (start + end) / 2;
			if (array[middleIndex] == k) {
				if ((middleIndex < array.length - 1 && array[middleIndex + 1] != k)
						|| middleIndex == array.length - 1) {
					return middleIndex;
				} else {
					start = middleIndex + 1;
				}
			} else if (array[middleIndex] < k) {
				start = middleIndex + 1;
			} else {
				end = middleIndex - 1;
			}
			return getLastK(array, k, start, end);
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 3, 3, 3, 3, 4, 5 };
		System.out.println(new Test38().GetNumberOfK(array, 3));
	}
}
