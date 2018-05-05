package offer;

/**
 * ��ָoffer-��34������
 * 
 * ��ֻ��������2��3��5��������������Ugly Number��������6��8���ǳ�������14���ǣ���Ϊ����������7��
 * ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 */

public class Test34 {
	public int GetUglyNumber_Solution(int index) {
		if (index <= 0) {
			return 0;
		} else {
			int[] uglyNumarray = new int[index];
			uglyNumarray[0] = 1;
			int uglyNumIndex = 1;
			int multiply2Index = 0;
			int multiply3Index = 0;
			int multiply5Index = 0;

			while (uglyNumIndex < index) {
				int min = min(uglyNumarray[multiply2Index] * 2, uglyNumarray[multiply3Index] * 3, uglyNumarray[multiply5Index] * 5);
				uglyNumarray[uglyNumIndex] = min;

				while (uglyNumarray[multiply2Index] * 2 <= uglyNumarray[uglyNumIndex]) {
					multiply2Index++;
				}
				while (uglyNumarray[multiply3Index] * 3 <= uglyNumarray[uglyNumIndex]) {
					multiply3Index++;
				}
				while (uglyNumarray[multiply5Index] * 5 <= uglyNumarray[uglyNumIndex]) {
					multiply5Index++;
				}
				uglyNumIndex++;
			}
			return uglyNumarray[uglyNumIndex - 1];
		}
	}

	public int min(int a, int b, int c) {
		int min = a < b ? a : b;
		min = min < c ? min : c;
		return min;
	}

	public static void main(String[] args) {
		System.out.println(new Test34().GetUglyNumber_Solution(1500));
	}

}
