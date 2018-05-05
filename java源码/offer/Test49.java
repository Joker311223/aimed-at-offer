package offer;

/**
 * ��ָoffer-��49�����ַ���ת��������
 * 
 * ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
 */

public class Test49 {
	public int StrToInt(String str) {
		if (str == null || str.trim().length() == 0) {
			return 0;
		} else {
			char[] charArray = str.toCharArray();
			int num = 0;
			boolean minus = false;
			int i = 0;
			if (charArray[0] == '-') {
				minus = true;
				i = 1;
			} else if (charArray[0] == '+') {
				i = 1;
			}
			for (; i < charArray.length; i++) {
				if(charArray[i] < '0' || charArray[i] > '9'){
					return 0;
				}else {
					num = num * 10 + charArray[i] - '0';
				}
			}
			if(minus){
				return 0 - num;
			}else {
				return num;
			}
		}
	}

	public static void main(String[] args) {
		String str = "-511";
		System.out.println(new Test49().StrToInt(str));
	}
}
