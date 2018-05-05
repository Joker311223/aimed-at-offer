package offer;

/**
 * ��ָoffer-��6���ؽ�������
 * 
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 */

public class Test06 {

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode root = new TreeNode(pre[0]);
		root.left = null;
		root.right = null;
		int rootIndex = 0; // ���ڵ������������λ��
		while (rootIndex < in.length && root.val != in[rootIndex]) {
			rootIndex++;
		}
		int rightLength = in.length - rootIndex - 1; // ���ڵ��������ڵ����

		if (rootIndex > 0) { // ����������
			int[] inTemp = new int[rootIndex];
			int[] preTemp = new int[rootIndex];
			for (int i = 0; i < rootIndex; i++) {
				inTemp[i] = in[i];
			}
			for (int j = 1; j <= rootIndex; j++) {
				preTemp[j - 1] = pre[j];
			}
			root.left = reConstructBinaryTree(preTemp, inTemp);
		}

		if (rightLength > 0) { // ����������
			int[] inTemp = new int[rightLength];
			int[] preTemp = new int[rightLength];
			for (int i = 0; i < rightLength; i++) {
				inTemp[i] = in[rootIndex + 1 + i];
			}
			for (int j = 1; j <= rightLength; j++) {
				preTemp[j - 1] = pre[rootIndex + j];
			}
			root.right = reConstructBinaryTree(preTemp, inTemp);
		}
		return root;
	}

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode rootNode = new Test06().reConstructBinaryTree(pre, in);
		System.out.println("���ڵ㣺" + rootNode.val);

		TreeInfo treeInfo = new TreeInfo();
		System.out.print("���������");
		treeInfo.houxuDigui(rootNode); // �������
		for (Integer integer : treeInfo.houxuNumList) {
			System.out.print(integer + ",");
		}
	}

}
