package offer;

import java.util.Stack;

/**
 * ��ָoffer-��22��ջ��ѹ�롢��������
 * 
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ�������
 * ��1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ�����
 * �С���ע�⣺���������еĳ�������ȵģ�
 */

public class Test22 {
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		boolean possible = false;
		if (pushA.length > 0 && popA.length > 0) {
			int pushIndex = 0;
			int popIndex = 0;
			Stack<Integer> dataStack = new Stack<Integer>();
			while (popIndex < popA.length) {
				while (dataStack.isEmpty() || dataStack.peek() != popA[popIndex]) {
					// ��ѹջ����ѹ��һ��ջ��ֱ���� 1.ջ��Ԫ�غ͵������е�����λ����ͬ
					// 2.ѹջ���б�������Ҳû���ҵ��͵������е�����λ����ͬ��ֵ
					if (pushIndex == pushA.length) {
						break;
					}
					dataStack.push(new Integer(pushA[pushIndex]));
					pushIndex++;
				}
				if (dataStack.peek() != popA[popIndex]) {
					break;
				}
				dataStack.pop();
				popIndex++;
			}
			if (dataStack.isEmpty() && popIndex == popA.length) {
				possible = true;
			}
		}
		return possible;
	}

	public static void main(String[] args) {
		int[] push = { 1, 2, 3, 4, 5 };
		int[] pop1 = { 4, 5, 3, 2, 1 };
		int[] pop2 = { 4, 3, 5, 1, 2 };
		Test22 test22 = new Test22();
		System.out.println(test22.IsPopOrder(push, pop1));
		System.out.println(test22.IsPopOrder(push, pop2));
	}
}
