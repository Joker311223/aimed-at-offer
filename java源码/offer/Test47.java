package offer;

/**
 * ��ָoffer-��47�����üӼ��˳����ӷ�
 * 
 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 */

public class Test47 {
	public int Add(int num1, int num2) {
		int jin;
		int sum;
		do {
			sum = num1 ^ num2;
			jin = (num1 & num2) << 1;
			num1 = sum;
			num2 = jin;
		} while (jin != 0);
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new Test47().Add(3, 9));
	}
}
