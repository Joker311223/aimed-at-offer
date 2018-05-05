package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ָoffer-��41����Ϊs����������VS��Ϊs��������������
 * 
 * ��һ������һ����������������һ������S���������в������������ǵ����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
 * 
 * ���������һ������s����ӡ�����к�Ϊs�������������У����ٺ���2����������������15������1+2+3+4+5=4+5+6=7+8=15�����Խ����ӡ��3����
 * ������1~5��4~6,7~8
 */

public class Test41 {
	// ��һ
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> twoNum = new ArrayList<Integer>();
		if (array.length == 0) {
			return twoNum;
		} else {
			int smallIndex = 0;
			int bigIndex = array.length - 1;
			int smallNum = 0;
			int bigNum = 0;
			int multyplyResult = array[bigIndex] * array[bigIndex - 1];

			while (smallIndex < bigIndex) {
				if (array[smallIndex] + array[bigIndex] == sum
						&& array[smallIndex] * array[bigIndex] <= multyplyResult) {
					smallNum = array[smallIndex];
					bigNum = array[bigIndex];
					multyplyResult = smallNum * bigNum;
					bigIndex--;
				} else if (array[smallIndex] + array[bigIndex] > sum) {
					bigIndex--;
				} else {
					smallIndex++;
				}
			}
			if (smallNum + bigNum == sum) {
				twoNum.add(new Integer(smallNum));
				twoNum.add(new Integer(bigNum));
			}
			return twoNum;
		}
	}

	// ���
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (sum < 2) {
			return list;
		} else {
			int small = 1;
			int big = 2;
			int middle = (sum + 1) / 2;
			int curSum = small + big;
			while (small < middle) {
				if (curSum == sum) {
					list.add(getList(small, big));
				}
				while (curSum > sum && small < middle) {
					curSum -= small;
					small++;
					if (curSum == sum) {
						list.add(getList(small, big));
					}
				}
				big++;
				curSum += big;
			}
			return list;
		}
	}

	public ArrayList<Integer> getList(int small, int big) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = small; i <= big; i++) {
			arrayList.add(new Integer(i));
		}
		return arrayList;
	}

	public static void main(String[] args) {
		Test41 test41 = new Test41();
		int[] array = { 1, 2, 4, 7, 11, 16 };
		int sum = 15;
		System.out.println("��һ��");
		List<Integer> result = test41.FindNumbersWithSum(array, sum);
		for (Integer integer : result) {
			System.out.print(integer + "  ");
		}
		System.out.println();
		System.out.println("�ڶ���");
		ArrayList<ArrayList<Integer>> resultList = test41.FindContinuousSequence(15);
		for (ArrayList<Integer> list : resultList) {
			for (Integer num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

	}

}
