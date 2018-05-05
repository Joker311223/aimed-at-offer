package offer;

/**
 * ��ָoffer-��56�������л�����ڽ��
 * 
 * һ�������а����������ҳ�������Ļ�����ڽ�㡣
 */

public class Test56 {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		ListNode meeeingNode = meetingNodes(pHead);
		if (meeeingNode == null) {
			return null;
		}
		int nodeNumOfLoop = 1;
		ListNode node1 = meeeingNode.next;
		while (node1 != meeeingNode) {
			node1 = node1.next;
			nodeNumOfLoop++;
		}
		node1 = pHead;
		for (int i = 0; i < nodeNumOfLoop; i++) {
			node1 = node1.next;
		}
		ListNode node2 = pHead;
		while (node1 != node2) {
			node1 = node1.next;
			node2 = node2.next;
		}
		return node1;
	}

	// һ��һ������ָ�������ͷ��ʼ������������ָ�������Ľ�㼴�ǻ��ڵ�һ�����
	public ListNode meetingNodes(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		ListNode slow = pHead.next;
		if (slow == null) {
			return null;
		}
		ListNode fast = slow.next;
		while (slow != null && fast != null) {
			if (slow == fast) {
				return fast;
			}
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
		}
		return null;
	}

	public static void main(String[] args) {
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
		f.next = c;
		System.out.println(new Test56().EntryNodeOfLoop(a).val);
	}
}
