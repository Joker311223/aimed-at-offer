package offer;

/**
 * ��ָoffer-��29�������г��ִ�������һ�������
 * 
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��������
 * ��2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 */

public class Test29 {
	public int MoreThanHalfNum_Solution(int[] array) {
		int arrayLen = array.length;
		if (array == null || arrayLen == 0) {
			return 0;
		} else {
			int times = 1;
			int totleTimes = 0; // ĳ�����ֳ��ֵ��ܴ���
			int num = array[0];
			for (int i = 1; i < arrayLen; i++) {
				if (times == 0) {
					num = array[i];
					times = 1;
				} else if (array[i] == num) {
					times++;
				} else {
					times--;
				}
			}
			for (int j = 0; j < arrayLen; j++) {
				if (array[j] == num) {
					totleTimes++;
				}
			}
			if (totleTimes > arrayLen / 2) {
				return num;
			} else {
				return 0;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		System.out.println(new Test29().MoreThanHalfNum_Solution(array));
	}
}
