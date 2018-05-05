package offer;

/**
 * ��ָoffer-��8����ת�������С����
 * 
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���ǵݼ�����������һ ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת������ �����СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 */

public class Test08 {

	public int minNumberInRotateArray(int[] array) {
		int index1 = 0;
		int index2 = array.length - 1;
		// ��ֵΪindex1��ԭ�򣺵�������ǰ0��Ԫ�ؽ�����תʱ������ĵ�һ��Ԫ�ؾ�����СԪ�أ����Բ���ѭ����ֱ�ӷ���
		int indexMin = index1; 
		while (array[index1] >= array[index2]) {
			if (index2 - index1 == 1) {
				indexMin = index2;
				break;
			}
			indexMin = (index1 + index2) / 2;
			if (array[index1] == array[index2] && array[index1] == array[indexMin]) {
				for (int i = index1; i <= index2; i++) {
					if (array[i] <= array[indexMin]) {
						indexMin = i;
					}
				}
				return array[indexMin];
			}else if (array[index1] <= array[indexMin]) {
				index1 = indexMin;
			}else if (array[indexMin] <= array[index2]) {
				index2 = indexMin;
			}
		}
		return array[indexMin];
	}
	
	
	public static void main(String[] args) {
		int[] a = { 3, 4, 5, 6, 7, 8, 1, 2, 3 };
		int[] b = { 9, 10, 11, 12, 13 };
		int[] c = { 1, 0, 1, 1, 1 };
		int[] d = {0};
		Test08 test08 = new Test08();
		System.out.println(test08.minNumberInRotateArray(a));
		System.out.println(test08.minNumberInRotateArray(b));
		System.out.println(test08.minNumberInRotateArray(c));
		System.out.println(test08.minNumberInRotateArray(d));
	}

}
