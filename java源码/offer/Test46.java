package offer;

/**
 * ��ָoffer-��46����ָoffer-��46����1+2+...+n
 * 
 * ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 */

public class Test46 {
	public int Sum_Solution(int n) {
        int sum = n;
		boolean flag = n > 0 && (sum += Sum_Solution(n - 1)) > 0;
		return sum;
    }
	
	public static void main(String[] args) {
		int n = 100;
		System.out.println(new Test46().Sum_Solution(n));
	}
}
