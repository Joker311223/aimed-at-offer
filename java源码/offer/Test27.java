package offer;

/**
 * ��ָoffer-��27��������������˫������
 * 
 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 */

public class Test27 {
	TreeNode lastNode = null;
	
	public TreeNode Convert(TreeNode pRootOfTree) {
		convertNode(pRootOfTree);
		TreeNode headNode = lastNode;
		while (headNode != null && headNode.left != null) {
			headNode = headNode.left;
		}
		return headNode;
	}

	public void convertNode(TreeNode node) {
		if (node == null) {
			return;
		}
		TreeNode curNode = node;
		if (curNode.left != null) {
			convertNode(curNode.left);
		}

		if (lastNode != null) {
			lastNode.right = curNode;
			curNode.left = lastNode;
		}
		lastNode = curNode;
		if (curNode.right != null) {
			convertNode(curNode.right);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode a = new TreeNode(6);
		TreeNode b = new TreeNode(14);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(8);
		TreeNode e = new TreeNode(12);
		TreeNode f = new TreeNode(16);
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.left = e;
		b.right = f;

		TreeNode node = new Test27().Convert(root);
		while (node != null) {
			System.out.print(node.val + ", ");
			node = node.right;
		}

	}
}
