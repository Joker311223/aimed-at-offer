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

	public static void main(String[] args) {
		TreeInfo treeInfo = new TreeInfo();
		TreeNode root = treeInfo.treeSet();

		treeInfo.qinaxuDigui(root); // ǰ�����
		System.out.print("ǰ�������");
		for (Integer integer : treeInfo.qianxuNumList) {
			System.out.print(integer + ",");
		}

		new Test19().Mirror(root);// ������
		System.out.println();
		
		TreeInfo newTree = new TreeInfo();
		newTree.qinaxuDigui(root); // ǰ�����
		System.out.print("ǰ�������");
		for (Integer integer : newTree.qianxuNumList) {
			System.out.print(integer + ",");
		}

	}

}
