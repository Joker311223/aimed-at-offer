package offer;

/**
 * ��ָoffer-��9��쳲���������
 * 
 * ��Ŀһ����Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�n<=39
 * 
 * ��Ŀ����һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 */

public class Test09 {

	public int Fibonacci(int n) {
		int fibonacci1 = 0;
		int fibonacci2 = 1;
		int fibonacci = 0;
		if (n == 0) {
			return fibonacci1;
		} else if (n == 1) {
			return fibonacci2;
		} else {
			for (int i = 2; i <= n; i++) {
				fibonacci = fibonacci1 + fibonacci2;
				fibonacci1 = fibonacci2;
				fibonacci2 = fibonacci;
			}
			return fibonacci;
		}
	}

	public int Fibonacci2(int n) { // �ݹ飬Ч�ʵ�
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return Fibonacci2(n - 1) + Fibonacci2(n - 2);
		}
	}

	
// -----------------------------���----------------------------
	public int JumpFloor(int target) {
		int sum1 = 1;
		int sum2 = 2;
		int sum = 0;
		if (target == 1) {
			return sum1;
		} else if (target == 2) {
			return sum2;
		} else {
			for (int i = 2; i < target; i++) {
				sum = sum1 + sum2;
				sum1 = sum2;
				sum2 = sum;
			}
			return sum;
		}
	}
	
	
	
	public static void main(String[] args) {
		Test09 test09 = new Test09();
//		System.out.println(test09.Fibonacci(0));
//		System.out.println(test09.Fibonacci(10));
//		System.out.println(test09.Fibonacci2(0));
//		System.out.println(test09.Fibonacci2(10));
		
		System.out.println(test09.JumpFloor(0));
		System.out.println(test09.JumpFloor(5));
	}

}
