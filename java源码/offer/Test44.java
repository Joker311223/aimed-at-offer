package offer;

import java.util.Arrays;

/**
 * ��ָoffer-��44���˿��Ƶ�˳��
 * 
 * ���˿����������5���ƣ��ж��ǲ���һ��˳�ӣ�����5�����ǲ��������ġ�2~10Ϊ���ֱ���AΪ1��JΪ11�� QΪ12��KΪ13������С�����Կ����������֡�
 */

public class Test44 {
	public boolean isContinuous(int[] numbers) {
		if (numbers.length < 1) {
			return false;
		} else {
			Arrays.sort(numbers);
			int numberOfZeros = 0; // ������0�ĸ���
			int gapNum = 0; // ����������еĲ�ֵ
			for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
				numberOfZeros++;
			}
			int smallIndex = numberOfZeros; // �������������С��0ֵ������
			int bigIndex = numberOfZeros + 1;
			while (bigIndex < numbers.length) {
				if(numbers[bigIndex] == numbers[smallIndex]){
					return false;
				}
				gapNum += numbers[bigIndex] - numbers[smallIndex] - 1;
				smallIndex = bigIndex;
				bigIndex++;
			}
			return gapNum > numberOfZeros ? false : true;
		}
	}

	public static void main(String[] args) {
		int[] numbers = { 5, 4, 2, 0, 0 };
		System.out.println(new Test44().isContinuous(numbers));
	}
}
