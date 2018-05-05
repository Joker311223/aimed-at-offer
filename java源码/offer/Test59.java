package offer;

/**
 * ��ָoffer-��59���ԳƵĶ�����
 * 
 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ����һ�������������ľ�����һ���ģ���ô���ǶԳƵġ�
 */

public class Test59 {
	boolean isSymmetrical(TreeNode pRoot) {
		return isSymmetrical(pRoot, pRoot);
	}

	boolean isSymmetrical(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null || node2 == null) {
			return false;
		}
		if (node1.val != node2.val) {
			return false;
		}
		return isSymmetrical(node1.right, node2.left) && isSymmetrical(node1.left, node2.right);
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(8);
		TreeNode b1 = new TreeNode(6);
		TreeNode b2 = new TreeNode(6);
		TreeNode c1 = new TreeNode(5);
		TreeNode d1 = new TreeNode(7);
		TreeNode c2 = new TreeNode(7);
		TreeNode d2 = new TreeNode(5);

		a.left = b1;
		a.right = b2;
		b1.left = c1;
		b1.right = d1;
		b2.left = c2;
		b2.right = d2;

		System.out.println(new Test59().isSymmetrical(a));
	}
}
