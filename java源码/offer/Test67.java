package offer;

/**
 * ��ָoffer-��67�������˵��˶���Χ
 * 
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ�񣬵��ǲ��ܽ�������������������
 * λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18�����ǣ������ܽ��뷽��35,38������
 * Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
 */

public class Test67 {
	public int movingCount(int threshold, int rows, int cols) {
		boolean[] visited = new boolean[rows * cols];
		int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
		return count;
	}

	public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
		int count = 0;
		if (cheak(threshold, rows, cols, row, col, visited)) {
			visited[row * cols + col] = true;
			count = 1 + movingCountCore(threshold, rows, cols, row + 1, col, visited)
					+ movingCountCore(threshold, rows, cols, row - 1, col, visited)
					+ movingCountCore(threshold, rows, cols, row, col + 1, visited)
					+ movingCountCore(threshold, rows, cols, row, col - 1, visited);
		}
		return count;
	}

	public boolean cheak(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
		if (row >= 0 && col >= 0 && row < rows && col < cols && !visited[row * cols + col]
				&& getDigitSum(row) + getDigitSum(col) <= threshold) {
			return true;
		}
		return false;
	}

	// ÿλ����֮��
	public int getDigitSum(int num) {
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		Test67 test67 = new Test67();
		System.out.println(test67.movingCount(2, 10, 10));
	}
}
