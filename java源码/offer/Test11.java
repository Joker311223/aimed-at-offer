package offer;

/**
 * ��ָoffer-��11����ֵ�������η�
 * 
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 */

public class Test11 {
	public double Power(double base, int exponent) {
		int absExponent;
		// �ж�base�ǲ���0ʱ�������á�base==0���жϣ���Ϊ������ڱ�ʾС��ʱ������ֻ������������ľ���ֵ�Ƿ���һ����С�ķ�Χ���ж�
		// ������0��ָ��Ϊ�����򷵻�0�������׳��쳣���ø�ȫ�ֱ�����ʶһ��
		if (base - 0 < 0.000001 && base - 0 > -0.0000001 && exponent < 0) {
			return 0;
		}
		if (exponent < 0) {
			absExponent = -exponent;
			return 1 / powWithUnsignExponent_2(base, absExponent);
		} else {
			absExponent = exponent;
			return powWithUnsignExponent_2(base, absExponent);
		}
	}

	public double powWithUnsignExponent_1(double base, int exponent) {
		double resule = 1;
		for (int i = 0; i < exponent; i++) {
			resule *= base;
		}
		return resule;
	}
	
	// �ݹ�ķ�ʽ
	public double powWithUnsignExponent_2(double base, int exponent) {
		if (exponent == 1) {
			return base;
		} else if (exponent == 0) {
			return 1;
		}
		double result = powWithUnsignExponent_2(base, exponent >> 1);
		result *= result;
		if ((exponent & 0x1) == 1) {// �ж�exponent�Ƿ���ż��
			result *= base;
		}
		return result;
	}

	public static void main(String[] args) {
		Test11 test11 = new Test11();
		System.out.println(test11.Power(2.5, -3));
	}

}
