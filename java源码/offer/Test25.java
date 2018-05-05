package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * ��ָoffer-��25���������к�Ϊĳһֵ��·��
 * 
 * ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 */

public class Test25 {
	int curSum = 0;
	Stack<Integer> pathStack = new Stack<>();
	ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		if (root == null) {
			return pathList;
		}
		curSum += root.val;
		pathStack.push(root.val);

		boolean isLeafNode = root.left == null && root.right == null;
		if (curSum == target && isLeafNode) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			for (Integer value : pathStack) {
				path.add(value);
			}
			pathList.add(path);
		}
		if (root.left != null) {
			FindPath(root.left, target);
		}
		if (root.right != null) {
			FindPath(root.right, target);
		}
		pathStack.pop();
		curSum -= root.val;
		return pathList;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(4);
		TreeNode c = new TreeNode(7);
		TreeNode d = new TreeNode(12);
		root.left = a;
		a.left = b;
		a.right = c;
		root.right = d;
		ArrayList<ArrayList<Integer>> pathList = new Test25().FindPath(root, 22);
		for (ArrayList<Integer> path : pathList) {
			for (Integer value : path) {
				System.out.print(value + ", ");
			}
			System.out.println();
		}
	}
}
