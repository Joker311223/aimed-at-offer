package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ��ָoffer-��33���������ų���С����
 * 
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 */

public class Test33 {
	public String PrintMinNumber(int[] numbers) {
		List<String> numStrList = new ArrayList<String>();
		String result = "";
		for (int i = 0; i < numbers.length; i++) {
			numStrList.add(numbers[i] + "");
		}
		numStrList.sort(new Comparator<String>() {
			public int compare(String s1, String s2) {
				return (s1 + s2).compareTo(s2 + s1);
			}
		});
		for (String string : numStrList) {
			result += string;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] numbers = { 3, 32, 321 };
		System.out.println(new Test33().PrintMinNumber(numbers));
	}
}
