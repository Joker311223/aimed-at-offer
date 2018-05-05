package offer;

/**
 * ��ָoffer-��26����������ĸ���
 * 
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ��
 * �ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 */

public class Test26 {
	public RandomListNode Clone(RandomListNode pHead) {
		cloneNodes(pHead);
		connectRandomNodes(pHead);
		return divideList(pHead);
	}

	// 1.���Ƹ�����������nextָ�븳ֵ
	public void cloneNodes(RandomListNode pHead) {
		RandomListNode node = pHead;
		while (node != null) {
			RandomListNode cloneNode = new RandomListNode(node.label);
			cloneNode.next = node.next;
			cloneNode.random = null;
			node.next = cloneNode;
			node = cloneNode.next;
		}
	}

	// 2.�����Ƶ������randomָ����ֵ
	public void connectRandomNodes(RandomListNode pHead) {
		RandomListNode node = pHead;
		while (node != null) {
			RandomListNode cloneNode = node.next;
			if (node.random != null) {
				cloneNode.random = node.random.next;
			}
			node = cloneNode.next;
		}
	}

	// 3.��ԭʼ�ĸ�������͸��Ƶ�����ֿ�
	public RandomListNode divideList(RandomListNode pHead) {
		RandomListNode node = pHead;
		RandomListNode cloneListHead = null;
		RandomListNode cloneNode = null;
		if (node != null) {
			cloneListHead = node.next;
			cloneNode = node.next;
			node.next = cloneNode.next;
			node = node.next;
		}
		while (node != null) {
			cloneNode.next = node.next;
			cloneNode = cloneNode.next;
			node.next = cloneNode.next;
			node = node.next;
		}
		return cloneListHead;
	}

	public static void main(String[] args) {
		RandomListNode a = new RandomListNode(1);
		RandomListNode b = new RandomListNode(2);
		RandomListNode c = new RandomListNode(3);
		RandomListNode d = new RandomListNode(4);
		RandomListNode e = new RandomListNode(5);
		RandomListNode f = new RandomListNode(6);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		a.random = c;
		b.random = d;
		c.random = e;
		d.random = a;

		Test26 test26 = new Test26();
		RandomListNode cloneNode = test26.Clone(a);
		while (cloneNode != null) {
			System.out.print(cloneNode.label + "--" );
			if(cloneNode.random != null){
				System.out.print(cloneNode.random.label);
			}
			System.out.println();
			cloneNode = cloneNode.next;
		}
	}
}
