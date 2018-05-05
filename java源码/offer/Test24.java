package offer;

import java.util.Arrays;

/**
 * ��ָoffer-��24�������������ĺ�����������
 * 
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No���������������������������ֶ�������ͬ��
 */

public class Test24 {
	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence.length <= 0) {
			return false;
		}
		int rootValue = sequence[sequence.length - 1];
		int leftTreeIndex, rightTreeIndex; // ��������������
		for (leftTreeIndex = 0; leftTreeIndex < sequence.length - 1; leftTreeIndex++) {
			if (sequence[leftTreeIndex] > rootValue) {
				break;
			}
		}
		for (rightTreeIndex = leftTreeIndex; rightTreeIndex < sequence.length - 1; rightTreeIndex++) {
			if (sequence[rightTreeIndex] < rootValue) {
				return false;
			}
		}
		boolean leftTree = true;
		boolean rightTree = true;
		if (leftTreeIndex > 0) {
			int[] leftArray = Arrays.copyOfRange(sequence, 0, leftTreeIndex);
			leftTree = VerifySquenceOfBST(leftArray);
		}
		if (leftTreeIndex < sequence.length - 1) {
			int[] rightArray = Arrays.copyOfRange(sequence, leftTreeIndex, sequence.length - 1);
			rightTree = VerifySquenceOfBST(rightArray);
		}
		return leftTree && rightTree;
	}

	public static void main(String[] args) {
		int[] sequence = { 5, 7, 6, 9, 11, 10, 8 };
		System.out.println(new Test24().VerifySquenceOfBST(sequence));
	}
}
