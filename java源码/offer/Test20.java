package offer;

import java.util.ArrayList;

/**
 * ��ָoffer-��20��˳ʱ���ӡ����
 * 
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣����磬����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class Test20 {
	ArrayList<Integer> arrayList;

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		if (rows == 0 || cols == 0) {
			return null;
		}
		int start = 0;
		arrayList = new ArrayList<Integer>();
		while (cols > 2 * start && rows > 2 * start) {
			printMatrixInCircle(matrix, rows, cols, start);
			start++;
		}
		return arrayList;
	}

	public void printMatrixInCircle(int[][] matrix, int rows, int cols, int start) {
		int endX = cols - 1 - start;
		int endY = rows - 1 - start;

		// �����Ҵ�ӡһ��
		for (int i = start; i <= endX; i++) {
			arrayList.add(new Integer(matrix[start][i]));
		}

		// ���ϵ��´�ӡһ��
		if (endY > start) {
			for (int i = start + 1; i <= endY; i++) {
				arrayList.add(new Integer(matrix[i][endX]));
			}
		}

		// ���������ӡһ��
		if (endY > start && endX > start) {
			for (int i = endX - 1; i >= start; i--) {
				arrayList.add(new Integer(matrix[endY][i]));
			}
		}

		// �������ϴ�ӡһ��
		if (endX > start && endY > start + 1) {
			for (int i = endY - 1; i > start; i--) {
				arrayList.add(new Integer(matrix[i][start]));
			}

		}

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		ArrayList<Integer> list = new Test20().printMatrix(matrix);
		for (Integer integer : list) {
			System.out.print(integer + ", ");
		}
	}
}
