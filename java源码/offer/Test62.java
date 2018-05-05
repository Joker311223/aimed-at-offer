package offer;

/**
 * ��ָoffer-��62�����л�������
 * 
 * ��ʵ�������������ֱ��������л��ͷ����л�������
 */

public class Test62 {
	int index = -1;

	// ���л�
	String Serialize(TreeNode root) {
		String str = "";
		if (root == null) {
			str = str + '$' + ',';
			return str;
		} else {
			str = str + root.val + ',';
			str = str + Serialize(root.left);
			str = str + Serialize(root.right);
		}
		return str;
	}

	TreeNode Deserialize(String str) {
		TreeNode root = null;
		if (str != null) {
			String[] strArray = str.split(",");
			if (strArray[0] != "$") {
				root = Deserialize(strArray);
			} else {
				return null;
			}
		}
		return root;
	}

	TreeNode Deserialize(String[] strArray) {
		index++;
		TreeNode node = null;
		if (!strArray[index].equals("$")) {
			node = new TreeNode(Integer.parseInt(strArray[index]));
			node.left = Deserialize(strArray);
			node.right = Deserialize(strArray);
		}
		return node;
	}

	public static void main(String[] args) {
		Test62 test62 = new Test62();

		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);

		a.left = b;
		a.right = c;
		b.left = d;
		c.left = e;
		c.right = f;

		String str = test62.Serialize(a);
		System.out.println(str);

		TreeNode node = test62.Deserialize(str);
		TreeInfo treeInfo = new TreeInfo();
		treeInfo.qinaxuDigui(node);
		for (Integer num : treeInfo.qianxuNumList) {
			System.out.print(num + " ");
		}
	}
}
