package offer;

/**
 * ��ָoffer-��52�������˻�����
 * 
 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 */

public class Test52 {
	public int[] multiply(int[] A) {
		int[] array = new int[A.length];
		if (A.length > 1) {
			array[0] = 1;
			for (int i = 1; i < A.length; i++) {
				array[i] = array[i - 1] * A[i - 1];
			}
			int temp = 1;
			for (int i = A.length - 2; i >= 0; i--) {
				temp *= A[i + 1];
				array[i] *= temp;
			}
		}
		return array;
	}

	public static void main(String[] args) {
		int[] A = { 2, 3, 4, 5};
		int[] array = new Test52().multiply(A);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
