package offer;

import java.util.Stack;

/**
 * ��ָoffer-��7��������ջʵ�ֶ���
 * 
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 */

public class Test07 {
	Stack<Integer> stack1 = new Stack<Integer>();  // ����ջ
	Stack<Integer> stack2 = new Stack<Integer>();  // ����ջ

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if(!stack2.isEmpty()){
			return stack2.pop();
		}else{
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			return pop();
		}
	}
	
	public static void main(String[] args) {
		Test07 test07 = new Test07();
		test07.push(3);
		test07.push(2);
		test07.push(1);
		System.out.println(test07.pop());
		System.out.println(test07.pop());
		test07.push(4);
		System.out.println(test07.pop());
		System.out.println(test07.pop());
		test07.push(5);
		System.out.println(test07.pop());
	}
}
