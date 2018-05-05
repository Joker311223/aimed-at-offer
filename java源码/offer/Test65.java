package offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ��ָoffer-��65���������ڵ����ֵ
 * 
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ
 * ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
 * {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}��
 * {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 */

public class Test65 {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> maxList = new ArrayList<Integer>();
		if (num.length >= size && size >= 1) {
			LinkedList<Integer> indexQueue = new LinkedList<Integer>();
			for (int i = 0; i < size; i++) {
				while (!indexQueue.isEmpty() && num[i] >= num[indexQueue.getLast()]) {
					indexQueue.pollLast();
				}
				indexQueue.offerLast(i);
			}
			for (int i = size; i < num.length; i++) {
				maxList.add(num[indexQueue.getFirst()]);
				while (!indexQueue.isEmpty() && num[i] >= num[indexQueue.getLast()]) {
					indexQueue.pollLast();
				}
				if (!indexQueue.isEmpty() && indexQueue.getFirst() <= i - size) {
					indexQueue.pollFirst();
				}
				indexQueue.offerLast(i);
			}
			maxList.add(num[indexQueue.getFirst()]);
		}
		return maxList;
	}

	public static void main(String[] args) {
		int[] num = { 2, 3, 4, 2, 6, 2, 5, 1 };
		int size = 3;
		ArrayList<Integer> maxList = new Test65().maxInWindows(num, size);
		for (Integer value : maxList) {
			System.out.print(value + " ");
		}
	}
}
