package offer;

/**
 * ��ָoffer-��16����ת����
 * 
 * ����һ�������ͷ��㣬��ת�����������ת�������ͷ��㡣
 */

public class Test16 {
	public ListNode ReverseList(ListNode head) {
		ListNode pNode = head;
		ListNode pPrev = null;
		ListNode pNest = null;
		ListNode pReversedHead = null;
		while (pNode != null) {
			pNest = pNode.next;
			if (pNest == null) {
				pReversedHead = pNode;
			}
			pNode.next = pPrev;
			pPrev = pNode;
			pNode = pNest;
		}
		return pReversedHead;
	}

	public static void main(String[] args) {
		Test16 test16 = new Test16();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		ListNode node = test16.ReverseList(a);
		while (node != null) {
			System.out.print(node.val + ", ");
			node = node.next;
		}
	}

}
