package offer;

/**
 * ��ָoffer-��5����β��ͷ��ӡ����
 * 
 * ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 */

import java.util.ArrayList;
import java.util.Stack;

public class Test05 {
	ArrayList<Integer> valueList = new ArrayList<Integer>();

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		/*
		 * if(listNode != null){ //���õݹ� printListFromTailToHead(listNode.next);
		 * valueList.add(listNode.val); }
		 */
		Stack<Integer> valueStack = new Stack<Integer>(); // ����ջ
		ListNode node = listNode;
		while (node != null) {
			valueStack.push(node.val);
			node = node.next;
		}
		while (valueStack.size() > 0) {
			valueList.add(valueStack.peek());
			valueStack.pop();
		}

		return valueList;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(5);
		ListNode b = new ListNode(8);
		ListNode c = new ListNode(61);
		ListNode d = new ListNode(95);
		a.next = b;
		b.next = c;
		c.next = d;

		ArrayList<Integer> valueList = new Test05().printListFromTailToHead(a);
		for (Integer integer : valueList) {
			System.out.print(integer + ", ");
		}
	}

}
