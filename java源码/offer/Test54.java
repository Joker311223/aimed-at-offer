package offer;

/**
 * ��ָoffer-��54����ʾ��ֵ���ַ���
 * 
 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С���������磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��
 * ֵ�� ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 */

public class Test54 {
	public boolean isNumeric(char[] str) {
		int strLenght = str.length;
		if (str == null || strLenght == 0) {
			return false;
		}
		int index = 0;
		if (str[index] == '+' || str[index] == '-') {
			index++;
		}
		if (index == strLenght) {
			return false;
		}
		// ����0~9����
		while (index < strLenght && str[index] >= '0' && str[index] <= '9') {
			index++;
		}
		if (index != strLenght) {
			if (str[index] == '.') {// ����С����ʱ
				index++;
				while (index < strLenght && str[index] >= '0' && str[index] <= '9') {
					index++;
				}
				if (index < strLenght && (str[index] == 'e' || str[index] == 'E')) {
					return isExponential(str, strLenght, index);
				}
			} else if (str[index] == 'e' || str[index] == 'E') {
				return isExponential(str, strLenght, index);
			} else {
				return false;
			}
		}
		return index == strLenght;
	}

	// �ж��Ƿ��ǿ�ѧ������
	public boolean isExponential(char[] str, int strLenght, int index) {
		index++;
		if (index < strLenght && (str[index] == '+' || str[index] == '-')) {
			index++;
		}
		if (index == strLenght) {
			return false;
		}
		while (index < strLenght && str[index] >= '0' && str[index] <= '9') {
			index++;
		}
		return index == strLenght ? true : false;
	}

	public static void main(String[] args) {
		Test54 test54 = new Test54();
		char[] numChar1 = "-25E-2".toCharArray();
		char[] numChar2 = "-2.2E+2".toCharArray();
		char[] numChar3 = "12e".toCharArray();
		char[] numChar4 = "12e+5.4".toCharArray();
		System.out.println(test54.isNumeric(numChar1));
		System.out.println(test54.isNumeric(numChar2));
		System.out.println(test54.isNumeric(numChar3));
		System.out.println(test54.isNumeric(numChar4));
	}
}
