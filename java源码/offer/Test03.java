package offer;

/**
 * ��ָoffer-��3����ά�����еĲ���
 * 
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ���
 * ��˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 */

public class Test03 {
	public boolean Find(int target, int[][] array) {
		if (array.length > 0 && array[0].length > 0) {
			int row = array.length;
			int col = array[0].length;
			if (target < array[0][0] || target > array[row - 1][col - 1]) {
				return false;
			} else {
				for (int i = 0; i < row; i++) {
					if (target == array[i][0] || target == array[i][col - 1]) {
						return true;
					} else if (target > array[i][0] || target < array[i][col - 1]) {
						for (int j = 1; j < col - 1; j++) {
							if (target == array[i][j]) {
								return true;
							}
						}
					} else {
						continue;
					}
				}
				return false;
			}
		} else {
			return false;
		}
	}

	// ���ϵķ���
	public boolean Find2(int target, int[][] array) {
		if (array.length > 0 && array[0].length > 0) {
			int arrlen = array.length;
			int col = array[0].length - 1;
			int row = 0;
			while (row < arrlen && col >= 0) {
				if (array[row][col] < target) {
					row++;
				} else if (array[row][col] > target) {
					col--;
				} else {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		int[][] array2 = new int[0][0];
		Test03 test03 = new Test03();
		System.out.println(test03.Find(1, array));
		System.out.println(test03.Find(1, array2));
		System.out.println(test03.Find2(1, array));
		System.out.println(test03.Find2(1, array2));
	}
}
