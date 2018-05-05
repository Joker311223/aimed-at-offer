package offer;

/**
 * ��ָoffer-��10����������1�ĸ���
 * 
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ�������9��ʾ�ɶ�������1001�� ��2λ��1������������9���ĺ������2��
 */

public class Test10 {
	public int NumberOf1_1(int n) { // ������Ч�ʱ�λ�Ƶ͵Ķ࣬���ܼ��㸺��
		int num = 0;
		while (n != 0) {
			int yu = n % 2;
			if (yu == 1) {
				num++;
			}
			n = n / 2;
		}
		return num;
	}

	// ����ʱ��������������,����ʱ��������ѭ����
	// �������ε�-9���䲹��Ϊ��11111111 11111111 11111111 11110111����һֱ���ƣ����������һֱ���1
	public int NumberOf1_2(int n) {
		int num = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				num++;
			}
			n = n >> 1;
		}
		return num;
	}

	// Ϊ�˱�����ѭ�������Բ��������������n�����Ȱ�n��1�����롱���㣬�ж�n�����λ�ǲ���
	// Ϊ1�����Ű�1����һλ�õ�2���ں�n�����롱���㣬�����ж�n�Ĵε�λ�ǲ���1���������������ƣ�ÿ�ζ���
	// �ж�n������һλ�ǲ���1��
	public int NumberOf1_3(int n) {
		int num = 0;
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) != 0) {
				num++;
			}
			flag = flag << 1;
		}
		return num;
	}

	public int NumberOf1(int n) {
		int num = 0;
		while (n != 0) {
			n = (n - 1) & n;
			num++;
		}
		return num;
	}

	public static void main(String[] args) {
		Test10 test10 = new Test10();
		System.out.println(test10.NumberOf1_1(9));
		System.out.println(test10.NumberOf1_2(9));
		System.out.println(test10.NumberOf1_3(-9));
		System.out.println(test10.NumberOf1(-9));
	}

}
