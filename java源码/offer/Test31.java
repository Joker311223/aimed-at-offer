package offer;

/**
 * ��ָoffer-��31�����������������
 * 
 * ����һ���������飬������������Ҳ�и�����������һ���������Ķ���������һ�������顣������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�ΪO(n)��
 */

public class Test31 {
	public int FindGreatestSumOfSubArray(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		} else {
			int curSum = 0;
			int maxSum = 0x80000000;
			for (int i = 0; i < array.length; i++) {
				if (curSum <= 0) {
					curSum = array[i];
				} else {
					curSum += array[i];
				}
				if (curSum > maxSum) {
					maxSum = curSum;
				}
			}
			return maxSum;
		}
	}

	public static void main(String[] args) {
		Test31 test31 = new Test31();
		int[] Aarray = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(test31.FindGreatestSumOfSubArray(Aarray));
	}
}
