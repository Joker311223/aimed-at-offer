package offer;

/**
 * ��ָoffer-��63�������������ĵ�k�����
 * 
 * ����һ�Ŷ��������������ҳ����еĵ�k��Ľ�㡣���磬 5 / \ 3 7 /\ /\ 2 4 6 8 �У��������ֵ��С˳�����������ֵΪ4��
 */

public class Test63 {
	int k = 0;

	TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k == 0) {
			return null;
		}
		this.k = k;
		return getKthNode(pRoot);
	}

	TreeNode getKthNode(TreeNode pRoot) {
		TreeNode target = null;
		if (pRoot.left != null) {
			target = getKthNode(pRoot.left);
		}
		if (target == null) {
			if (k == 1) {
				target = pRoot;
			} else {
				k--;
			}
		}
		if (target == null && pRoot.right != null) {
			target = getKthNode(pRoot.right);
		}
		return target;
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(7);
		TreeNode d = new TreeNode(2);
		TreeNode e = new TreeNode(4);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(8);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;

		TreeNode kthNode = new Test63().KthNode(a, 5);
		System.out.println(kthNode.val);
	}
}
