package array.q59;

/**
 * @author TXX 2018-08-23 Given a positive integer n, generate a square matrix
 *         filled with elements from 1 to n2 in spiral order.
 * 
 *         Example:
 * 
 *         Input: 3 Output: 
 *         [ [ 1, 2, 3 ], 
 *           [ 8, 9, 4 ], 
 *           [ 7, 6, 5 ] 
 *         ]
 *         生成按照顺时针螺旋排列的正方形矩阵。
 *         思路：用四个值up,down,left,right来控制边界，当num小于n^2时，从[0][0]开始向左推进，到
 *         right后改向下，同时将up加1;向下到down后改向左，同时将right减1；向左到left后改向上，同时
 *         将down减1；向上到left后改向右，同时将left加1，依次循环。
 */
public class Solution {
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int num = 1;
		int end = n * n;
		int up = 0;
		int down = n - 1;
		int left = 0;
		int right = n - 1;
		while (num <= end) {
			// 从左往右
			for (int y = left; y <= right; y++) {
				result[up][y] = num++;
			}
			up++;

			// 从上往下
			for (int x = up; x <= down; x++) {
				result[x][right] = num++;
			}
			right--;

			// 从右往左
			for (int y = right; y >= left; y--) {
				result[down][y] = num++;
			}
			down--;

			// 从下往上
			for (int x = down; x >= up; x--) {
				result[x][left] = num++;
			}
			left++;

		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] result = s.generateMatrix(5);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
