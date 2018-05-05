package offer;


import java.util.HashMap;
import java.util.Map.Entry;

/**
 * ��ָoffer-��43��n�����ӵĵ���
 * 
 * ��n���������ڵ��ϣ��������ӳ���һ��ĵ���֮��Ϊs������n����ӡ��s�����п��ܵ�ֵ���ֵĸ��ʡ�
 */

public class Test43 {
	int maxValue = 6;

	public HashMap<Integer, Integer> appearCount(int n) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (n > 1) {
			int[][] array = new int[2][maxValue * n + 1];
			int flag = 0;
			// ����ֻ��һ������ʱ�����,1~6ÿ����ֻ�����һ��
			for (int i = 1; i <= maxValue; i++) {
				array[flag][i] = 1;
			}
			for (int k = 2; k <= n; k++) {
				for (int i = 0; i < k; i++) {
					array[1 - flag][i] = 0;
				}
				for (int i = k; i <= k * maxValue; i++) {
					array[1 - flag][i] = 0;
					for (int j = 1; j <= i && j <= maxValue; j++) {
						array[1 - flag][i] += array[flag][i - j];
					}
				}
				flag = 1 - flag;
			}
			for (int i = n; i <= n * maxValue; i++) {
				map.put(i, array[flag][i]);
			}
		}
		return map;
	}

	public static void main(String[] args) {
		HashMap<Integer, Integer> resultMap = new Test43().appearCount(3);
		for (Entry<Integer, Integer> entry : resultMap.entrySet()) {
			System.out.println("���Ӻͣ�" + entry.getKey() + ",���ִ�����" + entry.getValue());
		}
	}
}
