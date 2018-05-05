package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ��ָoffer-��64���������е���λ��
 * 
 * ��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ�������
 * �������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 */

public class Test64 {
	PriorityQueue<Integer> min = new PriorityQueue<Integer>(); // ��С��
	PriorityQueue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>() {// ����
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	});

	public void Insert(Integer num) {
		// ���ݵ�����Ŀ��ż��ʱ���������ݲ��뵽��С����
		if (((min.size() + max.size()) & 1) == 0) {
			if (max.size() > 0 && num < max.peek()) {
				max.offer(num);
				num = max.poll();
			}
			min.offer(num);
		} else {
			if (min.size() > 0 && num > min.peek()) {
				min.offer(num);
				num = min.poll();
			}
			max.offer(num);
		}
	}

	public Double GetMedian() {
		int size = min.size() + max.size();
		if ((size & 1) == 0) {
			return ((double) (min.peek() + max.peek()) / 2);
		} else {
			return (double) min.peek();
		}
	}

	public static void main(String[] args) {
		Test64 test64 = new Test64();
		test64.Insert(5);
		test64.Insert(8);
		test64.Insert(1);
		test64.Insert(4);
		test64.Insert(3);
		System.out.println(test64.GetMedian());
		test64.Insert(7);
		System.out.println(test64.GetMedian());
	}
}
