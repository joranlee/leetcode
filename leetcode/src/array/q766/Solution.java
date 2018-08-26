package array.q766;

/**
 * @author TXX 2018-08-26 A matrix is Toeplitz if every diagonal from top-left
 *         to bottom-right has the same element.
 * 
 *         Now given an M x N matrix, return True if and only if the matrix is
 *         Toeplitz.
 * 
 * 
 *         Example 1:
 * 
 *         Input: matrix = [ [1,2,3,4], 
 *         					 [5,1,2,3], 
 *         					 [9,5,1,2] 
 *         				   ] 
 *         Output: True
 *         Explanation: In the above grid, the diagonals are: "[9]", "[5, 5]",
 *         "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]". In each diagonal all
 *         elements are the same, so the answer is True. 
 *         
 *         
 *         Example 2:
 * 
 *         Input: matrix = [ [1,2], 
 *         					 [2,2] 
 *         				   ] 
 *         Output: False 
 *         Explanation: The diagonal "[1, 2]" has different elements.
 * 
 *         检查矩阵从左上到右下的对角线上的元素是不是一样，如果全一样，返回true。否则返回false。
 *         思路1：将对角线上的元素和对角线上第一个元素作对比，如果不一样，终止对比，返回false。
 *         思路2：从matrix[1][1]开始遍历矩阵，将每个元素matrix[i][j]与matrix[i-1][j-1]
 *         即对角线上一个元素作对比，只要和上一个元素不一样，则终止对比，返回false。
 */
public class Solution {
	public boolean isToeplitzMatrix(int[][] matrix) {
		boolean result = true;
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		int min = Math.min(rowNum, colNum);
		int max = Math.max(rowNum, colNum);

		if (matrix.length == 1) {
			return result;
		}

		while (result) {
			for (int i = 0; i < max - 1; i++) {
				for (int j = 0; i + j < min; j++) {
					if (matrix[i + j][j] != matrix[i][0]) {
						result = false;
					}

					if (matrix[j][i + j] != matrix[0][i]) {
						result = false;
					}
				}
			}
			break;
		}

		return result;
	}

	public boolean isToeplitzMatrix2(int[][] matrix) {
		boolean result = true;
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		while (result) {
			for (int i = 1; i < rowNum; i++) {
				for (int j = 1; j < colNum; j++) {
					if (matrix[i][j] != matrix[i - 1][j - 1]) {
						result = false;
					}
				}
			}
			break;
		}
		return result;
	}
	
	public boolean isToeplitzMatrix3(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } };
		Solution s = new Solution();

		boolean result = s.isToeplitzMatrix(matrix);
		System.out.println(result);

		boolean result2 = s.isToeplitzMatrix2(matrix);
		System.out.println(result2);

	}
}
