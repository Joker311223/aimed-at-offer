package offer;

/**
 * ��ָoffer-��19���������ľ���
 * 
 * ���������Ķ�����������任ΪԴ�������ľ���
 */

public class Test19 {
	public void Mirror(TreeNode root) {
		if (root == null) {
			return;
		} else if (root.left == null && root.right == null) {
			return;
		} else {
			TreeNode tempNode = null;
			tempNode = root.left;
			root.left = root.right;
			root.right = tempNode;

			if (root.left != null) {
				Mirror(root.left);
			}
			if (root.right != null) {
				Mirror(root.right);
			}
		}
	}

}
