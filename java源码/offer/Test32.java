package offer;

/**
 * ��ָoffer-��32����1��n������1���ֵĴ���
 * 
 * ����һ������n�����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�������������12����1��12��Щ�����а���1��������1,10,11��12,1һ��������5�Ρ�
 */

public class Test32 {
	public int NumberOf1Between1AndN_Solution(int n) {
		if (n < 1) {
			return 0;
		} else {
			int count = 0;
			int base = 1;
			int round = n;
			int weight;
			while (round > 0) {
				weight = round % 10;
				round /= 10;
				count += round * base;
				if (weight > 1) {
					count += base;
				} else if (weight == 1) {
					count += (n % base) + 1;

				}
				base *= 10;
			}
			return count;
		}
	}

	public static void main(String[] args) {
		int n = 534;
		System.out.println(new Test32().NumberOf1Between1AndN_Solution(n));
	}
}
