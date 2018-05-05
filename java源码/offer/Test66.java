package offer;

/**
 * ��ָoffer-��66�������е�·��
 * 
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ�������
 * ��һ�����ӡ����һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ����磺���¾����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·������
 * Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ� 
 * a b c e 
 * s f c s 
 * a d e e
 * 
 */

public class Test66 {
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (matrix == null || str == null || matrix.length == 0 || str.length == 0 || rows < 1 || cols < 1) {
			return false;
		}
		boolean[] visited = new boolean[rows * cols];
		int strIndex = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (hasPathCore(matrix, str, visited, rows, cols, row, col, strIndex)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean hasPathCore(char[] matrix, char[] str, boolean[] visited, int rows, int cols, int row, int col,
			int strIndex) {
		if (strIndex == str.length) {
			return true;
		}
		boolean hasPath = false;
		if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[strIndex]
				&& visited[row * cols + col] == false) {
			strIndex++;
			visited[row * cols + col] = true;

			hasPath = hasPathCore(matrix, str, visited, rows, cols, row - 1, col, strIndex)
					|| hasPathCore(matrix, str, visited, rows, cols, row + 1, col, strIndex)
					|| hasPathCore(matrix, str, visited, rows, cols, row, col - 1, strIndex)
					|| hasPathCore(matrix, str, visited, rows, cols, row, col + 1, strIndex);

			if (!hasPath) {
				strIndex--;
				visited[row * cols + col] = false;
			}
		}
		return hasPath;
	}

	public static void main(String[] args) {
		Test66 test66 = new Test66();
		char[] matrix = { 'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e' };
		char[] str1 = { 'b', 'c', 'c', 'e', 'd' };
		char[] str2 = { 'a', 'b', 'c', 'b' };
		System.out.println(test66.hasPath(matrix, 3, 4, str1));
		System.out.println(test66.hasPath(matrix, 3, 4, str2));
	}
}
