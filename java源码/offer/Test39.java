package offer;

/**
 * ��ָoffer-��39�������������
 * 
 * ��һ������һ�ö����������������ȡ��Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 * ���������һ�ö������ĸ���㣬�жϸö������Ƿ���ƽ������������ĳ����������������������� �����������1����ô������һ��ƽ���������
 */

public class Test39 {
	// ��һ��
	public int TreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftLength = TreeDepth(root.left);
		int rightLength = TreeDepth(root.right);
		return leftLength > rightLength ? leftLength + 1 : rightLength + 1;
	}

	// �ڶ���
	public boolean IsBalanced_Solution(TreeNode root) {
		if(root == null || getNodeDepth(root) != -2){
			return true;
		}else{
			return false;
		}
	}

	public int getNodeDepth(TreeNode root) {
		int left = 0;
		int right = 0;
		if (root.left != null) {
			left = getNodeDepth(root.left);
		}
		if (root.right != null) {
			right = getNodeDepth(root.right);
		}
		if (left - right < -1 || left - right > 1) {
			return -2;
		}
		return left > right ? left + 1 : right + 1;
	}

}
