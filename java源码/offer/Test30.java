package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * ��ָoffer-��30����С��k����
 * 
 * ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4��
 */

public class Test30 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (input == null || input.length == 0 || k > input.length || k == 0) {
			return list;
		} else {
			// Ĭ����ͨ����Ȼ˳���������С�ѣ�������Ҫ����һ���Ƚ�����ʵ������
			PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
			});
			for (int i = 0; i < input.length; i++) {
				if (maxHeap.size() < k) {
					maxHeap.offer(new Integer(input[i]));
				} else if (maxHeap.peek() > input[i]) {
					maxHeap.poll();
					maxHeap.offer(input[i]);
				}
			}
			Iterator<Integer> iterator = maxHeap.iterator();
			while (iterator.hasNext()) {
				list.add((Integer) iterator.next());
			}
			return list;
		}
	}

	public static void main(String[] args) {
		int[] array = { 4, 5, 1, 6, 2, 7, 3, 8 };
		ArrayList<Integer> list = new Test30().GetLeastNumbers_Solution(array, 5);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
